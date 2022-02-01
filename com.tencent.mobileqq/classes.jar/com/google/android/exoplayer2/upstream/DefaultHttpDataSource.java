package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultHttpDataSource
  implements HttpDataSource
{
  private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
  public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
  private static final long MAX_BYTES_TO_DRAIN = 2048L;
  private static final int MAX_REDIRECTS = 20;
  private static final String TAG = "DefaultHttpDataSource";
  private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference();
  private final boolean allowCrossProtocolRedirects;
  private long bytesRead;
  private long bytesSkipped;
  private long bytesToRead;
  private long bytesToSkip;
  private final int connectTimeoutMillis;
  private HttpURLConnection connection;
  private final Predicate<String> contentTypePredicate;
  private DataSpec dataSpec;
  private final HttpDataSource.RequestProperties defaultRequestProperties;
  private InputStream inputStream;
  private final TransferListener<? super DefaultHttpDataSource> listener;
  private boolean opened;
  private final int readTimeoutMillis;
  private final HttpDataSource.RequestProperties requestProperties;
  private final String userAgent;
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate)
  {
    this(paramString, paramPredicate, null);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener<? super DefaultHttpDataSource> paramTransferListener)
  {
    this(paramString, paramPredicate, paramTransferListener, 8000, 8000);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener<? super DefaultHttpDataSource> paramTransferListener, int paramInt1, int paramInt2)
  {
    this(paramString, paramPredicate, paramTransferListener, paramInt1, paramInt2, false, null);
  }
  
  public DefaultHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener<? super DefaultHttpDataSource> paramTransferListener, int paramInt1, int paramInt2, boolean paramBoolean, HttpDataSource.RequestProperties paramRequestProperties)
  {
    this.userAgent = Assertions.checkNotEmpty(paramString);
    this.contentTypePredicate = paramPredicate;
    this.listener = paramTransferListener;
    this.requestProperties = new HttpDataSource.RequestProperties();
    this.connectTimeoutMillis = paramInt1;
    this.readTimeoutMillis = paramInt2;
    this.allowCrossProtocolRedirects = paramBoolean;
    this.defaultRequestProperties = paramRequestProperties;
  }
  
  private void closeConnectionQuietly()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection != null)
    {
      try
      {
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
      }
      this.connection = null;
    }
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject1 = paramHttpURLConnection.getHeaderField("Content-Length");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      l1 = Long.parseLong((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      long l1;
      label25:
      Object localObject2;
      break label25;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Unexpected Content-Length [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    Log.e("DefaultHttpDataSource", ((StringBuilder)localObject2).toString());
    l1 = -1L;
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      localObject2 = CONTENT_RANGE_HEADER.matcher(paramHttpURLConnection);
      if (!((Matcher)localObject2).find()) {}
    }
    try
    {
      long l2 = Long.parseLong(((Matcher)localObject2).group(2)) - Long.parseLong(((Matcher)localObject2).group(1)) + 1L;
      if (l1 < 0L) {
        return l2;
      }
      if (l1 == l2) {
        break label250;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Inconsistent headers [");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] [");
      ((StringBuilder)localObject2).append(paramHttpURLConnection);
      ((StringBuilder)localObject2).append("]");
      Log.w("DefaultHttpDataSource", ((StringBuilder)localObject2).toString());
      l2 = Math.max(l1, l2);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label207:
      break label207;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unexpected Content-Range [");
    ((StringBuilder)localObject1).append(paramHttpURLConnection);
    ((StringBuilder)localObject1).append("]");
    Log.e("DefaultHttpDataSource", ((StringBuilder)localObject1).toString());
    label250:
    return l1;
  }
  
  private static URL handleRedirect(URL paramURL, String paramString)
  {
    if (paramString != null)
    {
      paramString = new URL(paramURL, paramString);
      paramURL = paramString.getProtocol();
      if (!"https".equals(paramURL))
      {
        if ("http".equals(paramURL)) {
          return paramString;
        }
        paramString = new StringBuilder();
        paramString.append("Unsupported protocol redirect: ");
        paramString.append(paramURL);
        throw new ProtocolException(paramString.toString());
      }
      return paramString;
    }
    throw new ProtocolException("Null location redirect");
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    Object localObject = new URL(paramDataSpec.uri.toString());
    byte[] arrayOfByte = paramDataSpec.postBody;
    long l1 = paramDataSpec.position;
    long l2 = paramDataSpec.length;
    boolean bool = paramDataSpec.isFlagSet(1);
    if (!this.allowCrossProtocolRedirects) {
      return makeConnection((URL)localObject, arrayOfByte, l1, l2, bool, true);
    }
    int i = 0;
    paramDataSpec = (DataSpec)localObject;
    int j;
    for (;;)
    {
      j = i + 1;
      if (i > 20) {
        break;
      }
      localObject = makeConnection(paramDataSpec, arrayOfByte, l1, l2, bool, false);
      i = ((HttpURLConnection)localObject).getResponseCode();
      if ((i != 300) && (i != 301) && (i != 302) && (i != 303) && ((arrayOfByte != null) || ((i != 307) && (i != 308)))) {
        return localObject;
      }
      arrayOfByte = null;
      String str = ((HttpURLConnection)localObject).getHeaderField("Location");
      ((HttpURLConnection)localObject).disconnect();
      paramDataSpec = handleRedirect(paramDataSpec, str);
      i = j;
    }
    paramDataSpec = new StringBuilder();
    paramDataSpec.append("Too many redirects: ");
    paramDataSpec.append(j);
    paramDataSpec = new NoRouteToHostException(paramDataSpec.toString());
    for (;;)
    {
      throw paramDataSpec;
    }
  }
  
  private HttpURLConnection makeConnection(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
    localHttpURLConnection.setReadTimeout(this.readTimeoutMillis);
    paramURL = this.defaultRequestProperties;
    Object localObject;
    if (paramURL != null)
    {
      paramURL = paramURL.getSnapshot().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.requestProperties.getSnapshot().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      paramURL = new StringBuilder();
      paramURL.append("bytes=");
      paramURL.append(paramLong1);
      paramURL.append("-");
      localObject = paramURL.toString();
      paramURL = (URL)localObject;
      if (paramLong2 != -1L)
      {
        paramURL = new StringBuilder();
        paramURL.append((String)localObject);
        paramURL.append(paramLong1 + paramLong2 - 1L);
        paramURL = paramURL.toString();
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    localHttpURLConnection.setDoOutput(paramBoolean1);
    if (paramArrayOfByte != null)
    {
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length == 0)
      {
        localHttpURLConnection.connect();
        return localHttpURLConnection;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }
  
  private static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if ((Util.SDK_INT != 19) && (Util.SDK_INT != 20)) {
      return;
    }
    do
    {
      try
      {
        paramHttpURLConnection = paramHttpURLConnection.getInputStream();
        if (paramLong == -1L)
        {
          if (paramHttpURLConnection.read() == -1) {
            return;
          }
          Object localObject = paramHttpURLConnection.getClass().getName();
          if ((((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
          {
            localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
            ((Method)localObject).setAccessible(true);
            ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
          }
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        return;
      }
    } while (paramLong > 2048L);
  }
  
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l = this.bytesToRead;
    int i = paramInt2;
    if (l != -1L)
    {
      l -= this.bytesRead;
      if (l == 0L) {
        return -1;
      }
      i = (int)Math.min(paramInt2, l);
    }
    paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 == -1)
    {
      if (this.bytesToRead == -1L) {
        return -1;
      }
      throw new EOFException();
    }
    this.bytesRead += paramInt1;
    paramArrayOfByte = this.listener;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.onBytesTransferred(this, paramInt1);
    }
    return paramInt1;
  }
  
  private void skipInternal()
  {
    if (this.bytesSkipped == this.bytesToSkip) {
      return;
    }
    Object localObject2 = (byte[])skipBufferReference.getAndSet(null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4096];
    }
    for (;;)
    {
      long l1 = this.bytesSkipped;
      long l2 = this.bytesToSkip;
      if (l1 == l2) {
        break label145;
      }
      int i = (int)Math.min(l2 - l1, localObject1.length);
      i = this.inputStream.read((byte[])localObject1, 0, i);
      if (Thread.interrupted()) {
        break label137;
      }
      if (i == -1) {
        break;
      }
      this.bytesSkipped += i;
      localObject2 = this.listener;
      if (localObject2 != null) {
        ((TransferListener)localObject2).onBytesTransferred(this, i);
      }
    }
    throw new EOFException();
    label137:
    throw new InterruptedIOException();
    label145:
    skipBufferReference.set(localObject1);
  }
  
  protected final long bytesRead()
  {
    return this.bytesRead;
  }
  
  protected final long bytesRemaining()
  {
    long l = this.bytesToRead;
    if (l == -1L) {
      return l;
    }
    return l - this.bytesRead;
  }
  
  protected final long bytesSkipped()
  {
    return this.bytesSkipped;
  }
  
  public void clearAllRequestProperties()
  {
    this.requestProperties.clear();
  }
  
  public void clearRequestProperty(String paramString)
  {
    Assertions.checkNotNull(paramString);
    this.requestProperties.remove(paramString);
  }
  
  public void close()
  {
    try
    {
      if (this.inputStream != null)
      {
        maybeTerminateInputStream(this.connection, bytesRemaining());
        try
        {
          this.inputStream.close();
        }
        catch (IOException localIOException)
        {
          throw new HttpDataSource.HttpDataSourceException(localIOException, this.dataSpec, 3);
        }
      }
      TransferListener localTransferListener1;
      return;
    }
    finally
    {
      this.inputStream = null;
      closeConnectionQuietly();
      if (this.opened)
      {
        this.opened = false;
        TransferListener localTransferListener2 = this.listener;
        if (localTransferListener2 != null) {
          localTransferListener2.onTransferEnd(this);
        }
      }
    }
  }
  
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection == null) {
      return null;
    }
    return localHttpURLConnection.getHeaderFields();
  }
  
  public Uri getUri()
  {
    HttpURLConnection localHttpURLConnection = this.connection;
    if (localHttpURLConnection == null) {
      return null;
    }
    return Uri.parse(localHttpURLConnection.getURL().toString());
  }
  
  /* Error */
  public long open(DataSpec paramDataSpec)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 484	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   5: lconst_0
    //   6: lstore 5
    //   8: aload_0
    //   9: lconst_0
    //   10: putfield 422	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesRead	J
    //   13: aload_0
    //   14: lconst_0
    //   15: putfield 441	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesSkipped	J
    //   18: aload_0
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 516	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:makeConnection	(Lcom/google/android/exoplayer2/upstream/DataSpec;)Ljava/net/HttpURLConnection;
    //   24: putfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   27: aload_0
    //   28: getfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   31: invokevirtual 263	java/net/HttpURLConnection:getResponseCode	()I
    //   34: istore_2
    //   35: iload_2
    //   36: sipush 200
    //   39: if_icmplt +234 -> 273
    //   42: iload_2
    //   43: sipush 299
    //   46: if_icmple +6 -> 52
    //   49: goto +224 -> 273
    //   52: aload_0
    //   53: getfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   56: invokevirtual 519	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 95	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:contentTypePredicate	Lcom/google/android/exoplayer2/util/Predicate;
    //   65: astore 8
    //   67: aload 8
    //   69: ifnull +33 -> 102
    //   72: aload 8
    //   74: aload 7
    //   76: invokeinterface 524 2 0
    //   81: ifeq +6 -> 87
    //   84: goto +18 -> 102
    //   87: aload_0
    //   88: invokespecial 489	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   91: new 526	com/google/android/exoplayer2/upstream/HttpDataSource$InvalidContentTypeException
    //   94: dup
    //   95: aload 7
    //   97: aload_1
    //   98: invokespecial 529	com/google/android/exoplayer2/upstream/HttpDataSource$InvalidContentTypeException:<init>	(Ljava/lang/String;Lcom/google/android/exoplayer2/upstream/DataSpec;)V
    //   101: athrow
    //   102: lload 5
    //   104: lstore_3
    //   105: iload_2
    //   106: sipush 200
    //   109: if_icmpne +20 -> 129
    //   112: lload 5
    //   114: lstore_3
    //   115: aload_1
    //   116: getfield 249	com/google/android/exoplayer2/upstream/DataSpec:position	J
    //   119: lconst_0
    //   120: lcmp
    //   121: ifeq +8 -> 129
    //   124: aload_1
    //   125: getfield 249	com/google/android/exoplayer2/upstream/DataSpec:position	J
    //   128: lstore_3
    //   129: aload_0
    //   130: lload_3
    //   131: putfield 443	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesToSkip	J
    //   134: aload_1
    //   135: iconst_1
    //   136: invokevirtual 256	com/google/android/exoplayer2/upstream/DataSpec:isFlagSet	(I)Z
    //   139: ifne +67 -> 206
    //   142: aload_1
    //   143: getfield 252	com/google/android/exoplayer2/upstream/DataSpec:length	J
    //   146: lstore 5
    //   148: ldc2_w 169
    //   151: lstore_3
    //   152: lload 5
    //   154: ldc2_w 169
    //   157: lcmp
    //   158: ifeq +14 -> 172
    //   161: aload_0
    //   162: aload_1
    //   163: getfield 252	com/google/android/exoplayer2/upstream/DataSpec:length	J
    //   166: putfield 420	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesToRead	J
    //   169: goto +45 -> 214
    //   172: aload_0
    //   173: getfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   176: invokestatic 531	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   179: lstore 5
    //   181: lload 5
    //   183: ldc2_w 169
    //   186: lcmp
    //   187: ifeq +11 -> 198
    //   190: lload 5
    //   192: aload_0
    //   193: getfield 443	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesToSkip	J
    //   196: lsub
    //   197: lstore_3
    //   198: aload_0
    //   199: lload_3
    //   200: putfield 420	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesToRead	J
    //   203: goto +11 -> 214
    //   206: aload_0
    //   207: aload_1
    //   208: getfield 252	com/google/android/exoplayer2/upstream/DataSpec:length	J
    //   211: putfield 420	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesToRead	J
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   219: invokevirtual 380	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   222: putfield 427	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   225: aload_0
    //   226: iconst_1
    //   227: putfield 491	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:opened	Z
    //   230: aload_0
    //   231: getfield 97	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   234: astore 7
    //   236: aload 7
    //   238: ifnull +12 -> 250
    //   241: aload 7
    //   243: aload_0
    //   244: aload_1
    //   245: invokeinterface 535 3 0
    //   250: aload_0
    //   251: getfield 420	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesToRead	J
    //   254: lreturn
    //   255: astore 7
    //   257: aload_0
    //   258: invokespecial 489	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   261: new 482	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException
    //   264: dup
    //   265: aload 7
    //   267: aload_1
    //   268: iconst_1
    //   269: invokespecial 487	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/google/android/exoplayer2/upstream/DataSpec;I)V
    //   272: athrow
    //   273: aload_0
    //   274: getfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   277: invokevirtual 500	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   280: astore 7
    //   282: aload_0
    //   283: invokespecial 489	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   286: new 537	com/google/android/exoplayer2/upstream/HttpDataSource$InvalidResponseCodeException
    //   289: dup
    //   290: iload_2
    //   291: aload 7
    //   293: aload_1
    //   294: invokespecial 540	com/google/android/exoplayer2/upstream/HttpDataSource$InvalidResponseCodeException:<init>	(ILjava/util/Map;Lcom/google/android/exoplayer2/upstream/DataSpec;)V
    //   297: astore_1
    //   298: iload_2
    //   299: sipush 416
    //   302: if_icmpne +16 -> 318
    //   305: aload_1
    //   306: new 542	com/google/android/exoplayer2/upstream/DataSourceException
    //   309: dup
    //   310: iconst_0
    //   311: invokespecial 544	com/google/android/exoplayer2/upstream/DataSourceException:<init>	(I)V
    //   314: invokevirtual 548	com/google/android/exoplayer2/upstream/HttpDataSource$InvalidResponseCodeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   317: pop
    //   318: aload_1
    //   319: athrow
    //   320: astore 7
    //   322: aload_0
    //   323: invokespecial 489	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   326: new 152	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   333: astore 8
    //   335: aload 8
    //   337: ldc_w 550
    //   340: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 8
    //   346: aload_1
    //   347: getfield 238	com/google/android/exoplayer2/upstream/DataSpec:uri	Landroid/net/Uri;
    //   350: invokevirtual 241	android/net/Uri:toString	()Ljava/lang/String;
    //   353: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: new 482	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException
    //   360: dup
    //   361: aload 8
    //   363: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: aload 7
    //   368: aload_1
    //   369: iconst_1
    //   370: invokespecial 553	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/google/android/exoplayer2/upstream/DataSpec;I)V
    //   373: athrow
    //   374: astore 7
    //   376: new 152	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   383: astore 8
    //   385: aload 8
    //   387: ldc_w 550
    //   390: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 8
    //   396: aload_1
    //   397: getfield 238	com/google/android/exoplayer2/upstream/DataSpec:uri	Landroid/net/Uri;
    //   400: invokevirtual 241	android/net/Uri:toString	()Ljava/lang/String;
    //   403: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: new 482	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException
    //   410: dup
    //   411: aload 8
    //   413: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: aload 7
    //   418: aload_1
    //   419: iconst_1
    //   420: invokespecial 553	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/google/android/exoplayer2/upstream/DataSpec;I)V
    //   423: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	DefaultHttpDataSource
    //   0	424	1	paramDataSpec	DataSpec
    //   34	269	2	i	int
    //   104	96	3	l1	long
    //   6	185	5	l2	long
    //   59	183	7	localObject1	Object
    //   255	11	7	localIOException1	IOException
    //   280	12	7	localMap	Map
    //   320	47	7	localIOException2	IOException
    //   374	43	7	localIOException3	IOException
    //   65	347	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   214	225	255	java/io/IOException
    //   27	35	320	java/io/IOException
    //   18	27	374	java/io/IOException
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      skipInternal();
      paramInt1 = readInternal(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new HttpDataSource.HttpDataSourceException(paramArrayOfByte, this.dataSpec, 2);
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    this.requestProperties.set(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */
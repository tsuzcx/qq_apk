package com.google.android.exoplayer2.upstream;

import android.net.Uri;
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
    if (this.connection != null) {}
    try
    {
      this.connection.disconnect();
      this.connection = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
      }
    }
  }
  
  /* Error */
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 134
    //   3: lstore_3
    //   4: aload_0
    //   5: ldc 137
    //   7: invokevirtual 140	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: lload_3
    //   13: lstore_1
    //   14: aload 7
    //   16: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +9 -> 28
    //   22: aload 7
    //   24: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: lstore_1
    //   28: aload_0
    //   29: ldc 154
    //   31: invokevirtual 140	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_0
    //   35: lload_1
    //   36: lstore_3
    //   37: aload_0
    //   38: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +60 -> 101
    //   44: getstatic 62	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:CONTENT_RANGE_HEADER	Ljava/util/regex/Pattern;
    //   47: aload_0
    //   48: invokevirtual 158	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 8
    //   53: lload_1
    //   54: lstore_3
    //   55: aload 8
    //   57: invokevirtual 164	java/util/regex/Matcher:find	()Z
    //   60: ifeq +41 -> 101
    //   63: aload 8
    //   65: iconst_2
    //   66: invokevirtual 168	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   69: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lstore_3
    //   73: aload 8
    //   75: iconst_1
    //   76: invokevirtual 168	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   79: invokestatic 152	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore 5
    //   84: lload_3
    //   85: lload 5
    //   87: lsub
    //   88: lconst_1
    //   89: ladd
    //   90: lstore 5
    //   92: lload_1
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge +46 -> 141
    //   98: lload 5
    //   100: lstore_3
    //   101: lload_3
    //   102: lreturn
    //   103: astore 8
    //   105: ldc 22
    //   107: new 170	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   114: ldc 173
    //   116: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 7
    //   121: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 179
    //   126: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 186	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: lload_3
    //   137: lstore_1
    //   138: goto -110 -> 28
    //   141: lload_1
    //   142: lstore_3
    //   143: lload_1
    //   144: lload 5
    //   146: lcmp
    //   147: ifeq -46 -> 101
    //   150: ldc 22
    //   152: new 170	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   159: ldc 188
    //   161: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc 190
    //   171: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 179
    //   180: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: lload_1
    //   191: lload 5
    //   193: invokestatic 199	java/lang/Math:max	(JJ)J
    //   196: lstore_3
    //   197: lload_3
    //   198: lreturn
    //   199: astore 7
    //   201: ldc 22
    //   203: new 170	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   210: ldc 201
    //   212: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 179
    //   221: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 186	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: lload_1
    //   232: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramHttpURLConnection	HttpURLConnection
    //   13	219	1	l1	long
    //   3	195	3	l2	long
    //   82	110	5	l3	long
    //   10	155	7	str	String
    //   199	1	7	localNumberFormatException1	java.lang.NumberFormatException
    //   51	23	8	localMatcher	java.util.regex.Matcher
    //   103	1	8	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   22	28	103	java/lang/NumberFormatException
    //   63	84	199	java/lang/NumberFormatException
    //   150	197	199	java/lang/NumberFormatException
  }
  
  private static URL handleRedirect(URL paramURL, String paramString)
  {
    if (paramString == null) {
      throw new ProtocolException("Null location redirect");
    }
    paramURL = new URL(paramURL, paramString);
    paramString = paramURL.getProtocol();
    if ((!"https".equals(paramString)) && (!"http".equals(paramString))) {
      throw new ProtocolException("Unsupported protocol redirect: " + paramString);
    }
    return paramURL;
  }
  
  private HttpURLConnection makeConnection(DataSpec paramDataSpec)
  {
    Object localObject = new URL(paramDataSpec.uri.toString());
    byte[] arrayOfByte = paramDataSpec.postBody;
    long l1 = paramDataSpec.position;
    long l2 = paramDataSpec.length;
    boolean bool = paramDataSpec.isFlagSet(1);
    if (!this.allowCrossProtocolRedirects)
    {
      localObject = makeConnection((URL)localObject, arrayOfByte, l1, l2, bool, true);
      return localObject;
    }
    int i = 0;
    paramDataSpec = (DataSpec)localObject;
    int j;
    for (;;)
    {
      j = i + 1;
      if (i > 20) {
        break label190;
      }
      HttpURLConnection localHttpURLConnection = makeConnection(paramDataSpec, arrayOfByte, l1, l2, bool, false);
      i = localHttpURLConnection.getResponseCode();
      if ((i != 300) && (i != 301) && (i != 302) && (i != 303))
      {
        localObject = localHttpURLConnection;
        if (arrayOfByte != null) {
          break;
        }
        if (i != 307)
        {
          localObject = localHttpURLConnection;
          if (i != 308) {
            break;
          }
        }
      }
      arrayOfByte = null;
      localObject = localHttpURLConnection.getHeaderField("Location");
      localHttpURLConnection.disconnect();
      paramDataSpec = handleRedirect(paramDataSpec, (String)localObject);
      i = j;
    }
    label190:
    throw new NoRouteToHostException("Too many redirects: " + j);
  }
  
  private HttpURLConnection makeConnection(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeoutMillis);
    localHttpURLConnection.setReadTimeout(this.readTimeoutMillis);
    Object localObject;
    if (this.defaultRequestProperties != null)
    {
      paramURL = this.defaultRequestProperties.getSnapshot().entrySet().iterator();
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
      localObject = "bytes=" + paramLong1 + "-";
      paramURL = (URL)localObject;
      if (paramLong2 != -1L) {
        paramURL = (String)localObject + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localHttpURLConnection.setDoOutput(paramBoolean1);
      if (paramArrayOfByte == null) {
        break label365;
      }
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length != 0) {
        break;
      }
      localHttpURLConnection.connect();
      return localHttpURLConnection;
    }
    localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
    localHttpURLConnection.connect();
    paramURL = localHttpURLConnection.getOutputStream();
    paramURL.write(paramArrayOfByte);
    paramURL.close();
    return localHttpURLConnection;
    label365:
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
            break;
          }
          Object localObject = paramHttpURLConnection.getClass().getName();
          if ((!((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) && (!((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"))) {
            break;
          }
          localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
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
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    do
    {
      long l;
      do
      {
        return i;
        i = paramInt2;
        if (this.bytesToRead == -1L) {
          break;
        }
        l = this.bytesToRead - this.bytesRead;
        i = j;
      } while (l == 0L);
      i = (int)Math.min(paramInt2, l);
      paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, i);
      if (paramInt1 != -1) {
        break;
      }
      i = j;
    } while (this.bytesToRead == -1L);
    throw new EOFException();
    this.bytesRead += paramInt1;
    if (this.listener != null) {
      this.listener.onBytesTransferred(this, paramInt1);
    }
    return paramInt1;
  }
  
  private void skipInternal()
  {
    if (this.bytesSkipped == this.bytesToSkip) {
      return;
    }
    byte[] arrayOfByte2 = (byte[])skipBufferReference.getAndSet(null);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4096];
    }
    while (this.bytesSkipped != this.bytesToSkip)
    {
      int i = (int)Math.min(this.bytesToSkip - this.bytesSkipped, arrayOfByte1.length);
      i = this.inputStream.read(arrayOfByte1, 0, i);
      if (Thread.interrupted()) {
        throw new InterruptedIOException();
      }
      if (i == -1) {
        throw new EOFException();
      }
      this.bytesSkipped += i;
      if (this.listener != null) {
        this.listener.onBytesTransferred(this, i);
      }
    }
    skipBufferReference.set(arrayOfByte1);
  }
  
  protected final long bytesRead()
  {
    return this.bytesRead;
  }
  
  protected final long bytesRemaining()
  {
    if (this.bytesToRead == -1L) {
      return this.bytesToRead;
    }
    return this.bytesToRead - this.bytesRead;
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
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 427	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   4: ifnull +21 -> 25
    //   7: aload_0
    //   8: getfield 116	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   11: aload_0
    //   12: invokevirtual 477	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:bytesRemaining	()J
    //   15: invokestatic 479	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:maybeTerminateInputStream	(Ljava/net/HttpURLConnection;J)V
    //   18: aload_0
    //   19: getfield 427	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   22: invokevirtual 480	java/io/InputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 427	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   30: aload_0
    //   31: invokespecial 482	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   34: aload_0
    //   35: getfield 484	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:opened	Z
    //   38: ifeq +25 -> 63
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 484	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:opened	Z
    //   46: aload_0
    //   47: getfield 97	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   50: ifnull +13 -> 63
    //   53: aload_0
    //   54: getfield 97	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   57: aload_0
    //   58: invokeinterface 487 2 0
    //   63: return
    //   64: astore_1
    //   65: new 489	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException
    //   68: dup
    //   69: aload_1
    //   70: aload_0
    //   71: getfield 491	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   74: iconst_3
    //   75: invokespecial 494	com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/google/android/exoplayer2/upstream/DataSpec;I)V
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 427	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   85: aload_0
    //   86: invokespecial 482	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:closeConnectionQuietly	()V
    //   89: aload_0
    //   90: getfield 484	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:opened	Z
    //   93: ifeq +25 -> 118
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 484	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:opened	Z
    //   101: aload_0
    //   102: getfield 97	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 97	com/google/android/exoplayer2/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   112: aload_0
    //   113: invokeinterface 487 2 0
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	DefaultHttpDataSource
    //   64	6	1	localIOException	IOException
    //   79	40	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	64	java/io/IOException
    //   0	18	79	finally
    //   18	25	79	finally
    //   65	79	79	finally
  }
  
  protected final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    if (this.connection == null) {
      return null;
    }
    return this.connection.getHeaderFields();
  }
  
  public Uri getUri()
  {
    if (this.connection == null) {
      return null;
    }
    return Uri.parse(this.connection.getURL().toString());
  }
  
  public long open(DataSpec paramDataSpec)
  {
    long l2 = 0L;
    this.dataSpec = paramDataSpec;
    this.bytesRead = 0L;
    this.bytesSkipped = 0L;
    int i;
    try
    {
      this.connection = makeConnection(paramDataSpec);
      Map localMap;
      str = this.connection.getContentType();
    }
    catch (IOException localIOException1)
    {
      try
      {
        i = this.connection.getResponseCode();
        if ((i >= 200) && (i <= 299)) {
          break label180;
        }
        localMap = this.connection.getHeaderFields();
        closeConnectionQuietly();
        paramDataSpec = new HttpDataSource.InvalidResponseCodeException(i, localMap, paramDataSpec);
        if (i == 416) {
          paramDataSpec.initCause(new DataSourceException(0));
        }
        throw paramDataSpec;
      }
      catch (IOException localIOException2)
      {
        closeConnectionQuietly();
        throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), localIOException2, paramDataSpec, 1);
      }
      localIOException1 = localIOException1;
      throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + paramDataSpec.uri.toString(), localIOException1, paramDataSpec, 1);
    }
    label180:
    String str;
    if ((this.contentTypePredicate != null) && (!this.contentTypePredicate.evaluate(str)))
    {
      closeConnectionQuietly();
      throw new HttpDataSource.InvalidContentTypeException(str, paramDataSpec);
    }
    long l1 = l2;
    if (i == 200)
    {
      l1 = l2;
      if (paramDataSpec.position != 0L) {
        l1 = paramDataSpec.position;
      }
    }
    this.bytesToSkip = l1;
    if (!paramDataSpec.isFlagSet(1)) {
      if (paramDataSpec.length != -1L) {
        this.bytesToRead = paramDataSpec.length;
      }
    }
    for (;;)
    {
      try
      {
        this.inputStream = this.connection.getInputStream();
        this.opened = true;
        if (this.listener != null) {
          this.listener.onTransferStart(this, paramDataSpec);
        }
        return this.bytesToRead;
      }
      catch (IOException localIOException3)
      {
        closeConnectionQuietly();
        throw new HttpDataSource.HttpDataSourceException(localIOException3, paramDataSpec, 1);
      }
      l1 = getContentLength(this.connection);
      if (l1 != -1L)
      {
        l1 -= this.bytesToSkip;
        this.bytesToRead = l1;
      }
      else
      {
        l1 = -1L;
        continue;
        this.bytesToRead = paramDataSpec.length;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultHttpDataSource
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ark;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArkAndroidHttpClientStub
{
  private static final int ARK_HTTP_CLIENT_ERROR_CANCEL = 9;
  private static final int ARK_HTTP_CLIENT_ERROR_DECOMPRESS_FAIL = 12;
  private static final int ARK_HTTP_CLIENT_ERROR_DNS_FAIL = 22;
  private static final int ARK_HTTP_CLIENT_ERROR_FILE_NO_FOUND = 7;
  private static final int ARK_HTTP_CLIENT_ERROR_MAX = 100;
  private static final int ARK_HTTP_CLIENT_ERROR_MD5_NOT_MATCH = 11;
  private static final int ARK_HTTP_CLIENT_ERROR_MOVE_FILE_FAIL = 13;
  private static final int ARK_HTTP_CLIENT_ERROR_NETWORK_FAIL = 5;
  private static final int ARK_HTTP_CLIENT_ERROR_NOT_MODIFIED = 1;
  private static final int ARK_HTTP_CLIENT_ERROR_OK = 0;
  private static final int ARK_HTTP_CLIENT_ERROR_OTHER = 2;
  private static final int ARK_HTTP_CLIENT_ERROR_SERVER_CLOSE = 3;
  private static final int ARK_HTTP_CLIENT_ERROR_SERVER_ERROR = 8;
  private static final int ARK_HTTP_CLIENT_ERROR_TIMEOUT = 21;
  private static final int ARK_HTTP_CLIENT_ERROR_WRITE_FAIL = 4;
  private static final int BUFFER_SIZE = 32768;
  private static final int DEFAULT_TIMEOUT = 15000;
  protected static final ArkEnvironmentManager ENV;
  private static final String FORM_DATA_BEGIN = "--%s\r\nContent-Disposition: form-data; name=\"%s\"\r\n\r\n";
  private static final String FORM_DATA_END = "\r\n";
  private static final byte[] FORM_DATA_END_BYTES = { 13, 10 };
  private static final String FORM_FILE_BEGIN = "--%s\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream\r\nContent-Transfer-Encoding: binary\r\n\r\n";
  private static final String MULTI_PART_FORM_DATA_BOUNDARY = "89F92C5F19802901C764BDA13DEC3F3CB820E0FD68D2E2D1F03FC95DE692FFB4";
  private static final int REDIRECT_KEEP_VERB = 2;
  private static final int REDIRECT_MAX_COUNT = 3;
  private static final int REDIRECT_NONE = 0;
  private static final int REDIRECT_SWITCH_TO_GET = 1;
  private static final String TAG = "ArkApp.AndroidHTTP";
  private static final String UTF8 = "UTF-8";
  static ExecutorService executorService = Executors.newFixedThreadPool(10);
  private static Timer sTimer;
  private String mDownloadFilePath;
  ArkAndroidHttpClientStub.FormData mFormData;
  private HttpURLConnection mHttpURLConnection;
  private boolean mIsCanceled;
  private boolean mIsCompleted;
  private boolean mIsTimeout;
  private String mProxyHost;
  private int mProxyPort;
  public byte[] mResponseBody;
  private final ArkAndroidHttpClientStub.RequestOption m_option = new ArkAndroidHttpClientStub.RequestOption(null);
  
  static
  {
    ENV = ArkEnvironmentManager.getInstance();
    sTimer = new Timer();
  }
  
  private void OnTimeout()
  {
    try
    {
      if (this.mIsCompleted) {
        return;
      }
      ENV.logI("ArkApp.AndroidHTTP", "OnTimeout");
      this.mIsTimeout = true;
      return;
    }
    finally {}
  }
  
  private static void cancelTimer(TimerTask paramTimerTask)
  {
    if (paramTimerTask != null) {
      paramTimerTask.cancel();
    }
  }
  
  private static void closeStream(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      ENV.logI("ArkApp.AndroidHTTP", "closeStream fail, err=" + paramInputStream.getMessage());
    }
  }
  
  private static void closeStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (Exception paramOutputStream)
    {
      ENV.logI("ArkApp.AndroidHTTP", "closeStream fail, err=" + paramOutputStream.getMessage());
    }
  }
  
  private static void closeStream(HttpURLConnection paramHttpURLConnection) {}
  
  private static long computeFormDataLength(ArkAndroidHttpClientStub.FormData paramFormData)
  {
    Iterator localIterator = paramFormData.formData.keySet().iterator();
    String str;
    for (long l1 = 0L; localIterator.hasNext(); l1 = formDataToBytes(str, (String)paramFormData.formData.get(str)).length + l1) {
      str = (String)localIterator.next();
    }
    long l2 = l1;
    if (!TextUtils.isEmpty(paramFormData.fileName))
    {
      l2 = l1;
      if (!TextUtils.isEmpty(paramFormData.filePath))
      {
        l2 = getFileLength(paramFormData.filePath);
        ENV.logD("ArkApp.AndroidHTTP", String.format("length of form file %s is %d", new Object[] { paramFormData.filePath, Long.valueOf(l2) }));
        long l3 = formFileBegin(paramFormData.fileName, paramFormData.filePath).length;
        l2 = FORM_DATA_END_BYTES.length + (l2 + (l1 + l3));
      }
    }
    return formTailer().length + l2;
  }
  
  private static HttpURLConnection createConnection(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        URL localURL = new URL(paramString1);
        if ((!TextUtils.isEmpty(paramString2)) && (paramInt > 0)) {
          paramString2 = new InetSocketAddress(paramString2, paramInt);
        }
        for (paramString2 = (HttpURLConnection)localURL.openConnection(new Proxy(Proxy.Type.HTTP, paramString2));; paramString2 = (HttpURLConnection)localURL.openConnection())
        {
          ENV.logI("ArkApp.AndroidHTTP", "createConnection, url=" + paramString1);
          return paramString2;
        }
      }
      return null;
    }
    catch (Exception paramString1)
    {
      ENV.logE("ArkApp.AndroidHTTP", "createConnection fail, error: " + paramString1.getMessage());
      paramString1.printStackTrace();
    }
  }
  
  private static byte[] formDataToBytes(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.format("--%s\r\nContent-Disposition: form-data; name=\"%s\"\r\n\r\n", new Object[] { "89F92C5F19802901C764BDA13DEC3F3CB820E0FD68D2E2D1F03FC95DE692FFB4", paramString1 }));
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuffer.append(paramString2);
    }
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString().getBytes("UTF-8");
  }
  
  private static byte[] formFileBegin(String paramString1, String paramString2)
  {
    return String.format("--%s\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream\r\nContent-Transfer-Encoding: binary\r\n\r\n", new Object[] { "89F92C5F19802901C764BDA13DEC3F3CB820E0FD68D2E2D1F03FC95DE692FFB4", paramString1, getFileName(paramString2) }).getBytes("UTF-8");
  }
  
  private static byte[] formTailer()
  {
    return String.format("--%s--\r\n", new Object[] { "89F92C5F19802901C764BDA13DEC3F3CB820E0FD68D2E2D1F03FC95DE692FFB4" }).getBytes("UTF-8");
  }
  
  private static long getFileLength(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isFile()) {
      return paramString.length();
    }
    throw new IOException(String.format("get file length fail due to %s is not a file", new Object[0]));
  }
  
  private static String getFileName(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
      str = paramString;
    } while (i < 0);
    return paramString.substring(i + 1);
  }
  
  private static String getRedirectedURL(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    try
    {
      String str1 = paramHttpURLConnection.getHeaderField("Location");
      paramHttpURLConnection = new URL(paramString);
      String str2 = paramHttpURLConnection.getProtocol() + "://";
      paramHttpURLConnection = paramString;
      if (!TextUtils.isEmpty(str1))
      {
        paramHttpURLConnection = str1;
        if (!str2.equalsIgnoreCase("http://"))
        {
          paramHttpURLConnection = str1;
          if (!str2.equalsIgnoreCase("https://"))
          {
            paramHttpURLConnection = Uri.parse(paramString).buildUpon();
            paramHttpURLConnection.appendEncodedPath(str1);
            paramHttpURLConnection = paramHttpURLConnection.toString();
          }
        }
      }
      return paramHttpURLConnection;
    }
    catch (Exception paramHttpURLConnection)
    {
      ENV.logE("ArkApp.AndroidHTTP", "getRedirectedURL, fail, err=" + paramHttpURLConnection.getMessage());
    }
    return paramString;
  }
  
  private void httpAsynTask(String paramString1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, ArkAndroidHttpClientStub.FormData paramFormData, String paramString2, long paramLong)
  {
    executorService.execute(new ArkAndroidHttpClientStub.1(this, paramString1, paramInt1, paramArrayOfByte, paramInt2, paramFormData, paramString2, paramLong));
  }
  
  private void httpExecuteTask(String paramString1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, ArkAndroidHttpClientStub.FormData paramFormData, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    ENV.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, start, url=%s", new Object[] { paramString1 }));
    TimerTask localTimerTask = setTimer(this.m_option.timeoutInterval);
    int j = 0;
    int i = paramInt2;
    Object localObject = paramArrayOfByte;
    paramInt2 = j;
    paramArrayOfByte = paramFormData;
    paramFormData = (ArkAndroidHttpClientStub.FormData)localObject;
    localObject = null;
    HttpURLConnection localHttpURLConnection;
    int k;
    if (paramInt2 < 3)
    {
      localHttpURLConnection = createConnection(paramString1, this.mProxyHost, this.mProxyPort);
      ENV.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, send request, url=%s", new Object[] { paramString1 }));
      j = sendRequest(localHttpURLConnection, this.m_option, paramInt1, paramFormData, i, paramArrayOfByte);
      k = needRedirect(j);
      if (k == 0) {
        paramArrayOfByte = localHttpURLConnection;
      }
    }
    for (;;)
    {
      this.mDownloadFilePath = paramString2;
      this.mHttpURLConnection = paramArrayOfByte;
      ENV.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, write response, url=%s", new Object[] { paramString1 }));
      writeResponse(paramString1, localTimerTask, paramLong, paramString2);
      ENV.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, end, time=%d ms, url=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString1 }));
      return;
      if (k == 1)
      {
        paramFormData = null;
        i = 0;
        paramArrayOfByte = null;
      }
      localObject = getRedirectedURL(localHttpURLConnection, paramString1);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ENV.logE("ArkApp.AndroidHTTP", "invalid redirect response, url=" + (String)localObject);
        paramArrayOfByte = localHttpURLConnection;
        paramString1 = (String)localObject;
      }
      else
      {
        closeStream(localHttpURLConnection);
        ENV.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, redirect, status-code=%d, type=%d, url=%s->%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), paramString1, localObject }));
        paramInt2 += 1;
        paramString1 = (String)localObject;
        break;
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  private int needRedirect(int paramInt)
  {
    if ((paramInt == 307) || (paramInt == 308)) {
      return 2;
    }
    if ((paramInt == 301) || (paramInt == 302) || (paramInt == 303)) {
      return 1;
    }
    return 0;
  }
  
  private static int sendRequest(HttpURLConnection paramHttpURLConnection, ArkAndroidHttpClientStub.RequestOption paramRequestOption, int paramInt1, byte[] paramArrayOfByte, int paramInt2, ArkAndroidHttpClientStub.FormData paramFormData)
  {
    int j = 1;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    int i = j;
    if (paramFormData == null)
    {
      if ((paramArrayOfByte == null) || (paramInt2 <= 0)) {
        break label380;
      }
      i = j;
    }
    label303:
    label380:
    for (;;)
    {
      Object localObject2 = localObject3;
      Object localObject1 = localObject4;
      try
      {
        setConnectionOptions(paramHttpURLConnection, paramRequestOption, paramInt1);
        if (i != 0)
        {
          localObject2 = localObject3;
          localObject1 = localObject4;
          paramHttpURLConnection.setDoOutput(true);
          localObject2 = localObject3;
          localObject1 = localObject4;
          paramHttpURLConnection.setUseCaches(false);
          localObject2 = localObject3;
          localObject1 = localObject4;
          paramHttpURLConnection.setRequestMethod("POST");
          if (paramFormData != null)
          {
            localObject2 = localObject3;
            localObject1 = localObject4;
            paramHttpURLConnection.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", new Object[] { "89F92C5F19802901C764BDA13DEC3F3CB820E0FD68D2E2D1F03FC95DE692FFB4" }));
            localObject2 = localObject3;
            localObject1 = localObject4;
            paramHttpURLConnection.setRequestProperty("Content-Length", Long.toString(computeFormDataLength(paramFormData)));
          }
        }
        localObject2 = localObject3;
        localObject1 = localObject4;
        ENV.logI("ArkApp.AndroidHTTP", "sendRequest, connect begin");
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramHttpURLConnection.connect();
        localObject2 = localObject3;
        localObject1 = localObject4;
        ENV.logI("ArkApp.AndroidHTTP", "sendRequest, connect end");
        paramRequestOption = localObject5;
        if (i != 0)
        {
          localObject2 = localObject3;
          localObject1 = localObject4;
          ENV.logI("ArkApp.AndroidHTTP", "sendRequest, send request begin");
          localObject2 = localObject3;
          localObject1 = localObject4;
          paramRequestOption = paramHttpURLConnection.getOutputStream();
          if (paramFormData == null) {
            break label303;
          }
          localObject2 = paramRequestOption;
          localObject1 = paramRequestOption;
          writeFormData(paramRequestOption, paramFormData);
        }
        for (;;)
        {
          localObject2 = paramRequestOption;
          localObject1 = paramRequestOption;
          paramRequestOption.flush();
          localObject2 = paramRequestOption;
          localObject1 = paramRequestOption;
          ENV.logI("ArkApp.AndroidHTTP", "sendRequest, send request end");
          localObject2 = paramRequestOption;
          localObject1 = paramRequestOption;
          paramInt1 = paramHttpURLConnection.getResponseCode();
          closeStream(paramRequestOption);
          return paramInt1;
          if ((paramArrayOfByte != null) && (paramInt2 > 0))
          {
            localObject2 = paramRequestOption;
            localObject1 = paramRequestOption;
            paramRequestOption.write(paramArrayOfByte, 0, paramInt2);
          }
        }
        i = 0;
      }
      catch (Exception paramHttpURLConnection)
      {
        localObject1 = localObject2;
        ENV.logE("ArkApp.AndroidHTTP", "sendRequest, exception=" + paramHttpURLConnection.getMessage());
        return 0;
      }
      finally
      {
        closeStream((OutputStream)localObject1);
      }
    }
  }
  
  private static void setConnectionOptions(HttpURLConnection paramHttpURLConnection, ArkAndroidHttpClientStub.RequestOption paramRequestOption, int paramInt)
  {
    if (paramRequestOption.timeoutInterval == 0) {}
    for (int i = 15000;; i = paramRequestOption.timeoutInterval)
    {
      paramHttpURLConnection.setConnectTimeout(i);
      paramHttpURLConnection.setReadTimeout(i);
      paramHttpURLConnection.setInstanceFollowRedirects(true);
      if (paramRequestOption == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramRequestOption.cookie)) {
        paramHttpURLConnection.setRequestProperty("Cookie", paramRequestOption.cookie);
      }
      paramRequestOption = paramRequestOption.customHeader.iterator();
      while (paramRequestOption.hasNext())
      {
        ArkAndroidHttpClientStub.Header localHeader = (ArkAndroidHttpClientStub.Header)paramRequestOption.next();
        if (!TextUtils.isEmpty(localHeader.name)) {
          paramHttpURLConnection.addRequestProperty(localHeader.name, localHeader.value);
        }
      }
    }
    if (paramInt != 0)
    {
      paramRequestOption = timeStampToString(paramInt);
      if (!TextUtils.isEmpty(paramRequestOption))
      {
        paramHttpURLConnection.setRequestProperty("If-Modified-Since", paramRequestOption);
        ENV.logD("ArkApp.AndroidHTTP", String.format("lastModify is %s(%d)", new Object[] { paramRequestOption, Integer.valueOf(paramInt) }));
      }
    }
  }
  
  private void setFlagComplete()
  {
    try
    {
      this.mIsCompleted = true;
      return;
    }
    finally {}
  }
  
  private TimerTask setTimer(int paramInt)
  {
    ArkAndroidHttpClientStub.2 local2 = new ArkAndroidHttpClientStub.2(this, new WeakReference(this));
    if (paramInt > 0) {
      sTimer.schedule(local2, paramInt);
    }
    return local2;
  }
  
  private static String timeStampToString(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return null;
      Object localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Object localObject2 = ((SimpleDateFormat)localObject1).format(Long.valueOf(paramInt * 1000L));
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return "";
      }
      try
      {
        localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
        if (localObject1 != null)
        {
          localObject2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
          ((DateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
          localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        ENV.logE("ArkApp.AndroidHTTP", "timeStampToString is fail and errormsg is  " + localException.getMessage());
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  private static void writeFormData(OutputStream paramOutputStream, ArkAndroidHttpClientStub.FormData paramFormData)
  {
    Object localObject1 = paramFormData.formData.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramOutputStream.write(formDataToBytes((String)localObject2, (String)paramFormData.formData.get(localObject2)));
    }
    if ((!TextUtils.isEmpty(paramFormData.fileName)) && (!TextUtils.isEmpty(paramFormData.filePath)))
    {
      paramOutputStream.write(formFileBegin(paramFormData.fileName, paramFormData.filePath));
      localObject1 = new FileInputStream(paramFormData.filePath);
      localObject2 = new byte[32768];
    }
    int i;
    for (long l = 0L;; l += i)
    {
      i = ((FileInputStream)localObject1).read((byte[])localObject2);
      if (i == -1)
      {
        ENV.logD("ArkApp.AndroidHTTP", String.format("writeFormData, file=%s, length=%d", new Object[] { paramFormData.filePath, Long.valueOf(l) }));
        paramOutputStream.write(FORM_DATA_END_BYTES);
        paramOutputStream.write(formTailer());
        return;
      }
      paramOutputStream.write((byte[])localObject2, 0, i);
    }
  }
  
  /* Error */
  private void writeResponse(String paramString1, TimerTask paramTimerTask, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload 5
    //   5: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +117 -> 125
    //   11: new 628	java/io/FileOutputStream
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 629	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 429	com/tencent/ark/ArkAndroidHttpClientStub:mHttpURLConnection	Ljava/net/HttpURLConnection;
    //   26: ifnonnull +123 -> 149
    //   29: getstatic 97	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   32: ldc 63
    //   34: ldc_w 631
    //   37: invokevirtual 295	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: new 153	java/lang/Exception
    //   43: dup
    //   44: ldc_w 633
    //   47: invokespecial 634	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: astore 8
    //   53: aload 10
    //   55: astore 9
    //   57: getstatic 97	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   60: ldc 63
    //   62: new 160	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 636
    //   72: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 638
    //   82: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 8
    //   87: invokevirtual 639	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 295	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_2
    //   100: invokestatic 641	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   103: aload_0
    //   104: invokespecial 643	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   107: aload_0
    //   108: lload_3
    //   109: bipush 22
    //   111: invokevirtual 647	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   114: aload 9
    //   116: invokestatic 649	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/InputStream;)V
    //   119: aload 5
    //   121: invokestatic 508	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   124: return
    //   125: new 651	java/io/ByteArrayOutputStream
    //   128: dup
    //   129: invokespecial 652	java/io/ByteArrayOutputStream:<init>	()V
    //   132: astore 5
    //   134: goto -112 -> 22
    //   137: astore 8
    //   139: aconst_null
    //   140: astore 5
    //   142: aload 10
    //   144: astore 9
    //   146: goto -89 -> 57
    //   149: new 654	java/io/BufferedInputStream
    //   152: dup
    //   153: aload_0
    //   154: getfield 429	com/tencent/ark/ArkAndroidHttpClientStub:mHttpURLConnection	Ljava/net/HttpURLConnection;
    //   157: invokevirtual 658	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   160: invokespecial 660	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   163: astore 9
    //   165: aload 5
    //   167: astore 10
    //   169: aload 9
    //   171: astore 8
    //   173: ldc 37
    //   175: newarray byte
    //   177: astore 11
    //   179: iconst_0
    //   180: istore 6
    //   182: aload 5
    //   184: astore 10
    //   186: aload 9
    //   188: astore 8
    //   190: aload_0
    //   191: getfield 662	com/tencent/ark/ArkAndroidHttpClientStub:mIsCanceled	Z
    //   194: ifeq +147 -> 341
    //   197: aload 5
    //   199: astore 10
    //   201: aload 9
    //   203: astore 8
    //   205: getstatic 97	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   208: ldc 63
    //   210: new 160	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 664
    //   220: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_1
    //   224: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 129	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload 5
    //   235: astore 10
    //   237: aload 9
    //   239: astore 8
    //   241: aload 5
    //   243: instanceof 651
    //   246: ifeq +23 -> 269
    //   249: aload 5
    //   251: astore 10
    //   253: aload 9
    //   255: astore 8
    //   257: aload_0
    //   258: aload 5
    //   260: checkcast 651	java/io/ByteArrayOutputStream
    //   263: invokevirtual 667	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   266: putfield 669	com/tencent/ark/ArkAndroidHttpClientStub:mResponseBody	[B
    //   269: aload 5
    //   271: astore 10
    //   273: aload 9
    //   275: astore 8
    //   277: getstatic 97	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   280: ldc 63
    //   282: new 160	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 671
    //   292: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 6
    //   297: invokevirtual 674	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 676
    //   303: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 129	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_2
    //   317: invokestatic 641	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   320: aload_0
    //   321: invokespecial 643	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   324: aload_0
    //   325: lload_3
    //   326: iconst_0
    //   327: invokevirtual 647	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   330: aload 9
    //   332: invokestatic 649	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/InputStream;)V
    //   335: aload 5
    //   337: invokestatic 508	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   340: return
    //   341: aload 5
    //   343: astore 10
    //   345: aload 9
    //   347: astore 8
    //   349: aload_0
    //   350: getfield 131	com/tencent/ark/ArkAndroidHttpClientStub:mIsTimeout	Z
    //   353: ifeq +42 -> 395
    //   356: aload 5
    //   358: astore 10
    //   360: aload 9
    //   362: astore 8
    //   364: getstatic 97	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   367: ldc 63
    //   369: new 160	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 678
    //   379: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokevirtual 129	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: goto -159 -> 233
    //   395: aload 5
    //   397: astore 10
    //   399: aload 9
    //   401: astore 8
    //   403: aload 9
    //   405: aload 11
    //   407: invokevirtual 679	java/io/InputStream:read	([B)I
    //   410: istore 7
    //   412: iload 7
    //   414: iconst_m1
    //   415: if_icmpeq -182 -> 233
    //   418: aload 5
    //   420: astore 10
    //   422: aload 9
    //   424: astore 8
    //   426: aload 5
    //   428: aload 11
    //   430: iconst_0
    //   431: iload 7
    //   433: invokevirtual 512	java/io/OutputStream:write	([BII)V
    //   436: iload 7
    //   438: iload 6
    //   440: iadd
    //   441: istore 6
    //   443: goto -261 -> 182
    //   446: astore 11
    //   448: aconst_null
    //   449: astore 12
    //   451: aconst_null
    //   452: astore 5
    //   454: aload 12
    //   456: astore 10
    //   458: aload 5
    //   460: astore 8
    //   462: getstatic 97	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   465: ldc 63
    //   467: new 160	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 636
    //   477: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_1
    //   481: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc_w 638
    //   487: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 11
    //   492: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   495: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokevirtual 295	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload_2
    //   505: invokestatic 641	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   508: aload_0
    //   509: invokespecial 643	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   512: aload_0
    //   513: lload_3
    //   514: iconst_5
    //   515: invokevirtual 647	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   518: aload 5
    //   520: invokestatic 649	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/InputStream;)V
    //   523: aload 12
    //   525: invokestatic 508	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   528: return
    //   529: astore_1
    //   530: aconst_null
    //   531: astore 5
    //   533: aconst_null
    //   534: astore 8
    //   536: aload_2
    //   537: invokestatic 641	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   540: aload_0
    //   541: invokespecial 643	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   544: aload_0
    //   545: lload_3
    //   546: iconst_0
    //   547: invokevirtual 647	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   550: aload 8
    //   552: invokestatic 649	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/InputStream;)V
    //   555: aload 5
    //   557: invokestatic 508	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   560: aload_1
    //   561: athrow
    //   562: astore_1
    //   563: aconst_null
    //   564: astore 8
    //   566: goto -30 -> 536
    //   569: astore_1
    //   570: aload 10
    //   572: astore 5
    //   574: goto -38 -> 536
    //   577: astore_1
    //   578: aload 9
    //   580: astore 8
    //   582: goto -46 -> 536
    //   585: astore 11
    //   587: aconst_null
    //   588: astore 8
    //   590: aload 5
    //   592: astore 12
    //   594: aload 8
    //   596: astore 5
    //   598: goto -144 -> 454
    //   601: astore 11
    //   603: aload 5
    //   605: astore 12
    //   607: aload 9
    //   609: astore 5
    //   611: goto -157 -> 454
    //   614: astore 8
    //   616: goto -559 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	ArkAndroidHttpClientStub
    //   0	619	1	paramString1	String
    //   0	619	2	paramTimerTask	TimerTask
    //   0	619	3	paramLong	long
    //   0	619	5	paramString2	String
    //   180	262	6	i	int
    //   410	31	7	j	int
    //   51	35	8	localUnknownHostException1	java.net.UnknownHostException
    //   137	1	8	localUnknownHostException2	java.net.UnknownHostException
    //   171	424	8	localObject1	Object
    //   614	1	8	localUnknownHostException3	java.net.UnknownHostException
    //   55	553	9	localObject2	Object
    //   1	570	10	localObject3	Object
    //   177	252	11	arrayOfByte	byte[]
    //   446	45	11	localException1	Exception
    //   585	1	11	localException2	Exception
    //   601	1	11	localException3	Exception
    //   449	157	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   22	51	51	java/net/UnknownHostException
    //   149	165	51	java/net/UnknownHostException
    //   3	22	137	java/net/UnknownHostException
    //   125	134	137	java/net/UnknownHostException
    //   3	22	446	java/lang/Exception
    //   125	134	446	java/lang/Exception
    //   3	22	529	finally
    //   125	134	529	finally
    //   22	51	562	finally
    //   149	165	562	finally
    //   173	179	569	finally
    //   190	197	569	finally
    //   205	233	569	finally
    //   241	249	569	finally
    //   257	269	569	finally
    //   277	316	569	finally
    //   349	356	569	finally
    //   364	392	569	finally
    //   403	412	569	finally
    //   426	436	569	finally
    //   462	504	569	finally
    //   57	99	577	finally
    //   22	51	585	java/lang/Exception
    //   149	165	585	java/lang/Exception
    //   173	179	601	java/lang/Exception
    //   190	197	601	java/lang/Exception
    //   205	233	601	java/lang/Exception
    //   241	249	601	java/lang/Exception
    //   257	269	601	java/lang/Exception
    //   277	316	601	java/lang/Exception
    //   349	356	601	java/lang/Exception
    //   364	392	601	java/lang/Exception
    //   403	412	601	java/lang/Exception
    //   426	436	601	java/lang/Exception
    //   173	179	614	java/net/UnknownHostException
    //   190	197	614	java/net/UnknownHostException
    //   205	233	614	java/net/UnknownHostException
    //   241	249	614	java/net/UnknownHostException
    //   257	269	614	java/net/UnknownHostException
    //   277	316	614	java/net/UnknownHostException
    //   349	356	614	java/net/UnknownHostException
    //   364	392	614	java/net/UnknownHostException
    //   403	412	614	java/net/UnknownHostException
    //   426	436	614	java/net/UnknownHostException
  }
  
  public void AddCookie(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (this.m_option.cookie = paramString;; this.m_option.cookie = "")
    {
      ENV.logI("ArkApp.AndroidHTTP", "AddCookie, cookie=" + this.m_option.cookie);
      return;
    }
  }
  
  public void AddCustomHeader(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    this.m_option.customHeader.add(new ArkAndroidHttpClientStub.Header(paramString1, str));
    ENV.logD("ArkApp.AndroidHTTP", "AddCustomHeader, " + paramString1 + "=" + str);
  }
  
  public void AddFormData(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    if (this.mFormData == null) {
      this.mFormData = new ArkAndroidHttpClientStub.FormData(null);
    }
    this.mFormData.formData.put(paramString1, str);
  }
  
  public void AddFormFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (this.mFormData == null) {
      this.mFormData = new ArkAndroidHttpClientStub.FormData(null);
    }
    this.mFormData.fileName = paramString1;
    this.mFormData.filePath = paramString2;
  }
  
  public void Cancel()
  {
    try
    {
      if (this.mIsCompleted) {
        return;
      }
      ENV.logI("ArkApp.AndroidHTTP", "Cancel");
      this.mIsCanceled = true;
      return;
    }
    finally {}
  }
  
  public int DownloadToBuffer(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ENV.logE("ArkApp.AndroidHTTP", "DownloadToBuffer, url is empty");
      return -1;
    }
    httpAsynTask(paramString, paramInt, null, 0, null, null, paramLong);
    return 0;
  }
  
  public int DownloadToFile(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ENV.logE("ArkApp.AndroidHTTP", "DownloadToFile, url or filepath is empty");
      return -1;
    }
    httpAsynTask(paramString1, paramInt, null, 0, null, paramString2, paramLong);
    return 0;
  }
  
  public String[] GetAllResponseHeaders()
  {
    if (this.mHttpURLConnection == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Map localMap = this.mHttpURLConnection.getHeaderFields();
    if (localMap != null)
    {
      Iterator localIterator1 = localMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str1 = (String)localIterator1.next();
        Iterator localIterator2 = ((List)localMap.get(str1)).iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          localArrayList.add(str1);
          localArrayList.add(str2);
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public byte[] GetDownloadBuffer()
  {
    if (this.mResponseBody == null)
    {
      ENV.logI("ArkApp.AndroidHTTP", "GetDownloadBuffer, responseBody is null");
      return null;
    }
    ENV.logD("ArkApp.AndroidHTTP", "GetDownloadBuffer, length=" + this.mResponseBody.length);
    return this.mResponseBody;
  }
  
  public String GetDownloadFilePath()
  {
    ENV.logD("ArkApp.AndroidHTTP", "GetDownloadFilePath, path=" + this.mDownloadFilePath);
    return this.mDownloadFilePath;
  }
  
  public String GetFinalURL()
  {
    if (this.mHttpURLConnection == null)
    {
      ENV.logE("ArkApp.AndroidHTTP", "FinalURL is empty");
      return "";
    }
    ENV.logD("ArkApp.AndroidHTTP", "FinalURL=" + this.mHttpURLConnection.getURL().toString());
    return this.mHttpURLConnection.getURL().toString();
  }
  
  public int GetLastModifyTime()
  {
    if (this.mHttpURLConnection != null)
    {
      ENV.logD("ArkApp.AndroidHTTP", "LastModifyTime=" + (int)(this.mHttpURLConnection.getLastModified() / 1000L));
      return (int)(this.mHttpURLConnection.getLastModified() / 1000L);
    }
    return 0;
  }
  
  public int GetMaxAge()
  {
    int j = 0;
    String str = GetResponseHeader("Cache-Control", true);
    if (TextUtils.isEmpty(str)) {
      return 0;
    }
    Object localObject = str.toLowerCase();
    int i = j;
    if (((String)localObject).contains("max-age="))
    {
      localObject = Pattern.compile("max-age=[0-9]*").matcher((CharSequence)localObject);
      i = j;
      if (((Matcher)localObject).find()) {
        localObject = ((Matcher)localObject).group(0);
      }
    }
    try
    {
      i = Integer.parseInt(((String)localObject).replace("max-age=", ""));
      ENV.logD("ArkApp.AndroidHTTP", "GetMaxAge, max-age=" + i);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ENV.logI("ArkApp.AndroidHTTP", "GetMaxAge, invalid max-age, " + str);
        i = j;
      }
    }
  }
  
  public String GetResponseHeader(String paramString, boolean paramBoolean)
  {
    String str2 = null;
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.mHttpURLConnection != null) {
      str1 = str2;
    }
    try
    {
      str2 = this.mHttpURLConnection.getHeaderField(paramString);
      str1 = str2;
      if (str2 != null)
      {
        str1 = str2;
        if (paramBoolean)
        {
          str1 = str2;
          str2 = str2.trim();
          str1 = str2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ENV.logW("ArkApp.AndroidHTTP", String.format("GetResponseHeader, exception=%s", new Object[] { localException.toString() }));
      }
    }
    ENV.logD("ArkApp.AndroidHTTP", String.format("GetResponseHeader, %s=%s", new Object[] { paramString, str1 }));
    return str1;
  }
  
  public String[] GetResponseHeaders(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ENV.logW("ArkApp.AndroidHTTP", "GetResponseHeaders, name is empty");
      return null;
    }
    if (this.mHttpURLConnection == null)
    {
      ENV.logW("ArkApp.AndroidHTTP", "GetResponseHeaders, mHttpURLConnection is null");
      return null;
    }
    Object localObject = this.mHttpURLConnection.getHeaderFields();
    if (localObject != null)
    {
      localObject = (List)((Map)localObject).get(paramString);
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (paramBoolean)
        {
          paramString = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(((String)((Iterator)localObject).next()).trim());
          }
        }
        localObject = new String[paramString.size()];
        paramString.toArray((Object[])localObject);
        return localObject;
      }
    }
    ENV.logI("ArkApp.AndroidHTTP", String.format("GetResponseHeaders, header not found, name=%s", new Object[] { paramString }));
    return null;
  }
  
  public int GetStatusCode()
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.mHttpURLConnection != null) {
        i = this.mHttpURLConnection.getResponseCode();
      }
      ENV.logD("ArkApp.AndroidHTTP", "StatusCode=" + i);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ENV.logE("ArkApp.AndroidHTTP", "GetStatusCode is fail and errormsg=" + localException.getMessage());
        localException.printStackTrace();
        i = j;
      }
    }
  }
  
  native void OnComplete(long paramLong, int paramInt);
  
  public void OnRequestComplete(long paramLong, int paramInt)
  {
    int j = 2;
    int i;
    if (this.mIsCanceled) {
      i = 9;
    }
    for (;;)
    {
      ENV.logI("ArkApp.AndroidHTTP", "OnRequestComplete, errorcode=" + i);
      OnComplete(paramLong, i);
      return;
      if (this.mIsTimeout)
      {
        i = 21;
      }
      else
      {
        i = j;
        if (this.mIsCompleted) {
          if (paramInt != 0)
          {
            i = paramInt;
          }
          else
          {
            i = j;
            switch (GetStatusCode())
            {
            case 0: 
            default: 
              i = 8;
              break;
            case 200: 
            case 206: 
              i = 0;
              break;
            case 304: 
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public int PostForm(String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.mFormData == null))
    {
      ENV.logE("ArkApp.AndroidHTTP", "PostForm, invalid arguments");
      return -1;
    }
    ENV.logI("ArkApp.AndroidHTTP", String.format("PostForm, URL=%s, file-path=%s", new Object[] { paramString1, paramString2 }));
    ArkAndroidHttpClientStub.FormData localFormData = this.mFormData;
    this.mFormData = null;
    httpAsynTask(paramString1, 0, null, 0, localFormData, paramString2, paramLong);
    return 0;
  }
  
  public void SetHeader(String paramString1, String paramString2)
  {
    AddCustomHeader(paramString1, paramString2);
  }
  
  public void SetTimeout(int paramInt)
  {
    this.m_option.timeoutInterval = paramInt;
    ENV.logI("ArkApp.AndroidHTTP", "SetTimeout, timeout=" + this.m_option.timeoutInterval);
  }
  
  public int UploadBuffer(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      ENV.logE("ArkApp.AndroidHTTP", "UploadBuffer, invalid arguments");
      return -1;
    }
    httpAsynTask(paramString, 0, paramArrayOfByte, paramInt, null, null, paramLong);
    return 0;
  }
  
  public int UploadBufferToFile(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfByte == null) || (TextUtils.isEmpty(paramString2)))
    {
      ENV.logE("ArkApp.AndroidHTTP", String.format("UploadBufferToFile, invalid arguments, url=%s", new Object[] { paramString1 }));
      return -1;
    }
    httpAsynTask(paramString1, 0, paramArrayOfByte, paramInt, null, paramString2, paramLong);
    return 0;
  }
  
  public void setProxyParam(String paramString, int paramInt)
  {
    this.mProxyHost = paramString;
    this.mProxyPort = paramInt;
    ENV.logD("ArkApp.AndroidHTTP", String.format("set proxy %s:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkAndroidHttpClientStub
 * JD-Core Version:    0.7.0.1
 */
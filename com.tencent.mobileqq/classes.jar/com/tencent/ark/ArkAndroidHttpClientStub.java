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
      Logger.logI("ArkApp.AndroidHTTP", "OnTimeout");
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
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (Exception paramInputStream)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeStream fail, err=");
        localStringBuilder.append(paramInputStream.getMessage());
        Logger.logI("ArkApp.AndroidHTTP", localStringBuilder.toString());
      }
    }
  }
  
  private static void closeStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.close();
        return;
      }
      catch (Exception paramOutputStream)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeStream fail, err=");
        localStringBuilder.append(paramOutputStream.getMessage());
        Logger.logI("ArkApp.AndroidHTTP", localStringBuilder.toString());
      }
    }
  }
  
  private static void closeStream(HttpURLConnection paramHttpURLConnection) {}
  
  private static long computeFormDataLength(ArkAndroidHttpClientStub.FormData paramFormData)
  {
    Iterator localIterator = paramFormData.formData.keySet().iterator();
    String str;
    for (long l1 = 0L; localIterator.hasNext(); l1 += formDataToBytes(str, (String)paramFormData.formData.get(str)).length) {
      str = (String)localIterator.next();
    }
    long l2 = l1;
    if (!TextUtils.isEmpty(paramFormData.fileName))
    {
      l2 = l1;
      if (!TextUtils.isEmpty(paramFormData.filePath))
      {
        l2 = getFileLength(paramFormData.filePath);
        Logger.logD("ArkApp.AndroidHTTP", String.format("length of form file %s is %d", new Object[] { paramFormData.filePath, Long.valueOf(l2) }));
        l2 = l1 + formFileBegin(paramFormData.fileName, paramFormData.filePath).length + l2 + FORM_DATA_END_BYTES.length;
      }
    }
    return l2 + formTailer().length;
  }
  
  private static HttpURLConnection createConnection(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        Object localObject = new URL(paramString1);
        if ((!TextUtils.isEmpty(paramString2)) && (paramInt > 0))
        {
          paramString2 = new InetSocketAddress(paramString2, paramInt);
          paramString2 = (HttpURLConnection)((URL)localObject).openConnection(new Proxy(Proxy.Type.HTTP, paramString2));
        }
        else
        {
          paramString2 = (HttpURLConnection)((URL)localObject).openConnection();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createConnection, url=");
        ((StringBuilder)localObject).append(paramString1);
        Logger.logI("ArkApp.AndroidHTTP", ((StringBuilder)localObject).toString());
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("createConnection fail, error: ");
      paramString2.append(paramString1.getMessage());
      Logger.logE("ArkApp.AndroidHTTP", paramString2.toString());
      paramString1.printStackTrace();
    }
    return null;
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
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  private static String getRedirectedURL(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    try
    {
      localObject1 = paramHttpURLConnection.getHeaderField("Location");
      paramHttpURLConnection = new URL(paramString);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramHttpURLConnection.getProtocol());
      ((StringBuilder)localObject2).append("://");
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramHttpURLConnection = (HttpURLConnection)localObject1;
        if (!((String)localObject2).equalsIgnoreCase("http://"))
        {
          paramHttpURLConnection = (HttpURLConnection)localObject1;
          if (!((String)localObject2).equalsIgnoreCase("https://"))
          {
            paramHttpURLConnection = Uri.parse(paramString).buildUpon();
            paramHttpURLConnection.appendEncodedPath((String)localObject1);
            paramHttpURLConnection = paramHttpURLConnection.toString();
          }
        }
        return paramHttpURLConnection;
      }
      return paramString;
    }
    catch (Exception paramHttpURLConnection)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRedirectedURL, fail, err=");
      ((StringBuilder)localObject1).append(paramHttpURLConnection.getMessage());
      Logger.logE("ArkApp.AndroidHTTP", ((StringBuilder)localObject1).toString());
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
    Logger.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, start, url=%s", new Object[] { paramString1 }));
    TimerTask localTimerTask = setTimer(this.m_option.timeoutInterval);
    int j = 0;
    int i = paramInt2;
    byte[] arrayOfByte = paramArrayOfByte;
    paramInt2 = j;
    while (paramInt2 < 3)
    {
      Object localObject = createConnection(paramString1, this.mProxyHost, this.mProxyPort);
      Logger.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, send request, url=%s", new Object[] { paramString1 }));
      ArkAndroidHttpClientStub.RequestOption localRequestOption = this.m_option;
      paramArrayOfByte = (byte[])localObject;
      j = sendRequest((HttpURLConnection)localObject, localRequestOption, paramInt1, arrayOfByte, i, paramFormData);
      int k = needRedirect(j);
      if (k == 0) {
        break label258;
      }
      for (;;)
      {
        if (k == 1)
        {
          arrayOfByte = null;
          paramFormData = arrayOfByte;
          i = 0;
        }
        localObject = getRedirectedURL(paramArrayOfByte, paramString1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramString1 = new StringBuilder();
        paramString1.append("invalid redirect response, url=");
        paramString1.append((String)localObject);
        Logger.logE("ArkApp.AndroidHTTP", paramString1.toString());
        paramString1 = (String)localObject;
      }
      closeStream(paramArrayOfByte);
      Logger.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, redirect, status-code=%d, type=%d, url=%s->%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), paramString1, localObject }));
      paramInt2 += 1;
      paramString1 = (String)localObject;
    }
    paramArrayOfByte = null;
    label258:
    this.mDownloadFilePath = paramString2;
    this.mHttpURLConnection = paramArrayOfByte;
    Logger.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, write response, url=%s", new Object[] { paramString1 }));
    writeResponse(paramString1, localTimerTask, paramLong, paramString2);
    Logger.logI("ArkApp.AndroidHTTP", String.format("httpExecuteTask, end, time=%d ms, url=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString1 }));
  }
  
  private int needRedirect(int paramInt)
  {
    if ((paramInt != 307) && (paramInt != 308))
    {
      if ((paramInt != 301) && (paramInt != 302) && (paramInt != 303)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  /* Error */
  private static int sendRequest(HttpURLConnection paramHttpURLConnection, ArkAndroidHttpClientStub.RequestOption paramRequestOption, int paramInt1, byte[] paramArrayOfByte, int paramInt2, ArkAndroidHttpClientStub.FormData paramFormData)
  {
    // Byte code:
    //   0: aload 5
    //   2: ifnonnull +21 -> 23
    //   5: aload_3
    //   6: ifnull +11 -> 17
    //   9: iload 4
    //   11: ifle +6 -> 17
    //   14: goto +9 -> 23
    //   17: iconst_0
    //   18: istore 6
    //   20: goto +6 -> 26
    //   23: iconst_1
    //   24: istore 6
    //   26: aconst_null
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 10
    //   32: aconst_null
    //   33: astore 11
    //   35: aload 9
    //   37: astore 7
    //   39: aload 10
    //   41: astore 8
    //   43: aload_0
    //   44: aload_1
    //   45: iload_2
    //   46: invokestatic 456	com/tencent/ark/ArkAndroidHttpClientStub:setConnectionOptions	(Ljava/net/HttpURLConnection;Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;I)V
    //   49: iload 6
    //   51: ifeq +102 -> 153
    //   54: aload 9
    //   56: astore 7
    //   58: aload 10
    //   60: astore 8
    //   62: aload_0
    //   63: iconst_1
    //   64: invokevirtual 460	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   67: aload 9
    //   69: astore 7
    //   71: aload 10
    //   73: astore 8
    //   75: aload_0
    //   76: iconst_0
    //   77: invokevirtual 463	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   80: aload 9
    //   82: astore 7
    //   84: aload 10
    //   86: astore 8
    //   88: aload_0
    //   89: ldc_w 465
    //   92: invokevirtual 468	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   95: aload 5
    //   97: ifnull +56 -> 153
    //   100: aload 9
    //   102: astore 7
    //   104: aload 10
    //   106: astore 8
    //   108: aload_0
    //   109: ldc_w 470
    //   112: ldc_w 472
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc 56
    //   123: aastore
    //   124: invokestatic 248	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokevirtual 475	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 9
    //   132: astore 7
    //   134: aload 10
    //   136: astore 8
    //   138: aload_0
    //   139: ldc_w 477
    //   142: aload 5
    //   144: invokestatic 479	com/tencent/ark/ArkAndroidHttpClientStub:computeFormDataLength	(Lcom/tencent/ark/ArkAndroidHttpClientStub$FormData;)J
    //   147: invokestatic 482	java/lang/Long:toString	(J)Ljava/lang/String;
    //   150: invokevirtual 475	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 9
    //   155: astore 7
    //   157: aload 10
    //   159: astore 8
    //   161: ldc 63
    //   163: ldc_w 484
    //   166: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 9
    //   171: astore 7
    //   173: aload 10
    //   175: astore 8
    //   177: aload_0
    //   178: invokevirtual 487	java/net/HttpURLConnection:connect	()V
    //   181: aload 9
    //   183: astore 7
    //   185: aload 10
    //   187: astore 8
    //   189: ldc 63
    //   191: ldc_w 489
    //   194: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 11
    //   199: astore_1
    //   200: iload 6
    //   202: ifeq +99 -> 301
    //   205: aload 9
    //   207: astore 7
    //   209: aload 10
    //   211: astore 8
    //   213: ldc 63
    //   215: ldc_w 491
    //   218: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 9
    //   223: astore 7
    //   225: aload 10
    //   227: astore 8
    //   229: aload_0
    //   230: invokevirtual 495	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   233: astore_1
    //   234: aload 5
    //   236: ifnull +18 -> 254
    //   239: aload_1
    //   240: astore 7
    //   242: aload_1
    //   243: astore 8
    //   245: aload_1
    //   246: aload 5
    //   248: invokestatic 499	com/tencent/ark/ArkAndroidHttpClientStub:writeFormData	(Ljava/io/OutputStream;Lcom/tencent/ark/ArkAndroidHttpClientStub$FormData;)V
    //   251: goto +26 -> 277
    //   254: aload_3
    //   255: ifnull +22 -> 277
    //   258: iload 4
    //   260: ifle +17 -> 277
    //   263: aload_1
    //   264: astore 7
    //   266: aload_1
    //   267: astore 8
    //   269: aload_1
    //   270: aload_3
    //   271: iconst_0
    //   272: iload 4
    //   274: invokevirtual 503	java/io/OutputStream:write	([BII)V
    //   277: aload_1
    //   278: astore 7
    //   280: aload_1
    //   281: astore 8
    //   283: aload_1
    //   284: invokevirtual 506	java/io/OutputStream:flush	()V
    //   287: aload_1
    //   288: astore 7
    //   290: aload_1
    //   291: astore 8
    //   293: ldc 63
    //   295: ldc_w 508
    //   298: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_1
    //   302: astore 7
    //   304: aload_1
    //   305: astore 8
    //   307: aload_0
    //   308: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   311: istore_2
    //   312: aload_1
    //   313: invokestatic 514	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   316: iload_2
    //   317: ireturn
    //   318: astore_0
    //   319: goto +61 -> 380
    //   322: astore_0
    //   323: aload 8
    //   325: astore 7
    //   327: new 162	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   334: astore_1
    //   335: aload 8
    //   337: astore 7
    //   339: aload_1
    //   340: ldc_w 516
    //   343: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 8
    //   349: astore 7
    //   351: aload_1
    //   352: aload_0
    //   353: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   356: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 8
    //   362: astore 7
    //   364: ldc 63
    //   366: aload_1
    //   367: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 297	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 8
    //   375: invokestatic 514	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   378: iconst_0
    //   379: ireturn
    //   380: aload 7
    //   382: invokestatic 514	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   385: aload_0
    //   386: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramHttpURLConnection	HttpURLConnection
    //   0	387	1	paramRequestOption	ArkAndroidHttpClientStub.RequestOption
    //   0	387	2	paramInt1	int
    //   0	387	3	paramArrayOfByte	byte[]
    //   0	387	4	paramInt2	int
    //   0	387	5	paramFormData	ArkAndroidHttpClientStub.FormData
    //   18	183	6	i	int
    //   37	344	7	localObject1	Object
    //   41	333	8	localObject2	Object
    //   27	195	9	localObject3	Object
    //   30	196	10	localObject4	Object
    //   33	165	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   43	49	318	finally
    //   62	67	318	finally
    //   75	80	318	finally
    //   88	95	318	finally
    //   108	130	318	finally
    //   138	153	318	finally
    //   161	169	318	finally
    //   177	181	318	finally
    //   189	197	318	finally
    //   213	221	318	finally
    //   229	234	318	finally
    //   245	251	318	finally
    //   269	277	318	finally
    //   283	287	318	finally
    //   293	301	318	finally
    //   307	312	318	finally
    //   327	335	318	finally
    //   339	347	318	finally
    //   351	360	318	finally
    //   364	373	318	finally
    //   43	49	322	java/lang/Exception
    //   62	67	322	java/lang/Exception
    //   75	80	322	java/lang/Exception
    //   88	95	322	java/lang/Exception
    //   108	130	322	java/lang/Exception
    //   138	153	322	java/lang/Exception
    //   161	169	322	java/lang/Exception
    //   177	181	322	java/lang/Exception
    //   189	197	322	java/lang/Exception
    //   213	221	322	java/lang/Exception
    //   229	234	322	java/lang/Exception
    //   245	251	322	java/lang/Exception
    //   269	277	322	java/lang/Exception
    //   283	287	322	java/lang/Exception
    //   293	301	322	java/lang/Exception
    //   307	312	322	java/lang/Exception
  }
  
  private static void setConnectionOptions(HttpURLConnection paramHttpURLConnection, ArkAndroidHttpClientStub.RequestOption paramRequestOption, int paramInt)
  {
    int i;
    if (paramRequestOption.timeoutInterval == 0) {
      i = 15000;
    } else {
      i = paramRequestOption.timeoutInterval;
    }
    paramHttpURLConnection.setConnectTimeout(i);
    paramHttpURLConnection.setReadTimeout(i);
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    if (paramRequestOption != null)
    {
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
      if (paramInt != 0)
      {
        paramRequestOption = timeStampToString(paramInt);
        if (!TextUtils.isEmpty(paramRequestOption))
        {
          paramHttpURLConnection.setRequestProperty("If-Modified-Since", paramRequestOption);
          Logger.logD("ArkApp.AndroidHTTP", String.format("lastModify is %s(%d)", new Object[] { paramRequestOption, Integer.valueOf(paramInt) }));
        }
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
    if (paramInt == 0) {
      return null;
    }
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = ((SimpleDateFormat)localObject1).format(Long.valueOf(paramInt * 1000L));
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return "";
    }
    try
    {
      localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
      if (localObject1 == null) {
        return null;
      }
      localObject2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
      ((DateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
      localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("timeStampToString is fail and errormsg is  ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Logger.logE("ArkApp.AndroidHTTP", ((StringBuilder)localObject2).toString());
      localException.printStackTrace();
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
      int i;
      for (long l = 0L;; l += i)
      {
        i = ((FileInputStream)localObject1).read((byte[])localObject2);
        if (i == -1)
        {
          Logger.logD("ArkApp.AndroidHTTP", String.format("writeFormData, file=%s, length=%d", new Object[] { paramFormData.filePath, Long.valueOf(l) }));
          paramOutputStream.write(FORM_DATA_END_BYTES);
          break;
        }
        paramOutputStream.write((byte[])localObject2, 0, i);
      }
    }
    paramOutputStream.write(formTailer());
  }
  
  /* Error */
  private void writeResponse(String paramString1, TimerTask paramTimerTask, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aload 5
    //   2: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5: ifne +17 -> 22
    //   8: new 630	java/io/FileOutputStream
    //   11: dup
    //   12: aload 5
    //   14: invokespecial 631	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: goto +12 -> 31
    //   22: new 633	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 634	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 444	com/tencent/ark/ArkAndroidHttpClientStub:mHttpURLConnection	Ljava/net/HttpURLConnection;
    //   35: ifnull +420 -> 455
    //   38: new 636	java/io/BufferedInputStream
    //   41: dup
    //   42: aload_0
    //   43: getfield 444	com/tencent/ark/ArkAndroidHttpClientStub:mHttpURLConnection	Ljava/net/HttpURLConnection;
    //   46: invokevirtual 640	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   49: invokespecial 642	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore 8
    //   54: aload 8
    //   56: astore 9
    //   58: aload 5
    //   60: astore 10
    //   62: ldc 37
    //   64: newarray byte
    //   66: astore 11
    //   68: iconst_0
    //   69: istore 6
    //   71: aload 8
    //   73: astore 9
    //   75: aload 5
    //   77: astore 10
    //   79: aload_0
    //   80: getfield 644	com/tencent/ark/ArkAndroidHttpClientStub:mIsCanceled	Z
    //   83: ifeq +73 -> 156
    //   86: aload 8
    //   88: astore 9
    //   90: aload 5
    //   92: astore 10
    //   94: new 162	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   101: astore 11
    //   103: aload 8
    //   105: astore 9
    //   107: aload 5
    //   109: astore 10
    //   111: aload 11
    //   113: ldc_w 646
    //   116: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 8
    //   122: astore 9
    //   124: aload 5
    //   126: astore 10
    //   128: aload 11
    //   130: aload_1
    //   131: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 8
    //   137: astore 9
    //   139: aload 5
    //   141: astore 10
    //   143: ldc 63
    //   145: aload 11
    //   147: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto +111 -> 264
    //   156: aload 8
    //   158: astore 9
    //   160: aload 5
    //   162: astore 10
    //   164: aload_0
    //   165: getfield 133	com/tencent/ark/ArkAndroidHttpClientStub:mIsTimeout	Z
    //   168: ifeq +73 -> 241
    //   171: aload 8
    //   173: astore 9
    //   175: aload 5
    //   177: astore 10
    //   179: new 162	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   186: astore 11
    //   188: aload 8
    //   190: astore 9
    //   192: aload 5
    //   194: astore 10
    //   196: aload 11
    //   198: ldc_w 648
    //   201: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 8
    //   207: astore 9
    //   209: aload 5
    //   211: astore 10
    //   213: aload 11
    //   215: aload_1
    //   216: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 8
    //   222: astore 9
    //   224: aload 5
    //   226: astore 10
    //   228: ldc 63
    //   230: aload 11
    //   232: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto +26 -> 264
    //   241: aload 8
    //   243: astore 9
    //   245: aload 5
    //   247: astore 10
    //   249: aload 8
    //   251: aload 11
    //   253: invokevirtual 649	java/io/InputStream:read	([B)I
    //   256: istore 7
    //   258: iload 7
    //   260: iconst_m1
    //   261: if_icmpne +156 -> 417
    //   264: aload 8
    //   266: astore 9
    //   268: aload 5
    //   270: astore 10
    //   272: aload 5
    //   274: instanceof 633
    //   277: ifeq +23 -> 300
    //   280: aload 8
    //   282: astore 9
    //   284: aload 5
    //   286: astore 10
    //   288: aload_0
    //   289: aload 5
    //   291: checkcast 633	java/io/ByteArrayOutputStream
    //   294: invokevirtual 652	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   297: putfield 654	com/tencent/ark/ArkAndroidHttpClientStub:mResponseBody	[B
    //   300: aload 8
    //   302: astore 9
    //   304: aload 5
    //   306: astore 10
    //   308: new 162	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   315: astore 11
    //   317: aload 8
    //   319: astore 9
    //   321: aload 5
    //   323: astore 10
    //   325: aload 11
    //   327: ldc_w 656
    //   330: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 8
    //   336: astore 9
    //   338: aload 5
    //   340: astore 10
    //   342: aload 11
    //   344: iload 6
    //   346: invokevirtual 659	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 8
    //   352: astore 9
    //   354: aload 5
    //   356: astore 10
    //   358: aload 11
    //   360: ldc_w 661
    //   363: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 8
    //   369: astore 9
    //   371: aload 5
    //   373: astore 10
    //   375: aload 11
    //   377: aload_1
    //   378: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 8
    //   384: astore 9
    //   386: aload 5
    //   388: astore 10
    //   390: ldc 63
    //   392: aload 11
    //   394: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 131	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_2
    //   401: invokestatic 663	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   404: aload_0
    //   405: invokespecial 665	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   408: aload_0
    //   409: lload_3
    //   410: iconst_0
    //   411: invokevirtual 669	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   414: goto +334 -> 748
    //   417: aload 8
    //   419: astore 9
    //   421: aload 5
    //   423: astore 10
    //   425: aload 5
    //   427: aload 11
    //   429: iconst_0
    //   430: iload 7
    //   432: invokevirtual 503	java/io/OutputStream:write	([BII)V
    //   435: iload 6
    //   437: iload 7
    //   439: iadd
    //   440: istore 6
    //   442: goto -371 -> 71
    //   445: astore 11
    //   447: goto +70 -> 517
    //   450: astore 11
    //   452: goto +174 -> 626
    //   455: ldc 63
    //   457: ldc_w 671
    //   460: invokestatic 297	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: new 155	java/lang/Exception
    //   466: dup
    //   467: ldc_w 673
    //   470: invokespecial 674	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   473: athrow
    //   474: astore_1
    //   475: aconst_null
    //   476: astore 9
    //   478: goto +286 -> 764
    //   481: astore 11
    //   483: aconst_null
    //   484: astore 8
    //   486: goto +31 -> 517
    //   489: astore 11
    //   491: aconst_null
    //   492: astore 8
    //   494: goto +132 -> 626
    //   497: astore_1
    //   498: aconst_null
    //   499: astore 5
    //   501: aload 5
    //   503: astore 9
    //   505: goto +259 -> 764
    //   508: astore 11
    //   510: aconst_null
    //   511: astore 8
    //   513: aload 8
    //   515: astore 5
    //   517: aload 8
    //   519: astore 9
    //   521: aload 5
    //   523: astore 10
    //   525: new 162	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   532: astore 12
    //   534: aload 8
    //   536: astore 9
    //   538: aload 5
    //   540: astore 10
    //   542: aload 12
    //   544: ldc_w 676
    //   547: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 8
    //   553: astore 9
    //   555: aload 5
    //   557: astore 10
    //   559: aload 12
    //   561: aload_1
    //   562: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 8
    //   568: astore 9
    //   570: aload 5
    //   572: astore 10
    //   574: aload 12
    //   576: ldc_w 678
    //   579: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 8
    //   585: astore 9
    //   587: aload 5
    //   589: astore 10
    //   591: aload 12
    //   593: aload 11
    //   595: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 8
    //   604: astore 9
    //   606: aload 5
    //   608: astore 10
    //   610: ldc 63
    //   612: aload 12
    //   614: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 297	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: iconst_5
    //   621: istore 6
    //   623: goto +110 -> 733
    //   626: aload 8
    //   628: astore 9
    //   630: aload 5
    //   632: astore 10
    //   634: new 162	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   641: astore 12
    //   643: aload 8
    //   645: astore 9
    //   647: aload 5
    //   649: astore 10
    //   651: aload 12
    //   653: ldc_w 676
    //   656: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 8
    //   662: astore 9
    //   664: aload 5
    //   666: astore 10
    //   668: aload 12
    //   670: aload_1
    //   671: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 8
    //   677: astore 9
    //   679: aload 5
    //   681: astore 10
    //   683: aload 12
    //   685: ldc_w 678
    //   688: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload 8
    //   694: astore 9
    //   696: aload 5
    //   698: astore 10
    //   700: aload 12
    //   702: aload 11
    //   704: invokevirtual 679	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   707: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 8
    //   713: astore 9
    //   715: aload 5
    //   717: astore 10
    //   719: ldc 63
    //   721: aload 12
    //   723: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 297	com/tencent/ark/Logger:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   729: bipush 22
    //   731: istore 6
    //   733: aload_2
    //   734: invokestatic 663	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   737: aload_0
    //   738: invokespecial 665	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   741: aload_0
    //   742: lload_3
    //   743: iload 6
    //   745: invokevirtual 669	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   748: aload 8
    //   750: invokestatic 681	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/InputStream;)V
    //   753: aload 5
    //   755: invokestatic 514	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   758: return
    //   759: astore_1
    //   760: aload 10
    //   762: astore 5
    //   764: aload_2
    //   765: invokestatic 663	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   768: aload_0
    //   769: invokespecial 665	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   772: aload_0
    //   773: lload_3
    //   774: iconst_0
    //   775: invokevirtual 669	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(JI)V
    //   778: aload 9
    //   780: invokestatic 681	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/InputStream;)V
    //   783: aload 5
    //   785: invokestatic 514	com/tencent/ark/ArkAndroidHttpClientStub:closeStream	(Ljava/io/OutputStream;)V
    //   788: goto +5 -> 793
    //   791: aload_1
    //   792: athrow
    //   793: goto -2 -> 791
    //   796: astore 11
    //   798: aconst_null
    //   799: astore 8
    //   801: aload 8
    //   803: astore 5
    //   805: goto -179 -> 626
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	ArkAndroidHttpClientStub
    //   0	808	1	paramString1	String
    //   0	808	2	paramTimerTask	TimerTask
    //   0	808	3	paramLong	long
    //   0	808	5	paramString2	String
    //   69	675	6	i	int
    //   256	184	7	j	int
    //   52	750	8	localBufferedInputStream	java.io.BufferedInputStream
    //   56	723	9	localObject1	Object
    //   60	701	10	str	String
    //   66	362	11	localObject2	Object
    //   445	1	11	localException1	Exception
    //   450	1	11	localUnknownHostException1	java.net.UnknownHostException
    //   481	1	11	localException2	Exception
    //   489	1	11	localUnknownHostException2	java.net.UnknownHostException
    //   508	195	11	localException3	Exception
    //   796	1	11	localUnknownHostException3	java.net.UnknownHostException
    //   532	190	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	68	445	java/lang/Exception
    //   79	86	445	java/lang/Exception
    //   94	103	445	java/lang/Exception
    //   111	120	445	java/lang/Exception
    //   128	135	445	java/lang/Exception
    //   143	153	445	java/lang/Exception
    //   164	171	445	java/lang/Exception
    //   179	188	445	java/lang/Exception
    //   196	205	445	java/lang/Exception
    //   213	220	445	java/lang/Exception
    //   228	238	445	java/lang/Exception
    //   249	258	445	java/lang/Exception
    //   272	280	445	java/lang/Exception
    //   288	300	445	java/lang/Exception
    //   308	317	445	java/lang/Exception
    //   325	334	445	java/lang/Exception
    //   342	350	445	java/lang/Exception
    //   358	367	445	java/lang/Exception
    //   375	382	445	java/lang/Exception
    //   390	400	445	java/lang/Exception
    //   425	435	445	java/lang/Exception
    //   62	68	450	java/net/UnknownHostException
    //   79	86	450	java/net/UnknownHostException
    //   94	103	450	java/net/UnknownHostException
    //   111	120	450	java/net/UnknownHostException
    //   128	135	450	java/net/UnknownHostException
    //   143	153	450	java/net/UnknownHostException
    //   164	171	450	java/net/UnknownHostException
    //   179	188	450	java/net/UnknownHostException
    //   196	205	450	java/net/UnknownHostException
    //   213	220	450	java/net/UnknownHostException
    //   228	238	450	java/net/UnknownHostException
    //   249	258	450	java/net/UnknownHostException
    //   272	280	450	java/net/UnknownHostException
    //   288	300	450	java/net/UnknownHostException
    //   308	317	450	java/net/UnknownHostException
    //   325	334	450	java/net/UnknownHostException
    //   342	350	450	java/net/UnknownHostException
    //   358	367	450	java/net/UnknownHostException
    //   375	382	450	java/net/UnknownHostException
    //   390	400	450	java/net/UnknownHostException
    //   425	435	450	java/net/UnknownHostException
    //   31	54	474	finally
    //   455	474	474	finally
    //   31	54	481	java/lang/Exception
    //   455	474	481	java/lang/Exception
    //   31	54	489	java/net/UnknownHostException
    //   455	474	489	java/net/UnknownHostException
    //   0	19	497	finally
    //   22	31	497	finally
    //   0	19	508	java/lang/Exception
    //   22	31	508	java/lang/Exception
    //   62	68	759	finally
    //   79	86	759	finally
    //   94	103	759	finally
    //   111	120	759	finally
    //   128	135	759	finally
    //   143	153	759	finally
    //   164	171	759	finally
    //   179	188	759	finally
    //   196	205	759	finally
    //   213	220	759	finally
    //   228	238	759	finally
    //   249	258	759	finally
    //   272	280	759	finally
    //   288	300	759	finally
    //   308	317	759	finally
    //   325	334	759	finally
    //   342	350	759	finally
    //   358	367	759	finally
    //   375	382	759	finally
    //   390	400	759	finally
    //   425	435	759	finally
    //   525	534	759	finally
    //   542	551	759	finally
    //   559	566	759	finally
    //   574	583	759	finally
    //   591	602	759	finally
    //   610	620	759	finally
    //   634	643	759	finally
    //   651	660	759	finally
    //   668	675	759	finally
    //   683	692	759	finally
    //   700	711	759	finally
    //   719	729	759	finally
    //   0	19	796	java/net/UnknownHostException
    //   22	31	796	java/net/UnknownHostException
  }
  
  public void AddCookie(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.m_option.cookie = paramString;
    } else {
      this.m_option.cookie = "";
    }
    paramString = new StringBuilder();
    paramString.append("AddCookie, cookie=");
    paramString.append(this.m_option.cookie);
    Logger.logI("ArkApp.AndroidHTTP", paramString.toString());
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
    paramString2 = new StringBuilder();
    paramString2.append("AddCustomHeader, ");
    paramString2.append(paramString1);
    paramString2.append("=");
    paramString2.append(str);
    Logger.logD("ArkApp.AndroidHTTP", paramString2.toString());
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (this.mFormData == null) {
        this.mFormData = new ArkAndroidHttpClientStub.FormData(null);
      }
      ArkAndroidHttpClientStub.FormData localFormData = this.mFormData;
      localFormData.fileName = paramString1;
      localFormData.filePath = paramString2;
    }
  }
  
  public void Cancel()
  {
    try
    {
      if (this.mIsCompleted) {
        return;
      }
      Logger.logI("ArkApp.AndroidHTTP", "Cancel");
      this.mIsCanceled = true;
      return;
    }
    finally {}
  }
  
  public int DownloadToBuffer(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.logE("ArkApp.AndroidHTTP", "DownloadToBuffer, url is empty");
      return -1;
    }
    httpAsynTask(paramString, paramInt, null, 0, null, null, paramLong);
    return 0;
  }
  
  public int DownloadToFile(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      httpAsynTask(paramString1, paramInt, null, 0, null, paramString2, paramLong);
      return 0;
    }
    Logger.logE("ArkApp.AndroidHTTP", "DownloadToFile, url or filepath is empty");
    return -1;
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
      Logger.logI("ArkApp.AndroidHTTP", "GetDownloadBuffer, responseBody is null");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetDownloadBuffer, length=");
    localStringBuilder.append(this.mResponseBody.length);
    Logger.logD("ArkApp.AndroidHTTP", localStringBuilder.toString());
    return this.mResponseBody;
  }
  
  public String GetDownloadFilePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetDownloadFilePath, path=");
    localStringBuilder.append(this.mDownloadFilePath);
    Logger.logD("ArkApp.AndroidHTTP", localStringBuilder.toString());
    return this.mDownloadFilePath;
  }
  
  public String GetFinalURL()
  {
    if (this.mHttpURLConnection == null)
    {
      Logger.logE("ArkApp.AndroidHTTP", "FinalURL is empty");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FinalURL=");
    localStringBuilder.append(this.mHttpURLConnection.getURL().toString());
    Logger.logD("ArkApp.AndroidHTTP", localStringBuilder.toString());
    return this.mHttpURLConnection.getURL().toString();
  }
  
  public int GetLastModifyTime()
  {
    if (this.mHttpURLConnection != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LastModifyTime=");
      localStringBuilder.append((int)(this.mHttpURLConnection.getLastModified() / 1000L));
      Logger.logD("ArkApp.AndroidHTTP", localStringBuilder.toString());
      return (int)(this.mHttpURLConnection.getLastModified() / 1000L);
    }
    return 0;
  }
  
  public int GetMaxAge()
  {
    Object localObject1 = GetResponseHeader("Cache-Control", true);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    int j = 0;
    if (bool) {
      return 0;
    }
    Object localObject2 = ((String)localObject1).toLowerCase();
    int i = j;
    if (((String)localObject2).contains("max-age="))
    {
      localObject2 = Pattern.compile("max-age=[0-9]*").matcher((CharSequence)localObject2);
      i = j;
      if (((Matcher)localObject2).find()) {
        localObject2 = ((Matcher)localObject2).group(0);
      }
    }
    try
    {
      i = Integer.parseInt(((String)localObject2).replace("max-age=", ""));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label93:
      break label93;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("GetMaxAge, invalid max-age, ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Logger.logI("ArkApp.AndroidHTTP", ((StringBuilder)localObject2).toString());
    i = j;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("GetMaxAge, max-age=");
    ((StringBuilder)localObject1).append(i);
    Logger.logD("ArkApp.AndroidHTTP", ((StringBuilder)localObject1).toString());
    return i;
  }
  
  public String GetResponseHeader(String paramString, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject3 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = this.mHttpURLConnection;
    if (localObject2 != null) {
      try
      {
        localObject1 = ((HttpURLConnection)localObject2).getHeaderField(paramString);
        if ((localObject1 != null) && (paramBoolean)) {
          try
          {
            localObject2 = ((String)localObject1).trim();
            localObject1 = localObject2;
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        localObject1 = localObject3;
        Logger.logW("ArkApp.AndroidHTTP", String.format("GetResponseHeader, exception=%s", new Object[] { localException2.toString() }));
      }
    }
    Logger.logD("ArkApp.AndroidHTTP", String.format("GetResponseHeader, %s=%s", new Object[] { paramString, localObject1 }));
    return localObject1;
  }
  
  public String[] GetResponseHeaders(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.logW("ArkApp.AndroidHTTP", "GetResponseHeaders, name is empty");
      return null;
    }
    Object localObject1 = this.mHttpURLConnection;
    if (localObject1 == null)
    {
      Logger.logW("ArkApp.AndroidHTTP", "GetResponseHeaders, mHttpURLConnection is null");
      return null;
    }
    localObject1 = ((HttpURLConnection)localObject1).getHeaderFields();
    if (localObject1 != null)
    {
      Object localObject2 = (List)((Map)localObject1).get(paramString);
      if (localObject2 != null)
      {
        if (paramBoolean)
        {
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            paramString = (String)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            ((ArrayList)localObject1).add(((String)((Iterator)localObject2).next()).trim());
          }
        }
        paramString = (String)localObject2;
        localObject1 = new String[paramString.size()];
        paramString.toArray((Object[])localObject1);
        return localObject1;
      }
    }
    Logger.logI("ArkApp.AndroidHTTP", String.format("GetResponseHeaders, header not found, name=%s", new Object[] { paramString }));
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
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("GetStatusCode is fail and errormsg=");
      localStringBuilder2.append(localException.getMessage());
      Logger.logE("ArkApp.AndroidHTTP", localStringBuilder2.toString());
      localException.printStackTrace();
      i = j;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("StatusCode=");
    localStringBuilder1.append(i);
    Logger.logD("ArkApp.AndroidHTTP", localStringBuilder1.toString());
    return i;
  }
  
  native void OnComplete(long paramLong, int paramInt);
  
  public void OnRequestComplete(long paramLong, int paramInt)
  {
    if (this.mIsCanceled)
    {
      paramInt = 9;
    }
    else if (this.mIsTimeout)
    {
      paramInt = 21;
    }
    else
    {
      if (this.mIsCompleted)
      {
        if (paramInt != 0) {
          break label88;
        }
        paramInt = GetStatusCode();
        if (paramInt != 0)
        {
          if ((paramInt != 200) && (paramInt != 206))
          {
            if (paramInt != 304)
            {
              paramInt = 8;
              break label88;
            }
            paramInt = 1;
            break label88;
          }
          paramInt = 0;
          break label88;
        }
      }
      paramInt = 2;
    }
    label88:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnRequestComplete, errorcode=");
    localStringBuilder.append(paramInt);
    Logger.logI("ArkApp.AndroidHTTP", localStringBuilder.toString());
    OnComplete(paramLong, paramInt);
  }
  
  public int PostForm(String paramString1, String paramString2, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.mFormData != null))
    {
      Logger.logI("ArkApp.AndroidHTTP", String.format("PostForm, URL=%s, file-path=%s", new Object[] { paramString1, paramString2 }));
      ArkAndroidHttpClientStub.FormData localFormData = this.mFormData;
      this.mFormData = null;
      httpAsynTask(paramString1, 0, null, 0, localFormData, paramString2, paramLong);
      return 0;
    }
    Logger.logE("ArkApp.AndroidHTTP", "PostForm, invalid arguments");
    return -1;
  }
  
  public void SetHeader(String paramString1, String paramString2)
  {
    AddCustomHeader(paramString1, paramString2);
  }
  
  public void SetTimeout(int paramInt)
  {
    this.m_option.timeoutInterval = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SetTimeout, timeout=");
    localStringBuilder.append(this.m_option.timeoutInterval);
    Logger.logI("ArkApp.AndroidHTTP", localStringBuilder.toString());
  }
  
  public int UploadBuffer(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      httpAsynTask(paramString, 0, paramArrayOfByte, paramInt, null, null, paramLong);
      return 0;
    }
    Logger.logE("ArkApp.AndroidHTTP", "UploadBuffer, invalid arguments");
    return -1;
  }
  
  public int UploadBufferToFile(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramArrayOfByte != null) && (!TextUtils.isEmpty(paramString2)))
    {
      httpAsynTask(paramString1, 0, paramArrayOfByte, paramInt, null, paramString2, paramLong);
      return 0;
    }
    Logger.logE("ArkApp.AndroidHTTP", String.format("UploadBufferToFile, invalid arguments, url=%s", new Object[] { paramString1 }));
    return -1;
  }
  
  public void setProxyParam(String paramString, int paramInt)
  {
    this.mProxyHost = paramString;
    this.mProxyPort = paramInt;
    Logger.logD("ArkApp.AndroidHTTP", String.format("set proxy %s:%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkAndroidHttpClientStub
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ark;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
  protected static final ArkEnvironmentManager ENV = ;
  public static final int REDIRECT_MAX_COUNT = 3;
  private static final String TAG = "ArkAndroidHttpLog";
  private static final int defaultTimeout = 3000;
  static ExecutorService executorService = Executors.newFixedThreadPool(10);
  public static String proxyHost;
  public static int proxyPort;
  static Timer timer = new Timer();
  private HttpURLConnection httpURLConnection;
  private boolean isCanceled;
  private boolean isCompleted;
  private boolean isTimeOut;
  private boolean isTimerCanceld;
  RequestOption m_option;
  private int timeout;
  
  private void OnTimeout()
  {
    try
    {
      if (this.isCompleted) {
        return;
      }
      ENV.logD("ArkAndroidHttpLog", "Cancel is success");
      this.isTimeOut = true;
      return;
    }
    finally {}
  }
  
  private void cancelTimer(TimerTask paramTimerTask)
  {
    if (paramTimerTask != null)
    {
      paramTimerTask.cancel();
      try
      {
        this.isTimerCanceld = true;
        return;
      }
      finally {}
    }
  }
  
  private String getRealUrl(String paramString)
  {
    try
    {
      String str1 = this.httpURLConnection.getHeaderField("Location");
      Object localObject = new URL(paramString);
      String str2 = ((URL)localObject).getProtocol() + "://";
      localObject = paramString;
      if (!isEmpty(str1))
      {
        localObject = str1;
        if (!str2.equalsIgnoreCase("http://"))
        {
          localObject = str1;
          if (!str2.equalsIgnoreCase("https://"))
          {
            localObject = Uri.parse(paramString).buildUpon();
            ((Uri.Builder)localObject).appendEncodedPath(str1);
            localObject = ((Uri.Builder)localObject).toString();
          }
        }
        ENV.logD("ArkAndroidHttpLog", "need jump redirect and location " + (String)localObject);
      }
      return localObject;
    }
    catch (Exception localException)
    {
      ENV.logE("ArkAndroidHttpLog", "initURLConnection fail and errormessage=" + localException.getMessage());
    }
    return paramString;
  }
  
  private void httpAsynTask(final String paramString1, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2, final String paramString2, final long paramLong, boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    paramString1 = new Runnable()
    {
      public void run()
      {
        ArkAndroidHttpClientStub.this.httpExecuteTask(paramString1, paramInt1, paramArrayOfByte, paramInt2, paramString2, paramLong, paramBoolean2, paramBoolean3, paramBoolean4, this.val$isUploadFile);
      }
    };
    executorService.execute(paramString1);
  }
  
  private boolean needRedirect(int paramInt)
  {
    return (paramInt == 301) || (paramInt == 302) || (paramInt == 307);
  }
  
  private void setFlagComplete()
  {
    try
    {
      this.isCompleted = true;
      return;
    }
    finally {}
  }
  
  /* Error */
  private void setHttpParams(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 8
    //   12: aload 8
    //   14: astore 7
    //   16: aload 9
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   24: sipush 3000
    //   27: invokevirtual 217	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload 8
    //   32: astore 7
    //   34: aload 9
    //   36: astore 6
    //   38: aload_0
    //   39: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   42: sipush 3000
    //   45: invokevirtual 220	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   48: aload 8
    //   50: astore 7
    //   52: aload 9
    //   54: astore 6
    //   56: aload_0
    //   57: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   60: iconst_1
    //   61: invokevirtual 224	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   64: aload 8
    //   66: astore 7
    //   68: aload 9
    //   70: astore 6
    //   72: aload_0
    //   73: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   76: ifnull +340 -> 416
    //   79: aload 8
    //   81: astore 7
    //   83: aload 9
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   91: ifnull +325 -> 416
    //   94: aload 8
    //   96: astore 7
    //   98: aload 9
    //   100: astore 6
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   107: getfield 229	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:cookie	Ljava/lang/String;
    //   110: invokevirtual 160	com/tencent/ark/ArkAndroidHttpClientStub:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +44 -> 157
    //   116: aload 8
    //   118: astore 7
    //   120: aload 9
    //   122: astore 6
    //   124: aload_0
    //   125: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   128: ldc 231
    //   130: aload_0
    //   131: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   134: getfield 229	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:cookie	Ljava/lang/String;
    //   137: invokevirtual 234	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 8
    //   142: astore 7
    //   144: aload 9
    //   146: astore 6
    //   148: aload_0
    //   149: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   152: ldc 236
    //   154: putfield 229	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:cookie	Ljava/lang/String;
    //   157: aload 8
    //   159: astore 7
    //   161: aload 9
    //   163: astore 6
    //   165: aload_0
    //   166: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   169: getfield 240	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:customHeader	Ljava/util/List;
    //   172: ifnull +189 -> 361
    //   175: aload 8
    //   177: astore 7
    //   179: aload 9
    //   181: astore 6
    //   183: aload_0
    //   184: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   187: getfield 240	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:customHeader	Ljava/util/List;
    //   190: invokeinterface 246 1 0
    //   195: astore 11
    //   197: aload 8
    //   199: astore 7
    //   201: aload 9
    //   203: astore 6
    //   205: aload 11
    //   207: invokeinterface 251 1 0
    //   212: ifeq +129 -> 341
    //   215: aload 8
    //   217: astore 7
    //   219: aload 9
    //   221: astore 6
    //   223: aload 11
    //   225: invokeinterface 255 1 0
    //   230: checkcast 10	com/tencent/ark/ArkAndroidHttpClientStub$Header
    //   233: astore 12
    //   235: aload 8
    //   237: astore 7
    //   239: aload 9
    //   241: astore 6
    //   243: aload_0
    //   244: aload 12
    //   246: getfield 258	com/tencent/ark/ArkAndroidHttpClientStub$Header:name	Ljava/lang/String;
    //   249: invokevirtual 160	com/tencent/ark/ArkAndroidHttpClientStub:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifne -55 -> 197
    //   255: aload 8
    //   257: astore 7
    //   259: aload 9
    //   261: astore 6
    //   263: aload_0
    //   264: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   267: aload 12
    //   269: getfield 258	com/tencent/ark/ArkAndroidHttpClientStub$Header:name	Ljava/lang/String;
    //   272: aload 12
    //   274: getfield 261	com/tencent/ark/ArkAndroidHttpClientStub$Header:value	Ljava/lang/String;
    //   277: invokevirtual 264	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: goto -83 -> 197
    //   283: astore_2
    //   284: aload 7
    //   286: astore 6
    //   288: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   291: ldc 52
    //   293: new 142	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 266
    //   303: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_2
    //   307: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 7
    //   321: ifnull +19 -> 340
    //   324: aload 7
    //   326: invokevirtual 271	java/io/OutputStream:close	()V
    //   329: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   332: ldc 52
    //   334: ldc_w 273
    //   337: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: return
    //   341: aload 8
    //   343: astore 7
    //   345: aload 9
    //   347: astore 6
    //   349: aload_0
    //   350: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   353: getfield 240	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:customHeader	Ljava/util/List;
    //   356: invokeinterface 276 1 0
    //   361: iload 4
    //   363: ifeq +180 -> 543
    //   366: aload 8
    //   368: astore 7
    //   370: aload 9
    //   372: astore 6
    //   374: aload_0
    //   375: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   378: iconst_1
    //   379: invokevirtual 279	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   382: aload 8
    //   384: astore 7
    //   386: aload 9
    //   388: astore 6
    //   390: aload_0
    //   391: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   394: iconst_0
    //   395: invokevirtual 282	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   398: aload 8
    //   400: astore 7
    //   402: aload 9
    //   404: astore 6
    //   406: aload_0
    //   407: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   410: ldc_w 284
    //   413: invokevirtual 287	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   416: aload 8
    //   418: astore 7
    //   420: aload 9
    //   422: astore 6
    //   424: aload_0
    //   425: monitorenter
    //   426: aload_0
    //   427: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   430: invokevirtual 290	java/net/HttpURLConnection:connect	()V
    //   433: aload_0
    //   434: monitorexit
    //   435: iload 4
    //   437: ifeq +233 -> 670
    //   440: aload 8
    //   442: astore 7
    //   444: aload 10
    //   446: astore 5
    //   448: aload 9
    //   450: astore 6
    //   452: aload_0
    //   453: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   456: invokevirtual 294	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   459: ifnull +20 -> 479
    //   462: aload 8
    //   464: astore 7
    //   466: aload 9
    //   468: astore 6
    //   470: aload_0
    //   471: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   474: invokevirtual 294	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   477: astore 5
    //   479: aload 5
    //   481: ifnonnull +141 -> 622
    //   484: aload 5
    //   486: astore 7
    //   488: aload 5
    //   490: astore 6
    //   492: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   495: ldc 52
    //   497: ldc_w 296
    //   500: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload 5
    //   505: astore 7
    //   507: aload 5
    //   509: astore 6
    //   511: new 126	java/lang/Exception
    //   514: dup
    //   515: invokespecial 297	java/lang/Exception:<init>	()V
    //   518: athrow
    //   519: astore_2
    //   520: aload 6
    //   522: ifnull +19 -> 541
    //   525: aload 6
    //   527: invokevirtual 271	java/io/OutputStream:close	()V
    //   530: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   533: ldc 52
    //   535: ldc_w 273
    //   538: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: aload_2
    //   542: athrow
    //   543: iload_1
    //   544: ifeq -128 -> 416
    //   547: aload 8
    //   549: astore 7
    //   551: aload 9
    //   553: astore 6
    //   555: aload_0
    //   556: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   559: ldc_w 299
    //   562: aload_0
    //   563: iload_1
    //   564: invokevirtual 303	com/tencent/ark/ArkAndroidHttpClientStub:timeStampToString	(I)Ljava/lang/String;
    //   567: invokevirtual 234	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload 8
    //   572: astore 7
    //   574: aload 9
    //   576: astore 6
    //   578: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   581: ldc 52
    //   583: new 142	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 305
    //   593: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: iload_1
    //   597: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: goto -190 -> 416
    //   609: astore_2
    //   610: aload_0
    //   611: monitorexit
    //   612: aload 8
    //   614: astore 7
    //   616: aload 9
    //   618: astore 6
    //   620: aload_2
    //   621: athrow
    //   622: aload 5
    //   624: astore 7
    //   626: aload 5
    //   628: astore 6
    //   630: aload 5
    //   632: aload_2
    //   633: iconst_0
    //   634: iload_3
    //   635: invokevirtual 312	java/io/OutputStream:write	([BII)V
    //   638: aload 5
    //   640: astore 7
    //   642: aload 5
    //   644: astore 6
    //   646: aload 5
    //   648: invokevirtual 315	java/io/OutputStream:flush	()V
    //   651: aload 5
    //   653: astore 7
    //   655: aload 5
    //   657: astore 6
    //   659: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   662: ldc 52
    //   664: ldc_w 317
    //   667: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: aload 5
    //   672: ifnull -332 -> 340
    //   675: aload 5
    //   677: invokevirtual 271	java/io/OutputStream:close	()V
    //   680: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   683: ldc 52
    //   685: ldc_w 273
    //   688: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: return
    //   692: astore_2
    //   693: aload_2
    //   694: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   697: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   700: ldc 52
    //   702: new 142	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   709: ldc_w 322
    //   712: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_2
    //   716: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   719: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   728: return
    //   729: astore_2
    //   730: aload_2
    //   731: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   734: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   737: ldc 52
    //   739: new 142	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 322
    //   749: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_2
    //   753: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   756: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   765: return
    //   766: astore 5
    //   768: aload 5
    //   770: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   773: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   776: ldc 52
    //   778: new 142	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   785: ldc_w 322
    //   788: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: aload 5
    //   793: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   796: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: goto -264 -> 541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	ArkAndroidHttpClientStub
    //   0	808	1	paramInt1	int
    //   0	808	2	paramArrayOfByte	byte[]
    //   0	808	3	paramInt2	int
    //   0	808	4	paramBoolean	boolean
    //   7	669	5	localObject1	Object
    //   766	26	5	localException	Exception
    //   18	640	6	localObject2	Object
    //   14	640	7	localObject3	Object
    //   10	603	8	localObject4	Object
    //   4	613	9	localObject5	Object
    //   1	444	10	localObject6	Object
    //   195	29	11	localIterator	java.util.Iterator
    //   233	40	12	localHeader	Header
    // Exception table:
    //   from	to	target	type
    //   20	30	283	java/lang/Exception
    //   38	48	283	java/lang/Exception
    //   56	64	283	java/lang/Exception
    //   72	79	283	java/lang/Exception
    //   87	94	283	java/lang/Exception
    //   102	116	283	java/lang/Exception
    //   124	140	283	java/lang/Exception
    //   148	157	283	java/lang/Exception
    //   165	175	283	java/lang/Exception
    //   183	197	283	java/lang/Exception
    //   205	215	283	java/lang/Exception
    //   223	235	283	java/lang/Exception
    //   243	255	283	java/lang/Exception
    //   263	280	283	java/lang/Exception
    //   349	361	283	java/lang/Exception
    //   374	382	283	java/lang/Exception
    //   390	398	283	java/lang/Exception
    //   406	416	283	java/lang/Exception
    //   424	426	283	java/lang/Exception
    //   452	462	283	java/lang/Exception
    //   470	479	283	java/lang/Exception
    //   492	503	283	java/lang/Exception
    //   511	519	283	java/lang/Exception
    //   555	570	283	java/lang/Exception
    //   578	606	283	java/lang/Exception
    //   620	622	283	java/lang/Exception
    //   630	638	283	java/lang/Exception
    //   646	651	283	java/lang/Exception
    //   659	670	283	java/lang/Exception
    //   20	30	519	finally
    //   38	48	519	finally
    //   56	64	519	finally
    //   72	79	519	finally
    //   87	94	519	finally
    //   102	116	519	finally
    //   124	140	519	finally
    //   148	157	519	finally
    //   165	175	519	finally
    //   183	197	519	finally
    //   205	215	519	finally
    //   223	235	519	finally
    //   243	255	519	finally
    //   263	280	519	finally
    //   288	319	519	finally
    //   349	361	519	finally
    //   374	382	519	finally
    //   390	398	519	finally
    //   406	416	519	finally
    //   424	426	519	finally
    //   452	462	519	finally
    //   470	479	519	finally
    //   492	503	519	finally
    //   511	519	519	finally
    //   555	570	519	finally
    //   578	606	519	finally
    //   620	622	519	finally
    //   630	638	519	finally
    //   646	651	519	finally
    //   659	670	519	finally
    //   426	435	609	finally
    //   610	612	609	finally
    //   675	691	692	java/lang/Exception
    //   324	340	729	java/lang/Exception
    //   525	541	766	java/lang/Exception
  }
  
  private TimerTask setTimer()
  {
    TimerTask local1 = new TimerTask()
    {
      public void run()
      {
        ArkAndroidHttpClientStub.this.OnTimeout();
      }
    };
    if ((!this.isTimerCanceld) && (this.timeout > 0)) {
      timer.schedule(local1, this.timeout);
    }
    return local1;
  }
  
  /* Error */
  private void writeResponseToFile(TimerTask paramTimerTask, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 9
    //   9: aload 12
    //   11: astore 11
    //   13: aload 13
    //   15: astore 10
    //   17: aload_0
    //   18: aload 4
    //   20: invokevirtual 160	com/tencent/ark/ArkAndroidHttpClientStub:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +22 -> 45
    //   26: aload 12
    //   28: astore 11
    //   30: aload 13
    //   32: astore 10
    //   34: new 336	java/io/FileOutputStream
    //   37: dup
    //   38: aload 4
    //   40: invokespecial 337	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   43: astore 9
    //   45: aload 9
    //   47: astore 11
    //   49: aload 9
    //   51: astore 10
    //   53: new 339	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 340	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore 12
    //   62: iload 5
    //   64: ifne +8 -> 72
    //   67: iload 7
    //   69: ifeq +65 -> 134
    //   72: aload 12
    //   74: astore 11
    //   76: aload 9
    //   78: astore 10
    //   80: aload_0
    //   81: aload_1
    //   82: lload_2
    //   83: ldc 236
    //   85: aconst_null
    //   86: aload 12
    //   88: invokevirtual 344	com/tencent/ark/ArkAndroidHttpClientStub:httpGetorPost	(Ljava/util/TimerTask;JLjava/lang/String;Ljava/io/FileOutputStream;Ljava/io/ByteArrayOutputStream;)V
    //   91: aload 9
    //   93: ifnull +19 -> 112
    //   96: aload 9
    //   98: invokevirtual 345	java/io/FileOutputStream:close	()V
    //   101: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   104: ldc 52
    //   106: ldc_w 347
    //   109: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 12
    //   114: ifnull +19 -> 133
    //   117: aload 12
    //   119: invokevirtual 348	java/io/ByteArrayOutputStream:close	()V
    //   122: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   125: ldc 52
    //   127: ldc_w 350
    //   130: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: return
    //   134: iload 6
    //   136: ifne +8 -> 144
    //   139: iload 8
    //   141: ifeq -50 -> 91
    //   144: aload 12
    //   146: astore 11
    //   148: aload 9
    //   150: astore 10
    //   152: aload_0
    //   153: aload_1
    //   154: lload_2
    //   155: aload 4
    //   157: aload 9
    //   159: aconst_null
    //   160: invokevirtual 344	com/tencent/ark/ArkAndroidHttpClientStub:httpGetorPost	(Ljava/util/TimerTask;JLjava/lang/String;Ljava/io/FileOutputStream;Ljava/io/ByteArrayOutputStream;)V
    //   163: goto -72 -> 91
    //   166: astore 4
    //   168: aload 12
    //   170: astore_1
    //   171: aload_1
    //   172: astore 11
    //   174: aload 9
    //   176: astore 10
    //   178: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   181: ldc 52
    //   183: new 142	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 352
    //   193: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 4
    //   198: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 9
    //   212: ifnull +19 -> 231
    //   215: aload 9
    //   217: invokevirtual 345	java/io/FileOutputStream:close	()V
    //   220: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   223: ldc 52
    //   225: ldc_w 347
    //   228: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_1
    //   232: ifnull -99 -> 133
    //   235: aload_1
    //   236: invokevirtual 348	java/io/ByteArrayOutputStream:close	()V
    //   239: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   242: ldc 52
    //   244: ldc_w 350
    //   247: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: return
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   256: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   259: ldc 52
    //   261: new 142	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 354
    //   271: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: return
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   293: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   296: ldc 52
    //   298: new 142	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 356
    //   308: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   315: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: goto -212 -> 112
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   332: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   335: ldc 52
    //   337: new 142	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 354
    //   347: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_1
    //   351: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: return
    //   364: astore 4
    //   366: aload 4
    //   368: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   371: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   374: ldc 52
    //   376: new 142	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 356
    //   386: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 4
    //   391: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   394: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: goto -172 -> 231
    //   406: astore_1
    //   407: aconst_null
    //   408: astore 4
    //   410: aload 11
    //   412: astore 10
    //   414: aload 4
    //   416: astore 11
    //   418: aload 10
    //   420: ifnull +19 -> 439
    //   423: aload 10
    //   425: invokevirtual 345	java/io/FileOutputStream:close	()V
    //   428: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   431: ldc 52
    //   433: ldc_w 347
    //   436: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload 11
    //   441: ifnull +19 -> 460
    //   444: aload 11
    //   446: invokevirtual 348	java/io/ByteArrayOutputStream:close	()V
    //   449: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   452: ldc 52
    //   454: ldc_w 350
    //   457: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_1
    //   461: athrow
    //   462: astore 4
    //   464: aload 4
    //   466: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   469: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   472: ldc 52
    //   474: new 142	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 356
    //   484: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 4
    //   489: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   492: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: goto -62 -> 439
    //   504: astore 4
    //   506: aload 4
    //   508: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   511: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   514: ldc 52
    //   516: new 142	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 354
    //   526: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload 4
    //   531: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   534: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: goto -83 -> 460
    //   546: astore_1
    //   547: goto -129 -> 418
    //   550: astore 4
    //   552: aconst_null
    //   553: astore_1
    //   554: aload 10
    //   556: astore 9
    //   558: goto -387 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	ArkAndroidHttpClientStub
    //   0	561	1	paramTimerTask	TimerTask
    //   0	561	2	paramLong	long
    //   0	561	4	paramString	String
    //   0	561	5	paramBoolean1	boolean
    //   0	561	6	paramBoolean2	boolean
    //   0	561	7	paramBoolean3	boolean
    //   0	561	8	paramBoolean4	boolean
    //   7	550	9	localObject1	Object
    //   15	540	10	localObject2	Object
    //   11	434	11	localObject3	Object
    //   1	168	12	localByteArrayOutputStream	ByteArrayOutputStream
    //   4	27	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   80	91	166	java/lang/Exception
    //   152	163	166	java/lang/Exception
    //   235	250	251	java/lang/Exception
    //   96	112	288	java/lang/Exception
    //   117	133	327	java/lang/Exception
    //   215	231	364	java/lang/Exception
    //   17	26	406	finally
    //   34	45	406	finally
    //   53	62	406	finally
    //   423	439	462	java/lang/Exception
    //   444	460	504	java/lang/Exception
    //   80	91	546	finally
    //   152	163	546	finally
    //   178	210	546	finally
    //   17	26	550	java/lang/Exception
    //   34	45	550	java/lang/Exception
    //   53	62	550	java/lang/Exception
  }
  
  public void AddCookie(String paramString)
  {
    if (this.m_option == null) {
      this.m_option = new RequestOption();
    }
    if (!isEmpty(paramString)) {}
    for (this.m_option.cookie = paramString;; this.m_option.cookie = "")
    {
      ENV.logD("ArkAndroidHttpLog", "AddCookie is success=" + this.m_option.cookie);
      return;
    }
  }
  
  public void AddCustomHeader(String paramString1, String paramString2)
  {
    if (isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (isEmpty(paramString2)) {
      str = "";
    }
    if (this.m_option == null) {
      this.m_option = new RequestOption();
    }
    if (this.m_option.customHeader == null) {
      this.m_option.customHeader = new ArrayList();
    }
    this.m_option.customHeader.add(new Header(paramString1, str));
    ENV.logD("ArkAndroidHttpLog", "CustomHeader name=" + paramString1 + " and value=" + str);
  }
  
  public void Cancel()
  {
    try
    {
      if (this.isCompleted) {
        return;
      }
      ENV.logD("ArkAndroidHttpLog", "Cancel is success");
      this.isCanceled = true;
      return;
    }
    finally {}
  }
  
  public int DownloadToBuffer(String paramString, int paramInt, long paramLong)
  {
    try
    {
      if (isEmpty(paramString))
      {
        ENV.logE("ArkAndroidHttpLog", "  DownloadToBuffer,url is empty");
        return -1;
      }
      httpAsynTask(paramString, paramInt, null, 0, "", paramLong, true, false, false, false);
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      ENV.logE("ArkAndroidHttpLog", " DownloadToBuffer is fail and errormsg=" + paramString.getMessage());
    }
    return -1;
  }
  
  public int DownloadToFile(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    try
    {
      if ((isEmpty(paramString1)) || (isEmpty(paramString2)))
      {
        ENV.logE("ArkAndroidHttpLog", "DownloadToFile, url or filepath is empty");
        return -1;
      }
      httpAsynTask(paramString1, paramInt, null, 0, paramString2, paramLong, false, true, false, false);
      return 0;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      ENV.logE("ArkAndroidHttpLog", " DownloadToFile is fail and errormsg=" + paramString1.getMessage());
    }
    return -1;
  }
  
  public byte[] GetDownloadBuffer()
  {
    if (this.m_option == null) {}
    while ((this.m_option.outputStream == null) || (this.m_option.outputStream.size() == 0)) {
      return null;
    }
    ENV.logD("ArkAndroidHttpLog", "GetDownloadBuffer length=" + this.m_option.outputStream.toByteArray().length);
    return this.m_option.outputStream.toByteArray();
  }
  
  public String GetDownloadFilePath()
  {
    if (this.m_option == null) {
      return "";
    }
    ENV.logD("ArkAndroidHttpLog", "DownloadFilePath=" + this.m_option.filePath);
    return this.m_option.filePath;
  }
  
  public String GetFinalURL()
  {
    if (this.httpURLConnection == null)
    {
      ENV.logE("ArkAndroidHttpLog", "FinalURL is empty");
      return "";
    }
    ENV.logD("ArkAndroidHttpLog", "FinalURL=" + this.httpURLConnection.getURL().toString());
    return this.httpURLConnection.getURL().toString();
  }
  
  public int GetLastModifyTime()
  {
    if (this.httpURLConnection != null)
    {
      ENV.logD("ArkAndroidHttpLog", "LastModifyTime=" + (int)(this.httpURLConnection.getLastModified() / 1000L));
      return (int)(this.httpURLConnection.getLastModified() / 1000L);
    }
    return 0;
  }
  
  public int GetMaxAge()
  {
    int i = 0;
    Object localObject = GetResponseHeader("Cache-Control", true);
    if (isEmpty((CharSequence)localObject)) {}
    localObject = ((String)localObject).toLowerCase();
    if (!((String)localObject).contains("max-age=")) {}
    for (;;)
    {
      ENV.logD("ArkAndroidHttpLog", "MaxAge=" + i);
      return i;
      localObject = Pattern.compile("max-age=[0-9]*").matcher((CharSequence)localObject);
      if (((Matcher)localObject).find()) {
        i = Integer.parseInt(((Matcher)localObject).group(0).replace("max-age=", ""));
      }
    }
  }
  
  public String GetResponseHeader(String paramString, boolean paramBoolean)
  {
    if (this.m_option == null) {
      this.m_option = new RequestOption();
    }
    String str = "";
    if (!isEmpty(paramString))
    {
      if (this.httpURLConnection != null)
      {
        str = this.httpURLConnection.getHeaderField(paramString);
        if (isEmpty(str)) {
          break label115;
        }
        if (paramBoolean) {
          break label107;
        }
      }
      for (;;)
      {
        ENV.logD("ArkAndroidHttpLog", "ResponseHeader name=" + paramString);
        if (!isEmpty(str)) {
          break;
        }
        ENV.logD("ArkAndroidHttpLog", "ResponseHeader value is empty");
        return str;
        label107:
        str = str.trim();
        continue;
        label115:
        str = "";
      }
      ENV.logD("ArkAndroidHttpLog", "ResponseHeader value=" + str);
      return str;
    }
    ENV.logD("ArkAndroidHttpLog", "ResponseHeader name is empty and value is empty");
    return "";
  }
  
  public int GetStatusCode()
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.httpURLConnection != null) {
        i = this.httpURLConnection.getResponseCode();
      }
      ENV.logD("ArkAndroidHttpLog", "StatusCode=" + i);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ENV.logE("ArkAndroidHttpLog", "StatusCode is fail and errormsg=" + localException.getMessage());
        localException.printStackTrace();
        i = j;
      }
    }
  }
  
  native void OnComplete(long paramLong, int paramInt);
  
  public void OnRequestComplete(long paramLong)
  {
    int i;
    if (this.isCanceled) {
      i = 9;
    }
    for (;;)
    {
      OnComplete(paramLong, i);
      ENV.logD("ArkAndroidHttpLog", "OnRequestComplete is success,and errorcode=" + i);
      return;
      if (this.isTimeOut) {
        i = 21;
      } else if (this.isCompleted) {
        switch (GetStatusCode())
        {
        default: 
          i = 8;
          break;
        case 200: 
        case 206: 
          i = 0;
          break;
        case 304: 
          i = 1;
          break;
        }
      } else {
        i = 2;
      }
    }
  }
  
  public void SetHeader(String paramString1, String paramString2)
  {
    AddCustomHeader(paramString1, paramString2);
  }
  
  public void SetTimeout(int paramInt)
  {
    this.timeout = paramInt;
    ENV.logD("ArkAndroidHttpLog", "SetTimeout is success and timeout=" + this.timeout);
  }
  
  public int UploadBuffer(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (isEmpty(paramString))
      {
        ENV.logE("ArkAndroidHttpLog", "UploadBuffer, buffer or url is empty");
        return -1;
      }
      httpAsynTask(paramString, 0, paramArrayOfByte, paramInt, "", paramLong, false, false, true, false);
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      ENV.logE("ArkAndroidHttpLog", " UploadBuffer is fail and errormsg=" + paramString.getMessage());
    }
    return -1;
  }
  
  public int UploadBufferToFile(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, long paramLong)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if ((isEmpty(paramString1)) || (isEmpty(paramString2)))
      {
        ENV.logE("ArkAndroidHttpLog", "UploadBufferToFile,buffer or url or filepath is empty");
        return -1;
      }
      httpAsynTask(paramString1, 0, paramArrayOfByte, paramInt, paramString2, paramLong, true, false, false, true);
      return 0;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      ENV.logE("ArkAndroidHttpLog", " UploadBufferToFile is fail and errormsg=" + paramString1.getMessage());
    }
    return -1;
  }
  
  public HttpURLConnection getHttpURLConnection(String paramString)
  {
    try
    {
      if (!isEmpty(paramString))
      {
        Object localObject = new URL(paramString);
        InetSocketAddress localInetSocketAddress;
        if ((!isEmpty(proxyHost)) && (proxyPort > 0)) {
          localInetSocketAddress = new InetSocketAddress(proxyHost, proxyPort);
        }
        for (localObject = ((URL)localObject).openConnection(new Proxy(Proxy.Type.HTTP, localInetSocketAddress));; localObject = ((URL)localObject).openConnection())
        {
          localObject = (HttpURLConnection)localObject;
          ENV.logD("ArkAndroidHttpLog", "HttpURLConnection Get/Post url is " + paramString);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      ENV.logE("ArkAndroidHttpLog", "Create HttpURLConnection is fail and errormsg is  " + paramString.getMessage());
      paramString.printStackTrace();
    }
  }
  
  public void httpExecuteTask(String paramString1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    TimerTask localTimerTask = setTimer();
    int i = 0;
    if (i < 3)
    {
      if ((paramBoolean3) || (paramBoolean4)) {}
      for (boolean bool = true;; bool = false)
      {
        if (this.httpURLConnection == null) {
          this.httpURLConnection = getHttpURLConnection(paramString1);
        }
        setHttpParams(paramInt1, paramArrayOfByte, paramInt2, bool);
        if (!needRedirect(GetStatusCode())) {
          break label93;
        }
        this.httpURLConnection = getHttpURLConnection(getRealUrl(paramString1));
        i += 1;
        break;
      }
    }
    label93:
    writeResponseToFile(localTimerTask, paramLong, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  /* Error */
  public void httpGetorPost(TimerTask paramTimerTask, long paramLong, String paramString, java.io.FileOutputStream paramFileOutputStream, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 12
    //   12: aload 12
    //   14: astore 11
    //   16: aload 13
    //   18: astore 10
    //   20: aload_0
    //   21: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   24: ifnonnull +23 -> 47
    //   27: aload 12
    //   29: astore 11
    //   31: aload 13
    //   33: astore 10
    //   35: aload_0
    //   36: new 13	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 358	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:<init>	(Lcom/tencent/ark/ArkAndroidHttpClientStub;)V
    //   44: putfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   47: aload 12
    //   49: astore 11
    //   51: aload 13
    //   53: astore 10
    //   55: aload_0
    //   56: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   59: ldc 236
    //   61: putfield 412	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:filePath	Ljava/lang/String;
    //   64: aload 12
    //   66: astore 11
    //   68: aload 13
    //   70: astore 10
    //   72: aload_0
    //   73: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   76: new 339	java/io/ByteArrayOutputStream
    //   79: dup
    //   80: invokespecial 340	java/io/ByteArrayOutputStream:<init>	()V
    //   83: putfield 397	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:outputStream	Ljava/io/ByteArrayOutputStream;
    //   86: aload 12
    //   88: astore 11
    //   90: aload 13
    //   92: astore 10
    //   94: aload_0
    //   95: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   98: ifnonnull +126 -> 224
    //   101: aload 12
    //   103: astore 11
    //   105: aload 13
    //   107: astore 10
    //   109: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   112: ldc 52
    //   114: ldc_w 573
    //   117: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 12
    //   122: astore 11
    //   124: aload 13
    //   126: astore 10
    //   128: new 126	java/lang/Exception
    //   131: dup
    //   132: invokespecial 297	java/lang/Exception:<init>	()V
    //   135: athrow
    //   136: astore 4
    //   138: aload 11
    //   140: astore 10
    //   142: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   145: ldc 52
    //   147: new 142	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 575
    //   157: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 4
    //   162: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: aload_1
    //   176: invokespecial 577	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   179: aload_0
    //   180: invokespecial 579	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   183: aload_0
    //   184: lload_2
    //   185: invokevirtual 581	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(J)V
    //   188: aload 11
    //   190: ifnull +19 -> 209
    //   193: aload 11
    //   195: invokevirtual 584	java/io/InputStream:close	()V
    //   198: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   201: ldc 52
    //   203: ldc_w 586
    //   206: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_0
    //   210: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   213: ifnull +10 -> 223
    //   216: aload_0
    //   217: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   220: invokevirtual 589	java/net/HttpURLConnection:disconnect	()V
    //   223: return
    //   224: aload 12
    //   226: astore 11
    //   228: aload 13
    //   230: astore 10
    //   232: aload_0
    //   233: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   236: invokevirtual 593	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   239: ifnull +27 -> 266
    //   242: aload 12
    //   244: astore 11
    //   246: aload 13
    //   248: astore 10
    //   250: new 595	java/io/BufferedInputStream
    //   253: dup
    //   254: aload_0
    //   255: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   258: invokevirtual 593	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   261: invokespecial 598	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   264: astore 9
    //   266: aload 9
    //   268: ifnonnull +92 -> 360
    //   271: aload 9
    //   273: astore 11
    //   275: aload 9
    //   277: astore 10
    //   279: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   282: ldc 52
    //   284: ldc_w 600
    //   287: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload 9
    //   292: astore 11
    //   294: aload 9
    //   296: astore 10
    //   298: new 126	java/lang/Exception
    //   301: dup
    //   302: invokespecial 297	java/lang/Exception:<init>	()V
    //   305: athrow
    //   306: astore 4
    //   308: aload_0
    //   309: aload_1
    //   310: invokespecial 577	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   313: aload_0
    //   314: invokespecial 579	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   317: aload_0
    //   318: lload_2
    //   319: invokevirtual 581	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(J)V
    //   322: aload 10
    //   324: ifnull +19 -> 343
    //   327: aload 10
    //   329: invokevirtual 584	java/io/InputStream:close	()V
    //   332: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   335: ldc 52
    //   337: ldc_w 586
    //   340: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_0
    //   344: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   347: ifnull +10 -> 357
    //   350: aload_0
    //   351: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   354: invokevirtual 589	java/net/HttpURLConnection:disconnect	()V
    //   357: aload 4
    //   359: athrow
    //   360: aload 9
    //   362: astore 11
    //   364: aload 9
    //   366: astore 10
    //   368: ldc 45
    //   370: newarray byte
    //   372: astore 12
    //   374: aload 5
    //   376: ifnull +188 -> 564
    //   379: aload 9
    //   381: astore 11
    //   383: aload 9
    //   385: astore 10
    //   387: aload_0
    //   388: getfield 377	com/tencent/ark/ArkAndroidHttpClientStub:isCanceled	Z
    //   391: ifne +69 -> 460
    //   394: aload 9
    //   396: astore 11
    //   398: aload 9
    //   400: astore 10
    //   402: aload_0
    //   403: getfield 108	com/tencent/ark/ArkAndroidHttpClientStub:isTimeOut	Z
    //   406: ifne +54 -> 460
    //   409: aload 9
    //   411: astore 11
    //   413: aload 9
    //   415: astore 10
    //   417: aload 9
    //   419: aload 12
    //   421: invokevirtual 604	java/io/InputStream:read	([B)I
    //   424: istore 8
    //   426: iload 8
    //   428: iconst_m1
    //   429: if_icmpeq +31 -> 460
    //   432: aload 9
    //   434: astore 11
    //   436: aload 9
    //   438: astore 10
    //   440: aload 5
    //   442: aload 12
    //   444: iconst_0
    //   445: iload 8
    //   447: invokevirtual 605	java/io/FileOutputStream:write	([BII)V
    //   450: iload 7
    //   452: iload 8
    //   454: iadd
    //   455: istore 7
    //   457: goto -78 -> 379
    //   460: aload 9
    //   462: astore 11
    //   464: aload 9
    //   466: astore 10
    //   468: aload_0
    //   469: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   472: aload 4
    //   474: putfield 412	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:filePath	Ljava/lang/String;
    //   477: aload 9
    //   479: astore 11
    //   481: aload 9
    //   483: astore 10
    //   485: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   488: ldc 52
    //   490: new 142	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 607
    //   500: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: iload 7
    //   505: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_0
    //   515: aload_1
    //   516: invokespecial 577	com/tencent/ark/ArkAndroidHttpClientStub:cancelTimer	(Ljava/util/TimerTask;)V
    //   519: aload_0
    //   520: invokespecial 579	com/tencent/ark/ArkAndroidHttpClientStub:setFlagComplete	()V
    //   523: aload_0
    //   524: lload_2
    //   525: invokevirtual 581	com/tencent/ark/ArkAndroidHttpClientStub:OnRequestComplete	(J)V
    //   528: aload 9
    //   530: ifnull +19 -> 549
    //   533: aload 9
    //   535: invokevirtual 584	java/io/InputStream:close	()V
    //   538: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   541: ldc 52
    //   543: ldc_w 586
    //   546: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_0
    //   550: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   553: ifnull -330 -> 223
    //   556: aload_0
    //   557: getfield 128	com/tencent/ark/ArkAndroidHttpClientStub:httpURLConnection	Ljava/net/HttpURLConnection;
    //   560: invokevirtual 589	java/net/HttpURLConnection:disconnect	()V
    //   563: return
    //   564: aload 6
    //   566: ifnull -52 -> 514
    //   569: aload 9
    //   571: astore 11
    //   573: aload 9
    //   575: astore 10
    //   577: aload_0
    //   578: getfield 377	com/tencent/ark/ArkAndroidHttpClientStub:isCanceled	Z
    //   581: ifne +62 -> 643
    //   584: aload 9
    //   586: astore 11
    //   588: aload 9
    //   590: astore 10
    //   592: aload_0
    //   593: getfield 108	com/tencent/ark/ArkAndroidHttpClientStub:isTimeOut	Z
    //   596: ifne +47 -> 643
    //   599: aload 9
    //   601: astore 11
    //   603: aload 9
    //   605: astore 10
    //   607: aload 9
    //   609: aload 12
    //   611: invokevirtual 604	java/io/InputStream:read	([B)I
    //   614: istore 7
    //   616: iload 7
    //   618: iconst_m1
    //   619: if_icmpeq +24 -> 643
    //   622: aload 9
    //   624: astore 11
    //   626: aload 9
    //   628: astore 10
    //   630: aload 6
    //   632: aload 12
    //   634: iconst_0
    //   635: iload 7
    //   637: invokevirtual 608	java/io/ByteArrayOutputStream:write	([BII)V
    //   640: goto -71 -> 569
    //   643: aload 9
    //   645: astore 11
    //   647: aload 9
    //   649: astore 10
    //   651: aload_0
    //   652: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   655: aload 6
    //   657: putfield 397	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:outputStream	Ljava/io/ByteArrayOutputStream;
    //   660: aload 9
    //   662: astore 11
    //   664: aload 9
    //   666: astore 10
    //   668: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   671: ldc 52
    //   673: new 142	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 610
    //   683: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 226	com/tencent/ark/ArkAndroidHttpClientStub:m_option	Lcom/tencent/ark/ArkAndroidHttpClientStub$RequestOption;
    //   690: getfield 397	com/tencent/ark/ArkAndroidHttpClientStub$RequestOption:outputStream	Ljava/io/ByteArrayOutputStream;
    //   693: invokevirtual 401	java/io/ByteArrayOutputStream:size	()I
    //   696: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokevirtual 106	com/tencent/ark/ArkEnvironmentManager:logD	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: goto -191 -> 514
    //   708: astore_1
    //   709: aload_1
    //   710: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   713: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   716: ldc 52
    //   718: new 142	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 612
    //   728: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_1
    //   732: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   735: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: goto -195 -> 549
    //   747: astore_1
    //   748: aload_1
    //   749: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   752: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   755: ldc 52
    //   757: new 142	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 612
    //   767: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_1
    //   771: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   774: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: goto -574 -> 209
    //   786: astore_1
    //   787: aload_1
    //   788: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   791: getstatic 80	com/tencent/ark/ArkAndroidHttpClientStub:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   794: ldc 52
    //   796: new 142	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   803: ldc_w 612
    //   806: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_1
    //   810: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokevirtual 197	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: goto -479 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	this	ArkAndroidHttpClientStub
    //   0	825	1	paramTimerTask	TimerTask
    //   0	825	2	paramLong	long
    //   0	825	4	paramString	String
    //   0	825	5	paramFileOutputStream	java.io.FileOutputStream
    //   0	825	6	paramByteArrayOutputStream	ByteArrayOutputStream
    //   1	635	7	i	int
    //   424	31	8	j	int
    //   4	661	9	localBufferedInputStream	java.io.BufferedInputStream
    //   18	649	10	localObject1	Object
    //   14	649	11	localObject2	Object
    //   10	623	12	arrayOfByte	byte[]
    //   7	240	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	136	java/lang/Exception
    //   35	47	136	java/lang/Exception
    //   55	64	136	java/lang/Exception
    //   72	86	136	java/lang/Exception
    //   94	101	136	java/lang/Exception
    //   109	120	136	java/lang/Exception
    //   128	136	136	java/lang/Exception
    //   232	242	136	java/lang/Exception
    //   250	266	136	java/lang/Exception
    //   279	290	136	java/lang/Exception
    //   298	306	136	java/lang/Exception
    //   368	374	136	java/lang/Exception
    //   387	394	136	java/lang/Exception
    //   402	409	136	java/lang/Exception
    //   417	426	136	java/lang/Exception
    //   440	450	136	java/lang/Exception
    //   468	477	136	java/lang/Exception
    //   485	514	136	java/lang/Exception
    //   577	584	136	java/lang/Exception
    //   592	599	136	java/lang/Exception
    //   607	616	136	java/lang/Exception
    //   630	640	136	java/lang/Exception
    //   651	660	136	java/lang/Exception
    //   668	705	136	java/lang/Exception
    //   20	27	306	finally
    //   35	47	306	finally
    //   55	64	306	finally
    //   72	86	306	finally
    //   94	101	306	finally
    //   109	120	306	finally
    //   128	136	306	finally
    //   142	174	306	finally
    //   232	242	306	finally
    //   250	266	306	finally
    //   279	290	306	finally
    //   298	306	306	finally
    //   368	374	306	finally
    //   387	394	306	finally
    //   402	409	306	finally
    //   417	426	306	finally
    //   440	450	306	finally
    //   468	477	306	finally
    //   485	514	306	finally
    //   577	584	306	finally
    //   592	599	306	finally
    //   607	616	306	finally
    //   630	640	306	finally
    //   651	660	306	finally
    //   668	705	306	finally
    //   533	549	708	java/lang/Exception
    //   193	209	747	java/lang/Exception
    //   327	343	786	java/lang/Exception
  }
  
  public boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public void setProxyParam(String paramString, int paramInt)
  {
    proxyHost = paramString;
    proxyPort = paramInt;
    ENV.logD("ArkAndroidHttpLog", "proxyhost is  " + proxyHost);
    ENV.logD("ArkAndroidHttpLog", "proxyPort is  " + proxyPort);
  }
  
  public String timeStampToString(int paramInt)
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Object localObject2 = ((SimpleDateFormat)localObject1).format(Long.valueOf(paramInt * 1000L));
    if (isEmpty((CharSequence)localObject2)) {
      return "";
    }
    try
    {
      localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
      if (localObject1 == null) {
        return "";
      }
      localObject2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
      ((DateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
      localObject1 = ((DateFormat)localObject2).format((Date)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      ENV.logE("ArkAndroidHttpLog", "timeStampToString is fail and errormsg is  " + localException.getMessage());
      localException.printStackTrace();
    }
    return "";
  }
  
  static class Header
  {
    String name;
    String value;
    
    Header(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.value = paramString2;
    }
  }
  
  class RequestOption
  {
    public String cookie;
    List<ArkAndroidHttpClientStub.Header> customHeader;
    public String filePath;
    public ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    
    RequestOption() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkAndroidHttpClientStub
 * JD-Core Version:    0.7.0.1
 */
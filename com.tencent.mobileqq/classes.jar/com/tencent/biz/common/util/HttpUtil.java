package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.AsyncHttpClient.CustomSSLSocketFactory;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.http.base.SNIVerifier;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import klz;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil
{
  private static final SNIVerifier jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseSNIVerifier = new SNIVerifier();
  private static boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (b(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
  }
  
  public static HttpUtil.NetworkProxy a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (NetworkUtil.a((NetworkInfo)localObject))
    {
      localObject = a(paramContext);
      int i = a(paramContext);
      if ((!b((String)localObject)) && (i >= 0)) {
        return new HttpUtil.NetworkProxy((String)localObject, i, null);
      }
    }
    return null;
  }
  
  /* Error */
  public static com.tencent.util.Pair a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 109
    //   11: iconst_2
    //   12: new 111	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   19: ldc 114
    //   21: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +17 -> 55
    //   41: aload_1
    //   42: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +10 -> 55
    //   48: aload_2
    //   49: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: iconst_1
    //   58: istore 4
    //   60: iconst_1
    //   61: istore 5
    //   63: new 134	java/net/URL
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 137	java/net/URL:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 141	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   74: checkcast 143	java/net/HttpURLConnection
    //   77: astore 7
    //   79: iload 5
    //   81: istore_3
    //   82: aload 7
    //   84: sipush 5000
    //   87: invokevirtual 147	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   90: iload 5
    //   92: istore_3
    //   93: aload 7
    //   95: sipush 30000
    //   98: invokevirtual 150	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   101: iload 5
    //   103: istore_3
    //   104: aload 7
    //   106: ldc 152
    //   108: invokevirtual 155	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   111: iload 5
    //   113: istore_3
    //   114: aload 7
    //   116: ldc 157
    //   118: ldc 159
    //   120: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iload 5
    //   125: istore_3
    //   126: aload 7
    //   128: ldc 165
    //   130: new 111	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 167
    //   136: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: ldc 170
    //   141: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: getstatic 174	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   147: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 170
    //   152: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: getstatic 179	android/os/Build:DEVICE	Ljava/lang/String;
    //   158: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 170
    //   163: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: getstatic 182	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   169: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 170
    //   174: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 184
    //   179: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 5
    //   190: istore_3
    //   191: aload 7
    //   193: ldc 186
    //   195: ldc 188
    //   197: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iload 5
    //   202: istore_3
    //   203: aload 7
    //   205: ldc 190
    //   207: ldc 192
    //   209: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: iload 5
    //   214: istore_3
    //   215: invokestatic 198	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   218: invokevirtual 202	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   221: iconst_2
    //   222: invokevirtual 208	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   225: checkcast 210	mqq/manager/TicketManager
    //   228: aload_1
    //   229: ldc 192
    //   231: invokeinterface 214 3 0
    //   236: astore_0
    //   237: iload 5
    //   239: istore_3
    //   240: aload_0
    //   241: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifne +127 -> 371
    //   247: iload 5
    //   249: istore_3
    //   250: aload 7
    //   252: ldc 216
    //   254: new 111	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   261: ldc 218
    //   263: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 220
    //   272: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: iload 5
    //   287: istore_3
    //   288: aload 7
    //   290: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   293: istore 6
    //   295: iload 6
    //   297: sipush 200
    //   300: if_icmpeq +170 -> 470
    //   303: iload 5
    //   305: istore_3
    //   306: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +32 -> 341
    //   312: iload 5
    //   314: istore_3
    //   315: ldc 109
    //   317: iconst_2
    //   318: new 111	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   325: ldc 225
    //   327: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 6
    //   332: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: iload 5
    //   343: istore_3
    //   344: new 230	com/tencent/util/Pair
    //   347: dup
    //   348: iload 6
    //   350: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: ldc 236
    //   355: invokespecial 239	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   358: astore_0
    //   359: aload 7
    //   361: ifnull +8 -> 369
    //   364: aload 7
    //   366: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   369: aload_0
    //   370: areturn
    //   371: iload 5
    //   373: istore_3
    //   374: aload 7
    //   376: ldc 216
    //   378: new 111	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   385: ldc 244
    //   387: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc 246
    //   396: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_2
    //   400: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: goto -124 -> 285
    //   412: astore_1
    //   413: aload 7
    //   415: astore_0
    //   416: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +28 -> 447
    //   422: ldc 109
    //   424: iconst_2
    //   425: new 111	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   432: ldc 248
    //   434: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_1
    //   438: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: ifnull +274 -> 722
    //   451: aload_0
    //   452: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   455: aconst_null
    //   456: astore_0
    //   457: new 230	com/tencent/util/Pair
    //   460: dup
    //   461: iload_3
    //   462: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: aload_0
    //   466: invokespecial 239	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   469: areturn
    //   470: iload 5
    //   472: istore_3
    //   473: new 111	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   480: astore_0
    //   481: iload 5
    //   483: istore_3
    //   484: new 256	java/io/BufferedReader
    //   487: dup
    //   488: new 258	java/io/InputStreamReader
    //   491: dup
    //   492: aload 7
    //   494: invokevirtual 262	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   497: invokespecial 265	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   500: invokespecial 268	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   503: astore_1
    //   504: iload 5
    //   506: istore_3
    //   507: aload_1
    //   508: invokevirtual 271	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   511: astore_2
    //   512: aload_2
    //   513: ifnull +35 -> 548
    //   516: iload 5
    //   518: istore_3
    //   519: aload_0
    //   520: aload_2
    //   521: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 273
    //   527: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: goto -27 -> 504
    //   534: astore_1
    //   535: aload 7
    //   537: astore_0
    //   538: aload_0
    //   539: ifnull +7 -> 546
    //   542: aload_0
    //   543: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   546: aload_1
    //   547: athrow
    //   548: iload 5
    //   550: istore_3
    //   551: aload_1
    //   552: invokevirtual 276	java/io/BufferedReader:close	()V
    //   555: iload 5
    //   557: istore_3
    //   558: aload_0
    //   559: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: astore_0
    //   563: iload 5
    //   565: istore_3
    //   566: aload_0
    //   567: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   570: ifne +125 -> 695
    //   573: iload 5
    //   575: istore_3
    //   576: new 278	org/json/JSONObject
    //   579: dup
    //   580: aload_0
    //   581: invokespecial 279	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   584: astore_0
    //   585: iload 5
    //   587: istore_3
    //   588: aload_0
    //   589: ldc_w 281
    //   592: invokevirtual 284	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   595: istore 5
    //   597: iload 5
    //   599: ifne +49 -> 648
    //   602: iload 5
    //   604: istore_3
    //   605: aload_0
    //   606: ldc_w 286
    //   609: invokevirtual 289	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   612: ifeq +36 -> 648
    //   615: iload 5
    //   617: istore_3
    //   618: aload_0
    //   619: ldc_w 286
    //   622: invokevirtual 293	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   625: ldc_w 295
    //   628: invokevirtual 298	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   631: astore_0
    //   632: iload 5
    //   634: istore_3
    //   635: aload 7
    //   637: ifnull +90 -> 727
    //   640: aload 7
    //   642: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   645: goto -188 -> 457
    //   648: iload 5
    //   650: istore_3
    //   651: iload 5
    //   653: istore 4
    //   655: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +37 -> 695
    //   661: iload 5
    //   663: istore_3
    //   664: ldc 109
    //   666: iconst_2
    //   667: new 111	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   674: ldc_w 300
    //   677: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: iload 5
    //   682: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: iload 5
    //   693: istore 4
    //   695: iload 4
    //   697: istore_3
    //   698: aload 8
    //   700: astore_0
    //   701: goto -66 -> 635
    //   704: astore_1
    //   705: aconst_null
    //   706: astore_0
    //   707: goto -169 -> 538
    //   710: astore_1
    //   711: goto -173 -> 538
    //   714: astore_1
    //   715: iconst_1
    //   716: istore_3
    //   717: aconst_null
    //   718: astore_0
    //   719: goto -303 -> 416
    //   722: aconst_null
    //   723: astore_0
    //   724: goto -267 -> 457
    //   727: goto -270 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	730	0	paramString1	String
    //   0	730	1	paramString2	String
    //   0	730	2	paramString3	String
    //   81	636	3	i	int
    //   58	638	4	j	int
    //   61	631	5	k	int
    //   293	56	6	m	int
    //   77	564	7	localHttpURLConnection	java.net.HttpURLConnection
    //   1	698	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	90	412	java/lang/Exception
    //   93	101	412	java/lang/Exception
    //   104	111	412	java/lang/Exception
    //   114	123	412	java/lang/Exception
    //   126	188	412	java/lang/Exception
    //   191	200	412	java/lang/Exception
    //   203	212	412	java/lang/Exception
    //   215	237	412	java/lang/Exception
    //   240	247	412	java/lang/Exception
    //   250	285	412	java/lang/Exception
    //   288	295	412	java/lang/Exception
    //   306	312	412	java/lang/Exception
    //   315	341	412	java/lang/Exception
    //   344	359	412	java/lang/Exception
    //   374	409	412	java/lang/Exception
    //   473	481	412	java/lang/Exception
    //   484	504	412	java/lang/Exception
    //   507	512	412	java/lang/Exception
    //   519	531	412	java/lang/Exception
    //   551	555	412	java/lang/Exception
    //   558	563	412	java/lang/Exception
    //   566	573	412	java/lang/Exception
    //   576	585	412	java/lang/Exception
    //   588	597	412	java/lang/Exception
    //   605	615	412	java/lang/Exception
    //   618	632	412	java/lang/Exception
    //   655	661	412	java/lang/Exception
    //   664	691	412	java/lang/Exception
    //   82	90	534	finally
    //   93	101	534	finally
    //   104	111	534	finally
    //   114	123	534	finally
    //   126	188	534	finally
    //   191	200	534	finally
    //   203	212	534	finally
    //   215	237	534	finally
    //   240	247	534	finally
    //   250	285	534	finally
    //   288	295	534	finally
    //   306	312	534	finally
    //   315	341	534	finally
    //   344	359	534	finally
    //   374	409	534	finally
    //   473	481	534	finally
    //   484	504	534	finally
    //   507	512	534	finally
    //   519	531	534	finally
    //   551	555	534	finally
    //   558	563	534	finally
    //   566	573	534	finally
    //   576	585	534	finally
    //   588	597	534	finally
    //   605	615	534	finally
    //   618	632	534	finally
    //   655	661	534	finally
    //   664	691	534	finally
    //   63	79	704	finally
    //   416	447	710	finally
    //   63	79	714	java/lang/Exception
  }
  
  /* Error */
  public static ByteArrayOutputStream a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 309 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload 5
    //   17: invokeinterface 314 1 0
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: astore_2
    //   30: aload 5
    //   32: astore 4
    //   34: new 316	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 317	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore 6
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: astore 4
    //   53: aload_0
    //   54: ldc_w 319
    //   57: invokeinterface 323 2 0
    //   62: astore 7
    //   64: aload 5
    //   66: astore_0
    //   67: aload 7
    //   69: ifnull +55 -> 124
    //   72: aload 5
    //   74: astore_0
    //   75: aload 5
    //   77: astore_3
    //   78: aload 5
    //   80: astore_2
    //   81: aload 5
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 328 1 0
    //   92: invokevirtual 333	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc_w 335
    //   98: invokevirtual 338	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +23 -> 124
    //   104: aload 5
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: new 340	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokespecial 341	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_0
    //   124: aload_0
    //   125: astore_3
    //   126: aload_0
    //   127: astore_2
    //   128: aload_0
    //   129: astore 4
    //   131: sipush 512
    //   134: newarray byte
    //   136: astore 5
    //   138: aload_0
    //   139: astore_3
    //   140: aload_0
    //   141: astore_2
    //   142: aload_0
    //   143: astore 4
    //   145: aload_0
    //   146: aload 5
    //   148: invokevirtual 347	java/io/InputStream:read	([B)I
    //   151: istore_1
    //   152: iload_1
    //   153: iconst_m1
    //   154: if_icmpeq +38 -> 192
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: astore_2
    //   161: aload_0
    //   162: astore 4
    //   164: aload 6
    //   166: aload 5
    //   168: iconst_0
    //   169: iload_1
    //   170: invokevirtual 351	java/io/ByteArrayOutputStream:write	([BII)V
    //   173: goto -35 -> 138
    //   176: astore_0
    //   177: aload_3
    //   178: astore_2
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 352	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 352	java/io/InputStream:close	()V
    //   200: aload 6
    //   202: areturn
    //   203: astore_0
    //   204: aload 4
    //   206: astore_2
    //   207: new 303	java/io/IOException
    //   210: dup
    //   211: invokespecial 353	java/io/IOException:<init>	()V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramHttpResponse	HttpResponse
    //   151	19	1	i	int
    //   9	198	2	localObject1	Object
    //   14	164	3	localObject2	Object
    //   11	194	4	localObject3	Object
    //   6	161	5	localObject4	Object
    //   41	160	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   62	24	7	localHeader	org.apache.http.Header
    // Exception table:
    //   from	to	target	type
    //   15	24	176	java/io/IOException
    //   34	43	176	java/io/IOException
    //   53	64	176	java/io/IOException
    //   85	104	176	java/io/IOException
    //   114	124	176	java/io/IOException
    //   131	138	176	java/io/IOException
    //   145	152	176	java/io/IOException
    //   164	173	176	java/io/IOException
    //   15	24	181	finally
    //   34	43	181	finally
    //   53	64	181	finally
    //   85	104	181	finally
    //   114	124	181	finally
    //   131	138	181	finally
    //   145	152	181	finally
    //   164	173	181	finally
    //   179	181	181	finally
    //   207	215	181	finally
    //   15	24	203	java/lang/Exception
    //   34	43	203	java/lang/Exception
    //   53	64	203	java/lang/Exception
    //   85	104	203	java/lang/Exception
    //   114	124	203	java/lang/Exception
    //   131	138	203	java/lang/Exception
    //   145	152	203	java/lang/Exception
    //   164	173	203	java/lang/Exception
  }
  
  public static String a()
  {
    switch ()
    {
    default: 
      return null;
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "CABLE";
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (b(str)) {
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  protected static final String a(Context paramContext, String paramString1, String paramString2, int paramInt, JSONArray paramJSONArray)
  {
    Bundle localBundle = new Bundle();
    String str = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(paramString1, "openmobile.qq.com");
    if (!TextUtils.isEmpty(str)) {
      localBundle.putString("cookie", "p_uin=" + paramString1 + ";p_skey=" + str);
    }
    for (;;)
    {
      localBundle.putString("Referer", "http://openmobile.qq.com/");
      paramString1 = new Bundle();
      paramString1.putString("type", String.valueOf(paramInt));
      paramString1.putString("value", paramJSONArray.toString());
      paramString1.putString("mType", "qb_share");
      try
      {
        paramContext = a(paramContext, "http://openmobile.qq.com/api/url_change", "POST", paramString1, localBundle);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        QLog.d("zivonchen", 4, paramContext.getMessage());
      }
      localBundle.putString("cookie", "uin=" + paramString1 + ";skey=" + paramString2);
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(QRUtils.c))
        {
          str1 = QRUtils.a(paramContext, str2);
          if (str1 == null) {
            break label187;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label187:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext);
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(QRUtils.c)) {
            continue;
          }
          paramString3 = QRUtils.a(paramContext, str);
          if (paramString3 == null) {
            break label265;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        catch (OutOfMemoryError paramContext)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HttpUtil", 2, "openRequest fail OutOfMemoryError");
          paramContext = null;
          continue;
          int i = paramContext.getStatusLine().getStatusCode();
          if (i != 200) {
            continue;
          }
          try
          {
            paramContext = a(paramContext);
            return paramContext;
          }
          catch (OutOfMemoryError paramContext)
          {
            throw new IOException("-1");
          }
          throw new IOException("" + i);
        }
        if (paramContext != null) {
          continue;
        }
        throw new IOException("0");
        paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label265:
      for (;;) {}
    }
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
            j = 0;
            label130:
            if (j >= localObject1.length) {
              break label205;
            }
            if (j != 0) {
              break label171;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[j]));
          }
          for (;;)
          {
            j += 1;
            break label130;
            localStringBuilder.append("&");
            break;
            label171:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[j]));
          }
        }
        else
        {
          label205:
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
  }
  
  /* Error */
  public static final String a(String paramString1, String paramString2, String paramString3, java.util.Map paramMap1, java.util.Map paramMap2, java.util.Map paramMap3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_2
    //   8: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +7 -> 25
    //   21: aconst_null
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: aconst_null
    //   26: astore 8
    //   28: aconst_null
    //   29: astore 9
    //   31: new 134	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 137	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 141	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   42: checkcast 143	java/net/HttpURLConnection
    //   45: astore 7
    //   47: aload 7
    //   49: sipush 5000
    //   52: invokevirtual 147	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   55: aload 7
    //   57: sipush 30000
    //   60: invokevirtual 150	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   63: aload 7
    //   65: iconst_1
    //   66: invokevirtual 546	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   69: aload 7
    //   71: iconst_1
    //   72: invokevirtual 549	java/net/HttpURLConnection:setDoInput	(Z)V
    //   75: aload 7
    //   77: iconst_0
    //   78: invokevirtual 552	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   81: aload 7
    //   83: ldc_w 408
    //   86: invokevirtual 155	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   89: aload 7
    //   91: ldc 157
    //   93: ldc 159
    //   95: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 7
    //   100: ldc 165
    //   102: new 111	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 167
    //   108: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: ldc 170
    //   113: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: getstatic 174	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   119: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 170
    //   124: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 179	android/os/Build:DEVICE	Ljava/lang/String;
    //   130: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 170
    //   135: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: getstatic 182	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   141: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 170
    //   146: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 184
    //   151: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 7
    //   162: ldc_w 554
    //   165: new 111	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 556
    //   175: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 558
    //   181: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload 5
    //   192: astore 8
    //   194: aload 5
    //   196: ifnonnull +12 -> 208
    //   199: new 560	java/util/HashMap
    //   202: dup
    //   203: invokespecial 561	java/util/HashMap:<init>	()V
    //   206: astore 8
    //   208: aload_0
    //   209: ldc_w 563
    //   212: invokevirtual 566	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   215: ifeq +73 -> 288
    //   218: invokestatic 198	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   221: invokevirtual 202	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   224: iconst_2
    //   225: invokevirtual 208	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   228: checkcast 210	mqq/manager/TicketManager
    //   231: aload_1
    //   232: ldc 192
    //   234: invokeinterface 214 3 0
    //   239: astore 5
    //   241: aload 5
    //   243: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifne +42 -> 288
    //   249: aload 8
    //   251: ldc 216
    //   253: new 111	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   260: ldc 218
    //   262: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_1
    //   266: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 220
    //   271: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 5
    //   276: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokeinterface 572 3 0
    //   287: pop
    //   288: aload 8
    //   290: ldc 216
    //   292: invokeinterface 575 2 0
    //   297: ifne +41 -> 338
    //   300: aload 8
    //   302: ldc 216
    //   304: new 111	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   311: ldc 244
    //   313: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_1
    //   317: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 246
    //   322: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokeinterface 572 3 0
    //   337: pop
    //   338: aload 8
    //   340: invokeinterface 578 1 0
    //   345: invokeinterface 489 1 0
    //   350: astore_1
    //   351: aload_1
    //   352: invokeinterface 494 1 0
    //   357: ifeq +127 -> 484
    //   360: aload_1
    //   361: invokeinterface 498 1 0
    //   366: checkcast 580	java/util/Map$Entry
    //   369: astore_2
    //   370: aload 7
    //   372: aload_2
    //   373: invokeinterface 583 1 0
    //   378: checkcast 330	java/lang/String
    //   381: aload_2
    //   382: invokeinterface 585 1 0
    //   387: checkcast 330	java/lang/String
    //   390: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto -42 -> 351
    //   396: astore_1
    //   397: aload 7
    //   399: astore_2
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_2
    //   403: astore 8
    //   405: ldc_w 587
    //   408: iconst_2
    //   409: new 111	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 589
    //   419: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_0
    //   423: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_1
    //   433: astore_0
    //   434: aload_2
    //   435: ifnull -412 -> 23
    //   438: aload_2
    //   439: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   442: istore 6
    //   444: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +31 -> 478
    //   450: ldc_w 474
    //   453: iconst_2
    //   454: new 111	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 591
    //   464: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: iload 6
    //   469: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: aload_2
    //   479: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   482: aload_1
    //   483: areturn
    //   484: new 593	java/io/DataOutputStream
    //   487: dup
    //   488: aload 7
    //   490: invokevirtual 597	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   493: invokespecial 600	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   496: astore_2
    //   497: aload_3
    //   498: ifnull +210 -> 708
    //   501: new 602	java/lang/StringBuffer
    //   504: dup
    //   505: invokespecial 603	java/lang/StringBuffer:<init>	()V
    //   508: astore_1
    //   509: aload_3
    //   510: invokeinterface 578 1 0
    //   515: invokeinterface 489 1 0
    //   520: astore 5
    //   522: aload 5
    //   524: invokeinterface 494 1 0
    //   529: ifeq +168 -> 697
    //   532: aload 5
    //   534: invokeinterface 498 1 0
    //   539: checkcast 580	java/util/Map$Entry
    //   542: astore 8
    //   544: aload 8
    //   546: invokeinterface 583 1 0
    //   551: checkcast 330	java/lang/String
    //   554: astore_3
    //   555: aload 8
    //   557: invokeinterface 585 1 0
    //   562: checkcast 330	java/lang/String
    //   565: astore 8
    //   567: aload 8
    //   569: ifnull -47 -> 522
    //   572: aload_1
    //   573: ldc_w 605
    //   576: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   579: ldc_w 610
    //   582: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   585: ldc_w 558
    //   588: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   591: ldc_w 605
    //   594: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   597: pop
    //   598: aload_1
    //   599: new 111	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 612
    //   609: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload_3
    //   613: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: ldc_w 614
    //   619: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   628: pop
    //   629: aload_1
    //   630: aload 8
    //   632: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   635: pop
    //   636: goto -114 -> 522
    //   639: astore_0
    //   640: aload 7
    //   642: astore 8
    //   644: aload 8
    //   646: ifnull +49 -> 695
    //   649: aload 8
    //   651: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   654: istore 6
    //   656: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq +31 -> 690
    //   662: ldc_w 474
    //   665: iconst_2
    //   666: new 111	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   673: ldc_w 591
    //   676: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: iload 6
    //   681: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload 8
    //   692: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   695: aload_0
    //   696: athrow
    //   697: aload_2
    //   698: aload_1
    //   699: invokevirtual 615	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   702: invokevirtual 619	java/lang/String:getBytes	()[B
    //   705: invokevirtual 624	java/io/OutputStream:write	([B)V
    //   708: aload 4
    //   710: ifnull +417 -> 1127
    //   713: aload 4
    //   715: invokeinterface 578 1 0
    //   720: invokeinterface 489 1 0
    //   725: astore_3
    //   726: aload_3
    //   727: invokeinterface 494 1 0
    //   732: ifeq +395 -> 1127
    //   735: aload_3
    //   736: invokeinterface 498 1 0
    //   741: checkcast 580	java/util/Map$Entry
    //   744: astore_1
    //   745: aload_1
    //   746: invokeinterface 583 1 0
    //   751: checkcast 330	java/lang/String
    //   754: astore 5
    //   756: aload_1
    //   757: invokeinterface 585 1 0
    //   762: checkcast 330	java/lang/String
    //   765: astore_1
    //   766: aload_1
    //   767: ifnull -41 -> 726
    //   770: new 626	java/io/File
    //   773: dup
    //   774: aload_1
    //   775: invokespecial 627	java/io/File:<init>	(Ljava/lang/String;)V
    //   778: astore 4
    //   780: aload 4
    //   782: invokevirtual 630	java/io/File:getName	()Ljava/lang/String;
    //   785: astore 8
    //   787: aload 8
    //   789: ldc_w 632
    //   792: invokevirtual 635	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   795: ifeq +3 -> 798
    //   798: ldc_w 637
    //   801: astore_1
    //   802: ldc_w 637
    //   805: ifnull +577 -> 1382
    //   808: ldc_w 637
    //   811: ldc 236
    //   813: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq +6 -> 822
    //   819: goto +563 -> 1382
    //   822: new 602	java/lang/StringBuffer
    //   825: dup
    //   826: invokespecial 603	java/lang/StringBuffer:<init>	()V
    //   829: astore 9
    //   831: aload 9
    //   833: ldc_w 605
    //   836: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   839: ldc_w 610
    //   842: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   845: ldc_w 558
    //   848: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   851: ldc_w 605
    //   854: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   857: pop
    //   858: aload 9
    //   860: new 111	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 612
    //   870: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 5
    //   875: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: ldc_w 639
    //   881: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 8
    //   886: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: ldc_w 641
    //   892: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   901: pop
    //   902: aload 9
    //   904: new 111	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   911: ldc_w 643
    //   914: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload_1
    //   918: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: ldc_w 645
    //   924: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   933: pop
    //   934: aload_2
    //   935: aload 9
    //   937: invokevirtual 615	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   940: invokevirtual 619	java/lang/String:getBytes	()[B
    //   943: invokevirtual 624	java/io/OutputStream:write	([B)V
    //   946: new 647	java/io/BufferedInputStream
    //   949: dup
    //   950: new 647	java/io/BufferedInputStream
    //   953: dup
    //   954: new 649	java/io/FileInputStream
    //   957: dup
    //   958: aload 4
    //   960: invokespecial 652	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   963: invokespecial 653	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   966: invokespecial 653	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   969: astore 5
    //   971: sipush 3072
    //   974: newarray byte
    //   976: astore_1
    //   977: aload 5
    //   979: aload_1
    //   980: invokevirtual 654	java/io/BufferedInputStream:read	([B)I
    //   983: istore 6
    //   985: iload 6
    //   987: iconst_m1
    //   988: if_icmpeq +102 -> 1090
    //   991: aload_2
    //   992: aload_1
    //   993: iconst_0
    //   994: iload 6
    //   996: invokevirtual 655	java/io/OutputStream:write	([BII)V
    //   999: goto -22 -> 977
    //   1002: astore_1
    //   1003: ldc_w 474
    //   1006: iconst_2
    //   1007: new 111	java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1014: ldc_w 657
    //   1017: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 4
    //   1022: invokevirtual 661	java/io/File:length	()J
    //   1025: invokevirtual 664	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1028: ldc_w 666
    //   1031: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload 4
    //   1036: invokevirtual 669	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1039: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1048: aload_2
    //   1049: invokevirtual 672	java/io/OutputStream:flush	()V
    //   1052: aload_2
    //   1053: invokevirtual 673	java/io/OutputStream:close	()V
    //   1056: aload 7
    //   1058: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   1061: aconst_null
    //   1062: astore_1
    //   1063: aload 5
    //   1065: invokevirtual 674	java/io/BufferedInputStream:close	()V
    //   1068: aload_1
    //   1069: astore_0
    //   1070: iconst_0
    //   1071: ifeq -1048 -> 23
    //   1074: new 676	java/lang/NullPointerException
    //   1077: dup
    //   1078: invokespecial 677	java/lang/NullPointerException:<init>	()V
    //   1081: athrow
    //   1082: new 676	java/lang/NullPointerException
    //   1085: dup
    //   1086: invokespecial 677	java/lang/NullPointerException:<init>	()V
    //   1089: athrow
    //   1090: aload 5
    //   1092: invokevirtual 674	java/io/BufferedInputStream:close	()V
    //   1095: goto -369 -> 726
    //   1098: astore_0
    //   1099: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1102: ifeq -20 -> 1082
    //   1105: ldc_w 474
    //   1108: iconst_2
    //   1109: aload_0
    //   1110: invokevirtual 678	java/lang/Exception:toString	()Ljava/lang/String;
    //   1113: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: goto -34 -> 1082
    //   1119: astore_1
    //   1120: aload 5
    //   1122: invokevirtual 674	java/io/BufferedInputStream:close	()V
    //   1125: aload_1
    //   1126: athrow
    //   1127: aload_2
    //   1128: new 111	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1135: ldc_w 680
    //   1138: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: ldc_w 558
    //   1144: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: ldc_w 682
    //   1150: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokevirtual 619	java/lang/String:getBytes	()[B
    //   1159: invokevirtual 624	java/io/OutputStream:write	([B)V
    //   1162: aload_2
    //   1163: invokevirtual 672	java/io/OutputStream:flush	()V
    //   1166: aload_2
    //   1167: invokevirtual 673	java/io/OutputStream:close	()V
    //   1170: new 602	java/lang/StringBuffer
    //   1173: dup
    //   1174: invokespecial 603	java/lang/StringBuffer:<init>	()V
    //   1177: astore_3
    //   1178: new 256	java/io/BufferedReader
    //   1181: dup
    //   1182: new 258	java/io/InputStreamReader
    //   1185: dup
    //   1186: aload 7
    //   1188: invokevirtual 262	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1191: invokespecial 265	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1194: invokespecial 268	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1197: astore_2
    //   1198: aload_2
    //   1199: invokevirtual 271	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1202: astore_1
    //   1203: aload_1
    //   1204: ifnull +18 -> 1222
    //   1207: aload_3
    //   1208: aload_1
    //   1209: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1212: ldc_w 273
    //   1215: invokevirtual 608	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1218: pop
    //   1219: goto -21 -> 1198
    //   1222: aload_3
    //   1223: invokevirtual 615	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1226: astore_1
    //   1227: aload_2
    //   1228: invokevirtual 276	java/io/BufferedReader:close	()V
    //   1231: aload 7
    //   1233: ifnull +49 -> 1282
    //   1236: aload 7
    //   1238: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   1241: istore 6
    //   1243: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1246: ifeq +31 -> 1277
    //   1249: ldc_w 474
    //   1252: iconst_2
    //   1253: new 111	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1260: ldc_w 591
    //   1263: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: iload 6
    //   1268: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1277: aload 7
    //   1279: invokevirtual 242	java/net/HttpURLConnection:disconnect	()V
    //   1282: aload_1
    //   1283: areturn
    //   1284: astore_0
    //   1285: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1288: ifeq -11 -> 1277
    //   1291: ldc_w 474
    //   1294: iconst_2
    //   1295: aload_0
    //   1296: invokevirtual 678	java/lang/Exception:toString	()Ljava/lang/String;
    //   1299: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1302: goto -25 -> 1277
    //   1305: astore_0
    //   1306: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1309: ifeq -831 -> 478
    //   1312: ldc_w 474
    //   1315: iconst_2
    //   1316: aload_0
    //   1317: invokevirtual 678	java/lang/Exception:toString	()Ljava/lang/String;
    //   1320: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: goto -845 -> 478
    //   1326: astore_1
    //   1327: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1330: ifeq -640 -> 690
    //   1333: ldc_w 474
    //   1336: iconst_2
    //   1337: aload_1
    //   1338: invokevirtual 678	java/lang/Exception:toString	()Ljava/lang/String;
    //   1341: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: goto -654 -> 690
    //   1347: astore_0
    //   1348: goto -704 -> 644
    //   1351: astore_0
    //   1352: aconst_null
    //   1353: astore 8
    //   1355: goto -711 -> 644
    //   1358: astore_1
    //   1359: aconst_null
    //   1360: astore_1
    //   1361: aload 9
    //   1363: astore_2
    //   1364: goto -962 -> 402
    //   1367: astore_1
    //   1368: aconst_null
    //   1369: astore_2
    //   1370: aconst_null
    //   1371: astore_1
    //   1372: goto -970 -> 402
    //   1375: astore_2
    //   1376: aload 7
    //   1378: astore_2
    //   1379: goto -977 -> 402
    //   1382: ldc_w 684
    //   1385: astore_1
    //   1386: goto -564 -> 822
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1389	0	paramString1	String
    //   0	1389	1	paramString2	String
    //   0	1389	2	paramString3	String
    //   0	1389	3	paramMap1	java.util.Map
    //   0	1389	4	paramMap2	java.util.Map
    //   0	1389	5	paramMap3	java.util.Map
    //   442	825	6	i	int
    //   45	1332	7	localHttpURLConnection	java.net.HttpURLConnection
    //   26	1328	8	localObject	Object
    //   29	1333	9	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   47	190	396	java/lang/Exception
    //   199	208	396	java/lang/Exception
    //   208	288	396	java/lang/Exception
    //   288	338	396	java/lang/Exception
    //   338	351	396	java/lang/Exception
    //   351	393	396	java/lang/Exception
    //   484	497	396	java/lang/Exception
    //   501	522	396	java/lang/Exception
    //   522	567	396	java/lang/Exception
    //   572	636	396	java/lang/Exception
    //   697	708	396	java/lang/Exception
    //   713	726	396	java/lang/Exception
    //   726	766	396	java/lang/Exception
    //   770	798	396	java/lang/Exception
    //   808	819	396	java/lang/Exception
    //   822	977	396	java/lang/Exception
    //   1090	1095	396	java/lang/Exception
    //   1120	1127	396	java/lang/Exception
    //   1127	1198	396	java/lang/Exception
    //   1198	1203	396	java/lang/Exception
    //   1207	1219	396	java/lang/Exception
    //   1222	1227	396	java/lang/Exception
    //   47	190	639	finally
    //   199	208	639	finally
    //   208	288	639	finally
    //   288	338	639	finally
    //   338	351	639	finally
    //   351	393	639	finally
    //   484	497	639	finally
    //   501	522	639	finally
    //   522	567	639	finally
    //   572	636	639	finally
    //   697	708	639	finally
    //   713	726	639	finally
    //   726	766	639	finally
    //   770	798	639	finally
    //   808	819	639	finally
    //   822	977	639	finally
    //   1090	1095	639	finally
    //   1120	1127	639	finally
    //   1127	1198	639	finally
    //   1198	1203	639	finally
    //   1207	1219	639	finally
    //   1222	1227	639	finally
    //   1227	1231	639	finally
    //   977	985	1002	java/lang/OutOfMemoryError
    //   991	999	1002	java/lang/OutOfMemoryError
    //   1074	1082	1098	java/lang/Exception
    //   977	985	1119	finally
    //   991	999	1119	finally
    //   1003	1061	1119	finally
    //   1236	1277	1284	java/lang/Exception
    //   438	478	1305	java/lang/Exception
    //   649	690	1326	java/lang/Exception
    //   31	47	1347	finally
    //   405	432	1347	finally
    //   1063	1068	1351	finally
    //   31	47	1358	java/lang/Exception
    //   1063	1068	1367	java/lang/Exception
    //   1227	1231	1375	java/lang/Exception
  }
  
  public static String a(HttpResponse paramHttpResponse)
  {
    return new String(a(paramHttpResponse).toByteArray());
  }
  
  public static final HashMap a(Context paramContext, String paramString1, String paramString2, int paramInt, HashMap paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      paramContext = new HashMap();
    }
    HashMap localHashMap;
    for (;;)
    {
      return paramContext;
      localHashMap = new HashMap(paramHashMap);
      JSONArray localJSONArray = new JSONArray();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramHashMap.get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localJSONArray.put(str2);
          localArrayList.add(str1);
        }
      }
      paramContext = a(paramContext, paramString1, paramString2, paramInt, localJSONArray);
      if (paramContext != null) {
        try
        {
          paramContext = new JSONObject(paramContext);
          paramInt = paramContext.getInt("retcode");
          if (paramBundle != null) {
            paramBundle.putInt("retcode", paramInt);
          }
          if (paramInt == 0)
          {
            paramContext = paramContext.getJSONObject("result");
            if (paramContext == null) {
              return localHashMap;
            }
            paramContext = paramContext.getJSONArray("list");
            if (paramContext == null) {
              return localHashMap;
            }
            if (paramContext.length() != localArrayList.size()) {
              break label328;
            }
            paramString1 = new HashMap();
            paramInt = 0;
            while (paramInt < paramContext.length())
            {
              paramString1.put(localArrayList.get(paramInt), paramContext.getString(paramInt));
              paramInt += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HttpUtil", 2, "batchUrlExchange results: " + paramString1.toString() + ", input: " + paramHashMap);
            }
            paramContext = paramString1;
            if (paramBundle == null) {
              continue;
            }
            paramBundle.putBoolean("isSuccess", true);
            return paramString1;
          }
        }
        catch (JSONException paramContext)
        {
          QLog.d("Q.share.sdk", 4, paramContext.getMessage());
        }
      }
    }
    for (;;)
    {
      return localHashMap;
      label328:
      QLog.e("Q.share.sdk", 4, "!!!!urlArray.length() != srcKeyArray.size()");
    }
  }
  
  public static final HashMap a(HashMap paramHashMap)
  {
    return a(paramHashMap, null);
  }
  
  public static final HashMap a(HashMap paramHashMap, Bundle paramBundle)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap(paramHashMap);
    Object localObject1 = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = (String)paramHashMap.get(localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        ((JSONArray)localObject1).put(localObject3);
        localArrayList.add(localObject2);
      }
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("Referer", "http://openmobile.qq.com/");
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putString("value", ((JSONArray)localObject1).toString());
    ((Bundle)localObject3).putString("mType", "qb_share");
    localIterator = null;
    try
    {
      localObject1 = a(BaseApplication.getContext(), MsfSdkUtils.insertMtype("AppDepart", "http://openmobile.qq.com/api/shortUrl"), "POST", (Bundle)localObject3, (Bundle)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return localHashMap;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localObject1 = localIterator;
        if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, localIOException.getMessage());
          localObject1 = localIterator;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject1 = localIterator;
        if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, localOutOfMemoryError.getMessage());
          localObject1 = localIterator;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).getInt("retcode");
        if (paramBundle != null) {
          paramBundle.putInt("retcode", i);
        }
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label522;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error retcode:" + i);
          break label522;
        }
        paramBundle = ((JSONObject)localObject1).getJSONObject("result");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label525;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label525;
        }
        paramBundle = paramBundle.getJSONArray("list");
        if (paramBundle == null)
        {
          if (!QLog.isColorLevel()) {
            break label528;
          }
          QLog.d("HttpUtil", 2, "shortenUrl error result");
          break label528;
        }
        if (paramBundle.length() == localArrayList.size())
        {
          i = 0;
          if (i < paramBundle.length())
          {
            localObject1 = paramBundle.getString(i);
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label531;
            }
            localHashMap.put(localArrayList.get(i), localObject1);
            break label531;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("HttpUtil", 2, "shortenUrl error result size");
        }
      }
      catch (JSONException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HttpUtil", 2, "shortenUrl parse response error");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "shortenUrl results: " + localHashMap.toString() + ", input: " + paramHashMap);
      }
      return localHashMap;
      label522:
      return localHashMap;
      label525:
      return localHashMap;
      label528:
      return localHashMap;
      label531:
      i += 1;
    }
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, 15000, 30000);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramBundle1, paramBundle2, paramInt1, paramInt2, null);
  }
  
  public static HttpResponse a(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt1, int paramInt2, String paramString4)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      QRUtils.a(paramContext, QRUtils.c);
    }
    if (paramContext == null) {
      return null;
    }
    paramString4 = a(paramContext, paramInt1, paramInt2, paramString4);
    if (paramString4 == null) {
      return null;
    }
    QLog.d("QRHttpUtil", 2, paramString1);
    paramContext = paramString1;
    if (paramString1.contains("#")) {
      paramContext = paramString1.substring(0, paramString1.indexOf('#'));
    }
    paramString1 = paramContext.replace(" ", "%20");
    if ("GET".equals(paramString3))
    {
      paramString3 = a(paramBundle1);
      paramContext = paramString1;
      if (paramString3 != null)
      {
        paramContext = paramString1;
        if (paramString3.length() > 0)
        {
          paramBundle1 = new StringBuilder().append(paramString1);
          if (!paramString1.contains("?")) {
            break label258;
          }
          paramContext = "&";
        }
      }
      for (;;)
      {
        paramContext = paramContext + paramString3;
        try
        {
          paramContext = new HttpGet(paramContext);
          paramContext.addHeader("Accept-Encoding", "gzip");
          paramContext.addHeader("Connection", "close");
          a(paramContext);
          if (paramBundle2 != null)
          {
            paramString1 = paramBundle2.keySet().iterator();
            while (paramString1.hasNext())
            {
              paramString3 = (String)paramString1.next();
              paramBundle1 = paramBundle2.get(paramString3);
              if ((paramBundle1 instanceof String))
              {
                paramContext.addHeader(paramString3, (String)paramBundle1);
                continue;
                label258:
                paramContext = "?";
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramContext.getParams().setParameter("http.virtual-host", new HttpHost(paramString2));
      }
      try
      {
        paramContext = paramString4.execute(paramContext);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail IOException", paramContext);
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label685;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail OutOfMemoryError");
        return null;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label705;
        }
        QLog.d("QRHttpUtil", 2, "openRequest fail Exception", paramContext);
      }
      paramString1 = new HttpPost(paramString1);
      paramString1.addHeader("Accept-Encoding", "gzip");
      paramString1.addHeader("Connection", "close");
      paramContext = "";
      paramInt1 = paramBundle1.getInt("PostBodyType");
      if (paramInt1 == 0)
      {
        paramContext = a(paramBundle1);
        paramString1.setHeader("Content-Type", "application/x-www-form-urlencoded");
      }
      for (;;)
      {
        paramContext = paramContext.getBytes();
        a(paramString1);
        if (paramBundle2 == null) {
          break;
        }
        paramString3 = paramBundle2.keySet().iterator();
        Object localObject1;
        while (paramString3.hasNext())
        {
          paramBundle1 = (String)paramString3.next();
          localObject1 = paramBundle2.get(paramBundle1);
          if ((localObject1 instanceof String)) {
            paramString1.addHeader(paramBundle1, (String)localObject1);
          }
        }
        if (paramInt1 == 1)
        {
          paramString1.setHeader("Content-Type", "application/json; charset=UTF-8");
          paramBundle1.remove("PostBodyType");
          paramContext = new JSONObject();
          paramString3 = paramBundle1.keySet().iterator();
          while (paramString3.hasNext())
          {
            localObject1 = (String)paramString3.next();
            Object localObject2 = paramBundle1.get((String)localObject1);
            try
            {
              if (!(localObject2 instanceof String)) {
                break label568;
              }
              paramContext.put(URLEncoder.encode((String)localObject1), paramBundle1.getString((String)localObject1));
            }
            catch (JSONException localJSONException) {}
            if (QLog.isColorLevel())
            {
              QLog.d("QRHttpUtil", 2, "postBodyType=POST_BODY_TYPE_JSON parse Params to Json failed.");
              continue;
              label568:
              if (((localObject2 instanceof Long)) || ((localObject2 instanceof Integer)) || ((localObject2 instanceof Float)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof Byte))) {
                paramContext.put(URLEncoder.encode(localJSONException), localObject2);
              }
            }
          }
          paramContext = paramContext.toString();
        }
      }
      paramString1.setEntity(new ByteArrayEntity(paramContext));
      paramContext = paramString1;
    }
    label685:
    label705:
    return null;
  }
  
  private static HttpClient a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = null;
    if (paramContext == null)
    {
      paramContext = (Context)localObject;
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new AsyncHttpClient.CustomSSLSocketFactory((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        if (!TextUtils.isEmpty(paramString)) {
          ((SSLSocketFactory)localObject).setHostnameVerifier(new klz(paramString));
        }
        paramString = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(paramString, paramInt1);
        HttpConnectionParams.setSoTimeout(paramString, paramInt2);
        HttpProtocolParams.setVersion(paramString, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(paramString, "UTF-8");
        HttpProtocolParams.setUserAgent(paramString, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
        paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(paramString, localSchemeRegistry), paramString);
        localObject = a(paramContext);
        paramContext = paramString;
        if (localObject == null) {
          break;
        }
        paramContext = new HttpHost(((HttpUtil.NetworkProxy)localObject).jdField_a_of_type_JavaLangString, ((HttpUtil.NetworkProxy)localObject).jdField_a_of_type_Int);
        paramString.getParams().setParameter("http.route.default-proxy", paramContext);
        return paramString;
      }
      catch (Exception localException)
      {
        localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        localSSLSocketFactory.setHostnameVerifier(jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseSNIVerifier);
        continue;
      }
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    }
  }
  
  private static void a(HttpUriRequest paramHttpUriRequest)
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
    paramHttpUriRequest.addHeader("cookie", "uin=" + str1 + ";skey=" + str2);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpUtil", 2, "isConnect(), context == null");
      }
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          paramContext = paramContext.getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (paramContext == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("HttpUtil", 2, paramContext.toString());
    }
    return false;
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str2 = Uri.parse(paramString1).getHost();
      try
      {
        HttpResponse localHttpResponse = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        paramContext = localHttpResponse;
      }
      catch (IOException localIOException)
      {
        while (str2.equals(QRUtils.c))
        {
          str1 = QRUtils.a(paramContext, str2);
          if (str1 == null) {
            break label199;
          }
          paramString1 = paramString1.replace(str2, str1);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str2, paramString2, paramBundle1, paramBundle2);
        }
        throw str1;
      }
      if (paramContext == null) {
        throw new IOException("Http no response.");
      }
      label199:
      for (;;)
      {
        String str1;
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("Http statusCode:" + i);
      }
    }
  }
  
  public static byte[] a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    for (;;)
    {
      String str = Uri.parse(paramString1).getHost();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            continue;
          }
          paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          paramContext = paramString3;
        }
        catch (IOException paramString3)
        {
          if (!str.equals(QRUtils.c)) {
            continue;
          }
          paramString3 = QRUtils.a(paramContext, str);
          if (paramString3 == null) {
            break label241;
          }
          paramString1 = paramString1.replace(str, paramString3);
          QLog.d("QRHttpUtil", 2, "ClientProtocolException reopen: " + paramString1);
          paramContext = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2);
          continue;
          throw new IOException("0");
        }
        if (paramContext != null) {
          break label184;
        }
        throw new IOException("0");
        paramString3 = a(paramContext, paramString1, str, paramString2, paramBundle1, paramBundle2, 15000, 30000, paramString3);
        paramContext = paramString3;
      }
      label184:
      label241:
      for (;;)
      {
        int i = paramContext.getStatusLine().getStatusCode();
        if (i == 200) {
          return a(paramContext).toByteArray();
        }
        throw new IOException("" + i);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
  }
  
  private static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new String[27];
    localObject[0] = "li";
    localObject[1] = "del";
    localObject[2] = "ins";
    localObject[3] = "fieldset";
    localObject[4] = "legend";
    localObject[5] = "tr";
    localObject[6] = "th";
    localObject[7] = "caption";
    localObject[8] = "thead";
    localObject[9] = "tbody";
    localObject[10] = "tfoot";
    localObject[11] = "p";
    localObject[12] = "h[1-6]";
    localObject[13] = "dl";
    localObject[14] = "dt";
    localObject[15] = "dd";
    localObject[16] = "ol";
    localObject[17] = "ul";
    localObject[18] = "dir";
    localObject[19] = "address";
    localObject[20] = "blockquote";
    localObject[21] = "center";
    localObject[22] = "hr";
    localObject[23] = "pre";
    localObject[24] = "form";
    localObject[25] = "textarea";
    localObject[26] = "table";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Matcher localMatcher = Pattern.compile("<(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll(" ");
      }
      localMatcher = Pattern.compile("</?(\\s*" + localObject[i] + ")[^>]*>").matcher(paramString);
      if (localMatcher.find()) {
        paramString = localMatcher.replaceAll("\n");
      }
      i += 1;
    }
    localObject = Pattern.compile("<br>").matcher(paramString);
    if (((Matcher)localObject).find()) {
      paramString = ((Matcher)localObject).replaceAll("\n");
    }
    return paramString.replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */
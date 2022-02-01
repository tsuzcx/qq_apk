package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil;", "", "()V", "TAG", "", "convertStreamToString", "inputStream", "Ljava/io/InputStream;", "getApkDownloadUrl", "downloadScene", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "clickUrl", "parseApkDownloadUrl", "jsonObject", "Lorg/json/JSONObject;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAdUrlChangeUtil
{
  public static final RIJAdUrlChangeUtil a = new RIJAdUrlChangeUtil();
  
  private final String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader((Reader)new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    String str = (String)null;
    for (;;)
    {
      str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  @Nullable
  public final String a(@Nullable com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene paramAdDownloadScene, @Nullable String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: checkcast 74	java/lang/CharSequence
    //   7: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_1
    //   16: getstatic 85	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene:VideoFloatButton	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;
    //   19: if_acmpeq +10 -> 29
    //   22: aload_1
    //   23: getstatic 88	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene:VideoFloatCardButton	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;
    //   26: if_acmpne +251 -> 277
    //   29: ldc 90
    //   31: ldc 92
    //   33: invokestatic 98	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: ldc 100
    //   40: invokestatic 106	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   43: new 108	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   50: aload_2
    //   51: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 114
    //   56: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore_1
    //   67: ldc 117
    //   69: new 108	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   76: ldc 119
    //   78: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 121
    //   87: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   93: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   96: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 135	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aconst_null
    //   103: checkcast 57	java/lang/String
    //   106: astore_3
    //   107: aload_1
    //   108: ifnull +192 -> 300
    //   111: aload_1
    //   112: astore_2
    //   113: aconst_null
    //   114: checkcast 137	java/net/HttpURLConnection
    //   117: astore 4
    //   119: aload 4
    //   121: astore_1
    //   122: new 139	java/net/URL
    //   125: dup
    //   126: aload_2
    //   127: invokespecial 142	java/net/URL:<init>	(Ljava/lang/String;)V
    //   130: invokevirtual 146	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   133: astore_2
    //   134: aload 4
    //   136: astore_1
    //   137: aload_2
    //   138: instanceof 137
    //   141: ifne +291 -> 432
    //   144: aload 5
    //   146: astore_2
    //   147: aload 4
    //   149: astore_1
    //   150: aload_2
    //   151: checkcast 137	java/net/HttpURLConnection
    //   154: astore_2
    //   155: aload_2
    //   156: ifnull +47 -> 203
    //   159: aload_2
    //   160: ldc 148
    //   162: invokevirtual 151	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   165: aload_2
    //   166: ldc 153
    //   168: ldc 155
    //   170: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: ldc 160
    //   176: ldc 162
    //   178: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_2
    //   182: ldc 164
    //   184: ldc 166
    //   186: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_2
    //   190: sipush 3000
    //   193: invokevirtual 170	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   196: aload_2
    //   197: sipush 3000
    //   200: invokevirtual 173	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   203: aload_2
    //   204: ifnull +160 -> 364
    //   207: aload_2
    //   208: invokevirtual 177	java/net/HttpURLConnection:getResponseCode	()I
    //   211: sipush 200
    //   214: if_icmpne +150 -> 364
    //   217: aload_0
    //   218: aload_2
    //   219: invokevirtual 181	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   222: invokespecial 183	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: checkcast 74	java/lang/CharSequence
    //   230: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifne +73 -> 306
    //   236: aload_0
    //   237: new 185	org/json/JSONObject
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: invokevirtual 189	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   248: astore_1
    //   249: aload_1
    //   250: astore 4
    //   252: aload_2
    //   253: ifnull +10 -> 263
    //   256: aload_2
    //   257: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   260: aload_1
    //   261: astore 4
    //   263: aload 4
    //   265: areturn
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 195	java/lang/Exception:printStackTrace	()V
    //   271: ldc 196
    //   273: astore_1
    //   274: goto -231 -> 43
    //   277: new 108	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   284: aload_2
    //   285: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 198
    //   290: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore_1
    //   297: goto -230 -> 67
    //   300: ldc 196
    //   302: astore_2
    //   303: goto -190 -> 113
    //   306: ldc 117
    //   308: ldc 200
    //   310: invokestatic 135	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_3
    //   314: astore_1
    //   315: goto -66 -> 249
    //   318: astore 5
    //   320: aload_2
    //   321: astore_1
    //   322: ldc 117
    //   324: new 108	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   331: ldc 202
    //   333: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 5
    //   338: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 135	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_3
    //   348: astore 4
    //   350: aload_2
    //   351: ifnull -88 -> 263
    //   354: aload_2
    //   355: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   358: aload_3
    //   359: astore 4
    //   361: goto -98 -> 263
    //   364: new 108	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   371: ldc 207
    //   373: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: astore_1
    //   377: aload_2
    //   378: ifnonnull +6 -> 384
    //   381: invokestatic 210	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   384: ldc 117
    //   386: aload_1
    //   387: aload_2
    //   388: invokevirtual 177	java/net/HttpURLConnection:getResponseCode	()I
    //   391: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 135	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_3
    //   401: astore_1
    //   402: goto -153 -> 249
    //   405: astore_1
    //   406: aload_2
    //   407: ifnull +7 -> 414
    //   410: aload_2
    //   411: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   414: aload_1
    //   415: athrow
    //   416: astore_3
    //   417: aload_1
    //   418: astore_2
    //   419: aload_3
    //   420: astore_1
    //   421: goto -15 -> 406
    //   424: astore 5
    //   426: aload 4
    //   428: astore_2
    //   429: goto -109 -> 320
    //   432: goto -285 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	RIJAdUrlChangeUtil
    //   0	435	1	paramAdDownloadScene	com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene
    //   0	435	2	paramString	String
    //   106	295	3	str	String
    //   416	4	3	localObject1	Object
    //   117	310	4	localObject2	Object
    //   1	144	5	localObject3	Object
    //   318	19	5	localException1	java.lang.Exception
    //   424	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   29	43	266	java/lang/Exception
    //   159	203	318	java/lang/Exception
    //   207	249	318	java/lang/Exception
    //   306	313	318	java/lang/Exception
    //   364	377	318	java/lang/Exception
    //   381	384	318	java/lang/Exception
    //   384	400	318	java/lang/Exception
    //   159	203	405	finally
    //   207	249	405	finally
    //   306	313	405	finally
    //   364	377	405	finally
    //   381	384	405	finally
    //   384	400	405	finally
    //   122	134	416	finally
    //   137	144	416	finally
    //   150	155	416	finally
    //   322	347	416	finally
    //   122	134	424	java/lang/Exception
    //   137	144	424	java/lang/Exception
    //   150	155	424	java/lang/Exception
  }
  
  @Nullable
  public final String a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    try
    {
      String str2 = paramJSONObject.optString("apkUrl");
      Intrinsics.checkExpressionValueIsNotNull(str2, "jsonObject.optString(\"apkUrl\")");
      String str1 = str2;
      return str2;
    }
    catch (Throwable paramJSONObject)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)str2))
        {
          str1 = paramJSONObject.optJSONObject("data").optString("dstlink");
          Intrinsics.checkExpressionValueIsNotNull(str1, "jsonObject.optJSONObject…ta\").optString(\"dstlink\")");
        }
        return str1;
      }
      catch (Throwable paramJSONObject) {}
      paramJSONObject = paramJSONObject;
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdUrlChangeUtil
 * JD-Core Version:    0.7.0.1
 */
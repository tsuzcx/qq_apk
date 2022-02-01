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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil;", "", "()V", "TAG", "", "convertStreamToString", "inputStream", "Ljava/io/InputStream;", "getApkDownloadUrl", "downloadScene", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;", "clickUrl", "parseApkDownloadUrl", "jsonObject", "Lorg/json/JSONObject;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
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
    //   0: aload_2
    //   1: checkcast 74	java/lang/CharSequence
    //   4: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_1
    //   13: getstatic 85	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene:VideoFloatButton	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;
    //   16: if_acmpeq +42 -> 58
    //   19: aload_1
    //   20: getstatic 88	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene:VideoFloatCardButton	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/AdDownloadScene;
    //   23: if_acmpne +6 -> 29
    //   26: goto +32 -> 58
    //   29: new 90	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   36: astore_1
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: ldc 96
    //   46: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_1
    //   55: goto +60 -> 115
    //   58: ldc 99
    //   60: ldc 101
    //   62: invokestatic 107	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: ldc 109
    //   69: invokestatic 115	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: goto +11 -> 83
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   80: ldc 119
    //   82: astore_1
    //   83: new 90	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   90: astore_3
    //   91: aload_3
    //   92: aload_2
    //   93: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: ldc 121
    //   100: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_3
    //   105: aload_1
    //   106: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore_1
    //   115: new 90	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   122: astore_2
    //   123: aload_2
    //   124: ldc 123
    //   126: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: aload_1
    //   132: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: ldc 125
    //   139: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   147: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 136
    //   153: aload_2
    //   154: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 141	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aconst_null
    //   161: checkcast 57	java/lang/String
    //   164: astore_3
    //   165: aload_1
    //   166: ifnull +8 -> 174
    //   169: aload_1
    //   170: astore_2
    //   171: goto +6 -> 177
    //   174: ldc 119
    //   176: astore_2
    //   177: aconst_null
    //   178: checkcast 143	java/net/HttpURLConnection
    //   181: astore 4
    //   183: aload 4
    //   185: astore_1
    //   186: new 145	java/net/URL
    //   189: dup
    //   190: aload_2
    //   191: invokespecial 148	java/net/URL:<init>	(Ljava/lang/String;)V
    //   194: invokevirtual 152	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   197: astore 5
    //   199: aload 5
    //   201: astore_2
    //   202: aload 4
    //   204: astore_1
    //   205: aload 5
    //   207: instanceof 143
    //   210: ifne +5 -> 215
    //   213: aconst_null
    //   214: astore_2
    //   215: aload 4
    //   217: astore_1
    //   218: aload_2
    //   219: checkcast 143	java/net/HttpURLConnection
    //   222: astore_2
    //   223: aload_2
    //   224: ifnull +50 -> 274
    //   227: aload_2
    //   228: ldc 154
    //   230: invokevirtual 157	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   233: aload_2
    //   234: ldc 159
    //   236: ldc 161
    //   238: invokevirtual 164	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_2
    //   242: ldc 166
    //   244: ldc 168
    //   246: invokevirtual 164	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc 170
    //   252: ldc 172
    //   254: invokevirtual 164	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_2
    //   258: sipush 3000
    //   261: invokevirtual 176	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   264: aload_2
    //   265: sipush 3000
    //   268: invokevirtual 179	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   271: goto +3 -> 274
    //   274: aload_2
    //   275: ifnull +60 -> 335
    //   278: aload_2
    //   279: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   282: sipush 200
    //   285: if_icmpne +50 -> 335
    //   288: aload_0
    //   289: aload_2
    //   290: invokevirtual 187	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   293: invokespecial 189	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   296: astore_1
    //   297: aload_1
    //   298: checkcast 74	java/lang/CharSequence
    //   301: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne +19 -> 323
    //   307: aload_0
    //   308: new 191	org/json/JSONObject
    //   311: dup
    //   312: aload_1
    //   313: invokespecial 192	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   316: invokevirtual 195	com/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   319: astore_1
    //   320: goto +57 -> 377
    //   323: ldc 136
    //   325: ldc 197
    //   327: invokestatic 141	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_3
    //   331: astore_1
    //   332: goto +45 -> 377
    //   335: new 90	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   342: astore_1
    //   343: aload_1
    //   344: ldc 199
    //   346: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_2
    //   351: ifnonnull +6 -> 357
    //   354: invokestatic 202	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   357: aload_1
    //   358: aload_2
    //   359: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   362: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc 136
    //   368: aload_1
    //   369: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 141	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_3
    //   376: astore_1
    //   377: aload_1
    //   378: astore 4
    //   380: aload_2
    //   381: ifnull +81 -> 462
    //   384: aload_2
    //   385: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   388: aload_1
    //   389: areturn
    //   390: astore_3
    //   391: aload_1
    //   392: astore_2
    //   393: aload_3
    //   394: astore_1
    //   395: goto +70 -> 465
    //   398: astore_1
    //   399: aload 4
    //   401: astore_2
    //   402: aload_1
    //   403: astore 4
    //   405: aload_2
    //   406: astore_1
    //   407: new 90	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   414: astore 5
    //   416: aload_2
    //   417: astore_1
    //   418: aload 5
    //   420: ldc 210
    //   422: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_2
    //   427: astore_1
    //   428: aload 5
    //   430: aload 4
    //   432: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: astore_1
    //   438: ldc 136
    //   440: aload 5
    //   442: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 141	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload_3
    //   449: astore 4
    //   451: aload_2
    //   452: ifnull +10 -> 462
    //   455: aload_2
    //   456: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   459: aload_3
    //   460: astore 4
    //   462: aload 4
    //   464: areturn
    //   465: aload_2
    //   466: ifnull +7 -> 473
    //   469: aload_2
    //   470: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   473: aload_1
    //   474: athrow
    //   475: astore_1
    //   476: goto -11 -> 465
    //   479: astore 4
    //   481: goto -76 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	RIJAdUrlChangeUtil
    //   0	484	1	paramAdDownloadScene	com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene
    //   0	484	2	paramString	String
    //   90	286	3	localObject1	Object
    //   390	70	3	localObject2	Object
    //   181	282	4	localObject3	Object
    //   479	1	4	localException	java.lang.Exception
    //   197	244	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   58	72	75	java/lang/Exception
    //   186	199	390	finally
    //   205	213	390	finally
    //   218	223	390	finally
    //   407	416	390	finally
    //   418	426	390	finally
    //   428	436	390	finally
    //   438	448	390	finally
    //   186	199	398	java/lang/Exception
    //   205	213	398	java/lang/Exception
    //   218	223	398	java/lang/Exception
    //   227	271	475	finally
    //   278	320	475	finally
    //   323	330	475	finally
    //   335	350	475	finally
    //   354	357	475	finally
    //   357	375	475	finally
    //   227	271	479	java/lang/Exception
    //   278	320	479	java/lang/Exception
    //   323	330	479	java/lang/Exception
    //   335	350	479	java/lang/Exception
    //   354	357	479	java/lang/Exception
    //   357	375	479	java/lang/Exception
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
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)str2))
          {
            paramJSONObject = paramJSONObject.optJSONObject("data").optString("dstlink");
            Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "jsonObject.optJSONObject…ta\").optString(\"dstlink\")");
            return paramJSONObject;
            str1 = "";
          }
          return str1;
        }
        catch (Throwable paramJSONObject) {}
        paramJSONObject = paramJSONObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdUrlChangeUtil
 * JD-Core Version:    0.7.0.1
 */
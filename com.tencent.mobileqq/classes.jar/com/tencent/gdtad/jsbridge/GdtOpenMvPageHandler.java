package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class GdtOpenMvPageHandler
  implements GdtJsCallHandler
{
  private WeakReference<GdtAdWebPlugin> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public long a(long paramLong, String paramString1, String paramString2)
  {
    return ((paramLong ^ paramLong >>> 32) * 31L + paramString1.hashCode()) * 31L + paramString2.hashCode();
  }
  
  public void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    if (paramGdtMotiveVideoPageData != null)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(a(paramGdtMotiveVideoPageData.adId, paramGdtMotiveVideoPageData.url, paramGdtMotiveVideoPageData.adsContent)));
      if (str != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramGdtMotiveVideoPageData);
        paramGdtMotiveVideoPageData = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (paramGdtMotiveVideoPageData != null)
        {
          paramGdtMotiveVideoPageData = (GdtAdWebPlugin)paramGdtMotiveVideoPageData.get();
          if (paramGdtMotiveVideoPageData != null)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("callResultFunc2Web elapsedtime ");
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(" totaltime ");
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append(" isEnd ");
            ((StringBuilder)localObject).append(paramString3);
            QLog.w("GdtOpenMvPageHandler", 1, ((StringBuilder)localObject).toString());
            localObject = new JSONObject();
            try
            {
              ((JSONObject)localObject).put("elapsedTime", paramString1);
              ((JSONObject)localObject).put("totalTime", paramString2);
              ((JSONObject)localObject).put("isEnd", paramString3);
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
            }
            paramGdtMotiveVideoPageData.callJs(str, new String[] { ((JSONObject)localObject).toString() });
          }
        }
      }
    }
  }
  
  /* Error */
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_1
    //   8: invokevirtual 124	com/tencent/gdtad/jsbridge/GdtAdWebPlugin:a	()Landroid/app/Activity;
    //   11: astore 8
    //   13: goto +6 -> 19
    //   16: aconst_null
    //   17: astore 8
    //   19: aload_1
    //   20: ifnull +394 -> 414
    //   23: aload 8
    //   25: ifnonnull +6 -> 31
    //   28: goto +386 -> 414
    //   31: iconst_0
    //   32: istore 4
    //   34: iconst_0
    //   35: istore 5
    //   37: new 74	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   44: astore 7
    //   46: aload 7
    //   48: ldc 126
    //   50: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: aload_3
    //   57: iconst_0
    //   58: aaload
    //   59: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 87
    //   65: aload 7
    //   67: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 131	com/tencent/gdtad/log/GdtLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: new 99	org/json/JSONObject
    //   76: dup
    //   77: aload_3
    //   78: iconst_0
    //   79: aaload
    //   80: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   83: astore 7
    //   85: aload 7
    //   87: ldc 136
    //   89: invokevirtual 140	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   92: istore 6
    //   94: iload 5
    //   96: istore 4
    //   98: aload 7
    //   100: ldc 142
    //   102: invokevirtual 146	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_3
    //   106: iload 5
    //   108: istore 4
    //   110: aload 7
    //   112: ldc 148
    //   114: iconst_0
    //   115: invokevirtual 151	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   118: istore 5
    //   120: iload 5
    //   122: istore 4
    //   124: ldc 153
    //   126: new 153	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   129: dup
    //   130: invokespecial 154	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   133: new 99	org/json/JSONObject
    //   136: dup
    //   137: aload_3
    //   138: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: invokestatic 159	com/tencent/gdtad/json/GdtJsonPbUtil:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   144: invokevirtual 164	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 153	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   150: astore_3
    //   151: aload 7
    //   153: ldc 166
    //   155: invokevirtual 146	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 7
    //   160: iload 5
    //   162: istore 4
    //   164: iload 6
    //   166: istore 5
    //   168: goto +48 -> 216
    //   171: astore 7
    //   173: iload 5
    //   175: istore 4
    //   177: iload 6
    //   179: istore 5
    //   181: goto +21 -> 202
    //   184: astore 7
    //   186: aconst_null
    //   187: astore_3
    //   188: iload 6
    //   190: istore 5
    //   192: goto +10 -> 202
    //   195: astore 7
    //   197: aconst_null
    //   198: astore_3
    //   199: iconst_0
    //   200: istore 5
    //   202: ldc 87
    //   204: iconst_1
    //   205: ldc 168
    //   207: aload 7
    //   209: invokestatic 172	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: ldc 174
    //   214: astore 7
    //   216: aload_3
    //   217: iload 5
    //   219: invokestatic 179	com/tencent/gdtad/util/GdtUtil:a	(I)I
    //   222: invokestatic 182	com/tencent/gdtad/util/GdtUtil:a	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;I)Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;
    //   225: astore 11
    //   227: aload 11
    //   229: ifnull +138 -> 367
    //   232: aload_0
    //   233: getfield 20	com/tencent/gdtad/jsbridge/GdtOpenMvPageHandler:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   236: aload_0
    //   237: aload 11
    //   239: getfield 39	com/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData:adId	J
    //   242: aload 11
    //   244: getfield 43	com/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData:url	Ljava/lang/String;
    //   247: aload 11
    //   249: getfield 46	com/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData:adsContent	Ljava/lang/String;
    //   252: invokevirtual 48	com/tencent/gdtad/jsbridge/GdtOpenMvPageHandler:a	(JLjava/lang/String;Ljava/lang/String;)J
    //   255: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   258: aload_2
    //   259: invokeinterface 185 3 0
    //   264: pop
    //   265: aload_0
    //   266: new 67	java/lang/ref/WeakReference
    //   269: dup
    //   270: aload_1
    //   271: invokespecial 188	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   274: putfield 65	com/tencent/gdtad/jsbridge/GdtOpenMvPageHandler:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   277: aload 8
    //   279: invokevirtual 194	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   282: ldc 196
    //   284: invokevirtual 201	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 10
    //   289: aload 10
    //   291: astore_2
    //   292: aload 10
    //   294: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifeq +14 -> 311
    //   300: aload 8
    //   302: invokevirtual 194	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   305: ldc 209
    //   307: invokevirtual 201	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   310: astore_2
    //   311: aload 11
    //   313: aload_2
    //   314: putfield 212	com/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData:refId	Ljava/lang/String;
    //   317: iload 4
    //   319: ifle +10 -> 329
    //   322: aload 11
    //   324: iload 4
    //   326: invokevirtual 216	com/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData:setVideoCountDown	(I)V
    //   329: aload 7
    //   331: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: ifne +10 -> 344
    //   337: aload 11
    //   339: aload 7
    //   341: invokevirtual 219	com/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData:setRewardText	(Ljava/lang/String;)V
    //   344: ldc 221
    //   346: invokestatic 227	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   349: checkcast 221	com/tencent/gdtad/IGdtAPI
    //   352: aload_1
    //   353: invokevirtual 124	com/tencent/gdtad/jsbridge/GdtAdWebPlugin:a	()Landroid/app/Activity;
    //   356: aload 11
    //   358: aconst_null
    //   359: invokestatic 233	com/tencent/gdtad/basics/motivevideo/data/StartGdtMotiveVideoParams:b	(Landroid/app/Activity;Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;Landroid/os/ResultReceiver;)Lcom/tencent/gdtad/basics/motivevideo/data/StartGdtMotiveVideoParams;
    //   362: invokeinterface 237 2 0
    //   367: aload_1
    //   368: ifnull +11 -> 379
    //   371: aload_1
    //   372: invokevirtual 124	com/tencent/gdtad/jsbridge/GdtAdWebPlugin:a	()Landroid/app/Activity;
    //   375: astore_2
    //   376: goto +5 -> 381
    //   379: aconst_null
    //   380: astore_2
    //   381: aload 9
    //   383: astore 7
    //   385: aload_1
    //   386: ifnull +9 -> 395
    //   389: aload_1
    //   390: invokevirtual 239	com/tencent/gdtad/jsbridge/GdtAdWebPlugin:a	()Ljava/lang/String;
    //   393: astore 7
    //   395: aload_2
    //   396: iconst_1
    //   397: ldc 241
    //   399: aload 7
    //   401: new 243	com/tencent/gdtad/aditem/GdtAd
    //   404: dup
    //   405: aload_3
    //   406: invokespecial 246	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   409: invokestatic 252	com/tencent/ad/tangram/statistics/AdAnalysisHelperForUtil:reportForJSBridgeInvoked	(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Lcom/tencent/ad/tangram/Ad;)V
    //   412: iconst_1
    //   413: ireturn
    //   414: ldc 87
    //   416: ldc 254
    //   418: invokestatic 257	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: iconst_1
    //   422: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	GdtOpenMvPageHandler
    //   0	423	1	paramGdtAdWebPlugin	GdtAdWebPlugin
    //   0	423	2	paramString	String
    //   0	423	3	paramVarArgs	String[]
    //   32	293	4	i	int
    //   35	183	5	j	int
    //   92	97	6	k	int
    //   44	115	7	localObject1	Object
    //   171	1	7	localThrowable1	java.lang.Throwable
    //   184	1	7	localThrowable2	java.lang.Throwable
    //   195	13	7	localThrowable3	java.lang.Throwable
    //   214	186	7	localObject2	Object
    //   11	290	8	localActivity	android.app.Activity
    //   1	381	9	localObject3	Object
    //   287	6	10	str	String
    //   225	132	11	localGdtMotiveVideoPageData	GdtMotiveVideoPageData
    // Exception table:
    //   from	to	target	type
    //   151	160	171	java/lang/Throwable
    //   98	106	184	java/lang/Throwable
    //   110	120	184	java/lang/Throwable
    //   124	151	184	java/lang/Throwable
    //   37	94	195	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtOpenMvPageHandler
 * JD-Core Version:    0.7.0.1
 */
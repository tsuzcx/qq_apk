import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bjtp
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("[mini] QzonePublishPlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  /* Error */
  @com.tencent.qqmini.sdk.annotation.JsEvent({"checkin_qzoneUploadAndPublish"})
  public void checkinQzoneUploadAndPublish(RequestEvent paramRequestEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 59	bjtp:a	(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)Lorg/json/JSONObject;
    //   5: ldc 61
    //   7: invokevirtual 65	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10: astore 9
    //   12: aload 9
    //   14: ifnull +525 -> 539
    //   17: aload 9
    //   19: ldc 67
    //   21: invokevirtual 71	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 73	java/lang/String
    //   27: astore 13
    //   29: aload 9
    //   31: ldc 75
    //   33: invokevirtual 71	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 73	java/lang/String
    //   39: astore 14
    //   41: aload 9
    //   43: ldc 77
    //   45: invokevirtual 71	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: checkcast 73	java/lang/String
    //   51: astore 8
    //   53: aload 8
    //   55: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +489 -> 547
    //   61: aload_0
    //   62: getfield 87	bjtp:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   65: ldc 89
    //   67: invokeinterface 95 2 0
    //   72: checkcast 89	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   75: aload 8
    //   77: invokeinterface 99 2 0
    //   82: astore 8
    //   84: aload 9
    //   86: ldc 101
    //   88: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   91: istore 7
    //   93: aload 9
    //   95: ldc 107
    //   97: invokevirtual 110	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   100: astore 10
    //   102: new 112	cooperation/qzone/LbsDataV2$PoiInfo
    //   105: dup
    //   106: invokespecial 113	cooperation/qzone/LbsDataV2$PoiInfo:<init>	()V
    //   109: astore 15
    //   111: aload 10
    //   113: ifnull +73 -> 186
    //   116: aload 10
    //   118: ldc 115
    //   120: invokevirtual 119	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   123: dstore_2
    //   124: aload 10
    //   126: ldc 121
    //   128: invokevirtual 119	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   131: dstore 4
    //   133: aload 10
    //   135: ldc 123
    //   137: invokevirtual 105	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   140: pop
    //   141: aload 10
    //   143: ldc 125
    //   145: invokevirtual 128	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 10
    //   150: aload 15
    //   152: getfield 132	cooperation/qzone/LbsDataV2$PoiInfo:gpsInfo	Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   155: dload_2
    //   156: ldc2_w 133
    //   159: dmul
    //   160: d2i
    //   161: putfield 140	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   164: aload 15
    //   166: getfield 132	cooperation/qzone/LbsDataV2$PoiInfo:gpsInfo	Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   169: dload 4
    //   171: ldc2_w 133
    //   174: dmul
    //   175: d2i
    //   176: putfield 143	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   179: aload 15
    //   181: aload 10
    //   183: putfield 146	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   186: aconst_null
    //   187: astore 10
    //   189: aload 9
    //   191: ldc 148
    //   193: invokevirtual 110	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   196: astore 11
    //   198: aload 11
    //   200: ifnull +12 -> 212
    //   203: aload 11
    //   205: ldc 150
    //   207: invokevirtual 128	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 10
    //   212: new 152	java/util/HashMap
    //   215: dup
    //   216: invokespecial 153	java/util/HashMap:<init>	()V
    //   219: astore 16
    //   221: aload 9
    //   223: ldc 155
    //   225: invokevirtual 110	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   228: astore 11
    //   230: aload 11
    //   232: ifnull +87 -> 319
    //   235: aload 11
    //   237: invokevirtual 159	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   240: astore 12
    //   242: aload 12
    //   244: invokeinterface 165 1 0
    //   249: ifeq +70 -> 319
    //   252: aload 12
    //   254: invokeinterface 169 1 0
    //   259: checkcast 73	java/lang/String
    //   262: astore 17
    //   264: aload 16
    //   266: aload 17
    //   268: aload 11
    //   270: aload 17
    //   272: invokevirtual 128	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 173	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: goto -37 -> 242
    //   282: astore_1
    //   283: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +12 -> 298
    //   289: ldc 29
    //   291: iconst_2
    //   292: ldc 178
    //   294: aload_1
    //   295: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   298: return
    //   299: astore 8
    //   301: ldc 29
    //   303: iconst_1
    //   304: aload 8
    //   306: iconst_0
    //   307: anewarray 183	java/lang/Object
    //   310: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   313: aconst_null
    //   314: astore 9
    //   316: goto -304 -> 12
    //   319: new 188	java/util/ArrayList
    //   322: dup
    //   323: invokespecial 189	java/util/ArrayList:<init>	()V
    //   326: astore 17
    //   328: aconst_null
    //   329: astore 11
    //   331: aload 9
    //   333: ldc 191
    //   335: invokevirtual 110	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   338: astore 18
    //   340: aload 18
    //   342: ifnull +72 -> 414
    //   345: aload 18
    //   347: ldc 193
    //   349: invokevirtual 128	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 12
    //   354: aload 18
    //   356: ldc 195
    //   358: invokevirtual 199	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   361: astore 18
    //   363: aload 12
    //   365: astore 11
    //   367: aload 18
    //   369: ifnull +45 -> 414
    //   372: iconst_0
    //   373: istore 6
    //   375: aload 12
    //   377: astore 11
    //   379: iload 6
    //   381: aload 18
    //   383: invokevirtual 205	org/json/JSONArray:length	()I
    //   386: if_icmpge +28 -> 414
    //   389: aload 17
    //   391: aload 18
    //   393: iload 6
    //   395: invokevirtual 209	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   398: checkcast 73	java/lang/String
    //   401: invokevirtual 213	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   404: pop
    //   405: iload 6
    //   407: iconst_1
    //   408: iadd
    //   409: istore 6
    //   411: goto -36 -> 375
    //   414: new 152	java/util/HashMap
    //   417: dup
    //   418: invokespecial 153	java/util/HashMap:<init>	()V
    //   421: astore 12
    //   423: aload 9
    //   425: ldc 215
    //   427: invokevirtual 110	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   430: astore 9
    //   432: aload 9
    //   434: ifnull +50 -> 484
    //   437: aload 9
    //   439: invokevirtual 159	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   442: astore 18
    //   444: aload 18
    //   446: invokeinterface 165 1 0
    //   451: ifeq +33 -> 484
    //   454: aload 18
    //   456: invokeinterface 169 1 0
    //   461: checkcast 73	java/lang/String
    //   464: astore 19
    //   466: aload 12
    //   468: aload 19
    //   470: aload 9
    //   472: aload 19
    //   474: invokevirtual 128	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   477: invokevirtual 173	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   480: pop
    //   481: goto -37 -> 444
    //   484: new 188	java/util/ArrayList
    //   487: dup
    //   488: invokespecial 189	java/util/ArrayList:<init>	()V
    //   491: astore 9
    //   493: aload 9
    //   495: aload 8
    //   497: invokevirtual 213	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   500: pop
    //   501: invokestatic 220	blsi:a	()Lblsi;
    //   504: aload 13
    //   506: putfield 222	blsi:a	Ljava/lang/String;
    //   509: aload 14
    //   511: aload 9
    //   513: iload 7
    //   515: aload 15
    //   517: aload 10
    //   519: aload 11
    //   521: aload 17
    //   523: aload 12
    //   525: aload 16
    //   527: ldc 224
    //   529: iconst_2
    //   530: invokestatic 229	blsb:a	(Ljava/lang/String;Ljava/util/ArrayList;ILcooperation/qzone/LbsDataV2$PoiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;I)V
    //   533: aload_1
    //   534: invokevirtual 232	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:ok	()Ljava/lang/String;
    //   537: pop
    //   538: return
    //   539: aload_1
    //   540: ldc 234
    //   542: invokevirtual 237	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:fail	(Ljava/lang/String;)Ljava/lang/String;
    //   545: pop
    //   546: return
    //   547: goto -463 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	bjtp
    //   0	550	1	paramRequestEvent	RequestEvent
    //   123	33	2	d1	double
    //   131	39	4	d2	double
    //   373	37	6	i	int
    //   91	423	7	j	int
    //   51	32	8	str1	java.lang.String
    //   299	197	8	localThrowable	java.lang.Throwable
    //   10	502	9	localObject1	java.lang.Object
    //   100	418	10	localObject2	java.lang.Object
    //   196	324	11	localObject3	java.lang.Object
    //   240	284	12	localObject4	java.lang.Object
    //   27	478	13	str2	java.lang.String
    //   39	471	14	str3	java.lang.String
    //   109	407	15	localPoiInfo	cooperation.qzone.LbsDataV2.PoiInfo
    //   219	307	16	localHashMap	java.util.HashMap
    //   262	260	17	localObject5	java.lang.Object
    //   338	117	18	localObject6	java.lang.Object
    //   464	9	19	str4	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   17	84	282	java/lang/Exception
    //   84	111	282	java/lang/Exception
    //   116	186	282	java/lang/Exception
    //   189	198	282	java/lang/Exception
    //   203	212	282	java/lang/Exception
    //   212	230	282	java/lang/Exception
    //   235	242	282	java/lang/Exception
    //   242	279	282	java/lang/Exception
    //   319	328	282	java/lang/Exception
    //   331	340	282	java/lang/Exception
    //   345	363	282	java/lang/Exception
    //   379	405	282	java/lang/Exception
    //   414	432	282	java/lang/Exception
    //   437	444	282	java/lang/Exception
    //   444	481	282	java/lang/Exception
    //   484	538	282	java/lang/Exception
    //   0	12	299	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtp
 * JD-Core Version:    0.7.0.1
 */
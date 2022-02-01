package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.os.Build;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TaskException
{
  private static String TAG = "kandianreport.TaskException";
  
  /* Error */
  public static void reportCrash(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 24	org/json/JSONObject
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore 13
    //   12: aload 13
    //   14: ldc 28
    //   16: invokevirtual 32	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   19: istore 6
    //   21: aload 13
    //   23: ldc 34
    //   25: invokevirtual 38	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 11
    //   30: aload 13
    //   32: ldc 40
    //   34: invokevirtual 38	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 12
    //   39: aload 13
    //   41: ldc 42
    //   43: invokevirtual 38	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 14
    //   48: aload 13
    //   50: ldc 44
    //   52: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   55: istore_2
    //   56: aload 13
    //   58: ldc 50
    //   60: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   63: i2l
    //   64: lstore 7
    //   66: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   69: iconst_1
    //   70: new 52	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   77: ldc 55
    //   79: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload 6
    //   84: invokevirtual 62	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   87: ldc 64
    //   89: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 11
    //   94: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 64
    //   99: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 12
    //   104: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 64
    //   109: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 14
    //   114: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 64
    //   119: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: iload_2
    //   123: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc 64
    //   128: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: lload 7
    //   133: invokevirtual 70	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   136: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload 14
    //   144: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +336 -> 483
    //   150: aload 14
    //   152: ldc 88
    //   154: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   157: ifne +326 -> 483
    //   160: ldc 95
    //   162: ldc 97
    //   164: invokestatic 103	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: checkcast 90	java/lang/String
    //   170: astore 12
    //   172: new 105	org/json/JSONArray
    //   175: dup
    //   176: invokespecial 106	org/json/JSONArray:<init>	()V
    //   179: astore 11
    //   181: aload 12
    //   183: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: istore 6
    //   188: iload 6
    //   190: ifne +294 -> 484
    //   193: new 105	org/json/JSONArray
    //   196: dup
    //   197: aload 12
    //   199: invokespecial 107	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   202: astore 12
    //   204: aload 12
    //   206: astore 11
    //   208: aload 11
    //   210: lload 7
    //   212: invokevirtual 111	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   215: pop
    //   216: sipush 194
    //   219: invokestatic 117	com/tencent/aladdin/config/Aladdin:getConfig	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   222: ldc 119
    //   224: sipush 300
    //   227: invokevirtual 125	com/tencent/aladdin/config/AladdinConfig:getInteger	(Ljava/lang/String;I)I
    //   230: istore 4
    //   232: sipush 194
    //   235: invokestatic 117	com/tencent/aladdin/config/Aladdin:getConfig	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   238: ldc 127
    //   240: iconst_2
    //   241: invokevirtual 125	com/tencent/aladdin/config/AladdinConfig:getInteger	(Ljava/lang/String;I)I
    //   244: istore 5
    //   246: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   249: lstore 7
    //   251: aload 11
    //   253: invokevirtual 137	org/json/JSONArray:length	()I
    //   256: istore_2
    //   257: iconst_0
    //   258: istore_1
    //   259: iload_2
    //   260: iconst_1
    //   261: isub
    //   262: istore_3
    //   263: iload_1
    //   264: istore_2
    //   265: iload_3
    //   266: iflt +42 -> 308
    //   269: aload 11
    //   271: iload_3
    //   272: invokevirtual 141	org/json/JSONArray:getLong	(I)J
    //   275: lstore 9
    //   277: iload_1
    //   278: istore_2
    //   279: lload 7
    //   281: lload 9
    //   283: lsub
    //   284: iload 4
    //   286: bipush 60
    //   288: imul
    //   289: sipush 1000
    //   292: imul
    //   293: i2l
    //   294: lcmp
    //   295: ifgt +7 -> 302
    //   298: iload_1
    //   299: iconst_1
    //   300: iadd
    //   301: istore_2
    //   302: iload_2
    //   303: iload 5
    //   305: if_icmplt +182 -> 487
    //   308: iload_2
    //   309: iload 5
    //   311: if_icmplt +87 -> 398
    //   314: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   317: iconst_1
    //   318: new 52	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   325: ldc 143
    //   327: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload_2
    //   331: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc 145
    //   336: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 4
    //   341: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc 147
    //   346: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: ldc 152
    //   357: iconst_0
    //   358: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: invokestatic 161	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   364: ldc 163
    //   366: invokestatic 169	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   369: checkcast 163	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   372: aconst_null
    //   373: ldc 97
    //   375: ldc 171
    //   377: ldc 171
    //   379: iconst_0
    //   380: iconst_0
    //   381: ldc 97
    //   383: ldc 97
    //   385: ldc 97
    //   387: aload 13
    //   389: invokevirtual 172	org/json/JSONObject:toString	()Ljava/lang/String;
    //   392: iconst_0
    //   393: invokeinterface 176 12 0
    //   398: ldc 95
    //   400: aload_0
    //   401: invokestatic 161	cooperation/readinjoy/ReadInJoyHelper:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   404: ldc 178
    //   406: invokestatic 169	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   409: checkcast 178	com/tencent/biz/pubaccount/util/api/IPublicAccountUtil
    //   412: bipush 81
    //   414: getstatic 184	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskManager:scriptVersion	I
    //   417: aload 13
    //   419: invokevirtual 172	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: invokestatic 190	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskDistribution:getAttrList	(Ljava/lang/String;)Ljava/util/List;
    //   425: invokeinterface 194 4 0
    //   430: return
    //   431: astore 12
    //   433: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   436: iconst_2
    //   437: aload 12
    //   439: invokevirtual 197	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   442: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: goto +39 -> 484
    //   448: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   451: iconst_1
    //   452: aload 11
    //   454: invokevirtual 197	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   457: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: iload_1
    //   461: istore_2
    //   462: goto -154 -> 308
    //   465: astore_0
    //   466: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   469: iconst_1
    //   470: aload_0
    //   471: invokevirtual 198	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   474: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: return
    //   478: astore 11
    //   480: goto -32 -> 448
    //   483: return
    //   484: goto -276 -> 208
    //   487: iload_3
    //   488: iconst_1
    //   489: isub
    //   490: istore_3
    //   491: iload_2
    //   492: istore_1
    //   493: goto -230 -> 263
    //   496: astore 11
    //   498: goto -50 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramString	String
    //   1	492	1	i	int
    //   55	437	2	j	int
    //   262	229	3	k	int
    //   230	110	4	m	int
    //   244	68	5	n	int
    //   19	170	6	bool	boolean
    //   64	216	7	l1	long
    //   275	7	9	l2	long
    //   28	425	11	localObject1	Object
    //   478	1	11	localJSONException1	org.json.JSONException
    //   496	1	11	localJSONException2	org.json.JSONException
    //   37	168	12	localObject2	Object
    //   431	7	12	localJSONException3	org.json.JSONException
    //   10	408	13	localJSONObject	JSONObject
    //   46	105	14	str	String
    // Exception table:
    //   from	to	target	type
    //   193	204	431	org/json/JSONException
    //   2	188	465	java/lang/Throwable
    //   193	204	465	java/lang/Throwable
    //   208	251	465	java/lang/Throwable
    //   251	257	465	java/lang/Throwable
    //   269	277	465	java/lang/Throwable
    //   314	398	465	java/lang/Throwable
    //   398	430	465	java/lang/Throwable
    //   433	445	465	java/lang/Throwable
    //   448	460	465	java/lang/Throwable
    //   269	277	478	org/json/JSONException
    //   251	257	496	org/json/JSONException
  }
  
  public static void reportCrash(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong) {}
  
  public static void reportException(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exception", paramString);
      localJSONObject.put("version", TaskManager.scriptVersion + "");
      localJSONObject.put("so_version", KandianReportSoLoader.getSoVersion() + "");
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("sys_version", DeviceInfoUtil.e());
      localJSONObject.put("qq_version", DeviceInfoUtil.c());
      localJSONObject.put("appid", AppSetting.a() + "");
      QLog.d(TAG, 1, "reportException: " + localJSONObject.toString());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009831", "0X8009831", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void reportException(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exception", paramString2);
      localJSONObject.put("taskId", paramString1);
      localJSONObject.put("so_version", KandianReportSoLoader.getSoVersion() + "");
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("sys_version", DeviceInfoUtil.e());
      localJSONObject.put("qq_version", DeviceInfoUtil.c());
      localJSONObject.put("version", TaskManager.scriptVersion + "");
      localJSONObject.put("appid", AppSetting.a() + "");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009830", "0X8009830", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void reportSOException(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("exception", paramString);
      localJSONObject.put("so_version", KandianReportSoLoader.getSoVersion() + "");
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("sys_version", DeviceInfoUtil.e());
      localJSONObject.put("qq_version", DeviceInfoUtil.c());
      localJSONObject.put("version", TaskManager.scriptVersion + "");
      localJSONObject.put("appid", AppSetting.a() + "");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800982E", "0X800982E", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException
 * JD-Core Version:    0.7.0.1
 */
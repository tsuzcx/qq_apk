package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.os.Build;
import bdcb;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import nrt;
import org.json.JSONObject;

public class TaskException
{
  private static String TAG = "kandianreport.TaskException";
  
  /* Error */
  public static void reportCrash(String paramString)
  {
    // Byte code:
    //   0: new 24	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 26	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 13
    //   10: aload 13
    //   12: ldc 28
    //   14: invokevirtual 32	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   17: istore 6
    //   19: aload 13
    //   21: ldc 34
    //   23: invokevirtual 38	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 11
    //   28: aload 13
    //   30: ldc 40
    //   32: invokevirtual 38	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 12
    //   37: aload 13
    //   39: ldc 42
    //   41: invokevirtual 38	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 14
    //   46: aload 13
    //   48: ldc 44
    //   50: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   53: istore_1
    //   54: aload 13
    //   56: ldc 50
    //   58: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   61: i2l
    //   62: lstore 7
    //   64: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   67: iconst_1
    //   68: new 52	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   75: ldc 55
    //   77: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload 6
    //   82: invokevirtual 62	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc 64
    //   87: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 11
    //   92: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 64
    //   97: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 12
    //   102: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 64
    //   107: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 14
    //   112: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 64
    //   117: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload_1
    //   121: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: ldc 64
    //   126: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: lload 7
    //   131: invokevirtual 70	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 14
    //   142: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +337 -> 482
    //   148: aload 14
    //   150: ldc 88
    //   152: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   155: ifne +327 -> 482
    //   158: ldc 95
    //   160: ldc 97
    //   162: invokestatic 103	bjxj:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast 90	java/lang/String
    //   168: astore 14
    //   170: new 105	org/json/JSONArray
    //   173: dup
    //   174: invokespecial 106	org/json/JSONArray:<init>	()V
    //   177: astore 12
    //   179: aload 14
    //   181: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: istore 6
    //   186: aload 12
    //   188: astore 11
    //   190: iload 6
    //   192: ifne +14 -> 206
    //   195: new 105	org/json/JSONArray
    //   198: dup
    //   199: aload 14
    //   201: invokespecial 107	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   204: astore 11
    //   206: aload 11
    //   208: lload 7
    //   210: invokevirtual 111	org/json/JSONArray:put	(J)Lorg/json/JSONArray;
    //   213: pop
    //   214: sipush 194
    //   217: invokestatic 117	com/tencent/aladdin/config/Aladdin:getConfig	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   220: ldc 119
    //   222: sipush 300
    //   225: invokevirtual 125	com/tencent/aladdin/config/AladdinConfig:getInteger	(Ljava/lang/String;I)I
    //   228: istore 4
    //   230: sipush 194
    //   233: invokestatic 117	com/tencent/aladdin/config/Aladdin:getConfig	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   236: ldc 127
    //   238: iconst_2
    //   239: invokevirtual 125	com/tencent/aladdin/config/AladdinConfig:getInteger	(Ljava/lang/String;I)I
    //   242: istore 5
    //   244: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   247: lstore 7
    //   249: iconst_0
    //   250: istore_1
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
    //   305: if_icmplt +144 -> 449
    //   308: iload_2
    //   309: iload 5
    //   311: if_icmplt +77 -> 388
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
    //   361: invokestatic 161	bjxj:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   364: aconst_null
    //   365: ldc 97
    //   367: ldc 163
    //   369: ldc 163
    //   371: iconst_0
    //   372: iconst_0
    //   373: ldc 97
    //   375: ldc 97
    //   377: ldc 97
    //   379: aload 13
    //   381: invokevirtual 164	org/json/JSONObject:toString	()Ljava/lang/String;
    //   384: iconst_0
    //   385: invokestatic 169	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   388: ldc 95
    //   390: aload_0
    //   391: invokestatic 161	bjxj:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   394: invokestatic 175	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskManager:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/kandianreport/TaskManager;
    //   397: pop
    //   398: bipush 81
    //   400: getstatic 179	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskManager:scriptVersion	I
    //   403: aload 13
    //   405: invokevirtual 164	org/json/JSONObject:toString	()Ljava/lang/String;
    //   408: invokestatic 185	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskDistribution:getAttrList	(Ljava/lang/String;)Ljava/util/List;
    //   411: invokestatic 190	syb:a	(IILjava/util/List;)V
    //   414: return
    //   415: astore 11
    //   417: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   420: iconst_2
    //   421: aload 11
    //   423: invokevirtual 193	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   426: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 12
    //   431: astore 11
    //   433: goto -227 -> 206
    //   436: astore_0
    //   437: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   440: iconst_1
    //   441: aload_0
    //   442: invokevirtual 194	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   445: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: return
    //   449: iload_3
    //   450: iconst_1
    //   451: isub
    //   452: istore_3
    //   453: iload_2
    //   454: istore_1
    //   455: goto -192 -> 263
    //   458: astore 11
    //   460: getstatic 12	com/tencent/biz/pubaccount/readinjoy/kandianreport/TaskException:TAG	Ljava/lang/String;
    //   463: iconst_1
    //   464: aload 11
    //   466: invokevirtual 193	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   469: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: iload_1
    //   473: istore_2
    //   474: goto -166 -> 308
    //   477: astore 11
    //   479: goto -19 -> 460
    //   482: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramString	String
    //   53	420	1	i	int
    //   256	218	2	j	int
    //   262	191	3	k	int
    //   228	112	4	m	int
    //   242	70	5	n	int
    //   17	174	6	bool	boolean
    //   62	218	7	l1	long
    //   275	7	9	l2	long
    //   26	244	11	localObject1	Object
    //   415	7	11	localJSONException1	org.json.JSONException
    //   431	1	11	localObject2	Object
    //   458	7	11	localJSONException2	org.json.JSONException
    //   477	1	11	localJSONException3	org.json.JSONException
    //   35	395	12	localObject3	Object
    //   8	396	13	localJSONObject	JSONObject
    //   44	156	14	str	String
    // Exception table:
    //   from	to	target	type
    //   195	206	415	org/json/JSONException
    //   0	186	436	java/lang/Throwable
    //   195	206	436	java/lang/Throwable
    //   206	249	436	java/lang/Throwable
    //   251	257	436	java/lang/Throwable
    //   269	277	436	java/lang/Throwable
    //   314	388	436	java/lang/Throwable
    //   388	414	436	java/lang/Throwable
    //   417	429	436	java/lang/Throwable
    //   460	472	436	java/lang/Throwable
    //   251	257	458	org/json/JSONException
    //   269	277	477	org/json/JSONException
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
      localJSONObject.put("sys_version", bdcb.e());
      localJSONObject.put("qq_version", bdcb.c());
      localJSONObject.put("appid", AppSetting.a() + "");
      QLog.d(TAG, 1, "reportException: " + localJSONObject.toString());
      nrt.a(null, "", "0X8009831", "0X8009831", 0, 0, "", "", "", localJSONObject.toString(), false);
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
      localJSONObject.put("sys_version", bdcb.e());
      localJSONObject.put("qq_version", bdcb.c());
      localJSONObject.put("version", TaskManager.scriptVersion + "");
      localJSONObject.put("appid", AppSetting.a() + "");
      nrt.a(null, "", "0X8009830", "0X8009830", 0, 0, "", "", "", localJSONObject.toString(), false);
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
      localJSONObject.put("sys_version", bdcb.e());
      localJSONObject.put("qq_version", bdcb.c());
      localJSONObject.put("version", TaskManager.scriptVersion + "");
      localJSONObject.put("appid", AppSetting.a() + "");
      nrt.a(null, "", "0X800982E", "0X800982E", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException
 * JD-Core Version:    0.7.0.1
 */
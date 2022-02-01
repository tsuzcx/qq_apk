package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class QAVConfigUtils
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 1000L;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private static Integer jdField_a_of_type_JavaLangInteger;
  public static String a = "ver";
  private static int jdField_b_of_type_Int = -1;
  private static volatile Boolean jdField_b_of_type_JavaLangBoolean;
  private static Integer jdField_b_of_type_JavaLangInteger;
  public static String b = "0";
  private static volatile int jdField_c_of_type_Int = -1;
  private static Integer jdField_c_of_type_JavaLangInteger;
  private static String jdField_c_of_type_JavaLangString;
  private static int jdField_d_of_type_Int = -1;
  private static Integer jdField_d_of_type_JavaLangInteger;
  private static String jdField_d_of_type_JavaLangString = "qav_config_";
  private static int jdField_e_of_type_Int = -1;
  private static String jdField_e_of_type_JavaLangString = "text";
  private static int f = -1;
  private static volatile int g = -1;
  private static int h = -1;
  private static int i = -1;
  
  public static int a()
  {
    if (jdField_c_of_type_Int == -1)
    {
      jdField_c_of_type_Int = a(287, jdField_b_of_type_JavaLangString).getInt("multiVideoSupportNumbers", -1);
      if (jdField_c_of_type_Int == -1) {
        jdField_c_of_type_Int = 5;
      }
      return jdField_c_of_type_Int;
    }
    return jdField_c_of_type_Int;
  }
  
  public static int a(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getInt(jdField_a_of_type_JavaLangString, 0);
  }
  
  private static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject.has(paramString)) {
      paramInt = paramJSONObject.getInt(paramString);
    }
    return paramInt;
  }
  
  public static SharedPreferences a(int paramInt, String paramString)
  {
    paramString = b(paramInt, paramString);
    return BaseApplication.getContext().getSharedPreferences(paramString, 4);
  }
  
  public static QAVConfigUtils.MoreBtnTips a(int paramInt)
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        QAVConfigUtils.MoreBtnTips localMoreBtnTips = new QAVConfigUtils.MoreBtnTips();
        localMoreBtnTips.b = 2147483647;
        j = 0;
        if (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < localMoreBtnTips.b))
          {
            localMoreBtnTips.jdField_a_of_type_Int = localJSONObject.getInt("id");
            localMoreBtnTips.jdField_a_of_type_JavaLangString = localJSONObject.getString("url");
            localMoreBtnTips.b = localJSONObject.getInt("priority");
            localMoreBtnTips.jdField_c_of_type_Int = localJSONObject.getInt("type");
          }
        }
        else if (localMoreBtnTips.b < 2147483647)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(", url = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", priority = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.b);
          ((StringBuilder)localObject).append(", type = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.jdField_c_of_type_Int);
          QLog.i("QAVConfigUtils", 1, ((StringBuilder)localObject).toString());
          return localMoreBtnTips;
        }
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MoreBtnTips. getHighestPriorityMoreBtnTips failed. ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(localException));
        QLog.i("QAVConfigUtils", 1, ((StringBuilder)localObject).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MoreBtnTips. getHighestPriorityMoreBtnTips failed. moreBtnTips = null. sessionType = ");
        localStringBuilder.append(paramInt);
        QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
        return null;
      }
      j += 1;
    }
  }
  
  private static Long a(JSONObject paramJSONObject, String paramString, Long paramLong)
  {
    long l;
    if (paramJSONObject.has(paramString)) {
      l = paramJSONObject.getLong(paramString);
    } else {
      l = paramLong.longValue();
    }
    return Long.valueOf(l);
  }
  
  public static String a()
  {
    a();
    return jdField_c_of_type_JavaLangString;
  }
  
  public static String a(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getString(jdField_e_of_type_JavaLangString, null);
  }
  
  public static String a(@NonNull String paramString)
  {
    return a(287, jdField_b_of_type_JavaLangString).getString(paramString, "");
  }
  
  private static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject.has(paramString1)) {
      paramString2 = paramJSONObject.getString(paramString1);
    }
    return paramString2;
  }
  
  private static JSONArray a()
  {
    Object localObject = a(287, jdField_b_of_type_JavaLangString).getString("moreBtnTips", "");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. readMoreBtnTipsJsonArray failed. TextUtils.isEmpty(moreBtnTipsJson) = ");
      localStringBuilder.append(TextUtils.isEmpty((CharSequence)localObject));
      QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
      return null;
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. readMoreBtnTipsJsonArray. read moreBtnTipsJson = ");
      localStringBuilder.append((String)localObject);
      QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
      localObject = new JSONArray((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MoreBtnTips. readMoreBtnTipsJsonArray failed. ");
      localStringBuilder.append(QLog.getStackTraceString(localException));
      QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  private static void a()
  {
    if ((jdField_b_of_type_JavaLangBoolean == null) || (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)))
    {
      Object localObject = a(287, jdField_b_of_type_JavaLangString);
      jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(((SharedPreferences)localObject).getBoolean("switchMultiForceUseGroup", false));
      jdField_c_of_type_JavaLangString = ((SharedPreferences)localObject).getString("switchMultiForceUseGroupAlertTip", "对方版本过低，请先创建群聊后邀请");
      if (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {
        jdField_c_of_type_JavaLangString = "对方版本过低，请先创建群聊后邀请";
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initDouble2GroupConfig [");
        ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangBoolean);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject).append("]");
        QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void a(int paramInt)
  {
    JSONArray localJSONArray = a();
    if (localJSONArray == null) {
      return;
    }
    try
    {
      new QAVConfigUtils.MoreBtnTips().b = 2147483647;
      int j = 0;
      Object localObject;
      while (j < localJSONArray.length())
      {
        localObject = localJSONArray.getJSONObject(j);
        if (((JSONObject)localObject).getInt("id") == paramInt)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MoreBtnTips. removeMoreBtnTips. id = ");
          localStringBuilder.append(paramInt);
          QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
          if (Build.VERSION.SDK_INT >= 19) {
            localJSONArray.remove(j);
          } else {
            ((JSONObject)localObject).put("priority", 2147483647);
          }
          localObject = a(287, jdField_b_of_type_JavaLangString).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("MoreBtnTips. removeMoreBtnTips. saved moreBtnTipsJson = ");
          localStringBuilder.append(localJSONArray.toString());
          QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
          ((SharedPreferences.Editor)localObject).putString("moreBtnTips", localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
        j += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoreBtnTips. removeMoreBtnTips failed. ");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(localException));
      QLog.i("QAVConfigUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Object localObject = a(paramInt1, paramString1).edit();
    if (paramString2 == null) {
      ((SharedPreferences.Editor)localObject).remove(jdField_e_of_type_JavaLangString);
    } else {
      ((SharedPreferences.Editor)localObject).putString(jdField_e_of_type_JavaLangString, paramString2);
    }
    ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, paramInt2);
    ((SharedPreferences.Editor)localObject).commit();
    if (!QLog.isDevelopLevel()) {
      if (paramString2 == null)
      {
        paramString2 = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2.length());
        ((StringBuilder)localObject).append("");
        paramString2 = ((StringBuilder)localObject).toString();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QAVConfigUtils_");
    ((StringBuilder)localObject).append(paramInt1);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveConfig, configId[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], uin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], version[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("],\n");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: new 116	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   13: astore 28
    //   15: aload 28
    //   17: ldc_w 297
    //   20: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 28
    //   26: aload_0
    //   27: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 134
    //   33: iconst_2
    //   34: aload 28
    //   36: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: istore 19
    //   48: ldc 178
    //   50: astore 35
    //   52: ldc2_w 9
    //   55: lstore 26
    //   57: iload 19
    //   59: ifne +1740 -> 1799
    //   62: new 57	org/json/JSONObject
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 298	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore 36
    //   72: aload 36
    //   74: ldc_w 300
    //   77: iconst_1
    //   78: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   81: istore 6
    //   83: aload 36
    //   85: ldc_w 304
    //   88: ldc2_w 9
    //   91: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   94: invokestatic 306	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;
    //   97: invokevirtual 162	java/lang/Long:longValue	()J
    //   100: lstore 24
    //   102: aload 36
    //   104: ldc_w 308
    //   107: iconst_1
    //   108: invokestatic 311	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   111: istore 19
    //   113: aload 36
    //   115: ldc 45
    //   117: iconst_m1
    //   118: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   121: istore_1
    //   122: aload 36
    //   124: ldc_w 313
    //   127: iconst_0
    //   128: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   131: istore_2
    //   132: aload 36
    //   134: ldc 204
    //   136: iconst_0
    //   137: invokestatic 311	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   140: istore 20
    //   142: aload 36
    //   144: ldc 215
    //   146: ldc 217
    //   148: invokestatic 315	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   151: astore 28
    //   153: aload 36
    //   155: ldc_w 317
    //   158: iconst_m1
    //   159: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   162: istore_3
    //   163: aload 36
    //   165: ldc_w 319
    //   168: iconst_0
    //   169: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   172: istore 4
    //   174: iload 4
    //   176: iconst_1
    //   177: if_icmpne +9 -> 186
    //   180: iconst_1
    //   181: istore 21
    //   183: goto +6 -> 189
    //   186: iconst_0
    //   187: istore 21
    //   189: aload 36
    //   191: ldc_w 321
    //   194: bipush 7
    //   196: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   199: istore 4
    //   201: aload 36
    //   203: ldc_w 323
    //   206: iconst_m1
    //   207: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   210: istore 7
    //   212: new 116	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   219: astore 29
    //   221: iload 6
    //   223: istore 5
    //   225: aload 29
    //   227: ldc_w 325
    //   230: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 29
    //   236: iload 7
    //   238: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc 134
    //   244: iconst_1
    //   245: aload 29
    //   247: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload 36
    //   255: ldc_w 327
    //   258: iconst_m1
    //   259: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   262: istore 9
    //   264: new 116	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   271: astore 29
    //   273: iload 7
    //   275: istore 6
    //   277: aload 29
    //   279: ldc_w 329
    //   282: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 29
    //   288: iload 9
    //   290: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: ldc 134
    //   296: iconst_1
    //   297: aload 29
    //   299: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload 36
    //   307: ldc_w 331
    //   310: iconst_m1
    //   311: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   314: istore 10
    //   316: aload 36
    //   318: ldc_w 333
    //   321: ldc 178
    //   323: invokestatic 315	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   326: astore 32
    //   328: aload 36
    //   330: ldc 182
    //   332: invokevirtual 61	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   335: istore 22
    //   337: iload 22
    //   339: ifeq +107 -> 446
    //   342: aload 36
    //   344: ldc 182
    //   346: invokevirtual 337	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   349: astore 29
    //   351: aload 29
    //   353: invokevirtual 255	org/json/JSONArray:toString	()Ljava/lang/String;
    //   356: astore 30
    //   358: new 116	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   365: astore 29
    //   367: aload 29
    //   369: ldc_w 339
    //   372: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 29
    //   378: aload 30
    //   380: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: ldc 134
    //   386: iconst_1
    //   387: aload 29
    //   389: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: goto +55 -> 450
    //   398: astore 29
    //   400: goto +5 -> 405
    //   403: astore 29
    //   405: goto +14 -> 419
    //   408: astore 29
    //   410: goto +5 -> 415
    //   413: astore 29
    //   415: ldc 178
    //   417: astore 30
    //   419: ldc 178
    //   421: astore 31
    //   423: ldc 178
    //   425: astore 36
    //   427: aload 36
    //   429: astore 33
    //   431: aload 33
    //   433: astore 34
    //   435: aload 32
    //   437: astore 35
    //   439: aload 36
    //   441: astore 32
    //   443: goto +753 -> 1196
    //   446: ldc 178
    //   448: astore 30
    //   450: aload 32
    //   452: astore 31
    //   454: iload 9
    //   456: istore 7
    //   458: iload 10
    //   460: istore 8
    //   462: aload 36
    //   464: ldc_w 341
    //   467: ldc 178
    //   469: invokestatic 315	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   472: astore 29
    //   474: aload 36
    //   476: ldc_w 343
    //   479: ldc 178
    //   481: invokestatic 315	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   484: astore 35
    //   486: aload 36
    //   488: ldc_w 345
    //   491: iconst_0
    //   492: invokestatic 311	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   495: istore 23
    //   497: new 116	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   504: astore 32
    //   506: aload 35
    //   508: astore 34
    //   510: aload 32
    //   512: ldc_w 347
    //   515: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 32
    //   521: iload 23
    //   523: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: ldc 134
    //   529: iconst_1
    //   530: aload 32
    //   532: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: aload 36
    //   540: ldc_w 349
    //   543: ldc 178
    //   545: invokestatic 315	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   548: astore 32
    //   550: aload 36
    //   552: ldc_w 351
    //   555: ldc 178
    //   557: invokestatic 315	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   560: astore 33
    //   562: iload 23
    //   564: istore 22
    //   566: aload 36
    //   568: ldc_w 353
    //   571: iconst_m1
    //   572: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   575: istore 9
    //   577: aload 36
    //   579: ldc_w 355
    //   582: iconst_m1
    //   583: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   586: istore 10
    //   588: aload 36
    //   590: ldc_w 357
    //   593: iconst_1
    //   594: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   597: istore 12
    //   599: new 116	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   606: astore 37
    //   608: aload 32
    //   610: astore 35
    //   612: aload 37
    //   614: ldc_w 359
    //   617: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 37
    //   623: iload 12
    //   625: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: ldc_w 361
    //   632: iconst_2
    //   633: aload 37
    //   635: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 363	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: aload 36
    //   643: ldc_w 365
    //   646: iconst_0
    //   647: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   650: istore 16
    //   652: new 116	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   659: astore 32
    //   661: iload 12
    //   663: istore 11
    //   665: aload 32
    //   667: ldc_w 367
    //   670: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 32
    //   676: iload 16
    //   678: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: ldc_w 361
    //   685: iconst_2
    //   686: aload 32
    //   688: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 363	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: aload 36
    //   696: ldc_w 369
    //   699: iconst_m1
    //   700: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   703: istore 13
    //   705: iload 13
    //   707: istore 12
    //   709: aload 36
    //   711: ldc_w 371
    //   714: iconst_1
    //   715: invokestatic 302	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   718: istore 15
    //   720: iload 9
    //   722: istore 18
    //   724: iload 11
    //   726: istore 17
    //   728: iload 19
    //   730: istore 23
    //   732: iload_2
    //   733: istore 13
    //   735: aload 28
    //   737: astore 32
    //   739: iload 5
    //   741: istore 14
    //   743: iload 7
    //   745: istore 5
    //   747: aload 34
    //   749: astore 36
    //   751: iload 22
    //   753: istore 19
    //   755: aload 33
    //   757: astore 28
    //   759: iload 10
    //   761: istore 7
    //   763: iload 12
    //   765: istore_2
    //   766: aload 32
    //   768: astore 34
    //   770: iload 23
    //   772: istore 22
    //   774: iload 4
    //   776: istore 12
    //   778: iload 6
    //   780: istore 11
    //   782: iload 5
    //   784: istore 10
    //   786: iload 8
    //   788: istore 9
    //   790: aload 31
    //   792: astore 33
    //   794: aload 30
    //   796: astore 32
    //   798: aload 29
    //   800: astore 31
    //   802: aload 36
    //   804: astore 30
    //   806: aload 35
    //   808: astore 29
    //   810: iload 18
    //   812: istore 8
    //   814: iload 17
    //   816: istore 6
    //   818: iload 16
    //   820: istore 5
    //   822: iload_2
    //   823: istore 4
    //   825: iload 15
    //   827: istore_2
    //   828: goto +960 -> 1788
    //   831: astore 36
    //   833: goto +3 -> 836
    //   836: iload 11
    //   838: istore 13
    //   840: goto +17 -> 857
    //   843: astore 36
    //   845: goto +5 -> 850
    //   848: astore 36
    //   850: iload 12
    //   852: istore 13
    //   854: iconst_m1
    //   855: istore 12
    //   857: iload 9
    //   859: istore 11
    //   861: iload 16
    //   863: istore 9
    //   865: aload 28
    //   867: astore 32
    //   869: iload 4
    //   871: istore 14
    //   873: iload 13
    //   875: istore 4
    //   877: iload_2
    //   878: istore 13
    //   880: aload 35
    //   882: astore 28
    //   884: iload 12
    //   886: istore_2
    //   887: goto +746 -> 1633
    //   890: astore 36
    //   892: goto +10 -> 902
    //   895: astore 36
    //   897: goto +5 -> 902
    //   900: astore 36
    //   902: aload 32
    //   904: astore 35
    //   906: iconst_m1
    //   907: istore 15
    //   909: iconst_0
    //   910: istore 13
    //   912: aload 28
    //   914: astore 32
    //   916: iload 9
    //   918: istore 11
    //   920: iload 4
    //   922: istore 14
    //   924: iload 12
    //   926: istore 4
    //   928: iload 13
    //   930: istore 9
    //   932: iload_2
    //   933: istore 13
    //   935: aload 35
    //   937: astore 28
    //   939: iload 15
    //   941: istore_2
    //   942: goto +691 -> 1633
    //   945: astore 35
    //   947: goto +3 -> 950
    //   950: aload 32
    //   952: astore 37
    //   954: aload 28
    //   956: astore 32
    //   958: iload 9
    //   960: istore 11
    //   962: iload 4
    //   964: istore 12
    //   966: iload_2
    //   967: istore 13
    //   969: goto +644 -> 1613
    //   972: astore 36
    //   974: aload 32
    //   976: astore 34
    //   978: aload 36
    //   980: astore 32
    //   982: iload 9
    //   984: istore 11
    //   986: goto +58 -> 1044
    //   989: astore 36
    //   991: goto +3 -> 994
    //   994: aload 32
    //   996: astore 34
    //   998: aload 36
    //   1000: astore 32
    //   1002: goto +39 -> 1041
    //   1005: astore 33
    //   1007: aload 32
    //   1009: astore 34
    //   1011: ldc 178
    //   1013: astore 36
    //   1015: aload 33
    //   1017: astore 32
    //   1019: aload 36
    //   1021: astore 33
    //   1023: goto +18 -> 1041
    //   1026: astore 32
    //   1028: goto +5 -> 1033
    //   1031: astore 32
    //   1033: ldc 178
    //   1035: astore 33
    //   1037: aload 33
    //   1039: astore 34
    //   1041: iconst_m1
    //   1042: istore 11
    //   1044: iload 23
    //   1046: istore 22
    //   1048: aload 35
    //   1050: astore 36
    //   1052: aload 28
    //   1054: astore 37
    //   1056: aload 32
    //   1058: astore 28
    //   1060: aload 31
    //   1062: astore 35
    //   1064: aload 37
    //   1066: astore 31
    //   1068: iload 8
    //   1070: istore 9
    //   1072: iload 7
    //   1074: istore 12
    //   1076: aload 29
    //   1078: astore 32
    //   1080: goto +491 -> 1571
    //   1083: astore 31
    //   1085: aload 35
    //   1087: astore 34
    //   1089: goto +3 -> 1092
    //   1092: ldc 178
    //   1094: astore 33
    //   1096: aload 31
    //   1098: astore 35
    //   1100: aload 29
    //   1102: astore 31
    //   1104: goto +47 -> 1151
    //   1107: astore 35
    //   1109: ldc 178
    //   1111: astore 33
    //   1113: aload 29
    //   1115: astore 31
    //   1117: aload 33
    //   1119: astore 29
    //   1121: goto +22 -> 1143
    //   1124: astore 35
    //   1126: goto +9 -> 1135
    //   1129: astore 35
    //   1131: ldc 178
    //   1133: astore 30
    //   1135: ldc 178
    //   1137: astore 31
    //   1139: ldc 178
    //   1141: astore 29
    //   1143: aload 29
    //   1145: astore 33
    //   1147: aload 29
    //   1149: astore 34
    //   1151: aload 33
    //   1153: astore 36
    //   1155: aload 35
    //   1157: astore 29
    //   1159: aload 32
    //   1161: astore 35
    //   1163: aload 34
    //   1165: astore 32
    //   1167: aload 36
    //   1169: astore 34
    //   1171: goto +25 -> 1196
    //   1174: astore 29
    //   1176: ldc 178
    //   1178: astore 30
    //   1180: aload 30
    //   1182: astore 31
    //   1184: aload 31
    //   1186: astore 32
    //   1188: aload 32
    //   1190: astore 33
    //   1192: aload 33
    //   1194: astore 34
    //   1196: aload 28
    //   1198: astore 36
    //   1200: aload 29
    //   1202: astore 28
    //   1204: aload 36
    //   1206: astore 29
    //   1208: iload_2
    //   1209: istore 7
    //   1211: iload_3
    //   1212: istore 8
    //   1214: iload 10
    //   1216: istore_2
    //   1217: iload 9
    //   1219: istore_3
    //   1220: goto +321 -> 1541
    //   1223: astore 29
    //   1225: goto +5 -> 1230
    //   1228: astore 29
    //   1230: iload 7
    //   1232: istore 6
    //   1234: ldc 178
    //   1236: astore 30
    //   1238: aload 30
    //   1240: astore 31
    //   1242: aload 31
    //   1244: astore 32
    //   1246: aload 32
    //   1248: astore 33
    //   1250: aload 33
    //   1252: astore 34
    //   1254: aload 28
    //   1256: astore 36
    //   1258: iconst_m1
    //   1259: istore 10
    //   1261: aload 29
    //   1263: astore 28
    //   1265: aload 36
    //   1267: astore 29
    //   1269: iload_2
    //   1270: istore 7
    //   1272: iload_3
    //   1273: istore 8
    //   1275: iload 10
    //   1277: istore_2
    //   1278: iload 9
    //   1280: istore_3
    //   1281: goto +260 -> 1541
    //   1284: astore 29
    //   1286: goto +5 -> 1291
    //   1289: astore 29
    //   1291: iload 7
    //   1293: istore 9
    //   1295: iload 6
    //   1297: istore 5
    //   1299: aload 28
    //   1301: astore 30
    //   1303: aload 29
    //   1305: astore 28
    //   1307: aload 30
    //   1309: astore 29
    //   1311: iload_2
    //   1312: istore 7
    //   1314: iload_3
    //   1315: istore 8
    //   1317: iload 9
    //   1319: istore 6
    //   1321: goto +196 -> 1517
    //   1324: astore 29
    //   1326: goto +3 -> 1329
    //   1329: goto +12 -> 1341
    //   1332: astore 29
    //   1334: goto +3 -> 1337
    //   1337: bipush 7
    //   1339: istore 4
    //   1341: iload 6
    //   1343: istore 5
    //   1345: aload 28
    //   1347: astore 30
    //   1349: aload 29
    //   1351: astore 28
    //   1353: aload 30
    //   1355: astore 29
    //   1357: goto +151 -> 1508
    //   1360: astore 29
    //   1362: goto +3 -> 1365
    //   1365: aload 28
    //   1367: astore 30
    //   1369: aload 29
    //   1371: astore 28
    //   1373: goto +85 -> 1458
    //   1376: astore 29
    //   1378: goto +9 -> 1387
    //   1381: astore 29
    //   1383: ldc 217
    //   1385: astore 28
    //   1387: aload 28
    //   1389: astore 30
    //   1391: goto +61 -> 1452
    //   1394: astore 28
    //   1396: ldc 217
    //   1398: astore 29
    //   1400: goto +41 -> 1441
    //   1403: astore 28
    //   1405: goto +7 -> 1412
    //   1408: astore 28
    //   1410: iconst_m1
    //   1411: istore_1
    //   1412: ldc 217
    //   1414: astore 29
    //   1416: goto +23 -> 1439
    //   1419: astore 28
    //   1421: goto +9 -> 1430
    //   1424: astore 28
    //   1426: lload 26
    //   1428: lstore 24
    //   1430: ldc 217
    //   1432: astore 29
    //   1434: iconst_m1
    //   1435: istore_1
    //   1436: iconst_1
    //   1437: istore 19
    //   1439: iconst_0
    //   1440: istore_2
    //   1441: iconst_0
    //   1442: istore 20
    //   1444: aload 29
    //   1446: astore 30
    //   1448: aload 28
    //   1450: astore 29
    //   1452: iconst_m1
    //   1453: istore_3
    //   1454: aload 29
    //   1456: astore 28
    //   1458: iload 6
    //   1460: istore 5
    //   1462: bipush 7
    //   1464: istore 4
    //   1466: iconst_0
    //   1467: istore 21
    //   1469: aload 30
    //   1471: astore 29
    //   1473: goto +35 -> 1508
    //   1476: astore 28
    //   1478: ldc 217
    //   1480: astore 29
    //   1482: iconst_m1
    //   1483: istore_1
    //   1484: bipush 7
    //   1486: istore 4
    //   1488: iconst_1
    //   1489: istore 19
    //   1491: iconst_0
    //   1492: istore_2
    //   1493: iconst_0
    //   1494: istore 20
    //   1496: iconst_m1
    //   1497: istore_3
    //   1498: iconst_0
    //   1499: istore 21
    //   1501: iconst_1
    //   1502: istore 5
    //   1504: lload 26
    //   1506: lstore 24
    //   1508: iconst_m1
    //   1509: istore 6
    //   1511: iload_3
    //   1512: istore 8
    //   1514: iload_2
    //   1515: istore 7
    //   1517: ldc 178
    //   1519: astore 34
    //   1521: ldc 178
    //   1523: astore 33
    //   1525: ldc 178
    //   1527: astore 32
    //   1529: ldc 178
    //   1531: astore 31
    //   1533: ldc 178
    //   1535: astore 30
    //   1537: iconst_m1
    //   1538: istore_2
    //   1539: iconst_m1
    //   1540: istore_3
    //   1541: iconst_m1
    //   1542: istore 11
    //   1544: iconst_0
    //   1545: istore 22
    //   1547: aload 32
    //   1549: astore 36
    //   1551: aload 31
    //   1553: astore 32
    //   1555: iload_3
    //   1556: istore 12
    //   1558: iload_2
    //   1559: istore 9
    //   1561: iload 8
    //   1563: istore_3
    //   1564: iload 7
    //   1566: istore_2
    //   1567: aload 29
    //   1569: astore 31
    //   1571: iconst_m1
    //   1572: istore 10
    //   1574: aload 34
    //   1576: astore 37
    //   1578: aload 36
    //   1580: astore 34
    //   1582: aload 32
    //   1584: astore 29
    //   1586: iload 12
    //   1588: istore 7
    //   1590: iload 9
    //   1592: istore 8
    //   1594: iload_2
    //   1595: istore 13
    //   1597: iload 4
    //   1599: istore 12
    //   1601: aload 31
    //   1603: astore 32
    //   1605: aload 35
    //   1607: astore 31
    //   1609: aload 28
    //   1611: astore 35
    //   1613: iconst_0
    //   1614: istore 9
    //   1616: iconst_1
    //   1617: istore 4
    //   1619: iconst_m1
    //   1620: istore_2
    //   1621: aload 37
    //   1623: astore 28
    //   1625: iload 12
    //   1627: istore 14
    //   1629: aload 35
    //   1631: astore 36
    //   1633: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1636: ifeq +47 -> 1683
    //   1639: new 116	java/lang/StringBuilder
    //   1642: dup
    //   1643: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   1646: astore 35
    //   1648: aload 35
    //   1650: ldc_w 373
    //   1653: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: pop
    //   1657: aload 35
    //   1659: aload 36
    //   1661: invokestatic 149	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1664: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: pop
    //   1668: ldc_w 361
    //   1671: iconst_2
    //   1672: aload 35
    //   1674: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1680: goto +3 -> 1683
    //   1683: aload 32
    //   1685: astore 35
    //   1687: iload 14
    //   1689: istore 12
    //   1691: iload 4
    //   1693: istore 16
    //   1695: iload 19
    //   1697: istore 23
    //   1699: iload 5
    //   1701: istore 14
    //   1703: iload 6
    //   1705: istore 15
    //   1707: iload 8
    //   1709: istore 17
    //   1711: iload 7
    //   1713: istore 18
    //   1715: aload 31
    //   1717: astore 36
    //   1719: aload 30
    //   1721: astore 32
    //   1723: aload 29
    //   1725: astore 31
    //   1727: aload 34
    //   1729: astore 30
    //   1731: iload 22
    //   1733: istore 19
    //   1735: iload 10
    //   1737: istore 7
    //   1739: aload 28
    //   1741: astore 29
    //   1743: iload_2
    //   1744: istore 4
    //   1746: iconst_1
    //   1747: istore_2
    //   1748: iload 9
    //   1750: istore 5
    //   1752: iload 16
    //   1754: istore 6
    //   1756: iload 11
    //   1758: istore 8
    //   1760: aload 33
    //   1762: astore 28
    //   1764: aload 36
    //   1766: astore 33
    //   1768: iload 17
    //   1770: istore 9
    //   1772: iload 18
    //   1774: istore 10
    //   1776: iload 15
    //   1778: istore 11
    //   1780: iload 23
    //   1782: istore 22
    //   1784: aload 35
    //   1786: astore 34
    //   1788: aload 29
    //   1790: astore 35
    //   1792: aload 28
    //   1794: astore 36
    //   1796: goto +100 -> 1896
    //   1799: ldc 178
    //   1801: astore 33
    //   1803: aload 33
    //   1805: astore 28
    //   1807: aload 28
    //   1809: astore 29
    //   1811: aload 29
    //   1813: astore 30
    //   1815: aload 30
    //   1817: astore 31
    //   1819: aload 31
    //   1821: astore 36
    //   1823: ldc2_w 9
    //   1826: lstore 24
    //   1828: ldc 217
    //   1830: astore 34
    //   1832: iconst_1
    //   1833: istore 14
    //   1835: iconst_1
    //   1836: istore 22
    //   1838: iconst_0
    //   1839: istore 13
    //   1841: iconst_m1
    //   1842: istore_1
    //   1843: iconst_0
    //   1844: istore 21
    //   1846: bipush 7
    //   1848: istore 12
    //   1850: iconst_m1
    //   1851: istore 11
    //   1853: iconst_m1
    //   1854: istore 10
    //   1856: iconst_m1
    //   1857: istore 9
    //   1859: iconst_0
    //   1860: istore 19
    //   1862: iconst_m1
    //   1863: istore 8
    //   1865: iconst_m1
    //   1866: istore 7
    //   1868: iconst_1
    //   1869: istore 6
    //   1871: iconst_0
    //   1872: istore 5
    //   1874: iconst_m1
    //   1875: istore 4
    //   1877: iconst_1
    //   1878: istore_2
    //   1879: iconst_0
    //   1880: istore 20
    //   1882: iconst_m1
    //   1883: istore_3
    //   1884: aload 31
    //   1886: astore 35
    //   1888: aload 29
    //   1890: astore 31
    //   1892: aload 28
    //   1894: astore 32
    //   1896: sipush 287
    //   1899: getstatic 40	com/tencent/av/utils/QAVConfigUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1902: invokestatic 43	com/tencent/av/utils/QAVConfigUtils:a	(ILjava/lang/String;)Landroid/content/SharedPreferences;
    //   1905: invokeinterface 252 1 0
    //   1910: astore 28
    //   1912: aload 28
    //   1914: ldc_w 375
    //   1917: iload 14
    //   1919: invokeinterface 274 3 0
    //   1924: pop
    //   1925: aload 28
    //   1927: ldc_w 304
    //   1930: lload 24
    //   1932: invokeinterface 379 4 0
    //   1937: pop
    //   1938: aload 28
    //   1940: ldc_w 308
    //   1943: iload 22
    //   1945: invokeinterface 383 3 0
    //   1950: pop
    //   1951: aload 28
    //   1953: ldc 45
    //   1955: iload_1
    //   1956: invokeinterface 274 3 0
    //   1961: pop
    //   1962: aload 28
    //   1964: ldc_w 313
    //   1967: iload 13
    //   1969: invokeinterface 274 3 0
    //   1974: pop
    //   1975: aload 28
    //   1977: ldc 204
    //   1979: iload 20
    //   1981: invokeinterface 383 3 0
    //   1986: pop
    //   1987: aload 28
    //   1989: ldc 215
    //   1991: aload 34
    //   1993: invokeinterface 261 3 0
    //   1998: pop
    //   1999: aload 28
    //   2001: ldc_w 317
    //   2004: iload_3
    //   2005: invokeinterface 274 3 0
    //   2010: pop
    //   2011: aload 28
    //   2013: ldc_w 319
    //   2016: iload 21
    //   2018: invokeinterface 383 3 0
    //   2023: pop
    //   2024: aload 28
    //   2026: ldc_w 321
    //   2029: iload 12
    //   2031: invokeinterface 274 3 0
    //   2036: pop
    //   2037: aload 28
    //   2039: ldc_w 323
    //   2042: iload 11
    //   2044: invokeinterface 274 3 0
    //   2049: pop
    //   2050: aload 28
    //   2052: ldc_w 327
    //   2055: iload 10
    //   2057: invokeinterface 274 3 0
    //   2062: pop
    //   2063: aload 28
    //   2065: ldc_w 331
    //   2068: iload 9
    //   2070: invokeinterface 274 3 0
    //   2075: pop
    //   2076: aload 28
    //   2078: ldc_w 333
    //   2081: aload 33
    //   2083: invokeinterface 261 3 0
    //   2088: pop
    //   2089: aload 28
    //   2091: ldc 182
    //   2093: aload 32
    //   2095: invokeinterface 261 3 0
    //   2100: pop
    //   2101: aload 28
    //   2103: ldc_w 341
    //   2106: aload 31
    //   2108: invokeinterface 261 3 0
    //   2113: pop
    //   2114: aload 28
    //   2116: ldc_w 343
    //   2119: aload 30
    //   2121: invokeinterface 261 3 0
    //   2126: pop
    //   2127: aload 28
    //   2129: ldc_w 345
    //   2132: iload 19
    //   2134: invokeinterface 383 3 0
    //   2139: pop
    //   2140: aload 28
    //   2142: ldc_w 349
    //   2145: aload 35
    //   2147: invokeinterface 261 3 0
    //   2152: pop
    //   2153: aload 28
    //   2155: ldc_w 351
    //   2158: aload 36
    //   2160: invokeinterface 261 3 0
    //   2165: pop
    //   2166: aload 28
    //   2168: ldc_w 353
    //   2171: iload 8
    //   2173: invokeinterface 274 3 0
    //   2178: pop
    //   2179: iload 7
    //   2181: iconst_m1
    //   2182: if_icmpeq +16 -> 2198
    //   2185: aload 28
    //   2187: ldc_w 355
    //   2190: iload 7
    //   2192: invokeinterface 274 3 0
    //   2197: pop
    //   2198: aload 28
    //   2200: ldc_w 357
    //   2203: iload 6
    //   2205: invokeinterface 274 3 0
    //   2210: pop
    //   2211: aload 28
    //   2213: ldc_w 365
    //   2216: iload 5
    //   2218: invokeinterface 274 3 0
    //   2223: pop
    //   2224: iload 4
    //   2226: iconst_m1
    //   2227: if_icmpeq +16 -> 2243
    //   2230: aload 28
    //   2232: ldc_w 369
    //   2235: iload 4
    //   2237: invokeinterface 274 3 0
    //   2242: pop
    //   2243: iload_2
    //   2244: putstatic 385	com/tencent/av/utils/QAVConfigUtils:g	I
    //   2247: aload 28
    //   2249: ldc_w 371
    //   2252: iload_2
    //   2253: invokeinterface 274 3 0
    //   2258: pop
    //   2259: aload 28
    //   2261: invokeinterface 264 1 0
    //   2266: pop
    //   2267: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2270: ifeq +47 -> 2317
    //   2273: new 116	java/lang/StringBuilder
    //   2276: dup
    //   2277: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   2280: astore 28
    //   2282: aload 28
    //   2284: ldc_w 387
    //   2287: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: pop
    //   2291: aload 28
    //   2293: aload_0
    //   2294: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: pop
    //   2298: aload 28
    //   2300: ldc 230
    //   2302: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: pop
    //   2306: ldc 134
    //   2308: iconst_2
    //   2309: aload 28
    //   2311: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2314: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2317: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2318	0	paramString	String
    //   121	1835	1	j	int
    //   131	2122	2	k	int
    //   162	1843	3	m	int
    //   172	2064	4	n	int
    //   223	1994	5	i1	int
    //   81	2123	6	i2	int
    //   210	1981	7	i3	int
    //   460	1712	8	i4	int
    //   262	1807	9	i5	int
    //   314	1742	10	i6	int
    //   663	1380	11	i7	int
    //   597	1433	12	i8	int
    //   703	1265	13	i9	int
    //   741	1177	14	i10	int
    //   718	1059	15	i11	int
    //   650	1103	16	i12	int
    //   726	1043	17	i13	int
    //   722	1051	18	i14	int
    //   46	2087	19	bool1	boolean
    //   140	1840	20	bool2	boolean
    //   181	1836	21	bool3	boolean
    //   335	1609	22	bool4	boolean
    //   495	1286	23	bool5	boolean
    //   100	1831	24	l1	long
    //   55	1450	26	l2	long
    //   13	1375	28	localObject1	Object
    //   1394	1	28	localException1	Exception
    //   1403	1	28	localException2	Exception
    //   1408	1	28	localException3	Exception
    //   1419	1	28	localException4	Exception
    //   1424	25	28	localException5	Exception
    //   1456	1	28	localObject2	Object
    //   1476	134	28	localException6	Exception
    //   1623	687	28	localObject3	Object
    //   219	169	29	localObject4	Object
    //   398	1	29	localException7	Exception
    //   403	1	29	localException8	Exception
    //   408	1	29	localException9	Exception
    //   413	1	29	localException10	Exception
    //   472	686	29	localObject5	Object
    //   1174	27	29	localException11	Exception
    //   1206	1	29	localObject6	Object
    //   1223	1	29	localException12	Exception
    //   1228	34	29	localException13	Exception
    //   1267	1	29	localObject7	Object
    //   1284	1	29	localException14	Exception
    //   1289	15	29	localException15	Exception
    //   1309	1	29	localObject8	Object
    //   1324	1	29	localException16	Exception
    //   1332	18	29	localException17	Exception
    //   1355	1	29	localObject9	Object
    //   1360	10	29	localException18	Exception
    //   1376	1	29	localException19	Exception
    //   1381	1	29	localException20	Exception
    //   1398	491	29	localObject10	Object
    //   356	1764	30	localObject11	Object
    //   421	646	31	localObject12	Object
    //   1083	14	31	localException21	Exception
    //   1102	1005	31	localObject13	Object
    //   326	692	32	localObject14	Object
    //   1026	1	32	localException22	Exception
    //   1031	26	32	localException23	Exception
    //   1078	1016	32	localObject15	Object
    //   429	364	33	localObject16	Object
    //   1005	11	33	localException24	Exception
    //   1021	1061	33	localObject17	Object
    //   433	1559	34	localObject18	Object
    //   50	886	35	localObject19	Object
    //   945	104	35	localException25	Exception
    //   1062	37	35	localObject20	Object
    //   1107	1	35	localException26	Exception
    //   1124	1	35	localException27	Exception
    //   1129	27	35	localException28	Exception
    //   1161	985	35	localObject21	Object
    //   70	733	36	localObject22	Object
    //   831	1	36	localException29	Exception
    //   843	1	36	localException30	Exception
    //   848	1	36	localException31	Exception
    //   890	1	36	localException32	Exception
    //   895	1	36	localException33	Exception
    //   900	1	36	localException34	Exception
    //   972	7	36	localException35	Exception
    //   989	10	36	localException36	Exception
    //   1013	1146	36	localObject23	Object
    //   606	1016	37	localObject24	Object
    // Exception table:
    //   from	to	target	type
    //   367	395	398	java/lang/Exception
    //   358	367	403	java/lang/Exception
    //   351	358	408	java/lang/Exception
    //   342	351	413	java/lang/Exception
    //   709	720	831	java/lang/Exception
    //   665	705	843	java/lang/Exception
    //   652	661	848	java/lang/Exception
    //   641	652	890	java/lang/Exception
    //   612	641	895	java/lang/Exception
    //   599	608	900	java/lang/Exception
    //   588	599	945	java/lang/Exception
    //   577	588	972	java/lang/Exception
    //   566	577	989	java/lang/Exception
    //   550	562	1005	java/lang/Exception
    //   510	550	1026	java/lang/Exception
    //   497	506	1031	java/lang/Exception
    //   486	497	1083	java/lang/Exception
    //   474	486	1107	java/lang/Exception
    //   462	474	1124	java/lang/Exception
    //   328	337	1129	java/lang/Exception
    //   316	328	1174	java/lang/Exception
    //   277	316	1223	java/lang/Exception
    //   264	273	1228	java/lang/Exception
    //   225	264	1284	java/lang/Exception
    //   212	221	1289	java/lang/Exception
    //   201	212	1324	java/lang/Exception
    //   189	201	1332	java/lang/Exception
    //   163	174	1360	java/lang/Exception
    //   153	163	1376	java/lang/Exception
    //   142	153	1381	java/lang/Exception
    //   132	142	1394	java/lang/Exception
    //   122	132	1403	java/lang/Exception
    //   113	122	1408	java/lang/Exception
    //   102	113	1419	java/lang/Exception
    //   83	102	1424	java/lang/Exception
    //   62	83	1476	java/lang/Exception
  }
  
  public static boolean a()
  {
    int j = jdField_a_of_type_Int;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (-1 != j)
    {
      if (j == 1) {
        bool1 = true;
      }
      return bool1;
    }
    try
    {
      if (-1 != jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
        return bool1;
      }
      SharedPreferences localSharedPreferences = a(287, jdField_b_of_type_JavaLangString);
      jdField_a_of_type_Int = localSharedPreferences.getInt("isBlueToothSwitch", 1);
      jdField_a_of_type_Long = localSharedPreferences.getLong("bluetoothDelayTime", 1000L);
      bool1 = bool3;
      if (jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean a(long paramLong)
  {
    int j = a(287, jdField_b_of_type_JavaLangString).getInt("useAADSDeJitterAlgorithmUin", -1);
    boolean bool = false;
    if ((j > -1) && (paramLong % 10L <= j)) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JTest. read useAADSDeJitterAlgorithmUin = ");
    localStringBuilder.append(j);
    localStringBuilder.append(", useAADSDeJitterAlgorithm = ");
    localStringBuilder.append(bool);
    QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    if (paramJSONObject.has(paramString)) {
      paramBoolean = paramJSONObject.getBoolean(paramString);
    }
    return paramBoolean;
  }
  
  public static int b()
  {
    if (f == -1) {
      f = a(287, jdField_b_of_type_JavaLangString).getInt("sharpnessFPSThreshold", 7);
    }
    return f * 10;
  }
  
  private static String b(int paramInt, String paramString)
  {
    if ((AudioHelperUtil.b()) && (TextUtils.isEmpty(paramString)))
    {
      paramString = new StringBuilder();
      paramString.append("getConfigSPName uin不能为空, configId:");
      paramString.append(paramInt);
      throw new IllegalArgumentException(paramString.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_d_of_type_JavaLangString);
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean b()
  {
    int j = jdField_d_of_type_Int;
    boolean bool = false;
    if (j == -1) {
      jdField_d_of_type_Int = a(287, jdField_b_of_type_JavaLangString).getInt("SpeedDialScreenStyle", 0);
    }
    if (jdField_d_of_type_Int == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(long paramLong)
  {
    int j = a(287, jdField_b_of_type_JavaLangString).getInt("enableAADSDeJitterMaxJDelayUin", -1);
    boolean bool = false;
    if ((j > -1) && (paramLong % 10L <= j)) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JTest. read enableAADSDeJitterMaxJDelayUin = ");
    localStringBuilder.append(j);
    localStringBuilder.append(", enableAADSDeJitterMaxJDelay = ");
    localStringBuilder.append(bool);
    QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean c()
  {
    int j = jdField_e_of_type_Int;
    boolean bool = false;
    if (j == -1) {
      jdField_e_of_type_Int = a(287, jdField_b_of_type_JavaLangString).getInt("allowMicLongPressSpeakInMute", 0);
    }
    if (jdField_e_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      SharedPreferences localSharedPreferences = a(287, jdField_b_of_type_JavaLangString);
      int j = Build.VERSION.SDK_INT;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (j >= 19)
      {
        bool1 = bool2;
        if (localSharedPreferences.getBoolean("isSharpnessSwitch", false)) {
          bool1 = true;
        }
      }
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean e()
  {
    if (g == -1) {
      g = a(287, jdField_b_of_type_JavaLangString).getInt("davBubbleSwitch", 1);
    }
    return g == 0;
  }
  
  public static boolean f()
  {
    a();
    return jdField_b_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean g()
  {
    int j = h;
    boolean bool = false;
    if (j == -1) {
      h = a(287, jdField_b_of_type_JavaLangString).getInt("useRGB2I420Shader", 0);
    }
    if (h == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h()
  {
    int j = i;
    boolean bool = false;
    if (j == -1) {
      i = a(287, jdField_b_of_type_JavaLangString).getInt("upLoadWhenGetNewData", 0);
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i()
  {
    boolean bool = a(287, jdField_b_of_type_JavaLangString).getBoolean("isAllowedControlMicAfterBeMuted", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JTest. read isAllowedControlMicAfterBeMuted = ");
    localStringBuilder.append(bool);
    QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean j()
  {
    if (jdField_a_of_type_JavaLangInteger == null)
    {
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(a(287, jdField_b_of_type_JavaLangString).getInt("qavWatchTogetherSwitch", 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQavWatchTogetherOpen, switch[");
      localStringBuilder.append(jdField_a_of_type_JavaLangInteger);
      localStringBuilder.append("]");
      QLog.i("WTogether", 1, localStringBuilder.toString());
    }
    return jdField_a_of_type_JavaLangInteger.intValue() != 0;
  }
  
  public static boolean k()
  {
    if (jdField_b_of_type_JavaLangInteger == null)
    {
      jdField_b_of_type_JavaLangInteger = Integer.valueOf(a(287, jdField_b_of_type_JavaLangString).getInt("ScreenShareSwitch", 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQavScreenShareOpen, switch[");
      localStringBuilder.append(jdField_b_of_type_JavaLangInteger);
      localStringBuilder.append("]");
      QLog.i("WTogether", 1, localStringBuilder.toString());
    }
    return jdField_b_of_type_JavaLangInteger.intValue() != 0;
  }
  
  public static boolean l()
  {
    if (jdField_c_of_type_JavaLangInteger == null)
    {
      jdField_c_of_type_JavaLangInteger = Integer.valueOf(a(287, jdField_b_of_type_JavaLangString).getInt("AskScreenShareSwitch", 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQavScreenShareOpen, switch[");
      localStringBuilder.append(jdField_c_of_type_JavaLangInteger);
      localStringBuilder.append("]");
      QLog.i("WTogether", 1, localStringBuilder.toString());
    }
    return jdField_c_of_type_JavaLangInteger.intValue() != 0;
  }
  
  public static boolean m()
  {
    if (jdField_d_of_type_JavaLangInteger == null)
    {
      jdField_d_of_type_JavaLangInteger = Integer.valueOf(a(287, jdField_b_of_type_JavaLangString).getInt("avGameResultUseWebSwitch", 0));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAVGameResultWebOpen, switch[");
      localStringBuilder.append(jdField_d_of_type_JavaLangInteger);
      localStringBuilder.append("]");
      QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    }
    return jdField_d_of_type_JavaLangInteger.intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVConfigUtils
 * JD-Core Version:    0.7.0.1
 */
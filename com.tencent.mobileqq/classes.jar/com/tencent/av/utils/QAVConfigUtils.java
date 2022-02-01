package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class QAVConfigUtils
{
  public static String a = "ver";
  public static String b = "0";
  private static int c = -1;
  private static long d = 1000L;
  private static int e = -1;
  private static volatile int f = -1;
  private static int g = -1;
  private static int h = -1;
  private static Boolean i;
  private static int j = -1;
  private static volatile int k = -1;
  private static volatile int l = -1;
  private static volatile int m = -1;
  private static volatile int n = -1;
  private static volatile Boolean o;
  private static String p;
  private static int q = -1;
  private static int r = -1;
  private static int s = -1;
  private static String t = "qav_config_";
  private static String u = "text";
  private static Integer v;
  private static Integer w;
  private static Integer x;
  private static Integer y;
  private static QAVConfigUtils.ScreenShareSafeTips z;
  
  private static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject.has(paramString)) {
      paramInt = paramJSONObject.getInt(paramString);
    }
    return paramInt;
  }
  
  public static SharedPreferences a(int paramInt, String paramString)
  {
    paramString = d(paramInt, paramString);
    return BaseApplication.getContext().getSharedPreferences(paramString, 4);
  }
  
  public static QAVConfigUtils.MoreBtnTips a(int paramInt)
  {
    Object localObject = w();
    if (localObject == null) {
      return null;
    }
    for (;;)
    {
      int i1;
      try
      {
        QAVConfigUtils.MoreBtnTips localMoreBtnTips = new QAVConfigUtils.MoreBtnTips();
        localMoreBtnTips.c = 2147483647;
        i1 = 0;
        if (i1 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < localMoreBtnTips.c))
          {
            localMoreBtnTips.a = localJSONObject.getInt("id");
            localMoreBtnTips.b = localJSONObject.getString("url");
            localMoreBtnTips.c = localJSONObject.getInt("priority");
            localMoreBtnTips.d = localJSONObject.getInt("type");
          }
        }
        else if (localMoreBtnTips.c < 2147483647)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.a);
          ((StringBuilder)localObject).append(", url = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.b);
          ((StringBuilder)localObject).append(", priority = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.c);
          ((StringBuilder)localObject).append(", type = ");
          ((StringBuilder)localObject).append(localMoreBtnTips.d);
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
      i1 += 1;
    }
  }
  
  public static QAVConfigUtils.ScreenShareSafeTips a(String paramString1, String paramString2, String paramString3)
  {
    if (z == null)
    {
      z = new QAVConfigUtils.ScreenShareSafeTips(paramString1, paramString2, paramString3);
      paramString3 = a(287, b);
      paramString1 = paramString3.getString("screenShareTips", "");
      if (paramString1.equals(""))
      {
        QLog.i("QAVConfigUtils", 1, "screenShareTips not receive");
        return z;
      }
      paramString2 = paramString3.getString("screenTipsHighlight", "");
      if (paramString2.equals(""))
      {
        QLog.i("QAVConfigUtils", 1, "screenTipsHighlight not receive");
        return z;
      }
      paramString3 = paramString3.getString("screenTipsLink", "");
      if (paramString3.equals(""))
      {
        QLog.i("QAVConfigUtils", 1, "screenTipsLink not receive");
        return z;
      }
      Object localObject = z;
      ((QAVConfigUtils.ScreenShareSafeTips)localObject).a = paramString1;
      ((QAVConfigUtils.ScreenShareSafeTips)localObject).b = paramString2;
      ((QAVConfigUtils.ScreenShareSafeTips)localObject).c = paramString3;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sScreenShareSafeTips, content[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], highlight[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], link[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("]");
      QLog.i("QAVConfigUtils", 1, ((StringBuilder)localObject).toString());
    }
    return z;
  }
  
  private static Long a(JSONObject paramJSONObject, String paramString, Long paramLong)
  {
    long l1;
    if (paramJSONObject.has(paramString)) {
      l1 = paramJSONObject.getLong(paramString);
    } else {
      l1 = paramLong.longValue();
    }
    return Long.valueOf(l1);
  }
  
  private static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject.has(paramString1)) {
      paramString2 = paramJSONObject.getString(paramString1);
    }
    return paramString2;
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Object localObject = a(paramInt1, paramString1).edit();
    if (paramString2 == null) {
      ((SharedPreferences.Editor)localObject).remove(u);
    } else {
      ((SharedPreferences.Editor)localObject).putString(u, paramString2);
    }
    ((SharedPreferences.Editor)localObject).putInt(a, paramInt2);
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
    //   0: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: new 120	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   13: astore 37
    //   15: aload 37
    //   17: ldc_w 270
    //   20: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 37
    //   26: aload_0
    //   27: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 138
    //   33: iconst_2
    //   34: aload 37
    //   36: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokestatic 276	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: istore 25
    //   48: iconst_1
    //   49: istore_2
    //   50: ldc2_w 17
    //   53: lstore 33
    //   55: iload 25
    //   57: ifne +3307 -> 3364
    //   60: new 56	org/json/JSONObject
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 278	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   68: astore 45
    //   70: aload 45
    //   72: ldc_w 280
    //   75: iconst_1
    //   76: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   79: istore 13
    //   81: aload 45
    //   83: ldc_w 284
    //   86: ldc2_w 17
    //   89: invokestatic 219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokestatic 286	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;
    //   95: invokevirtual 215	java/lang/Long:longValue	()J
    //   98: lstore 35
    //   100: lload 35
    //   102: lstore 33
    //   104: aload 45
    //   106: ldc_w 288
    //   109: iconst_1
    //   110: invokestatic 291	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   113: istore 29
    //   115: aload 45
    //   117: ldc_w 293
    //   120: iconst_m1
    //   121: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   124: istore 4
    //   126: aload 45
    //   128: ldc_w 295
    //   131: iconst_0
    //   132: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   135: istore 14
    //   137: aload 45
    //   139: ldc_w 297
    //   142: iconst_0
    //   143: invokestatic 291	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   146: istore 30
    //   148: aload 45
    //   150: ldc_w 299
    //   153: ldc_w 301
    //   156: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 47
    //   161: aload 45
    //   163: ldc_w 305
    //   166: iconst_m1
    //   167: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   170: istore 15
    //   172: iload 13
    //   174: istore 16
    //   176: aload 45
    //   178: ldc_w 307
    //   181: iconst_0
    //   182: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   185: istore_1
    //   186: iload_1
    //   187: iconst_1
    //   188: if_icmpne +9 -> 197
    //   191: iconst_1
    //   192: istore 25
    //   194: goto +6 -> 200
    //   197: iconst_0
    //   198: istore 25
    //   200: aload 45
    //   202: ldc_w 309
    //   205: bipush 7
    //   207: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   210: istore_1
    //   211: aload 45
    //   213: ldc_w 311
    //   216: iconst_m1
    //   217: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   220: istore 11
    //   222: new 120	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   229: astore 37
    //   231: aload 47
    //   233: astore 46
    //   235: aload 37
    //   237: ldc_w 313
    //   240: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 37
    //   246: iload 11
    //   248: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: ldc 138
    //   254: iconst_1
    //   255: aload 37
    //   257: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload 45
    //   265: ldc_w 315
    //   268: iconst_m1
    //   269: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   272: istore_3
    //   273: new 120	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   280: astore 37
    //   282: iload 11
    //   284: istore 5
    //   286: aload 37
    //   288: ldc_w 317
    //   291: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 37
    //   297: iload_3
    //   298: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: ldc 138
    //   304: iconst_1
    //   305: aload 37
    //   307: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 45
    //   315: ldc_w 319
    //   318: iconst_0
    //   319: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   322: istore 12
    //   324: new 120	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   331: astore 37
    //   333: iload_3
    //   334: istore 6
    //   336: aload 37
    //   338: ldc_w 321
    //   341: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 37
    //   347: iload 12
    //   349: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc 138
    //   355: iconst_1
    //   356: aload 37
    //   358: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 45
    //   366: ldc_w 323
    //   369: iconst_0
    //   370: invokestatic 291	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   373: istore 27
    //   375: new 120	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   382: astore 37
    //   384: iload 12
    //   386: istore 7
    //   388: aload 37
    //   390: ldc_w 325
    //   393: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 37
    //   399: iload 27
    //   401: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: ldc 138
    //   407: iconst_1
    //   408: aload 37
    //   410: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload 45
    //   418: ldc_w 330
    //   421: iconst_m1
    //   422: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   425: istore 8
    //   427: aload 45
    //   429: ldc_w 332
    //   432: ldc 170
    //   434: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 37
    //   439: aload 45
    //   441: ldc_w 334
    //   444: invokevirtual 60	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   447: istore 26
    //   449: iload 26
    //   451: ifeq +127 -> 578
    //   454: aload 45
    //   456: ldc_w 334
    //   459: invokevirtual 338	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   462: astore 38
    //   464: aload 38
    //   466: invokevirtual 339	org/json/JSONArray:toString	()Ljava/lang/String;
    //   469: astore 39
    //   471: new 120	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   478: astore 38
    //   480: aload 38
    //   482: ldc_w 341
    //   485: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 38
    //   491: aload 39
    //   493: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: ldc 138
    //   499: iconst_1
    //   500: aload 38
    //   502: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: goto +74 -> 582
    //   511: astore 38
    //   513: goto +5 -> 518
    //   516: astore 38
    //   518: aload 39
    //   520: astore 41
    //   522: goto +14 -> 536
    //   525: astore 38
    //   527: goto +5 -> 532
    //   530: astore 38
    //   532: ldc 170
    //   534: astore 41
    //   536: ldc 170
    //   538: astore 43
    //   540: aload 37
    //   542: astore 39
    //   544: ldc 170
    //   546: astore 45
    //   548: aload 45
    //   550: astore 46
    //   552: aload 46
    //   554: astore 44
    //   556: aload 44
    //   558: astore 48
    //   560: aload 48
    //   562: astore 49
    //   564: aload 49
    //   566: astore 50
    //   568: iload 8
    //   570: istore_2
    //   571: aload 38
    //   573: astore 37
    //   575: goto +1296 -> 1871
    //   578: ldc 170
    //   580: astore 39
    //   582: iload 8
    //   584: istore_2
    //   585: iload 27
    //   587: istore 26
    //   589: aload 45
    //   591: ldc_w 343
    //   594: ldc 170
    //   596: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   599: astore 38
    //   601: aload 45
    //   603: ldc_w 345
    //   606: ldc 170
    //   608: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   611: astore 42
    //   613: aload 45
    //   615: ldc_w 347
    //   618: iconst_0
    //   619: invokestatic 291	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Z)Z
    //   622: istore 28
    //   624: new 120	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   631: astore 40
    //   633: aload 42
    //   635: astore 43
    //   637: aload 40
    //   639: ldc_w 349
    //   642: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 40
    //   648: iload 28
    //   650: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: ldc 138
    //   656: iconst_1
    //   657: aload 40
    //   659: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload 45
    //   667: ldc_w 351
    //   670: ldc 170
    //   672: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   675: astore 40
    //   677: aload 45
    //   679: ldc_w 353
    //   682: ldc 170
    //   684: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   687: astore 41
    //   689: iload 28
    //   691: istore 27
    //   693: aload 45
    //   695: ldc_w 355
    //   698: iconst_m1
    //   699: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   702: istore 9
    //   704: aload 45
    //   706: ldc_w 357
    //   709: iconst_m1
    //   710: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   713: istore 8
    //   715: aload 45
    //   717: ldc_w 359
    //   720: iconst_1
    //   721: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   724: istore 10
    //   726: new 120	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   733: astore 42
    //   735: aload 41
    //   737: astore 48
    //   739: aload 42
    //   741: ldc_w 361
    //   744: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 42
    //   750: iload 10
    //   752: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: ldc_w 363
    //   759: iconst_2
    //   760: aload 42
    //   762: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: aload 45
    //   770: ldc_w 367
    //   773: iconst_0
    //   774: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   777: istore 17
    //   779: new 120	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   786: astore 42
    //   788: iload 10
    //   790: istore 23
    //   792: aload 42
    //   794: ldc_w 369
    //   797: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload 42
    //   803: iload 17
    //   805: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: ldc_w 363
    //   812: iconst_2
    //   813: aload 42
    //   815: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: aload 45
    //   823: ldc_w 371
    //   826: iconst_m1
    //   827: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   830: istore 21
    //   832: aload 45
    //   834: ldc_w 373
    //   837: iconst_1
    //   838: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   841: istore_3
    //   842: aload 45
    //   844: ldc_w 375
    //   847: iconst_0
    //   848: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   851: istore 13
    //   853: aload 45
    //   855: ldc 168
    //   857: ldc 170
    //   859: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   862: astore 41
    //   864: aload 45
    //   866: ldc 185
    //   868: ldc 170
    //   870: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   873: astore 42
    //   875: aload 45
    //   877: ldc 189
    //   879: ldc 170
    //   881: invokestatic 303	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   884: astore 44
    //   886: aload 45
    //   888: ldc_w 377
    //   891: iconst_0
    //   892: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   895: istore 20
    //   897: aload 45
    //   899: ldc_w 379
    //   902: iconst_0
    //   903: invokestatic 282	com/tencent/av/utils/QAVConfigUtils:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   906: istore 18
    //   908: iload 13
    //   910: istore 19
    //   912: iload_1
    //   913: istore 10
    //   915: iload_3
    //   916: istore 22
    //   918: iload 29
    //   920: istore 32
    //   922: iload 4
    //   924: istore_1
    //   925: iload 14
    //   927: istore 4
    //   929: iload 16
    //   931: istore_3
    //   932: iload 25
    //   934: istore 28
    //   936: aload 46
    //   938: astore 51
    //   940: iload 5
    //   942: istore 11
    //   944: iload 6
    //   946: istore 12
    //   948: iload 7
    //   950: istore 13
    //   952: iload 26
    //   954: istore 29
    //   956: iload_2
    //   957: istore 14
    //   959: aload 37
    //   961: astore 45
    //   963: aload 39
    //   965: astore 46
    //   967: aload 38
    //   969: astore 47
    //   971: aload 43
    //   973: astore 49
    //   975: iload 27
    //   977: istore 31
    //   979: aload 40
    //   981: astore 50
    //   983: iload 9
    //   985: istore 16
    //   987: iload 8
    //   989: istore 24
    //   991: aload 41
    //   993: astore 38
    //   995: aload 42
    //   997: astore 39
    //   999: aload 44
    //   1001: astore 40
    //   1003: iload 30
    //   1005: istore 26
    //   1007: iload 32
    //   1009: istore 25
    //   1011: aload 51
    //   1013: astore 37
    //   1015: iload_3
    //   1016: istore_2
    //   1017: iload 15
    //   1019: istore_3
    //   1020: iload 28
    //   1022: istore 27
    //   1024: iload 10
    //   1026: istore 5
    //   1028: iload 11
    //   1030: istore 6
    //   1032: iload 12
    //   1034: istore 7
    //   1036: iload 13
    //   1038: istore 8
    //   1040: iload 29
    //   1042: istore 28
    //   1044: iload 14
    //   1046: istore 9
    //   1048: aload 45
    //   1050: astore 41
    //   1052: aload 46
    //   1054: astore 42
    //   1056: aload 47
    //   1058: astore 43
    //   1060: aload 49
    //   1062: astore 44
    //   1064: iload 31
    //   1066: istore 29
    //   1068: aload 50
    //   1070: astore 45
    //   1072: aload 48
    //   1074: astore 46
    //   1076: iload 16
    //   1078: istore 10
    //   1080: iload 24
    //   1082: istore 11
    //   1084: iload 23
    //   1086: istore 12
    //   1088: iload 17
    //   1090: istore 13
    //   1092: iload 21
    //   1094: istore 14
    //   1096: iload 22
    //   1098: istore 15
    //   1100: iload 19
    //   1102: istore 16
    //   1104: iload 20
    //   1106: istore 17
    //   1108: goto +2367 -> 3475
    //   1111: astore 47
    //   1113: iload 20
    //   1115: istore 18
    //   1117: iload 13
    //   1119: istore 7
    //   1121: iload_3
    //   1122: istore 13
    //   1124: aload 41
    //   1126: astore 50
    //   1128: aload 42
    //   1130: astore 45
    //   1132: aload 44
    //   1134: astore 49
    //   1136: goto +157 -> 1293
    //   1139: astore 45
    //   1141: goto +3 -> 1144
    //   1144: iload 13
    //   1146: istore 5
    //   1148: goto +111 -> 1259
    //   1151: astore 45
    //   1153: ldc 170
    //   1155: astore 47
    //   1157: aload 41
    //   1159: astore 50
    //   1161: aload 42
    //   1163: astore 44
    //   1165: aload 47
    //   1167: astore 41
    //   1169: goto +30 -> 1199
    //   1172: astore 42
    //   1174: aload 41
    //   1176: astore 50
    //   1178: goto +9 -> 1187
    //   1181: astore 42
    //   1183: ldc 170
    //   1185: astore 50
    //   1187: ldc 170
    //   1189: astore 44
    //   1191: ldc 170
    //   1193: astore 41
    //   1195: aload 42
    //   1197: astore 45
    //   1199: iload 13
    //   1201: istore 5
    //   1203: aload 45
    //   1205: astore 42
    //   1207: aload 41
    //   1209: astore 49
    //   1211: goto +64 -> 1275
    //   1214: astore 45
    //   1216: goto +3 -> 1219
    //   1219: ldc 170
    //   1221: astore 41
    //   1223: aload 41
    //   1225: astore 42
    //   1227: aload 42
    //   1229: astore 44
    //   1231: iconst_0
    //   1232: istore 5
    //   1234: goto +25 -> 1259
    //   1237: astore 45
    //   1239: goto +3 -> 1242
    //   1242: ldc 170
    //   1244: astore 41
    //   1246: aload 41
    //   1248: astore 42
    //   1250: aload 42
    //   1252: astore 44
    //   1254: iconst_0
    //   1255: istore 5
    //   1257: iconst_1
    //   1258: istore_3
    //   1259: aload 44
    //   1261: astore 49
    //   1263: aload 42
    //   1265: astore 44
    //   1267: aload 41
    //   1269: astore 50
    //   1271: aload 45
    //   1273: astore 42
    //   1275: iconst_0
    //   1276: istore 18
    //   1278: aload 44
    //   1280: astore 45
    //   1282: iload_3
    //   1283: istore 13
    //   1285: iload 5
    //   1287: istore 7
    //   1289: aload 42
    //   1291: astore 47
    //   1293: iload 9
    //   1295: istore 19
    //   1297: iload 28
    //   1299: istore 31
    //   1301: iload_2
    //   1302: istore 20
    //   1304: iload 12
    //   1306: istore 22
    //   1308: iload 11
    //   1310: istore 23
    //   1312: iload_1
    //   1313: istore 12
    //   1315: iload 29
    //   1317: istore 27
    //   1319: iload 21
    //   1321: istore 5
    //   1323: iload 17
    //   1325: istore 9
    //   1327: iload 8
    //   1329: istore_3
    //   1330: iload 10
    //   1332: istore_1
    //   1333: iload 26
    //   1335: istore 28
    //   1337: iload 6
    //   1339: istore 17
    //   1341: iload 15
    //   1343: istore_2
    //   1344: iload 30
    //   1346: istore 26
    //   1348: iload 14
    //   1350: istore 10
    //   1352: iload 4
    //   1354: istore 11
    //   1356: lload 35
    //   1358: lstore 33
    //   1360: iload 9
    //   1362: istore 4
    //   1364: iload 18
    //   1366: istore 6
    //   1368: iload 13
    //   1370: istore 8
    //   1372: iload 11
    //   1374: istore 9
    //   1376: iload 16
    //   1378: istore 11
    //   1380: aload 46
    //   1382: astore 41
    //   1384: iload 23
    //   1386: istore 13
    //   1388: iload 17
    //   1390: istore 14
    //   1392: iload 22
    //   1394: istore 15
    //   1396: iload 20
    //   1398: istore 16
    //   1400: iload 31
    //   1402: istore 29
    //   1404: aload 48
    //   1406: astore 42
    //   1408: iload 19
    //   1410: istore 17
    //   1412: aload 50
    //   1414: astore 44
    //   1416: aload 49
    //   1418: astore 46
    //   1420: goto +1716 -> 3136
    //   1423: astore 44
    //   1425: goto +5 -> 1430
    //   1428: astore 44
    //   1430: ldc 170
    //   1432: astore 42
    //   1434: aload 42
    //   1436: astore 49
    //   1438: aload 49
    //   1440: astore 45
    //   1442: iload 17
    //   1444: istore_3
    //   1445: goto +24 -> 1469
    //   1448: astore 44
    //   1450: goto +5 -> 1455
    //   1453: astore 44
    //   1455: ldc 170
    //   1457: astore 42
    //   1459: aload 42
    //   1461: astore 49
    //   1463: aload 49
    //   1465: astore 45
    //   1467: iconst_0
    //   1468: istore_3
    //   1469: aload 44
    //   1471: astore 52
    //   1473: goto +61 -> 1534
    //   1476: astore 45
    //   1478: aload 41
    //   1480: astore 46
    //   1482: goto +3 -> 1485
    //   1485: ldc 170
    //   1487: astore 44
    //   1489: aload 44
    //   1491: astore 43
    //   1493: aload 43
    //   1495: astore 41
    //   1497: iload 9
    //   1499: istore 6
    //   1501: aload 40
    //   1503: astore 48
    //   1505: aload 46
    //   1507: astore 40
    //   1509: goto +164 -> 1673
    //   1512: astore 52
    //   1514: iconst_1
    //   1515: istore 10
    //   1517: ldc 170
    //   1519: astore 42
    //   1521: aload 42
    //   1523: astore 49
    //   1525: aload 49
    //   1527: astore 45
    //   1529: iconst_m1
    //   1530: istore 8
    //   1532: iconst_0
    //   1533: istore_3
    //   1534: iload 9
    //   1536: istore 11
    //   1538: aload 41
    //   1540: astore 44
    //   1542: iload_3
    //   1543: istore 9
    //   1545: aload 37
    //   1547: astore 51
    //   1549: aload 39
    //   1551: astore 41
    //   1553: aload 38
    //   1555: astore 50
    //   1557: aload 43
    //   1559: astore 48
    //   1561: iload 26
    //   1563: istore 27
    //   1565: aload 40
    //   1567: astore 46
    //   1569: iload 28
    //   1571: istore 26
    //   1573: iload 11
    //   1575: istore_3
    //   1576: aload 49
    //   1578: astore 40
    //   1580: aload 45
    //   1582: astore 38
    //   1584: goto +329 -> 1913
    //   1587: astore 45
    //   1589: goto +3 -> 1592
    //   1592: ldc 170
    //   1594: astore 43
    //   1596: aload 40
    //   1598: astore 48
    //   1600: aload 41
    //   1602: astore 46
    //   1604: aload 43
    //   1606: astore 40
    //   1608: goto +39 -> 1647
    //   1611: astore 45
    //   1613: ldc 170
    //   1615: astore 41
    //   1617: aload 40
    //   1619: astore 48
    //   1621: goto +18 -> 1639
    //   1624: astore 45
    //   1626: goto +5 -> 1631
    //   1629: astore 45
    //   1631: ldc 170
    //   1633: astore 48
    //   1635: aload 48
    //   1637: astore 41
    //   1639: aload 41
    //   1641: astore 40
    //   1643: aload 41
    //   1645: astore 46
    //   1647: aload 40
    //   1649: astore 43
    //   1651: aload 43
    //   1653: astore 41
    //   1655: iload 28
    //   1657: istore 27
    //   1659: iconst_m1
    //   1660: istore 8
    //   1662: iconst_m1
    //   1663: istore 6
    //   1665: aload 40
    //   1667: astore 44
    //   1669: aload 46
    //   1671: astore 40
    //   1673: aload 45
    //   1675: astore 51
    //   1677: iload 7
    //   1679: istore 11
    //   1681: aload 37
    //   1683: astore 50
    //   1685: aload 39
    //   1687: astore 49
    //   1689: aload 38
    //   1691: astore 46
    //   1693: aload 42
    //   1695: astore 45
    //   1697: iload 26
    //   1699: istore 28
    //   1701: aload 48
    //   1703: astore 42
    //   1705: iload_2
    //   1706: istore 7
    //   1708: iload 27
    //   1710: istore 26
    //   1712: aload 44
    //   1714: astore 39
    //   1716: aload 43
    //   1718: astore 38
    //   1720: aload 41
    //   1722: astore 37
    //   1724: goto +270 -> 1994
    //   1727: astore 40
    //   1729: goto +3 -> 1732
    //   1732: aload 42
    //   1734: astore 45
    //   1736: ldc 170
    //   1738: astore 41
    //   1740: aload 37
    //   1742: astore 42
    //   1744: aload 41
    //   1746: astore 37
    //   1748: goto +84 -> 1832
    //   1751: astore 40
    //   1753: ldc 170
    //   1755: astore 43
    //   1757: aload 37
    //   1759: astore 42
    //   1761: aload 38
    //   1763: astore 41
    //   1765: aload 43
    //   1767: astore 38
    //   1769: goto +51 -> 1820
    //   1772: astore 40
    //   1774: ldc 170
    //   1776: astore 38
    //   1778: aload 37
    //   1780: astore 42
    //   1782: aload 38
    //   1784: astore 37
    //   1786: goto +26 -> 1812
    //   1789: astore 40
    //   1791: aload 37
    //   1793: astore 42
    //   1795: goto +9 -> 1804
    //   1798: astore 40
    //   1800: ldc 170
    //   1802: astore 42
    //   1804: ldc 170
    //   1806: astore 39
    //   1808: ldc 170
    //   1810: astore 37
    //   1812: aload 37
    //   1814: astore 38
    //   1816: aload 37
    //   1818: astore 41
    //   1820: aload 38
    //   1822: astore 37
    //   1824: aload 38
    //   1826: astore 45
    //   1828: aload 41
    //   1830: astore 38
    //   1832: aload 37
    //   1834: astore 44
    //   1836: aload 44
    //   1838: astore 48
    //   1840: aload 48
    //   1842: astore 49
    //   1844: aload 49
    //   1846: astore 50
    //   1848: iload 8
    //   1850: istore_2
    //   1851: aload 37
    //   1853: astore 46
    //   1855: aload 38
    //   1857: astore 43
    //   1859: aload 39
    //   1861: astore 41
    //   1863: aload 42
    //   1865: astore 39
    //   1867: aload 40
    //   1869: astore 37
    //   1871: iconst_1
    //   1872: istore 10
    //   1874: iconst_m1
    //   1875: istore 8
    //   1877: iconst_0
    //   1878: istore 9
    //   1880: iconst_0
    //   1881: istore 26
    //   1883: iconst_m1
    //   1884: istore_3
    //   1885: aload 50
    //   1887: astore 38
    //   1889: aload 49
    //   1891: astore 40
    //   1893: aload 48
    //   1895: astore 42
    //   1897: aload 45
    //   1899: astore 48
    //   1901: aload 43
    //   1903: astore 50
    //   1905: aload 39
    //   1907: astore 51
    //   1909: aload 37
    //   1911: astore 52
    //   1913: aload 52
    //   1915: astore 37
    //   1917: iload 6
    //   1919: istore 11
    //   1921: iload_3
    //   1922: istore 6
    //   1924: goto +190 -> 2114
    //   1927: astore 41
    //   1929: goto +5 -> 1934
    //   1932: astore 41
    //   1934: ldc 170
    //   1936: astore 50
    //   1938: aload 50
    //   1940: astore 49
    //   1942: aload 49
    //   1944: astore 46
    //   1946: aload 46
    //   1948: astore 45
    //   1950: aload 45
    //   1952: astore 42
    //   1954: aload 42
    //   1956: astore 40
    //   1958: aload 40
    //   1960: astore 39
    //   1962: aload 39
    //   1964: astore 38
    //   1966: aload 38
    //   1968: astore 37
    //   1970: iload 12
    //   1972: istore 11
    //   1974: iconst_m1
    //   1975: istore 8
    //   1977: iconst_m1
    //   1978: istore 7
    //   1980: iconst_0
    //   1981: istore 26
    //   1983: iconst_m1
    //   1984: istore 6
    //   1986: iload 27
    //   1988: istore 28
    //   1990: aload 41
    //   1992: astore 51
    //   1994: iload 5
    //   1996: istore_2
    //   1997: aload 51
    //   1999: astore 52
    //   2001: aload 50
    //   2003: astore 51
    //   2005: aload 49
    //   2007: astore 50
    //   2009: aload 46
    //   2011: astore 49
    //   2013: aload 45
    //   2015: astore 48
    //   2017: aload 42
    //   2019: astore 41
    //   2021: iload 7
    //   2023: istore 5
    //   2025: aload 40
    //   2027: astore 42
    //   2029: aload 39
    //   2031: astore 43
    //   2033: aload 38
    //   2035: astore 44
    //   2037: aload 37
    //   2039: astore 45
    //   2041: goto +198 -> 2239
    //   2044: astore 37
    //   2046: goto +5 -> 2051
    //   2049: astore 37
    //   2051: iconst_1
    //   2052: istore 10
    //   2054: ldc 170
    //   2056: astore 51
    //   2058: aload 51
    //   2060: astore 41
    //   2062: aload 41
    //   2064: astore 50
    //   2066: aload 50
    //   2068: astore 48
    //   2070: aload 48
    //   2072: astore 46
    //   2074: aload 46
    //   2076: astore 44
    //   2078: aload 44
    //   2080: astore 42
    //   2082: aload 42
    //   2084: astore 40
    //   2086: aload 40
    //   2088: astore 38
    //   2090: iload 12
    //   2092: istore 7
    //   2094: iconst_m1
    //   2095: istore 8
    //   2097: iconst_0
    //   2098: istore 9
    //   2100: iconst_0
    //   2101: istore 27
    //   2103: iconst_m1
    //   2104: istore_2
    //   2105: iconst_0
    //   2106: istore 26
    //   2108: iconst_m1
    //   2109: istore 6
    //   2111: iload_3
    //   2112: istore 11
    //   2114: aload 37
    //   2116: astore 52
    //   2118: iload 5
    //   2120: istore 12
    //   2122: iload 7
    //   2124: istore_3
    //   2125: aload 51
    //   2127: astore 37
    //   2129: aload 41
    //   2131: astore 51
    //   2133: aload 50
    //   2135: astore 39
    //   2137: aload 48
    //   2139: astore 49
    //   2141: iload 27
    //   2143: istore 28
    //   2145: aload 46
    //   2147: astore 41
    //   2149: iload_2
    //   2150: istore 5
    //   2152: aload 44
    //   2154: astore 48
    //   2156: aload 42
    //   2158: astore 43
    //   2160: aload 40
    //   2162: astore 44
    //   2164: aload 38
    //   2166: astore 45
    //   2168: goto +195 -> 2363
    //   2171: astore 37
    //   2173: goto +5 -> 2178
    //   2176: astore 37
    //   2178: ldc 170
    //   2180: astore 51
    //   2182: aload 51
    //   2184: astore 50
    //   2186: aload 50
    //   2188: astore 49
    //   2190: aload 49
    //   2192: astore 48
    //   2194: aload 48
    //   2196: astore 41
    //   2198: aload 41
    //   2200: astore 42
    //   2202: aload 42
    //   2204: astore 43
    //   2206: aload 43
    //   2208: astore 44
    //   2210: aload 44
    //   2212: astore 45
    //   2214: iload 11
    //   2216: istore_2
    //   2217: iconst_m1
    //   2218: istore 8
    //   2220: iconst_0
    //   2221: istore 11
    //   2223: iconst_0
    //   2224: istore 28
    //   2226: iconst_m1
    //   2227: istore 5
    //   2229: iconst_0
    //   2230: istore 26
    //   2232: iconst_m1
    //   2233: istore 6
    //   2235: aload 37
    //   2237: astore 52
    //   2239: iconst_0
    //   2240: istore 9
    //   2242: iconst_1
    //   2243: istore 7
    //   2245: aload 52
    //   2247: astore 46
    //   2249: iload 25
    //   2251: istore 27
    //   2253: iload_1
    //   2254: istore 10
    //   2256: iload_2
    //   2257: istore_1
    //   2258: iload_3
    //   2259: istore_2
    //   2260: iload 11
    //   2262: istore_3
    //   2263: aload 51
    //   2265: astore 37
    //   2267: aload 50
    //   2269: astore 38
    //   2271: aload 49
    //   2273: astore 39
    //   2275: aload 48
    //   2277: astore 40
    //   2279: iload 28
    //   2281: istore 25
    //   2283: goto +222 -> 2505
    //   2286: astore 38
    //   2288: goto +5 -> 2293
    //   2291: astore 38
    //   2293: iconst_1
    //   2294: istore 10
    //   2296: ldc 170
    //   2298: astore 37
    //   2300: aload 37
    //   2302: astore 51
    //   2304: aload 51
    //   2306: astore 39
    //   2308: aload 39
    //   2310: astore 49
    //   2312: aload 49
    //   2314: astore 41
    //   2316: aload 41
    //   2318: astore 48
    //   2320: aload 48
    //   2322: astore 43
    //   2324: aload 43
    //   2326: astore 44
    //   2328: aload 44
    //   2330: astore 45
    //   2332: iload 11
    //   2334: istore 12
    //   2336: iconst_m1
    //   2337: istore 8
    //   2339: iconst_0
    //   2340: istore 9
    //   2342: iconst_m1
    //   2343: istore 11
    //   2345: iconst_0
    //   2346: istore_3
    //   2347: iconst_0
    //   2348: istore 28
    //   2350: iconst_m1
    //   2351: istore 5
    //   2353: iconst_0
    //   2354: istore 26
    //   2356: iconst_m1
    //   2357: istore 6
    //   2359: aload 38
    //   2361: astore 52
    //   2363: aload 52
    //   2365: astore 46
    //   2367: iload 10
    //   2369: istore 7
    //   2371: iload 25
    //   2373: istore 27
    //   2375: iload_1
    //   2376: istore 10
    //   2378: iload 12
    //   2380: istore_1
    //   2381: iload 11
    //   2383: istore_2
    //   2384: aload 51
    //   2386: astore 38
    //   2388: aload 49
    //   2390: astore 40
    //   2392: iload 28
    //   2394: istore 25
    //   2396: aload 48
    //   2398: astore 42
    //   2400: goto +105 -> 2505
    //   2403: astore 46
    //   2405: goto +3 -> 2408
    //   2408: iload 25
    //   2410: istore 27
    //   2412: iload_1
    //   2413: istore 10
    //   2415: goto +27 -> 2442
    //   2418: astore 46
    //   2420: goto +3 -> 2423
    //   2423: goto +11 -> 2434
    //   2426: astore 46
    //   2428: goto +3 -> 2431
    //   2431: iconst_0
    //   2432: istore 25
    //   2434: bipush 7
    //   2436: istore 10
    //   2438: iload 25
    //   2440: istore 27
    //   2442: ldc 170
    //   2444: astore 45
    //   2446: ldc 170
    //   2448: astore 44
    //   2450: ldc 170
    //   2452: astore 43
    //   2454: ldc 170
    //   2456: astore 42
    //   2458: ldc 170
    //   2460: astore 41
    //   2462: ldc 170
    //   2464: astore 40
    //   2466: ldc 170
    //   2468: astore 39
    //   2470: ldc 170
    //   2472: astore 38
    //   2474: ldc 170
    //   2476: astore 37
    //   2478: iconst_0
    //   2479: istore 9
    //   2481: iconst_m1
    //   2482: istore 8
    //   2484: iconst_1
    //   2485: istore 7
    //   2487: iconst_m1
    //   2488: istore_1
    //   2489: iconst_m1
    //   2490: istore_2
    //   2491: iconst_0
    //   2492: istore_3
    //   2493: iconst_0
    //   2494: istore 25
    //   2496: iconst_m1
    //   2497: istore 5
    //   2499: iconst_0
    //   2500: istore 26
    //   2502: iconst_m1
    //   2503: istore 6
    //   2505: iload 7
    //   2507: istore 11
    //   2509: iload 8
    //   2511: istore 12
    //   2513: iload 9
    //   2515: istore 8
    //   2517: iload 15
    //   2519: istore 7
    //   2521: iload_1
    //   2522: istore 18
    //   2524: iload_2
    //   2525: istore_1
    //   2526: goto +89 -> 2615
    //   2529: astore 46
    //   2531: goto +10 -> 2541
    //   2534: astore 46
    //   2536: ldc_w 301
    //   2539: astore 47
    //   2541: iconst_1
    //   2542: istore 11
    //   2544: ldc 170
    //   2546: astore 37
    //   2548: aload 37
    //   2550: astore 38
    //   2552: aload 38
    //   2554: astore 39
    //   2556: aload 39
    //   2558: astore 40
    //   2560: aload 40
    //   2562: astore 41
    //   2564: aload 41
    //   2566: astore 42
    //   2568: aload 42
    //   2570: astore 43
    //   2572: aload 43
    //   2574: astore 44
    //   2576: aload 44
    //   2578: astore 45
    //   2580: iconst_m1
    //   2581: istore 12
    //   2583: iconst_0
    //   2584: istore 8
    //   2586: iconst_0
    //   2587: istore 27
    //   2589: bipush 7
    //   2591: istore 10
    //   2593: iconst_m1
    //   2594: istore 7
    //   2596: iconst_m1
    //   2597: istore 18
    //   2599: iconst_m1
    //   2600: istore_1
    //   2601: iconst_0
    //   2602: istore_3
    //   2603: iconst_0
    //   2604: istore 25
    //   2606: iconst_m1
    //   2607: istore 5
    //   2609: iconst_0
    //   2610: istore 26
    //   2612: iconst_m1
    //   2613: istore 6
    //   2615: iload 12
    //   2617: istore 9
    //   2619: iload 30
    //   2621: istore 31
    //   2623: iload 10
    //   2625: istore 12
    //   2627: iload 7
    //   2629: istore_2
    //   2630: iload_3
    //   2631: istore 15
    //   2633: iload 25
    //   2635: istore 28
    //   2637: iload 5
    //   2639: istore 16
    //   2641: iload 6
    //   2643: istore 17
    //   2645: goto +87 -> 2732
    //   2648: astore 46
    //   2650: iconst_1
    //   2651: istore 11
    //   2653: ldc_w 301
    //   2656: astore 47
    //   2658: ldc 170
    //   2660: astore 37
    //   2662: aload 37
    //   2664: astore 38
    //   2666: aload 38
    //   2668: astore 39
    //   2670: aload 39
    //   2672: astore 40
    //   2674: aload 40
    //   2676: astore 41
    //   2678: aload 41
    //   2680: astore 42
    //   2682: aload 42
    //   2684: astore 43
    //   2686: aload 43
    //   2688: astore 44
    //   2690: aload 44
    //   2692: astore 45
    //   2694: iconst_m1
    //   2695: istore 9
    //   2697: iconst_0
    //   2698: istore 8
    //   2700: iconst_0
    //   2701: istore 31
    //   2703: iconst_0
    //   2704: istore 27
    //   2706: bipush 7
    //   2708: istore 12
    //   2710: iconst_m1
    //   2711: istore_2
    //   2712: iconst_m1
    //   2713: istore 18
    //   2715: iconst_m1
    //   2716: istore_1
    //   2717: iconst_0
    //   2718: istore 15
    //   2720: iconst_0
    //   2721: istore 28
    //   2723: iconst_m1
    //   2724: istore 16
    //   2726: iconst_0
    //   2727: istore 26
    //   2729: iconst_m1
    //   2730: istore 17
    //   2732: iload 14
    //   2734: istore 10
    //   2736: iload 4
    //   2738: istore 6
    //   2740: aload 46
    //   2742: astore 53
    //   2744: iload 11
    //   2746: istore 5
    //   2748: iload 9
    //   2750: istore_3
    //   2751: iload 8
    //   2753: istore 4
    //   2755: iload 6
    //   2757: istore 9
    //   2759: iload 27
    //   2761: istore 25
    //   2763: aload 47
    //   2765: astore 52
    //   2767: iload_1
    //   2768: istore 14
    //   2770: aload 38
    //   2772: astore 51
    //   2774: aload 39
    //   2776: astore 38
    //   2778: aload 40
    //   2780: astore 50
    //   2782: aload 41
    //   2784: astore 40
    //   2786: iload 26
    //   2788: istore 30
    //   2790: aload 43
    //   2792: astore 49
    //   2794: aload 44
    //   2796: astore 48
    //   2798: aload 45
    //   2800: astore 46
    //   2802: goto +106 -> 2908
    //   2805: astore 39
    //   2807: iload 4
    //   2809: istore 9
    //   2811: goto +8 -> 2819
    //   2814: astore 39
    //   2816: iconst_m1
    //   2817: istore 9
    //   2819: ldc 170
    //   2821: astore 46
    //   2823: ldc 170
    //   2825: astore 48
    //   2827: ldc 170
    //   2829: astore 49
    //   2831: ldc 170
    //   2833: astore 42
    //   2835: ldc 170
    //   2837: astore 40
    //   2839: ldc 170
    //   2841: astore 50
    //   2843: ldc 170
    //   2845: astore 38
    //   2847: ldc 170
    //   2849: astore 51
    //   2851: ldc 170
    //   2853: astore 37
    //   2855: ldc_w 301
    //   2858: astore 52
    //   2860: iconst_0
    //   2861: istore 4
    //   2863: iconst_m1
    //   2864: istore_3
    //   2865: iconst_1
    //   2866: istore 5
    //   2868: iconst_0
    //   2869: istore 10
    //   2871: iconst_0
    //   2872: istore 31
    //   2874: iconst_0
    //   2875: istore 25
    //   2877: bipush 7
    //   2879: istore 12
    //   2881: iconst_m1
    //   2882: istore_2
    //   2883: iconst_m1
    //   2884: istore 18
    //   2886: iconst_m1
    //   2887: istore 14
    //   2889: iconst_0
    //   2890: istore 15
    //   2892: iconst_0
    //   2893: istore 28
    //   2895: iconst_m1
    //   2896: istore 16
    //   2898: iconst_0
    //   2899: istore 30
    //   2901: iconst_m1
    //   2902: istore 17
    //   2904: aload 39
    //   2906: astore 53
    //   2908: iload 13
    //   2910: istore 11
    //   2912: iconst_1
    //   2913: istore 8
    //   2915: iload 29
    //   2917: istore 27
    //   2919: iconst_0
    //   2920: istore 7
    //   2922: iconst_m1
    //   2923: istore 13
    //   2925: iconst_0
    //   2926: istore 6
    //   2928: aload 53
    //   2930: astore 47
    //   2932: iload 5
    //   2934: istore_1
    //   2935: iload 13
    //   2937: istore 5
    //   2939: iload 31
    //   2941: istore 26
    //   2943: aload 52
    //   2945: astore 41
    //   2947: iload 18
    //   2949: istore 13
    //   2951: aload 51
    //   2953: astore 39
    //   2955: aload 50
    //   2957: astore 43
    //   2959: iload 30
    //   2961: istore 29
    //   2963: aload 49
    //   2965: astore 44
    //   2967: aload 48
    //   2969: astore 45
    //   2971: goto +165 -> 3136
    //   2974: astore 47
    //   2976: goto +5 -> 2981
    //   2979: astore 47
    //   2981: iload 13
    //   2983: istore 11
    //   2985: ldc 170
    //   2987: astore 37
    //   2989: aload 37
    //   2991: astore 39
    //   2993: aload 39
    //   2995: astore 38
    //   2997: aload 38
    //   2999: astore 43
    //   3001: aload 43
    //   3003: astore 40
    //   3005: aload 40
    //   3007: astore 42
    //   3009: aload 42
    //   3011: astore 44
    //   3013: aload 44
    //   3015: astore 45
    //   3017: aload 45
    //   3019: astore 46
    //   3021: goto +49 -> 3070
    //   3024: astore 47
    //   3026: ldc2_w 17
    //   3029: lstore 33
    //   3031: ldc 170
    //   3033: astore 37
    //   3035: aload 37
    //   3037: astore 39
    //   3039: aload 39
    //   3041: astore 38
    //   3043: aload 38
    //   3045: astore 43
    //   3047: aload 43
    //   3049: astore 40
    //   3051: aload 40
    //   3053: astore 42
    //   3055: aload 42
    //   3057: astore 44
    //   3059: aload 44
    //   3061: astore 45
    //   3063: aload 45
    //   3065: astore 46
    //   3067: iconst_1
    //   3068: istore 11
    //   3070: ldc_w 301
    //   3073: astore 41
    //   3075: iconst_0
    //   3076: istore 26
    //   3078: iconst_0
    //   3079: istore 10
    //   3081: iconst_m1
    //   3082: istore 9
    //   3084: iconst_1
    //   3085: istore 8
    //   3087: iconst_1
    //   3088: istore 27
    //   3090: iconst_0
    //   3091: istore 7
    //   3093: iconst_0
    //   3094: istore 6
    //   3096: iconst_m1
    //   3097: istore 5
    //   3099: iconst_0
    //   3100: istore 4
    //   3102: iconst_m1
    //   3103: istore_3
    //   3104: iconst_1
    //   3105: istore_1
    //   3106: iconst_0
    //   3107: istore 25
    //   3109: bipush 7
    //   3111: istore 12
    //   3113: iconst_m1
    //   3114: istore_2
    //   3115: iconst_m1
    //   3116: istore 13
    //   3118: iconst_m1
    //   3119: istore 14
    //   3121: iconst_0
    //   3122: istore 15
    //   3124: iconst_0
    //   3125: istore 28
    //   3127: iconst_m1
    //   3128: istore 16
    //   3130: iconst_0
    //   3131: istore 29
    //   3133: iconst_m1
    //   3134: istore 17
    //   3136: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3139: ifeq +47 -> 3186
    //   3142: new 120	java/lang/StringBuilder
    //   3145: dup
    //   3146: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   3149: astore 48
    //   3151: aload 48
    //   3153: ldc_w 381
    //   3156: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3159: pop
    //   3160: aload 48
    //   3162: aload 47
    //   3164: invokestatic 153	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3167: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3170: pop
    //   3171: ldc_w 363
    //   3174: iconst_2
    //   3175: aload 48
    //   3177: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3180: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3183: goto +3 -> 3186
    //   3186: iload_3
    //   3187: istore 22
    //   3189: iload 4
    //   3191: istore 19
    //   3193: iload 5
    //   3195: istore 20
    //   3197: iload 6
    //   3199: istore 18
    //   3201: iload 7
    //   3203: istore 21
    //   3205: iload 27
    //   3207: istore 30
    //   3209: iload 8
    //   3211: istore 23
    //   3213: iload 9
    //   3215: istore_3
    //   3216: iload 10
    //   3218: istore 4
    //   3220: iload 25
    //   3222: istore 27
    //   3224: aload 41
    //   3226: astore 52
    //   3228: iload 12
    //   3230: istore 5
    //   3232: iload 13
    //   3234: istore 6
    //   3236: iload 14
    //   3238: istore 7
    //   3240: iload 15
    //   3242: istore 8
    //   3244: aload 37
    //   3246: astore 41
    //   3248: aload 39
    //   3250: astore 47
    //   3252: aload 38
    //   3254: astore 48
    //   3256: aload 43
    //   3258: astore 49
    //   3260: aload 40
    //   3262: astore 50
    //   3264: iload 16
    //   3266: istore 9
    //   3268: aload 42
    //   3270: astore 51
    //   3272: iload 17
    //   3274: istore 10
    //   3276: aload 44
    //   3278: astore 38
    //   3280: aload 45
    //   3282: astore 39
    //   3284: aload 46
    //   3286: astore 40
    //   3288: iload_1
    //   3289: istore 12
    //   3291: iconst_0
    //   3292: istore 24
    //   3294: iload_2
    //   3295: istore 13
    //   3297: iload 30
    //   3299: istore 25
    //   3301: aload 52
    //   3303: astore 37
    //   3305: iload_3
    //   3306: istore_1
    //   3307: iload 11
    //   3309: istore_2
    //   3310: iload 13
    //   3312: istore_3
    //   3313: aload 47
    //   3315: astore 42
    //   3317: aload 48
    //   3319: astore 43
    //   3321: aload 49
    //   3323: astore 44
    //   3325: aload 50
    //   3327: astore 45
    //   3329: aload 51
    //   3331: astore 46
    //   3333: iload 22
    //   3335: istore 11
    //   3337: iload 19
    //   3339: istore 13
    //   3341: iload 20
    //   3343: istore 14
    //   3345: iload 23
    //   3347: istore 15
    //   3349: iload 21
    //   3351: istore 16
    //   3353: iload 18
    //   3355: istore 17
    //   3357: iload 24
    //   3359: istore 18
    //   3361: goto +114 -> 3475
    //   3364: ldc 170
    //   3366: astore 38
    //   3368: ldc_w 301
    //   3371: astore 37
    //   3373: ldc2_w 17
    //   3376: lstore 33
    //   3378: aload 38
    //   3380: astore 39
    //   3382: aload 39
    //   3384: astore 40
    //   3386: aload 40
    //   3388: astore 41
    //   3390: aload 41
    //   3392: astore 42
    //   3394: aload 42
    //   3396: astore 43
    //   3398: aload 43
    //   3400: astore 44
    //   3402: aload 44
    //   3404: astore 45
    //   3406: aload 45
    //   3408: astore 46
    //   3410: iconst_1
    //   3411: istore 25
    //   3413: iconst_m1
    //   3414: istore_1
    //   3415: iconst_0
    //   3416: istore 4
    //   3418: iconst_0
    //   3419: istore 27
    //   3421: bipush 7
    //   3423: istore 5
    //   3425: iconst_m1
    //   3426: istore 6
    //   3428: iconst_m1
    //   3429: istore 7
    //   3431: iconst_0
    //   3432: istore 8
    //   3434: iconst_0
    //   3435: istore 28
    //   3437: iconst_m1
    //   3438: istore 9
    //   3440: iconst_0
    //   3441: istore 29
    //   3443: iconst_m1
    //   3444: istore 10
    //   3446: iconst_m1
    //   3447: istore 11
    //   3449: iconst_1
    //   3450: istore 12
    //   3452: iconst_0
    //   3453: istore 13
    //   3455: iconst_m1
    //   3456: istore 14
    //   3458: iconst_1
    //   3459: istore 15
    //   3461: iconst_0
    //   3462: istore 16
    //   3464: iconst_0
    //   3465: istore 17
    //   3467: iconst_0
    //   3468: istore 18
    //   3470: iconst_0
    //   3471: istore 26
    //   3473: iconst_m1
    //   3474: istore_3
    //   3475: sipush 287
    //   3478: getstatic 164	com/tencent/av/utils/QAVConfigUtils:b	Ljava/lang/String;
    //   3481: invokestatic 166	com/tencent/av/utils/QAVConfigUtils:a	(ILjava/lang/String;)Landroid/content/SharedPreferences;
    //   3484: invokeinterface 225 1 0
    //   3489: astore 47
    //   3491: aload 47
    //   3493: ldc_w 383
    //   3496: iload_2
    //   3497: invokeinterface 242 3 0
    //   3502: pop
    //   3503: aload 47
    //   3505: ldc_w 284
    //   3508: lload 33
    //   3510: invokeinterface 387 4 0
    //   3515: pop
    //   3516: aload 47
    //   3518: ldc_w 288
    //   3521: iload 25
    //   3523: invokeinterface 391 3 0
    //   3528: pop
    //   3529: aload 47
    //   3531: ldc_w 293
    //   3534: iload_1
    //   3535: invokeinterface 242 3 0
    //   3540: pop
    //   3541: aload 47
    //   3543: ldc_w 295
    //   3546: iload 4
    //   3548: invokeinterface 242 3 0
    //   3553: pop
    //   3554: aload 47
    //   3556: ldc_w 297
    //   3559: iload 26
    //   3561: invokeinterface 391 3 0
    //   3566: pop
    //   3567: aload 47
    //   3569: ldc_w 299
    //   3572: aload 37
    //   3574: invokeinterface 237 3 0
    //   3579: pop
    //   3580: aload 47
    //   3582: ldc_w 305
    //   3585: iload_3
    //   3586: invokeinterface 242 3 0
    //   3591: pop
    //   3592: aload 47
    //   3594: ldc_w 307
    //   3597: iload 27
    //   3599: invokeinterface 391 3 0
    //   3604: pop
    //   3605: aload 47
    //   3607: ldc_w 309
    //   3610: iload 5
    //   3612: invokeinterface 242 3 0
    //   3617: pop
    //   3618: aload 47
    //   3620: ldc_w 311
    //   3623: iload 6
    //   3625: invokeinterface 242 3 0
    //   3630: pop
    //   3631: aload 47
    //   3633: ldc_w 315
    //   3636: iload 7
    //   3638: invokeinterface 242 3 0
    //   3643: pop
    //   3644: aload 47
    //   3646: ldc_w 319
    //   3649: iload 8
    //   3651: invokeinterface 242 3 0
    //   3656: pop
    //   3657: aload 47
    //   3659: ldc_w 323
    //   3662: iload 28
    //   3664: invokeinterface 391 3 0
    //   3669: pop
    //   3670: aload 47
    //   3672: ldc_w 330
    //   3675: iload 9
    //   3677: invokeinterface 242 3 0
    //   3682: pop
    //   3683: aload 47
    //   3685: ldc_w 332
    //   3688: aload 41
    //   3690: invokeinterface 237 3 0
    //   3695: pop
    //   3696: aload 47
    //   3698: ldc_w 334
    //   3701: aload 42
    //   3703: invokeinterface 237 3 0
    //   3708: pop
    //   3709: aload 47
    //   3711: ldc_w 343
    //   3714: aload 43
    //   3716: invokeinterface 237 3 0
    //   3721: pop
    //   3722: aload 47
    //   3724: ldc_w 345
    //   3727: aload 44
    //   3729: invokeinterface 237 3 0
    //   3734: pop
    //   3735: aload 47
    //   3737: ldc_w 347
    //   3740: iload 29
    //   3742: invokeinterface 391 3 0
    //   3747: pop
    //   3748: aload 47
    //   3750: ldc_w 351
    //   3753: aload 45
    //   3755: invokeinterface 237 3 0
    //   3760: pop
    //   3761: aload 47
    //   3763: ldc_w 353
    //   3766: aload 46
    //   3768: invokeinterface 237 3 0
    //   3773: pop
    //   3774: aload 47
    //   3776: ldc_w 355
    //   3779: iload 10
    //   3781: invokeinterface 242 3 0
    //   3786: pop
    //   3787: iload 11
    //   3789: iconst_m1
    //   3790: if_icmpeq +16 -> 3806
    //   3793: aload 47
    //   3795: ldc_w 357
    //   3798: iload 11
    //   3800: invokeinterface 242 3 0
    //   3805: pop
    //   3806: aload 47
    //   3808: ldc_w 359
    //   3811: iload 12
    //   3813: invokeinterface 242 3 0
    //   3818: pop
    //   3819: aload 47
    //   3821: ldc_w 367
    //   3824: iload 13
    //   3826: invokeinterface 242 3 0
    //   3831: pop
    //   3832: iload 14
    //   3834: iconst_m1
    //   3835: if_icmpeq +16 -> 3851
    //   3838: aload 47
    //   3840: ldc_w 371
    //   3843: iload 14
    //   3845: invokeinterface 242 3 0
    //   3850: pop
    //   3851: aload 38
    //   3853: invokevirtual 393	java/lang/String:isEmpty	()Z
    //   3856: ifne +15 -> 3871
    //   3859: aload 47
    //   3861: ldc 168
    //   3863: aload 38
    //   3865: invokeinterface 237 3 0
    //   3870: pop
    //   3871: aload 39
    //   3873: invokevirtual 393	java/lang/String:isEmpty	()Z
    //   3876: ifne +15 -> 3891
    //   3879: aload 47
    //   3881: ldc 185
    //   3883: aload 39
    //   3885: invokeinterface 237 3 0
    //   3890: pop
    //   3891: aload 40
    //   3893: invokevirtual 393	java/lang/String:isEmpty	()Z
    //   3896: ifne +15 -> 3911
    //   3899: aload 47
    //   3901: ldc 189
    //   3903: aload 40
    //   3905: invokeinterface 237 3 0
    //   3910: pop
    //   3911: iload 15
    //   3913: putstatic 395	com/tencent/av/utils/QAVConfigUtils:k	I
    //   3916: aload 47
    //   3918: ldc_w 373
    //   3921: iload 15
    //   3923: invokeinterface 242 3 0
    //   3928: pop
    //   3929: aload 47
    //   3931: ldc_w 375
    //   3934: iload 16
    //   3936: invokeinterface 242 3 0
    //   3941: pop
    //   3942: aload 47
    //   3944: ldc_w 377
    //   3947: iload 17
    //   3949: invokeinterface 242 3 0
    //   3954: pop
    //   3955: aload 47
    //   3957: ldc_w 379
    //   3960: iload 18
    //   3962: invokeinterface 242 3 0
    //   3967: pop
    //   3968: aload 47
    //   3970: invokeinterface 246 1 0
    //   3975: pop
    //   3976: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3979: ifeq +47 -> 4026
    //   3982: new 120	java/lang/StringBuilder
    //   3985: dup
    //   3986: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   3989: astore 37
    //   3991: aload 37
    //   3993: ldc_w 397
    //   3996: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3999: pop
    //   4000: aload 37
    //   4002: aload_0
    //   4003: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4006: pop
    //   4007: aload 37
    //   4009: ldc 204
    //   4011: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4014: pop
    //   4015: ldc 138
    //   4017: iconst_2
    //   4018: aload 37
    //   4020: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4023: invokestatic 147	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4026: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4027	0	paramString	String
    //   185	3350	1	i1	int
    //   49	3448	2	i2	int
    //   272	3314	3	i3	int
    //   124	3423	4	i4	int
    //   284	3327	5	i5	int
    //   334	3290	6	i6	int
    //   386	3251	7	i7	int
    //   425	3225	8	i8	int
    //   702	2974	9	i9	int
    //   724	3056	10	i10	int
    //   220	3579	11	i11	int
    //   322	3490	12	i12	int
    //   79	3746	13	i13	int
    //   135	3709	14	i14	int
    //   170	3752	15	i15	int
    //   174	3761	16	i16	int
    //   777	3171	17	i17	int
    //   906	3055	18	i18	int
    //   910	2428	19	i19	int
    //   895	2447	20	i20	int
    //   830	2520	21	i21	int
    //   916	2418	22	i22	int
    //   790	2556	23	i23	int
    //   989	2369	24	i24	int
    //   46	3476	25	bool1	boolean
    //   447	3113	26	bool2	boolean
    //   373	3225	27	bool3	boolean
    //   622	3041	28	bool4	boolean
    //   113	3628	29	bool5	boolean
    //   146	3152	30	bool6	boolean
    //   977	1963	31	bool7	boolean
    //   920	88	32	bool8	boolean
    //   53	3456	33	l1	long
    //   98	1259	35	l2	long
    //   13	2025	37	localObject1	Object
    //   2044	1	37	localException1	Exception
    //   2049	66	37	localException2	Exception
    //   2127	1	37	localObject2	Object
    //   2171	1	37	localException3	Exception
    //   2176	60	37	localException4	Exception
    //   2265	1754	37	localObject3	Object
    //   462	39	38	localObject4	Object
    //   511	1	38	localException5	Exception
    //   516	1	38	localException6	Exception
    //   525	1	38	localException7	Exception
    //   530	42	38	localException8	Exception
    //   599	1671	38	localObject5	Object
    //   2286	1	38	localException9	Exception
    //   2291	69	38	localException10	Exception
    //   2386	1478	38	localObject6	Object
    //   469	2306	39	localObject7	Object
    //   2805	1	39	localException11	Exception
    //   2814	91	39	localException12	Exception
    //   2953	931	39	localObject8	Object
    //   631	1041	40	localObject9	Object
    //   1727	1	40	localException13	Exception
    //   1751	1	40	localException14	Exception
    //   1772	1	40	localException15	Exception
    //   1789	1	40	localException16	Exception
    //   1798	70	40	localException17	Exception
    //   1891	2013	40	localObject10	Object
    //   520	1342	41	localObject11	Object
    //   1927	1	41	localException18	Exception
    //   1932	59	41	localException19	Exception
    //   2019	1670	41	localObject12	Object
    //   611	551	42	localObject13	Object
    //   1172	1	42	localException20	Exception
    //   1181	15	42	localException21	Exception
    //   1205	2497	42	localObject14	Object
    //   538	3177	43	localObject15	Object
    //   554	861	44	localObject16	Object
    //   1423	1	44	localException22	Exception
    //   1428	1	44	localException23	Exception
    //   1448	1	44	localException24	Exception
    //   1453	17	44	localException25	Exception
    //   1487	2241	44	localObject17	Object
    //   68	1063	45	localObject18	Object
    //   1139	1	45	localException26	Exception
    //   1151	1	45	localException27	Exception
    //   1197	7	45	localObject19	Object
    //   1214	1	45	localException28	Exception
    //   1237	35	45	localException29	Exception
    //   1280	186	45	localObject20	Object
    //   1476	1	45	localException30	Exception
    //   1527	54	45	localObject21	Object
    //   1587	1	45	localException31	Exception
    //   1611	1	45	localException32	Exception
    //   1624	1	45	localException33	Exception
    //   1629	45	45	localException34	Exception
    //   1695	2059	45	localObject22	Object
    //   233	2133	46	localObject23	Object
    //   2403	1	46	localException35	Exception
    //   2418	1	46	localException36	Exception
    //   2426	1	46	localException37	Exception
    //   2529	1	46	localException38	Exception
    //   2534	1	46	localException39	Exception
    //   2648	93	46	localException40	Exception
    //   2800	967	46	localObject24	Object
    //   159	898	47	localObject25	Object
    //   1111	1	47	localException41	Exception
    //   1155	1776	47	localObject26	Object
    //   2974	1	47	localException42	Exception
    //   2979	1	47	localException43	Exception
    //   3024	139	47	localException44	Exception
    //   3250	719	47	localObject27	Object
    //   558	2760	48	localObject28	Object
    //   562	2760	49	localObject29	Object
    //   566	2760	50	localObject30	Object
    //   938	2392	51	localObject31	Object
    //   1471	1	52	localException45	Exception
    //   1512	1	52	localException46	Exception
    //   1911	1391	52	localObject32	Object
    //   2742	187	53	localException47	Exception
    // Exception table:
    //   from	to	target	type
    //   480	508	511	java/lang/Exception
    //   471	480	516	java/lang/Exception
    //   464	471	525	java/lang/Exception
    //   454	464	530	java/lang/Exception
    //   897	908	1111	java/lang/Exception
    //   886	897	1139	java/lang/Exception
    //   875	886	1151	java/lang/Exception
    //   864	875	1172	java/lang/Exception
    //   853	864	1181	java/lang/Exception
    //   842	853	1214	java/lang/Exception
    //   832	842	1237	java/lang/Exception
    //   792	832	1423	java/lang/Exception
    //   779	788	1428	java/lang/Exception
    //   739	779	1448	java/lang/Exception
    //   726	735	1453	java/lang/Exception
    //   715	726	1476	java/lang/Exception
    //   704	715	1512	java/lang/Exception
    //   693	704	1587	java/lang/Exception
    //   677	689	1611	java/lang/Exception
    //   637	677	1624	java/lang/Exception
    //   624	633	1629	java/lang/Exception
    //   613	624	1727	java/lang/Exception
    //   601	613	1751	java/lang/Exception
    //   589	601	1772	java/lang/Exception
    //   439	449	1789	java/lang/Exception
    //   427	439	1798	java/lang/Exception
    //   388	427	1927	java/lang/Exception
    //   375	384	1932	java/lang/Exception
    //   336	375	2044	java/lang/Exception
    //   324	333	2049	java/lang/Exception
    //   286	324	2171	java/lang/Exception
    //   273	282	2176	java/lang/Exception
    //   235	273	2286	java/lang/Exception
    //   222	231	2291	java/lang/Exception
    //   211	222	2403	java/lang/Exception
    //   200	211	2418	java/lang/Exception
    //   176	186	2426	java/lang/Exception
    //   161	172	2529	java/lang/Exception
    //   148	161	2534	java/lang/Exception
    //   137	148	2648	java/lang/Exception
    //   126	137	2805	java/lang/Exception
    //   115	126	2814	java/lang/Exception
    //   104	115	2974	java/lang/Exception
    //   81	100	2979	java/lang/Exception
    //   60	81	3024	java/lang/Exception
  }
  
  public static boolean a()
  {
    int i1 = c;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (-1 != i1)
    {
      if (i1 == 1) {
        bool1 = true;
      }
      return bool1;
    }
    try
    {
      if (-1 != c)
      {
        bool1 = bool2;
        if (c == 1) {
          bool1 = true;
        }
        return bool1;
      }
      SharedPreferences localSharedPreferences = a(287, b);
      c = localSharedPreferences.getInt("isBlueToothSwitch", 1);
      d = localSharedPreferences.getLong("bluetoothDelayTime", 1000L);
      bool1 = bool3;
      if (c == 1) {
        bool1 = true;
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean a(long paramLong)
  {
    int i1 = a(287, b).getInt("useAADSDeJitterAlgorithmUin", -1);
    boolean bool = false;
    if ((i1 > -1) && (paramLong % 10L <= i1)) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JTest. read useAADSDeJitterAlgorithmUin = ");
    localStringBuilder.append(i1);
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
    if (f == -1)
    {
      f = a(287, b).getInt("multiVideoSupportNumbers", -1);
      if (f == -1) {
        f = 5;
      }
      return f;
    }
    return f;
  }
  
  public static String b(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getString(u, null);
  }
  
  public static String b(@NonNull String paramString)
  {
    return a(287, b).getString(paramString, "");
  }
  
  public static void b(int paramInt)
  {
    JSONArray localJSONArray = w();
    if (localJSONArray == null) {
      return;
    }
    try
    {
      new QAVConfigUtils.MoreBtnTips().c = 2147483647;
      int i1 = 0;
      Object localObject;
      while (i1 < localJSONArray.length())
      {
        localObject = localJSONArray.getJSONObject(i1);
        if (((JSONObject)localObject).getInt("id") == paramInt)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MoreBtnTips. removeMoreBtnTips. id = ");
          localStringBuilder.append(paramInt);
          QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
          if (Build.VERSION.SDK_INT >= 19) {
            localJSONArray.remove(i1);
          } else {
            ((JSONObject)localObject).put("priority", 2147483647);
          }
          localObject = a(287, b).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("MoreBtnTips. removeMoreBtnTips. saved moreBtnTipsJson = ");
          localStringBuilder.append(localJSONArray.toString());
          QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
          ((SharedPreferences.Editor)localObject).putString("moreBtnTips", localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
        i1 += 1;
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
  
  public static boolean b(long paramLong)
  {
    int i1 = a(287, b).getInt("enableAADSDeJitterMaxJDelayUin", -1);
    boolean bool = false;
    if ((i1 > -1) && (paramLong % 10L <= i1)) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JTest. read enableAADSDeJitterMaxJDelayUin = ");
    localStringBuilder.append(i1);
    localStringBuilder.append(", enableAADSDeJitterMaxJDelay = ");
    localStringBuilder.append(bool);
    QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static int c(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getInt(a, 0);
  }
  
  public static boolean c()
  {
    int i1 = g;
    boolean bool = false;
    if (i1 == -1) {
      g = a(287, b).getInt("SpeedDialScreenStyle", 0);
    }
    if (g == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static String d(int paramInt, String paramString)
  {
    if ((AudioHelperUtil.c()) && (TextUtils.isEmpty(paramString)))
    {
      paramString = new StringBuilder();
      paramString.append("getConfigSPName uin不能为空, configId:");
      paramString.append(paramInt);
      throw new IllegalArgumentException(paramString.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(t);
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean d()
  {
    int i1 = h;
    boolean bool = false;
    if (i1 == -1) {
      h = a(287, b).getInt("allowMicLongPressSpeakInMute", 0);
    }
    if (h == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e()
  {
    if (i == null)
    {
      SharedPreferences localSharedPreferences = a(287, b);
      int i1 = Build.VERSION.SDK_INT;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (i1 >= 19)
      {
        bool1 = bool2;
        if (localSharedPreferences.getBoolean("isSharpnessSwitch", false)) {
          bool1 = true;
        }
      }
      i = Boolean.valueOf(bool1);
    }
    return i.booleanValue();
  }
  
  public static int f()
  {
    if (j == -1) {
      j = a(287, b).getInt("sharpnessFPSThreshold", 7);
    }
    return j * 10;
  }
  
  public static boolean g()
  {
    if (k == -1) {
      k = a(287, b).getInt("davBubbleSwitch", 1);
    }
    return k == 0;
  }
  
  public static int h()
  {
    if (l == -1) {
      l = a(287, b).getInt("880UIABTestOption", 0);
    }
    return l;
  }
  
  public static int i()
  {
    if (m == -1) {
      m = a(287, b).getInt("880EffectUIABTestOption", 0);
    }
    return m;
  }
  
  public static int j()
  {
    if (n == -1) {
      n = a(287, b).getInt("883Avatar2dEntranceABTestOption", 0);
    }
    return n;
  }
  
  public static boolean k()
  {
    v();
    return o.booleanValue();
  }
  
  public static String l()
  {
    v();
    return p;
  }
  
  public static boolean m()
  {
    int i1 = q;
    boolean bool = false;
    if (i1 == -1) {
      q = a(287, b).getInt("useRGB2I420Shader", 0);
    }
    if (q == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean n()
  {
    int i1 = r;
    boolean bool = false;
    if (i1 == -1)
    {
      r = a(287, b).getInt("videoTrackSoundSeparation", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read videoTrackSoundSeparation = ");
      localStringBuilder.append(r);
      QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    }
    if (r == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean o()
  {
    Object localObject = a(287, b);
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavUseOpenSLESInterface.name(), "1");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (((SharedPreferences)localObject).getBoolean("useOpenSLESInterface", false))
    {
      bool1 = bool2;
      if ("1".equalsIgnoreCase(str)) {
        bool1 = true;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("useOpenSLESInterface = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", DPC_USE_OPENSLES_API = ");
    ((StringBuilder)localObject).append("1".equalsIgnoreCase(str));
    QLog.i("QAVConfigUtils", 1, ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  public static boolean p()
  {
    int i1 = s;
    boolean bool = false;
    if (i1 == -1) {
      s = a(287, b).getInt("upLoadWhenGetNewData", 0);
    }
    if (s == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean q()
  {
    boolean bool = a(287, b).getBoolean("isAllowedControlMicAfterBeMuted", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JTest. read isAllowedControlMicAfterBeMuted = ");
    localStringBuilder.append(bool);
    QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean r()
  {
    if (v == null)
    {
      v = Integer.valueOf(a(287, b).getInt("qavWatchTogetherSwitch", 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQavWatchTogetherOpen, switch[");
      localStringBuilder.append(v);
      localStringBuilder.append("]");
      QLog.i("WTogether", 1, localStringBuilder.toString());
    }
    return v.intValue() != 0;
  }
  
  public static boolean s()
  {
    if (w == null)
    {
      w = Integer.valueOf(a(287, b).getInt("ScreenShareSwitch", 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQavScreenShareOpen, switch[");
      localStringBuilder.append(w);
      localStringBuilder.append("]");
      QLog.i("WTogether", 1, localStringBuilder.toString());
    }
    return w.intValue() != 0;
  }
  
  public static boolean t()
  {
    if (x == null)
    {
      x = Integer.valueOf(a(287, b).getInt("AskScreenShareSwitch", 1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isQavScreenShareOpen, switch[");
      localStringBuilder.append(x);
      localStringBuilder.append("]");
      QLog.i("WTogether", 1, localStringBuilder.toString());
    }
    return x.intValue() != 0;
  }
  
  public static boolean u()
  {
    if (y == null)
    {
      y = Integer.valueOf(a(287, b).getInt("avGameResultUseWebSwitch", 0));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAVGameResultWebOpen, switch[");
      localStringBuilder.append(y);
      localStringBuilder.append("]");
      QLog.i("QAVConfigUtils", 1, localStringBuilder.toString());
    }
    return y.intValue() != 0;
  }
  
  private static void v()
  {
    if ((o == null) || (TextUtils.isEmpty(p)))
    {
      Object localObject = a(287, b);
      o = Boolean.valueOf(((SharedPreferences)localObject).getBoolean("switchMultiForceUseGroup", false));
      p = ((SharedPreferences)localObject).getString("switchMultiForceUseGroupAlertTip", "对方版本过低，请先创建群聊后邀请");
      if (TextUtils.isEmpty(p)) {
        p = "对方版本过低，请先创建群聊后邀请";
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initDouble2GroupConfig [");
        ((StringBuilder)localObject).append(o);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(p);
        ((StringBuilder)localObject).append("]");
        QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static JSONArray w()
  {
    Object localObject = a(287, b).getString("moreBtnTips", "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVConfigUtils
 * JD-Core Version:    0.7.0.1
 */
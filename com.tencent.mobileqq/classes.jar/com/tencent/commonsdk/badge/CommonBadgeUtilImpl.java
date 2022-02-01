package com.tencent.commonsdk.badge;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class CommonBadgeUtilImpl
{
  public static final String ACTION_APPLICATION_MESSAGE_QUERY = "android.intent.action.APPLICATION_MESSAGE_QUERY";
  public static final String ACTION_APPLICATION_MESSAGE_UPDATE = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
  public static final String ACTION_QQLAUNCHER_BADGE_UPDATE = "com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT";
  public static final String EXTRA_UPDATE_APPLICATION_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
  public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT = "android.intent.extra.update_application_message_text";
  public static final String LENOVO_PACKAGE_NAME = "com.lenovo.launcher";
  public static final String MANUFACTURER_OF_HARDWARE_HONOR = "HONOR";
  public static final String MANUFACTURER_OF_HARDWARE_HUAWEI = "huawei";
  public static final String MANUFACTURER_OF_HARDWARE_LENOVO = "lenovo";
  public static final String MANUFACTURER_OF_HARDWARE_NUBIA = "nubia";
  public static final String MANUFACTURER_OF_HARDWARE_ONEPLUS = "OnePlus";
  public static final String MANUFACTURER_OF_HARDWARE_OPPO = "OPPO";
  public static final String MANUFACTURER_OF_HARDWARE_OPPO_REALME = "Realme";
  public static final String MANUFACTURER_OF_HARDWARE_SANXING = "samsung";
  public static final String MANUFACTURER_OF_HARDWARE_SONY = "Sony Ericsson";
  public static final String MANUFACTURER_OF_HARDWARE_VIVO = "vivo";
  public static final String MANUFACTURER_OF_HARDWARE_XIAOMI = "Xiaomi";
  public static final String MANUFACTURER_OF_HARDWARE_ZUK = "ZUK";
  public static final String MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE = "content://com.lenovo.launcher.badge/lenovo_badges";
  public static int NOTIFICATION_ID_NOTIFYID = 110234;
  private static final String OPPO_QQ_BADGE_NUMBER = "com.tencent.mobileqq.badge";
  public static final String TAG = "CommonBadgeUtilImpl";
  public static int haslenovoLanucher;
  private static Boolean haveprovider;
  public static String mLauncherClassName;
  public static int mLimitCount;
  private static int miui6Flag = 0;
  public static PackageManager packmag;
  private static int sBadgeAbility;
  private static Context sContext;
  public static String[] sQQLuancherPackageNames = { "com.tencent.qlauncher.lite", "com.tencent.qlauncher", "com.tencent.qqlauncher", "com.tencent.launcher" };
  
  static
  {
    mLauncherClassName = "";
    haslenovoLanucher = -1;
    mLimitCount = -1;
    sBadgeAbility = 0;
  }
  
  public static void changeLenovoBadge(Context paramContext, int paramInt)
  {
    int j = mLimitCount;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putStringArrayList("app_shortcut_custom_id", null);
        localBundle.putInt("app_badge_count", i);
        if (paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle) != null)
        {
          bool = true;
          paramContext = new StringBuilder();
          paramContext.append("changeLenovoBadge count=");
          paramContext.append(i);
          paramContext.append("result=");
          paramContext.append(bool);
          QLog.i("CommonBadgeUtilImpl", 1, paramContext.toString());
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("CommonBadgeUtilImpl", 1, paramContext, new Object[0]);
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void changeMI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    int i = mLimitCount;
    if (paramInt > i) {
      paramInt = i;
    }
    try
    {
      paramContext = Class.forName("android.app.MiuiNotification").newInstance();
      Field localField = paramContext.getClass().getDeclaredField("messageCount");
      localField.setAccessible(true);
      localField.set(paramContext, Integer.valueOf(paramInt));
      paramNotification.getClass().getField("extraNotification").set(paramNotification, paramContext);
      return;
    }
    catch (InstantiationException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void changeMIBadge(Context paramContext, int paramInt)
  {
    if (isMIUI6()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    localIntent.putExtra("android.intent.extra.update_application_component_name", "com.tencent.mobileqq/.activity.SplashActivity");
    Object localObject = "";
    if (paramInt > 0) {
      if (paramInt > mLimitCount)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(mLimitCount);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    localIntent.putExtra("android.intent.extra.update_application_message_text", (String)localObject);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void changeNubiaBadge(Context paramContext, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("app_badge_count", paramInt);
    try
    {
      paramContext.getContentResolver().call(Uri.parse("content://cn.nubia.launcher.unreadMark"), "setAppBadgeCount", null, localBundle);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void changeOPPOBadge(Context paramContext, int paramInt)
  {
    int j = mLimitCount;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_badge_count", i);
      paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void changeOnePlusBadge(Context paramContext, int paramInt)
  {
    paramInt = Math.min(paramInt, mLimitCount);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_badge_count", paramInt);
      paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
      paramContext = new StringBuilder();
      paramContext.append("changeOnePlusBadge count=");
      paramContext.append(paramInt);
      QLog.i("CommonBadgeUtilImpl", 1, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("CommonBadgeUtilImpl", 1, "Write unread number FAILED!!! e = ", paramContext);
    }
  }
  
  public static void changeVivoBadge(Context paramContext, int paramInt)
  {
    int j = mLimitCount;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    String str = getLauncherClassName(paramContext);
    if (str == null) {
      return;
    }
    Intent localIntent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.putExtra("className", str);
    localIntent.putExtra("notificationNum", i);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void changeZUKBadge(Context paramContext, int paramInt)
  {
    int j = mLimitCount;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putStringArrayList("app_shortcut_custom_id", null);
        localBundle.putInt("app_badge_count", i);
        if (paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle) != null)
        {
          bool = true;
          paramContext = new StringBuilder();
          paramContext.append("changeZUKBadge mcount=");
          paramContext.append(i);
          paramContext.append("result=");
          paramContext.append(bool);
          Log.d("CommonBadgeUtilImpl", paramContext.toString());
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public static String getLauncherClassName(Context paramContext)
  {
    if (!TextUtils.isEmpty(mLauncherClassName)) {
      return mLauncherClassName;
    }
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    try
    {
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName.equalsIgnoreCase(paramContext.getPackageName()))
        {
          paramContext = ((ResolveInfo)localObject2).activityInfo.name;
          mLauncherClassName = paramContext;
          return paramContext;
        }
      }
      return null;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  public static boolean isMIUI6()
  {
    // Byte code:
    //   0: getstatic 110	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   3: istore_1
    //   4: iconst_0
    //   5: istore_2
    //   6: iconst_0
    //   7: istore_0
    //   8: iload_1
    //   9: ifne +379 -> 388
    //   12: iconst_m1
    //   13: putstatic 110	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   16: ldc 100
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 5
    //   22: aconst_null
    //   23: astore 7
    //   25: aconst_null
    //   26: astore 6
    //   28: new 384	java/io/BufferedReader
    //   31: dup
    //   32: new 386	java/io/InputStreamReader
    //   35: dup
    //   36: new 388	java/lang/ProcessBuilder
    //   39: dup
    //   40: iconst_2
    //   41: anewarray 88	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: ldc_w 390
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: ldc_w 392
    //   55: aastore
    //   56: invokespecial 395	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   59: invokevirtual 399	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   62: invokevirtual 405	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   65: invokespecial 408	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: sipush 1024
    //   71: invokespecial 411	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   74: astore 4
    //   76: aload_3
    //   77: astore 5
    //   79: aload_3
    //   80: astore 6
    //   82: aload 4
    //   84: invokevirtual 414	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   87: astore 7
    //   89: aload 7
    //   91: astore 5
    //   93: aload 7
    //   95: astore 6
    //   97: aload 7
    //   99: astore_3
    //   100: aload 4
    //   102: invokevirtual 417	java/io/BufferedReader:close	()V
    //   105: aload 4
    //   107: invokevirtual 417	java/io/BufferedReader:close	()V
    //   110: aload 7
    //   112: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +273 -> 388
    //   118: aload 7
    //   120: invokestatic 421	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   123: istore_0
    //   124: goto +10 -> 134
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 422	java/lang/NumberFormatException:printStackTrace	()V
    //   132: iconst_0
    //   133: istore_0
    //   134: iload_0
    //   135: iconst_3
    //   136: if_icmple +252 -> 388
    //   139: new 157	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   146: astore_3
    //   147: aload_3
    //   148: ldc_w 424
    //   151: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: iload_0
    //   157: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc_w 426
    //   164: aload_3
    //   165: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 316	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: iconst_1
    //   173: putstatic 110	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   176: goto +212 -> 388
    //   179: astore_3
    //   180: aload 4
    //   182: astore 6
    //   184: aload_3
    //   185: astore 4
    //   187: goto +17 -> 204
    //   190: goto +96 -> 286
    //   193: aload 6
    //   195: astore_3
    //   196: goto +141 -> 337
    //   199: astore 4
    //   201: aload_3
    //   202: astore 5
    //   204: aload 6
    //   206: ifnull +11 -> 217
    //   209: aload 6
    //   211: invokevirtual 417	java/io/BufferedReader:close	()V
    //   214: goto +3 -> 217
    //   217: aload 5
    //   219: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +61 -> 283
    //   225: aload 5
    //   227: invokestatic 421	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_1
    //   231: iload_1
    //   232: istore_0
    //   233: goto +8 -> 241
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 422	java/lang/NumberFormatException:printStackTrace	()V
    //   241: iload_0
    //   242: iconst_3
    //   243: if_icmple +40 -> 283
    //   246: new 157	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   253: astore_3
    //   254: aload_3
    //   255: ldc_w 424
    //   258: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_3
    //   263: iload_0
    //   264: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: ldc_w 426
    //   271: aload_3
    //   272: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 316	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   278: pop
    //   279: iconst_1
    //   280: putstatic 110	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   283: aload 4
    //   285: athrow
    //   286: aload 4
    //   288: ifnull +11 -> 299
    //   291: aload 4
    //   293: invokevirtual 417	java/io/BufferedReader:close	()V
    //   296: goto +3 -> 299
    //   299: aload_3
    //   300: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifne +85 -> 388
    //   306: aload_3
    //   307: invokestatic 421	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   310: istore_0
    //   311: goto +10 -> 321
    //   314: astore_3
    //   315: aload_3
    //   316: invokevirtual 422	java/lang/NumberFormatException:printStackTrace	()V
    //   319: iconst_0
    //   320: istore_0
    //   321: iload_0
    //   322: iconst_3
    //   323: if_icmple +65 -> 388
    //   326: new 157	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   333: astore_3
    //   334: goto -187 -> 147
    //   337: aload 4
    //   339: ifnull +11 -> 350
    //   342: aload 4
    //   344: invokevirtual 417	java/io/BufferedReader:close	()V
    //   347: goto +3 -> 350
    //   350: aload_3
    //   351: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +34 -> 388
    //   357: aload_3
    //   358: invokestatic 421	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   361: istore_0
    //   362: goto +10 -> 372
    //   365: astore_3
    //   366: aload_3
    //   367: invokevirtual 422	java/lang/NumberFormatException:printStackTrace	()V
    //   370: iconst_0
    //   371: istore_0
    //   372: iload_0
    //   373: iconst_3
    //   374: if_icmple +14 -> 388
    //   377: new 157	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   384: astore_3
    //   385: goto -238 -> 147
    //   388: getstatic 110	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   391: iconst_1
    //   392: if_icmpne +5 -> 397
    //   395: iconst_1
    //   396: istore_2
    //   397: iload_2
    //   398: ireturn
    //   399: astore 4
    //   401: aload 7
    //   403: astore 4
    //   405: goto -68 -> 337
    //   408: astore 4
    //   410: aload 5
    //   412: astore 4
    //   414: goto -128 -> 286
    //   417: astore_3
    //   418: goto -225 -> 193
    //   421: astore 5
    //   423: goto -233 -> 190
    //   426: astore_3
    //   427: goto -317 -> 110
    //   430: astore_3
    //   431: goto -214 -> 217
    //   434: astore 4
    //   436: goto -137 -> 299
    //   439: astore 4
    //   441: goto -91 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	368	0	i	int
    //   3	229	1	j	int
    //   5	393	2	bool	boolean
    //   18	82	3	localObject1	Object
    //   127	2	3	localNumberFormatException1	java.lang.NumberFormatException
    //   146	19	3	localStringBuilder1	StringBuilder
    //   179	6	3	localObject2	Object
    //   195	7	3	localObject3	Object
    //   236	2	3	localNumberFormatException2	java.lang.NumberFormatException
    //   253	54	3	localStringBuilder2	StringBuilder
    //   314	2	3	localNumberFormatException3	java.lang.NumberFormatException
    //   333	25	3	localStringBuilder3	StringBuilder
    //   365	2	3	localNumberFormatException4	java.lang.NumberFormatException
    //   384	1	3	localStringBuilder4	StringBuilder
    //   417	1	3	localIOException1	java.io.IOException
    //   426	1	3	localIOException2	java.io.IOException
    //   430	1	3	localIOException3	java.io.IOException
    //   74	112	4	localObject4	Object
    //   199	144	4	localObject5	Object
    //   399	1	4	localIOException4	java.io.IOException
    //   403	1	4	str1	String
    //   408	1	4	localException1	Exception
    //   412	1	4	localObject6	Object
    //   434	1	4	localIOException5	java.io.IOException
    //   439	1	4	localIOException6	java.io.IOException
    //   20	391	5	localObject7	Object
    //   421	1	5	localException2	Exception
    //   26	184	6	localObject8	Object
    //   23	379	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   118	124	127	java/lang/NumberFormatException
    //   82	89	179	finally
    //   100	105	179	finally
    //   28	76	199	finally
    //   225	231	236	java/lang/NumberFormatException
    //   306	311	314	java/lang/NumberFormatException
    //   357	362	365	java/lang/NumberFormatException
    //   28	76	399	java/io/IOException
    //   28	76	408	java/lang/Exception
    //   82	89	417	java/io/IOException
    //   100	105	417	java/io/IOException
    //   82	89	421	java/lang/Exception
    //   100	105	421	java/lang/Exception
    //   105	110	426	java/io/IOException
    //   209	214	430	java/io/IOException
    //   291	296	434	java/io/IOException
    //   342	347	439	java/io/IOException
  }
  
  public static boolean isQQLanucher()
  {
    if (packmag == null) {
      packmag = sContext.getPackageManager();
    }
    int i = 0;
    for (;;)
    {
      Object localObject = sQQLuancherPackageNames;
      if (i >= localObject.length) {
        break;
      }
      try
      {
        localObject = packmag.getPackageInfo(localObject[i], 0);
        if (localObject != null) {
          return true;
        }
      }
      catch (Exception localException)
      {
        label44:
        break label44;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isSupportBadge(Context paramContext)
  {
    if (sContext == null) {
      sContext = paramContext;
    }
    int j = sBadgeAbility;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 1;
    if (j != 0)
    {
      if (j == 1) {
        bool1 = true;
      }
      return bool1;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {}
    do
    {
      do
      {
        bool1 = true;
        break;
      } while ((islenovoLanucher("com.lenovo.launcher")) || (isQQLanucher()) || (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (Build.MANUFACTURER.equalsIgnoreCase("samsung")) || (Build.MANUFACTURER.equalsIgnoreCase("huawei")) || (Build.MANUFACTURER.equalsIgnoreCase("HONOR")) || (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) || (Build.MANUFACTURER.equalsIgnoreCase("Realme")) || (Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MANUFACTURER.equalsIgnoreCase("nubia")) || (Build.MANUFACTURER.equalsIgnoreCase("lenovo")));
      bool1 = bool2;
    } while (Build.MANUFACTURER.equalsIgnoreCase("OnePlus"));
    BadgeController.init(sContext);
    if (BadgeController.isSupport(sContext)) {
      bool1 = true;
    }
    if (!bool1) {
      i = 2;
    }
    sBadgeAbility = i;
    return bool1;
  }
  
  public static boolean islenovoLanucher(String paramString)
  {
    if (Build.VERSION.SDK_INT < 15) {
      return false;
    }
    int i = haslenovoLanucher;
    if (i != -1) {
      return i == 1;
    }
    try
    {
      if ((packmag == null) && (sContext != null)) {
        packmag = sContext.getPackageManager();
      }
      if (Float.valueOf(Float.parseFloat(packmag.getPackageInfo(paramString, 0).versionName.substring(0, 3))).floatValue() >= 6.7F)
      {
        haslenovoLanucher = 1;
        return true;
      }
      haslenovoLanucher = 0;
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      break label99;
    }
    catch (Exception paramString)
    {
      label93:
      label99:
      break label93;
    }
    haslenovoLanucher = 0;
    return false;
    haslenovoLanucher = 0;
    return false;
  }
  
  public static void setBadge(Context paramContext, int paramInt)
  {
    setBadge(paramContext, paramInt, false);
  }
  
  public static void setBadge(Context paramContext, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBadge count=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|forceSet=");
    localStringBuilder.append(paramBoolean);
    Log.d("CommonBadgeUtilImpl", localStringBuilder.toString());
    if (isQQLanucher()) {
      setQQLauncherBadges(paramContext, paramInt);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {
      changeZUKBadge(paramContext, paramInt);
    }
    if (islenovoLanucher("com.lenovo.launcher")) {
      setLenovoBadge(paramContext, paramInt);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("lenovo")) {
      changeLenovoBadge(paramContext, paramInt);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
    {
      changeMIBadge(paramContext, paramInt);
      return;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
    {
      setSamsungBadge(paramContext, paramInt);
      return;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
    {
      setHuaweiBadge(paramContext, paramInt);
      return;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("HONOR"))
    {
      setHuaweiBadge(paramContext, paramInt);
      return;
    }
    if ((!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (!Build.MANUFACTURER.equalsIgnoreCase("Realme")))
    {
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        changeVivoBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("nubia"))
      {
        changeNubiaBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("OnePlus")) {
        changeOnePlusBadge(paramContext, paramInt);
      }
    }
    else
    {
      changeOPPOBadge(paramContext, paramInt);
    }
  }
  
  public static void setHuaweiBadge(Context paramContext, int paramInt)
  {
    try
    {
      String str = getLauncherClassName(paramContext);
      if (str == null) {
        return;
      }
      int i = paramInt;
      if (paramInt > mLimitCount) {
        i = mLimitCount;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("package", paramContext.getPackageName());
      localBundle.putString("class", str);
      localBundle.putInt("badgenumber", i);
      paramContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void setLenovoBadge(Context paramContext, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    Object localObject3 = getLauncherClassName(paramContext);
    if (localObject3 == null) {
      return;
    }
    Object localObject2 = null;
    Cursor localCursor1 = null;
    Cursor localCursor2 = localCursor1;
    Object localObject1 = localObject2;
    try
    {
      try
      {
        localContentValues.put("package", paramContext.getPackageName());
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        localContentValues.put("class", (String)localObject3);
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        localContentValues.put("badgecount", Integer.valueOf(paramInt));
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        localContentValues.put("extraData", "");
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        localObject3 = paramContext.getContentResolver();
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        Uri localUri = Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges");
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        String str = paramContext.getPackageName();
        localCursor2 = localCursor1;
        localObject1 = localObject2;
        localCursor1 = ((ContentResolver)localObject3).query(localUri, new String[] { "package", "class", "badgecount", "extraData" }, "package=?", new String[] { str }, null);
        if (localCursor1 != null)
        {
          localCursor2 = localCursor1;
          localObject1 = localCursor1;
          if (localCursor1.getCount() > 0)
          {
            localCursor2 = localCursor1;
            localObject1 = localCursor1;
            if (localCursor1.moveToFirst())
            {
              localCursor2 = localCursor1;
              localObject1 = localCursor1;
              paramContext.getContentResolver().update(Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges"), localContentValues, "package=?", new String[] { paramContext.getPackageName() });
            }
            if (localCursor1 != null) {
              localCursor1.close();
            }
            return;
          }
        }
        localCursor2 = localCursor1;
        localObject1 = localCursor1;
        Log.d("lenovo", "setLenovoBadge cur=null");
        localCursor2 = localCursor1;
        localObject1 = localCursor1;
        paramContext.getContentResolver().insert(Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges"), localContentValues);
        if (localCursor1 == null) {
          break label337;
        }
        localObject1 = localCursor1;
      }
      finally {}
    }
    catch (Throwable paramContext)
    {
      label310:
      break label310;
    }
    if (localCursor2 != null) {
      localCursor2.close();
    }
    throw paramContext;
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    label337:
  }
  
  public static void setLimitCount(int paramInt)
  {
    mLimitCount = paramInt;
  }
  
  public static void setMIUI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (isMIUI6())) {
      changeMI6Badge(paramContext, paramInt, paramNotification);
    }
  }
  
  public static void setQQLauncherBadges(Context paramContext, int paramInt)
  {
    int i = mLimitCount;
    if (paramInt <= i)
    {
      i = paramInt;
      if (paramInt < 1) {
        i = 0;
      }
    }
    Intent localIntent = new Intent("com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT");
    localIntent.putExtra("webappId", "20634");
    localIntent.putExtra("info_tips", String.valueOf(i));
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void setSamsungBadge(Context paramContext, int paramInt)
  {
    String str = null;
    Intent localIntent = null;
    Object localObject1 = null;
    Object localObject3 = str;
    Object localObject2 = localIntent;
    try
    {
      try
      {
        if (haveprovider == null)
        {
          localObject3 = str;
          localObject2 = localIntent;
          localObject1 = Uri.parse("content://com.sec.badge/apps");
          localObject3 = str;
          localObject2 = localIntent;
          localObject1 = paramContext.getContentResolver().query((Uri)localObject1, null, null, null, null);
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            localObject2 = localObject1;
            haveprovider = Boolean.valueOf(false);
            return;
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          haveprovider = Boolean.valueOf(true);
        }
        localObject3 = localObject1;
        localObject2 = localObject1;
        if (haveprovider.booleanValue())
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          str = getLauncherClassName(paramContext);
          if (str == null) {
            return;
          }
          int i = paramInt;
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (paramInt > mLimitCount)
          {
            localObject3 = localObject1;
            localObject2 = localObject1;
            i = mLimitCount;
          }
          localObject3 = localObject1;
          localObject2 = localObject1;
          localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
          localObject3 = localObject1;
          localObject2 = localObject1;
          localIntent.putExtra("badge_count", i);
          localObject3 = localObject1;
          localObject2 = localObject1;
          localIntent.putExtra("badge_count_package_name", paramContext.getPackageName());
          localObject3 = localObject1;
          localObject2 = localObject1;
          localIntent.putExtra("badge_count_class_name", str);
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramContext.sendBroadcast(localIntent);
        }
        if (localObject1 == null) {
          break label285;
        }
      }
      finally
      {
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
      }
    }
    catch (Throwable paramContext)
    {
      label271:
      label285:
      break label271;
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      ((Cursor)localObject1).close();
    }
  }
  
  public static void setSonyBadge(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    String str = getLauncherClassName(paramContext);
    if (str == null) {
      return;
    }
    Object localObject = "";
    if (paramInt < 1)
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
    }
    else
    {
      if (paramInt > mLimitCount)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(mLimitCount);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
    }
    localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
    localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", str);
    localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", (String)localObject);
    localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.badge.CommonBadgeUtilImpl
 * JD-Core Version:    0.7.0.1
 */
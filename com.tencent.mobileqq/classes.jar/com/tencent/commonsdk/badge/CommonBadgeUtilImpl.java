package com.tencent.commonsdk.badge;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
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
  public static final String MANUFACTURER_OF_HARDWARE_HUAWEI = "huawei";
  public static final String MANUFACTURER_OF_HARDWARE_LENOVO = "lenovo";
  public static final String MANUFACTURER_OF_HARDWARE_NUBIA = "nubia";
  public static final String MANUFACTURER_OF_HARDWARE_OPPO = "OPPO";
  public static final String MANUFACTURER_OF_HARDWARE_OPPO_REALME = "Realme";
  public static final String MANUFACTURER_OF_HARDWARE_SANXING = "samsung";
  public static final String MANUFACTURER_OF_HARDWARE_SONY = "Sony Ericsson";
  public static final String MANUFACTURER_OF_HARDWARE_VIVO = "vivo";
  public static final String MANUFACTURER_OF_HARDWARE_XIAOMI = "Xiaomi";
  public static final String MANUFACTURER_OF_HARDWARE_ZUK = "ZUK";
  public static final String MANUFACTURER_OF_LENOVO_LAUNCHER_BADGE = "content://com.lenovo.launcher.badge/lenovo_badges";
  public static int NOTIFICATION_ID_NOTIFYID = 0;
  private static final String OPPO_QQ_BADGE_NUMBER = "com.tencent.mobileqq.badge";
  public static final String TAG = "CommonBadgeUtilImpl";
  public static int haslenovoLanucher;
  private static Boolean haveprovider = null;
  public static String mLauncherClassName;
  public static int mLimitCount;
  private static int miui6Flag = 0;
  public static PackageManager packmag;
  private static int sBadgeAbility;
  private static Context sContext;
  public static String[] sQQLuancherPackageNames;
  
  static
  {
    NOTIFICATION_ID_NOTIFYID = 110234;
    sQQLuancherPackageNames = new String[] { "com.tencent.qlauncher.lite", "com.tencent.qlauncher", "com.tencent.qqlauncher", "com.tencent.launcher" };
    mLauncherClassName = "";
    haslenovoLanucher = -1;
    mLimitCount = -1;
    sBadgeAbility = 0;
  }
  
  public static void changeLenovoBadge(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("app_shortcut_custom_id", null);
      localBundle.putInt("app_badge_count", i);
      if (paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle) != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.i("CommonBadgeUtilImpl", 1, "changeLenovoBadge count=" + i + "result=" + bool);
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("CommonBadgeUtilImpl", 1, paramContext, new Object[0]);
    }
  }
  
  public static void changeMI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    try
    {
      paramContext = Class.forName("android.app.MiuiNotification").newInstance();
      Field localField = paramContext.getClass().getDeclaredField("messageCount");
      localField.setAccessible(true);
      localField.set(paramContext, Integer.valueOf(i));
      paramNotification.getClass().getField("extraNotification").set(paramNotification, paramContext);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (InstantiationException paramContext)
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
    String str;
    if (paramInt > 0) {
      if (paramInt > mLimitCount) {
        str = "" + mLimitCount;
      }
    }
    for (;;)
    {
      localIntent.putExtra("android.intent.extra.update_application_message_text", str);
      paramContext.sendBroadcast(localIntent);
      return;
      str = paramInt + "";
      continue;
      str = "";
    }
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
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
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
  
  public static void changeVivoBadge(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
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
    int i = paramInt;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("app_shortcut_custom_id", null);
      localBundle.putInt("app_badge_count", i);
      if (paramContext.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("CommonBadgeUtilImpl", "changeZUKBadge mcount=" + i + "result=" + bool);
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
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
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
  }
  
  /* Error */
  public static boolean isMIUI6()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: getstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   5: ifne +128 -> 133
    //   8: iconst_m1
    //   9: putstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   12: ldc 99
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_3
    //   21: new 369	java/io/BufferedReader
    //   24: dup
    //   25: new 371	java/io/InputStreamReader
    //   28: dup
    //   29: new 373	java/lang/ProcessBuilder
    //   32: dup
    //   33: iconst_2
    //   34: anewarray 87	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 375
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc_w 377
    //   48: aastore
    //   49: invokespecial 380	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   52: invokevirtual 384	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   55: invokevirtual 390	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   58: invokespecial 393	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   61: sipush 1024
    //   64: invokespecial 396	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 399	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_3
    //   73: aload_2
    //   74: invokevirtual 402	java/io/BufferedReader:close	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 402	java/io/BufferedReader:close	()V
    //   85: aload_3
    //   86: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +44 -> 133
    //   92: aload_3
    //   93: invokestatic 406	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: istore_0
    //   97: iload_0
    //   98: iconst_3
    //   99: if_icmple +34 -> 133
    //   102: ldc_w 408
    //   105: new 156	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 410
    //   115: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_0
    //   119: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 301	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: iconst_1
    //   130: putstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   133: getstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   136: iconst_1
    //   137: if_icmpne +238 -> 375
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 411	java/lang/NumberFormatException:printStackTrace	()V
    //   147: iconst_0
    //   148: istore_0
    //   149: goto -52 -> 97
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_2
    //   155: ldc 99
    //   157: astore_3
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 402	java/io/BufferedReader:close	()V
    //   166: aload_3
    //   167: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne -37 -> 133
    //   173: aload_3
    //   174: invokestatic 406	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   177: istore_0
    //   178: iload_0
    //   179: iconst_3
    //   180: if_icmple -47 -> 133
    //   183: ldc_w 408
    //   186: new 156	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 410
    //   196: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload_0
    //   200: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 301	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   209: pop
    //   210: iconst_1
    //   211: putstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   214: goto -81 -> 133
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual 411	java/lang/NumberFormatException:printStackTrace	()V
    //   222: iconst_0
    //   223: istore_0
    //   224: goto -46 -> 178
    //   227: astore_2
    //   228: aload_3
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 402	java/io/BufferedReader:close	()V
    //   238: aload 4
    //   240: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne -110 -> 133
    //   246: aload 4
    //   248: invokestatic 406	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   251: istore_0
    //   252: iload_0
    //   253: iconst_3
    //   254: if_icmple -121 -> 133
    //   257: ldc_w 408
    //   260: new 156	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 410
    //   270: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_0
    //   274: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 301	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   283: pop
    //   284: iconst_1
    //   285: putstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   288: goto -155 -> 133
    //   291: astore_2
    //   292: aload_2
    //   293: invokevirtual 411	java/lang/NumberFormatException:printStackTrace	()V
    //   296: iconst_0
    //   297: istore_0
    //   298: goto -46 -> 252
    //   301: astore_2
    //   302: aload 5
    //   304: astore_3
    //   305: aload_3
    //   306: ifnull +7 -> 313
    //   309: aload_3
    //   310: invokevirtual 402	java/io/BufferedReader:close	()V
    //   313: aload 4
    //   315: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: ifne +47 -> 365
    //   321: aload 4
    //   323: invokestatic 406	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   326: istore_1
    //   327: iload_1
    //   328: istore_0
    //   329: iload_0
    //   330: iconst_3
    //   331: if_icmple +34 -> 365
    //   334: ldc_w 408
    //   337: new 156	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 410
    //   347: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload_0
    //   351: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 301	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   360: pop
    //   361: iconst_1
    //   362: putstatic 109	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   365: aload_2
    //   366: athrow
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 411	java/lang/NumberFormatException:printStackTrace	()V
    //   372: goto -43 -> 329
    //   375: iconst_0
    //   376: ireturn
    //   377: astore_2
    //   378: goto -293 -> 85
    //   381: astore_2
    //   382: goto -216 -> 166
    //   385: astore_2
    //   386: goto -148 -> 238
    //   389: astore_3
    //   390: goto -77 -> 313
    //   393: astore 5
    //   395: aload_2
    //   396: astore_3
    //   397: aload 5
    //   399: astore_2
    //   400: goto -95 -> 305
    //   403: astore 5
    //   405: aload_3
    //   406: astore 4
    //   408: aload_2
    //   409: astore_3
    //   410: aload 5
    //   412: astore_2
    //   413: goto -108 -> 305
    //   416: astore_3
    //   417: goto -187 -> 230
    //   420: astore 4
    //   422: aload_3
    //   423: astore 4
    //   425: goto -195 -> 230
    //   428: astore_3
    //   429: ldc 99
    //   431: astore_3
    //   432: goto -274 -> 158
    //   435: astore 4
    //   437: goto -279 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	350	0	i	int
    //   326	2	1	j	int
    //   67	15	2	localBufferedReader	java.io.BufferedReader
    //   142	2	2	localNumberFormatException1	java.lang.NumberFormatException
    //   152	1	2	localIOException1	java.io.IOException
    //   154	9	2	localObject1	Object
    //   217	2	2	localNumberFormatException2	java.lang.NumberFormatException
    //   227	1	2	localException1	Exception
    //   229	6	2	localObject2	Object
    //   291	2	2	localNumberFormatException3	java.lang.NumberFormatException
    //   301	65	2	localObject3	Object
    //   377	1	2	localIOException2	java.io.IOException
    //   381	1	2	localIOException3	java.io.IOException
    //   385	11	2	localIOException4	java.io.IOException
    //   399	14	2	localObject4	Object
    //   20	290	3	localObject5	Object
    //   367	2	3	localNumberFormatException4	java.lang.NumberFormatException
    //   389	1	3	localIOException5	java.io.IOException
    //   396	14	3	localObject6	Object
    //   416	7	3	localException2	Exception
    //   428	1	3	localIOException6	java.io.IOException
    //   431	1	3	str	String
    //   14	393	4	localObject7	Object
    //   420	1	4	localException3	Exception
    //   423	1	4	localObject8	Object
    //   435	1	4	localIOException7	java.io.IOException
    //   17	286	5	localObject9	Object
    //   393	5	5	localObject10	Object
    //   403	8	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   92	97	142	java/lang/NumberFormatException
    //   21	68	152	java/io/IOException
    //   173	178	217	java/lang/NumberFormatException
    //   21	68	227	java/lang/Exception
    //   246	252	291	java/lang/NumberFormatException
    //   21	68	301	finally
    //   321	327	367	java/lang/NumberFormatException
    //   81	85	377	java/io/IOException
    //   162	166	381	java/io/IOException
    //   234	238	385	java/io/IOException
    //   309	313	389	java/io/IOException
    //   68	73	393	finally
    //   73	77	403	finally
    //   68	73	416	java/lang/Exception
    //   73	77	420	java/lang/Exception
    //   68	73	428	java/io/IOException
    //   73	77	435	java/io/IOException
  }
  
  public static boolean isQQLanucher()
  {
    boolean bool2 = false;
    if (packmag == null) {
      packmag = sContext.getPackageManager();
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < sQQLuancherPackageNames.length) {}
      try
      {
        PackageInfo localPackageInfo = packmag.getPackageInfo(sQQLuancherPackageNames[i], 0);
        if (localPackageInfo != null)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
  
  public static boolean isSupportBadge(Context paramContext)
  {
    boolean bool = false;
    int i = 1;
    if (sContext == null) {
      sContext = paramContext;
    }
    if (sBadgeAbility != 0) {
      return sBadgeAbility == 1;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK"))
    {
      bool = true;
      BadgeController.init(sContext);
      if (BadgeController.isSupport(sContext)) {
        bool = true;
      }
      if (!bool) {
        break label218;
      }
    }
    for (;;)
    {
      sBadgeAbility = i;
      return bool;
      if ((islenovoLanucher("com.lenovo.launcher")) || (isQQLanucher()))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("OPPO"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("Realme"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        bool = true;
        break;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("nubia"))
      {
        bool = true;
        break;
      }
      if (!Build.MANUFACTURER.equalsIgnoreCase("lenovo")) {
        break;
      }
      bool = true;
      break;
      label218:
      i = 2;
    }
  }
  
  public static boolean islenovoLanucher(String paramString)
  {
    if (Build.VERSION.SDK_INT < 15) {}
    do
    {
      return false;
      if (haslenovoLanucher == -1) {
        break;
      }
    } while (haslenovoLanucher != 1);
    return true;
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
      haslenovoLanucher = 0;
      return false;
    }
    catch (Exception paramString)
    {
      haslenovoLanucher = 0;
    }
    return false;
  }
  
  public static void setBadge(Context paramContext, int paramInt)
  {
    setBadge(paramContext, paramInt, false);
  }
  
  public static void setBadge(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Log.d("CommonBadgeUtilImpl", "setBadge count=" + paramInt + "|forceSet=" + paramBoolean);
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
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      changeMIBadge(paramContext, paramInt);
    }
    do
    {
      return;
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
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) || (Build.MANUFACTURER.equalsIgnoreCase("Realme")))
      {
        changeOPPOBadge(paramContext, paramInt);
        return;
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        changeVivoBadge(paramContext, paramInt);
        return;
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("nubia"));
    changeNubiaBadge(paramContext, paramInt);
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
  
  /* Error */
  public static void setLenovoBadge(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 519	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 520	android/content/ContentValues:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokestatic 278	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:getLauncherClassName	(Landroid/content/Context;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload 4
    //   23: ldc_w 505
    //   26: aload_0
    //   27: invokevirtual 285	android/content/Context:getPackageName	()Ljava/lang/String;
    //   30: invokevirtual 523	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 4
    //   35: ldc_w 511
    //   38: aload_3
    //   39: invokevirtual 523	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload 4
    //   44: ldc_w 525
    //   47: iload_1
    //   48: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: invokevirtual 528	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   54: aload 4
    //   56: ldc_w 530
    //   59: ldc 99
    //   61: invokevirtual 523	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   68: astore_3
    //   69: ldc 56
    //   71: invokestatic 146	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   74: astore 5
    //   76: aload_0
    //   77: invokevirtual 285	android/content/Context:getPackageName	()Ljava/lang/String;
    //   80: astore 6
    //   82: aload_3
    //   83: aload 5
    //   85: iconst_4
    //   86: anewarray 87	java/lang/String
    //   89: dup
    //   90: iconst_0
    //   91: ldc_w 505
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: ldc_w 511
    //   100: aastore
    //   101: dup
    //   102: iconst_2
    //   103: ldc_w 525
    //   106: aastore
    //   107: dup
    //   108: iconst_3
    //   109: ldc_w 530
    //   112: aastore
    //   113: ldc_w 532
    //   116: iconst_1
    //   117: anewarray 87	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: aload 6
    //   124: aastore
    //   125: aconst_null
    //   126: invokevirtual 536	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore_3
    //   130: aload_3
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +61 -> 194
    //   136: aload_2
    //   137: invokeinterface 542 1 0
    //   142: ifle +52 -> 194
    //   145: aload_2
    //   146: invokeinterface 545 1 0
    //   151: ifeq +32 -> 183
    //   154: aload_0
    //   155: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   158: ldc 56
    //   160: invokestatic 146	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   163: aload 4
    //   165: ldc_w 532
    //   168: iconst_1
    //   169: anewarray 87	java/lang/String
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: invokevirtual 285	android/content/Context:getPackageName	()Ljava/lang/String;
    //   178: aastore
    //   179: invokevirtual 549	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   182: pop
    //   183: aload_2
    //   184: ifnull -164 -> 20
    //   187: aload_2
    //   188: invokeinterface 550 1 0
    //   193: return
    //   194: ldc 29
    //   196: ldc_w 552
    //   199: invokestatic 301	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: aload_0
    //   204: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   207: ldc 56
    //   209: invokestatic 146	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   212: aload 4
    //   214: invokevirtual 556	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   217: pop
    //   218: aload_2
    //   219: ifnull -199 -> 20
    //   222: aload_2
    //   223: invokeinterface 550 1 0
    //   228: return
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_2
    //   232: aload_2
    //   233: ifnull -213 -> 20
    //   236: aload_2
    //   237: invokeinterface 550 1 0
    //   242: return
    //   243: astore_0
    //   244: aload_2
    //   245: ifnull +9 -> 254
    //   248: aload_2
    //   249: invokeinterface 550 1 0
    //   254: aload_0
    //   255: athrow
    //   256: astore_0
    //   257: goto -13 -> 244
    //   260: astore_0
    //   261: goto -29 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   0	264	1	paramInt	int
    //   1	248	2	localObject1	Object
    //   15	116	3	localObject2	Object
    //   9	204	4	localContentValues	android.content.ContentValues
    //   74	10	5	localUri	Uri
    //   80	43	6	str	String
    // Exception table:
    //   from	to	target	type
    //   21	130	229	java/lang/Throwable
    //   21	130	243	finally
    //   136	183	256	finally
    //   194	218	256	finally
    //   136	183	260	java/lang/Throwable
    //   194	218	260	java/lang/Throwable
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
    int i;
    if (paramInt > mLimitCount) {
      i = mLimitCount;
    }
    for (;;)
    {
      Intent localIntent = new Intent("com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT");
      localIntent.putExtra("webappId", "20634");
      localIntent.putExtra("info_tips", String.valueOf(i));
      paramContext.sendBroadcast(localIntent);
      return;
      i = paramInt;
      if (paramInt < 1) {
        i = 0;
      }
    }
  }
  
  /* Error */
  public static void setSamsungBadge(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 82	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   6: ifnonnull +265 -> 271
    //   9: ldc_w 572
    //   12: invokestatic 146	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   15: astore_3
    //   16: aload_0
    //   17: invokevirtual 138	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: aload_3
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 536	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +27 -> 57
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: astore 5
    //   39: iconst_0
    //   40: invokestatic 577	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: putstatic 82	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   46: aload_3
    //   47: ifnull +9 -> 56
    //   50: aload_3
    //   51: invokeinterface 550 1 0
    //   56: return
    //   57: aload_3
    //   58: astore 4
    //   60: aload_3
    //   61: astore 5
    //   63: iconst_1
    //   64: invokestatic 577	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: putstatic 82	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   70: aload_3
    //   71: astore 4
    //   73: aload_3
    //   74: astore 5
    //   76: getstatic 82	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   79: invokevirtual 580	java/lang/Boolean:booleanValue	()Z
    //   82: ifeq +138 -> 220
    //   85: aload_3
    //   86: astore 4
    //   88: aload_3
    //   89: astore 5
    //   91: aload_0
    //   92: invokestatic 278	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:getLauncherClassName	(Landroid/content/Context;)Ljava/lang/String;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnonnull +14 -> 113
    //   102: aload_3
    //   103: ifnull -47 -> 56
    //   106: aload_3
    //   107: invokeinterface 550 1 0
    //   112: return
    //   113: iload_1
    //   114: istore_2
    //   115: aload_3
    //   116: astore 4
    //   118: aload_3
    //   119: astore 5
    //   121: iload_1
    //   122: getstatic 105	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:mLimitCount	I
    //   125: if_icmple +13 -> 138
    //   128: aload_3
    //   129: astore 4
    //   131: aload_3
    //   132: astore 5
    //   134: getstatic 105	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:mLimitCount	I
    //   137: istore_2
    //   138: aload_3
    //   139: astore 4
    //   141: aload_3
    //   142: astore 5
    //   144: new 254	android/content/Intent
    //   147: dup
    //   148: ldc_w 582
    //   151: invokespecial 257	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   154: astore 7
    //   156: aload_3
    //   157: astore 4
    //   159: aload_3
    //   160: astore 5
    //   162: aload 7
    //   164: ldc_w 584
    //   167: iload_2
    //   168: invokevirtual 292	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   171: pop
    //   172: aload_3
    //   173: astore 4
    //   175: aload_3
    //   176: astore 5
    //   178: aload 7
    //   180: ldc_w 586
    //   183: aload_0
    //   184: invokevirtual 285	android/content/Context:getPackageName	()Ljava/lang/String;
    //   187: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   190: pop
    //   191: aload_3
    //   192: astore 4
    //   194: aload_3
    //   195: astore 5
    //   197: aload 7
    //   199: ldc_w 588
    //   202: aload 6
    //   204: invokevirtual 263	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   207: pop
    //   208: aload_3
    //   209: astore 4
    //   211: aload_3
    //   212: astore 5
    //   214: aload_0
    //   215: aload 7
    //   217: invokevirtual 267	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   220: aload_3
    //   221: ifnull -165 -> 56
    //   224: aload_3
    //   225: invokeinterface 550 1 0
    //   230: return
    //   231: astore_0
    //   232: aconst_null
    //   233: astore 5
    //   235: aload 5
    //   237: ifnull -181 -> 56
    //   240: aload 5
    //   242: invokeinterface 550 1 0
    //   247: return
    //   248: astore_0
    //   249: aload 4
    //   251: ifnull +10 -> 261
    //   254: aload 4
    //   256: invokeinterface 550 1 0
    //   261: aload_0
    //   262: athrow
    //   263: astore_0
    //   264: goto -15 -> 249
    //   267: astore_0
    //   268: goto -33 -> 235
    //   271: aconst_null
    //   272: astore_3
    //   273: goto -203 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   0	276	1	paramInt	int
    //   114	54	2	i	int
    //   15	258	3	localObject1	Object
    //   1	254	4	localObject2	Object
    //   37	204	5	localObject3	Object
    //   95	108	6	str	String
    //   154	62	7	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   3	29	231	java/lang/Throwable
    //   3	29	248	finally
    //   39	46	263	finally
    //   63	70	263	finally
    //   76	85	263	finally
    //   91	97	263	finally
    //   121	128	263	finally
    //   134	138	263	finally
    //   144	156	263	finally
    //   162	172	263	finally
    //   178	191	263	finally
    //   197	208	263	finally
    //   214	220	263	finally
    //   39	46	267	java/lang/Throwable
    //   63	70	267	java/lang/Throwable
    //   76	85	267	java/lang/Throwable
    //   91	97	267	java/lang/Throwable
    //   121	128	267	java/lang/Throwable
    //   134	138	267	java/lang/Throwable
    //   144	156	267	java/lang/Throwable
    //   162	172	267	java/lang/Throwable
    //   178	191	267	java/lang/Throwable
    //   197	208	267	java/lang/Throwable
    //   214	220	267	java/lang/Throwable
  }
  
  public static void setSonyBadge(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    String str2 = getLauncherClassName(paramContext);
    if (str2 == null) {
      return;
    }
    if (paramInt < 1)
    {
      str1 = "";
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
      localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", str2);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str1);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    if (paramInt > mLimitCount) {}
    for (String str1 = "" + mLimitCount;; str1 = paramInt + "")
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.badge.CommonBadgeUtilImpl
 * JD-Core Version:    0.7.0.1
 */
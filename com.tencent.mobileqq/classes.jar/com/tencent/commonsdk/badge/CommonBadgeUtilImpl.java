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
  public static final String MANUFACTURER_OF_HARDWARE_OPPO = "OPPO";
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
    //   0: getstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   3: ifne +155 -> 158
    //   6: iconst_m1
    //   7: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   10: ldc 93
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: new 347	java/io/BufferedReader
    //   25: dup
    //   26: new 349	java/io/InputStreamReader
    //   29: dup
    //   30: new 351	java/lang/ProcessBuilder
    //   33: dup
    //   34: iconst_2
    //   35: anewarray 81	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc_w 353
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc_w 355
    //   49: aastore
    //   50: invokespecial 358	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   53: invokevirtual 362	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   56: invokevirtual 368	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   59: invokespecial 371	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: sipush 1024
    //   65: invokespecial 374	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   68: astore_3
    //   69: aload_2
    //   70: astore 4
    //   72: aload_2
    //   73: astore 5
    //   75: aload_3
    //   76: invokevirtual 377	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 6
    //   81: aload 6
    //   83: astore 4
    //   85: aload 6
    //   87: astore 5
    //   89: aload 6
    //   91: astore_2
    //   92: aload_3
    //   93: invokevirtual 380	java/io/BufferedReader:close	()V
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 380	java/io/BufferedReader:close	()V
    //   104: aload 6
    //   106: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +49 -> 158
    //   112: iconst_0
    //   113: istore_0
    //   114: aload 6
    //   116: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   119: istore_1
    //   120: iload_1
    //   121: istore_0
    //   122: iload_0
    //   123: iconst_3
    //   124: if_icmple +34 -> 158
    //   127: ldc_w 386
    //   130: new 188	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 388
    //   140: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload_0
    //   144: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 277	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   153: pop
    //   154: iconst_1
    //   155: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   158: getstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   161: iconst_1
    //   162: if_icmpne +236 -> 398
    //   165: iconst_1
    //   166: ireturn
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 389	java/lang/NumberFormatException:printStackTrace	()V
    //   172: goto -50 -> 122
    //   175: astore_3
    //   176: aload 4
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 380	java/io/BufferedReader:close	()V
    //   187: aload_2
    //   188: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne -33 -> 158
    //   194: iconst_0
    //   195: istore_0
    //   196: aload_2
    //   197: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   200: istore_1
    //   201: iload_1
    //   202: istore_0
    //   203: iload_0
    //   204: iconst_3
    //   205: if_icmple -47 -> 158
    //   208: ldc_w 386
    //   211: new 188	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 388
    //   221: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload_0
    //   225: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 277	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   234: pop
    //   235: iconst_1
    //   236: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   239: goto -81 -> 158
    //   242: astore_2
    //   243: aload_2
    //   244: invokevirtual 389	java/lang/NumberFormatException:printStackTrace	()V
    //   247: goto -44 -> 203
    //   250: astore_3
    //   251: aload 6
    //   253: astore_3
    //   254: aload_3
    //   255: ifnull +7 -> 262
    //   258: aload_3
    //   259: invokevirtual 380	java/io/BufferedReader:close	()V
    //   262: aload_2
    //   263: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne -108 -> 158
    //   269: iconst_0
    //   270: istore_0
    //   271: aload_2
    //   272: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   275: istore_1
    //   276: iload_1
    //   277: istore_0
    //   278: iload_0
    //   279: iconst_3
    //   280: if_icmple -122 -> 158
    //   283: ldc_w 386
    //   286: new 188	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 388
    //   296: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload_0
    //   300: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 277	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   309: pop
    //   310: iconst_1
    //   311: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   314: goto -156 -> 158
    //   317: astore_2
    //   318: aload_2
    //   319: invokevirtual 389	java/lang/NumberFormatException:printStackTrace	()V
    //   322: goto -44 -> 278
    //   325: astore_3
    //   326: aload 5
    //   328: ifnull +8 -> 336
    //   331: aload 5
    //   333: invokevirtual 380	java/io/BufferedReader:close	()V
    //   336: aload_2
    //   337: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne +48 -> 388
    //   343: iconst_0
    //   344: istore_0
    //   345: aload_2
    //   346: invokestatic 384	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   349: istore_1
    //   350: iload_1
    //   351: istore_0
    //   352: iload_0
    //   353: iconst_3
    //   354: if_icmple +34 -> 388
    //   357: ldc_w 386
    //   360: new 188	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 388
    //   370: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload_0
    //   374: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 277	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   383: pop
    //   384: iconst_1
    //   385: putstatic 103	com/tencent/commonsdk/badge/CommonBadgeUtilImpl:miui6Flag	I
    //   388: aload_3
    //   389: athrow
    //   390: astore_2
    //   391: aload_2
    //   392: invokevirtual 389	java/lang/NumberFormatException:printStackTrace	()V
    //   395: goto -43 -> 352
    //   398: iconst_0
    //   399: ireturn
    //   400: astore_2
    //   401: goto -297 -> 104
    //   404: astore_3
    //   405: goto -218 -> 187
    //   408: astore_3
    //   409: goto -147 -> 262
    //   412: astore 4
    //   414: goto -78 -> 336
    //   417: astore 6
    //   419: aload_3
    //   420: astore 5
    //   422: aload 4
    //   424: astore_2
    //   425: aload 6
    //   427: astore_3
    //   428: goto -102 -> 326
    //   431: astore_2
    //   432: aload 5
    //   434: astore_2
    //   435: goto -181 -> 254
    //   438: astore 4
    //   440: goto -261 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   113	261	0	i	int
    //   119	232	1	j	int
    //   12	80	2	localObject1	Object
    //   167	30	2	localNumberFormatException1	java.lang.NumberFormatException
    //   242	30	2	localNumberFormatException2	java.lang.NumberFormatException
    //   317	29	2	localNumberFormatException3	java.lang.NumberFormatException
    //   390	2	2	localNumberFormatException4	java.lang.NumberFormatException
    //   400	1	2	localIOException1	java.io.IOException
    //   424	1	2	localObject2	Object
    //   431	1	2	localException1	Exception
    //   434	1	2	localObject3	Object
    //   68	33	3	localBufferedReader	java.io.BufferedReader
    //   175	1	3	localIOException2	java.io.IOException
    //   178	6	3	localObject4	Object
    //   250	1	3	localException2	Exception
    //   253	6	3	str1	String
    //   325	64	3	localObject5	Object
    //   404	1	3	localIOException3	java.io.IOException
    //   408	12	3	localIOException4	java.io.IOException
    //   427	1	3	localObject6	Object
    //   20	157	4	localObject7	Object
    //   412	11	4	localIOException5	java.io.IOException
    //   438	1	4	localIOException6	java.io.IOException
    //   17	416	5	localObject8	Object
    //   14	238	6	str2	String
    //   417	9	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   114	120	167	java/lang/NumberFormatException
    //   22	69	175	java/io/IOException
    //   196	201	242	java/lang/NumberFormatException
    //   22	69	250	java/lang/Exception
    //   271	276	317	java/lang/NumberFormatException
    //   22	69	325	finally
    //   345	350	390	java/lang/NumberFormatException
    //   100	104	400	java/io/IOException
    //   183	187	404	java/io/IOException
    //   258	262	408	java/io/IOException
    //   331	336	412	java/io/IOException
    //   75	81	417	finally
    //   92	96	417	finally
    //   75	81	431	java/lang/Exception
    //   92	96	431	java/lang/Exception
    //   75	81	438	java/io/IOException
    //   92	96	438	java/io/IOException
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
    int i = 1;
    if (sContext == null) {
      sContext = paramContext;
    }
    if (sBadgeAbility != 0) {
      return sBadgeAbility == 1;
    }
    boolean bool;
    if (Build.MANUFACTURER.equalsIgnoreCase("ZUK"))
    {
      bool = true;
      BadgeController.init(sContext);
      if (BadgeController.isSupport(sContext)) {
        bool = true;
      }
      if (!bool) {
        break label173;
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
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      label173:
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
      if (Build.MANUFACTURER.equalsIgnoreCase("OPPO"))
      {
        changeOPPOBadge(paramContext, paramInt);
        return;
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("vivo"));
    changeVivoBadge(paramContext, paramInt);
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
    if (localObject3 == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localObject2;
      try
      {
        localContentValues.put("package", paramContext.getPackageName());
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localContentValues.put("class", (String)localObject3);
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localContentValues.put("badgecount", Integer.valueOf(paramInt));
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localContentValues.put("extraData", "");
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localObject3 = paramContext.getContentResolver();
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        Uri localUri = Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges");
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        String str = paramContext.getPackageName();
        localCursor1 = localCursor2;
        localObject1 = localObject2;
        localCursor2 = ((ContentResolver)localObject3).query(localUri, new String[] { "package", "class", "badgecount", "extraData" }, "package=?", new String[] { str }, null);
        if (localCursor2 != null)
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          if (localCursor2.getCount() > 0)
          {
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            if (localCursor2.moveToFirst())
            {
              localCursor1 = localCursor2;
              localObject1 = localCursor2;
              paramContext.getContentResolver().update(Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges"), localContentValues, "package=?", new String[] { paramContext.getPackageName() });
            }
            if (localCursor2 == null) {
              continue;
            }
            localCursor2.close();
            return;
          }
        }
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        Log.d("lenovo", "setLenovoBadge cur=null");
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        paramContext.getContentResolver().insert(Uri.parse("content://com.lenovo.launcher.badge/lenovo_badges"), localContentValues);
        if (localCursor2 == null) {
          continue;
        }
        localCursor2.close();
        return;
      }
      catch (Throwable paramContext)
      {
        if (localCursor1 == null) {
          continue;
        }
        localCursor1.close();
        return;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
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
  
  public static void setSamsungBadge(Context paramContext, int paramInt)
  {
    String str = null;
    Intent localIntent = null;
    Object localObject1 = null;
    localObject2 = str;
    localObject3 = localIntent;
    label99:
    label249:
    do
    {
      do
      {
        try
        {
          if (haveprovider != null) {
            break label99;
          }
          localObject2 = str;
          localObject3 = localIntent;
          localObject1 = Uri.parse("content://com.sec.badge/apps");
          localObject2 = str;
          localObject3 = localIntent;
          localObject1 = paramContext.getContentResolver().query((Uri)localObject1, null, null, null, null);
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            localObject3 = localObject1;
            haveprovider = Boolean.valueOf(false);
            return;
          }
        }
        catch (Throwable paramContext)
        {
          int i;
          return;
        }
        finally
        {
          if (localObject3 == null) {
            break label287;
          }
          ((Cursor)localObject3).close();
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        haveprovider = Boolean.valueOf(true);
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (!haveprovider.booleanValue()) {
          break label249;
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        str = getLauncherClassName(paramContext);
        if (str != null) {
          break;
        }
      } while (localObject1 == null);
      ((Cursor)localObject1).close();
      return;
      i = paramInt;
      localObject2 = localObject1;
      localObject3 = localObject1;
      if (paramInt > mLimitCount)
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        i = mLimitCount;
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent.putExtra("badge_count", i);
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent.putExtra("badge_count_package_name", paramContext.getPackageName());
      localObject2 = localObject1;
      localObject3 = localObject1;
      localIntent.putExtra("badge_count_class_name", str);
      localObject2 = localObject1;
      localObject3 = localObject1;
      paramContext.sendBroadcast(localIntent);
    } while (localObject1 == null);
    ((Cursor)localObject1).close();
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
package com.tencent.beacon.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import com.tencent.beacon.d.a;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static boolean a = false;
  private static String b = null;
  private static String c = null;
  private static Boolean d = null;
  private static int e = 0;
  private static String f = "";
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getInt(paramString, 0);
  }
  
  public static String a()
  {
    if (!"".equals(f)) {
      return f;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      f = f + e + "_";
      f += new Date().getTime();
    }
    catch (Exception localException)
    {
      label89:
      break label89;
    }
    return f;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
        if (paramContext != null)
        {
          paramContext = paramContext.toString().trim();
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        a.d("no appkey !! ", new Object[0]);
        paramContext = "";
      }
      finally {}
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      b = paramString;
      d locald = d.m();
      if (locald != null) {
        locald.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static long b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getLong(paramString, 0L);
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +11 -> 15
    //   7: ldc 26
    //   9: astore_0
    //   10: ldc 2
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 175	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: astore 6
    //   26: aload_0
    //   27: ldc 37
    //   29: iconst_0
    //   30: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: ldc 177
    //   35: ldc 26
    //   37: invokeinterface 181 3 0
    //   42: astore 5
    //   44: aload 5
    //   46: astore_2
    //   47: aload 5
    //   49: ldc 26
    //   51: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifeq +33 -> 87
    //   57: ldc 183
    //   59: astore_2
    //   60: aload_0
    //   61: ldc 37
    //   63: iconst_0
    //   64: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   67: invokeinterface 144 1 0
    //   72: ldc 177
    //   74: ldc 183
    //   76: invokeinterface 164 3 0
    //   81: invokeinterface 154 1 0
    //   86: pop
    //   87: new 66	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 185
    //   93: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 189	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_2
    //   111: ldc 26
    //   113: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +301 -> 417
    //   119: aload 6
    //   121: aload_2
    //   122: invokevirtual 195	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   125: astore_2
    //   126: new 197	java/util/Properties
    //   129: dup
    //   130: invokespecial 198	java/util/Properties:<init>	()V
    //   133: astore_3
    //   134: aload_3
    //   135: aload_2
    //   136: invokevirtual 202	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   139: aload_3
    //   140: ldc 204
    //   142: ldc 26
    //   144: invokevirtual 207	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: astore_3
    //   148: new 66	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 209
    //   154: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_3
    //   158: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 189	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: ldc 26
    //   173: aload_3
    //   174: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: istore_1
    //   178: iload_1
    //   179: ifne +34 -> 213
    //   182: aload_3
    //   183: astore_0
    //   184: aload_2
    //   185: ifnull -175 -> 10
    //   188: aload_2
    //   189: invokevirtual 214	java/io/InputStream:close	()V
    //   192: aload_3
    //   193: astore_0
    //   194: goto -184 -> 10
    //   197: astore_0
    //   198: aload_0
    //   199: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   202: aload_3
    //   203: astore_0
    //   204: goto -194 -> 10
    //   207: astore_0
    //   208: ldc 2
    //   210: monitorexit
    //   211: aload_0
    //   212: athrow
    //   213: aload_2
    //   214: astore 4
    //   216: aload_3
    //   217: astore_2
    //   218: aload 4
    //   220: astore_3
    //   221: aload_2
    //   222: astore 4
    //   224: aload_3
    //   225: ifnull +186 -> 411
    //   228: aload_3
    //   229: invokevirtual 214	java/io/InputStream:close	()V
    //   232: aload_0
    //   233: invokevirtual 96	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   236: aload_0
    //   237: invokevirtual 99	android/content/Context:getPackageName	()Ljava/lang/String;
    //   240: sipush 128
    //   243: invokevirtual 105	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   246: getfield 111	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   249: ldc 219
    //   251: invokevirtual 119	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   254: astore_3
    //   255: aload_2
    //   256: astore_0
    //   257: aload_3
    //   258: ifnull -248 -> 10
    //   261: aload_3
    //   262: invokevirtual 120	java/lang/Object:toString	()Ljava/lang/String;
    //   265: astore_0
    //   266: goto -256 -> 10
    //   269: astore_3
    //   270: aload_3
    //   271: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   274: goto -42 -> 232
    //   277: astore_2
    //   278: ldc 26
    //   280: astore_2
    //   281: aload_0
    //   282: ldc 37
    //   284: iconst_0
    //   285: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   288: invokeinterface 144 1 0
    //   293: ldc 177
    //   295: ldc 26
    //   297: invokeinterface 164 3 0
    //   302: invokeinterface 154 1 0
    //   307: pop
    //   308: ldc 221
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 223	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_2
    //   318: astore 4
    //   320: aload_3
    //   321: ifnull +90 -> 411
    //   324: aload_3
    //   325: invokevirtual 214	java/io/InputStream:close	()V
    //   328: goto -96 -> 232
    //   331: astore_3
    //   332: aload_3
    //   333: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   336: goto -104 -> 232
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 214	java/io/InputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_2
    //   353: aload_2
    //   354: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   357: goto -7 -> 350
    //   360: astore_0
    //   361: ldc 225
    //   363: iconst_0
    //   364: anewarray 4	java/lang/Object
    //   367: invokestatic 189	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: aload_2
    //   371: astore_0
    //   372: goto -362 -> 10
    //   375: astore_0
    //   376: goto -34 -> 342
    //   379: astore_0
    //   380: aload_3
    //   381: astore_2
    //   382: goto -40 -> 342
    //   385: astore_3
    //   386: ldc 26
    //   388: astore 4
    //   390: aload_2
    //   391: astore_3
    //   392: aload 4
    //   394: astore_2
    //   395: goto -114 -> 281
    //   398: astore 4
    //   400: aload_3
    //   401: astore 4
    //   403: aload_2
    //   404: astore_3
    //   405: aload 4
    //   407: astore_2
    //   408: goto -127 -> 281
    //   411: aload 4
    //   413: astore_2
    //   414: goto -182 -> 232
    //   417: ldc 26
    //   419: astore_2
    //   420: aload 4
    //   422: astore_3
    //   423: goto -202 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	paramContext	Context
    //   177	2	1	bool	boolean
    //   46	210	2	localObject1	Object
    //   277	1	2	localException1	Exception
    //   280	67	2	str1	String
    //   352	19	2	localIOException1	java.io.IOException
    //   381	39	2	localObject2	Object
    //   16	246	3	localObject3	Object
    //   269	56	3	localIOException2	java.io.IOException
    //   331	50	3	localIOException3	java.io.IOException
    //   385	1	3	localException2	Exception
    //   391	32	3	localObject4	Object
    //   18	375	4	localObject5	Object
    //   398	1	4	localException3	Exception
    //   401	20	4	localObject6	Object
    //   42	6	5	str2	String
    //   24	96	6	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   188	192	197	java/io/IOException
    //   20	26	207	finally
    //   188	192	207	finally
    //   198	202	207	finally
    //   228	232	207	finally
    //   232	255	207	finally
    //   261	266	207	finally
    //   270	274	207	finally
    //   324	328	207	finally
    //   332	336	207	finally
    //   346	350	207	finally
    //   350	352	207	finally
    //   353	357	207	finally
    //   361	370	207	finally
    //   228	232	269	java/io/IOException
    //   26	44	277	java/lang/Exception
    //   47	57	277	java/lang/Exception
    //   60	87	277	java/lang/Exception
    //   87	126	277	java/lang/Exception
    //   324	328	331	java/io/IOException
    //   26	44	339	finally
    //   47	57	339	finally
    //   60	87	339	finally
    //   87	126	339	finally
    //   346	350	352	java/io/IOException
    //   232	255	360	java/lang/Throwable
    //   261	266	360	java/lang/Throwable
    //   126	148	375	finally
    //   148	178	375	finally
    //   281	317	379	finally
    //   126	148	385	java/lang/Exception
    //   148	178	398	java/lang/Exception
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getString(paramString1, paramString2);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", paramString).commit();
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        a.d("context == null return null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        String str2 = paramContext.getSharedPreferences("DENGTA_META", 4).getString("APPKEY_DENGTA", null);
        bool1 = bool3;
        String str1 = a(paramContext);
        if (str2 != null)
        {
          bool1 = bool3;
          if (str2.equals(str1)) {}
        }
        else
        {
          bool3 = true;
          bool2 = true;
          bool1 = bool3;
          paramContext = paramContext.getSharedPreferences("DENGTA_META", 0).edit();
          bool1 = bool3;
          paramContext.putString("APPKEY_DENGTA", str1);
          bool1 = bool3;
          paramContext.commit();
        }
      }
      catch (Exception paramContext)
      {
        a.b("updateLocalAPPKEY fail!", new Object[0]);
        a.a(paramContext);
        bool2 = bool1;
      }
    }
  }
  
  public static void d(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", paramString).commit();
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext == null) {
      a.d("context == null return null", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        String str2 = paramContext.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
        String str1 = f(paramContext);
        if (str2 != null)
        {
          bool = str2.equals(str1);
          if (bool) {}
        }
        else
        {
          bool = true;
          a.b("updateLocalAPPKEY fail!", new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = paramContext.getSharedPreferences("DENGTA_META", 0).edit();
          paramContext.putString("APPVER_DENGTA", str1);
          paramContext.commit();
          return true;
        }
        catch (Exception paramContext)
        {
          boolean bool;
          break;
        }
        paramContext = paramContext;
        bool = false;
      }
    }
    a.a(paramContext);
    return bool;
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  public static void e(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", paramString).commit();
  }
  
  public static String f(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      int k;
      try
      {
        if (b != null)
        {
          paramContext = b;
          return paramContext;
        }
        Object localObject;
        if (paramContext == null) {
          localObject = null;
        }
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
          localObject = paramContext.versionName;
          int m = paramContext.versionCode;
          if ((localObject == null) || (((String)localObject).trim().length() <= 0))
          {
            paramContext = String.valueOf(m);
            continue;
            localObject = paramContext.getPackageName();
            continue;
          }
          paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
          localObject = paramContext.toCharArray();
          j = 0;
          if (i < localObject.length)
          {
            k = j;
            if (localObject[i] != '.') {
              break label243;
            }
            k = j + 1;
            break label243;
          }
          if (j >= 3) {
            break label240;
          }
          a.a("add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
          a.a("version: %s", new Object[] { paramContext });
        }
        catch (Exception paramContext)
        {
          a.a(paramContext);
          a.d(paramContext.toString(), new Object[0]);
          paramContext = "";
        }
        continue;
        continue;
      }
      finally {}
      label240:
      label243:
      i += 1;
      int j = k;
    }
  }
  
  private static boolean f(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramString != null)) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label160:
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label160;
        }
        int j = paramContext.length;
        int i = 0;
        if (i >= j) {
          break label160;
        }
        bool2 = paramString.equals(paramContext[i]);
        if (bool2)
        {
          bool1 = bool3;
          a.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        i += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        a.a(paramContext);
        return bool1;
      }
      finally
      {
        a.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
      }
      return false;
    }
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      a.b("Read phone state permission check! start ", new Object[0]);
      if (d == null) {
        d = Boolean.valueOf(f(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      boolean bool = d.booleanValue();
      return bool;
    }
    finally {}
  }
  
  private static boolean g(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        a.b("no running proc", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(localObject[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      a.a(paramContext);
      a.d("Failed to judge }[%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static boolean h(Context paramContext)
  {
    return g(paramContext, paramContext.getPackageName());
  }
  
  public static int i(Context paramContext)
  {
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          int i = localRunningAppProcessInfo.importance;
          return i;
        }
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String j(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          paramContext = localRunningAppProcessInfo.processName;
          c = paramContext;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      a.a(paramContext);
    }
    return "";
  }
  
  public static SharedPreferences.Editor k(Context paramContext)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.beacon.a.d.a.a;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static String a;
  public static int b = 0;
  public static String c = "";
  public static boolean d = false;
  private static Boolean e;
  private static String f;
  private static boolean g = false;
  private static String h = "";
  
  public static String a()
  {
    if (a == null) {
      a = e();
    }
    return a;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      if (TextUtils.isEmpty(f))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("on_app_first_install_time_");
        ((StringBuilder)localObject).append(c(paramContext));
        paramContext = ((StringBuilder)localObject).toString();
        localObject = com.tencent.beacon.a.d.a.a();
        long l2 = ((com.tencent.beacon.a.d.a)localObject).getLong(paramContext, 0L);
        long l1 = l2;
        if (l2 == 0L)
        {
          l1 = new Date().getTime();
          com.tencent.beacon.a.b.a.a().a(new a((com.tencent.beacon.a.d.a)localObject, paramContext, l1));
        }
        f = String.valueOf(l1);
        com.tencent.beacon.base.util.c.a("[appInfo] process: %s, getAppFirstInstallTime: %s", new Object[] { paramContext, f });
      }
      com.tencent.beacon.base.util.c.a("[appInfo] getAppFirstInstallTime: %s", new Object[] { f });
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      if (Long.parseLong(paramString) <= 10000L) {
        break label42;
      }
      h = paramString;
      return;
    }
    catch (Exception paramString)
    {
      label23:
      break label23;
    }
    com.tencent.beacon.base.util.c.e("[appInfo] set qq is not available !", new Object[0]);
    return;
    com.tencent.beacon.base.util.c.e("[appInfo] set qq is null !", new Object[0]);
    label42:
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      if (paramString.trim().length() <= 0) {
        return false;
      }
      if (!com.tencent.beacon.e.b.a().k())
      {
        com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", new Object[] { Boolean.valueOf(false) });
        return true;
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext != null) && (paramContext.size() != 0))
      {
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
              if (paramString.equals(localObject[i])) {
                return true;
              }
              i += 1;
            }
          }
        }
        return false;
      }
      com.tencent.beacon.base.util.c.e("[appInfo] no running proc", new Object[0]);
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    if (b == 0) {
      b = Process.myPid();
    }
    if (!com.tencent.beacon.e.b.a().k())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", new Object[] { Boolean.valueOf(false) });
      return -2;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if ((paramContext != null) && (paramContext.getRunningAppProcesses() != null))
    {
      paramContext = paramContext.getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == b) {
          return localRunningAppProcessInfo.importance;
        }
      }
    }
    return 0;
  }
  
  public static String b()
  {
    Object localObject = c.d().c();
    if (localObject == null) {
      return null;
    }
    String str = ((Context)localObject).getPackageName();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    return localObject;
  }
  
  /* Error */
  public static boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +161 -> 162
    //   4: aload_1
    //   5: ifnull +157 -> 162
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 193	android/os/Process:myPid	()I
    //   13: invokestatic 212	android/os/Process:myUid	()I
    //   16: invokevirtual 216	android/content/Context:checkPermission	(Ljava/lang/String;II)I
    //   19: ifne +9 -> 28
    //   22: iconst_1
    //   23: istore 4
    //   25: goto +6 -> 31
    //   28: iconst_0
    //   29: istore 4
    //   31: iload 4
    //   33: ifne +126 -> 159
    //   36: iload 4
    //   38: istore 5
    //   40: getstatic 221	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 23
    //   45: if_icmpge +70 -> 115
    //   48: aload_0
    //   49: invokevirtual 225	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   52: aload_0
    //   53: invokevirtual 207	android/content/Context:getPackageName	()Ljava/lang/String;
    //   56: sipush 4096
    //   59: invokevirtual 231	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   62: getfield 236	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   65: astore_0
    //   66: iload 4
    //   68: istore 5
    //   70: aload_0
    //   71: ifnull +44 -> 115
    //   74: aload_0
    //   75: arraylength
    //   76: istore_3
    //   77: iconst_0
    //   78: istore_2
    //   79: iload 4
    //   81: istore 5
    //   83: iload_2
    //   84: iload_3
    //   85: if_icmpge +30 -> 115
    //   88: aload_1
    //   89: aload_0
    //   90: iload_2
    //   91: aaload
    //   92: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: istore 5
    //   97: iload 5
    //   99: ifeq +9 -> 108
    //   102: iconst_1
    //   103: istore 5
    //   105: goto +10 -> 115
    //   108: iload_2
    //   109: iconst_1
    //   110: iadd
    //   111: istore_2
    //   112: goto -33 -> 79
    //   115: ldc 238
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 93	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: iload 5
    //   126: ireturn
    //   127: astore_0
    //   128: goto +20 -> 148
    //   131: astore_0
    //   132: aload_0
    //   133: invokestatic 241	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   136: ldc 238
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 93	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: iload 4
    //   147: ireturn
    //   148: ldc 238
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 93	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: athrow
    //   159: iload 4
    //   161: ireturn
    //   162: ldc 243
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 245	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: iconst_0
    //   172: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramContext	Context
    //   0	173	1	paramString	String
    //   78	34	2	i	int
    //   76	10	3	j	int
    //   23	137	4	bool1	boolean
    //   38	87	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   40	66	127	finally
    //   74	77	127	finally
    //   88	97	127	finally
    //   132	136	127	finally
    //   40	66	131	java/lang/Throwable
    //   74	77	131	java/lang/Throwable
    //   88	97	131	java/lang/Throwable
  }
  
  public static String c()
  {
    return h;
  }
  
  public static String c(Context paramContext)
  {
    return com.tencent.beacon.base.util.a.a();
  }
  
  public static String d()
  {
    if (!"".equals(c)) {
      return c;
    }
    if (b == 0) {
      b = Process.myPid();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(b);
    localStringBuilder.append("_");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(new Date().getTime());
    c = localStringBuilder.toString();
    return c;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {}
    try
    {
      com.tencent.beacon.base.util.c.b("[appInfo] context is null", new Object[0]);
      return false;
    }
    finally {}
    paramContext = com.tencent.beacon.a.d.a.a();
    String str1 = paramContext.getString("APPVER_DENGTA", "");
    String str2 = a();
    if ((str1.isEmpty()) || (!str1.equals(str2)))
    {
      bool = true;
      paramContext.edit().putString("APPVER_DENGTA", str2);
    }
    return bool;
  }
  
  public static String e()
  {
    try
    {
      Object localObject1 = b();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool) {
        return null;
      }
      Object localObject3 = c.d().c();
      try
      {
        localObject1 = ((Context)localObject3).getPackageManager().getPackageInfo((String)localObject1, 0);
        localObject3 = ((PackageInfo)localObject1).versionName;
        int m = ((PackageInfo)localObject1).versionCode;
        if ((localObject3 != null) && (((String)localObject3).trim().length() > 0))
        {
          localObject1 = ((String)localObject3).trim().replace('\n', ' ').replace('\r', ' ');
          localObject3 = ((String)localObject1).replace("|", "%7C");
          localObject1 = ((String)localObject3).toCharArray();
          int i = 0;
          int k;
          for (int j = 0; i < localObject1.length; j = k)
          {
            int n = localObject1[i];
            k = j;
            if (n == 46) {
              k = j + 1;
            }
            i += 1;
          }
          localObject1 = localObject3;
          if (j < 3)
          {
            com.tencent.beacon.base.util.c.a("[appInfo] add versionCode: %s", new Object[] { Integer.valueOf(m) });
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject3);
            ((StringBuilder)localObject1).append(".");
            ((StringBuilder)localObject1).append(m);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          com.tencent.beacon.base.util.c.a("[appInfo] final Version: %s", new Object[] { localObject1 });
          return localObject1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(m);
        localObject1 = ((StringBuilder)localObject1).toString();
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.base.util.c.a(localThrowable);
        com.tencent.beacon.base.util.c.b(localThrowable.toString(), new Object[0]);
        return "";
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  public static boolean e(Context paramContext)
  {
    return a(paramContext, paramContext.getPackageName());
  }
  
  public static void f() {}
  
  public static boolean f(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = Boolean.valueOf(b(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      paramContext = new StringBuilder();
      paramContext.append("[appInfo] Read phone state permission: ");
      paramContext.append(e);
      com.tencent.beacon.base.util.c.a(paramContext.toString(), new Object[0]);
      boolean bool = e.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public static boolean g()
  {
    boolean bool = false;
    try
    {
      com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
      String str1 = locala.getString("APPKEY_DENGTA", "");
      String str2 = c.d().f();
      if ((TextUtils.isEmpty(str1)) || (!str2.equals(str1)))
      {
        bool = true;
        locala.edit().putString("APPKEY_DENGTA", str2);
      }
      return bool;
    }
    finally {}
  }
  
  public static boolean g(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return true;
    }
    String str = c(paramContext);
    if (!TextUtils.isEmpty(str))
    {
      if (str.equals(paramContext.getPackageName())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean h()
  {
    return g;
  }
  
  private static void i()
  {
    try
    {
      com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
      String str1 = locala.getString("APPVER_DENGTA", "");
      String str2 = a();
      if ((!TextUtils.isEmpty(str1)) && (str2.equals(str1)))
      {
        g = false;
        return;
      }
      g = true;
      locala.edit().putString("APPVER_DENGTA", str2);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.base.util.c.b("[core] app version check fail!", new Object[0]);
      com.tencent.beacon.base.util.c.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.c.b
 * JD-Core Version:    0.7.0.1
 */
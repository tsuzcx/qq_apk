package com.tencent.beacon.event;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.beacon.a.c;
import com.tencent.beacon.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String g = "INSTALL_UPLOADED_DENGTA";
  private static String h = "USEAPP_UPLOADED_DENGTA";
  private Context a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private int e = 180;
  private String f = "N";
  private List<com.tencent.beacon.a.a.b> i = null;
  private Runnable j = new Runnable()
  {
    public final void run()
    {
      a.a(a.this);
    }
  };
  private Runnable k = new Runnable()
  {
    public final void run()
    {
      a.b(a.this);
    }
  };
  private Runnable l = new Runnable()
  {
    public final void run()
    {
      a.c(a.this);
    }
  };
  
  public a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.a = paramContext;
    this.c = paramBoolean1;
    this.b = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramInt;
    paramContext = n.a();
    if (paramContext != null) {
      this.f = paramContext.r();
    }
    if (this.c)
    {
      paramContext = com.tencent.beacon.a.b.b(this.a, g, "");
      if (("".equals(paramContext)) || (!f.n().equals(paramContext))) {
        break label204;
      }
      com.tencent.beacon.d.a.a("installApp list has been uploaded today! " + paramContext, new Object[0]);
    }
    for (;;)
    {
      if (this.b)
      {
        c.a().a(this.k, 60000L);
        a(true);
      }
      return;
      label204:
      c.a().a(this.j, 60000L);
    }
  }
  
  private List<com.tencent.beacon.a.a.b> b(boolean paramBoolean)
  {
    if (this.a == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject1 = (ActivityManager)this.a.getSystemService("activity");
        if (localObject1 == null) {
          break;
        }
        Object localObject3 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          continue;
        }
        localObject1 = new ArrayList();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        try
        {
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next();
          if ((localRunningAppProcessInfo.processName.startsWith("android")) || (localRunningAppProcessInfo.processName.startsWith("com.android."))) {
            continue;
          }
          if (localRunningAppProcessInfo.uid >= 10000) {
            continue;
          }
        }
        catch (Exception localException2) {}
        com.tencent.beacon.a.a.b localb = new com.tencent.beacon.a.a.b();
        localb.b = localRunningAppProcessInfo.processName;
        localb.c = localRunningAppProcessInfo.pid;
        localb.d = bool;
        ((List)localObject1).add(localb);
        continue;
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2 = null;
        continue;
        continue;
        localObject2 = null;
        continue;
        bool = true;
      }
      return localObject1;
      boolean bool = false;
      if (bool) {
        if (!paramBoolean) {}
      }
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  private List<String> c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/beacon/event/a:a	Landroid/content/Context;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 71	com/tencent/beacon/event/a:a	Landroid/content/Context;
    //   13: invokevirtual 287	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull -11 -> 7
    //   21: aload_3
    //   22: iconst_0
    //   23: invokevirtual 293	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   26: astore 4
    //   28: aload 4
    //   30: ifnull -23 -> 7
    //   33: aload 4
    //   35: invokeinterface 139 1 0
    //   40: ifle -33 -> 7
    //   43: new 205	java/util/ArrayList
    //   46: dup
    //   47: invokespecial 206	java/util/ArrayList:<init>	()V
    //   50: astore_3
    //   51: aload 4
    //   53: invokeinterface 210 1 0
    //   58: astore 4
    //   60: aload 4
    //   62: invokeinterface 216 1 0
    //   67: ifeq +210 -> 277
    //   70: aload 4
    //   72: invokeinterface 220 1 0
    //   77: checkcast 295	android/content/pm/PackageInfo
    //   80: astore 5
    //   82: aload 5
    //   84: getfield 299	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   87: getfield 304	android/content/pm/ApplicationInfo:flags	I
    //   90: iconst_1
    //   91: iand
    //   92: ifne +202 -> 294
    //   95: iconst_1
    //   96: istore_2
    //   97: goto +182 -> 279
    //   100: new 100	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   107: astore 6
    //   109: aload 6
    //   111: ldc_w 263
    //   114: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 6
    //   120: aload 5
    //   122: getfield 307	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   125: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 263
    //   131: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 6
    //   137: aload 5
    //   139: getfield 310	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 263
    //   148: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 6
    //   154: aload 5
    //   156: getfield 313	android/content/pm/PackageInfo:versionCode	I
    //   159: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: ldc_w 263
    //   165: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: getstatic 318	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   172: invokestatic 324	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   175: bipush 9
    //   177: if_icmpge +48 -> 225
    //   180: aload 6
    //   182: ldc_w 263
    //   185: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 6
    //   191: ldc_w 263
    //   194: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: iload_2
    //   199: ifeq +63 -> 262
    //   202: aload 6
    //   204: ldc 54
    //   206: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_3
    //   211: aload 6
    //   213: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokeinterface 250 2 0
    //   221: pop
    //   222: goto -162 -> 60
    //   225: aload 6
    //   227: aload 5
    //   229: getfield 328	android/content/pm/PackageInfo:firstInstallTime	J
    //   232: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: ldc_w 263
    //   238: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 6
    //   244: aload 5
    //   246: getfield 334	android/content/pm/PackageInfo:lastUpdateTime	J
    //   249: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: ldc_w 263
    //   255: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: goto -61 -> 198
    //   262: aload 6
    //   264: ldc_w 261
    //   267: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: goto -61 -> 210
    //   274: astore_3
    //   275: aconst_null
    //   276: areturn
    //   277: aload_3
    //   278: areturn
    //   279: iload_1
    //   280: ifne -180 -> 100
    //   283: iload_2
    //   284: ifeq -224 -> 60
    //   287: goto -187 -> 100
    //   290: astore 4
    //   292: aload_3
    //   293: areturn
    //   294: iconst_0
    //   295: istore_2
    //   296: goto -17 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	a
    //   0	299	1	paramBoolean	boolean
    //   96	200	2	m	int
    //   16	195	3	localObject1	Object
    //   274	19	3	localException1	Exception
    //   26	45	4	localObject2	Object
    //   290	1	4	localException2	Exception
    //   80	165	5	localPackageInfo	android.content.pm.PackageInfo
    //   107	156	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	17	274	java/lang/Exception
    //   21	28	274	java/lang/Exception
    //   33	51	274	java/lang/Exception
    //   51	60	290	java/lang/Exception
    //   60	95	290	java/lang/Exception
    //   100	198	290	java/lang/Exception
    //   202	210	290	java/lang/Exception
    //   210	222	290	java/lang/Exception
    //   225	259	290	java/lang/Exception
    //   262	271	290	java/lang/Exception
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c.a().a(110, this.l, this.e * 1000, this.e * 1000);
      return;
    }
    c.a().a(110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.a
 * JD-Core Version:    0.7.0.1
 */
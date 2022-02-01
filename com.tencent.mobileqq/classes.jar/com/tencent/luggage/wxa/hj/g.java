package com.tencent.luggage.wxa.hj;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Method;
import junit.framework.a;

public class g
{
  private static Context a;
  private static String b;
  
  public static Context a()
  {
    a.a("IPCInvoker not initialize.", a);
    return a;
  }
  
  /* Error */
  public static String a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: ldc 24
    //   9: invokevirtual 30	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 32	android/app/ActivityManager
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +68 -> 85
    //   20: aload_0
    //   21: invokevirtual 36	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +59 -> 85
    //   29: aload_0
    //   30: invokeinterface 42 1 0
    //   35: ifne +50 -> 85
    //   38: aload_0
    //   39: invokeinterface 46 1 0
    //   44: astore_0
    //   45: aload_0
    //   46: invokeinterface 51 1 0
    //   51: ifeq +34 -> 85
    //   54: aload_0
    //   55: invokeinterface 55 1 0
    //   60: checkcast 57	android/app/ActivityManager$RunningAppProcessInfo
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull -22 -> 45
    //   70: aload 4
    //   72: getfield 61	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   75: iload_1
    //   76: if_icmpne -31 -> 45
    //   79: aload 4
    //   81: getfield 64	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: areturn
    //   85: sipush 128
    //   88: newarray byte
    //   90: astore 5
    //   92: new 66	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   99: astore_0
    //   100: aload_0
    //   101: ldc 72
    //   103: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: iload_1
    //   109: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_0
    //   114: ldc 81
    //   116: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new 83	java/io/FileInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   131: astore_0
    //   132: aload_0
    //   133: astore 4
    //   135: aload_0
    //   136: aload 5
    //   138: invokevirtual 94	java/io/FileInputStream:read	([B)I
    //   141: istore_3
    //   142: aload_0
    //   143: astore 4
    //   145: iload_3
    //   146: ifle +31 -> 177
    //   149: iconst_0
    //   150: istore_1
    //   151: goto +114 -> 265
    //   154: aload_0
    //   155: astore 4
    //   157: new 96	java/lang/String
    //   160: dup
    //   161: aload 5
    //   163: iconst_0
    //   164: iload_2
    //   165: invokespecial 99	java/lang/String:<init>	([BII)V
    //   168: astore 5
    //   170: aload_0
    //   171: invokevirtual 102	java/io/FileInputStream:close	()V
    //   174: aload 5
    //   176: areturn
    //   177: aload 4
    //   179: invokevirtual 102	java/io/FileInputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore 5
    //   186: goto +14 -> 200
    //   189: astore_0
    //   190: aconst_null
    //   191: astore 4
    //   193: goto +42 -> 235
    //   196: astore 5
    //   198: aconst_null
    //   199: astore_0
    //   200: aload_0
    //   201: astore 4
    //   203: ldc 104
    //   205: ldc 106
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 5
    //   215: invokestatic 112	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 117	com/tencent/luggage/wxa/hs/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: aload_0
    //   223: ifnull +9 -> 232
    //   226: aload_0
    //   227: astore 4
    //   229: goto -52 -> 177
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 102	java/io/FileInputStream:close	()V
    //   245: goto +5 -> 250
    //   248: aload_0
    //   249: athrow
    //   250: goto -2 -> 248
    //   253: astore_0
    //   254: aload 5
    //   256: areturn
    //   257: astore_0
    //   258: aconst_null
    //   259: areturn
    //   260: astore 4
    //   262: goto -17 -> 245
    //   265: iload_3
    //   266: istore_2
    //   267: iload_1
    //   268: iload_3
    //   269: if_icmpge -115 -> 154
    //   272: aload 5
    //   274: iload_1
    //   275: baload
    //   276: sipush 128
    //   279: if_icmpgt +20 -> 299
    //   282: aload 5
    //   284: iload_1
    //   285: baload
    //   286: ifgt +6 -> 292
    //   289: goto +10 -> 299
    //   292: iload_1
    //   293: iconst_1
    //   294: iadd
    //   295: istore_1
    //   296: goto -31 -> 265
    //   299: iload_1
    //   300: istore_2
    //   301: goto -147 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramInt	int
    //   164	137	2	i	int
    //   141	129	3	j	int
    //   63	178	4	localObject1	Object
    //   260	1	4	localException1	Exception
    //   90	85	5	localObject2	Object
    //   184	1	5	localException2	Exception
    //   196	87	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   135	142	184	java/lang/Exception
    //   157	170	184	java/lang/Exception
    //   92	132	189	finally
    //   92	132	196	java/lang/Exception
    //   135	142	234	finally
    //   157	170	234	finally
    //   203	222	234	finally
    //   170	174	253	java/lang/Exception
    //   177	182	257	java/lang/Exception
    //   240	245	260	java/lang/Exception
  }
  
  static void a(Context paramContext)
  {
    a = paramContext;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.equals(b()));
  }
  
  public static String b()
  {
    String str = b;
    if ((str == null) || (str.length() == 0)) {
      b = b(a);
    }
    return b;
  }
  
  public static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Application.getProcessName();
    }
    try
    {
      String str = c();
      return str;
    }
    catch (Exception localException)
    {
      label18:
      break label18;
    }
    return a(paramContext, Process.myPid());
  }
  
  @SuppressLint({"PrivateApi"})
  private static String c()
  {
    Object localObject = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
    ((Method)localObject).setAccessible(true);
    String str = null;
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if ((localObject instanceof String)) {
      str = (String)localObject;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.g
 * JD-Core Version:    0.7.0.1
 */
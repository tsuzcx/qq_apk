package com.tencent.beacon.d;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.a.c;
import com.tencent.beacon.a.c.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.event.UserAction;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class a
  extends com.tencent.beacon.a.a
{
  private static a b;
  private boolean c = true;
  
  private a(Context paramContext)
  {
    super(paramContext);
  }
  
  private long A()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)this.a.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[model] getFreeMem error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return -1L;
  }
  
  private String B()
  {
    try
    {
      Object localObject = ((WifiManager)this.a.getSystemService("wifi")).getConnectionInfo();
      if (((WifiInfo)localObject).getBSSID() != null)
      {
        localObject = ((WifiInfo)localObject).getSSID();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.a(localThrowable);
      com.tencent.beacon.a.g.a.d("[model] getWifiSSID error!", new Object[0]);
    }
    return "";
  }
  
  public static String g()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[model] getLanguage error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return null;
  }
  
  public static a j(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new a(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private static String o()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[model] getCountry error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return null;
  }
  
  private String p()
  {
    Object localObject3 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i;
      try
      {
        localClass = Class.forName("android.hardware.Camera");
        j = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (j == 0)
        {
          localObject1 = "N";
          localObject2 = "N";
        }
      }
      catch (Throwable localThrowable1)
      {
        Class localClass;
        int j;
        Object localObject4;
        Object localObject6;
        Object localObject7;
        int k;
        Field localField1;
        Field localField2;
        Field localField3;
        int m;
        int n;
        localObject2 = "X";
        localObject1 = "X";
        com.tencent.beacon.a.g.a.d("[model] getSensor error!", new Object[0]);
        com.tencent.beacon.a.g.a.a(localThrowable1);
        Object localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = "X";
        continue;
        continue;
        localObject1 = "X";
        localObject2 = "X";
        continue;
      }
      try
      {
        localObject4 = (SensorManager)this.a.getSystemService("sensor");
        if (((SensorManager)localObject4).getDefaultSensor(9) != null) {
          localObject3 = "Y";
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject3 = localObject2;
        localObject2 = "X";
        continue;
      }
      try
      {
        if (((SensorManager)localObject4).getDefaultSensor(4) != null)
        {
          localObject6 = "Y";
          localObject4 = localObject2;
          localObject2 = localObject6;
          localStringBuffer.append((String)localObject1).append((String)localObject4).append((String)localObject3).append((String)localObject2);
          return localStringBuffer.toString();
          localObject2 = Class.forName("android.hardware.Camera$CameraInfo");
          localObject7 = ((Class)localObject2).newInstance();
          localObject6 = localClass.getMethods();
          localObject1 = null;
          k = localObject6.length;
          i = 0;
          localObject4 = localObject1;
          if (i < k)
          {
            localObject4 = localObject6[i];
            if (!((Method)localObject4).getName().equals("getCameraInfo")) {
              break label526;
            }
          }
          localField1 = ((Class)localObject2).getField("facing");
          localField2 = ((Class)localObject2).getField("CAMERA_FACING_BACK");
          localField3 = ((Class)localObject2).getField("CAMERA_FACING_FRONT");
          if (localObject4 == null) {
            continue;
          }
          localObject2 = "X";
          localObject1 = "X";
          i = 0;
          if (i >= j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        localObject6 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject6;
        continue;
      }
      try
      {
        ((Method)localObject4).invoke(localClass, new Object[] { Integer.valueOf(i), localObject7 });
        k = localField1.getInt(localObject7);
        m = localField2.getInt(localObject7);
        n = localField3.getInt(localObject7);
        if (k == m)
        {
          localObject1 = "Y";
          localObject3 = localObject1;
          if (j == 1)
          {
            localObject2 = "N";
            localObject3 = localObject1;
          }
        }
        else
        {
          localObject3 = localObject1;
          if (k == n)
          {
            localObject6 = "Y";
            localObject2 = localObject6;
            localObject3 = localObject1;
            if (j == 1)
            {
              localObject3 = "N";
              localObject2 = localObject6;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = localObject2;
        localObject2 = "X";
        continue;
      }
      localObject3 = "N";
      continue;
      localObject6 = "N";
      localObject4 = localObject2;
      Object localObject2 = localObject6;
      continue;
      localObject2 = "X";
      String str = "X";
      localObject3 = "X";
      Object localObject1 = "X";
      continue;
      i += 1;
      localObject1 = localObject3;
      continue;
      label526:
      i += 1;
    }
  }
  
  /* Error */
  private static String q()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 311	java/io/FileReader
    //   6: dup
    //   7: ldc_w 313
    //   10: invokespecial 316	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 318	java/io/BufferedReader
    //   17: dup
    //   18: aload_3
    //   19: sipush 8192
    //   22: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore 5
    //   29: aload_3
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 324	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: ldc_w 326
    //   39: iconst_2
    //   40: invokevirtual 330	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   43: iconst_1
    //   44: aaload
    //   45: invokevirtual 333	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: ldc_w 335
    //   51: ldc 87
    //   53: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 348	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   62: ldc2_w 191
    //   65: ldiv
    //   66: lstore_0
    //   67: lload_0
    //   68: invokestatic 351	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   71: astore 4
    //   73: aload_2
    //   74: invokevirtual 354	java/io/BufferedReader:close	()V
    //   77: aload_3
    //   78: invokevirtual 355	java/io/FileReader:close	()V
    //   81: aload 4
    //   83: astore_2
    //   84: aload_2
    //   85: areturn
    //   86: astore_2
    //   87: ldc_w 357
    //   90: iconst_0
    //   91: anewarray 54	java/lang/Object
    //   94: invokestatic 60	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_2
    //   98: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   101: aload 4
    //   103: areturn
    //   104: astore 6
    //   106: aconst_null
    //   107: astore_2
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_2
    //   111: astore 5
    //   113: aload_3
    //   114: astore 4
    //   116: ldc_w 359
    //   119: iconst_0
    //   120: anewarray 54	java/lang/Object
    //   123: invokestatic 60	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_2
    //   127: astore 5
    //   129: aload_3
    //   130: astore 4
    //   132: aload 6
    //   134: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 354	java/io/BufferedReader:close	()V
    //   145: aload 7
    //   147: astore_2
    //   148: aload_3
    //   149: ifnull -65 -> 84
    //   152: aload_3
    //   153: invokevirtual 355	java/io/FileReader:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_2
    //   159: ldc_w 357
    //   162: iconst_0
    //   163: anewarray 54	java/lang/Object
    //   166: invokestatic 60	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_2
    //   170: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_2
    //   176: aconst_null
    //   177: astore 5
    //   179: aconst_null
    //   180: astore_3
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 354	java/io/BufferedReader:close	()V
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 355	java/io/FileReader:close	()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_3
    //   202: ldc_w 357
    //   205: iconst_0
    //   206: anewarray 54	java/lang/Object
    //   209: invokestatic 60	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_3
    //   213: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   216: goto -17 -> 199
    //   219: astore_2
    //   220: aconst_null
    //   221: astore 5
    //   223: goto -42 -> 181
    //   226: astore_2
    //   227: aload 4
    //   229: astore_3
    //   230: goto -49 -> 181
    //   233: astore 6
    //   235: aconst_null
    //   236: astore_2
    //   237: goto -127 -> 110
    //   240: astore 6
    //   242: goto -132 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	2	0	l	long
    //   25	60	2	localObject1	Object
    //   86	12	2	localThrowable1	Throwable
    //   107	41	2	localObject2	Object
    //   158	12	2	localThrowable2	Throwable
    //   175	25	2	localObject3	Object
    //   219	1	2	localObject4	Object
    //   226	1	2	localObject5	Object
    //   236	1	2	localObject6	Object
    //   13	183	3	localFileReader	java.io.FileReader
    //   201	12	3	localThrowable3	Throwable
    //   229	1	3	localObject7	Object
    //   30	198	4	localObject8	Object
    //   27	195	5	localObject9	Object
    //   104	29	6	localThrowable4	Throwable
    //   233	1	6	localThrowable5	Throwable
    //   240	1	6	localThrowable6	Throwable
    //   1	145	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   73	81	86	java/lang/Throwable
    //   3	14	104	java/lang/Throwable
    //   141	145	158	java/lang/Throwable
    //   152	156	158	java/lang/Throwable
    //   3	14	175	finally
    //   186	191	201	java/lang/Throwable
    //   195	199	201	java/lang/Throwable
    //   14	26	219	finally
    //   32	67	226	finally
    //   116	126	226	finally
    //   132	137	226	finally
    //   14	26	233	java/lang/Throwable
    //   32	67	240	java/lang/Throwable
  }
  
  private static String r()
  {
    String str = null;
    try
    {
      Object localObject = Build.class.getField("HARDWARE").get(null);
      if (localObject != null) {
        str = localObject.toString();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[model] get cpu product error!", new Object[0]);
    }
    return null;
  }
  
  private DisplayMetrics s()
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[model] getDisplayMetrics error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return null;
  }
  
  private long t()
  {
    e.a(this.a);
    if (!Environment.getExternalStorageState().equals("mounted")) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      long l = localStatFs.getBlockCount();
      l = i * l / 1024L / 1024L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return 0L;
  }
  
  private int u()
  {
    for (;;)
    {
      try
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (localDisplayMetrics.density == 1.0F) {
          return 160;
        }
        if (localDisplayMetrics.density <= 0.75D) {
          return 120;
        }
        if (localDisplayMetrics.density == 1.5D) {
          return 240;
        }
        if (localDisplayMetrics.density == 2.0D) {
          return 320;
        }
        float f = localDisplayMetrics.density;
        if (f == 3.0D)
        {
          i = 480;
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
        return 160;
      }
      int i = 160;
    }
  }
  
  /* Error */
  private static int v()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: aconst_null
    //   5: astore_2
    //   6: new 318	java/io/BufferedReader
    //   9: dup
    //   10: new 433	java/io/InputStreamReader
    //   13: dup
    //   14: invokestatic 439	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: iconst_2
    //   18: anewarray 284	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc_w 441
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 443
    //   32: aastore
    //   33: invokevirtual 447	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   36: invokevirtual 453	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 456	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 459	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: invokevirtual 324	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +18 -> 74
    //   59: aload_3
    //   60: astore_2
    //   61: aload 4
    //   63: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   66: invokestatic 232	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   69: sipush 1000
    //   72: idiv
    //   73: istore_0
    //   74: aload_3
    //   75: invokevirtual 354	java/io/BufferedReader:close	()V
    //   78: iload_0
    //   79: ireturn
    //   80: astore_2
    //   81: aload_2
    //   82: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   85: iload_0
    //   86: ireturn
    //   87: astore 4
    //   89: aconst_null
    //   90: astore_3
    //   91: aload_3
    //   92: astore_2
    //   93: aload 4
    //   95: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   98: iload_1
    //   99: istore_0
    //   100: aload_3
    //   101: ifnull -23 -> 78
    //   104: aload_3
    //   105: invokevirtual 354	java/io/BufferedReader:close	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_2
    //   111: aload_2
    //   112: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore 4
    //   119: aload_2
    //   120: astore_3
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 354	java/io/BufferedReader:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore_3
    //   135: aload_3
    //   136: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   139: goto -7 -> 132
    //   142: astore 4
    //   144: aload_2
    //   145: astore_3
    //   146: aload 4
    //   148: astore_2
    //   149: goto -25 -> 124
    //   152: astore 4
    //   154: goto -63 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	97	0	i	int
    //   1	98	1	j	int
    //   5	56	2	localObject1	Object
    //   80	2	2	localIOException1	java.io.IOException
    //   92	1	2	localObject2	Object
    //   110	10	2	localIOException2	java.io.IOException
    //   123	26	2	localObject3	Object
    //   45	84	3	localObject4	Object
    //   134	2	3	localIOException3	java.io.IOException
    //   145	1	3	localObject5	Object
    //   52	10	4	str	String
    //   87	7	4	localThrowable1	Throwable
    //   117	5	4	localObject6	Object
    //   142	5	4	localObject7	Object
    //   152	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/io/IOException
    //   6	46	87	java/lang/Throwable
    //   104	108	110	java/io/IOException
    //   6	46	117	finally
    //   128	132	134	java/io/IOException
    //   48	54	142	finally
    //   61	74	142	finally
    //   93	98	142	finally
    //   48	54	152	java/lang/Throwable
    //   61	74	152	java/lang/Throwable
  }
  
  private static int w()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new a());
      if (arrayOfFile == null) {
        return 1;
      }
      int i = arrayOfFile.length;
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.a.g.a.d("[model] CPU Count: Failed.", new Object[0]);
      com.tencent.beacon.a.g.a.a(localException);
    }
    return 1;
  }
  
  /* Error */
  private static String x()
  {
    // Byte code:
    //   0: ldc 87
    //   2: astore_2
    //   3: new 318	java/io/BufferedReader
    //   6: dup
    //   7: new 433	java/io/InputStreamReader
    //   10: dup
    //   11: invokestatic 439	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: iconst_2
    //   15: anewarray 284	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 441
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 473
    //   29: aastore
    //   30: invokevirtual 447	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   33: invokevirtual 453	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: invokespecial 456	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 459	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 324	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: ifnull +36 -> 89
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: ldc_w 475
    //   62: invokevirtual 478	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq -22 -> 43
    //   68: aload_1
    //   69: astore_0
    //   70: aload_3
    //   71: aload_3
    //   72: ldc_w 480
    //   75: invokevirtual 483	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   78: iconst_1
    //   79: iadd
    //   80: invokevirtual 487	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: invokevirtual 342	java/lang/String:trim	()Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_0
    //   89: aload_1
    //   90: invokevirtual 354	java/io/BufferedReader:close	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_3
    //   108: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   111: aload_2
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull -21 -> 93
    //   117: aload_1
    //   118: invokevirtual 354	java/io/BufferedReader:close	()V
    //   121: ldc 87
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   129: ldc 87
    //   131: areturn
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 354	java/io/BufferedReader:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: aload_0
    //   147: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   150: goto -7 -> 143
    //   153: astore_1
    //   154: goto -19 -> 135
    //   157: astore_3
    //   158: goto -53 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	69	0	localObject1	Object
    //   124	2	0	localIOException1	java.io.IOException
    //   134	6	0	localObject2	Object
    //   145	2	0	localIOException2	java.io.IOException
    //   42	48	1	localBufferedReader	java.io.BufferedReader
    //   95	2	1	localIOException3	java.io.IOException
    //   104	14	1	localObject3	Object
    //   132	12	1	localObject4	Object
    //   153	1	1	localObject5	Object
    //   2	110	2	str1	String
    //   49	39	3	str2	String
    //   102	6	3	localThrowable1	Throwable
    //   157	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   89	93	95	java/io/IOException
    //   3	43	102	java/lang/Throwable
    //   117	121	124	java/io/IOException
    //   3	43	132	finally
    //   139	143	145	java/io/IOException
    //   45	50	153	finally
    //   58	68	153	finally
    //   70	87	153	finally
    //   107	111	153	finally
    //   45	50	157	java/lang/Throwable
    //   58	68	157	java/lang/Throwable
    //   70	87	157	java/lang/Throwable
  }
  
  /* Error */
  private static boolean y()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: new 318	java/io/BufferedReader
    //   10: dup
    //   11: new 433	java/io/InputStreamReader
    //   14: dup
    //   15: invokestatic 439	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: iconst_2
    //   19: anewarray 284	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 441
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc_w 473
    //   33: aastore
    //   34: invokevirtual 447	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   37: invokevirtual 453	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 456	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: invokespecial 459	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 5
    //   48: aload 5
    //   50: astore 4
    //   52: aload 5
    //   54: invokevirtual 324	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 6
    //   59: iload_2
    //   60: istore_1
    //   61: aload 6
    //   63: ifnull +26 -> 89
    //   66: aload 5
    //   68: astore 4
    //   70: aload 6
    //   72: invokevirtual 333	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   75: ldc_w 489
    //   78: invokevirtual 483	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   81: istore_0
    //   82: iconst_m1
    //   83: iload_0
    //   84: if_icmpeq -36 -> 48
    //   87: iconst_1
    //   88: istore_1
    //   89: aload 5
    //   91: invokevirtual 354	java/io/BufferedReader:close	()V
    //   94: iload_1
    //   95: ireturn
    //   96: astore 4
    //   98: aload 4
    //   100: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   103: iload_1
    //   104: ireturn
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: aload 5
    //   112: astore 4
    //   114: aload 6
    //   116: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   119: iload_3
    //   120: istore_1
    //   121: aload 5
    //   123: ifnull -29 -> 94
    //   126: aload 5
    //   128: invokevirtual 354	java/io/BufferedReader:close	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore 4
    //   135: aload 4
    //   137: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore 6
    //   144: aload 4
    //   146: astore 5
    //   148: aload 6
    //   150: astore 4
    //   152: aload 5
    //   154: ifnull +8 -> 162
    //   157: aload 5
    //   159: invokevirtual 354	java/io/BufferedReader:close	()V
    //   162: aload 4
    //   164: athrow
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 63	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   172: goto -10 -> 162
    //   175: astore 6
    //   177: aload 4
    //   179: astore 5
    //   181: aload 6
    //   183: astore 4
    //   185: goto -33 -> 152
    //   188: astore 6
    //   190: goto -80 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	4	0	i	int
    //   60	61	1	bool1	boolean
    //   3	57	2	bool2	boolean
    //   1	119	3	bool3	boolean
    //   5	64	4	localObject1	Object
    //   96	3	4	localIOException1	java.io.IOException
    //   112	1	4	localObject2	Object
    //   133	12	4	localIOException2	java.io.IOException
    //   150	34	4	localObject3	Object
    //   46	112	5	localObject4	Object
    //   165	3	5	localIOException3	java.io.IOException
    //   179	1	5	localObject5	Object
    //   57	14	6	str	String
    //   105	10	6	localThrowable1	Throwable
    //   142	7	6	localObject6	Object
    //   175	7	6	localObject7	Object
    //   188	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   89	94	96	java/io/IOException
    //   7	48	105	java/lang/Throwable
    //   126	131	133	java/io/IOException
    //   7	48	142	finally
    //   157	162	165	java/io/IOException
    //   52	59	175	finally
    //   70	82	175	finally
    //   114	119	175	finally
    //   52	59	188	java/lang/Throwable
    //   70	82	188	java/lang/Throwable
  }
  
  private String z()
  {
    Object localObject1 = "X";
    Object localObject2 = "X";
    Object localObject3 = "X";
    int i;
    String str2;
    label35:
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if ((WifiManager)this.a.getSystemService("wifi") != null)
    {
      i = 1;
      if (i == 0) {
        break label220;
      }
      str2 = "Y";
      if (Integer.parseInt(Build.VERSION.SDK) < 10) {
        break label288;
      }
      localObject4 = localObject3;
      localObject6 = localObject2;
      localObject5 = localObject1;
    }
    for (;;)
    {
      try
      {
        SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(1) == null) {
          continue;
        }
        localObject1 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(5) == null) {
          break label305;
        }
        localObject2 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
          break label311;
        }
        localObject3 = "N";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (!this.a.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
          continue;
        }
        localObject6 = "Y";
        localObject5 = localObject3;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject5;
        localObject1 = localObject6;
      }
      catch (Throwable localThrowable)
      {
        label220:
        localObject3 = localObject6;
        com.tencent.beacon.a.g.a.d("[model] getSensor2 error!", new Object[0]);
        localObject2 = localObject4;
        str1 = "X";
        localObject4 = localObject5;
        continue;
      }
      return str2 + (String)localObject4 + (String)localObject3 + (String)localObject2 + (String)localObject1;
      i = 0;
      break;
      str2 = "N";
      break label35;
      localObject1 = "N";
      continue;
      localObject6 = "N";
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject1 = localObject6;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      continue;
      label288:
      String str1 = "X";
      localObject2 = "X";
      localObject3 = "X";
      localObject4 = "X";
      continue;
      label305:
      localObject2 = "N";
      continue;
      label311:
      localObject3 = "Y";
    }
  }
  
  public final void a(int paramInt, Map<String, String> paramMap)
  {
    super.a(paramInt, paramMap);
    if (paramInt == 1) {
      this.c = com.tencent.beacon.a.a.a((String)paramMap.get("modelEventUsable"), this.c);
    }
  }
  
  public final void c()
  {
    super.c();
    com.tencent.beacon.a.g.a.a("[module] model module > %S", new Object[] { this.c });
    c localc;
    if (this.c) {
      localc = c.a(this.a);
    }
    try
    {
      localObject = localc.a("rqd_model", "");
      boolean bool = com.tencent.beacon.a.a.f().equals(localObject);
      if (bool) {
        return;
      }
    }
    catch (Exception localException1)
    {
      com.tencent.beacon.a.g.a.d("[model] get upload flag failed! ", new Object[0]);
      return;
    }
    Object localObject = new Runnable()
    {
      public final void run()
      {
        if (d.a(a.a(a.this)) == null)
        {
          com.tencent.beacon.a.g.a.d("[model] detail user info is null.", new Object[0]);
          return;
        }
        e.a(a.b(a.this));
        HashMap localHashMap = new HashMap();
        localHashMap.put("A9", e.e());
        localHashMap.put("A10", e.b());
        localHashMap.put("A11", a.h());
        localHashMap.put("A12", a.g());
        localHashMap.put("A13", a.c(a.this));
        localHashMap.put("A14", e.f() + "m");
        localHashMap.put("A15", a.i() + "m");
        localHashMap.put("A16", a.j());
        localHashMap.put("A17", a.d(a.this));
        localHashMap.put("A18", "");
        localHashMap.put("A20", e.f(a.e(a.this)));
        localHashMap.put("A22", a.f(a.this));
        localHashMap.put("A30", a.g(a.this) + "m");
        localHashMap.put("A33", e.i(a.h(a.this)));
        localHashMap.put("A52", a.i(a.this));
        localHashMap.put("A53", a.k() + "m");
        localHashMap.put("A54", a.l());
        localHashMap.put("A55", a.m());
        if (a.n())
        {
          localObject = "Y";
          localHashMap.put("A56", localObject);
          localHashMap.put("A57", a.j(a.this));
          if (!com.tencent.beacon.a.g.b.a().b()) {
            break label571;
          }
          localObject = "Y";
          label436:
          localHashMap.put("A58", localObject);
          localHashMap.put("A59", a.k(a.this) + "m");
          localHashMap.put("A69", a.l(a.this));
          localObject = com.tencent.beacon.a.a.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label577;
          }
        }
        label571:
        label577:
        for (Object localObject = (String)((List)localObject).get(0);; localObject = "")
        {
          localHashMap.put("A82", localObject);
          UserAction.onUserAction("rqd_model", true, 0L, 0L, localHashMap, true);
          return;
          localObject = "N";
          break;
          localObject = "N";
          break label436;
        }
      }
    };
    com.tencent.beacon.a.a.b.a().a((Runnable)localObject, 50000L);
    try
    {
      localException1.a().a("rqd_model", com.tencent.beacon.a.a.f()).b();
      return;
    }
    catch (Exception localException2)
    {
      com.tencent.beacon.a.g.a.d("[model] save upload flag failed!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localException2);
    }
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.d.a
 * JD-Core Version:    0.7.0.1
 */
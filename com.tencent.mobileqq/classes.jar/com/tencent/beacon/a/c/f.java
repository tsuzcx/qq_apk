package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.base.net.c.e.a;
import com.tencent.beacon.e.a;
import com.tencent.qmsp.sdk.u.U;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public class f
  implements e.a
{
  protected static f a = new f();
  private final Context b = c.d().c();
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  
  private f()
  {
    com.tencent.beacon.base.net.c.e.a(this.b, this);
    P();
    O();
  }
  
  private void O()
  {
    boolean bool = com.tencent.beacon.base.util.b.a(a.a().a("storageOAID"), true);
    try
    {
      U.init_o(this.b, bool, com.tencent.beacon.base.util.c.a());
      U.getOAID(new d(this));
      this.m = U.getOAIDSync(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
  }
  
  private void P()
  {
    this.l = Q();
  }
  
  private String Q()
  {
    Object localObject3 = "unknown";
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = this.b;
        localObject1 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
        if (localObject1 == null) {
          return "unknown";
        }
        Object localObject4 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject4 == null) {
          return "unknown";
        }
        int n = ((NetworkInfo)localObject4).getType();
        if (n == 1)
        {
          localObject1 = "wifi";
        }
        else
        {
          localObject1 = localObject3;
          if (((NetworkInfo)localObject4).getType() == 0)
          {
            localObject1 = this.b;
            localObject4 = (TelephonyManager)((Context)localObject1).getSystemService("phone");
            localObject1 = localObject3;
            if (localObject4 != null) {
              switch (((TelephonyManager)localObject4).getNetworkType())
              {
              case 13: 
                continue;
                localObject1 = "4G";
                break;
              case 3: 
              case 5: 
              case 6: 
              case 8: 
              case 9: 
              case 10: 
              case 12: 
              case 14: 
              case 15: 
                localObject1 = "3G";
                break;
              case 1: 
              case 2: 
              case 4: 
              case 7: 
              case 11: 
                localObject1 = "2G";
                break label229;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("unknown_");
                ((StringBuilder)localObject1).append(((TelephonyManager)localObject4).getNetworkType());
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.base.util.c.a(localException);
        localObject2 = localObject3;
      }
      label229:
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[DeviceInfo] NetWork Type:");
      ((StringBuilder)localObject3).append(localObject2);
      com.tencent.beacon.base.util.c.a(((StringBuilder)localObject3).toString(), new Object[0]);
      return localObject2;
    }
  }
  
  private StringBuilder a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfByte.length;
    int n = 0;
    while (n < i1)
    {
      localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfByte[n]) }));
      n += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder;
  }
  
  public static f p()
  {
    try
    {
      f localf = a;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String A()
  {
    // Byte code:
    //   0: new 210	java/io/FileReader
    //   3: dup
    //   4: ldc 212
    //   6: invokespecial 215	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: new 217	java/io/BufferedReader
    //   14: dup
    //   15: aload 4
    //   17: sipush 8192
    //   20: invokespecial 220	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   23: astore_3
    //   24: aload_3
    //   25: astore 6
    //   27: aload 4
    //   29: astore 5
    //   31: aload_3
    //   32: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore 7
    //   37: aload 7
    //   39: ifnull +141 -> 180
    //   42: aload_3
    //   43: astore 6
    //   45: aload 4
    //   47: astore 5
    //   49: aload 7
    //   51: ldc 225
    //   53: iconst_2
    //   54: invokevirtual 229	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   57: iconst_1
    //   58: aaload
    //   59: invokevirtual 232	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   62: astore 7
    //   64: aload_3
    //   65: astore 6
    //   67: aload 4
    //   69: astore 5
    //   71: aload 7
    //   73: ldc 234
    //   75: ldc 33
    //   77: invokevirtual 238	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   80: invokevirtual 241	java/lang/String:trim	()Ljava/lang/String;
    //   83: invokestatic 247	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   86: ldc2_w 248
    //   89: ldiv
    //   90: lstore_1
    //   91: aload_3
    //   92: astore 6
    //   94: aload 4
    //   96: astore 5
    //   98: new 165	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   105: astore 7
    //   107: aload_3
    //   108: astore 6
    //   110: aload 4
    //   112: astore 5
    //   114: aload 7
    //   116: lload_1
    //   117: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_3
    //   122: astore 6
    //   124: aload 4
    //   126: astore 5
    //   128: aload 7
    //   130: ldc 33
    //   132: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_3
    //   137: astore 6
    //   139: aload 4
    //   141: astore 5
    //   143: aload 7
    //   145: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore 7
    //   150: aload_3
    //   151: invokevirtual 255	java/io/BufferedReader:close	()V
    //   154: aload 4
    //   156: invokevirtual 256	java/io/FileReader:close	()V
    //   159: aload 7
    //   161: areturn
    //   162: astore_3
    //   163: ldc_w 258
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_3
    //   174: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   177: aload 7
    //   179: areturn
    //   180: aload_3
    //   181: invokevirtual 255	java/io/BufferedReader:close	()V
    //   184: aload 4
    //   186: invokevirtual 256	java/io/FileReader:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_3
    //   192: ldc_w 258
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: aload_3
    //   203: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   206: aconst_null
    //   207: areturn
    //   208: astore_3
    //   209: aload 5
    //   211: astore 4
    //   213: goto +108 -> 321
    //   216: astore 7
    //   218: goto +35 -> 253
    //   221: astore_3
    //   222: aconst_null
    //   223: astore 6
    //   225: goto +96 -> 321
    //   228: astore 7
    //   230: aconst_null
    //   231: astore_3
    //   232: goto +21 -> 253
    //   235: astore_3
    //   236: aconst_null
    //   237: astore 6
    //   239: aload 6
    //   241: astore 4
    //   243: goto +78 -> 321
    //   246: astore 7
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_3
    //   251: astore 4
    //   253: aload_3
    //   254: astore 6
    //   256: aload 4
    //   258: astore 5
    //   260: ldc_w 262
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_3
    //   271: astore 6
    //   273: aload 4
    //   275: astore 5
    //   277: aload 7
    //   279: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   282: aload_3
    //   283: ifnull +10 -> 293
    //   286: aload_3
    //   287: invokevirtual 255	java/io/BufferedReader:close	()V
    //   290: goto +3 -> 293
    //   293: aload 4
    //   295: ifnull +24 -> 319
    //   298: aload 4
    //   300: invokevirtual 256	java/io/FileReader:close	()V
    //   303: aconst_null
    //   304: areturn
    //   305: ldc_w 258
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: aload_3
    //   316: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   319: aconst_null
    //   320: areturn
    //   321: aload 6
    //   323: ifnull +11 -> 334
    //   326: aload 6
    //   328: invokevirtual 255	java/io/BufferedReader:close	()V
    //   331: goto +3 -> 334
    //   334: aload 4
    //   336: ifnull +26 -> 362
    //   339: aload 4
    //   341: invokevirtual 256	java/io/FileReader:close	()V
    //   344: goto +18 -> 362
    //   347: ldc_w 258
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload 4
    //   359: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   362: aload_3
    //   363: athrow
    //   364: astore_3
    //   365: goto -60 -> 305
    //   368: astore 4
    //   370: goto -23 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	f
    //   90	27	1	l1	long
    //   23	128	3	localBufferedReader	java.io.BufferedReader
    //   162	19	3	localThrowable1	Throwable
    //   191	12	3	localThrowable2	Throwable
    //   208	1	3	localObject1	Object
    //   221	1	3	localObject2	Object
    //   231	1	3	localObject3	Object
    //   235	1	3	localObject4	Object
    //   249	114	3	localThrowable3	Throwable
    //   364	1	3	localThrowable4	Throwable
    //   9	349	4	localObject5	Object
    //   368	1	4	localThrowable5	Throwable
    //   29	247	5	localObject6	Object
    //   25	302	6	localObject7	Object
    //   35	143	7	localObject8	Object
    //   216	1	7	localThrowable6	Throwable
    //   228	1	7	localThrowable7	Throwable
    //   246	32	7	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   150	159	162	java/lang/Throwable
    //   180	189	191	java/lang/Throwable
    //   31	37	208	finally
    //   49	64	208	finally
    //   71	91	208	finally
    //   98	107	208	finally
    //   114	121	208	finally
    //   128	136	208	finally
    //   143	150	208	finally
    //   260	270	208	finally
    //   277	282	208	finally
    //   31	37	216	java/lang/Throwable
    //   49	64	216	java/lang/Throwable
    //   71	91	216	java/lang/Throwable
    //   98	107	216	java/lang/Throwable
    //   114	121	216	java/lang/Throwable
    //   128	136	216	java/lang/Throwable
    //   143	150	216	java/lang/Throwable
    //   11	24	221	finally
    //   11	24	228	java/lang/Throwable
    //   0	11	235	finally
    //   0	11	246	java/lang/Throwable
    //   286	290	364	java/lang/Throwable
    //   298	303	364	java/lang/Throwable
    //   326	331	368	java/lang/Throwable
    //   339	344	368	java/lang/Throwable
  }
  
  public String B()
  {
    DisplayMetrics localDisplayMetrics = j();
    if (localDisplayMetrics == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localDisplayMetrics.widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(localDisplayMetrics.heightPixels);
    return localStringBuilder.toString();
  }
  
  public String C()
  {
    ArrayList localArrayList = com.tencent.beacon.base.util.b.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public String D()
  {
    if (!TextUtils.isEmpty(this.k)) {
      return this.k;
    }
    Object localObject = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = ((StatFs)localObject).getBlockSize();
    long l2 = ((StatFs)localObject).getBlockCount();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l2 * l1 / 1024L / 1024L);
    ((StringBuilder)localObject).append("");
    this.k = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DeviceInfo] Rom Size:");
    ((StringBuilder)localObject).append(this.k);
    com.tencent.beacon.base.util.c.a(((StringBuilder)localObject).toString(), new Object[0]);
    return this.k;
  }
  
  public long E()
  {
    if (!c()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int n = localStatFs.getBlockSize();
      long l1 = localStatFs.getBlockCount() * n / 1024L / 1024L;
      return l1;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
    return 0L;
  }
  
  public int F()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    if (localWindowManager != null)
    {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
      double d1 = localDisplayMetrics.density;
      Double.isNaN(d1);
      if (d1 - 0.75D <= 1.0E-006D) {
        return 120;
      }
      Double.isNaN(d1);
      if (d1 - 1.5D <= 1.0E-006D) {
        return 240;
      }
      Double.isNaN(d1);
      if (d1 - 2.0D <= 1.0E-006D) {
        return 320;
      }
      Double.isNaN(d1);
      if (d1 - 3.0D <= 1.0E-006D) {
        return 480;
      }
    }
    return 160;
  }
  
  public String G()
  {
    com.tencent.beacon.base.util.c.a("[DeviceInfo] getSensor start", new Object[0]);
    StringBuilder localStringBuilder = new StringBuilder();
    int n = Integer.parseInt(Build.VERSION.SDK);
    String str3 = "X";
    Object localObject1;
    Object localObject2;
    Object localObject5;
    label509:
    String str2;
    if (n >= 10)
    {
      try
      {
        Class localClass = Class.forName("android.hardware.Camera");
        int i1 = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (i1 == 0) {}
        for (localObject1 = "N";; localObject1 = "X")
        {
          localObject2 = localObject1;
          break;
          localObject2 = Class.forName("android.hardware.Camera$CameraInfo");
          Object localObject6 = ((Class)localObject2).newInstance();
          Method[] arrayOfMethod = localClass.getMethods();
          localObject1 = null;
          int i2 = arrayOfMethod.length;
          n = 0;
          for (;;)
          {
            localObject5 = localObject1;
            if (n < i2)
            {
              localObject5 = arrayOfMethod[n];
              try
              {
                localObject7 = ((Method)localObject5).getName();
                boolean bool = ((String)localObject7).equals("getCameraInfo");
                if (!bool) {
                  n += 1;
                }
              }
              catch (Throwable localThrowable1)
              {
                localObject5 = "X";
                localObject1 = localObject5;
                localObject2 = localObject1;
                break label509;
              }
            }
          }
          Object localObject7 = ((Class)localObject2).getField("facing");
          Field localField1 = ((Class)localObject2).getField("CAMERA_FACING_BACK");
          Field localField2 = ((Class)localObject2).getField("CAMERA_FACING_FRONT");
          if (localObject5 != null)
          {
            localObject1 = "X";
            localObject2 = localObject1;
            n = 0;
            for (;;)
            {
              if (n < i1) {
                try
                {
                  ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(n), localObject6 });
                  i2 = ((Field)localObject7).getInt(localObject6);
                  int i3 = localField1.getInt(localObject6);
                  int i4 = localField2.getInt(localObject6);
                  Object localObject3;
                  if (i2 == i3)
                  {
                    if (i1 == 1)
                    {
                      localObject3 = "Y";
                      localObject2 = "N";
                    }
                    else
                    {
                      localObject3 = "Y";
                    }
                  }
                  else
                  {
                    localObject3 = localObject1;
                    if (i2 == i4) {
                      if (i1 == 1)
                      {
                        localObject2 = "Y";
                        localObject3 = "N";
                      }
                      else
                      {
                        localObject2 = "Y";
                        localObject3 = localObject1;
                      }
                    }
                  }
                  n += 1;
                  localObject1 = localObject3;
                }
                catch (Throwable localThrowable2)
                {
                  localObject5 = "X";
                  break label509;
                }
              }
            }
            break;
          }
        }
        try
        {
          Object localObject4 = this.b;
          localObject4 = (SensorManager)((Context)localObject4).getSystemService("sensor");
          if (localObject4 != null)
          {
            localObject5 = ((SensorManager)localObject4).getDefaultSensor(9);
            if (localObject5 != null) {
              localObject5 = "Y";
            } else {
              localObject5 = "N";
            }
            try
            {
              localObject4 = ((SensorManager)localObject4).getDefaultSensor(4);
              if (localObject4 != null) {
                localObject4 = "Y";
              } else {
                localObject4 = "N";
              }
            }
            catch (Throwable localThrowable3)
            {
              break label509;
            }
          }
          else
          {
            localObject5 = "X";
            String str1 = str3;
          }
        }
        catch (Throwable localThrowable4)
        {
          localObject5 = "X";
        }
        com.tencent.beacon.base.util.c.b("[model] getSensor error!", new Object[0]);
      }
      catch (Throwable localThrowable5)
      {
        localObject5 = "X";
        localObject1 = localObject5;
        localObject2 = localObject1;
      }
      com.tencent.beacon.base.util.c.a(localThrowable5);
      str2 = str3;
    }
    else
    {
      localObject5 = "X";
      localObject1 = localObject5;
      localObject2 = localObject1;
      str2 = str3;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append((String)localObject5);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public String H()
  {
    com.tencent.beacon.base.util.c.a("[model] getSensor2 start", new Object[0]);
    String str2;
    if (M()) {
      str2 = "Y";
    } else {
      str2 = "N";
    }
    int n = Integer.parseInt(Build.VERSION.SDK);
    String str1 = "X";
    if (n >= 10) {}
    try
    {
      localObject1 = this.b;
      localObject3 = (SensorManager)((Context)localObject1).getSystemService("sensor");
      localObject1 = ((SensorManager)localObject3).getDefaultSensor(1);
      if (localObject1 != null) {
        localObject1 = "Y";
      } else {
        localObject1 = "N";
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      boolean bool;
      label186:
      label200:
      break label218;
    }
    try
    {
      localObject3 = ((SensorManager)localObject3).getDefaultSensor(5);
      if (localObject3 != null) {
        localObject3 = "Y";
      } else {
        localObject3 = "N";
      }
    }
    catch (Throwable localThrowable2)
    {
      break label200;
    }
    try
    {
      localObject4 = BluetoothAdapter.getDefaultAdapter();
      if (localObject4 == null) {
        localObject4 = "N";
      } else {
        localObject4 = "Y";
      }
    }
    catch (Throwable localThrowable3)
    {
      break label186;
    }
    try
    {
      localObject5 = this.b.getPackageManager();
      bool = ((PackageManager)localObject5).hasSystemFeature("android.hardware.nfc");
      if (bool)
      {
        str1 = "Y";
        localObject5 = localObject1;
        localObject1 = localObject4;
      }
      else
      {
        str1 = "N";
        localObject5 = localObject1;
        localObject1 = localObject4;
      }
    }
    catch (Throwable localThrowable4)
    {
      Throwable localThrowable5 = localThrowable1;
      Object localObject2 = localThrowable3;
      break label230;
    }
    localObject4 = "X";
    localObject5 = localObject1;
    localObject1 = localObject4;
    break label230;
    localObject3 = "X";
    localObject4 = localObject3;
    localObject5 = localObject1;
    localObject1 = localObject4;
    break label230;
    label218:
    localObject3 = "X";
    localObject5 = localObject3;
    localObject1 = localObject5;
    label230:
    com.tencent.beacon.base.util.c.b("[model] getSensor2 error!", new Object[0]);
    break label255;
    localObject3 = "X";
    localObject5 = localObject3;
    localObject1 = localObject5;
    label255:
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(str2);
    ((StringBuilder)localObject4).append((String)localObject5);
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(str1);
    return ((StringBuilder)localObject4).toString();
  }
  
  public String I()
  {
    boolean bool = com.tencent.beacon.e.b.a().i();
    Object localObject3 = "";
    if (!bool)
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return "";
    }
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      com.tencent.beacon.base.util.c.b("[core] getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    Object localObject2;
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)((Context)localObject1).getSystemService("wifi")).getConnectionInfo();
      localObject1 = localObject3;
      if (localWifiInfo.getBSSID() != null) {
        localObject1 = localWifiInfo.getBSSID();
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
      com.tencent.beacon.base.util.c.b("getWifiSSID error!", new Object[0]);
      localObject2 = localObject3;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[core] Wifi SSID:");
    ((StringBuilder)localObject3).append(localObject2);
    com.tencent.beacon.base.util.c.a(((StringBuilder)localObject3).toString(), new Object[0]);
    return localObject2;
  }
  
  public String J()
  {
    if (!com.tencent.beacon.e.b.a().i())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return this.i;
    }
    if (!TextUtils.isEmpty(this.i)) {
      return this.i;
    }
    Object localObject = (WifiManager)this.b.getSystemService("wifi");
    if (localObject != null)
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject != null) {
        this.i = ((WifiInfo)localObject).getBSSID();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DeviceInfo] Wifi BSSID:");
    ((StringBuilder)localObject).append(this.i);
    com.tencent.beacon.base.util.c.a(((StringBuilder)localObject).toString(), new Object[0]);
    return this.i;
  }
  
  public String K()
  {
    if (!com.tencent.beacon.e.b.a().i())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return this.j;
    }
    if (!TextUtils.isEmpty(this.j)) {
      return this.j;
    }
    Object localObject = (WifiManager)this.b.getApplicationContext().getSystemService("wifi");
    if (localObject != null)
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if ((localObject != null) && (((WifiInfo)localObject).getBSSID() != null)) {
        this.j = ((WifiInfo)localObject).getSSID();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DeviceInfo] Wifi SSID:");
    ((StringBuilder)localObject).append(this.j);
    com.tencent.beacon.base.util.c.a(((StringBuilder)localObject).toString(), new Object[0]);
    return this.j;
  }
  
  public String L()
  {
    Object localObject = (LocationManager)this.b.getSystemService("location");
    String str = "N";
    if (localObject == null) {
      return "N";
    }
    localObject = ((LocationManager)localObject).getAllProviders();
    if (localObject == null) {
      return "N";
    }
    if (((List)localObject).contains("gps")) {
      str = "Y";
    }
    return str;
  }
  
  public boolean M()
  {
    return (WifiManager)this.b.getSystemService("wifi") != null;
  }
  
  /* Error */
  public boolean N()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 217	java/io/BufferedReader
    //   8: dup
    //   9: new 543	java/io/InputStreamReader
    //   12: dup
    //   13: invokestatic 549	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   16: iconst_2
    //   17: anewarray 195	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 551
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc_w 553
    //   31: aastore
    //   32: invokevirtual 557	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 563	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokestatic 569	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   41: invokespecial 572	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   44: invokespecial 575	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +26 -> 82
    //   59: aload_3
    //   60: invokevirtual 232	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: ldc_w 577
    //   68: invokevirtual 580	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   71: istore_1
    //   72: iconst_m1
    //   73: iload_1
    //   74: if_icmpeq -25 -> 49
    //   77: iconst_1
    //   78: istore_2
    //   79: goto +5 -> 84
    //   82: iconst_0
    //   83: istore_2
    //   84: iconst_1
    //   85: anewarray 582	java/io/Closeable
    //   88: dup
    //   89: iconst_0
    //   90: aload 4
    //   92: aastore
    //   93: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   96: iload_2
    //   97: ireturn
    //   98: astore_3
    //   99: goto +52 -> 151
    //   102: astore 5
    //   104: goto +20 -> 124
    //   107: aload_3
    //   108: astore 4
    //   110: aload 5
    //   112: astore_3
    //   113: goto +38 -> 151
    //   116: astore_3
    //   117: aload 5
    //   119: astore 4
    //   121: aload_3
    //   122: astore 5
    //   124: aload 4
    //   126: astore_3
    //   127: aload 5
    //   129: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   132: iconst_1
    //   133: anewarray 582	java/io/Closeable
    //   136: dup
    //   137: iconst_0
    //   138: aload 4
    //   140: aastore
    //   141: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore 5
    //   148: goto -41 -> 107
    //   151: iconst_1
    //   152: anewarray 582	java/io/Closeable
    //   155: dup
    //   156: iconst_0
    //   157: aload 4
    //   159: aastore
    //   160: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   163: goto +5 -> 168
    //   166: aload_3
    //   167: athrow
    //   168: goto -2 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	f
    //   71	4	1	n	int
    //   78	19	2	bool	boolean
    //   1	64	3	str	String
    //   98	10	3	localObject1	Object
    //   112	1	3	localObject2	Object
    //   116	6	3	localThrowable1	Throwable
    //   126	41	3	localObject3	Object
    //   47	111	4	localObject4	Object
    //   3	1	5	localObject5	Object
    //   102	16	5	localThrowable2	Throwable
    //   122	6	5	localThrowable3	Throwable
    //   146	1	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	98	finally
    //   59	64	98	finally
    //   64	72	98	finally
    //   49	55	102	java/lang/Throwable
    //   59	64	102	java/lang/Throwable
    //   64	72	102	java/lang/Throwable
    //   5	49	116	java/lang/Throwable
    //   5	49	146	finally
    //   127	132	146	finally
  }
  
  public String a(Context paramContext)
  {
    try
    {
      int n = Integer.parseInt(Build.VERSION.SDK);
      if (n < 9)
      {
        com.tencent.beacon.base.util.c.b("[audit] Api level < 9;return null!", new Object[0]);
        return "";
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[audit] get app_last_updated_time:");
      localStringBuilder.append(String.valueOf(paramContext.lastUpdateTime));
      com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
      long l1 = paramContext.lastUpdateTime;
      return String.valueOf(l1);
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.base.util.c.a(paramContext);
      com.tencent.beacon.base.util.c.b("[audit] get app_last_updated_time failed!", new Object[0]);
    }
    return "";
  }
  
  public void a()
  {
    P();
  }
  
  public void b()
  {
    P();
  }
  
  public boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public String d()
  {
    if (!com.tencent.beacon.e.b.a().i())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect allMacAddress be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return this.h;
    }
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      if (localEnumeration != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        while (localEnumeration.hasMoreElements())
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
          byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
          if ((arrayOfByte != null) && (arrayOfByte.length != 0))
          {
            localStringBuilder2.append(localNetworkInterface.getName());
            localStringBuilder2.append(":");
            localStringBuilder2.append(a(arrayOfByte));
            localStringBuilder2.append(",");
          }
        }
        this.h = localStringBuilder2.toString();
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[DeviceInfo] Mac Address:");
    localStringBuilder1.append(this.h);
    com.tencent.beacon.base.util.c.a(localStringBuilder1.toString(), new Object[0]);
    return this.h;
  }
  
  public String e()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return this.c;
    }
    if (!com.tencent.beacon.e.b.a().d())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect androidId be refused! isAndroidId: %s", new Object[] { Boolean.valueOf(false) });
      return this.c;
    }
    Object localObject = this.b;
    if (localObject == null) {
      return this.c;
    }
    this.c = Settings.Secure.getString(((Context)localObject).getContentResolver(), "android_id");
    localObject = this.c;
    if (localObject != null) {
      this.c = ((String)localObject).toLowerCase();
    } else {
      this.c = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DeviceInfo] Android ID:");
    ((StringBuilder)localObject).append(this.c);
    com.tencent.beacon.base.util.c.d(((StringBuilder)localObject).toString(), new Object[0]);
    return this.c;
  }
  
  /* Error */
  public int f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_3
    //   6: astore_2
    //   7: invokestatic 549	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   10: iconst_2
    //   11: anewarray 195	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 551
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: ldc_w 665
    //   25: aastore
    //   26: invokevirtual 557	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   29: invokevirtual 563	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   32: astore 5
    //   34: aload_3
    //   35: astore_2
    //   36: new 217	java/io/BufferedReader
    //   39: dup
    //   40: new 543	java/io/InputStreamReader
    //   43: dup
    //   44: aload 5
    //   46: ldc_w 667
    //   49: invokestatic 670	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   52: invokespecial 572	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   55: invokespecial 575	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +18 -> 83
    //   68: aload_2
    //   69: invokevirtual 241	java/lang/String:trim	()Ljava/lang/String;
    //   72: invokestatic 381	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   75: sipush 1000
    //   78: idiv
    //   79: istore_1
    //   80: goto +5 -> 85
    //   83: iconst_0
    //   84: istore_1
    //   85: iconst_1
    //   86: anewarray 582	java/io/Closeable
    //   89: dup
    //   90: iconst_0
    //   91: aload_3
    //   92: aastore
    //   93: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   96: iload_1
    //   97: ireturn
    //   98: astore_2
    //   99: goto +48 -> 147
    //   102: astore 4
    //   104: goto +18 -> 122
    //   107: aload_2
    //   108: astore_3
    //   109: aload 4
    //   111: astore_2
    //   112: goto +35 -> 147
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload_2
    //   120: astore 4
    //   122: aload_3
    //   123: astore_2
    //   124: aload 4
    //   126: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   129: iconst_1
    //   130: anewarray 582	java/io/Closeable
    //   133: dup
    //   134: iconst_0
    //   135: aload_3
    //   136: aastore
    //   137: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore 4
    //   144: goto -37 -> 107
    //   147: iconst_1
    //   148: anewarray 582	java/io/Closeable
    //   151: dup
    //   152: iconst_0
    //   153: aload_3
    //   154: aastore
    //   155: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   158: goto +5 -> 163
    //   161: aload_2
    //   162: athrow
    //   163: goto -2 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	f
    //   79	18	1	n	int
    //   6	63	2	localObject1	Object
    //   98	10	2	localObject2	Object
    //   111	1	2	localThrowable1	Throwable
    //   115	5	2	localThrowable2	Throwable
    //   123	39	2	localObject3	Object
    //   1	153	3	localObject4	Object
    //   3	1	4	localObject5	Object
    //   102	15	4	localThrowable3	Throwable
    //   120	5	4	localObject6	Object
    //   142	1	4	localObject7	Object
    //   32	13	5	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   59	64	98	finally
    //   68	80	98	finally
    //   59	64	102	java/lang/Throwable
    //   68	80	102	java/lang/Throwable
    //   7	34	115	java/lang/Throwable
    //   36	59	115	java/lang/Throwable
    //   7	34	142	finally
    //   36	59	142	finally
    //   124	129	142	finally
  }
  
  /* Error */
  public String g()
  {
    // Byte code:
    //   0: ldc 33
    //   2: astore 4
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_3
    //   10: astore_2
    //   11: invokestatic 549	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: iconst_2
    //   15: anewarray 195	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 551
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 553
    //   29: aastore
    //   30: invokevirtual 557	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   33: invokevirtual 563	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: astore 6
    //   38: aload_3
    //   39: astore_2
    //   40: new 217	java/io/BufferedReader
    //   43: dup
    //   44: new 543	java/io/InputStreamReader
    //   47: dup
    //   48: aload 6
    //   50: ldc_w 667
    //   53: invokestatic 670	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   56: invokespecial 572	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   59: invokespecial 575	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore 5
    //   69: aload 4
    //   71: astore_2
    //   72: aload 5
    //   74: ifnull +35 -> 109
    //   77: aload 5
    //   79: ldc_w 672
    //   82: invokevirtual 674	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   85: istore_1
    //   86: iload_1
    //   87: ifeq -24 -> 63
    //   90: aload 5
    //   92: aload 5
    //   94: ldc_w 634
    //   97: invokevirtual 580	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   100: iconst_1
    //   101: iadd
    //   102: invokevirtual 678	java/lang/String:substring	(I)Ljava/lang/String;
    //   105: invokevirtual 241	java/lang/String:trim	()Ljava/lang/String;
    //   108: astore_2
    //   109: iconst_1
    //   110: anewarray 582	java/io/Closeable
    //   113: dup
    //   114: iconst_0
    //   115: aload_3
    //   116: aastore
    //   117: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   120: aload_2
    //   121: areturn
    //   122: astore_2
    //   123: goto +47 -> 170
    //   126: astore 4
    //   128: goto +16 -> 144
    //   131: aload_2
    //   132: astore_3
    //   133: aload 4
    //   135: astore_2
    //   136: goto +34 -> 170
    //   139: astore 4
    //   141: aload 5
    //   143: astore_3
    //   144: aload_3
    //   145: astore_2
    //   146: aload 4
    //   148: invokestatic 120	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   151: iconst_1
    //   152: anewarray 582	java/io/Closeable
    //   155: dup
    //   156: iconst_0
    //   157: aload_3
    //   158: aastore
    //   159: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   162: ldc 33
    //   164: areturn
    //   165: astore 4
    //   167: goto -36 -> 131
    //   170: iconst_1
    //   171: anewarray 582	java/io/Closeable
    //   174: dup
    //   175: iconst_0
    //   176: aload_3
    //   177: aastore
    //   178: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   181: goto +5 -> 186
    //   184: aload_2
    //   185: athrow
    //   186: goto -2 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	f
    //   85	2	1	bool	boolean
    //   10	111	2	localObject1	Object
    //   122	10	2	localObject2	Object
    //   135	50	2	localObject3	Object
    //   5	172	3	localObject4	Object
    //   2	68	4	str1	String
    //   126	8	4	localThrowable1	Throwable
    //   139	8	4	localThrowable2	Throwable
    //   165	1	4	localObject5	Object
    //   7	135	5	str2	String
    //   36	13	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   63	69	122	finally
    //   77	86	122	finally
    //   90	109	122	finally
    //   63	69	126	java/lang/Throwable
    //   77	86	126	java/lang/Throwable
    //   90	109	126	java/lang/Throwable
    //   11	38	139	java/lang/Throwable
    //   40	63	139	java/lang/Throwable
    //   11	38	165	finally
    //   40	63	165	finally
    //   146	151	165	finally
  }
  
  public String h()
  {
    return Locale.getDefault().getCountry();
  }
  
  public String i()
  {
    return Build.HARDWARE;
  }
  
  public DisplayMetrics j()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    if (localWindowManager != null) {
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    return localDisplayMetrics;
  }
  
  public long k()
  {
    ActivityManager localActivityManager = (ActivityManager)this.b.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (localActivityManager != null)
    {
      localActivityManager.getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.availMem;
    }
    return -1L;
  }
  
  public String l()
  {
    long l1 = k();
    if (l1 > 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1 / 1024L / 1024L);
      localStringBuilder.append("");
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  public String m()
  {
    if (!com.tencent.beacon.e.b.a().g())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect imei be refused! isCollect Imei: %s", new Object[] { Boolean.valueOf(false) });
      return this.e;
    }
    if (this.b == null)
    {
      com.tencent.beacon.base.util.c.b("[DeviceInfo] getImei but context is null!", new Object[0]);
      return this.e;
    }
    if (!TextUtils.isEmpty(this.e)) {
      return this.e;
    }
    if (b.f(this.b))
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
      if (localTelephonyManager != null) {
        try
        {
          this.e = localTelephonyManager.getDeviceId();
          if (this.e != null) {
            this.e = this.e.toLowerCase();
          } else {
            this.e = "";
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.base.util.c.d("[DeviceInfo] getDeviceId error!", new Object[0]);
          com.tencent.beacon.base.util.c.a(localThrowable);
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] IMEI:");
    localStringBuilder.append(this.e);
    com.tencent.beacon.base.util.c.d(localStringBuilder.toString(), new Object[0]);
    return this.e;
  }
  
  public String n()
  {
    if (!com.tencent.beacon.e.b.a().g()) {
      com.tencent.beacon.base.util.c.a("[core] current collect imei2 be refused! isCollectImei2: %s", new Object[] { Boolean.valueOf(false) });
    } else if (Build.VERSION.SDK_INT < 26) {
      return m();
    }
    try
    {
      if (!b.f(this.b)) {
        break label83;
      }
      Object localObject = this.b;
      localObject = ((TelephonyManager)((Context)localObject).getSystemService("phone")).getImei(1);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label73:
      label83:
      break label73;
    }
    com.tencent.beacon.base.util.c.b("[core] getImei error!", new Object[0]);
    return "";
  }
  
  public String o()
  {
    if (!com.tencent.beacon.e.b.a().g())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect imei be refused! isCollectImei: %s", new Object[] { Boolean.valueOf(false) });
      return this.f;
    }
    if (this.b == null)
    {
      com.tencent.beacon.base.util.c.b("[DeviceInfo] getImsi but context == null!", new Object[0]);
      return this.f;
    }
    if (!TextUtils.isEmpty(this.f)) {
      return this.f;
    }
    if (b.f(this.b))
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
      if (localTelephonyManager != null) {
        try
        {
          this.f = localTelephonyManager.getSubscriberId();
          if (this.f != null) {
            this.f = this.f.toLowerCase();
          } else {
            this.f = "";
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.base.util.c.d("[DeviceInfo] getSubscriberId error!", new Object[0]);
          com.tencent.beacon.base.util.c.a(localThrowable);
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] imsi:");
    localStringBuilder.append(this.f);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.f;
  }
  
  public boolean q()
  {
    return com.tencent.beacon.base.util.d.d();
  }
  
  public String r()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public String s()
  {
    if (!com.tencent.beacon.e.b.a().i())
    {
      com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect mac be refused! isCollectMAC: %s", new Object[] { Boolean.valueOf(false) });
      return this.g;
    }
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    try
    {
      Object localObject;
      if (Integer.valueOf(Build.VERSION.SDK).intValue() < 23)
      {
        localObject = this.b;
        localObject = (WifiManager)((Context)localObject).getSystemService("wifi");
        if (localObject != null)
        {
          localObject = ((WifiManager)localObject).getConnectionInfo();
          if ((this.g != null) && (localObject != null))
          {
            this.g = ((WifiInfo)localObject).getMacAddress();
            this.g = this.g.toLowerCase();
          }
        }
      }
      else
      {
        localObject = new String[2];
        localObject[0] = "/sys/class/net/wlan0/address";
        localObject[1] = "/sys/devices/virtual/net/wlan0/address";
        int i1 = localObject.length;
        int n = 0;
        while (n < i1)
        {
          this.g = com.tencent.beacon.base.util.b.e(localObject[n]).trim();
          if (this.g.length() > 0)
          {
            this.g = this.g.toLowerCase();
            break;
          }
          n += 1;
        }
        if ("".equals(this.g))
        {
          localObject = NetworkInterface.getNetworkInterfaces();
          while ((localObject != null) && (((Enumeration)localObject).hasMoreElements()))
          {
            NetworkInterface localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
            byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
            if (("wlan0".equals(localNetworkInterface.getName())) && (arrayOfByte != null) && (arrayOfByte.length != 0)) {
              this.g = a(arrayOfByte).toString();
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] Mac Address:");
    localStringBuilder.append(this.g);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.g;
  }
  
  public String t()
  {
    return Build.MANUFACTURER;
  }
  
  public String u()
  {
    boolean bool = com.tencent.beacon.e.b.a().g();
    Object localObject1 = "";
    if (!bool)
    {
      com.tencent.beacon.base.util.c.a("[core] current collect meid be refused! isCollectMeid: %s", new Object[] { Boolean.valueOf(false) });
      return "";
    }
    if (Build.VERSION.SDK_INT < 26) {
      return m();
    }
    Object localObject2 = localObject1;
    try
    {
      if (b.f(this.b))
      {
        localObject2 = this.b;
        localObject2 = ((TelephonyManager)((Context)localObject2).getSystemService("phone")).getMeid();
        if (localObject2 == null) {
          return "";
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      label91:
      label93:
      break label93;
    }
    try
    {
      localObject1 = ((String)localObject2).toLowerCase();
      return localObject1;
    }
    catch (Throwable localThrowable1)
    {
      break label91;
    }
    localObject1 = localObject2;
    com.tencent.beacon.base.util.c.b("[core] getImei error!", new Object[0]);
    localObject2 = localObject1;
    return localObject2;
  }
  
  /* Error */
  public String v()
  {
    // Byte code:
    //   0: new 165	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: new 217	java/io/BufferedReader
    //   17: dup
    //   18: new 210	java/io/FileReader
    //   21: dup
    //   22: new 313	java/io/File
    //   25: dup
    //   26: ldc_w 792
    //   29: invokespecial 793	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 796	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   35: invokespecial 575	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload 5
    //   43: aload_2
    //   44: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: iconst_1
    //   52: anewarray 582	java/io/Closeable
    //   55: dup
    //   56: iconst_0
    //   57: aload_2
    //   58: aastore
    //   59: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   62: goto +34 -> 96
    //   65: astore_1
    //   66: aconst_null
    //   67: astore_2
    //   68: goto +289 -> 357
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: ldc_w 798
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: iconst_1
    //   86: anewarray 582	java/io/Closeable
    //   89: dup
    //   90: iconst_0
    //   91: aload_2
    //   92: aastore
    //   93: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   96: aload 5
    //   98: ldc_w 641
    //   101: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: new 217	java/io/BufferedReader
    //   108: dup
    //   109: new 210	java/io/FileReader
    //   112: dup
    //   113: new 313	java/io/File
    //   116: dup
    //   117: ldc_w 800
    //   120: invokespecial 793	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 796	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   126: invokespecial 575	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: aload 5
    //   134: aload_2
    //   135: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   138: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: iconst_1
    //   143: anewarray 582	java/io/Closeable
    //   146: dup
    //   147: iconst_0
    //   148: aload_2
    //   149: aastore
    //   150: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   153: goto +34 -> 187
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_2
    //   159: goto +180 -> 339
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_2
    //   165: astore_1
    //   166: ldc_w 798
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_1
    //   177: anewarray 582	java/io/Closeable
    //   180: dup
    //   181: iconst_0
    //   182: aload_2
    //   183: aastore
    //   184: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   187: aload 5
    //   189: ldc_w 641
    //   192: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore_1
    //   199: new 217	java/io/BufferedReader
    //   202: dup
    //   203: new 210	java/io/FileReader
    //   206: dup
    //   207: new 313	java/io/File
    //   210: dup
    //   211: ldc_w 802
    //   214: invokespecial 793	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: invokespecial 796	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   220: invokespecial 575	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   223: astore_2
    //   224: aload 5
    //   226: aload_2
    //   227: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   230: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: iconst_1
    //   235: anewarray 582	java/io/Closeable
    //   238: dup
    //   239: iconst_0
    //   240: aload_2
    //   241: aastore
    //   242: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   245: goto +30 -> 275
    //   248: astore_1
    //   249: goto +72 -> 321
    //   252: aload_2
    //   253: astore_1
    //   254: ldc_w 798
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 260	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: iconst_1
    //   265: anewarray 582	java/io/Closeable
    //   268: dup
    //   269: iconst_0
    //   270: aload_2
    //   271: aastore
    //   272: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   275: aload 5
    //   277: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore_1
    //   281: new 165	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   288: astore_2
    //   289: aload_2
    //   290: ldc_w 804
    //   293: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: aload_1
    //   299: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_2
    //   304: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokestatic 183	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_1
    //   315: areturn
    //   316: astore_3
    //   317: aload_1
    //   318: astore_2
    //   319: aload_3
    //   320: astore_1
    //   321: iconst_1
    //   322: anewarray 582	java/io/Closeable
    //   325: dup
    //   326: iconst_0
    //   327: aload_2
    //   328: aastore
    //   329: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   332: aload_1
    //   333: athrow
    //   334: astore_3
    //   335: aload_1
    //   336: astore_2
    //   337: aload_3
    //   338: astore_1
    //   339: iconst_1
    //   340: anewarray 582	java/io/Closeable
    //   343: dup
    //   344: iconst_0
    //   345: aload_2
    //   346: aastore
    //   347: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   350: aload_1
    //   351: athrow
    //   352: astore_3
    //   353: aload_1
    //   354: astore_2
    //   355: aload_3
    //   356: astore_1
    //   357: iconst_1
    //   358: anewarray 582	java/io/Closeable
    //   361: dup
    //   362: iconst_0
    //   363: aload_2
    //   364: aastore
    //   365: invokestatic 585	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   368: aload_1
    //   369: athrow
    //   370: astore_1
    //   371: goto -300 -> 71
    //   374: astore_1
    //   375: goto -302 -> 73
    //   378: astore_1
    //   379: goto -217 -> 162
    //   382: astore_1
    //   383: goto -219 -> 164
    //   386: astore_1
    //   387: aload_3
    //   388: astore_2
    //   389: goto -137 -> 252
    //   392: astore_1
    //   393: goto -141 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	f
    //   40	1	1	localObject1	Object
    //   65	1	1	localObject2	Object
    //   74	58	1	localObject3	Object
    //   156	1	1	localObject4	Object
    //   165	34	1	localObject5	Object
    //   248	1	1	localObject6	Object
    //   253	116	1	localObject7	Object
    //   370	1	1	localException1	Exception
    //   374	1	1	localException2	Exception
    //   378	1	1	localException3	Exception
    //   382	1	1	localException4	Exception
    //   386	1	1	localException5	Exception
    //   392	1	1	localException6	Exception
    //   38	351	2	localObject8	Object
    //   13	1	3	localObject9	Object
    //   316	4	3	localObject10	Object
    //   334	4	3	localObject11	Object
    //   352	36	3	localObject12	Object
    //   10	187	4	localObject13	Object
    //   7	269	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	39	65	finally
    //   105	130	156	finally
    //   224	234	248	finally
    //   199	224	316	finally
    //   254	264	316	finally
    //   132	142	334	finally
    //   166	176	334	finally
    //   41	51	352	finally
    //   75	85	352	finally
    //   14	39	370	java/lang/Exception
    //   41	51	374	java/lang/Exception
    //   105	130	378	java/lang/Exception
    //   132	142	382	java/lang/Exception
    //   199	224	386	java/lang/Exception
    //   224	234	392	java/lang/Exception
  }
  
  public String w()
  {
    return this.l;
  }
  
  public int x()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new e(this));
      if (arrayOfFile == null) {
        return 1;
      }
      int n = arrayOfFile.length;
      return n;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.base.util.c.b("[model] CPU Count: Failed.", new Object[0]);
      com.tencent.beacon.base.util.c.a(localException);
    }
    return 1;
  }
  
  public String y()
  {
    return this.m;
  }
  
  public String z()
  {
    if (!TextUtils.isEmpty(this.d)) {
      return this.d;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append(",level ");
    localStringBuilder.append(Build.VERSION.SDK);
    this.d = localStringBuilder.toString();
    com.tencent.beacon.base.util.c.a("[DeviceInfo] os version: %s", new Object[] { this.d });
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.c.f
 * JD-Core Version:    0.7.0.1
 */
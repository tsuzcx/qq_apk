package com.tencent.beacon.model;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.e.b;
import com.tencent.beacon.core.info.e;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModuleImpl
  extends c
{
  private static ModuleImpl mInstance;
  private static final String modelEvent = "rqd_model";
  private boolean modelEventUsable = true;
  
  public ModuleImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  private String getCpuProductorName()
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
      com.tencent.beacon.core.e.d.b("[model] get cpu product error!", new Object[0]);
    }
    return null;
  }
  
  private long getFreeMem()
  {
    try
    {
      Object localObject = this.mContext;
      localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.e.d.b("[model] getFreeMem error!", new Object[0]);
      com.tencent.beacon.core.e.d.a(localThrowable);
    }
    return -1L;
  }
  
  private String getFreeMem2()
  {
    String str = "0";
    long l = getFreeMem();
    if (l > 0L) {
      str = l / 1024L / 1024L + "";
    }
    return str;
  }
  
  public static ModuleImpl getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ModuleImpl(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private String getRomFingerPrint()
  {
    ArrayList localArrayList = b.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private long getSDCardSize()
  {
    if (!e.d(this.mContext).a()) {
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
      com.tencent.beacon.core.e.d.a(localThrowable);
    }
    return 0L;
  }
  
  private String getSensor()
  {
    com.tencent.beacon.core.e.d.a("[model] getSensor start", new Object[0]);
    Object localObject1 = "X";
    Object localObject3 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) < 10)
    {
      localObject4 = "X";
      localObject1 = "X";
      localObject5 = "X";
      localObject3 = "X";
      localStringBuffer.append((String)localObject5).append((String)localObject1).append((String)localObject4).append((String)localObject3);
      return localStringBuffer.toString();
    }
    Object localObject5 = localObject3;
    Object localObject4 = localObject1;
    label666:
    for (;;)
    {
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject7 = Class.forName("android.hardware.Camera");
          localObject5 = localObject3;
          localObject4 = localObject1;
          j = ((Integer)((Class)localObject7).getMethod("getNumberOfCameras", new Class[0]).invoke(localObject7, new Object[0])).intValue();
          if (j == 0)
          {
            localObject1 = "N";
            localObject3 = "N";
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject6 = this.mContext;
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject6 = (SensorManager)((Context)localObject6).getSystemService("sensor");
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject7 = ((SensorManager)localObject6).getDefaultSensor(9);
            if (localObject7 == null) {
              continue;
            }
            localObject4 = "Y";
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject7;
          int j;
          Object localObject11;
          Object localObject8;
          Object localObject9;
          int k;
          int i;
          Object localObject10;
          int m;
          int n;
          Object localObject6 = "X";
          localObject3 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject6;
          com.tencent.beacon.core.e.d.b("[model] getSensor error!", new Object[0]);
          com.tencent.beacon.core.e.d.a(localThrowable1);
          localObject6 = "X";
          localObject2 = localObject3;
          localObject3 = localObject6;
        }
        try
        {
          localObject5 = ((SensorManager)localObject6).getDefaultSensor(4);
          if (localObject5 != null)
          {
            localObject6 = "Y";
            localObject5 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject6;
            break;
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject11 = Class.forName("android.hardware.Camera$CameraInfo");
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject8 = ((Class)localObject11).newInstance();
            localObject5 = localObject3;
            localObject4 = localObject1;
            localObject9 = ((Class)localObject7).getMethods();
            localObject5 = localObject3;
            localObject4 = localObject1;
            k = localObject9.length;
            i = 0;
            if (i < k)
            {
              localObject6 = localObject9[i];
              localObject5 = localObject3;
              localObject4 = localObject1;
              localObject10 = ((Method)localObject6).getName();
              localObject5 = localObject3;
              localObject4 = localObject1;
              boolean bool = ((String)localObject10).equals("getCameraInfo");
              if (bool)
              {
                localObject5 = localObject3;
                localObject4 = localObject1;
                localObject9 = ((Class)localObject11).getField("facing");
                localObject5 = localObject3;
                localObject4 = localObject1;
                localObject10 = ((Class)localObject11).getField("CAMERA_FACING_BACK");
                localObject5 = localObject3;
                localObject4 = localObject1;
                localObject11 = ((Class)localObject11).getField("CAMERA_FACING_FRONT");
                if (localObject6 == null) {
                  continue;
                }
                localObject3 = "X";
                localObject1 = "X";
                i = 0;
                if (i >= j) {
                  break label666;
                }
              }
            }
          }
        }
        catch (Throwable localThrowable3)
        {
          localObject5 = localObject2;
          localObject2 = localThrowable3;
        }
      }
      try
      {
        ((Method)localObject6).invoke(localObject7, new Object[] { Integer.valueOf(i), localObject8 });
        k = ((Field)localObject9).getInt(localObject8);
        m = ((Field)localObject10).getInt(localObject8);
        n = ((Field)localObject11).getInt(localObject8);
        if (k == m)
        {
          localObject1 = "Y";
          localObject4 = localObject1;
          if (j == 1)
          {
            localObject3 = "N";
            localObject4 = localObject1;
          }
          i += 1;
          localObject1 = localObject4;
          continue;
          i += 1;
          continue;
          localObject6 = null;
          continue;
        }
        localObject4 = localObject1;
        if (k != n) {
          continue;
        }
        localObject5 = "Y";
        localObject3 = localObject5;
        localObject4 = localObject1;
        if (j != 1) {
          continue;
        }
        localObject4 = "N";
        localObject3 = localObject5;
        continue;
        localObject4 = "N";
      }
      catch (Throwable localThrowable2)
      {
        localObject4 = "X";
        localObject5 = localObject2;
        localObject2 = localThrowable2;
        continue;
      }
      localObject6 = "N";
      localObject5 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject6;
      break;
      break;
    }
  }
  
  /* Error */
  private String getSensor2()
  {
    // Byte code:
    //   0: ldc_w 300
    //   3: iconst_0
    //   4: anewarray 86	java/lang/Object
    //   7: invokestatic 210	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: ldc 212
    //   12: astore_2
    //   13: ldc 212
    //   15: astore_3
    //   16: aload_0
    //   17: invokespecial 303	com/tencent/beacon/model/ModuleImpl:hasWIFIDevice	()Z
    //   20: ifeq +180 -> 200
    //   23: ldc_w 263
    //   26: astore 6
    //   28: getstatic 220	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   31: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   34: bipush 10
    //   36: if_icmplt +242 -> 278
    //   39: aload_2
    //   40: astore 5
    //   42: aload_3
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 25	com/tencent/beacon/core/c:mContext	Landroid/content/Context;
    //   49: astore 7
    //   51: aload_2
    //   52: astore 5
    //   54: aload_3
    //   55: astore 4
    //   57: aload 7
    //   59: ldc 255
    //   61: invokevirtual 106	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   64: checkcast 257	android/hardware/SensorManager
    //   67: astore 7
    //   69: aload_2
    //   70: astore 5
    //   72: aload_3
    //   73: astore 4
    //   75: aload 7
    //   77: iconst_1
    //   78: invokevirtual 261	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull +124 -> 207
    //   86: ldc_w 263
    //   89: astore_2
    //   90: aload_2
    //   91: astore 5
    //   93: aload_3
    //   94: astore 4
    //   96: aload 7
    //   98: iconst_5
    //   99: invokevirtual 261	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +109 -> 213
    //   107: ldc_w 263
    //   110: astore_3
    //   111: aload_2
    //   112: astore 5
    //   114: aload_3
    //   115: astore 4
    //   117: invokestatic 309	android/bluetooth/BluetoothAdapter:getDefaultAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   120: astore 7
    //   122: aload 7
    //   124: ifnonnull +95 -> 219
    //   127: ldc 253
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 25	com/tencent/beacon/core/c:mContext	Landroid/content/Context;
    //   135: invokevirtual 313	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   138: astore 5
    //   140: aload 5
    //   142: ldc_w 315
    //   145: invokevirtual 321	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   148: istore_1
    //   149: iload_1
    //   150: ifeq +77 -> 227
    //   153: ldc_w 263
    //   156: astore 5
    //   158: aload_3
    //   159: astore 7
    //   161: aload_2
    //   162: astore_3
    //   163: aload 7
    //   165: astore_2
    //   166: new 135	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   173: aload 6
    //   175: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 4
    //   188: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 5
    //   193: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: areturn
    //   200: ldc 253
    //   202: astore 6
    //   204: goto -176 -> 28
    //   207: ldc 253
    //   209: astore_2
    //   210: goto -120 -> 90
    //   213: ldc 253
    //   215: astore_3
    //   216: goto -105 -> 111
    //   219: ldc_w 263
    //   222: astore 4
    //   224: goto -93 -> 131
    //   227: ldc 253
    //   229: astore 7
    //   231: aload_2
    //   232: astore 5
    //   234: aload_3
    //   235: astore_2
    //   236: aload 5
    //   238: astore_3
    //   239: aload 7
    //   241: astore 5
    //   243: goto -77 -> 166
    //   246: astore_2
    //   247: ldc 212
    //   249: astore 7
    //   251: aload 5
    //   253: astore_3
    //   254: aload 4
    //   256: astore_2
    //   257: aload 7
    //   259: astore 4
    //   261: ldc_w 323
    //   264: iconst_0
    //   265: anewarray 86	java/lang/Object
    //   268: invokestatic 97	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: ldc 212
    //   273: astore 5
    //   275: goto -109 -> 166
    //   278: ldc 212
    //   280: astore 4
    //   282: ldc 212
    //   284: astore_3
    //   285: ldc 212
    //   287: astore_2
    //   288: ldc 212
    //   290: astore 5
    //   292: goto -126 -> 166
    //   295: astore 5
    //   297: aload_2
    //   298: astore 5
    //   300: aload_3
    //   301: astore_2
    //   302: aload 5
    //   304: astore_3
    //   305: goto -44 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ModuleImpl
    //   148	2	1	bool	boolean
    //   12	224	2	localObject1	Object
    //   246	1	2	localThrowable1	Throwable
    //   256	46	2	localObject2	Object
    //   15	290	3	localObject3	Object
    //   43	238	4	localObject4	Object
    //   40	251	5	localObject5	Object
    //   295	1	5	localThrowable2	Throwable
    //   298	5	5	localObject6	Object
    //   26	177	6	str	String
    //   49	209	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   45	51	246	java/lang/Throwable
    //   57	69	246	java/lang/Throwable
    //   75	82	246	java/lang/Throwable
    //   96	103	246	java/lang/Throwable
    //   117	122	246	java/lang/Throwable
    //   131	140	295	java/lang/Throwable
    //   140	149	295	java/lang/Throwable
  }
  
  private String getWifiSSID()
  {
    try
    {
      Object localObject = this.mContext;
      localObject = ((WifiManager)((Context)localObject).getSystemService("wifi")).getConnectionInfo();
      if (((WifiInfo)localObject).getBSSID() != null)
      {
        localObject = ((WifiInfo)localObject).getSSID();
        return localObject;
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.e.d.a(localThrowable);
      com.tencent.beacon.core.e.d.b("[model] getWifiSSID error!", new Object[0]);
    }
    return "";
  }
  
  private String hasGPSDevice()
  {
    Object localObject = (LocationManager)this.mContext.getSystemService("location");
    if (localObject == null) {
      return "N";
    }
    localObject = ((LocationManager)localObject).getAllProviders();
    if (localObject == null) {
      return "N";
    }
    if (((List)localObject).contains("gps")) {
      return "Y";
    }
    return "N";
  }
  
  private boolean hasWIFIDevice()
  {
    return (WifiManager)this.mContext.getSystemService("wifi") != null;
  }
  
  private void modelEvent()
  {
    f localf = f.a(this.mContext);
    try
    {
      Object localObject = localf.a("rqd_model", "");
      boolean bool = b.a().equals(localObject);
      if (bool) {
        return;
      }
      localObject = new a(this);
      com.tencent.beacon.core.a.d.a().a((Runnable)localObject, 50000L);
      try
      {
        localf = localf.b();
        localf.a("rqd_model", b.a()).a();
        return;
      }
      catch (Exception localException1)
      {
        com.tencent.beacon.core.e.d.b("[model] save upload flag failed!", new Object[0]);
        com.tencent.beacon.core.e.d.a(localException1);
        return;
      }
      return;
    }
    catch (Exception localException2)
    {
      com.tencent.beacon.core.e.d.b("[model] get upload flag failed! ", new Object[0]);
    }
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    com.tencent.beacon.core.e.d.d("[module] model module > %S", new Object[] { "" + this.modelEventUsable });
    if (this.modelEventUsable) {
      modelEvent();
    }
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if (paramInt == 1) {
      this.modelEventUsable = b.a((String)paramMap.get("modelEventUsable"), this.modelEventUsable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.model.ModuleImpl
 * JD-Core Version:    0.7.0.1
 */
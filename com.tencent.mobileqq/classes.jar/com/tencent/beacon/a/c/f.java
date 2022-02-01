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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.base.net.c.e.a;
import com.tencent.beacon.base.util.b;
import com.tencent.beacon.base.util.d;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
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
  private String n = "";
  private String o = "";
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  
  private f()
  {
    com.tencent.beacon.base.net.c.e.a(this.b, this);
    U();
    N();
  }
  
  private void O()
  {
    try
    {
      Enumeration localEnumeration = NetworkMonitor.getNetworkInterfaces();
      if (localEnumeration != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        while (localEnumeration.hasMoreElements())
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
          byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
          if ((arrayOfByte != null) && (arrayOfByte.length != 0))
          {
            localStringBuilder.append(localNetworkInterface.getName());
            localStringBuilder.append(":");
            localStringBuilder.append(a(arrayOfByte));
            localStringBuilder.append(",");
          }
        }
        this.j = localStringBuilder.toString();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
  }
  
  /* Error */
  private void P()
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/beacon/e/b:a	()Lcom/tencent/beacon/e/b;
    //   3: invokevirtual 157	com/tencent/beacon/e/b:d	()Z
    //   6: ifne +20 -> 26
    //   9: ldc 159
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iconst_0
    //   18: invokestatic 165	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 168	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: return
    //   26: aload_0
    //   27: getfield 70	com/tencent/beacon/a/c/f:q	Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: aload_0
    //   35: getfield 84	com/tencent/beacon/a/c/f:b	Landroid/content/Context;
    //   38: invokevirtual 174	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: astore_1
    //   42: aload_1
    //   43: ldc 176
    //   45: invokestatic 182	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +23 -> 73
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   58: putfield 42	com/tencent/beacon/a/c/f:c	Ljava/lang/String;
    //   61: goto +12 -> 73
    //   64: astore_1
    //   65: goto +14 -> 79
    //   68: astore_1
    //   69: aload_1
    //   70: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 70	com/tencent/beacon/a/c/f:q	Z
    //   78: return
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 70	com/tencent/beacon/a/c/f:q	Z
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	f
    //   41	14	1	localObject1	Object
    //   64	1	1	localObject2	Object
    //   68	17	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   34	42	64	finally
    //   42	49	64	finally
    //   53	61	64	finally
    //   69	73	64	finally
    //   34	42	68	java/lang/Throwable
    //   42	49	68	java/lang/Throwable
    //   53	61	68	java/lang/Throwable
  }
  
  /* Error */
  private void Q()
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/beacon/e/b:a	()Lcom/tencent/beacon/e/b;
    //   3: invokevirtual 190	com/tencent/beacon/e/b:g	()Z
    //   6: ifne +20 -> 26
    //   9: ldc 192
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iconst_0
    //   18: invokestatic 165	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 168	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: return
    //   26: aload_0
    //   27: getfield 84	com/tencent/beacon/a/c/f:b	Landroid/content/Context;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +13 -> 45
    //   35: ldc 194
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 72	com/tencent/beacon/a/c/f:r	Z
    //   49: ifeq +4 -> 53
    //   52: return
    //   53: aload_1
    //   54: invokestatic 201	com/tencent/beacon/a/c/b:f	(Landroid/content/Context;)Z
    //   57: ifeq +155 -> 212
    //   60: aload_0
    //   61: getfield 84	com/tencent/beacon/a/c/f:b	Landroid/content/Context;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc 203
    //   68: invokevirtual 207	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   71: checkcast 209	android/telephony/TelephonyManager
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +99 -> 175
    //   79: aload_1
    //   80: invokestatic 215	com/tencent/mobileqq/qmethodmonitor/monitor/PhoneInfoMonitor:getDeviceId	(Landroid/telephony/TelephonyManager;)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +11 -> 96
    //   88: aload_0
    //   89: aload_2
    //   90: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   93: putfield 46	com/tencent/beacon/a/c/f:e	Ljava/lang/String;
    //   96: getstatic 221	android/os/Build$VERSION:SDK_INT	I
    //   99: bipush 26
    //   101: if_icmpge +22 -> 123
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 46	com/tencent/beacon/a/c/f:e	Ljava/lang/String;
    //   109: putfield 48	com/tencent/beacon/a/c/f:f	Ljava/lang/String;
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 46	com/tencent/beacon/a/c/f:e	Ljava/lang/String;
    //   117: putfield 52	com/tencent/beacon/a/c/f:h	Ljava/lang/String;
    //   120: goto +38 -> 158
    //   123: aload_1
    //   124: iconst_1
    //   125: invokestatic 225	com/tencent/mobileqq/qmethodmonitor/monitor/PhoneInfoMonitor:getImei	(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +11 -> 141
    //   133: aload_0
    //   134: aload_2
    //   135: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   138: putfield 48	com/tencent/beacon/a/c/f:f	Ljava/lang/String;
    //   141: aload_1
    //   142: invokevirtual 228	android/telephony/TelephonyManager:getMeid	()Ljava/lang/String;
    //   145: astore_2
    //   146: aload_2
    //   147: ifnull +11 -> 158
    //   150: aload_0
    //   151: aload_2
    //   152: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   155: putfield 52	com/tencent/beacon/a/c/f:h	Ljava/lang/String;
    //   158: aload_1
    //   159: invokestatic 231	com/tencent/mobileqq/qmethodmonitor/monitor/PhoneInfoMonitor:getSubscriberId	(Landroid/telephony/TelephonyManager;)Ljava/lang/String;
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +11 -> 175
    //   167: aload_0
    //   168: aload_1
    //   169: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   172: putfield 50	com/tencent/beacon/a/c/f:g	Ljava/lang/String;
    //   175: aload_0
    //   176: iconst_1
    //   177: putfield 72	com/tencent/beacon/a/c/f:r	Z
    //   180: return
    //   181: astore_1
    //   182: goto +23 -> 205
    //   185: astore_1
    //   186: ldc 233
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 235	com/tencent/beacon/base/util/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_1
    //   196: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   199: aload_0
    //   200: iconst_1
    //   201: putfield 72	com/tencent/beacon/a/c/f:r	Z
    //   204: return
    //   205: aload_0
    //   206: iconst_1
    //   207: putfield 72	com/tencent/beacon/a/c/f:r	Z
    //   210: aload_1
    //   211: athrow
    //   212: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	f
    //   30	139	1	localObject1	Object
    //   181	1	1	localObject2	Object
    //   185	26	1	localThrowable	Throwable
    //   83	69	2	str	String
    // Exception table:
    //   from	to	target	type
    //   60	65	181	finally
    //   65	75	181	finally
    //   79	84	181	finally
    //   88	96	181	finally
    //   96	120	181	finally
    //   123	129	181	finally
    //   133	141	181	finally
    //   141	146	181	finally
    //   150	158	181	finally
    //   158	163	181	finally
    //   167	175	181	finally
    //   186	199	181	finally
    //   60	65	185	java/lang/Throwable
    //   65	75	185	java/lang/Throwable
    //   79	84	185	java/lang/Throwable
    //   88	96	185	java/lang/Throwable
    //   96	120	185	java/lang/Throwable
    //   123	129	185	java/lang/Throwable
    //   133	141	185	java/lang/Throwable
    //   141	146	185	java/lang/Throwable
    //   150	158	185	java/lang/Throwable
    //   158	163	185	java/lang/Throwable
    //   167	175	185	java/lang/Throwable
  }
  
  /* Error */
  private void R()
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/beacon/e/b:a	()Lcom/tencent/beacon/e/b;
    //   3: invokevirtual 238	com/tencent/beacon/e/b:i	()Z
    //   6: ifne +20 -> 26
    //   9: ldc 240
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iconst_0
    //   18: invokestatic 165	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 168	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: return
    //   26: aload_0
    //   27: getfield 68	com/tencent/beacon/a/c/f:p	Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: aload_0
    //   35: invokespecial 242	com/tencent/beacon/a/c/f:O	()V
    //   38: aload_0
    //   39: invokespecial 245	com/tencent/beacon/a/c/f:S	()V
    //   42: aload_0
    //   43: getfield 84	com/tencent/beacon/a/c/f:b	Landroid/content/Context;
    //   46: astore_1
    //   47: aload_1
    //   48: ldc 247
    //   50: invokevirtual 207	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: checkcast 249	android/net/wifi/WifiManager
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +54 -> 112
    //   61: aload_1
    //   62: invokestatic 253	com/tencent/mobileqq/qmethodmonitor/monitor/NetworkMonitor:getConnectionInfo	(Landroid/net/wifi/WifiManager;)Landroid/net/wifi/WifiInfo;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +45 -> 112
    //   70: aload_1
    //   71: invokevirtual 258	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   74: ifnull +11 -> 85
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 258	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   82: putfield 58	com/tencent/beacon/a/c/f:k	Ljava/lang/String;
    //   85: aload_1
    //   86: invokevirtual 261	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   89: ifnull +23 -> 112
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 261	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   97: putfield 60	com/tencent/beacon/a/c/f:l	Ljava/lang/String;
    //   100: goto +12 -> 112
    //   103: astore_1
    //   104: goto +14 -> 118
    //   107: astore_1
    //   108: aload_1
    //   109: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   112: aload_0
    //   113: iconst_1
    //   114: putfield 68	com/tencent/beacon/a/c/f:p	Z
    //   117: return
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 68	com/tencent/beacon/a/c/f:p	Z
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	f
    //   46	48	1	localObject1	Object
    //   103	1	1	localObject2	Object
    //   107	17	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   34	47	103	finally
    //   47	57	103	finally
    //   61	66	103	finally
    //   70	85	103	finally
    //   85	100	103	finally
    //   108	112	103	finally
    //   34	47	107	java/lang/Throwable
    //   47	57	107	java/lang/Throwable
    //   61	66	107	java/lang/Throwable
    //   70	85	107	java/lang/Throwable
    //   85	100	107	java/lang/Throwable
  }
  
  private void S()
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject;
        if (Build.VERSION.SDK_INT < 23)
        {
          localObject = this.b.getApplicationContext();
          localObject = (WifiManager)((Context)localObject).getSystemService("wifi");
          if (localObject != null)
          {
            localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
            if ((localObject != null) && (((WifiInfo)localObject).getMacAddress() != null)) {
              this.i = ((WifiInfo)localObject).getMacAddress().toLowerCase();
            }
          }
        }
        else
        {
          localObject = new String[2];
          i1 = 0;
          localObject[0] = "/sys/class/net/wlan0/address";
          localObject[1] = "/sys/devices/virtual/net/wlan0/address";
          int i2 = localObject.length;
          if (i1 < i2)
          {
            this.i = b.e(localObject[i1]).trim();
            if (this.i.length() <= 0) {
              break label215;
            }
            this.i = this.i.toLowerCase();
          }
          if (TextUtils.isEmpty(this.i))
          {
            localObject = NetworkMonitor.getNetworkInterfaces();
            if ((localObject != null) && (((Enumeration)localObject).hasMoreElements()))
            {
              NetworkInterface localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
              byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
              if ((!"wlan0".equals(localNetworkInterface.getName())) || (arrayOfByte == null) || (arrayOfByte.length == 0)) {
                continue;
              }
              this.i = a(arrayOfByte).toString();
              return;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.base.util.c.a(localThrowable);
      }
      return;
      label215:
      i1 += 1;
    }
  }
  
  /* Error */
  private void T()
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/beacon/e/b:a	()Lcom/tencent/beacon/e/b;
    //   3: invokevirtual 298	com/tencent/beacon/e/b:j	()Z
    //   6: ifne +21 -> 27
    //   9: ldc_w 300
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iconst_0
    //   19: invokestatic 165	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: aastore
    //   23: invokestatic 168	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: return
    //   27: aload_0
    //   28: getfield 74	com/tencent/beacon/a/c/f:s	Z
    //   31: ifeq +4 -> 35
    //   34: return
    //   35: invokestatic 305	com/tencent/beacon/e/a:a	()Lcom/tencent/beacon/e/a;
    //   38: ldc_w 307
    //   41: invokevirtual 309	com/tencent/beacon/e/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   44: iconst_1
    //   45: invokestatic 312	com/tencent/beacon/base/util/b:a	(Ljava/lang/String;Z)Z
    //   48: istore_1
    //   49: aload_0
    //   50: getfield 84	com/tencent/beacon/a/c/f:b	Landroid/content/Context;
    //   53: iload_1
    //   54: invokestatic 314	com/tencent/beacon/base/util/c:a	()Z
    //   57: invokestatic 320	com/tencent/qmsp/sdk/u/U:init_o	(Landroid/content/Context;ZZ)V
    //   60: new 322	com/tencent/beacon/a/c/d
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 325	com/tencent/beacon/a/c/d:<init>	(Lcom/tencent/beacon/a/c/f;)V
    //   68: invokestatic 329	com/tencent/qmsp/sdk/u/U:getOAID	(Lcom/tencent/qmsp/sdk/base/IVendorCallback;)V
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 84	com/tencent/beacon/a/c/f:b	Landroid/content/Context;
    //   76: invokestatic 333	com/tencent/qmsp/sdk/u/U:getOAIDSync	(Landroid/content/Context;)Ljava/lang/String;
    //   79: putfield 66	com/tencent/beacon/a/c/f:o	Ljava/lang/String;
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 74	com/tencent/beacon/a/c/f:s	Z
    //   87: return
    //   88: astore_2
    //   89: goto +14 -> 103
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield 74	com/tencent/beacon/a/c/f:s	Z
    //   102: return
    //   103: aload_0
    //   104: iconst_1
    //   105: putfield 74	com/tencent/beacon/a/c/f:s	Z
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	f
    //   48	6	1	bool	boolean
    //   88	1	2	localObject	Object
    //   92	17	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   49	82	88	finally
    //   93	97	88	finally
    //   49	82	92	java/lang/Throwable
  }
  
  private void U()
  {
    this.n = V();
  }
  
  private String V()
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
        int i1 = ((NetworkInfo)localObject4).getType();
        if (i1 == 1)
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
                break label237;
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
      label237:
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
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfByte[i1]) }));
      i1 += 1;
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
    //   0: new 389	java/io/FileReader
    //   3: dup
    //   4: ldc_w 391
    //   7: invokespecial 394	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: new 396	java/io/BufferedReader
    //   15: dup
    //   16: aload 4
    //   18: sipush 8192
    //   21: invokespecial 399	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore 6
    //   28: aload 4
    //   30: astore 5
    //   32: aload_3
    //   33: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore 7
    //   38: aload 7
    //   40: ifnull +143 -> 183
    //   43: aload_3
    //   44: astore 6
    //   46: aload 4
    //   48: astore 5
    //   50: aload 7
    //   52: ldc_w 404
    //   55: iconst_2
    //   56: invokevirtual 408	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   59: iconst_1
    //   60: aaload
    //   61: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   64: astore 7
    //   66: aload_3
    //   67: astore 6
    //   69: aload 4
    //   71: astore 5
    //   73: aload 7
    //   75: ldc_w 410
    //   78: ldc 40
    //   80: invokevirtual 414	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   83: invokevirtual 279	java/lang/String:trim	()Ljava/lang/String;
    //   86: invokestatic 420	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: ldc2_w 421
    //   92: ldiv
    //   93: lstore_1
    //   94: aload_3
    //   95: astore 6
    //   97: aload 4
    //   99: astore 5
    //   101: new 106	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   108: astore 7
    //   110: aload_3
    //   111: astore 6
    //   113: aload 4
    //   115: astore 5
    //   117: aload 7
    //   119: lload_1
    //   120: invokevirtual 425	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: astore 6
    //   127: aload 4
    //   129: astore 5
    //   131: aload 7
    //   133: ldc 40
    //   135: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: astore 6
    //   142: aload 4
    //   144: astore 5
    //   146: aload 7
    //   148: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore 7
    //   153: aload_3
    //   154: invokevirtual 428	java/io/BufferedReader:close	()V
    //   157: aload 4
    //   159: invokevirtual 429	java/io/FileReader:close	()V
    //   162: aload 7
    //   164: areturn
    //   165: astore_3
    //   166: ldc_w 431
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_3
    //   177: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   180: aload 7
    //   182: areturn
    //   183: aload_3
    //   184: invokevirtual 428	java/io/BufferedReader:close	()V
    //   187: aload 4
    //   189: invokevirtual 429	java/io/FileReader:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_3
    //   195: ldc_w 431
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload_3
    //   206: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_3
    //   212: aload 5
    //   214: astore 4
    //   216: goto +108 -> 324
    //   219: astore 7
    //   221: goto +35 -> 256
    //   224: astore_3
    //   225: aconst_null
    //   226: astore 6
    //   228: goto +96 -> 324
    //   231: astore 7
    //   233: aconst_null
    //   234: astore_3
    //   235: goto +21 -> 256
    //   238: astore_3
    //   239: aconst_null
    //   240: astore 6
    //   242: aload 6
    //   244: astore 4
    //   246: goto +78 -> 324
    //   249: astore 7
    //   251: aconst_null
    //   252: astore_3
    //   253: aload_3
    //   254: astore 4
    //   256: aload_3
    //   257: astore 6
    //   259: aload 4
    //   261: astore 5
    //   263: ldc_w 433
    //   266: iconst_0
    //   267: anewarray 4	java/lang/Object
    //   270: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_3
    //   274: astore 6
    //   276: aload 4
    //   278: astore 5
    //   280: aload 7
    //   282: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   285: aload_3
    //   286: ifnull +10 -> 296
    //   289: aload_3
    //   290: invokevirtual 428	java/io/BufferedReader:close	()V
    //   293: goto +3 -> 296
    //   296: aload 4
    //   298: ifnull +24 -> 322
    //   301: aload 4
    //   303: invokevirtual 429	java/io/FileReader:close	()V
    //   306: aconst_null
    //   307: areturn
    //   308: ldc_w 431
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_3
    //   319: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   322: aconst_null
    //   323: areturn
    //   324: aload 6
    //   326: ifnull +11 -> 337
    //   329: aload 6
    //   331: invokevirtual 428	java/io/BufferedReader:close	()V
    //   334: goto +3 -> 337
    //   337: aload 4
    //   339: ifnull +26 -> 365
    //   342: aload 4
    //   344: invokevirtual 429	java/io/FileReader:close	()V
    //   347: goto +18 -> 365
    //   350: ldc_w 431
    //   353: iconst_0
    //   354: anewarray 4	java/lang/Object
    //   357: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload 4
    //   362: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   365: aload_3
    //   366: athrow
    //   367: astore_3
    //   368: goto -60 -> 308
    //   371: astore 4
    //   373: goto -23 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	f
    //   93	27	1	l1	long
    //   24	130	3	localBufferedReader	java.io.BufferedReader
    //   165	19	3	localThrowable1	Throwable
    //   194	12	3	localThrowable2	Throwable
    //   211	1	3	localObject1	Object
    //   224	1	3	localObject2	Object
    //   234	1	3	localObject3	Object
    //   238	1	3	localObject4	Object
    //   252	114	3	localThrowable3	Throwable
    //   367	1	3	localThrowable4	Throwable
    //   10	351	4	localObject5	Object
    //   371	1	4	localThrowable5	Throwable
    //   30	249	5	localObject6	Object
    //   26	304	6	localObject7	Object
    //   36	145	7	localObject8	Object
    //   219	1	7	localThrowable6	Throwable
    //   231	1	7	localThrowable7	Throwable
    //   249	32	7	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   153	162	165	java/lang/Throwable
    //   183	192	194	java/lang/Throwable
    //   32	38	211	finally
    //   50	66	211	finally
    //   73	94	211	finally
    //   101	110	211	finally
    //   117	124	211	finally
    //   131	139	211	finally
    //   146	153	211	finally
    //   263	273	211	finally
    //   280	285	211	finally
    //   32	38	219	java/lang/Throwable
    //   50	66	219	java/lang/Throwable
    //   73	94	219	java/lang/Throwable
    //   101	110	219	java/lang/Throwable
    //   117	124	219	java/lang/Throwable
    //   131	139	219	java/lang/Throwable
    //   146	153	219	java/lang/Throwable
    //   12	25	224	finally
    //   12	25	231	java/lang/Throwable
    //   0	12	238	finally
    //   0	12	249	java/lang/Throwable
    //   289	293	367	java/lang/Throwable
    //   301	306	367	java/lang/Throwable
    //   329	334	371	java/lang/Throwable
    //   342	347	371	java/lang/Throwable
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
    ArrayList localArrayList = b.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public String D()
  {
    if (!TextUtils.isEmpty(this.m)) {
      return this.m;
    }
    Object localObject = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = ((StatFs)localObject).getBlockSize();
    long l2 = ((StatFs)localObject).getBlockCount();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l2 * l1 / 1024L / 1024L);
    ((StringBuilder)localObject).append("");
    this.m = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[DeviceInfo] Rom Size:");
    ((StringBuilder)localObject).append(this.m);
    com.tencent.beacon.base.util.c.a(((StringBuilder)localObject).toString(), new Object[0]);
    return this.m;
  }
  
  public long E()
  {
    if (!c()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i1 = localStatFs.getBlockSize();
      long l1 = localStatFs.getBlockCount() * i1 / 1024L / 1024L;
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
    int i1 = Integer.parseInt(Build.VERSION.SDK);
    String str3 = "X";
    Object localObject1;
    Object localObject2;
    Object localObject5;
    label509:
    String str2;
    if (i1 >= 10)
    {
      try
      {
        Class localClass = Class.forName("android.hardware.Camera");
        int i2 = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (i2 == 0) {}
        for (localObject1 = "N";; localObject1 = "X")
        {
          localObject2 = localObject1;
          break;
          localObject2 = Class.forName("android.hardware.Camera$CameraInfo");
          Object localObject6 = ((Class)localObject2).newInstance();
          Method[] arrayOfMethod = localClass.getMethods();
          localObject1 = null;
          int i3 = arrayOfMethod.length;
          i1 = 0;
          for (;;)
          {
            localObject5 = localObject1;
            if (i1 < i3)
            {
              localObject5 = arrayOfMethod[i1];
              try
              {
                localObject7 = ((Method)localObject5).getName();
                boolean bool = ((String)localObject7).equals("getCameraInfo");
                if (!bool) {
                  i1 += 1;
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
            i1 = 0;
            for (;;)
            {
              if (i1 < i2) {
                try
                {
                  ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(i1), localObject6 });
                  i3 = ((Field)localObject7).getInt(localObject6);
                  int i4 = localField1.getInt(localObject6);
                  int i5 = localField2.getInt(localObject6);
                  Object localObject3;
                  if (i3 == i4)
                  {
                    if (i2 == 1)
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
                    if (i3 == i5) {
                      if (i2 == 1)
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
                  i1 += 1;
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
    if (L()) {
      str2 = "Y";
    } else {
      str2 = "N";
    }
    int i1 = Integer.parseInt(Build.VERSION.SDK);
    String str1 = "X";
    if (i1 >= 10) {}
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] Wifi BSSID:");
    localStringBuilder.append(this.k);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.k;
  }
  
  public String J()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] Wifi SSID:");
    localStringBuilder.append(this.l);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.l;
  }
  
  public String K()
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
  
  public boolean L()
  {
    return (WifiManager)this.b.getSystemService("wifi") != null;
  }
  
  /* Error */
  public boolean M()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 396	java/io/BufferedReader
    //   8: dup
    //   9: new 660	java/io/InputStreamReader
    //   12: dup
    //   13: invokestatic 666	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   16: iconst_2
    //   17: anewarray 184	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 668
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc_w 670
    //   31: aastore
    //   32: invokevirtual 674	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 680	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokestatic 686	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   41: invokespecial 689	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   44: invokespecial 692	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +26 -> 82
    //   59: aload_3
    //   60: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: ldc_w 694
    //   68: invokevirtual 697	java/lang/String:indexOf	(Ljava/lang/String;)I
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
    //   85: anewarray 699	java/io/Closeable
    //   88: dup
    //   89: iconst_0
    //   90: aload 4
    //   92: aastore
    //   93: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
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
    //   129: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   132: iconst_1
    //   133: anewarray 699	java/io/Closeable
    //   136: dup
    //   137: iconst_0
    //   138: aload 4
    //   140: aastore
    //   141: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore 5
    //   148: goto -41 -> 107
    //   151: iconst_1
    //   152: anewarray 699	java/io/Closeable
    //   155: dup
    //   156: iconst_0
    //   157: aload 4
    //   159: aastore
    //   160: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   163: goto +5 -> 168
    //   166: aload_3
    //   167: athrow
    //   168: goto -2 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	f
    //   71	4	1	i1	int
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
  
  public void N()
  {
    T();
    Q();
    R();
    P();
  }
  
  public String a(Context paramContext)
  {
    try
    {
      int i1 = Integer.parseInt(Build.VERSION.SDK);
      if (i1 < 9)
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
    U();
  }
  
  public void b()
  {
    U();
  }
  
  public boolean c()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] Mac Address:");
    localStringBuilder.append(this.j);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.j;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] Android ID:");
    localStringBuilder.append(this.c);
    com.tencent.beacon.base.util.c.d(localStringBuilder.toString(), new Object[0]);
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
    //   7: invokestatic 666	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   10: iconst_2
    //   11: anewarray 184	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 668
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: ldc_w 742
    //   25: aastore
    //   26: invokevirtual 674	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   29: invokevirtual 680	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   32: astore 5
    //   34: aload_3
    //   35: astore_2
    //   36: new 396	java/io/BufferedReader
    //   39: dup
    //   40: new 660	java/io/InputStreamReader
    //   43: dup
    //   44: aload 5
    //   46: ldc_w 744
    //   49: invokestatic 747	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   52: invokespecial 689	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   55: invokespecial 692	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +18 -> 83
    //   68: aload_2
    //   69: invokevirtual 279	java/lang/String:trim	()Ljava/lang/String;
    //   72: invokestatic 543	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   75: sipush 1000
    //   78: idiv
    //   79: istore_1
    //   80: goto +5 -> 85
    //   83: iconst_0
    //   84: istore_1
    //   85: iconst_1
    //   86: anewarray 699	java/io/Closeable
    //   89: dup
    //   90: iconst_0
    //   91: aload_3
    //   92: aastore
    //   93: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
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
    //   126: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   129: iconst_1
    //   130: anewarray 699	java/io/Closeable
    //   133: dup
    //   134: iconst_0
    //   135: aload_3
    //   136: aastore
    //   137: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore 4
    //   144: goto -37 -> 107
    //   147: iconst_1
    //   148: anewarray 699	java/io/Closeable
    //   151: dup
    //   152: iconst_0
    //   153: aload_3
    //   154: aastore
    //   155: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   158: goto +5 -> 163
    //   161: aload_2
    //   162: athrow
    //   163: goto -2 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	f
    //   79	18	1	i1	int
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
    //   0: ldc 40
    //   2: astore 4
    //   4: aconst_null
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_3
    //   10: astore_2
    //   11: invokestatic 666	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: iconst_2
    //   15: anewarray 184	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 668
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 670
    //   29: aastore
    //   30: invokevirtual 674	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   33: invokevirtual 680	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   36: astore 6
    //   38: aload_3
    //   39: astore_2
    //   40: new 396	java/io/BufferedReader
    //   43: dup
    //   44: new 660	java/io/InputStreamReader
    //   47: dup
    //   48: aload 6
    //   50: ldc_w 744
    //   53: invokestatic 747	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   56: invokespecial 689	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   59: invokespecial 692	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore 5
    //   69: aload 4
    //   71: astore_2
    //   72: aload 5
    //   74: ifnull +34 -> 108
    //   77: aload 5
    //   79: ldc_w 749
    //   82: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   85: istore_1
    //   86: iload_1
    //   87: ifeq -24 -> 63
    //   90: aload 5
    //   92: aload 5
    //   94: ldc 133
    //   96: invokevirtual 697	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   99: iconst_1
    //   100: iadd
    //   101: invokevirtual 755	java/lang/String:substring	(I)Ljava/lang/String;
    //   104: invokevirtual 279	java/lang/String:trim	()Ljava/lang/String;
    //   107: astore_2
    //   108: iconst_1
    //   109: anewarray 699	java/io/Closeable
    //   112: dup
    //   113: iconst_0
    //   114: aload_3
    //   115: aastore
    //   116: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   119: aload_2
    //   120: areturn
    //   121: astore_2
    //   122: goto +47 -> 169
    //   125: astore 4
    //   127: goto +16 -> 143
    //   130: aload_2
    //   131: astore_3
    //   132: aload 4
    //   134: astore_2
    //   135: goto +34 -> 169
    //   138: astore 4
    //   140: aload 5
    //   142: astore_3
    //   143: aload_3
    //   144: astore_2
    //   145: aload 4
    //   147: invokestatic 149	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   150: iconst_1
    //   151: anewarray 699	java/io/Closeable
    //   154: dup
    //   155: iconst_0
    //   156: aload_3
    //   157: aastore
    //   158: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   161: ldc 40
    //   163: areturn
    //   164: astore 4
    //   166: goto -36 -> 130
    //   169: iconst_1
    //   170: anewarray 699	java/io/Closeable
    //   173: dup
    //   174: iconst_0
    //   175: aload_3
    //   176: aastore
    //   177: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   180: goto +5 -> 185
    //   183: aload_2
    //   184: athrow
    //   185: goto -2 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	f
    //   85	2	1	bool	boolean
    //   10	110	2	localObject1	Object
    //   121	10	2	localObject2	Object
    //   134	50	2	localObject3	Object
    //   5	171	3	localObject4	Object
    //   2	68	4	str1	String
    //   125	8	4	localThrowable1	Throwable
    //   138	8	4	localThrowable2	Throwable
    //   164	1	4	localObject5	Object
    //   7	134	5	str2	String
    //   36	13	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   63	69	121	finally
    //   77	86	121	finally
    //   90	108	121	finally
    //   63	69	125	java/lang/Throwable
    //   77	86	125	java/lang/Throwable
    //   90	108	125	java/lang/Throwable
    //   11	38	138	java/lang/Throwable
    //   40	63	138	java/lang/Throwable
    //   11	38	164	finally
    //   40	63	164	finally
    //   145	150	164	finally
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] IMEI:");
    localStringBuilder.append(this.e);
    com.tencent.beacon.base.util.c.d(localStringBuilder.toString(), new Object[0]);
    return this.e;
  }
  
  public String n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] IMEI2:");
    localStringBuilder.append(this.f);
    com.tencent.beacon.base.util.c.d(localStringBuilder.toString(), new Object[0]);
    return this.f;
  }
  
  public String o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] imsi:");
    localStringBuilder.append(this.g);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.g;
  }
  
  public boolean q()
  {
    return d.d();
  }
  
  public String r()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public String s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] Mac Address:");
    localStringBuilder.append(this.i);
    com.tencent.beacon.base.util.c.a(localStringBuilder.toString(), new Object[0]);
    return this.i;
  }
  
  public String t()
  {
    return Build.MANUFACTURER;
  }
  
  public String u()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DeviceInfo] meid:");
    localStringBuilder.append(this.h);
    com.tencent.beacon.base.util.c.d(localStringBuilder.toString(), new Object[0]);
    return this.h;
  }
  
  /* Error */
  public String v()
  {
    // Byte code:
    //   0: new 106	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: new 396	java/io/BufferedReader
    //   17: dup
    //   18: new 389	java/io/FileReader
    //   21: dup
    //   22: new 477	java/io/File
    //   25: dup
    //   26: ldc_w 811
    //   29: invokespecial 812	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 815	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   35: invokespecial 692	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload 5
    //   43: aload_2
    //   44: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: iconst_1
    //   52: anewarray 699	java/io/Closeable
    //   55: dup
    //   56: iconst_0
    //   57: aload_2
    //   58: aastore
    //   59: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   62: goto +34 -> 96
    //   65: astore_1
    //   66: aconst_null
    //   67: astore_2
    //   68: goto +287 -> 355
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: ldc_w 817
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: iconst_1
    //   86: anewarray 699	java/io/Closeable
    //   89: dup
    //   90: iconst_0
    //   91: aload_2
    //   92: aastore
    //   93: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   96: aload 5
    //   98: ldc 141
    //   100: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: new 396	java/io/BufferedReader
    //   107: dup
    //   108: new 389	java/io/FileReader
    //   111: dup
    //   112: new 477	java/io/File
    //   115: dup
    //   116: ldc_w 819
    //   119: invokespecial 812	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: invokespecial 815	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   125: invokespecial 692	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload 5
    //   133: aload_2
    //   134: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: iconst_1
    //   142: anewarray 699	java/io/Closeable
    //   145: dup
    //   146: iconst_0
    //   147: aload_2
    //   148: aastore
    //   149: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   152: goto +34 -> 186
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: goto +179 -> 337
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_2
    //   164: astore_1
    //   165: ldc_w 817
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: iconst_1
    //   176: anewarray 699	java/io/Closeable
    //   179: dup
    //   180: iconst_0
    //   181: aload_2
    //   182: aastore
    //   183: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   186: aload 5
    //   188: ldc 141
    //   190: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 4
    //   196: astore_1
    //   197: new 396	java/io/BufferedReader
    //   200: dup
    //   201: new 389	java/io/FileReader
    //   204: dup
    //   205: new 477	java/io/File
    //   208: dup
    //   209: ldc_w 821
    //   212: invokespecial 812	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: invokespecial 815	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   218: invokespecial 692	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   221: astore_2
    //   222: aload 5
    //   224: aload_2
    //   225: invokevirtual 402	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   228: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iconst_1
    //   233: anewarray 699	java/io/Closeable
    //   236: dup
    //   237: iconst_0
    //   238: aload_2
    //   239: aastore
    //   240: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   243: goto +30 -> 273
    //   246: astore_1
    //   247: goto +72 -> 319
    //   250: aload_2
    //   251: astore_1
    //   252: ldc_w 817
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 196	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: iconst_1
    //   263: anewarray 699	java/io/Closeable
    //   266: dup
    //   267: iconst_0
    //   268: aload_2
    //   269: aastore
    //   270: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   273: aload 5
    //   275: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore_1
    //   279: new 106	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   286: astore_2
    //   287: aload_2
    //   288: ldc_w 823
    //   291: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_2
    //   296: aload_1
    //   297: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 168	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_1
    //   313: areturn
    //   314: astore_3
    //   315: aload_1
    //   316: astore_2
    //   317: aload_3
    //   318: astore_1
    //   319: iconst_1
    //   320: anewarray 699	java/io/Closeable
    //   323: dup
    //   324: iconst_0
    //   325: aload_2
    //   326: aastore
    //   327: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   330: aload_1
    //   331: athrow
    //   332: astore_3
    //   333: aload_1
    //   334: astore_2
    //   335: aload_3
    //   336: astore_1
    //   337: iconst_1
    //   338: anewarray 699	java/io/Closeable
    //   341: dup
    //   342: iconst_0
    //   343: aload_2
    //   344: aastore
    //   345: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   348: aload_1
    //   349: athrow
    //   350: astore_3
    //   351: aload_1
    //   352: astore_2
    //   353: aload_3
    //   354: astore_1
    //   355: iconst_1
    //   356: anewarray 699	java/io/Closeable
    //   359: dup
    //   360: iconst_0
    //   361: aload_2
    //   362: aastore
    //   363: invokestatic 702	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   366: aload_1
    //   367: athrow
    //   368: astore_1
    //   369: goto -298 -> 71
    //   372: astore_1
    //   373: goto -300 -> 73
    //   376: astore_1
    //   377: goto -216 -> 161
    //   380: astore_1
    //   381: goto -218 -> 163
    //   384: astore_1
    //   385: aload_3
    //   386: astore_2
    //   387: goto -137 -> 250
    //   390: astore_1
    //   391: goto -141 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	f
    //   40	1	1	localObject1	Object
    //   65	1	1	localObject2	Object
    //   74	57	1	localObject3	Object
    //   155	1	1	localObject4	Object
    //   164	33	1	localObject5	Object
    //   246	1	1	localObject6	Object
    //   251	116	1	localObject7	Object
    //   368	1	1	localException1	Exception
    //   372	1	1	localException2	Exception
    //   376	1	1	localException3	Exception
    //   380	1	1	localException4	Exception
    //   384	1	1	localException5	Exception
    //   390	1	1	localException6	Exception
    //   38	349	2	localObject8	Object
    //   13	1	3	localObject9	Object
    //   314	4	3	localObject10	Object
    //   332	4	3	localObject11	Object
    //   350	36	3	localObject12	Object
    //   10	185	4	localObject13	Object
    //   7	267	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	39	65	finally
    //   104	129	155	finally
    //   222	232	246	finally
    //   197	222	314	finally
    //   252	262	314	finally
    //   131	141	332	finally
    //   165	175	332	finally
    //   41	51	350	finally
    //   75	85	350	finally
    //   14	39	368	java/lang/Exception
    //   41	51	372	java/lang/Exception
    //   104	129	376	java/lang/Exception
    //   131	141	380	java/lang/Exception
    //   197	222	384	java/lang/Exception
    //   222	232	390	java/lang/Exception
  }
  
  public String w()
  {
    return this.n;
  }
  
  public int x()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new e(this));
      if (arrayOfFile == null) {
        return 1;
      }
      int i1 = arrayOfFile.length;
      return i1;
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
    return this.o;
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
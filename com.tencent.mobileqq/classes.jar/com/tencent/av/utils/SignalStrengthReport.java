package com.tencent.av.utils;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class SignalStrengthReport
{
  static volatile SignalStrengthReport a;
  WeakReference<Context> b;
  SignalStrengthReport.QavPhoneStateListener c;
  WifiManager d;
  TelephonyManager e;
  int f = -1;
  HandlerThread g;
  Handler h;
  int i = 0;
  int j = 0;
  int k = -1;
  String l = "";
  Runnable m = new SignalStrengthReport.1(this);
  Runnable n = new SignalStrengthReport.2(this);
  
  private SignalStrengthReport(Context paramContext)
  {
    this.b = new WeakReference(paramContext);
    if (Looper.myLooper() != null) {
      this.c = new SignalStrengthReport.QavPhoneStateListener(this);
    }
    if (paramContext != null)
    {
      this.d = ((WifiManager)paramContext.getSystemService("wifi"));
      this.e = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
  }
  
  public static SignalStrengthReport a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new SignalStrengthReport(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  private String i()
  {
    try
    {
      if (this.d != null)
      {
        Object localObject = this.d.getDhcpInfo();
        if (localObject != null)
        {
          localObject = a(((DhcpInfo)localObject).gateway);
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGateway e:");
      localStringBuilder.append(localException);
      AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
    }
    return "";
  }
  
  private static int j()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i1 = 4;
    if (bool) {
      return 1;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int i2 = AppNetConnInfo.getMobileInfo();
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 == 3) {
            return i1;
          }
          if (i2 == 4) {
            return 5;
          }
        }
        else
        {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    i1 = 0;
    return i1;
  }
  
  private int k()
  {
    try
    {
      if ((this.b != null) && (this.b.get() != null))
      {
        Object localObject = QAVConfigUtils.b(218, QAVConfigUtils.b);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getPingInterval config:");
          localStringBuilder.append((String)localObject);
          AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("pingInterval"))
          {
            int i1 = ((JSONObject)localObject).getInt("pingInterval");
            if ((i1 >= 0) && (i1 < 2000)) {
              return 2000;
            }
            return i1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPingInterval e:");
      localStringBuilder.append(localException);
      AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
    }
    return -1;
  }
  
  int a(SignalStrength paramSignalStrength)
  {
    if (paramSignalStrength != null) {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          int i1 = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getLevel", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
          i1 *= 25;
          if (i1 > 100) {
            return 100;
          }
          return i1;
        }
      }
      catch (Exception paramSignalStrength)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLevelPercentBySignalStrength reflect getLevel e:");
        localStringBuilder.append(paramSignalStrength);
        AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive())) {
      return;
    }
    AVLog.printColorLog("SignalStrengthReport", "report start");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SignalStrengthReportThread");
    ((StringBuilder)localObject).append((int)(Math.random() * 100.0D));
    this.g = new HandlerThread(((StringBuilder)localObject).toString());
    this.g.start();
    this.h = new Handler(this.g.getLooper());
    this.f = k();
    this.l = "";
    localObject = this.m;
    if (localObject != null) {
      this.h.post((Runnable)localObject);
    }
    localObject = this.n;
    if (localObject != null) {
      this.h.post((Runnable)localObject);
    }
    localObject = this.c;
    if (localObject != null)
    {
      TelephonyManager localTelephonyManager = this.e;
      if (localTelephonyManager != null) {
        localTelephonyManager.listen((PhoneStateListener)localObject, 256);
      }
    }
  }
  
  int b(SignalStrength paramSignalStrength)
  {
    int i3 = -1;
    int i2 = i3;
    int i1;
    if (paramSignalStrength != null)
    {
      try
      {
        i1 = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getDbm", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getDbmBySignalStrength reflect getDbm e1:");
        localStringBuilder2.append(localException);
        AVLog.printColorLog("SignalStrengthReport", localStringBuilder2.toString());
        i1 = -1;
      }
      if (i1 == -1) {
        try
        {
          if (paramSignalStrength.isGsm())
          {
            i2 = paramSignalStrength.getGsmSignalStrength();
            i1 = i2;
            if (i2 != 99) {
              break label204;
            }
            i1 = -1;
            break label204;
          }
          i2 = paramSignalStrength.getCdmaDbm();
          i3 = paramSignalStrength.getEvdoDbm();
          if (i3 != -120)
          {
            if (i2 == -120)
            {
              i1 = i3;
            }
            else
            {
              i1 = i3;
              if (i2 >= i3) {}
            }
          }
          else {
            i1 = i2;
          }
          return i1;
        }
        catch (Exception paramSignalStrength)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("getDbmBySignalStrength e2:");
          localStringBuilder1.append(paramSignalStrength);
          AVLog.printColorLog("SignalStrengthReport", localStringBuilder1.toString());
          return -1;
        }
      }
      i2 = i1;
    }
    label204:
    do
    {
      return i2;
      i2 = i3;
    } while (i1 == -1);
    return i1 * 2 - 113;
  }
  
  public void b()
  {
    Object localObject1 = this.h;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.m;
      if (localObject2 != null) {
        ((Handler)localObject1).removeCallbacks((Runnable)localObject2);
      }
      localObject1 = this.n;
      if (localObject1 != null) {
        this.h.removeCallbacks((Runnable)localObject1);
      }
      this.h = null;
    }
    this.f = -1;
    localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject2 = this.e;
      if (localObject2 != null) {
        ((TelephonyManager)localObject2).listen((PhoneStateListener)localObject1, 0);
      }
    }
    localObject1 = this.g;
    if (localObject1 != null)
    {
      ((HandlerThread)localObject1).quit();
      this.g = null;
    }
    this.l = "";
    AVLog.printColorLog("SignalStrengthReport", "report stop");
  }
  
  public String c()
  {
    return this.l;
  }
  
  int d()
  {
    return this.k;
  }
  
  int e()
  {
    return this.j;
  }
  
  int f()
  {
    int i2 = 0;
    int i1 = i2;
    try
    {
      if (this.d != null)
      {
        WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo(this.d);
        i1 = i2;
        if (localWifiInfo.getBSSID() != null)
        {
          i1 = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 5);
          i2 = i1 * 25;
          i1 = i2;
          if (i2 > 100) {
            return 100;
          }
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWifiLevelPercent e:");
      localStringBuilder.append(localException);
      AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
      i1 = i2;
    }
    return i1;
  }
  
  int g()
  {
    try
    {
      if (this.d != null)
      {
        WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo(this.d);
        if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null))
        {
          int i1 = localWifiInfo.getRssi();
          return i1;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWifiDbm e:");
      localStringBuilder.append(localException);
      AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport
 * JD-Core Version:    0.7.0.1
 */
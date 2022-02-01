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
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class SignalStrengthReport
{
  static volatile SignalStrengthReport jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport;
  int jdField_a_of_type_Int = -1;
  WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  SignalStrengthReport.QavPhoneStateListener jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport$QavPhoneStateListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new SignalStrengthReport.1(this);
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int = 0;
  Runnable jdField_b_of_type_JavaLangRunnable = new SignalStrengthReport.2(this);
  int c = 0;
  int d = -1;
  
  private SignalStrengthReport(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (Looper.myLooper() != null) {
      this.jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport$QavPhoneStateListener = new SignalStrengthReport.QavPhoneStateListener(this);
    }
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager = ((WifiManager)paramContext.getSystemService("wifi"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
  }
  
  public static SignalStrengthReport a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport == null) {
          jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport = new SignalStrengthReport(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport;
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
  
  private String b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidNetWifiWifiManager.getDhcpInfo();
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
  
  private static int f()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i = 4;
    if (bool) {
      return 1;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int j = AppNetConnInfo.getMobileInfo();
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            return i;
          }
          if (j == 4) {
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
    i = 0;
    return i;
  }
  
  private int g()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        Object localObject = QAVConfigUtils.a(218, QAVConfigUtils.b);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getPingInterval config:");
          localStringBuilder.append((String)localObject);
          AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("pingInterval"))
          {
            int i = ((JSONObject)localObject).getInt("pingInterval");
            if ((i >= 0) && (i < 2000)) {
              return 2000;
            }
            return i;
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
  
  int a()
  {
    return this.d;
  }
  
  int a(SignalStrength paramSignalStrength)
  {
    if (paramSignalStrength != null) {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          int i = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getLevel", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
          i *= 25;
          if (i > 100) {
            return 100;
          }
          return i;
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
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if ((localObject != null) && (((HandlerThread)localObject).isAlive())) {
      return;
    }
    AVLog.printColorLog("SignalStrengthReport", "report start");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SignalStrengthReportThread");
    ((StringBuilder)localObject).append((int)(Math.random() * 100.0D));
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Int = g();
    this.jdField_a_of_type_JavaLangString = "";
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject);
    }
    localObject = this.jdField_b_of_type_JavaLangRunnable;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport$QavPhoneStateListener;
    if (localObject != null)
    {
      TelephonyManager localTelephonyManager = this.jdField_a_of_type_AndroidTelephonyTelephonyManager;
      if (localTelephonyManager != null) {
        localTelephonyManager.listen((PhoneStateListener)localObject, 256);
      }
    }
  }
  
  int b()
  {
    return this.c;
  }
  
  int b(SignalStrength paramSignalStrength)
  {
    int k = -1;
    int j = k;
    int i;
    if (paramSignalStrength != null)
    {
      try
      {
        i = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getDbm", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getDbmBySignalStrength reflect getDbm e1:");
        localStringBuilder2.append(localException);
        AVLog.printColorLog("SignalStrengthReport", localStringBuilder2.toString());
        i = -1;
      }
      if (i == -1) {
        try
        {
          if (paramSignalStrength.isGsm())
          {
            j = paramSignalStrength.getGsmSignalStrength();
            i = j;
            if (j != 99) {
              break label204;
            }
            i = -1;
            break label204;
          }
          j = paramSignalStrength.getCdmaDbm();
          k = paramSignalStrength.getEvdoDbm();
          if (k != -120)
          {
            if (j == -120)
            {
              i = k;
            }
            else
            {
              i = k;
              if (j >= k) {}
            }
          }
          else {
            i = j;
          }
          return i;
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
      j = i;
    }
    label204:
    do
    {
      return j;
      j = k;
    } while (i == -1);
    return i * 2 - 113;
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_JavaLangRunnable;
      if (localObject2 != null) {
        ((Handler)localObject1).removeCallbacks((Runnable)localObject2);
      }
      localObject1 = this.jdField_b_of_type_JavaLangRunnable;
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject1);
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_Int = -1;
    localObject1 = this.jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport$QavPhoneStateListener;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_AndroidTelephonyTelephonyManager;
      if (localObject2 != null) {
        ((TelephonyManager)localObject2).listen((PhoneStateListener)localObject1, 0);
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject1 != null)
    {
      ((HandlerThread)localObject1).quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_JavaLangString = "";
    AVLog.printColorLog("SignalStrengthReport", "report stop");
  }
  
  int c()
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
        i = j;
        if (localWifiInfo.getBSSID() != null)
        {
          i = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 5);
          j = i * 25;
          i = j;
          if (j > 100) {
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
      i = j;
    }
    return i;
  }
  
  int d()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
        if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null))
        {
          int i = localWifiInfo.getRssi();
          return i;
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
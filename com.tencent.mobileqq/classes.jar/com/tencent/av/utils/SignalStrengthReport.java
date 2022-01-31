package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import khn;
import kho;
import khp;
import org.json.JSONObject;

public class SignalStrengthReport
{
  static volatile SignalStrengthReport jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport;
  static final String jdField_a_of_type_JavaLangString = AppConstants.aJ + "qav" + File.separator + "signal_strength" + File.separator;
  public int a;
  WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  public Handler a;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new khn(this);
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  khp jdField_a_of_type_Khp;
  public int b;
  Runnable b;
  public String b;
  public int c = 0;
  public int d = -1;
  
  private SignalStrengthReport(Context paramContext)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangRunnable = new kho(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (Looper.myLooper() != null) {
      this.jdField_a_of_type_Khp = new khp(this);
    }
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager = ((WifiManager)paramContext.getSystemService("wifi"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
  }
  
  public static int a(Context paramContext)
  {
    if (TextUtils.isEmpty(a(paramContext))) {
      return 0;
    }
    int i = paramContext.getSharedPreferences("qav_signal_strength_config_sp", 4).getInt("key_config_version", 0);
    AVLog.c("SignalStrengthReport", "getSignalStrengthConfigVersion:" + i);
    return i;
  }
  
  public static SignalStrengthReport a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport == null) {
        jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport = new SignalStrengthReport(paramContext);
      }
      return jdField_a_of_type_ComTencentAvUtilsSignalStrengthReport;
    }
    finally {}
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
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "signal_strength_config.json");
      AVLog.c("SignalStrengthReport", "getSignalStrengthConfig:" + jdField_a_of_type_JavaLangString + "signal_strength_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      a(paramContext, 0);
      return null;
    }
    catch (Exception paramContext)
    {
      AVLog.c("SignalStrengthReport", "getSignalStrengthConfig e:" + paramContext);
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AVLog.c("SignalStrengthReport", "setSignalStrengthConfigVersion:" + paramInt);
    paramContext = paramContext.getSharedPreferences("qav_signal_strength_config_sp", 4).edit();
    paramContext.putInt("key_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      AVLog.c("SignalStrengthReport", "updateSignalStrengthConfig error : txt is null ");
    }
    while (!FileUtils.a(jdField_a_of_type_JavaLangString, "signal_strength_config.json", paramString)) {
      return;
    }
    a(paramContext, paramInt);
  }
  
  private String b()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        DhcpInfo localDhcpInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getDhcpInfo();
        str1 = str2;
        if (localDhcpInfo != null) {
          str1 = a(localDhcpInfo.gateway);
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      AVLog.c("SignalStrengthReport", "getGateway e:" + localException);
    }
    return "";
  }
  
  private static int f()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  private int g()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        Object localObject = a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          AVLog.c("SignalStrengthReport", "getPingInterval config:" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("pingInterval"))
          {
            int i = ((JSONObject)localObject).getInt("pingInterval");
            int j = i;
            if (i >= 0)
            {
              j = i;
              if (i < 2000) {
                j = 2000;
              }
            }
            return j;
          }
        }
      }
    }
    catch (Exception localException)
    {
      AVLog.c("SignalStrengthReport", "getPingInterval e:" + localException);
    }
    return -1;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(SignalStrength paramSignalStrength)
  {
    int j = 100;
    int k = 0;
    int i = 0;
    if (paramSignalStrength != null) {
      i = k;
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          i = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getLevel", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
          k = i * 25;
          i = k;
          if (k > 100)
          {
            i = j;
            return i;
          }
        }
      }
      catch (Exception paramSignalStrength)
      {
        AVLog.c("SignalStrengthReport", "getLevelPercentBySignalStrength reflect getLevel e:" + paramSignalStrength);
        return 0;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    do
    {
      return;
      AVLog.c("SignalStrengthReport", "report start");
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SignalStrengthReportThread" + (int)(Math.random() * 100.0D));
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_Int = g();
      this.jdField_b_of_type_JavaLangString = "";
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
      }
    } while ((this.jdField_a_of_type_Khp == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null));
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_Khp, 256);
  }
  
  public int b()
  {
    return this.c;
  }
  
  /* Error */
  public int b(SignalStrength paramSignalStrength)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload 4
    //   5: istore_2
    //   6: aload_1
    //   7: ifnull +79 -> 86
    //   10: ldc_w 285
    //   13: invokevirtual 290	java/lang/Class:getName	()Ljava/lang/String;
    //   16: invokestatic 294	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   19: ldc_w 359
    //   22: iconst_0
    //   23: anewarray 287	java/lang/Class
    //   26: invokevirtual 300	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   29: aload_1
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokevirtual 306	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   37: invokevirtual 307	java/lang/Object:toString	()Ljava/lang/String;
    //   40: invokestatic 312	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   43: istore_2
    //   44: iload_2
    //   45: iconst_m1
    //   46: if_icmpne +143 -> 189
    //   49: aload_1
    //   50: invokevirtual 362	android/telephony/SignalStrength:isGsm	()Z
    //   53: ifeq +68 -> 121
    //   56: aload_1
    //   57: invokevirtual 365	android/telephony/SignalStrength:getGsmSignalStrength	()I
    //   60: istore_2
    //   61: iload_2
    //   62: istore_3
    //   63: iload_2
    //   64: bipush 99
    //   66: if_icmpne +5 -> 71
    //   69: iconst_m1
    //   70: istore_3
    //   71: iload 4
    //   73: istore_2
    //   74: iload_3
    //   75: iconst_m1
    //   76: if_icmpeq +10 -> 86
    //   79: iload_3
    //   80: iconst_2
    //   81: imul
    //   82: bipush 113
    //   84: isub
    //   85: istore_2
    //   86: iload_2
    //   87: ireturn
    //   88: astore 5
    //   90: ldc 138
    //   92: new 22	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 367
    //   102: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 5
    //   107: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 148	com/tencent/av/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: iconst_m1
    //   117: istore_2
    //   118: goto -74 -> 44
    //   121: aload_1
    //   122: invokevirtual 370	android/telephony/SignalStrength:getCdmaDbm	()I
    //   125: istore 4
    //   127: aload_1
    //   128: invokevirtual 373	android/telephony/SignalStrength:getEvdoDbm	()I
    //   131: istore_3
    //   132: iload_3
    //   133: bipush 136
    //   135: if_icmpne +6 -> 141
    //   138: iload 4
    //   140: ireturn
    //   141: iload_3
    //   142: istore_2
    //   143: iload 4
    //   145: bipush 136
    //   147: if_icmpeq -61 -> 86
    //   150: iload_3
    //   151: istore_2
    //   152: iload 4
    //   154: iload_3
    //   155: if_icmpge -69 -> 86
    //   158: iload 4
    //   160: ireturn
    //   161: astore_1
    //   162: ldc 138
    //   164: new 22	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 375
    //   174: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 148	com/tencent/av/AVLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iconst_m1
    //   188: ireturn
    //   189: iload_2
    //   190: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	SignalStrengthReport
    //   0	191	1	paramSignalStrength	SignalStrength
    //   5	185	2	i	int
    //   62	94	3	j	int
    //   1	158	4	k	int
    //   88	18	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	44	88	java/lang/Exception
    //   49	61	161	java/lang/Exception
    //   121	132	161	java/lang/Exception
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_Int = -1;
    if ((this.jdField_a_of_type_Khp != null) && (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_Khp, 0);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_b_of_type_JavaLangString = "";
    AVLog.c("SignalStrengthReport", "report stop");
  }
  
  public int c()
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
      AVLog.c("SignalStrengthReport", "getWifiLevelPercent e:" + localException);
      i = j;
    }
    return i;
  }
  
  public int d()
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
        i = j;
        if (localWifiInfo != null)
        {
          i = j;
          if (localWifiInfo.getBSSID() != null) {
            i = localWifiInfo.getRssi();
          }
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      AVLog.c("SignalStrengthReport", "getWifiDbm e:" + localException);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.falco.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.lang.reflect.Method;

class DeviceInfoUtil$CTelephoneInfo
{
  private static CTelephoneInfo CTelephoneInfo;
  private static Context mContext;
  private String iDataConnected1 = "0";
  private String iDataConnected2 = "0";
  private String iNumeric1;
  private String iNumeric2;
  private String imeiSIM1;
  private String imeiSIM2;
  private boolean isSIM1Ready;
  private boolean isSIM2Ready;
  
  public static CTelephoneInfo getInstance(Context paramContext)
  {
    try
    {
      if (CTelephoneInfo == null) {
        CTelephoneInfo = new CTelephoneInfo();
      }
      mContext = paramContext.getApplicationContext();
      paramContext = CTelephoneInfo;
      return paramContext;
    }
    finally {}
  }
  
  private static String getOperatorBySlot(Context paramContext, String paramString, int paramInt)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = Class.forName(paramContext.getClass().getName()).getMethod(paramString, new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(paramInt) });
      if (paramContext != null)
      {
        paramContext = paramContext.toString();
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      throw new DeviceInfoUtil.CTelephoneInfo.GeminiMethodNotFoundException(paramString);
    }
  }
  
  private static boolean getSIMStateBySlot(Context paramContext, String paramString, int paramInt)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = Class.forName(paramContext.getClass().getName()).getMethod(paramString, new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(paramInt) });
      if (paramContext != null)
      {
        paramInt = Integer.parseInt(paramContext.toString());
        if (paramInt == 5) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      throw new DeviceInfoUtil.CTelephoneInfo.GeminiMethodNotFoundException(paramString);
    }
  }
  
  public String getINumeric()
  {
    if (this.imeiSIM2 != null)
    {
      String str = this.iNumeric1;
      if ((str != null) && (str.length() > 1)) {
        return this.iNumeric1;
      }
      str = this.iNumeric2;
      if ((str != null) && (str.length() > 1)) {
        return this.iNumeric2;
      }
    }
    return this.iNumeric1;
  }
  
  public String getINumeric1()
  {
    return this.iNumeric1;
  }
  
  public String getINumeric2()
  {
    return this.iNumeric2;
  }
  
  public String getImeiSIM1()
  {
    return this.imeiSIM1;
  }
  
  public String getImeiSIM2()
  {
    return this.imeiSIM2;
  }
  
  public boolean isDataConnected1()
  {
    return (TextUtils.equals(this.iDataConnected1, "2")) || (TextUtils.equals(this.iDataConnected1, "1"));
  }
  
  public boolean isDataConnected2()
  {
    return (TextUtils.equals(this.iDataConnected2, "2")) || (TextUtils.equals(this.iDataConnected2, "1"));
  }
  
  public boolean isDualSim()
  {
    return this.imeiSIM2 != null;
  }
  
  public boolean isSIM1Ready()
  {
    return this.isSIM1Ready;
  }
  
  public boolean isSIM2Ready()
  {
    return this.isSIM2Ready;
  }
  
  public void setCTelephoneInfo()
  {
    Object localObject = (TelephonyManager)mContext.getSystemService("phone");
    CTelephoneInfo.imeiSIM1 = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject);
    CTelephoneInfo localCTelephoneInfo1 = CTelephoneInfo;
    localCTelephoneInfo1.imeiSIM2 = null;
    try
    {
      localCTelephoneInfo1.imeiSIM1 = getOperatorBySlot(mContext, "getDeviceIdGemini", 0);
      CTelephoneInfo.imeiSIM2 = getOperatorBySlot(mContext, "getDeviceIdGemini", 1);
      CTelephoneInfo.iNumeric1 = getOperatorBySlot(mContext, "getSimOperatorGemini", 0);
      CTelephoneInfo.iNumeric2 = getOperatorBySlot(mContext, "getSimOperatorGemini", 1);
      CTelephoneInfo.iDataConnected1 = getOperatorBySlot(mContext, "getDataStateGemini", 0);
      CTelephoneInfo.iDataConnected2 = getOperatorBySlot(mContext, "getDataStateGemini", 1);
    }
    catch (DeviceInfoUtil.CTelephoneInfo.GeminiMethodNotFoundException localGeminiMethodNotFoundException3)
    {
      localGeminiMethodNotFoundException3.printStackTrace();
      try
      {
        CTelephoneInfo.imeiSIM1 = getOperatorBySlot(mContext, "getDeviceId", 0);
        CTelephoneInfo.imeiSIM2 = getOperatorBySlot(mContext, "getDeviceId", 1);
        CTelephoneInfo.iNumeric1 = getOperatorBySlot(mContext, "getSimOperator", 0);
        CTelephoneInfo.iNumeric2 = getOperatorBySlot(mContext, "getSimOperator", 1);
        CTelephoneInfo.iDataConnected1 = getOperatorBySlot(mContext, "getDataState", 0);
        CTelephoneInfo.iDataConnected2 = getOperatorBySlot(mContext, "getDataState", 1);
      }
      catch (DeviceInfoUtil.CTelephoneInfo.GeminiMethodNotFoundException localGeminiMethodNotFoundException4)
      {
        localGeminiMethodNotFoundException4.printStackTrace();
      }
    }
    CTelephoneInfo localCTelephoneInfo2 = CTelephoneInfo;
    boolean bool;
    if (((TelephonyManager)localObject).getSimState() == 5) {
      bool = true;
    } else {
      bool = false;
    }
    localCTelephoneInfo2.isSIM1Ready = bool;
    localObject = CTelephoneInfo;
    ((CTelephoneInfo)localObject).isSIM2Ready = false;
    try
    {
      ((CTelephoneInfo)localObject).isSIM1Ready = getSIMStateBySlot(mContext, "getSimStateGemini", 0);
      CTelephoneInfo.isSIM2Ready = getSIMStateBySlot(mContext, "getSimStateGemini", 1);
      return;
    }
    catch (DeviceInfoUtil.CTelephoneInfo.GeminiMethodNotFoundException localGeminiMethodNotFoundException1)
    {
      localGeminiMethodNotFoundException1.printStackTrace();
      try
      {
        CTelephoneInfo.isSIM1Ready = getSIMStateBySlot(mContext, "getSimState", 0);
        CTelephoneInfo.isSIM2Ready = getSIMStateBySlot(mContext, "getSimState", 1);
        return;
      }
      catch (DeviceInfoUtil.CTelephoneInfo.GeminiMethodNotFoundException localGeminiMethodNotFoundException2)
      {
        localGeminiMethodNotFoundException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.DeviceInfoUtil.CTelephoneInfo
 * JD-Core Version:    0.7.0.1
 */
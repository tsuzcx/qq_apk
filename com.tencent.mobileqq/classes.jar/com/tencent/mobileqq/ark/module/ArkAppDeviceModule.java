package com.tencent.mobileqq.ark.module;

import android.content.BroadcastReceiver;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class ArkAppDeviceModule
  extends ArkAppModuleBase
{
  protected ArkAppEventObserverManager a = new ArkAppEventObserverManager(this.f);
  private ArkAppDeviceModule.SystemInfoMethod b = new ArkAppDeviceModule.SystemInfoMethod(this, null);
  private ArkAppDeviceModule.ConnectionTypeMethod c = new ArkAppDeviceModule.ConnectionTypeMethod(this, null);
  private ArkAppDeviceModule.ObserverMethod d = new ArkAppDeviceModule.ObserverMethod(this, null);
  private ArkAppDeviceModule.ScanCodeMethod k = new ArkAppDeviceModule.ScanCodeMethod(this, null);
  private HashMap<String, ArkAppDeviceModule.DeviceMethodWrap> l = new ArkAppDeviceModule.1(this);
  private BroadcastReceiver m = null;
  
  public ArkAppDeviceModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("doScanCodeCallback cbId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", scanResult=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", scanType=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ArkAppDeviceModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramLong);
    if (localObject == null) {
      return;
    }
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      i = 1;
    } else {
      i = 0;
    }
    ark.VariantWrapper localVariantWrapper = ((ark.VariantWrapper)localObject).Create();
    if (i != 0)
    {
      if ("QR_CODE".equalsIgnoreCase(paramString2)) {
        paramString2 = "QRCode";
      } else {
        paramString2 = "BarCode";
      }
      localVariantWrapper.SetTableAsJsonString(String.format(Locale.CHINA, "{\"result\":\"%s\",\"type\":\"%s\",\"charset\":\"%s\"}", new Object[] { paramString1, paramString2, "utf-8" }));
    }
    else
    {
      localVariantWrapper.SetNull();
    }
    paramString1 = ((ark.VariantWrapper)localObject).Create();
    ((ark.VariantWrapper)localObject).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper }, paramString1);
    paramString1.Reset();
    localVariantWrapper.Reset();
    ((ark.VariantWrapper)localObject).Reset();
  }
  
  private void a(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("doPositionCallback cbId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", success=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", lat=");
      ((StringBuilder)localObject).append(paramDouble1);
      ((StringBuilder)localObject).append(", lng=");
      ((StringBuilder)localObject).append(paramDouble2);
      QLog.d("ArkAppDeviceModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = b(paramLong);
    if (localObject == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper1 = ((ark.VariantWrapper)localObject).Create();
    if (paramBoolean) {
      localVariantWrapper1.SetTableAsJsonString(String.format(Locale.CHINA, "{\"latitude\":%.6f,\"longitude\":%.6f}", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    } else {
      localVariantWrapper1.SetNull();
    }
    ark.VariantWrapper localVariantWrapper2 = ((ark.VariantWrapper)localObject).Create();
    ((ark.VariantWrapper)localObject).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper2);
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("doConnectionCallback cbId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", success=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", netType=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ArkAppDeviceModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = b(paramLong);
    if (localObject == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper = ((ark.VariantWrapper)localObject).Create();
    if (paramBoolean) {
      localVariantWrapper.SetString(paramString);
    } else {
      localVariantWrapper.SetNull();
    }
    paramString = ((ark.VariantWrapper)localObject).Create();
    ((ark.VariantWrapper)localObject).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper }, paramString);
    paramString.Reset();
    localVariantWrapper.Reset();
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("doSensorCallback cbId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", success=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", sensorEventType=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", argA=");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(", argB=");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append(", argC=");
      ((StringBuilder)localObject).append(paramFloat3);
      QLog.d("ArkAppDeviceModule", 2, ((StringBuilder)localObject).toString());
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    Object localObject = null;
    if ("Motion".equals(paramString)) {
      localObject = "{\"x\":%.6f,\"y\":%.6f,\"z\":%.6f}";
    } else if ("Orientation".equals(paramString)) {
      localObject = "{\"alpha\":%.6f,\"beta\":%.6f,\"gamma\":%.6f}";
    }
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, (String)localObject, new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    } else {
      localVariantWrapper2.SetNull();
    }
    paramString = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
    paramString.Reset();
    localVariantWrapper2.Reset();
  }
  
  private static String e()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
  }
  
  public void Destruct()
  {
    ArkAppEventObserverManager localArkAppEventObserverManager = this.a;
    if (localArkAppEventObserverManager != null) {
      localArkAppEventObserverManager.a();
    }
    if (this.m != null) {}
    try
    {
      BaseApplication.getContext().unregisterReceiver(this.m);
      label30:
      this.m = null;
      super.Destruct();
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public String GetTypeName()
  {
    return "Device";
  }
  
  public boolean HasMethod(String paramString)
  {
    HashMap localHashMap = this.l;
    return (localHashMap != null) && (localHashMap.containsKey(paramString)) && (this.l.get(paramString) != null);
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invokeFunc=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ArkAppDeviceModule", 2, ((StringBuilder)localObject).toString());
    }
    if (!a(paramString)) {
      return false;
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = (ArkAppDeviceModule.DeviceMethodWrap)((HashMap)localObject).get(paramString);
      if (localObject != null) {
        return ((ArkAppDeviceModule.DeviceMethodWrap)localObject).a(paramString, paramArrayOfVariantWrapper, paramVariantWrapper);
      }
    }
    return false;
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule
 * JD-Core Version:    0.7.0.1
 */
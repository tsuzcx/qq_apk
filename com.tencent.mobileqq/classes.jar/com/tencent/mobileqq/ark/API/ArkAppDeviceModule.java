package com.tencent.mobileqq.ark.API;

import android.content.BroadcastReceiver;
import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public class ArkAppDeviceModule
  extends ArkAppModuleBase
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private ArkAppDeviceModule.ConnectionTypeMethod jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ConnectionTypeMethod = new ArkAppDeviceModule.ConnectionTypeMethod(this, null);
  private ArkAppDeviceModule.ObserverMethod jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ObserverMethod = new ArkAppDeviceModule.ObserverMethod(this, null);
  private ArkAppDeviceModule.ScanCodeMethod jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ScanCodeMethod = new ArkAppDeviceModule.ScanCodeMethod(this, null);
  private ArkAppDeviceModule.SystemInfoMethod jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$SystemInfoMethod = new ArkAppDeviceModule.SystemInfoMethod(this, null);
  protected ArkAppEventObserverManager a;
  private HashMap<String, ArkAppDeviceModule.DeviceMethodWrap> jdField_a_of_type_JavaUtilHashMap = new ArkAppDeviceModule.1(this);
  
  public ArkAppDeviceModule(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager = new ArkAppEventObserverManager(this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doScanCodeCallback cbId=" + paramLong + ", scanResult=" + paramString1 + ", scanType=" + paramString2);
    }
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    int i;
    ark.VariantWrapper localVariantWrapper2;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      i = 1;
      localVariantWrapper2 = localVariantWrapper1.Create();
      if (i == 0) {
        break label186;
      }
      if (!"QR_CODE".equalsIgnoreCase(paramString2)) {
        break label179;
      }
      paramString2 = "QRCode";
      label104:
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"result\":\"%s\",\"type\":\"%s\",\"charset\":\"%s\"}", new Object[] { paramString1, paramString2, "utf-8" }));
    }
    for (;;)
    {
      paramString1 = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString1);
      paramString1.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
      i = 0;
      break;
      label179:
      paramString2 = "BarCode";
      break label104;
      label186:
      localVariantWrapper2.SetNull();
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doPositionCallback cbId=" + paramLong + ", success=" + paramBoolean + ", lat=" + paramDouble1 + ", lng=" + paramDouble2);
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramBoolean) {
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"latitude\":%.6f,\"longitude\":%.6f}", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    }
    for (;;)
    {
      ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      return;
      localVariantWrapper2.SetNull();
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doConnectionCallback cbId=" + paramLong + ", success=" + paramBoolean + ", netType=" + paramString);
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramBoolean) {
      localVariantWrapper2.SetString(paramString);
    }
    for (;;)
    {
      paramString = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
      paramString.Reset();
      localVariantWrapper2.Reset();
      return;
      localVariantWrapper2.SetNull();
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "doSensorCallback cbId=" + paramLong + ", success=" + paramBoolean + ", sensorEventType=" + paramString + ", argA=" + paramFloat1 + ", argB=" + paramFloat2 + ", argC=" + paramFloat3);
    }
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    String str = null;
    if ("Motion".equals(paramString))
    {
      str = "{\"x\":%.6f,\"y\":%.6f,\"z\":%.6f}";
      if ((!paramBoolean) || (TextUtils.isEmpty(str))) {
        break label220;
      }
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, str, new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    for (;;)
    {
      paramString = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
      paramString.Reset();
      localVariantWrapper2.Reset();
      return;
      if (!"Orientation".equals(paramString)) {
        break;
      }
      str = "{\"alpha\":%.6f,\"beta\":%.6f,\"gamma\":%.6f}";
      break;
      label220:
      localVariantWrapper2.SetNull();
    }
  }
  
  public void Destruct()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager.a();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label31:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      super.Destruct();
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public String GetTypeName()
  {
    return "Device";
  }
  
  public boolean HasMenthod(String paramString)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null);
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "invokeFunc=" + paramString);
    }
    if (!a(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      ArkAppDeviceModule.DeviceMethodWrap localDeviceMethodWrap = (ArkAppDeviceModule.DeviceMethodWrap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localDeviceMethodWrap != null) {
        return localDeviceMethodWrap.a(paramString, paramArrayOfVariantWrapper, paramVariantWrapper);
      }
    }
    return false;
  }
  
  protected ArkAppModuleBase.ModuleMethod[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule
 * JD-Core Version:    0.7.0.1
 */
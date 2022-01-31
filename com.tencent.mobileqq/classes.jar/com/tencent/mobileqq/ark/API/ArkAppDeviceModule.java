package com.tencent.mobileqq.ark.API;

import aagt;
import aagu;
import aagv;
import aahp;
import aahs;
import android.content.BroadcastReceiver;
import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public class ArkAppDeviceModule
  extends ArkAppModuleReg.ModuleBase
{
  private aagt jdField_a_of_type_Aagt = new aagt(this, null);
  private aagv jdField_a_of_type_Aagv = new aagv(this, null);
  private aahp jdField_a_of_type_Aahp = new aahp(this, null);
  private aahs jdField_a_of_type_Aahs = new aahs(this, null);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public ArkAppEventObserverManager a;
  private HashMap b = new ArkAppDeviceModule.1(this);
  
  public ArkAppDeviceModule()
  {
    this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager = new ArkAppEventObserverManager();
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
    return (this.b != null) && (this.b.containsKey(paramString)) && (this.b.get(paramString) != null);
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppDeviceModule", 2, "invokeFunc=" + paramString);
    }
    if (!a(paramString)) {
      return false;
    }
    if (this.b != null)
    {
      aagu localaagu = (aagu)this.b.get(paramString);
      if (localaagu != null) {
        return localaagu.a(paramString, paramArrayOfVariantWrapper, paramVariantWrapper);
      }
    }
    return false;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule
 * JD-Core Version:    0.7.0.1
 */
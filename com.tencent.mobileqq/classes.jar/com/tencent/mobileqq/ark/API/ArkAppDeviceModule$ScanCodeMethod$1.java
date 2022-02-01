package com.tencent.mobileqq.ark.API;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkAppDeviceModule$ScanCodeMethod$1
  extends BroadcastReceiver
{
  ArkAppDeviceModule$ScanCodeMethod$1(ArkAppDeviceModule.ScanCodeMethod paramScanCodeMethod, long paramLong) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("com.tencent.ark.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.ark.scanResultType");
    ArkAppCenter.a().post(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ScanCodeMethod.a.a, new ArkAppDeviceModule.ScanCodeMethod.1.1(this, paramContext, paramIntent));
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(ArkAppDeviceModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ScanCodeMethod.a));
      label56:
      ArkAppDeviceModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ScanCodeMethod.a, null);
      return;
    }
    catch (Exception paramContext)
    {
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ScanCodeMethod.1
 * JD-Core Version:    0.7.0.1
 */
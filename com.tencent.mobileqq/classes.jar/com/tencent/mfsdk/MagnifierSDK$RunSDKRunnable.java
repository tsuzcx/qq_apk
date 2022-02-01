package com.tencent.mfsdk;

import abjg;
import adks;
import adkt;
import adkv;
import adkw;
import adkx;
import adle;
import admj;
import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.Config;
import com.tencent.mobileqq.app.MemoryManager;

class MagnifierSDK$RunSDKRunnable
  implements Runnable
{
  private Application a;
  
  public MagnifierSDK$RunSDKRunnable(MagnifierSDK paramMagnifierSDK, Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  public void run()
  {
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences = MagnifierSDK.a(this.a);
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    MagnifierSDK.jdField_a_of_type_Admj = admj.a(this.a.getApplicationContext());
    this.this$0.jdField_a_of_type_ComTencentMfsdkConfigConfig.loadLocalConfigs();
    if (BaseApplicationImpl.sProcessId == 1) {
      MagnifierSDK.a().b().a();
    }
    if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 7)) {
      MagnifierSDK.a().a().a();
    }
    if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2)) {
      MagnifierSDK.a().a().a();
    }
    if (BaseApplicationImpl.sProcessId != 4) {
      MagnifierSDK.a().a().a();
    }
    MagnifierSDK.a().a().a();
    if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 11) || (BaseApplicationImpl.sProcessId == 10))
    {
      MagnifierSDK.a().a().a();
      MagnifierSDK.a().a().a();
      if (BaseApplicationImpl.sProcessId != 1) {
        break label268;
      }
      MemoryManager.a().b();
    }
    for (;;)
    {
      if ((!MagnifierSDK.a().a().runIo) && (MagnifierSDK.a().a().runDb)) {}
      return;
      label268:
      abjg.a().d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK.RunSDKRunnable
 * JD-Core Version:    0.7.0.1
 */
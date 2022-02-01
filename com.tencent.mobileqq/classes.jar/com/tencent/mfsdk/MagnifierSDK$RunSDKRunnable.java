package com.tencent.mfsdk;

import aczl;
import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.Config;
import java.util.ArrayList;

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
    MagnifierSDK.jdField_a_of_type_Aczl = aczl.a(this.a.getApplicationContext());
    this.this$0.jdField_a_of_type_ComTencentMfsdkConfigConfig.loadLocalConfigs();
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId == 1) {
      localArrayList.add(MagnifierSDK.a().b());
    }
    if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 7)) {
      localArrayList.add(MagnifierSDK.a().a());
    }
    if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2)) {
      localArrayList.add(MagnifierSDK.a().a());
    }
    if (BaseApplicationImpl.sProcessId != 4) {
      localArrayList.add(MagnifierSDK.a().a());
    }
    localArrayList.add(MagnifierSDK.a().a());
    if ((BaseApplicationImpl.sProcessId == 1) || (BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 11) || (BaseApplicationImpl.sProcessId == 10))
    {
      localArrayList.add(MagnifierSDK.a().a());
      localArrayList.add(MagnifierSDK.a().a());
    }
    MagnifierSDK.a(MagnifierSDK.a(), localArrayList);
    if (BaseApplicationImpl.sProcessId == 1) {
      localArrayList.add(MagnifierSDK.a().c());
    }
    if ((!MagnifierSDK.a().a().runIo) && (MagnifierSDK.a().a().runDb)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK.RunSDKRunnable
 * JD-Core Version:    0.7.0.1
 */
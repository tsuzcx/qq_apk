package com.tencent.mfsdk;

import abqk;
import abrd;
import abrf;
import abrl;
import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.LocalMultiProcConfig;

class MagnifierSDK$RunSDKRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int = 63;
  private Application jdField_a_of_type_AndroidAppApplication;
  
  public MagnifierSDK$RunSDKRunnable(MagnifierSDK paramMagnifierSDK, Application paramApplication, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    boolean bool2 = false;
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences = MagnifierSDK.a(this.jdField_a_of_type_AndroidAppApplication);
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    MagnifierSDK.jdField_a_of_type_Abrd = abrd.a(this.jdField_a_of_type_AndroidAppApplication.getApplicationContext());
    abqk.a();
    boolean bool3 = abqk.a;
    boolean bool1;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      bool1 = true;
      abqk.a = bool1 & bool3;
      bool3 = abqk.b;
      if ((this.jdField_a_of_type_Int & 0x2) <= 0) {
        break label242;
      }
      bool1 = true;
      label75:
      abqk.b = bool1 & bool3;
      bool3 = abqk.c;
      if ((this.jdField_a_of_type_Int & 0x4) <= 0) {
        break label247;
      }
      bool1 = true;
      label96:
      abqk.c = bool1 & bool3;
      bool3 = abqk.g;
      if ((this.jdField_a_of_type_Int & 0x8) <= 0) {
        break label252;
      }
      bool1 = true;
      label118:
      abqk.g = bool1 & bool3;
      bool3 = abqk.h;
      if ((this.jdField_a_of_type_Int & 0x10) <= 0) {
        break label257;
      }
      bool1 = true;
      label140:
      abqk.h = bool1 & bool3;
      bool3 = abqk.i;
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x20) > 0) {
        bool1 = true;
      }
      abqk.i = bool3 & bool1;
      if (abqk.a)
      {
        if ((2 != BaseApplicationImpl.sProcessId) && (8 != BaseApplicationImpl.sProcessId)) {
          break label262;
        }
        if (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true)) {}
      }
    }
    for (;;)
    {
      if (abqk.g) {
        abrl.a().addObserver(MagnifierSDK.a());
      }
      abrf.a().addObserver(MagnifierSDK.a());
      if ((!abqk.b) && (abqk.c)) {}
      return;
      bool1 = false;
      break;
      label242:
      bool1 = false;
      break label75;
      label247:
      bool1 = false;
      break label96;
      label252:
      bool1 = false;
      break label118;
      label257:
      bool1 = false;
      break label140;
      label262:
      this.this$0.a(this.jdField_a_of_type_AndroidAppApplication);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK.RunSDKRunnable
 * JD-Core Version:    0.7.0.1
 */
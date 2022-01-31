package com.tencent.mfsdk;

import aaag;
import aaai;
import aaao;
import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.LocalMultiProcConfig;
import zzn;

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
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidAppApplication.getSharedPreferences("MagnifierSDK", 4);
    MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    MagnifierSDK.jdField_a_of_type_Aaag = aaag.a(this.jdField_a_of_type_AndroidAppApplication.getApplicationContext());
    zzn.a();
    boolean bool3 = zzn.a;
    boolean bool1;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      bool1 = true;
      zzn.a = bool1 & bool3;
      bool3 = zzn.b;
      if ((this.jdField_a_of_type_Int & 0x2) <= 0) {
        break label245;
      }
      bool1 = true;
      label78:
      zzn.b = bool1 & bool3;
      bool3 = zzn.c;
      if ((this.jdField_a_of_type_Int & 0x4) <= 0) {
        break label250;
      }
      bool1 = true;
      label99:
      zzn.c = bool1 & bool3;
      bool3 = zzn.g;
      if ((this.jdField_a_of_type_Int & 0x8) <= 0) {
        break label255;
      }
      bool1 = true;
      label121:
      zzn.g = bool1 & bool3;
      bool3 = zzn.h;
      if ((this.jdField_a_of_type_Int & 0x10) <= 0) {
        break label260;
      }
      bool1 = true;
      label143:
      zzn.h = bool1 & bool3;
      bool3 = zzn.i;
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x20) > 0) {
        bool1 = true;
      }
      zzn.i = bool3 & bool1;
      if (zzn.a)
      {
        if ((2 != BaseApplicationImpl.sProcessId) && (8 != BaseApplicationImpl.sProcessId)) {
          break label265;
        }
        if (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true)) {}
      }
    }
    for (;;)
    {
      if (zzn.g) {
        aaao.a().addObserver(MagnifierSDK.a());
      }
      aaai.a().addObserver(MagnifierSDK.a());
      if ((!zzn.b) && (zzn.c)) {}
      return;
      bool1 = false;
      break;
      label245:
      bool1 = false;
      break label78;
      label250:
      bool1 = false;
      break label99;
      label255:
      bool1 = false;
      break label121;
      label260:
      bool1 = false;
      break label143;
      label265:
      this.this$0.a(this.jdField_a_of_type_AndroidAppApplication);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.MagnifierSDK.RunSDKRunnable
 * JD-Core Version:    0.7.0.1
 */
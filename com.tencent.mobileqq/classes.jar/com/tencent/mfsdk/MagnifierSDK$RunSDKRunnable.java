package com.tencent.mfsdk;

import aaak;
import aaam;
import aaas;
import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.LocalMultiProcConfig;
import zzq;

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
    MagnifierSDK.jdField_a_of_type_Aaak = aaak.a(this.jdField_a_of_type_AndroidAppApplication.getApplicationContext());
    zzq.a();
    boolean bool3 = zzq.a;
    boolean bool1;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      bool1 = true;
      zzq.a = bool1 & bool3;
      bool3 = zzq.b;
      if ((this.jdField_a_of_type_Int & 0x2) <= 0) {
        break label245;
      }
      bool1 = true;
      label78:
      zzq.b = bool1 & bool3;
      bool3 = zzq.c;
      if ((this.jdField_a_of_type_Int & 0x4) <= 0) {
        break label250;
      }
      bool1 = true;
      label99:
      zzq.c = bool1 & bool3;
      bool3 = zzq.g;
      if ((this.jdField_a_of_type_Int & 0x8) <= 0) {
        break label255;
      }
      bool1 = true;
      label121:
      zzq.g = bool1 & bool3;
      bool3 = zzq.h;
      if ((this.jdField_a_of_type_Int & 0x10) <= 0) {
        break label260;
      }
      bool1 = true;
      label143:
      zzq.h = bool1 & bool3;
      bool3 = zzq.i;
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x20) > 0) {
        bool1 = true;
      }
      zzq.i = bool3 & bool1;
      if (zzq.a)
      {
        if ((2 != BaseApplicationImpl.sProcessId) && (8 != BaseApplicationImpl.sProcessId)) {
          break label265;
        }
        if (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true)) {}
      }
    }
    for (;;)
    {
      if (zzq.g) {
        aaas.a().addObserver(MagnifierSDK.a());
      }
      aaam.a().addObserver(MagnifierSDK.a());
      if ((!zzq.b) && (zzq.c)) {}
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
package com.tencent.mfsdk;

import android.app.Application;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.LocalMultiProcConfig;
import zpy;
import zqr;
import zqt;
import zqz;

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
    MagnifierSDK.jdField_a_of_type_Zqr = zqr.a(this.jdField_a_of_type_AndroidAppApplication.getApplicationContext());
    zpy.a();
    boolean bool3 = zpy.a;
    boolean bool1;
    if ((this.jdField_a_of_type_Int & 0x1) > 0)
    {
      bool1 = true;
      zpy.a = bool1 & bool3;
      bool3 = zpy.b;
      if ((this.jdField_a_of_type_Int & 0x2) <= 0) {
        break label245;
      }
      bool1 = true;
      label78:
      zpy.b = bool1 & bool3;
      bool3 = zpy.c;
      if ((this.jdField_a_of_type_Int & 0x4) <= 0) {
        break label250;
      }
      bool1 = true;
      label99:
      zpy.c = bool1 & bool3;
      bool3 = zpy.g;
      if ((this.jdField_a_of_type_Int & 0x8) <= 0) {
        break label255;
      }
      bool1 = true;
      label121:
      zpy.g = bool1 & bool3;
      bool3 = zpy.h;
      if ((this.jdField_a_of_type_Int & 0x10) <= 0) {
        break label260;
      }
      bool1 = true;
      label143:
      zpy.h = bool1 & bool3;
      bool3 = zpy.i;
      bool1 = bool2;
      if ((this.jdField_a_of_type_Int & 0x20) > 0) {
        bool1 = true;
      }
      zpy.i = bool3 & bool1;
      if (zpy.a)
      {
        if ((2 != BaseApplicationImpl.sProcessId) && (8 != BaseApplicationImpl.sProcessId)) {
          break label265;
        }
        if (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true)) {}
      }
    }
    for (;;)
    {
      if (zpy.g) {
        zqz.a().addObserver(MagnifierSDK.a());
      }
      zqt.a().addObserver(MagnifierSDK.a());
      if ((!zpy.b) && (zpy.c)) {}
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
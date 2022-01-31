package com.tencent.kingkong;

import zyz;
import zzn;

final class Common$2
  implements Runnable
{
  public void run()
  {
    try
    {
      if ((!Common.jdField_a_of_type_Boolean) && (Common.b()) && (Common.c()) && (Common.d()))
      {
        if (!Common.jdField_a_of_type_Zzn.a()) {
          return;
        }
        Common.a(true);
        if (PatchManager.a(Common.jdField_a_of_type_AndroidContentContext))
        {
          UpdateManager.a(Common.jdField_a_of_type_AndroidContentContext);
          if (UpdateManager.b()) {
            UpdateManager.b();
          }
          if (UpdateManager.a()) {
            UpdateManager.a();
          }
          PatchManager.a();
        }
        Common.jdField_a_of_type_Boolean = true;
        Common.a(false);
        Common.jdField_a_of_type_Zzn.a();
        return;
      }
    }
    catch (Exception localException)
    {
      Common.jdField_a_of_type_Boolean = false;
      zyz.a("KingKongCommon", " SetSafeStatus Exception : " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kingkong.Common.2
 * JD-Core Version:    0.7.0.1
 */
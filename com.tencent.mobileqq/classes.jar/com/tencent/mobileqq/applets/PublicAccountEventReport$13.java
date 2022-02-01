package com.tencent.mobileqq.applets;

import blbw;
import blbx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$13
  implements Runnable
{
  public PublicAccountEventReport$13(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void run()
  {
    blbx localblbx = new blbx();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localblbx.jdField_e_of_type_JavaLangString = "vab_push";
    localblbx.jdField_f_of_type_JavaLangString = "vab_push";
    localblbx.jdField_b_of_type_JavaLangString = (str + "_" + l);
    localblbx.jdField_a_of_type_Int = 1;
    localblbx.g = this.jdField_a_of_type_JavaLangString;
    localblbx.h = "";
    localblbx.jdField_a_of_type_Long = l;
    localblbx.d = this.jdField_a_of_type_Int;
    localblbx.k = Integer.toString(this.jdField_b_of_type_Int);
    localblbx.jdField_e_of_type_Int = 1;
    localblbx.jdField_f_of_type_Int = this.c;
    localblbx.l = this.jdField_b_of_type_JavaLangString;
    blbw.a().a(localblbx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */
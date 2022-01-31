package com.tencent.mobileqq.applets;

import biam;
import bian;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$11
  implements Runnable
{
  public PublicAccountEventReport$11(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bian localbian = new bian();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbian.jdField_e_of_type_JavaLangString = "vab_push";
    localbian.jdField_f_of_type_JavaLangString = "vab_push";
    localbian.b = (str + "_" + l);
    localbian.jdField_a_of_type_Int = 1;
    localbian.g = this.jdField_a_of_type_JavaLangString;
    localbian.h = "";
    localbian.jdField_a_of_type_Long = l;
    localbian.d = this.jdField_a_of_type_Int;
    localbian.k = Integer.toString(this.b);
    localbian.jdField_e_of_type_Int = 1;
    localbian.jdField_f_of_type_Int = 1;
    biam.a().a(localbian);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.11
 * JD-Core Version:    0.7.0.1
 */
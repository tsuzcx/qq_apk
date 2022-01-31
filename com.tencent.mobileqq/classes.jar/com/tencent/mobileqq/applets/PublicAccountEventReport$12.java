package com.tencent.mobileqq.applets;

import bkgp;
import bkgq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$12
  implements Runnable
{
  public PublicAccountEventReport$12(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bkgq localbkgq = new bkgq();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbkgq.jdField_e_of_type_JavaLangString = "vab_push";
    localbkgq.jdField_f_of_type_JavaLangString = "vab_push";
    localbkgq.b = (str + "_" + l);
    localbkgq.jdField_a_of_type_Int = 1;
    localbkgq.g = this.jdField_a_of_type_JavaLangString;
    localbkgq.h = "";
    localbkgq.jdField_a_of_type_Long = l;
    localbkgq.d = this.jdField_a_of_type_Int;
    localbkgq.k = Integer.toString(this.b);
    localbkgq.jdField_e_of_type_Int = 1;
    localbkgq.jdField_f_of_type_Int = 1;
    bkgp.a().a(localbkgq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.12
 * JD-Core Version:    0.7.0.1
 */
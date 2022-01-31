package com.tencent.mobileqq.applets;

import bkci;
import bkcj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$12
  implements Runnable
{
  public PublicAccountEventReport$12(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bkcj localbkcj = new bkcj();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbkcj.jdField_e_of_type_JavaLangString = "vab_push";
    localbkcj.jdField_f_of_type_JavaLangString = "vab_push";
    localbkcj.b = (str + "_" + l);
    localbkcj.jdField_a_of_type_Int = 1;
    localbkcj.g = this.jdField_a_of_type_JavaLangString;
    localbkcj.h = "";
    localbkcj.jdField_a_of_type_Long = l;
    localbkcj.d = this.jdField_a_of_type_Int;
    localbkcj.k = Integer.toString(this.b);
    localbkcj.jdField_e_of_type_Int = 1;
    localbkcj.jdField_f_of_type_Int = 1;
    bkci.a().a(localbkcj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.12
 * JD-Core Version:    0.7.0.1
 */
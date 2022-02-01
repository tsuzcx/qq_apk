package com.tencent.mobileqq.applets;

import bmvi;
import bmvj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$13
  implements Runnable
{
  public PublicAccountEventReport$13(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bmvj localbmvj = new bmvj();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbmvj.jdField_e_of_type_JavaLangString = "vab_push";
    localbmvj.jdField_f_of_type_JavaLangString = "vab_push";
    localbmvj.b = (str + "_" + l);
    localbmvj.jdField_a_of_type_Int = 1;
    localbmvj.g = this.jdField_a_of_type_JavaLangString;
    localbmvj.h = "";
    localbmvj.jdField_a_of_type_Long = l;
    localbmvj.d = this.jdField_a_of_type_Int;
    localbmvj.k = Integer.toString(this.b);
    localbmvj.jdField_e_of_type_Int = 1;
    localbmvj.jdField_f_of_type_Int = 1;
    bmvi.a().a(localbmvj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */
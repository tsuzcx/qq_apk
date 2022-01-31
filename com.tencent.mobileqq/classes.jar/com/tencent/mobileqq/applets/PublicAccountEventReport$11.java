package com.tencent.mobileqq.applets;

import bhzv;
import bhzw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$11
  implements Runnable
{
  public PublicAccountEventReport$11(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bhzw localbhzw = new bhzw();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbhzw.jdField_e_of_type_JavaLangString = "vab_push";
    localbhzw.jdField_f_of_type_JavaLangString = "vab_push";
    localbhzw.b = (str + "_" + l);
    localbhzw.jdField_a_of_type_Int = 1;
    localbhzw.g = this.jdField_a_of_type_JavaLangString;
    localbhzw.h = "";
    localbhzw.jdField_a_of_type_Long = l;
    localbhzw.d = this.jdField_a_of_type_Int;
    localbhzw.k = Integer.toString(this.b);
    localbhzw.jdField_e_of_type_Int = 1;
    localbhzw.jdField_f_of_type_Int = 1;
    bhzv.a().a(localbhzw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.11
 * JD-Core Version:    0.7.0.1
 */
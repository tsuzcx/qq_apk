package com.tencent.mobileqq.applets;

import bnwq;
import bnwr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$13
  implements Runnable
{
  public PublicAccountEventReport$13(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bnwr localbnwr = new bnwr();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbnwr.jdField_e_of_type_JavaLangString = "vab_push";
    localbnwr.jdField_f_of_type_JavaLangString = "vab_push";
    localbnwr.b = (str + "_" + l);
    localbnwr.jdField_a_of_type_Int = 1;
    localbnwr.g = this.jdField_a_of_type_JavaLangString;
    localbnwr.h = "";
    localbnwr.jdField_a_of_type_Long = l;
    localbnwr.d = this.jdField_a_of_type_Int;
    localbnwr.k = Integer.toString(this.b);
    localbnwr.jdField_e_of_type_Int = 1;
    localbnwr.jdField_f_of_type_Int = 1;
    bnwq.a().a(localbnwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */
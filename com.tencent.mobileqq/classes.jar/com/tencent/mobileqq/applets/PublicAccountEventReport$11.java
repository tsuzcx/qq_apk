package com.tencent.mobileqq.applets;

import bgqw;
import bgqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$11
  implements Runnable
{
  public PublicAccountEventReport$11(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    bgqx localbgqx = new bgqx();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbgqx.jdField_e_of_type_JavaLangString = "vab_push";
    localbgqx.jdField_f_of_type_JavaLangString = "vab_push";
    localbgqx.b = (str + "_" + l);
    localbgqx.jdField_a_of_type_Int = 1;
    localbgqx.g = this.jdField_a_of_type_JavaLangString;
    localbgqx.h = "";
    localbgqx.jdField_a_of_type_Long = l;
    localbgqx.d = this.jdField_a_of_type_Int;
    localbgqx.k = Integer.toString(this.b);
    localbgqx.jdField_e_of_type_Int = 1;
    localbgqx.jdField_f_of_type_Int = 1;
    bgqw.a().a(localbgqx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.11
 * JD-Core Version:    0.7.0.1
 */
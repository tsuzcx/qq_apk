package com.tencent.biz.common.offline;

import java.util.HashMap;
import mqq.app.AppRuntime;
import nuw;
import nuz;
import nvm;

public final class HtmlOffline$4
  implements Runnable
{
  public HtmlOffline$4(int paramInt, String paramString, AppRuntime paramAppRuntime, HashMap paramHashMap, nuw paramnuw, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (nuz.a.a()) {
      nuz.a.a("HtmlCheckUpdate", 2, "start checkUpThread. delay:" + this.jdField_a_of_type_Int + ", businessId:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int > 0) {}
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      label75:
      nuz.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Nuw, true, this.jdField_a_of_type_Boolean, this.b);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.4
 * JD-Core Version:    0.7.0.1
 */
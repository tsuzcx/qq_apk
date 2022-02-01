package com.tencent.mobileqq.activity;

import aezx;
import bdxs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class SubLoginActivity$9$1
  implements Runnable
{
  public SubLoginActivity$9$1(aezx paramaezx, String paramString) {}
  
  public void run()
  {
    bdxs localbdxs = (bdxs)this.jdField_a_of_type_Aezx.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localbdxs != null) {
      localbdxs.a(this.jdField_a_of_type_JavaLangString, 0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.9.1
 * JD-Core Version:    0.7.0.1
 */
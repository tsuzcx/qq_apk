package com.tencent.mobileqq.activity;

import adlb;
import awyz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class AutoLoginHelper$1
  implements Runnable
{
  public AutoLoginHelper$1(adlb paramadlb) {}
  
  public void run()
  {
    ((awyz)adlb.a(this.this$0).getManager(QQManagerFactory.CONTACT_MANAGER)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.1
 * JD-Core Version:    0.7.0.1
 */
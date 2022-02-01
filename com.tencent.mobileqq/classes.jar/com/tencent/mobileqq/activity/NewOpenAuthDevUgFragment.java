package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

public class NewOpenAuthDevUgFragment
  extends NewAuthDevUgFragment
{
  protected void b()
  {
    QLog.d("NewOpenAuthDevUgFragment", 1, "opensdk beforeOpenBrowser do nothing");
  }
  
  protected void c()
  {
    QLog.d("NewOpenAuthDevUgFragment", 1, "opensdk afterOpenBrowser do finish");
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewOpenAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */
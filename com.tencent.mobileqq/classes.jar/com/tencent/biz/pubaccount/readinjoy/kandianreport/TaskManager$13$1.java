package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import amtj;
import bfur;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TaskManager$13$1
  implements Runnable
{
  TaskManager$13$1(TaskManager.13 param13, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    bfur.a(BaseActivity.sTopActivity, 232, this.val$title, this.val$message, "OK", amtj.a(2131713764), new TaskManager.13.1.1(this), new TaskManager.13.1.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.13.1
 * JD-Core Version:    0.7.0.1
 */
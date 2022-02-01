package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TaskManager$13$1
  implements Runnable
{
  TaskManager$13$1(TaskManager.13 param13, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    DialogUtil.a(BaseActivity.sTopActivity, 232, this.val$title, this.val$message, "OK", HardCodeUtil.a(2131714607), new TaskManager.13.1.1(this), new TaskManager.13.1.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.13.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import ajjj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$1
  implements Runnable
{
  PermisionPrivacyActivity$1(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    boolean bool = ((ajjj)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin()).medalSwitchDisable;
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "PermisionPrivacyActivity initUI medalSwitchDisable = " + bool);
    }
    this.this$0.runOnUiThread(new PermisionPrivacyActivity.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.1
 * JD-Core Version:    0.7.0.1
 */
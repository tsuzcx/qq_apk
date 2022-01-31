package com.tencent.mobileqq.activity;

import aloz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$2
  implements Runnable
{
  PermisionPrivacyActivity$2(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    boolean bool = ((aloz)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin()).medalSwitchDisable;
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "PermisionPrivacyActivity initUI medalSwitchDisable = " + bool);
    }
    this.this$0.runOnUiThread(new PermisionPrivacyActivity.2.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.2
 * JD-Core Version:    0.7.0.1
 */
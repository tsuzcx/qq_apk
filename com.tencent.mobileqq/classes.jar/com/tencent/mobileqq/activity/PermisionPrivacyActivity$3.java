package com.tencent.mobileqq.activity;

import banc;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$3
  implements Runnable
{
  PermisionPrivacyActivity$3(PermisionPrivacyActivity paramPermisionPrivacyActivity, FormSimpleItem paramFormSimpleItem) {}
  
  public void run()
  {
    this.a.setRightText(banc.a().a());
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "permision activity -> updateCustomOnlineStatus text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.3
 * JD-Core Version:    0.7.0.1
 */
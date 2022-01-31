package com.tencent.mobileqq.activity;

import bdsp;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$4
  implements Runnable
{
  PermisionPrivacyActivity$4(PermisionPrivacyActivity paramPermisionPrivacyActivity, FormSimpleItem paramFormSimpleItem) {}
  
  public void run()
  {
    this.a.setRightText(bdsp.a().a());
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "permision activity -> updateCustomOnlineStatus text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.4
 * JD-Core Version:    0.7.0.1
 */
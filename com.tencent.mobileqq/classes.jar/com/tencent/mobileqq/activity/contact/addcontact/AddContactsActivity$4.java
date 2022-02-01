package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.qroute.QRoute;

class AddContactsActivity$4
  extends Handler
{
  AddContactsActivity$4(AddContactsActivity paramAddContactsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrEntrance(300);
      return;
    }
    this.a.c.d();
    this.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.4
 * JD-Core Version:    0.7.0.1
 */
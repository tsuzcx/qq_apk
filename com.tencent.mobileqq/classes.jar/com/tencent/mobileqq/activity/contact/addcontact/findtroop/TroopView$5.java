package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopView$5
  implements OnRefreshListener
{
  TroopView$5(TroopView paramTroopView) {}
  
  public void a()
  {
    Message localMessage;
    if (StudyModeManager.h())
    {
      localMessage = TroopView.c(this.a).obtainMessage(15);
      TroopView.c(this.a).sendMessage(localMessage);
      return;
    }
    if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      if (this.a.e.size() > 0)
      {
        if ((TroopView.e(this.a) != null) && (TroopView.a(this.a) != null)) {
          TroopView.e(this.a).g(TroopView.a(this.a).getCurrentItem());
        }
      }
      else {
        TroopView.f(this.a);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("addContacts.TroopView", 2, "refresh falied. network unavailable");
      }
      localMessage = TroopView.c(this.a).obtainMessage(13);
      TroopView.c(this.a).sendMessageDelayed(localMessage, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contacts.base;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class ContactsViewController$1
  implements Handler.Callback
{
  ContactsViewController$1(ContactsViewController paramContactsViewController) {}
  
  private void a()
  {
    if (ContactsViewController.a(this.a) != null) {
      ContactsViewController.a(this.a).setRefreshing(false);
    }
    if (ContactsViewController.a(this.a) != null) {
      ContactsViewController.a(this.a).setRefresh(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 8: 
      this.a.f();
      return false;
    case 7: 
      if ((ContactsViewController.a(this.a) != null) && (ContactsViewController.a(this.a) != null))
      {
        ContactsViewController.a(this.a).a(ContactsViewController.a(this.a).getScrollY(), ContactsViewController.a(this.a).a());
        return false;
      }
      break;
    case 6: 
      ContactsViewController.a(this.a, true, true);
      return false;
    case 5: 
      a();
      return false;
    case 4: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        ContactsViewController.a(this.a);
        if (ContactsViewController.a(this.a) != null)
        {
          ContactsViewController.a(this.a).a(0);
          this.a.a.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
      }
      else
      {
        a();
        QQToast.a(this.a.a(), 1, 2131719247, 0).b(ContactsViewController.a(this.a));
        return false;
      }
      break;
    case 3: 
      QQToast.a(this.a.a(), 1, 2131719247, 0).b(ContactsViewController.a(this.a));
      a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController.1
 * JD-Core Version:    0.7.0.1
 */
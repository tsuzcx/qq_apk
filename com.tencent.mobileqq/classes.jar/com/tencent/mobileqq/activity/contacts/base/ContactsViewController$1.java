package com.tencent.mobileqq.activity.contacts.base;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class ContactsViewController$1
  implements Handler.Callback
{
  ContactsViewController$1(ContactsViewController paramContactsViewController) {}
  
  private void a()
  {
    if (ContactsViewController.e(this.a) != null) {
      ContactsViewController.e(this.a).setRefreshing(false);
    }
    if (ContactsViewController.b(this.a) != null) {
      ContactsViewController.b(this.a).a(18, Boolean.valueOf(false));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 8: 
      this.a.g();
      return false;
    case 7: 
      if ((ContactsViewController.c(this.a) != null) && (ContactsViewController.d(this.a) != null))
      {
        ContactsViewController.c(this.a).a(ContactsViewController.d(this.a).getScrollY(), ContactsViewController.d(this.a).getMaxY());
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
        if (ContactsViewController.b(this.a) != null)
        {
          ContactsViewController.b(this.a).a(20, null);
          ContactsViewController.b(this.a).a(0);
          this.a.c.sendEmptyMessageDelayed(5, 800L);
          return false;
        }
      }
      else
      {
        a();
        QQToast.makeText(this.a.b(), 1, 2131916799, 0).show(ContactsViewController.a(this.a));
        return false;
      }
      break;
    case 3: 
      QQToast.makeText(this.a.b(), 1, 2131916799, 0).show(ContactsViewController.a(this.a));
      a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contacts.base;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ContactsViewController$4
  extends ViewPager.SimpleOnPageChangeListener
{
  ContactsViewController$4(ContactsViewController paramContactsViewController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ContactsViewController.a(this.a, ContactsViewController.a(this.a).getCurrentItem());
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:" + ContactsViewController.b(this.a) + "  mPageChangedByIndicator:" + ContactsViewController.a(this.a));
    }
    if (ContactsViewController.a(this.a)) {
      ContactsViewController.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ContactsViewController.a(this.a, paramInt);
    if (!ContactsViewController.a(this.a)) {
      ReportController.b(this.a.a, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "mViewPager onPageSelected mOccurSwitchAccountChangeTab:" + ContactsViewController.b(this.a) + " mPageChangedByIndicator:" + ContactsViewController.a(this.a));
    }
    ContactsViewController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController.4
 * JD-Core Version:    0.7.0.1
 */
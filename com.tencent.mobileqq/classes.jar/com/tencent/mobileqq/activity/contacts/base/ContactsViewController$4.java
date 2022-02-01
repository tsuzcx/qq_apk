package com.tencent.mobileqq.activity.contacts.base;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ContactsViewController$4
  extends ViewPager.SimpleOnPageChangeListener
{
  ContactsViewController$4(ContactsViewController paramContactsViewController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.a;
      ContactsViewController.b((ContactsViewController)localObject, ContactsViewController.h((ContactsViewController)localObject).getCurrentItem());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mViewPager onPageScrollStateChanged mOccurSwitchAccountChangeTab:");
      ((StringBuilder)localObject).append(ContactsViewController.g(this.a));
      ((StringBuilder)localObject).append("  mPageChangedByIndicator:");
      ((StringBuilder)localObject).append(ContactsViewController.f(this.a));
      QLog.i("ContactsViewController", 2, ((StringBuilder)localObject).toString());
    }
    if (ContactsViewController.f(this.a)) {
      ContactsViewController.b(this.a, false);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ContactsViewController.a(this.a, paramInt);
    if (!ContactsViewController.f(this.a)) {
      ReportController.b(this.a.b, "dc00898", "", "", "0X8008059", "0X8008059", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mViewPager onPageSelected mOccurSwitchAccountChangeTab:");
      localStringBuilder.append(ContactsViewController.g(this.a));
      localStringBuilder.append(" mPageChangedByIndicator:");
      localStringBuilder.append(ContactsViewController.f(this.a));
      QLog.i("ContactsViewController", 2, localStringBuilder.toString());
    }
    ContactsViewController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ContactsViewController.4
 * JD-Core Version:    0.7.0.1
 */
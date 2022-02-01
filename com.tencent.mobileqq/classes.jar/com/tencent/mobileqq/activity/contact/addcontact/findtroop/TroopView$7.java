package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.studymode.StudyModeManager;

class TroopView$7
  extends ViewPager.SimpleOnPageChangeListener
{
  TroopView$7(TroopView paramTroopView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (StudyModeManager.a()) {}
    while (paramInt != 1) {
      return;
    }
    TroopView.a(this.a, TroopView.a(this.a).getCurrentItem());
  }
  
  public void onPageSelected(int paramInt)
  {
    if (StudyModeManager.a()) {
      return;
    }
    TroopView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.7
 * JD-Core Version:    0.7.0.1
 */
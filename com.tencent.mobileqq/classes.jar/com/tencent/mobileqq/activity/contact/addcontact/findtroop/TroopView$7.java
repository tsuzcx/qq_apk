package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.studymode.StudyModeManager;

class TroopView$7
  extends ViewPager.SimpleOnPageChangeListener
{
  TroopView$7(TroopView paramTroopView) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (StudyModeManager.h()) {
      return;
    }
    if (paramInt == 1)
    {
      TroopView localTroopView = this.a;
      TroopView.a(localTroopView, TroopView.a(localTroopView).getCurrentItem());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (StudyModeManager.h()) {
      return;
    }
    TroopView.c(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.7
 * JD-Core Version:    0.7.0.1
 */
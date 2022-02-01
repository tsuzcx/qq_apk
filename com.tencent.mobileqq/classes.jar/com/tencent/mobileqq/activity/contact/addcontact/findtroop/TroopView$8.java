package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.OnRepeatClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopView$8
  implements SimpleCheckableSlidingIndicator.OnRepeatClickListener
{
  TroopView$8(TroopView paramTroopView) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onRepeatClick. position:" + paramInt);
    }
    if (paramInt != -1)
    {
      TroopView.a(this.a).setCurrentPosition(-1, false);
      int i = TroopView.a(this.a).getCurrentItem();
      if (QLog.isColorLevel()) {
        QLog.i("addContacts.TroopView", 2, "onCurrentTabClick. position:" + paramInt + " currentClassifyPos:" + i);
      }
      Object localObject = TroopView.a(this.a).a(i, false);
      if (localObject != null)
      {
        localObject = (AddContactViewPagerTroopFragment)localObject;
        AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.a.a.get(i);
        localAddContactFindTroopClassifyInfo.b = -1;
        ((AddContactViewPagerTroopFragment)localObject).a(localAddContactFindTroopClassifyInfo.d, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.8
 * JD-Core Version:    0.7.0.1
 */
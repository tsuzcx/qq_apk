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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRepeatClick. position:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("addContacts.TroopView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != -1)
    {
      TroopView.a(this.a).setCurrentPosition(-1, false);
      int i = TroopView.a(this.a).getCurrentItem();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCurrentTabClick. position:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" currentClassifyPos:");
        ((StringBuilder)localObject).append(i);
        QLog.i("addContacts.TroopView", 2, ((StringBuilder)localObject).toString());
      }
      localObject = TroopView.a(this.a).a(i, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.8
 * JD-Core Version:    0.7.0.1
 */
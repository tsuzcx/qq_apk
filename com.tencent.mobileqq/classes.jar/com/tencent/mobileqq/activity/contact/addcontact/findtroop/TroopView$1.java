package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.view.View;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.qphone.base.util.QLog;

class TroopView$1
  implements AddContactTroopClassifyAdapter.onItemClickListener
{
  TroopView$1(TroopView paramTroopView) {}
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("AddContactTroopClassifyAdapter.onItemClickListener onItemClick. position:");
      paramView.append(paramInt);
      QLog.i("addContacts.TroopView", 2, paramView.toString());
    }
    paramView = this.a;
    TroopView.a(paramView, TroopView.a(paramView).getCurrentItem());
    TroopView.b(this.a, paramInt);
    TroopView.a(this.a).setCurrentItem(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.1
 * JD-Core Version:    0.7.0.1
 */
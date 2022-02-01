package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.qphone.base.util.QLog;

class TroopView$3
  implements ContactsBaseFragment.RefreshDataListener
{
  TroopView$3(TroopView paramTroopView) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addContacts.TroopView", 2, "onRefreshResult. position:" + paramInt + " success:" + paramBoolean);
    }
    paramObject = TroopView.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramObject = paramObject.obtainMessage(14, paramInt, i);
      TroopView.a(this.a).sendMessage(paramObject);
      return;
    }
  }
  
  public void af_()
  {
    if ((TroopView.a(this.a) != null) && (!TroopView.a(this.a).a())) {
      TroopView.a(this.a).scrollTo(0, TroopView.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView.OnScrollListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;

class TroopView$10
  implements HeaderScrollView.OnScrollListener
{
  TroopView$10(TroopView paramTroopView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (TroopView.a(this.a) != null) {
      TroopView.a(this.a).a(paramInt1, paramInt2);
    }
    if (paramInt1 >= paramInt2)
    {
      if (!TroopView.a(this.a))
      {
        TroopView.a(this.a, true);
        if (this.a.a != null) {
          this.a.a.a(TroopView.a(this.a));
        }
      }
    }
    else if (TroopView.a(this.a))
    {
      TroopView.a(this.a, false);
      if (this.a.a != null) {
        this.a.a.a(TroopView.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.10
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddContactTroopClassifyAdapter$1
  implements View.OnClickListener
{
  AddContactTroopClassifyAdapter$1(AddContactTroopClassifyAdapter paramAddContactTroopClassifyAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b.d != null) {
      this.b.d.a(paramView, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactTroopClassifyAdapter.1
 * JD-Core Version:    0.7.0.1
 */
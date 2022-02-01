package com.tencent.mobileqq.activity.contacts.guild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactsGuildAdapter$4
  implements View.OnClickListener
{
  ContactsGuildAdapter$4(ContactsGuildAdapter paramContactsGuildAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.b.b[this.a] = 2;
    this.b.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter.4
 * JD-Core Version:    0.7.0.1
 */
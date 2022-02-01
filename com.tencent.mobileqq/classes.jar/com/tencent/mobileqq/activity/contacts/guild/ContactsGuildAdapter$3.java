package com.tencent.mobileqq.activity.contacts.guild;

import java.util.List;

class ContactsGuildAdapter$3
  implements Runnable
{
  ContactsGuildAdapter$3(ContactsGuildAdapter paramContactsGuildAdapter, List paramList1, List paramList2, List paramList3, List paramList4) {}
  
  public void run()
  {
    ContactsGuildAdapter.b(this.this$0).clear();
    ContactsGuildAdapter.b(this.this$0).addAll(this.a);
    ContactsGuildAdapter.c(this.this$0).clear();
    ContactsGuildAdapter.c(this.this$0).addAll(this.b);
    ContactsGuildAdapter.d(this.this$0).clear();
    ContactsGuildAdapter.d(this.this$0).addAll(this.c);
    ContactsGuildAdapter.e(this.this$0).clear();
    ContactsGuildAdapter.e(this.this$0).addAll(this.d);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter.3
 * JD-Core Version:    0.7.0.1
 */
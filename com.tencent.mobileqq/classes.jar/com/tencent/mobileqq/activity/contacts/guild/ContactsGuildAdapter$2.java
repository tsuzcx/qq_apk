package com.tencent.mobileqq.activity.contacts.guild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.List;

class ContactsGuildAdapter$2
  implements Runnable
{
  ContactsGuildAdapter$2(ContactsGuildAdapter paramContactsGuildAdapter) {}
  
  public void run()
  {
    if (ContactsGuildAdapter.a(this.this$0) != null)
    {
      List localList = ((IGPSService)ContactsGuildAdapter.a(this.this$0).getRuntimeService(IGPSService.class, "")).getGuildList();
      ContactsGuildAdapter.a(this.this$0, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter.2
 * JD-Core Version:    0.7.0.1
 */
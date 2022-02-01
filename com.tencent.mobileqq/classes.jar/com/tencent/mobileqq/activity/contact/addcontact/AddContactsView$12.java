package com.tencent.mobileqq.activity.contact.addcontact;

import aobl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AddContactsView$12
  implements Runnable
{
  AddContactsView$12(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    Object localObject = (aobl)this.this$0.a.getManager(159);
    int i = ((aobl)localObject).a();
    localObject = ((aobl)localObject).b();
    ThreadManager.getUIHandler().post(new AddContactsView.12.1(this, i, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.addcontact;

import alro;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AddContactsView$11
  implements Runnable
{
  AddContactsView$11(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    Object localObject = (alro)this.this$0.a.getManager(159);
    int i = ((alro)localObject).a();
    localObject = ((alro)localObject).b();
    ThreadManager.getUIHandler().post(new AddContactsView.11.1(this, i, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.11
 * JD-Core Version:    0.7.0.1
 */
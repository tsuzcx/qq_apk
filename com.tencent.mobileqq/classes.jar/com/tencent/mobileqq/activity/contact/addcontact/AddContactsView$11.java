package com.tencent.mobileqq.activity.contact.addcontact;

import alwd;
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
    Object localObject = (alwd)this.this$0.a.getManager(159);
    int i = ((alwd)localObject).a();
    localObject = ((alwd)localObject).b();
    ThreadManager.getUIHandler().post(new AddContactsView.11.1(this, i, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.11
 * JD-Core Version:    0.7.0.1
 */
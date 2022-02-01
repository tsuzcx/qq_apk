package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$8
  implements ConditionSearchManager.IConfigListener
{
  AddContactsView$8(AddContactsView paramAddContactsView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConfig | isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt == 2) && (paramBoolean))
    {
      localObject = this.a;
      ((AddContactsView)localObject).d = true;
      ((AddContactsView)localObject).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.8
 * JD-Core Version:    0.7.0.1
 */
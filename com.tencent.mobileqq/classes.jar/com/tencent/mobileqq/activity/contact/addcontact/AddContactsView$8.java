package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$8
  implements ConditionSearchManager.IConfigListener
{
  AddContactsView$8(AddContactsView paramAddContactsView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onGetConfig | isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((paramInt == 2) && (paramBoolean))
    {
      this.a.d = true;
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.8
 * JD-Core Version:    0.7.0.1
 */
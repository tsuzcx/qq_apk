package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AddFriendVerifyActivity$PobingTemplateObserver
  implements BusinessObserver
{
  private int jdField_a_of_type_Int;
  private WeakReference<AddFriendVerifyActivity> jdField_a_of_type_MqqUtilWeakReference;
  
  public AddFriendVerifyActivity$PobingTemplateObserver(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAddFriendVerifyActivity);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AddFriendVerifyActivity localAddFriendVerifyActivity = (AddFriendVerifyActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localAddFriendVerifyActivity != null) && (!localAddFriendVerifyActivity.isFinishing()))
    {
      localAddFriendVerifyActivity.a(paramInt, paramBoolean, paramObject, this.jdField_a_of_type_Int);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("onUpdate: activity is null, type=");
    paramObject.append(paramInt);
    QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.PobingTemplateObserver
 * JD-Core Version:    0.7.0.1
 */
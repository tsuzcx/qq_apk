package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AddFriendVerifyActivity$PobingTemplateObserver
  implements BusinessObserver
{
  private int a;
  private WeakReference<AddFriendVerifyActivity> b;
  
  public AddFriendVerifyActivity$PobingTemplateObserver(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt)
  {
    this.a = paramInt;
    this.b = new WeakReference(paramAddFriendVerifyActivity);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    AddFriendVerifyActivity localAddFriendVerifyActivity = (AddFriendVerifyActivity)this.b.get();
    if ((localAddFriendVerifyActivity != null) && (!localAddFriendVerifyActivity.isFinishing()))
    {
      localAddFriendVerifyActivity.a(paramInt, paramBoolean, paramObject, this.a);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("onUpdate: activity is null, type=");
    paramObject.append(paramInt);
    QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.PobingTemplateObserver
 * JD-Core Version:    0.7.0.1
 */
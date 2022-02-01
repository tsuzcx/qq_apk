package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

class AssociatedAccountManageActivity$8
  extends FriendListObserver
{
  AssociatedAccountManageActivity$8(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    View localView;
    do
    {
      return;
      localView = AssociatedAccountManageActivity.a(this.a, paramString, 0);
      if (localView != null)
      {
        ((SingleLineTextView)localView.findViewById(2131372115)).setText(ContactUtils.h(this.a.app, paramString));
        this.a.a(paramString, localView);
      }
      localView = AssociatedAccountManageActivity.a(this.a, paramString, 1);
    } while (localView == null);
    ((SingleLineTextView)localView.findViewById(2131372115)).setText(ContactUtils.h(this.a.app, paramString));
    this.a.a(paramString, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8
 * JD-Core Version:    0.7.0.1
 */
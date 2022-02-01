package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.FriendListObserverCallback;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

class AssociatedAccountManageActivity$8
  implements ISubAccountApi.FriendListObserverCallback
{
  AssociatedAccountManageActivity$8(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendInfo  uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AssociatedAccountManage", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = AssociatedAccountManageActivity.access$1500(this.a, paramString, 0);
      if (localObject != null)
      {
        ((SingleLineTextView)((View)localObject).findViewById(2131439121)).setText(((IContactUtils)QRoute.api(IContactUtils.class)).getAccountNickName(this.a.app, paramString));
        this.a.updateFace(paramString, (View)localObject);
      }
      localObject = AssociatedAccountManageActivity.access$1500(this.a, paramString, 1);
      if (localObject != null)
      {
        ((SingleLineTextView)((View)localObject).findViewById(2131439121)).setText(((IContactUtils)QRoute.api(IContactUtils.class)).getAccountNickName(this.a.app, paramString));
        this.a.updateFace(paramString, (View)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8
 * JD-Core Version:    0.7.0.1
 */
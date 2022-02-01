package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class AssociatedAccountManageActivity$9
  extends AvatarObserver
{
  AssociatedAccountManageActivity$9(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      View localView = AssociatedAccountManageActivity.access$1500(this.a, paramString, 0);
      if (localView != null) {
        this.a.updateFace(paramString, localView);
      }
      localView = AssociatedAccountManageActivity.access$1500(this.a, paramString, 1);
      if (localView != null) {
        this.a.updateFace(paramString, localView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.9
 * JD-Core Version:    0.7.0.1
 */
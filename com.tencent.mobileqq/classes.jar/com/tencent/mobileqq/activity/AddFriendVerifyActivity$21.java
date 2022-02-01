package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.widget.QQToast;

class AddFriendVerifyActivity$21
  extends TroopShowExternalObserver
{
  AddFriendVerifyActivity$21(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null)
    {
      if (!this.a.a.equals(paramString)) {
        return;
      }
      boolean bool = false;
      if (!paramBoolean)
      {
        paramString = this.a;
        QQToast.a(paramString, paramString.getString(2131696194), 0).b(this.a.getTitleBarHeight());
        AddFriendVerifyActivity.c(this.a);
      }
      paramString = this.a;
      paramBoolean = bool;
      if (paramInt3 == 1) {
        paramBoolean = true;
      }
      paramString.c = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.21
 * JD-Core Version:    0.7.0.1
 */
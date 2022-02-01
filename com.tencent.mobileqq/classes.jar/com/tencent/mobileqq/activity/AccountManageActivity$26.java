package com.tencent.mobileqq.activity;

import android.widget.LinearLayout;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class AccountManageActivity$26
  extends AvatarObserver
{
  AccountManageActivity$26(AccountManageActivity paramAccountManageActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      LinearLayout localLinearLayout = this.a.a;
      int j = 0;
      int i;
      if (localLinearLayout != null) {
        i = this.a.a.getChildCount();
      } else {
        i = 0;
      }
      while (j < this.a.e.size())
      {
        if ((i > j) && (this.a.e.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.e.get(j)).getUin())))
        {
          this.a.a(paramString, j);
          return;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.26
 * JD-Core Version:    0.7.0.1
 */
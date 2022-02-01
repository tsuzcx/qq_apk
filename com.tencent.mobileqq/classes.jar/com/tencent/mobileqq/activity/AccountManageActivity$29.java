package com.tencent.mobileqq.activity;

import android.widget.LinearLayout;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class AccountManageActivity$29
  extends AvatarObserver
{
  AccountManageActivity$29(AccountManageActivity paramAccountManageActivity) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          this.a.a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.29
 * JD-Core Version:    0.7.0.1
 */
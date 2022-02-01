package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.List;

class AccountManageActivity$30
  extends FriendListObserver
{
  AccountManageActivity$30(AccountManageActivity paramAccountManageActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      Object localObject2 = this.a.app;
      Object localObject1 = "";
      Object localObject3 = (ISubAccountService)((QQAppInterface)localObject2).getRuntimeService(ISubAccountService.class, "");
      int i = ((ISubAccountService)localObject3).getBindedNumber();
      int j = 0;
      if (i == 0)
      {
        AccountManageActivity.b(this.a).setVisibility(8);
        AccountManageActivity.c(this.a).setVisibility(8);
      }
      else if (i == 1)
      {
        localObject2 = ((ISubAccountService)localObject3).getSubAccountInfo("sub.uin.default");
        if (localObject2 != null)
        {
          localObject1 = ContactUtils.b(this.a.app, ((SubAccountInfo)localObject2).subuin, false);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((TextUtils.isEmpty(((SubAccountInfo)localObject2).subname)) || (!((String)localObject1).equals(((SubAccountInfo)localObject2).subname))))
          {
            ((SubAccountInfo)localObject2).subname = ((String)localObject1);
            localObject3 = this.a;
            ((AccountManageActivity)localObject3).a(AccountManageActivity.c((AccountManageActivity)localObject3), ((SubAccountInfo)localObject2).subuin);
            AccountManageActivity.c(this.a).setVisibility(0);
            AccountManageActivity.b(this.a).setVisibility(8);
            if (AppSetting.d)
            {
              localObject2 = AccountManageActivity.a(this.a);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("关联QQ号");
              ((StringBuilder)localObject3).append((String)localObject1);
              ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
            }
          }
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131699970));
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject3 = ((ISubAccountService)localObject3).getAllSubUin();
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() == 2)
        {
          localObject1 = this.a;
          ((AccountManageActivity)localObject1).a(AccountManageActivity.c((AccountManageActivity)localObject1), (String)((ArrayList)localObject3).get(0));
          AccountManageActivity.c(this.a).setVisibility(0);
          localObject1 = this.a;
          ((AccountManageActivity)localObject1).a(AccountManageActivity.b((AccountManageActivity)localObject1), (String)((ArrayList)localObject3).get(1));
          AccountManageActivity.b(this.a).setVisibility(0);
          localObject1 = localObject2;
        }
      }
      if (AppSetting.d)
      {
        localObject2 = AccountManageActivity.a(this.a);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("关联QQ号");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
      }
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      } else {
        i = 0;
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131371697);
          localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131361863);
          ((TextView)localObject1).setText(ContactUtils.e(this.a.app, paramString));
          ((TextView)localObject2).setText(paramString);
          this.a.a(paramString, j);
          return;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.30
 * JD-Core Version:    0.7.0.1
 */
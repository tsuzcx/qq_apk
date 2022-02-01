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

class AccountManageActivity$27
  extends FriendListObserver
{
  AccountManageActivity$27(AccountManageActivity paramAccountManageActivity) {}
  
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
        AccountManageActivity.j(this.a).setVisibility(8);
        AccountManageActivity.k(this.a).setVisibility(8);
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
            ((AccountManageActivity)localObject3).a(AccountManageActivity.k((AccountManageActivity)localObject3), ((SubAccountInfo)localObject2).subuin);
            AccountManageActivity.k(this.a).setVisibility(0);
            AccountManageActivity.j(this.a).setVisibility(8);
            if (AppSetting.e)
            {
              localObject2 = AccountManageActivity.l(this.a);
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
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131898016));
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject3 = ((ISubAccountService)localObject3).getAllSubUin();
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() == 2)
        {
          localObject1 = this.a;
          ((AccountManageActivity)localObject1).a(AccountManageActivity.k((AccountManageActivity)localObject1), (String)((ArrayList)localObject3).get(0));
          AccountManageActivity.k(this.a).setVisibility(0);
          localObject1 = this.a;
          ((AccountManageActivity)localObject1).a(AccountManageActivity.j((AccountManageActivity)localObject1), (String)((ArrayList)localObject3).get(1));
          AccountManageActivity.j(this.a).setVisibility(0);
          localObject1 = localObject2;
        }
      }
      if (AppSetting.e)
      {
        localObject2 = AccountManageActivity.l(this.a);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("关联QQ号");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
      }
      if (this.a.a != null) {
        i = this.a.a.getChildCount();
      } else {
        i = 0;
      }
      while (j < this.a.e.size())
      {
        if ((i > j) && (this.a.e.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.e.get(j)).getUin())))
        {
          localObject1 = (TextView)this.a.a.getChildAt(j).findViewById(2131439121);
          localObject2 = (TextView)this.a.a.getChildAt(j).findViewById(2131427416);
          ((TextView)localObject1).setText(ContactUtils.f(this.a.app, paramString));
          ((TextView)localObject2).setText(paramString);
          this.a.a(paramString, j);
          return;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.27
 * JD-Core Version:    0.7.0.1
 */
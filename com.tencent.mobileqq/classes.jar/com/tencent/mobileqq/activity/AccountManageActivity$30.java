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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.List;

class AccountManageActivity$30
  extends FriendListObserver
{
  AccountManageActivity$30(AccountManageActivity paramAccountManageActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    Object localObject3 = (SubAccountManager)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    Object localObject1 = "";
    int i = ((SubAccountManager)localObject3).a();
    label68:
    label125:
    Object localObject2;
    if (i == 0)
    {
      AccountManageActivity.b(this.a).setVisibility(8);
      AccountManageActivity.c(this.a).setVisibility(8);
      if (AppSetting.d) {
        AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject1);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label570;
      }
      i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (j >= this.a.jdField_a_of_type_JavaUtilList.size()) {
        break label573;
      }
      if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
      {
        localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131372115);
        localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131361857);
        ((TextView)localObject1).setText(ContactUtils.h(this.a.app, paramString));
        ((TextView)localObject2).setText(paramString);
        this.a.a(paramString, j);
      }
    }
    else if (i == 1)
    {
      localObject3 = ((SubAccountManager)localObject3).a("sub.uin.default");
      if (localObject3 == null) {
        break label575;
      }
      localObject2 = ContactUtils.d(this.a.app, ((SubAccountInfo)localObject3).subuin, false);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!TextUtils.isEmpty(((SubAccountInfo)localObject3).subname))
        {
          localObject1 = localObject2;
          if (((String)localObject2).equals(((SubAccountInfo)localObject3).subname)) {}
        }
        else
        {
          ((SubAccountInfo)localObject3).subname = ((String)localObject2);
          this.a.a(AccountManageActivity.c(this.a), ((SubAccountInfo)localObject3).subuin);
          AccountManageActivity.c(this.a).setVisibility(0);
          AccountManageActivity.b(this.a).setVisibility(8);
          localObject1 = localObject2;
          if (AppSetting.d) {
            AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject2);
          }
        }
      }
    }
    label570:
    label573:
    label575:
    for (localObject1 = localObject2;; localObject1 = "")
    {
      break label68;
      localObject2 = i + HardCodeUtil.a(2131699829);
      localObject3 = ((SubAccountManager)localObject3).a();
      localObject1 = localObject2;
      if (((ArrayList)localObject3).size() != 2) {
        break label68;
      }
      this.a.a(AccountManageActivity.c(this.a), (String)((ArrayList)localObject3).get(0));
      AccountManageActivity.c(this.a).setVisibility(0);
      this.a.a(AccountManageActivity.b(this.a), (String)((ArrayList)localObject3).get(1));
      AccountManageActivity.b(this.a).setVisibility(0);
      localObject1 = localObject2;
      break label68;
      j += 1;
      break label125;
      i = 0;
      break label125;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.30
 * JD-Core Version:    0.7.0.1
 */
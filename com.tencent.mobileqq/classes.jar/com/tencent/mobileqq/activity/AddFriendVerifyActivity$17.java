package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactSecCheckWebPlugin;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendVerifyActivity$17
  extends FriendObserver
{
  AddFriendVerifyActivity$17(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<AddBatchPhoneFriendResult> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      int i;
      if (paramArrayList != null) {
        i = paramArrayList.size();
      } else {
        i = -1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddBatchPhoneFriend success=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", added count=");
      ((StringBuilder)localObject).append(i);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (this.a.a != null) {
        this.a.a.dismiss();
      }
      QQToast.makeText(this.a, 2, 2131916258, 0).show(this.a.getTitleBarHeight());
      localObject = new Intent();
      ((Intent)localObject).putExtra("result", paramArrayList);
      this.a.setResult(-1, (Intent)localObject);
      this.a.finish();
      return;
    }
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    AddFriendVerifyActivity.p(this.a).clear();
    QQToast.makeText(this.a, 1, 2131915702, 0).show(this.a.getTitleBarHeight());
    this.a.setResult(0);
    this.a.finish();
  }
  
  protected void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle)
  {
    String str = "";
    if ((paramBoolean) && (paramBundle != null))
    {
      AddFriendVerifyActivity.a(this.a, paramBundle);
      str = paramBundle.getString("security_check_url", "");
      paramBundle = paramBundle.getString("security_check_buffer", "");
      AddContactSecCheckWebPlugin.a(this.a.app, this.a, 1004, str);
    }
    else
    {
      paramBundle = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFriendSecCheck, isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",");
      localStringBuilder.append(TextUtils.isEmpty(str));
      localStringBuilder.append(",");
      localStringBuilder.append(TextUtils.isEmpty(paramBundle));
      QLog.d("AddFriendVerifyActivity", 2, localStringBuilder.toString());
    }
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(AddFriendVerifyActivity.d(this.a), paramString1)) {
      return;
    }
    if (paramBoolean) {
      if ((!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(AddFriendVerifyActivity.m(this.a))) && (this.a.v == null))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("onGetAutoInfo remark = ");
          paramString1.append(paramString2);
          QLog.d("AddFriendVerifyActivity", 2, paramString1.toString());
        }
        this.a.f.setText(paramString2);
      }
    }
    try
    {
      this.a.f.setSelection(this.a.f.getText().length());
    }
    catch (IndexOutOfBoundsException paramString1)
    {
      label128:
      break label128;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
    }
    if (AppSetting.e)
    {
      paramString1 = AddFriendVerifyActivity.n(this.a);
      paramString2 = new StringBuilder();
      paramString2.append(this.a.getResources().getString(2131890924));
      paramString2.append(this.a.f.getText().toString());
      paramString1.setContentDescription(paramString2.toString());
    }
    AddFriendVerifyActivity.a(this.a, paramInt);
    this.a.g.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.a.app, AddFriendVerifyActivity.o(this.a)));
    return;
    AddFriendVerifyActivity.a(this.a, 0);
    this.a.g.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.a.app, AddFriendVerifyActivity.o(this.a)));
  }
  
  protected void onGetInfoWithOpenId(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyActivity.d(this.a))) && (!TextUtils.isEmpty(paramString2)))
    {
      AddFriendVerifyActivity.f(this.a).setText(paramString2);
      if (AppSetting.e) {
        AddFriendVerifyActivity.f(this.a).setContentDescription(paramString2);
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, AddFriendVerifyActivity.d(this.a))) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBundle.getInt("friend_setting") == 3)
      {
        if (paramBoolean2)
        {
          paramString = this.a;
          paramString.a(paramString.b.getText().toString().trim(), paramBundle.getByteArray("sig"), paramBundle.getString("security_ticket", ""));
          return;
        }
        if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {
          paramString = paramBundle.getString("ErrorString");
        } else {
          paramString = this.a.getString(2131886665);
        }
        QQToast.makeText(this.a, 1, paramString, 1).show(this.a.getTitleBarHeight());
        return;
      }
      if (paramBundle.getInt("resultCode") == 0)
      {
        i = paramBundle.getInt("friend_setting");
        paramBundle.getString("nick_name");
        if (i != 0) {
          if ((i != 1) && (i != 4))
          {
            if (i != 100)
            {
              if (this.a.a != null)
              {
                this.a.a.cancel();
                this.a.a = null;
              }
              QQToast.makeText(this.a, 2, 2131915701, 0).show(this.a.getTitleBarHeight());
              this.a.a();
            }
          }
          else
          {
            if (this.a.a != null)
            {
              this.a.a.cancel();
              this.a.a = null;
            }
            QQToast.makeText(this.a, 2, 2131915701, 0).show(this.a.getTitleBarHeight());
            this.a.a();
            return;
          }
        }
        if (this.a.a != null)
        {
          this.a.a.cancel();
          this.a.a = null;
        }
        QQToast.makeText(this.a, 2, 2131886209, 0).show(this.a.getTitleBarHeight());
        if (Utils.c(paramString))
        {
          Object localObject = this.a.f.getText().toString();
          String str = AddFriendVerifyActivity.f(this.a).getText().toString();
          paramBundle = (Bundle)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramBundle = str;
          }
          localObject = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
          ((Intent)localObject).putExtra("uin", paramString);
          ((Intent)localObject).putExtra("uintype", 0);
          ((Intent)localObject).putExtra("uinname", paramBundle);
          this.a.startActivity((Intent)localObject);
          ((BabyQHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(this.a.getIntent());
          return;
        }
        this.a.a();
        return;
      }
      if (this.a.a != null)
      {
        this.a.a.cancel();
        this.a.a = null;
      }
      int i = paramBundle.getInt("error_code", 0);
      paramBundle = paramBundle.getString("ErrorString");
      if (i == 167)
      {
        AddFriendVerifyActivity.a(this.a, paramBundle);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("add friend response error and ErroString = ");
        paramString.append(paramBundle);
        QLog.d("AddFriendVerifyActivity", 2, paramString.toString());
      }
      paramString = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        paramString = this.a.getString(2131915702);
      }
      AddFriendVerifyActivity.b(this.a, paramString);
      return;
    }
    if (this.a.a != null)
    {
      this.a.a.cancel();
      this.a.a = null;
    }
    paramString = this.a;
    AddFriendVerifyActivity.b(paramString, paramString.getString(2131915702));
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "add friend response error and isSuccuss = NO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.17
 * JD-Core Version:    0.7.0.1
 */
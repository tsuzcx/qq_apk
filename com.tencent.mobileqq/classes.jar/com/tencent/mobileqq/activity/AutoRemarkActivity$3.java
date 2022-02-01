package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AutoRemarkActivity$3
  extends FriendObserver
{
  AutoRemarkActivity$3(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.a.b, paramString1)) {
      return;
    }
    if (paramBoolean) {
      if ((!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.a.c)) && (!this.a.l))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("onGetAutoInfo remark = ");
          paramString1.append(paramString2);
          QLog.d("AutoRemarkActivity", 2, paramString1.toString());
        }
        this.a.g.setText(paramString2);
      }
    }
    try
    {
      this.a.g.setSelection(this.a.g.getText().length());
    }
    catch (IndexOutOfBoundsException paramString1)
    {
      label128:
      break label128;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
    }
    if (AppSetting.e)
    {
      paramString1 = AutoRemarkActivity.f(this.a);
      paramString2 = new StringBuilder();
      paramString2.append(this.a.getResources().getString(2131890924));
      paramString2.append(this.a.g.getText().toString());
      paramString1.setContentDescription(paramString2.toString());
    }
    paramString1 = this.a;
    paramString1.d = paramInt;
    paramString1.h.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.a.app, this.a.d));
    return;
    paramString1 = this.a;
    paramString1.d = 0;
    paramString1.h.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.a.app, this.a.d));
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, this.a.b)) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBundle.getInt("resultCode") == 0)
      {
        int i = paramBundle.getInt("friend_setting");
        paramBundle.getString("nick_name");
        if (i != 0) {
          if ((i != 1) && (i != 4))
          {
            if (i != 100)
            {
              AutoRemarkActivity.c(this.a);
              QQToast.makeText(this.a, 2, 2131916262, 0).show(this.a.getTitleBarHeight());
              this.a.a();
              break label188;
            }
          }
          else
          {
            AutoRemarkActivity.b(this.a);
            QQToast.makeText(this.a, 2, 2131916262, 0).show(this.a.getTitleBarHeight());
            this.a.a();
            break label188;
          }
        }
        AutoRemarkActivity.a(this.a);
        QQToast.makeText(this.a, 2, 2131886209, 0).show(this.a.getTitleBarHeight());
        this.a.a();
        label188:
        ((BabyQHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(this.a.getIntent());
        return;
      }
      AutoRemarkActivity.d(this.a);
      paramBundle = paramBundle.getString("ErrorString");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("add friend response error and ErroString = ");
        paramString.append(paramBundle);
        QLog.d("AutoRemarkActivity", 2, paramString.toString());
      }
      paramString = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        paramString = this.a.getString(2131915702);
      }
      AutoRemarkActivity.a(this.a, paramString);
      return;
    }
    AutoRemarkActivity.e(this.a);
    paramString = this.a;
    AutoRemarkActivity.a(paramString, paramString.getString(2131915702));
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity.3
 * JD-Core Version:    0.7.0.1
 */
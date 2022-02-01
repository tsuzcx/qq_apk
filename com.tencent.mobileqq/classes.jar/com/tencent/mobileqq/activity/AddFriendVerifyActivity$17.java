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
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendVerifyActivity$17
  extends FriendListObserver
{
  AddFriendVerifyActivity$17(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      if (paramArrayList == null) {
        break label199;
      }
    }
    label199:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.d("AddFriendVerifyActivity", 2, "onAddBatchPhoneFriend success=" + paramBoolean + ", added count=" + i);
      if (paramBoolean)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        QQToast.a(this.a, 2, 2131719036, 0).b(this.a.getTitleBarHeight());
        Intent localIntent = new Intent();
        localIntent.putExtra("result", paramArrayList);
        this.a.setResult(-1, localIntent);
        this.a.finish();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      AddFriendVerifyActivity.b(this.a).clear();
      QQToast.a(this.a, 1, 2131718552, 0).b(this.a.getTitleBarHeight());
      this.a.setResult(0);
      this.a.finish();
      return;
    }
  }
  
  public void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle)
  {
    String str3 = "";
    String str4 = "";
    String str2 = str4;
    String str1 = str3;
    if (paramBoolean)
    {
      str2 = str4;
      str1 = str3;
      if (paramBundle != null)
      {
        AddFriendVerifyActivity.a(this.a, paramBundle);
        str1 = paramBundle.getString("security_check_url", "");
        str2 = paramBundle.getString("security_check_buffer", "");
        AddContactSecCheckWebPlugin.a(this.a.app, this.a, 1004, str1, str2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "onAddFriendSecCheck, isSuccess=" + paramBoolean + "," + TextUtils.isEmpty(str1) + "," + TextUtils.isEmpty(str2));
    }
  }
  
  public void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(AddFriendVerifyActivity.a(this.a), paramString1)) {
      return;
    }
    if (paramBoolean)
    {
      if ((!AutoRemarkActivity.a(AddFriendVerifyActivity.b(this.a))) && (this.a.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo remark = " + paramString2);
        }
        this.a.b.setText(paramString2);
      }
      try
      {
        this.a.b.setSelection(this.a.b.getText().length());
        if (AppSetting.d) {
          AddFriendVerifyActivity.a(this.a).setContentDescription(this.a.getResources().getString(2131693420) + this.a.b.getText().toString());
        }
        AddFriendVerifyActivity.a(this.a, paramInt);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.a.app, AddFriendVerifyActivity.c(this.a)));
        return;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
          }
        }
      }
    }
    AddFriendVerifyActivity.a(this.a, 0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(AutoRemarkActivity.a(this.a.app, AddFriendVerifyActivity.c(this.a)));
  }
  
  public void onInfoOpenId(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyActivity.a(this.a))) && (!TextUtils.isEmpty(paramString2)))
    {
      AddFriendVerifyActivity.a(this.a).setText(paramString2);
      if (AppSetting.d) {
        AddFriendVerifyActivity.a(this.a).setContentDescription(paramString2);
      }
    }
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, AddFriendVerifyActivity.a(this.a))) {}
    do
    {
      return;
      if (paramBoolean1)
      {
        if (paramBundle.getInt("friend_setting") == 3)
        {
          if (paramBoolean2)
          {
            this.a.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim(), paramBundle.getByteArray("sig"), paramBundle.getString("security_ticket", ""));
            return;
          }
          if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {}
          for (paramString = paramBundle.getString("ErrorString");; paramString = this.a.getString(2131690100))
          {
            QQToast.a(this.a, 1, paramString, 1).b(this.a.getTitleBarHeight());
            return;
          }
        }
        if (paramBundle.getInt("resultCode") == 0)
        {
          i = paramBundle.getInt("friend_setting");
          if (paramBundle.getString("nick_name") == null) {}
          switch (i)
          {
          default: 
            if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
            }
            QQToast.a(this.a, 2, 2131718551, 0).b(this.a.getTitleBarHeight());
            this.a.a();
            return;
          case 0: 
          case 100: 
            if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
            }
            QQToast.a(this.a, 2, 2131689567, 0).b(this.a.getTitleBarHeight());
            if (Utils.b(paramString))
            {
              paramBundle = this.a.b.getText().toString();
              Object localObject = AddFriendVerifyActivity.a(this.a).getText().toString();
              if (TextUtils.isEmpty(paramBundle)) {
                paramBundle = (Bundle)localObject;
              }
              for (;;)
              {
                localObject = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
                ((Intent)localObject).putExtra("uin", paramString);
                ((Intent)localObject).putExtra("uintype", 0);
                ((Intent)localObject).putExtra("uinname", paramBundle);
                this.a.startActivity((Intent)localObject);
                ((BabyQHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(this.a.getIntent());
                return;
              }
            }
            this.a.a();
            return;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
          }
          QQToast.a(this.a, 2, 2131718551, 0).b(this.a.getTitleBarHeight());
          this.a.a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
        int i = paramBundle.getInt("error_code", 0);
        paramBundle = paramBundle.getString("ErrorString");
        if (i == 167)
        {
          AddFriendVerifyActivity.a(this.a, paramBundle);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "add friend response error and ErroString = " + paramBundle);
        }
        paramString = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramString = this.a.getString(2131718552);
        }
        AddFriendVerifyActivity.b(this.a, paramString);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      AddFriendVerifyActivity.b(this.a, this.a.getString(2131718552));
    } while (!QLog.isColorLevel());
    QLog.d("AddFriendVerifyActivity", 2, "add friend response error and isSuccuss = NO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.17
 * JD-Core Version:    0.7.0.1
 */
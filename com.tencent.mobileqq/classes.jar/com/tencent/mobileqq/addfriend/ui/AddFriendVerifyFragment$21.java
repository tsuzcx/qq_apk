package com.tencent.mobileqq.addfriend.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendVerifyFragment$21
  extends FriendObserver
{
  AddFriendVerifyFragment$21(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<AddBatchPhoneFriendResult> paramArrayList)
  {
    if (AddFriendVerifyFragment.b(this.a)) {
      return;
    }
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
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (AddFriendVerifyFragment.a(this.a) != null) {
        AddFriendVerifyFragment.a(this.a).dismiss();
      }
      QQToast.a(this.a.getActivity(), 2, 2131718752, 0).b(this.a.getQBaseActivity().getTitleBarHeight());
      localObject = new Intent();
      ((Intent)localObject).putExtra("result", paramArrayList);
      this.a.getActivity().setResult(-1, (Intent)localObject);
      this.a.getActivity().finish();
      return;
    }
    if (AddFriendVerifyFragment.a(this.a) != null) {
      AddFriendVerifyFragment.a(this.a).dismiss();
    }
    AddFriendVerifyFragment.b(this.a).clear();
    QQToast.a(this.a.getActivity(), 1, 2131718220, 0).b(this.a.getQBaseActivity().getTitleBarHeight());
    this.a.getActivity().setResult(0);
    this.a.getActivity().finish();
  }
  
  protected void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle)
  {
    if (AddFriendVerifyFragment.b(this.a)) {
      return;
    }
    Object localObject = "";
    String str;
    if ((paramBoolean) && (paramBundle != null))
    {
      AddFriendVerifyFragment.a(this.a, paramBundle);
      localObject = paramBundle.getString("security_check_url", "");
      str = paramBundle.getString("security_check_buffer", "");
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).openSecCheckWebForFragment(AddFriendVerifyFragment.a(this.a), this.a.getActivity(), this.a, 1004, (String)localObject, str);
      paramBundle = (Bundle)localObject;
    }
    else
    {
      str = "";
      paramBundle = (Bundle)localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddFriendSecCheck, isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(TextUtils.isEmpty(paramBundle));
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(TextUtils.isEmpty(str));
      QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.equals(AddFriendVerifyFragment.a(this.a), paramString1)) && (this.a.getActivity() != null))
    {
      if (this.a.getActivity().isFinishing()) {
        return;
      }
      if (paramBoolean) {
        if ((!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(AddFriendVerifyFragment.a(this.a))) && (this.a.a == null))
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("onGetAutoInfo remark = ");
            paramString1.append(paramString2);
            QLog.d("IphoneTitleBarFragment", 2, paramString1.toString());
          }
          AddFriendVerifyFragment.b(this.a).setText(paramString2);
        }
      }
    }
    try
    {
      AddFriendVerifyFragment.b(this.a).setSelection(AddFriendVerifyFragment.b(this.a).getText().length());
    }
    catch (IndexOutOfBoundsException paramString1)
    {
      label151:
      break label151;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, "onGetAutoInfo | IndexOutOfBoundsException");
    }
    if (AppSetting.d)
    {
      paramString1 = AddFriendVerifyFragment.a(this.a);
      paramString2 = new StringBuilder();
      paramString2.append(this.a.getResources().getString(2131693375));
      paramString2.append(AddFriendVerifyFragment.b(this.a).getText().toString());
      paramString1.setContentDescription(paramString2.toString());
    }
    AddFriendVerifyFragment.a(this.a, paramInt);
    AddFriendVerifyFragment.c(this.a).setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(AddFriendVerifyFragment.a(this.a), AddFriendVerifyFragment.b(this.a)));
    return;
    AddFriendVerifyFragment.a(this.a, 0);
    AddFriendVerifyFragment.c(this.a).setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(AddFriendVerifyFragment.a(this.a), AddFriendVerifyFragment.b(this.a)));
  }
  
  protected void onGetInfoWithOpenId(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (AddFriendVerifyFragment.b(this.a)) {
      return;
    }
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyFragment.a(this.a))) && (!TextUtils.isEmpty(paramString2)))
    {
      AddFriendVerifyFragment.a(this.a).setText(paramString2);
      if (AppSetting.d) {
        AddFriendVerifyFragment.a(this.a).setContentDescription(paramString2);
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((TextUtils.equals(paramString, AddFriendVerifyFragment.a(this.a))) && (this.a.getActivity() != null))
    {
      if (this.a.getActivity().isFinishing()) {
        return;
      }
      if (paramBoolean1)
      {
        if (paramBundle.getInt("friend_setting") == 3)
        {
          if (paramBoolean2)
          {
            paramString = this.a;
            paramString.a(AddFriendVerifyFragment.a(paramString).getText().toString().trim(), paramBundle.getByteArray("sig"), paramBundle.getString("security_ticket", ""));
            return;
          }
          if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {
            paramString = paramBundle.getString("ErrorString");
          } else {
            paramString = this.a.getString(2131690016);
          }
          QQToast.a(this.a.getActivity(), 1, paramString, 1).b(this.a.getQBaseActivity().getTitleBarHeight());
          return;
        }
        Object localObject;
        if (paramBundle.getInt("resultCode") == 0)
        {
          i = paramBundle.getInt("friend_setting");
          paramBundle.getString("nick_name");
          if (i != 0) {
            if ((i != 1) && (i != 4))
            {
              if (i != 100)
              {
                if (AddFriendVerifyFragment.a(this.a) != null)
                {
                  AddFriendVerifyFragment.a(this.a).cancel();
                  AddFriendVerifyFragment.a(this.a, null);
                }
                QQToast.a(this.a.getActivity(), 2, 2131718219, 0).b(this.a.getQBaseActivity().getTitleBarHeight());
                this.a.a();
              }
            }
            else
            {
              if (AddFriendVerifyFragment.a(this.a) != null)
              {
                AddFriendVerifyFragment.a(this.a).cancel();
                AddFriendVerifyFragment.a(this.a, null);
              }
              QQToast.a(this.a.getActivity(), 2, 2131718219, 0).b(this.a.getQBaseActivity().getTitleBarHeight());
              this.a.a();
              return;
            }
          }
          if (AddFriendVerifyFragment.a(this.a) != null)
          {
            AddFriendVerifyFragment.a(this.a).cancel();
            AddFriendVerifyFragment.a(this.a, null);
          }
          QQToast.a(this.a.getActivity(), 2, 2131689599, 0).b(this.a.getQBaseActivity().getTitleBarHeight());
          if (Utils.b(paramString))
          {
            localObject = AddFriendVerifyFragment.b(this.a).getText().toString();
            String str = AddFriendVerifyFragment.a(this.a).getText().toString();
            paramBundle = (Bundle)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramBundle = str;
            }
            localObject = BaseAIOUtils.a(new Intent(), null);
            ((Intent)localObject).putExtra("uin", paramString);
            ((Intent)localObject).putExtra("uintype", 0);
            ((Intent)localObject).putExtra("uinname", paramBundle);
            paramString = new ActivityURIRequest(this.a.getActivity(), "/base/start/splash");
            paramString.extra().putAll(((Intent)localObject).getExtras());
            paramString.setFlags(((Intent)localObject).getFlags());
            QRoute.startUri(paramString);
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendAddFriendNoticeForBaby(AddFriendVerifyFragment.a(this.a), this.a.getActivity().getIntent());
            return;
          }
          this.a.a();
          return;
        }
        if (AddFriendVerifyFragment.a(this.a) != null)
        {
          AddFriendVerifyFragment.a(this.a).cancel();
          AddFriendVerifyFragment.a(this.a, null);
        }
        int i = paramBundle.getInt("error_code", 0);
        paramString = paramBundle.getString("ErrorString");
        if (i == 167)
        {
          AddFriendVerifyFragment.a(this.a, paramString);
          return;
        }
        if (i == 168)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("add friend response error and ErroString = ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("IphoneTitleBarFragment", 2, ((StringBuilder)localObject).toString());
          }
          AddFriendVerifyFragment.a(this.a, paramBundle.getString("error_tips_wording"), paramBundle.getString("error_tips_cancel_wording"), paramBundle.getString("error_tips_jump_btn_wording"), paramBundle.getString("error_tips_h5_url"), paramBundle.getString("error_tips_mini_app_url"));
        }
      }
      else
      {
        if (AddFriendVerifyFragment.a(this.a) != null)
        {
          AddFriendVerifyFragment.a(this.a).cancel();
          AddFriendVerifyFragment.a(this.a, null);
        }
        paramString = this.a;
        AddFriendVerifyFragment.b(paramString, paramString.getString(2131718220));
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarFragment", 2, "add friend response error and isSuccuss = NO");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.21
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class SubAccountBindActivity$2
  extends SubAccountBindObserver
{
  SubAccountBindActivity$2(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SubAccountBindActivity.onBindSubAccount() isSucc=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      if (paramSubAccountBackProtocData != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SubAccountBindActivity.onBindSubAccount() mainAccount=");
        ((StringBuilder)localObject1).append(paramSubAccountBackProtocData.c);
        ((StringBuilder)localObject1).append(" subAccount=");
        ((StringBuilder)localObject1).append(paramSubAccountBackProtocData.d);
        ((StringBuilder)localObject1).append(" errType=");
        ((StringBuilder)localObject1).append(paramSubAccountBackProtocData.a);
        ((StringBuilder)localObject1).append(" errMsg=");
        ((StringBuilder)localObject1).append(paramSubAccountBackProtocData.b);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
      }
    }
    this.a.hideJuhua();
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = this.a;
      ((SubAccountBindActivity)localObject1).showQQToastSuccess(((SubAccountBindActivity)localObject1).getString(2131916857));
      SubAccountAssistantForward.a(this.a.app);
      this.a.getActivity().setTitle("");
      this.a.finish();
    }
    else
    {
      if (paramSubAccountBackProtocData == null) {
        return;
      }
      int i = paramSubAccountBackProtocData.a;
      if (i != 1011)
      {
        switch (i)
        {
        default: 
          localObject2 = this.a.getString(2131916848);
          localObject1 = localObject2;
          if (paramSubAccountBackProtocData != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramSubAccountBackProtocData.b)) {
              localObject1 = paramSubAccountBackProtocData.b;
            }
          }
          this.a.showQQToast((String)localObject1);
          break;
        case 1004: 
          i = paramSubAccountBackProtocData.i;
          if (i != 1200) {
            if (i != 1218)
            {
              if ((i != 1214) && (i != 1215))
              {
                if (i != 1232)
                {
                  if (i != 1233) {
                    switch (i)
                    {
                    default: 
                      localObject2 = paramSubAccountBackProtocData.b;
                      localObject1 = localObject2;
                      if (TextUtils.isEmpty((CharSequence)localObject2))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
                        }
                        localObject1 = this.a.getString(2131916848);
                      }
                      this.a.showQQToast((String)localObject1);
                      break;
                    case 1242: 
                      localObject2 = paramSubAccountBackProtocData.b;
                      localObject1 = localObject2;
                      if (TextUtils.isEmpty((CharSequence)localObject2)) {
                        localObject1 = this.a.app.getApp().getResources().getString(2131916855);
                      }
                      this.a.showQQToast((String)localObject1);
                      break;
                    case 1241: 
                      localObject2 = paramSubAccountBackProtocData.b;
                      localObject1 = localObject2;
                      if (TextUtils.isEmpty((CharSequence)localObject2)) {
                        localObject1 = this.a.app.getApp().getResources().getString(2131916846);
                      }
                      this.a.showQQToast((String)localObject1);
                      break;
                    case 1240: 
                      localObject2 = paramSubAccountBackProtocData.b;
                      localObject1 = localObject2;
                      if (TextUtils.isEmpty((CharSequence)localObject2)) {
                        localObject1 = this.a.app.getApp().getResources().getString(2131916853);
                      }
                      this.a.showQQToast((String)localObject1);
                      break;
                    }
                  }
                  localObject2 = paramSubAccountBackProtocData.b;
                  localObject1 = localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = this.a.app.getApp().getResources().getString(2131916847);
                  }
                  this.a.showQQToast((String)localObject1);
                  break;
                }
                localObject2 = paramSubAccountBackProtocData.b;
                localObject1 = localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  localObject1 = this.a.app.getApp().getResources().getString(2131916852);
                }
                this.a.showQQToast((String)localObject1);
                break;
              }
            }
            else
            {
              localObject2 = paramSubAccountBackProtocData.b;
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = this.a.app.getApp().getResources().getString(2131915894);
              }
              this.a.showQQToast((String)localObject1);
              break;
            }
          }
          localObject1 = this.a.getString(2131916882);
          localObject2 = this.a.getString(2131916851);
          this.a.showQQCustomDialog((String)localObject1, (String)localObject2, new SubAccountBindActivity.2.1(this, paramSubAccountBackProtocData));
          break;
        case 1003: 
          localObject1 = this.a;
          ((SubAccountBindActivity)localObject1).showQQToast(((SubAccountBindActivity)localObject1).getString(2131916849));
          break;
        case 1002: 
          SubAccountControllUtil.a(this.a.app, this.a);
          break;
        }
      }
      else
      {
        localObject2 = this.a.getString(2131916848);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.b)) {
            localObject1 = paramSubAccountBackProtocData.b;
          }
        }
        this.a.showQQToast((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramSubAccountBackProtocData.d);
        ((Intent)localObject1).putExtra("fromWhere", this.a.fromWhere);
        this.a.startActivity((Intent)localObject1);
      }
    }
    if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onBindSubAccount:");
      if (paramBoolean) {
        localObject1 = "..success";
      } else {
        localObject1 = "...failed..";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" ...errorMsg = ");
      ((StringBuilder)localObject2).append(paramSubAccountBackProtocData.b);
      ((StringBuilder)localObject2).append("...errorType = ");
      ((StringBuilder)localObject2).append(paramSubAccountBackProtocData.a);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.2
 * JD-Core Version:    0.7.0.1
 */
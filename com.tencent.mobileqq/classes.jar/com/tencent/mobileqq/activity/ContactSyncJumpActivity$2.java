package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;

class ContactSyncJumpActivity$2
  extends FriendListObserver
{
  ContactSyncJumpActivity$2(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    Object localObject;
    if (!paramString.equals(ContactSyncJumpActivity.a(this.a)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ContactSyncJumpActivity.b(this.a));
      ((StringBuilder)localObject).append(ContactSyncJumpActivity.c(this.a));
      if (!paramString.equals(((StringBuilder)localObject).toString())) {
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onGetOnlineInfo | isSuccess = ");
      paramString.append(paramBoolean);
      paramString.append(" | resp = ");
      boolean bool2;
      if (paramGetOnlineInfoResp != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramString.append(bool2);
      paramString.append(" | resp.result = ");
      int j = -10000;
      if (paramGetOnlineInfoResp != null) {
        i = paramGetOnlineInfoResp.result;
      } else {
        i = -10000;
      }
      paramString.append(i);
      paramString.append(" | resp.errorCode = ");
      if (paramGetOnlineInfoResp != null) {
        i = paramGetOnlineInfoResp.errorCode;
      } else {
        i = -10000;
      }
      paramString.append(i);
      paramString.append(" | resp.iTermType = ");
      long l = -10000L;
      if (paramGetOnlineInfoResp != null) {
        paramLong = paramGetOnlineInfoResp.iTermType;
      } else {
        paramLong = -10000L;
      }
      paramString.append(paramLong);
      paramString.append(" | resp.status = ");
      if (paramGetOnlineInfoResp != null) {
        paramLong = paramGetOnlineInfoResp.dwStatus;
      } else {
        paramLong = -10000L;
      }
      paramString.append(paramLong);
      paramString.append(" | resp.ability = ");
      paramLong = l;
      if (paramGetOnlineInfoResp != null) {
        paramLong = paramGetOnlineInfoResp.uAbiFlag;
      }
      paramString.append(paramLong);
      paramString.append(" | resp.network = ");
      int i = j;
      if (paramGetOnlineInfoResp != null) {
        i = paramGetOnlineInfoResp.eNetworkType;
      }
      paramString.append(i);
      QLog.d("ContactSync.JumpActivity", 2, paramString.toString());
    }
    if ((paramBoolean) && (paramGetOnlineInfoResp != null))
    {
      if (paramGetOnlineInfoResp.result == 1)
      {
        if ((paramGetOnlineInfoResp.errorCode != 60001) && (paramGetOnlineInfoResp.errorCode != -5535))
        {
          this.a.finish();
          return;
        }
        paramString = String.format(this.a.getResources().getString(2131896677), new Object[] { ContactSyncJumpActivity.d(this.a) });
        ContactSyncJumpActivity.f(this.a).deleteSyncContact(ContactSyncJumpActivity.e(this.a));
        ContactSyncJumpActivity.a(this.a, 1, paramString);
        return;
      }
      if ((this.a.a == null) && (this.a.b != 2)) {
        return;
      }
      String str1 = ContactSyncJumpActivity.f(this.a).getStatusDescription(paramGetOnlineInfoResp);
      String str2 = ContactSyncJumpActivity.f(this.a).getNetworkDescription(paramGetOnlineInfoResp);
      if (!TextUtils.isEmpty(str1)) {
        paramString = str1;
      } else {
        paramString = "";
      }
      localObject = paramString;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = paramString;
        if (!TextUtils.isEmpty(str2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("\n");
          paramString = ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(str2);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      boolean bool1 = TextUtils.isEmpty((CharSequence)localObject) ^ true;
      if (!bool1) {
        localObject = this.a.getResources().getString(2131896684);
      }
      paramString = (TextView)this.a.a.findViewById(2131431912);
      paramString.setText((CharSequence)localObject);
      paramString.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((bool1) && ((paramGetOnlineInfoResp.eNetworkType == 4) || (paramGetOnlineInfoResp.eNetworkType == 5) || (paramGetOnlineInfoResp.eNetworkType == 1)))
      {
        paramString = new Message();
        paramString.what = 1000;
        paramString.arg1 = 4;
        ContactSyncJumpActivity.g(this.a).sendMessage(paramString);
      }
    }
    else if ((this.a.a != null) && (this.a.b == 2))
    {
      paramString = (TextView)this.a.a.findViewById(2131431912);
      paramString.setText(2131896684);
      paramString.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */
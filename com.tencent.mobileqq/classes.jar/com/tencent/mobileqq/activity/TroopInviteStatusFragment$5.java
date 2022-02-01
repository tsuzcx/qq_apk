package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopInviteStatusFragment$5
  extends MessageObserver
{
  TroopInviteStatusFragment$5(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendSystemMsgActionError logStr:");
      localStringBuilder.append(paramString);
      QLog.i("TroopInviteStatusFragment", 2, localStringBuilder.toString());
    }
    if ((this.a.x != null) && (this.a.x.isShowing()))
    {
      this.a.x.dismiss();
      paramString = this.a.l.getResources().getString(2131916977);
      QQToast.makeText(this.a.l, 1, paramString, 0).show(this.a.l.getTitleBarHeight()).show();
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if ((this.a.x != null) && (this.a.x.isShowing())) {
      this.a.x.dismiss();
    }
    if (!paramBoolean)
    {
      paramString1 = this.a.l.getResources().getString(2131916242);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1 = paramString3;
      }
      QQToast.makeText(this.a.l, 1, paramString1, 0).show(this.a.l.getTitleBarHeight());
      return;
    }
    paramString1 = this.a.l.getResources().getString(2131889681);
    QQToast.makeText(this.a.l, 2, paramString1, 0).show(this.a.l.getTitleBarHeight());
    paramString1 = this.a;
    paramString1.C = -1;
    TroopInviteStatusFragment.a(paramString1);
    paramString1 = this.a;
    paramString1.w = true;
    paramString1.u.post(this.a.E);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.5
 * JD-Core Version:    0.7.0.1
 */
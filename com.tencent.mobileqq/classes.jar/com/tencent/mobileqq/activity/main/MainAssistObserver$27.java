package com.tencent.mobileqq.activity.main;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$27
  extends OpenIdObserver
{
  MainAssistObserver$27(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->onGetOpenId, isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(paramOpenID.toString());
      localStringBuilder.append(" mOpenId = ");
      localStringBuilder.append(this.a.m);
      QLog.i("MainAssistObserver", 2, localStringBuilder.toString());
    }
    if (!this.a.a.isFinishing())
    {
      if (this.a.s) {
        return;
      }
      if (this.a.q != null) {
        this.a.q.hide();
      }
      if (this.a.r != null) {
        this.a.r.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MainAssistObserver", 2, "openIdObserver success");
        }
        if ((!TextUtils.isEmpty(this.a.m)) && (!paramOpenID.openID.equals(this.a.m))) {
          this.a.k();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MainAssistObserver", 2, "openIdObserver fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.27
 * JD-Core Version:    0.7.0.1
 */
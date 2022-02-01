package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QRLoginAuthActivity$4
  extends Handler
{
  QRLoginAuthActivity$4(QRLoginAuthActivity paramQRLoginAuthActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if ((this.a.u != null) && (this.a.u.isShowing())) {
          this.a.u.dismiss();
        }
        this.a.j.setVisibility(8);
        this.a.f.setVisibility(0);
        this.a.a(null);
        return;
      }
      i = ((Bundle)localObject).getInt("ret", 1);
      paramMessage = ((Bundle)localObject).getByteArray("errMsg");
      localObject = ((Bundle)localObject).getByteArray("devInfo");
      if (localObject != null) {
        try
        {
          localObject = new JSONObject(new String((byte[])localObject, "UTF-8"));
          this.a.w = ((JSONObject)localObject).optInt("app_type");
          this.a.x = ((JSONObject)localObject).optString("login_tips");
          this.a.y = ((JSONObject)localObject).optLong("sub_appid");
          if (!QLog.isColorLevel()) {
            break label280;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ON CLOSE appType:");
          ((StringBuilder)localObject).append(this.a.w);
          ((StringBuilder)localObject).append(",bannerTips:");
          ((StringBuilder)localObject).append(this.a.x);
          ((StringBuilder)localObject).append(",subappid:");
          ((StringBuilder)localObject).append(this.a.y);
          QLog.d("QRLoginAuthActivity", 2, ((StringBuilder)localObject).toString());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      } else if (QLog.isDevelopLevel()) {
        QLog.d("QRLoginAuthActivity", 4, "ON CLOSE devInfo == null");
      }
      label280:
      if (this.a.u.isShowing()) {
        this.a.u.dismiss();
      }
      if (i == 0)
      {
        this.a.c();
        return;
      }
      this.a.a(new String(paramMessage));
      return;
    }
    this.a.a(localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity.4
 * JD-Core Version:    0.7.0.1
 */
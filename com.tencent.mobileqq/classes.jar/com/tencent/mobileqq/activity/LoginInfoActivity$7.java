package com.tencent.mobileqq.activity;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

class LoginInfoActivity$7
  extends LoginVerifyObserver
{
  LoginInfoActivity$7(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void getFaceStateSuccess(oidb_0x5e1.RspBody paramRspBody)
  {
    LoginInfoActivity.access$1902(this.a, paramRspBody);
    int j = ((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get();
    TextView localTextView = LoginInfoActivity.access$2000(this.a);
    int i;
    if (j == 1)
    {
      paramRspBody = this.a;
      i = 2131692145;
    }
    else
    {
      paramRspBody = this.a;
      i = 2131692151;
    }
    localTextView.setText(paramRspBody.getString(i));
    LoginInfoActivity.access$2100(this.a).setVisibility(4);
    LoginInfoActivity.access$2000(this.a).setVisibility(0);
    if (j == 1) {
      paramRspBody = "1";
    } else {
      paramRspBody = "0";
    }
    ReportController.b(null, "dc00898", "", "", "0X800AA7A", "0X800AA7A", 0, 0, paramRspBody, "", "", "");
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.a, paramString2, 0).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd : ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" request failed  code : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" message : ");
    localStringBuilder.append(paramString2);
    QLog.e("LoginInfoActivity.AccDevSec", 1, localStringBuilder.toString());
    LoginInfoActivity.access$2100(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.7
 * JD-Core Version:    0.7.0.1
 */
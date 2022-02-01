package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LoginInfoActivity$11
  extends FriendListObserver
{
  LoginInfoActivity$11(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    LoginInfoActivity.access$2400(this.a);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult success");
      }
      LoginInfoActivity.access$502(this.a, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = LoginInfoActivity.access$500(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
      }
      LoginInfoActivity.access$600(this.a, LoginInfoActivity.access$500(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult fail isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data is null");
    }
    for (;;)
    {
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131692098), 0).b(this.a.getTitleBarHeight());
      return;
      label288:
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  public void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onKickOutDevFResult isSuccess=" + paramBoolean + " appid=" + paramLong + " result=" + paramInt1 + " index=" + paramInt2);
    }
    LoginInfoActivity.access$2400(this.a);
    if (paramBoolean)
    {
      if ((paramInt1 == 0) && (paramInt2 >= 1) && (paramInt2 < LoginInfoActivity.access$500(this.a).size()))
      {
        LoginInfoActivity.access$500(this.a).remove(paramInt2);
        LoginInfoActivity.access$600(this.a, LoginInfoActivity.access$500(this.a));
      }
      return;
    }
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131694410), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.11
 * JD-Core Version:    0.7.0.1
 */
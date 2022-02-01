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
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    LoginInfoActivity.access$2400(this.a);
    Object localObject;
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
          localObject = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SvcDevLoginInfo.iAppId=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iAppId);
            localStringBuilder.append(" iLoginTime=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iLoginTime);
            localStringBuilder.append(" strLoginLocation=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strLoginLocation);
            localStringBuilder.append(" iLoginPlatform=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iLoginPlatform);
            localStringBuilder.append(" strDeviceName=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strDeviceName);
            localStringBuilder.append(" strDeviceTypeInfo");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strDeviceTypeInfo);
            QLog.d("LoginInfoActivity.AccDevSec", 2, localStringBuilder.toString());
          }
        }
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
      }
      paramSvcRspGetDevLoginInfo = this.a;
      LoginInfoActivity.access$600(paramSvcRspGetDevLoginInfo, LoginInfoActivity.access$500(paramSvcRspGetDevLoginInfo));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetLoginDevResult fail isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("LoginInfoActivity.AccDevSec", 2, ((StringBuilder)localObject).toString());
      if (paramSvcRspGetDevLoginInfo == null)
      {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data is null");
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetLoginDevResult data.iResult=");
        ((StringBuilder)localObject).append(paramSvcRspGetDevLoginInfo.iResult);
        QLog.d("LoginInfoActivity.AccDevSec", 2, ((StringBuilder)localObject).toString());
      }
    }
    QQToast.a(this.a.getActivity(), 1, this.a.getString(2131692017), 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onKickOutDevFResult isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" appid=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" result=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" index=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("LoginInfoActivity.AccDevSec", 2, ((StringBuilder)localObject).toString());
    }
    LoginInfoActivity.access$2400(this.a);
    if (paramBoolean)
    {
      if ((paramInt1 == 0) && (paramInt2 >= 1) && (paramInt2 < LoginInfoActivity.access$500(this.a).size()))
      {
        LoginInfoActivity.access$500(this.a).remove(paramInt2);
        localObject = this.a;
        LoginInfoActivity.access$600((LoginInfoActivity)localObject, LoginInfoActivity.access$500((LoginInfoActivity)localObject));
      }
    }
    else {
      QQToast.a(this.a.getApplicationContext(), this.a.getString(2131694375), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.11
 * JD-Core Version:    0.7.0.1
 */
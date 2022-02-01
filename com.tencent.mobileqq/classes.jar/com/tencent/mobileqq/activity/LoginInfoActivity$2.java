package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

class LoginInfoActivity$2
  extends MqqHandler
{
  LoginInfoActivity$2(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 0;
    Object localObject;
    switch (j)
    {
    default: 
    case 20200313: 
      paramMessage = this.a;
      LoginInfoActivity.access$400(paramMessage, paramMessage.findViewById(1));
      return;
    case 20170211: 
      paramMessage = paramMessage.getData();
      if (paramMessage != null)
      {
        boolean bool = paramMessage.getBoolean("bSafe");
        paramMessage = paramMessage.getString("TipText");
        LoginInfoActivity.access$1100(this.a, bool, paramMessage);
        return;
      }
      break;
    case 20170210: 
      if (LoginInfoActivity.access$700(this.a) == null) {
        return;
      }
      if ((!LoginInfoActivity.access$800(this.a)) && (!LoginInfoActivity.access$900(this.a))) {
        return;
      }
      paramMessage = this.a.getString(2131914195);
      if (LoginInfoActivity.access$1000(this.a) >= 4)
      {
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
        return;
      }
      LoginInfoActivity.access$700(this.a).setVisibility(0);
      localObject = this.a;
      LoginInfoActivity.access$1002((LoginInfoActivity)localObject, (LoginInfoActivity.access$1000((LoginInfoActivity)localObject) + 1) % 4);
      i = LoginInfoActivity.access$1000(this.a);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              LoginInfoActivity.access$700(this.a).setText(paramMessage);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramMessage);
            ((StringBuilder)localObject).append(this.a.getString(2131916177));
            paramMessage = ((StringBuilder)localObject).toString();
            LoginInfoActivity.access$700(this.a).setText(paramMessage);
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramMessage);
          ((StringBuilder)localObject).append(this.a.getString(2131916176));
          paramMessage = ((StringBuilder)localObject).toString();
          LoginInfoActivity.access$700(this.a).setText(paramMessage);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append(this.a.getString(2131916175));
        paramMessage = ((StringBuilder)localObject).toString();
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
      }
      sendEmptyMessageDelayed(20170210, 300L);
      return;
    case 20140331: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage.msg.arg1=");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        QLog.d("LoginInfoActivity.AccDevSec", 2, ((StringBuilder)localObject).toString());
      }
      if (LoginInfoActivity.access$200(this.a) != null)
      {
        LoginInfoActivity.access$200(this.a).DevSetup = paramMessage.arg1;
        paramMessage = this.a;
        LoginInfoActivity.access$300(paramMessage, LoginInfoActivity.access$200(paramMessage));
        return;
      }
      break;
    case 1: 
      if (LoginInfoActivity.access$500(this.a) != null)
      {
        localObject = paramMessage.getData();
        if (localObject != null)
        {
          paramMessage = ((Bundle)localObject).getString("target_name");
          localObject = ((Bundle)localObject).getByteArray("target_desc");
          while (i < LoginInfoActivity.access$500(this.a).size())
          {
            SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)LoginInfoActivity.access$500(this.a).get(i);
            if ((localSvcDevLoginInfo != null) && (Arrays.equals(localSvcDevLoginInfo.stDeviceItemDes.vecItemDes, (byte[])localObject)))
            {
              localSvcDevLoginInfo.strDeviceName = paramMessage;
              break;
            }
            i += 1;
          }
          paramMessage = this.a;
          LoginInfoActivity.access$600(paramMessage, LoginInfoActivity.access$500(paramMessage));
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */
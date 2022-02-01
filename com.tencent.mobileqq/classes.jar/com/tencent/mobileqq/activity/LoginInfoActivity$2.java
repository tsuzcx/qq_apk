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
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("LoginInfoActivity.AccDevSec", 2, "handleMessage.msg.arg1=" + paramMessage.arg1);
              }
            } while (LoginInfoActivity.access$200(this.a) == null);
            LoginInfoActivity.access$200(this.a).DevSetup = paramMessage.arg1;
            LoginInfoActivity.access$300(this.a, LoginInfoActivity.access$200(this.a));
            return;
            LoginInfoActivity.access$400(this.a, this.a.findViewById(1));
            return;
          } while (LoginInfoActivity.access$500(this.a) == null);
          localObject = paramMessage.getData();
        } while (localObject == null);
        paramMessage = ((Bundle)localObject).getString(AuthDevRenameActivity.f);
        Object localObject = ((Bundle)localObject).getByteArray(AuthDevRenameActivity.h);
        int i = 0;
        for (;;)
        {
          if (i < LoginInfoActivity.access$500(this.a).size())
          {
            SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)LoginInfoActivity.access$500(this.a).get(i);
            if ((localSvcDevLoginInfo != null) && (Arrays.equals(localSvcDevLoginInfo.stDeviceItemDes.vecItemDes, (byte[])localObject))) {
              localSvcDevLoginInfo.strDeviceName = paramMessage;
            }
          }
          else
          {
            LoginInfoActivity.access$600(this.a, LoginInfoActivity.access$500(this.a));
            return;
          }
          i += 1;
        }
      } while ((LoginInfoActivity.access$700(this.a) == null) || ((!LoginInfoActivity.access$800(this.a)) && (!LoginInfoActivity.access$900(this.a))));
      paramMessage = this.a.getString(2131717064);
      if (LoginInfoActivity.access$1000(this.a) >= 4)
      {
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
        return;
      }
      LoginInfoActivity.access$700(this.a).setVisibility(0);
      LoginInfoActivity.access$1002(this.a, (LoginInfoActivity.access$1000(this.a) + 1) % 4);
      switch (LoginInfoActivity.access$1000(this.a))
      {
      }
      for (;;)
      {
        sendEmptyMessageDelayed(20170210, 300L);
        return;
        paramMessage = paramMessage + this.a.getString(2131718958);
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
        continue;
        paramMessage = paramMessage + this.a.getString(2131718959);
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
        continue;
        paramMessage = paramMessage + this.a.getString(2131718960);
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
        continue;
        LoginInfoActivity.access$700(this.a).setText(paramMessage);
      }
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    boolean bool = paramMessage.getBoolean("bSafe");
    paramMessage = paramMessage.getString("TipText");
    LoginInfoActivity.access$1100(this.a, bool, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */
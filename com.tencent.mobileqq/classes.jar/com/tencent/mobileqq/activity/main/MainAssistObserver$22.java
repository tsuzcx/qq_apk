package com.tencent.mobileqq.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$22
  extends Handler
{
  MainAssistObserver$22(MainAssistObserver paramMainAssistObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.a != null) && (this.a.a.app != null))
    {
      if (!this.a.a.app.isLogin()) {
        return;
      }
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3)
          {
            if (i != 28929) {
              return;
            }
            paramMessage = paramMessage.getData();
            if (paramMessage == null) {
              return;
            }
            i = paramMessage.getInt("result");
            if ((i != -1) && (i != -2))
            {
              if (this.a.i != null) {
                this.a.i.dismiss();
              }
            }
            else
            {
              String str;
              if (i == -1)
              {
                str = this.a.a.getString(2131916082);
                paramMessage = this.a.a.getString(2131916081);
              }
              else
              {
                str = this.a.a.getString(2131916084);
                paramMessage = this.a.a.getString(2131916083);
              }
              try
              {
                if (this.a.i != null)
                {
                  if (this.a.i.isShowing()) {
                    this.a.i.dismiss();
                  }
                  this.a.i = null;
                }
                this.a.i = DialogUtil.a(this.a.a, 230, str, paramMessage, new MainAssistObserver.22.1(this), null);
                this.a.i.setOnCancelListener(new MainAssistObserver.22.2(this));
                this.a.i.setOnDismissListener(new MainAssistObserver.22.3(this));
                this.a.i.show();
                return;
              }
              catch (Exception paramMessage)
              {
                if (!QLog.isColorLevel()) {
                  return;
                }
              }
              paramMessage.printStackTrace();
            }
          }
          else
          {
            paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
            this.a.a(33, paramMessage);
          }
        }
        else
        {
          paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
          this.a.a(34, paramMessage);
        }
      }
      else
      {
        paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
        this.a.a(35, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.22
 * JD-Core Version:    0.7.0.1
 */
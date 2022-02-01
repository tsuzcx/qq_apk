package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.qphone.base.util.QLog;

class RegisterProxySvcPackHandler$1
  extends Handler
{
  RegisterProxySvcPackHandler$1(RegisterProxySvcPackHandler paramRegisterProxySvcPackHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.b();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(RegisterProxySvcPackHandler.a(this.a)), " ,devStatus:", Integer.valueOf(RegisterProxySvcPackHandler.b(this.a)), " ,clientType:", Long.valueOf(RegisterProxySvcPackHandler.a(this.a)), " ,appid:", Long.valueOf(RegisterProxySvcPackHandler.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(RegisterProxySvcPackHandler.b(this.a)) });
    } while (RegisterProxySvcPackHandler.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    NoDisturbUtil.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackHandler.1
 * JD-Core Version:    0.7.0.1
 */
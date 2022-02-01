package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class SendMultiPictureHelper$1
  extends TransProcessorHandler
{
  SendMultiPictureHelper$1(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (FileMsg)paramMessage.obj;
    if (paramMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "file is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transferListener status: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("SendMultiPictureHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMessage.mUin);
    ((StringBuilder)localObject).append(paramMessage.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    localObject = ((ITransFileController)this.a.b.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject);
    if ((localObject instanceof BaseTransProcessor)) {
      i = ((BaseTransProcessor)localObject).getProgress();
    } else {
      i = 0;
    }
    if (this.a.s) {
      return;
    }
    if (this.a.m)
    {
      if (paramMessage.status == 1005)
      {
        this.a.r = true;
        return;
      }
      if (paramMessage.status == 1003)
      {
        this.a.a();
        return;
      }
      localObject = this.a;
      SendMultiPictureHelper.a((SendMultiPictureHelper)localObject, ((SendMultiPictureHelper)localObject).k, this.a.h, paramMessage.uniseq);
      return;
    }
    if (paramMessage.status == 1003)
    {
      if (this.a.c != null) {
        this.a.c.setMessage(String.format(this.a.o, new Object[] { Integer.valueOf(this.a.e + 1), Integer.valueOf(this.a.f), Integer.valueOf(100) }));
      }
      this.a.a();
      return;
    }
    if (paramMessage.status == 1005)
    {
      this.a.a();
      return;
    }
    if (this.a.c != null) {
      this.a.c.setMessage(String.format(this.a.o, new Object[] { Integer.valueOf(this.a.e + 1), Integer.valueOf(this.a.f), Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.1
 * JD-Core Version:    0.7.0.1
 */
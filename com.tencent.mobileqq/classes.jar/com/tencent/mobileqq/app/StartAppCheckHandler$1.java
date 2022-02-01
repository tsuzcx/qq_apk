package com.tencent.mobileqq.app;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.ProtoServlet;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.NewIntent;

class StartAppCheckHandler$1
  extends Handler
{
  StartAppCheckHandler$1(StartAppCheckHandler paramStartAppCheckHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 3) {
        return;
      }
      new Thread(this.a.k).start();
      return;
    }
    Object localObject;
    if ((this.a.a != null) && (this.a.b != null))
    {
      localObject = new NewIntent(this.a.a.getApplicationContext(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("data", ((StartAppCheckHandler.SendingAPP)paramMessage.obj).g.toByteArray());
      ((NewIntent)localObject).putExtra("cmd", "SecCheckSigSvc.UploadReq");
      ((NewIntent)localObject).setObserver(this.a);
      this.a.b.startServlet((NewIntent)localObject);
    }
    else
    {
      localObject = this.a.createToServiceMsg("SecCheckSigSvc.UploadReq");
      ((ToServiceMsg)localObject).putWupBuffer(((StartAppCheckHandler.SendingAPP)paramMessage.obj).g.toByteArray());
      this.a.sendPbReq((ToServiceMsg)localObject);
    }
    paramMessage = this.a;
    paramMessage.d = false;
    paramMessage.i = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.1
 * JD-Core Version:    0.7.0.1
 */
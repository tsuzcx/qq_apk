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
      new Thread(this.a.jdField_a_of_type_JavaLangRunnable).start();
      return;
    }
    Object localObject;
    if ((this.a.jdField_a_of_type_AndroidAppActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null))
    {
      localObject = new NewIntent(this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("data", ((StartAppCheckHandler.SendingAPP)paramMessage.obj).a.toByteArray());
      ((NewIntent)localObject).putExtra("cmd", "SecCheckSigSvc.UploadReq");
      ((NewIntent)localObject).setObserver(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.startServlet((NewIntent)localObject);
    }
    else
    {
      localObject = this.a.createToServiceMsg("SecCheckSigSvc.UploadReq");
      ((ToServiceMsg)localObject).putWupBuffer(((StartAppCheckHandler.SendingAPP)paramMessage.obj).a.toByteArray());
      this.a.sendPbReq((ToServiceMsg)localObject);
    }
    paramMessage = this.a;
    paramMessage.jdField_a_of_type_Boolean = false;
    paramMessage.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.1
 * JD-Core Version:    0.7.0.1
 */
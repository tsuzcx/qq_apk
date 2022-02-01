import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.NewIntent;

class aodw
  extends Handler
{
  aodw(aodv paramaodv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 1: 
      Object localObject;
      if ((this.a.jdField_a_of_type_AndroidAppActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null))
      {
        localObject = new NewIntent(this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), nta.class);
        ((NewIntent)localObject).putExtra("data", ((aoea)paramMessage.obj).a.toByteArray());
        ((NewIntent)localObject).putExtra("cmd", "SecCheckSigSvc.UploadReq");
        ((NewIntent)localObject).setObserver(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_Aoea = null;
        return;
        localObject = this.a.createToServiceMsg("SecCheckSigSvc.UploadReq");
        ((ToServiceMsg)localObject).putWupBuffer(((aoea)paramMessage.obj).a.toByteArray());
        this.a.sendPbReq((ToServiceMsg)localObject);
      }
    }
    new Thread(this.a.jdField_a_of_type_JavaLangRunnable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodw
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.NewIntent;

class amcx
  extends Handler
{
  amcx(amcw paramamcw, Looper paramLooper)
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
        localObject = new NewIntent(this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), mzx.class);
        ((NewIntent)localObject).putExtra("data", ((amdb)paramMessage.obj).a.toByteArray());
        ((NewIntent)localObject).putExtra("cmd", "SecCheckSigSvc.UploadReq");
        ((NewIntent)localObject).setObserver(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_Amdb = null;
        return;
        localObject = this.a.createToServiceMsg("SecCheckSigSvc.UploadReq");
        ((ToServiceMsg)localObject).putWupBuffer(((amdb)paramMessage.obj).a.toByteArray());
        this.a.sendPbReq((ToServiceMsg)localObject);
      }
    }
    new Thread(this.a.jdField_a_of_type_JavaLangRunnable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcx
 * JD-Core Version:    0.7.0.1
 */
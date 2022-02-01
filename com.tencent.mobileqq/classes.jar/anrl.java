import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anrl
  extends TransProcessorHandler
{
  WeakReference<anrm> a;
  
  public anrl(anrm paramanrm)
  {
    this.a = new WeakReference(paramanrm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg.fileType == 35) {
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramMessage = localFileMsg.bdhExtendInfo;
        if ((this.a != null) && (this.a.get() != null))
        {
          ((anrm)this.a.get()).b(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
      return;
      if ((this.a != null) && (this.a.get() != null))
      {
        ((anrm)this.a.get()).a(localFileMsg.errorCode);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrl
 * JD-Core Version:    0.7.0.1
 */
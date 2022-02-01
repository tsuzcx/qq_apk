import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable;
import cooperation.qqpim.QQPimTipsInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class bmdn
  implements EIPCResultCallback
{
  public bmdn(QQPimGetTipsInfoIPC.GetContactTipsRunnable paramGetContactTipsRunnable) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i(bmdk.a, 2, "QQPimGetTipsInfoIPC.onCallback() " + QQPimGetTipsInfoIPC.a(this.a.this$0).hashCode());
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data.getParcelable(bmdk.n);
      if (paramEIPCResult != null)
      {
        paramEIPCResult = (QQPimTipsInfo)paramEIPCResult;
        this.a.this$0.a = paramEIPCResult;
        QQPimGetTipsInfoIPC.a(this.a.this$0).a(paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdn
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable;
import cooperation.qqpim.QQPimTipsInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class biyj
  implements EIPCResultCallback
{
  public biyj(QQPimGetTipsInfoIPC.GetContactTipsRunnable paramGetContactTipsRunnable) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i(biyg.a, 2, "QQPimGetTipsInfoIPC.onCallback() " + QQPimGetTipsInfoIPC.a(this.a.this$0).hashCode());
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data.getParcelable(biyg.n);
      if (paramEIPCResult != null)
      {
        paramEIPCResult = (QQPimTipsInfo)paramEIPCResult;
        this.a.this$0.a = paramEIPCResult;
        QQPimGetTipsInfoIPC.a(this.a.this$0).a(paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyj
 * JD-Core Version:    0.7.0.1
 */
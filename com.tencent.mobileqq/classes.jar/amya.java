import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.IGetQQPimTipsCallBack;
import cooperation.qqpim.QQPimTipsInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class amya
  implements EIPCResultCallback
{
  amya(amxz paramamxz) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQPimDefineList.a, 2, "QQPimGetTipsInfoIPC.onCallback() " + QQPimGetTipsInfoIPC.a(this.a.a).hashCode());
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data.getParcelable(QQPimDefineList.n);
      if (paramEIPCResult != null)
      {
        paramEIPCResult = (QQPimTipsInfo)paramEIPCResult;
        this.a.a.a = paramEIPCResult;
        QQPimGetTipsInfoIPC.a(this.a.a).a(paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amya
 * JD-Core Version:    0.7.0.1
 */
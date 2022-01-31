import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PicShareToWX.2.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

public final class aunx
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 2, "onCallback, eipcResult.code = " + paramEIPCResult.code);
    }
    ThreadManager.getUIHandler().post(new PicShareToWX.2.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunx
 * JD-Core Version:    0.7.0.1
 */
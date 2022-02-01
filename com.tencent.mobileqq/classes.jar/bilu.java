import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bilu
  implements EIPCResultCallback
{
  bilu(Runnable paramRunnable) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("OpenSdkQIPCClient", 1, "WBQIPCClient installWBSdk onCallback");
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilu
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class artv
  implements EIPCResultCallback
{
  artv(artu paramartu) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (!paramEIPCResult.isSuccess())
    {
      QLog.d("QFlutter.launcher", 1, "install IPC fail");
      artp.b();
      artu.a(this.a, 1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artv
 * JD-Core Version:    0.7.0.1
 */
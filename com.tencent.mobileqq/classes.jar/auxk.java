import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class auxk
  implements EIPCResultCallback
{
  auxk(auxj paramauxj) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (!paramEIPCResult.isSuccess())
    {
      QLog.d("QFlutter.launcher", 1, "install IPC fail");
      auxe.b();
      auxj.a(this.a, 1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxk
 * JD-Core Version:    0.7.0.1
 */
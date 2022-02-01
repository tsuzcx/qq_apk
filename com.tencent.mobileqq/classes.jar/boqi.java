import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class boqi
  implements EIPCResultCallback
{
  boqi(String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("uinname");
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "getTroopMemberName success name = " + paramEIPCResult);
      }
      bpfs.a().a(this.a, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqi
 * JD-Core Version:    0.7.0.1
 */
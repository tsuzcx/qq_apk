import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class axsj
  implements EIPCResultCallback
{
  axsj(axsi paramaxsi) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data.getBoolean("key_monitor"))) {
      axsn.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axsj
 * JD-Core Version:    0.7.0.1
 */
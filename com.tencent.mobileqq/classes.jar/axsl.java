import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class axsl
  implements EIPCResultCallback
{
  axsl(axsk paramaxsk) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data.getBoolean("key_monitor"))) {
      axsp.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axsl
 * JD-Core Version:    0.7.0.1
 */
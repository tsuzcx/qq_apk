import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class azsg
  implements EIPCResultCallback
{
  azsg(azsf paramazsf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data.getBoolean("key_monitor"))) {
      azsk.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsg
 * JD-Core Version:    0.7.0.1
 */
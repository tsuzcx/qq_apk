import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aqpe
  implements EIPCResultCallback
{
  aqpe(aqpd paramaqpd) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpe
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class axvy
  implements EIPCResultCallback
{
  axvy(axvx paramaxvx) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      this.a.a.mContext.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvy
 * JD-Core Version:    0.7.0.1
 */
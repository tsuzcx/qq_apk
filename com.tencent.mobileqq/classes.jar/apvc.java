import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class apvc
  implements EIPCResultCallback
{
  apvc(apvb paramapvb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvc
 * JD-Core Version:    0.7.0.1
 */
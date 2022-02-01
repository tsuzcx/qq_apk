import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class awjr
  implements EIPCResultCallback
{
  awjr(awjq paramawjq) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      boolean bool = paramEIPCResult.data.getBoolean("receive_success");
      this.a.a(0, bool, paramEIPCResult.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjr
 * JD-Core Version:    0.7.0.1
 */
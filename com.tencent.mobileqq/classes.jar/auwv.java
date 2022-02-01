import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class auwv
  implements EIPCResultCallback
{
  auwv(auwu paramauwu) {}
  
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
 * Qualified Name:     auwv
 * JD-Core Version:    0.7.0.1
 */
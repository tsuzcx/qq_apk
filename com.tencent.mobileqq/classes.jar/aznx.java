import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aznx
  implements EIPCResultCallback
{
  aznx(aznw paramaznw) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data.getBoolean("key_monitor"))) {
      azob.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznx
 * JD-Core Version:    0.7.0.1
 */
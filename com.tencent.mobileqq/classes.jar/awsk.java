import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class awsk
  implements EIPCResultCallback
{
  awsk(awsj paramawsj) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (paramEIPCResult.data.getBoolean("key_monitor"))) {
      awso.a().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awsk
 * JD-Core Version:    0.7.0.1
 */
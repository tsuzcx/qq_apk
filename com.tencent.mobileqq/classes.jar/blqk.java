import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class blqk
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      blqj.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqk
 * JD-Core Version:    0.7.0.1
 */
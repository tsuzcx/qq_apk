import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bghj
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      bghi.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghj
 * JD-Core Version:    0.7.0.1
 */
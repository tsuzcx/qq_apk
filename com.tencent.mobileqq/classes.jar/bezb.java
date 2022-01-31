import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bezb
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      beza.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezb
 * JD-Core Version:    0.7.0.1
 */
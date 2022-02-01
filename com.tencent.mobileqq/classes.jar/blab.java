import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class blab
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      blaa.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blab
 * JD-Core Version:    0.7.0.1
 */
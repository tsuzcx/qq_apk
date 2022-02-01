import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bkez
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      bkey.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkez
 * JD-Core Version:    0.7.0.1
 */
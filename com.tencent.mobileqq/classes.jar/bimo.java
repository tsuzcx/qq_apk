import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bimo
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      bimn.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimo
 * JD-Core Version:    0.7.0.1
 */
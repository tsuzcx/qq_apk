import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class bmbe
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      bmbd.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbe
 * JD-Core Version:    0.7.0.1
 */
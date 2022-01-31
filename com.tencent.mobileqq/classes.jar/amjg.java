import android.os.Bundle;
import cooperation.comic.VipComicConfigHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class amjg
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      VipComicConfigHelper.a(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjg
 * JD-Core Version:    0.7.0.1
 */
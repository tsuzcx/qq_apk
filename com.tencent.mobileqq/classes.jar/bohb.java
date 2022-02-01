import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import dov.com.qq.im.capture.control.CaptureAsyncStep.BindTroopMemberClient;

public class bohb
  implements aaea
{
  public bohb(CaptureAsyncStep.BindTroopMemberClient paramBindTroopMemberClient) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nickName");
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      AppInterface localAppInterface = bogd.a();
      if ((localAppInterface instanceof PeakAppInterface)) {
        ((PeakAppInterface)localAppInterface).a(paramBundle);
      }
      this.a.a.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohb
 * JD-Core Version:    0.7.0.1
 */
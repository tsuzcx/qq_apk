import android.os.Bundle;
import com.tencent.mobileqq.app.ConfigObserver;
import cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy;

public class amxp
  extends ConfigObserver
{
  public amxp(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("result", paramInt);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxp
 * JD-Core Version:    0.7.0.1
 */
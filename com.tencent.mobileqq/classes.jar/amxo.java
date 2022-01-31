import android.os.Bundle;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy;

public class amxo
  extends UniPayHandler.UniPayUpdateListener
{
  public amxo(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  public void a()
  {
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 2, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxo
 * JD-Core Version:    0.7.0.1
 */
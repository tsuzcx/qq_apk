import android.os.Bundle;
import com.tencent.mobileqq.app.SignatureObserver;
import cooperation.qqindividuality.ipc.IndividualityRemoteCommandHandler;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy;

public class amxq
  extends SignatureObserver
{
  public amxq(IndividualityRemoteCommandHandler paramIndividualityRemoteCommandHandler) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      paramObject.putInt("which_method", 0);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 4, paramObject);
    }
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      paramObject.putInt("which_method", 1);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 4, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxq
 * JD-Core Version:    0.7.0.1
 */
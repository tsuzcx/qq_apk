import android.os.Bundle;
import cooperation.plugin.PluginUpdater;
import mqq.observer.BusinessObserver;
import tencent.im.plugin.ResourceConfig.GetResourceRespV2;

public class blxh
  implements BusinessObserver
{
  public blxh(PluginUpdater paramPluginUpdater) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      ResourceConfig.GetResourceRespV2 localGetResourceRespV2 = new ResourceConfig.GetResourceRespV2();
      try
      {
        localGetResourceRespV2.mergeFrom(paramBundle);
        this.a.b(true, 128, localGetResourceRespV2);
        return;
      }
      catch (Exception paramBundle)
      {
        this.a.b(false, 128, null);
        return;
      }
    }
    this.a.b(false, 128, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxh
 * JD-Core Version:    0.7.0.1
 */
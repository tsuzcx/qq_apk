import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import cooperation.plugin.PluginUpdater;
import mqq.observer.BusinessObserver;
import tencent.im.plugin.ResourceConfig.GetResourceRespV2;

public class bklz
  implements BusinessObserver
{
  public bklz(PluginUpdater paramPluginUpdater) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("data");
    ResourceConfig.GetResourceRespV2 localGetResourceRespV2 = new ResourceConfig.GetResourceRespV2();
    try
    {
      localGetResourceRespV2.mergeFrom(paramBundle);
      this.a.b(paramBoolean, 128, localGetResourceRespV2);
      return;
    }
    catch (Exception paramBundle) {}catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklz
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.patch.QZonePatchRequest;
import cooperation.qzone.plugin.PluginIntent.OnResultListner;
import cooperation.qzone.plugin.QZonePluginUpdater;
import cooperation.qzone.plugin.QZonePluginUpdater.OnUpdateListner;

public class amhw
  implements PluginIntent.OnResultListner
{
  public amhw(QZonePluginUpdater paramQZonePluginUpdater) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZonePatchRequest.a(paramFromServiceMsg.getWupBuffer());
      QZonePluginUpdater.a(this.a, paramIntent);
      QZonePluginUpdater.a(this.a, paramIntent, null);
      QzoneModuleConfigManager.a().a(paramIntent);
      if (this.a.a != null) {
        this.a.a.a(true);
      }
    }
    do
    {
      return;
      QZonePluginUpdater.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhw
 * JD-Core Version:    0.7.0.1
 */
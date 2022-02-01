import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class blvw
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isQzoneInstalled: ");
    if (paramPluginManagerClient != null) {}
    for (Object localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));; localObject = "null")
    {
      QZLog.i("QZoneApiProxy", localObject);
      if (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) {
        blvu.b = true;
      }
      blvu.a(new WeakReference(paramPluginManagerClient));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvw
 * JD-Core Version:    0.7.0.1
 */
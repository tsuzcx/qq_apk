import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class bhbi
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  bhbi(long paramLong) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onPluginManagerLoaded: ");
    if (paramPluginManagerClient != null) {}
    for (Object localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));; localObject = "null")
    {
      QZLog.i("QZoneApiProxy", localObject + " cost " + (System.nanoTime() - this.a));
      bhbh.a(new WeakReference(paramPluginManagerClient));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbi
 * JD-Core Version:    0.7.0.1
 */
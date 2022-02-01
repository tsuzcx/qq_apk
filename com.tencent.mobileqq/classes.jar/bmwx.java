import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class bmwx
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  bmwx(long paramLong, bmwz parambmwz) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onPluginManagerLoaded: ");
    Object localObject;
    if (paramPluginManagerClient != null)
    {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
      QZLog.i("QZoneApiProxy", localObject + " cost " + (System.nanoTime() - this.jdField_a_of_type_Long));
      if (paramPluginManagerClient != null)
      {
        if (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) {
          bmww.b = true;
        }
        bmww.a(new WeakReference(paramPluginManagerClient));
      }
      if (this.jdField_a_of_type_Bmwz != null)
      {
        localObject = this.jdField_a_of_type_Bmwz;
        if ((paramPluginManagerClient == null) || (!paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) || (!bmww.a(BaseApplicationImpl.getApplication()))) {
          break label137;
        }
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      ((bmwz)localObject).onLoadOver(bool);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwx
 * JD-Core Version:    0.7.0.1
 */
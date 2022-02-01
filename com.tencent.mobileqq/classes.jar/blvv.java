import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class blvv
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  blvv(long paramLong, blvx paramblvx) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onPluginManagerLoaded: ");
    Object localObject;
    if (paramPluginManagerClient != null)
    {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
      QZLog.i("QZoneApiProxy", localObject + " cost " + (System.nanoTime() - this.jdField_a_of_type_Long));
      if (paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) {
        blvu.b = true;
      }
      blvu.a(new WeakReference(paramPluginManagerClient));
      if (this.jdField_a_of_type_Blvx != null)
      {
        localObject = this.jdField_a_of_type_Blvx;
        if ((paramPluginManagerClient == null) || (!paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk")) || (!blvu.a(BaseApplicationImpl.getApplication()))) {
          break label133;
        }
      }
    }
    label133:
    for (boolean bool = true;; bool = false)
    {
      ((blvx)localObject).onLoadOver(bool);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvv
 * JD-Core Version:    0.7.0.1
 */
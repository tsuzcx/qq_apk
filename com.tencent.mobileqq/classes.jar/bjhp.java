import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import cooperation.qzone.util.QZLog;
import mqq.util.WeakReference;

final class bjhp
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  bjhp(long paramLong, bjhq parambjhq) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onPluginManagerLoaded: ");
    Object localObject;
    if (paramPluginManagerClient != null)
    {
      localObject = Boolean.valueOf(paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"));
      QZLog.i("QZoneApiProxy", localObject + " cost " + (System.nanoTime() - this.jdField_a_of_type_Long));
      bjho.a(new WeakReference(paramPluginManagerClient));
      if (this.jdField_a_of_type_Bjhq != null)
      {
        localObject = this.jdField_a_of_type_Bjhq;
        if ((paramPluginManagerClient == null) || (!paramPluginManagerClient.isPluginInstalled("qzone_plugin.apk"))) {
          break label111;
        }
      }
    }
    label111:
    for (boolean bool = true;; bool = false)
    {
      ((bjhq)localObject).a(bool);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhp
 * JD-Core Version:    0.7.0.1
 */
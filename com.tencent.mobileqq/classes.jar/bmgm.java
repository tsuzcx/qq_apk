import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class bmgm
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    bmgk.a(paramPluginManagerClient);
    bmgk.a(null);
    while (!bmgk.a().isEmpty())
    {
      paramPluginManagerClient = (bmgu)bmgk.a().poll();
      if (paramPluginManagerClient != null) {
        bmgk.b(paramPluginManagerClient.jdField_a_of_type_AndroidContentContext, paramPluginManagerClient.jdField_a_of_type_Bmgt, paramPluginManagerClient.jdField_a_of_type_Bmgr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgm
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class bglj
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    bglh.a(paramPluginManagerClient);
    bglh.a(null);
    while (!bglh.a().isEmpty())
    {
      paramPluginManagerClient = (bglr)bglh.a().poll();
      if (paramPluginManagerClient != null) {
        bglh.b(paramPluginManagerClient.jdField_a_of_type_AndroidContentContext, paramPluginManagerClient.jdField_a_of_type_Bglq, paramPluginManagerClient.jdField_a_of_type_Bglo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglj
 * JD-Core Version:    0.7.0.1
 */
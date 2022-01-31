import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class bimi
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    bimg.a(paramPluginManagerClient);
    bimg.a(null);
    while (!bimg.a().isEmpty())
    {
      paramPluginManagerClient = (bimq)bimg.a().poll();
      if (paramPluginManagerClient != null) {
        bimg.b(paramPluginManagerClient.jdField_a_of_type_AndroidContentContext, paramPluginManagerClient.jdField_a_of_type_Bimp, paramPluginManagerClient.jdField_a_of_type_Bimn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimi
 * JD-Core Version:    0.7.0.1
 */
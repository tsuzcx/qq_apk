import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class blwa
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    blvy.a(paramPluginManagerClient);
    blvy.a(null);
    while (!blvy.a().isEmpty())
    {
      paramPluginManagerClient = (blwi)blvy.a().poll();
      if (paramPluginManagerClient != null) {
        blvy.b(paramPluginManagerClient.jdField_a_of_type_AndroidContentContext, paramPluginManagerClient.jdField_a_of_type_Blwh, paramPluginManagerClient.jdField_a_of_type_Blwf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwa
 * JD-Core Version:    0.7.0.1
 */
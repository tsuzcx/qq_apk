import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class bfdb
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    bfcz.a(paramPluginManagerClient);
    bfcz.a(null);
    while (!bfcz.a().isEmpty())
    {
      paramPluginManagerClient = (bfdj)bfcz.a().poll();
      if (paramPluginManagerClient != null) {
        bfcz.b(paramPluginManagerClient.jdField_a_of_type_AndroidContentContext, paramPluginManagerClient.jdField_a_of_type_Bfdi, paramPluginManagerClient.jdField_a_of_type_Bfdg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfdb
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class amlz
  implements IPluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IPluginManager.d(paramContext, paramPluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlz
 * JD-Core Version:    0.7.0.1
 */
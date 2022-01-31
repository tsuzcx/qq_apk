import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.IQZonePluginManager.OnPluginReadyListener;
import cooperation.qzone.plugin.IQZonePluginManager.PluginParams;

public final class anei
  implements IQZonePluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean)
    {
      IQZonePluginManager.b((Activity)paramContext, paramPluginParams);
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), "加载失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anei
 * JD-Core Version:    0.7.0.1
 */
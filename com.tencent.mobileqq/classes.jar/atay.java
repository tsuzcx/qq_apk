import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.qphone.base.util.QLog;

public final class atay
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginLauncher", 2, "onReceive ACTION_FORCE_UPDATE");
    }
    if (TextUtils.equals(paramIntent.getAction(), "action_iv_plugin_update"))
    {
      paramIntent = (InstalledPlugin)paramIntent.getSerializableExtra("plugin");
      if (paramIntent != null)
      {
        boolean bool = atbb.a(paramContext, paramIntent).a();
        if (QLog.isColorLevel()) {
          QLog.d("HuayangPluginLauncher", 2, "onReceive isCalled:" + bool);
        }
        if (!bool)
        {
          com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity.a = 0L;
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atay
 * JD-Core Version:    0.7.0.1
 */
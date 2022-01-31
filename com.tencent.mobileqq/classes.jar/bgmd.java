import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.pluginbridge.BridgePluginInstallActivity;

public class bgmd
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("BridgeHelper", 2, "action:" + paramIntent);
    }
    if (("bridge.plugin.onresume.broadcast".equals(paramIntent)) || ("bridge.onresume.broadcast".equals(paramIntent))) {}
    try
    {
      paramContext.unregisterReceiver(BridgeHelper.a());
      BridgeHelper.a(null);
      if (BridgeHelper.a() != null)
      {
        BridgeHelper.a().dismiss();
        BridgeHelper.a(null);
      }
      if ((paramContext instanceof BridgePluginInstallActivity))
      {
        if (QLog.isColorLevel()) {
          QLog.w("BridgeHelper", 2, "Activity finish!");
        }
        ((BridgePluginInstallActivity)paramContext).finish();
      }
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmd
 * JD-Core Version:    0.7.0.1
 */
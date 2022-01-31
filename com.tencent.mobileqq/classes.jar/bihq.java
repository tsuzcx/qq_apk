import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class bihq
  extends BroadcastReceiver
{
  private bihq(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BuscardPluginInstallActivity", 4, "BuscardPluginOnResumeReceiver->onReceive, intent:" + paramIntent);
    }
    if ((paramIntent == null) || (!"bridge.plugin.onresume.broadcast".equals(paramIntent.getAction()))) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bihq
 * JD-Core Version:    0.7.0.1
 */
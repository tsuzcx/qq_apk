import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qzone.webviewplugin.QZoneFeedActionJsPlugin;

public class anbl
  extends BroadcastReceiver
{
  public anbl(QZoneFeedActionJsPlugin paramQZoneFeedActionJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QZoneFeedActionJsPlugin.a(this.a, paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbl
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class bexk
  extends BroadcastReceiver
{
  public bexk(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equals("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete"))) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexk
 * JD-Core Version:    0.7.0.1
 */
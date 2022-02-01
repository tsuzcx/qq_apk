import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class bbpc
  extends BroadcastReceiver
{
  public bbpc(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryActivity", 4, "receive videochat in aiogallery");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpc
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.gallery.view.AIOGalleryActivity;

public class aqoc
  extends BroadcastReceiver
{
  public aqoc(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      aqmd.a().a().a("AIOGalleryActivity", 4, "receive videochat in aiogallery");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqoc
 * JD-Core Version:    0.7.0.1
 */
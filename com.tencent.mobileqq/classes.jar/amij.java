import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class amij
  extends BroadcastReceiver
{
  public amij(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "ACTION_SCREEN_OFF == >>");
      }
      this.a.d();
    }
    while (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "ACTION_START_VIDEO_CHAT == >>");
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amij
 * JD-Core Version:    0.7.0.1
 */
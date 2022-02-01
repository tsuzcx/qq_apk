import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class brcs
  extends BroadcastReceiver
{
  public brcs(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "ACTION_SCREEN_OFF == >>");
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     brcs
 * JD-Core Version:    0.7.0.1
 */
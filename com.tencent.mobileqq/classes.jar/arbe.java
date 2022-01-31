import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class arbe
  extends BroadcastReceiver
{
  public arbe(FileBrowserActivity paramFileBrowserActivity) {}
  
  @TargetApi(5)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbe
 * JD-Core Version:    0.7.0.1
 */
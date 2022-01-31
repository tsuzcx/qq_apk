import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.1;

public class apdd
  extends BroadcastReceiver
{
  public apdd(UniformDownloadMgr.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getBundleExtra("param");
    paramIntent = paramIntent.getStringExtra("url");
    apdc.a().a(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apdd
 * JD-Core Version:    0.7.0.1
 */
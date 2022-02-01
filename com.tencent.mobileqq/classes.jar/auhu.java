import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.1;

public class auhu
  extends BroadcastReceiver
{
  public auhu(UniformDownloadMgr.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getBundleExtra("param");
    paramIntent = paramIntent.getStringExtra("url");
    auht.a().a(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhu
 * JD-Core Version:    0.7.0.1
 */
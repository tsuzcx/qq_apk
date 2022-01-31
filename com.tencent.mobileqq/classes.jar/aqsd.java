import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1;

public class aqsd
  extends BroadcastReceiver
{
  public aqsd(FileManagerDataCenter.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")))
    {
      paramContext = paramIntent.getBundleExtra("extraBundle");
      aqsc.a(this.a.this$0, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsd
 * JD-Core Version:    0.7.0.1
 */
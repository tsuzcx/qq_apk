import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.3.1;

public class bkzb
  extends BroadcastReceiver
{
  public bkzb(QzoneConfig paramQzoneConfig) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ThreadManagerV2.excute(new QzoneConfig.3.1(this, paramIntent), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzb
 * JD-Core Version:    0.7.0.1
 */
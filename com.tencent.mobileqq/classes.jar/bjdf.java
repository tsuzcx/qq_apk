import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MediaChooseJsProxyImpl.1.1;

public class bjdf
  extends BroadcastReceiver
{
  bjdf(bjde parambjde) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!bjde.a(this.a)) {}
    do
    {
      return;
      bjde.a(this.a, false);
      paramContext = paramIntent.getAction();
      QLog.d("MediaChooseJsProxyImpl", 2, "mAvatarReceiver.onReceive action=" + paramContext);
    } while (!"get_media_info".equals(paramContext));
    if (QLog.isColorLevel()) {
      QLog.d("MediaChooseJsProxyImpl", 2, new Object[] { paramIntent });
    }
    ThreadManagerV2.executeOnSubThread(new MediaChooseJsProxyImpl.1.1(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdf
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class avcp
  extends BroadcastReceiver
{
  avcp(avcj paramavcj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((avcj.a(this.a) == null) || (avcj.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = auzl.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      avcj.a(this.a, avcj.a(this.a).getIntent().getExtras());
      avcj.a(avcj.a(this.a), avcj.a(this.a), avcj.a(this.a));
      return;
    }
    avcj.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcp
 * JD-Core Version:    0.7.0.1
 */
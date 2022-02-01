import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aukp
  extends BroadcastReceiver
{
  aukp(aukj paramaukj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aukj.a(this.a) == null) || (aukj.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = auhn.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      aukj.a(this.a, aukj.a(this.a).getIntent().getExtras());
      return;
    }
    aukj.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukp
 * JD-Core Version:    0.7.0.1
 */
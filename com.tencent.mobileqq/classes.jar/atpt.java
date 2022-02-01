import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class atpt
  extends BroadcastReceiver
{
  atpt(atpn paramatpn) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((atpn.a(this.a) == null) || (atpn.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = atmp.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      atpn.a(this.a, atpn.a(this.a).getIntent().getExtras());
      atpn.a(atpn.a(this.a), atpn.a(this.a), atpn.a(this.a));
      return;
    }
    atpn.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpt
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class auuo
  extends BroadcastReceiver
{
  auuo(auui paramauui) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((auui.a(this.a) == null) || (auui.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = aurk.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      auui.a(this.a, auui.a(this.a).getIntent().getExtras());
      auui.a(auui.a(this.a), auui.a(this.a), auui.a(this.a));
      return;
    }
    auui.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuo
 * JD-Core Version:    0.7.0.1
 */
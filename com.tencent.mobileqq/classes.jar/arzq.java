import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class arzq
  extends BroadcastReceiver
{
  arzq(arzk paramarzk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((arzk.a(this.a) == null) || (arzk.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = arwa.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      arzk.a(this.a, arzk.a(this.a).getIntent().getExtras());
      return;
    }
    arzk.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzq
 * JD-Core Version:    0.7.0.1
 */
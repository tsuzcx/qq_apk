import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aqgb
  extends BroadcastReceiver
{
  aqgb(aqfv paramaqfv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aqfv.a(this.a) == null) || (aqfv.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = aqcs.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      aqfv.a(this.a, aqfv.a(this.a).getIntent().getExtras());
      return;
    }
    aqfv.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgb
 * JD-Core Version:    0.7.0.1
 */
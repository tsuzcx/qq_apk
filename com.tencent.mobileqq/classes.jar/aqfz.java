import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aqfz
  extends BroadcastReceiver
{
  aqfz(aqft paramaqft) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aqft.a(this.a) == null) || (aqft.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = aqcq.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      aqft.a(this.a, aqft.a(this.a).getIntent().getExtras());
      return;
    }
    aqft.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfz
 * JD-Core Version:    0.7.0.1
 */
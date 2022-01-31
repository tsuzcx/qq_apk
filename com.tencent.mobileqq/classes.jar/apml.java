import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class apml
  extends BroadcastReceiver
{
  apml(apmf paramapmf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((apmf.a(this.a) == null) || (apmf.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = apjd.a(paramIntent.getStringExtra("key_share_image_by_server"));
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      apmf.a(this.a, apmf.a(this.a).getIntent().getExtras());
      return;
    }
    apmf.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apml
 * JD-Core Version:    0.7.0.1
 */
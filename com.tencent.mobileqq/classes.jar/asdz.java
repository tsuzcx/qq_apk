import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class asdz
  extends BroadcastReceiver
{
  asdz(asdt paramasdt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((asdt.a(this.a) == null) || (asdt.a(this.a).isFinishing())) {}
    do
    {
      return;
      paramContext = asaj.a(paramIntent.getStringExtra("key_share_image_by_server"));
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "initBroadcastReceiver errorMsg=", paramContext });
    } while (paramContext == null);
    if (TextUtils.isEmpty(paramContext))
    {
      asdt.a(this.a, asdt.a(this.a).getIntent().getExtras());
      return;
    }
    asdt.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdz
 * JD-Core Version:    0.7.0.1
 */
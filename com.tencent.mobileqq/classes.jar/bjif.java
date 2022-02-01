import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class bjif
  extends BroadcastReceiver
{
  public bjif(WXShareHelper paramWXShareHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WXShareHelper.b(this.a) != null) {
      WXShareHelper.b(this.a).handleIntent(paramIntent, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjif
 * JD-Core Version:    0.7.0.1
 */
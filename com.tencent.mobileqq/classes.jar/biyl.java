import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class biyl
  extends BroadcastReceiver
{
  public biyl(WXShareHelper paramWXShareHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WXShareHelper.a(this.a) != null) {
      WXShareHelper.a(this.a).handleIntent(paramIntent, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyl
 * JD-Core Version:    0.7.0.1
 */
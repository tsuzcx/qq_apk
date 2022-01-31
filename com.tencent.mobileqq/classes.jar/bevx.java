import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class bevx
  extends BroadcastReceiver
{
  public bevx(WXShareHelper paramWXShareHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WXShareHelper.a(this.a) != null) {
      WXShareHelper.a(this.a).handleIntent(paramIntent, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevx
 * JD-Core Version:    0.7.0.1
 */
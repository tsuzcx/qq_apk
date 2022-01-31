import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

class bgss
  implements DialogInterface.OnClickListener
{
  bgss(bgsr parambgsr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if ((this.a.a() instanceof Activity))
    {
      paramDialogInterface = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      Activity localActivity = (Activity)this.a.a();
      Intent localIntent = new Intent();
      localIntent.putExtra("url", this.a.a().url.get());
      paramDialogInterface.startBrowserActivity(localActivity, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgss
 * JD-Core Version:    0.7.0.1
 */
import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

class bgxd
  implements DialogInterface.OnClickListener
{
  bgxd(bgxb parambgxb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((this.a.a() instanceof Activity)) && (this.a.a() != null))
    {
      paramDialogInterface = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      Activity localActivity = (Activity)this.a.a();
      Intent localIntent = new Intent();
      localIntent.putExtra("url", this.a.a().url.get());
      paramDialogInterface.startBrowserActivity(localActivity, localIntent);
    }
    this.a.a("identi_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxd
 * JD-Core Version:    0.7.0.1
 */
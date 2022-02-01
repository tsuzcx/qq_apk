import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;

public class bjtz
  implements DialogInterface.OnClickListener
{
  public bjtz(TroopAlbumPlugin.2.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    Intent localIntent = new Intent();
    String str = bjtv.f(this.a.a.a).getAttachedActivity().getResources().getString(2131716322);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", "jhan_plxz");
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.a(bjtv.g(this.a.a.a).getAttachedActivity(), paramDialogInterface, localIntent, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtz
 * JD-Core Version:    0.7.0.1
 */
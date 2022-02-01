import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1;

public class bnob
  implements DialogInterface.OnClickListener
{
  public bnob(QzoneQunFeedJsPlugin.2.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.a.a.a.mRuntime.a().getAccount();
    Intent localIntent = new Intent();
    String str = this.a.a.a.a.mRuntime.a().getResources().getString(2131716436);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", "jhan_plxz");
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.a(this.a.a.a.a.mRuntime.a(), paramDialogInterface, localIntent, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnob
 * JD-Core Version:    0.7.0.1
 */
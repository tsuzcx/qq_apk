import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.4;

public class bfbe
  implements DialogInterface.OnClickListener
{
  public bfbe(AppBrandPageContainer.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bfgv.a().edit().putBoolean(AppBrandPageContainer.a(this.a.this$0).a().appId + "_debug", this.a.a);
    this.a.this$0.a(this.a.this$0);
    bfgs.a(AppBrandPageContainer.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbe
 * JD-Core Version:    0.7.0.1
 */
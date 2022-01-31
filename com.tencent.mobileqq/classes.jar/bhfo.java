import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.4;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;

public class bhfo
  implements DialogInterface.OnClickListener
{
  public bhfo(AppBrandPageContainer.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StorageUtil.getPreference().edit().putBoolean(AppBrandPageContainer.a(this.a.this$0).a().appId + "_debug", this.a.a);
    this.a.this$0.a(this.a.this$0);
    ProcessUtil.exitProcess(AppBrandPageContainer.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfo
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareState;

final class bhmp
  implements bgnl
{
  bhmp(ShareState paramShareState, MiniAppProxy paramMiniAppProxy, bglv parambglv) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (9527 != paramInt1) {
      return false;
    }
    bhmo.a(false);
    bgnk.a().b(this);
    paramInt1 = paramIntent.getIntExtra("more_item_id", -1);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareState.isShareInMiniProcess = paramIntent.getBooleanExtra("share_in_mini_process", false);
    paramIntent = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getMoreItemSelectedListener();
    if (paramIntent != null) {
      paramIntent.onMoreItemSelected(new bglw(this.jdField_a_of_type_Bglv), paramInt1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmp
 * JD-Core Version:    0.7.0.1
 */
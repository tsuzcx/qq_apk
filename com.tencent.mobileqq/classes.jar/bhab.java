import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import cooperation.vip.pb.TianShuAccess.AdItem;

public final class bhab
  implements DialogInterface.OnShowListener
{
  public bhab(TianShuAccess.AdItem paramAdItem, String paramString) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    StorageUtil.getPreference().edit().putLong("pref_key_banner_ad_popup_last_show_time_millis", System.currentTimeMillis()).putInt("pref_key_banner_ad_current_show_times", 1).apply();
    MiniGameAdBannerPopup.a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, this.jdField_a_of_type_JavaLangString, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhab
 * JD-Core Version:    0.7.0.1
 */
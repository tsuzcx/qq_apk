import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup;
import cooperation.vip.pb.TianShuAccess.AdItem;

public final class bexe
  implements View.OnClickListener
{
  public bexe(Dialog paramDialog, Context paramContext, String paramString1, MiniAppProxy paramMiniAppProxy, TianShuAccess.AdItem paramAdItem, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (!bfgx.a(this.jdField_a_of_type_JavaLangString)) {
        break label69;
      }
      behj.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2094, null);
    }
    for (;;)
    {
      MiniGameAdBannerPopup.a(this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem, this.b, 102);
      return;
      label69:
      paramView = new Intent();
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.startBrowserActivity((Activity)this.jdField_a_of_type_AndroidContentContext, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexe
 * JD-Core Version:    0.7.0.1
 */
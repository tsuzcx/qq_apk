import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;

class aprc
  implements View.OnClickListener
{
  aprc(aprb paramaprb, MISC.StAppPlayingInfo paramStAppPlayingInfo) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StAppPlayingInfo.appMetaInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StAppPlayingInfo.appMetaInfo.appId.get())) && (paramView != null)) {
      MiniAppLauncher.launchMiniAppById(paramView.getContext(), this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StAppPlayingInfo.appMetaInfo.appId.get(), null, null, null, null, aprb.a(this.jdField_a_of_type_Aprb));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aprc
 * JD-Core Version:    0.7.0.1
 */
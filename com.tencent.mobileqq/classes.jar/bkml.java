import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.superplayer.api.SuperPlayerFactory;

class bkml
  implements SDKInitListener
{
  bkml(bkmk parambkmk, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "superPlayer onSDKInited :" + paramBoolean);
    if (paramBoolean)
    {
      bkmk.a(this.jdField_a_of_type_Bkmk, SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext()));
      bkmk.a(this.jdField_a_of_type_Bkmk, SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, bkmk.a(this.jdField_a_of_type_Bkmk)));
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnVideoViewInitListener != null) && ((bkmk.a(this.jdField_a_of_type_Bkmk) instanceof View))) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnVideoViewInitListener.onVideoViewInit((View)bkmk.a(this.jdField_a_of_type_Bkmk));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkml
 * JD-Core Version:    0.7.0.1
 */
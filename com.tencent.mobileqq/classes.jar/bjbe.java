import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.superplayer.api.SuperPlayerFactory;

class bjbe
  implements SDKInitListener
{
  bjbe(bjbd parambjbd, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "superPlayer onSDKInited :" + paramBoolean);
    if (paramBoolean)
    {
      bjbd.a(this.jdField_a_of_type_Bjbd, SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext()));
      bjbd.a(this.jdField_a_of_type_Bjbd, SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, bjbd.a(this.jdField_a_of_type_Bjbd)));
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnVideoViewInitListener != null) && ((bjbd.a(this.jdField_a_of_type_Bjbd) instanceof View))) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnVideoViewInitListener.onVideoViewInit((View)bjbd.a(this.jdField_a_of_type_Bjbd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbe
 * JD-Core Version:    0.7.0.1
 */
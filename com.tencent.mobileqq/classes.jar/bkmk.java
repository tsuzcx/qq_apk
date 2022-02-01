import android.content.Context;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class bkmk
  extends AbsVideoPlayer
{
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      try
      {
        paramInt1 = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.captureImageInTime(-1L, paramInt1, paramInt2);
        return paramInt1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    return 0;
  }
  
  public void createVideoView(Context paramContext, AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener)
  {
    if (bapt.a())
    {
      QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "createVideoView: superPlayer sdk is ready");
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 102, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      if ((paramOnVideoViewInitListener != null) && ((this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView instanceof View))) {
        paramOnVideoViewInitListener.onVideoViewInit((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      }
      return;
    }
    QLog.e("MiniAppVideoPlayer_SuperPlayer", 1, "superPlayer sdk no ready when doing createVideoView");
    bapt.a(BaseApplicationImpl.getApplication(), new bkml(this, paramOnVideoViewInitListener));
  }
  
  public long getCurrentPostion()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public int getVideoHeight()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying();
    }
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 104, MD5Utils.toMD5(paramString));
      SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
      localSuperPlayerOption.enableCodecReuse = false;
      localSuperPlayerOption.isPrePlay = false;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(paramContext, paramString, paramLong);
    }
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(new bkmr(this, paramOnCaptureImageListener));
    }
  }
  
  public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(new bkmn(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener) {}
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(new bkmo(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(new bkmp(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(new bkmq(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(new bkmm(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(paramBoolean);
      return true;
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
    }
  }
  
  public void startPlayDanmu()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
    }
  }
  
  public void stopPlayDanmu()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmk
 * JD-Core Version:    0.7.0.1
 */
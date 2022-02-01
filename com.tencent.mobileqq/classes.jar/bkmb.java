import android.content.Context;
import android.view.View;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.List;

public class bkmb
  extends AbsVideoPlayer
{
  private static final String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  
  public int captureImageInTime(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      try
      {
        paramInt1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.captureImageInTime(paramInt1, paramInt2);
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
    Object localObject;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      localObject = new OskPlayerConfig();
      ((OskPlayerConfig)localObject).setEnableHLSCache(true);
      ((OskPlayerConfig)localObject).setDebugVersion(true);
      ((OskPlayerConfig)localObject).setLogger(new DefaultLogger());
      ((OskPlayerConfig)localObject).setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), (OskPlayerConfig)localObject);
      localObject = PlayerConfig.g().getContentTypeList();
      if (localObject == null) {
        break label165;
      }
    }
    label165:
    IVideoViewBase localIVideoViewBase;
    do
    {
      TVK_IProxyFactory localTVK_IProxyFactory;
      do
      {
        for (;;)
        {
          try
          {
            ((List)localObject).addAll(Arrays.asList(jdField_a_of_type_JavaLangString.split("|")));
            PlayerConfig.g().setContentTypeList((List)localObject);
            TVK_SDKMgr.setDebugEnable(true);
            TVK_SDKMgr.setOnLogListener(new bkmc(this));
            TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
            if (TVK_SDKMgr.isInstalled(paramContext)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AbsVideoPlayerImpl", 2, "TVK_SDK is not installed");
            }
            return;
          }
          catch (Exception localException)
          {
            QLog.e("AbsVideoPlayerImpl", 2, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + localException);
            continue;
          }
          QLog.e("AbsVideoPlayerImpl", 2, "getContentTypeList null");
        }
        localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      } while (localTVK_IProxyFactory == null);
      localIVideoViewBase = localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(paramContext, localIVideoViewBase);
    } while (paramOnVideoViewInitListener == null);
    paramOnVideoViewInitListener.onVideoViewInit((View)localIVideoViewBase);
  }
  
  public long getCurrentPostion()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute();
    }
    return false;
  }
  
  public int getVideoHeight()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void openMediaPlayerByUrl(Context paramContext, String paramString, long paramLong)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
        break label154;
      }
      if (!paramString.toLowerCase().contains(".m3u8")) {
        break label85;
      }
      localTVK_PlayerVideoInfo.setPlayType(1);
      if (!paramString.startsWith("https")) {
        break label160;
      }
      paramString = OskPlayerCore.getInstance().getUrl(paramString);
    }
    label154:
    label160:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext, paramString, paramLong, 0L, localTVK_PlayerVideoInfo);
      return;
      label85:
      QLog.d("AbsVideoPlayerImpl", 1, "OskPlayerCore.getInstance().getUrl: " + paramString);
      paramString = OskPlayerCore.getInstance().getUrl(paramString);
      QLog.d("AbsVideoPlayerImpl", 1, "OskPlayerCore.getInstance().getUrl done: " + paramString);
      localTVK_PlayerVideoInfo.setPlayType(5);
      continue;
      localTVK_PlayerVideoInfo.setPlayType(4);
    }
  }
  
  public void pause()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(new bkmj(this, paramOnCaptureImageListener));
    }
  }
  
  public void setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new bkmf(this, paramOnCompletionListener));
    }
  }
  
  public void setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnControllerClickListener(new bkmd(this, paramOnControllerClickListener));
    }
  }
  
  public void setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new bkmg(this, paramOnErrorListener));
    }
  }
  
  public void setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new bkmh(this, paramOnInfoListener));
    }
  }
  
  public void setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new bkmi(this, paramOnSeekCompleteListener));
    }
  }
  
  public void setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new bkme(this, paramOnVideoPreparedListener));
    }
  }
  
  public boolean setOutputMute(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
    return false;
  }
  
  public void setXYaxis(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(paramInt);
    }
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void startPlayDanmu()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.startPlayDanmu();
    }
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
  }
  
  public void stopPlayDanmu()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stopPlayDanmu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmb
 * JD-Core Version:    0.7.0.1
 */
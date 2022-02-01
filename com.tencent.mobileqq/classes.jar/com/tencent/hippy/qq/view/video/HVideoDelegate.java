package com.tencent.hippy.qq.view.video;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class HVideoDelegate
  implements HippyQQVideoView.OnVideoViewControlListener, PlayerStatusListener, IVideoVolumeController.EventListener
{
  private static final int CODE_VIDEO_ERROR = 101;
  private static final String RESIZE_CONTAIN = "contain";
  private static final String RESIZE_COVER = "cover";
  private static final String TAG = "VVideoControlListenerImpl";
  protected Activity mActivity;
  private boolean mCoverFrame = false;
  private boolean mIsShowingFull = false;
  private int mMaxVolume = -1;
  private int mOriginSystemUIVisibility;
  IReadInJoyPlayer mPlayer;
  private long mStartPosition;
  @Nullable
  private VideoInfo mVideoInfo;
  protected HippyQQVideoView mVideoView;
  
  public HVideoDelegate(Activity paramActivity, HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    this.mPlayer = ((IReadInJoyPlayerFactory)QRoute.api(IReadInJoyPlayerFactory.class)).createPlayer(paramInt);
    this.mVideoView = paramHippyQQVideoView;
    this.mActivity = paramActivity;
    ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).inKandianModule(paramActivity);
    ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).addEventListener(this);
    this.mPlayer.a(this);
    this.mPlayer.a(paramHippyQQVideoView);
  }
  
  private void callJsStateChange(int paramInt, HippyMap paramHippyMap)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("state", paramInt);
    if (paramHippyMap != null) {
      localHippyMap.pushMap("message", paramHippyMap);
    }
    paramHippyMap = new HippyMap();
    paramHippyMap.pushInt("width", this.mPlayer.b());
    paramHippyMap.pushInt("height", this.mPlayer.c());
    localHippyMap.pushMap("videoSize", paramHippyMap);
    this.mVideoView.videoViewFireEvent("stateChange", localHippyMap);
  }
  
  private int getVideoState()
  {
    int i = this.mPlayer.a();
    if (i != 0) {
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 7) {
                return 6;
              }
            }
            else {
              return 4;
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    return 5;
  }
  
  private void onOrientationChanged()
  {
    if (this.mIsShowingFull)
    {
      try
      {
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushInt("hasUI", 0);
        this.mVideoView.videoViewFireEvent("didEnterFullScreen", localHippyMap);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initChangeFullScreenAnim onAnimationEnd error = : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    else
    {
      this.mVideoView.videoViewFireEvent("didExitFullScreen", null);
    }
  }
  
  public static final int parseTimeToSeconds(long paramLong)
  {
    if (paramLong >= 500L)
    {
      double d = paramLong / 1000L;
      Double.isNaN(d);
      return (int)(d + 0.5D);
    }
    return 0;
  }
  
  public void afterChangeFullScreen(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.h();
  }
  
  public void beforeChangeFullScreen(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.g();
  }
  
  public void beforeVideoStart() {}
  
  public void enterFullScreen(int paramInt, HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.mIsShowingFull = true;
    if (!paramBoolean) {
      if (paramInt == 0) {
        this.mActivity.setRequestedOrientation(0);
      } else {
        this.mActivity.setRequestedOrientation(8);
      }
    }
    paramHippyQQVideoView = this.mActivity;
    Window localWindow = paramHippyQQVideoView.getWindow();
    this.mOriginSystemUIVisibility = localWindow.getDecorView().getSystemUiVisibility();
    if (paramBoolean)
    {
      localWindow.setFlags(1024, 1024);
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideNavigationBar(this.mActivity);
    }
    else
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(paramHippyQQVideoView);
    }
    onOrientationChanged();
    if (paramPromise != null)
    {
      paramHippyQQVideoView = new HippyMap();
      paramHippyQQVideoView.pushBoolean("hasUI", false);
      paramPromise.resolve(paramHippyQQVideoView);
    }
  }
  
  public void exitFullScreen(HippyQQVideoView paramHippyQQVideoView, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.mIsShowingFull = false;
    this.mActivity.setRequestedOrientation(1);
    this.mActivity.setRequestedOrientation(1);
    paramHippyQQVideoView = this.mActivity.getWindow();
    paramHippyQQVideoView.getDecorView().setSystemUiVisibility(this.mOriginSystemUIVisibility);
    paramHippyQQVideoView.clearFlags(1024);
    onOrientationChanged();
    if (paramPromise != null)
    {
      paramHippyQQVideoView = new HippyMap();
      paramHippyQQVideoView.pushBoolean("hasUI", false);
      paramPromise.resolve(paramHippyQQVideoView);
    }
  }
  
  public void getPlayInfo(HippyQQVideoView paramHippyQQVideoView, Promise paramPromise)
  {
    if (paramPromise != null)
    {
      paramHippyQQVideoView = new HippyMap();
      paramHippyQQVideoView.pushInt("state", getVideoState());
      paramHippyQQVideoView.pushInt("currentTime", parseTimeToSeconds(this.mPlayer.b()));
      paramHippyQQVideoView.pushDouble("totalTime", this.mPlayer.a() / 1000L);
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("width", this.mPlayer.b());
      localHippyMap.pushInt("height", this.mPlayer.c());
      paramHippyQQVideoView.pushMap("videoSize", localHippyMap);
      paramPromise.resolve(paramHippyQQVideoView);
    }
  }
  
  public boolean isFullScreen()
  {
    return this.mIsShowingFull;
  }
  
  public void onActivityCreate() {}
  
  public void onActivityDestroy()
  {
    this.mPlayer.m();
    ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).outKandianModule(this.mActivity);
    ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).removeEventListener(this);
    this.mActivity = null;
  }
  
  public void onActivityPause()
  {
    this.mPlayer.k();
    ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).requestOrAbandonAudioFocus(false, "viola video");
  }
  
  public void onActivityResume()
  {
    this.mPlayer.l();
    ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).requestOrAbandonAudioFocus(true, "viola video");
  }
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onBufferEnd()
  {
    if (this.mPlayer.h())
    {
      callJsStateChange(2, null);
      return;
    }
    if (this.mPlayer.g()) {
      callJsStateChange(4, null);
    }
  }
  
  public void onBufferStart()
  {
    callJsStateChange(3, null);
  }
  
  public void onCompletion()
  {
    callJsStateChange(5, null);
  }
  
  public void onDownloadFinished() {}
  
  public void onFirstFrameRendered() {}
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    this.mPlayer.e(paramBoolean ^ true);
  }
  
  public void onPhoneCome()
  {
    this.mPlayer.d();
  }
  
  public void onProgressChanged(long paramLong)
  {
    try
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushObject("currentTime", Integer.valueOf(parseTimeToSeconds(paramLong)));
      localHippyMap.pushObject("totalTime", Long.valueOf(this.mPlayer.a() / 1000L));
      this.mVideoView.videoViewFireEvent("playTimeChange", localHippyMap);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    Object localObject = this.mPlayer;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((IReadInJoyPlayer)localObject).e(bool);
    try
    {
      localObject = new HippyMap();
      if (this.mMaxVolume == -1) {
        this.mMaxVolume = ((IVideoVolumeController)QRoute.api(IVideoVolumeController.class)).getStreamMaxVolume(3);
      }
      ((HippyMap)localObject).pushObject("value", Float.valueOf(paramInt / this.mMaxVolume));
      this.mVideoView.videoViewFireEvent("volumeChange", (HippyMap)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onVideoEnd(int paramInt)
  {
    callJsStateChange(5, null);
  }
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString)
  {
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushInt("code", 101);
    HippyMap localHippyMap2 = new HippyMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localHippyMap2.pushString("code", localStringBuilder.toString());
    localHippyMap2.pushString("msg", paramString);
    localHippyMap1.pushMap("extra", localHippyMap2);
    callJsStateChange(6, localHippyMap1);
  }
  
  public void onVideoOpen() {}
  
  public void onVideoPause()
  {
    callJsStateChange(4, null);
  }
  
  public void onVideoPrepared()
  {
    callJsStateChange(1, null);
  }
  
  public void onVideoRestart()
  {
    callJsStateChange(2, null);
  }
  
  public void onVideoStart()
  {
    callJsStateChange(2, null);
  }
  
  public void onVideoStop()
  {
    callJsStateChange(7, null);
  }
  
  public void open(HippyQQVideoView paramHippyQQVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open: ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    try
    {
      boolean bool1 = paramJSONObject.optBoolean("autoplay", true);
      boolean bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      setResize(paramHippyQQVideoView, paramJSONObject.optString("resize"));
      setTimeInterval(paramHippyQQVideoView, paramJSONObject.optInt("timeupdateRate"));
      setEndWithLastFrame(paramJSONObject.optBoolean("endWithLastFrame"));
      this.mCoverFrame = paramJSONObject.optBoolean("cover_frame", false);
      this.mStartPosition = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.mVideoInfo = new VideoInfo(paramJSONObject.getJSONObject("video_info"));
      this.mPlayer.e(paramJSONObject.optBoolean("muted", false));
      if (bool1)
      {
        this.mPlayer.a(this.mVideoInfo.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
        return;
      }
      if (bool2)
      {
        preplay(null);
        return;
      }
    }
    catch (JSONException paramHippyQQVideoView)
    {
      paramHippyQQVideoView.printStackTrace();
    }
  }
  
  public void pause(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.d();
  }
  
  public void play(HippyQQVideoView paramHippyQQVideoView)
  {
    if (QLog.isColorLevel())
    {
      paramHippyQQVideoView = new StringBuilder();
      paramHippyQQVideoView.append("play: status=");
      paramHippyQQVideoView.append(this.mPlayer.a());
      paramHippyQQVideoView.append(", isPreload=");
      paramHippyQQVideoView.append(this.mPlayer.a());
      paramHippyQQVideoView.append(", videoinfo=");
      paramHippyQQVideoView.append(this.mVideoInfo);
      paramHippyQQVideoView.append(", mStartPosition:");
      paramHippyQQVideoView.append(this.mStartPosition);
      QLog.d("VVideoControlListenerImpl", 2, paramHippyQQVideoView.toString());
    }
    if ((this.mVideoInfo != null) && (this.mPlayer.a()))
    {
      this.mPlayer.a(this.mVideoInfo.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
      return;
    }
    if (this.mPlayer.b())
    {
      this.mPlayer.c();
      return;
    }
    paramHippyQQVideoView = this.mVideoInfo;
    if (paramHippyQQVideoView != null) {
      this.mPlayer.a(paramHippyQQVideoView.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void preplay(HippyQQVideoView paramHippyQQVideoView)
  {
    if ((this.mVideoInfo != null) && (!this.mPlayer.a()))
    {
      this.mPlayer.b(this.mCoverFrame);
      this.mPlayer.a(this.mVideoInfo.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void replay(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.f();
    paramHippyQQVideoView = this.mVideoInfo;
    if (paramHippyQQVideoView != null) {
      this.mPlayer.a(paramHippyQQVideoView.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void resetSrc(HippyQQVideoView paramHippyQQVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetSrc: ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("VVideoControlListenerImpl", 2, localStringBuilder.toString());
    }
    this.mPlayer.f();
    open(paramHippyQQVideoView, paramJSONObject);
  }
  
  public void seek(HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    this.mPlayer.b(paramInt);
  }
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.mPlayer.c(paramBoolean);
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    this.mPlayer.d(paramBoolean);
  }
  
  public void setMuted(HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean)
  {
    this.mPlayer.e(paramBoolean);
  }
  
  public void setResize(HippyQQVideoView paramHippyQQVideoView, String paramString)
  {
    if (paramString.equals("contain"))
    {
      this.mPlayer.a(0);
      return;
    }
    if (paramString.equals("cover")) {
      this.mPlayer.a(2);
    }
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPosition = (paramInt * 1000);
  }
  
  public void setTimeInterval(HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    this.mPlayer.c(paramInt);
  }
  
  public void setVideoPreDownloadMgr(IVideoPreDownloadMgr paramIVideoPreDownloadMgr)
  {
    this.mPlayer.a(paramIVideoPreDownloadMgr);
  }
  
  public void stop(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HVideoDelegate
 * JD-Core Version:    0.7.0.1
 */
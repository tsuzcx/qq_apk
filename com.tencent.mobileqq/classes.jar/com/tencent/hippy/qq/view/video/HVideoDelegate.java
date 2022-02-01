package com.tencent.hippy.qq.view.video;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import rwv;
import seo;
import sep;
import sgr;
import sgs;
import sgu;
import tmt;

public class HVideoDelegate
  implements HippyQQVideoView.OnVideoViewControlListener, sep, sgr
{
  private static final int CODE_VIDEO_ERROR = 101;
  private static final String RESIZE_CONTAIN = "contain";
  private static final String RESIZE_COVER = "cover";
  private static final String TAG = "VVideoControlListenerImpl";
  protected Activity mActivity;
  private boolean mCoverFrame;
  private boolean mIsShowingFull;
  private int mMaxVolume = -1;
  private int mOriginSystemUIVisibility;
  sgs mPlayer;
  private long mStartPosition;
  @Nullable
  private tmt mVideoInfo;
  protected HippyQQVideoView mVideoView;
  
  public HVideoDelegate(Activity paramActivity, HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    this.mPlayer = new sgs(paramInt);
    this.mVideoView = paramHippyQQVideoView;
    this.mActivity = paramActivity;
    seo.a().a(paramActivity);
    seo.a().a(this);
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
    switch (this.mPlayer.a())
    {
    case 6: 
    default: 
      return 6;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  private void onOrientationChanged()
  {
    if (this.mIsShowingFull) {
      try
      {
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushInt("hasUI", 0);
        this.mVideoView.videoViewFireEvent("didEnterFullScreen", localHippyMap);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("VVideoControlListenerImpl", 2, "initChangeFullScreenAnim onAnimationEnd error = : " + localException.getMessage());
        return;
      }
    }
    this.mVideoView.videoViewFireEvent("didExitFullScreen", null);
  }
  
  public static final int parseTimeToSeconds(long paramLong)
  {
    int i = 0;
    if (paramLong >= 500L) {
      i = (int)(paramLong / 1000L + 0.5D);
    }
    return i;
  }
  
  public void afterChangeFullScreen(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.h();
  }
  
  public void beforeChangeFullScreen(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.g();
  }
  
  public void enterFullScreen(int paramInt, HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.mIsShowingFull = true;
    if (!paramBoolean)
    {
      if (paramInt == 0) {
        this.mActivity.setRequestedOrientation(0);
      }
    }
    else
    {
      paramHippyQQVideoView = this.mActivity;
      Window localWindow = paramHippyQQVideoView.getWindow();
      this.mOriginSystemUIVisibility = localWindow.getDecorView().getSystemUiVisibility();
      if (!paramBoolean) {
        break label125;
      }
      localWindow.setFlags(1024, 1024);
      rwv.b(this.mActivity);
    }
    for (;;)
    {
      onOrientationChanged();
      if (paramPromise != null)
      {
        paramHippyQQVideoView = new HippyMap();
        paramHippyQQVideoView.pushBoolean("hasUI", false);
        paramPromise.resolve(paramHippyQQVideoView);
      }
      return;
      this.mActivity.setRequestedOrientation(8);
      break;
      label125:
      rwv.a(paramHippyQQVideoView);
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
    seo.a().b(this.mActivity);
    seo.a().b(this);
    this.mActivity = null;
  }
  
  public void onActivityPause()
  {
    this.mPlayer.k();
    seo.a().a(false, "viola video");
  }
  
  public void onActivityResume()
  {
    this.mPlayer.l();
    seo.a().a(true, "viola video");
  }
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onBufferEnd()
  {
    if (this.mPlayer.h()) {
      callJsStateChange(2, null);
    }
    while (!this.mPlayer.g()) {
      return;
    }
    callJsStateChange(4, null);
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
    if (paramBoolean)
    {
      this.mPlayer.e(false);
      return;
    }
    this.mPlayer.e(true);
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
    if (paramInt == 0) {
      this.mPlayer.e(true);
    }
    for (;;)
    {
      try
      {
        HippyMap localHippyMap = new HippyMap();
        if (this.mMaxVolume == -1) {
          this.mMaxVolume = seo.a().a(3);
        }
        localHippyMap.pushObject("value", Float.valueOf(paramInt / this.mMaxVolume));
        this.mVideoView.videoViewFireEvent("volumeChange", localHippyMap);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.mPlayer.e(false);
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
    localHippyMap2.pushString("code", paramInt1 + "-" + paramInt2);
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
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "open: " + paramJSONObject);
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
      this.mVideoInfo = new tmt(paramJSONObject.getJSONObject("video_info"));
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
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "play: status=" + this.mPlayer.a() + ", isPreload=" + this.mPlayer.a() + ", videoinfo=" + this.mVideoInfo + ", mStartPosition:" + this.mStartPosition);
    }
    if ((this.mVideoInfo != null) && (this.mPlayer.a())) {
      this.mPlayer.a(this.mVideoInfo.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
    }
    do
    {
      return;
      if (this.mPlayer.b())
      {
        this.mPlayer.c();
        return;
      }
    } while (this.mVideoInfo == null);
    this.mPlayer.a(this.mVideoInfo.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
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
    if (this.mVideoInfo != null) {
      this.mPlayer.a(this.mVideoInfo.jdField_a_of_type_Int, this.mVideoInfo.jdField_a_of_type_JavaLangString, this.mVideoInfo.jdField_d_of_type_JavaLangString, this.mStartPosition, this.mVideoInfo.jdField_d_of_type_Int);
    }
  }
  
  public void resetSrc(HippyQQVideoView paramHippyQQVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "resetSrc: " + paramJSONObject);
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
  
  public void setPredownloadMgr(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.mPlayer.a.a(paramVideoPreDownloadMgr);
  }
  
  public void setResize(HippyQQVideoView paramHippyQQVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.mPlayer.a(0);
    }
    while (!paramString.equals("cover")) {
      return;
    }
    this.mPlayer.a(2);
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPosition = (paramInt * 1000);
  }
  
  public void setTimeInterval(HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    this.mPlayer.c(paramInt);
  }
  
  public void stop(HippyQQVideoView paramHippyQQVideoView)
  {
    this.mPlayer.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HVideoDelegate
 * JD-Core Version:    0.7.0.1
 */
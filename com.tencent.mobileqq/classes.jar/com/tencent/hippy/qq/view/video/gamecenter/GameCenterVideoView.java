package com.tencent.hippy.qq.view.video.gamecenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.collection.ArrayMap;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.media.DanmakuHost.Item;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterVideoView
  extends HippyViewGroup
  implements HippyViewBase
{
  private static final GameCenterVideoView.FunctionExecutor NO_OP_FUNCTION = new GameCenterVideoView.3();
  private static final int PLAYER_INFO_CURRENT_LOOP_START = 107;
  private static final SparseIntArray STATUS_MAP = new SparseIntArray();
  public static final int STYLE_IMMERSIVE = 0;
  public static final int STYLE_NORMAL = 15;
  public static final int STYLE_SHOW_AUDIO_BTN = 2;
  public static final int STYLE_SHOW_FULLSCREEN_BTN = 8;
  public static final int STYLE_SHOW_PLAY_BTN = 1;
  public static final int STYLE_SHOW_PROGRESS_BTN = 4;
  private static final String TAG = "GameCenterVideoView";
  private boolean mAutoPlay = false;
  private String mCoverUrl;
  private int mCurrentLoop = 1;
  private long mDuration;
  private boolean mIsDoingFullscreen = false;
  private boolean mIsLandscapeWhenFullScreen = true;
  private volatile boolean mListenProgress;
  private int mLoop = 1;
  private boolean mMuted = true;
  private boolean mPreload;
  private final HippyMap mProgressMap = new HippyMap();
  private volatile GameCenterVideoView.SDKInitListenerWithAction mSDKInitListener;
  private String mSrc;
  private int mType;
  private int mUIStyle;
  private GameCenterVideoView.VideoViewWrapper mVideoView;
  
  static
  {
    STATUS_MAP.put(0, 0);
    STATUS_MAP.put(4, 3);
    STATUS_MAP.put(3, 4);
    STATUS_MAP.put(5, 5);
    STATUS_MAP.put(7, 6);
  }
  
  public GameCenterVideoView(@android.support.annotation.NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    initVideoView(paramContext, paramInt);
  }
  
  private void doActionAfterSDKInit(Runnable paramRunnable)
  {
    if (QQVideoPlaySDKManager.isSDKReady())
    {
      paramRunnable.run();
      return;
    }
    if (this.mSDKInitListener == null)
    {
      this.mSDKInitListener = new GameCenterVideoView.SDKInitListenerWithAction(this, paramRunnable);
      QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this.mSDKInitListener);
      return;
    }
    this.mSDKInitListener.action = paramRunnable;
  }
  
  private void forceViewMeasure()
  {
    if (this.mIsDoingFullscreen) {
      return;
    }
    forceViewMeasure(this);
  }
  
  private void forceViewMeasure(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramView.getHeight(), 1073741824));
    paramView.layout(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  private void initVideoView(@android.support.annotation.NonNull Context paramContext, int paramInt)
  {
    this.mVideoView = new GameCenterVideoView.VideoViewWrapper(this, paramContext, paramInt);
    this.mVideoView.setBackgroundColor(-16777216);
    addView(this.mVideoView, -1, -1);
  }
  
  public void clearDanmu()
  {
    DanmakuLayout localDanmakuLayout = this.mVideoView.getDanmakuLayout();
    if (localDanmakuLayout != null) {
      localDanmakuLayout.a();
    }
  }
  
  public void destory()
  {
    this.mVideoView.destroy();
  }
  
  public void dispatchFunction(String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoView", 2, new Object[] { "dispatchFunction, functionName:", paramString, ", hippyArray:", paramHippyArray, ", promise:", paramPromise });
    }
    ((GameCenterVideoView.FunctionExecutor)GameCenterVideoView.VideoViewWrapper.access$000(this.mVideoView).getOrDefault(paramString, NO_OP_FUNCTION)).execute(paramHippyArray, paramPromise);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void onAfterUpdateProps()
  {
    FeedsItemData localFeedsItemData = new FeedsItemData();
    int i = this.mType;
    if ((i != 2) && (i != 1))
    {
      localFeedsItemData.type = 2;
      localFeedsItemData.videoVid = this.mSrc;
    }
    else
    {
      i = this.mType;
      localFeedsItemData.type = i;
      str = this.mSrc;
      localFeedsItemData.videoUrl = str;
      if (i != 1) {
        HtmlOffline.a(str, MobileQQ.sMobileQQ.waitAppRuntime(null));
      }
    }
    String str = this.mCoverUrl;
    localFeedsItemData.coverImgUrl = str;
    HtmlOffline.a(str, MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.mVideoView.setData(localFeedsItemData, 1);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoView", 2, new Object[] { "onAfterUpdateProps: ", this });
    }
    this.mVideoView.setVideoStatusChangerListener(new GameCenterVideoView.1(this));
    doActionAfterSDKInit(new GameCenterVideoView.2(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    post(new GameCenterVideoView.4(this));
  }
  
  public void sendEvent(String paramString, HippyMap paramHippyMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoView", 2, new Object[] { "sendEvent, eventName:", paramString, ", data:", paramHippyMap });
    }
    new HippyViewEvent(paramString).send(this, paramHippyMap);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
  }
  
  public void setDanmuData(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        localObject = new JSONObject(paramString).optJSONArray("data");
        DanmakuHost.Item[] arrayOfItem = new DanmakuHost.Item[paramString.length()];
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if (localJSONObject != null) {
            arrayOfItem[i] = new DanmakuHost.Item(localJSONObject.optString("text"), localJSONObject.optDouble("onScreenTime"), localJSONObject.optDouble("screenDuration"), localJSONObject.optString("fontColor"), localJSONObject.optString("backgroundColor"));
          }
        }
        else
        {
          this.mVideoView.getDanmakuLayout().a(arrayOfItem);
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDanmuData Err:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("GameCenterVideoView", 1, ((StringBuilder)localObject).toString());
        return;
      }
      i += 1;
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setIsLandscapeWhenFullScreen(boolean paramBoolean)
  {
    this.mIsLandscapeWhenFullScreen = paramBoolean;
    this.mVideoView.setIsLandscapeWhenFullScreen(this.mIsLandscapeWhenFullScreen);
  }
  
  public void setListenProgress(boolean paramBoolean)
  {
    this.mListenProgress = paramBoolean;
  }
  
  public void setLoadingIconStyle(int paramInt)
  {
    GameCenterVideoView.VideoViewWrapper localVideoViewWrapper = this.mVideoView;
    if (localVideoViewWrapper != null) {
      localVideoViewWrapper.setLoadingIconStyle(paramInt);
    }
  }
  
  public void setLoop(int paramInt)
  {
    if (paramInt >= 0) {
      this.mLoop = paramInt;
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    this.mMuted = paramBoolean;
    this.mVideoView.setMute(paramBoolean);
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.mPreload = paramBoolean;
  }
  
  public void setSrc(String paramString)
  {
    this.mSrc = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setUIStyle(int paramInt)
  {
    this.mUIStyle = paramInt;
    GameCenterVideoView.VideoViewWrapper localVideoViewWrapper = this.mVideoView;
    boolean bool2 = false;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localVideoViewWrapper.setPlayEnabled(bool1);
    if ((paramInt & 0x2) != 0) {
      this.mVideoView.enableVolumeSwitch();
    }
    localVideoViewWrapper = this.mVideoView;
    boolean bool1 = bool2;
    if ((paramInt & 0x4) != 0) {
      bool1 = true;
    }
    localVideoViewWrapper.setProgressEnabled(bool1);
    if ((paramInt & 0x8) != 0) {
      this.mVideoView.enableFullScreenSwitch();
    }
  }
  
  public void setVideoDuration(int paramInt)
  {
    GameCenterVideoView.VideoViewWrapper localVideoViewWrapper = this.mVideoView;
    if (localVideoViewWrapper != null) {
      localVideoViewWrapper.setVideoDuration(paramInt);
    }
  }
  
  @androidx.annotation.NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameCenterVideoView{");
    localStringBuilder.append("mSrc=");
    localStringBuilder.append(this.mSrc);
    localStringBuilder.append(", mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(", mLoop=");
    localStringBuilder.append(this.mLoop);
    localStringBuilder.append(", mCurrentLoop=");
    localStringBuilder.append(this.mCurrentLoop);
    localStringBuilder.append(", mCoverUrl=");
    localStringBuilder.append(this.mCoverUrl);
    localStringBuilder.append(", mMuted=");
    localStringBuilder.append(this.mMuted);
    localStringBuilder.append(", mAutoPlay=");
    localStringBuilder.append(this.mAutoPlay);
    localStringBuilder.append(", mPreload=");
    localStringBuilder.append(this.mPreload);
    localStringBuilder.append(", mUIStyle=");
    localStringBuilder.append(this.mUIStyle);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.hippy.qq.view.video.gamecenter;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.collection.ArrayMap;
import atxz;
import azjl;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

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
  private boolean mAutoPlay;
  private String mCoverUrl;
  private int mCurrentLoop = 1;
  private long mDuration;
  private boolean mIsDoingFullscreen;
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
  
  public GameCenterVideoView(@android.support.annotation.NonNull Context paramContext)
  {
    super(paramContext);
    initVideoView(paramContext);
  }
  
  private void doActionAfterSDKInit(Runnable paramRunnable)
  {
    if (azjl.a())
    {
      paramRunnable.run();
      return;
    }
    if (this.mSDKInitListener == null)
    {
      this.mSDKInitListener = new GameCenterVideoView.SDKInitListenerWithAction(this, paramRunnable);
      azjl.a(BaseApplication.getContext(), this.mSDKInitListener);
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
  
  private void initVideoView(@android.support.annotation.NonNull Context paramContext)
  {
    this.mVideoView = new GameCenterVideoView.VideoViewWrapper(this, paramContext);
    this.mVideoView.setBackgroundColor(-16777216);
    addView(this.mVideoView, -1, -1);
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
    if ((this.mType == 2) || (this.mType == 1))
    {
      localFeedsItemData.type = this.mType;
      localFeedsItemData.videoUrl = this.mSrc;
    }
    for (;;)
    {
      localFeedsItemData.coverImgUrl = this.mCoverUrl;
      this.mVideoView.setData(localFeedsItemData, 1);
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterVideoView", 2, new Object[] { "onAfterUpdateProps: ", this });
      }
      this.mVideoView.setVideoStatusChangerListener(new GameCenterVideoView.1(this));
      doActionAfterSDKInit(new GameCenterVideoView.2(this));
      return;
      localFeedsItemData.type = 2;
      localFeedsItemData.videoVid = this.mSrc;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mVideoView.release();
    if (atxz.a().a() == this.mVideoView) {
      atxz.a().a();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setListenProgress(boolean paramBoolean)
  {
    this.mListenProgress = paramBoolean;
  }
  
  public void setLoop(int paramInt)
  {
    if (paramInt >= 0) {
      this.mLoop = paramInt;
    }
  }
  
  void setMuted(boolean paramBoolean)
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
    boolean bool2 = true;
    this.mUIStyle = paramInt;
    GameCenterVideoView.VideoViewWrapper localVideoViewWrapper = this.mVideoView;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      localVideoViewWrapper.setPlayEnabled(bool1);
      if ((paramInt & 0x2) != 0) {
        this.mVideoView.enableVolumeSwitch();
      }
      localVideoViewWrapper = this.mVideoView;
      if ((paramInt & 0x4) == 0) {
        break label80;
      }
    }
    label80:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoViewWrapper.setProgressEnabled(bool1);
      if ((paramInt & 0x8) != 0) {
        this.mVideoView.enableFullScreenSwitch();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  @androidx.annotation.NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameCenterVideoView{");
    localStringBuilder.append("mSrc=").append(this.mSrc);
    localStringBuilder.append(", mType=").append(this.mType);
    localStringBuilder.append(", mLoop=").append(this.mLoop);
    localStringBuilder.append(", mCurrentLoop=").append(this.mCurrentLoop);
    localStringBuilder.append(", mCoverUrl=").append(this.mCoverUrl);
    localStringBuilder.append(", mMuted=").append(this.mMuted);
    localStringBuilder.append(", mAutoPlay=").append(this.mAutoPlay);
    localStringBuilder.append(", mPreload=").append(this.mPreload);
    localStringBuilder.append(", mUIStyle=").append(this.mUIStyle);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView
 * JD-Core Version:    0.7.0.1
 */
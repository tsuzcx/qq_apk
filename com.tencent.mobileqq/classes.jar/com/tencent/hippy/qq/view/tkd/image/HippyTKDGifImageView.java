package com.tencent.hippy.qq.view.tkd.image;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.image.HippyImageView;

public class HippyTKDGifImageView
  extends HippyImageView
  implements HippyTKDSkinHandler.HippyQBCommonSkin, HippyViewBase
{
  public static final String TAG = "HippyGifImage";
  private HippyMap mClipInfoMap;
  private boolean mEnableNoPicMode;
  String mGIFUrl = null;
  private NativeGestureDispatcher mGestureDispatcher;
  protected HippyEngineContext mHippyEngineContext;
  private HippyTKDGifImageView.OnErrorEvent mOnErrorEvent;
  private HippyTKDGifImageView.OnLoadEvent mOnLoadEvent;
  private HippyTKDGifImageView.OnLoadStartEvent mOnLoadStartEvent;
  private HippyTKDGifImageView.OnStartPlayEvent mOnStartPlayEvent;
  private HippyTKDGifImageView.OnStopPlayEvent mOnStopPlayEvent;
  private HippyMap mReportData;
  boolean mUserRequestPlay = false;
  
  public HippyTKDGifImageView(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof HippyInstanceContext)) {
      localHippyEngineContext = ((HippyInstanceContext)paramContext).getEngineContext();
    }
    this.mHippyEngineContext = localHippyEngineContext;
  }
  
  private HippyTKDGifImageView.OnErrorEvent getOnErrorEvent()
  {
    if (this.mOnErrorEvent == null) {
      this.mOnErrorEvent = new HippyTKDGifImageView.OnErrorEvent(this, "onError");
    }
    return this.mOnErrorEvent;
  }
  
  private HippyTKDGifImageView.OnLoadEvent getOnLoadEvent()
  {
    if (this.mOnLoadEvent == null) {
      this.mOnLoadEvent = new HippyTKDGifImageView.OnLoadEvent(this, "onLoad");
    }
    return this.mOnLoadEvent;
  }
  
  private HippyTKDGifImageView.OnLoadStartEvent getOnLoadStartEvent()
  {
    if (this.mOnLoadStartEvent == null) {
      this.mOnLoadStartEvent = new HippyTKDGifImageView.OnLoadStartEvent(this, "onLoadStart");
    }
    return this.mOnLoadStartEvent;
  }
  
  private HippyTKDGifImageView.OnStartPlayEvent getOnStartPlayEvent()
  {
    if (this.mOnStartPlayEvent == null) {
      this.mOnStartPlayEvent = new HippyTKDGifImageView.OnStartPlayEvent(this, "onStartPlay");
    }
    return this.mOnStartPlayEvent;
  }
  
  private HippyTKDGifImageView.OnStopPlayEvent getOnStopPlayEvent()
  {
    if (this.mOnStopPlayEvent == null) {
      this.mOnStopPlayEvent = new HippyTKDGifImageView.OnStopPlayEvent(this, "onStopPlay");
    }
    return this.mOnStopPlayEvent;
  }
  
  public HippyMap getClipInfo()
  {
    return this.mClipInfoMap;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  public HippyMap getReportData()
  {
    return this.mReportData;
  }
  
  public void handleNoPicModeChange() {}
  
  public void hippySwitchSkin() {}
  
  public void onDetachedFromWindow()
  {
    this.mUserRequestPlay = false;
    super.onDetachedFromWindow();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.mGestureDispatcher != null) {
      bool1 = bool2 | this.mGestureDispatcher.handleTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public void setClipInfo(HippyMap paramHippyMap)
  {
    this.mClipInfoMap = paramHippyMap;
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setGifUrl(String paramString) {}
  
  public void setNoPicModeOption(boolean paramBoolean) {}
  
  public void setReportData(HippyMap paramHippyMap)
  {
    this.mReportData = paramHippyMap;
  }
  
  public void setSustainedPlay(boolean paramBoolean) {}
  
  public void stopPlay() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageView
 * JD-Core Version:    0.7.0.1
 */
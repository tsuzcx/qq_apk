package com.tencent.hippy.qq.view.video;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qphone.base.util.QLog;

public class HippyQQVideoView
  extends HippyViewGroup
  implements HippyViewBase
{
  public static String TAG = "HippyVideoView";
  private Activity mActivity;
  private boolean mHasExictlySize = true;
  private HippyEngineContext mHippyContext;
  private boolean mIsDoingFullscreen = false;
  private int mOriginalHeight;
  private int mOriginalIndex = 0;
  private ViewGroup.LayoutParams mOriginalLayoutParams;
  private ViewGroup mOriginalParent;
  private int mOriginalWidth;
  private HippyQQVideoView.OnVideoViewControlListener mVideoViewControlListener;
  
  public HippyQQVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof HippyInstanceContext))
    {
      paramContext = (HippyInstanceContext)paramContext;
      this.mHippyContext = paramContext.getEngineContext();
      if ((paramContext.getBaseContext() instanceof Activity)) {
        this.mActivity = ((Activity)paramContext.getBaseContext());
      }
    }
  }
  
  private void forceViewMeasure(View paramView)
  {
    if ((paramView == null) || (this.mIsDoingFullscreen)) {
      return;
    }
    int i;
    label24:
    label43:
    int k;
    int m;
    if (this.mOriginalWidth == 0)
    {
      i = paramView.getWidth();
      j = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      if (this.mOriginalHeight != 0) {
        break label144;
      }
      i = paramView.getHeight();
      paramView.measure(j, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      k = paramView.getLeft();
      m = paramView.getTop();
      if (this.mOriginalWidth != 0) {
        break label152;
      }
      i = paramView.getRight();
      label78:
      if (this.mOriginalHeight != 0) {
        break label165;
      }
    }
    label144:
    label152:
    label165:
    for (int j = paramView.getBottom();; j = paramView.getTop() + this.mOriginalHeight)
    {
      paramView.layout(k, m, i, j);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "forceViewMeasure mIsDoingFullscreen:" + this.mIsDoingFullscreen);
      return;
      i = this.mOriginalWidth;
      break label24;
      i = this.mOriginalHeight;
      break label43;
      i = paramView.getLeft() + this.mOriginalWidth;
      break label78;
    }
  }
  
  public void endHotSwap()
  {
    if (this.mVideoViewControlListener != null) {
      this.mVideoViewControlListener.afterChangeFullScreen(this);
    }
  }
  
  public void enterFullScreen(int paramInt)
  {
    this.mIsDoingFullscreen = true;
    this.mOriginalLayoutParams = getLayoutParams();
    this.mOriginalParent = ((ViewGroup)getParent());
    if ((this.mOriginalLayoutParams.height <= 0) || (this.mOriginalLayoutParams.width <= 0))
    {
      this.mHasExictlySize = false;
      this.mOriginalWidth = getWidth();
      this.mOriginalHeight = getHeight();
    }
    if (this.mActivity != null)
    {
      Window localWindow = this.mActivity.getWindow();
      if ((getParent() instanceof ViewGroup))
      {
        this.mOriginalIndex = ((ViewGroup)getParent()).indexOfChild(this);
        startHotSwap();
        ((ViewGroup)getParent()).removeView(this);
        endHotSwap();
      }
      localWindow.addContentView(this, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void exitFullScreen(int paramInt)
  {
    this.mIsDoingFullscreen = false;
    if ((getParent() != null) && ((getParent() instanceof ViewGroup)))
    {
      startHotSwap();
      ((ViewGroup)getParent()).removeView(this);
      endHotSwap();
    }
    if (!this.mHasExictlySize)
    {
      this.mOriginalLayoutParams.height = this.mOriginalHeight;
      this.mOriginalLayoutParams.width = this.mOriginalWidth;
    }
    this.mOriginalParent.addView(this, this.mOriginalIndex, this.mOriginalLayoutParams);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public HippyQQVideoView.OnVideoViewControlListener getVideoViewControlListener()
  {
    return this.mVideoViewControlListener;
  }
  
  public void initView()
  {
    if (this.mActivity != null) {
      setVideoViewControlListener(new HVideoDelegate(this.mActivity, this, 102));
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (getChildAt(0) != null))
    {
      getChildAt(0).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      getChildAt(0).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onLayout mIsDoingFullscreen:" + this.mIsDoingFullscreen + ",changed:" + paramBoolean);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void requestLayout()
  {
    post(new HippyQQVideoView.1(this));
    super.requestLayout();
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setVideoViewControlListener(HippyQQVideoView.OnVideoViewControlListener paramOnVideoViewControlListener)
  {
    this.mVideoViewControlListener = paramOnVideoViewControlListener;
  }
  
  public void startHotSwap()
  {
    if (this.mVideoViewControlListener != null) {
      this.mVideoViewControlListener.beforeChangeFullScreen(this);
    }
  }
  
  public void videoViewFireEvent(String paramString, HippyMap paramHippyMap)
  {
    ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), paramString, paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HippyQQVideoView
 * JD-Core Version:    0.7.0.1
 */
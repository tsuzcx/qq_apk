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
    if (paramView != null)
    {
      if (this.mIsDoingFullscreen) {
        return;
      }
      int j = this.mOriginalWidth;
      int i = j;
      if (j == 0) {
        i = paramView.getWidth();
      }
      int k = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      j = this.mOriginalHeight;
      i = j;
      if (j == 0) {
        i = paramView.getHeight();
      }
      paramView.measure(k, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      k = paramView.getLeft();
      int m = paramView.getTop();
      if (this.mOriginalWidth == 0) {
        i = paramView.getRight();
      } else {
        i = paramView.getLeft() + this.mOriginalWidth;
      }
      if (this.mOriginalHeight == 0) {
        j = paramView.getBottom();
      } else {
        j = paramView.getTop() + this.mOriginalHeight;
      }
      paramView.layout(k, m, i, j);
      if (QLog.isColorLevel())
      {
        paramView = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("forceViewMeasure mIsDoingFullscreen:");
        localStringBuilder.append(this.mIsDoingFullscreen);
        QLog.d(paramView, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void endHotSwap()
  {
    HippyQQVideoView.OnVideoViewControlListener localOnVideoViewControlListener = this.mVideoViewControlListener;
    if (localOnVideoViewControlListener != null) {
      localOnVideoViewControlListener.afterChangeFullScreen(this);
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
    Object localObject = this.mActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if ((getParent() instanceof ViewGroup))
      {
        this.mOriginalIndex = ((ViewGroup)getParent()).indexOfChild(this);
        startHotSwap();
        ((ViewGroup)getParent()).removeView(this);
        endHotSwap();
      }
      ((Window)localObject).addContentView(this, new ViewGroup.LayoutParams(-1, -1));
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
      ViewGroup.LayoutParams localLayoutParams = this.mOriginalLayoutParams;
      localLayoutParams.height = this.mOriginalHeight;
      localLayoutParams.width = this.mOriginalWidth;
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
    Activity localActivity = this.mActivity;
    if (localActivity != null) {
      setVideoViewControlListener(new HVideoDelegate(localActivity, this, 102));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (getChildAt(0) != null))
    {
      getChildAt(0).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      getChildAt(0).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLayout mIsDoingFullscreen:");
        localStringBuilder.append(this.mIsDoingFullscreen);
        localStringBuilder.append(",changed:");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
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
    HippyQQVideoView.OnVideoViewControlListener localOnVideoViewControlListener = this.mVideoViewControlListener;
    if (localOnVideoViewControlListener != null) {
      localOnVideoViewControlListener.beforeChangeFullScreen(this);
    }
  }
  
  public void videoViewFireEvent(String paramString, HippyMap paramHippyMap)
  {
    ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), paramString, paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HippyQQVideoView
 * JD-Core Version:    0.7.0.1
 */
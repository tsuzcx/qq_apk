package com.tencent.hippy.qq.view.tkd.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPager;

public class HippyTKDViewGroup
  extends HippyViewGroup
  implements HippyTKDCommonBorderHandler.HippyQBCommonBorder, HippyTKDSkinHandler.HippyQBCommonSkin
{
  private int disableExternalScoll;
  HippyTKDSkinHandler mHippyTKDSkinHandler = new HippyTKDSkinHandler();
  private HippyTKDViewGroup.OnSizeChangeListener mOnSizeChangeListener;
  
  public HippyTKDViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public void changeExternalScrollEnabled(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    int i = 0;
    if ((localViewParent != null) && (i < this.disableExternalScoll)) {
      if ((localViewParent instanceof HippyScrollView))
      {
        ((HippyScrollView)localViewParent).setScrollEnabled(paramBoolean);
        i += 1;
      }
    }
    for (;;)
    {
      localViewParent = localViewParent.getParent();
      break;
      if ((localViewParent instanceof HippyListView))
      {
        ((HippyListView)localViewParent).setScrollEnable(paramBoolean);
        i += 1;
      }
      else if ((localViewParent instanceof HippyViewPager))
      {
        ((HippyViewPager)localViewParent).setScrollEnabled(paramBoolean);
        i += 1;
        continue;
        return;
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      do
      {
        do
        {
          paramCanvas = getContext();
        } while (!(paramCanvas instanceof HippyInstanceContext));
        paramCanvas = ((HippyInstanceContext)paramCanvas).getEngineContext().getGlobalConfigs().getExceptionHandler();
      } while (paramCanvas == null);
      paramCanvas.handleNativeException(new RuntimeException("HippyViewGroup StackOverflowError"), true);
    }
  }
  
  public void hippySwitchSkin()
  {
    this.mHippyTKDSkinHandler.switchSkin(this);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnSizeChangeListener != null) {
      this.mOnSizeChangeListener.onHippyViewGroupSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (this.disableExternalScoll > 0)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label27;
      }
      changeExternalScrollEnabled(false);
    }
    label27:
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1)) {
      return bool;
    }
    changeExternalScrollEnabled(true);
    return bool;
  }
  
  public void resetProps()
  {
    super.resetProps();
    this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
    this.mOnSizeChangeListener = null;
  }
  
  public void setBackgroundColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBackgroundColors(this, paramHippyArray);
  }
  
  public void setBorderBottomColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderBottomColors(this, paramHippyArray);
  }
  
  public void setBorderColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderColors(this, paramHippyArray);
  }
  
  public void setBorderLeftColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderLeftColors(this, paramHippyArray);
  }
  
  public void setBorderRightColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderRightColors(this, paramHippyArray);
  }
  
  public void setBorderTopColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderTopColors(this, paramHippyArray);
  }
  
  public void setDisableExternalScroll(int paramInt)
  {
    this.disableExternalScoll = paramInt;
  }
  
  public void setOnSizeChangedListener(HippyTKDViewGroup.OnSizeChangeListener paramOnSizeChangeListener)
  {
    this.mOnSizeChangeListener = paramOnSizeChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroup
 * JD-Core Version:    0.7.0.1
 */
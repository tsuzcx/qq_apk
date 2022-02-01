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
  private int disableExternalScoll = 0;
  HippyTKDSkinHandler mHippyTKDSkinHandler = new HippyTKDSkinHandler();
  private HippyTKDViewGroup.OnSizeChangeListener mOnSizeChangeListener;
  
  public HippyTKDViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public void changeExternalScrollEnabled(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    int j;
    for (int i = 0; (localViewParent != null) && (i < this.disableExternalScoll); i = j)
    {
      if ((localViewParent instanceof HippyScrollView)) {
        ((HippyScrollView)localViewParent).setScrollEnabled(paramBoolean);
      }
      for (;;)
      {
        j = i + 1;
        break;
        if ((localViewParent instanceof HippyListView))
        {
          ((HippyListView)localViewParent).setScrollEnable(paramBoolean);
        }
        else
        {
          j = i;
          if (!(localViewParent instanceof HippyViewPager)) {
            break;
          }
          ((HippyViewPager)localViewParent).setScrollEnabled(paramBoolean);
        }
      }
      localViewParent = localViewParent.getParent();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      label6:
      break label6;
    }
    paramCanvas = getContext();
    if ((paramCanvas instanceof HippyInstanceContext))
    {
      paramCanvas = ((HippyInstanceContext)paramCanvas).getEngineContext().getGlobalConfigs().getExceptionHandler();
      if (paramCanvas != null) {
        paramCanvas.handleNativeException(new RuntimeException("HippyViewGroup StackOverflowError"), true);
      }
    }
  }
  
  public void hippySwitchSkin()
  {
    this.mHippyTKDSkinHandler.switchSkin(this);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    HippyTKDViewGroup.OnSizeChangeListener localOnSizeChangeListener = this.mOnSizeChangeListener;
    if (localOnSizeChangeListener != null) {
      localOnSizeChangeListener.onHippyViewGroupSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (this.disableExternalScoll > 0)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        changeExternalScrollEnabled(false);
        return bool;
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
        changeExternalScrollEnabled(true);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroup
 * JD-Core Version:    0.7.0.1
 */
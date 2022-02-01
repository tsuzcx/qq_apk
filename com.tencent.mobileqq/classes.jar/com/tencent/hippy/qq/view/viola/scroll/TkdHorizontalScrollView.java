package com.tencent.hippy.qq.view.viola.scroll;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView;

public class TkdHorizontalScrollView
  extends HippyHorizontalScrollView
  implements TkdScrollView
{
  private boolean mIsLoading = false;
  private float mLastScrollX = 0.0F;
  private int mPreloadDistance = 0;
  
  public TkdHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
    this.mScrollMinOffset = ((int)PixelUtil.dp2px(5.0F));
  }
  
  private void setLoadMoreState(boolean paramBoolean)
  {
    this.mIsLoading = paramBoolean;
  }
  
  private boolean shouldEmitEndReachedEvent(int paramInt1, int paramInt2)
  {
    int i = getWidth();
    int j = getWidth();
    if (getChildCount() > 0) {
      i = getChildAt(0).getWidth();
    }
    if (i > j)
    {
      int k = this.mPreloadDistance;
      if (i < k) {
        return true;
      }
      return (paramInt1 > 0) && (paramInt1 > paramInt2) && (j + paramInt1 >= i - k);
    }
    return true;
  }
  
  private boolean shouldEmitStartReachedEvent(int paramInt1, int paramInt2)
  {
    return (paramInt1 < paramInt2) && (paramInt1 < this.mPreloadDistance);
  }
  
  public void callLoadMoreFinish()
  {
    setLoadMoreState(false);
  }
  
  public void callScrollToPosition(int paramInt1, int paramInt2, Promise paramPromise)
  {
    paramInt1 = getScrollX() + paramInt1;
    Object localObject;
    if (paramInt2 <= 0)
    {
      scrollTo(paramInt1, 0);
      if (paramPromise != null)
      {
        localObject = new HippyMap();
        ((HippyMap)localObject).pushString("msg", "on scroll end!");
        paramPromise.resolve(localObject);
      }
    }
    else
    {
      localObject = ObjectAnimator.ofInt(this, "scrollX", new int[] { paramInt1 });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this, "scrollY", new int[] { 0 });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(paramInt2);
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.addListener(new TkdHorizontalScrollView.1(this, paramPromise));
      localAnimatorSet.start();
    }
  }
  
  public void callScrollToTop(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      smoothScrollTo(0, 0);
      return;
    }
    scrollTo(0, 0);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mPreloadDistance > 0) && (!this.mIsLoading))
    {
      if (shouldEmitEndReachedEvent(paramInt1, paramInt3))
      {
        TkdScrollViewEventHelper.emitScrollEndReachedEvent(this);
        setLoadMoreState(true);
        return;
      }
      if (shouldEmitStartReachedEvent(paramInt1, paramInt3))
      {
        TkdScrollViewEventHelper.emitScrollStartReachedEvent(this);
        setLoadMoreState(true);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() & 0xFF) == 2) && (!this.mIsLoading)) {
      if (getScrollX() == 0)
      {
        if (this.mLastScrollX == 0.0F)
        {
          this.mLastScrollX = paramMotionEvent.getX();
        }
        else if (paramMotionEvent.getX() > this.mLastScrollX)
        {
          TkdScrollViewEventHelper.emitScrollStartReachedEvent(this);
          setLoadMoreState(true);
          this.mLastScrollX = 0.0F;
        }
      }
      else if (getChildCount() > 0)
      {
        int i = getChildAt(0).getWidth();
        if (getScrollX() + getWidth() >= i - 2) {
          if (this.mLastScrollX == 0.0F)
          {
            this.mLastScrollX = paramMotionEvent.getX();
          }
          else if (paramMotionEvent.getX() < this.mLastScrollX)
          {
            TkdScrollViewEventHelper.emitScrollEndReachedEvent(this);
            setLoadMoreState(true);
            this.mLastScrollX = 0.0F;
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPreloadDistance(int paramInt)
  {
    this.mPreloadDistance = ((int)PixelUtil.dp2px(Math.max(0, paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.scroll.TkdHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

public abstract class BaseChatItemLayoutViewBasicAbility
{
  public static final int INVALID = 0;
  protected View mView;
  
  public BaseChatItemLayoutViewBasicAbility(View paramView)
  {
    this.mView = paramView;
  }
  
  public boolean checkViewNonNull()
  {
    return this.mView != null;
  }
  
  public int getHeight()
  {
    return this.mView.getHeight();
  }
  
  public int getId()
  {
    return this.mView.getId();
  }
  
  public ViewGroup.LayoutParams getLayoutParams()
  {
    return this.mView.getLayoutParams();
  }
  
  public void getLocationOnScreen(int[] paramArrayOfInt)
  {
    this.mView.getLocationOnScreen(paramArrayOfInt);
  }
  
  public int getMeasuredHeight()
  {
    return this.mView.getMeasuredHeight();
  }
  
  public int getMeasuredWidth()
  {
    return this.mView.getMeasuredWidth();
  }
  
  public int getTop()
  {
    return this.mView.getTop();
  }
  
  public int getViewVisibility()
  {
    return this.mView.getVisibility();
  }
  
  public void post(Runnable paramRunnable)
  {
    this.mView.post(paramRunnable);
  }
  
  public void setAccessibilityDelegate(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.mView.setAccessibilityDelegate(paramAccessibilityDelegate);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.mView.setContentDescription(paramCharSequence);
  }
  
  public abstract void setData(Object... paramVarArgs);
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mView.setLayoutParams(paramLayoutParams);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mView.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void setOnTouchEvent(View.OnTouchListener paramOnTouchListener)
  {
    this.mView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    this.mView.setTag(paramInt, paramObject);
  }
  
  public void setTag(Object paramObject)
  {
    this.mView.setTag(paramObject);
  }
  
  public void setViewVisibility(int paramInt)
  {
    this.mView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

public abstract class NickNameExtenderViewBasicAbility
{
  protected View mView;
  
  public NickNameExtenderViewBasicAbility(View paramView)
  {
    this.mView = paramView;
  }
  
  public boolean checkViewNonNull()
  {
    return this.mView != null;
  }
  
  public ViewGroup.LayoutParams getLayoutParams()
  {
    if (checkViewNonNull()) {
      return this.mView.getLayoutParams();
    }
    return null;
  }
  
  public int getViewVisibility()
  {
    if (checkViewNonNull()) {
      return this.mView.getVisibility();
    }
    return 8;
  }
  
  public void setAccessibilityDelegate(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    if (checkViewNonNull()) {
      this.mView.setAccessibilityDelegate(paramAccessibilityDelegate);
    }
  }
  
  public abstract void setData(Object... paramVarArgs);
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (checkViewNonNull()) {
      this.mView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (checkViewNonNull()) {
      this.mView.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void setOnTouchEvent(View.OnTouchListener paramOnTouchListener)
  {
    if (checkViewNonNull()) {
      this.mView.setOnTouchListener(paramOnTouchListener);
    }
  }
  
  public void setTag(Object paramObject)
  {
    if (checkViewNonNull()) {
      this.mView.setTag(paramObject);
    }
  }
  
  public void setViewVisibility(int paramInt)
  {
    if (checkViewNonNull()) {
      this.mView.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility
 * JD-Core Version:    0.7.0.1
 */
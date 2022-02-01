package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.util.MqqWeakReferenceHandler;

public class SimpleCheckableSlidingIndicator
  extends SimpleSlidingIndicator
{
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  static int e = 1;
  private MqqWeakReferenceHandler B;
  private SimpleCheckableSlidingIndicator.ScrollViewListener C;
  private int D = -9999999;
  private int E = b;
  SimpleCheckableSlidingIndicator.OnRepeatClickListener a;
  Handler.Callback f = new SimpleCheckableSlidingIndicator.2(this);
  
  public SimpleCheckableSlidingIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SimpleCheckableSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    if (this.i != this.h)
    {
      Object localObject = this.g.getChildAt(this.i);
      View localView = this.g.getChildAt(this.h);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new SimpleCheckableSlidingIndicator.1(this));
        ((ValueAnimator)localObject).start();
        return;
      }
      if (localView != null)
      {
        this.z = localView.getLeft();
        invalidate();
      }
    }
    else
    {
      this.z = this.g.getChildAt(this.h).getLeft();
      invalidate();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.h != paramInt)
    {
      this.i = this.h;
      this.h = paramInt;
      setChooseTabViewTextColor(paramInt);
      b(this.h);
      if (paramBoolean1)
      {
        a();
      }
      else
      {
        View localView = this.g.getChildAt(this.h);
        if (localView != null) {
          this.z = localView.getLeft();
        }
        invalidate();
      }
      if ((this.s != null) && (paramInt >= 0)) {
        this.s.a(paramInt, paramBoolean2);
      }
    }
  }
  
  public int[] getTabViewIds()
  {
    return this.k;
  }
  
  public String[] getTextList()
  {
    return this.j;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (i != 1)
    {
      if (i == 2)
      {
        this.E = c;
        localObject = this.C;
        if (localObject != null) {
          ((SimpleCheckableSlidingIndicator.ScrollViewListener)localObject).a(this.E);
        }
        localObject = this.B;
        if (localObject != null) {
          ((MqqWeakReferenceHandler)localObject).removeMessages(e);
        }
      }
    }
    else
    {
      localObject = this.B;
      if (localObject != null) {
        ((MqqWeakReferenceHandler)localObject).sendEmptyMessage(e);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnRepeatClickListener(SimpleCheckableSlidingIndicator.OnRepeatClickListener paramOnRepeatClickListener)
  {
    this.a = paramOnRepeatClickListener;
  }
  
  public void setScrollViewListener(SimpleCheckableSlidingIndicator.ScrollViewListener paramScrollViewListener)
  {
    if (this.B == null) {
      this.B = new MqqWeakReferenceHandler(this.f);
    }
    this.C = paramScrollViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */
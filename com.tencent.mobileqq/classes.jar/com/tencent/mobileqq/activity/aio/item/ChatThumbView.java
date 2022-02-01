package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;

public class ChatThumbView
  extends URLImageView
  implements BaseBubbleBuilder.TouchDelegate
{
  private boolean a;
  public boolean b;
  public boolean c = true;
  
  public ChatThumbView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChatThumbView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChatThumbView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      paramView = getDrawable();
      if (paramView != null)
      {
        paramView.setColorFilter(null);
        paramView.invalidateSelf();
      }
    }
    else
    {
      paramView = getDrawable();
      if (paramView != null) {
        paramView.setColorFilter(BaseBubbleBuilder.n);
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (!this.c) {
      return;
    }
    this.a = (paramBoolean ^ true);
    if (paramBoolean) {
      paramView = null;
    } else {
      paramView = BaseBubbleBuilder.n;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setFadeInImage(false);
    if (this.b)
    {
      paramURLDrawable = new AlphaAnimation(0.0F, 1.0F);
      paramURLDrawable.setDuration(100L);
      startAnimation(paramURLDrawable);
      invalidate();
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (BaseBubbleBuilder.m)
    {
      int m = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      int n = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getSize(paramInt2);
      int i;
      if (m != -2147483648)
      {
        i = paramInt1;
        if (m != 1073741824) {}
      }
      else
      {
        i = paramInt1;
        if (n <= 0) {
          i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
      }
      if (j != -2147483648)
      {
        paramInt1 = paramInt2;
        if (j != 1073741824) {}
      }
      else
      {
        paramInt1 = paramInt2;
        if (k <= 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
      }
      super.onMeasure(i, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    Drawable localDrawable;
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (!this.a))
      {
        localDrawable = getDrawable();
        if (localDrawable != null)
        {
          localDrawable.setColorFilter(null);
          localDrawable.invalidateSelf();
        }
      }
    }
    else
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {
        localDrawable.setColorFilter(BaseBubbleBuilder.n);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ChatThumbView
 * JD-Core Version:    0.7.0.1
 */
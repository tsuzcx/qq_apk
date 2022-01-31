package com.tencent.mobileqq.activity.aio.item;

import aels;
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

public class ChatThumbView
  extends URLImageView
  implements aels
{
  public boolean a;
  public boolean b = true;
  private boolean c;
  
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
    if (!this.b) {}
    do
    {
      do
      {
        return;
        switch (paramMotionEvent.getAction())
        {
        case 2: 
        default: 
          return;
        case 0: 
          paramView = getDrawable();
        }
      } while (paramView == null);
      paramView.setColorFilter(BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter);
      return;
      paramView = getDrawable();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (!this.b) {
      return;
    }
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      label14:
      this.c = bool;
      if (!paramBoolean) {
        break label53;
      }
    }
    label53:
    for (paramView = null;; paramView = BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      Drawable localDrawable = getDrawable();
      if (localDrawable == null) {
        break;
      }
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
      bool = false;
      break label14;
    }
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setFadeInImage(false);
    if (this.jdField_a_of_type_Boolean)
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
    if (BaseBubbleBuilder.jdField_a_of_type_Boolean)
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
    if (!this.b) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      Drawable localDrawable = getDrawable();
      if (localDrawable != null)
      {
        localDrawable.setColorFilter(BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter);
        continue;
        if (!this.c)
        {
          localDrawable = getDrawable();
          if (localDrawable != null)
          {
            localDrawable.setColorFilter(null);
            localDrawable.invalidateSelf();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ChatThumbView
 * JD-Core Version:    0.7.0.1
 */
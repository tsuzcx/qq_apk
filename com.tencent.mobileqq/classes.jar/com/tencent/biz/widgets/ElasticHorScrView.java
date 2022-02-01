package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class ElasticHorScrView
  extends HorizontalScrollView
{
  protected final double a;
  protected float a;
  protected final int a;
  protected Rect a;
  protected View a;
  protected ViewGroup a;
  protected boolean a;
  protected int b;
  protected boolean b;
  
  public ElasticHorScrView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_Double = 2.5D;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public ElasticHorScrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_Double = 2.5D;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidGraphicsRect.left, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewView.setAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.jdField_b_of_type_Boolean = false;
        }
        float f1 = this.jdField_a_of_type_Float;
        float f2 = paramMotionEvent.getX();
        double d = f1 - f2;
        Double.isNaN(d);
        i = (int)(d / 2.5D);
        this.jdField_a_of_type_Float = f2;
        if (b())
        {
          if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
            this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom());
          }
          int j = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
          int k = getWidth();
          int m = getScrollX();
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("inner.getLeft()");
          paramMotionEvent.append(this.jdField_a_of_type_AndroidViewView.getLeft());
          paramMotionEvent.append("distanceX");
          paramMotionEvent.append(i);
          paramMotionEvent.append("inner.getRight()");
          paramMotionEvent.append(this.jdField_a_of_type_AndroidViewView.getRight());
          Log.v("test", paramMotionEvent.toString());
          if (((m == 0) && (i < 0)) || ((j - k == m) && (i > 0)))
          {
            paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
            paramMotionEvent.layout(paramMotionEvent.getLeft() - i, this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight() - i, this.jdField_a_of_type_AndroidViewView.getBottom());
          }
        }
        else
        {
          scrollBy(i, 0);
        }
      }
      else
      {
        if (a()) {
          a();
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
    else {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.isEmpty() ^ true;
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    int j = getWidth();
    int k = getScrollX();
    return (k == 0) || (i - j == k);
  }
  
  protected void onFinishInflate()
  {
    if ((getChildCount() > 0) && ((getChildAt(0) instanceof ViewGroup))) {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(0));
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() > 0) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0);
    }
    super.onFinishInflate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMove(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ElasticHorScrView
 * JD-Core Version:    0.7.0.1
 */
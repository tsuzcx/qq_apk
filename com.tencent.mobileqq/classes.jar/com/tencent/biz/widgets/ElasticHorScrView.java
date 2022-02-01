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
  protected boolean b = true;
  
  public ElasticHorScrView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_Double = 2.5D;
  }
  
  public ElasticHorScrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_Double = 2.5D;
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
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      return;
      if (a()) {
        a();
      }
      this.b = true;
      return;
      if (this.b)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.b = false;
      }
      float f1 = this.jdField_a_of_type_Float;
      float f2 = paramMotionEvent.getX();
      i = (int)((f1 - f2) / 2.5D);
      this.jdField_a_of_type_Float = f2;
      if (!b()) {
        break;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
        this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight(), this.jdField_a_of_type_AndroidViewView.getBottom());
      }
      j = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
      k = getWidth();
      m = getScrollX();
      Log.v("test", "inner.getLeft()" + this.jdField_a_of_type_AndroidViewView.getLeft() + "distanceX" + i + "inner.getRight()" + this.jdField_a_of_type_AndroidViewView.getRight());
    } while (((m != 0) || (i >= 0)) && ((j - k != m) || (i <= 0)));
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft() - i, this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getRight() - i, this.jdField_a_of_type_AndroidViewView.getBottom());
    return;
    scrollBy(i, 0);
  }
  
  private boolean a()
  {
    return !this.jdField_a_of_type_AndroidGraphicsRect.isEmpty();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ElasticHorScrView
 * JD-Core Version:    0.7.0.1
 */
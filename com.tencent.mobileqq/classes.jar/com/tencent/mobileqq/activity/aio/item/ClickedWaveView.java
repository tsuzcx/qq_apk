package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ClickedWaveView
  extends ImageView
{
  static final int jdField_a_of_type_Int = AIOUtils.b(0.01F, BaseApplicationImpl.getContext().getResources());
  static final int b = AIOUtils.b(60.0F, BaseApplicationImpl.getContext().getResources());
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Scroller jdField_a_of_type_AndroidWidgetScroller = null;
  ClickedWaveView.MovingRadiusRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$MovingRadiusRunnable = new ClickedWaveView.MovingRadiusRunnable(this);
  ClickedWaveView.OnTouchReceive jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$OnTouchReceive = null;
  int c = 20;
  int d = 0;
  
  public ClickedWaveView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public ClickedWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public ClickedWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    Paint localPaint = new Paint();
    localPaint.setARGB(this.d, 0, 0, 0);
    if (this.c > i) {
      this.c = i;
    }
    paramCanvas.drawCircle(i, j, this.c, localPaint);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return bool;
      }
      setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((localDrawable != null) && ((localDrawable instanceof CustomFrameAnimationDrawable))) {
        ((CustomFrameAnimationDrawable)localDrawable).d();
      }
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$OnTouchReceive;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.jdField_a_of_type_AndroidOsBundle);
        }
      }
      return bool;
    }
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$OnTouchReceive;
    if (paramMotionEvent != null) {
      paramMotionEvent.a();
    }
    paramMotionEvent = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((paramMotionEvent != null) && ((paramMotionEvent instanceof CustomFrameAnimationDrawable))) {
      ((CustomFrameAnimationDrawable)paramMotionEvent).unscheduleSelf((Runnable)paramMotionEvent);
    }
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(jdField_a_of_type_Int, 0, b, 0, 900);
    this.c = jdField_a_of_type_Int;
    this.d = 30;
    PokeItemHelper.a(this, this.jdField_a_of_type_AndroidOsBundle.getInt("type"), this.jdField_a_of_type_AndroidOsBundle.getInt("id"));
    postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$MovingRadiusRunnable, 20L);
    return true;
  }
  
  public void setCustomDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setExtraInfo(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void setOnTouchReceive(ClickedWaveView.OnTouchReceive paramOnTouchReceive)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemClickedWaveView$OnTouchReceive = paramOnTouchReceive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ClickedWaveView
 * JD-Core Version:    0.7.0.1
 */
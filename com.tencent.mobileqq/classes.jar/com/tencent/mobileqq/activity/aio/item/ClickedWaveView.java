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
  static final int a = AIOUtils.b(0.01F, BaseApplicationImpl.getContext().getResources());
  static final int b = AIOUtils.b(60.0F, BaseApplicationImpl.getContext().getResources());
  int c = 20;
  int d = 0;
  Scroller e = null;
  Drawable f = null;
  ClickedWaveView.OnTouchReceive g = null;
  ClickedWaveView.MovingRadiusRunnable h = new ClickedWaveView.MovingRadiusRunnable(this);
  private Bundle i;
  
  public ClickedWaveView(Context paramContext)
  {
    super(paramContext);
    this.e = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public ClickedWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public ClickedWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = new Scroller(paramContext, new DecelerateInterpolator());
  }
  
  public Bundle getExtraInfo()
  {
    return this.i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getWidth() / 2;
    int k = getHeight() / 2;
    Paint localPaint = new Paint();
    localPaint.setARGB(this.d, 0, 0, 0);
    if (this.c > j) {
      this.c = j;
    }
    paramCanvas.drawCircle(j, k, this.c, localPaint);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if ((j != 1) && (j != 3)) {
        return bool;
      }
      setImageDrawable(this.f);
      Drawable localDrawable = this.f;
      if ((localDrawable != null) && ((localDrawable instanceof CustomFrameAnimationDrawable))) {
        ((CustomFrameAnimationDrawable)localDrawable).d();
      }
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = this.g;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.i);
        }
      }
      return bool;
    }
    paramMotionEvent = this.g;
    if (paramMotionEvent != null) {
      paramMotionEvent.a();
    }
    paramMotionEvent = this.f;
    if ((paramMotionEvent != null) && ((paramMotionEvent instanceof CustomFrameAnimationDrawable))) {
      ((CustomFrameAnimationDrawable)paramMotionEvent).unscheduleSelf((Runnable)paramMotionEvent);
    }
    this.e.startScroll(a, 0, b, 0, 900);
    this.c = a;
    this.d = 30;
    PokeItemHelper.a(this, this.i.getInt("type"), this.i.getInt("id"));
    postDelayed(this.h, 20L);
    return true;
  }
  
  public void setCustomDrawable(Drawable paramDrawable)
  {
    this.f = paramDrawable;
  }
  
  public void setExtraInfo(Bundle paramBundle)
  {
    this.i = paramBundle;
  }
  
  public void setOnTouchReceive(ClickedWaveView.OnTouchReceive paramOnTouchReceive)
  {
    this.g = paramOnTouchReceive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ClickedWaveView
 * JD-Core Version:    0.7.0.1
 */
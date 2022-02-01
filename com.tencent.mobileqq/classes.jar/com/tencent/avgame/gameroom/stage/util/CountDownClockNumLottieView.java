package com.tencent.avgame.gameroom.stage.util;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class CountDownClockNumLottieView
  extends ImageView
  implements IBaseCountDownClockView
{
  ValueAnimator a;
  LottieDrawable b;
  Handler c = new Handler(Looper.getMainLooper());
  private int d;
  private int e;
  private Paint f = new Paint();
  private int g = 0;
  private long h;
  private float i;
  private long j;
  private IBaseCountDownClockView.OnCountDownListener k;
  private final int l = 360;
  private float m = 0.0666667F;
  private boolean n = true;
  
  public CountDownClockNumLottieView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public CountDownClockNumLottieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public CountDownClockNumLottieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.d / 2, this.e / 2);
    String str = String.valueOf(this.h);
    float f1 = this.f.measureText(str);
    float f2 = Math.abs(this.f.ascent() + this.f.descent()) / 2.0F;
    paramCanvas.drawText(str, -f1 / 2.0F, f2, this.f);
    paramCanvas.restore();
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    this.n = true;
    if (paramLong2 > paramLong1) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    long l1 = paramLong1 - paramLong2;
    this.j = (paramLong1 / 1000L);
    long l2 = this.j;
    this.m = (1.0F / ((float)l2 + 0.5F));
    this.i = (360.0F / (float)l2);
    double d1 = 360L * paramLong2;
    Double.isNaN(d1);
    double d2 = paramLong1;
    Double.isNaN(d2);
    this.a = ValueAnimator.ofFloat(new float[] { (int)(d1 * 1.0D / d2), 360.0F }).setDuration(l1);
    this.a.setInterpolator(new LinearInterpolator());
    this.a.addUpdateListener(new CountDownClockNumLottieView.2(this));
    ValueAnimatorUtil.a();
    this.a.start();
    float f1 = (float)paramLong2 * 1.0F / (float)paramLong1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start-> mLottieSpeed = ");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(",duration=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("passProgress=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(" totalTime");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("CountDownClockNumLottieView", 2, ((StringBuilder)localObject).toString());
    }
    a(this.m, true, f1);
    setVisibility(0);
  }
  
  private void c()
  {
    this.f.setFlags(1);
    this.f.setColor(-1);
    this.f.setTextSize(ViewUtils.dip2px(18.0F));
    b();
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.g = 0;
    this.h = 0L;
    this.i = 0.0F;
    a(this.m, false, 0.0F);
    this.c.removeCallbacksAndMessages(null);
    invalidate();
  }
  
  public void a(float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CountDownClockNumLottieView", 2, "playSongPlayingLottieDrawable run");
    }
    LottieDrawable localLottieDrawable = this.b;
    if (localLottieDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CountDownClockNumLottieView", 2, "playSongPlayingLottieDrawable lottieDrawable = null");
      }
      return;
    }
    if (localLottieDrawable.isRunning()) {
      this.b.stop();
    }
    this.b.setSpeed(paramFloat1);
    if (paramBoolean)
    {
      this.b.setMinProgress(paramFloat2);
      this.b.setRepeatCount(-1);
      setImageDrawable(this.b);
      this.b.start();
      return;
    }
    this.b.setMinProgress(0.0F);
    this.b.setProgress(paramFloat2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.b != null)
    {
      b(paramLong1, paramLong2);
      return;
    }
    setVisibility(4);
    this.c.postDelayed(new CountDownClockNumLottieView.1(this, paramLong1, paramLong2), 500L);
  }
  
  public void b()
  {
    if (this.b == null) {
      AVGameLottieHelper.a(getContext(), "avgame_topic_cj_count_down_clock/data.json", "avgame_topic_cj_count_down_clock/images/", 80, 80, new CountDownClockNumLottieView.3(this));
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.d;
    if ((paramInt3 == 0) || (paramInt3 != paramInt1))
    {
      this.d = paramInt1;
      this.e = paramInt2;
    }
  }
  
  public void setOnTimeEndListener(IBaseCountDownClockView.OnCountDownListener paramOnCountDownListener)
  {
    this.k = paramOnCountDownListener;
  }
  
  public void setParams(int paramInt1, int paramInt2)
  {
    this.f.setColor(paramInt1);
    this.f.setTextSize(paramInt2);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 4) || (paramInt == 8)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.util.CountDownClockNumLottieView
 * JD-Core Version:    0.7.0.1
 */
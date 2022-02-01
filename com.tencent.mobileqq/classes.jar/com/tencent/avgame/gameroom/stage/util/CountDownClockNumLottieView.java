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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private IBaseCountDownClockView.OnCountDownListener jdField_a_of_type_ComTencentAvgameGameroomStageUtilIBaseCountDownClockView$OnCountDownListener;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 0.0666667F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c = 0;
  private final int d = 360;
  
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
    paramCanvas.translate(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2);
    String str = String.valueOf(this.jdField_a_of_type_Long);
    float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
    float f2 = Math.abs(this.jdField_a_of_type_AndroidGraphicsPaint.ascent() + this.jdField_a_of_type_AndroidGraphicsPaint.descent()) / 2.0F;
    paramCanvas.drawText(str, -f1 / 2.0F, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramLong2 > paramLong1) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    long l1 = paramLong1 - paramLong2;
    this.jdField_b_of_type_Long = (paramLong1 / 1000L);
    long l2 = this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Float = (1.0F / ((float)l2 + 0.5F));
    this.jdField_a_of_type_Float = (360.0F / (float)l2);
    double d1 = 360L * paramLong2;
    Double.isNaN(d1);
    double d2 = paramLong1;
    Double.isNaN(d2);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { (int)(d1 * 1.0D / d2), 360.0F }).setDuration(l1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new CountDownClockNumLottieView.2(this));
    ValueAnimatorUtil.a();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    float f = (float)paramLong2 * 1.0F / (float)paramLong1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start-> mLottieSpeed = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
      ((StringBuilder)localObject).append(",duration=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("passProgress=");
      ((StringBuilder)localObject).append(f);
      ((StringBuilder)localObject).append(" totalTime");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("CountDownClockNumLottieView", 2, ((StringBuilder)localObject).toString());
    }
    a(this.jdField_b_of_type_Float, true, f);
    setVisibility(0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFlags(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(ViewUtils.a(18.0F));
    b();
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.c = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    a(this.jdField_b_of_type_Float, false, 0.0F);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    invalidate();
  }
  
  public void a(float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CountDownClockNumLottieView", 2, "playSongPlayingLottieDrawable run");
    }
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CountDownClockNumLottieView", 2, "playSongPlayingLottieDrawable lottieDrawable = null");
      }
      return;
    }
    if (localLottieDrawable.isRunning()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setSpeed(paramFloat1);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setMinProgress(paramFloat2);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(-1);
      setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.start();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setMinProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(paramFloat2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      b(paramLong1, paramLong2);
      return;
    }
    setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CountDownClockNumLottieView.1(this, paramLong1, paramLong2), 500L);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
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
    paramInt3 = this.jdField_a_of_type_Int;
    if ((paramInt3 == 0) || (paramInt3 != paramInt1))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
    }
  }
  
  public void setOnTimeEndListener(IBaseCountDownClockView.OnCountDownListener paramOnCountDownListener)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageUtilIBaseCountDownClockView$OnCountDownListener = paramOnCountDownListener;
  }
  
  public void setParams(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt2);
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
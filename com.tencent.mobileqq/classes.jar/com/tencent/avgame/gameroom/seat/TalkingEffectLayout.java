package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.qphone.base.util.QLog;

public class TalkingEffectLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public TalkingEffectLayout(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public TalkingEffectLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public TalkingEffectLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Bitmap localBitmap = AVGameUtils.a("avgame_pk_player_talking_inner.png");
    if (localBitmap != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localBitmap = AVGameUtils.a("avgame_pk_player_talking_outer.png");
      if (localBitmap == null) {
        break label156;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      addView(this.jdField_a_of_type_AndroidWidgetImageView, new RelativeLayout.LayoutParams(-1, -1));
      addView(this.jdField_b_of_type_AndroidWidgetImageView, new RelativeLayout.LayoutParams(-1, -1));
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838939));
      break;
      label156:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838940));
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.removeAllListeners();
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 0.35F, 0.35F, 0.35F, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "clipPadding", new float[] { this.jdField_a_of_type_Int * 0.0666667F, this.jdField_a_of_type_Int * 0.01111111F, 0.03333334F * this.jdField_a_of_type_Int, this.jdField_a_of_type_Int * 0.01111111F, this.jdField_a_of_type_Int * 0.0666667F });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator2.setDuration(1000L);
    localObjectAnimator3.setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new TalkingEffectLayout.1(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TalkingEffectLayout", 2, "playAnimation animatorSet = " + this.jdField_a_of_type_AndroidAnimationAnimatorSet);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {}
    while (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    float f1 = this.jdField_b_of_type_Float;
    float f2 = this.jdField_a_of_type_Int;
    float f3 = this.jdField_b_of_type_Float;
    float f4 = this.jdField_b_of_type_Int;
    float f5 = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, f1, f2 - f3, f4 - f5);
    this.jdField_a_of_type_Float = (0.1333333F * this.jdField_a_of_type_Int + (0.08888889F * this.jdField_a_of_type_Int - this.jdField_b_of_type_Float));
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.dispatchDraw(paramCanvas);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int != paramInt1))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      d();
    }
  }
  
  public void setAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = paramAnimatorListener;
  }
  
  public void setClipPadding(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.TalkingEffectLayout
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.avgame.util.AVGameUtil;
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
    Bitmap localBitmap = AVGameUtil.a("avgame_pk_player_talking_inner.png");
    if (localBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838699));
    }
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    localBitmap = AVGameUtil.a("avgame_pk_player_talking_outer.png");
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838700));
    }
    addView(this.jdField_a_of_type_AndroidWidgetImageView, new RelativeLayout.LayoutParams(-1, -1));
    addView(this.jdField_b_of_type_AndroidWidgetImageView, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.removeAllListeners();
    }
    localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 0.35F, 0.35F, 0.35F, 0.0F });
    int i = this.jdField_a_of_type_Int;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "clipPadding", new float[] { i * 0.0666667F, i * 0.01111111F, i * 0.03333334F, i * 0.01111111F, i * 0.0666667F });
    ((ObjectAnimator)localObject).setDuration(1000L);
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator2.setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new TalkingEffectLayout.1(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playAnimation animatorSet = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidAnimationAnimatorSet);
      QLog.d("TalkingEffectLayout", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject == null) {
      return;
    }
    if (((AnimatorSet)localObject).isRunning()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void b()
  {
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet == null) {
      return;
    }
    localAnimatorSet.cancel();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    float f1 = this.jdField_b_of_type_Float;
    float f2 = this.jdField_a_of_type_Int;
    float f3 = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, f1, f2 - f1, f3 - f1);
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Float = (i * 0.1333333F + (i * 0.08888889F - this.jdField_b_of_type_Float));
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    f1 = this.jdField_a_of_type_Float;
    localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = this.jdField_a_of_type_Int;
    if ((paramInt3 == 0) || (paramInt3 != paramInt1))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.TalkingEffectLayout
 * JD-Core Version:    0.7.0.1
 */
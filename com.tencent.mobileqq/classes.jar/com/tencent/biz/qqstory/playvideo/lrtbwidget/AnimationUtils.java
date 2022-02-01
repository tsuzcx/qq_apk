package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;

public class AnimationUtils
{
  public static void a(ViewGroup paramViewGroup, @NonNull AnimationParam paramAnimationParam, Animator.AnimatorListener paramAnimatorListener)
  {
    SLog.b("Q.qqstory.playernew.AnimationUtils", "doExitAnimation");
    Object localObject = paramViewGroup.findViewById(2131445137);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131428363);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131449797);
    Drawable localDrawable = paramAnimationParam.a();
    if (localDrawable != null)
    {
      paramViewGroup = new ImageView(paramViewGroup.getContext());
      localViewGroup.addView(paramViewGroup, new RelativeLayout.LayoutParams(-1, -1));
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.setImageDrawable(localDrawable);
    }
    else
    {
      paramViewGroup = null;
    }
    int i = ((View)localObject).getMeasuredWidth();
    int j = ((View)localObject).getMeasuredHeight();
    float f1 = paramAnimationParam.c * 1.0F / i;
    float f2 = paramAnimationParam.d * 1.0F / j;
    localObject = new ValueAnimator();
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, f1 }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, f2 }), PropertyValuesHolder.ofInt("width", new int[] { i, paramAnimationParam.c }), PropertyValuesHolder.ofInt("height", new int[] { j, paramAnimationParam.d }), PropertyValuesHolder.ofFloat("translateX", new float[] { 0.0F, paramAnimationParam.a }), PropertyValuesHolder.ofFloat("translateY", new float[] { 0.0F, paramAnimationParam.b }), PropertyValuesHolder.ofFloat("backgroundAlpha", new float[] { 1.0F, 0.0F }) });
    ((ValueAnimator)localObject).addUpdateListener(new AnimationUtils.1(localViewGroup, localDrawable, paramViewGroup, localImageView));
    ((ValueAnimator)localObject).addListener(new AnimationUtils.2(paramAnimatorListener));
    ((ValueAnimator)localObject).start();
  }
  
  public static void b(ViewGroup paramViewGroup, @NonNull AnimationParam paramAnimationParam, Animator.AnimatorListener paramAnimatorListener)
  {
    SLog.b("Q.qqstory.playernew.AnimationUtils", "doEnterAnimation");
    Object localObject = paramViewGroup.findViewById(2131445137);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131428363);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131449797);
    paramViewGroup = new ImageView(paramViewGroup.getContext());
    localViewGroup.addView(paramViewGroup, 0, new RelativeLayout.LayoutParams(-1, -1));
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup.setImageDrawable(paramAnimationParam.a());
    int i = ((View)localObject).getMeasuredWidth();
    int j = ((View)localObject).getMeasuredHeight();
    float f1 = paramAnimationParam.c * 1.0F / i;
    float f2 = paramAnimationParam.d * 1.0F / j;
    localObject = new ValueAnimator();
    ((ValueAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { f1, 1.0F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { f2, 1.0F }), PropertyValuesHolder.ofInt("width", new int[] { paramAnimationParam.c, i }), PropertyValuesHolder.ofInt("height", new int[] { paramAnimationParam.d, j }), PropertyValuesHolder.ofFloat("translateX", new float[] { paramAnimationParam.a, 0.0F }), PropertyValuesHolder.ofFloat("translateY", new float[] { paramAnimationParam.b, 0.0F }), PropertyValuesHolder.ofFloat("backgroundAlpha", new float[] { 0.0F, 1.0F }) });
    ((ValueAnimator)localObject).addUpdateListener(new AnimationUtils.3(localViewGroup, paramViewGroup, localImageView));
    ((ValueAnimator)localObject).addListener(new AnimationUtils.4(paramAnimatorListener, localViewGroup, paramViewGroup));
    ((ValueAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowBottomPanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hide", "", "onFinishInflate", "show", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowBottomPanel
  extends LinearLayout
{
  public FlashShowBottomPanel(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlashShowBottomPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlashShowBottomPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a()
  {
    if (getVisibility() == 0) {
      return;
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation((Animation)new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F));
    localAnimationSet.setDuration(300L);
    localAnimationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
    setVisibility(0);
    startAnimation((Animation)localAnimationSet);
  }
  
  public final void b()
  {
    if (getVisibility() != 0) {
      return;
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.addAnimation((Animation)new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F));
    localAnimationSet.setDuration(300L);
    localAnimationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
    localAnimationSet.setAnimationListener((Animation.AnimationListener)new FlashShowBottomPanel.hide..inlined.apply.lambda.1(this));
    startAnimation((Animation)localAnimationSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowBottomPanel
 * JD-Core Version:    0.7.0.1
 */
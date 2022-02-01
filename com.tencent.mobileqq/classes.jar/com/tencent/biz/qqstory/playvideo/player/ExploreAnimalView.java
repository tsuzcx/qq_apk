package com.tencent.biz.qqstory.playvideo.player;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class ExploreAnimalView
  extends RelativeLayout
{
  protected LinearLayout a;
  protected EllipsizingTextView b;
  protected TranslateAnimation c;
  protected TranslateAnimation d;
  protected AnimatorSet e;
  protected AlphaAnimation f;
  
  public ExploreAnimalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.inflate(getContext(), 2131628206, this);
    this.a = ((LinearLayout)super.findViewById(2131442754));
    this.b = ((EllipsizingTextView)super.findViewById(2131449730));
  }
  
  public void a()
  {
    TranslateAnimation localTranslateAnimation = this.c;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
    localTranslateAnimation = this.d;
    if (localTranslateAnimation != null) {
      localTranslateAnimation.cancel();
    }
    this.c = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.c.setDuration(200L);
    this.c.setFillAfter(true);
    this.d = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.d.setDuration(300L);
    this.d.setFillAfter(true);
    this.c.setAnimationListener(new ExploreAnimalView.1(this));
    this.d.setAnimationListener(new ExploreAnimalView.2(this));
    this.a.startAnimation(this.c);
  }
  
  @TargetApi(11)
  protected void a(View paramView, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
      paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView.setDuration(1200L);
      paramView.setRepeatCount(-1);
      paramView.setRepeatMode(-1);
      this.e = new AnimatorSet();
      this.e.play(paramView);
      this.e.setStartDelay(paramLong);
      this.e.start();
      return;
    }
    paramView.setVisibility(0);
  }
  
  @TargetApi(11)
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).cancel();
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).cancel();
      this.d = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((AlphaAnimation)localObject).cancel();
      this.f = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.e;
      if (localObject != null)
      {
        ((AnimatorSet)localObject).end();
        this.e.cancel();
      }
    }
  }
  
  public void setText(String paramString)
  {
    EllipsizingTextView localEllipsizingTextView = this.b;
    if (localEllipsizingTextView != null) {
      localEllipsizingTextView.setText(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      a();
      return;
    }
    if (paramInt == 4) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView
 * JD-Core Version:    0.7.0.1
 */
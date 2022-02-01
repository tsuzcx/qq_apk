package com.tencent.biz.videostory.entrancewidget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qphone.base.util.QLog;

public class VSEntranceWidget
{
  private View a;
  private FrameLayout b;
  private ImageView c;
  private ImageView d;
  private volatile boolean e = false;
  
  private Drawable a(String paramString, View paramView)
  {
    return ImageLoader.getInstance().loadImage(paramString, new VSEntranceWidget.1(this, paramView));
  }
  
  private AnimationSet b()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(280L);
    localScaleAnimation.setAnimationListener(new VSEntranceWidget.2(this));
    localAnimationSet.addAnimation(localScaleAnimation);
    return localAnimationSet;
  }
  
  private AnimationSet c()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setStartOffset(2240L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new VSEntranceWidget.3(this));
    localAnimationSet.addAnimation(localScaleAnimation);
    return localAnimationSet;
  }
  
  private AnimationSet d()
  {
    if (this.d != null)
    {
      AnimationSet localAnimationSet = new AnimationSet(false);
      localAnimationSet.setFillAfter(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setInterpolator(new OvershootInterpolator());
      localScaleAnimation.setDuration(440L);
      localScaleAnimation.setStartOffset(400L);
      localScaleAnimation.setAnimationListener(new VSEntranceWidget.4(this));
      localAnimationSet.addAnimation(localScaleAnimation);
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(320L);
      localScaleAnimation.setStartOffset(2400L);
      localAnimationSet.addAnimation(localScaleAnimation);
      return localAnimationSet;
    }
    return null;
  }
  
  public void a()
  {
    if (this.e)
    {
      this.b.setVisibility(0);
      this.a.setAlpha(0.0F);
      this.c.clearAnimation();
      this.c.startAnimation(b());
      this.d.clearAnimation();
      this.d.startAnimation(d());
    }
    else
    {
      this.b.setVisibility(8);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playWidgetAnimationset resourceReady:");
    localStringBuilder.append(this.e);
    QLog.d("Q.videostory.config.VSEntranceWidget", 1, localStringBuilder.toString());
  }
  
  public void a(FrameLayout paramFrameLayout, View paramView, String paramString)
  {
    this.b = paramFrameLayout;
    this.a = paramView;
    paramFrameLayout = VSEntranceWidgetHelper.a().b(paramString);
    if ((paramFrameLayout != null) && (paramFrameLayout.a()))
    {
      this.e = true;
      paramView = a(paramFrameLayout.c, this.b);
      if (paramView != null) {
        this.b.setBackgroundDrawable(paramView);
      }
      this.b.setVisibility(4);
      this.c = ((ImageView)this.b.findViewById(2131430265));
      paramView = a(paramFrameLayout.d, this.c);
      if (paramView != null) {
        this.c.setImageDrawable(paramView);
      }
      this.c.setVisibility(0);
      this.d = ((ImageView)this.b.findViewById(2131450133));
      paramFrameLayout = a(paramFrameLayout.f, this.d);
      if (paramFrameLayout != null) {
        this.d.setImageDrawable(paramFrameLayout);
      }
      this.d.setVisibility(4);
      return;
    }
    QLog.e("Q.videostory.config.VSEntranceWidget", 1, "bindTargetView error!widgetConfig is null or resource not ready!");
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidget
 * JD-Core Version:    0.7.0.1
 */
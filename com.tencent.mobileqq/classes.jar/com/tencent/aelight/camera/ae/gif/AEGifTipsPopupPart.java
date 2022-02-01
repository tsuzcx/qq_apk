package com.tencent.aelight.camera.ae.gif;

import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AEGifTipsPopupPart
  extends VideoStoryBasePart
{
  private static final String[] j = { HardCodeUtil.a(2131886378), HardCodeUtil.a(2131886379), HardCodeUtil.a(2131886380) };
  private static List<String> k = Arrays.asList(new String[] { "Xiaomi_MI 4C" });
  private boolean a;
  private View b;
  private TextView c;
  private View d;
  private Animation e;
  private Animation f;
  private Animation g;
  private boolean h;
  private boolean i;
  private Runnable l;
  
  private String a()
  {
    int m = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    String[] arrayOfString = j;
    return arrayOfString[(m % arrayOfString.length)];
  }
  
  private void a(Runnable paramRunnable)
  {
    QLog.d("AEGifTipsPopupPart", 4, "###  showup tips");
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.5F, 1, 0.0F, 0, this.d.getY() + this.d.getHeight() / 2 - this.b.getY(), 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator(3.0F));
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new AEGifTipsPopupPart.3(this, paramRunnable));
    this.b.startAnimation(localAnimationSet);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (c()) {
      return;
    }
    this.i = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("###  show tips, random = ");
    localStringBuilder.append(paramBoolean1);
    QLog.d("AEGifTipsPopupPart", 4, localStringBuilder.toString());
    if (!this.h) {
      return;
    }
    if (paramBoolean1) {
      this.c.setText(a());
    } else {
      this.c.setText(b());
    }
    if (a(this.e)) {
      return;
    }
    if (a(this.f)) {
      return;
    }
    if (a(this.g))
    {
      this.g.setAnimationListener(null);
      this.g.cancel();
      this.g = null;
    }
    if (this.b == null) {
      return;
    }
    if (paramBoolean2)
    {
      a(new AEGifTipsPopupPart.1(this));
      return;
    }
    d();
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private String b()
  {
    return j[0];
  }
  
  private static boolean c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    return k.contains(localObject);
  }
  
  private void d()
  {
    if (this.i) {
      return;
    }
    this.b.setVisibility(0);
    this.f = new TranslateAnimation(0.0F, 0.0F, 0.0F, 15.0F);
    this.f.setDuration(300L);
    this.f.setRepeatCount(-1);
    this.f.setRepeatMode(2);
    this.f.setAnimationListener(new AEGifTipsPopupPart.2(this));
    this.b.startAnimation(this.f);
  }
  
  private void e()
  {
    QLog.d("AEGifTipsPopupPart", 4, "###  hide tips");
    this.i = true;
    if (a(this.e))
    {
      this.e.setAnimationListener(null);
      this.e.reset();
      this.e = null;
    }
    if (a(this.f))
    {
      this.f.setAnimationListener(null);
      this.f.reset();
      this.f = null;
    }
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((View)localObject).removeCallbacks(this.l);
    if (this.b.getVisibility() != 0) {
      return;
    }
    localObject = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F);
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(3.0F));
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.5F, 1, 0.0F, 0, this.d.getY() + this.d.getHeight() / 2 - this.b.getY());
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator(3.0F));
    ((AnimationSet)localObject).addAnimation(localScaleAnimation);
    ((AnimationSet)localObject).addAnimation(localTranslateAnimation);
    ((AnimationSet)localObject).setAnimationListener(new AEGifTipsPopupPart.4(this));
    this.b.startAnimation((Animation)localObject);
  }
  
  private boolean f()
  {
    if (!this.h) {
      return false;
    }
    return AECameraPrefsUtil.a().b("has_enter_aio_gif", false, 0) ^ true;
  }
  
  private void g()
  {
    if (!this.h) {
      return;
    }
    AECameraPrefsUtil.a().a("has_enter_aio_gif", true, 0);
  }
  
  private void h()
  {
    if (!this.h) {
      return;
    }
    if (c()) {
      return;
    }
    if (!a(this.e))
    {
      if (a(this.f)) {
        return;
      }
      boolean bool = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("###  showIfFirstTimeEnter， first = ");
      localStringBuilder.append(bool);
      QLog.d("AEGifTipsPopupPart", 4, localStringBuilder.toString());
      if (bool)
      {
        a(false, false);
        g();
        return;
      }
      this.a = false;
      this.b.postDelayed(this.l, 5000L);
    }
  }
  
  private void i()
  {
    this.a = false;
    this.b.removeCallbacks(this.l);
    this.b.setVisibility(4);
    if (a(this.e))
    {
      this.e.setAnimationListener(null);
      this.e.cancel();
      this.e = null;
    }
    if (a(this.f))
    {
      this.f.setAnimationListener(null);
      this.f.cancel();
      this.f = null;
    }
    if (a(this.g))
    {
      this.g.setAnimationListener(null);
      this.g.cancel();
      this.g = null;
    }
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    this.d = this.mRootView.findViewById(2063991100);
    this.b = this.mRootView.findViewById(2063991118);
    this.c = ((TextView)this.b.findViewById(2063991119));
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
  }
  
  public void onActivityResume()
  {
    h();
    super.onActivityResume();
  }
  
  public void onDestroy()
  {
    i();
    super.onDestroy();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 786435) {
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGifTipsPopupPart
 * JD-Core Version:    0.7.0.1
 */
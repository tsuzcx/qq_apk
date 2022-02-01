package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.BaseDirector;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector.OnDirectorPrepared;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.lottie.LottieAnimController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.mutualmark.MutualMarkManger;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.os.MqqHandler;

public class LottieAnimDirector
  extends BaseDirector
  implements Animator.AnimatorListener
{
  private LottieDrawable a;
  private LottieAnimController b;
  private String c = "";
  private ImageView d;
  private String e;
  private String f;
  private boolean g = false;
  private boolean h = false;
  
  public LottieAnimDirector(Context paramContext)
  {
    super(paramContext);
    this.b = new LottieAnimController(paramContext);
    this.b.a(new LottieAnimDirector.1(this));
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.c = MutualMarkManger.a(paramQQAppInterface).c(this.e, this.f);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("onResourceReady lottieUrl:");
      paramQQAppInterface.append(this.e);
      paramQQAppInterface.append("  lottieMd5:");
      paramQQAppInterface.append(this.f);
      paramQQAppInterface.append(" mResPath:");
      paramQQAppInterface.append(this.c);
      QLog.i("LottieAnimDirector", 1, paramQQAppInterface.toString());
    }
    if (this.a == null)
    {
      this.a = new LottieDrawable();
      this.a.setImageAssetDelegate(new LottieAnimDirector.3(this));
    }
    try
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.c);
      paramQQAppInterface.append("data.json");
      paramQQAppInterface = new FileInputStream(paramQQAppInterface.toString());
      QLog.i("LottieAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(g(), paramQQAppInterface, new LottieAnimDirector.4(this));
      return;
    }
    catch (IOException paramQQAppInterface)
    {
      label186:
      break label186;
    }
    QLog.e("LottieAnimDirector", 1, "Decode anim json error");
  }
  
  private void a(LottieComposition paramLottieComposition)
  {
    QLog.i("LottieAnimDirector", 1, "decode json success");
    LottieDrawable localLottieDrawable = this.a;
    if ((localLottieDrawable != null) && (paramLottieComposition != null))
    {
      localLottieDrawable.setComposition(paramLottieComposition);
      this.a.loop(false);
      this.a.addAnimatorListener(this);
      if (this.d != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimDirector", 2, "refresh Lottie.d");
        }
        this.d.setImageDrawable(null);
        this.d.setImageDrawable(this.a);
      }
    }
  }
  
  private QQAppInterface i()
  {
    if ((g() != null) && ((g() instanceof BaseActivity))) {
      return ((BaseActivity)g()).app;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "play");
    }
    ThreadManager.getUIHandler().postDelayed(new LottieAnimDirector.5(this), 300L);
  }
  
  public void a(IDirector.OnDirectorPrepared paramOnDirectorPrepared)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "prepare");
    }
    QQAppInterface localQQAppInterface = i();
    if (localQQAppInterface == null)
    {
      paramOnDirectorPrepared.a(false);
      return;
    }
    if (MutualMarkManger.a(localQQAppInterface).b(this.e, this.f))
    {
      a(localQQAppInterface);
      paramOnDirectorPrepared.a(true);
      return;
    }
    MutualMarkManger.a(localQQAppInterface).a(this.e, this.f, new LottieAnimDirector.2(this, paramOnDirectorPrepared));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.f = paramString2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLottieResources url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" md5:");
      localStringBuilder.append(paramString2);
      QLog.d("LottieAnimDirector", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "cancel");
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.a.recycleBitmaps();
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((LottieAnimController)localObject).c();
      this.b.d();
    }
    a(8);
    super.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnPause");
    }
    Object localObject = this.a;
    if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
      this.a.pauseAnimation();
    }
    localObject = this.b;
    if ((localObject != null) && (((LottieAnimController)localObject).b())) {
      this.b.e();
    }
    this.h = false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnResume");
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((LottieDrawable)localObject).resumeAnimation();
    }
    localObject = this.b;
    if ((localObject != null) && (((LottieAnimController)localObject).b())) {
      this.b.f();
    }
    this.h = true;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnDestroy");
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.a.recycleBitmaps();
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((LottieAnimController)localObject).c();
      this.b.d();
    }
    this.a = null;
    this.d = null;
    this.g = true;
    this.h = true;
  }
  
  public int f()
  {
    return 3;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    b();
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector
 * JD-Core Version:    0.7.0.1
 */
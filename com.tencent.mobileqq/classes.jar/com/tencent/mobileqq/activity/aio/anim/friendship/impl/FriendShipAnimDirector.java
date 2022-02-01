package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.BaseDirector;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.IDirector.OnDirectorPrepared;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.friendship.AdditionalAnimController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import mqq.os.MqqHandler;

public class FriendShipAnimDirector
  extends BaseDirector
  implements Animator.AnimatorListener
{
  private static final String[] a = { "images/img_0.png", "images/img_1.png", "images/img_2.png", "images/img_3.png", "images/img_4.png", "images/img_5.png", "images/img_6.png", "images/img_7.png", "images/img_8.png", "images/img_9.png", "images/img_10.png", "images/img_11.png", "images/img_12.png", "images/img_13.png", "images/img_14.png", "images/img_15.png", "data.json", "icon_close.png" };
  private LottieDrawable b;
  private AdditionalAnimController c;
  private String d = "";
  private ImageView e;
  
  public FriendShipAnimDirector(Context paramContext)
  {
    super(paramContext);
    this.c = new AdditionalAnimController(paramContext);
    this.c.a(new FriendShipAnimDirector.1(this));
  }
  
  private void a(LottieComposition paramLottieComposition)
  {
    QLog.i("FriendShipAnimDirector", 1, "decode json success");
    LottieDrawable localLottieDrawable = this.b;
    if ((localLottieDrawable != null) && (paramLottieComposition != null))
    {
      localLottieDrawable.setComposition(paramLottieComposition);
      this.b.loop(false);
      this.b.addAnimatorListener(this);
      if (this.e != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendShipAnimDirector", 2, "refresh Lottie.d");
        }
        this.e.setImageDrawable(null);
        this.e.setImageDrawable(this.b);
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "begin checkRes");
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkRes: ");
        localStringBuilder.append(str);
        QLog.d("FriendShipAnimDirector", 2, localStringBuilder.toString());
      }
      if (!FileUtils.fileExists(str))
      {
        paramString = new StringBuilder();
        paramString.append("checkRes failed, ");
        paramString.append(str);
        paramString.append(" is not exist");
        QLog.e("FriendShipAnimDirector", 1, paramString.toString());
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "play");
    }
    ThreadManager.getUIHandler().postDelayed(new FriendShipAnimDirector.4(this), 300L);
  }
  
  public void a(IDirector.OnDirectorPrepared paramOnDirectorPrepared)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "prepare");
    }
    this.d = HotReactiveHelper.e();
    boolean bool = a(this.d);
    if (!bool) {
      QLog.e("FriendShipAnimDirector", 1, "cannot find anim resource, animation will not show");
    }
    if ((bool) && (this.b == null))
    {
      this.b = new LottieDrawable();
      this.b.setImageAssetDelegate(new FriendShipAnimDirector.2(this));
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("data.json");
      localObject = new FileInputStream(((StringBuilder)localObject).toString());
      QLog.i("FriendShipAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(g(), (InputStream)localObject, new FriendShipAnimDirector.3(this));
    }
    catch (IOException localIOException)
    {
      label142:
      break label142;
    }
    QLog.e("FriendShipAnimDirector", 1, "Decode anim json error");
    super.a(paramOnDirectorPrepared);
    paramOnDirectorPrepared.a(bool);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "cancel");
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.b.recycleBitmaps();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((AdditionalAnimController)localObject).c();
      this.c.d();
    }
    a(8);
    super.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnPause");
    }
    Object localObject = this.b;
    if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
      this.b.pauseAnimation();
    }
    localObject = this.c;
    if ((localObject != null) && (((AdditionalAnimController)localObject).b())) {
      this.c.e();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnResume");
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((LottieDrawable)localObject).resumeAnimation();
    }
    localObject = this.c;
    if ((localObject != null) && (((AdditionalAnimController)localObject).b())) {
      this.c.f();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnDestroy");
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.b.recycleBitmaps();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((AdditionalAnimController)localObject).c();
      this.c.d();
    }
    this.b = null;
    this.e = null;
  }
  
  public int f()
  {
    return 2;
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector
 * JD-Core Version:    0.7.0.1
 */
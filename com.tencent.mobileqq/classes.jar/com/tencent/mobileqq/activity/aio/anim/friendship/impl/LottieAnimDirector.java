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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LottieAnimController jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  
  public LottieAnimDirector(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController = new LottieAnimController(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController.a(new LottieAnimDirector.1(this));
  }
  
  private QQAppInterface a()
  {
    if ((a() != null) && ((a() instanceof BaseActivity))) {
      return ((BaseActivity)a()).app;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = MutualMarkManger.a(paramQQAppInterface).a(this.jdField_b_of_type_JavaLangString, this.c);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("onResourceReady lottieUrl:");
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
      paramQQAppInterface.append("  lottieMd5:");
      paramQQAppInterface.append(this.c);
      paramQQAppInterface.append(" mResPath:");
      paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("LottieAnimDirector", 1, paramQQAppInterface.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = new LottieDrawable();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(new LottieAnimDirector.3(this));
    }
    try
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.append("data.json");
      paramQQAppInterface = new FileInputStream(paramQQAppInterface.toString());
      QLog.i("LottieAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(a(), paramQQAppInterface, new LottieAnimDirector.4(this));
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
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((localLottieDrawable != null) && (paramLottieComposition != null))
    {
      localLottieDrawable.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.loop(false);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.addAnimatorListener(this);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimDirector", 2, "refresh Lottie.d");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      }
    }
  }
  
  public int a()
  {
    return 3;
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
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      paramOnDirectorPrepared.a(false);
      return;
    }
    if (MutualMarkManger.a(localQQAppInterface).a(this.jdField_b_of_type_JavaLangString, this.c))
    {
      a(localQQAppInterface);
      paramOnDirectorPrepared.a(true);
      return;
    }
    MutualMarkManger.a(localQQAppInterface).a(this.jdField_b_of_type_JavaLangString, this.c, new LottieAnimDirector.2(this, paramOnDirectorPrepared));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController;
    if (localObject != null)
    {
      ((LottieAnimController)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController.c();
    }
    a(8);
    super.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnPause");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController;
    if ((localObject != null) && (((LottieAnimController)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController.d();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnResume");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null) {
      ((LottieDrawable)localObject).resumeAnimation();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController;
    if ((localObject != null) && (((LottieAnimController)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController.e();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimDirector", 2, "doOnDestroy");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null)
    {
      ((LottieDrawable)localObject).cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController;
    if (localObject != null)
    {
      ((LottieAnimController)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplLottieLottieAnimController.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector
 * JD-Core Version:    0.7.0.1
 */
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
import mqq.os.MqqHandler;

public class FriendShipAnimDirector
  extends BaseDirector
  implements Animator.AnimatorListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "images/img_0.png", "images/img_1.png", "images/img_2.png", "images/img_3.png", "images/img_4.png", "images/img_5.png", "images/img_6.png", "images/img_7.png", "images/img_8.png", "images/img_9.png", "images/img_10.png", "images/img_11.png", "images/img_12.png", "images/img_13.png", "images/img_14.png", "images/img_15.png", "data.json", "icon_close.png" };
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AdditionalAnimController jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private String jdField_a_of_type_JavaLangString = "";
  
  public FriendShipAnimDirector(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController = new AdditionalAnimController(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.a(new FriendShipAnimDirector.1(this));
  }
  
  private void a(LottieComposition paramLottieComposition)
  {
    QLog.i("FriendShipAnimDirector", 1, "decode json success");
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (paramLottieComposition != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.loop(false);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.addAnimatorListener(this);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendShipAnimDirector", 2, "refresh Lottie.d");
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
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
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      str = paramString + str;
      if (QLog.isColorLevel()) {
        QLog.d("FriendShipAnimDirector", 2, "checkRes: " + str);
      }
      if (!FileUtils.a(str))
      {
        QLog.e("FriendShipAnimDirector", 1, "checkRes failed, " + str + " is not exist");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int a()
  {
    return 2;
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
    this.jdField_a_of_type_JavaLangString = HotReactiveHelper.c();
    boolean bool = a(this.jdField_a_of_type_JavaLangString);
    if (!bool) {
      QLog.e("FriendShipAnimDirector", 1, "cannot find anim resource, animation will not show");
    }
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = new LottieDrawable();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(new FriendShipAnimDirector.2(this));
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString + "data.json");
      QLog.i("FriendShipAnimDirector", 1, "decode anim async");
      LottieComposition.Factory.fromInputStream(a(), localFileInputStream, new FriendShipAnimDirector.3(this));
      super.a(paramOnDirectorPrepared);
      paramOnDirectorPrepared.a(bool);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FriendShipAnimDirector", 1, "Decode anim json error");
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "cancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.c();
    }
    a(8);
    super.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnPause");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.d();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.resumeAnimation();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.e();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendShipAnimDirector", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.recycleBitmaps();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplFriendshipAdditionalAnimController.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    b();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector
 * JD-Core Version:    0.7.0.1
 */
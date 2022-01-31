package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import swb;
import swc;
import swd;

public class FriendProfileCardActivity$ColorScreenLoader
  implements VasManager.CompleteListener, Runnable
{
  public int a;
  public LottieComposition a;
  public ColorScreenConfig a;
  
  public FriendProfileCardActivity$ColorScreenLoader(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ColorScreenConfig paramColorScreenConfig, Object paramObject)
  {
    if (paramColorScreenConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 2, "onComplete, config is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onComplete, anim file is " + paramColorScreenConfig.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenConfig = paramColorScreenConfig;
    try
    {
      paramColorScreenConfig = new FileInputStream(paramColorScreenConfig.jdField_a_of_type_JavaLangString);
      paramObject = new Bundle();
      paramObject.putString("key", "lottie_colorscreen_" + String.valueOf(this.jdField_a_of_type_Int) + "unzip");
      paramObject.putString("path", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getFilesDir().getAbsolutePath() + "/" + "color_screen" + "/" + this.jdField_a_of_type_Int + "/" + "unzip" + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramColorScreenConfig, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.getLottieDrawable(), new swb(this), paramObject, BaseApplicationImpl.sImageCache);
      return;
    }
    catch (FileNotFoundException paramColorScreenConfig)
    {
      QLog.e("ColorScreenManager", 1, "colorScreen", paramColorScreenConfig);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.d == this.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 2, "play : " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.setImageAssetDelegate(new swc(this));
      localswd = new swd(this, this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition.getDuration());
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.setComposition(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.setRepeatCount(this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenConfig.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.addAnimatorListener(localswd);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.addAnimatorUpdateListener(localswd);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.playAnimation();
    }
    while (!QLog.isColorLevel())
    {
      swd localswd;
      return;
    }
    QLog.d("ColorScreenManager", 2, "won't play old anim: " + this.jdField_a_of_type_Int + " because have new anim: " + this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader
 * JD-Core Version:    0.7.0.1
 */
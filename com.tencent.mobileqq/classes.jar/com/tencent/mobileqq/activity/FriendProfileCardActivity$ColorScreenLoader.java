package com.tencent.mobileqq.activity;

import aavs;
import aavt;
import aavu;
import android.os.Bundle;
import aphb;
import bapb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FriendProfileCardActivity$ColorScreenLoader
  implements bapb<aphb>, Runnable
{
  public int a;
  public aphb a;
  public LottieComposition a;
  
  public FriendProfileCardActivity$ColorScreenLoader(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(aphb paramaphb, Object paramObject)
  {
    if ((paramaphb == null) || (!this.this$0.isValidate()))
    {
      QLog.e("ColorScreenManager", 1, "early return, config is " + paramaphb);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onComplete, anim file is " + paramaphb.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Aphb = paramaphb;
    try
    {
      paramaphb = new FileInputStream(paramaphb.jdField_a_of_type_JavaLangString);
      paramObject = new Bundle();
      paramObject.putString("key", "lottie_colorscreen_" + String.valueOf(this.jdField_a_of_type_Int) + "unzip");
      paramObject.putString("path", this.this$0.getFilesDir().getAbsolutePath() + "/" + "color_screen" + "/" + this.jdField_a_of_type_Int + "/" + "unzip" + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(this.this$0, paramaphb, this.this$0.a.getLottieDrawable(), new aavs(this), paramObject, BaseApplicationImpl.sImageCache);
      return;
    }
    catch (FileNotFoundException paramaphb)
    {
      QLog.e("ColorScreenManager", 1, "colorScreen", paramaphb);
    }
  }
  
  public void run()
  {
    if (!this.this$0.isValidate()) {
      QLog.e("ColorScreenManager", 1, "early return, invalid before setComposition");
    }
    do
    {
      return;
      if (this.this$0.d == this.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorScreenManager", 2, "play : " + this.jdField_a_of_type_Int);
        }
        this.this$0.a.cancelAnimation();
        this.this$0.a.setImageAssetDelegate(new aavt(this));
        try
        {
          aavu localaavu = new aavu(this, this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition.getDuration());
          this.this$0.a.setComposition(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition);
          this.this$0.a.setProgress(0.0F);
          this.this$0.a.setRepeatCount(this.jdField_a_of_type_Aphb.jdField_a_of_type_Int);
          this.this$0.a.addAnimatorListener(localaavu);
          this.this$0.a.addAnimatorUpdateListener(localaavu);
          this.this$0.a.setVisibility(0);
          this.this$0.a.playAnimation();
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ColorScreenManager", 1, "", localException);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ColorScreenManager", 2, "won't play old anim: " + this.jdField_a_of_type_Int + " because have new anim: " + this.this$0.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import abfo;
import abfp;
import abfq;
import android.os.Bundle;
import apze;
import bbqy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FriendProfileCardActivity$ColorScreenLoader
  implements bbqy<apze>, Runnable
{
  public int a;
  public apze a;
  public LottieComposition a;
  
  public FriendProfileCardActivity$ColorScreenLoader(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(apze paramapze, Object paramObject)
  {
    if ((paramapze == null) || (!this.this$0.isValidate()))
    {
      QLog.e("ColorScreenManager", 1, "early return, config is " + paramapze);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onComplete, anim file is " + paramapze.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Apze = paramapze;
    try
    {
      paramapze = new FileInputStream(paramapze.jdField_a_of_type_JavaLangString);
      paramObject = new Bundle();
      paramObject.putString("key", "lottie_colorscreen_" + String.valueOf(this.jdField_a_of_type_Int) + "unzip");
      paramObject.putString("path", this.this$0.getFilesDir().getAbsolutePath() + "/" + "color_screen" + "/" + this.jdField_a_of_type_Int + "/" + "unzip" + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(this.this$0, paramapze, this.this$0.a.getLottieDrawable(), new abfo(this), paramObject, BaseApplicationImpl.sImageCache);
      return;
    }
    catch (FileNotFoundException paramapze)
    {
      QLog.e("ColorScreenManager", 1, "colorScreen", paramapze);
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
      if (this.this$0.b == this.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorScreenManager", 2, "play : " + this.jdField_a_of_type_Int);
        }
        this.this$0.a.cancelAnimation();
        this.this$0.a.setImageAssetDelegate(new abfp(this));
        try
        {
          abfq localabfq = new abfq(this, this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition.getDuration());
          this.this$0.a.setComposition(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition);
          this.this$0.a.setProgress(0.0F);
          this.this$0.a.setRepeatCount(this.jdField_a_of_type_Apze.jdField_a_of_type_Int);
          this.this$0.a.addAnimatorListener(localabfq);
          this.this$0.a.addAnimatorUpdateListener(localabfq);
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
    QLog.d("ColorScreenManager", 2, "won't play old anim: " + this.jdField_a_of_type_Int + " because have new anim: " + this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader
 * JD-Core Version:    0.7.0.1
 */
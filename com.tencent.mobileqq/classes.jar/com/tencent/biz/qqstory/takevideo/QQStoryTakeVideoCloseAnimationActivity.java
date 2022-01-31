package com.tencent.biz.qqstory.takevideo;

import ajsd;
import ajya;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tribe.async.dispatch.Dispatcher;
import stb;
import uyj;
import ved;
import vjk;
import vjl;
import vzl;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
  implements Handler.Callback
{
  public static final String a;
  public static boolean a;
  private float a;
  protected ImageView a;
  protected vjl a;
  private float jdField_b_of_type_Float;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsd.bn + "qqstory/animation_cover.jpg";
  }
  
  @TargetApi(14)
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajya.a(2131711063), Float.valueOf(paramFloat1), ",bottom:", Float.valueOf(paramFloat4) });
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    float f3 = vzl.d(this);
    float f4 = vzl.a(this);
    float f1 = (paramFloat4 - paramFloat1) / f3;
    float f2 = (paramFloat3 - paramFloat2) / f4;
    paramFloat3 = (paramFloat3 - paramFloat2) / 2.0F;
    f4 /= 2.0F;
    paramFloat4 = (paramFloat4 - paramFloat1) / 2.0F;
    f3 /= 2.0F;
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidWidgetImageView.animate().setDuration(250L).scaleXBy(1.0F).scaleX(f2).scaleYBy(1.0F).scaleY(f1).x(paramFloat3 + paramFloat2 - f4).y(paramFloat4 + paramFloat1 - f3);
    localViewPropertyAnimator.setListener(new vjk(this));
    localViewPropertyAnimator.start();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_a_of_type_Boolean = true;
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = new AutoPlayImageView(this);
    super.getWindow().addFlags(1024);
    super.setContentViewNoTitle(this.jdField_a_of_type_AndroidWidgetImageView);
    paramBundle = getIntent();
    String str = paramBundle.getStringExtra("path");
    this.jdField_a_of_type_Float = paramBundle.getIntExtra("target_top", 0);
    this.jdField_b_of_type_Float = paramBundle.getIntExtra("target_right", 0);
    this.c = paramBundle.getIntExtra("target_left", 0);
    this.d = paramBundle.getIntExtra("target_bottom", 0);
    ved.b("Q.qqstory.home:FeedSegment_animation", "动画activity终于 OnCreate 了！！！");
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_Vjl = new vjl(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vjl);
    try
    {
      paramBundle = BitmapFactory.decodeFile(str);
      if (paramBundle == null)
      {
        finish();
        return false;
      }
      paramBundle = paramBundle.copy(Bitmap.Config.ARGB_8888, true);
      if (paramBundle == null)
      {
        finish();
        return false;
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      finish();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      return false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Vjl != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vjl);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ved.b("Q.qqstory:QQStoryTakeVideoCloseAnimationActivity", "动画等超时了");
      a(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity
 * JD-Core Version:    0.7.0.1
 */
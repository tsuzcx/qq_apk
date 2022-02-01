package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
  implements Handler.Callback
{
  public static final String a;
  public static boolean b = false;
  protected ImageView c;
  protected QQStoryTakeVideoCloseAnimationActivity.FakeFeedUpdateCompletedReceiver d;
  private Handler e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    localStringBuilder.append("qqstory/animation_cover.jpg");
    a = localStringBuilder.toString();
  }
  
  @TargetApi(14)
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    InfoPrinter.b("Q.qqstory.home:FeedSegment_animation", new Object[] { HardCodeUtil.a(2131908669), Float.valueOf(paramFloat1), ",bottom:", Float.valueOf(paramFloat4) });
    this.e.removeMessages(1);
    float f1 = UIUtils.e(this);
    float f2 = UIUtils.b(this);
    float f3 = paramFloat4 - paramFloat1;
    paramFloat4 = f3 / f1;
    float f4 = paramFloat3 - paramFloat2;
    paramFloat3 = f4 / f2;
    f4 /= 2.0F;
    f2 /= 2.0F;
    f3 /= 2.0F;
    f1 /= 2.0F;
    ViewPropertyAnimator localViewPropertyAnimator = this.c.animate().setDuration(250L).scaleXBy(1.0F).scaleX(paramFloat3).scaleYBy(1.0F).scaleY(paramFloat4).x(f4 + paramFloat2 - f2).y(f3 + paramFloat1 - f1);
    localViewPropertyAnimator.setListener(new QQStoryTakeVideoCloseAnimationActivity.1(this));
    localViewPropertyAnimator.start();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    b = true;
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.e = new Handler(this);
    super.doOnCreate(paramBundle);
    this.c = new AutoPlayImageView(this);
    super.getWindow().addFlags(1024);
    super.setContentViewNoTitle(this.c);
    paramBundle = getIntent();
    String str = paramBundle.getStringExtra("path");
    this.f = paramBundle.getIntExtra("target_top", 0);
    this.g = paramBundle.getIntExtra("target_right", 0);
    this.h = paramBundle.getIntExtra("target_left", 0);
    this.i = paramBundle.getIntExtra("target_bottom", 0);
    SLog.b("Q.qqstory.home:FeedSegment_animation", "动画activity终于 OnCreate 了！！！");
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.d = new QQStoryTakeVideoCloseAnimationActivity.FakeFeedUpdateCompletedReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.d);
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
      this.c.setImageBitmap(paramBundle);
    }
    catch (OutOfMemoryError paramBundle)
    {
      label208:
      break label208;
    }
    finish();
    this.e.sendEmptyMessageDelayed(1, 3000L);
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b = false;
    if (this.d != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.d);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.e.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    SLog.b("Q.qqstory:QQStoryTakeVideoCloseAnimationActivity", "动画等超时了");
    a(0.0F, 0.0F, 0.0F, 0.0F);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity
 * JD-Core Version:    0.7.0.1
 */
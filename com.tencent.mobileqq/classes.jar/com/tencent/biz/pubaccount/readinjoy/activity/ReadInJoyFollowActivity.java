package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import cooperation.readinjoy.ReadInJoyHelper;
import ldl;

public class ReadInJoyFollowActivity
  extends IphoneTitleBarActivity
{
  public ReadInJoyChannelViewController a;
  
  private void a()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131367167);
    this.a = new ReadInJoyChannelViewController(this);
    this.a.a(70);
    this.a.b(0);
    this.a.a(localViewGroup);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoVolumeControl.a().a(this);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130969616);
    getWindow().setBackgroundDrawable(null);
    setClickableTitle("BB圈", new ldl(this));
    a();
    this.a.a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.d();
    VideoVolumeControl.a().b(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.a.g();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.a.h();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ReadInJoyHelper.a(getAppRuntime());
    this.a.e();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.a.f();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity
 * JD-Core Version:    0.7.0.1
 */
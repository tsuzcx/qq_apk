package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import lci;
import lcj;
import lck;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
{
  private long jdField_a_of_type_Long = -1L;
  public ReadInJoyBaseViewController a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private boolean jdField_a_of_type_Boolean;
  
  private boolean a()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 56) {
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131367215);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = new ReadInJoyChannelViewController(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(localViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
    if ((ThemeUtil.isInNightMode(ReadInJoyUtils.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2130969641, this.titleRoot);
    }
    c();
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 40677) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = WeishiReportUtil.b();
    }
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label183;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label163;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130845433);
      this.vg.setBackgroundColor(-1);
      if ((getIntent().getBooleanExtra("is_need_show_animation_translate", false)) && (this.jdField_a_of_type_Boolean))
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(400L);
        this.vg.startAnimation(localAlphaAnimation);
      }
      return;
      label163:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label183:
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.a().a(this);
    this.jdField_a_of_type_Boolean = VideoFeedsHelper.a();
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131624729);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2130969624);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(162);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new lci(this));
    b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new lcj(this));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_a_of_type_Long));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.d();
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)this.app.getManager(162);
    VideoVolumeControl.a().b(this);
    VideoBrightnessControl.a().b(this);
    if (b())
    {
      ThreadManager.executeOnSubThread(new lck(this));
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_a_of_type_Long), this.jdField_a_of_type_Long, "");
      this.jdField_a_of_type_Long = -1L;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.g();
    ReadInJoyScreenShotReporter.a(this).a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.h();
    ReadInJoyScreenShotReporter.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((ReadInJoyHelper.f()) && (a())) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ReadInJoyHelper.a(getAppRuntime());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.e();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.a().a(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.f();
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
    if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
    {
      localObject = ((VideoPlayManager)localObject).a();
      if (((VideoUIManager)localObject).a())
      {
        ((VideoUIManager)localObject).d();
        return true;
      }
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Observable;
import java.util.Observer;
import ler;
import let;
import leu;
import lev;
import lew;
import lex;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private long jdField_a_of_type_Long = -1L;
  public ReadInJoyBaseViewController a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(int paramInt)
  {
    runOnUiThread(new lew(this, paramInt));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if ((b()) && (ReadInJoyHelper.v(ReadInJoyUtils.a()))) {
      b(paramViewGroup);
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 56) {
      bool = true;
    }
    return bool;
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2130969685, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      c(localViewGroup);
      PublicAccountReportUtils.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", VideoReporter.c(), false);
      localViewGroup.setOnClickListener(new lex(this));
    }
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
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131367215);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = new ReadInJoyChannelViewController(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(localViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
    if ((b()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController instanceof ReadInJoyChannelViewController))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController);
    }
    if ((ThemeUtil.isInNightMode(ReadInJoyUtils.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2130969637, this.titleRoot);
    }
    d();
    a(localViewGroup);
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131367497);
    if (WeishiGuideUtils.a(this))
    {
      paramViewGroup.setText("打开看看");
      return;
    }
    paramViewGroup.setText("下载微视");
  }
  
  private void d()
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
      this.leftView.setBackgroundResource(2130845514);
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
  
  public void b()
  {
    if (this.leftView != null) {
      ThreadManager.post(new lev(this), 5, null, true);
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
    setContentView(2130969620);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(162);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new ler(this));
    c();
    if (b())
    {
      ThreadManager.executeOnSubThread(new let(this));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_a_of_type_Long));
      if ((this.app != null) && (this.app.a() != null)) {
        this.app.a().addObserver(this);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.d();
    VideoVolumeControl.a().b(this);
    VideoBrightnessControl.a().b(this);
    ReadInJoyScreenShotReporter.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new leu(this));
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_a_of_type_Long), this.jdField_a_of_type_Long, "");
      this.jdField_a_of_type_Long = -1L;
      if ((this.app != null) && (this.app.a() != null)) {
        this.app.a().deleteObserver(this);
      }
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
  
  protected View onCreateRightView()
  {
    Object localObject = super.onCreateRightView();
    if (b())
    {
      this.rightViewImg.setImageResource(2130840796);
      this.rightViewImg.setVisibility(0);
      localObject = this.rightViewImg;
    }
    return localObject;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (!WeishiManager.a(paramObservable))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */
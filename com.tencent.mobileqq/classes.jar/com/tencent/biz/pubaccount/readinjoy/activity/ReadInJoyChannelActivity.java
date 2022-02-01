package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  protected long a;
  protected ReadInJoyBaseViewController a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  
  public ReadInJoyChannelActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = null;
  }
  
  private void a(int paramInt)
  {
    runOnUiThread(new ReadInJoyChannelActivity.8(this, paramInt));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    paramViewGroup.setOnClickListener(new ReadInJoyChannelActivity.5(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController instanceof ReadInJoyChannelViewController)) && (((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).a() != null) && (((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).a().size() > 0)) {
      RIJStatisticCollectorReport.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().a(), (BaseArticleInfo)((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).a().get(0), paramBoolean);
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
  
  private void b(int paramInt)
  {
    VideoReport.addToDetectionWhitelist(this);
    VideoReport.setPageId(this, "118");
    VideoReport.setPageParams(this, new RIJDtParamBuilder().a(Integer.valueOf(paramInt)).a());
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((b()) && (ReadInJoyHelper.F(ReadInJoyUtils.a()))) {
      c(paramViewGroup);
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
    for (;;)
    {
      try
      {
        if (!getIntent().getBooleanExtra("is_daily_dynamic_child_channel", false)) {
          return;
        }
        HashMap localHashMap = (HashMap)getIntent().getSerializableExtra("channel_map_data");
        if (localHashMap != null)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localHashMap.get("channelName"));
          this.jdField_b_of_type_Boolean = "1".equals(localHashMap.get("canDownRefresh"));
          bool2 = "1".equals(localHashMap.get("canUpRefresh"));
          bool1 = "1".equals(localHashMap.get("isImmersive"));
          ReadInJoyHelper.b(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController != null)
          {
            ((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).a(this.jdField_b_of_type_Boolean, bool2, bool1);
            ((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).i();
          }
          QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh=", Boolean.valueOf(this.jdField_b_of_type_Boolean), " mCanPullUpRefresh=", Boolean.valueOf(bool2), " mChannelName=", this.jdField_a_of_type_JavaLangString });
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh error, e=", localException.toString() });
        return;
      }
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131560503, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      d(localViewGroup);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", VideoReporter.c(), false);
      localViewGroup.setOnClickListener(new ReadInJoyChannelActivity.9(this));
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 40830) {
      bool = true;
    }
    return bool;
  }
  
  private void d()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131376619);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = new ReadInJoyChannelViewController(this);
    ((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController).c(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(localViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
    if ((b()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController instanceof ReadInJoyChannelViewController))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController);
    }
    if ((ThemeUtil.isInNightMode(ReadInJoyUtils.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2131560363, this.titleRoot);
    }
    e();
    b(localViewGroup);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131374187);
    if (WeishiGuideUtils.a(this))
    {
      paramViewGroup.setText(HardCodeUtil.a(2131712839));
      return;
    }
    paramViewGroup.setText(HardCodeUtil.a(2131712837));
  }
  
  private void e()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = WeishiReportUtil.b();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131379546));
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label269;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label248;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849916);
      if (c()) {
        this.leftView.setText(HardCodeUtil.a(2131712750));
      }
      this.vg.setBackgroundColor(-1);
      a(this.vg);
      if ((getIntent().getBooleanExtra("is_need_show_animation_translate", false)) && (this.jdField_a_of_type_Boolean))
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(400L);
        this.vg.startAnimation(localAlphaAnimation);
      }
      return;
      label248:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label269:
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
      ThreadManager.post(new ReadInJoyChannelActivity.7(this), 5, null, true);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    VideoVolumeControl.a().a(this);
    this.jdField_a_of_type_Boolean = VideoFeedsHelper.c();
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755154);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131560312);
    int i = getIntent().getIntExtra("channel_id", -1);
    ReadInJoyGlobalReporter.c(i);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new ReadInJoyChannelActivity.1(this));
    d();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_b_of_type_Long));
      if ((this.app != null) && (this.app.getMessageFacade() != null) && (!c())) {
        this.app.getMessageFacade().addObserver(this);
      }
      ViolaSoLoaderManager.a.a().a();
      ReadInJoyWebRenderEngine.c();
      CodecReuseHelper.a.a();
    }
    c();
    b(i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().i(getIntent().getIntExtra("channel_id", 0));
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.d();
    }
    VideoVolumeControl.a().b(this);
    ReadInJoyScreenShotReporter.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_b_of_type_Long), this.jdField_b_of_type_Long, "");
      this.jdField_b_of_type_Long = -1L;
      if ((this.app != null) && (this.app.getMessageFacade() != null)) {
        this.app.getMessageFacade().deleteObserver(this);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.g();
    ReadInJoyScreenShotReporter.a(this).a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.h();
    ReadInJoyScreenShotReporter.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((ReadInJoyHelper.m()) && (a())) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ReadInJoyHelper.a(getAppRuntime());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.e();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ReadInJoyChannelActivity.4(this));
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.a().a(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.f();
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
    if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
    {
      localObject = ((VideoPlayManager)localObject).a();
      if (((VideoUIManager)localObject).a())
      {
        ((VideoUIManager)localObject).j();
        return true;
      }
    }
    a(false);
    finish();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public View onCreateRightView()
  {
    Object localObject = super.onCreateRightView();
    if (b())
    {
      this.rightViewImg.setImageResource(2130843089);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipServiceAccountFolderConfig;
import com.tencent.mobileqq.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

public class ServiceAccountFolderActivityNew
  extends FragmentActivity
  implements SimpleEventReceiver
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private ServiceAccountFolderActivityNew.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter;
  private FolderFollowTabFragment jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<FolderBaseTabFragment> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = true;
  
  static
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqsubscribe", "DefaultSelectExplorePage", 0) > 0) {
      bool = true;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  private COMM.StCommonExt a()
  {
    COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("user_info");
    localEntry.value.set("1");
    localStCommonExt.mapInfo.get().add(localEntry);
    return localStCommonExt;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment = new FolderFollowTabFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment);
    this.jdField_d_of_type_Boolean = QVipServiceAccountFolderProcessor.a().showRecommendPage;
    if ((!a()) && (this.jdField_d_of_type_Boolean))
    {
      FolderRecommendTabFragment localFolderRecommendTabFragment = new FolderRecommendTabFragment();
      this.jdField_a_of_type_JavaUtilArrayList.add(localFolderRecommendTabFragment);
    }
    this.jdField_a_of_type_JavaLangString = this.app.getAccount();
  }
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramStGetMainPageRsp.messStatus.get() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter.getItem(0) != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter.getItem(0) instanceof FolderFollowTabFragment))) {
      ((FolderFollowTabFragment)this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter.getItem(0)).a(paramStGetMainPageRsp.messStatus.noticeCount.get());
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377842);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377296);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131377038));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376488));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376490));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131381783));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter = new ServiceAccountFolderActivityNew.FolderTabFragmentAdapter(this, getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOffscreenPageLimit(1);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369761));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165416));
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839178));
      this.jdField_b_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165416));
      this.jdField_b_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839178));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839152));
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(1308622848);
    }
    d();
    f();
  }
  
  private void b(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramStGetMainPageRsp.user != null) && (paramStGetMainPageRsp.user.certifiedType.get() == 1))
    {
      paramStGetMainPageRsp = a(a(QzoneConfig.getInstance().getConfig("H5Url", "SubPersonalHomePageUrl", "https://h5.qzone.qq.com/v2/vip/live/profile?openid={openid}&puin={puin}&_wv=16777217"), "{puin}", paramStGetMainPageRsp.user.id.get()), "{openid}", "");
      try
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("url", paramStGetMainPageRsp);
        localIntent.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
        startActivity(localIntent);
        return;
      }
      catch (Exception paramStGetMainPageRsp)
      {
        QLog.e("ServiceAccountFolderActivityNew", 1, "start Intent error " + paramStGetMainPageRsp);
        return;
      }
    }
    if ((paramStGetMainPageRsp.user != null) && (paramStGetMainPageRsp.user.type.get() == 1))
    {
      SubscribeLaucher.a(this, paramStGetMainPageRsp.user);
      VSReporter.b("auth_follow", "clk_head", 0, 0, new String[0]);
      return;
    }
    SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (SubscribeUtils.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get())) && (!a()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      VSReporter.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ServiceAccountFolderActivityNew.1(this));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379678));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369703));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ServiceAccountFolderActivityNew.2(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370879));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131370880));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841785));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839094));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(1711276032);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
    e();
  }
  
  private void e()
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.jdField_a_of_type_JavaLangString, a());
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, new ServiceAccountFolderActivityNew.3(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new ServiceAccountFolderActivityNew.4(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(new ServiceAccountFolderActivityNew.5(this));
    if ((a()) || (!this.jdField_d_of_type_Boolean)) {
      this.jdField_b_of_type_AndroidWidgetRadioButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7004) && (!a()) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(0);
      MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "find_page", "", 100, 1, System.currentTimeMillis(), "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(0);
      MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "tab_page", "", 100, 1, System.currentTimeMillis(), "");
    }
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public void a(int paramInt)
  {
    if (((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() != 0)) || (paramInt == 8)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderActivityNew", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  public boolean a()
  {
    return StudyModeManager.a();
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559759);
    this.jdField_b_of_type_Boolean = SubscribeUtils.a();
    a();
    b();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    try
    {
      SubImageLoader.a();
      if (this.jdField_a_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Int == FolderBaseTabFragment.jdField_a_of_type_Int)
        {
          String str1 = "auth_follow";
          VSReporter.a(str1, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
          this.jdField_a_of_type_Long = 0L;
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        VSNetworkHelper.getInstance().cancelRequest(BaseApplicationImpl.getContext());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ServiceAccountFolderActivityNew", 1, localException, new Object[0]);
        continue;
        String str2 = "auth_discover";
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(UserStateUpdateEvent.class);
    return localArrayList;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof UserStateUpdateEvent)) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import Override;
import aaak;
import aaam;
import aaec;
import aaek;
import abbe;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import bduy;
import bmzn;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import ttu;
import ttv;
import ttw;
import tty;
import ttz;

public class ServiceAccountFolderActivityNew
  extends FragmentActivity
  implements aaam
{
  public static boolean a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private ServiceAccountFolderActivityNew.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter;
  private FolderFollowTabFragment jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
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
  private ImageView d;
  
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
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment = new FolderFollowTabFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment);
    if (!a())
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377382);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376868);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131376623));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376092));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131376096));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131381247));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment.a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter = new ServiceAccountFolderActivityNew.FolderTabFragmentAdapter(this, getSupportFragmentManager());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369325));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165402));
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839055));
      this.jdField_b_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165402));
      this.jdField_b_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130839055));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839029));
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(1308622848);
    }
    d();
    f();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (aaek.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get())) && (!a()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      abbe.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ttu(this));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d()
  {
    this.d = ((ImageView)findViewById(2131379180));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369261));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ttv(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370440));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131370441));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841596));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838971));
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
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, new ttw(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new tty(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new ttz(this));
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetRadioButton.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7004) && (!a()))
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1);
      bmzn.a().a("", "", "qq_live", "find_page", "", 100, 1, System.currentTimeMillis(), "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
      bmzn.a().a("", "", "qq_live", "tab_page", "", 100, 1, System.currentTimeMillis(), "");
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
    if (((paramInt == 0) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() != 0)) || (paramInt == 8)) {
      this.d.setVisibility(paramInt);
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
    return bduy.a();
  }
  
  public boolean b()
  {
    return this.d.getVisibility() == 0;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559646);
    this.jdField_b_of_type_Boolean = aaek.a();
    a();
    b();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    aaak.a().a(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    aaak.a().b(this);
    aaec.a();
    long l1;
    long l2;
    if (this.jdField_a_of_type_Long > 0L)
    {
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Int != FolderBaseTabFragment.jdField_a_of_type_Int) {
        break label85;
      }
    }
    label85:
    for (String str = "auth_follow";; str = "auth_discover")
    {
      abbe.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      this.jdField_a_of_type_Long = 0L;
      VSNetworkHelper.a().a(BaseApplicationImpl.getContext());
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew
 * JD-Core Version:    0.7.0.1
 */
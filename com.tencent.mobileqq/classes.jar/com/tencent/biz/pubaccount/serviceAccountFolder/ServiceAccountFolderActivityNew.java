package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import ssd;
import sse;
import ssf;
import ssh;
import ssi;
import xxd;
import xxl;
import yej;
import yel;
import yvu;

public class ServiceAccountFolderActivityNew
  extends FragmentActivity
  implements yel
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
    Object localObject = new FolderFollowTabFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = new FolderRecommendTabFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376399);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375933);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131375712));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131375175));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131375176));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131380046));
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter = new ServiceAccountFolderActivityNew.FolderTabFragmentAdapter(this, getSupportFragmentManager());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivityNew$FolderTabFragmentAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(1);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368855));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165368));
      this.jdField_a_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130838851));
      this.jdField_b_of_type_AndroidWidgetRadioButton.setTextColor(getResources().getColor(2131165368));
      this.jdField_b_of_type_AndroidWidgetRadioButton.setBackgroundDrawable(getResources().getDrawable(2130838851));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838769));
      this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(1308622848);
    }
    d();
    f();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (xxl.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get())))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      yvu.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ssd(this));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d()
  {
    this.d = ((ImageView)findViewById(2131378114));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368806));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new sse(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369877));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369878));
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130841282));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838711));
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
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, new ssf(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new ssh(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new ssi(this));
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7004)) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(UserStateUpdateEvent.class);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (((paramInt == 0) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() != 0)) || (paramInt == 8)) {
      this.d.setVisibility(paramInt);
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof UserStateUpdateEvent)) {
      e();
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
    return this.d.getVisibility() == 0;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559508);
    this.jdField_b_of_type_Boolean = xxl.a();
    a();
    b();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    yej.a().a(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    yej.a().b(this);
    xxd.a();
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
      yvu.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      this.jdField_a_of_type_Long = 0L;
      VSNetworkHelper.a().a(BaseApplicationImpl.getContext());
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew
 * JD-Core Version:    0.7.0.1
 */
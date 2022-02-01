package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stTabInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.pubaccount.weishi_new.view.WSParentViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.vip.VasAdvSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class WSHomeFragment
  extends WSBaseFragment<IWSHomeView, WSHomeFragmentPresenter>
  implements View.OnClickListener, WSSimpleEventReceiver, IWSHomeView
{
  public static int a;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSHomeFragment.FpsListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$FpsListener;
  private WSHomeFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter;
  private RedDotBubblePopupWindow jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private WSParentViewPager jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager;
  private WSPopupMenuDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog;
  private WSTabItemViewHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WSHomeFragment.1(this);
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private WSTabItemViewHolder jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
  private Runnable jdField_b_of_type_JavaLangRunnable = new WSHomeFragment.2(this);
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  private String a()
  {
    if (this.f) {
      return "feeds_fullscreen";
    }
    return "feeds";
  }
  
  private void a(double paramDouble)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      String str = HardCodeUtil.a(2131706834) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  private void a(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      paramInt = 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.b(paramInt);
    }
  }
  
  private void a(stNewsRedDot paramstNewsRedDot)
  {
    if ((paramstNewsRedDot != null) && (paramstNewsRedDot.newsCount > 0)) {
      WSPublicAccReport.getInstance().reportAttentionRedDotExposure(paramstNewsRedDot.newsCount, a());
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    Object localObject;
    if (paramstSimpleMetaPerson != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
      WeishiUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
      return;
    }
    paramstSimpleMetaPerson = getActivity();
    if ((paramstSimpleMetaPerson != null) && (getActivity().app != null))
    {
      localObject = getActivity().app.getCurrentAccountUin();
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      paramstSimpleMetaPerson = FaceDrawable.getFaceDrawable(paramstSimpleMetaPerson.app, 1, (String)localObject, 3, localDrawable, localDrawable, null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramstSimpleMetaPerson);
      return;
    }
    WeishiUtils.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, 1, false);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j;
    if (paramInt >= 0)
    {
      j = paramInt;
      if (paramInt <= 1) {}
    }
    else
    {
      j = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_home_to_index", j);
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("key_home_bundle", localBundle);
    if (paramBoolean) {
      localIntent.setFlags(67108864);
    }
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {}
    for (String str = "focus";; str = "feeds")
    {
      WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
      return;
    }
  }
  
  private void a(ArrayList<stNotificationRedDot> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      WSPublicAccReport.getInstance().reportMessageBubblePopupExposure(jdField_a_of_type_Int, this.f);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = new RedDotBubblePopupWindow(getActivity(), new WSHomeFragment.10(this));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramArrayList);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow == null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow.a();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    if ((!this.e) && (paramBoolean)) {
      u();
    }
    Animation localAnimation;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772014);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.startAnimation(localAnimation);
      return;
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772015);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void b(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp == null) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    if (!WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext))
    {
      d(paramstPublisherRsp);
      return;
    }
    c(paramstPublisherRsp);
  }
  
  private boolean b()
  {
    boolean bool2;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      bool2 = false;
    }
    Iterator localIterator;
    boolean bool1;
    do
    {
      return bool2;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      bool1 = false;
      bool2 = bool1;
    } while (!localIterator.hasNext());
    Fragment localFragment = (Fragment)localIterator.next();
    if ((localFragment instanceof WSBaseFragment)) {
      if ((bool1) || (((WSBaseFragment)localFragment).onBackEvent())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      break;
      bool1 = false;
    }
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    WSPublisherDialog localWSPublisherDialog = new WSPublisherDialog(getActivity());
    localWSPublisherDialog.a(paramstPublisherRsp);
    localWSPublisherDialog.a(jdField_a_of_type_Int);
    localWSPublisherDialog.show();
    a("gzh_click", "publish", 1000006);
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    switch (paramstPublisherRsp.noInstallAction)
    {
    default: 
      c(paramstPublisherRsp);
      return;
    case 2: 
      WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.miniAppSchema, new WSHomeFragment.9(this));
      a("gzh_click", "publish", 1000007);
      return;
    }
    WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.h5Url);
    a("gzh_click", "publish", 1000004);
  }
  
  private void e()
  {
    WSSimpleEventBus.a().a(this);
    GdtManager.Params localParams = new GdtManager.Params();
    GdtManager.a().a(this.jdField_a_of_type_AndroidContentContext, localParams);
    ((WSHomeFragmentPresenter)b()).i();
    ((WSHomeFragmentPresenter)b()).e();
    ((WSHomeFragmentPresenter)b()).f();
    ((WSHomeFragmentPresenter)b()).g();
    ((WSHomeFragmentPresenter)b()).h();
  }
  
  private void f()
  {
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager = ((WSParentViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131382052));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131382032));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382010));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382013));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382025));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382017));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382019));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131382029);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131382034);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    g();
    l();
  }
  
  private void g()
  {
    h();
    Bundle localBundle = null;
    if (getArguments() != null) {
      localBundle = getArguments().getBundle("key_home_bundle");
    }
    if (localBundle != null) {
      jdField_a_of_type_Int = localBundle.getInt("key_home_to_index");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter = new WSHomeFragmentAdapter(getChildFragmentManager(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager.setCurrentItem(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new WSHomeFragment.3(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager.addOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(new WSFollowFragment());
    boolean bool = WSExpABTestManager.a().f();
    this.g = bool;
    if (bool)
    {
      this.jdField_a_of_type_JavaUtilList.add(new WSRecommendFragment());
      return;
    }
    bool = WSExpABTestManager.a().b();
    this.f = bool;
    if (bool)
    {
      VasAdvSupport.a().a();
      this.jdField_a_of_type_JavaUtilList.add(WSVerticalPageFragment.a("aio_home_page", "feeds"));
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(WSGridPageFragment.a("", false, true));
  }
  
  private void i()
  {
    int j;
    if (jdField_a_of_type_Int == 0)
    {
      WSReportUtils.b();
      WeishiUtils.c("focus");
      WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder == null)
      {
        j = 0;
        localWSPublicAccReport.reportAttentionClick(j, a(), this.jdField_c_of_type_Boolean);
        a(0);
        WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
        WSPublicAccReport.getInstance().reportPageVisitExit(a());
        WSReportDc00898.c();
      }
    }
    do
    {
      do
      {
        return;
        j = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a();
        break;
      } while (jdField_a_of_type_Int != 1);
      WeishiUtils.c(a());
      WSPublicAccReport.getInstance().reportRecommendClick(this.jdField_c_of_type_Boolean);
      WSPublicAccReport.getInstance().reportPageVisitEnter(a());
      WSPublicAccReport.getInstance().reportPageVisitExit("focus");
    } while (!this.f);
    WSReportUtils.b(String.valueOf(System.currentTimeMillis()));
  }
  
  private void j()
  {
    if (jdField_a_of_type_Int == 0)
    {
      a(true);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_b_of_type_Boolean) {
        o();
      }
    }
    do
    {
      a(true);
      do
      {
        return;
      } while (jdField_a_of_type_Int != 1);
      a(false);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_b_of_type_Boolean);
    n();
    a(false);
  }
  
  private void k()
  {
    WSPublicAccReport.getInstance().reportAvatarViewClick(jdField_a_of_type_Int, this.f);
    t();
    List localList = ((WSHomeFragmentPresenter)b()).b();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog = WSPopupMenuDialog.a(getActivity(), bool, new WSHomeFragment.4(this), new WSHomeFragment.5(this));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog.showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getWidth() / 2 - ViewUtils.a(152.0F) / 2 - ViewUtils.a(7.0F), ViewUtils.a(9.0F));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  private void l()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WSTabInfo(getString(2131720716)).a(true).a(18));
    localArrayList.add(new WSTabInfo(getString(2131720717)).a(true).a(18));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(localArrayList, new WSHomeFragment.6(this));
    m();
    p();
    if (((this.f) && (jdField_a_of_type_Int == 1)) || (this.jdField_b_of_type_Boolean))
    {
      n();
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      a(false);
    }
    for (;;)
    {
      if (this.g) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      o();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      a(true);
    }
  }
  
  private void m()
  {
    TabLayoutCompat.Tab localTab1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(0);
    TabLayoutCompat.Tab localTab2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(1);
    if ((localTab1 != null) && (localTab2 != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder = ((WSTabItemViewHolder)localTab1.a());
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder = ((WSTabItemViewHolder)localTab2.a());
    }
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850545);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843417);
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840629);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843416);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder == null) || (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder == null)) {
      return;
    }
    if (jdField_a_of_type_Int == 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-1);
      }
      for (;;)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a();
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-16777216);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a();
    if ((this.jdField_b_of_type_Boolean) || (this.f))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-1);
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-16777216);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      WSLog.a("weishi-815", "is night mode");
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131382022)).inflate();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      n();
      a(false);
    }
    do
    {
      return;
      WSLog.a("weishi-815", "is day mode");
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void r()
  {
    t();
    WSFeedDataManager.a().a();
    s();
    WeishiUtils.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    WeishiRequest.a.clear();
    if (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  private void s()
  {
    int k = 3;
    int j;
    if ((WSReportEventConstants.jdField_a_of_type_Int == 1) || (WSReportEventConstants.b == 1) || (this.jdField_d_of_type_Boolean) || (WSReportEventConstants.jdField_a_of_type_Boolean)) {
      j = 1;
    }
    for (;;)
    {
      if (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) {
        WSPublicAccReport.getInstance().closePublicAccReport(j);
      }
      WSReportEventConstants.jdField_a_of_type_Int = 0;
      WSReportEventConstants.b = 0;
      return;
      if ((WSReportEventConstants.jdField_a_of_type_Int == 2) || (WSReportEventConstants.b == 2))
      {
        j = 2;
      }
      else
      {
        j = k;
        if (WSReportEventConstants.jdField_a_of_type_Int != 3)
        {
          j = k;
          if (WSReportEventConstants.b != 3) {
            j = 0;
          }
        }
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = null;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog = null;
    }
  }
  
  private void u()
  {
    this.e = true;
    if (this.h)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 3000L);
      a("gzh_exposure", "publish_copywriting", 0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      a("gzh_exposure", "publish", 0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void v()
  {
    ((WSHomeFragmentPresenter)b()).a(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  @NonNull
  public WSHomeFragmentPresenter a()
  {
    return new WSHomeFragmentPresenter();
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSCommentShowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    return localArrayList;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(stGetTabsRsp paramstGetTabsRsp)
  {
    if ((paramstGetTabsRsp == null) || (paramstGetTabsRsp.Tabs == null)) {
      return;
    }
    if (paramstGetTabsRsp.Tabs.size() > 0)
    {
      paramstGetTabsRsp = (stTabInfo)paramstGetTabsRsp.Tabs.get(0);
      if (TextUtils.isEmpty(paramstGetTabsRsp.displayIcon))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130851345);
      WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramstGetTabsRsp.displayIcon, localDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(new WSHomeFragment.8(this, paramstGetTabsRsp));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp.enable)
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131382055)).inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381890));
        ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381888)).setOnClickListener(new WSHomeFragment.7(this, paramstPublisherRsp));
        ((WSHomeFragmentPresenter)b()).a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp);
        this.h = paramstPublisherRsp.newUser;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstPublisherRsp.newsUserText);
        if ((this.f) && (jdField_a_of_type_Int == 1)) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        return;
      }
      u();
      return;
    }
    this.e = false;
  }
  
  public void a(stRedDotRsp paramstRedDotRsp)
  {
    stNewsRedDot localstNewsRedDot = paramstRedDotRsp.newsReddot;
    a(paramstRedDotRsp.user);
    if (localstNewsRedDot == null) {}
    for (int j = 0;; j = localstNewsRedDot.newsCount)
    {
      a(j);
      a(paramstRedDotRsp.notificationReddot);
      a(localstNewsRedDot);
      return;
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSCommentShowEvent)) && (this.e) && (this.jdField_c_of_type_AndroidViewView != null)) {
      if ((!this.f) || (jdField_a_of_type_Int != 1)) {}
    }
    while (!(paramWSSimpleBaseEvent instanceof WSUserAuthEvent))
    {
      return;
      if (((WSCommentShowEvent)paramWSSimpleBaseEvent).isShowingCommentView)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    if (jdField_a_of_type_Int == 0) {}
    for (paramWSSimpleBaseEvent = "focus";; paramWSSimpleBaseEvent = "feeds")
    {
      WSUserAuthDialog.a(localFragmentActivity, paramWSSimpleBaseEvent);
      return;
    }
  }
  
  public void c()
  {
    WSPublicAccReport.getInstance().reportTabLiveBtnExposure(jdField_a_of_type_Int, this.f);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter.getItem(jdField_a_of_type_Int) != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter.getItem(jdField_a_of_type_Int).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    return (b()) || (super.onBackEvent());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().doOnBackPressed();
      continue;
      WSPublicAccReport.getInstance().reportPublicAccDetailClick();
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(getActivity(), "/pubaccount/detail");
      localActivityURIRequest.extra().putString("uin", String.valueOf(2062433139L));
      localActivityURIRequest.extra().putInt("uintype", 1008);
      localActivityURIRequest.extra().putInt("source", 119);
      QRoute.startUri(localActivityURIRequest, null);
      continue;
      k();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WSReportUtils.a("QQ_official_account");
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    WSInitializeHelper.a().c();
    WeishiReportUtil.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramLayoutInflater.inflate(2131560130, paramViewGroup, false));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((WSHomeFragmentPresenter)b()).j();
    WSInitializeHelper.a().d();
    WSSimpleEventBus.a().b(this);
    WSRecommendReportManager.a().a();
    WeishiReportUtil.b();
    FPSCalculator.a().b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragment$FpsListener);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSParentViewPager.removeOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    r();
  }
  
  public void onPause()
  {
    super.onPause();
    PublicAccountEventReport.a(getActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    q();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 10);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null)
    {
      String str = WSReportUtils.a();
      WSLog.e("WSHomeFragment", "[WSHomeFragment.java][onSaveInstanceState] sceneFrom:" + str);
      paramBundle.putString("key_scene_from", str);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    f();
    e();
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_scene_from");
      WSLog.e("WSHomeFragment", "[WSHomeFragment.java][onViewStateRestored] sceneFrom:" + paramBundle);
      if (!TextUtils.isEmpty(paramBundle)) {
        WSReportUtils.a(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */
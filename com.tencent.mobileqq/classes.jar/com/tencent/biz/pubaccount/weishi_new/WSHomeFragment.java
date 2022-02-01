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
import android.support.annotation.Nullable;
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
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
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
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  private WSHomeFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter;
  private final WSInstanceStateForPublicAccFrom jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForPublicAccFrom = new WSInstanceStateForPublicAccFrom();
  private final WSInstanceStateForSceneFrom jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom = new WSInstanceStateForSceneFrom();
  private RedDotBubblePopupWindow jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private WSPopupMenuDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog;
  private WSViewPager jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager;
  private WSTabItemViewHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WSHomeFragment.1(this);
  private List<BaseFragment> jdField_a_of_type_JavaUtilList;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private WSTabItemViewHolder jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
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
  
  private void a(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      paramInt = 0;
    }
    WSTabItemViewHolder localWSTabItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
    if (localWSTabItemViewHolder != null) {
      localWSTabItemViewHolder.b(paramInt);
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
      WSPicLoader.a(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
      return;
    }
    paramstSimpleMetaPerson = getBaseActivity();
    if ((paramstSimpleMetaPerson != null) && (getBaseActivity().app != null))
    {
      localObject = getBaseActivity().app.getCurrentAccountUin();
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      paramstSimpleMetaPerson = FaceDrawable.getFaceDrawable(paramstSimpleMetaPerson.app, 1, (String)localObject, 3, localDrawable, localDrawable, null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramstSimpleMetaPerson);
      return;
    }
    WSPicLoader.a(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
  }
  
  private void a(@Nullable Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("key_home_bundle");
      if (paramBundle == null) {
        return;
      }
      String str1 = paramBundle.getString("key_drama_id");
      String str2 = paramBundle.getString("key_drama_jump_schema");
      paramBundle.putString("key_drama_id", "");
      paramBundle.putString("key_drama_jump_schema", "");
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      WSDramaPageFragment.a(new WSDramaPageIntentParams("aio_red_dot", getContext()).a(str1).b(str2));
    }
  }
  
  public static void a(WSHomeLaunchParams paramWSHomeLaunchParams)
  {
    int k = paramWSHomeLaunchParams.a();
    int j;
    if (k >= 0)
    {
      j = k;
      if (k <= 1) {}
    }
    else
    {
      j = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_home_to_index", j);
    localBundle.putString("key_home_to_context_feed_id", paramWSHomeLaunchParams.a());
    localBundle.putString("key_drama_id", paramWSHomeLaunchParams.b());
    localBundle.putString("key_drama_jump_schema", paramWSHomeLaunchParams.c());
    localBundle.putBoolean("key_context_feed_show_musk", paramWSHomeLaunchParams.b());
    Intent localIntent = new Intent(paramWSHomeLaunchParams.a(), PublicFragmentActivity.class);
    localIntent.putExtra("key_home_bundle", localBundle);
    if (paramWSHomeLaunchParams.a()) {
      localIntent.setFlags(67108864);
    }
    PublicFragmentActivity.Launcher.a(paramWSHomeLaunchParams.a(), localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    String str;
    if (jdField_a_of_type_Int == 0) {
      str = "focus";
    } else {
      str = "feeds";
    }
    WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
  }
  
  private void a(String paramString, boolean paramBoolean)
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
      this.jdField_a_of_type_JavaUtilList.add(WSRecommendFragment.a(paramString, paramBoolean));
      return;
    }
    bool = WSExpABTestManager.a().b();
    this.f = bool;
    if (bool)
    {
      ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
      this.jdField_a_of_type_JavaUtilList.add(WSVerticalPageFragment.a(new WSVerticalPageOpenParams("aio_home_page", "feeds")));
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(WSGridPageFragment.a("", false, true, paramString, paramBoolean));
  }
  
  private void a(ArrayList<stNotificationRedDot> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      WSPublicAccReport.getInstance().reportMessageBubblePopupExposure(jdField_a_of_type_Int, this.f);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = new RedDotBubblePopupWindow(getBaseActivity(), new WSHomeFragment.10(this));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramArrayList);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramArrayList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow;
    if (paramArrayList != null) {
      paramArrayList.a();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    if ((!this.e) && (paramBoolean)) {
      s();
    }
    Animation localAnimation;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772023);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772025);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidViewView.startAnimation(localAnimation);
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return false;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      boolean bool = false;
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label77;
        }
        BaseFragment localBaseFragment = (BaseFragment)((Iterator)localObject).next();
        if ((localBaseFragment instanceof WSBaseFragment))
        {
          if ((!bool) && (!((WSBaseFragment)localBaseFragment).onBackEvent())) {
            break;
          }
          bool = true;
        }
      }
      label77:
      return bool;
    }
    return false;
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    WSPublisherDialog localWSPublisherDialog = new WSPublisherDialog(getBaseActivity());
    localWSPublisherDialog.a(paramstPublisherRsp);
    localWSPublisherDialog.a(jdField_a_of_type_Int);
    localWSPublisherDialog.show();
    a("gzh_click", "publish", 1000006);
  }
  
  private void d()
  {
    WSSimpleEventBus.a().a(this);
    GdtManager.Params localParams = new GdtManager.Params();
    GdtManager.a().a(this.jdField_a_of_type_AndroidContentContext, localParams);
    ((WSHomeFragmentPresenter)b()).f();
    ((WSHomeFragmentPresenter)b()).c();
    ((WSHomeFragmentPresenter)b()).d();
    ((WSHomeFragmentPresenter)b()).e();
    WSAioListHelper.a();
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    int j = paramstPublisherRsp.noInstallAction;
    if (j != 2)
    {
      if (j != 3)
      {
        c(paramstPublisherRsp);
        return;
      }
      WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.h5Url);
      a("gzh_click", "publish", 1000004);
      return;
    }
    WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.miniAppSchema, new WSHomeFragment.9(this));
    a("gzh_click", "publish", 1000007);
  }
  
  private void e()
  {
    if ((getBaseActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
    }
    jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager = ((WSViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381255));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381237));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381215));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381218));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381230));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381222));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381224));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381234);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381239);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    f();
    j();
  }
  
  private void f()
  {
    Object localObject;
    if (getArguments() != null) {
      localObject = getArguments().getBundle("key_home_bundle");
    } else {
      localObject = null;
    }
    boolean bool = false;
    if (localObject != null)
    {
      jdField_a_of_type_Int = ((Bundle)localObject).getInt("key_home_to_index");
      String str = ((Bundle)localObject).getString("key_home_to_context_feed_id");
      bool = ((Bundle)localObject).getBoolean("key_context_feed_show_musk");
      localObject = str;
    }
    else
    {
      localObject = "";
    }
    a((String)localObject, bool);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter = new WSHomeFragmentAdapter(getChildFragmentManager(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setCurrentItem(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new WSHomeFragment.3(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.addOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
  }
  
  private void g()
  {
    int j = jdField_a_of_type_Int;
    if (j == 0)
    {
      WSReportUtils.b();
      WeishiUtils.c("focus");
      WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
      WSTabItemViewHolder localWSTabItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
      if (localWSTabItemViewHolder == null) {
        j = 0;
      } else {
        j = localWSTabItemViewHolder.a();
      }
      localWSPublicAccReport.reportAttentionClick(j, a(), this.jdField_c_of_type_Boolean);
      a(0);
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      WSPublicAccReport.getInstance().reportPageVisitExit(a());
      WSReportDc00898.c();
      return;
    }
    if (j == 1)
    {
      WeishiUtils.c(a());
      WSPublicAccReport.getInstance().reportRecommendClick(this.jdField_c_of_type_Boolean);
      WSPublicAccReport.getInstance().reportPageVisitEnter(a());
      WSPublicAccReport.getInstance().reportPageVisitExit("focus");
      if (this.f) {
        WSReportUtils.b(String.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  private void h()
  {
    int j = jdField_a_of_type_Int;
    if (j == 0)
    {
      a(true);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_b_of_type_Boolean)
      {
        m();
        a(true);
      }
    }
    else if (j == 1)
    {
      a(false);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if (!this.jdField_b_of_type_Boolean)
      {
        l();
        a(false);
      }
    }
  }
  
  private void i()
  {
    WSPublicAccReport.getInstance().reportAvatarViewClick(jdField_a_of_type_Int, this.f);
    r();
    Object localObject = ((WSHomeFragmentPresenter)b()).b();
    boolean bool;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog = WSPopupMenuDialog.a(getBaseActivity(), bool, new WSHomeFragment.4(this), new WSHomeFragment.5(this));
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog;
    RoundImageView localRoundImageView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
    ((WSPopupMenuDialog)localObject).showAsDropDown(localRoundImageView, localRoundImageView.getWidth() / 2 - ViewUtils.a(152.0F) / 2 - ViewUtils.a(7.0F), ViewUtils.a(9.0F));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void j()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WSTabInfo(getString(2131720440)).a(true).a(18));
    localArrayList.add(new WSTabInfo(getString(2131720441)).a(true).a(18));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(localArrayList, new WSHomeFragment.6(this));
    k();
    n();
    if (((this.f) && (jdField_a_of_type_Int == 1)) || (this.jdField_b_of_type_Boolean))
    {
      l();
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      a(false);
    }
    else
    {
      m();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      a(true);
    }
    if (this.g) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void k()
  {
    TabLayoutCompat.Tab localTab1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(0);
    TabLayoutCompat.Tab localTab2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(1);
    if ((localTab1 != null) && (localTab2 != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder = ((WSTabItemViewHolder)localTab1.a());
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder = ((WSTabItemViewHolder)localTab2.a());
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850471);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843330);
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840504);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843329);
  }
  
  private void n()
  {
    WSTabItemViewHolder localWSTabItemViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder;
    if (localWSTabItemViewHolder != null)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder == null) {
        return;
      }
      if (jdField_a_of_type_Int == 0)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-1);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-16777216);
        }
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a();
        return;
      }
      localWSTabItemViewHolder.a();
      if ((!this.jdField_b_of_type_Boolean) && (!this.f))
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-16777216);
        return;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabItemViewHolder.a(-1);
    }
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      WSLog.a("weishi-815", "is night mode");
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381227)).inflate();
      }
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
      l();
      a(false);
      return;
    }
    WSLog.a("weishi-815", "is day mode");
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  private void p()
  {
    r();
    WSFeedDataManager.a().a();
    q();
    WeishiUtils.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    WeishiRequest.a.clear();
    WSExposeDataManager.a().a();
    if (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  private void q()
  {
    int j = WSReportEventConstants.jdField_a_of_type_Int;
    int k = 3;
    if ((j != 1) && (WSReportEventConstants.b != 1) && (!this.jdField_d_of_type_Boolean) && (!WSReportEventConstants.jdField_a_of_type_Boolean))
    {
      if ((WSReportEventConstants.jdField_a_of_type_Int != 2) && (WSReportEventConstants.b != 2))
      {
        j = k;
        if (WSReportEventConstants.jdField_a_of_type_Int != 3) {
          if (WSReportEventConstants.b == 3) {
            j = k;
          } else {
            j = 0;
          }
        }
      }
      else
      {
        j = 2;
      }
    }
    else {
      j = 1;
    }
    if ((!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) && (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_operation_h5"))) {
      WSPublicAccReport.getInstance().closePublicAccReport(j);
    }
    WSReportEventConstants.jdField_a_of_type_Int = 0;
    WSReportEventConstants.b = 0;
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow;
    if (localObject != null)
    {
      ((RedDotBubblePopupWindow)localObject).a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog;
    if ((localObject != null) && (((WSPopupMenuDialog)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSPopupMenuDialog = null;
    }
  }
  
  private void s()
  {
    this.e = true;
    if (this.h)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      a("gzh_exposure", "publish_copywriting", 0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    a("gzh_exposure", "publish", 0);
  }
  
  private void t()
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
  
  public void a(stGetTabsRsp paramstGetTabsRsp)
  {
    if (paramstGetTabsRsp != null)
    {
      if (paramstGetTabsRsp.Tabs == null) {
        return;
      }
      if (paramstGetTabsRsp.Tabs.size() > 0)
      {
        paramstGetTabsRsp = (stTabInfo)paramstGetTabsRsp.Tabs.get(0);
        if (TextUtils.isEmpty(paramstGetTabsRsp.displayIcon))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2131167333);
        WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramstGetTabsRsp.displayIcon, localDrawable);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(new WSHomeFragment.8(this, paramstGetTabsRsp));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    }
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp.enable)
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381257)).inflate();
      }
      View localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381102));
        ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381100)).setOnClickListener(new WSHomeFragment.7(this, paramstPublisherRsp));
        ((WSHomeFragmentPresenter)b()).a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp);
        this.h = paramstPublisherRsp.newUser;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstPublisherRsp.newsUserText);
        if ((this.f) && (jdField_a_of_type_Int == 1))
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        s();
      }
    }
    else
    {
      this.e = false;
    }
  }
  
  public void a(stRedDotRsp paramstRedDotRsp)
  {
    stNewsRedDot localstNewsRedDot = paramstRedDotRsp.newsReddot;
    a(paramstRedDotRsp.user);
    int j;
    if (localstNewsRedDot == null) {
      j = 0;
    } else {
      j = localstNewsRedDot.newsCount;
    }
    a(j);
    a(paramstRedDotRsp.notificationReddot);
    a(localstNewsRedDot);
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSCommentShowEvent)) && (this.e) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if ((this.f) && (jdField_a_of_type_Int == 1)) {
        return;
      }
      if (((WSCommentShowEvent)paramWSSimpleBaseEvent).isShowingCommentView)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSUserAuthEvent))
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (jdField_a_of_type_Int == 0) {
        paramWSSimpleBaseEvent = "focus";
      } else {
        paramWSSimpleBaseEvent = "feeds";
      }
      WSUserAuthDialog.a(localFragmentActivity, paramWSSimpleBaseEvent);
    }
  }
  
  public void b()
  {
    a(null);
  }
  
  public void c()
  {
    WSPublicAccReport.getInstance().reportTabLiveBtnExposure(jdField_a_of_type_Int, this.f);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    WSHomeFragmentAdapter localWSHomeFragmentAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter;
    if ((localWSHomeFragmentAdapter != null) && (localWSHomeFragmentAdapter.a(jdField_a_of_type_Int) != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter.a(jdField_a_of_type_Int).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    return (b()) || (super.onBackEvent());
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131381215)
    {
      if (j != 2131381218)
      {
        if (j != 2131381230) {
          return;
        }
        i();
        return;
      }
      WSPublicAccReport.getInstance().reportPublicAccDetailClick();
      paramView = new ActivityURIRequest(getBaseActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", String.valueOf(2062433139L));
      paramView.extra().putInt("uintype", 1008);
      paramView.extra().putInt("source", 119);
      QRoute.startUri(paramView, null);
      return;
    }
    getBaseActivity().doOnBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("[WSHomeFragment.java][onCreate] this:");
    paramBundle.append(this);
    WSLog.b("WSHomeFragmentLog", paramBundle.toString());
    WSReportUtils.a("QQ_official_account");
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    WSInitializeHelper.a().d();
    ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportEnter();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramLayoutInflater.inflate(2131560014, paramViewGroup, false));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((WSHomeFragmentPresenter)b()).g();
    WSInitializeHelper.a().e();
    WSSimpleEventBus.a().b(this);
    WSRecommendReportManager.a().a();
    ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportExit();
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
    WSViewPager localWSViewPager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager;
    if (localWSViewPager != null) {
      localWSViewPager.removeOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    p();
  }
  
  public void onPause()
  {
    super.onPause();
    PublicAccountEventReport.a(getBaseActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SystemBarCompact localSystemBarCompact = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarVisible(2, 0);
    }
    o();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 10);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom.a(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForPublicAccFrom.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSHomeFragment.java][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSHomeFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    d();
    paramView.post(new WSHomeFragment.2(this));
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSHomeFragment.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSHomeFragmentLog", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom.b(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForPublicAccFrom.b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */
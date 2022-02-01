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
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherUtil;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateManager;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.HomeLauncher;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump.WSOpenHomeThenVideoManager;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
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
import org.jetbrains.annotations.NotNull;

public class WSHomeFragment
  extends WSBaseFragment<IWSHomeView, WSHomeFragmentPresenter>
  implements View.OnClickListener, WSSimpleEventReceiver, IWSHomeView
{
  public static int f;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private long E = 0L;
  private final WSInstanceStateManager F = new WSInstanceStateManager();
  private Context G;
  private List<QBaseFragment> H;
  private WSFragmentAdapter I;
  private ViewPager.OnPageChangeListener J;
  private WSVideoPageChangeObserver K;
  private WSOpenHomeThenVideoManager L = new WSOpenHomeThenVideoManager();
  private Runnable M = new WSHomeFragment.1(this);
  private View g;
  private WSViewPager h;
  private ImageView i;
  private ImageView j;
  private KandianUrlImageView k;
  private WSTabLayout l;
  private SystemBarCompact m;
  private View n;
  private View o;
  private TextView p;
  private View q;
  private WSTabItemViewHolder r;
  private WSTabItemViewHolder s;
  private RedDotBubblePopupWindow t;
  private RoundImageView u;
  private ImageView v;
  private WSPopupMenuDialog w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  private void A()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WSTabInfo(getString(2131918116)).a(true).a(18));
    localArrayList.add(new WSTabInfo(getString(2131918117)).a(true).a(18));
    this.l.a(localArrayList, new WSHomeFragment.5(this));
    B();
    E();
    if (((this.A) && (f == 1)) || (this.e))
    {
      C();
      this.q.setVisibility(8);
      a(false);
    }
    else
    {
      D();
      this.q.setVisibility(0);
      a(true);
    }
    if (this.B) {
      this.q.setVisibility(8);
    }
  }
  
  private void B()
  {
    TabLayoutCompat.Tab localTab1 = this.l.b(0);
    TabLayoutCompat.Tab localTab2 = this.l.b(1);
    if ((localTab1 != null) && (localTab2 != null))
    {
      this.r = ((WSTabItemViewHolder)localTab1.a());
      this.s = ((WSTabItemViewHolder)localTab2.a());
    }
  }
  
  private void C()
  {
    this.j.setImageResource(2130852267);
    this.i.setImageResource(2130844284);
  }
  
  private void D()
  {
    this.j.setImageResource(2130841270);
    this.i.setImageResource(2130844283);
  }
  
  private void E()
  {
    WSTabItemViewHolder localWSTabItemViewHolder = this.r;
    if (localWSTabItemViewHolder != null)
    {
      if (this.s == null) {
        return;
      }
      if (f == 0)
      {
        if (this.e) {
          this.r.a(-1);
        } else {
          this.r.a(-16777216);
        }
        this.s.a();
        return;
      }
      localWSTabItemViewHolder.a();
      if ((!this.e) && (!this.A))
      {
        this.s.a(-16777216);
        return;
      }
      this.s.a(-1);
    }
  }
  
  private void F()
  {
    if (this.e)
    {
      WSLog.a("weishi-815", "is night mode");
      if (this.n == null) {
        this.n = ((ViewStub)this.g.findViewById(2131450275)).inflate();
      }
      localView = this.n;
      if (localView != null) {
        localView.setVisibility(0);
      }
      C();
      a(false);
      return;
    }
    WSLog.a("weishi-815", "is day mode");
    View localView = this.n;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  private void G()
  {
    I();
    WSFeedDataManager.a().c();
    H();
    WeishiUtils.a = false;
    ThreadManager.getUIHandler().removeCallbacks(this.M);
    WeishiRequest.n.clear();
    WSExposeDataManager.a().c();
    if (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  private void H()
  {
    int i1 = WSReportUtils.a(this.y);
    if ((!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) && (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_operation_h5"))) {
      WSPublicAccReport.getInstance().closePublicAccReport(i1);
    }
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.d = 0;
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.e = 0;
  }
  
  private void I()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      ((RedDotBubblePopupWindow)localObject).a();
      this.t = null;
    }
    localObject = this.w;
    if ((localObject != null) && (((WSPopupMenuDialog)localObject).isShowing()))
    {
      this.w.dismiss();
      this.w = null;
    }
  }
  
  private void J()
  {
    this.z = true;
    if (this.C)
    {
      this.p.setVisibility(0);
      ThreadManager.getUIHandler().postDelayed(this.M, 3000L);
      a("gzh_exposure", "publish_copywriting", 0);
    }
    else
    {
      this.p.setVisibility(8);
    }
    this.o.setVisibility(0);
    a("gzh_exposure", "publish", 0);
  }
  
  @NotNull
  private String K()
  {
    if (f == 0) {
      return "focus";
    }
    return "feeds";
  }
  
  private void L()
  {
    ((WSHomeFragmentPresenter)aO_()).a(null);
    this.v.setVisibility(8);
  }
  
  private boolean M()
  {
    Object localObject = this.H;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return false;
      }
      localObject = this.H.iterator();
      boolean bool = false;
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label77;
        }
        QBaseFragment localQBaseFragment = (QBaseFragment)((Iterator)localObject).next();
        if ((localQBaseFragment instanceof WSBaseFragment))
        {
          if ((!bool) && (!((WSBaseFragment)localQBaseFragment).onBackEvent())) {
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
  
  public static WSHomeFragment a(Bundle paramBundle, WSVideoPageChangeObserver paramWSVideoPageChangeObserver)
  {
    WSHomeFragment localWSHomeFragment = new WSHomeFragment();
    localWSHomeFragment.K = paramWSVideoPageChangeObserver;
    localWSHomeFragment.setArguments(paramBundle);
    return localWSHomeFragment;
  }
  
  private void a(int paramInt)
  {
    if (f == 0) {
      paramInt = 0;
    }
    WSTabItemViewHolder localWSTabItemViewHolder = this.r;
    if (localWSTabItemViewHolder != null) {
      localWSTabItemViewHolder.b(paramInt);
    }
  }
  
  private void a(stNewsRedDot paramstNewsRedDot)
  {
    if ((paramstNewsRedDot != null) && (paramstNewsRedDot.newsCount > 0)) {
      WSPublicAccReport.getInstance().reportAttentionRedDotExposure(paramstNewsRedDot.newsCount, v());
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    Object localObject;
    if (paramstSimpleMetaPerson != null)
    {
      localObject = this.u.getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
      WSPicLoader.a().a(getBaseActivity(), this.u, paramstSimpleMetaPerson.avatar);
      return;
    }
    paramstSimpleMetaPerson = getBaseActivity();
    if ((paramstSimpleMetaPerson != null) && (getBaseActivity().app != null))
    {
      localObject = getBaseActivity().app.getCurrentAccountUin();
      Drawable localDrawable = FaceDrawable.getDefaultDrawable(1, 3);
      paramstSimpleMetaPerson = FaceDrawable.getFaceDrawable(paramstSimpleMetaPerson.app, 1, (String)localObject, 3, localDrawable, localDrawable, null);
      localObject = this.u.getDrawable();
      if ((localObject != null) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
      this.u.setImageDrawable(paramstSimpleMetaPerson);
      return;
    }
    WSPicLoader.a().a(getBaseActivity(), this.u, null);
  }
  
  public static void a(WSHomeLaunchParams paramWSHomeLaunchParams)
  {
    WSLauncher.HomeLauncher.a(paramWSHomeLaunchParams);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    WSPublisherUtil.a.a(paramString1, paramString2, paramInt, K());
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.H == null) {
      this.H = new ArrayList();
    }
    this.H.clear();
    this.H.add(new WSFollowFragment());
    boolean bool = WSExpABTestManager.a().f();
    this.A = bool;
    if (bool)
    {
      ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
      paramString = WSVerticalPageFragment.a(new WSVerticalPageOpenParams("aio_home_page", "feeds").v().getExtras());
      paramString.a(this.K);
      this.H.add(paramString);
      return;
    }
    bool = WSExpABTestManager.a().m();
    this.B = bool;
    if (bool)
    {
      this.H.add(WSRecommendFragment.a(paramString, paramBoolean));
      return;
    }
    this.H.add(WSGridPageFragment.a("", false, true, paramString, paramBoolean));
  }
  
  private void a(ArrayList<stNotificationRedDot> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      WSPublicAccReport.getInstance().reportMessageBubblePopupExposure(f, this.A);
      this.t = new RedDotBubblePopupWindow(getBaseActivity(), new WSHomeFragment.8(this));
      this.t.a(this.u, paramArrayList);
      this.v.setVisibility(0);
      return;
    }
    this.v.setVisibility(8);
    paramArrayList = this.t;
    if (paramArrayList != null) {
      paramArrayList.a();
    }
  }
  
  private void b(stPublisherRsp paramstPublisherRsp)
  {
    this.y = true;
    String str = K();
    WSPublisherUtil.a.a(this.G, paramstPublisherRsp, str);
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.o == null) {
      return;
    }
    if ((!this.z) && (paramBoolean)) {
      J();
    }
    Animation localAnimation;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.G, 2130772028);
      this.o.setVisibility(0);
    }
    else
    {
      localAnimation = AnimationUtils.loadAnimation(this.G, 2130772030);
      this.o.setVisibility(8);
    }
    this.o.startAnimation(localAnimation);
  }
  
  private void r()
  {
    WSSimpleEventBus.a().a(this);
    GdtManager.Params localParams = new GdtManager.Params();
    GdtManager.a().a(this.G, localParams);
    ((WSHomeFragmentPresenter)aO_()).f();
    ((WSHomeFragmentPresenter)aO_()).a();
    ((WSHomeFragmentPresenter)aO_()).d();
    ((WSHomeFragmentPresenter)aO_()).e();
    WSAioListHelper.a();
  }
  
  private void s()
  {
    if ((getBaseActivity() instanceof PublicFragmentActivity)) {
      this.m = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
    }
    f = 1;
    this.h = ((WSViewPager)this.g.findViewById(2131450303));
    this.l = ((WSTabLayout)this.g.findViewById(2131450285));
    this.i = ((ImageView)this.g.findViewById(2131450263));
    this.j = ((ImageView)this.g.findViewById(2131450266));
    this.u = ((RoundImageView)this.g.findViewById(2131450278));
    this.v = ((ImageView)this.g.findViewById(2131450270));
    this.k = ((KandianUrlImageView)this.g.findViewById(2131450272));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.g.findViewById(2131450282);
    this.q = this.g.findViewById(2131450287);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.u.setOnClickListener(this);
    t();
    A();
  }
  
  private void t()
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
      f = ((Bundle)localObject).getInt("key_home_to_index");
      String str = ((Bundle)localObject).getString("key_home_to_context_feed_id");
      bool = ((Bundle)localObject).getBoolean("key_context_feed_show_musk");
      localObject = str;
    }
    else
    {
      localObject = "";
    }
    a((String)localObject, bool);
    this.I = new WSFragmentAdapter(getChildFragmentManager(), this.H);
    this.h.setAdapter(this.I);
    this.h.setCurrentItem(f);
    this.h.setOffscreenPageLimit(2);
    this.J = new WSHomeFragment.2(this);
    this.h.addOnPageChangeListener(this.J);
  }
  
  private void u()
  {
    if (this.D) {
      w();
    }
    this.D = false;
  }
  
  private String v()
  {
    if (this.A) {
      return "feeds_fullscreen";
    }
    return "feeds";
  }
  
  private void w()
  {
    int i1 = f;
    if (i1 == 0)
    {
      WSReportUtils.d();
      WeishiUtils.m("focus");
      WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
      WSTabItemViewHolder localWSTabItemViewHolder = this.r;
      if (localWSTabItemViewHolder == null) {
        i1 = 0;
      } else {
        i1 = localWSTabItemViewHolder.c();
      }
      localWSPublicAccReport.reportAttentionClick(i1, v(), this.x);
      a(0);
      WSReportDc00898.e();
      return;
    }
    if (i1 == 1)
    {
      WeishiUtils.m(v());
      WSPublicAccReport.getInstance().reportRecommendClick(this.x);
      if (this.A) {
        WSReportUtils.c(String.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  private void x()
  {
    int i1 = f;
    if (i1 == 0)
    {
      e(true);
      this.q.setVisibility(0);
      if (!this.e)
      {
        D();
        a(true);
      }
    }
    else if (i1 == 1)
    {
      e(false);
      this.q.setVisibility(8);
      if (!this.e)
      {
        C();
        a(false);
      }
    }
  }
  
  private void y()
  {
    WSPublicAccReport.getInstance().reportAvatarViewClick(f, this.A);
    I();
    Object localObject = ((WSHomeFragmentPresenter)aO_()).c();
    boolean bool;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.w = WSPopupMenuDialog.a(getBaseActivity(), bool, new WSHomeFragment.3(this), new WSHomeFragment.4(this));
    localObject = this.w;
    RoundImageView localRoundImageView = this.u;
    ((WSPopupMenuDialog)localObject).showAsDropDown(localRoundImageView, localRoundImageView.getWidth() / 2 - ViewUtils.dip2px(152.0F) / 2 - ViewUtils.dip2px(7.0F), ViewUtils.dip2px(9.0F));
    this.v.setVisibility(8);
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
          this.k.setVisibility(8);
          return;
        }
        this.k.setVisibility(0);
        Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2131168376);
        WSPicLoader.a().a(this.k, paramstGetTabsRsp.displayIcon, localDrawable);
        this.k.setOnClickListener(new WSHomeFragment.7(this, paramstGetTabsRsp));
        return;
      }
      this.k.setVisibility(8);
    }
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp.enable)
    {
      if (this.o == null) {
        this.o = ((ViewStub)this.g.findViewById(2131450305)).inflate();
      }
      View localView = this.o;
      if (localView != null)
      {
        this.p = ((TextView)localView.findViewById(2131450117));
        ((ImageView)this.o.findViewById(2131450115)).setOnClickListener(new WSHomeFragment.6(this, paramstPublisherRsp));
        ((WSHomeFragmentPresenter)aO_()).a(this.G, paramstPublisherRsp);
        this.C = paramstPublisherRsp.newUser;
        this.p.setText(paramstPublisherRsp.newsUserText);
        if ((this.A) && (f == 1))
        {
          this.o.setVisibility(8);
          return;
        }
        J();
      }
    }
    else
    {
      this.z = false;
    }
  }
  
  public void a(stRedDotRsp paramstRedDotRsp)
  {
    stNewsRedDot localstNewsRedDot = paramstRedDotRsp.newsReddot;
    a(paramstRedDotRsp.user);
    int i1;
    if (localstNewsRedDot == null) {
      i1 = 0;
    } else {
      i1 = localstNewsRedDot.newsCount;
    }
    a(i1);
    a(paramstRedDotRsp.notificationReddot);
    a(localstNewsRedDot);
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSCommentShowEvent)) && (this.z) && (this.o != null))
    {
      if ((this.A) && (f == 1)) {
        return;
      }
      if (((WSCommentShowEvent)paramWSSimpleBaseEvent).isShowingCommentView)
      {
        this.o.setVisibility(8);
        return;
      }
      this.o.setVisibility(0);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSUserAuthEvent))
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (f == 0) {
        paramWSSimpleBaseEvent = "focus";
      } else {
        paramWSSimpleBaseEvent = "feeds";
      }
      WSUserAuthDialog.a(localFragmentActivity, paramWSSimpleBaseEvent);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @NonNull
  public WSHomeFragmentPresenter n()
  {
    return new WSHomeFragmentPresenter();
  }
  
  public void o()
  {
    a(null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    WSFragmentAdapter localWSFragmentAdapter = this.I;
    if ((localWSFragmentAdapter != null) && (localWSFragmentAdapter.a(f) != null)) {
      this.I.a(f).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    return (M()) || (super.onBackEvent());
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131450263)
    {
      if (i1 != 2131450266)
      {
        if (i1 != 2131450278) {
          return;
        }
        y();
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
    this.G = getBaseActivity();
    WSInitializeHelper.a().e();
    ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportEnter();
    this.L.a(this.G, getArguments());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = ((ViewGroup)paramLayoutInflater.inflate(2131626057, paramViewGroup, false));
    return this.g;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((WSHomeFragmentPresenter)aO_()).g();
    WSInitializeHelper.a().i();
    WSSimpleEventBus.a().b(this);
    WSRecommendReportManager.a().b();
    ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportExit();
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
    WSViewPager localWSViewPager = this.h;
    if (localWSViewPager != null) {
      localWSViewPager.removeOnPageChangeListener(this.J);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    G();
  }
  
  public void onPause()
  {
    super.onPause();
    PublicAccountEventReport.a(getBaseActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.E);
  }
  
  public void onResume()
  {
    super.onResume();
    this.E = System.currentTimeMillis();
    SystemBarCompact localSystemBarCompact = this.m;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarVisible(2, 0);
    }
    F();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 10);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.F.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSHomeFragment.java][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSHomeFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    s();
    r();
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSHomeFragment.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSHomeFragmentLog", localStringBuilder.toString());
    this.F.b(paramBundle);
  }
  
  public void p()
  {
    WSPublicAccReport.getInstance().reportTabLiveBtnExposure(f, this.A);
  }
  
  public List<QBaseFragment> q()
  {
    return this.H;
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSCommentShowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import adxr;
import amtj;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import bfqd;
import bhlx;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import pbo;
import tdz;
import ujo;
import ujp;
import ujq;
import ujr;
import ujs;
import ujt;
import uju;
import ujv;
import uka;
import ukq;
import ukw;
import umu;
import unc;
import unw;
import unz;
import urg;
import utr;
import uue;
import uvo;
import uvu;
import uxx;
import uya;
import uyo;
import vee;
import vel;
import yqu;

public class WSHomeFragment
  extends WSBaseFragment<uue, utr>
  implements View.OnClickListener, unz, uue
{
  public static int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private WSHomeFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter;
  private RedDotBubblePopupWindow jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WSHomeFragment.1(this);
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private ujv jdField_a_of_type_Ujv;
  private vee jdField_a_of_type_Vee;
  private vel jdField_a_of_type_Vel;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new WSHomeFragment.2(this);
  private vel jdField_b_of_type_Vel;
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
  
  private void a(double paramDouble)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      String str = amtj.a(2131705943) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  private void a(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      paramInt = 0;
    }
    if (this.jdField_a_of_type_Vel != null) {
      this.jdField_a_of_type_Vel.b(paramInt);
    }
  }
  
  private void a(stNewsRedDot paramstNewsRedDot)
  {
    if ((paramstNewsRedDot != null) && (paramstNewsRedDot.newsCount > 0)) {
      if (!this.f) {
        break label33;
      }
    }
    label33:
    for (String str = "feeds_fullscreen";; str = "feeds")
    {
      WSPublicAccReport.getInstance().reportAttentionRedDotExposure(paramstNewsRedDot.newsCount, str);
      return;
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
      uyo.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
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
    uyo.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, 1, false);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 1) {}
    }
    else
    {
      i = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_home_to_index", i);
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("key_home_bundle", localBundle);
    if (paramBoolean) {
      localIntent.setFlags(67108864);
    }
    adxr.a(paramContext, localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = new RedDotBubblePopupWindow(getActivity(), new uju(this));
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
      o();
    }
    Animation localAnimation;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772011);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.startAnimation(localAnimation);
      return;
      localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772012);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void b(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp == null) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    if (!yqu.a(this.jdField_a_of_type_AndroidContentContext))
    {
      d(paramstPublisherRsp);
      return;
    }
    c(paramstPublisherRsp);
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    uka localuka = new uka(getActivity());
    localuka.a(paramstPublisherRsp);
    localuka.a(jdField_a_of_type_Int);
    localuka.show();
    a("gzh_click", "publish", 1000006);
  }
  
  private void d()
  {
    unw.a().a(this);
    ((utr)b()).c();
    ((utr)b()).d();
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    switch (paramstPublisherRsp.noInstallAction)
    {
    default: 
      c(paramstPublisherRsp);
      return;
    case 2: 
      ukw.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.miniAppSchema, new ujt(this));
      a("gzh_click", "publish", 1000007);
      return;
    }
    ukw.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.h5Url);
    a("gzh_click", "publish", 1000004);
  }
  
  private void e()
  {
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    this.f = umu.a().e();
    jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewView.findViewById(2131381222));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381204));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381185));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381187));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381197));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381191));
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381201);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381205);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(new WSFollowFragment());
    if (this.f) {
      this.jdField_a_of_type_JavaUtilList.add(WSVerticalPageFragment.a("aio_home_page", "feeds"));
    }
    for (;;)
    {
      localObject = null;
      if (getArguments() != null) {
        localObject = getArguments().getBundle("key_home_bundle");
      }
      if (localObject != null) {
        jdField_a_of_type_Int = ((Bundle)localObject).getInt("key_home_to_index");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter = new WSHomeFragmentAdapter(getChildFragmentManager(), this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new ujo(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
      h();
      return;
      this.jdField_a_of_type_JavaUtilList.add(WSRecommendFragment.a());
    }
  }
  
  private void f()
  {
    if (jdField_a_of_type_Int == 0)
    {
      a(true);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_b_of_type_Boolean) {
        j();
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
    i();
    a(false);
  }
  
  private void g()
  {
    WSPublicAccReport.getInstance().reportAvatarViewClick(jdField_a_of_type_Int, this.f);
    n();
    List localList = ((utr)b()).b();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Vee = vee.a(getActivity(), bool, new ujp(this), new ujq(this));
      this.jdField_a_of_type_Vee.showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getWidth() / 2 - ViewUtils.dip2px(152.0F) / 2 - ViewUtils.dip2px(7.0F), ViewUtils.dip2px(9.0F));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  private void h()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131719685));
    ((List)localObject).add(getString(2131719686));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.setTabContentClickListener(new ujr(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a((List)localObject, jdField_a_of_type_Int);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(0);
    tdz localtdz = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(1);
    if ((localObject != null) && (localtdz != null))
    {
      this.jdField_a_of_type_Vel = ((vel)((tdz)localObject).a());
      this.jdField_b_of_type_Vel = ((vel)localtdz.a());
    }
    if ((this.f) && (jdField_a_of_type_Int == 1))
    {
      i();
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      a(false);
      return;
    }
    j();
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    a(true);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Vel != null) {
      this.jdField_a_of_type_Vel.c(-1);
    }
    if (this.jdField_b_of_type_Vel != null) {
      this.jdField_b_of_type_Vel.c(-1);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850054);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843219);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Vel != null) {
      this.jdField_a_of_type_Vel.c(-16777216);
    }
    if (this.jdField_b_of_type_Vel != null) {
      this.jdField_b_of_type_Vel.c(-16777216);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840454);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843218);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      uya.a("weishi-815", "is night mode");
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381194)).inflate();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      i();
      a(false);
    }
    do
    {
      return;
      uya.a("weishi-815", "is day mode");
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    n();
    unc.a().a();
    m();
    uyo.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    urg.a.clear();
  }
  
  private void m()
  {
    int j = 3;
    int i;
    if ((uvu.jdField_a_of_type_Int == 1) || (uvu.b == 1) || (this.jdField_d_of_type_Boolean) || (uvu.jdField_a_of_type_Boolean)) {
      i = 1;
    }
    for (;;)
    {
      WSPublicAccReport.getInstance().closePublicAccReport(i);
      uvu.jdField_a_of_type_Int = 0;
      uvu.b = 0;
      return;
      if ((uvu.jdField_a_of_type_Int == 2) || (uvu.b == 2))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (uvu.jdField_a_of_type_Int != 3)
        {
          i = j;
          if (uvu.b != 3) {
            i = 0;
          }
        }
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = null;
    }
    if ((this.jdField_a_of_type_Vee != null) && (this.jdField_a_of_type_Vee.isShowing()))
    {
      this.jdField_a_of_type_Vee.dismiss();
      this.jdField_a_of_type_Vee = null;
    }
  }
  
  private void o()
  {
    this.e = true;
    if (this.g)
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
  
  private void p()
  {
    ((utr)b()).a(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSCommentShowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    localArrayList.add(ForeBackgroundEvent.class);
    return localArrayList;
  }
  
  @NonNull
  public utr a()
  {
    return new utr();
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp.enable)
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381224)).inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381070));
        ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381068)).setOnClickListener(new ujs(this, paramstPublisherRsp));
        ((utr)b()).a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp);
        this.g = paramstPublisherRsp.newUser;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstPublisherRsp.newsUserText);
        if ((this.f) && (jdField_a_of_type_Int == 1)) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        return;
      }
      o();
      return;
    }
    this.e = false;
  }
  
  public void a(stRedDotRsp paramstRedDotRsp)
  {
    stNewsRedDot localstNewsRedDot = paramstRedDotRsp.newsReddot;
    a(paramstRedDotRsp.user);
    if (localstNewsRedDot == null) {}
    for (int i = 0;; i = localstNewsRedDot.newsCount)
    {
      a(i);
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
    do
    {
      return;
      if (((WSCommentShowEvent)paramWSSimpleBaseEvent).isShowingCommentView)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      if ((paramWSSimpleBaseEvent instanceof WSUserAuthEvent))
      {
        FragmentActivity localFragmentActivity = getActivity();
        if (jdField_a_of_type_Int == 0) {}
        for (paramWSSimpleBaseEvent = "focus";; paramWSSimpleBaseEvent = "feeds")
        {
          ukq.a(localFragmentActivity, paramWSSimpleBaseEvent);
          return;
        }
      }
    } while (!(paramWSSimpleBaseEvent instanceof ForeBackgroundEvent));
    b(paramWSSimpleBaseEvent);
  }
  
  public void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    if (((ForeBackgroundEvent)paramWSSimpleBaseEvent).mIsBackground)
    {
      WSPublicAccReport.getInstance().backgroundPublicAccReport();
      return;
    }
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  public void c()
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter != null)
    {
      Fragment localFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter.getItem(jdField_a_of_type_Int);
      if ((localFragment instanceof WSBaseHomeFragment)) {
        return ((WSBaseHomeFragment)localFragment).onBackEvent();
      }
      if ((localFragment instanceof WSBaseFragment)) {
        return ((WSBaseFragment)localFragment).onBackEvent();
      }
    }
    return super.onBackEvent();
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
      Intent localIntent = new Intent(getActivity(), AccountDetailActivity.class);
      localIntent.putExtra("uin", String.valueOf(2062433139L));
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("source", 119);
      startActivity(localIntent);
      continue;
      g();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    uxx.a().a();
    pbo.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramLayoutInflater.inflate(2131560009, paramViewGroup, false));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    uxx.a().b();
    unw.a().b(this);
    uvo.a().a();
    pbo.b();
    bfqd.a().b(this.jdField_a_of_type_Ujv);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.removeOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    l();
  }
  
  public void onDetach()
  {
    super.onDetach();
    bhlx.a(BaseApplicationImpl.getContext(), true, 10);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    k();
    bhlx.a(BaseApplicationImpl.getContext(), false, 10);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */
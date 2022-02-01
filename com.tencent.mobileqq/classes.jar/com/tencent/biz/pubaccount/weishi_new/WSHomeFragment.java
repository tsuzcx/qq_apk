package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import aeow;
import android.content.Context;
import android.content.Intent;
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
import anvx;
import bgyu;
import biwn;
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
import pkp;
import trk;
import uxl;
import uxm;
import uxn;
import uxo;
import uxp;
import uxq;
import uxr;
import uxs;
import uxx;
import uyn;
import uyt;
import vau;
import vbc;
import vbw;
import vbz;
import vfo;
import vic;
import vir;
import vkc;
import vki;
import vmm;
import vmp;
import vnd;
import vsx;
import vte;
import zfn;

public class WSHomeFragment
  extends WSBaseFragment<vir, vic>
  implements View.OnClickListener, vbz, vir
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
  private uxs jdField_a_of_type_Uxs;
  private vsx jdField_a_of_type_Vsx;
  private vte jdField_a_of_type_Vte;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new WSHomeFragment.2(this);
  private vte jdField_b_of_type_Vte;
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
      String str = anvx.a(2131706294) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  private void a(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      paramInt = 0;
    }
    if (this.jdField_a_of_type_Vte != null) {
      this.jdField_a_of_type_Vte.b(paramInt);
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
      vnd.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
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
    vnd.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
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
    aeow.a(paramContext, localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = new RedDotBubblePopupWindow(getActivity(), new uxr(this));
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
    if (!zfn.a(this.jdField_a_of_type_AndroidContentContext))
    {
      d(paramstPublisherRsp);
      return;
    }
    c(paramstPublisherRsp);
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    uxx localuxx = new uxx(getActivity());
    localuxx.a(paramstPublisherRsp);
    localuxx.a(jdField_a_of_type_Int);
    localuxx.show();
    a("gzh_click", "publish", 1000006);
  }
  
  private void d()
  {
    vbw.a().a(this);
    ((vic)b()).c();
    ((vic)b()).d();
    ((vic)b()).e();
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    switch (paramstPublisherRsp.noInstallAction)
    {
    default: 
      c(paramstPublisherRsp);
      return;
    case 2: 
      uyt.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.miniAppSchema, new uxq(this));
      a("gzh_click", "publish", 1000007);
      return;
    }
    uyt.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.h5Url);
    a("gzh_click", "publish", 1000004);
  }
  
  private void e()
  {
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    this.f = vau.a().e();
    jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewView.findViewById(2131381585));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381567));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381547));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381550));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381560));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381554));
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381564);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381568);
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
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new uxl(this);
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
    List localList = ((vic)b()).b();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Vsx = vsx.a(getActivity(), bool, new uxm(this), new uxn(this));
      this.jdField_a_of_type_Vsx.showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getWidth() / 2 - ViewUtils.dip2px(152.0F) / 2 - ViewUtils.dip2px(7.0F), ViewUtils.dip2px(9.0F));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  private void h()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131720138));
    ((List)localObject).add(getString(2131720139));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.setTabContentClickListener(new uxo(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a((List)localObject, jdField_a_of_type_Int);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(0);
    trk localtrk = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(1);
    if ((localObject != null) && (localtrk != null))
    {
      this.jdField_a_of_type_Vte = ((vte)((trk)localObject).a());
      this.jdField_b_of_type_Vte = ((vte)localtrk.a());
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
    if (this.jdField_a_of_type_Vte != null) {
      this.jdField_a_of_type_Vte.c(-1);
    }
    if (this.jdField_b_of_type_Vte != null) {
      this.jdField_b_of_type_Vte.c(-1);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850147);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843255);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Vte != null) {
      this.jdField_a_of_type_Vte.c(-16777216);
    }
    if (this.jdField_b_of_type_Vte != null) {
      this.jdField_b_of_type_Vte.c(-16777216);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840492);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843254);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      vmp.a("weishi-815", "is night mode");
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381557)).inflate();
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
      vmp.a("weishi-815", "is day mode");
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    n();
    vbc.a().a();
    m();
    vnd.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    vfo.a.clear();
  }
  
  private void m()
  {
    int j = 3;
    int i;
    if ((vki.jdField_a_of_type_Int == 1) || (vki.b == 1) || (this.jdField_d_of_type_Boolean) || (vki.jdField_a_of_type_Boolean)) {
      i = 1;
    }
    for (;;)
    {
      if (!TextUtils.equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_qq_chat")) {
        WSPublicAccReport.getInstance().closePublicAccReport(i);
      }
      vki.jdField_a_of_type_Int = 0;
      vki.b = 0;
      return;
      if ((vki.jdField_a_of_type_Int == 2) || (vki.b == 2))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (vki.jdField_a_of_type_Int != 3)
        {
          i = j;
          if (vki.b != 3) {
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
    if ((this.jdField_a_of_type_Vsx != null) && (this.jdField_a_of_type_Vsx.isShowing()))
    {
      this.jdField_a_of_type_Vsx.dismiss();
      this.jdField_a_of_type_Vsx = null;
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
    ((vic)b()).a(null);
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
  public vic a()
  {
    return new vic();
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
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381587)).inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381429));
        ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381427)).setOnClickListener(new uxp(this, paramstPublisherRsp));
        ((vic)b()).a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp);
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
          uyn.a(localFragmentActivity, paramWSSimpleBaseEvent);
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
    vmm.a().a();
    pkp.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramLayoutInflater.inflate(2131560053, paramViewGroup, false));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    vmm.a().b();
    vbw.a().b(this);
    vkc.a().a();
    pkp.b();
    bgyu.a().b(this.jdField_a_of_type_Uxs);
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
    biwn.a(BaseApplicationImpl.getContext(), true, 10);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    k();
    biwn.a(BaseApplicationImpl.getContext(), false, 10);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */
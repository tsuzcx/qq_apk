package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import afez;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import aoot;
import bhgt;
import bhtq;
import bjfr;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import pai;
import szz;
import ucy;
import ucz;
import uda;
import udb;
import udc;
import udd;
import ude;
import udf;
import udk;
import uea;
import ueg;
import ugd;
import ugl;
import uhf;
import uhi;
import ukl;
import ulx;
import umk;
import unu;
import uoa;
import uqc;
import uqf;
import uqt;
import uwh;
import uwo;
import zqd;

public class WSHomeFragment
  extends WSBaseFragment<umk, ulx>
  implements View.OnClickListener, uhi, umk
{
  public static int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
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
  private udf jdField_a_of_type_Udf;
  private uwh jdField_a_of_type_Uwh;
  private uwo jdField_a_of_type_Uwo;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new WSHomeFragment.2(this);
  private uwo jdField_b_of_type_Uwo;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  private void a(double paramDouble)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      String str = anzj.a(2131705713) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  private void a(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      paramInt = 0;
    }
    if (this.jdField_a_of_type_Uwo != null) {
      this.jdField_a_of_type_Uwo.b(paramInt);
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
      if ((localObject != null) && ((localObject instanceof aoot))) {
        ((aoot)localObject).b();
      }
      uqt.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
      return;
    }
    paramstSimpleMetaPerson = getActivity();
    if ((paramstSimpleMetaPerson != null) && (getActivity().app != null))
    {
      localObject = getActivity().app.getCurrentAccountUin();
      Drawable localDrawable = aoot.a(1, 3);
      paramstSimpleMetaPerson = aoot.a(paramstSimpleMetaPerson.app, 1, (String)localObject, 3, localDrawable, localDrawable, null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof aoot))) {
        ((aoot)localObject).b();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramstSimpleMetaPerson);
      return;
    }
    uqt.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
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
    afez.a(paramContext, localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow = new RedDotBubblePopupWindow(getActivity(), new ude(this));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRedDotBubblePopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramArrayList);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    do
    {
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
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
    if (!zqd.a(this.jdField_a_of_type_AndroidContentContext))
    {
      d(paramstPublisherRsp);
      return;
    }
    c(paramstPublisherRsp);
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    udk localudk = new udk(getActivity());
    localudk.a(paramstPublisherRsp);
    localudk.a(jdField_a_of_type_Int);
    localudk.show();
    a("gzh_click", "publish", 1000006);
  }
  
  private void d()
  {
    uhf.a().a(this);
    ((ulx)b()).c();
    ((ulx)b()).d();
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    switch (paramstPublisherRsp.noInstallAction)
    {
    default: 
      c(paramstPublisherRsp);
      return;
    case 2: 
      ueg.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.miniAppSchema, new udd(this));
      a("gzh_click", "publish", 1000007);
      return;
    }
    ueg.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.h5Url);
    a("gzh_click", "publish", 1000004);
  }
  
  private void e()
  {
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    this.f = ugd.a().e();
    jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewView.findViewById(2131381505));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381487));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381468));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381470));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381480));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381474));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381484));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381488);
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new ucy(this));
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
    List localList = ((ulx)b()).b();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Uwh = uwh.a(getActivity(), bool, new ucz(this), new uda(this));
      this.jdField_a_of_type_Uwh.showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getWidth() / 2 - bhtq.a(152.0F) / 2 - bhtq.a(7.0F), bhtq.a(9.0F));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  private void h()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131719367));
    ((List)localObject).add(getString(2131719368));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.setTabContentClickListener(new udb(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a((List)localObject, jdField_a_of_type_Int);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(0);
    szz localszz = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(1);
    if ((localObject != null) && (localszz != null))
    {
      this.jdField_a_of_type_Uwo = ((uwo)((szz)localObject).a());
      this.jdField_b_of_type_Uwo = ((uwo)localszz.a());
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
    if (this.jdField_a_of_type_Uwo != null) {
      this.jdField_a_of_type_Uwo.c(-1);
    }
    if (this.jdField_b_of_type_Uwo != null) {
      this.jdField_b_of_type_Uwo.c(-1);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850137);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843157);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Uwo != null) {
      this.jdField_a_of_type_Uwo.c(-16777216);
    }
    if (this.jdField_b_of_type_Uwo != null) {
      this.jdField_b_of_type_Uwo.c(-16777216);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840416);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843156);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      uqf.a("weishi-815", "is night mode");
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381477)).inflate();
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
      uqf.a("weishi-815", "is day mode");
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    n();
    ugl.a().a();
    m();
    uqt.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    uqt.jdField_a_of_type_AndroidUtilSparseArray.clear();
    ukl.a.clear();
  }
  
  private void m()
  {
    int j = 3;
    int i;
    if ((uoa.jdField_a_of_type_Int == 1) || (uoa.b == 1) || (this.jdField_d_of_type_Boolean) || (uoa.jdField_a_of_type_Boolean)) {
      i = 1;
    }
    for (;;)
    {
      WSPublicAccReport.getInstance().closePublicAccReport(i);
      uoa.jdField_a_of_type_Int = 0;
      uoa.b = 0;
      return;
      if ((uoa.jdField_a_of_type_Int == 2) || (uoa.b == 2))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (uoa.jdField_a_of_type_Int != 3)
        {
          i = j;
          if (uoa.b != 3) {
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
    if ((this.jdField_a_of_type_Uwh != null) && (this.jdField_a_of_type_Uwh.isShowing()))
    {
      this.jdField_a_of_type_Uwh.dismiss();
      this.jdField_a_of_type_Uwh = null;
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
    ((ulx)b()).a(null);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  @NonNull
  public ulx a()
  {
    return new ulx();
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
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381507)).inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381352));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381350));
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new udc(this, paramstPublisherRsp));
        ((ulx)b()).a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp);
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
      uea.a(localFragmentActivity, paramWSSimpleBaseEvent);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSCommentShowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    return localArrayList;
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
    uqc.a().a();
    pai.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramLayoutInflater.inflate(2131560003, paramViewGroup, false));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    uqc.a().b();
    uhf.a().b(this);
    unu.a().a();
    pai.b();
    bhgt.a().b(this.jdField_a_of_type_Udf);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
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
    bjfr.a(BaseApplicationImpl.getContext(), true, 10);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    k();
    bjfr.a(BaseApplicationImpl.getContext(), false, 10);
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
package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stNewsRedDot;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stSimpleMetaPerson;
import abqm;
import adky;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bcxb;
import bdag;
import bdkf;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import sko;
import tbg;
import tbh;
import tbi;
import tbj;
import tbk;
import tbl;
import tbm;
import tbn;
import tbo;
import tbq;
import tch;
import tee;
import tel;
import tff;
import tfi;
import tij;
import tiu;
import tjx;
import tll;
import tlo;
import tlv;
import tnu;
import tnx;
import toe;
import xoo;

public class WSHomeFragment
  extends WSBaseFragment<tiu, tij>
  implements View.OnClickListener, tfi, tiu
{
  public static int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  private tbo jdField_a_of_type_Tbo;
  private tnu jdField_a_of_type_Tnu;
  private tnx jdField_a_of_type_Tnx;
  private toe jdField_a_of_type_Toe;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private toe jdField_b_of_type_Toe;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView d;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, -1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(paramInt);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    Object localObject;
    if (paramstSimpleMetaPerson != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof bcxb))) {
        ((bcxb)localObject).a();
      }
      tlv.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
      return;
    }
    paramstSimpleMetaPerson = getActivity();
    if ((paramstSimpleMetaPerson != null) && (getActivity().app != null))
    {
      localObject = getActivity().app.getCurrentAccountUin();
      Drawable localDrawable = bcxb.a(1, 3);
      paramstSimpleMetaPerson = bcxb.a(paramstSimpleMetaPerson.app, 1, (String)localObject, 3, localDrawable, localDrawable, null);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof bcxb))) {
        ((bcxb)localObject).a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramstSimpleMetaPerson);
      return;
    }
    tlv.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, null);
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
    adky.a(paramContext, localIntent, PublicFragmentActivity.class, WSHomeFragment.class);
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
      WSPublicAccReport.getInstance().reportMessageBubblePopupExposure();
      this.jdField_a_of_type_Tnu = new tnu(getActivity(), new tbn(this));
      this.jdField_a_of_type_Tnu.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramArrayList);
      this.d.setVisibility(0);
    }
    do
    {
      return;
      this.d.setVisibility(8);
    } while (this.jdField_a_of_type_Tnu == null);
    this.jdField_a_of_type_Tnu.a();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(0);
      a(false);
      return;
    }
    if (a(true))
    {
      a(-1);
      return;
    }
    a(-2368549);
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = 9216;
    if ((Build.VERSION.SDK_INT >= 23) && (!bdag.d()) && (!bdag.b())) {
      if (paramBoolean) {
        getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      }
    }
    do
    {
      return paramBoolean;
      i = 1280;
      break;
      if (!ImmersiveUtils.a()) {
        break label110;
      }
      ImmersiveUtils.a(getActivity().getWindow(), paramBoolean);
    } while ((Build.VERSION.SDK_INT < 23) || (!bdag.b()));
    if (paramBoolean) {}
    for (;;)
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      return paramBoolean;
      i = 1280;
    }
    label110:
    return false;
  }
  
  private void b(int paramInt)
  {
    if (jdField_a_of_type_Int == 0) {
      paramInt = 0;
    }
    if (this.jdField_a_of_type_Toe != null) {
      this.jdField_a_of_type_Toe.b(paramInt);
    }
  }
  
  private void b(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (!xoo.a(this.jdField_a_of_type_AndroidContentContext))
    {
      d(paramstPublisherRsp);
      return;
    }
    c(paramstPublisherRsp);
  }
  
  private void c()
  {
    tff.a().a(this);
    ((tij)b()).c();
    ((tij)b()).d();
  }
  
  private void c(stPublisherRsp paramstPublisherRsp)
  {
    tbq localtbq = new tbq(getActivity());
    localtbq.a(paramstPublisherRsp);
    localtbq.a(jdField_a_of_type_Int);
    localtbq.show();
    a("gzh_click", "publish", 1000006);
  }
  
  private void d()
  {
    jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewView.findViewById(2131380261));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380256));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380242));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380243));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380251));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380246));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380254));
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(new WSFollowFragment());
    this.jdField_a_of_type_JavaUtilList.add(new WSRecommendFragment());
    this.jdField_a_of_type_Tbo = new tbo(this, getChildFragmentManager(), this.jdField_a_of_type_JavaUtilList);
    localObject = null;
    if (getArguments() != null) {
      localObject = getArguments().getBundle("key_home_bundle");
    }
    if (localObject != null) {
      jdField_a_of_type_Int = ((Bundle)localObject).getInt("key_home_to_index");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_Tbo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.a(new tbg(this));
    f();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(new tbh(this));
  }
  
  private void d(stPublisherRsp paramstPublisherRsp)
  {
    switch (paramstPublisherRsp.noInstallAction)
    {
    default: 
      c(paramstPublisherRsp);
      return;
    case 2: 
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.miniAppSchema, 2003, new tbm(this));
      a("gzh_click", "publish", 1000007);
      return;
    }
    tch.a(this.jdField_a_of_type_AndroidContentContext, paramstPublisherRsp.h5Url);
    a("gzh_click", "publish", 1000004);
  }
  
  private void e()
  {
    WSPublicAccReport.getInstance().reportAvatarViewClick();
    j();
    List localList = ((tij)b()).b();
    if ((localList != null) && (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Tnx = tnx.a(getActivity(), bool, new tbi(this), new tbj(this));
      this.jdField_a_of_type_Tnx.showAsDropDown(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getWidth() / 2 - bdkf.a(152.0F) / 2 - bdkf.a(7.0F), bdkf.a(9.0F));
      this.d.setVisibility(8);
      return;
    }
  }
  
  private void f()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131721474));
    ((List)localObject).add(getString(2131721475));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.setTabContentClickListener(new tbk(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a((List)localObject, jdField_a_of_type_Int);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(0);
    sko localsko = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSTabLayout.a(1);
    if ((localObject != null) && (localsko != null))
    {
      this.jdField_a_of_type_Toe = ((toe)((sko)localObject).a());
      this.jdField_b_of_type_Toe = ((toe)localsko.a());
    }
  }
  
  private void g()
  {
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      tlo.a("weishi-815", "is night mode");
      a(true);
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380249)).inflate();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849501);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842785);
      if (this.jdField_a_of_type_Toe != null) {
        this.jdField_a_of_type_Toe.c(-1);
      }
      if (this.jdField_b_of_type_Toe != null) {
        this.jdField_b_of_type_Toe.c(-1);
      }
    }
    do
    {
      return;
      tlo.a("weishi-815", "is day mode");
      a(false);
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void h()
  {
    j();
    tel.a().a();
    i();
    tlv.jdField_a_of_type_Boolean = false;
  }
  
  private void i()
  {
    int j = 3;
    int i;
    if ((tjx.jdField_a_of_type_Int == 1) || (tjx.b == 1) || (this.jdField_b_of_type_Boolean)) {
      i = 1;
    }
    for (;;)
    {
      WSPublicAccReport.getInstance().closePublicAccReport(i);
      tjx.jdField_a_of_type_Int = 0;
      tjx.b = 0;
      return;
      if ((tjx.jdField_a_of_type_Int == 2) || (tjx.b == 2))
      {
        i = 2;
      }
      else
      {
        i = j;
        if (tjx.jdField_a_of_type_Int != 3)
        {
          i = j;
          if (tjx.b != 3) {
            i = 0;
          }
        }
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Tnu != null)
    {
      this.jdField_a_of_type_Tnu.a();
      this.jdField_a_of_type_Tnu = null;
    }
    if ((this.jdField_a_of_type_Tnx != null) && (this.jdField_a_of_type_Tnx.isShowing()))
    {
      this.jdField_a_of_type_Tnx.dismiss();
      this.jdField_a_of_type_Tnx = null;
    }
  }
  
  private void k()
  {
    ((tij)b()).a(null);
    this.d.setVisibility(8);
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSCommentShowEvent.class);
    return localArrayList;
  }
  
  @NonNull
  public tij a()
  {
    return new tij();
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    if (paramstPublisherRsp.enable)
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380262)).inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380143));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380141));
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new tbl(this, paramstPublisherRsp));
        if (!paramstPublisherRsp.newUser) {
          break label171;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstPublisherRsp.newsUserText);
        ThreadManager.getUIHandler().postDelayed(new WSHomeFragment.7(this), 3000L);
        a("gzh_exposure", "publish_copywriting", 0);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        a("gzh_exposure", "publish", 0);
        return;
        label171:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(stRedDotRsp paramstRedDotRsp)
  {
    stNewsRedDot localstNewsRedDot = paramstRedDotRsp.newsReddot;
    a(paramstRedDotRsp.user);
    if (localstNewsRedDot == null) {}
    for (int i = 0;; i = localstNewsRedDot.newsCount)
    {
      b(i);
      a(paramstRedDotRsp.notificationReddot);
      return;
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSCommentShowEvent)) && (this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if (((WSCommentShowEvent)paramWSSimpleBaseEvent).isShowingCommentView) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_Tbo != null) && (this.jdField_a_of_type_Tbo.getItem(jdField_a_of_type_Int) != null)) {
      this.jdField_a_of_type_Tbo.getItem(jdField_a_of_type_Int).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380242: 
      getActivity().finish();
      return;
    }
    WSPublicAccReport.getInstance().reportPublicAccDetailClick();
    paramView = new Intent(getActivity(), AccountDetailActivity.class);
    paramView.putExtra("uin", String.valueOf(2062433139L));
    paramView.putExtra("uintype", 1008);
    paramView.putExtra("source", 119);
    startActivity(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    tll.a().a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)paramLayoutInflater.inflate(2131559856, paramViewGroup, false));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    tll.a().b();
    tff.a().b(this);
    tee.a().a();
    abqm.a(getActivity());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    h();
  }
  
  public void onResume()
  {
    super.onResume();
    g();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment
 * JD-Core Version:    0.7.0.1
 */
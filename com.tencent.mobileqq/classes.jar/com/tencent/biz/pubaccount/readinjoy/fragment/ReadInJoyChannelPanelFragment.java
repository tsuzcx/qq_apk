package com.tencent.biz.pubaccount.readinjoy.fragment;

import aepi;
import alud;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdaq;
import bdep;
import bevn;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.NestedScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelBottomBanner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nrt;
import ojb;
import ors;
import orz;
import otb;
import owy;
import oxb;
import oxd;
import oxe;
import oyz;
import oza;
import ozc;
import ozd;
import oze;
import ozh;
import pfd;
import qkk;
import qkm;
import qnc;
import qni;
import sik;

public class ReadInJoyChannelPanelFragment
  extends PublicBaseFragment
  implements View.OnClickListener, bevn
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NestedScrollView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView;
  private ReadInJoyDynamicGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView;
  private ChannelBottomBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner;
  private SlideDownFrameLayout jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
  private ArrayList<ReadInJoyStaticGridView> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private List<qkm> jdField_a_of_type_JavaUtilList;
  private Map<Integer, TabChannelCoverInfo> jdField_a_of_type_JavaUtilMap;
  private owy jdField_a_of_type_Owy;
  protected oxe a;
  private oze jdField_a_of_type_Oze;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public ReadInJoyChannelPanelFragment()
  {
    this.jdField_a_of_type_Oxe = new ozc(this);
  }
  
  private int a(int paramInt)
  {
    if (!otb.a()) {
      return paramInt;
    }
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 2131559926: 
      return 2131559927;
    case 2131559928: 
      return 2131559929;
    case 2131560067: 
      return 2131560066;
    }
    return 2131560094;
  }
  
  public static int a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if ((paramChannelCoverInfo != null) && (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl))) {
      return 2;
    }
    return 1;
  }
  
  public static int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo == null) || (paramTabChannelCoverInfo.redPoint == null))
    {
      if (paramTabChannelCoverInfo != null) {}
      for (paramTabChannelCoverInfo = paramTabChannelCoverInfo.toString();; paramTabChannelCoverInfo = "")
      {
        QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "getRedDotType, info is null or redPoint is null", paramTabChannelCoverInfo });
        return -1;
      }
    }
    QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "getRedDotType, info = ", paramTabChannelCoverInfo.toString() });
    if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)
    {
      long l = System.currentTimeMillis() / 1000L;
      if ((l >= paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long) && (l <= paramTabChannelCoverInfo.redPoint.jdField_b_of_type_Long)) {
        return paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int;
      }
    }
    return -1;
  }
  
  public static void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    localTranslateAnimation.setDuration(300L);
    if (paramView != null) {
      paramView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Oze.notifyDataSetChanged();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ozh)((ReadInJoyStaticGridView)localIterator.next()).a()).notifyDataSetChanged();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718881);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131718761);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.a(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.a();
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((qkm)this.jdField_a_of_type_JavaUtilList.get(0)).b);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131718762);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.a();
      h();
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(0);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo != null)
    {
      oxb.a().m();
      oxb.a().a(paramTabChannelCoverInfo);
      ojb.a("0X8007F02", paramTabChannelCoverInfo, ojb.jdField_b_of_type_Int);
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, TextView paramTextView)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString)) {
      paramTextView.setText(paramTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString);
    }
    if (paramTabChannelCoverInfo.redPoint.jdField_b_of_type_Int != 0) {
      paramTextView.setTextColor(paramTabChannelCoverInfo.redPoint.jdField_b_of_type_Int);
    }
    if (paramTabChannelCoverInfo.redPoint.c != 0) {
      ((GradientDrawable)paramTextView.getBackground()).setColor(paramTabChannelCoverInfo.redPoint.c);
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, sik paramsik)
  {
    if (a(paramTabChannelCoverInfo) >= 0)
    {
      this.e = true;
      paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
      if (paramsik != null) {
        paramsik.notifyDataSetChanged();
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "actionName = ", paramString1, "\n", "r5 = ", paramString2 });
    nrt.a(null, "", paramString1, paramString1, 0, 0, "", "", "", paramString2, false);
  }
  
  private void a(qkk paramqkk, int paramInt)
  {
    if (paramqkk != null)
    {
      TabChannelCoverInfo localTabChannelCoverInfo = paramqkk.a;
      if (localTabChannelCoverInfo != null) {
        ThreadManager.executeOnSubThread(new ReadInJoyChannelPanelFragment.7(this, localTabChannelCoverInfo, paramqkk, paramInt));
      }
    }
  }
  
  private void a(qkm paramqkm, int paramInt)
  {
    ozh localozh = new ozh(this, getActivity(), 4, paramInt, (int)paramqkm.jdField_a_of_type_Long);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getActivity()).inflate(a(2131559926), this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
    ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localRelativeLayout.findViewById(2131375448);
    localReadInJoyStaticGridView.setExpendable(true);
    localReadInJoyStaticGridView.setEditModeEnabled(false);
    localReadInJoyStaticGridView.setAdapter(localozh);
    localReadInJoyStaticGridView.setTag(Long.valueOf(paramqkm.jdField_a_of_type_Long));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout);
    ((TextView)localRelativeLayout.findViewById(2131375449)).setText(paramqkm.jdField_a_of_type_JavaLangString);
    ((TextView)localRelativeLayout.findViewById(2131375447)).setText(paramqkm.b);
    paramqkm = localRelativeLayout.findViewById(2131375446);
    localReadInJoyStaticGridView.getViewTreeObserver().addOnGlobalLayoutListener(new oza(this, localReadInJoyStaticGridView, paramqkm));
    this.jdField_a_of_type_JavaUtilArrayList.add(localReadInJoyStaticGridView);
  }
  
  private int b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabChannelCoverInfo.fonts_color == 0) {
        break label24;
      }
      i = paramTabChannelCoverInfo.fonts_color;
    }
    label24:
    do
    {
      return i;
      i = j;
    } while (!paramTabChannelCoverInfo.isCurrent);
    return -15550475;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("currentIndex", 0);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Owy.a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    this.e = true;
    if (paramTabChannelCoverInfo != null) {
      paramTabChannelCoverInfo.reason = 2;
    }
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo, sik paramsik)
  {
    if (a(paramTabChannelCoverInfo) == 0)
    {
      this.e = true;
      paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
      if (paramsik != null) {
        paramsik.notifyDataSetChanged();
      }
    }
  }
  
  private int c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      i = j;
      if (paramTabChannelCoverInfo.fonts_color != 0) {
        i = paramTabChannelCoverInfo.fonts_color;
      }
    }
    return i;
  }
  
  private void c()
  {
    pfd localpfd = owy.a().a();
    if (localpfd != null)
    {
      a(localpfd.a(2000000000));
      ThreadManager.getUIHandler().post(new ReadInJoyChannelPanelFragment.1(this, localpfd));
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364788));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364119));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131375468));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView = ((NestedScrollView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364118));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364340);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370941));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370939));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370937));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370731));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView = ((ReadInJoyDynamicGridView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370940));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131370100);
    this.jdField_b_of_type_Int = aepi.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.getResources());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner = new ChannelBottomBanner(getActivity());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = bdaq.a(getActivity(), 18.0F);
      if (otb.a()) {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = bdaq.a(getActivity(), 18.0F);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131370731);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner, (ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.setOnSlideListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new oyz(this));
    this.jdField_a_of_type_Oze = new oze(this, getActivity(), 4, TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setExpendable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setAdapter(this.jdField_a_of_type_Oze);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((qkm)this.jdField_a_of_type_JavaUtilList.get(0)).b);
      int i = 1;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        a((qkm)this.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131713111));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClipChildren(false);
    onPostThemeChanged();
    Object localObject = ((ViewGroup)((FrameLayout)getActivity().findViewById(16908290)).getParent()).getChildAt(1);
    if (((localObject instanceof FrameLayout)) && (((View)localObject).getId() != 16908290)) {
      ((View)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new ReadInJoyChannelPanelFragment.3(this));
  }
  
  private void e()
  {
    FragmentActivity localFragmentActivity;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localFragmentActivity = getActivity();
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.a(getActivity().getWindow(), true);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(0);
      }
    }
    else
    {
      return;
    }
    if (!bdep.d())
    {
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
    localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Owy = ((oxd)ors.a().getManager(163)).a();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnItemLongClickListener(this.jdField_a_of_type_Oze);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnItemClickListener(this.jdField_a_of_type_Oze);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnDropListener(this.jdField_a_of_type_Oze);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnDragListener(this.jdField_a_of_type_Oze);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localIterator.next();
      localReadInJoyStaticGridView.setOnItemClickListener((ozh)localReadInJoyStaticGridView.a());
    }
  }
  
  private void h()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[updateChannelInfoListToCacheDBAndServer] ");
    if (!this.e)
    {
      QLog.d("ReadInJoyChannelPanelFragment", 1, "mHasChanged = false, do not need to update channel info list.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    qkm localqkm = new qkm(((qkm)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long, ((qkm)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ((qkm)this.jdField_a_of_type_JavaUtilList.get(0)).b);
    localqkm.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Oze.a();
    localArrayList.add(localqkm);
    int i = 1;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localqkm = new qkm(((qkm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long, ((qkm)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, ((qkm)this.jdField_a_of_type_JavaUtilList.get(i)).b);
      localqkm.jdField_a_of_type_JavaUtilList = ((ozh)((ReadInJoyStaticGridView)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1)).a()).a();
      localArrayList.add(localqkm);
      i += 1;
    }
    this.jdField_a_of_type_Owy.a(localArrayList, 1, true);
    this.e = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Owy.a(localTabChannelCoverInfo);
      }
    }
    this.jdField_a_of_type_Owy.c(false);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    oxb.a().a(paramFloat, paramInt);
    this.jdField_c_of_type_AndroidViewView.setAlpha(1.0F - paramFloat / paramInt);
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if (paramTopBannerInfo == null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramTopBannerInfo.items.isEmpty())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
    }
    while (paramTopBannerInfo.moreChannelItem != null)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramTopBannerInfo.moreChannelItem.jdField_a_of_type_JavaLangString);
      paramTopBannerInfo = paramTopBannerInfo.moreChannelItem.b;
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ozd(this, paramTopBannerInfo));
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.a(null, paramTopBannerInfo);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView.getScrollY() == 0;
  }
  
  public float[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    float[] arrayOfFloat = new float[2];
    if ((paramArrayOfInt1.length >= 2) && (paramArrayOfInt2.length >= 2))
    {
      arrayOfFloat[0] = (paramArrayOfInt1[0] - paramArrayOfInt2[0]);
      arrayOfFloat[1] = (paramArrayOfInt1[1] - paramArrayOfInt2[1]);
    }
    return arrayOfFloat;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.b();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364340: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.b();
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      a(-1);
      a("0X8009498", new orz().b().a());
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().setTheme(2131755150);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout = ((SlideDownFrameLayout)paramLayoutInflater.inflate(a(2131559928), paramViewGroup, false));
    f();
    b();
    d();
    c();
    g();
    oxb.a().a(this.jdField_a_of_type_Oxe);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
  }
  
  public void onDestroy()
  {
    oxb.a().b(this.jdField_a_of_type_Oxe);
    super.onDestroy();
    i();
    this.jdField_a_of_type_Owy = null;
  }
  
  public void onFinish()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[onFinish] ");
    super.onFinish();
    if (this.e) {
      h();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.c();
    }
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isNowThemeIsNight(ors.a(), false, null))
    {
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131375335)).inflate();
      }
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    oxb.a().a(this.jdField_a_of_type_Oxe);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */
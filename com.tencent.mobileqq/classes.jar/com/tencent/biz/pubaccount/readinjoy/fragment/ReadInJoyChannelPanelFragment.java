package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.BannerInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelSection;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.MoreChannelItem;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelBottomBanner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyChannelPanelFragment
  extends RIJBaseChannelPanelFragment
{
  private ViewTreeObserver.OnPreDrawListener jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ReadInJoyLogicEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
  protected ReadInJoyObserver a;
  private RIJDynamicChannelGridViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter;
  private ReadInJoyDynamicGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView;
  private ChannelBottomBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner;
  private final ArrayList<ReadInJoyStaticGridView> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private List<ChannelSection> jdField_a_of_type_JavaUtilList;
  private Map<Integer, TabChannelCoverInfo> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  
  public ReadInJoyChannelPanelFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyChannelPanelFragment.3(this);
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
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "switchEditMode, position = ", Integer.valueOf(paramInt), ", mIsEditMode = ", Boolean.valueOf(this.jdField_c_of_type_Boolean), ", mIsEditMovingMode = ", Boolean.valueOf(this.d) });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter.a(this.jdField_c_of_type_Boolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((RIJStaticChannelGridViewAdapter)((ReadInJoyStaticGridView)localIterator.next()).getAdapter()).a(this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718230);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718105);
      if (this.d)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.a(paramInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.a();
      break;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.get(0) != null)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).b);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718106);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.a();
      g();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter != null) {
        a((TabChannelCoverInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter.getItem(this.jdField_b_of_type_Int));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(0);
  }
  
  private void a(ChannelSection paramChannelSection, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.b(paramInt);
    RIJStaticChannelGridViewAdapter localRIJStaticChannelGridViewAdapter = new RIJStaticChannelGridViewAdapter(getActivity(), 4, this.jdField_a_of_type_Int, new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback(this, paramChannelSection.jdField_a_of_type_Long));
    localRIJStaticChannelGridViewAdapter.a((List)localObject);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131560218, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    localObject = (ReadInJoyStaticGridView)localRelativeLayout.findViewById(2131376720);
    ((ReadInJoyStaticGridView)localObject).setExpendable(true);
    ((ReadInJoyStaticGridView)localObject).setEditModeEnabled(false);
    ((ReadInJoyStaticGridView)localObject).setAdapter(localRIJStaticChannelGridViewAdapter);
    ((ReadInJoyStaticGridView)localObject).setTag(Long.valueOf(paramChannelSection.jdField_a_of_type_Long));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout);
    ((TextView)localRelativeLayout.findViewById(2131376721)).setText(paramChannelSection.jdField_a_of_type_JavaLangString);
    ((TextView)localRelativeLayout.findViewById(2131376719)).setText(paramChannelSection.b);
    paramChannelSection = localRelativeLayout.findViewById(2131376718);
    ((ReadInJoyStaticGridView)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ReadInJoyChannelPanelFragment.2(this, (ReadInJoyStaticGridView)localObject, paramChannelSection));
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "jumpToChannelPage, info: " + paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().k();
      ReadInJoyLogicEngineEventDispatcher.a().a(paramTabChannelCoverInfo);
      ChannelCoverView.a("0X8007F02", paramTabChannelCoverInfo, ChannelCoverView.jdField_b_of_type_Int);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_Int = getActivity().getIntent().getIntExtra("currentIndex", 0);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "initData, currentIndex = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "updateChannelInfoReason, tabInfo = " + paramTabChannelCoverInfo);
    this.e = true;
    if (paramTabChannelCoverInfo != null) {
      paramTabChannelCoverInfo.reason = 2;
    }
  }
  
  private void c()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().a();
    if (localBannerInfoModule != null)
    {
      a(localBannerInfoModule.a(2000000000));
      ThreadManager.getUIHandler().post(new ReadInJoyChannelPanelFragment.1(this, localBannerInfoModule));
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364580);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376740));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371860));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView = ((ReadInJoyDynamicGridView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372084));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner = new ChannelBottomBanner(getActivity());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = DisplayUtil.a(getActivity(), 18.0F);
      if (ChannelModeConfigHandler.a()) {
        localLayoutParams.bottomMargin = DisplayUtil.a(getActivity(), 18.0F);
      }
      localLayoutParams.addRule(3, 2131371860);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter = new RIJDynamicChannelGridViewAdapter(getActivity(), 4, this.jdField_a_of_type_Int, new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback(this, null), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setExpendable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).b);
      }
      int i = 1;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        a((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712691));
    localRelativeLayout.setClipChildren(false);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnItemLongClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnDropListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView.setOnDragListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)localIterator.next();
      localReadInJoyStaticGridView.setOnItemClickListener((AdapterView.OnItemClickListener)localReadInJoyStaticGridView.getAdapter());
    }
  }
  
  private void g()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[updateChannelInfoListToCacheDBAndServer] ");
    if ((!this.e) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.d("ReadInJoyChannelPanelFragment", 1, "mHasChanged = false, do not need to update channel info list.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ChannelSection localChannelSection = new ChannelSection(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(0)).b);
    localChannelSection.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter.a();
    localArrayList.add(localChannelSection);
    int i = 1;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localChannelSection = new ChannelSection(((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, ((ChannelSection)this.jdField_a_of_type_JavaUtilList.get(i)).b);
      localChannelSection.jdField_a_of_type_JavaUtilList = ((RIJStaticChannelGridViewAdapter)((ReadInJoyStaticGridView)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1)).getAdapter()).a();
      localArrayList.add(localChannelSection);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a(localArrayList, 1, true);
    this.e = false;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a(localTabChannelCoverInfo);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.c(false);
  }
  
  int a()
  {
    return 2131562881;
  }
  
  String a()
  {
    return getString(2131718086);
  }
  
  protected void a(View paramView)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      a(-1);
      RIJChannelReporter.a("0X8009498", new RIJTransMergeKanDianReport.ReportR5Builder().b().a());
      return;
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "refreshBanner, bannerInfo = " + paramTopBannerInfo);
    if (paramTopBannerInfo == null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramTopBannerInfo.moreChannelItem.jdField_a_of_type_JavaLangString);
      paramTopBannerInfo = paramTopBannerInfo.moreChannelItem.b;
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ReadInJoyChannelPanelFragment.4(this, paramTopBannerInfo));
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.a(null, paramTopBannerInfo);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    RIJDtReportHelper.a.a(getActivity(), "16");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    d();
    c();
    f();
    VideoReport.setPageId(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout, "16");
    VideoReport.setPageParams(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout, new RIJDtParamBuilder().a());
    VideoReport.addToDetectionWhitelist(getActivity());
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.onDestroy();
    h();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = null;
  }
  
  public void onFinish()
  {
    QLog.i("ReadInJoyChannelPanelFragment", 1, "[onFinish] ");
    super.onFinish();
    if (this.e) {
      g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelBottomBanner.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */
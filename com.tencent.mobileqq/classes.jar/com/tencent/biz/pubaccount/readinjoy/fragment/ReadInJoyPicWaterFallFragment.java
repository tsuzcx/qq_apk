package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController;
import com.tencent.biz.pubaccount.readinjoy.common.DistinctEventReporter;
import com.tencent.biz.pubaccount.readinjoy.common.DistinctEventReporter.IReporter;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils.ReportData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import com.tencent.biz.pubaccount.readinjoy.view.widget.SimpleFeedbackPopupWindow;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.ExposureReportItem;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<ReadInJoyPicWaterFallFragment.ClassData>
  implements DistinctEventReporter.IReporter
{
  static final int c = Color.parseColor("#999999");
  static final int e = Color.parseColor("#262626");
  int jdField_a_of_type_Int = 2;
  private RecyclerView.ItemAnimator jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator;
  private View jdField_a_of_type_AndroidViewView;
  protected DistinctEventReporter a;
  protected ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface a;
  protected ReadInJoyPicWaterFallFragment.WaterFallPicAdapter a;
  protected ReadInjoyXRecyclerView a;
  private SimpleFeedbackPopupWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetSimpleFeedbackPopupWindow;
  ArrayList<ReadInJoyPicWaterFallFragment.ClassData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected Map<Long, BaseReportData> a;
  protected Set<Long> a;
  int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int f = 41522;
  
  public ReadInJoyPicWaterFallFragment()
  {
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilMap = null;
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369534);
    Object localObject = (LinearLayout)paramView.findViewById(2131369536);
    localObject = (ImageView)paramView.findViewById(2131369535);
    paramView = (TextView)paramView.findViewById(2131369487);
    localTextView.setText(getActivity().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.5(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.d) {
      AccessibilityUtil.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    localObject1 = RIJFeedsType.b(paramArticleInfo);
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label162;
      }
    }
    label162:
    for (int j = 0;; j = 1)
    {
      Object localObject2 = RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, j, NetworkUtil.h(null), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo);
      localObject1 = new JSONObject();
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject2 = new JSONObject((String)localObject2);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          continue;
          Object localObject3;
          continue;
        }
        try
        {
          ((JSONObject)localObject2).put("feeds_type", paramInt2);
          localObject1 = localObject2;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, RIJFeedsType.b(paramArticleInfo), "0X8007625", "0X8007625", 0, 0, RIJStringUtils.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ((JSONObject)localObject1).toString(), false);
          return;
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localJSONException1;
          localObject3 = localJSONException2;
        }
      }
      i = 0;
      break;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setAddDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setChangeDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setMoveDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setRemoveDuration(0L);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setAddDuration(120L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setChangeDuration(250L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setMoveDuration(250L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setRemoveDuration(120L);
  }
  
  public int a()
  {
    return this.f;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<ReadInJoyPicWaterFallFragment.ClassData> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131560318, null);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131379458);
    if (f())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramLayoutInflater);
      Utils.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131365255);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView = new ReadInJoyPicWaterFallFragment.1(this, paramViewGroup.getContext());
    paramViewGroup = new ReadInJoyPicWaterFallFragment.2(this, this.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, AIOUtils.a(3.0F, getResources()), 0, AIOUtils.a(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setAdapter(new ReadInJoyPicWaterFallFragment.ClassificationAdapter(this, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter = new ReadInJoyPicWaterFallFragment.WaterFallPicAdapter(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addOnScrollListener(new ReadInJoyPicWaterFallFragment.3(this));
      this.jdField_b_of_type_Int = AIOUtils.a(3.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addItemDecoration(new ReadInJoyPicWaterFallFragment.SpaceItemDecoration(this, this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().getItemAnimator();
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView, paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetSimpleFeedbackPopupWindow = new SimpleFeedbackPopupWindow(getActivity(), new ReadInJoyPicWaterFallFragment.4(this));
      return paramLayoutInflater;
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setPadding(0, AIOUtils.a(3.0F, getResources()), 0, AIOUtils.a(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
  }
  
  public ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface = new ReadInJoyPicWaterFallFragment.6(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface;
  }
  
  protected void a()
  {
    super.a();
    Intent localIntent = getActivity().getIntent();
    this.f = localIntent.getIntExtra("channel_id", 41522);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  protected void a(View paramView, int paramInt)
  {
    paramView = ((ReadInJoyPicWaterFallFragment.ClassData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtra("channel_id", paramView.mChannelCoverId);
      localIntent.putExtra("sub_channel_name", paramView.mChannelCoverName);
      localIntent.putExtra("is_sub_channel", true);
      PublicFragmentActivity.a(getActivity(), localIntent, ReadInJoyPicWaterFallFragment.class);
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (this.jdField_a_of_type_JavaUtilMap != null)) {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramBaseArticleInfo, paramInt, RIJTransMergeKanDianReport.a(), System.currentTimeMillis()), 5, null, true);
      }
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation")) {
      GalleryReportedUtils.a((GalleryReportedUtils.ReportData)paramObject);
    }
    while (!paramString.equals("exp_subchannel")) {
      return;
    }
    paramString = (ReadInJoyPicWaterFallFragment.ClassData)paramObject;
    GalleryReportedUtils.a(getActivity(), "0X8009A70", a(), paramString.a.mChannelCoverId);
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString)
  {
    new RIJFrameworkReportManager().a(paramMap, paramBoolean, paramMap1, paramString, getActivity(), a());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.notifyDataSetChanged();
    }
  }
  
  protected boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean g()
  {
    return getActivity() instanceof SplashActivity;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelWaterFallViewController.k();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonDistinctEventReporter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonDistinctEventReporter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonDistinctEventReporter.a();
    }
  }
  
  public boolean onBackEvent()
  {
    j();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonDistinctEventReporter = new DistinctEventReporter(this);
    RIJDtReportHelper.a.a(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$WaterFallPicAdapter.notifyDataSetChanged();
    }
    if (f()) {
      Utils.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */
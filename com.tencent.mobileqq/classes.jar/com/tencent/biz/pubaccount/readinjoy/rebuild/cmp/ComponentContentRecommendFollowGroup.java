package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.BatchFollowModel;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView.OnOverScrollListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ComponentContentRecommendFollowGroup
  extends RelativeLayout
  implements ComponentInheritView, DisableSlideHorizontalListView.OnOverScrollListener
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ReadInJoyObserver a;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ComponentContentRecommendFollowGroup.FollowListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$FollowListAdapter;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private View b;
  
  public ComponentContentRecommendFollowGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ComponentContentRecommendFollowGroup.4(this);
    a(paramContext);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt, String paramString)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mRecommendFollowInfos == null) || (paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap == null) || (paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {
      return;
    }
    Iterator localIterator = paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, 3, 0, jdField_a_of_type_Int, null);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X80094DB", "0X80094DB", 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", paramString, paramString, 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560244, this, true);
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_b_of_type_JavaLangString;
    Intent localIntent = new Intent(getContext(), PublicAccountBrowserImpl.class);
    localIntent.putExtra("url", (String)localObject);
    getContext().startActivity(localIntent);
    localObject = (RecommendFollowInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0, null);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView = ((DisableSlideHorizontalListView)paramView.findViewById(2131376753));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376762));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370151);
    this.b = paramView.findViewById(2131376756);
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363572);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$FollowListAdapter = new ComponentContentRecommendFollowGroup.FollowListAdapter(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(DisplayUtil.b(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$FollowListAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.b.setOnClickListener(new ComponentContentRecommendFollowGroup.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.g(getContext())) {
      QQToast.a(getContext(), 1, 2131718305, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentRecommendFollowGroup", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0, null);
    if ((!TextUtils.isEmpty(str)) && (ViolaAccessHelper.b(str)))
    {
      ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.c(str), null);
      return;
    }
    paramRecommendFollowInfo = new Intent(getContext(), PublicAccountBrowserImpl.class);
    paramRecommendFollowInfo.putExtra("url", str);
    paramRecommendFollowInfo.putExtra("hide_operation_bar", true);
    paramRecommendFollowInfo.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    ((Activity)getContext()).startActivityForResult(paramRecommendFollowInfo, 1);
  }
  
  public void a(Object paramObject)
  {
    jdField_a_of_type_Int = RIJTransMergeKanDianReport.a();
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = ((IReadInJoyModel)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$FollowListAdapter.a(paramObject.jdField_b_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, List<RecommendFollowInfo> paramList)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() != null) {
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a();
      }
    }
    paramList = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 3, paramInt2, jdField_a_of_type_Int, paramList);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", paramString, paramString, 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", paramList, false);
  }
  
  protected void a(List<RecommendFollowInfo> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    RecommendFollowInfo localRecommendFollowInfo;
    while (i < paramList.size())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)paramList.get(i);
      if (paramBoolean != localRecommendFollowInfo.isFollowed)
      {
        localArrayList1.add(new BatchFollowModel(localRecommendFollowInfo.uin, localRecommendFollowInfo.type));
        localArrayList2.add(localRecommendFollowInfo);
      }
      i += 1;
    }
    if (!localArrayList2.isEmpty())
    {
      localRecommendFollowInfo = (RecommendFollowInfo)localArrayList2.get(0);
      if (!paramBoolean) {
        break label174;
      }
      a("0X80094DC", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    for (;;)
    {
      paramList = new ComponentContentRecommendFollowGroup.2(this, paramList, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      ReadInJoyLogicEngine.a().a().a(localArrayList1, paramList, 2);
      return;
      label174:
      a("0X80094DD", 0L, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId, localArrayList2.size(), localArrayList2);
    }
    ReadInJoyLogicEngine.a().a().b(localArrayList1, paramList, 2);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowGroup.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  public void c()
  {
    a();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup
 * JD-Core Version:    0.7.0.1
 */
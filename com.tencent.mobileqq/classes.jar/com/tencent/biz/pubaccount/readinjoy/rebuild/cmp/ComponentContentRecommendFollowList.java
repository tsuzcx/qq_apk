package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
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
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentRecommendFollowList
  extends RelativeLayout
  implements ComponentInheritView, DisableSlideHorizontalListView.OnOverScrollListener
{
  private static int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ReadInJoyObserver a;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ComponentContentRecommendFollowList.FollowListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList$FollowListAdapter;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private DisableSlideHorizontalListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private View jdField_b_of_type_AndroidViewView;
  private Set<Long> jdField_b_of_type_JavaUtilSet = new HashSet();
  private Set<Long> c = new HashSet();
  private Set<String> d = new HashSet();
  
  public ComponentContentRecommendFollowList(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ComponentContentRecommendFollowList.6(this);
    a(paramContext);
  }
  
  private int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.insertAction != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.insertAction.a().getActionType() == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_DATA_CARD_FOLLOW.getActionType())) {
        i = 4;
      }
    }
    else {
      return i;
    }
    switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.reqSource)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 5: 
      return 2;
    }
    return 3;
  }
  
  private JSONObject a()
  {
    localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID != 0L) {
          break label156;
        }
        i = 1;
        localJSONObject.put("acc_rec_location", i);
        localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.insertAction == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.insertAction.a() == null)) {
          break label161;
        }
      }
      label156:
      label161:
      for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.insertAction.a().toPBInt();; i = 0)
      {
        localJSONObject.put("trigger_type", i);
        localJSONObject.put("scene_type", a());
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        localJSONObject.put("feeds_type", 70);
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
        localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        return localJSONObject;
        i = -1;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("ComponentContentRecommendFollowList", 1, localJSONException.getMessage());
    }
  }
  
  @NotNull
  private JSONObject a(int paramInt, Long paramLong)
  {
    JSONObject localJSONObject = a();
    try
    {
      localJSONObject.put("acc_seq", paramInt + 1);
      localJSONObject.put("puin", paramLong);
      localJSONObject.put("feeds_type", 70);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
        localJSONObject.put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
      return localJSONObject;
    }
    catch (JSONException paramLong)
    {
      QLog.d("ComponentContentRecommendFollowList", 1, paramLong.getMessage());
    }
    return localJSONObject;
  }
  
  private JSONObject a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    int j = 2;
    localJSONObject = a();
    try
    {
      localJSONObject.put("app_type", ReadinjoyReportUtils.c());
      long l;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        localJSONObject.put("channel_id", l);
        if (paramRecommendFollowInfo != null)
        {
          localJSONObject.put("ugcuin", paramRecommendFollowInfo.uin);
          localJSONObject.put("puin", paramRecommendFollowInfo.uin);
          if (!paramRecommendFollowInfo.isFollowed) {
            break label171;
          }
        }
      }
      label171:
      for (int i = 2;; i = 1)
      {
        localJSONObject.put("button_type", i);
        i = j;
        if (paramRecommendFollowInfo.isFollowed) {
          i = 1;
        }
        localJSONObject.put("click_type", i);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
        {
          localJSONObject.put("scene_type", a());
          localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
          localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
        }
        return localJSONObject;
        l = -1L;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException paramRecommendFollowInfo)
    {
      QLog.d("ComponentContentRecommendFollowList", 1, paramRecommendFollowInfo.getMessage());
    }
  }
  
  private void a(int paramInt, RecommendFollowInfo paramRecommendFollowInfo)
  {
    Long localLong = Long.valueOf(paramRecommendFollowInfo.uin);
    if (!this.jdField_b_of_type_JavaUtilSet.contains(localLong))
    {
      this.jdField_b_of_type_JavaUtilSet.add(localLong);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800B96C", "0X800B96C", 0, 0, "", "", "", a(paramInt, localLong).toString(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", a(paramRecommendFollowInfo).toString(), false);
    }
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
      String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, 2, 0, jdField_a_of_type_Int, null);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X80094DB", "0X80094DB", 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", paramString, paramString, 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", localRecommendFollowInfo.strategyId + "", str, false);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo, int paramInt)
  {
    if ((paramRecommendFollowInfo != null) && (paramRecommendFollowInfo.uin != 0L))
    {
      JSONObject localJSONObject = a(paramInt, Long.valueOf(paramRecommendFollowInfo.uin));
      if (!this.c.contains(Long.valueOf(paramRecommendFollowInfo.uin)))
      {
        this.c.add(Long.valueOf(paramRecommendFollowInfo.uin));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800B96D", "0X800B96D", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.d.contains(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
      {
        this.d.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800B96B", "0X800B96B", 0, 0, "", "", "", localJSONObject.toString(), false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X8007625", "0X8007625", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800B96A", "0X800B96A", 0, 0, "", "", "", a().toString(), false);
    }
  }
  
  private void c(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if ((paramRecommendFollowInfo != null) && (paramRecommendFollowInfo.uin != 0L)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", a(paramRecommendFollowInfo).toString(), false);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560244, this, true);
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.b;
    ReadInJoyUtils.b(getContext(), (String)localObject);
    localObject = (RecommendFollowInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0);
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
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376756);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131372372));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131363572);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setSideBarView(localBezierSideBarView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList$FollowListAdapter = new ComponentContentRecommendFollowList.FollowListAdapter(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setDividerWidth(DisplayUtil.b(paramView.getContext(), 5.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList$FollowListAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setOnOverScrollListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new ComponentContentRecommendFollowList.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(paramCellListener);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ThreadManager.post(new ComponentContentRecommendFollowList.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.g(getContext()))
    {
      if (paramBoolean)
      {
        a("0X80094DC", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
        if (paramRecommendFollowInfo.type != 1) {
          break label79;
        }
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList$FollowListAdapter.notifyDataSetChanged();
        return;
        a("0X80094DD", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
        break;
        label79:
        if (paramRecommendFollowInfo.type == 2) {
          b(paramRecommendFollowInfo, paramBoolean);
        } else {
          QLog.e("ComponentContentRecommendFollowList", 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
        }
      }
    }
    QQToast.a(getContext(), 1, 2131718305, 0).a();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList$FollowListAdapter.a(paramObject.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
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
    String str = ComponentContentRecommend.a(i, paramLong1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramLong2, 2, paramInt2, jdField_a_of_type_Int, null);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", paramString, paramString, 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendFollowId + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", paramInt1 + "", str, false);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.g(getContext())) {
      QQToast.a(getContext(), 1, 2131718305, 0).a();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentRecommendFollowList", 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    String str = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    if ((!TextUtils.isEmpty(str)) && (ViolaAccessHelper.b(str)))
    {
      ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.c(str), null);
      return;
    }
    Intent localIntent = new Intent(getContext(), PublicAccountBrowserImpl.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    getContext().startActivity(localIntent);
    a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoyLogicEngine.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.2(this, paramRecommendFollowInfo), 2);
  }
  
  public void c()
  {
    a();
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.4(this, paramRecommendFollowInfo), 1);
      return;
    }
    ReadInJoyLogicEngine.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.5(this, paramRecommendFollowInfo), 1);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList
 * JD-Core Version:    0.7.0.1
 */
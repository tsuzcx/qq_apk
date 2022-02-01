package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJCreateArticleInfoForBiu;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;

public class ReadInJoySecondCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, FlingExitLayout.OnGestureExitListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ICommentNumChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentUtils.CommentListListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener;
  private ReadInJoyCommentUtils.SecondCommentEvent jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$SecondCommentEvent;
  private ReadInJoySecondCommentListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private TimeSliceHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper = new TimeSliceHelper();
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoySecondCommentListFragment.1(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadInJoySecondCommentListFragment", 2, "read to BiuActivity second   commonCommentData :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("write_comment_button").e(paramArticleInfo.innerUniqueID).c("click_write_comment").a().a("comment_id", this.jdField_a_of_type_JavaLangString).a());
  }
  
  private int b()
  {
    int i = 0;
    if (LiuHaiUtils.b()) {
      i = ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    i = VideoFeedsHelper.b(getActivity()) - i;
    QLog.d("ReadInJoySecondCommentListFragment", 2, "onCreateView | marginTop is " + i);
    return i;
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setVisibility(0);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    do
    {
      return;
      localObject1 = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    } while (localObject1 == null);
    Object localObject1 = (CommentData)((ReadInJoyCommentDataManager)localObject1).a(this.jdField_a_of_type_JavaLangString);
    int k = 4;
    int m = 19;
    int i;
    int j;
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      i = 2;
      j = 20;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label372;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
    }
    label372:
    for (;;)
    {
      Object localObject2 = ((CommentData)localObject1).getWholeStringContent();
      String str = ((CommentData)localObject1).uin;
      localObject2 = RIJCreateArticleInfoForBiu.a(new Intent(getActivity(), ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, (String)localObject2, Long.valueOf(str).longValue(), ((CommentData)localObject1).nickName, 0, j);
      ((Intent)localObject2).putExtra("fast_biu_type", paramBoolean);
      a((Intent)localObject2);
      getActivity().startActivity((Intent)localObject2);
      getActivity().overridePendingTransition(0, 0);
      localObject1 = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (BaseCommentData)localObject1).a().a(this.jdField_a_of_type_JavaLangString).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800901A", "0X800901A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
      return;
      j = m;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      j = m;
      i = k;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break;
      }
      j = m;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
        break;
      }
      i = 9;
      j = 20;
      break;
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((this.jdField_c_of_type_Int == 0) && (this.jdField_c_of_type_Boolean)) {
        this.jdField_c_of_type_Int = b();
      }
    } while (!(this.jdField_b_of_type_AndroidViewView.getLayoutParams() instanceof FrameLayout.LayoutParams));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.setMargins(0, this.jdField_c_of_type_Int, 0, 0);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void g()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localReadInJoyCommentDataManager == null) {}
    while ((localReadInJoyCommentDataManager.a() != 1) || (localReadInJoyCommentDataManager.a() != null)) {
      return;
    }
    ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364815)).setImageResource(2130842982);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter = new ReadInJoySecondCommentListAdapter(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.initFooterView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.hideFooterView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(new ReadInJoySecondCommentListFragment.3(this));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  ReadInJoyCommentUtils.SecondCommentEvent a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$SecondCommentEvent;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(ICommentNumChangedListener paramICommentNumChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener = paramICommentNumChangedListener;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentICommentNumChangedListener);
    }
  }
  
  public void a(ReadInJoyCommentUtils.CommentListListener paramCommentListListener, Bundle paramBundle, ReadInJoyCommentUtils.SecondCommentEvent paramSecondCommentEvent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener = paramCommentListListener;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$SecondCommentEvent = paramSecondCommentEvent;
    setArguments(paramBundle);
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    BaseCommentData localBaseCommentData = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      paramString2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a();
      if (paramString2 == null) {
        break label158;
      }
    }
    label158:
    for (localBaseCommentData = paramString2.a(paramString1);; localBaseCommentData = null)
    {
      c(false);
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.resetState();
      paramString1 = new CommentReportR5Builder(paramArticleInfo, localBaseCommentData).a().a();
      if (paramArticleInfo == null) {
        break;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(paramArticleInfo), "0X800901F", "0X800901F", 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, paramString1, false);
      return;
    }
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener == null) {
      return;
    }
    String str;
    if (paramBoolean)
    {
      str = "downClose";
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener.a(false, null, str);
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 1;; i = 2)
    {
      RIJTransMergeKanDianReport.a(1, this.jdField_b_of_type_Int, i);
      return;
      str = "";
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener.a(false, null, null);
    }
  }
  
  public void d()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localReadInJoyCommentDataManager != null) {
      localReadInJoyCommentDataManager.f();
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.findViewById(2131373363) != null))
    {
      QLog.d("ReadInJoySecondCommentListFragment", 2, "hideMaskView");
      this.jdField_b_of_type_AndroidViewView.findViewById(2131373363).setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.d)
    {
      c();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j = 4;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localObject != null)
        {
          label146:
          CommentData localCommentData;
          FragmentActivity localFragmentActivity;
          ArticleInfo localArticleInfo;
          StringBuilder localStringBuilder;
          if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            i = 2;
            localCommentData = (CommentData)((ReadInJoyCommentDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
            localFragmentActivity = getActivity();
            localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
            localStringBuilder = new StringBuilder().append(getActivity().getString(2131718150));
            if (localCommentData == null) {
              break label393;
            }
          }
          label393:
          for (localObject = localCommentData.nickName;; localObject = "")
          {
            ReadInJoyCommentUtils.a(localFragmentActivity, localArticleInfo, localCommentData, i, (String)localObject, "", false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$SecondCommentEvent, -1);
            if (localCommentData != null)
            {
              localObject = new CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localCommentData).a().a(this.jdField_a_of_type_JavaLangString).a();
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009019", "0X8009019", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
            }
            a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
            break;
            i = j;
            if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
              break label146;
            }
            i = j;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
              break label146;
            }
            i = j;
            if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
              break label146;
            }
            i = 9;
            break label146;
          }
          if (BiuBehaviour.a() == 1) {
            bool = true;
          }
          d(bool);
          continue;
          i();
          continue;
          e();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener.a(false, null, null);
            if (paramView.getId() == 2131379487) {
              i = 5;
            }
            RIJTransMergeKanDianReport.a(1, this.jdField_b_of_type_Int, i);
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131560381, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131560381, paramViewGroup, false))
    {
      paramViewGroup = (RelativeLayout)paramLayoutInflater.findViewById(2131379487);
      paramViewGroup.setOnClickListener(this);
      paramViewGroup.setVisibility(0);
      paramViewGroup = (FlingExitLayout)paramLayoutInflater.findViewById(2131367133);
      paramViewGroup.setOnGestureExitListener(this);
      paramLayoutInflater.findViewById(2131364823).setOnClickListener(this);
      paramLayoutInflater.findViewById(2131369141).setOnClickListener(this);
      paramLayoutInflater.findViewById(2131379432).setOnClickListener(this);
      if (ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
        ((ViewStub)paramLayoutInflater.findViewById(2131376601)).inflate();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131365086));
      paramViewGroup.setListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(new ReadInJoySecondCommentListFragment.2(this));
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131365067);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366896));
      h();
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater;
      f();
      ReadInJoyDropFrameHelper.a().a(6666, this);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      super.onDestroy();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter = null;
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$CommentListListener = null;
    ReadInJoyDropFrameHelper.a().b(6666, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a() != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.a().a(a());
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.c();
        }
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (BiuBehaviour.b() == 1) {}
    for (;;)
    {
      d(bool);
      return false;
      bool = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.d = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment
 * JD-Core Version:    0.7.0.1
 */
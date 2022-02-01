package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyFeedbackPopupWindow
  extends ReadInJoyBasePopupWindow
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private FastWebShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils;
  private ReadInJoyFeedbackPopupWindow.FeedbackCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback = new ReadInJoyFeedbackPopupWindow.1(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  
  public ReadInJoyFeedbackPopupWindow(Activity paramActivity, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils = new FastWebShareUtils();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 9;
    }
    return 10;
  }
  
  private void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject;
    if (b("reportData")) {
      localObject = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    try
    {
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).o(paramInt).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin), paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), (String)localObject, false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("ReadInJoyBasePopupWindow", 1, "reportData json exception.");
      paramString.printStackTrace();
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131718193, 0).a();
      return false;
    }
    return true;
  }
  
  private boolean a(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.publishUin > 0L) && (ReadInJoyUtils.a() == paramArticleInfo.publishUin);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mArticleInfo is null." });
      return false;
    }
    return true;
  }
  
  private boolean b(String paramString)
  {
    if ((a(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)) {
      return true;
    }
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mSocialFeedInfo is null" });
    return false;
  }
  
  private void c()
  {
    if (a("reportFeeds")) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyFeedbackPopupWindow.3(this));
    }
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidAppActivity);
    localActionSheet.setMainTitle(2131718243);
    localActionSheet.addButton(2131718242, 0);
    localActionSheet.addCancelButton(2131690800);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadInJoyFeedbackPopupWindow.4(this, localActionSheet));
  }
  
  private void e()
  {
    if (!a()) {}
    while (!a("shieldFeeds")) {
      return;
    }
    FastWebRequestUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560201, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131378012));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131376948));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131365650));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131377801));
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131375561));
    this.e = ((ImageView)paramLayoutInflater.findViewById(2131381875));
    this.f = ((ImageView)paramLayoutInflater.findViewById(2131371809));
    return paramLayoutInflater;
  }
  
  public final void a(View paramView1, ArticleInfo paramArticleInfo, int paramInt, View paramView2)
  {
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "show, articleInfo = ", paramArticleInfo });
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Int = paramInt;
    a(paramArticleInfo);
    a(paramView1);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (a(paramArticleInfo))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843078));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843077));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843078));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    setOnDismissListener(new ReadInJoyFeedbackPopupWindow.2(this));
  }
  
  public void onClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
    dismiss();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      a("0X80095D4", 5);
      continue;
      c();
      a("0X80095D4", 7);
      continue;
      d();
      a("0X80095D4", 6);
      continue;
      a(0);
      a("0X80095D4", 1);
      continue;
      a(1);
      a("0X80095D4", 2);
      continue;
      a(2);
      a("0X80095D4", 3);
      continue;
      a(3);
      a("0X80095D4", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.FeedItemCellArk;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FrameworkHandler$ItemViewBuilder
{
  private DynamicItemViewHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public FrameworkHandler$ItemViewBuilder(FrameworkHandler paramFrameworkHandler) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      ArkAppMessage localArkAppMessage = ReadInJoyArkUtil.a(paramArticleInfo.mArkAppFeedsInfo);
      if (QLog.isColorLevel()) {
        QLog.d("FrameworkHandler", 2, new Object[] { "getArkAppView, position: ", Integer.valueOf(paramInt), ", articleInfo: ", paramArticleInfo, ", arkAppMessage: ", localArkAppMessage });
      }
      return a(paramArticleInfo, paramView, localArkAppMessage);
    }
    ReadInJoyArkUtil.b(paramView);
    return paramView;
  }
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.c(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.d(), null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a());
    View localView = CellFactory.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a());
    label266:
    String str;
    if (localView != null)
    {
      localView.setTag(2131381651, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("FrameworkHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131369928, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a());
      if (paramArticleInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrameworkHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != 1)
          {
            paramView.height = 1;
            localView.setLayoutParams(paramView);
          }
        }
        localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (localView != null) {
          break label424;
        }
        paramInt1 = 0;
        str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.c() + "";
        if (paramArticleInfo == null) {
          break label429;
        }
      }
    }
    label424:
    label429:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, str, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.b() + "", "", false);
      return localView;
      if (localView.getVisibility() != 0) {
        localView.setVisibility(0);
      }
      if (!(localView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
        break;
      }
      paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
      if (paramView.height == -2) {
        break;
      }
      paramView.height = -2;
      localView.setLayoutParams(paramView);
      break;
      QLog.w("FrameworkHandler", 1, "CellFactory.getView = null");
      break;
      paramInt1 = 1;
      break label266;
    }
  }
  
  private View a(View paramView, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, int paramInt1, int paramInt2)
  {
    paramArticleInfo2 = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo1, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.c(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.d(), paramArticleInfo2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a());
    paramArticleInfo2.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      ProteusSupportUtil.a((ProteusItemView)paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo2, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        l = System.currentTimeMillis();
        paramArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a();
        paramView.a().setTag(2131369928, paramArticleInfo1);
        paramView.setTag(2131381651, paramArticleInfo2);
        ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.setTag", System.currentTimeMillis() - l);
      }
      return paramView;
      l = System.currentTimeMillis();
      paramView = ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo1);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      ProteusSupportUtil.a(paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo2, paramInt2, "default_feeds");
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private View a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArkAppMessage paramArkAppMessage)
  {
    Object localObject2;
    if (paramBaseArticleInfo == null)
    {
      localObject2 = paramView;
      return localObject2;
    }
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof FeedItemCellArk))) {
      localObject1 = (FeedItemCellArk)paramView.getTag();
    }
    for (;;)
    {
      localObject2 = paramView;
      if (localObject1 == null) {
        break;
      }
      localObject2 = paramView;
      if (paramView == null) {
        break;
      }
      if (!ReadInJoyArkUtil.a(paramArkAppMessage)) {
        break label127;
      }
      ((FeedItemCellArk)localObject1).a(paramArkAppMessage, paramBaseArticleInfo);
      ((FeedItemCellArk)localObject1).a();
      ReadInJoyArkUtil.a(paramView);
      return paramView;
      localObject2 = new FeedItemCellArk(paramArkAppMessage, paramBaseArticleInfo);
      ReadInJoyArkUtil.a((FeedItemCellArk)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.b());
      localObject1 = localObject2;
      if (((FeedItemCellArk)localObject2).a() != null)
      {
        paramView = ((FeedItemCellArk)localObject2).a();
        paramView.setTag(localObject2);
        localObject1 = localObject2;
      }
    }
    label127:
    ReadInJoyArkUtil.a(paramArkAppMessage, 0);
    ReadInJoyArkUtil.b(paramView);
    return paramView;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, int paramInt1, int paramInt2)
  {
    paramArticleInfo2 = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo1, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.c(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.d(), paramArticleInfo2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.a((ProteusItemView)paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo2, paramInt2);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.convertview#bindData", System.currentTimeMillis() - l);
      paramView = (ProteusItemView)paramView;
    }
    for (;;)
    {
      paramArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a();
      if (paramView.a() != null) {
        paramView.a().setTag(2131369928, paramArticleInfo1);
      }
      paramView.setTag(2131381651, paramArticleInfo2);
      return paramView;
      l = System.currentTimeMillis();
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo1);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.a(paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a(), paramArticleInfo2, paramInt2);
      ReadInJoyPTSCostHelper.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a().a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersFrameworkHandler.a().a();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.ItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */
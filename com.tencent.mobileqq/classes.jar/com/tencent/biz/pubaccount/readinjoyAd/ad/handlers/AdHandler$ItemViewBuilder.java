package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager;
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyModelFactory;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class AdHandler$ItemViewBuilder
  implements PlayableItem
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public AdHandler$ItemViewBuilder(AdHandler paramAdHandler) {}
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    IReadInJoyModel localIReadInJoyModel = ((IReadInJoyModelFactory)QRoute.api(IReadInJoyModelFactory.class)).createReadInJoyModel(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), paramAbsBaseArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.b(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.c(), null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    long l;
    if ((paramView != null) && ((paramView instanceof IProteusItemView)))
    {
      l = System.currentTimeMillis();
      IProteusSupportUtil localIProteusSupportUtil = (IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class);
      paramView = (IProteusItemView)paramView;
      localIProteusSupportUtil.bindData(paramView, paramInt1, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), localIReadInJoyModel, paramInt2, "default_feeds");
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    else
    {
      l = System.currentTimeMillis();
      paramView = ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).getView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramAbsBaseArticleInfo);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindData(paramView, paramInt1, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), localIReadInJoyModel, paramInt2, "default_feeds");
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
    if ((paramView != null) && (paramView.a() != null))
    {
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a();
      paramView.a().setTag(2131369613, paramAbsBaseArticleInfo);
      paramView.setInternalTag(2131380884, localIReadInJoyModel);
      paramView.setInternalTag(this);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.a();
    this.jdField_a_of_type_Int = paramInt2;
    return paramView.a();
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
        ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).initAdapterProteus(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
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
  
  private View b(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = ((IReadInJoyModelFactory)QRoute.api(IReadInJoyModelFactory.class)).createReadInJoyModel(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), paramAbsBaseArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.b(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.c(), null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    View localView = ((ICellFactory)QRoute.api(ICellFactory.class)).getView(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    paramInt1 = 0;
    if (localView != null)
    {
      localView.setTag(2131380884, localObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("CellFactoryImpl.getView = ");
        paramView.append(localView.getTag().getClass().getSimpleName());
        QLog.d("AdHandler", 2, paramView.toString());
      }
      localView.setTag(2131369613, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
      if (paramAbsBaseArticleInfo == null)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getView() article is null, set view gone, position: ");
          paramView.append(paramInt2);
          QLog.d("AdHandler", 2, paramView.toString());
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
      }
      else
      {
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != -2)
          {
            paramView.height = -2;
            localView.setLayoutParams(paramView);
          }
        }
      }
    }
    else
    {
      QLog.w("AdHandler", 1, "CellFactoryImpl.getView = null");
    }
    localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (localView != null) {
      paramInt1 = 1;
    }
    paramView = new StringBuilder();
    paramView.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.b());
    paramView.append("");
    String str = paramView.toString();
    if (paramAbsBaseArticleInfo != null) {
      paramView = String.valueOf(paramAbsBaseArticleInfo.mArticleID);
    } else {
      paramView = "";
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    paramAbsBaseArticleInfo.append("");
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, str, paramView, paramAbsBaseArticleInfo.toString(), "", false);
    return localView;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public VideoPlayParam a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    if ((localObject1 != null) && ((localObject1 instanceof IProteusItemView)))
    {
      localObject1 = (IReadInJoyModel)((View)localObject1).getTag(2131380884);
      if (localObject1 != null)
      {
        Object localObject2 = ((IReadInJoyModel)localObject1).a();
        if (((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && ((((IReadInJoyModel)localObject1).d() == 6) || (((IReadInJoyModel)localObject1).d() == 66) || (((IReadInJoyModel)localObject1).d() == 115))) || (((IReadInJoyModel)localObject1).d() == 148))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a();
          if ((localIReadInJoyBaseAdapter != null) && (localIReadInJoyBaseAdapter.c() != null) && (localIReadInJoyBaseAdapter.b() != null) && ((localIReadInJoyBaseAdapter.b() instanceof IRecommendADVideoFeedsManager))) {
            return ((IRecommendADVideoFeedsManager)localIReadInJoyBaseAdapter.b()).a((AdvertisementInfo)localObject2, this.jdField_a_of_type_AndroidViewView, (IReadInJoyModel)localObject1);
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if ((paramView instanceof IProteusItemView))
      {
        paramView = (IReadInJoyModel)paramView.getTag(2131380884);
        bool1 = bool2;
        if (paramView != null)
        {
          Object localObject = paramView.a();
          bool1 = bool2;
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject)) {
            if ((paramView.d() != 6) && (paramView.d() != 66) && (paramView.d() != 115))
            {
              bool1 = bool2;
              if (paramView.d() != 148) {}
            }
            else
            {
              localObject = (AdvertisementInfo)localObject;
              if (TextUtils.isEmpty(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdExtParam((AbsBaseArticleInfo)localObject, "AdsIconText"))) {
                return false;
              }
              IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a();
              bool1 = bool2;
              if (localIReadInJoyBaseAdapter != null)
              {
                bool1 = bool2;
                if (localIReadInJoyBaseAdapter.c() != null)
                {
                  bool1 = bool2;
                  if (localIReadInJoyBaseAdapter.b() != null)
                  {
                    bool1 = bool2;
                    if ((localIReadInJoyBaseAdapter.b() instanceof IRecommendADVideoFeedsManager))
                    {
                      IRecommendADVideoFeedsManager localIRecommendADVideoFeedsManager = (IRecommendADVideoFeedsManager)localIReadInJoyBaseAdapter.b();
                      paramView = localIRecommendADVideoFeedsManager.a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
                      bool1 = bool2;
                      if (ReadInJoyAdSwitchUtil.a((AdvertisementInfo)localObject, null, localIReadInJoyBaseAdapter.a(), 1))
                      {
                        bool1 = bool2;
                        if (localIRecommendADVideoFeedsManager.a(paramView)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.ItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */
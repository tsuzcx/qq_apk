package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class AdHandler$ItemViewBuilder
  implements VideoHandler.PlayableItem
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public AdHandler$ItemViewBuilder(AdHandler paramAdHandler) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    ReadInJoyModelImpl localReadInJoyModelImpl = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.c(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.d(), null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      ProteusSupportUtil.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), localReadInJoyModelImpl, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      ReadInJoyPTSCostHelper.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a();
        paramView.a().setTag(2131369928, paramArticleInfo);
        paramView.setTag(2131381651, localReadInJoyModelImpl);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      ReadInJoyPTSCostHelper.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      ProteusSupportUtil.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), localReadInJoyModelImpl, paramInt2, "default_feeds");
      ReadInJoyPTSCostHelper.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
        ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
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
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.b(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.c(), paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.d(), null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    View localView = CellFactory.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
    label266:
    String str;
    if (localView != null)
    {
      localView.setTag(2131381651, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131369928, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a());
      if (paramArticleInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
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
        str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.c() + "";
        if (paramArticleInfo == null) {
          break label429;
        }
      }
    }
    label424:
    label429:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, str, paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.b() + "", "", false);
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
      QLog.w("AdHandler", 1, "CellFactory.getView = null");
      break;
      paramInt1 = 1;
      break label266;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      ReadInJoyModelImpl localReadInJoyModelImpl = (ReadInJoyModelImpl)this.jdField_a_of_type_AndroidViewView.getTag(2131381651);
      if (localReadInJoyModelImpl != null)
      {
        Object localObject = localReadInJoyModelImpl.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((localReadInJoyModelImpl.a() == 6) || (localReadInJoyModelImpl.a() == 66) || (localReadInJoyModelImpl.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a();
          if ((localReadInJoyBaseAdapter != null) && (localReadInJoyBaseAdapter.a() != null) && (localReadInJoyBaseAdapter.a() != null)) {
            return localReadInJoyBaseAdapter.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, localReadInJoyModelImpl);
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (ReadInJoyModelImpl)this.jdField_a_of_type_AndroidViewView.getTag(2131381651);
      if (paramView != null)
      {
        localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (!TextUtils.isEmpty(ReadinJoyActionUtil.a((ArticleInfo)localObject, "AdsIconText"))) {
            break label93;
          }
        }
      }
    }
    label93:
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter;
    do
    {
      return false;
      localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdHandlersAdHandler.a();
    } while ((localReadInJoyBaseAdapter == null) || (localReadInJoyBaseAdapter.a() == null) || (localReadInJoyBaseAdapter.a() == null));
    paramView = localReadInJoyBaseAdapter.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
    if ((ReadInJoyAdSwitchUtil.a((AdvertisementInfo)localObject, null, localReadInJoyBaseAdapter.a(), 1)) && (localReadInJoyBaseAdapter.a().a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.ItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mobileqq.kandian.ad.api.impl.RIJSurpriseVideoServiceImpl.AdPlayableItem;
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
  implements RIJSurpriseVideoServiceImpl.AdPlayableItem, PlayableItem
{
  private volatile boolean b = false;
  private VafContext c = new ReadInjoyContext();
  private int d;
  private View e;
  private boolean f;
  
  public AdHandler$ItemViewBuilder(AdHandler paramAdHandler) {}
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    IReadInJoyModel localIReadInJoyModel = ((IReadInJoyModelFactory)QRoute.api(IReadInJoyModelFactory.class)).createReadInJoyModel(this.a.c(), paramAbsBaseArticleInfo, paramInt1, this.a.a(), this.a.e(), paramInt2, this.a.g(), this.a.f(), null, this.a.b());
    long l;
    if ((paramView != null) && ((paramView instanceof IProteusItemView)))
    {
      l = System.currentTimeMillis();
      IProteusSupportUtil localIProteusSupportUtil = (IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class);
      paramView = (IProteusItemView)paramView;
      localIProteusSupportUtil.bindData(paramView, paramInt1, paramAbsBaseArticleInfo, this.c, this.a.i(), this.a.b(), localIReadInJoyModel, paramInt2, "default_feeds");
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    else
    {
      l = System.currentTimeMillis();
      paramView = ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).getView(this.c, paramInt1, paramAbsBaseArticleInfo);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindData(paramView, paramInt1, paramAbsBaseArticleInfo, this.c, this.a.i(), this.a.b(), localIReadInJoyModel, paramInt2, "default_feeds");
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
    if ((paramView != null) && (paramView.getContainer() != null))
    {
      paramAbsBaseArticleInfo = this.a.h();
      paramView.getContainer().setTag(2131436721, paramAbsBaseArticleInfo);
      paramView.setInternalTag(2131449867, localIReadInJoyModel);
      paramView.setInternalTag(this);
    }
    this.e = paramView.getProteusItemView();
    this.d = paramInt2;
    e();
    return paramView.getProteusItemView();
  }
  
  private boolean a(IReadInJoyModel paramIReadInJoyModel, boolean paramBoolean, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramIReadInJoyModel.o() == 152) && (paramBoolean))
    {
      if (this.e.getTop() + paramVideoPlayParam.h.getBottom() <= 0) {
        return false;
      }
      AdHandler.b(this.a).a(this.e, paramVideoPlayParam.d);
      return true;
    }
    return paramBoolean;
  }
  
  private View b(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = ((IReadInJoyModelFactory)QRoute.api(IReadInJoyModelFactory.class)).createReadInJoyModel(this.a.c(), paramAbsBaseArticleInfo, paramInt1, this.a.a(), this.a.e(), paramInt2, this.a.g(), this.a.f(), null, this.a.b());
    View localView = ((ICellFactory)QRoute.api(ICellFactory.class)).getView(paramInt2, localObject, paramInt1, paramView, this.a.c(), this.a.b(), this.a.i());
    paramInt1 = 0;
    if (localView != null)
    {
      localView.setTag(2131449867, localObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("CellFactoryImpl.getView = ");
        paramView.append(localView.getTag().getClass().getSimpleName());
        QLog.d("AdHandler", 2, paramView.toString());
      }
      localView.setTag(2131436721, this.a.h());
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
    paramView.append(this.a.e());
    paramView.append("");
    String str = paramView.toString();
    if (paramAbsBaseArticleInfo != null) {
      paramView = String.valueOf(paramAbsBaseArticleInfo.mArticleID);
    } else {
      paramView = "";
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append(this.a.a());
    paramAbsBaseArticleInfo.append("");
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, str, paramView, paramAbsBaseArticleInfo.toString(), "", false);
    return localView;
  }
  
  private void d()
  {
    try
    {
      if (!this.b)
      {
        this.c.setContext(this.a.c());
        this.c.setCurActivity(this.a.c());
        ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).initAdapterProteus(this.c, "default_feeds");
        this.b = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void e()
  {
    this.f = false;
    Object localObject = this.e;
    if ((localObject != null) && ((localObject instanceof IProteusItemView)))
    {
      localObject = (IReadInJoyModel)((View)localObject).getTag(2131449867);
      if (localObject != null)
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyModel)localObject).k();
        if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) && (((IReadInJoyModel)localObject).o() == 152)) {
          this.f = true;
        }
      }
    }
  }
  
  public VideoPlayParam a()
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && ((localObject1 instanceof IProteusItemView)))
    {
      localObject1 = (IReadInJoyModel)((View)localObject1).getTag(2131449867);
      if (localObject1 != null)
      {
        Object localObject2 = ((IReadInJoyModel)localObject1).k();
        if (((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2)) && ((((IReadInJoyModel)localObject1).o() == 6) || (((IReadInJoyModel)localObject1).o() == 66) || (((IReadInJoyModel)localObject1).o() == 115))) || (((IReadInJoyModel)localObject1).o() == 148) || (((IReadInJoyModel)localObject1).o() == 151) || (((IReadInJoyModel)localObject1).o() == 152) || (((IReadInJoyModel)localObject1).o() == 153))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = this.a.b();
          if ((localIReadInJoyBaseAdapter != null) && (localIReadInJoyBaseAdapter.q() != null) && (localIReadInJoyBaseAdapter.p() != null) && ((localIReadInJoyBaseAdapter.p() instanceof IRecommendADVideoFeedsManager))) {
            return ((IRecommendADVideoFeedsManager)localIReadInJoyBaseAdapter.p()).a((AdvertisementInfo)localObject2, this.e, (IReadInJoyModel)localObject1);
          }
        }
      }
    }
    return null;
  }
  
  public boolean a(View paramView)
  {
    paramView = this.e;
    if ((paramView != null) && ((paramView instanceof IProteusItemView)))
    {
      paramView = (IReadInJoyModel)paramView.getTag(2131449867);
      if (paramView != null)
      {
        Object localObject = paramView.k();
        if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject)) && ((paramView.o() == 6) || (paramView.o() == 66) || (paramView.o() == 115) || (paramView.o() == 148) || (paramView.o() == 151) || (paramView.o() == 152) || (paramView.o() == 153)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (TextUtils.isEmpty(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdExtParam((AbsBaseArticleInfo)localObject, "AdsIconText"))) {
            return false;
          }
          IReadInJoyBaseAdapter localIReadInJoyBaseAdapter = this.a.b();
          if ((localIReadInJoyBaseAdapter != null) && (localIReadInJoyBaseAdapter.q() != null) && (localIReadInJoyBaseAdapter.p() != null) && ((localIReadInJoyBaseAdapter.p() instanceof IRecommendADVideoFeedsManager)))
          {
            IRecommendADVideoFeedsManager localIRecommendADVideoFeedsManager = (IRecommendADVideoFeedsManager)localIReadInJoyBaseAdapter.p();
            VideoPlayParam localVideoPlayParam = localIRecommendADVideoFeedsManager.a((AdvertisementInfo)localObject, this.e, paramView);
            if (!ReadInJoyAdSwitchUtil.a((AdvertisementInfo)localObject, null, localIReadInJoyBaseAdapter.a(), 1)) {
              return false;
            }
            return a(paramView, localIRecommendADVideoFeedsManager.a(localVideoPlayParam), localVideoPlayParam);
          }
        }
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.ItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */
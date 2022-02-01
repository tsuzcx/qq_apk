package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.List;

class AdHandler$3
  extends ReadInJoyObserver
{
  AdHandler$3(AdHandler paramAdHandler) {}
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 101) {
      if (paramVarArgs != null)
      {
        if (paramVarArgs.length <= 0) {
          return;
        }
        paramObject = (ReadInJoyXListView)this.a.a().a();
        localObject1 = this.a.a().b();
        if (paramObject != null)
        {
          if (localObject1 == null) {
            return;
          }
          paramVarArgs = paramVarArgs[0];
        }
      }
    }
    try
    {
      int j = paramObject.getHeaderViewsCount();
      int i = paramObject.getFirstVisiblePosition();
      int k = paramObject.getLastVisiblePosition();
      paramInt = i;
      for (;;)
      {
        if (paramInt <= k)
        {
          int m;
          Object localObject2;
          Object localObject3;
          if (paramInt >= j)
          {
            m = paramInt - j;
            if (m < ((List)localObject1).size())
            {
              localObject2 = (AbsBaseArticleInfo)((List)localObject1).get(m);
              localObject3 = paramObject.getChildAt(paramInt - i);
              if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject2))
              {
                localObject2 = (AdvertisementInfo)localObject2;
                m = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getGameType((AdvertisementInfo)localObject2);
                String str = ReadInJoyAdUtils.a((AdvertisementInfo)localObject2);
                if ((m == 1) && (paramVarArgs.equals(str)) && ((localObject3 instanceof IProteusItemView)))
                {
                  localObject3 = ((IProteusItemView)localObject3).a().getVirtualView().findViewBaseByName("id_view_AdDownloadView");
                  if ((localObject3 instanceof RIJAdDownloadViewBase))
                  {
                    localObject3 = (RIJAdDownloadViewBase)localObject3;
                    if (((RIJAdDownloadViewBase)localObject3).a() != null) {
                      ((RIJAdDownloadViewBase)localObject3).a().a(true, (AdvertisementInfo)localObject2, paramVarArgs);
                    }
                  }
                }
              }
            }
          }
          paramInt += 1;
          continue;
          return;
          if (paramInt == 110) {
            try
            {
              paramObject = (ReadInJoyXListView)this.a.a().a();
              paramVarArgs = this.a.a().b();
              k = paramObject.getHeaderViewsCount();
              j = paramObject.getFirstVisiblePosition();
              m = paramObject.getLastVisiblePosition();
              paramInt = j;
              while (paramInt <= m)
              {
                if (paramInt >= k)
                {
                  i = paramInt - k;
                  if (i < paramVarArgs.size())
                  {
                    localObject1 = (AbsBaseArticleInfo)paramVarArgs.get(i);
                    localObject2 = paramObject.getChildAt(paramInt - j);
                    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject1))
                    {
                      localObject3 = (AdvertisementInfo)localObject1;
                      if (((AdvertisementInfo)localObject3).isHideForAnimate)
                      {
                        if (!paramBoolean)
                        {
                          i = 4;
                        }
                        else
                        {
                          ((AdvertisementInfo)localObject3).isHideForAnimate = false;
                          i = 0;
                        }
                        localObject2 = ((IProteusItemView)localObject2).a().getVirtualView();
                        if (((AdvertisementInfo)localObject3).mImaxShowAdType == 1001)
                        {
                          localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_article_large_imge");
                          if (localObject3 != null) {
                            ((ViewBase)localObject3).getNativeView().setVisibility(i);
                          }
                          localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_icon");
                          if (localObject3 != null) {
                            ((ViewBase)localObject3).getNativeView().setVisibility(4);
                          }
                          if ((NetworkState.isWifiConn()) && (i == 0))
                          {
                            if (localObject3 != null) {
                              ((ViewBase)localObject3).getNativeView().setVisibility(i);
                            }
                          }
                          else
                          {
                            localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_video_bg");
                            if (localObject3 != null) {
                              ((ViewBase)localObject3).getNativeView().setVisibility(i);
                            }
                          }
                          localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_view_Ad_CompleteGudie");
                          if (localObject3 != null) {
                            ((ViewBase)localObject3).getNativeView().setVisibility(4);
                          }
                          localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_activity_img");
                          if (localObject3 != null) {
                            ((ViewBase)localObject3).getNativeView().setVisibility(4);
                          }
                          localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_cover");
                          if (localObject3 != null) {
                            ((ViewBase)localObject3).getNativeView().setVisibility(i);
                          }
                          localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_duration");
                          if (localObject3 != null) {
                            ((ViewBase)localObject3).getNativeView().setVisibility(i);
                          }
                          if (((AdvertisementInfo)localObject1).isIMaxAndNewStyle)
                          {
                            localObject1 = ((ViewBase)localObject2).findViewBaseByName("id_artilce_title");
                            if (localObject1 != null) {
                              ((ViewBase)localObject1).getNativeView().setVisibility(i);
                            }
                          }
                        }
                        else if (((AdvertisementInfo)localObject3).mImaxShowAdType == 1002)
                        {
                          localObject1 = ((ViewBase)localObject2).findViewBaseByName("id_article_double_image");
                          if (localObject1 != null) {
                            ((ViewBase)localObject1).getNativeView().setVisibility(i);
                          }
                        }
                      }
                    }
                  }
                }
                paramInt += 1;
              }
              return;
            }
            catch (Exception paramObject)
            {
              if (QLog.isColorLevel())
              {
                paramVarArgs = new StringBuilder();
                paramVarArgs.append("error  =>");
                paramVarArgs.append(paramObject.getMessage());
                QLog.d("ReadInjoyIMAXAdFragment", 2, paramVarArgs.toString());
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.3
 * JD-Core Version:    0.7.0.1
 */
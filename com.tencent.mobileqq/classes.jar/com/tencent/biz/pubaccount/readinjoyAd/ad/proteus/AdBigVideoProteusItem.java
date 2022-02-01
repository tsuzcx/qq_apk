package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyAdVideoCompleteGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdLargeVideoCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.api.IRIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class AdBigVideoProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdLargeVideoCell.a(paramInt, paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((paramIReadInJoyModel != null) && ((paramIReadInJoyModel.k() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramIReadInJoyModel.k()).isHideForAnimate)) {
      return;
    }
    boolean bool = NetworkState.isWifiConn();
    Object localObject2 = null;
    Object localObject1;
    if (bool)
    {
      localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(0);
      }
      localObject1 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(8);
      }
      ((IRIJComponentConfigImage)QRoute.api(IRIJComponentConfigImage.class)).showOrHideFreeNetFlowHint(false, localViewBase, null);
    }
    else
    {
      localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(8);
      }
      localObject1 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(0);
      }
      NativeText localNativeText = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
      if (localNativeText != null)
      {
        localObject3 = HardCodeUtil.a(2131898085);
        if (CUKingCardUtils.a() == 1)
        {
          localObject1 = HardCodeUtil.a(2131898084);
        }
        else
        {
          localObject1 = localObject3;
          if (paramIReadInJoyModel != null)
          {
            AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
            localObject1 = localObject3;
            if ((localAbsBaseArticleInfo instanceof AdvertisementInfo))
            {
              long l = ((AdvertisementInfo)localAbsBaseArticleInfo).mAdVideoFileSize;
              localObject1 = localObject3;
              if (l > 0L)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).fileSizeToString(l));
                ((StringBuilder)localObject1).append(HardCodeUtil.a(2131898086));
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
          }
        }
        localNativeText.setText((CharSequence)localObject1);
      }
      Object localObject3 = (IRIJComponentConfigImage)QRoute.api(IRIJComponentConfigImage.class);
      localObject1 = localObject2;
      if (paramIReadInJoyModel != null) {
        localObject1 = paramIReadInJoyModel.k();
      }
      ((IRIJComponentConfigImage)localObject3).tryToShowFreeNetFlowHint(localViewBase, (AbsBaseArticleInfo)localObject1);
    }
    if ((paramIReadInJoyModel != null) && ((paramIReadInJoyModel.k() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramIReadInJoyModel.k()).isShowingGuide))
    {
      localObject1 = (AdvertisementInfo)paramIReadInJoyModel.k();
      localObject2 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject2 != null) {
        ((ViewBase)localObject2).setVisibility(8);
      }
      localObject2 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject2 != null) {
        ((ViewBase)localObject2).setVisibility(8);
      }
      localObject2 = localViewBase.findViewBaseByName("id_large_video_duration");
      if ((localObject2 != null) && (((ViewBase)localObject2).getNativeView() != null)) {
        ((ViewBase)localObject2).getNativeView().setVisibility(8);
      }
      paramContainer = ((View)paramContainer.getParent()).findViewById(2131427698);
      if (!(paramContainer instanceof ReadInJoyAdVideoGuide)) {
        break label592;
      }
      paramContainer.setVisibility(0);
    }
    try
    {
      localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
      ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd((AdvertisementInfo)localObject1), (AdvertisementInfo)localObject1);
    }
    catch (JSONException paramContainer)
    {
      label539:
      label592:
      break label539;
    }
    break label592;
    paramContainer = ((View)paramContainer.getParent()).findViewById(2131427698);
    if (paramContainer != null) {
      paramContainer.setVisibility(8);
    }
    paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
      paramContainer.getNativeView().setVisibility(0);
    }
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.k() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramIReadInJoyModel.k())))
    {
      paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
      if ((paramContainer instanceof ReadInJoyAdVideoCompleteGuide))
      {
        localObject1 = (AdvertisementInfo)paramIReadInJoyModel.k();
        paramContainer.setTag(localObject1);
        if (((AdvertisementInfo)localObject1).mChannelID == 0L) {
          paramContainer.setVisibility(0);
        } else if ((((AdvertisementInfo)localObject1).isShowingGuide) && (((AdvertisementInfo)localObject1).mShowAdButton)) {
          paramContainer.setVisibility(0);
        } else {
          paramContainer.setVisibility(8);
        }
      }
    }
    if ((paramIReadInJoyModel != null) && ((paramIReadInJoyModel.k() instanceof AdvertisementInfo)) && (bool))
    {
      paramContainer = localViewBase.findViewBaseByName("id_article_bubble_view");
      if ((paramContainer instanceof ReadInJoyAdBubbleView)) {
        ((ReadInJoyAdBubbleView)paramContainer).a(false);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */
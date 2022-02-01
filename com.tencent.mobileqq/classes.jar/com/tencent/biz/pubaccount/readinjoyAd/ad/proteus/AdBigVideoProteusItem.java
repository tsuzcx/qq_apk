package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdLargeVideoCell;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAdVideoCompleteGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
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
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ReadInJoyAdLargeVideoCell.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((paramIReadInJoyModel != null) && ((paramIReadInJoyModel.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramIReadInJoyModel.a()).isHideForAnimate)) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (NetworkState.isWifiConn())
      {
        localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
        if (localObject1 != null) {
          ((ViewBase)localObject1).setVisibility(0);
        }
        localObject1 = localViewBase.findViewBaseByName("id_video_bg");
        if (localObject1 != null) {
          ((ViewBase)localObject1).setVisibility(8);
        }
        ReadInJoyDisplayUtils.a(false, localViewBase, null);
        if ((paramIReadInJoyModel == null) || (!(paramIReadInJoyModel.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramIReadInJoyModel.a()).isShowingGuide)) {
          break label535;
        }
        localObject1 = (AdvertisementInfo)paramIReadInJoyModel.a();
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
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131362091);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, ReadInJoyAdUtils.b((AdvertisementInfo)localObject1), (AdvertisementInfo)localObject1);
        while ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramIReadInJoyModel.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if (!(paramContainer instanceof ReadInJoyAdVideoCompleteGuide)) {
            break;
          }
          paramIReadInJoyModel = (AdvertisementInfo)paramIReadInJoyModel.a();
          paramContainer.setTag(paramIReadInJoyModel);
          if (paramIReadInJoyModel.mChannelID != 0L) {
            break label588;
          }
          paramContainer.setVisibility(0);
          return;
          localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
          if (localObject1 != null) {
            ((ViewBase)localObject1).setVisibility(8);
          }
          localObject1 = localViewBase.findViewBaseByName("id_video_bg");
          if (localObject1 != null) {
            ((ViewBase)localObject1).setVisibility(0);
          }
          localObject2 = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
          if (localObject2 != null)
          {
            localObject1 = HardCodeUtil.a(2131699897);
            if (CUKingCardHelper.a() == 1)
            {
              localObject1 = HardCodeUtil.a(2131699896);
              label432:
              ((NativeText)localObject2).setText((CharSequence)localObject1);
            }
          }
          else
          {
            if (paramIReadInJoyModel == null) {
              break label529;
            }
          }
          label529:
          for (localObject1 = paramIReadInJoyModel.a();; localObject1 = null)
          {
            ReadInJoyDisplayUtils.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (paramIReadInJoyModel == null) {
              break label619;
            }
            ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
            if (!(localArticleInfo instanceof AdvertisementInfo)) {
              break label619;
            }
            long l = ((AdvertisementInfo)localArticleInfo).mAdVideoFileSize;
            if (l <= 0L) {
              break label619;
            }
            localObject1 = VideoFeedsHelper.b(l) + HardCodeUtil.a(2131699898);
            break label432;
          }
          label535:
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131362091);
          if (paramContainer != null) {
            paramContainer.setVisibility(8);
          }
          paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
          if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
            paramContainer.getNativeView().setVisibility(0);
          }
        }
        label588:
        if ((paramIReadInJoyModel.isShowingGuide) && (paramIReadInJoyModel.mShowAdButton))
        {
          paramContainer.setVisibility(0);
          return;
        }
        paramContainer.setVisibility(8);
        return;
      }
      catch (JSONException paramContainer)
      {
        label619:
        for (;;) {}
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */
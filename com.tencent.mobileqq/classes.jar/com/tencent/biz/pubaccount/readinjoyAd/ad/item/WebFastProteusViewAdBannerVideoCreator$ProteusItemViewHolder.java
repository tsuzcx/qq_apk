package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder
  extends WebFastBaseProteusItemHolder
{
  private ReadInJoyArticleBottomVideoView n = null;
  private ReadInjoyImageView o = null;
  private ReadInjoyTextView p = null;
  
  public WebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramBaseData, paramWeakReference, localWeakReference);
    if (paramBaseData != null)
    {
      paramView = (Container)paramBaseData;
      if (paramView.getVirtualView() != null)
      {
        if (this.n == null)
        {
          this.n = ((ReadInJoyArticleBottomVideoView)paramView.getVirtualView().findViewBaseByName("id_ad_banner_bottom_video"));
          paramView = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          paramWeakReference = new StringBuilder();
          paramWeakReference.append("bottomView create - item:");
          paramWeakReference.append(this.n.hashCode());
          paramView.d("VideoPlayerWrapper_AD", paramWeakReference.toString());
        }
        try
        {
          if (this.o == null) {
            this.o = ((ReadInjoyImageView)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_ad_title_mask"));
          }
          if (this.p == null)
          {
            this.p = ((ReadInjoyTextView)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_tv_title_inner"));
            return;
          }
        }
        catch (Exception paramView)
        {
          paramBaseData = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          paramWeakReference = new StringBuilder();
          paramWeakReference.append("ProteusItemViewHolder create error: ");
          paramWeakReference.append(paramView.getMessage());
          paramBaseData.d("WebFastProteusViewAdBannerVideoCreator", paramWeakReference.toString());
        }
      }
    }
  }
  
  private void a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (paramProteusBannerVideoItemData1 != null)
    {
      Object localObject = this.n;
      if (localObject == null) {
        return;
      }
      ((ReadInJoyArticleBottomVideoView)localObject).setVisibility(0);
      localObject = new AdModuleVideo();
      AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramProteusBannerVideoItemData1);
      ((AdModuleVideo)localObject).r = paramProteusBannerVideoItemData1.n;
      ((AdModuleVideo)localObject).p = paramProteusBannerVideoItemData1.G;
      this.n.a((AdModuleVideo)localObject, localAdvertisementInfo, paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2);
      if (paramProteusBannerVideoItemData1.a) {
        this.n.e();
      }
    }
  }
  
  protected void a() {}
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.a.getVirtualView(), new WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.1(this, paramBaseData, paramContext));
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return paramBaseData1 == paramBaseData2;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    if (!(paramBaseData1 instanceof ProteusBannerVideoItemData)) {
      return;
    }
    if ((paramBaseData2 != null) && (paramBaseData2.aP == 17))
    {
      paramBaseData2 = (ProteusBannerVideoItemData)paramBaseData2;
      a((ProteusBannerVideoItemData)paramBaseData1, paramBaseData2);
      return;
    }
    a((ProteusBannerVideoItemData)paramBaseData1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */
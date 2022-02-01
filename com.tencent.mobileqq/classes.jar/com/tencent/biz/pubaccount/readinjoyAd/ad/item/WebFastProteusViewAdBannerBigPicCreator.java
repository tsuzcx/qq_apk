package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAdtUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public class WebFastProteusViewAdBannerBigPicCreator
  extends WebFastBaseProteusAdCreator
{
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    return new WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder(this, paramView, paramBaseData, this.b);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.aP == 10);
  }
  
  public int b(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusBannerBigPicItemData)) {
      return FastWebAdtUtil.a((ProteusBannerBigPicItemData)paramBaseData);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerBigPicCreator
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;

public class WebFastProteusViewAdBannerBigPicCreator
  extends WebFastBaseProteusAdCreator
{
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerBigPicItemData)) {
      i = FastWeqAdUtils.a((ProteusBannerBigPicItemData)paramBaseData);
    }
    return i;
  }
  
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    return new WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder(this, paramView, paramBaseData, this.a);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.s == 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerBigPicCreator
 * JD-Core Version:    0.7.0.1
 */
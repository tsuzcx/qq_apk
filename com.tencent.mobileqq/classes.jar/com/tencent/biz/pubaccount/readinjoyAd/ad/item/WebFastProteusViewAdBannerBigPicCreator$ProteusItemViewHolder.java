package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder
  extends WebFastBaseProteusItemHolder
{
  public WebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramBaseData, paramWeakReference, localWeakReference);
  }
  
  public void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder.1(this, paramBaseData, paramContext));
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return (paramBaseData1 == paramBaseData2) && ((paramBaseData2 instanceof ProteusBannerBigPicItemData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */
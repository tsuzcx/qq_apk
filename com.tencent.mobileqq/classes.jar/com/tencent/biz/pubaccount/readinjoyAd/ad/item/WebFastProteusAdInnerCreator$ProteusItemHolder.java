package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastProteusAdInnerCreator$ProteusItemHolder
  extends WebFastBaseProteusItemHolder
{
  public WebFastProteusAdInnerCreator$ProteusItemHolder(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramBaseData, paramWeakReference, localWeakReference);
  }
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new WebFastProteusAdInnerCreator.ProteusItemHolder.1(this, paramContext));
  }
  
  protected void a(Container paramContainer, ProteusItemData paramProteusItemData)
  {
    super.a(paramContainer, paramProteusItemData);
    if (paramContainer != null)
    {
      ViewBase localViewBase1 = paramContainer.getVirtualView();
      if (((paramProteusItemData instanceof AdData)) && (((AdData)paramProteusItemData).a != null) && (FastWeqAdUtils.a((AdData)paramProteusItemData)))
      {
        ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_inner_small_img");
        if (((localViewBase2 instanceof ReadInjoyImageView)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.k))) {
          FastWeqAdUtils.a(paramContainer.getContext(), localViewBase2, ((AdData)paramProteusItemData).a.k, 10);
        }
        localViewBase2 = localViewBase1.findViewBaseByName("id_inner_game_img1");
        if (((localViewBase2 instanceof ReadInjoyImageView)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.d))) {
          FastWeqAdUtils.a(paramContainer.getContext(), localViewBase2, ((AdData)paramProteusItemData).a.a.d, 10);
        }
        localViewBase2 = localViewBase1.findViewBaseByName("id_inner_game_img2");
        if (((localViewBase2 instanceof ReadInjoyImageView)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.e))) {
          FastWeqAdUtils.a(paramContainer.getContext(), localViewBase2, ((AdData)paramProteusItemData).a.a.e, 10);
        }
        localViewBase1 = localViewBase1.findViewBaseByName("id_inner_game_img3");
        if (((localViewBase1 instanceof ReadInjoyImageView)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.f))) {
          FastWeqAdUtils.a(paramContainer.getContext(), localViewBase1, ((AdData)paramProteusItemData).a.a.f, 10);
        }
      }
    }
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator.ProteusItemHolder
 * JD-Core Version:    0.7.0.1
 */
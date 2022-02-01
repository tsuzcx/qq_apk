package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastProteusAdInnerCreator$ProteusItemHolder
  extends WebFastBaseProteusItemHolder
{
  public WebFastProteusAdInnerCreator$ProteusItemHolder(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramBaseData, paramWeakReference, localWeakReference);
  }
  
  protected void a(Container paramContainer, ProteusItemData paramProteusItemData)
  {
    super.a(paramContainer, paramProteusItemData);
    if (paramContainer != null)
    {
      ViewBase localViewBase1 = paramContainer.getVirtualView();
      if ((paramProteusItemData instanceof AdData))
      {
        paramProteusItemData = (AdData)paramProteusItemData;
        if ((paramProteusItemData.a != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramProteusItemData)))
        {
          ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_inner_small_img");
          if (((localViewBase2 instanceof ReadInjoyImageView)) && (paramProteusItemData.a.a != null) && (!TextUtils.isEmpty(paramProteusItemData.a.k))) {
            FastWeqAdUtils.a(paramContainer.getContext(), localViewBase2, paramProteusItemData.a.k, 10);
          }
          localViewBase2 = localViewBase1.findViewBaseByName("id_inner_game_img1");
          if (((localViewBase2 instanceof ReadInjoyImageView)) && (paramProteusItemData.a.a != null) && (!TextUtils.isEmpty(paramProteusItemData.a.a.d))) {
            FastWeqAdUtils.a(paramContainer.getContext(), localViewBase2, paramProteusItemData.a.a.d, 10);
          }
          localViewBase2 = localViewBase1.findViewBaseByName("id_inner_game_img2");
          if (((localViewBase2 instanceof ReadInjoyImageView)) && (paramProteusItemData.a.a != null) && (!TextUtils.isEmpty(paramProteusItemData.a.a.e))) {
            FastWeqAdUtils.a(paramContainer.getContext(), localViewBase2, paramProteusItemData.a.a.e, 10);
          }
          localViewBase1 = localViewBase1.findViewBaseByName("id_inner_game_img3");
          if (((localViewBase1 instanceof ReadInjoyImageView)) && (paramProteusItemData.a.a != null) && (!TextUtils.isEmpty(paramProteusItemData.a.a.f))) {
            FastWeqAdUtils.a(paramContainer.getContext(), localViewBase1, paramProteusItemData.a.a.f, 10);
          }
        }
      }
    }
  }
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new WebFastProteusAdInnerCreator.ProteusItemHolder.1(this, paramContext));
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator.ProteusItemHolder
 * JD-Core Version:    0.7.0.1
 */
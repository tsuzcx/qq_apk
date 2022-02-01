package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyAdBrandOptimizationCell;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView;
import org.json.JSONObject;

public class AdBrandOptimizationProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ReadInjoyAdBrandOptimizationCell.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject;
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramIReadInJoyModel.a())))
    {
      localObject = paramContainer.findViewBaseByName("id_article_brand_optimization");
      TemplateBean localTemplateBean = paramIReadInJoyModel.a().mProteusTemplateBean;
      paramContainer = null;
      if (localTemplateBean != null) {
        paramContainer = localTemplateBean.findViewById("id_top_left_mask");
      }
      if ((localObject instanceof ReadInJoyAdBrandOptimizationView))
      {
        localObject = (ReadInJoyAdBrandOptimizationView)localObject;
        ((ReadInJoyAdBrandOptimizationView)localObject).a(paramIReadInJoyModel);
        if (paramContainer == null) {
          break label96;
        }
        ((ReadInJoyAdBrandOptimizationView)localObject).a(true);
      }
    }
    return;
    label96:
    ((ReadInJoyAdBrandOptimizationView)localObject).a(false);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBrandOptimizationProteusItem
 * JD-Core Version:    0.7.0.1
 */
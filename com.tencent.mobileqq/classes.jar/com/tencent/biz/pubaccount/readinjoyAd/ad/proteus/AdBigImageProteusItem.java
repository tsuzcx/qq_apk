package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInjoyAdLargeImgCell;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView;
import org.json.JSONObject;

public class AdBigImageProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ReadInjoyAdLargeImgCell.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramIReadInJoyModel.a())))
    {
      paramContainer = paramContainer.findViewBaseByName("id_article_double_image");
      if ((paramContainer instanceof ReadInjoyDoubleImageView)) {
        ((ReadInjoyDoubleImageView)paramContainer).a(paramIReadInJoyModel);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigImageProteusItem
 * JD-Core Version:    0.7.0.1
 */
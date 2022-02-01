package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class WebFastProteusViewAdCreator$ProteusItemViewHolder
  extends BaseItemViewHolder
{
  private Container b;
  private ProteusItemData c;
  
  public WebFastProteusViewAdCreator$ProteusItemViewHolder(WebFastProteusViewAdCreator paramWebFastProteusViewAdCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.b = ((Container)paramView);
    }
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.b.getVirtualView(), new WebFastProteusViewAdCreator.ProteusItemViewHolder.1(this, paramContext));
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (paramBaseData2 == null) {
        return;
      }
      if ((paramBaseData2 instanceof ProteusItemData))
      {
        this.c = ((ProteusItemData)paramBaseData2);
        paramBaseData1 = this.c.bd;
        if (paramBaseData1 != null)
        {
          WebFastProteusViewAdCreator.a(this.a, this.b);
          if ((paramBaseData2 instanceof RecommendAdData)) {
            WebFastProteusViewAdCreator.a(this.a, this.b, (RecommendAdData)paramBaseData2);
          }
          try
          {
            paramBaseData1.bindData(this.c.bb);
            ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindDynamicValue(this.b.getVirtualView(), this.c.bd.getViewBean());
            this.g = this.c;
          }
          catch (Exception paramBaseData1)
          {
            ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("WebFastProteusViewAdCreator", paramBaseData1.getMessage());
          }
          a(WebFastProteusViewAdCreator.a(this.a), this.c.bb);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */
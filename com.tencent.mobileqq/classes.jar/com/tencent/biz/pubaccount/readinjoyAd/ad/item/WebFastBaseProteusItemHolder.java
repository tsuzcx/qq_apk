package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastBaseProteusItemHolder
  extends BaseItemViewHolder
{
  public Container a;
  protected ProteusItemData b;
  protected WeakReference<Context> c;
  
  public WebFastBaseProteusItemHolder(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.a = ((Container)paramView);
    }
    this.c = paramWeakReference;
  }
  
  protected void a() {}
  
  protected void a(Container paramContainer, ProteusItemData paramProteusItemData)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      if ((paramProteusItemData instanceof AdData))
      {
        paramProteusItemData = (AdData)paramProteusItemData;
        if ((paramProteusItemData.as != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(paramProteusItemData)))
        {
          localViewBase = localViewBase.findViewBaseByName("id_game_small_img");
          if (((localViewBase instanceof ReadInjoyImageView)) && (!TextUtils.isEmpty(paramProteusItemData.aa)))
          {
            int i = AIOUtils.b(40.0F, paramContainer.getContext().getResources());
            FastWeqAdUtils.a(paramContainer.getContext(), localViewBase, paramProteusItemData.aa, 10, i, i);
          }
        }
      }
    }
  }
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject) {}
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (this.a != null)
    {
      if (paramBaseData2 == null) {
        return;
      }
      if ((paramBaseData2 instanceof ProteusItemData))
      {
        this.b = ((ProteusItemData)paramBaseData2);
        TemplateBean localTemplateBean = this.b.bd;
        if (localTemplateBean != null)
        {
          if (a(paramBaseData1, paramBaseData2)) {
            a(this.a, this.b);
          }
          if (paramBaseData1 != paramBaseData2) {
            try
            {
              localTemplateBean.bindData(this.b.bb);
              ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindDynamicValue(this.a.getVirtualView(), this.b.bd.getViewBean());
              this.g = this.b;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          b(paramBaseData2, paramBaseData1);
          paramBaseData1 = this.c;
          if (paramBaseData1 != null) {
            a(paramBaseData2, (Context)paramBaseData1.get(), this.b.bb);
          }
          this.f.setTag(2131427733, paramBaseData2);
          a();
        }
      }
    }
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return false;
  }
  
  protected void b(BaseData paramBaseData1, BaseData paramBaseData2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastBaseProteusItemHolder
 * JD-Core Version:    0.7.0.1
 */
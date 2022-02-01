package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastBaseProteusAdCreator
  implements IStateChangeListener, ItemCreator
{
  protected VafContext a;
  protected WeakReference<Context> b = null;
  protected BaseItemViewHolder c = null;
  protected BaseData d;
  private View e;
  private RIJAdDownloadViewBase f;
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      this.a = new ReadInjoyContext();
      this.a.setContext(paramContext);
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).initAdapterProteus(this.a, "native_article");
    }
    if (this.b == null) {
      this.b = new WeakReference(paramContext);
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    try
    {
      this.e = this.a.getViewFactory().inflate(this.a, localProteusItemData.bd);
      paramViewGroup = ((Container)this.e).getVirtualView();
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindDynamicValue(paramViewGroup, localProteusItemData.bd.getViewBean());
      paramViewGroup = localProteusItemData.bb.toString();
    }
    catch (Exception paramViewGroup)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error!! msg=");
      localStringBuilder.append(paramViewGroup.toString());
      paramViewGroup = localStringBuilder.toString();
    }
    boolean bool = false;
    if (this.e == null)
    {
      this.e = new View(paramContext);
      bool = true;
    }
    this.e.setTag(paramBaseData);
    paramContext = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramBaseData = new StringBuilder();
    paramBaseData.append("createViewHolder viewIsNull=");
    paramBaseData.append(bool);
    paramBaseData.append("  proteusData=");
    paramBaseData.append(paramViewGroup);
    paramContext.d("WebFastBaseProteusAdCreator", paramBaseData.toString());
    this.c = a(this.e, localProteusItemData);
    if (this.f == null)
    {
      paramContext = this.e;
      if (((paramContext instanceof Container)) && (((Container)paramContext).getVirtualView() != null)) {
        this.f = ((RIJAdDownloadViewBase)((Container)this.e).getVirtualView().findViewBaseByName("id_view_AdDownloadView"));
      }
    }
    return this.c;
  }
  
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return false;
  }
  
  public int b(BaseData paramBaseData)
  {
    return 0;
  }
  
  public void b()
  {
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onResume();
    Object localObject2 = this.c;
    if ((localObject2 instanceof WebFastBaseProteusItemHolder))
    {
      Object localObject1 = null;
      localObject2 = ((BaseItemViewHolder)localObject2).f;
      if ((localObject2 instanceof Container)) {
        localObject1 = (Container)localObject2;
      }
      if (localObject1 == null) {
        return;
      }
      if (((Container)localObject1).getVirtualView() == null) {
        return;
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((RIJAdDownloadViewBase)localObject1).b();
      }
    }
  }
  
  public void c()
  {
    RIJAdDownloadViewBase localRIJAdDownloadViewBase = this.f;
    if (localRIJAdDownloadViewBase != null) {
      localRIJAdDownloadViewBase.c();
    }
  }
  
  public void d()
  {
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onDestroy();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastBaseProteusAdCreator
 * JD-Core Version:    0.7.0.1
 */
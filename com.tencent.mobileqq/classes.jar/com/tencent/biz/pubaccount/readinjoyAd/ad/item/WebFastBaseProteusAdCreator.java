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
  private View jdField_a_of_type_AndroidViewView;
  protected VafContext a;
  private RIJAdDownloadViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase;
  protected BaseItemViewHolder a;
  protected BaseData a;
  protected WeakReference<Context> a;
  
  public WebFastBaseProteusAdCreator()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder = null;
  }
  
  public int a(BaseData paramBaseData)
  {
    return 0;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder;
    if (paramViewGroup != null) {
      return paramViewGroup;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).initAdapterProteus(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    try
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramViewGroup = ((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView();
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindDynamicValue(paramViewGroup, localProteusItemData.a.getViewBean());
      paramViewGroup = localProteusItemData.c.toString();
    }
    catch (Exception paramViewGroup)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error!! msg=");
      localStringBuilder.append(paramViewGroup.toString());
      paramViewGroup = localStringBuilder.toString();
    }
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(paramContext);
      bool = true;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(paramBaseData);
    paramContext = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramBaseData = new StringBuilder();
    paramBaseData.append("createViewHolder viewIsNull=");
    paramBaseData.append(bool);
    paramBaseData.append("  proteusData=");
    paramBaseData.append(paramViewGroup);
    paramContext.d("WebFastBaseProteusAdCreator", paramBaseData.toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder = a(this.jdField_a_of_type_AndroidViewView, localProteusItemData);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase == null)
    {
      paramContext = this.jdField_a_of_type_AndroidViewView;
      if (((paramContext instanceof Container)) && (((Container)paramContext).getVirtualView() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase = ((RIJAdDownloadViewBase)((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView().findViewBaseByName("id_view_AdDownloadView"));
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder;
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
  
  public void b()
  {
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onResume();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder;
    if ((localObject2 instanceof WebFastBaseProteusItemHolder))
    {
      Object localObject1 = null;
      localObject2 = ((BaseItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView;
      if ((localObject2 instanceof Container)) {
        localObject1 = (Container)localObject2;
      }
      if (localObject1 == null) {
        return;
      }
      if (((Container)localObject1).getVirtualView() == null) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase;
      if (localObject1 != null) {
        ((RIJAdDownloadViewBase)localObject1).a();
      }
    }
  }
  
  public void c()
  {
    RIJAdDownloadViewBase localRIJAdDownloadViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase;
    if (localRIJAdDownloadViewBase != null) {
      localRIJAdDownloadViewBase.b();
    }
  }
  
  public void d()
  {
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onDestroy();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastBaseProteusAdCreator
 * JD-Core Version:    0.7.0.1
 */
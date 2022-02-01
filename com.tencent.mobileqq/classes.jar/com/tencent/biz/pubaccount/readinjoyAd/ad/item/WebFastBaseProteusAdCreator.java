package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.ItemCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.OnStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastBaseProteusAdCreator
  implements ItemCreator, OnStateChangeListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected BaseData a;
  protected BaseItemViewHolder a;
  protected FastWebRecommendAdHelper a;
  protected VafContext a;
  private RIJAdDownloadViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase;
  protected WeakReference<Context> a;
  
  public WebFastBaseProteusAdCreator()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRecommendAdHelper = new FastWebRecommendAdHelper();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder = null;
  }
  
  public int a(BaseData paramBaseData)
  {
    return 0;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    try
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      ProteusSupportUtil.a(((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = localProteusItemData.c.toString();
      boolean bool = false;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(paramContext);
        bool = true;
      }
      this.jdField_a_of_type_AndroidViewView.setTag(paramBaseData);
      ReadInJoyAdLog.a("WebFastBaseProteusAdCreator", "createViewHolder viewIsNull=" + bool + "  proteusData=" + paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder = a(this.jdField_a_of_type_AndroidViewView, localProteusItemData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase == null) && ((this.jdField_a_of_type_AndroidViewView instanceof Container)) && (((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView() != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase = ((RIJAdDownloadViewBase)((Container)this.jdField_a_of_type_AndroidViewView).getVirtualView().findViewBaseByName("id_view_AdDownloadView"));
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup = "error!! msg=" + paramViewGroup.toString();
      }
    }
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRecommendAdHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRecommendAdHelper.a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder instanceof WebFastBaseProteusItemHolder))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder.jdField_a_of_type_AndroidViewView;
      if (!(localObject instanceof Container)) {
        break label71;
      }
    }
    label71:
    for (Object localObject = (Container)localObject;; localObject = null)
    {
      if (localObject == null) {}
      while ((((Container)localObject).getVirtualView() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase == null)) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase.a();
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJAdDownloadViewBase.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRecommendAdHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebRecommendAdHelper.b();
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastBaseProteusAdCreator
 * JD-Core Version:    0.7.0.1
 */
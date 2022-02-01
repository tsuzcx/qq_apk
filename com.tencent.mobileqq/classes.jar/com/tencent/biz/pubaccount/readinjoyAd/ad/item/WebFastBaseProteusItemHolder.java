package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class WebFastBaseProteusItemHolder
  extends BaseItemViewHolder
{
  protected ProteusItemData a;
  public Container a;
  protected WeakReference<Context> a;
  
  public WebFastBaseProteusItemHolder(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject) {}
  
  protected void a(BaseData paramBaseData1, BaseData paramBaseData2) {}
  
  protected void a(Container paramContainer, ProteusItemData paramProteusItemData)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      if (((paramProteusItemData instanceof AdData)) && (((AdData)paramProteusItemData).a != null) && (FastWeqAdUtils.a((AdData)paramProteusItemData)))
      {
        localViewBase = localViewBase.findViewBaseByName("id_game_small_img");
        if (((localViewBase instanceof ReadInjoyImageView)) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).B)))
        {
          int i = AIOUtils.a(40.0F, paramContainer.getContext().getResources());
          FastWeqAdUtils.a(paramContainer.getContext(), localViewBase, ((AdData)paramProteusItemData).B, 10, i, i);
        }
      }
    }
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return false;
  }
  
  protected void b() {}
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    TemplateBean localTemplateBean;
    do
    {
      do
      {
        return;
      } while (!(paramBaseData2 instanceof ProteusItemData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData = ((ProteusItemData)paramBaseData2);
      localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a;
    } while (localTemplateBean == null);
    if (a(paramBaseData1, paramBaseData2)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
    }
    if (paramBaseData1 != paramBaseData2) {}
    try
    {
      localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
      a(paramBaseData2, paramBaseData1);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        a(paramBaseData2, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      }
      this.jdField_a_of_type_AndroidViewView.setTag(2131362123, paramBaseData2);
      b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastBaseProteusItemHolder
 * JD-Core Version:    0.7.0.1
 */
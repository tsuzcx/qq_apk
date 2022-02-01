package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

class RIJListViewGroupHandlerClick$2$1
  implements Runnable
{
  RIJListViewGroupHandlerClick$2$1(RIJListViewGroupHandlerClick.2 param2, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    RIJListViewGroupHandlerClick.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder);
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder.a().getCount();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.b < i)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder.a().getItem(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.b);
      if ((localObject instanceof ArticleInfo))
      {
        localObject = (ArticleInfo)localObject;
        ((ArticleInfo)localObject).setSearchWordInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJListViewGroupHandlerClick$Builder.a().getString(2131693568), this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField, this.jdField_a_of_type_ComTencentMobileqqPbPBStringField);
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick.2.1
 * JD-Core Version:    0.7.0.1
 */
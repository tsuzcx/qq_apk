package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils;
import com.tencent.qphone.base.util.QLog;

class StyleLoaderHelper$DummyCallback$1
  implements Runnable
{
  StyleLoaderHelper$DummyCallback$1(StyleLoaderHelper.DummyCallback paramDummyCallback, String paramString, int paramInt) {}
  
  public void run()
  {
    QLog.d("TemplateFactory", 1, "check style config param: " + this.jdField_a_of_type_JavaLangString + " code: " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleLoaderHelper$DummyCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    ProteusCDNUtils.a(StyleLoaderHelper.DummyCallback.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleLoaderHelper$DummyCallback), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback.1
 * JD-Core Version:    0.7.0.1
 */
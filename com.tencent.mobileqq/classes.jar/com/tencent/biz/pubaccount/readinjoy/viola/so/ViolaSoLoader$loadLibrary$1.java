package com.tencent.biz.pubaccount.readinjoy.viola.so;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.LoadLibCallback;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resCode", "", "<anonymous parameter 1>", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "kotlin.jvm.PlatformType", "onLoadResult"}, k=3, mv={1, 1, 16})
final class ViolaSoLoader$loadLibrary$1
  implements OnLoadListener
{
  ViolaSoLoader$loadLibrary$1(ViolaSoLoader paramViolaSoLoader, ReadInJoyWebRenderEngine.LoadLibCallback paramLoadLibCallback, String paramString) {}
  
  public final void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      ViolaSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader, true);
      paramLoadExtResult = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine$LoadLibCallback;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.onFinish(ReadInJoyWebRenderEngine.f);
      }
      ViolaSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader, 0);
      QLog.d("ViolaSoLoader", 1, "load viola so success, from: " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    ViolaSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader, false);
    if (ViolaSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader) < 3)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine$LoadLibCallback);
      paramLoadExtResult = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader;
      ViolaSoLoader.a(paramLoadExtResult, ViolaSoLoader.a(paramLoadExtResult) + 1);
      QLog.e("ViolaSoLoader", 1, "load viola so error, from: " + this.jdField_a_of_type_JavaLangString + ", retryCount: " + ViolaSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader));
      return;
    }
    ViolaSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaSoViolaSoLoader, 0);
    paramLoadExtResult = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyWebRenderEngine$LoadLibCallback;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.onError(paramInt);
    }
    QLog.d("ViolaSoLoader", 1, "load viola so error, from: " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoader.loadLibrary.1
 * JD-Core Version:    0.7.0.1
 */
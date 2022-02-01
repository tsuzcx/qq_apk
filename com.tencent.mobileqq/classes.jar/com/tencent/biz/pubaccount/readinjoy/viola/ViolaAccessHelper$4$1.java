package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class ViolaAccessHelper$4$1
  implements AsyncBack
{
  ViolaAccessHelper$4$1(ViolaAccessHelper.4 param4) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "downOffline  code " + paramInt + "  param " + paramString);
    }
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener != null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener.a();
        }
      }
    }
    while (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener == null)
    {
      return;
      if (paramString.contains("url"))
      {
        QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.a.jdField_a_of_type_Long;
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener.a();
      }
      QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(l1 - l2) });
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener.b();
  }
  
  public void progress(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$ViolaOfflineDownloadListener.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.4.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.viola.view;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.ViolaOfflineDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ViolaBaseView$8
  implements ViolaAccessHelper.ViolaOfflineDownloadListener
{
  ViolaBaseView$8(ViolaBaseView paramViolaBaseView, String paramString1, String paramString2, ViolaBaseView.LoadAsyBack paramLoadAsyBack) {}
  
  public void a()
  {
    String str1 = OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString);
    str1 = str1 + this.jdField_a_of_type_JavaLangString + File.separator;
    String str2 = HtmlOffline.d(this.b);
    if (new File(str1 + str2).exists()) {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess js exists [url:" + this.b + "]");
      }
    }
    do
    {
      for (;;)
      {
        str1 = ViolaAccessHelper.b(this.b);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack.a(str1);
        }
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess and jsSource succ [url:" + this.b + "]");
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess js no exists [url:" + this.b + "]");
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack.a();
      }
    } while (!QLog.isColorLevel());
    QLog.e(ViolaBaseView.a(), 2, "downloadOfflineSuccess but js null [url:" + this.b + "]");
  }
  
  public void a(int paramInt) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack.a();
    }
    if (QLog.isColorLevel()) {
      QLog.e(ViolaBaseView.a(), 2, "downloadOfflineFailed [url:" + this.b + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.gdtad.log.GdtLog;

class GdtArkPreDownloadTask$6$1
  implements Runnable
{
  GdtArkPreDownloadTask$6$1(GdtArkPreDownloadTask.6 param6, ArkAppMgr.AppPathInfo paramAppPathInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1 = null;
    try
    {
      Object localObject1 = AdJSON.fromObject(this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo);
      i = this.jdField_a_of_type_Int;
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (localObject1 != null) {
        str1 = localObject1.toString();
      }
      GdtLog.b("GdtArkPreDownloadTask", String.format("onGetAppPathByName retCode:%d msg:%s appPathInfo:%s", new Object[] { Integer.valueOf(i), str2, str1 }));
      if (this.jdField_a_of_type_Int == -6) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        GdtLog.b("GdtArkPreDownloadTask", "onGetAppPathByName", localThrowable);
        Object localObject2 = null;
      }
      int k = GdtArkUtil.a(this.jdField_a_of_type_Int);
      if ((k == 0) && (this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo.path)) && (!TextUtils.isEmpty(GdtArkPreDownloadTask.a(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$6.a)))) {}
      int j;
      for (int i = 1;; i = 0)
      {
        j = k;
        if (i == 0)
        {
          j = k;
          if (k == 0) {
            j = 1;
          }
        }
        if (i == 0) {
          break;
        }
        GdtArkPreDownloadTask.a(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$6.a, 3);
        GdtArkPreDownloadTask.b(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$6.a);
        return;
      }
      GdtArkPreDownloadTask.a(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$6.a, 4);
      GdtArkPreDownloadTask.a(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkPreDownloadTask$6.a, j, this.jdField_a_of_type_Int, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1
 * JD-Core Version:    0.7.0.1
 */
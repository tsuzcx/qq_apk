package com.tencent.gdtad.api.interstitial;

import aaoj;
import aaok;
import aaom;
import aase;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;

public class GdtArkPreDownloadTask$6$1
  implements Runnable
{
  public GdtArkPreDownloadTask$6$1(aaok paramaaok, ArkAppMgr.AppPathInfo paramAppPathInfo, int paramInt, String paramString) {}
  
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
      aase.b("GdtArkPreDownloadTask", String.format("onGetAppPathByName retCode:%d msg:%s appPathInfo:%s", new Object[] { Integer.valueOf(i), str2, str1 }));
      if (this.jdField_a_of_type_Int == -6) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aase.b("GdtArkPreDownloadTask", "onGetAppPathByName", localThrowable);
        Object localObject2 = null;
      }
      int k = aaom.a(this.jdField_a_of_type_Int);
      if ((k == 0) && (this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentArkOpenArkAppMgr$AppPathInfo.path)) && (!TextUtils.isEmpty(aaoj.a(this.jdField_a_of_type_Aaok.a)))) {}
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
        aaoj.a(this.jdField_a_of_type_Aaok.a, 3);
        aaoj.b(this.jdField_a_of_type_Aaok.a);
        return;
      }
      aaoj.a(this.jdField_a_of_type_Aaok.a, 4);
      aaoj.a(this.jdField_a_of_type_Aaok.a, j, this.jdField_a_of_type_Int, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1
 * JD-Core Version:    0.7.0.1
 */
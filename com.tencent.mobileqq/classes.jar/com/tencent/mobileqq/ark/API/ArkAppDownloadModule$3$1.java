package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.open.wadl.WadlJsBridgeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import org.json.JSONObject;

class ArkAppDownloadModule$3$1
  implements Runnable
{
  ArkAppDownloadModule$3$1(ArkAppDownloadModule.3 param3, WadlResult paramWadlResult) {}
  
  public void run()
  {
    int i;
    ark.VariantWrapper localVariantWrapper1;
    if ((ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a) != null) && (ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a).size() > 0))
    {
      i = 0;
      if (i < ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a).size())
      {
        localVariantWrapper1 = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a.b(((Long)ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a).get(i)).longValue());
        if ((localVariantWrapper1 != null) && (this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult != null)) {
          break label101;
        }
        QLog.d("ark.download.module", 1, "ark.dctrl.onDownloadState Callback is null");
      }
    }
    return;
    label101:
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    int j = WadlJsBridgeUtil.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult.b);
    String str;
    if (-2 == j)
    {
      j = WadlJsBridgeUtil.b(this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult.c);
      str = ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a, j);
      if (!TextUtils.isEmpty(str)) {
        ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a, str);
      }
      QLog.e("ark.download.module", 1, new Object[] { "ark.dctrl.download error code:", Integer.valueOf(j) });
      switch (j)
      {
      }
    }
    for (;;)
    {
      JSONObject localJSONObject = ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a, this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult, "DownloadInit");
      str = "";
      if (localJSONObject != null) {
        str = localJSONObject.toString();
      }
      localVariantWrapper2.SetTableAsJsonString(str);
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      QLog.i("ark.download.module", 1, "ark.dctrl.onDownloadState callback : " + str);
      i += 1;
      break;
      if (this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult.a != null)
      {
        WadlProxyServiceUtil.a().c(this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult.a.d, this.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlResult.a.a);
        continue;
        if (2 == j) {
          ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule$3.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.3.1
 * JD-Core Version:    0.7.0.1
 */
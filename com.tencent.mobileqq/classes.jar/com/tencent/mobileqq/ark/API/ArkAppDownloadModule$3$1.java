package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import aool;
import aooq;
import bifx;
import bldt;
import bldu;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import org.json.JSONObject;

public class ArkAppDownloadModule$3$1
  implements Runnable
{
  public ArkAppDownloadModule$3$1(aooq paramaooq, WadlResult paramWadlResult) {}
  
  public void run()
  {
    int i;
    ark.VariantWrapper localVariantWrapper1;
    if ((aool.a(this.jdField_a_of_type_Aooq.a) != null) && (aool.a(this.jdField_a_of_type_Aooq.a).size() > 0))
    {
      i = 0;
      if (i < aool.a(this.jdField_a_of_type_Aooq.a).size())
      {
        localVariantWrapper1 = this.jdField_a_of_type_Aooq.a.b(((Long)aool.a(this.jdField_a_of_type_Aooq.a).get(i)).longValue());
        if ((localVariantWrapper1 != null) && (this.jdField_a_of_type_CooperationWadlIpcWadlResult != null)) {
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
    int j = bifx.a(this.jdField_a_of_type_CooperationWadlIpcWadlResult.b);
    String str;
    if (-2 == j)
    {
      j = bifx.b(this.jdField_a_of_type_CooperationWadlIpcWadlResult.c);
      str = aool.a(this.jdField_a_of_type_Aooq.a, j);
      if (!TextUtils.isEmpty(str)) {
        aool.a(this.jdField_a_of_type_Aooq.a, str);
      }
      QLog.e("ark.download.module", 1, new Object[] { "ark.dctrl.download error code:", Integer.valueOf(j) });
      switch (j)
      {
      }
    }
    for (;;)
    {
      JSONObject localJSONObject = aool.a(this.jdField_a_of_type_Aooq.a, this.jdField_a_of_type_CooperationWadlIpcWadlResult, "DownloadInit");
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
      if (this.jdField_a_of_type_CooperationWadlIpcWadlResult.a != null)
      {
        bldt.a().c(this.jdField_a_of_type_CooperationWadlIpcWadlResult.a.d, this.jdField_a_of_type_CooperationWadlIpcWadlResult.a.a);
        continue;
        if (2 == j) {
          aool.a(this.jdField_a_of_type_Aooq.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.3.1
 * JD-Core Version:    0.7.0.1
 */
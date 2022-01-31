package com.tencent.mobileqq.ark.API;

import alob;
import aloe;
import android.text.TextUtils;
import bdop;
import biby;
import bibz;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import org.json.JSONObject;

public class ArkAppDownloadModule$3$1
  implements Runnable
{
  public ArkAppDownloadModule$3$1(aloe paramaloe, WadlResult paramWadlResult) {}
  
  public void run()
  {
    int i;
    ark.VariantWrapper localVariantWrapper1;
    if ((alob.a(this.jdField_a_of_type_Aloe.a) != null) && (alob.a(this.jdField_a_of_type_Aloe.a).size() > 0))
    {
      i = 0;
      if (i < alob.a(this.jdField_a_of_type_Aloe.a).size())
      {
        localVariantWrapper1 = this.jdField_a_of_type_Aloe.a.b(((Long)alob.a(this.jdField_a_of_type_Aloe.a).get(i)).longValue());
        if ((localVariantWrapper1 != null) && (this.jdField_a_of_type_CooperationWadlIpcWadlResult != null)) {
          break label101;
        }
        QLog.d("ark.download.module", 1, "onDownloadState Callback is null");
      }
    }
    return;
    label101:
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetNull();
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    int j = bdop.a(this.jdField_a_of_type_CooperationWadlIpcWadlResult.b);
    String str;
    if (-2 == j)
    {
      j = bdop.b(this.jdField_a_of_type_CooperationWadlIpcWadlResult.c);
      str = alob.a(this.jdField_a_of_type_Aloe.a, j);
      if (!TextUtils.isEmpty(str)) {
        alob.a(this.jdField_a_of_type_Aloe.a, str);
      }
      switch (j)
      {
      }
    }
    for (;;)
    {
      JSONObject localJSONObject = alob.a(this.jdField_a_of_type_Aloe.a, this.jdField_a_of_type_CooperationWadlIpcWadlResult, "DownloadInit");
      str = "";
      if (localJSONObject != null) {
        str = localJSONObject.toString();
      }
      localVariantWrapper2.SetTableAsJsonString(str);
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper3);
      localVariantWrapper3.Reset();
      localVariantWrapper2.Reset();
      if (QLog.isColorLevel()) {
        QLog.e("ark.download.module", 2, new Object[] { "onDownloadState callback : ", str });
      }
      i += 1;
      break;
      if (this.jdField_a_of_type_CooperationWadlIpcWadlResult.a != null)
      {
        biby.a().c(this.jdField_a_of_type_CooperationWadlIpcWadlResult.a.d, this.jdField_a_of_type_CooperationWadlIpcWadlResult.a.a);
        continue;
        if (2 == j) {
          alob.a(this.jdField_a_of_type_Aloe.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;

class ArkAppDownloadModule$1$1
  implements Runnable
{
  ArkAppDownloadModule$1$1(ArkAppDownloadModule.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject2 = ArkAppDownloadModule.a(this.b.b, this.b.a);
    if (localObject2 == null)
    {
      QLog.i("ark.download.module", 1, "ark.dctrl.onQueryPackageState Callback is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper1 = ((ark.VariantWrapper)localObject2).Create();
    localVariantWrapper1.SetNull();
    ark.VariantWrapper localVariantWrapper2 = ((ark.VariantWrapper)localObject2).Create();
    Object localObject1 = ArkAppDownloadModule.a(this.b.b, this.a, "QueryPackageState");
    if (localObject1 != null) {
      localObject1 = ((JSONArray)localObject1).toString();
    } else {
      localObject1 = "";
    }
    localVariantWrapper1.SetTableAsJsonString((String)localObject1);
    ((ark.VariantWrapper)localObject2).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper2);
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
    ((ark.VariantWrapper)localObject2).Reset();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ark.dctrl.onQueryPackageState result:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("ark.download.module", 1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.1.1
 * JD-Core Version:    0.7.0.1
 */
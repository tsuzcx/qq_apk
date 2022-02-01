package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ArkAppYYBDownloadModule$1$1
  implements Runnable
{
  ArkAppYYBDownloadModule$1$1(ArkAppYYBDownloadModule.1 param1, String paramString) {}
  
  public void run()
  {
    if ((ArkAppYYBDownloadModule.b(this.b.a) != null) && (ArkAppYYBDownloadModule.b(this.b.a).size() > 0))
    {
      int i = 0;
      while (i < ArkAppYYBDownloadModule.b(this.b.a).size())
      {
        Object localObject = ArkAppYYBDownloadModule.a(this.b.a, ((Long)ArkAppYYBDownloadModule.b(this.b.a).get(i)).longValue());
        if ((localObject != null) && (!TextUtils.isEmpty(this.a)))
        {
          ark.VariantWrapper localVariantWrapper1 = ((ark.VariantWrapper)localObject).Create();
          localVariantWrapper1.SetNull();
          ark.VariantWrapper localVariantWrapper2 = ((ark.VariantWrapper)localObject).Create();
          localVariantWrapper1.SetTableAsJsonString(this.a);
          ((ark.VariantWrapper)localObject).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper2);
          localVariantWrapper2.Reset();
          localVariantWrapper1.Reset();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onDownloadState callback : ");
            ((StringBuilder)localObject).append(this.a);
            QLog.i("ArkApp.downloadyyb.module", 1, ((StringBuilder)localObject).toString());
          }
          i += 1;
        }
        else
        {
          QLog.d("ArkApp.downloadyyb.module", 1, "onDownloadState Callback is null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.1.1
 * JD-Core Version:    0.7.0.1
 */
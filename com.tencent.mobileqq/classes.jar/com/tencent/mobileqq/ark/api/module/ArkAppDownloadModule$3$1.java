package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

class ArkAppDownloadModule$3$1
  implements Runnable
{
  ArkAppDownloadModule$3$1(ArkAppDownloadModule.3 param3, WadlResult paramWadlResult) {}
  
  public void run()
  {
    if ((ArkAppDownloadModule.d(this.b.a) != null) && (ArkAppDownloadModule.d(this.b.a).size() > 0))
    {
      int i = 0;
      while (i < ArkAppDownloadModule.d(this.b.a).size())
      {
        Object localObject2 = ArkAppDownloadModule.c(this.b.a, ((Long)ArkAppDownloadModule.d(this.b.a).get(i)).longValue());
        if ((localObject2 != null) && (this.a != null))
        {
          ark.VariantWrapper localVariantWrapper1 = ((ark.VariantWrapper)localObject2).Create();
          localVariantWrapper1.SetNull();
          ark.VariantWrapper localVariantWrapper2 = ((ark.VariantWrapper)localObject2).Create();
          int j = GameCenterUtil.a(this.a.d);
          if (-2 == j)
          {
            j = GameCenterUtil.b(this.a.j);
            localObject1 = ArkAppDownloadModule.a(this.b.a, j);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ArkAppDownloadModule.a(this.b.a, (String)localObject1);
            }
            QLog.e("ark.download.module", 1, new Object[] { "ark.dctrl.download error code:", Integer.valueOf(j) });
            if (((j == 4) || (j == 5)) && (this.a.a != null)) {
              WadlProxyServiceUtil.a().c(this.a.a.h, this.a.a.e);
            }
          }
          else if (2 == j)
          {
            ArkAppDownloadModule.a(this.b.a, true);
          }
          Object localObject1 = ArkAppDownloadModule.a(this.b.a, this.a, "DownloadInit");
          if (localObject1 != null) {
            localObject1 = ((JSONObject)localObject1).toString();
          } else {
            localObject1 = "";
          }
          localVariantWrapper1.SetTableAsJsonString((String)localObject1);
          ((ark.VariantWrapper)localObject2).InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1 }, localVariantWrapper2);
          localVariantWrapper2.Reset();
          localVariantWrapper1.Reset();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ark.dctrl.onDownloadState callback : ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("ark.download.module", 1, ((StringBuilder)localObject2).toString());
          i += 1;
        }
        else
        {
          QLog.d("ark.download.module", 1, "ark.dctrl.onDownloadState Callback is null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.3.1
 * JD-Core Version:    0.7.0.1
 */
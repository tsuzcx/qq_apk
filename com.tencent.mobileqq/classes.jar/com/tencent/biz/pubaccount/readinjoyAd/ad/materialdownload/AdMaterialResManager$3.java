package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class AdMaterialResManager$3
  implements Runnable
{
  AdMaterialResManager$3(AdMaterialResManager paramAdMaterialResManager, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      AdMaterialResManager.b("preload receive json is empty!");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((AdMaterialResManager.a(this.this$0) != null) && (AdMaterialResManager.b(this.this$0).getApp() != null))
        {
          if (AdMaterialResManager.c(this.this$0).getCurrentAccountUin() == null) {
            return;
          }
          Object localObject1 = new JSONObject(this.a);
          SuperMaskConfigMgr.a.a(NetConnInfoCenter.getServerTime());
          SuperMaskConfigMgr.a.a(((JSONObject)localObject1).optInt("is_preview"));
          SuperMaskConfigMgr.a.b(((JSONObject)localObject1).optLong("req_interval"));
          localObject2 = ((JSONObject)localObject1).optJSONArray("res_list");
          localObject1 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            MaterialData localMaterialData = new MaterialData(((JSONArray)localObject2).getJSONObject(i));
            if ((localMaterialData.ad_type == 2) && ((!TextUtils.isEmpty(localMaterialData.res_md5)) || (localMaterialData.bid_mask == 1)) && (localMaterialData.url != null) && (localMaterialData.url.startsWith("http")))
            {
              ((List)localObject1).add(localMaterialData);
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("preload ad_material went wrong id = ");
              localStringBuilder.append(localMaterialData.id);
              AdMaterialResManager.b(localStringBuilder.toString());
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("preload ad_material result size");
            ((StringBuilder)localObject2).append(((List)localObject1).size());
            AdMaterialResManager.b(((StringBuilder)localObject2).toString());
            AdMaterialResManager.a(this.this$0, (List)localObject1);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("resolve json error");
        ((StringBuilder)localObject2).append(QLog.getStackTraceString(localThrowable));
        AdMaterialResManager.b(((StringBuilder)localObject2).toString());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.3
 * JD-Core Version:    0.7.0.1
 */
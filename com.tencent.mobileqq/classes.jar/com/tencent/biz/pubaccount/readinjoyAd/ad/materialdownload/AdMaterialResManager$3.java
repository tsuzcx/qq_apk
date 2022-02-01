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
      AdMaterialResManager.a("preload receive json is empty!");
      return;
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        if ((AdMaterialResManager.a(this.this$0) == null) || (AdMaterialResManager.b(this.this$0).getApp() == null) || (AdMaterialResManager.c(this.this$0).getCurrentAccountUin() == null)) {
          break;
        }
        Object localObject = new JSONObject(this.a);
        SuperMaskConfigMgr.a.a(NetConnInfoCenter.getServerTime());
        SuperMaskConfigMgr.a.a(((JSONObject)localObject).optInt("is_preview"));
        SuperMaskConfigMgr.a.b(((JSONObject)localObject).optLong("req_interval"));
        localObject = ((JSONObject)localObject).optJSONArray("res_list");
        localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          MaterialData localMaterialData = new MaterialData(((JSONArray)localObject).getJSONObject(i));
          if ((localMaterialData.ad_type == 2) && (!TextUtils.isEmpty(localMaterialData.res_md5)) && (localMaterialData.url != null) && (localMaterialData.url.startsWith("http"))) {
            localArrayList.add(localMaterialData);
          } else {
            AdMaterialResManager.a("preload ad_material went wrong id = " + localMaterialData.id);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        AdMaterialResManager.a("resolve json error" + QLog.getStackTraceString(localThrowable));
        return;
      }
      AdMaterialResManager.a("preload ad_material result size" + localArrayList.size());
      AdMaterialResManager.a(this.this$0, localArrayList);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.3
 * JD-Core Version:    0.7.0.1
 */
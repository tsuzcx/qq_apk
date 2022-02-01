package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import ttv;
import tvd;

public class AdMaterialResManager$4
  implements Runnable
{
  public AdMaterialResManager$4(ttv paramttv, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "preload receive json is empty!");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((ttv.a(this.this$0) == null) || (ttv.b(this.this$0).getApp() == null) || (ttv.c(this.this$0).getCurrentAccountUin() == null)) {
          break;
        }
        tvd.a.a(NetConnInfoCenter.getServerTime());
        ArrayList localArrayList = new ArrayList();
        Object localObject = new JSONObject(this.a);
        tvd.a.a(((JSONObject)localObject).optInt("is_preview"));
        tvd.a.b(((JSONObject)localObject).optLong("req_interval"));
        localObject = ((JSONObject)localObject).optJSONArray("res_list");
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label270;
        }
        MaterialData localMaterialData = new MaterialData(((JSONArray)localObject).getJSONObject(i));
        if ((localMaterialData.ad_type == 2) && (!TextUtils.isEmpty(localMaterialData.res_md5)) && (localMaterialData.url != null) && (localMaterialData.url.startsWith("http"))) {
          localArrayList.add(localMaterialData);
        } else if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "preload ad_material went wrong id = " + localMaterialData.id);
        }
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AdMaterialResManager", 2, "resolve json error" + QLog.getStackTraceString(localException));
      return;
      label270:
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "preload ad_material result size" + localException.size());
      }
      ttv.a(this.this$0, localException);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.4
 * JD-Core Version:    0.7.0.1
 */
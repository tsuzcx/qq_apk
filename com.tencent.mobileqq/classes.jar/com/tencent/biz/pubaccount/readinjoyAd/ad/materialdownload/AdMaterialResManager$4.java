package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import uic;
import ujd;

public class AdMaterialResManager$4
  implements Runnable
{
  public AdMaterialResManager$4(uic paramuic, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a))
    {
      uic.a("preload receive json is empty!");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((uic.a(this.this$0) == null) || (uic.b(this.this$0).getApp() == null) || (uic.c(this.this$0).getCurrentAccountUin() == null)) {
          break;
        }
        ujd.a.a(NetConnInfoCenter.getServerTime());
        ArrayList localArrayList = new ArrayList();
        Object localObject = new JSONObject(this.a);
        ujd.a.a(((JSONObject)localObject).optInt("is_preview"));
        ujd.a.b(((JSONObject)localObject).optLong("req_interval"));
        localObject = ((JSONObject)localObject).optJSONArray("res_list");
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          MaterialData localMaterialData = new MaterialData(((JSONArray)localObject).getJSONObject(i));
          if ((localMaterialData.ad_type == 2) && (!TextUtils.isEmpty(localMaterialData.res_md5)) && (localMaterialData.url != null) && (localMaterialData.url.startsWith("http"))) {
            localArrayList.add(localMaterialData);
          } else {
            uic.a("preload ad_material went wrong id = " + localMaterialData.id);
          }
        }
      }
      catch (Exception localException)
      {
        uic.a("resolve json error" + QLog.getStackTraceString(localException));
        return;
      }
      uic.a("preload ad_material result size" + localException.size());
      uic.a(this.this$0, localException);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.4
 * JD-Core Version:    0.7.0.1
 */
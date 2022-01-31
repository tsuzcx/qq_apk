package com.tencent.biz.pubaccount.readinjoy.ad.materialdownload;

import android.text.TextUtils;
import bdne;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ocx;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMaterialResManager$3
  implements Runnable
{
  public AdMaterialResManager$3(ocx paramocx, String paramString) {}
  
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
        if ((ocx.a(this.this$0) == null) || (ocx.b(this.this$0).getApp() == null) || (ocx.c(this.this$0).getCurrentAccountUin() == null)) {
          break;
        }
        bdne.D(ocx.d(this.this$0).getApp(), ocx.e(this.this$0).getCurrentAccountUin());
        ArrayList localArrayList = new ArrayList();
        Object localObject = new JSONObject(this.a);
        bdne.V(ocx.f(this.this$0).getApp(), ocx.g(this.this$0).getCurrentAccountUin(), ((JSONObject)localObject).optInt("is_preview"));
        ocu.a = ((JSONObject)localObject).optLong("req_interval");
        localObject = ((JSONObject)localObject).optJSONArray("res_list");
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label307;
        }
        MaterialData localMaterialData = new MaterialData(((JSONArray)localObject).getJSONObject(i));
        if (((localMaterialData.ad_type == 1) || (localMaterialData.ad_type == 2)) && (!TextUtils.isEmpty(localMaterialData.res_md5)) && (localMaterialData.url != null) && (localMaterialData.url.startsWith("http"))) {
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
      label307:
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "preload ad_material result size" + localException.size());
      }
      ocx.a(this.this$0, localException);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.AdMaterialResManager.3
 * JD-Core Version:    0.7.0.1
 */
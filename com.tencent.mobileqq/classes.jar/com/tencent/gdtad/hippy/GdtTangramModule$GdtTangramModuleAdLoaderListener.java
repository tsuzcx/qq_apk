package com.tencent.gdtad.hippy;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class GdtTangramModule$GdtTangramModuleAdLoaderListener
  implements GdtAdLoader.Listener
{
  WeakReference<Promise> promise;
  
  GdtTangramModule$GdtTangramModuleAdLoaderListener(WeakReference<Promise> paramWeakReference)
  {
    this.promise = paramWeakReference;
  }
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    if (this.promise != null) {}
    for (Promise localPromise = (Promise)this.promise.get(); localPromise == null; localPromise = null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    if ((paramGdtAdLoader == null) || (paramGdtAdLoader.a() == null))
    {
      localPromise.resolve(null);
      return;
    }
    Object localObject = GdtJsonPbUtil.a(paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    paramGdtAdLoader = GdtJsonPbUtil.a(paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    AdLog.i("GdtTangramModule", "loadAd onResponse");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("request", localObject);
      localJSONObject.put("response", paramGdtAdLoader);
      if (paramGdtAdLoader == null) {
        try
        {
          localHippyMap.pushInt("code", 999);
          localPromise.resolve(localHippyMap);
          return;
        }
        catch (Throwable paramGdtAdLoader)
        {
          AdLog.e("GdtTangramModule", "onResponse:", paramGdtAdLoader);
          localPromise.resolve(null);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localHippyMap.pushInt("code", localJSONObject.getJSONObject("response").getInt("ret"));
        localHippyMap.pushString("gdt_cookie", localJSONObject.getJSONObject("response").getString("gdt_cookie"));
        paramGdtAdLoader = localJSONObject.getJSONObject("response").getJSONArray("pos_ads_info");
        HippyArray localHippyArray = new HippyArray();
        localHippyArray.pushJSONArray(paramGdtAdLoader);
        localHippyMap.pushArray("pos_ads_info", localHippyArray);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.hippy.GdtTangramModule.GdtTangramModuleAdLoaderListener
 * JD-Core Version:    0.7.0.1
 */
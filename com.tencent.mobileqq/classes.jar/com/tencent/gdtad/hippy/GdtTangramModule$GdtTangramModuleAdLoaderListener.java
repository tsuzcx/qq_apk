package com.tencent.gdtad.hippy;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONException;
import org.json.JSONObject;

class GdtTangramModule$GdtTangramModuleAdLoaderListener
  implements GdtAdLoader.Listener
{
  Promise promise;
  
  GdtTangramModule$GdtTangramModuleAdLoaderListener(Promise paramPromise)
  {
    this.promise = paramPromise;
  }
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    if (this.promise == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    JSONObject localJSONObject;
    if ((paramGdtAdLoader != null) && (paramGdtAdLoader.a() != null))
    {
      Object localObject = GdtJsonPbUtil.a(paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      paramGdtAdLoader = GdtJsonPbUtil.a(paramGdtAdLoader.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
      AdLog.i("GdtTangramModule", "loadAd onResponse");
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("request", localObject);
        localJSONObject.put("response", paramGdtAdLoader);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (paramGdtAdLoader != null) {}
    }
    try
    {
      localHippyMap.pushInt("code", 999);
      break label179;
      localHippyMap.pushInt("code", localJSONObject.getJSONObject("response").getInt("ret"));
      localHippyMap.pushString("gdt_cookie", localJSONObject.getJSONObject("response").getString("gdt_cookie"));
      paramGdtAdLoader = localJSONObject.getJSONObject("response").getJSONArray("pos_ads_info");
      HippyArray localHippyArray = new HippyArray();
      localHippyArray.pushJSONArray(paramGdtAdLoader);
      localHippyMap.pushArray("pos_ads_info", localHippyArray);
      label179:
      this.promise.resolve(localHippyMap);
      GdtTangramModule.removeRequest(this.promise.getCallId());
      return;
    }
    catch (Throwable paramGdtAdLoader)
    {
      label202:
      break label202;
    }
    AdLog.e("GdtTangramModule", "onResponse:", paramGdtAdLoader);
    this.promise.resolve(null);
    GdtTangramModule.removeRequest(this.promise.getCallId());
    return;
    this.promise.resolve(null);
    GdtTangramModule.removeRequest(this.promise.getCallId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.hippy.GdtTangramModule.GdtTangramModuleAdLoaderListener
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.api.notify;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class GdtNotify$2
  implements Runnable
{
  GdtNotify$2(GdtNotify paramGdtNotify, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new JSONObject(this.a);
      Object localObject1 = ((JSONObject)localObject2).getJSONObject("options");
      boolean bool1 = ((JSONObject)localObject1).getBoolean("reportForClick");
      boolean bool2 = ((JSONObject)localObject1).getBoolean("appAutoDownload");
      boolean bool3 = ((JSONObject)localObject1).optBoolean("videoCeilingSupported", false);
      int i = ((JSONObject)localObject1).optInt("clickScene");
      int j = ((JSONObject)localObject1).optInt("clickPosition");
      localObject1 = ((JSONObject)localObject1).optString("gdtRefsid");
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject2).getJSONObject("adInfo")));
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.q = 7;
      localParams.r = this.b;
      localParams.a = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
      localParams.b = bool1;
      localParams.e = bool2;
      localParams.f = bool3;
      localParams.c = i;
      localParams.d = j;
      bool1 = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool1)
      {
        localParams.p = new Bundle();
        localParams.p.putString("big_brother_ref_source_key", (String)localObject1);
      }
      else if ((!TextUtils.isEmpty(this.c)) && (this.c.equals("com.tencent.yundong")))
      {
        localParams.p = new Bundle();
        localParams.p.putString("big_brother_ref_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3026775809"));
      }
      GdtHandler.a(localParams);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GdtNotify", 1, "ark.notify error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.2
 * JD-Core Version:    0.7.0.1
 */
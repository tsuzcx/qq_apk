package com.tencent.mobileqq.ark.api.notify;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class GdtNotify$5
  implements Runnable
{
  GdtNotify$5(GdtNotify paramGdtNotify, String paramString) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.a))
      {
        QLog.e("GdtNotify", 1, "ark ad_preload_after_ad_loaded params invalid", null);
        return;
      }
      Object localObject = new JSONObject(this.a);
      localObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject).getJSONObject("adInfo"))));
      QLog.d("GdtNotify", 1, "ark ad_preload_after_ad_loaded start", null);
      GdtPreLoader.a().a((GdtAd)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtNotify", 1, "ark ad_preload_after_ad_loaded error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.API;

import acoo;
import acvb;
import android.text.TextUtils;
import apwi;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class ArkAppNotifyCenter$GdtNotify$5
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$5(apwi paramapwi, String paramString) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.a))
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded params invalid", null);
        return;
      }
      Object localObject = new JSONObject(this.a);
      localObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject).getJSONObject("adInfo"))));
      QLog.d("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded start", null);
      acoo.a().a((GdtAd)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark ad_preload_after_ad_loaded error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class ArkAppNotifyCenter$GdtNotify$2
  implements Runnable
{
  ArkAppNotifyCenter$GdtNotify$2(ArkAppNotifyCenter.GdtNotify paramGdtNotify, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        Object localObject3 = ((JSONObject)localObject1).getJSONObject("options");
        boolean bool1 = ((JSONObject)localObject3).getBoolean("reportForClick");
        boolean bool2 = ((JSONObject)localObject3).getBoolean("appAutoDownload");
        boolean bool3 = ((JSONObject)localObject3).optBoolean("videoCeilingSupported", false);
        int i = ((JSONObject)localObject3).optInt("clickScene");
        int j = ((JSONObject)localObject3).optInt("clickPosition");
        localObject3 = ((JSONObject)localObject3).optString("gdtRefsid");
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject1).getJSONObject("adInfo")));
        GdtHandler.Params localParams = new GdtHandler.Params();
        localParams.jdField_c_of_type_Int = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        localParams.jdField_a_of_type_Boolean = bool1;
        localParams.jdField_b_of_type_Boolean = bool2;
        if (bool3)
        {
          localObject1 = GdtVideoCeilingFragmentForJS.class;
          localParams.jdField_a_of_type_JavaLangClass = ((Class)localObject1);
          localParams.jdField_c_of_type_Boolean = bool3;
          localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForArk.class;
          localParams.jdField_a_of_type_Int = i;
          localParams.jdField_b_of_type_Int = j;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
            localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", (String)localObject3);
            GdtHandler.a(localParams);
            return;
          }
          if ((TextUtils.isEmpty(this.b)) || (!this.b.equals("com.tencent.yundong"))) {
            continue;
          }
          localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3026775809"));
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.2
 * JD-Core Version:    0.7.0.1
 */
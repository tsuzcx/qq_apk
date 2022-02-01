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
      Object localObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      Object localObject1 = ((JSONObject)localObject2).getJSONObject("options");
      boolean bool1 = ((JSONObject)localObject1).getBoolean("reportForClick");
      boolean bool2 = ((JSONObject)localObject1).getBoolean("appAutoDownload");
      boolean bool3 = ((JSONObject)localObject1).optBoolean("videoCeilingSupported", false);
      int i = ((JSONObject)localObject1).optInt("clickScene");
      int j = ((JSONObject)localObject1).optInt("clickPosition");
      localObject1 = ((JSONObject)localObject1).optString("gdtRefsid");
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject2).getJSONObject("adInfo")));
      GdtHandler.Params localParams = new GdtHandler.Params();
      localParams.jdField_c_of_type_Int = 7;
      localParams.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
      localParams.jdField_a_of_type_Boolean = bool1;
      localParams.jdField_b_of_type_Boolean = bool2;
      localParams.jdField_c_of_type_Boolean = bool3;
      localParams.jdField_a_of_type_Int = i;
      localParams.jdField_b_of_type_Int = j;
      bool1 = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool1)
      {
        localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
        localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", (String)localObject1);
      }
      else if ((!TextUtils.isEmpty(this.b)) && (this.b.equals("com.tencent.yundong")))
      {
        localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
        localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3026775809"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.API;

import albi;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import rtr;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import yjr;
import yjs;
import ynv;

public class ArkAppNotifyCenter$GdtNotify$2
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$2(albi paramalbi, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
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
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject1).getJSONObject("adInfo")));
        yjs localyjs = new yjs();
        localyjs.jdField_a_of_type_Int = 7;
        localyjs.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        localyjs.jdField_a_of_type_Boolean = bool1;
        localyjs.jdField_b_of_type_Boolean = bool2;
        if (bool3)
        {
          localObject1 = GdtVideoCeilingFragmentForJS.class;
          localyjs.jdField_a_of_type_JavaLangClass = ((Class)localObject1);
          localyjs.jdField_c_of_type_Boolean = bool3;
          localyjs.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForArk.class;
          localyjs.jdField_b_of_type_Int = i;
          localyjs.jdField_c_of_type_Int = j;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
            localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", (String)localObject3);
            yjr.a(localyjs);
            return;
          }
          if ((TextUtils.isEmpty(this.b)) || (!this.b.equals("com.tencent.yundong"))) {
            continue;
          }
          localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", rtr.b("3026775809"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.2
 * JD-Core Version:    0.7.0.1
 */
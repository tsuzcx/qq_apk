package com.tencent.mobileqq.ark.API;

import abkp;
import abkr;
import abrk;
import android.app.Activity;
import android.content.Context;
import aopw;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ark.ark;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppNotifyCenter$GdtNotify$3$1$1
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$3$1$1(aopw paramaopw, abkp paramabkp) {}
  
  public void run()
  {
    Object localObject2 = abrk.a(this.jdField_a_of_type_Abkp.a().a);
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("rsp", localObject2);
      ark.arkNotify(this.jdField_a_of_type_Aopw.a.jdField_a_of_type_JavaLangString, "ad_req_callback", ((JSONObject)localObject1).toString(), "json");
      if (this.jdField_a_of_type_Aopw.a.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject1 = (Activity)this.jdField_a_of_type_Aopw.a.jdField_a_of_type_JavaLangRefWeakReference.get();
        AdReporterForAnalysis.reportForARKSendNotification((Context)localObject1, this.jdField_a_of_type_Aopw.a.jdField_a_of_type_Boolean, "ad_req_callback", this.jdField_a_of_type_Aopw.a.jdField_a_of_type_JavaLangString, null);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3.1.1
 * JD-Core Version:    0.7.0.1
 */
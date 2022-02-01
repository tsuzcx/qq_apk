package com.tencent.mobileqq.ark.api.notify;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class GdtNotify$4
  implements Runnable
{
  GdtNotify$4(GdtNotify paramGdtNotify, WeakReference paramWeakReference, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      try
      {
        localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString).optJSONObject("params");
        if (localObject1 != null) {
          localObject1 = ((JSONObject)localObject1).optString("businessIdForAidTicketAndTaidTicket");
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("GdtNotify", 1, "ark get_device_info error", localJSONException);
        localObject2 = null;
      }
      GdtDeviceInfoHelper.Params localParams = new GdtDeviceInfoHelper.Params();
      localParams.jdField_a_of_type_JavaLangString = ((String)localObject2);
      Object localObject2 = GdtDeviceInfoHelper.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localParams);
      if ((localObject2 != null) && (((GdtDeviceInfoHelper.Result)localObject2).a != null))
      {
        localObject2 = GdtJsonPbUtil.a(((GdtDeviceInfoHelper.Result)localObject2).a);
        if ((localObject2 instanceof JSONObject))
        {
          ((IArkAPIService)QRoute.api(IArkAPIService.class)).postArkNotify(this.b, "get_device_info_callback", localObject2.toString());
          QLog.d("GdtNotify", 1, "ark get_device_info_callback", null);
        }
        return;
      }
      QLog.e("GdtNotify", 1, "ark get_device_info error", null);
      return;
    }
    QLog.e("GdtNotify", 1, "ark get_device_info error", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class GdtDeviceInfoJsCallHandler$1
  implements Runnable
{
  GdtDeviceInfoJsCallHandler$1(GdtDeviceInfoJsCallHandler paramGdtDeviceInfoJsCallHandler, WeakReference paramWeakReference, String[] paramArrayOfString, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject2 = null;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (((GdtAdWebPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() == null))
    {
      GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error");
      return;
    }
    try
    {
      localObject1 = new JSONObject(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
      GdtLog.b("GdtDeviceInfoJsCallHandler", String.format("handleJsCallRequest %s", new Object[] { ((JSONObject)localObject1).toString() }));
      localObject1 = ((JSONObject)localObject1).getJSONObject("params").optString("businessIdForAidTicketAndTaidTicket");
      localObject2 = ((GdtAdWebPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().getApplicationContext();
      GdtDeviceInfoHelper.Params localParams = new GdtDeviceInfoHelper.Params();
      localParams.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = GdtDeviceInfoHelper.a((Context)localObject2, localParams);
      if (localObject1 == null)
      {
        localObject1 = localJSONObject2;
        localJSONObject2 = new JSONObject();
        if ((localObject1 == null) || (JSONObject.NULL.equals(localObject1))) {
          break label274;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          localJSONObject2.put("deviceInfo", localObject1);
          try
          {
            ((GdtAdWebPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get()).callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject2.toString() });
            return;
          }
          catch (Throwable localThrowable1)
          {
            GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localThrowable1);
            return;
          }
          localThrowable2 = localThrowable2;
          GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localThrowable2);
          JSONObject localJSONObject1 = null;
          continue;
          Object localObject2 = localJSONObject1.a;
          localJSONObject1 = localJSONObject2;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = GdtJsonPbUtil.a((PBField)localObject2);
          localJSONObject1 = localJSONObject2;
          if (localObject2 == null) {
            continue;
          }
          localJSONObject1 = localJSONObject2;
          if (!(localObject2 instanceof JSONObject)) {
            continue;
          }
          localJSONObject1 = (JSONObject)JSONObject.class.cast(localObject2);
        }
        catch (JSONException localJSONException)
        {
          GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localJSONException);
          continue;
        }
        label274:
        GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1
 * JD-Core Version:    0.7.0.1
 */
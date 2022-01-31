package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.pb.PBField;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import ywn;
import ywy;
import yxr;
import yxs;
import yys;
import yyt;
import yyu;

public class GdtDeviceInfoJsCallHandler$1
  implements Runnable
{
  public GdtDeviceInfoJsCallHandler$1(ywy paramywy, WeakReference paramWeakReference, String[] paramArrayOfString, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject2 = null;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (((ywn)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() == null))
    {
      yxs.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error");
      return;
    }
    try
    {
      localObject1 = new JSONObject(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
      yxs.b("GdtDeviceInfoJsCallHandler", String.format("handleJsCallRequest %s", new Object[] { ((JSONObject)localObject1).toString() }));
      localObject1 = ((JSONObject)localObject1).getJSONObject("params").optString("businessIdForAidTicketAndTaidTicket");
      localObject2 = ((ywn)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().getApplicationContext();
      yyt localyyt = new yyt();
      localyyt.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = yys.a((Context)localObject2, localyyt);
      if (localObject1 == null)
      {
        localObject1 = localJSONObject2;
        localJSONObject2 = new JSONObject();
        if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
          break label271;
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
            ((ywn)this.jdField_a_of_type_JavaLangRefWeakReference.get()).callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject2.toString() });
            return;
          }
          catch (Throwable localThrowable1)
          {
            yxs.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localThrowable1);
            return;
          }
          localThrowable2 = localThrowable2;
          yxs.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localThrowable2);
          JSONObject localJSONObject1 = null;
          continue;
          Object localObject2 = localJSONObject1.a;
          localJSONObject1 = localJSONObject2;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = yxr.a((PBField)localObject2);
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
          yxs.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localJSONException);
          continue;
        }
        label271:
        yxs.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1
 * JD-Core Version:    0.7.0.1
 */
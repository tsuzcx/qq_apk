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
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (((GdtAdWebPlugin)this.a.get()).a() != null))
    {
      JSONObject localJSONObject = null;
      try
      {
        localObject1 = new JSONObject(this.b[0]);
        GdtLog.b("GdtDeviceInfoJsCallHandler", String.format("handleJsCallRequest %s", new Object[] { ((JSONObject)localObject1).toString() }));
        localObject1 = ((JSONObject)localObject1).getJSONObject("params").optString("businessIdForAidTicketAndTaidTicket");
      }
      catch (Throwable localThrowable1)
      {
        GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localThrowable1);
        localObject2 = null;
      }
      Context localContext = ((GdtAdWebPlugin)this.a.get()).a().getApplicationContext();
      GdtDeviceInfoHelper.Params localParams = new GdtDeviceInfoHelper.Params();
      localParams.a = ((String)localObject2);
      Object localObject2 = GdtDeviceInfoHelper.a(localContext, localParams);
      if (localObject2 == null)
      {
        localObject2 = localJSONObject;
      }
      else
      {
        localObject2 = ((GdtDeviceInfoHelper.Result)localObject2).a;
        if (localObject2 == null)
        {
          localObject2 = localJSONObject;
        }
        else
        {
          localObject2 = GdtJsonPbUtil.a((PBField)localObject2);
          if (localObject2 == null) {
            localObject2 = localJSONObject;
          } else if (!(localObject2 instanceof JSONObject)) {
            localObject2 = localJSONObject;
          } else {
            localObject2 = (JSONObject)JSONObject.class.cast(localObject2);
          }
        }
      }
      localJSONObject = new JSONObject();
      if ((localObject2 != null) && (!JSONObject.NULL.equals(localObject2))) {
        try
        {
          localJSONObject.put("deviceInfo", localObject2);
        }
        catch (JSONException localJSONException)
        {
          GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localJSONException);
        }
      } else {
        GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error");
      }
      try
      {
        ((GdtAdWebPlugin)this.a.get()).callJs(this.c, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Throwable localThrowable2)
      {
        GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest", localThrowable2);
        return;
      }
    }
    GdtLog.d("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1
 * JD-Core Version:    0.7.0.1
 */
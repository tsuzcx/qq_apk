package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import org.json.JSONObject;

public final class GdtCanvasJSONJsCallHandler
  implements GdtJsCallHandler
{
  private static GdtAd a(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("gdt_ad"))) {
      return null;
    }
    return (GdtAd)paramIntent.getParcelableExtra("gdt_ad");
  }
  
  private static JSONObject a(GdtAd paramGdtAd)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramGdtAd != null) {
      try
      {
        if (paramGdtAd.isValid())
        {
          Object localObject = GdtJsonPbUtil.a(paramGdtAd.info);
          if ((localObject != null) && (!JSONObject.NULL.equals(localObject))) {
            localJSONObject.put("adInfo", localObject.toString());
          }
          paramGdtAd = paramGdtAd.getCanvasForXiJingOffline();
          if (!TextUtils.isEmpty(paramGdtAd)) {
            localJSONObject.put("canvasJson", paramGdtAd);
          }
        }
      }
      catch (Throwable paramGdtAd)
      {
        GdtLog.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramGdtAd);
      }
    }
    if (localJSONObject.length() > 0) {
      return localJSONObject;
    }
    return null;
  }
  
  private static GdtAd b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("data")))
    {
      paramIntent = paramIntent.getSerializableExtra("data");
      if ((paramIntent != null) && ((paramIntent instanceof GdtVideoCeilingData)))
      {
        paramIntent = (GdtVideoCeilingData)GdtVideoCeilingData.class.cast(paramIntent);
        if (paramIntent != null) {
          break label59;
        }
      }
    }
    return null;
    label59:
    return paramIntent.getAd();
  }
  
  private static GdtAd c(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("data")))
    {
      paramIntent = paramIntent.getSerializableExtra("data");
      if ((paramIntent != null) && ((paramIntent instanceof GdtImaxData)))
      {
        paramIntent = (GdtImaxData)GdtImaxData.class.cast(paramIntent);
        if (paramIntent != null) {
          break label59;
        }
      }
    }
    return null;
    label59:
    return paramIntent.getAd();
  }
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = null;
    Activity localActivity;
    if (paramGdtAdWebPlugin != null) {
      localActivity = paramGdtAdWebPlugin.a();
    } else {
      localActivity = null;
    }
    if ((paramGdtAdWebPlugin != null) && (localActivity != null))
    {
      GdtAd localGdtAd = a(localActivity.getIntent());
      paramVarArgs = a(localGdtAd);
      if ((paramVarArgs == null) || (JSONObject.NULL.equals(paramVarArgs)) || (paramVarArgs.length() <= 0))
      {
        do
        {
          localGdtAd = b(localActivity.getIntent());
          paramVarArgs = a(localGdtAd);
        } while ((paramVarArgs != null) && (!JSONObject.NULL.equals(paramVarArgs)) && (paramVarArgs.length() > 0));
        localGdtAd = c(localActivity.getIntent());
        paramVarArgs = a(localGdtAd);
      }
      Object localObject1;
      if (paramVarArgs != null)
      {
        localObject1 = paramVarArgs;
        if (!JSONObject.NULL.equals(paramVarArgs)) {}
      }
      else
      {
        localObject1 = new JSONObject();
      }
      GdtLog.b("GdtCanvasJSONJsCallHandler", String.format("handleJsCallRequest adInfo:%b canvasJson:%b", new Object[] { Boolean.valueOf(((JSONObject)localObject1).has("adInfo")), Boolean.valueOf(((JSONObject)localObject1).has("canvasJson")) }));
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
      }
      catch (Throwable paramString)
      {
        GdtLog.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramString);
      }
      long l2 = System.currentTimeMillis();
      paramString = localObject2;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.b();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "getCanvasJson", paramString, localGdtAd, l2 - l1);
      return true;
    }
    GdtLog.d("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtCanvasJSONJsCallHandler
 * JD-Core Version:    0.7.0.1
 */
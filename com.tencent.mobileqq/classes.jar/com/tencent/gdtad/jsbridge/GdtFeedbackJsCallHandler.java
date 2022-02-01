package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.api.feedback.StartGdtFeedbackParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

final class GdtFeedbackJsCallHandler
  implements GdtJsCallHandler
{
  public static final String a = "GdtFeedbackJsCallHandler";
  private WeakReference<GdtAdWebPlugin> b;
  private GdtFeedbackListener c;
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = (GdtAdWebPlugin)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        Object localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendResult2Web actionType = ");
        localStringBuilder.append(paramInt1);
        AdLog.i((String)localObject2, localStringBuilder.toString());
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("action_type", paramInt1);
          ((JSONObject)localObject2).put("error_code", paramInt2);
        }
        catch (Exception localException)
        {
          AdLog.e(a, "sendResult2Web error ", localException);
        }
        ((GdtAdWebPlugin)localObject1).callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
      }
    }
  }
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Activity localActivity;
    if (paramGdtAdWebPlugin != null) {
      localActivity = paramGdtAdWebPlugin.a();
    } else {
      localActivity = null;
    }
    if ((paramGdtAdWebPlugin != null) && (localActivity != null))
    {
      this.c = new GdtFeedbackJsCallHandler.1(this, paramString);
      try
      {
        Object localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("args = ");
        localStringBuilder.append(paramVarArgs[0]);
        GdtLog.a((String)localObject, localStringBuilder.toString());
        localObject = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject).optString("adInfo");
        localObject = ((JSONObject)localObject).optJSONObject("options");
        int i = ((JSONObject)localObject).optInt("orientation");
        paramVarArgs = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramVarArgs));
        boolean bool = ((JSONObject)localObject).optBoolean("isDarkMode");
        this.b = new WeakReference(paramGdtAdWebPlugin);
        ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtFeedbackFragment(StartGdtFeedbackParams.a(new WeakReference(localActivity), new WeakReference(this.c), new GdtAd(paramVarArgs), i, bool));
        return true;
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        AdLog.e(a, "GdtFeedbackJsCallHandler e1", paramGdtAdWebPlugin);
        a(paramString, 0, 4);
        return false;
      }
    }
    AdLog.e(a, "handleJsCallRequest error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtFeedbackJsCallHandler
 * JD-Core Version:    0.7.0.1
 */
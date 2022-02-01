package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONObject;

class GdtMvWebEndcardClickHandler
  extends GdtMvWebJsCallHandler
{
  private final int b = 1;
  
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("args=");
      ((StringBuilder)localObject).append(Arrays.toString(paramVarArgs));
      QLog.i("WebGdtMvWebEndcardClickHandler", 1, ((StringBuilder)localObject).toString());
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("args = ");
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        QLog.i("WebGdtMvWebEndcardClickHandler", 1, ((StringBuilder)localObject).toString());
        localObject = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject).optString("antiSpam");
        try
        {
          int i = ((JSONObject)localObject).optInt("atd");
          localObject = paramVarArgs;
          if (i != 1) {
            break label170;
          }
          bool = true;
        }
        catch (Throwable localThrowable1) {}
        QLog.i("WebGdtMvWebEndcardClickHandler", 1, "json", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        paramVarArgs = "";
      }
      String[] arrayOfString = paramVarArgs;
      label170:
      boolean bool = false;
      paramVarArgs = arrayOfString;
      a(paramVarArgs, bool);
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { "" });
      }
      catch (Throwable paramString)
      {
        QLog.i("WebGdtMvWebEndcardClickHandler", 1, "callJs", paramString);
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "handleRewardVideoClick", paramGdtAdWebPlugin.b());
      return true;
    }
    QLog.i("WebGdtMvWebEndcardClickHandler", 1, "webPlugin == null || activity == null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebEndcardClickHandler
 * JD-Core Version:    0.7.0.1
 */
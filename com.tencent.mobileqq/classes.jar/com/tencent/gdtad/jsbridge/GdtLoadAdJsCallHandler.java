package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;

class GdtLoadAdJsCallHandler
  implements GdtJsCallHandler
{
  private WeakReference<GdtAdWebPlugin> a;
  private Map<GdtAdLoader, String> b = new HashMap();
  private GdtAdLoader.Listener c = new GdtLoadAdJsCallHandler.1(this);
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject1 = null;
    Activity localActivity;
    if (paramGdtAdWebPlugin != null) {
      localActivity = paramGdtAdWebPlugin.a();
    } else {
      localActivity = null;
    }
    if ((paramGdtAdWebPlugin != null) && (localActivity != null)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        GdtLog.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject2).toString());
        paramVarArgs = new GdtAdLoader.Session();
        paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), localObject2)));
        this.a = new WeakReference(paramGdtAdWebPlugin);
        localObject2 = new GdtAdLoader(paramVarArgs, new WeakReference(this.c));
        this.b.put(localObject2, paramString);
        ((GdtAdLoader)localObject2).a(new WeakReference(localActivity));
        paramString = new ArrayList();
        if ((paramVarArgs.a != null) && (!paramVarArgs.a.position_info.isEmpty()))
        {
          int i = 0;
          while (i < paramVarArgs.a.position_info.size())
          {
            localObject2 = ((qq_ad_get.QQAdGet.PositionInfo)paramVarArgs.a.position_info.get(i)).pos_id.get();
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString.add(localObject2);
            }
            i += 1;
          }
        }
        paramString = localObject1;
        if (paramGdtAdWebPlugin != null) {
          paramString = paramGdtAdWebPlugin.b();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramString);
        return true;
      }
      catch (JSONException paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
    }
    GdtLog.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLoadAdJsCallHandler
 * JD-Core Version:    0.7.0.1
 */
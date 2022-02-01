package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
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
  private GdtAdLoader.Listener jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Listener = new GdtLoadAdJsCallHandler.1(this);
  private WeakReference<GdtAdWebPlugin> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<GdtAdLoader, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (Activity localActivity = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (localActivity == null); localActivity = null)
    {
      GdtLog.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      GdtLog.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new GdtAdLoader.Session();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGdtAdWebPlugin);
      localObject = new GdtAdLoader(paramVarArgs, new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Listener));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((GdtAdLoader)localObject).a(new WeakReference(localActivity));
      paramString = new ArrayList();
      if ((paramVarArgs.a != null) && (!paramVarArgs.a.position_info.isEmpty()))
      {
        int i = 0;
        while (i < paramVarArgs.a.position_info.size())
        {
          localObject = ((qq_ad_get.QQAdGet.PositionInfo)paramVarArgs.a.position_info.get(i)).pos_id.get();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString.add(localObject);
          }
          i += 1;
        }
      }
      if (paramGdtAdWebPlugin == null) {}
    }
    catch (JSONException paramGdtAdWebPlugin)
    {
      GdtLog.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
      return true;
    }
    for (paramGdtAdWebPlugin = paramGdtAdWebPlugin.a();; paramGdtAdWebPlugin = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramGdtAdWebPlugin);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLoadAdJsCallHandler
 * JD-Core Version:    0.7.0.1
 */
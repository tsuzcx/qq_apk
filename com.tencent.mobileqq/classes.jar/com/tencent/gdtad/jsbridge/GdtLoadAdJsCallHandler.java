package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import qkv;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtLoadAdJsCallHandler
  implements GdtJsCallHandler
{
  private GdtAdLoader.Listener jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Listener = new qkv(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if ((paramGdtAdWebPlugin == null) || (paramGdtAdWebPlugin.mRuntime == null) || (paramGdtAdWebPlugin.mRuntime.a() == null))
    {
      GdtLog.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      GdtLog.b("GdtLoadAdJsCallHandler", paramVarArgs.toString());
      GdtAdLoader.Session localSession = new GdtAdLoader.Session();
      localSession.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), paramVarArgs)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGdtAdWebPlugin);
      this.jdField_a_of_type_JavaUtilMap.put(localSession, paramString);
      GdtAdLoader.a(paramGdtAdWebPlugin.mRuntime.a(), localSession, new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Listener));
      return true;
    }
    catch (JSONException paramGdtAdWebPlugin)
    {
      GdtLog.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLoadAdJsCallHandler
 * JD-Core Version:    0.7.0.1
 */
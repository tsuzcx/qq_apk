import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.service.AppBrandService.3;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class bhhd
  extends bhhc
{
  protected static HandlerThread a;
  private static boolean jdField_a_of_type_Boolean;
  protected static Handler b;
  private bhfi jdField_a_of_type_Bhfi;
  private bhhr jdField_a_of_type_Bhhr;
  public JsContext a;
  protected JsVirtualMachine a;
  public String a;
  
  public bhhd(bglv parambglv, bhhr parambhhr)
  {
    super(parambglv);
    this.jdField_a_of_type_JavaLangString = "mini_service_thread";
    a(parambhhr);
    try
    {
      if (jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(this.jdField_a_of_type_JavaLangString);
        jdField_a_of_type_AndroidOsHandlerThread.start();
        b = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a(bgod parambgod)
  {
    if (parambgod == null) {
      return "";
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appId", parambgod.appId);
      ((JSONObject)localObject).put("icon", parambgod.iconUrl);
      ((JSONObject)localObject).put("nickname", "testuser");
      parambgod = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambgod.mConfigStr, ((JSONObject)localObject).toString() });
      localObject = parambgod + "__qqConfig.debug=true;";
      parambgod = (bgod)localObject;
      if (this.jdField_a_of_type_Bhfi != null) {
        parambgod = (String)localObject + "__qqConfig.useXWebVideo=" + this.jdField_a_of_type_Bhfi.a() + ";";
      }
      return parambgod + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("USER_DATA_PATH", "qqfile://usr");
      ((JSONObject)localObject).put("env", localJSONObject);
      ((JSONObject)localObject).put("preload", paramBoolean);
      ((JSONObject)localObject).put("platform", "android");
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      QMLog.d("minisdk-start", "getJsDefaultConfig ServiceWebview String: " + (String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandService", "getJsDefaultConfig failed: ", localException);
    }
    return "";
  }
  
  public void a(int paramInt, String paramString)
  {
    a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void a(Context paramContext)
  {
    Log.e("AppBrandService", "ServiceWebview init ... ");
    this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine = new JsVirtualMachine(paramContext, b.getLooper());
    this.jdField_a_of_type_ComTencentSmttSdkJsContext = new JsContext(this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine);
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.setExceptionHandler(new bhhf(this));
    c();
    a(Integer.valueOf(3));
  }
  
  public void a(Context paramContext, bhff parambhff)
  {
    if (parambhff != null) {
      addStateChangeListener(parambhff);
    }
    TbsLog.initIfNeed(paramContext);
    parambhff = new bhhe(this, paramContext);
    QbSdk.preInit(this.jdField_a_of_type_Bglv.a(), parambhff);
    if (jdField_a_of_type_Boolean) {
      a(paramContext);
    }
  }
  
  public void a(bgod parambgod)
  {
    if (parambgod == null) {
      return;
    }
    b(a(parambgod));
    String str = "";
    try
    {
      parambgod = bgpc.b(new File(parambgod.a()));
      c(parambgod);
      return;
    }
    catch (IOException parambgod)
    {
      for (;;)
      {
        parambgod.printStackTrace();
        parambgod = str;
      }
    }
  }
  
  public void a(bhfi parambhfi)
  {
    this.jdField_a_of_type_Bhfi = parambhfi;
  }
  
  public void a(bhhr parambhhr)
  {
    this.jdField_a_of_type_Bhhr = parambhhr;
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    a(paramString, paramValueCallback, null);
  }
  
  public void a(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if (Thread.currentThread() == jdField_a_of_type_AndroidOsHandlerThread)
    {
      if (this.jdField_a_of_type_ComTencentSmttSdkJsContext != null) {
        this.jdField_a_of_type_ComTencentSmttSdkJsContext.evaluateJavascript(paramString1, paramValueCallback);
      }
      return;
    }
    b.post(new AppBrandService.3(this, paramString1, paramValueCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QMLog.d("AppBrandService", "evaluateSubscribeJS  eventName=" + paramString1);
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    if (!a()) {
      return;
    }
    a(paramString1, null);
  }
  
  public void b()
  {
    a(a(true));
    AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().loadBaselib(AppLoaderFactory.g().getMiniAppEnv().getContext(), new bhhg(this));
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.addJavascriptInterface(this, "WeixinJSCore");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhd
 * JD-Core Version:    0.7.0.1
 */
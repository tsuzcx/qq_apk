import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.service.AppBrandWebviewService.2;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class bhhh
  extends bhhc
{
  private bhhr jdField_a_of_type_Bhhr;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  protected boolean a;
  
  public bhhh(bglv parambglv, bhhr parambhhr)
  {
    super(parambglv);
    this.jdField_a_of_type_Boolean = true;
    a(parambhhr);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(parambglv.a());
    this.jdField_a_of_type_ComTencentSmttSdkWebView.addJavascriptInterface(this, "WeixinJSCore");
    parambglv = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    parambglv.setSupportZoom(false);
    parambglv.setJavaScriptEnabled(true);
    parambglv.setCacheMode(2);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new bhhi(this));
    a(Integer.valueOf(3));
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
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambgod.appId);
      localJSONObject.put("icon", parambgod.iconUrl);
      localJSONObject.put("nickname", "testuser");
      parambgod = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambgod.mConfigStr, localJSONObject.toString() });
      parambgod = parambgod + "__qqConfig.debug=true;";
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
      ((JSONObject)localObject).put("useXWebVideo", this.jdField_a_of_type_Boolean);
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      QMLog.d("miniapp-embedded", "service enableEmbeddedVideo : " + this.jdField_a_of_type_Boolean);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandWebviewService", "getJsDefaultConfig failed: ", localException);
    }
    return "";
  }
  
  public void a(int paramInt, String paramString)
  {
    a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
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
  
  public void a(bhfi parambhfi) {}
  
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
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.evaluateJavascript(paramString1, bhiq.a(paramValueCallback));
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AppBrandWebviewService.2(this, paramString1, paramValueCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QMLog.d("AppBrandWebviewService", "evaluateSubscribeJS  eventName=" + paramString1);
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    if (!a()) {
      return;
    }
    a(paramString1, null);
  }
  
  public void b()
  {
    a(a(true));
    AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().loadBaselib(AppLoaderFactory.g().getMiniAppEnv().getContext(), new bhhj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhh
 * JD-Core Version:    0.7.0.1
 */
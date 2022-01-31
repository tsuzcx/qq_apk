import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.runtime.core.service.AppBrandWebviewService.2;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class bfdk
  extends bfdf
{
  private bfdu jdField_a_of_type_Bfdu;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  
  public bfdk(behq parambehq, bfdu parambfdu)
  {
    super(parambehq);
    a(parambfdu);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(parambehq.a());
    this.jdField_a_of_type_ComTencentSmttSdkWebView.addJavascriptInterface(this, "WeixinJSCore");
    parambehq = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    parambehq.setSupportZoom(false);
    parambehq.setJavaScriptEnabled(true);
    parambehq.setCacheMode(2);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new bfdl(this));
    a(Integer.valueOf(3));
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a(bekp parambekp)
  {
    if (parambekp == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambekp.d);
      localJSONObject.put("icon", parambekp.e);
      localJSONObject.put("nickname", "testuser");
      parambekp = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambekp.b, localJSONObject.toString() });
      return parambekp + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
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
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      betc.d("AppBrandService", "getJsDefaultConfig failed: ", localException);
    }
    return "";
  }
  
  public void a(int paramInt, String paramString)
  {
    a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void a(bekp parambekp)
  {
    if (parambekp == null) {
      return;
    }
    b(a(parambekp));
    String str = "";
    try
    {
      parambekp = belh.b(new File(parambekp.a()));
      c(parambekp);
      return;
    }
    catch (IOException parambekp)
    {
      for (;;)
      {
        parambekp.printStackTrace();
        parambekp = str;
      }
    }
  }
  
  public void a(bfdu parambfdu)
  {
    this.jdField_a_of_type_Bfdu = parambfdu;
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
        this.jdField_a_of_type_ComTencentSmttSdkWebView.evaluateJavascript(paramString1, bfen.a(paramValueCallback));
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AppBrandWebviewService.2(this, paramString1, paramValueCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    betc.a("AppBrandService", "evaluateSubscribeJS  eventName=" + paramString1);
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    if (!a()) {
      return;
    }
    a(paramString1, null);
  }
  
  public void b()
  {
    a(a(true));
    MiniAppEnv.g().getBaselibLoader().loadBaselib(MiniAppEnv.g().getContext(), new bfdm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdk
 * JD-Core Version:    0.7.0.1
 */
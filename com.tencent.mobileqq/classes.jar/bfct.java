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

public class bfct
  extends bfco
{
  private bfdd jdField_a_of_type_Bfdd;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  
  public bfct(begz parambegz, bfdd parambfdd)
  {
    super(parambegz);
    a(parambfdd);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(parambegz.a());
    this.jdField_a_of_type_ComTencentSmttSdkWebView.addJavascriptInterface(this, "WeixinJSCore");
    parambegz = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    parambegz.setSupportZoom(false);
    parambegz.setJavaScriptEnabled(true);
    parambegz.setCacheMode(2);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(new bfcu(this));
    a(Integer.valueOf(3));
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a(bejy parambejy)
  {
    if (parambejy == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambejy.d);
      localJSONObject.put("icon", parambejy.e);
      localJSONObject.put("nickname", "testuser");
      parambejy = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambejy.b, localJSONObject.toString() });
      return parambejy + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
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
      besl.d("AppBrandService", "getJsDefaultConfig failed: ", localException);
    }
    return "";
  }
  
  public void a(int paramInt, String paramString)
  {
    a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void a(bejy parambejy)
  {
    if (parambejy == null) {
      return;
    }
    b(a(parambejy));
    String str = "";
    try
    {
      parambejy = bekq.b(new File(parambejy.a()));
      c(parambejy);
      return;
    }
    catch (IOException parambejy)
    {
      for (;;)
      {
        parambejy.printStackTrace();
        parambejy = str;
      }
    }
  }
  
  public void a(bfdd parambfdd)
  {
    this.jdField_a_of_type_Bfdd = parambfdd;
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
        this.jdField_a_of_type_ComTencentSmttSdkWebView.evaluateJavascript(paramString1, bfdw.a(paramValueCallback));
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AppBrandWebviewService.2(this, paramString1, paramValueCallback));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    besl.a("AppBrandService", "evaluateSubscribeJS  eventName=" + paramString1);
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    if (!a()) {
      return;
    }
    a(paramString1, null);
  }
  
  public void b()
  {
    a(a(true));
    MiniAppEnv.g().getBaselibLoader().loadBaselib(MiniAppEnv.g().getContext(), new bfcv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfct
 * JD-Core Version:    0.7.0.1
 */
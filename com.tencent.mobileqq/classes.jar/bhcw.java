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

public class bhcw
  extends bhcv
{
  protected static HandlerThread a;
  private static boolean jdField_a_of_type_Boolean;
  protected static Handler b;
  private bhbb jdField_a_of_type_Bhbb;
  private bhdk jdField_a_of_type_Bhdk;
  public JsContext a;
  protected JsVirtualMachine a;
  public String a;
  
  public bhcw(bgho parambgho, bhdk parambhdk)
  {
    super(parambgho);
    this.jdField_a_of_type_JavaLangString = "mini_service_thread";
    a(parambhdk);
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
  
  public String a(bgjw parambgjw)
  {
    if (parambgjw == null) {
      return "";
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appId", parambgjw.appId);
      ((JSONObject)localObject).put("icon", parambgjw.iconUrl);
      ((JSONObject)localObject).put("nickname", "testuser");
      parambgjw = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambgjw.mConfigStr, ((JSONObject)localObject).toString() });
      localObject = parambgjw + "__qqConfig.debug=true;";
      parambgjw = (bgjw)localObject;
      if (this.jdField_a_of_type_Bhbb != null) {
        parambgjw = (String)localObject + "__qqConfig.useXWebVideo=" + this.jdField_a_of_type_Bhbb.a() + ";";
      }
      return parambgjw + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
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
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.setExceptionHandler(new bhcy(this));
    c();
    a(Integer.valueOf(3));
  }
  
  public void a(Context paramContext, bhay parambhay)
  {
    if (parambhay != null) {
      addStateChangeListener(parambhay);
    }
    TbsLog.initIfNeed(paramContext);
    parambhay = new bhcx(this, paramContext);
    QbSdk.preInit(this.jdField_a_of_type_Bgho.a(), parambhay);
    if (jdField_a_of_type_Boolean) {
      a(paramContext);
    }
  }
  
  public void a(bgjw parambgjw)
  {
    if (parambgjw == null) {
      return;
    }
    b(a(parambgjw));
    String str = "";
    try
    {
      parambgjw = bgkv.b(new File(parambgjw.a()));
      c(parambgjw);
      return;
    }
    catch (IOException parambgjw)
    {
      for (;;)
      {
        parambgjw.printStackTrace();
        parambgjw = str;
      }
    }
  }
  
  public void a(bhbb parambhbb)
  {
    this.jdField_a_of_type_Bhbb = parambhbb;
  }
  
  public void a(bhdk parambhdk)
  {
    this.jdField_a_of_type_Bhdk = parambhdk;
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
    AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().loadBaselib(AppLoaderFactory.g().getMiniAppEnv().getContext(), new bhcz(this));
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.addJavascriptInterface(this, "WeixinJSCore");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcw
 * JD-Core Version:    0.7.0.1
 */
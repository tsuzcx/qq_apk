import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.runtime.core.service.AppBrandService.3;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class bfcp
  extends bfco
{
  protected static HandlerThread a;
  private static boolean jdField_a_of_type_Boolean;
  protected static Handler b;
  private bfdd jdField_a_of_type_Bfdd;
  public JsContext a;
  protected JsVirtualMachine a;
  public String a;
  
  public bfcp(begz parambegz, bfdd parambfdd)
  {
    super(parambegz);
    this.jdField_a_of_type_JavaLangString = "mini_service_thread";
    a(parambfdd);
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
  
  public void a(Context paramContext)
  {
    Log.e("AppBrandService", "ServiceWebview init ... ");
    this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine = new JsVirtualMachine(paramContext, b.getLooper());
    this.jdField_a_of_type_ComTencentSmttSdkJsContext = new JsContext(this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine);
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.setExceptionHandler(new bfcr(this));
    c();
    a(Integer.valueOf(3));
  }
  
  public void a(Context paramContext, bfax parambfax)
  {
    if (parambfax != null) {
      a(parambfax);
    }
    TbsLog.initIfNeed(paramContext);
    parambfax = new bfcq(this, paramContext);
    QbSdk.preInit(this.jdField_a_of_type_Begz.a(), parambfax);
    if (jdField_a_of_type_Boolean) {
      a(paramContext);
    }
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
    MiniAppEnv.g().getBaselibLoader().loadBaselib(MiniAppEnv.g().getContext(), new bfcs(this));
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentSmttSdkJsContext.addJavascriptInterface(this, "WeixinJSCore");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcp
 * JD-Core Version:    0.7.0.1
 */
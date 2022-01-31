import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.runtime.core.service.V8AsyncLibLoader;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class bhdd
  extends bhcv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Engine jdField_a_of_type_ComTencentTissueV8rtEngineEngine = Engine.getInstance();
  private V8JsRuntime jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime;
  
  static
  {
    Logger.init(new bher());
  }
  
  public bhdd(bgho parambgho)
  {
    super(parambgho);
    this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.setLibLoader(new V8AsyncLibLoader());
    this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.initEngine(parambgho.a());
    this.jdField_a_of_type_AndroidContentContext = parambgho.a();
    if (this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.getStatus() == 0) {
      try
      {
        this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime = this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.createJsRuntime();
        this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().injectAll();
        a(Integer.valueOf(3));
        Logger.i("TV8ENG", "create jsruntime success " + this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime);
        return;
      }
      finally {}
    }
    Logger.e("TV8ENG", "create jsruntime failed, engine status:" + this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.getStatus());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.getStatus();
  }
  
  public String a(bgjw parambgjw)
  {
    if (parambgjw == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambgjw.appId);
      localJSONObject.put("icon", parambgjw.iconUrl);
      localJSONObject.put("nickname", "testuser");
      parambgjw = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambgjw.mConfigStr, localJSONObject.toString() });
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
      ((JSONObject)localObject).put("useFlutter", true);
      ((JSONObject)localObject).put("platform", "android");
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.e("V8ServiceRuntime", "getJsDefaultConfig failed: " + localException);
    }
    return "";
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime != null)
    {
      Logger.d("V8ServiceRuntime", "evaluateCallbackJs  callbackId=" + paramInt + ",result=" + paramString);
      a(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateCallbackJs failed jsRuntime null");
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
  
  public void a(bhbb parambhbb) {}
  
  public void a(bhdk parambhdk)
  {
    ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime, new bhdh(this, parambhdk));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bhav.a(paramString, "default_config.js");
    appendEvent(Integer.valueOf(4));
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    a(paramString, paramValueCallback, null);
  }
  
  public void a(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString2)) {
      if ((paramString2.endsWith("QLogic.js")) && (paramString2.startsWith("/"))) {
        if (paramString2.startsWith("assets://"))
        {
          localObject = new File(paramString2.substring("assets://".length()));
          localObject = new File(this.jdField_a_of_type_AndroidContentContext.getCacheDir().getPath() + File.separator + "cc_assets" + File.separator + ((File)localObject).getParentFile().getPath());
          ((File)localObject).mkdirs();
          if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
            break label336;
          }
          paramString2 = new File(paramString2).getName();
          localObject = new File((File)localObject, paramString2);
          localObject = ((File)localObject).getAbsolutePath() + ".cc";
        }
      }
    }
    for (;;)
    {
      label189:
      if (!TextUtils.isEmpty(paramString2)) {}
      for (int i = 1;; i = 0)
      {
        if (this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime != null)
        {
          if (paramValueCallback != null) {
            break label286;
          }
          if (i == 0) {
            break label273;
          }
          this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new bhde(this), paramString2, (String)localObject);
        }
        return;
        localObject = new File(paramString2).getParentFile();
        ((File)localObject).mkdirs();
        break;
        localObject = "";
        break label189;
      }
      label273:
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
      label286:
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new bhdf(this, paramValueCallback), paramString2, (String)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new bhdg(this, paramValueCallback));
      return;
      label336:
      paramString2 = null;
      localObject = null;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
    appendEvent(Integer.valueOf(5));
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    Logger.d("V8ServiceRuntime", "evaluateSubscribeJS: " + paramString1);
    if (this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime != null)
    {
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateSubscribeJS failed jsRuntime null");
  }
  
  public void b()
  {
    a(a(true));
    MiniAppEnv.g().getBaselibLoader().loadBaselib(MiniAppEnv.g().getContext(), new bhdi(this));
  }
  
  public void b(String paramString)
  {
    this.c.a(paramString, "global_config.js");
    appendEvent(Integer.valueOf(6));
  }
  
  public void c(String paramString)
  {
    this.d.a(paramString, "app_service.js");
    appendEvent(Integer.valueOf(7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdd
 * JD-Core Version:    0.7.0.1
 */
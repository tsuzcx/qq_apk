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

public class bhhk
  extends bhhc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Engine jdField_a_of_type_ComTencentTissueV8rtEngineEngine = Engine.getInstance();
  private V8JsRuntime jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime;
  
  static
  {
    Logger.init(new bhiy());
  }
  
  public bhhk(bglv parambglv)
  {
    super(parambglv);
    this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.setLibLoader(new V8AsyncLibLoader());
    this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.initEngine(parambglv.a());
    this.jdField_a_of_type_AndroidContentContext = parambglv.a();
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
    ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime, new bhho(this, parambhhr));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bhfc.a(paramString, "default_config.js");
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
          this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new bhhl(this), paramString2, (String)localObject);
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
        this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new bhhm(this, paramValueCallback), paramString2, (String)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new bhhn(this, paramValueCallback));
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
    MiniAppEnv.g().getBaselibLoader().loadBaselib(MiniAppEnv.g().getContext(), new bhhp(this));
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
 * Qualified Name:     bhhk
 * JD-Core Version:    0.7.0.1
 */
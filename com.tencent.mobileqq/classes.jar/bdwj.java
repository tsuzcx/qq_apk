import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class bdwj
  extends bdwf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Engine jdField_a_of_type_ComTencentTissueV8rtEngineEngine = Engine.getInstance();
  private V8JsRuntime jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime;
  
  static
  {
    Logger.init(new bdxi());
  }
  
  public bdwj(bdcz parambdcz)
  {
    super(parambdcz);
    this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.setLibLoader(new bdwr());
    this.jdField_a_of_type_ComTencentTissueV8rtEngineEngine.initEngine(parambdcz.a());
    this.jdField_a_of_type_AndroidContentContext = parambdcz.a();
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
  
  public String a(bdfx parambdfx)
  {
    if (parambdfx == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambdfx.d);
      localJSONObject.put("icon", parambdfx.e);
      localJSONObject.put("nickname", "testuser");
      parambdfx = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambdfx.b, localJSONObject.toString() });
      return parambdfx + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
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
  
  public void a(bdfx parambdfx)
  {
    if (parambdfx == null) {
      return;
    }
    b(a(parambdfx));
    String str = "";
    try
    {
      parambdfx = bdgo.b(new File(parambdfx.a()));
      c(parambdfx);
      return;
    }
    catch (IOException parambdfx)
    {
      for (;;)
      {
        parambdfx.printStackTrace();
        parambdfx = str;
      }
    }
  }
  
  public void a(bdwq parambdwq)
  {
    ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime, new bdwn(this, parambdwq));
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    a(paramString, paramValueCallback, null);
  }
  
  public void a(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.endsWith("QLogic.js"))) {
      if (paramString2.startsWith("assets://"))
      {
        localObject = new File(paramString2.substring("assets://".length()));
        localObject = new File(this.jdField_a_of_type_AndroidContentContext.getCacheDir().getPath() + File.separator + "cc_assets" + File.separator + ((File)localObject).getParentFile().getPath());
        ((File)localObject).mkdirs();
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break label324;
        }
        paramString2 = new File(paramString2).getName();
        localObject = new File((File)localObject, paramString2);
      }
    }
    for (Object localObject = ((File)localObject).getAbsolutePath() + ".cc";; localObject = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString2))) {}
      for (int i = 1;; i = 0)
      {
        if (this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime != null)
        {
          if (paramValueCallback != null) {
            break label274;
          }
          if (i == 0) {
            break label261;
          }
          this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new bdwk(this), paramString2, (String)localObject);
        }
        return;
        localObject = new File(paramString2).getParentFile();
        ((File)localObject).mkdirs();
        break;
      }
      label261:
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
      label274:
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new bdwl(this, paramValueCallback), paramString2, (String)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new bdwm(this, paramValueCallback));
      return;
      label324:
      paramString2 = null;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    Logger.d("V8ServiceRuntime", "evaluateSubscribeJS: " + paramString1);
    if (this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime != null)
    {
      this.jdField_a_of_type_ComTencentTissueV8rtEngineV8JsRuntime.getDefaultContext().evaluateJsSync(paramString1);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateSubscribeJS failed jsRuntime null");
  }
  
  public void b()
  {
    a(a(true));
    MiniAppEnv.g().getBaselibLoader().loadBaselib(MiniAppEnv.g().getContext(), new bdwo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwj
 * JD-Core Version:    0.7.0.1
 */
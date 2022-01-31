import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.runtime.core.EventListener.1;
import com.tencent.qqmini.sdk.runtime.core.EventListener.2;
import com.tencent.qqmini.sdk.runtime.core.EventListener.3;
import com.tencent.qqmini.sdk.runtime.core.EventListener.4;
import com.tencent.qqmini.sdk.runtime.core.EventListener.5;
import com.tencent.qqmini.sdk.runtime.core.EventListener.6;
import com.tencent.qqmini.sdk.runtime.core.EventListener.7;
import com.tencent.tissue.v8rt.engine.SpeedUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class bfbj
  implements bfce, bfdu
{
  private bfbi a;
  protected boolean a;
  private boolean b;
  
  public bfbj(bfbi parambfbi)
  {
    this.jdField_a_of_type_Bfbi = parambfbi;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int j = 1;
    int i = 1;
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      this.jdField_a_of_type_Boolean = true;
      betc.b("EventListener", "WeixinJSBridge finished.");
      SpeedUtil.DEFAULT.event("initWeixinJSBridge finished");
      return bekx.a(paramString1, null).toString();
    }
    bfdt localbfdt = this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfdt;
    bfcb localbfcb = this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfcb;
    JsPluginEngine localJsPluginEngine = this.jdField_a_of_type_Bfbi.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
    bekp localbekp = this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bekp;
    bekr localbekr = new beks().a(paramString1).b(paramString2).a(paramInt).a(localbfdt).a();
    for (;;)
    {
      try
      {
        if ("redirectTo".equals(paramString1))
        {
          paramString2 = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty(paramString2))
          {
            if ((localbekp != null) && (localbekp.a(paramString2)))
            {
              paramInt = i;
              if (paramInt != 0) {
                return localbekr.b();
              }
              bekz.a(new EventListener.1(this, localbfcb, paramString2, localbekr));
            }
          }
          else {
            return bekx.a(paramString1, null).toString();
          }
        }
        else
        {
          if ("navigateTo".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2))
            {
              if ((localbekp == null) || (!localbekp.a(paramString2))) {
                break label544;
              }
              paramInt = j;
              if (paramInt != 0) {
                return bekx.b(paramString1, null).toString();
              }
              bekz.a(new EventListener.2(this, localbfcb, paramString2, localbekr));
            }
            return bekx.a(paramString1, null).toString();
          }
          if ("navigateBack".equals(paramString1))
          {
            paramInt = new JSONObject(paramString2).optInt("delta", 0);
            if (paramInt > 0) {
              bekz.a(new EventListener.3(this, localbfcb, paramInt, localbekr));
            }
            return bekx.a(paramString1, null).toString();
          }
          if ("switchTab".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              bekz.a(new EventListener.4(this, localbfcb, paramString2, localbekr));
            }
            return bekx.a(paramString1, null).toString();
          }
          if ("reLaunch".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              bekz.a(new EventListener.5(this, paramString2, localbekr));
            }
            return bekx.a(paramString1, null).toString();
          }
          if ("exitMiniProgram".equals(paramString1))
          {
            bekz.a(new EventListener.6(this));
            if (localJsPluginEngine != null) {
              return localJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbfdt, paramInt);
            }
          }
          else
          {
            if (!"flutter_launch".equals(paramString1)) {
              continue;
            }
            bekz.a(new EventListener.7(this, localbfcb, paramString1, paramString2, localbekr));
            continue;
          }
          return "";
        }
      }
      catch (JSONException paramString1)
      {
        betc.d("EventListener", "", paramString1);
        return "";
      }
      catch (Throwable paramString1)
      {
        betc.d("EventListener", "", paramString1);
        return "";
      }
      paramInt = 0;
      continue;
      label544:
      paramInt = 0;
    }
  }
  
  public String a(String paramString1, String paramString2, behp parambehp, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      betc.a("EventListener", "onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
      return "";
    }
    betc.a("EventListener", "ServiceRemoteRuntime onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
    if (this.jdField_a_of_type_Bfbi.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine == null) {
      return "";
    }
    return this.jdField_a_of_type_Bfbi.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.handleNativeRequest(paramString1, paramString2, parambehp, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfbi.a() != null)
    {
      betc.a("EventListener", "moveAppBrandToBack. | " + this);
      if (!this.jdField_a_of_type_Bfbi.a().moveTaskToBack(false))
      {
        betc.d("EventListener", "moveTaskToBack failed, finish the activity.");
        this.jdField_a_of_type_Bfbi.a().finish();
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfcb != null) {
      this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfcb.a(false);
    }
    this.jdField_a_of_type_Bfbi.b(this.jdField_a_of_type_Bfbi.a(), true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfdt == null) {
      return;
    }
    betc.a("EventListener", "ServiceRemoteRuntime  onWebViewEvent eventName=" + paramString1 + ",pageWebviewId=" + paramInt);
    if (paramString1.contains("GenerateFuncReady")) {
      SpeedUtil.DEFAULT.event("GenerateFuncReady");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfdt.a(paramString1, paramString2, paramInt);
      return;
      if ((paramString2 != null) && (paramString2.contains("__DOMReady")))
      {
        SpeedUtil.DEFAULT.event("domReady");
        SpeedUtil.DEFAULT.report(new String[0]);
        SpeedUtil.DEFAULT.clear();
        this.b = true;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("custom_event_onAppRouteDone".equals(paramString1)) {
      this.jdField_a_of_type_Bfbi.a(bekc.a(10));
    }
    if (this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfcb != null) {
      this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfcb.a(paramString1, paramString2, paramArrayOfInt);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    SpeedUtil.DEFAULT.event("onWebViewReady " + paramInt);
    c(paramString1, paramString2, paramInt);
    d(paramString1, paramString2, paramInt);
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    SpeedUtil.DEFAULT.event("onAppRoute " + paramInt + " " + paramString2);
    paramString1 = bela.a(paramString2, paramString1, this.jdField_a_of_type_Bfbi.a());
    this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfdt.a("onAppRoute", paramString1.toString(), paramInt);
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = bela.a(paramString2, paramString1, this.jdField_a_of_type_Bfbi.a());
    this.jdField_a_of_type_Bfbi.jdField_a_of_type_Bfdt.a("onAppRouteDone", paramString1.toString(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbj
 * JD-Core Version:    0.7.0.1
 */
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

public class bfas
  implements bfbn, bfdd
{
  private bfar a;
  protected boolean a;
  private boolean b;
  
  public bfas(bfar parambfar)
  {
    this.jdField_a_of_type_Bfar = parambfar;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int j = 1;
    int i = 1;
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      this.jdField_a_of_type_Boolean = true;
      besl.b("EventListener", "WeixinJSBridge finished.");
      SpeedUtil.DEFAULT.event("initWeixinJSBridge finished");
      return bekg.a(paramString1, null).toString();
    }
    bfdc localbfdc = this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfdc;
    bfbk localbfbk = this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfbk;
    JsPluginEngine localJsPluginEngine = this.jdField_a_of_type_Bfar.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
    bejy localbejy = this.jdField_a_of_type_Bfar.jdField_a_of_type_Bejy;
    beka localbeka = new bekb().a(paramString1).b(paramString2).a(paramInt).a(localbfdc).a();
    for (;;)
    {
      try
      {
        if ("redirectTo".equals(paramString1))
        {
          paramString2 = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty(paramString2))
          {
            if ((localbejy != null) && (localbejy.a(paramString2)))
            {
              paramInt = i;
              if (paramInt != 0) {
                return localbeka.b();
              }
              beki.a(new EventListener.1(this, localbfbk, paramString2, localbeka));
            }
          }
          else {
            return bekg.a(paramString1, null).toString();
          }
        }
        else
        {
          if ("navigateTo".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2))
            {
              if ((localbejy == null) || (!localbejy.a(paramString2))) {
                break label544;
              }
              paramInt = j;
              if (paramInt != 0) {
                return bekg.b(paramString1, null).toString();
              }
              beki.a(new EventListener.2(this, localbfbk, paramString2, localbeka));
            }
            return bekg.a(paramString1, null).toString();
          }
          if ("navigateBack".equals(paramString1))
          {
            paramInt = new JSONObject(paramString2).optInt("delta", 0);
            if (paramInt > 0) {
              beki.a(new EventListener.3(this, localbfbk, paramInt, localbeka));
            }
            return bekg.a(paramString1, null).toString();
          }
          if ("switchTab".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              beki.a(new EventListener.4(this, localbfbk, paramString2, localbeka));
            }
            return bekg.a(paramString1, null).toString();
          }
          if ("reLaunch".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              beki.a(new EventListener.5(this, paramString2, localbeka));
            }
            return bekg.a(paramString1, null).toString();
          }
          if ("exitMiniProgram".equals(paramString1))
          {
            beki.a(new EventListener.6(this));
            if (localJsPluginEngine != null) {
              return localJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbfdc, paramInt);
            }
          }
          else
          {
            if (!"flutter_launch".equals(paramString1)) {
              continue;
            }
            beki.a(new EventListener.7(this, localbfbk, paramString1, paramString2, localbeka));
            continue;
          }
          return "";
        }
      }
      catch (JSONException paramString1)
      {
        besl.d("EventListener", "", paramString1);
        return "";
      }
      catch (Throwable paramString1)
      {
        besl.d("EventListener", "", paramString1);
        return "";
      }
      paramInt = 0;
      continue;
      label544:
      paramInt = 0;
    }
  }
  
  public String a(String paramString1, String paramString2, begy parambegy, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      besl.a("EventListener", "onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
      return "";
    }
    besl.a("EventListener", "ServiceRemoteRuntime onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
    if (this.jdField_a_of_type_Bfar.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine == null) {
      return "";
    }
    return this.jdField_a_of_type_Bfar.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.handleNativeRequest(paramString1, paramString2, parambegy, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfar.a() != null)
    {
      besl.a("EventListener", "moveAppBrandToBack. | " + this);
      if (!this.jdField_a_of_type_Bfar.a().moveTaskToBack(false))
      {
        besl.d("EventListener", "moveTaskToBack failed, finish the activity.");
        this.jdField_a_of_type_Bfar.a().finish();
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfbk != null) {
      this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfbk.a(false);
    }
    this.jdField_a_of_type_Bfar.b(this.jdField_a_of_type_Bfar.a(), true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfdc == null) {
      return;
    }
    besl.a("EventListener", "ServiceRemoteRuntime  onWebViewEvent eventName=" + paramString1 + ",pageWebviewId=" + paramInt);
    if (paramString1.contains("GenerateFuncReady")) {
      SpeedUtil.DEFAULT.event("GenerateFuncReady");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfdc.a(paramString1, paramString2, paramInt);
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
      this.jdField_a_of_type_Bfar.a(bejl.a(10));
    }
    if (this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfbk != null) {
      this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfbk.a(paramString1, paramString2, paramArrayOfInt);
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
    paramString1 = bekj.a(paramString2, paramString1, this.jdField_a_of_type_Bfar.a());
    this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfdc.a("onAppRoute", paramString1.toString(), paramInt);
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = bekj.a(paramString2, paramString1, this.jdField_a_of_type_Bfar.a());
    this.jdField_a_of_type_Bfar.jdField_a_of_type_Bfdc.a("onAppRouteDone", paramString1.toString(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfas
 * JD-Core Version:    0.7.0.1
 */
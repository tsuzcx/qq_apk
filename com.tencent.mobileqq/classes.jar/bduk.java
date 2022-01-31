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

public class bduk
  implements bdvf, bdwq
{
  private bduj a;
  protected boolean a;
  private boolean b;
  
  public bduk(bduj parambduj)
  {
    this.jdField_a_of_type_Bduj = parambduj;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int j = 1;
    int i = 1;
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      this.jdField_a_of_type_Boolean = true;
      bdnw.b("EventListener", "WeixinJSBridge finished.");
      SpeedUtil.DEFAULT.event("initWeixinJSBridge finished");
      return bdgg.a(paramString1, null).toString();
    }
    bdwp localbdwp = this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdwp;
    bdvc localbdvc = this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdvc;
    JsPluginEngine localJsPluginEngine = this.jdField_a_of_type_Bduj.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
    bdfx localbdfx = this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdfx;
    bdfz localbdfz = new bdga().a(paramString1).b(paramString2).a(paramInt).a(localbdwp).a();
    for (;;)
    {
      try
      {
        if ("redirectTo".equals(paramString1))
        {
          paramString2 = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty(paramString2))
          {
            if ((localbdfx != null) && (localbdfx.a(paramString2)))
            {
              paramInt = i;
              if (paramInt != 0) {
                return localbdfz.b();
              }
              bdgi.a(new EventListener.1(this, localbdvc, paramString2, localbdfz));
            }
          }
          else {
            return bdgg.a(paramString1, null).toString();
          }
        }
        else
        {
          if ("navigateTo".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2))
            {
              if ((localbdfx == null) || (!localbdfx.a(paramString2))) {
                break label544;
              }
              paramInt = j;
              if (paramInt != 0) {
                return bdgg.b(paramString1, null).toString();
              }
              bdgi.a(new EventListener.2(this, localbdvc, paramString2, localbdfz));
            }
            return bdgg.a(paramString1, null).toString();
          }
          if ("navigateBack".equals(paramString1))
          {
            paramInt = new JSONObject(paramString2).optInt("delta", 0);
            if (paramInt > 0) {
              bdgi.a(new EventListener.3(this, localbdvc, paramInt, localbdfz));
            }
            return bdgg.a(paramString1, null).toString();
          }
          if ("switchTab".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              bdgi.a(new EventListener.4(this, localbdvc, paramString2, localbdfz));
            }
            return bdgg.a(paramString1, null).toString();
          }
          if ("reLaunch".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              bdgi.a(new EventListener.5(this, paramString2, localbdfz));
            }
            return bdgg.a(paramString1, null).toString();
          }
          if ("exitMiniProgram".equals(paramString1))
          {
            bdgi.a(new EventListener.6(this));
            if (localJsPluginEngine != null) {
              return localJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbdwp, paramInt);
            }
          }
          else
          {
            if (!"flutter_launch".equals(paramString1)) {
              continue;
            }
            bdgi.a(new EventListener.7(this, localbdvc, paramString1, paramString2, localbdfz));
            continue;
          }
          return "";
        }
      }
      catch (JSONException paramString1)
      {
        bdnw.d("EventListener", "", paramString1);
        return "";
      }
      catch (Throwable paramString1)
      {
        bdnw.d("EventListener", "", paramString1);
        return "";
      }
      paramInt = 0;
      continue;
      label544:
      paramInt = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bduj.a() != null)
    {
      bdnw.a("EventListener", "moveAppBrandToBack. | " + this);
      if (!this.jdField_a_of_type_Bduj.a().moveTaskToBack(false))
      {
        bdnw.d("EventListener", "moveTaskToBack failed, finish the activity.");
        this.jdField_a_of_type_Bduj.a().finish();
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdvc != null) {
      this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdvc.a(false);
    }
    this.jdField_a_of_type_Bduj.b(this.jdField_a_of_type_Bduj.a(), true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdwp == null) {
      return;
    }
    bdnw.a("EventListener", "ServiceRemoteRuntime  onWebViewEvent eventName=" + paramString1 + ",pageWebviewId=" + paramInt);
    if (paramString1.contains("GenerateFuncReady")) {
      SpeedUtil.DEFAULT.event("GenerateFuncReady");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdwp.a(paramString1, paramString2, paramInt);
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
      this.jdField_a_of_type_Bduj.a(bdfl.a(10));
    }
    if (this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdvc != null) {
      this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdvc.a(paramString1, paramString2, paramArrayOfInt);
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
    paramString1 = bdgj.a(paramString2, paramString1, this.jdField_a_of_type_Bduj.a());
    this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdwp.a("onAppRoute", paramString1.toString(), paramInt);
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = bdgj.a(paramString2, paramString1, this.jdField_a_of_type_Bduj.a());
    this.jdField_a_of_type_Bduj.jdField_a_of_type_Bdwp.a("onAppRouteDone", paramString1.toString(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bduk
 * JD-Core Version:    0.7.0.1
 */
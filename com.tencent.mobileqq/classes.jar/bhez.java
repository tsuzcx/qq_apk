import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.log.QMLog;
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

public class bhez
  implements bhfy, bhhr
{
  private bhey a;
  protected boolean a;
  private boolean b;
  
  public bhez(bhey parambhey)
  {
    this.jdField_a_of_type_Bhey = parambhey;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int j = 1;
    int i = 1;
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      this.jdField_a_of_type_Boolean = true;
      QMLog.i("EventListener", "WeixinJSBridge finished.");
      SpeedUtil.DEFAULT.event("initWeixinJSBridge finished");
      return bgop.a(paramString1, null).toString();
    }
    bhhq localbhhq = this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhhq;
    bhfv localbhfv = this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhfv;
    JsPluginEngine localJsPluginEngine = this.jdField_a_of_type_Bhey.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
    bgod localbgod = this.jdField_a_of_type_Bhey.jdField_a_of_type_Bgod;
    bgok localbgok = new bgol().a(paramString1).b(paramString2).a(paramInt).a(localbhhq).a();
    for (;;)
    {
      try
      {
        if ("redirectTo".equals(paramString1))
        {
          paramString2 = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty(paramString2))
          {
            if ((localbgod != null) && (localbgod.a(paramString2)))
            {
              paramInt = i;
              if (paramInt != 0) {
                return localbgok.b();
              }
              bgor.a(new EventListener.1(this, localbhfv, paramString2, localbgok));
            }
          }
          else {
            return bgop.a(paramString1, null).toString();
          }
        }
        else
        {
          if ("navigateTo".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2))
            {
              if ((localbgod == null) || (!localbgod.a(paramString2))) {
                break label544;
              }
              paramInt = j;
              if (paramInt != 0) {
                return bgop.b(paramString1, null).toString();
              }
              bgor.a(new EventListener.2(this, localbhfv, paramString2, localbgok));
            }
            return bgop.a(paramString1, null).toString();
          }
          if ("navigateBack".equals(paramString1))
          {
            paramInt = new JSONObject(paramString2).optInt("delta", 0);
            if (paramInt > 0) {
              bgor.a(new EventListener.3(this, localbhfv, paramInt, localbgok));
            }
            return bgop.a(paramString1, null).toString();
          }
          if ("switchTab".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              bgor.a(new EventListener.4(this, localbhfv, paramString2, localbgok));
            }
            return bgop.a(paramString1, null).toString();
          }
          if ("reLaunch".equals(paramString1))
          {
            paramString2 = new JSONObject(paramString2).optString("url", "");
            if (!TextUtils.isEmpty(paramString2)) {
              bgor.a(new EventListener.5(this, paramString2, localbgok));
            }
            return bgop.a(paramString1, null).toString();
          }
          if ("exitMiniProgram".equals(paramString1))
          {
            bgor.a(new EventListener.6(this));
            if (localJsPluginEngine != null) {
              return localJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbhhq, paramInt);
            }
          }
          else
          {
            if (!"flutter_launch".equals(paramString1)) {
              continue;
            }
            bgor.a(new EventListener.7(this, localbhfv, paramString1, paramString2, localbgok));
            continue;
          }
          return "";
        }
      }
      catch (JSONException paramString1)
      {
        QMLog.e("EventListener", "", paramString1);
        return "";
      }
      catch (Throwable paramString1)
      {
        QMLog.e("EventListener", "", paramString1);
        return "";
      }
      paramInt = 0;
      continue;
      label544:
      paramInt = 0;
    }
  }
  
  public String a(String paramString1, String paramString2, bglu parambglu, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      QMLog.d("EventListener", "onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
      return "";
    }
    QMLog.d("EventListener", "ServiceRemoteRuntime onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
    if (this.jdField_a_of_type_Bhey.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine == null) {
      return "";
    }
    return this.jdField_a_of_type_Bhey.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.handleNativeRequest(paramString1, paramString2, parambglu, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhey.a() != null)
    {
      QMLog.d("EventListener", "moveAppBrandToBack. | " + this);
      if (!this.jdField_a_of_type_Bhey.a().moveTaskToBack(false))
      {
        QMLog.e("EventListener", "moveTaskToBack failed, finish the activity.");
        this.jdField_a_of_type_Bhey.a().finish();
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhfv != null) {
      this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhfv.a(false);
    }
    this.jdField_a_of_type_Bhey.a(this.jdField_a_of_type_Bhey.a(), true, paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhhq == null) {
      return;
    }
    QMLog.d("EventListener", "ServiceRemoteRuntime  onWebViewEvent eventName=" + paramString1 + ",pageWebviewId=" + paramInt);
    if (paramString1.contains("GenerateFuncReady")) {
      SpeedUtil.DEFAULT.event("GenerateFuncReady");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhhq.a(paramString1, paramString2, paramInt);
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
      this.jdField_a_of_type_Bhey.a(bgmd.a(10));
    }
    if (this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhfv != null) {
      this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhfv.a(paramString1, paramString2, paramArrayOfInt);
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
    paramString1 = bgos.a(paramString2, paramString1, this.jdField_a_of_type_Bhey.a());
    this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhhq.a("onAppRoute", paramString1.toString(), paramInt);
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = bgos.a(paramString2, paramString1, this.jdField_a_of_type_Bhey.a());
    this.jdField_a_of_type_Bhey.jdField_a_of_type_Bhhq.a("onAppRouteDone", paramString1.toString(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhez
 * JD-Core Version:    0.7.0.1
 */
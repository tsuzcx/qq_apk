package com.tencent.luggage.wxa.kp;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import com.tencent.luggage.wxa.on.n;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
  extends com.tencent.luggage.wxa.kd.b
{
  private static final int CTRL_INDEX = 329;
  public static final String NAME = "insertCamera";
  private static j.a a;
  private boolean b;
  
  private static int a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1078030475)
    {
      if (i != 102742843)
      {
        if ((i == 109548807) && (paramString.equals("small")))
        {
          i = 0;
          break label70;
        }
      }
      else if (paramString.equals("large"))
      {
        i = 2;
        break label70;
      }
    }
    else if (paramString.equals("medium"))
    {
      i = 1;
      break label70;
    }
    i = -1;
    label70:
    int j = 288;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return 288;
        }
        return 720;
      }
      j = 480;
    }
    return j;
  }
  
  public static void a(j.a parama)
  {
    a = parama;
  }
  
  private boolean a(com.tencent.luggage.wxa.jx.c paramc, e parame, com.tencent.luggage.wxa.kd.j paramj)
  {
    Object localObject = new WeakReference(parame);
    WeakReference localWeakReference = new WeakReference(paramc);
    n.b(String.valueOf(paramc.getAppId()), new j.3(this, (WeakReference)localObject, localWeakReference, paramj));
    localObject = (Activity)paramc.getContext();
    if (localObject == null) {
      return false;
    }
    boolean bool = com.tencent.luggage.util.j.a((Activity)localObject, "android.permission.CAMERA", 16, "", "");
    a.a().a(bool);
    if (!bool) {
      return false;
    }
    bool = com.tencent.luggage.util.j.a((Activity)localObject, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a().b(bool);
    if (!bool) {
      return false;
    }
    n.a(paramc.getAppId());
    if (!this.b)
    {
      paramj.a(b("ok"));
      parame.a();
      this.b = true;
    }
    return true;
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId");
  }
  
  protected View a(com.tencent.luggage.wxa.jx.e parame, JSONObject paramJSONObject)
  {
    this.b = false;
    Context localContext = parame.getContext();
    e locale = a.b(localContext);
    int i = paramJSONObject.optInt("cameraId");
    String str1 = paramJSONObject.optString("mode", "normal");
    String str2 = paramJSONObject.optString("devicePosition", "back");
    String str3 = paramJSONObject.optString("flash", "auto");
    int j = a(paramJSONObject.optString("size"));
    boolean bool = paramJSONObject.optBoolean("needOutput", false);
    Object localObject = paramJSONObject.optString("resolution", "medium");
    locale.setAppId(parame.getAppId());
    locale.setPage(parame);
    locale.setCameraId(i);
    locale.setMode(str1);
    locale.a(str2, true);
    locale.setFlash(str3);
    locale.setFrameLimitSize(j);
    locale.setNeedOutput(bool);
    locale.setResolution((String)localObject);
    locale.setPageOrientation(parame.v());
    localObject = paramJSONObject.optJSONObject("position");
    j = g.a((JSONObject)localObject, "width", 0);
    int k = g.a((JSONObject)localObject, "height", 0);
    if ((j != 0) && (k != 0)) {
      locale.a(j, k, true);
    }
    localObject = (d)parame.a(d.class);
    if (localObject != null)
    {
      parame = ((d)localObject).a(parame);
      if ((parame != null) && (parame.length == 2) && (parame[0] > 0) && (parame[1] > 0))
      {
        locale.setDisplayScreenSize(new Size(parame[0], parame[1]));
        o.d("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(parame[0]), Integer.valueOf(parame[1]) });
      }
    }
    parame = paramJSONObject.optJSONArray("scanArea");
    if ((parame != null) && (parame.length() == 4))
    {
      o.d("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
      locale.a(g.c(parame.optInt(0)), g.c(parame.optInt(1)), g.c(parame.optInt(2)), g.c(parame.optInt(3)));
    }
    else
    {
      locale.a(0, 0, j, k);
    }
    locale.setScanFreq(paramJSONObject.optInt("scanFreq"));
    bool = paramJSONObject.optBoolean("centerCrop");
    locale.setPreviewCenterCrop(bool);
    o.e("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d, centerCrop: %b", new Object[] { Integer.valueOf(i), str2, str3, Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) });
    parame = locale.getView();
    if ("normal".equals(str1)) {
      i = 2131886744;
    } else {
      i = 2131886745;
    }
    parame.setContentDescription(localContext.getString(i));
    return new com.tencent.luggage.wxa.kt.b(localContext, (View)locale);
  }
  
  protected void a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject, com.tencent.luggage.wxa.kd.j paramj)
  {
    o.d("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramView = (e)((com.tencent.luggage.wxa.kt.b)paramView).a(View.class);
    if (paramView == null)
    {
      o.b("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      paramj.a(b("fail:internal error"));
      return;
    }
    paramJSONObject = new WeakReference(paramView);
    WeakReference localWeakReference = new WeakReference(parame);
    a(parame, paramView, paramj);
    a.a().a(paramView.getCameraId(), paramView);
    parame.a(paramView);
    parame.a(paramView);
    parame.a(paramView);
    com.tencent.luggage.wxa.iu.c.a(parame.getAppId(), new j.1(this, paramJSONObject, localWeakReference));
    paramView.setOutPutCallBack(new j.2(this));
  }
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.mw;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.View;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.kp.f;
import com.tencent.luggage.wxa.on.n;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends a
{
  private static final int CTRL_INDEX = 806;
  public static final String NAME = "insertXWebCamera";
  private boolean a;
  
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
  
  private boolean a(com.tencent.luggage.wxa.jx.c paramc, com.tencent.luggage.wxa.kp.e parame, b.a parama)
  {
    n.b(String.valueOf(paramc.getAppId()), new b.3(this, paramc, parame, parama));
    Activity localActivity = (Activity)paramc.getContext();
    if (localActivity == null) {
      return false;
    }
    boolean bool = j.a(localActivity, "android.permission.CAMERA", 16, "", "");
    com.tencent.luggage.wxa.kp.a.a().a(bool);
    if (!bool) {
      return false;
    }
    bool = j.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    com.tencent.luggage.wxa.kp.a.a().b(bool);
    if (!bool) {
      return false;
    }
    n.a(paramc.getAppId());
    if (!this.a)
    {
      if (parama != null) {
        parama.a();
      }
      parame.a();
      this.a = true;
    }
    return true;
  }
  
  public f a(com.tencent.luggage.wxa.jx.e parame, f paramf, JSONObject paramJSONObject, SurfaceTexture paramSurfaceTexture)
  {
    this.a = false;
    Context localContext = parame.getContext();
    int i = paramJSONObject.optInt("cameraId");
    String str1 = paramJSONObject.optString("mode", "normal");
    String str2 = paramJSONObject.optString("devicePosition", "back");
    String str3 = paramJSONObject.optString("flash", "auto");
    int j = a(paramJSONObject.optString("size"));
    boolean bool = paramJSONObject.optBoolean("needOutput", false);
    String str4 = paramJSONObject.optString("resolution");
    paramf.setAppId(parame.getAppId());
    paramf.setPage(parame);
    paramf.setCameraId(i);
    paramf.setMode(str1);
    paramf.a(str2, true);
    paramf.setFlash(str3);
    paramf.setFrameLimitSize(j);
    paramf.setNeedOutput(bool);
    paramf.setResolution(str4);
    paramf.setCustomSurfaceTexture(paramSurfaceTexture);
    paramf.setPageOrientation(parame.v());
    paramSurfaceTexture = paramJSONObject.optJSONObject("position");
    j = g.a(paramSurfaceTexture, "width", 0);
    int k = g.a(paramSurfaceTexture, "height", 0);
    if ((j != 0) && (k != 0)) {
      paramf.a(j, k, true);
    }
    if ((parame instanceof u))
    {
      parame = w.a((u)parame);
      paramf.setDisplayScreenSize(new Size(parame[0], parame[1]));
    }
    parame = paramJSONObject.optJSONArray("scanArea");
    if ((parame != null) && (parame.length() == 4))
    {
      o.d("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
      paramf.a(g.c(parame.optInt(0)), g.c(parame.optInt(1)), g.c(parame.optInt(2)), g.c(parame.optInt(3)));
    }
    else
    {
      paramf.a(0, 0, j, k);
    }
    paramf.setScanFreq(paramJSONObject.optInt("scanFreq"));
    paramf.setPreviewCenterCrop(paramJSONObject.optBoolean("centerCrop"));
    o.e("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(i), str2, str3, Integer.valueOf(j), Integer.valueOf(k) });
    parame = paramf.getView();
    if ("normal".equals(str1)) {
      i = 2131886744;
    } else {
      i = 2131886745;
    }
    parame.setContentDescription(localContext.getString(i));
    return paramf;
  }
  
  public void a(com.tencent.luggage.wxa.jx.e parame, com.tencent.luggage.wxa.kp.e parame1, b.a parama)
  {
    o.d("MicroMsg.JsApiInsertXWebCamera", "onInsertViewWithAsyncCallback");
    if (parame1 == null)
    {
      o.c("MicroMsg.JsApiInsertXWebCamera", "onInsertView failed, cameraView is null");
      return;
    }
    a(parame, parame1, parama);
    com.tencent.luggage.wxa.kp.a.a().a(parame1.getCameraId(), parame1);
    parame.a(parame1);
    parame.a(parame1);
    parame.a(parame1);
    parama = new WeakReference(parame1);
    com.tencent.luggage.wxa.iu.c.a(parame.getAppId(), new b.1(this, parama, parame));
    parame1.setOutPutCallBack(new b.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mw.b
 * JD-Core Version:    0.7.0.1
 */
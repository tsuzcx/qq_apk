package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.on.n;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.sc.d;
import com.tencent.rtmp.TXLiveBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends com.tencent.luggage.wxa.gf.a
  implements com.tencent.luggage.wxa.fy.o
{
  private j.a A = new j.a(this);
  private Handler B;
  private HandlerThread C = d.b(String.format("LivePusherThread_%s", new Object[] { Long.valueOf(System.currentTimeMillis()) }), 5);
  private ScaleGestureDetector.OnScaleGestureListener D = new j.15(this);
  private Surface e;
  private SurfaceTexture f;
  private k g;
  private com.tencent.luggage.wxa.gc.c h;
  private com.tencent.luggage.wxa.gc.b i;
  private com.tencent.luggage.wxa.gc.a j;
  private com.tencent.luggage.wxa.fx.a k;
  private a.a l;
  private int m;
  private int n;
  private String o = "";
  private String p;
  private int q;
  private boolean r;
  private boolean s;
  private int t = 1;
  private boolean u;
  private ScaleGestureDetector v;
  private j.c w = new j.c(this, null);
  private Handler x;
  private int y = 0;
  private com.tencent.luggage.wxa.pd.t z;
  
  public j()
  {
    this.C.start();
    this.B = new Handler(this.C.getLooper());
    this.x = new Handler(r.a().getMainLooper());
    com.tencent.luggage.wxa.fz.b.a();
    e();
    f();
    c();
  }
  
  private String a()
  {
    return String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePusherPluginHandler", A() });
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((k)localObject).a(paramFloat1, paramFloat2);
      com.tencent.luggage.wxa.qz.o.d(a(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject).a), ((com.tencent.luggage.wxa.fz.a)localObject).b });
    }
  }
  
  private void a(Activity paramActivity, com.tencent.luggage.wxa.fx.a parama)
  {
    int i1 = this.q;
    this.q = (i1 + 1);
    if (i1 > 5)
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
      parama.a("fail:system permission denied");
      return;
    }
    n.b(parama.a(), new j.14(this, paramActivity, parama));
    if (!com.tencent.luggage.util.j.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
      parama.a("fail:system permission denied");
      return;
    }
    if (!com.tencent.luggage.util.j.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
      parama.a("fail:system permission denied");
      return;
    }
    com.tencent.luggage.wxa.qz.o.d(a(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
    f(parama);
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull String paramString, @NonNull JSONObject paramJSONObject)
  {
    if (this.j == null)
    {
      com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathAndOperateLivePusher, customHandler is null");
      parama.a("fail");
      return;
    }
    String str1 = paramJSONObject.optString("path", null);
    if (af.c(str1))
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "convertResourcePathAndOperateLivePusher, resourcePath is empty");
      b(parama, paramString, paramJSONObject);
      return;
    }
    String str2 = paramJSONObject.optString("md5", null);
    boolean bool = paramString.equalsIgnoreCase("applySticker");
    this.j.a(parama, str1, str2, bool, new j.6(this, parama, paramJSONObject, paramString));
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("stickers");
    if (localJSONArray != null)
    {
      int i2 = localJSONArray.length();
      if (i2 != 0)
      {
        j.b localb = new j.b(null);
        localb.a = i2;
        int i1 = 0;
        while (i1 < i2)
        {
          JSONObject localJSONObject = localJSONArray.optJSONObject(i1);
          if (localJSONObject == null)
          {
            com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher1, stickerJsonObj(%d) is null", new Object[] { Integer.valueOf(i1) });
            parama.a("fail");
            return;
          }
          String str1 = localJSONObject.optString("path", null);
          if (af.c(str1))
          {
            com.tencent.luggage.wxa.qz.o.d(a(), "convertResourcePathWorkaroundAndOperateLivePusher1, resourcePath(%d) is empty", new Object[] { Integer.valueOf(i1) });
            parama.a("fail");
            return;
          }
          String str2 = localJSONObject.optString("md5", null);
          this.j.a(parama, str1, str2, true, new j.7(this, i1, parama, localJSONObject, localb, paramJSONObject));
          i1 += 1;
        }
        return;
      }
    }
    com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher, stickersJsonArr is empty");
    parama.a("fail");
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("filterImage"))
    {
      this.o = paramJSONObject.optString("filterImage", this.o);
      this.p = paramJSONObject.optString("filterImageMd5", null);
      if (af.c(this.o)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          return;
        }
        catch (JSONException paramJSONObject)
        {
          com.tencent.luggage.wxa.qz.o.c(a(), "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          return;
        }
      }
      if ((this.o.startsWith("http://")) || (this.o.startsWith("https://"))) {
        paramJSONObject.remove("filterImage");
      }
    }
  }
  
  private void a(@NonNull String[] paramArrayOfString1, @NonNull String[] paramArrayOfString2, @NonNull String[] paramArrayOfString3, @NonNull JSONObject paramJSONObject1, @NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull JSONObject paramJSONObject2)
  {
    int i2 = paramArrayOfString1.length;
    j.b localb = new j.b(null);
    localb.a = i2;
    int i1 = 0;
    while (i1 < i2)
    {
      this.j.a(parama, paramArrayOfString1[i1], paramArrayOfString2[i1], false, new j.8(this, i1, parama, paramJSONObject1, paramArrayOfString3, localb, paramJSONObject2));
      i1 += 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt != this.y)
    {
      this.y = paramInt;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", new Object[] { Integer.valueOf(paramInt) });
      k localk = this.g;
      if (localk != null)
      {
        localk.a(paramInt);
        return true;
      }
    }
    return false;
  }
  
  private void b(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handlePluginReady", new Object[] { A() });
    this.f = paramSurfaceTexture;
    this.e = new Surface(paramSurfaceTexture);
    paramSurfaceTexture = this.g;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.a(this.e);
      n();
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handlePluginTouch(%s)", new Object[] { A(), paramMotionEvent });
    if ((this.s) || (this.u))
    {
      if ((paramMotionEvent.getPointerCount() == 1) && (paramMotionEvent.getAction() == 0))
      {
        com.tencent.luggage.wxa.qz.o.d(a(), "handlePluginTouch, 1 pointer action down");
        this.w.a(paramMotionEvent);
        com.tencent.luggage.wxa.qz.t.a(this.w, 100L);
        return;
      }
      if ((paramMotionEvent.getPointerCount() > 1) && (paramMotionEvent.getAction() == 2))
      {
        com.tencent.luggage.wxa.qz.o.d(a(), "handlePluginTouch, 2 pointer action move");
        com.tencent.luggage.wxa.qz.t.b(this.w);
        a(-1.0F, -1.0F);
        if (this.u)
        {
          ScaleGestureDetector localScaleGestureDetector = this.v;
          if (localScaleGestureDetector != null) {
            localScaleGestureDetector.onTouchEvent(paramMotionEvent);
          }
        }
      }
    }
  }
  
  private void b(@NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull String paramString, @NonNull JSONObject paramJSONObject)
  {
    com.tencent.luggage.wxa.qz.o.d(a(), "convertResourcePathWorkaroundAndOperateLivePusher");
    if (paramString.equalsIgnoreCase("applySticker"))
    {
      a(parama, paramJSONObject);
      return;
    }
    if (paramString.equalsIgnoreCase("applyMakeup"))
    {
      b(parama, paramJSONObject);
      return;
    }
    com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher, type is illegal");
    parama.a("fail");
  }
  
  private void b(@NonNull com.tencent.luggage.wxa.fx.a parama, @NonNull JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("makeupType", null);
    boolean bool = af.c((String)localObject2);
    Object localObject1 = "fail";
    if (bool)
    {
      com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is empty");
      parama.a("fail");
      return;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("makeup");
    if (localJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupJsonObj is null");
      parama.a("fail");
      return;
    }
    if (((String)localObject2).equalsIgnoreCase("lipStick"))
    {
      localObject2 = this.g.a("applyMakeup", paramJSONObject);
      com.tencent.luggage.wxa.qz.o.d(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, type:applyMakeup, error:[%s, %s]", new Object[] { Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject2).a), ((com.tencent.luggage.wxa.fz.a)localObject2).b });
      paramJSONObject = (JSONObject)localObject1;
      if (((com.tencent.luggage.wxa.fz.a)localObject2).a == 0) {
        paramJSONObject = "ok";
      }
      parama.a(paramJSONObject);
      return;
    }
    if (((String)localObject2).equalsIgnoreCase("eyeShadow"))
    {
      localObject1 = localJSONObject.optString("leftPath", null);
      if (af.c((String)localObject1))
      {
        com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
        parama.a("fail");
        return;
      }
      localObject2 = localJSONObject.optString("leftPathMD5", null);
      str1 = localJSONObject.optString("shimmerPosition", null);
      if (!af.c(str1))
      {
        String str2 = localJSONObject.optString("shimmerPositionMD5", null);
        localObject3 = new String[] { "leftPath", "shimmerPosition" };
        localObject2 = new String[] { localObject2, str2 };
        localObject1 = new String[] { localObject1, str1 };
      }
      else
      {
        localObject1 = new String[] { localObject1 };
        localObject2 = new String[] { localObject2 };
        localObject3 = new String[] { "leftPath" };
      }
      a((String[])localObject1, (String[])localObject2, (String[])localObject3, localJSONObject, parama, paramJSONObject);
      return;
    }
    if ((!((String)localObject2).equalsIgnoreCase("blusherStick")) && (!((String)localObject2).equalsIgnoreCase("eyeBrow")))
    {
      if (((String)localObject2).equalsIgnoreCase("faceContour"))
      {
        localObject1 = localJSONObject.optString("highlightPath", null);
        if (af.c((String)localObject1))
        {
          com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, highLightPath is empty");
          parama.a("fail");
          return;
        }
        localObject2 = localJSONObject.optString("highlightPathMD5", null);
        localObject3 = localJSONObject.optString("shadowPath", null);
        if (af.c((String)localObject3))
        {
          com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, shadowPath is empty");
          parama.a("fail");
          return;
        }
        str1 = localJSONObject.optString("shadowPathMD5", null);
        a(new String[] { localObject1, localObject3 }, new String[] { localObject2, str1 }, new String[] { "highlightPath", "shadowPath" }, localJSONObject, parama, paramJSONObject);
        return;
      }
      com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is illegal");
      parama.a("fail");
      return;
    }
    localObject1 = localJSONObject.optString("leftPath", null);
    if (af.c((String)localObject1))
    {
      com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
      parama.a("fail");
      return;
    }
    localObject2 = localJSONObject.optString("leftPathMD5", null);
    Object localObject3 = localJSONObject.optString("rightPath", null);
    if (af.c((String)localObject3))
    {
      com.tencent.luggage.wxa.qz.o.c(a(), "convertResourcePathWorkaroundAndOperateLivePusher2, rightPath is empty");
      parama.a("fail");
      return;
    }
    String str1 = localJSONObject.optString("rightPathMD5", null);
    a(new String[] { localObject1, localObject3 }, new String[] { localObject2, str1 }, new String[] { "leftPath", "rightPath" }, localJSONObject, parama, paramJSONObject);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.m = g.c(paramJSONObject.optInt("width", 0));
        this.n = g.c(paramJSONObject.optInt("height", 0));
        com.tencent.luggage.wxa.qz.o.d(a(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) });
        n();
      }
    }
  }
  
  private boolean b(@NonNull String paramString)
  {
    return (paramString.equalsIgnoreCase("applyFilter")) || (paramString.equalsIgnoreCase("applySticker")) || (paramString.equalsIgnoreCase("applyMakeup"));
  }
  
  private void c()
  {
    Handler localHandler = this.x;
    if (localHandler != null) {
      localHandler.post(new j.1(this));
    }
  }
  
  private void c(int paramInt)
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.4(this, paramInt));
    }
  }
  
  private void c(com.tencent.luggage.wxa.fx.a parama)
  {
    String str = parama.e();
    if (af.c(str)) {
      return;
    }
    JSONObject localJSONObject = parama.d();
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { A(), str, localJSONObject.toString() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsApi:");
    localStringBuilder.append(str);
    localStringBuilder.append(", data:");
    localStringBuilder.append(localJSONObject);
    Log.i("TXLivePusherAdapter", localStringBuilder.toString());
    if (str.contains("insert"))
    {
      e(5);
      e(parama);
      return;
    }
    if (str.contains("update"))
    {
      e(6);
      g(parama);
      return;
    }
    if (str.contains("operate"))
    {
      e(7);
      h(parama);
      return;
    }
    if (str.contains("remove"))
    {
      e(8);
      i(parama);
    }
  }
  
  private void c(com.tencent.luggage.wxa.fx.a parama, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("needEvent"))
    {
      this.r = paramJSONObject.optBoolean("needEvent", false);
      if (r()) {
        this.i.a(parama);
      }
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("focusMode"))
    {
      boolean bool = false;
      if (paramJSONObject.optInt("focusMode", 0) != 0) {
        bool = true;
      }
      this.s = bool;
    }
  }
  
  private void d(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handleWebViewBackground, type:%s", new Object[] { A(), Integer.valueOf(paramInt) });
    if (!a(null))
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "plugin is not ready");
      return;
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      if (!((com.tencent.luggage.wxa.gc.a)localObject).a(this, this.k, paramInt))
      {
        localObject = this.g;
        if ((localObject != null) && (paramInt == 4)) {
          ((k)localObject).c();
        }
      }
      if (this.g != null) {
        if (paramInt == 3)
        {
          com.tencent.luggage.wxa.qz.o.d(a(), "handleWebViewBackgroundInternal, type back");
          this.g.a(true);
        }
        else
        {
          com.tencent.luggage.wxa.qz.o.d(a(), "handleWebViewBackgroundInternal, type others");
          this.g.a(false);
        }
      }
    }
    this.z.disable();
  }
  
  private void d(com.tencent.luggage.wxa.fx.a parama)
  {
    this.l = new j.2(this);
    parama.a(this.l);
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("zoom")) {
      this.u = paramJSONObject.optBoolean("zoom", false);
    }
  }
  
  private void e()
  {
    this.g = new k(r.a());
    this.g.a(this.B);
    this.g.a(new j.12(this));
    this.g.a(new j.17(this));
    this.g.a(new j.18(this));
  }
  
  private void e(int paramInt)
  {
    com.tencent.luggage.wxa.gc.c localc = this.h;
    if (localc != null) {
      localc.a(paramInt, 1L, false);
    }
  }
  
  private void e(com.tencent.luggage.wxa.fx.a parama)
  {
    n(parama);
  }
  
  private void f()
  {
    this.z = new com.tencent.luggage.wxa.pd.t(r.a(), new j.19(this));
    this.z.enable();
    a(g());
  }
  
  private void f(com.tencent.luggage.wxa.fx.a parama)
  {
    if (this.g == null)
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "insert, adapter is null");
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.a() }));
    this.k = parama;
    d(parama);
    Object localObject = parama.d();
    c(parama, (JSONObject)localObject);
    b((JSONObject)localObject);
    c((JSONObject)localObject);
    d((JSONObject)localObject);
    a((JSONObject)localObject);
    Bundle localBundle = com.tencent.luggage.wxa.fz.c.b((JSONObject)localObject);
    localObject = this.j;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.gc.a)localObject).a(parama, localBundle);
      if (!af.c((String)localObject))
      {
        com.tencent.luggage.wxa.qz.o.d(a(), "insert fail, message:%s", new Object[] { localObject });
        parama.a("fail: can not insert VOIP mode LivePusher now");
        Toast.makeText(parama.b(), (CharSequence)localObject, 0).show();
        return;
      }
    }
    com.tencent.luggage.wxa.fz.a locala = this.g.a(localBundle);
    com.tencent.luggage.wxa.qz.o.d(a(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(locala.a), locala.b });
    if (locala.a == 0) {
      localObject = "ok";
    } else {
      localObject = "fail";
    }
    parama.a((String)localObject);
    j(parama);
    k(parama);
    if (locala.a == 0)
    {
      parama = this.j;
      if (parama != null) {
        parama.a(this, this.k, localBundle);
      }
    }
  }
  
  private int g()
  {
    if (r.a().getSystemService("window") != null) {
      return ((WindowManager)r.a().getSystemService("window")).getDefaultDisplay().getRotation();
    }
    return 0;
  }
  
  private void g(com.tencent.luggage.wxa.fx.a parama)
  {
    if (this.g == null)
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "update, adapter is null");
      return;
    }
    Object localObject = parama.d();
    c(parama, (JSONObject)localObject);
    b((JSONObject)localObject);
    c((JSONObject)localObject);
    d((JSONObject)localObject);
    a((JSONObject)localObject);
    Bundle localBundle = com.tencent.luggage.wxa.fz.c.b((JSONObject)localObject);
    localObject = this.j;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.gc.a)localObject).a(parama, localBundle);
      if (!af.c((String)localObject))
      {
        com.tencent.luggage.wxa.qz.o.d(a(), "update fail, message:%s", new Object[] { localObject });
        parama.a("fail: can not update LivePusher to VOIP mode now");
        Toast.makeText(parama.b(), (CharSequence)localObject, 0).show();
        return;
      }
    }
    com.tencent.luggage.wxa.fz.a locala = this.g.b(localBundle);
    com.tencent.luggage.wxa.qz.o.d(a(), "update, code:%d info:%s", new Object[] { Integer.valueOf(locala.a), locala.b });
    if (locala.a == 0) {
      localObject = "ok";
    } else {
      localObject = "fail";
    }
    parama.a((String)localObject);
    j(parama);
    k(parama);
    if (locala.a == 0)
    {
      parama = this.j;
      if (parama != null)
      {
        parama.a(this, this.k, localBundle);
        this.j.b(this, this.k, localBundle);
      }
    }
  }
  
  private void h()
  {
    super.d();
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handlePluginDestroy", new Object[] { A() });
  }
  
  private void h(com.tencent.luggage.wxa.fx.a parama)
  {
    if (this.g == null)
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "operate, adapter is null");
      return;
    }
    Object localObject = parama.d();
    String str2 = ((JSONObject)localObject).optString("type");
    com.tencent.luggage.wxa.qz.o.d(a(), "operate, type:%s", new Object[] { str2 });
    boolean bool = af.c(str2);
    String str1 = "fail";
    if ((!bool) && (this.g != null))
    {
      if (str2.equals("snapshot"))
      {
        l(parama);
        return;
      }
      if (str2.equals("playBGM"))
      {
        m(parama);
        return;
      }
      if (b(str2))
      {
        a(parama, str2, (JSONObject)localObject);
        return;
      }
      localObject = this.g.a(str2, (JSONObject)localObject);
      com.tencent.luggage.wxa.qz.o.d(a(), "operate, type:%s, error:[%s, %s]", new Object[] { str2, Integer.valueOf(((com.tencent.luggage.wxa.fz.a)localObject).a), ((com.tencent.luggage.wxa.fz.a)localObject).b });
      if (((com.tencent.luggage.wxa.fz.a)localObject).a == 0) {
        str1 = "ok";
      }
      parama.a(str1);
      if ((str2.equalsIgnoreCase("stop")) && (((com.tencent.luggage.wxa.fz.a)localObject).a == 0))
      {
        parama = this.j;
        if (parama != null) {
          parama.b(this, this.k);
        }
      }
    }
    else
    {
      parama.a("fail");
    }
  }
  
  private void i()
  {
    com.tencent.luggage.wxa.fx.a locala = this.k;
    if (locala != null)
    {
      locala.f();
      this.l = null;
    }
  }
  
  private void i(com.tencent.luggage.wxa.fx.a parama)
  {
    o();
    parama.a("ok");
  }
  
  private void j()
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.3(this));
    }
  }
  
  private void j(com.tencent.luggage.wxa.fx.a parama)
  {
    com.tencent.luggage.wxa.gc.a locala = this.j;
    if (locala != null) {
      locala.a(parama, new j.9(this));
    }
  }
  
  private void k()
  {
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handleWebViewForeground", new Object[] { A() });
    if (!a(null))
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "plugin is not ready");
      return;
    }
    k localk = this.g;
    if (localk != null) {
      localk.d();
    }
    this.z.enable();
  }
  
  private void k(com.tencent.luggage.wxa.fx.a parama)
  {
    if ((this.j != null) && (!af.c(this.o))) {
      this.j.a(parama, this.o, this.p, new j.10(this));
    }
  }
  
  private void l()
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.5(this));
    }
  }
  
  private void l(com.tencent.luggage.wxa.fx.a parama)
  {
    this.g.a(new j.11(this, parama));
    if (this.g.a("snapshot", parama.d()).a != 0) {
      parama.a("fail:snapshot error");
    }
  }
  
  private void m()
  {
    com.tencent.luggage.wxa.qz.o.d(a(), "*** handler(%s) handleWebViewDestroy", new Object[] { A() });
    o();
  }
  
  private void m(com.tencent.luggage.wxa.fx.a parama)
  {
    com.tencent.luggage.wxa.gc.a locala = this.j;
    if (locala != null)
    {
      locala.b(parama, new j.13(this));
      parama.a("ok");
      return;
    }
    parama.a("fail");
  }
  
  private void n()
  {
    if ((this.m != 0) && (this.n != 0) && (this.f != null) && (this.g != null))
    {
      com.tencent.luggage.wxa.qz.o.d(a(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) });
      this.f.setDefaultBufferSize(this.m, this.n);
      this.g.a(this.m, this.n);
    }
  }
  
  private void n(com.tencent.luggage.wxa.fx.a parama)
  {
    Context localContext = parama.b();
    if (!(localContext instanceof Activity))
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
      parama.a("fail:internal error invalid android context");
      n.a(parama.a());
      return;
    }
    this.q = 0;
    a((Activity)localContext, parama);
  }
  
  private void o()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((com.tencent.luggage.wxa.gc.a)localObject).b(this, this.k);
      this.j.a(this, this.k);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((k)localObject).a();
      this.g = null;
    }
    p();
    i();
    q();
  }
  
  private void p()
  {
    Surface localSurface = this.e;
    if (localSurface != null)
    {
      localSurface.release();
      this.e = null;
    }
  }
  
  private void q()
  {
    com.tencent.luggage.wxa.qz.o.d(a(), "LivePusher release handler thread");
    Object localObject = this.B;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.C;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
  
  private boolean r()
  {
    return this.i != null;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.20(this, paramSurfaceTexture));
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.22(this, paramMotionEvent));
    }
  }
  
  public void a(com.tencent.luggage.wxa.gc.a parama)
  {
    this.j = parama;
    parama = this.j;
    if (parama != null)
    {
      this.i = parama.a();
      this.h = this.j.b();
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.fx.a parama)
  {
    return true;
  }
  
  public String b()
  {
    return String.format("%s_%s", new Object[] { C(), Integer.valueOf(B()) });
  }
  
  public String b(com.tencent.luggage.wxa.fx.a parama)
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.23(this, parama));
    }
    return null;
  }
  
  public void d()
  {
    Handler localHandler = this.B;
    if (localHandler != null) {
      localHandler.post(new j.21(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j
 * JD-Core Version:    0.7.0.1
 */
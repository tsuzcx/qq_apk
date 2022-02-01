package com.tencent.luggage.wxa.nf;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.provider.Settings.System;
import com.tencent.luggage.wxa.iu.p;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.ng.h;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b.c b = new b.c(null);
  private static final String s = "MicroMsg.VideoCast.AppBrandVideoCastHandler";
  private int c;
  @NotNull
  private final com.tencent.luggage.wxa.jx.c d;
  private final i e;
  private final Lazy f;
  private final com.tencent.luggage.wxa.ng.c g;
  @NotNull
  private final com.tencent.luggage.wxa.iu.d h;
  private final Lazy i;
  private final ReadWriteProperty j;
  @NotNull
  private String k;
  private boolean l;
  private boolean m;
  @NotNull
  private final ReadWriteProperty n;
  private final b.h o;
  private final b.i p;
  private final com.tencent.luggage.wxa.ge.a q;
  private final com.tencent.luggage.wxa.fx.a r;
  
  public b(@NotNull com.tencent.luggage.wxa.ge.a parama, @NotNull com.tencent.luggage.wxa.fx.a parama1)
  {
    this.q = parama;
    this.r = parama1;
    parama = this.r.g();
    Intrinsics.checkExpressionValueIsNotNull(parama, "invokeContext.component");
    this.d = parama;
    parama = this.r.b();
    Intrinsics.checkExpressionValueIsNotNull(parama, "invokeContext.context");
    this.e = new i(parama, null);
    this.f = LazyKt.lazy((Function0)new b.d(this));
    this.g = ((com.tencent.luggage.wxa.ng.c)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ng.c.class));
    this.h = com.tencent.luggage.wxa.ng.d.a(this.r);
    this.i = LazyKt.lazy((Function0)new b.g(this));
    parama = Delegates.INSTANCE;
    parama = Boolean.valueOf(true);
    this.j = ((ReadWriteProperty)new b.a(parama, parama, this));
    parama = com.tencent.luggage.wxa.ng.d.a(this.r);
    parama1 = this.g;
    if (parama1 != null)
    {
      String str = parama.aa();
      Intrinsics.checkExpressionValueIsNotNull(str, "appBrandRuntime.appId");
      parama1.b(str);
      parama = parama.C();
      if (parama != null)
      {
        parama = parama.getPageView();
        if (parama != null)
        {
          parama = parama.an();
          if (parama != null) {
            break label231;
          }
        }
      }
      parama = "";
      label231:
      this.g.c(parama);
    }
    parama = this.d;
    if ((parama instanceof com.tencent.luggage.wxa.jx.e))
    {
      ((com.tencent.luggage.wxa.jx.e)parama).a((f.d)new b.1(this));
      ((com.tencent.luggage.wxa.jx.e)this.d).a((f.b)new b.2(this));
    }
    this.k = "";
    parama = Delegates.INSTANCE;
    parama = Boolean.valueOf(false);
    this.n = ((ReadWriteProperty)new b.b(parama, parama, this));
    this.o = new b.h(this);
    this.p = new b.i(this);
  }
  
  private final long a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
      {
        double d1 = paramJSONObject.optDouble(0, -1.0D);
        if (d1 < 0)
        {
          com.tencent.luggage.wxa.qz.o.c("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, invalid position:%s", new Object[] { Double.valueOf(d1) });
          return -1L;
        }
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, position:%s", new Object[] { Double.valueOf(d1) });
        double d2 = 1000;
        Double.isNaN(d2);
        return (d1 * d2);
      }
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, data array is null");
    }
    return -1L;
  }
  
  private final void d(boolean paramBoolean)
  {
    this.j.setValue(this, a[0], Boolean.valueOf(paramBoolean));
  }
  
  private final AudioManager k()
  {
    return (AudioManager)this.f.getValue();
  }
  
  private final h l()
  {
    return (h)this.i.getValue();
  }
  
  private final boolean m()
  {
    return ((Boolean)this.j.getValue(this, a[0])).booleanValue();
  }
  
  private final void n()
  {
    Context localContext = this.r.b();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "invokeContext.context");
    localContext.getContentResolver().unregisterContentObserver((ContentObserver)this.e);
  }
  
  private final void o()
  {
    Context localContext = this.r.b();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "invokeContext.context");
    localContext.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, (ContentObserver)this.e);
  }
  
  private final void p()
  {
    this.h.a((p)this.o);
    this.h.a((p)this.p);
  }
  
  private final void q()
  {
    this.h.a(25, -1, (p)this.o);
    this.h.a(24, -1, (p)this.p);
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    com.tencent.luggage.wxa.ng.c localc = this.g;
    if (localc != null) {
      localc.a(paramString);
    }
    this.k = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(@NotNull JSONObject paramJSONObject, @NotNull com.tencent.luggage.wxa.fx.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Intrinsics.checkParameterIsNotNull(parama, "invokeContext");
    parama = paramJSONObject.optString("type");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleOperate: type = ");
    localStringBuilder.append(parama);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", localStringBuilder.toString());
    if (parama == null) {
      return true;
    }
    switch (parama.hashCode())
    {
    default: 
      return true;
    case 1082113260: 
      if (parama.equals("reconnectCasting"))
      {
        paramJSONObject = this.g;
        if (paramJSONObject != null) {
          paramJSONObject.a(5);
        }
        l().e();
        return true;
      }
      break;
    case 420897153: 
      if (parama.equals("startCasting"))
      {
        l().a((Function0)new b.e(this));
        h.a(l(), true, false, 2, null);
        return true;
      }
      break;
    case 106440182: 
      if (parama.equals("pause"))
      {
        h.a(l(), null, 1, null);
        return true;
      }
      break;
    case 3526264: 
      if (parama.equals("seek"))
      {
        long l1 = a(paramJSONObject);
        if (l1 > 0L)
        {
          l().a(b.a((int)l1));
          return true;
        }
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", "invalid seek position");
        return false;
      }
      break;
    case 3443508: 
      if (parama.equals("play"))
      {
        h.a(l(), 0, 0, 3, null);
        return true;
      }
      break;
    case -1491869371: 
      if (parama.equals("exitCasting"))
      {
        paramJSONObject = this.g;
        if (paramJSONObject != null) {
          paramJSONObject.a(6);
        }
        h.b(l(), null, 1, null);
        l().d();
        this.m = false;
        c(false);
        return true;
      }
      break;
    case -1983381905: 
      if (parama.equals("switchCasting"))
      {
        paramJSONObject = this.g;
        if (paramJSONObject != null) {
          paramJSONObject.a(4);
        }
        l().f();
      }
      break;
    }
    return true;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.jx.c b()
  {
    return this.d;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "updateVideoPath");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateVideoPath: [");
    localStringBuilder.append(paramString);
    localStringBuilder.append(']');
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", localStringBuilder.toString());
    if (StringsKt.isBlank((CharSequence)StringsKt.trim((CharSequence)paramString).toString())) {
      return;
    }
    l().h();
    if (Intrinsics.areEqual(paramString, this.k)) {
      return;
    }
    a(paramString);
    c(true);
    l().b((Function1)new b.f(this));
    if (l().a() == -1)
    {
      l().a(8);
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", "discard a updateVideoPath report event");
  }
  
  public final void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.iu.d c()
  {
    return this.h;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.n.setValue(this, a[1], Boolean.valueOf(paramBoolean));
  }
  
  @NotNull
  public final String d()
  {
    return this.k;
  }
  
  public final boolean e()
  {
    return this.l;
  }
  
  public final boolean f()
  {
    if (!this.l) {
      return false;
    }
    return this.m;
  }
  
  public final boolean g()
  {
    return ((Boolean)this.n.getValue(this, a[1])).booleanValue();
  }
  
  public void h()
  {
    l().d();
    this.m = false;
    c(false);
    l().h();
  }
  
  public final int i()
  {
    AudioManager localAudioManager = k();
    if (localAudioManager != null) {
      return localAudioManager.getStreamMaxVolume(3);
    }
    return 0;
  }
  
  public final int j()
  {
    AudioManager localAudioManager = k();
    if (localAudioManager != null) {
      return localAudioManager.getStreamVolume(3);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.b
 * JD-Core Version:    0.7.0.1
 */
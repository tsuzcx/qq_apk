package com.tencent.magicbrush;

import android.content.Context;
import android.content.res.AssetManager;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.tencent.magicbrush.handler.a;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.a.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "box2dSoPath", "", "getBox2dSoPath", "()Ljava/lang/String;", "setBox2dSoPath", "(Ljava/lang/String;)V", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableSwitchThreadNativeForAsyncJsApis", "getEnableSwitchThreadNativeForAsyncJsApis", "setEnableSwitchThreadNativeForAsyncJsApis", "enableSwitchThreadNativeForAsyncJsApis$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "isLogicOnly", "setLogicOnly", "isLogicOnly$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", "params", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "physxSoPath", "getPhysxSoPath", "setPhysxSoPath", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "sdcardPath", "getSdcardPath", "setSdcardPath", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "wasmCachePath", "getWasmCachePath", "setWasmCachePath", "wasmCachePath$delegate", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public class g
{
  @NotNull
  private final g.a A = new g.a(this, aa.a);
  @NotNull
  private final g.a B = new g.a(this, r.a);
  @NotNull
  private final g.a C = new g.a(this, ad.a);
  @NotNull
  private final g.a D = new g.a(this, aj.a);
  @NotNull
  private final g.a E = new g.a(this, v.a);
  @NotNull
  private final g.a F = new g.a(this, ai.a);
  @NotNull
  private final g.a G = new g.a(this, af.a);
  @NotNull
  private final g.a H = new g.a(this, ae.a);
  @NotNull
  private final g.a I = new g.a(this, ah.a);
  @NotNull
  private final g.a J = new g.a(this, ag.a);
  @Nullable
  private String K;
  @Nullable
  private String L;
  @NotNull
  private final g.a M = new g.a(this, ab.a);
  @NotNull
  private final MBRuntime.MBParams N = new MBRuntime.MBParams();
  @Nullable
  private Context b;
  @Nullable
  private a c;
  @Nullable
  private Function0<ak> d;
  @NotNull
  private final g.a e = new g.a(this, n.a);
  @NotNull
  private final g.a f = new g.a(this, l.a);
  @NotNull
  private final g.a g = new g.a(this, k.a);
  @Nullable
  private final g.a h = new g.a(this, y.a);
  @Nullable
  private final g.a i = new g.a(this, j.a);
  @NotNull
  private final g.b j = new g.b();
  @Nullable
  private IMBFontHandler k;
  @NotNull
  private final g.a l = new g.a(this, i.a);
  @NotNull
  private final g.a m = new g.a(this, p.a);
  @NotNull
  private final g.a n = new g.a(this, t.a);
  @NotNull
  private final g.a o = new g.a(this, q.a);
  @NotNull
  private final g.a p = new g.a(this, s.a);
  @NotNull
  private final g.a q = new g.a(this, z.a);
  @NotNull
  private final g.a r = new g.a(this, u.a);
  @NotNull
  private final g.a s = new g.a(this, x.a);
  @NotNull
  private final g.a t = new g.a(this, o.a);
  @NotNull
  private final g.a u = new g.a(this, w.a);
  @NotNull
  private final g.a v = new g.a(this, h.a);
  private boolean w = true;
  private boolean x = true;
  @NotNull
  private final g.a y = new g.a(this, m.a);
  @NotNull
  private final g.a z = new g.a(this, ac.a);
  
  public final void a(float paramFloat)
  {
    this.e.a(this, a[0], Float.valueOf(paramFloat));
  }
  
  public final void a(int paramInt)
  {
    this.f.a(this, a[1], Integer.valueOf(paramInt));
  }
  
  public final void a(@Nullable Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final void a(@Nullable AssetManager paramAssetManager)
  {
    this.i.a(this, a[4], paramAssetManager);
  }
  
  public final void a(@Nullable a parama)
  {
    this.c = parama;
  }
  
  public final void a(@Nullable IMBFontHandler paramIMBFontHandler)
  {
    this.k = paramIMBFontHandler;
  }
  
  public final void a(@NotNull a.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "<set-?>");
    this.l.a(this, a[5], paramb);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.C.a(this, a[20], paramString);
  }
  
  public final void a(@Nullable Function0<ak> paramFunction0)
  {
    this.d = paramFunction0;
  }
  
  public final void a(@NotNull Function1<? super g.b, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "dls");
    paramFunction1.invoke(this.j);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.o.a(this, a[8], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final Context b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.g.a(this, a[2], Integer.valueOf(paramInt));
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.D.a(this, a[21], paramString);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p.a(this, a[9], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final a c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.y.a(this, a[16], Integer.valueOf(paramInt));
  }
  
  public final void c(@Nullable String paramString)
  {
    this.K = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.s.a(this, a[12], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final Function0<ak> d()
  {
    return this.d;
  }
  
  public final void d(int paramInt)
  {
    this.G.a(this, a[24], Integer.valueOf(paramInt));
  }
  
  public final void d(@Nullable String paramString)
  {
    this.L = paramString;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.t.a(this, a[13], Boolean.valueOf(paramBoolean));
  }
  
  public final float e()
  {
    return ((Number)this.e.a(this, a[0])).floatValue();
  }
  
  public final void e(boolean paramBoolean)
  {
    this.u.a(this, a[14], Boolean.valueOf(paramBoolean));
  }
  
  public final int f()
  {
    return ((Number)this.f.a(this, a[1])).intValue();
  }
  
  public final void f(boolean paramBoolean)
  {
    this.v.a(this, a[15], Boolean.valueOf(paramBoolean));
  }
  
  public final int g()
  {
    return ((Number)this.g.a(this, a[2])).intValue();
  }
  
  public final void g(boolean paramBoolean)
  {
    this.z.a(this, a[17], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final IMBFileSystem h()
  {
    return (IMBFileSystem)this.h.a(this, a[3]);
  }
  
  public final void h(boolean paramBoolean)
  {
    this.A.a(this, a[18], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final AssetManager i()
  {
    return (AssetManager)this.i.a(this, a[4]);
  }
  
  public final void i(boolean paramBoolean)
  {
    this.B.a(this, a[19], Boolean.valueOf(paramBoolean));
  }
  
  @JvmName(name="getImageHandlerConfig")
  @NotNull
  public final g.b j()
  {
    return this.j;
  }
  
  public final void j(boolean paramBoolean)
  {
    this.E.a(this, a[22], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final BaseImageDecodeService k()
  {
    return this.j.e();
  }
  
  public final void k(boolean paramBoolean)
  {
    this.H.a(this, a[25], Boolean.valueOf(paramBoolean));
  }
  
  @Nullable
  public final IMBFontHandler l()
  {
    return this.k;
  }
  
  @NotNull
  public final a.b m()
  {
    return (a.b)this.l.a(this, a[5]);
  }
  
  public final float n()
  {
    return ((Number)this.q.a(this, a[10])).floatValue();
  }
  
  public final boolean o()
  {
    return this.w;
  }
  
  public final boolean p()
  {
    return this.x;
  }
  
  @Nullable
  public final String q()
  {
    return this.K;
  }
  
  @Nullable
  public final String r()
  {
    return this.L;
  }
  
  @NotNull
  public final MBRuntime.MBParams s()
  {
    return this.N;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.g
 * JD-Core Version:    0.7.0.1
 */
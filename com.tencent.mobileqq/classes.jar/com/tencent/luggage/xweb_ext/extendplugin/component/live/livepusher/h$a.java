package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "()V", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h$a
  implements h
{
  @NotNull
  private static final g d;
  
  static
  {
    g localg = g.a;
    Intrinsics.checkExpressionValueIsNotNull(localg, "IWeEffectManager.DUMMY");
    d = localg;
  }
  
  public void a(@Nullable g.a parama, float paramFloat)
  {
    ((a)this).e().a(parama, paramFloat);
  }
  
  public void a(@Nullable g.b paramb, @Nullable String paramString)
  {
    ((a)this).e().a(paramb, paramString);
  }
  
  public void a(@Nullable g.c paramc, @Nullable String paramString)
  {
    ((a)this).e().a(paramc, paramString);
  }
  
  public void a(@Nullable String paramString, float paramFloat)
  {
    ((a)this).e().a(paramString, paramFloat);
  }
  
  public boolean a()
  {
    return ((a)this).e().a();
  }
  
  public boolean a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "info");
    return false;
  }
  
  public boolean a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "info");
    return false;
  }
  
  public boolean a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "info");
    return false;
  }
  
  public boolean a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "info");
    return false;
  }
  
  public boolean a(@NotNull g.c paramc, @NotNull List<StickerItemInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "type");
    Intrinsics.checkParameterIsNotNull(paramList, "stickerInfo");
    return false;
  }
  
  public boolean a(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "info");
    return false;
  }
  
  public void b()
  {
    ((a)this).e().b();
  }
  
  public void c()
  {
    ((a)this).e().c();
  }
  
  public void d()
  {
    ((a)this).e().d();
  }
  
  @NotNull
  public g e()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h.a
 * JD-Core Version:    0.7.0.1
 */
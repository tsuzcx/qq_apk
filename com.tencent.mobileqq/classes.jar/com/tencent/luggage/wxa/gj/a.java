package com.tencent.luggage.wxa.gj;

import com.github.henryye.nativeiv.b;
import com.github.henryye.nativeiv.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension;", "Lcom/github/henryye/nativeiv/BitmapDecoder;", "()V", "TAG", "", "createBitmapWrapper", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "mgr", "Lcom/github/henryye/nativeiv/BitmapDecoderFactoryMgr;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public class a
  extends com.github.henryye.nativeiv.a
{
  private final String a = "MB.BitmapDecoderMagicBrushExtension";
  
  @NotNull
  protected c a(@NotNull b paramb, @NotNull com.github.henryye.nativeiv.api.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "mgr");
    Intrinsics.checkParameterIsNotNull(parama, "decodeInfo");
    return (c)new a.a(this, paramb, parama, paramb, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gj.a
 * JD-Core Version:    0.7.0.1
 */
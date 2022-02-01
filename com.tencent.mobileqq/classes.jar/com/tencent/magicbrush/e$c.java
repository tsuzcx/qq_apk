package com.tencent.magicbrush;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.github.henryye.nativeiv.api.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
final class e$c
  implements IImageDecodeService.b
{
  public void a(@NotNull String paramString, @NotNull IImageDecodeService.b.a parama, @NotNull a parama1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(parama, "event");
    Intrinsics.checkParameterIsNotNull(parama1, "decodeInfo");
  }
  
  public void a(@NotNull String paramString, @Nullable Object paramObject, @NotNull IImageDecodeService.c paramc, @NotNull ImageDecodeConfig paramImageDecodeConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramc, "recycleHandler");
    Intrinsics.checkParameterIsNotNull(paramImageDecodeConfig, "config");
    this.a.a(paramString, paramObject, paramc, paramImageDecodeConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.e.c
 * JD-Core Version:    0.7.0.1
 */
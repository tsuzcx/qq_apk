package com.tencent.magicbrush;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.luggage.wxa.c.c.b;
import com.tencent.luggage.wxa.d.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class g$b
{
  private boolean a = true;
  @NotNull
  private List<d> b = (List)new ArrayList();
  @Nullable
  private c.b c;
  @Nullable
  private IImageDecodeService.a d;
  @Nullable
  private BaseImageDecodeService e;
  
  public final void a(@Nullable BaseImageDecodeService paramBaseImageDecodeService)
  {
    this.e = paramBaseImageDecodeService;
  }
  
  public final void a(@Nullable IImageDecodeService.a parama)
  {
    this.d = parama;
  }
  
  public final void a(@Nullable c.b paramb)
  {
    this.c = paramb;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<d> b()
  {
    return this.b;
  }
  
  @Nullable
  public final c.b c()
  {
    return this.c;
  }
  
  @Nullable
  public final IImageDecodeService.a d()
  {
    return this.d;
  }
  
  @Nullable
  public final BaseImageDecodeService e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.g.b
 * JD-Core Version:    0.7.0.1
 */
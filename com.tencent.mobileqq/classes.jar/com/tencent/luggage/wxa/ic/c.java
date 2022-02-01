package com.tencent.luggage.wxa.ic;

import com.tencent.luggage.wxa.ib.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/GPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "TAG", "", "setRender", "", "renderer", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class c
  extends a
{
  private final String b = "MicroMsg.GPUPreviewController";
  
  public c(@NotNull b paramb)
  {
    super(paramb);
  }
  
  public void b(@NotNull com.tencent.luggage.wxa.sm.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "renderer");
    super.b(paramf);
    paramf.a((Function1)new c.a(this, paramf));
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreviewRenderer: ");
    localStringBuilder.append(paramf.hashCode());
    com.tencent.luggage.wxa.f.f.b(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ic.c
 * JD-Core Version:    0.7.0.1
 */
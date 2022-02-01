package com.tencent.luggage.wxa.ic;

import com.tencent.luggage.wxa.sm.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "frameDataCallback", "com/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController$frameDataCallback$1", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/CPUPreviewController$frameDataCallback$1;", "drawFrame", "", "data", "", "getFrameDataCallback", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraFrameDataCallback;", "Companion", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class b
  extends a
{
  public static final b.a b = new b.a(null);
  private final b.b c = new b.b(this);
  
  public b(@NotNull com.tencent.luggage.wxa.ib.a parama)
  {
    super((com.tencent.luggage.wxa.ib.b)parama);
  }
  
  public void a(@Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      com.tencent.luggage.wxa.sm.f localf = a();
      if (localf != null) {
        com.tencent.luggage.wxa.sm.f.a(localf, paramArrayOfByte, false, 2, null);
      }
      g().requestRender();
      return;
    }
    com.tencent.luggage.wxa.f.f.b("WMPF.CPUPreviewController", "passing draw");
  }
  
  @NotNull
  public c b()
  {
    return (c)this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ic.b
 * JD-Core Version:    0.7.0.1
 */
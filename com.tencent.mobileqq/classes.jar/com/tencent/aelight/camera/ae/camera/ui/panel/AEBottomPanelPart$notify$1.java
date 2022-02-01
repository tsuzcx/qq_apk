package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AEBottomPanelPart$notify$1
  implements Runnable
{
  AEBottomPanelPart$notify$1(AEBottomPanelPart paramAEBottomPanelPart, int paramInt, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    int i = this.a;
    Object localObject2;
    Object localObject1;
    if (i != 111)
    {
      if (i != 1024)
      {
        Object localObject3 = null;
        localObject2 = null;
        switch (i)
        {
        default: 
          return;
        case 116: 
          AEQLog.b("AEBottomPanelPart", "receive template info list update event");
          localObject1 = AEBottomPanelPart.c(this.this$0);
          if (localObject1 != null)
          {
            localObject2 = AEBottomPanelPart.a(this.this$0).c(true);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "templateManager.getMaterialListWithRecent(true)");
            ((AENewMaterialPanel)localObject1).a((List)localObject2);
          }
          AEBottomPanelPart.a(this.this$0, true);
          return;
        case 115: 
          if (this.b.length == 0) {
            i = 1;
          } else {
            i = 0;
          }
          localObject1 = localObject2;
          if ((i ^ 0x1) != 0)
          {
            localObject3 = this.b[0];
            localObject1 = localObject3;
            if (!(localObject3 instanceof VideoMaterial)) {
              localObject1 = null;
            }
            localObject3 = (VideoMaterial)localObject1;
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((VideoMaterial)localObject3).getId();
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receive hide watermark edit picture event, id = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          AEQLog.b("AEBottomPanelPart", ((StringBuilder)localObject2).toString());
          if (localObject1 == null) {
            break;
          }
          localObject2 = AEBottomPanelPart.c(this.this$0);
          if (localObject2 == null) {
            break;
          }
          ((AENewMaterialPanel)localObject2).a((String)localObject1, false);
          return;
        case 114: 
          if (this.b.length == 0) {
            i = 1;
          } else {
            i = 0;
          }
          localObject1 = localObject3;
          if ((i ^ 0x1) != 0)
          {
            localObject2 = this.b[0];
            localObject1 = localObject2;
            if (!(localObject2 instanceof VideoMaterial)) {
              localObject1 = null;
            }
            localObject2 = (VideoMaterial)localObject1;
            localObject1 = localObject3;
            if (localObject2 != null) {
              localObject1 = ((VideoMaterial)localObject2).getId();
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("receive show watermark edit picture event, id = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          AEQLog.b("AEBottomPanelPart", ((StringBuilder)localObject2).toString());
          if (localObject1 == null) {
            break;
          }
          localObject2 = AEBottomPanelPart.c(this.this$0);
          if (localObject2 == null) {
            break;
          }
          ((AENewMaterialPanel)localObject2).a((String)localObject1, true);
          return;
        case 113: 
          AEQLog.b("AEBottomPanelPart", "receive select template update event");
          localObject1 = AEBottomPanelPart.c(this.this$0);
          if (localObject1 == null) {
            break;
          }
          ((AENewMaterialPanel)localObject1).a();
          return;
        }
      }
      else
      {
        AEQLog.b("AEBottomPanelPart", "receive select select watermark use event");
        localObject1 = AEBottomPanelPart.c(this.this$0);
        if (localObject1 != null) {
          ((AENewMaterialPanel)localObject1).a();
        }
      }
    }
    else
    {
      AEQLog.b("AEBottomPanelPart", "receive recent template list update");
      localObject2 = AEBottomPanelPart.a(this.this$0).c(true);
      if (((List)localObject2).size() >= 1)
      {
        localObject1 = AEBottomPanelPart.c(this.this$0);
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject2).get(0);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "list[0]");
          ((AENewMaterialPanel)localObject1).a((AEMaterialCategory)localObject2, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart.notify.1
 * JD-Core Version:    0.7.0.1
 */
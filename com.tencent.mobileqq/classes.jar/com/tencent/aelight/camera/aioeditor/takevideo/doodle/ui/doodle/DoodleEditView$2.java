package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import java.util.List;
import java.util.Map;

class DoodleEditView$2
  implements TextFaceEditLayer.LayerListener
{
  DoodleEditView$2(DoodleEditView paramDoodleEditView) {}
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
      if (localFaceItem.s)
      {
        if ((this.a.h != null) && (this.a.h.c())) {
          paramZoomItem = this.a.l.getDynamicFaceLayer();
        } else {
          paramZoomItem = this.a.l.getFaceLayer();
        }
        paramZoomItem.r.remove(localFaceItem);
      }
      else
      {
        if ((localFaceItem.y == 1) && ((this.a.h == null) || (this.a.h.c()))) {
          paramZoomItem = this.a.l.getDynamicFaceLayer();
        } else {
          paramZoomItem = this.a.l.getFaceLayer();
        }
        paramZoomItem = (List)paramZoomItem.q.get(localFaceItem.n);
        if (paramZoomItem != null) {
          paramZoomItem.remove(localFaceItem.o);
        }
      }
      this.a.a.i();
    }
    else if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      this.a.a.i();
    }
    else
    {
      this.a.a.i();
    }
    this.a.l.u();
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    if (paramZoomItem == null) {
      return;
    }
    if (this.a.l.z()) {
      return;
    }
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      a(paramZoomItem, paramInt1, paramInt2, 0.0F, 0.0F);
      return;
    }
    if ((((paramZoomItem instanceof FaceLayer.FaceItem)) || ((paramZoomItem instanceof FaceLayer.FaceAndTextItem))) && (DoodleEditView.a(this.a) != null)) {
      DoodleEditView.a(this.a).a(paramZoomItem);
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      paramZoomItem = ((TextLayer.TextItem)paramZoomItem).c;
      if (paramZoomItem != null)
      {
        int i = paramInt2;
        if (!paramZoomItem.a())
        {
          i = paramInt2;
          if (paramInt2 == 0) {
            i = 3;
          }
        }
        if (i != 0)
        {
          int j = 0;
          paramInt2 = 0;
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            if (paramInt1 == -1) {
              paramInt1 = paramInt2;
            }
            paramZoomItem.a(paramInt1, true);
            this.a.l.a(paramZoomItem, paramInt1, 2);
            return;
          }
          paramZoomItem.a(paramInt1, true);
          if (paramInt1 == -1) {
            paramInt1 = j;
          }
          this.a.l.a(paramZoomItem, paramInt1, 1);
          return;
        }
        paramZoomItem.o();
        paramZoomItem.a(-1, this.a.l.w, false, 3000, 500, null);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.l != null) {
      this.a.l.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {
      return;
    }
    if (this.a.l.z()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.2
 * JD-Core Version:    0.7.0.1
 */
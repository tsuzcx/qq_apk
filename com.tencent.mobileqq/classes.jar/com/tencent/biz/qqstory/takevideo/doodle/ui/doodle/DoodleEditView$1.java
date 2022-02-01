package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;

class DoodleEditView$1
  implements TextFaceEditLayer.LayerListener
{
  DoodleEditView$1(DoodleEditView paramDoodleEditView) {}
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      paramZoomItem = (TextLayer)DoodleEditView.a(this.a).a("TextLayer");
      if (paramZoomItem != null) {
        paramZoomItem.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      SLog.b("DoodleEditView", "click the TextItem:" + paramZoomItem);
      paramZoomItem = (TextLayer)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramZoomItem != null) && (paramZoomItem.a != null))
      {
        paramZoomItem.d();
        paramZoomItem.a.a();
      }
    }
    FaceLayer localFaceLayer;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramZoomItem instanceof FaceLayer.FaceItem));
        SLog.b("DoodleEditView", "click the FaceAndTextItem:" + paramZoomItem);
        paramZoomItem.d = false;
        localFaceLayer = (FaceLayer)DoodleEditView.a(this.a).a("FaceLayer");
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
        if (localFaceLayer != null) {
          localFaceLayer.jdField_a_of_type_JavaUtilList.add(localFaceItem);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramZoomItem instanceof FaceLayer.FaceAndTextItem)) {
        break;
      }
    } while ((localFaceLayer == null) || (localFaceLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener == null));
    localFaceLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a((FaceLayer.FaceAndTextItem)paramZoomItem);
    return;
    DoodleEditView.a(this.a).a(paramZoomItem);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.1
 * JD-Core Version:    0.7.0.1
 */
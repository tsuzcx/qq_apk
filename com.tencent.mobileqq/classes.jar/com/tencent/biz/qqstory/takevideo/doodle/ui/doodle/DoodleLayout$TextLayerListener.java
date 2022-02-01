package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;

class DoodleLayout$TextLayerListener
  implements TextLayer.LayerListener
{
  private DoodleLayout$TextLayerListener(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.d(3);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.a.a().a());
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3) {}
  
  public boolean a(TextLayer.TextItem paramTextItem)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramTextItem != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
        ((GestureHelper.ZoomItem)localObject).d = false;
        if (!(localObject instanceof FaceLayer.FaceItem)) {
          break label124;
        }
        FaceLayer localFaceLayer = this.a.a();
        if (localFaceLayer != null) {
          localFaceLayer.a.add((FaceLayer.FaceItem)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramTextItem);
        paramTextItem.d = true;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        label124:
        if ((localObject instanceof TextLayer.TextItem))
        {
          localObject = this.a.a();
          if (localObject != null) {
            ((TextLayer)localObject).d();
          }
        }
      }
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.TextLayerListener
 * JD-Core Version:    0.7.0.1
 */
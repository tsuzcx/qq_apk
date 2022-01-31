import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.ArrayList;
import java.util.List;

public class aohy
  implements FaceLayer.LayerEventListener
{
  public aohy(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(1, paramInt);
    }
  }
  
  public boolean a(FaceLayer.FaceItem paramFaceItem)
  {
    if (DoodleLayout.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onEditFaceItem mIsRecording");
      }
    }
    while (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null) {
      return false;
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
    GestureHelper.ZoomItem localZoomItem;
    Object localObject;
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b())
    {
      localZoomItem = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
      localZoomItem.j = false;
      if (!(localZoomItem instanceof FaceLayer.FaceItem)) {
        break label327;
      }
      localObject = this.a.a();
      if ((((FaceLayer.FaceItem)localZoomItem).h != 1) || ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {
        break label368;
      }
      localObject = this.a.a();
      ((FaceLayer.FaceItem)localZoomItem).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    label327:
    label368:
    for (;;)
    {
      if (localObject != null) {
        ((FaceLayer)localObject).a.add((FaceLayer.FaceItem)localZoomItem);
      }
      if (((paramFaceItem.h == 0) || (paramFaceItem.h == 1)) && (paramFaceItem.c))
      {
        this.a.q();
        DoodleLayout.a(this.a, paramFaceItem);
      }
      if (paramFaceItem.h == 3) {
        this.a.post(new aohz(this));
      }
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(paramFaceItem);
      paramFaceItem.j = true;
      localObject = paramFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper;
      if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a()) {}
      for (boolean bool = true;; bool = false)
      {
        ((SegmentKeeper)localObject).a(bool);
        if ((paramFaceItem.h == 1) || (paramFaceItem.h == 3)) {
          paramFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
        }
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        return true;
        if (!(localZoomItem instanceof TextLayer.TextItem)) {
          break;
        }
        localObject = this.a.a();
        if (localObject == null) {
          break;
        }
        ((TextLayer)localObject).a.add((TextLayer.TextItem)localZoomItem);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohy
 * JD-Core Version:    0.7.0.1
 */
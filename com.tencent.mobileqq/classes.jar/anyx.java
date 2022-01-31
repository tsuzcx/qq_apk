import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.Map;

public class anyx
  implements Runnable
{
  public anyx(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    GestureHelper.ZoomItem localZoomItem;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.jdField_a_of_type_JavaUtilMap != null))
    {
      localZoomItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localZoomItem instanceof FaceLayer.FaceItem)) {
        break label97;
      }
      ((FaceLayer.FaceItem)localZoomItem).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_JavaUtilMap;
    }
    for (;;)
    {
      localZoomItem.i = 3;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.o();
      }
      return;
      label97:
      if ((localZoomItem instanceof TextLayer.TextItem)) {
        ((TextLayer.TextItem)localZoomItem).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_JavaUtilMap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyx
 * JD-Core Version:    0.7.0.1
 */
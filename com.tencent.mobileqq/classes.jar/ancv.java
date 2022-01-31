import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditMultiSegmentExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.DoodleEditViewListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

public class ancv
  implements DoodleEditView.DoodleEditViewListener
{
  public ancv(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b == 27) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b == 36)
    {
      EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
      if (localEditMultiSegmentExport != null) {
        localEditMultiSegmentExport.c();
      }
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if ((EditVideoDoodle.a(this.a) != 0) && (EditVideoPartManager.a(EditVideoDoodle.b(this.a), 268435456)))
    {
      VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111);
      if (localVideoSegmentPickerProviderView != null)
      {
        EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
        if (localEditMultiSegmentExport != null)
        {
          localVideoSegmentPickerProviderView.setPlayMode(localEditMultiSegmentExport.a());
          localEditMultiSegmentExport.d();
          localEditMultiSegmentExport.ay_();
        }
      }
      this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111, new Object[] { paramZoomItem });
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b == 0) {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(36);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(103, new Object[] { paramZoomItem });
    } while (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b != 0);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(27);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ancv
 * JD-Core Version:    0.7.0.1
 */
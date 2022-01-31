import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView.VideoSegmentPickerListener;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditMultiSegmentExport;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

public class ansz
  implements VideoSegmentPickerProviderView.VideoSegmentPickerListener
{
  public ansz(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.a.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111);
    Object localObject;
    if (localVideoSegmentPickerProviderView != null)
    {
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource))
      {
        localObject = (EditTakeVideoSource)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a;
        localVideoSegmentPickerProviderView.setVideo(((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString, 0L, ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, ((EditTakeVideoSource)localObject).a(), ((EditTakeVideoSource)localObject).b(), ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, true);
      }
    }
    else {
      return;
    }
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a;
      if (VideoUtils.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {}
      for (int i = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation + 90;; i = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation)
      {
        localVideoSegmentPickerProviderView.setVideo(((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString, ((EditLocalVideoSource)localObject).jdField_a_of_type_Int, ((EditLocalVideoSource)localObject).b, ((EditLocalVideoSource)localObject).a(), ((EditLocalVideoSource)localObject).b(), i, false);
        return;
      }
    }
    throw new IllegalArgumentException("SegmentEdit init error");
  }
  
  public void a(long paramLong)
  {
    EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
    if (localEditMultiSegmentExport != null) {
      localEditMultiSegmentExport.a(paramLong, true);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
    if (localEditMultiSegmentExport != null) {
      localEditMultiSegmentExport.a(0L, false);
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.d();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
  
  public void a(List paramList)
  {
    EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
    if (localEditMultiSegmentExport != null) {
      localEditMultiSegmentExport.a(paramList);
    }
  }
  
  public void b(long paramLong)
  {
    EditMultiSegmentExport localEditMultiSegmentExport = (EditMultiSegmentExport)this.a.a(EditMultiSegmentExport.class);
    if (localEditMultiSegmentExport != null) {
      localEditMultiSegmentExport.a(paramLong, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansz
 * JD-Core Version:    0.7.0.1
 */
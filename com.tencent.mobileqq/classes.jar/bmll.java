import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.List;

class bmll
  implements bmby
{
  bmll(bmlk parambmlk) {}
  
  public void a()
  {
    VideoCoverPickerProviderView localVideoCoverPickerProviderView = (VideoCoverPickerProviderView)this.a.a.jdField_a_of_type_Bmjt.a.a(113);
    boolean bool;
    Object localObject;
    if (localVideoCoverPickerProviderView != null)
    {
      bool = this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_is_need_gaussion_blur", false);
      if ((this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
      {
        localObject = (EditTakeVideoSource)this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
        localVideoCoverPickerProviderView.setVideo(((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString, 0L, ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, ((EditTakeVideoSource)localObject).a(), ((EditTakeVideoSource)localObject).b(), ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, true, bool);
      }
    }
    else
    {
      return;
    }
    if ((this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.a.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      localVideoCoverPickerProviderView.setVideo(((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString, ((EditLocalVideoSource)localObject).jdField_a_of_type_Int, ((EditLocalVideoSource)localObject).b, ((EditLocalVideoSource)localObject).a(), ((EditLocalVideoSource)localObject).b(), ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, true, bool);
      return;
    }
    throw new IllegalArgumentException("SegmentEdit init error");
  }
  
  public void a(long paramLong)
  {
    bmlk.a(this.a, true);
    bmjf localbmjf = (bmjf)this.a.a(bmjf.class);
    if (localbmjf != null) {
      localbmjf.a(paramLong, true, false);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.a.a(paramLong, paramBoolean);
  }
  
  public void a(List<Long> paramList)
  {
    bmjf localbmjf = (bmjf)this.a.a(bmjf.class);
    if (localbmjf != null) {
      localbmjf.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmll
 * JD-Core Version:    0.7.0.1
 */
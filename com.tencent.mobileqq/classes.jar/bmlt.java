import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

class bmlt
  implements bmcb
{
  bmlt(bmlp parambmlp, int paramInt) {}
  
  public void a()
  {
    VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.jdField_a_of_type_Bmlp.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111);
    boolean bool;
    Object localObject;
    if (localVideoSegmentPickerProviderView != null)
    {
      bool = this.jdField_a_of_type_Bmlp.jdField_a_of_type_Bmnj.a.a("extra_is_need_gaussion_blur", false);
      if ((this.jdField_a_of_type_Bmlp.jdField_a_of_type_Bmnj.a.a instanceof EditTakeVideoSource))
      {
        localObject = (EditTakeVideoSource)this.jdField_a_of_type_Bmlp.jdField_a_of_type_Bmnj.a.a;
        localVideoSegmentPickerProviderView.setVideo(((EditTakeVideoSource)localObject).jdField_a_of_type_JavaLangString, 0L, ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, ((EditTakeVideoSource)localObject).a(), ((EditTakeVideoSource)localObject).b(), ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, true, bool);
      }
    }
    else
    {
      return;
    }
    if ((this.jdField_a_of_type_Bmlp.jdField_a_of_type_Bmnj.a.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.jdField_a_of_type_Bmlp.jdField_a_of_type_Bmnj.a.a;
      localVideoSegmentPickerProviderView.setVideo(((EditLocalVideoSource)localObject).jdField_a_of_type_JavaLangString, ((EditLocalVideoSource)localObject).jdField_a_of_type_Int, ((EditLocalVideoSource)localObject).b, ((EditLocalVideoSource)localObject).a(), ((EditLocalVideoSource)localObject).b(), ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, false, bool);
      return;
    }
    throw new IllegalArgumentException("SegmentEdit init error");
  }
  
  public void a(long paramLong)
  {
    bmjf localbmjf = (bmjf)this.jdField_a_of_type_Bmlp.a(bmjf.class);
    if (localbmjf != null) {
      localbmjf.a(this.jdField_a_of_type_Int + paramLong, true);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    bmjf localbmjf = (bmjf)this.jdField_a_of_type_Bmlp.a(bmjf.class);
    if (localbmjf != null) {
      localbmjf.a(this.jdField_a_of_type_Int, false);
    }
    this.jdField_a_of_type_Bmlp.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.d();
    this.jdField_a_of_type_Bmlp.jdField_a_of_type_Bmnj.a(0);
  }
  
  public void a(List<Long> paramList)
  {
    bmjf localbmjf = (bmjf)this.jdField_a_of_type_Bmlp.a(bmjf.class);
    if (localbmjf != null) {
      localbmjf.a(paramList);
    }
  }
  
  public void b(long paramLong)
  {
    bmjf localbmjf = (bmjf)this.jdField_a_of_type_Bmlp.a(bmjf.class);
    if (localbmjf != null) {
      localbmjf.a(this.jdField_a_of_type_Int + paramLong, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlt
 * JD-Core Version:    0.7.0.1
 */
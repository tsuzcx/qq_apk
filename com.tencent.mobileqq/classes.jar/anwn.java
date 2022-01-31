import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

class anwn
  implements Runnable
{
  anwn(anwm paramanwm) {}
  
  public void run()
  {
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Anwl.a, null);
    if (!HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Anwl.a))
    {
      SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "Convert video finished but player not displayed.");
      return;
    }
    if ((this.a.jdField_a_of_type_Anwl.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a != null) && (this.a.jdField_a_of_type_Anwl.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.b() == 3) && (this.a.jdField_a_of_type_Anwl.c == this.a.jdField_a_of_type_Anwl.a.jdField_a_of_type_Int)) {
      HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Anwl.a, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer$Mp4VideoFragmentInfo);
    }
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Anwl.a);
    HWEditLocalVideoPlayer.a(this.a.jdField_a_of_type_Anwl.a, this.a.jdField_a_of_type_Anwl.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwn
 * JD-Core Version:    0.7.0.1
 */
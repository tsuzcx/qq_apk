import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class anzx
  implements Runnable
{
  public anzx(DoodleView paramDoodleView, long paramLong) {}
  
  public void run()
  {
    if (DoodleView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.requestLayout();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzx
 * JD-Core Version:    0.7.0.1
 */
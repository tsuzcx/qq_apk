import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator;

public class anzu
  implements Runnable
{
  public anzu(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    PersonalityOperator localPersonalityOperator = (PersonalityOperator)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(102);
    if (localPersonalityOperator != null)
    {
      localPersonalityOperator.a();
      localPersonalityOperator.a(this.a.jdField_a_of_type_Int, this.a.b);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.h();
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzu
 * JD-Core Version:    0.7.0.1
 */
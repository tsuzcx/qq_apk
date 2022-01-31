import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator;

public class aojb
  implements Runnable
{
  public aojb(PersonalityOperator paramPersonalityOperator, QQVideoMaterial paramQQVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.getId());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.b, 1.0D);
    long l2 = System.currentTimeMillis();
    SLog.b("PersonalityOperator", "setVideoFilter " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojb
 * JD-Core Version:    0.7.0.1
 */
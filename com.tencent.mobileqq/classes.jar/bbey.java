import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class bbey
  implements beuq
{
  bbey(bbew parambbew, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + parambevm.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_Bbew.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      nof.a(new File(bbew.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5), bbew.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5));
      if (this.jdField_a_of_type_Bbew.a != null) {
        this.jdField_a_of_type_Bbew.a.a();
      }
      return;
    }
    catch (IOException parambevm)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          parambevm.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbey
 * JD-Core Version:    0.7.0.1
 */
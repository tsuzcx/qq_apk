import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class avrx
  implements aysc
{
  avrx(avrv paramavrv, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramaysz.c);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_Avrv.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      nav.a(new File(avrv.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5), avrv.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5));
      if (this.jdField_a_of_type_Avrv.a != null) {
        this.jdField_a_of_type_Avrv.a.a();
      }
      return;
    }
    catch (IOException paramaysz)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramaysz.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avrx
 * JD-Core Version:    0.7.0.1
 */
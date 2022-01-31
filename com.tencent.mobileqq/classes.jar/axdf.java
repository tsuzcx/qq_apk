import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.15;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class axdf
  implements aysc
{
  public axdf(PtvTemplateManager.15 param15) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl + " resultcode: " + paramaysz.c);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = this.a.this$0.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, false);
    if (this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable) {}
    try
    {
      nav.a(new File(PtvTemplateManager.b, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName), PtvTemplateManager.c);
      if (paramaysz.jdField_a_of_type_Int == 0)
      {
        ayxs localayxs = (ayxs)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
        if (localayxs.a()) {
          localayxs.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl, paramaysz.jdField_a_of_type_Long);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdf
 * JD-Core Version:    0.7.0.1
 */
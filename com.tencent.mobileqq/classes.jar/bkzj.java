import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.13;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import java.io.File;
import java.io.IOException;

public class bkzj
  implements aysc
{
  public bkzj(PtvTemplateManager.13 param13) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl + " resultcode: " + paramaysz.c);
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = this.a.this$0.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, false);
    if (this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable) {}
    try
    {
      nav.a(new File(PtvTemplateManager.b, this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName), PtvTemplateManager.c);
      if (paramaysz.jdField_a_of_type_Int == 0)
      {
        ayxs localayxs = (ayxs)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
        if (localayxs.a()) {
          localayxs.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl, paramaysz.jdField_a_of_type_Long);
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
 * Qualified Name:     bkzj
 * JD-Core Version:    0.7.0.1
 */
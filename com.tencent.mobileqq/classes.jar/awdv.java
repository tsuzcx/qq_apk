import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.15;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class awdv
  implements axrt
{
  public awdv(PtvTemplateManager.15 param15) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl + " resultcode: " + paramaxsq.c);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = this.a.this$0.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, false);
    if (this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable) {}
    try
    {
      mpx.a(new File(PtvTemplateManager.b, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName), PtvTemplateManager.c);
      if (paramaxsq.jdField_a_of_type_Int == 0)
      {
        axxj localaxxj = (axxj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
        if (localaxxj.a()) {
          localaxxj.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl, paramaxsq.jdField_a_of_type_Long);
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
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awdv
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.13;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import java.io.File;
import java.io.IOException;

public class brhh
  implements beuq
{
  public brhh(PtvTemplateManager.13 param13) {}
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl + " resultcode: " + parambevm.c);
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = this.a.this$0.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, false);
    if (this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable) {}
    try
    {
      nof.a(new File(PtvTemplateManager.b, this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName), PtvTemplateManager.c);
      if (parambevm.jdField_a_of_type_Int == 0)
      {
        bezv localbezv = (bezv)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
        if (localbezv.a()) {
          localbezv.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl, parambevm.jdField_a_of_type_Long);
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
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brhh
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfo;
import java.io.File;

public class aoom
  implements Runnable
{
  public aoom(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, true)) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = true;
    }
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aoon(this);
      localHttpNetReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl;
      localHttpNetReq.jdField_a_of_type_Int = 0;
      localHttpNetReq.jdField_c_of_type_JavaLangString = new File(PtvTemplateManager.b, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName).getPath();
      localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).a(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoom
 * JD-Core Version:    0.7.0.1
 */
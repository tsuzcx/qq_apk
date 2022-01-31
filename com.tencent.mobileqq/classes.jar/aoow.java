import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import mqq.app.AppRuntime;

public class aoow
  implements Runnable
{
  public aoow(QIMPtvTemplateManager paramQIMPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo)) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = true;
    }
    do
    {
      HttpNetReq localHttpNetReq;
      AppRuntime localAppRuntime;
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = false;
        localHttpNetReq = new HttpNetReq();
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new aoox(this);
        localHttpNetReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl;
        localHttpNetReq.jdField_a_of_type_Int = 0;
        localHttpNetReq.jdField_c_of_type_JavaLangString = new File(QIMPtvTemplateManager.a, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name).getPath();
        localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
        localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      } while (!QQAppInterface.class.isInstance(localAppRuntime));
      ((QQAppInterface)localAppRuntime).getNetEngine(0).a(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("QIMPtvTemplateManager", 2, "startDownloadTemplate, url: " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoow
 * JD-Core Version:    0.7.0.1
 */
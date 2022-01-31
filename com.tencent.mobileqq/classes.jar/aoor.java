import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class aoor
  implements Runnable
{
  public aoor(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface, File paramFile) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    List localList = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaIoFile, null);
    if (localList != null) {}
    synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a.clear();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a.addAll(localList);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.d = true;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) && (PtvFilterSoLoad.b())) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager.a);
      }
      PtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager);
      if (QLog.isDevelopLevel())
      {
        QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoor
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMRedDotConfig;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class anyt
  implements Runnable
{
  public anyt(QIMPtvTemplateManager paramQIMPtvTemplateManager, File paramFile) {}
  
  public void run()
  {
    Object localObject2 = QIMRedDotConfig.getRedDotConfigFromFile(QIMPtvTemplateManager.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    if (localObject2 != null) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "initLocalTemplateConfigInfo|updateByServer =" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_Boolean);
      }
    }
    synchronized (QIMPtvTemplateManager.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_DovComQqImCaptureDataQIMRedDotConfig = ((QIMRedDotConfig)localObject2);
      }
      localObject2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_JavaIoFile);
      if (QLog.isColorLevel()) {
        QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, isUpdateedByServer[%s], templateInfos[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_Boolean), localObject2 }));
      }
      if (localObject2 == null) {}
    }
    synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_Boolean) {}
      do
      {
        return;
        localCollection = finally;
        throw localCollection;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilList.addAll(localCollection);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_b_of_type_Boolean = true;
        if (PtvFilterSoLoad.b()) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.b(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a() != null) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QIMPtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyt
 * JD-Core Version:    0.7.0.1
 */
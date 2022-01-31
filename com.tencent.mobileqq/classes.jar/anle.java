import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class anle
  implements Runnable
{
  public anle(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "start download template runnable");
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(), this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, QIMPtvTemplateAdapter.a(this.a));
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anle
 * JD-Core Version:    0.7.0.1
 */
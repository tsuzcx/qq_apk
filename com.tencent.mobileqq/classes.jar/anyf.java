import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.io.File;

public class anyf
  implements Runnable
{
  public anyf(PtvTemplateManager paramPtvTemplateManager, String paramString) {}
  
  public void run()
  {
    FileUtils.a(PtvTemplateManager.b.getPath() + File.separator, "dov_doodle_template_new.cfg", this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyf
 * JD-Core Version:    0.7.0.1
 */
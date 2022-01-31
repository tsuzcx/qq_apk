import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;

public final class aoou
  implements Runnable
{
  public aoou(String paramString1, String paramString2) {}
  
  public void run()
  {
    FileUtils.a(QIMPtvTemplateManager.a.getPath() + File.separator, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoou
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.5;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.io.IOException;

public class bnku
  implements bapx
{
  public bnku(PtvTemplateManager.5 param5) {}
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + parambaqw.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      ndr.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.a.a.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (IOException parambaqw)
    {
      while (!QLog.isColorLevel()) {}
      parambaqw.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnku
 * JD-Core Version:    0.7.0.1
 */
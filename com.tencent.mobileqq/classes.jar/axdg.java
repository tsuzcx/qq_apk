import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.5;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class axdg
  implements aysc
{
  public axdg(PtvTemplateManager.5 param5) {}
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.a.a.resurl + " resultcode: " + paramaysz.c);
    }
    this.a.a.usable = this.a.this$0.a(this.a.a);
    if (this.a.a.usable) {}
    try
    {
      nav.a(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.a.a.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (IOException paramaysz)
    {
      while (!QLog.isColorLevel()) {}
      paramaysz.printStackTrace();
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdg
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class axep
{
  public int a;
  ayrx jdField_a_of_type_Ayrx;
  public String a;
  public ArrayList<axeq> a;
  public int b = 0;
  
  public axep(ShortVideoResourceManager paramShortVideoResourceManager, ayrx paramayrx)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Ayrx = paramayrx;
    this.b = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager).getNetEngine(0).a(this.jdField_a_of_type_Ayrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axep
 * JD-Core Version:    0.7.0.1
 */
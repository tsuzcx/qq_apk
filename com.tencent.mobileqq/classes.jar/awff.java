import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class awff
{
  public int a;
  axro jdField_a_of_type_Axro;
  public String a;
  public ArrayList<awfg> a;
  public int b = 0;
  
  public awff(ShortVideoResourceManager paramShortVideoResourceManager, axro paramaxro)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Axro = paramaxro;
    this.b = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager).getNetEngine(0).a(this.jdField_a_of_type_Axro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awff
 * JD-Core Version:    0.7.0.1
 */
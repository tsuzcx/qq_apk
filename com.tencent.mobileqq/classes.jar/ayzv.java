import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ayzv
{
  public int a;
  baps jdField_a_of_type_Baps;
  public String a;
  public ArrayList<ayzw> a;
  public int b = 0;
  
  public ayzv(ShortVideoResourceManager paramShortVideoResourceManager, baps parambaps)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Baps = parambaps;
    this.b = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager).getNetEngine(0).a(this.jdField_a_of_type_Baps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzv
 * JD-Core Version:    0.7.0.1
 */
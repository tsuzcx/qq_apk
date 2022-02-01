import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bcxv
{
  public int a;
  beum jdField_a_of_type_Beum;
  public String a;
  public ArrayList<bcxw> a;
  public int b = 0;
  
  public bcxv(ShortVideoResourceManager paramShortVideoResourceManager, beum parambeum)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Beum = parambeum;
    this.b = 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager).getNetEngine(0).a(this.jdField_a_of_type_Beum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxv
 * JD-Core Version:    0.7.0.1
 */
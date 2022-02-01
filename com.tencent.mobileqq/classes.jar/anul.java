import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class anul
  extends anvw
{
  private String a;
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    QQAppInterface.getBatteryStats().c();
    anue.a().a(paramString);
    aqrl.a(true);
    this.jdField_a_of_type_JavaLangString = paramString;
    CoreService.startCoreService(anvu.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.c();
  }
  
  protected void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, this.jdField_a_of_type_JavaLangString);
    aqrl.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anul
 * JD-Core Version:    0.7.0.1
 */
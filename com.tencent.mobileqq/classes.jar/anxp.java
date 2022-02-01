import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class anxp
  extends anzi
{
  private String a;
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    QQAppInterface.a().c();
    anxi.a().a(paramString);
    aquy.a(true);
    this.jdField_a_of_type_JavaLangString = paramString;
    CoreService.startCoreService(anzg.a().a);
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.c();
  }
  
  protected void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, this.jdField_a_of_type_JavaLangString);
    aquy.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anxp
 * JD-Core Version:    0.7.0.1
 */
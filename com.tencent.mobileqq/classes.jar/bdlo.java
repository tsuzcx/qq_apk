import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.statistics.ReportControllerImpl;

public class bdlo
  extends apap
{
  public bdlo(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected void a()
  {
    bdll localbdll = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localbdll != null) && ((localbdll instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbdll).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
  
  protected void b()
  {
    bdll localbdll = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localbdll != null) && ((localbdll instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbdll).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlo
 * JD-Core Version:    0.7.0.1
 */
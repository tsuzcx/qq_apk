import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.statistics.ReportControllerImpl;

public class bdld
  extends aoxs
{
  public bdld(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected void a()
  {
    bdla localbdla = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReportController();
    if ((localbdla != null) && ((localbdla instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbdla).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
  
  protected void b()
  {
    bdla localbdla = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReportController();
    if ((localbdla != null) && ((localbdla instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbdla).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdld
 * JD-Core Version:    0.7.0.1
 */
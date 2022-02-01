import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.statistics.ReportControllerImpl;

public class bcei
  extends anus
{
  public bcei(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected void a()
  {
    bcef localbcef = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReportController();
    if ((localbcef != null) && ((localbcef instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbcef).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
  
  protected void b()
  {
    bcef localbcef = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReportController();
    if ((localbcef != null) && ((localbcef instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbcef).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcei
 * JD-Core Version:    0.7.0.1
 */
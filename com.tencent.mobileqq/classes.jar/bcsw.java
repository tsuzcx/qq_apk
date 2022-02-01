import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.statistics.ReportControllerImpl;

public class bcsw
  extends aomz
{
  public bcsw(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  protected void a()
  {
    bcst localbcst = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localbcst != null) && ((localbcst instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbcst).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
  
  protected void b()
  {
    bcst localbcst = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localbcst != null) && ((localbcst instanceof ReportControllerImpl))) {
      ((ReportControllerImpl)localbcst).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcsw
 * JD-Core Version:    0.7.0.1
 */
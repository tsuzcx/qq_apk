import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class aonu
  extends aont
{
  public aonu(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    this.jdField_a_of_type_Int = 6000;
  }
  
  protected aoxv a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0);
  }
  
  protected void a()
  {
    ((ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonu
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

public final class anpa
  extends anpq
{
  protected anpa(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() == 1)
    {
      if ((AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessage.frienduin)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(paramMessage.frienduin)) || (AppConstants.FRIEND_ANNIVER_UIN.equals(paramMessage.frienduin)))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.senderuin, true);
        this.jdField_a_of_type_Anpt.a(paramMessage);
      }
    }
    else {
      return;
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
    this.jdField_a_of_type_Anpt.a(paramMessage);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    a(paramMessage);
    String str = a() + ": ";
    this.jdField_a_of_type_Anpt.b(str);
    this.jdField_a_of_type_Anpt.d(c());
    return b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpa
 * JD-Core Version:    0.7.0.1
 */
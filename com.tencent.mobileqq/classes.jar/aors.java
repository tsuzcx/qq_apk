import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public final class aors
  extends aosj
{
  protected aors(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
    String str1;
    if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
    {
      str1 = (String)localObject + paramMessage.nickName + "(" + a() + "):";
      this.jdField_a_of_type_Aosm.b(str1);
      localObject = (String)localObject + paramMessage.nickName + ": " + c();
      this.jdField_a_of_type_Aosm.d((String)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() == 1)
      {
        localObject = (antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (localObject != null)
        {
          localObject = ((antl)localObject).a(paramMessage.frienduin, true);
          this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
        }
      }
      return b(paramMessage);
      str1 = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, 0);
      String str2 = (String)localObject + str1 + "(" + a() + "):";
      this.jdField_a_of_type_Aosm.b(str2);
      localObject = (String)localObject + str1 + ": " + c();
      this.jdField_a_of_type_Aosm.d((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aors
 * JD-Core Version:    0.7.0.1
 */
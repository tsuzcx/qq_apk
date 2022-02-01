import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public final class anoz
  extends anpq
{
  protected anoz(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
    String str1;
    if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
    {
      str1 = (String)localObject + paramMessage.nickName + "(" + a() + "):";
      this.jdField_a_of_type_Anpt.b(str1);
      localObject = (String)localObject + paramMessage.nickName + ": " + c();
      this.jdField_a_of_type_Anpt.d((String)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() == 1)
      {
        localObject = (amqx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(6);
        if (localObject != null)
        {
          localObject = ((amqx)localObject).a(paramMessage.frienduin, true);
          this.jdField_a_of_type_Anpt.a((Bitmap)localObject);
        }
      }
      return b(paramMessage);
      str1 = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, 0);
      String str2 = (String)localObject + str1 + "(" + a() + "):";
      this.jdField_a_of_type_Anpt.b(str2);
      localObject = (String)localObject + str1 + ": " + c();
      this.jdField_a_of_type_Anpt.d((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoz
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public class anph
  extends anpp
{
  protected anph(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject1;
    if (("device_groupchat".equals(paramMessage.extStr)) && ((paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4508)))
    {
      Object localObject2 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, true);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessage.senderuin))
      {
        localObject1 = localObject2;
        if (paramMessage.senderuin.equals(paramMessage.frienduin)) {
          localObject1 = abdn.a(((aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(paramMessage.senderuin)));
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = (String)localObject2 + ": " + c();
      this.jdField_a_of_type_Anpt.d((String)localObject1);
    }
    for (;;)
    {
      b(paramMessage);
      return this.jdField_a_of_type_Anpt;
      localObject1 = c();
      this.jdField_a_of_type_Anpt.d((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anph
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public class aosa
  extends aosi
{
  protected aosa(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return -113;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
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
          localObject1 = absz.a(((abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramMessage.senderuin)));
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = (String)localObject2 + ": " + c();
      this.jdField_a_of_type_Aosm.d((String)localObject1);
    }
    for (;;)
    {
      b(paramMessage);
      return this.jdField_a_of_type_Aosm;
      localObject1 = c();
      this.jdField_a_of_type_Aosm.d((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosa
 * JD-Core Version:    0.7.0.1
 */
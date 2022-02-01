import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public final class aoru
  extends aosj
{
  protected aoru(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047);
  }
  
  @Nullable
  private aosm c(QQMessageFacade.Message paramMessage)
  {
    Object localObject = "";
    if (nty.a(paramMessage))
    {
      String str1 = nty.a(paramMessage).b;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131696965) + str1 + "(" + a() + "):";
      this.jdField_a_of_type_Aosm.b(str2);
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131696965) + str1 + ": " + c();
      this.jdField_a_of_type_Aosm.d(str1);
      if ((paramMessage.msgtype == -2035) || (paramMessage.msgtype == -2038))
      {
        str1 = MessageForGrayTips.getOrginMsg(c());
        this.jdField_a_of_type_Aosm.a(str1);
      }
      if (paramMessage.msgtype == -3006)
      {
        localObject = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, false);
        this.jdField_a_of_type_Aosm.a((String)localObject);
        localObject = usu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      }
      if (!acnh.l(paramMessage.msgtype)) {
        break label478;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage);
      label226:
      str1 = (String)localObject + "(" + a() + "):";
      this.jdField_a_of_type_Aosm.b(str1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label507;
      }
      localObject = (String)localObject + ": " + c();
      this.jdField_a_of_type_Aosm.d((String)localObject);
    }
    for (;;)
    {
      localObject = bhmb.b(b());
      this.jdField_a_of_type_Aosm.d((String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
        this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
      }
      localObject = bkyy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null)
      {
        localObject = ((bkyy)localObject).b(b(), paramMessage);
        this.jdField_a_of_type_Aosm.d((String)localObject);
      }
      localObject = aqne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(b(), paramMessage);
      this.jdField_a_of_type_Aosm.d((String)localObject);
      return b(paramMessage);
      localObject = bgiz.a(paramMessage);
      if (localObject != null)
      {
        localObject = ((bgja)localObject).c;
        break;
      }
      if (!TextUtils.isEmpty(paramMessage.nickName))
      {
        localObject = paramMessage.nickName;
        break;
      }
      localObject = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      break;
      label478:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage) + (String)localObject;
      break label226;
      label507:
      localObject = c();
      this.jdField_a_of_type_Aosm.d((String)localObject);
    }
  }
  
  @Nullable
  private aosm d(QQMessageFacade.Message paramMessage)
  {
    String str = a() + ":";
    this.jdField_a_of_type_Aosm.b(str);
    str = c();
    this.jdField_a_of_type_Aosm.d(str);
    return b(paramMessage);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return b(paramMessage);
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage)) {
      return d(paramMessage);
    }
    return c(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoru
 * JD-Core Version:    0.7.0.1
 */
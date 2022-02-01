import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class aorz
  extends aosi
{
  protected aorz(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop == 1001) {
      return b(paramMessage);
    }
    return -113;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    String str;
    Object localObject;
    if (AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin))
    {
      str = ContactUtils.getDateNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramMessage.senderuin;
      }
      str = (String)localObject + "(" + a() + "):";
      this.jdField_a_of_type_Aosm.b(str);
      if (paramMessage.msgtype != -2053) {
        break label219;
      }
      localObject = paramMessage.nickName;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698655) + (String)localObject + c();
      this.jdField_a_of_type_Aosm.d((String)localObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getStrangerFaceBitmap(paramMessage.frienduin, 200);
        this.jdField_a_of_type_Aosm.a((Bitmap)localObject);
      }
      b(paramMessage);
      return this.jdField_a_of_type_Aosm;
      str = ContactUtils.getDateNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = paramMessage.frienduin;
      break;
      label219:
      if (paramMessage.msgtype == -2068)
      {
        localObject = c();
        this.jdField_a_of_type_Aosm.d((String)localObject);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNamePostfix(paramMessage) + (String)localObject + ": " + c();
        this.jdField_a_of_type_Aosm.d((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorz
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class anpq
  extends anpr
{
  protected anpq(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    paramMessage = apka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Anpt.a(), paramMessage);
    this.jdField_a_of_type_Anpt.a(paramMessage);
  }
  
  private void b(QQMessageFacade.Message paramMessage)
  {
    int i;
    Bitmap localBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.b() > 1)
    {
      i = 1;
      boolean bool = bjnm.a(paramMessage);
      if ((i != 0) && (bool))
      {
        localBitmap = this.jdField_a_of_type_Anpt.a();
        if (paramMessage.istroop != 0) {
          break label77;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Anpt.a(localBitmap);
      return;
      i = 0;
      break;
      label77:
      if (paramMessage.istroop == 1) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(paramMessage.frienduin, (byte)3, false, false);
      }
    }
  }
  
  private void c(QQMessageFacade.Message paramMessage)
  {
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker().a(paramMessage, this.jdField_a_of_type_Anpt.a());
    this.jdField_a_of_type_Anpt.a(paramMessage);
  }
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    paramMessage = apka.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Anpt.c(), paramMessage);
    this.jdField_a_of_type_Anpt.c(paramMessage);
  }
  
  private void e(QQMessageFacade.Message paramMessage)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    if (((paramMessage.istroop == 0) || (paramMessage.istroop == 1) || (paramMessage.istroop == 3000)) && (paramMessage.msgtype == -2016))
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgSummary(localBaseApplication, paramMessage, true);
      this.jdField_a_of_type_Anpt.a(paramMessage);
      this.jdField_a_of_type_Anpt.b(paramMessage);
      this.jdField_a_of_type_Anpt.d(paramMessage);
    }
  }
  
  protected final int b(QQMessageFacade.Message paramMessage)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
    int i = paramMessage.istroop;
    paramMessage = paramMessage.frienduin;
    if (bjnm.a(i, paramMessage))
    {
      if (bool) {
        return bjnm.a().a(paramMessage);
      }
      return 265;
    }
    return -113;
  }
  
  @Nullable
  protected final anpt b(QQMessageFacade.Message paramMessage)
  {
    a();
    a(paramMessage, this.jdField_a_of_type_Anpt);
    d(paramMessage);
    e(paramMessage);
    b(paramMessage);
    a(paramMessage);
    c(paramMessage);
    return this.jdField_a_of_type_Anpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpq
 * JD-Core Version:    0.7.0.1
 */
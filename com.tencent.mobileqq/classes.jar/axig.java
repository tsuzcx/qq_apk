import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

public class axig
  extends axii
{
  public axig(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp.istroop == 1) {
      nty.a().a(paramMessageForArkApp);
    }
    if (paramBoolean) {
      paramQQAppInterface.getMessageFacade().addSendMessage(paramMessageForArkApp);
    }
    paramMessageForArkApp.mPendantAnimatable = true;
    byte[] arrayOfByte = paramQQAppInterface.getProxyManager().a().a(paramMessageForArkApp);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageForArkApp.extraflag = 32768;
      paramQQAppInterface.getMsgCache().a(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
      String str = paramMessageForArkApp.frienduin;
      int i = paramMessageForArkApp.istroop;
      long l = paramMessageForArkApp.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramMessageForArkApp.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
    paramBoolean = ((axii)paramQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForArkApp.frienduin, paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq, 1035, new axih(this, paramMessageForArkApp, paramQQAppInterface));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
    }
    axii.a(paramQQAppInterface, paramMessageForArkApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axig
 * JD-Core Version:    0.7.0.1
 */
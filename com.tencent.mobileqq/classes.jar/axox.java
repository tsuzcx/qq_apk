import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

public class axox
  extends axoz
{
  public axox(QQAppInterface paramQQAppInterface)
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
      nlj.a().a(paramMessageForArkApp);
    }
    if (paramBoolean) {
      paramQQAppInterface.a().a(paramMessageForArkApp);
    }
    paramMessageForArkApp.mPendantAnimatable = true;
    byte[] arrayOfByte = paramQQAppInterface.a().a().a(paramMessageForArkApp);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageForArkApp.extraflag = 32768;
      paramQQAppInterface.a().a(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
      String str = paramMessageForArkApp.frienduin;
      int i = paramMessageForArkApp.istroop;
      long l = paramMessageForArkApp.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(MessageHandler.a(paramMessageForArkApp.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
    paramBoolean = ((axoz)paramQQAppInterface.getManager(166)).a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForArkApp.frienduin, paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq, 1035, new axoy(this, paramMessageForArkApp, paramQQAppInterface));
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
    axoz.a(paramQQAppInterface, paramMessageForArkApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axox
 * JD-Core Version:    0.7.0.1
 */
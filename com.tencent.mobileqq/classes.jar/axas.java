import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axas
{
  protected int a;
  protected QQAppInterface a;
  protected String a;
  protected int b;
  protected String b;
  protected int c;
  
  private axas(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, QQMessageFacade.Message paramMessage)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    try
    {
      axap localaxap = (axap)paramQQAppInterface.getManager(38);
      if (localaxap == null) {
        break label241;
      }
      this.jdField_a_of_type_Int = localaxap.b(paramString, paramInt1);
      if (this.jdField_a_of_type_Int <= 0) {
        break label241;
      }
      if (paramMessage == null) {
        break label235;
      }
      if (!bdex.b(paramMessage.msgtype))
      {
        bool = bdex.c(paramMessage.msgtype);
        if (!bool) {
          break label235;
        }
      }
      bool = true;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
      }
    }
    if (bool) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("CallUnreadCountInfo, isCallTabShow[%s], isConversationTabShow[%s], isInCallList[%s], uin[%s], type[%s], mUnreadMsgNum[%s], mMissCallCount[%s], mMsgExtroInfo[%s], isVideoMsg[%s]", new Object[] { Boolean.valueOf(paramQQAppInterface.n), Boolean.valueOf(paramQQAppInterface.o), Boolean.valueOf(paramQQAppInterface.p), paramString, Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) }));
      }
      return;
      try
      {
        this.jdField_a_of_type_JavaLangString = alud.a(2131709966);
      }
      catch (Exception paramMessage) {}
      QLog.w("fetchUnReadCount", 1, "CallUnreadCountInfo , Exception", paramMessage);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axas
 * JD-Core Version:    0.7.0.1
 */
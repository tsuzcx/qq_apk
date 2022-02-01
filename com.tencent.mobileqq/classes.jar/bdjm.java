import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.WriteTogetherDecodeFactory;
import mqq.app.AppRuntime;
import okio.ByteString;

public class bdjm
{
  private static final String jdField_a_of_type_JavaLangString = "WriteTogether." + bdjm.class.getSimpleName();
  private WriteTogetherDecodeFactory jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgWriteTogetherDecodeFactory = new WriteTogetherDecodeFactory();
  
  private void b(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    int i = 0;
    if (i < arrayOfString.length)
    {
      WriteTogetherDecodeFactory localWriteTogetherDecodeFactory = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherWebsocketMsgWriteTogetherDecodeFactory;
      String str = arrayOfString[i];
      if (i + 1 < arrayOfString.length)
      {
        paramString = arrayOfString[(i + 1)];
        label40:
        paramString = localWriteTogetherDecodeFactory.decode(str, paramString);
        if (paramString != null) {
          break label65;
        }
      }
      for (;;)
      {
        i += 2;
        break;
        paramString = null;
        break label40;
        label65:
        a(paramString);
      }
    }
  }
  
  void a(BaseWriteTogetherMsg paramBaseWriteTogetherMsg)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bdgj)((QQAppInterface)localAppRuntime).getManager(377)).a(paramBaseWriteTogetherMsg);
    }
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(ByteString paramByteString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjm
 * JD-Core Version:    0.7.0.1
 */
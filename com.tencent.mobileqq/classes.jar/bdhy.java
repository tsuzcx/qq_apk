import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.imcore.proxy.RecentRoute.ConversationFacadeProxy.Proxy;

public final class bdhy
  implements RecentRoute.ConversationFacadeProxy.Proxy
{
  public int getUnreadCount(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if (((paramIMCoreAppRuntime instanceof QQAppInterface)) && ((paramIMCoreMessageStub instanceof QQMessageFacade.Message)))
    {
      paramIMCoreAppRuntime = ((QQAppInterface)paramIMCoreAppRuntime).getConversationFacade();
      if (paramIMCoreAppRuntime != null) {
        return paramIMCoreAppRuntime.a(((QQMessageFacade.Message)paramIMCoreMessageStub).frienduin, paramInt);
      }
    }
    return 0;
  }
  
  public int getUnreadCount(IMCoreMessageStub paramIMCoreMessageStub, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if (((paramIMCoreAppRuntime instanceof QQAppInterface)) && ((paramIMCoreMessageStub instanceof QQMessageFacade.Message)))
    {
      paramIMCoreAppRuntime = ((QQAppInterface)paramIMCoreAppRuntime).getConversationFacade();
      if (paramIMCoreAppRuntime != null) {
        return paramIMCoreAppRuntime.a(((QQMessageFacade.Message)paramIMCoreMessageStub).frienduin, ((QQMessageFacade.Message)paramIMCoreMessageStub).istroop);
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhy
 * JD-Core Version:    0.7.0.1
 */
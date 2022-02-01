import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

public class bafb
  extends baev
{
  public bafb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a() {}
  
  public void a(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 27392)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloHeadReceiver", 2, "get apollo head update push.");
      }
      ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getApolloHead(this.a.getCurrentAccountUin());
    }
  }
  
  public void a(long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return paramInt == 27392;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafb
 * JD-Core Version:    0.7.0.1
 */
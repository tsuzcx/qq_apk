import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

public class ayzp
  extends ayzk
{
  public ayzp(QQAppInterface paramQQAppInterface)
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
      ((FriendListHandler)this.a.getBusinessHandler(1)).getApolloHead(this.a.getCurrentAccountUin());
    }
  }
  
  public void a(long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return paramInt == 27392;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzp
 * JD-Core Version:    0.7.0.1
 */
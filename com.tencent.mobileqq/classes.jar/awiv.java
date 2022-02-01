import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

abstract class awiv<T extends BusinessHandler>
{
  protected final QQAppInterface a;
  
  public awiv(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseProto", 2, new Object[] { "ssoLinkOk: invoked. ", " req: ", paramToServiceMsg, " res: ", paramFromServiceMsg, " data: ", paramObject });
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null) || (!paramFromServiceMsg.isSuccess())) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiv
 * JD-Core Version:    0.7.0.1
 */
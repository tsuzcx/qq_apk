import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class axve
  extends BusinessHandler
{
  public axve(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return axvf.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axve
 * JD-Core Version:    0.7.0.1
 */
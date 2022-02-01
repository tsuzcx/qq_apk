import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class aoha
  extends BusinessHandler
{
  public aoha(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "WifiCloudCheckSvc.req");
    localToServiceMsg.addAttribute("request_type", Integer.valueOf(paramInt));
    super.send(localToServiceMsg);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return aohb.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "WifiSdkHandler, onReceive resultCode: " + paramFromServiceMsg.getResultCode() + " errorMsg: " + paramFromServiceMsg.getBusinessFailMsg() + " serviceCmd: " + paramToServiceMsg.getServiceCmd());
    }
    int i = 0;
    try
    {
      if ("WifiCloudCheckSvc.req".equals(paramToServiceMsg.getServiceCmd()))
      {
        int j = ((Integer)paramToServiceMsg.getAttribute("request_type")).intValue();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("WifiSdk", 2, "WifiSdkHandler, onReceive type: " + j);
          i = j;
        }
      }
      super.notifyUI(i, paramFromServiceMsg.isSuccess(), paramObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("WifiSdk", 2, "WifiSdkHandler, onReceive exception: " + paramToServiceMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoha
 * JD-Core Version:    0.7.0.1
 */
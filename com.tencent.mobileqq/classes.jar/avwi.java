import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class avwi
  extends BusinessHandler
{
  private Map<Integer, CommonCallback> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public avwi(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowChannerHandler", 2, "handleLiveFeedNearbyAnchor req == null || res == null");
      }
      return;
    }
    CommonCallback localCommonCallback = (CommonCallback)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("BUFFER", (byte[])paramObject);
    localBundle.putInt("BIZCODE", 0);
    localBundle.putString("ERRMSG", paramFromServiceMsg.getBusinessFailMsg());
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      localBundle.putInt("CHANNELCODE", i);
      localBundle.putString("serviceCmd", (String)paramToServiceMsg.getAttribute("serviceCmd"));
      if (localCommonCallback == null) {
        break;
      }
      localCommonCallback.onResult(localBundle);
      return;
      i = -1;
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, CommonCallback<Bundle> paramCommonCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.w("NowChannerHandler", 2, "send serviceName = " + paramString1 + " to SSO Service");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceCmd", paramString2);
    anrx.a();
    anrx.a(paramString2, new int[] { BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2 });
    paramString1 = new ToServiceMsg(paramString1, getCurrentAccountUin(), paramString2);
    paramString1.putWupBuffer(paramArrayOfByte);
    paramString1.setAttributes(localHashMap);
    paramString1.setTimeout(15000L);
    sendPbReq(paramString1);
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    paramString1.setRequestSsoSeq(i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramCommonCallback);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return avwh.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("NowChannerHandler", 2, "onReceive-----serviceName = " + paramToServiceMsg.getServiceName() + ", serviceCmd = " + paramToServiceMsg.getServiceCmd());
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwi
 * JD-Core Version:    0.7.0.1
 */
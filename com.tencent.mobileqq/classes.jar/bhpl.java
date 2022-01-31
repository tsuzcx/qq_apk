import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class bhpl
{
  private static ConcurrentHashMap<String, bhpm> a = new ConcurrentHashMap();
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null)
    {
      Object localObject = paramFromServiceMsg.getServiceCmd();
      localObject = (bhpm)a.get(localObject);
      if (localObject != null) {
        ((bhpm)localObject).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public static void a(String paramString, bhpm parambhpm)
  {
    if ((paramString != null) && (parambhpm != null)) {
      a.put(paramString, parambhpm);
    }
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString == null) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface == null) {
      return false;
    }
    paramString = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    localQQAppInterface.sendToService(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhpl
 * JD-Core Version:    0.7.0.1
 */
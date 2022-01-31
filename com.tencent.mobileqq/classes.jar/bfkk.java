import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class bfkk
{
  private static ConcurrentHashMap<String, bfkl> a = new ConcurrentHashMap();
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null)
    {
      Object localObject = paramFromServiceMsg.getServiceCmd();
      localObject = (bfkl)a.get(localObject);
      if (localObject != null) {
        ((bfkl)localObject).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public static void a(String paramString, bfkl parambfkl)
  {
    if ((paramString != null) && (parambfkl != null)) {
      a.put(paramString, parambfkl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfkk
 * JD-Core Version:    0.7.0.1
 */
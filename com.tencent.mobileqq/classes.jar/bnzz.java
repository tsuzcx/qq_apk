import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public final class bnzz
{
  private static Singleton<bnzz, Void> jdField_a_of_type_ComTencentWeiyunUtilsSingleton = new boaa();
  private long jdField_a_of_type_Long = 1L;
  private ConcurrentHashMap<Integer, boab> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public static bnzz a()
  {
    return (bnzz)jdField_a_of_type_ComTencentWeiyunUtilsSingleton.get(null);
  }
  
  private void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.e("WySender", 1, "sendRequestInner : seq[" + paramInt + "], cmd is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WySender", 1, "sendRequestInner : seq[" + paramInt + "], cmd[" + paramString + "]");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String[] arrayOfString;
    if (paramString.contains(".")) {
      arrayOfString = paramString.split("\\.");
    }
    for (int i = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);; i = Integer.parseInt(paramString))
    {
      paramArrayOfByte = new bnzx(i, paramArrayOfByte);
      paramString = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), paramString);
      paramString.setTimeout(Math.min(60000L, (30000.0D * Math.pow(this.jdField_a_of_type_Long, 0.15D))));
      paramString.setEnableFastResend(true);
      paramString.putWupBuffer(bnzy.a(paramArrayOfByte));
      paramString.extraData.putInt("sequence", paramInt);
      paramString.extraData.putLong("sendtimekey", System.currentTimeMillis());
      paramArrayOfByte = new NewIntent(localAppRuntime.getApplication(), boac.class);
      paramArrayOfByte.putExtra(ToServiceMsg.class.getSimpleName(), paramString);
      localAppRuntime.startServlet(paramArrayOfByte);
      return;
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    int k = paramToServiceMsg.extraData.getInt("sequence");
    int i;
    label40:
    bnzx localbnzx;
    if (paramFromServiceMsg.isSuccess())
    {
      i = 0;
      if (i != 1002) {
        break label148;
      }
      this.jdField_a_of_type_Long += 1L;
      if (i != 0) {
        break label156;
      }
      localbnzx = bnzy.a(paramFromServiceMsg.getWupBuffer());
      label53:
      paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      paramToServiceMsg = paramFromServiceMsg;
      if (i == 1002) {
        paramToServiceMsg = "(1002)" + paramFromServiceMsg;
      }
      if (i != 0) {
        break label205;
      }
      if (localbnzx != null) {
        break label162;
      }
      i = 1810023;
    }
    label148:
    label156:
    label162:
    label196:
    label205:
    for (;;)
    {
      label99:
      boab localboab = (boab)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(k));
      if (localboab != null) {
        if (localbnzx != null) {
          break label196;
        }
      }
      for (paramFromServiceMsg = localObject;; paramFromServiceMsg = localbnzx.a())
      {
        localboab.a(i, paramToServiceMsg, paramFromServiceMsg);
        return;
        i = paramFromServiceMsg.getResultCode();
        break;
        this.jdField_a_of_type_Long = 1L;
        break label40;
        localbnzx = null;
        break label53;
        paramFromServiceMsg = localbnzx.a();
        int j = paramFromServiceMsg.retcode.get();
        if (j == 0) {
          break label205;
        }
        paramToServiceMsg = paramFromServiceMsg.retmsg.get();
        i = j;
        break label99;
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, boab paramboab)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (paramboab != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramboab);
    }
    a(i, paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzz
 * JD-Core Version:    0.7.0.1
 */
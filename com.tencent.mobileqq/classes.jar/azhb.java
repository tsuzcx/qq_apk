import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xed3.oidb_cmd0xed3.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azhb
  extends BusinessHandler
{
  protected azhb(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected azhb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiHandler", 2, "onReceiveEd3() called with: resultCode = [" + i + "], req = [" + paramToServiceMsg + "], res = [" + paramFromServiceMsg + "]");
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        QLog.d("PaiYiPaiHandler", 1, "onReceiveEd3()  e =", paramFromServiceMsg);
      }
    }
    notifyUI(paramToServiceMsg.uint32_result.get(), true, null);
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.mApp.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_user_double_tap_timestamp_" + (String)localObject, 0);
    long l1 = ((SharedPreferences)localObject).getLong(paramString, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l2 - l1;
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiHandler", 2, "canSendReq() called with: toUin = [" + paramString + "], lastDoubleTapTimestamp = [" + l1 + "], now = [" + l2 + "], interval = [" + l3 + "]ms");
    }
    boolean bool;
    if (l1 == 0L) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ((SharedPreferences)localObject).edit().putLong(paramString, l2).apply();
      }
      return bool;
      if (l3 > 10000L) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (!a(paramString1))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694487, 0).a();
      return;
    }
    oidb_cmd0xed3.ReqBody localReqBody = new oidb_cmd0xed3.ReqBody();
    localReqBody.uint64_to_uin.set(Long.valueOf(paramString1).longValue());
    if (paramInt == 0) {
      localReqBody.uint64_aio_uin.set(Long.valueOf(paramString2).longValue());
    }
    for (;;)
    {
      sendPbReq(makeOIDBPkg("OidbSvc.0xed3", 3795, 1, localReqBody.toByteArray()));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PaiYiPaiHandler", 2, "sendDoubleClickReq() called with: toUin = [" + paramString1 + "], friendUin = [" + paramString2 + "], uinType = [" + paramInt + "]");
      return;
      if (paramInt != 1) {
        break;
      }
      localReqBody.uint64_group_code.set(Long.valueOf(paramString2).longValue());
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return azhc.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {}
    while (!"OidbSvc.0xed3".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhb
 * JD-Core Version:    0.7.0.1
 */
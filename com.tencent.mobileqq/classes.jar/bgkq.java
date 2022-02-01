import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e.ReqBody;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e.RspBody;
import tencent.im.oidb.cmd0xe82.cmd0xe82.App;
import tencent.im.oidb.cmd0xe82.cmd0xe82.ClientInfo;
import tencent.im.oidb.cmd0xe82.cmd0xe82.ReqBody;
import tencent.im.oidb.cmd0xe82.cmd0xe82.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bgkq
  extends anud
{
  private bgks jdField_a_of_type_Bgks;
  private ConcurrentHashMap<Long, bgll> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicLong a;
  
  public bgkq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_a_of_type_Bgks = ((bgks)paramQQAppInterface.getManager(355));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xe82.RspBody localRspBody = new cmd0xe82.RspBody();
    long l1 = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("redpoint", Integer.valueOf(0))).intValue();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0)
    {
      int k = localRspBody.cache_ts.get();
      int m = localRspBody.disabled.get();
      int n = localRspBody.group_disabled.get();
      int i1 = localRspBody.redpoint_cache_ts.get();
      long l2 = localRspBody.switch_ts.get();
      if (QLog.isColorLevel()) {
        QLog.i("TroopShortcutBar", 2, "handleGetTroopAIOShortcutBar group_disabled: " + n + "disabled：" + m + "troopcode:" + l1);
      }
      paramToServiceMsg = new ArrayList();
      if (localRspBody.app.has())
      {
        paramFromServiceMsg = localRspBody.app.get().iterator();
        while (paramFromServiceMsg.hasNext()) {
          paramToServiceMsg.add(bgkn.a((cmd0xe82.App)paramFromServiceMsg.next()));
        }
      }
      paramToServiceMsg = new bgkr(l1, k, m, n, i1, l2, paramToServiceMsg);
      paramFromServiceMsg = (bgks)this.app.getManager(355);
      if (i == 1) {}
      for (bool = true;; bool = false)
      {
        paramFromServiceMsg.a(Long.valueOf(l1), paramToServiceMsg, bool);
        paramFromServiceMsg = new StringBuilder();
        if (paramToServiceMsg.a().isEmpty()) {
          break label395;
        }
        i = 0;
        while (i < paramToServiceMsg.a().size() - 1)
        {
          paramFromServiceMsg.append(((bgkn)paramToServiceMsg.a().get(i)).c()).append("|");
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler handleGetTroopAIOShortcutBar appList:" + paramFromServiceMsg + "troopCode: " + l1);
      }
    }
    label395:
    if (j == 0) {}
    for (boolean bool = true;; bool = false)
    {
      notifyUI(1, bool, new Object[] { Long.valueOf(l1) });
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    bgkr localbgkr = this.jdField_a_of_type_Bgks.a(Long.valueOf(paramLong));
    if (localbgkr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopShortcutBar", 2, new Object[] { "checkPullRedPoint return true", " info is null" });
      }
    }
    do
    {
      return true;
      if ((localbgkr.a().size() <= 0) || (System.currentTimeMillis() <= localbgkr.b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopShortcutBar", 2, "checkPullRedPoint return true");
    return true;
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0xe0e.RspBody localRspBody = new Oidb_0xe0e.RspBody();
    long l = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("disabled", Integer.valueOf(0))).intValue();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("bisadmin", Boolean.valueOf(false))).booleanValue();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0)
    {
      ((bgks)this.app.getManager(355)).a(l, i, bool);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShortcutBar", 2, "handleSetTotalSwitch troopCode: " + l + "disabled：" + i + "bIsAdmin:" + bool);
      }
    }
    if (j == 0) {}
    for (bool = true;; bool = false)
    {
      notifyUI(2, bool, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("sendSeq", 0L);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l))) && (((bgll)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l))).a(paramFromServiceMsg, paramObject))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler getTroopAIOShortCutBar troopCode:" + paramLong + ",troopType: " + paramInt);
    }
    cmd0xe82.ReqBody localReqBody = new cmd0xe82.ReqBody();
    localReqBody.group_id.set(paramLong);
    localReqBody.group_type.set(paramInt);
    if (bduy.a()) {
      localReqBody.mode.set(1);
    }
    if (a(paramLong)) {
      localReqBody.redpoint.set(1);
    }
    Object localObject = new cmd0xe82.ClientInfo();
    ((cmd0xe82.ClientInfo)localObject).platform.set(2);
    ((cmd0xe82.ClientInfo)localObject).version.set("8.4.5");
    localReqBody.client.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0xe82", 3714, 1, localReqBody.toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("trooptype", Integer.valueOf(paramInt));
    if (bduy.a()) {
      ((ToServiceMsg)localObject).addAttribute("mode", Integer.valueOf(1));
    }
    if ((localReqBody.redpoint.has()) && (localReqBody.redpoint.get() == 1)) {
      ((ToServiceMsg)localObject).addAttribute("redpoint", Integer.valueOf(1));
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopShortcutBar", 2, "setTotalSwitch troopCode: " + paramLong + "disabled：" + paramInt);
    }
    if (((bgks)this.app.getManager(355)).a(Long.valueOf(paramLong)) == null) {
      return;
    }
    Object localObject = new Oidb_0xe0e.ReqBody();
    ((Oidb_0xe0e.ReqBody)localObject).group_id.set(paramLong);
    ((Oidb_0xe0e.ReqBody)localObject).disabled.set(paramInt);
    localObject = makeOIDBPkg("OidbSvc.0xe0e", 3598, 1, ((Oidb_0xe0e.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("disabled", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject).addAttribute("bisadmin", Boolean.valueOf(paramBoolean));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends anui> observerClass()
  {
    return bgku.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramToServiceMsg == null)) {
      QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive res == null || req == null");
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive resultCode:" + paramFromServiceMsg.getResultCode() + "errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + "serivceCmd: " + paramToServiceMsg.getServiceCmd());
      }
      str = paramToServiceMsg.getServiceCmd();
      try
      {
        int i = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject)).uint32_result.get();
        if ((i != 0) && (QLog.isColorLevel())) {
          QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive return Error result:" + i + "cmd：" + paramToServiceMsg.getServiceCmd());
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive exception: " + localInvalidProtocolBufferMicroException.getMessage() + "cmd：" + paramToServiceMsg.getServiceCmd());
          }
        }
        if (!"OidbSvc.0xe0e".equals(str)) {
          continue;
        }
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe82".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvcTcp.0xea3".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkq
 * JD-Core Version:    0.7.0.1
 */
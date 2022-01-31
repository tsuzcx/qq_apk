import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
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
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.App;
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.ClientInfo;
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.ReqBody;
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.RspBody;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e.ReqBody;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e.RspBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.ReqBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bcim
  extends alpd
{
  public bcim(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xe0a.RspBody localRspBody = new cmd0xe0a.RspBody();
    long l = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0)
    {
      int i = localRspBody.cache_ts.get();
      int k = localRspBody.disabled.get();
      int m = localRspBody.group_disabled.get();
      int n = localRspBody.redpoint_cache_ts.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = localRspBody.app.get().iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(bcij.a((cmd0xe0a.App)paramFromServiceMsg.next()));
      }
      paramToServiceMsg = new bcin(l, i, k, m, n, paramToServiceMsg);
      ((bcio)this.app.getManager(355)).a(Long.valueOf(l), paramToServiceMsg);
      paramFromServiceMsg = new StringBuilder();
      if (!paramToServiceMsg.a().isEmpty())
      {
        i = 0;
        while (i < paramToServiceMsg.a().size() - 1)
        {
          paramFromServiceMsg.append(((bcij)paramToServiceMsg.a().get(i)).a()).append("|");
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler handleGetTroopAIOShortcutBar appList:" + paramFromServiceMsg + "troopCode: " + l);
        }
      }
    }
    if (j == 0) {}
    for (boolean bool = true;; bool = false)
    {
      notifyUI(2, bool, new Object[] { Long.valueOf(l) });
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xe0a.RspBody localRspBody = new cmd0xe0a.RspBody();
    long l = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      int j = localRspBody.cache_ts.get();
      int k = localRspBody.disabled.get();
      int m = localRspBody.group_disabled.get();
      int n = localRspBody.redpoint_cache_ts.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = localRspBody.app.get().iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(bcij.a((cmd0xe0a.App)paramFromServiceMsg.next()));
      }
      paramToServiceMsg = new bcin(l, j, k, m, n, paramToServiceMsg);
      ((bcio)this.app.getManager(355)).b(Long.valueOf(l), paramToServiceMsg);
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      notifyUI(1, bool, new Object[] { Long.valueOf(l) });
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0xe0e.RspBody localRspBody = new Oidb_0xe0e.RspBody();
    long l1 = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("appid", Long.valueOf(0L))).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("disabled", Integer.valueOf(0))).intValue();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0) {
      ((bcio)this.app.getManager(355)).a(l1, l2, i);
    }
    if (j == 0) {}
    for (boolean bool = true;; bool = false)
    {
      notifyUI(3, bool, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0xe0e.RspBody localRspBody = new Oidb_0xe0e.RspBody();
    long l = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("disabled", Integer.valueOf(0))).intValue();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("bisadmin", Boolean.valueOf(false))).booleanValue();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0) {
      ((bcio)this.app.getManager(355)).a(l, i, bool);
    }
    if (j == 0) {}
    for (bool = true;; bool = false)
    {
      notifyUI(4, bool, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      return;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
          break label188;
        }
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(5, false, new Object[] { Long.valueOf(l) });
        return;
      }
      try
      {
        paramFromServiceMsg = new oidb_0x8c9.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        if (!paramFromServiceMsg.rpt_group_app_unread_info.has()) {
          break label188;
        }
        paramToServiceMsg = paramFromServiceMsg.rpt_group_app_unread_info.get();
        ((bcio)this.app.getManager(355)).a(Long.valueOf(l), paramToServiceMsg);
        bool = true;
      }
      catch (Exception paramToServiceMsg)
      {
        bool = false;
        continue;
      }
      notifyUI(5, bool, new Object[] { Long.valueOf(l) });
      return;
      label188:
      boolean bool = false;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new cmd0xe0a.ReqBody();
    ((cmd0xe0a.ReqBody)localObject).group_id.set(paramLong);
    ((cmd0xe0a.ReqBody)localObject).group_type.set(paramInt);
    if (babd.a()) {
      ((cmd0xe0a.ReqBody)localObject).mode.set(1);
    }
    cmd0xe0a.ClientInfo localClientInfo = new cmd0xe0a.ClientInfo();
    localClientInfo.platform.set(2);
    localClientInfo.version.set("8.3.5");
    ((cmd0xe0a.ReqBody)localObject).client.set(localClientInfo);
    localObject = makeOIDBPkg("OidbSvc.0xe0a_1", 3594, 1, ((cmd0xe0a.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("trooptype", Integer.valueOf(paramInt));
    if (babd.a()) {
      ((ToServiceMsg)localObject).addAttribute("mode", Integer.valueOf(1));
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = ((bcio)this.app.getManager(355)).b(Long.valueOf(paramLong));
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new Oidb_0xe0e.ReqBody();
    ((Oidb_0xe0e.ReqBody)localObject1).group_id.set(paramLong);
    ((Oidb_0xe0e.ReqBody)localObject1).disabled.set(paramInt);
    Object localObject3 = ((bcin)localObject2).a();
    localObject2 = new ArrayList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      bcij localbcij = (bcij)((Iterator)localObject3).next();
      if (localbcij.c() == 1) {
        ((ArrayList)localObject2).add(Long.valueOf(localbcij.a()));
      }
    }
    ((Oidb_0xe0e.ReqBody)localObject1).disabled_appids.set((List)localObject2);
    localObject1 = makeOIDBPkg("OidbSvc.0xe0e_2", 3598, 0, ((Oidb_0xe0e.ReqBody)localObject1).toByteArray(), 30000L);
    ((ToServiceMsg)localObject1).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject1).addAttribute("disabled", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject1).addAttribute("bisadmin", Boolean.valueOf(paramBoolean));
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject2 = ((bcio)this.app.getManager(355)).b(Long.valueOf(paramLong1));
    if (localObject2 == null) {
      return;
    }
    int i = ((bcin)localObject2).a();
    Object localObject1 = new Oidb_0xe0e.ReqBody();
    ((Oidb_0xe0e.ReqBody)localObject1).group_id.set(paramLong1);
    ((Oidb_0xe0e.ReqBody)localObject1).disabled.set(i);
    Object localObject3 = ((bcin)localObject2).a();
    localObject2 = new ArrayList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      bcij localbcij = (bcij)((Iterator)localObject3).next();
      if ((localbcij.a() == 1) && (localbcij.a() != paramLong2)) {
        ((ArrayList)localObject2).add(Long.valueOf(localbcij.a()));
      }
    }
    if (paramInt == 1) {
      ((ArrayList)localObject2).add(Long.valueOf(paramLong2));
    }
    ((Oidb_0xe0e.ReqBody)localObject1).disabled_appids.set((List)localObject2);
    localObject1 = makeOIDBPkg("OidbSvc.Oxe0e_1", 3598, 0, ((Oidb_0xe0e.ReqBody)localObject1).toByteArray(), 30000L);
    ((ToServiceMsg)localObject1).addAttribute("troopcode", Long.valueOf(paramLong1));
    ((ToServiceMsg)localObject1).addAttribute("appid", Long.valueOf(paramLong2));
    ((ToServiceMsg)localObject1).addAttribute("disabled", Integer.valueOf(paramInt));
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(Long paramLong, List<Long> paramList)
  {
    long l = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
    Object localObject = new oidb_0x8c9.ReqBody();
    ((oidb_0x8c9.ReqBody)localObject).opt_uint64_from_uin.set(l);
    ((oidb_0x8c9.ReqBody)localObject).opt_uint64_group_code.set(paramLong.longValue());
    ((oidb_0x8c9.ReqBody)localObject).rpt_uint64_appid.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2249);
    paramList.uint32_service_type.set(2);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8c9.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x8c9_2.GetPoint");
    ((ToServiceMsg)localObject).addAttribute("troopcode", paramLong);
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(long paramLong, int paramInt)
  {
    Object localObject = new cmd0xe0a.ReqBody();
    ((cmd0xe0a.ReqBody)localObject).group_id.set(paramLong);
    ((cmd0xe0a.ReqBody)localObject).group_type.set(paramInt);
    cmd0xe0a.ClientInfo localClientInfo = new cmd0xe0a.ClientInfo();
    localClientInfo.platform.set(2);
    localClientInfo.version.set("8.3.5");
    ((cmd0xe0a.ReqBody)localObject).client.set(localClientInfo);
    localObject = makeOIDBPkg("OidbSvc.0xe0a_2", 3594, 2, ((cmd0xe0a.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("trooptype", Integer.valueOf(paramInt));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return bcip.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramToServiceMsg == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive resultCode:" + paramFromServiceMsg.getResultCode() + "errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + "serivceCmd: " + paramToServiceMsg.getServiceCmd());
      }
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
          String str;
          if (QLog.isColorLevel()) {
            QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive exception: " + localInvalidProtocolBufferMicroException.getMessage() + "cmd：" + paramToServiceMsg.getServiceCmd());
          }
        }
        if (!"OidbSvc.0xe0a_2".equals(localInvalidProtocolBufferMicroException)) {
          continue;
        }
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if (!"OidbSvc.Oxe0e_1".equals(localInvalidProtocolBufferMicroException)) {
          continue;
        }
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if (!"OidbSvc.0xe0e_2".equals(localInvalidProtocolBufferMicroException)) {
          continue;
        }
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      str = paramToServiceMsg.getServiceCmd();
      if ("OidbSvc.0xe0a_1".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x8c9_2.GetPoint".equals(localInvalidProtocolBufferMicroException));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcim
 * JD-Core Version:    0.7.0.1
 */
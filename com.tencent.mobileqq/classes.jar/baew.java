import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class baew
  extends BusinessHandler
{
  private Map<String, baeu> a;
  
  protected baew(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    a();
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Boolean)paramToServiceMsg.getAttribute("request_for_login");
    String str = (String)paramToServiceMsg.getAttribute("processor_key");
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonHandler", 2, String.format("handleGetProfileInfo requestForLogin=%s processorKey=%s", new Object[] { localObject, str }));
    }
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      do
      {
        return;
      } while (str == null);
      localObject = (baeu)this.a.get(str);
    } while (localObject == null);
    ((baeu)localObject).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = null;
    int i;
    if (bool) {
      i = j;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i = j;
        j = paramFromServiceMsg.uint32_result.get();
        if (j != 0) {
          continue;
        }
        bool = true;
        if (!bool) {
          break label261;
        }
        i = j;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label261;
        }
        i = j;
        paramObject = new oidb_0x5eb.RspBody();
        i = j;
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i = j;
        if (paramObject.rpt_msg_uin_data.size() <= 0) {
          break label261;
        }
        i = j;
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0);
        paramToServiceMsg = paramFromServiceMsg;
        i = j;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("ProfileCommonHandler", 1, "handleGetProfileInfoForLogin fail.", paramFromServiceMsg);
        bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCommonHandler", 2, String.format("handleGetProfileInfoForLogin success=%s result=%s udcUinData=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), paramToServiceMsg }));
      }
      if (paramToServiceMsg != null)
      {
        paramFromServiceMsg = this.a.values().iterator();
        if (paramFromServiceMsg.hasNext())
        {
          ((baeu)paramFromServiceMsg.next()).a(bool, paramToServiceMsg);
          continue;
          bool = false;
          continue;
        }
      }
      return;
      label261:
      paramToServiceMsg = null;
      continue;
      i = j;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (String)paramToServiceMsg.getAttribute("processor_key");
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonHandler", 2, String.format("handleSetProfileInfo  processorKey=%s", new Object[] { localObject }));
    }
    if (localObject != null)
    {
      localObject = (baeu)this.a.get(localObject);
      if (localObject != null) {
        ((baeu)localObject).b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public baeu a(String paramString)
  {
    baeu localbaeu = null;
    if (this.a != null) {
      localbaeu = (baeu)this.a.get(paramString);
    }
    return localbaeu;
  }
  
  protected void a()
  {
    this.a = new HashMap();
    this.a.put("AssistantSwitchImpl", new balv(this.app, this));
    this.a.put("TroopLuckyCharacterProcessor", new bafa(this.app, this));
  }
  
  public void b()
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
    Iterator localIterator = this.a.values().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((baeu)localIterator.next()).a((oidb_0x5eb.ReqBody)localObject) | bool) {}
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonHandler", 2, String.format("getProfileInfoForLogin needRequest=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22_common", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("request_for_login", Boolean.valueOf(true));
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x5eb_22_common");
      this.allowCmdSet.add("OidbSvc.0x587_74_common");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return baex.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {}
    do
    {
      return;
      if ("OidbSvc.0x5eb_22_common".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x587_74_common".equals(str));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baew
 * JD-Core Version:    0.7.0.1
 */
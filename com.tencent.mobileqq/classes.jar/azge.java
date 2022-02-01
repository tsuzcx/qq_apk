import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0x587.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azge
  extends ayzj
{
  public azge(QQAppInterface paramQQAppInterface, ayzl paramayzl)
  {
    super(paramQQAppInterface, paramayzl);
  }
  
  public static Boolean a(int paramInt)
  {
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (azge)ayzn.a(paramQQAppInterface, "AssistantSwitchImpl");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      azeu.a("HelloQQWake", "AssistantSwitchImpl getSwitch fail." + paramQQAppInterface.getMessage());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      paramQQAppInterface = (azge)ayzn.a(paramQQAppInterface, "AssistantSwitchImpl");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramBoolean);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      azeu.a("HelloQQWake", "AssistantSwitchImpl setSwitch fail." + paramQQAppInterface.getMessage());
    }
  }
  
  public String a()
  {
    return "AssistantSwitchImpl";
  }
  
  public void a()
  {
    azeu.a("HelloQQWake", "getqqAssistantSwitch");
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    localReqBody.rpt_uint64_uins.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
    localReqBody.uint32_qq_assistant_switch.set(1);
    a(this.jdField_a_of_type_Ayzl.makeOIDBPkg("OidbSvc.0x5eb_22_common", 1515, 22, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    int j = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = null;
    if (bool1)
    {
      i = j;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i = j;
        j = paramFromServiceMsg.uint32_result.get();
        if (j == 0)
        {
          bool1 = true;
          if (!bool1) {
            break label314;
          }
          i = j;
          if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
            break label314;
          }
          i = j;
          paramObject = new oidb_0x5eb.RspBody();
          i = j;
          paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = j;
          if (paramObject.rpt_msg_uin_data.size() <= 0) {
            break label314;
          }
          i = j;
          paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0);
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          azeu.a("HelloQQWake", "handleGetProfileInfo fail." + paramFromServiceMsg.getMessage());
          bool1 = false;
          continue;
          i = 0;
          continue;
          label314:
          paramToServiceMsg = null;
        }
      }
    }
    for (int i = j;; i = j)
    {
      azeu.a("HelloQQWake", String.format("handleGetProfileInfo success=%s result=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) }));
      if (paramToServiceMsg != null)
      {
        boolean bool2 = paramToServiceMsg.uint32_qq_assistant_switch.has();
        if (bool2)
        {
          i = paramToServiceMsg.uint32_qq_assistant_switch.get();
          azhh.a().a(a(i).booleanValue());
          azeu.a("HelloQQWake", String.format("handleGetProfileInfoForLogin hasWeiShiSwitch=%s weiShiSwitchValue=%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i) }));
          this.jdField_a_of_type_Ayzl.notifyUI(2, bool1, a(i));
        }
      }
      else
      {
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    azeu.a("HelloQQWake", String.format("setWeiShiSwitch value=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    oidb_0x587.ReqBody localReqBody = new oidb_0x587.ReqBody();
    localReqBody.rpt_uint64_uins.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_qq_assistant_switch;
    if (paramBoolean) {
      i = 2;
    }
    localPBUInt32Field.set(i);
    a(this.jdField_a_of_type_Ayzl.makeOIDBPkg("OidbSvc.0x587_74_common", 1415, 74, localReqBody.toByteArray()));
  }
  
  public void a(boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    paramBoolean = paramUdcUinData.uint32_qq_assistant_switch.has();
    int i;
    if (paramBoolean)
    {
      i = paramUdcUinData.uint32_qq_assistant_switch.get();
      azhh.a().a(a(i).booleanValue());
    }
    for (;;)
    {
      azeu.a("HelloQQWake", String.format("handleGetProfileInfoForLogin hasSwitch=%s SwitchValue=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) }));
      return;
      i = 0;
    }
  }
  
  public boolean a(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_qq_assistant_switch.set(1);
    azeu.a("HelloQQWake", "processGetProfileInfoForLogin");
    return true;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int j = paramFromServiceMsg.getResultCode();
    if (bool) {}
    for (;;)
    {
      try
      {
        i = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject)).uint32_result.get();
        azeu.a("HelloQQWake", String.format("handleSetProfileInfo success=%s result=%s setData=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) }));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        azeu.a("HelloQQWake", "handleSetProfileInfo fail." + paramToServiceMsg.getMessage());
        i = -1;
        bool = false;
        continue;
      }
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azge
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DoubtInfo;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetListRspBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetUnreadNumRspBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.RspBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72.RspBody;

public class aoeh
  extends aods
{
  public aoeh(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xd69".equals(paramString)) || ("OidbSvc.0xd72".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xd69".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.0xd72".equals(str)) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = ((Integer)paramToServiceMsg.getAttribute("cmd", Integer.valueOf(0))).intValue();
    Object localObject3 = new oidb_cmd0xd69.RspBody();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int k = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    int m = ((oidb_cmd0xd69.RspBody)localObject3).cmd_type.get();
    localObject1 = new StringBuilder(1024);
    Object localObject2;
    label287:
    boolean bool;
    if (k == 0)
    {
      paramObject = (aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      if (m == 2)
      {
        int i = 0;
        if (((oidb_cmd0xd69.RspBody)localObject3).msg_get_unread_num_body.has()) {
          i = ((oidb_cmd0xd69.GetUnreadNumRspBody)((oidb_cmd0xd69.RspBody)localObject3).msg_get_unread_num_body.get()).doubt_unread_num.get();
        }
        ((StringBuilder)localObject1).append("CMD_GET_UNREAD unread=").append(i);
        paramObject.b(i);
        a(124, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousMsg cmd:" + m + " localCmd:" + j + " result:" + k + " |" + ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (m == 1)
      {
        localObject2 = paramToServiceMsg.getAttribute("exactData");
        if (!((oidb_cmd0xd69.RspBody)localObject3).msg_get_list_body.has()) {
          break label914;
        }
        if (!((oidb_cmd0xd69.RspBody)localObject3).msg_get_list_body.bytes_cookies.has()) {
          break label909;
        }
        paramFromServiceMsg = ((oidb_cmd0xd69.RspBody)localObject3).msg_get_list_body.bytes_cookies.get().toByteArray();
        paramToServiceMsg = (oidb_cmd0xd69.GetListRspBody)((oidb_cmd0xd69.RspBody)localObject3).msg_get_list_body.get();
        if (!paramToServiceMsg.rpt_msg_list.has()) {
          break label904;
        }
        localObject3 = paramToServiceMsg.rpt_msg_list.get();
        paramToServiceMsg = new ArrayList(((List)localObject3).size());
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          paramToServiceMsg.add(SysSuspiciousMsg.covertFrom((oidb_cmd0xd69.DoubtInfo)((Iterator)localObject3).next()));
        }
        if (paramFromServiceMsg == null)
        {
          bool = true;
          label380:
          paramObject.a(paramToServiceMsg, bool);
        }
      }
    }
    for (;;)
    {
      localObject3 = ((StringBuilder)localObject1).append("CMD_GET_LIST unread=").append("|");
      if (paramToServiceMsg != null)
      {
        paramObject = Integer.valueOf(paramToServiceMsg.size());
        label413:
        ((StringBuilder)localObject3).append(paramObject);
        localObject3 = ((StringBuilder)localObject1).append("|");
        if (paramFromServiceMsg == null) {
          break label490;
        }
      }
      label490:
      for (paramObject = " has cookie";; paramObject = " no cookie")
      {
        ((StringBuilder)localObject3).append(paramObject);
        a(125, true, new Object[] { Integer.valueOf(k), paramToServiceMsg, paramFromServiceMsg, localObject2 });
        break;
        bool = false;
        break label380;
        paramObject = " no list";
        break label413;
      }
      long l;
      if (m == 3)
      {
        l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
        ((StringBuilder)localObject1).append("CMD_DELETE uin=").append(l);
        paramObject.a(l);
        a(126, true, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
        break;
      }
      if (m == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousClear ");
        }
        ((StringBuilder)localObject1).append("CMD_CLEAR unread=");
        paramObject.l();
        a(127, true, new Object[] { Integer.valueOf(k) });
        break;
      }
      if (m != 5) {
        break;
      }
      ((StringBuilder)localObject1).append("CMD_REPORT");
      a(128, true, new Object[] { Integer.valueOf(k) });
      break;
      if (m == 2)
      {
        ((StringBuilder)localObject1).append("CMD_GET_UNREAD failed");
        a(124, false, new Object[] { Integer.valueOf(k), Integer.valueOf(0) });
        break;
      }
      if (m == 1)
      {
        ((StringBuilder)localObject1).append("CMD_GET_LIST failed");
        a(125, false, new Object[] { Integer.valueOf(k), null, null, paramToServiceMsg.getAttribute("exactData") });
        break;
      }
      if (m == 3)
      {
        l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
        ((StringBuilder)localObject1).append("CMD_DELETE failed ").append(l);
        a(126, false, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
        break;
      }
      if (m == 4)
      {
        ((StringBuilder)localObject1).append("CMD_CLEAR failed");
        a(127, false, new Object[] { Integer.valueOf(k) });
        break;
      }
      if (m != 5) {
        break;
      }
      ((StringBuilder)localObject1).append("CMD_REPORT failed");
      a(128, false, new Object[] { Integer.valueOf(k) });
      break;
      label904:
      paramToServiceMsg = null;
      continue;
      label909:
      paramFromServiceMsg = null;
      break label287;
      label914:
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("toUin", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleAgreeSuspiciousMsg " + l);
    }
    paramToServiceMsg = new oidb_cmd0xd72.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int i = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleAgreeSuspiciousMsg suc " + l);
      }
      ((aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(l);
      a(129, true, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleAgreeSuspiciousMsg failed result:" + i);
    }
    a(129, false, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoeh
 * JD-Core Version:    0.7.0.1
 */
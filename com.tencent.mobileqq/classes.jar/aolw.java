import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
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

public class aolw
  extends aolh
{
  public aolw(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xd69.RspBody paramRspBody, int paramInt, StringBuilder paramStringBuilder, aizi paramaizi)
  {
    ArrayList localArrayList = null;
    Object localObject = paramToServiceMsg.getAttribute("exactData");
    boolean bool;
    if (paramRspBody.msg_get_list_body.has()) {
      if (paramRspBody.msg_get_list_body.bytes_cookies.has())
      {
        paramToServiceMsg = paramRspBody.msg_get_list_body.bytes_cookies.get().toByteArray();
        oidb_cmd0xd69.GetListRspBody localGetListRspBody = (oidb_cmd0xd69.GetListRspBody)paramRspBody.msg_get_list_body.get();
        paramRspBody = paramToServiceMsg;
        if (localGetListRspBody.rpt_msg_list.has())
        {
          paramRspBody = localGetListRspBody.rpt_msg_list.get();
          localArrayList = new ArrayList(paramRspBody.size());
          paramRspBody = paramRspBody.iterator();
          while (paramRspBody.hasNext()) {
            localArrayList.add(SysSuspiciousMsg.covertFrom((oidb_cmd0xd69.DoubtInfo)paramRspBody.next()));
          }
          if (paramToServiceMsg != null) {
            break label243;
          }
          bool = true;
          paramaizi.a(localArrayList, bool);
        }
      }
    }
    for (paramRspBody = paramToServiceMsg;; paramRspBody = null)
    {
      paramaizi = paramStringBuilder.append("CMD_GET_LIST unread=").append("|");
      if (localArrayList != null)
      {
        paramToServiceMsg = Integer.valueOf(localArrayList.size());
        label180:
        paramaizi.append(paramToServiceMsg);
        paramStringBuilder = paramStringBuilder.append("|");
        if (paramRspBody == null) {
          break label255;
        }
      }
      label243:
      label255:
      for (paramToServiceMsg = " has cookie";; paramToServiceMsg = " no cookie")
      {
        paramStringBuilder.append(paramToServiceMsg);
        a(125, true, new Object[] { Integer.valueOf(paramInt), localArrayList, paramRspBody, localObject });
        return;
        bool = false;
        break;
        paramToServiceMsg = " no list";
        break label180;
      }
      paramToServiceMsg = null;
      break;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xd69".equals(paramString)) || ("OidbSvc.0xd72".equals(paramString));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = ((Integer)paramToServiceMsg.getAttribute("cmd", Integer.valueOf(0))).intValue();
    oidb_cmd0xd69.RspBody localRspBody = new oidb_cmd0xd69.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int k = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    int m = localRspBody.cmd_type.get();
    paramFromServiceMsg = new StringBuilder(1024);
    if (k == 0)
    {
      paramObject = (aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      if (m == 2) {
        if (!localRspBody.msg_get_unread_num_body.has()) {
          break label649;
        }
      }
    }
    label649:
    for (int i = ((oidb_cmd0xd69.GetUnreadNumRspBody)localRspBody.msg_get_unread_num_body.get()).doubt_unread_num.get();; i = 0)
    {
      paramFromServiceMsg.append("CMD_GET_UNREAD unread=").append(i);
      paramObject.b(i);
      a(124, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousMsg cmd:" + m + " localCmd:" + j + " result:" + k + " |" + paramFromServiceMsg.toString());
        }
        return;
        if (m == 1)
        {
          a(paramToServiceMsg, localRspBody, k, paramFromServiceMsg, paramObject);
        }
        else
        {
          long l;
          if (m == 3)
          {
            l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
            paramFromServiceMsg.append("CMD_DELETE uin=").append(l);
            paramObject.a(l);
            a(126, true, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
          }
          else if (m == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousClear ");
            }
            paramFromServiceMsg.append("CMD_CLEAR unread=");
            paramObject.l();
            a(127, true, new Object[] { Integer.valueOf(k) });
          }
          else if (m == 5)
          {
            paramFromServiceMsg.append("CMD_REPORT");
            a(128, true, new Object[] { Integer.valueOf(k) });
            continue;
            if (m == 2)
            {
              paramFromServiceMsg.append("CMD_GET_UNREAD failed");
              a(124, false, new Object[] { Integer.valueOf(k), Integer.valueOf(0) });
            }
            else if (m == 1)
            {
              paramFromServiceMsg.append("CMD_GET_LIST failed");
              a(125, false, new Object[] { Integer.valueOf(k), null, null, paramToServiceMsg.getAttribute("exactData") });
            }
            else if (m == 3)
            {
              l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
              paramFromServiceMsg.append("CMD_DELETE failed ").append(l);
              a(126, false, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
            }
            else if (m == 4)
            {
              paramFromServiceMsg.append("CMD_CLEAR failed");
              a(127, false, new Object[] { Integer.valueOf(k) });
            }
            else if (m == 5)
            {
              paramFromServiceMsg.append("CMD_REPORT failed");
              a(128, false, new Object[] { Integer.valueOf(k) });
            }
          }
        }
      }
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
      ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(l);
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
 * Qualified Name:     aolw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
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

public class SuspiciousOperReceiver
  extends BaseHandlerReceiver
{
  public SuspiciousOperReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xd69.RspBody paramRspBody, int paramInt, StringBuilder paramStringBuilder, INewFriendService paramINewFriendService)
  {
    Object localObject = paramToServiceMsg.getAttribute("exactData");
    boolean bool = paramRspBody.msg_get_list_body.has();
    ArrayList localArrayList = null;
    if (bool)
    {
      if (paramRspBody.msg_get_list_body.bytes_cookies.has()) {
        paramToServiceMsg = paramRspBody.msg_get_list_body.bytes_cookies.get().toByteArray();
      } else {
        paramToServiceMsg = null;
      }
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
        if (paramToServiceMsg == null) {
          bool = true;
        } else {
          bool = false;
        }
        paramINewFriendService.updateSuspiciousMsgListFromServer(localArrayList, bool);
        paramRspBody = paramToServiceMsg;
      }
    }
    else
    {
      paramRspBody = null;
    }
    paramStringBuilder.append("CMD_GET_LIST unread=");
    paramStringBuilder.append("|");
    if (localArrayList != null) {
      paramToServiceMsg = Integer.valueOf(localArrayList.size());
    } else {
      paramToServiceMsg = " no list";
    }
    paramStringBuilder.append(paramToServiceMsg);
    paramStringBuilder.append("|");
    if (paramRspBody != null) {
      paramToServiceMsg = " has cookie";
    } else {
      paramToServiceMsg = " no cookie";
    }
    paramStringBuilder.append(paramToServiceMsg);
    a(122, true, new Object[] { Integer.valueOf(paramInt), localArrayList, paramRspBody, localObject });
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0xd69".equals(paramString)) || ("OidbSvc.0xd72".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xd69".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xd72".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = Integer.valueOf(0);
    int j = ((Integer)paramToServiceMsg.getAttribute("cmd", localObject)).intValue();
    oidb_cmd0xd69.RspBody localRspBody = new oidb_cmd0xd69.RspBody();
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    int k = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    int m = localRspBody.cmd_type.get();
    paramFromServiceMsg = new StringBuilder(1024);
    paramObject = Long.valueOf(0L);
    long l;
    if (k == 0)
    {
      localObject = (INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class);
      if (m == 2)
      {
        int i;
        if (localRspBody.msg_get_unread_num_body.has()) {
          i = ((oidb_cmd0xd69.GetUnreadNumRspBody)localRspBody.msg_get_unread_num_body.get()).doubt_unread_num.get();
        } else {
          i = 0;
        }
        paramFromServiceMsg.append("CMD_GET_UNREAD unread=");
        paramFromServiceMsg.append(i);
        ((INewFriendService)localObject).setSysSuspiciousUnreadNum(i);
        a(121, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      }
      else if (m == 1)
      {
        a(paramToServiceMsg, localRspBody, k, paramFromServiceMsg, (INewFriendService)localObject);
      }
      else if (m == 3)
      {
        l = ((Long)paramToServiceMsg.getAttribute("uin", paramObject)).longValue();
        paramFromServiceMsg.append("CMD_DELETE uin=");
        paramFromServiceMsg.append(l);
        ((INewFriendService)localObject).deleteSysSuspiciousMsg(l);
        a(123, true, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
      }
      else if (m == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousClear ");
        }
        paramFromServiceMsg.append("CMD_CLEAR unread=");
        ((INewFriendService)localObject).clearAllSysSuspiciousMsg();
        a(124, true, new Object[] { Integer.valueOf(k) });
      }
      else if (m == 5)
      {
        paramFromServiceMsg.append("CMD_REPORT");
        a(125, true, new Object[] { Integer.valueOf(k) });
      }
    }
    else if (m == 2)
    {
      paramFromServiceMsg.append("CMD_GET_UNREAD failed");
      a(121, false, new Object[] { Integer.valueOf(k), localObject });
    }
    else if (m == 1)
    {
      paramFromServiceMsg.append("CMD_GET_LIST failed");
      a(122, false, new Object[] { Integer.valueOf(k), null, null, paramToServiceMsg.getAttribute("exactData") });
    }
    else if (m == 3)
    {
      l = ((Long)paramToServiceMsg.getAttribute("uin", paramObject)).longValue();
      paramFromServiceMsg.append("CMD_DELETE failed ");
      paramFromServiceMsg.append(l);
      a(123, false, new Object[] { Integer.valueOf(k), Long.valueOf(l) });
    }
    else if (m == 4)
    {
      paramFromServiceMsg.append("CMD_CLEAR failed");
      a(124, false, new Object[] { Integer.valueOf(k) });
    }
    else if (m == 5)
    {
      paramFromServiceMsg.append("CMD_REPORT failed");
      a(125, false, new Object[] { Integer.valueOf(k) });
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetSuspiciousMsg cmd:");
      paramToServiceMsg.append(m);
      paramToServiceMsg.append(" localCmd:");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(" result:");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(" |");
      paramToServiceMsg.append(paramFromServiceMsg.toString());
      QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      long l = ((Long)paramToServiceMsg.getAttribute("toUin", Long.valueOf(0L))).longValue();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleAgreeSuspiciousMsg ");
        paramToServiceMsg.append(l);
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
      }
      paramToServiceMsg = new oidb_cmd0xd72.RspBody();
      FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
      int i = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleAgreeSuspiciousMsg suc ");
          paramToServiceMsg.append(l);
          QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
        }
        ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).deleteSysSuspiciousMsg(l);
        a(126, true, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleAgreeSuspiciousMsg failed result:");
        paramToServiceMsg.append(i);
        QLog.i("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
      }
      a(126, false, new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.SuspiciousOperReceiver
 * JD-Core Version:    0.7.0.1
 */
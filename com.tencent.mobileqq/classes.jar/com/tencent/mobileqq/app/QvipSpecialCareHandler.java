package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.remind.RemindPB.RemindItem;
import com.tencent.pb.remind.RemindPB.RemindQuota;
import com.tencent.pb.remind.RemindPB.ReqBody;
import com.tencent.pb.remind.RemindPB.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QvipSpecialCareHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  QvipSpecialCareHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(RemindPB.RspBody paramRspBody)
  {
    if (paramRspBody.rep_clear_uin.has())
    {
      Object localObject = paramRspBody.rep_clear_uin.get();
      paramRspBody = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = String.valueOf((Long)((Iterator)localObject).next());
          paramRspBody.add(str);
          QvipSpecialCareUtil.c(str, this.a);
        }
        QvipSpecialCareUtil.b(paramRspBody, this.a);
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->report MM:cmd=");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      localStringBuilder.append(",error code=");
      localStringBuilder.append(paramFromServiceMsg.getBusinessFailCode());
      localStringBuilder.append(",uin=");
      localStringBuilder.append(this.a.getCurrentAccountUin());
      QLog.e("QVipSpeicalCareHandler", 2, localStringBuilder.toString());
    }
    if (!paramFromServiceMsg.isSuccess()) {
      ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.a.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131908994), true);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, RemindPB.RspBody paramRspBody, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SpecialRemind.Service", 2, "get count fail.");
      }
      return;
    }
    paramInt = paramRspBody.int32_ret.get();
    notifyUI(1001, paramFromServiceMsg.isSuccess(), Integer.valueOf(paramInt));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    RemindPB.RspBody localRspBody = new RemindPB.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localRspBody;
    }
    catch (Exception localException)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handle send special sound exception:");
      paramArrayOfByte.append(localException.getMessage());
      QLog.i("SpecialRemind.Service", 1, paramArrayOfByte.toString());
      paramArrayOfByte = null;
      localException.printStackTrace();
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_method.has()))
    {
      int i = paramArrayOfByte.uint32_method.get();
      if (paramArrayOfByte.int32_ret.has())
      {
        if (paramArrayOfByte.int32_ret.get() == 0)
        {
          b(paramFromServiceMsg, paramArrayOfByte, i);
          return;
        }
        a(paramFromServiceMsg, paramArrayOfByte, i);
      }
    }
  }
  
  private boolean a(List<String> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private void b(RemindPB.RspBody paramRspBody)
  {
    if (paramRspBody.rep_set_info.has())
    {
      Object localObject = paramRspBody.rep_set_info.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramRspBody = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RemindPB.RemindItem localRemindItem = (RemindPB.RemindItem)((Iterator)localObject).next();
          if ((localRemindItem.uint64_uin.has()) && (localRemindItem.uint32_id.has()))
          {
            String str = String.valueOf(localRemindItem.uint64_uin.get());
            paramRspBody.add(str);
            QvipSpecialCareUtil.a(str, localRemindItem.uint32_id.get(), this.a);
          }
        }
        QvipSpecialCareUtil.a(paramRspBody, this.a);
      }
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, RemindPB.RspBody paramRspBody, int paramInt)
  {
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3))
      {
        if (paramInt == 4) {
          a(paramRspBody);
        }
      }
      else {
        b(paramRspBody);
      }
    }
    else {
      c(paramRspBody);
    }
    notifyUI(1000, paramFromServiceMsg.isSuccess(), Integer.valueOf(paramInt));
  }
  
  private void c(RemindPB.RspBody paramRspBody)
  {
    if (paramRspBody.msg_quota.has())
    {
      paramRspBody = (RemindPB.RemindQuota)paramRspBody.msg_quota.get();
      if (paramRspBody.uint32_comm_quota.has()) {
        QvipSpecialCareUtil.a(paramRspBody.uint32_comm_quota.get(), this.a);
      }
      if (paramRspBody.uint32_svip_quota.has()) {
        QvipSpecialCareUtil.b(paramRspBody.uint32_svip_quota.get(), this.a);
      }
      QvipSpecialCareUtil.e(this.a);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      a(paramFromServiceMsg, (byte[])paramObject);
      return;
    }
    a(paramFromServiceMsg);
  }
  
  public void a(List<String> paramList1, int paramInt, List<String> paramList2)
  {
    RemindPB.ReqBody localReqBody = new RemindPB.ReqBody();
    if ((paramInt == 1) || ((paramInt == 2) || (paramInt == 3) || (paramInt == 4))) {}
    try
    {
      if (a(paramList1))
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          localReqBody.rep_clear_uin.add(Long.valueOf(Long.parseLong(paramList2)));
        }
        localReqBody.uint32_method.set(4);
        break label244;
        if ((a(paramList1)) && (a(paramList2)) && (paramList1.size() == paramList2.size()))
        {
          int j = paramList2.size();
          int i = 0;
          while (i < j)
          {
            RemindPB.RemindItem localRemindItem = new RemindPB.RemindItem();
            localRemindItem.uint64_uin.set(Long.parseLong((String)paramList1.get(i)));
            localRemindItem.uint32_id.set(Integer.parseInt((String)paramList2.get(i)));
            localReqBody.rep_set_info.add(localRemindItem);
            localReqBody.setHasFlag(true);
            i += 1;
          }
          localReqBody.uint32_method.set(paramInt);
          break label244;
          localReqBody.uint32_method.set(1);
        }
      }
      label244:
      paramList1 = createToServiceMsg("SpecialRemind.Service");
      paramList1.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(paramList1);
      return;
    }
    catch (Exception paramList1)
    {
      paramList1.printStackTrace();
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QvipSpecialCareObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.length() == 0) {
        return;
      }
      if ("SpecialRemind.Service".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QvipSpecialCareHandler
 * JD-Core Version:    0.7.0.1
 */
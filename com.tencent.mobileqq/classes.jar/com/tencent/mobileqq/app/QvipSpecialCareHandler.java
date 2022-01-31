package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
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
  QvipSpecialCareHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(List paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  protected Class a()
  {
    return QvipSpecialCareObserver.class;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      localObject1 = new RemindPB.RspBody();
      try
      {
        ((RemindPB.RspBody)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
      }
      catch (Exception paramObject)
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SpecialRemind.Service", 2, "handle send special sound exception:" + paramObject.getMessage());
            }
            paramObject.printStackTrace();
            paramObject = null;
            continue;
            if (paramObject.msg_quota.has())
            {
              paramObject = (RemindPB.RemindQuota)paramObject.msg_quota.get();
              if (paramObject.uint32_comm_quota.has()) {
                QvipSpecialCareManager.a(paramObject.uint32_comm_quota.get(), this.b);
              }
              if (paramObject.uint32_svip_quota.has()) {
                QvipSpecialCareManager.b(paramObject.uint32_svip_quota.get(), this.b);
              }
              QvipSpecialCareManager.b(this.b);
              continue;
              if (paramObject.rep_set_info.has())
              {
                localObject1 = paramObject.rep_set_info.get();
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  paramObject = new ArrayList();
                  localObject1 = ((List)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (RemindPB.RemindItem)((Iterator)localObject1).next();
                    if ((((RemindPB.RemindItem)localObject2).uint64_uin.has()) && (((RemindPB.RemindItem)localObject2).uint32_id.has()))
                    {
                      str = String.valueOf(((RemindPB.RemindItem)localObject2).uint64_uin.get());
                      paramObject.add(str);
                      QvipSpecialCareManager.a(str, ((RemindPB.RemindItem)localObject2).uint32_id.get(), this.b);
                    }
                  }
                  QvipSpecialCareManager.a(paramObject, this.b);
                  continue;
                  if (paramObject.rep_clear_uin.has())
                  {
                    localObject1 = paramObject.rep_clear_uin.get();
                    paramObject = new ArrayList();
                    if ((localObject1 != null) && (((List)localObject1).size() > 0))
                    {
                      localObject1 = ((List)localObject1).iterator();
                      while (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = String.valueOf((Long)((Iterator)localObject1).next());
                        paramObject.add(localObject2);
                        QvipSpecialCareManager.c((String)localObject2, this.b);
                      }
                      QvipSpecialCareManager.b(paramObject, this.b);
                    }
                  }
                }
              }
            }
          }
          if (i != 1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("SpecialRemind.Service", 2, "get count fail.");
        return;
        int i = paramObject.int32_ret.get();
        a(1001, paramFromServiceMsg.isSuccess(), Integer.valueOf(i));
        return;
      }
      if ((paramObject != null) && (paramObject.uint32_method.has()))
      {
        i = paramObject.uint32_method.get();
        if (paramObject.int32_ret.has())
        {
          if (paramObject.int32_ret.get() != 0) {
            break label503;
          }
          switch (i)
          {
          default: 
            a(1000, paramFromServiceMsg.isSuccess(), Integer.valueOf(i));
          }
        }
      }
    }
    label503:
    do
    {
      return;
      Object localObject2;
      String str;
      if (QLog.isColorLevel()) {
        QLog.e("QVipSpeicalCareHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.b.getCurrentAccountUin());
      }
    } while (paramFromServiceMsg.isSuccess());
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.b.getCurrentAccountUin(), 1000277, "[特别关心]请求后台失败.", true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {}
    while (!"SpecialRemind.Service".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramFromServiceMsg, paramObject);
  }
  
  public void a(List paramList1, int paramInt, List paramList2)
  {
    RemindPB.ReqBody localReqBody = new RemindPB.ReqBody();
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramList1 = a("SpecialRemind.Service");
        paramList1.putWupBuffer(localReqBody.toByteArray());
        b(paramList1);
        return;
      }
      catch (Exception paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      localReqBody.uint32_method.set(1);
      continue;
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
        continue;
        if (a(paramList1))
        {
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            paramList2 = (String)paramList1.next();
            localReqBody.rep_clear_uin.add(Long.valueOf(Long.parseLong(paramList2)));
          }
          localReqBody.uint32_method.set(4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QvipSpecialCareHandler
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

public class aofw
  extends anud
{
  aofw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
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
          amjp.c(str, this.app);
        }
        amjp.b(paramRspBody, this.app);
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QVipSpeicalCareHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    if (!paramFromServiceMsg.isSuccess()) {
      bjqh.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, anzj.a(2131710272), true);
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
      int i;
      for (;;)
      {
        QLog.i("SpecialRemind.Service", 1, "handle send special sound exception:" + localException.getMessage());
        paramArrayOfByte = null;
        localException.printStackTrace();
      }
      a(paramFromServiceMsg, paramArrayOfByte, i);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_method.has()))
    {
      i = paramArrayOfByte.uint32_method.get();
      if (paramArrayOfByte.int32_ret.has())
      {
        if (paramArrayOfByte.int32_ret.get() != 0) {
          break label110;
        }
        b(paramFromServiceMsg, paramArrayOfByte, i);
      }
    }
    return;
    label110:
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
            amjp.a(str, localRemindItem.uint32_id.get(), this.app);
          }
        }
        amjp.a(paramRspBody, this.app);
      }
    }
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, RemindPB.RspBody paramRspBody, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      notifyUI(1000, paramFromServiceMsg.isSuccess(), Integer.valueOf(paramInt));
      return;
      c(paramRspBody);
      continue;
      b(paramRspBody);
      continue;
      a(paramRspBody);
    }
  }
  
  private void c(RemindPB.RspBody paramRspBody)
  {
    if (paramRspBody.msg_quota.has())
    {
      paramRspBody = (RemindPB.RemindQuota)paramRspBody.msg_quota.get();
      if (paramRspBody.uint32_comm_quota.has()) {
        amjp.a(paramRspBody.uint32_comm_quota.get(), this.app);
      }
      if (paramRspBody.uint32_svip_quota.has()) {
        amjp.b(paramRspBody.uint32_svip_quota.get(), this.app);
      }
      amjp.b(this.app);
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
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramList1 = createToServiceMsg("SpecialRemind.Service");
        paramList1.putWupBuffer(localReqBody.toByteArray());
        sendPbReq(paramList1);
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
  
  protected Class<? extends anui> observerClass()
  {
    return aofx.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {}
    while (!"SpecialRemind.Service".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    a(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofw
 * JD-Core Version:    0.7.0.1
 */
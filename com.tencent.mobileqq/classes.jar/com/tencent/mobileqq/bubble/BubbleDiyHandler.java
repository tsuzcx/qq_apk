package com.tencent.mobileqq.bubble;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
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
import org.json.JSONObject;

public class BubbleDiyHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public BubbleDiyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, BubbleDiyComu.Bubble_Rsp paramBubble_Rsp)
  {
    Object localObject;
    if (paramBubble_Rsp.ret.get() != 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DiyText...fetch key 回包 sso 成功 ，server 失败，ret = ");
        ((StringBuilder)localObject).append(paramBubble_Rsp.ret.get());
        QLog.d("BubbleDiyHandler", 2, ((StringBuilder)localObject).toString());
      }
      super.notifyUI(paramToServiceMsg, 1, false, null);
      return;
    }
    if ((paramBubble_Rsp.rspcmd_0x01.has()) && (paramBubble_Rsp.rspcmd_0x01.user_text_info.has()))
    {
      paramBubble_Rsp = paramBubble_Rsp.rspcmd_0x01.user_text_info.get();
      localObject = new ArrayList();
      if (paramBubble_Rsp != null) {
        a(paramBubble_Rsp, (List)localObject);
      }
      BubbleDiyFetcher.a().a(this.a, true, (List)localObject);
      super.notifyUI(paramToServiceMsg, 1, true, localObject);
      return;
    }
    super.notifyUI(paramToServiceMsg, 1, false, null);
  }
  
  private void a(List<BubbleDiyComu.UserTextInfo> paramList, List<BubbleDiyEntity> paramList1)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BubbleDiyComu.UserTextInfo localUserTextInfo = (BubbleDiyComu.UserTextInfo)paramList.next();
      if ((localUserTextInfo.text.has()) && (localUserTextInfo.text_uin.has()) && (localUserTextInfo.text_id.has()))
      {
        try
        {
          Object localObject = new JSONObject(localUserTextInfo.text.get());
          BubbleDiyEntity localBubbleDiyEntity = new BubbleDiyEntity();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localUserTextInfo.text_uin.get());
          localStringBuilder.append("_");
          localStringBuilder.append(localUserTextInfo.text_id.get());
          localBubbleDiyEntity.uinAndDiyId = localStringBuilder.toString();
          localBubbleDiyEntity.diyText = ((JSONObject)localObject).optString("diyText");
          localBubbleDiyEntity.bottomLeftId = ((JSONObject)localObject).optString("bl");
          localBubbleDiyEntity.bottomRightId = ((JSONObject)localObject).optString("br");
          localBubbleDiyEntity.topLeftId = ((JSONObject)localObject).optString("tl");
          localBubbleDiyEntity.topRightId = ((JSONObject)localObject).optString("tr");
          paramList1.add(localBubbleDiyEntity);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceive: uinAndDiyId: ");
          ((StringBuilder)localObject).append(localBubbleDiyEntity.uinAndDiyId);
          ((StringBuilder)localObject).append(",config: ");
          ((StringBuilder)localObject).append(localUserTextInfo.text.get());
          QLog.i("BubbleDiyHandler", 2, ((StringBuilder)localObject).toString());
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.e("BubbleDiyHandler", 2, "", localException);
        }
      }
    }
  }
  
  private void b(List<String> paramList, List<BubbleDiyComu.UserTextInfo> paramList1)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      BubbleDiyComu.UserTextInfo localUserTextInfo = new BubbleDiyComu.UserTextInfo();
      paramList = paramList.split("_");
      if (paramList.length == 2)
      {
        int i = 0;
        long l;
        try
        {
          l = Long.parseLong(paramList[0]);
          try
          {
            int j = Integer.parseInt(paramList[1]);
            i = j;
          }
          catch (NumberFormatException paramList) {}
          QLog.e("BubbleDiyHandler", 1, "", paramList);
        }
        catch (NumberFormatException paramList)
        {
          l = 0L;
        }
        if ((l > 0L) && (i > 0))
        {
          localUserTextInfo.text_uin.set(l);
          localUserTextInfo.text_id.set(i);
          paramList1.add(localUserTextInfo);
        }
      }
    }
  }
  
  public void a(List<String> paramList, BusinessObserver paramBusinessObserver)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("try fetchDiyTexts: ");
        ((StringBuilder)localObject).append(TextUtils.join(",", paramList));
        QLog.i("BubbleDiyHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new BubbleDiyComu.Bubble_Req_Comm();
      ((BubbleDiyComu.Bubble_Req_Comm)localObject).platform.set(109L);
      ((BubbleDiyComu.Bubble_Req_Comm)localObject).osver.set(Build.VERSION.RELEASE);
      ((BubbleDiyComu.Bubble_Req_Comm)localObject).mqqver.set("8.7.0");
      BubbleDiyComu.Bubble_GetDiyText_Req localBubble_GetDiyText_Req = new BubbleDiyComu.Bubble_GetDiyText_Req();
      ArrayList localArrayList = new ArrayList();
      b(paramList, localArrayList);
      if (localArrayList.isEmpty())
      {
        if (QLog.isColorLevel())
        {
          paramBusinessObserver = new StringBuilder();
          paramBusinessObserver.append("no diy id need request: ");
          paramBusinessObserver.append(TextUtils.join(",", paramList));
          QLog.i("BubbleDiyHandler", 2, paramBusinessObserver.toString());
        }
        return;
      }
      localBubble_GetDiyText_Req.user_text_info.set(localArrayList);
      paramList = new BubbleDiyComu.Bubble_Req();
      paramList.cmd.set(1);
      paramList.packet_seq.set(System.currentTimeMillis());
      paramList.comm.set((MessageMicro)localObject);
      paramList.reqcmd_0x01.set(localBubble_GetDiyText_Req);
      paramBusinessObserver = super.createToServiceMsg("bubble.1", paramBusinessObserver);
      paramBusinessObserver.putWupBuffer(paramList.toByteArray());
      super.sendPbReq(paramBusinessObserver);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("bubble.1"))
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      String str = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("keySeq=");
        localStringBuilder.append(str);
        localStringBuilder.append(" isSuccess=");
        localStringBuilder.append(bool);
        localStringBuilder.append(" resultCode=");
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        QLog.d("BubbleDiyHandler", 2, localStringBuilder.toString());
      }
      if (bool) {
        paramFromServiceMsg = new BubbleDiyComu.Bubble_Rsp();
      }
    }
    try
    {
      paramFromServiceMsg = (BubbleDiyComu.Bubble_Rsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (Exception paramFromServiceMsg)
    {
      label141:
      break label141;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleDiyHandler", 2, "DiyText bubbleRsp is null 业务回包 异常");
    }
    paramFromServiceMsg = null;
    if (paramFromServiceMsg != null)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    super.notifyUI(paramToServiceMsg, 1, false, null);
    return;
    super.notifyUI(paramToServiceMsg, 1, false, null);
    if (QLog.isColorLevel())
    {
      QLog.d("BubbleDiyHandler", 2, "DiyText isSuccess is false sso通道  异常");
      return;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("BubbleDiyHandler", 2, paramToServiceMsg.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyHandler
 * JD-Core Version:    0.7.0.1
 */
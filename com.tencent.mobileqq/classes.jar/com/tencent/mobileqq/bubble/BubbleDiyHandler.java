package com.tencent.mobileqq.bubble;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public BubbleDiyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("bubble.1"))
    {
      bool = paramFromServiceMsg.isSuccess();
      localObject = String.valueOf(paramToServiceMsg.getAttribute("_tag_LOGSTR"));
      if (QLog.isColorLevel()) {
        QLog.d("BubbleDiyHandler", 2, "key_seq=" + (String)localObject + " isSuccess=" + bool + " resultCode=" + paramFromServiceMsg.getResultCode());
      }
      if (bool) {
        paramFromServiceMsg = new BubbleDiyComu.Bubble_Rsp();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          boolean bool;
          paramFromServiceMsg = (BubbleDiyComu.Bubble_Rsp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg != null) {
            if (paramFromServiceMsg.ret.get() != 0L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BubbleDiyHandler", 2, "DiyText...fetch key 回包 sso 成功 ，server 失败，ret = " + paramFromServiceMsg.ret.get());
              }
              super.a(paramToServiceMsg, 1, false, null);
              return;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          Object localObject;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BubbleDiyHandler", 2, "DiyText bubble_Rsp is null 业务回包 异常");
            }
            paramFromServiceMsg = null;
          }
          if ((paramFromServiceMsg.rspcmd_0x01.has()) && (paramFromServiceMsg.rspcmd_0x01.user_text_info.has()))
          {
            paramObject = paramFromServiceMsg.rspcmd_0x01.user_text_info.get();
            paramFromServiceMsg = new ArrayList();
            if (paramObject != null)
            {
              paramObject = paramObject.iterator();
              while (paramObject.hasNext())
              {
                localObject = (BubbleDiyComu.UserTextInfo)paramObject.next();
                if ((((BubbleDiyComu.UserTextInfo)localObject).text.has()) && (((BubbleDiyComu.UserTextInfo)localObject).text_uin.has()) && (((BubbleDiyComu.UserTextInfo)localObject).text_id.has()))
                {
                  try
                  {
                    JSONObject localJSONObject = new JSONObject(((BubbleDiyComu.UserTextInfo)localObject).text.get());
                    BubbleDiyEntity localBubbleDiyEntity = new BubbleDiyEntity();
                    localBubbleDiyEntity.uinAndDiyId = (((BubbleDiyComu.UserTextInfo)localObject).text_uin.get() + "_" + ((BubbleDiyComu.UserTextInfo)localObject).text_id.get());
                    localBubbleDiyEntity.diyText = localJSONObject.optString("diyText");
                    localBubbleDiyEntity.bottomLeftId = localJSONObject.optString("bl");
                    localBubbleDiyEntity.bottomRightId = localJSONObject.optString("br");
                    localBubbleDiyEntity.topLeftId = localJSONObject.optString("tl");
                    localBubbleDiyEntity.topRightId = localJSONObject.optString("tr");
                    paramFromServiceMsg.add(localBubbleDiyEntity);
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.i("BubbleDiyHandler", 2, "onReceive: uinAndDiyId: " + localBubbleDiyEntity.uinAndDiyId + ",config: " + ((BubbleDiyComu.UserTextInfo)localObject).text.get());
                  }
                  catch (Exception localException) {}
                  if (QLog.isColorLevel()) {
                    QLog.e("BubbleDiyHandler", 2, "", localException);
                  }
                }
              }
            }
            BubbleDiyFetcher.a().a(this.b, true, paramFromServiceMsg);
            super.a(paramToServiceMsg, 1, true, paramFromServiceMsg);
            return;
          }
          super.a(paramToServiceMsg, 1, false, null);
          return;
        }
        super.a(paramToServiceMsg, 1, false, null);
        return;
        super.a(paramToServiceMsg, 1, false, null);
      } while (!QLog.isColorLevel());
      QLog.d("BubbleDiyHandler", 2, "DiyText isSuccess is false sso通道  异常");
      return;
    }
    QLog.d("BubbleDiyHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(List paramList, BusinessObserver paramBusinessObserver)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    BubbleDiyComu.Bubble_Req_Comm localBubble_Req_Comm;
    BubbleDiyComu.Bubble_GetDiyText_Req localBubble_GetDiyText_Req;
    ArrayList localArrayList;
    label255:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyHandler", 2, "try fetchDiyTexts: " + TextUtils.join(",", paramList));
      }
      localBubble_Req_Comm = new BubbleDiyComu.Bubble_Req_Comm();
      localBubble_Req_Comm.platform.set(109L);
      localBubble_Req_Comm.osver.set(Build.VERSION.RELEASE);
      localBubble_Req_Comm.mqqver.set("7.6.3");
      localBubble_GetDiyText_Req = new BubbleDiyComu.Bubble_GetDiyText_Req();
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label255;
        }
        Object localObject = (String)localIterator.next();
        BubbleDiyComu.UserTextInfo localUserTextInfo = new BubbleDiyComu.UserTextInfo();
        localObject = ((String)localObject).split("_");
        long l1 = 0L;
        if (localObject.length == 2) {}
        try
        {
          long l2 = Long.parseLong(localObject[0]);
          l1 = l2;
          i = Integer.parseInt(localObject[1]);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            QLog.e("BubbleDiyHandler", 1, "", localNumberFormatException);
            int i = 0;
          }
        }
        if ((l1 > 0L) && (i > 0))
        {
          localUserTextInfo.text_uin.set(l1);
          localUserTextInfo.text_id.set(i);
          localArrayList.add(localUserTextInfo);
        }
      }
      if (!localArrayList.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BubbleDiyHandler", 2, "no diy id need request: " + TextUtils.join(",", paramList));
    return;
    localBubble_GetDiyText_Req.user_text_info.set(localArrayList);
    paramList = new BubbleDiyComu.Bubble_Req();
    paramList.cmd.set(1);
    paramList.packet_seq.set(System.currentTimeMillis());
    paramList.comm.set(localBubble_Req_Comm);
    paramList.reqcmd_0x01.set(localBubble_GetDiyText_Req);
    paramBusinessObserver = super.a("bubble.1", paramBusinessObserver);
    paramBusinessObserver.putWupBuffer(paramList.toByteArray());
    super.b(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyHandler
 * JD-Core Version:    0.7.0.1
 */
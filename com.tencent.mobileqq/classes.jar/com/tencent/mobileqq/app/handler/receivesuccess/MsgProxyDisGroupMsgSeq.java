package com.tencent.mobileqq.app.handler.receivesuccess;

import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.stConfNumInfo;
import QQService.DiscussInfo;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import RegisterProxySvcPack.stDisGroupInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class MsgProxyDisGroupMsgSeq
{
  @Deprecated
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      long l = System.currentTimeMillis();
      SvcResponsePullDisGroupSeq localSvcResponsePullDisGroupSeq = (SvcResponsePullDisGroupSeq)paramObject;
      StringBuilder localStringBuilder = new StringBuilder(256);
      if (QLog.isColorLevel()) {
        localStringBuilder.append("registerproxy->handleMsgProxyDisGroupMsgSeq.");
      }
      boolean bool = paramFromServiceMsg.isSuccess();
      paramObject = null;
      int j = 0;
      if ((bool) && ((localSvcResponsePullDisGroupSeq == null) || (localSvcResponsePullDisGroupSeq.cReplyCode == 0)))
      {
        if (localSvcResponsePullDisGroupSeq != null)
        {
          DiscussionHandler localDiscussionHandler = (DiscussionHandler)paramMessageHandler.n.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
          paramObject = new SvcResponsePullDisMsgSeq();
          paramObject.cReplyCode = localSvcResponsePullDisGroupSeq.cReplyCode;
          paramObject.strResult = localSvcResponsePullDisGroupSeq.strResult;
          if (localSvcResponsePullDisGroupSeq.vDisInfo != null)
          {
            IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)paramMessageHandler.n.getRuntimeService(IPasswdRedBagService.class);
            HashMap localHashMap = new HashMap();
            paramObject.vConfNumInfo = new ArrayList();
            ArrayList localArrayList = new ArrayList();
            int i = j;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append(", size=");
              localStringBuilder.append(localSvcResponsePullDisGroupSeq.vDisInfo.size());
              i = j;
            }
            while (i < localSvcResponsePullDisGroupSeq.vDisInfo.size())
            {
              stDisGroupInfo localstDisGroupInfo = (stDisGroupInfo)localSvcResponsePullDisGroupSeq.vDisInfo.get(i);
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\nlDisCode=");
                localStringBuilder.append(localstDisGroupInfo.lDisCode);
                localStringBuilder.append(", eInfoFlag=");
                localStringBuilder.append(localstDisGroupInfo.eInfoFlag);
                localStringBuilder.append(", infoSeq=");
                localStringBuilder.append(localstDisGroupInfo.uInfoSeq);
              }
              j = localstDisGroupInfo.eInfoFlag;
              if ((j != -1) && (j != 0) && (j != 1)) {
                if ((j != 2) && (j != 3))
                {
                  if (j != 4) {
                    break label484;
                  }
                }
                else
                {
                  localDiscussionHandler.a(String.valueOf(localstDisGroupInfo.lDisCode));
                  break label484;
                }
              }
              Object localObject = new stConfNumInfo();
              ((stConfNumInfo)localObject).lConfUin = localstDisGroupInfo.lDisCode;
              ((stConfNumInfo)localObject).uConfMsgSeq = localstDisGroupInfo.uDisMsgSeq;
              ((stConfNumInfo)localObject).uMemberMsgSeq = localstDisGroupInfo.uMemberMsgSeq;
              paramObject.vConfNumInfo.add(localObject);
              localObject = new DiscussInfo();
              ((DiscussInfo)localObject).DiscussUin = localstDisGroupInfo.lDisCode;
              ((DiscussInfo)localObject).InfoSeq = localstDisGroupInfo.uInfoSeq;
              localArrayList.add(localObject);
              if (localstDisGroupInfo.lRedPackTime > 0L) {
                localHashMap.put(String.valueOf(localstDisGroupInfo.lDisCode), String.valueOf(localstDisGroupInfo.lRedPackTime));
              }
              label484:
              i += 1;
            }
            localIPasswdRedBagService.saveDisGroupInfos(localHashMap);
            localDiscussionHandler.a(localArrayList);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        }
        paramMessageHandler.f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        MsgAutoMonitorUtil.getInstance().addProxySeqTime_Dis(System.currentTimeMillis() - l);
        return;
      }
      paramMessageHandler.notifyUI(1000, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MsgProxyDisGroupMsgSeq
 * JD-Core Version:    0.7.0.1
 */
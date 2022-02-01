package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.ReqBody;
import tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.RspBody;
import tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.RspBody.WordsOfCut;

public class GlobalSearchHandler
  extends BusinessHandler
{
  public GlobalSearchHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("mq_kandian_svc_sentences");
    paramObject = new HashMap();
    paramObject.put("mq_kandian_svc_sentences", paramToServiceMsg);
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new MQKanDianSvc0x001.RspBody();
      try
      {
        paramToServiceMsg = (MQKanDianSvc0x001.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (paramToServiceMsg.int32_error_num.get() != 0)
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleSvcSeg error, errorNum: ");
            paramFromServiceMsg.append(paramToServiceMsg.int32_error_num.get());
            QLog.w("Q.groupsearch", 2, paramFromServiceMsg.toString());
          }
          notifyUI(1, false, paramObject);
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_words.get();
        if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
        {
          paramToServiceMsg = new ArrayList();
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          while (paramFromServiceMsg.hasNext())
          {
            localObject = ((MQKanDianSvc0x001.RspBody.WordsOfCut)((MQKanDianSvc0x001.RspBody.WordsOfCut)paramFromServiceMsg.next()).get()).rpt_str_words.get();
            ArrayList localArrayList = new ArrayList();
            localArrayList.addAll((Collection)localObject);
            paramToServiceMsg.add(localArrayList);
          }
          paramObject.put("mq_kandian_svc_results", paramToServiceMsg);
          notifyUI(1, true, paramObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.groupsearch", 2, "handleSvcSeg error, msgWords is empty...");
        }
        notifyUI(1, false, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.w("Q.groupsearch", 2, "handleSvcSeg error: ", paramToServiceMsg);
        }
        notifyUI(1, false, paramObject);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSvcSeg error, resultCode: ");
      if (paramFromServiceMsg != null) {
        paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());
      } else {
        paramToServiceMsg = "null";
      }
      ((StringBuilder)localObject).append(paramToServiceMsg);
      QLog.w("Q.groupsearch", 2, ((StringBuilder)localObject).toString());
    }
    if ((QLog.isColorLevel()) && (paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1002)) {
      QLog.w("Q.groupsearch", 2, "handleSvcSeg error, server segmentation timeout...");
    }
    notifyUI(1, false, paramObject);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject = new MQKanDianSvc0x001.ReqBody();
      ((MQKanDianSvc0x001.ReqBody)localObject).enum_cut_mode.set(0);
      ((MQKanDianSvc0x001.ReqBody)localObject).enum_request_mode.set(0);
      ((MQKanDianSvc0x001.ReqBody)localObject).bool_use_hmm.set(true);
      ((MQKanDianSvc0x001.ReqBody)localObject).uint32_request_article_num.set(0);
      ((MQKanDianSvc0x001.ReqBody)localObject).rpt_str_sentences.set(paramArrayList);
      ToServiceMsg localToServiceMsg = createToServiceMsg("MQKanDianSvc.0x001");
      localToServiceMsg.setTimeout(4500L);
      localToServiceMsg.putWupBuffer(((MQKanDianSvc0x001.ReqBody)localObject).toByteArray());
      localToServiceMsg.extraData.putInt("mq_kandian_svc_mode", 1);
      localToServiceMsg.extraData.putStringArrayList("mq_kandian_svc_sentences", paramArrayList);
      sendPbReq(localToServiceMsg);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSvcSeg sentences : ");
        ((StringBuilder)localObject).append(paramArrayList);
        QLog.i("Q.groupsearch", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.groupsearch", 2, "getSvcSeg sentences is empty...");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GlobalSearchObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(", serviceCmd: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", resultCode: ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.groupsearch", 2, localStringBuilder.toString());
    }
    if (("MQKanDianSvc.0x001".equals(str)) && (paramToServiceMsg.extraData.getInt("mq_kandian_svc_mode") == 1)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.GlobalSearchHandler
 * JD-Core Version:    0.7.0.1
 */
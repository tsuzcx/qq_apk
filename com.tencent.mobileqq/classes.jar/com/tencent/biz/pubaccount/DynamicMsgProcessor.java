package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class DynamicMsgProcessor
  extends C2CMessageProcessor
{
  public DynamicMsgProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  public ArrayList<MessageRecord> a(long paramLong, List<msg_comm.Msg> paramList)
  {
    paramList = b(paramLong, paramList);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList, true);
    paramList.clear();
    return localArrayList;
  }
  
  public void a(long paramLong, List<msg_comm.Msg> paramList)
  {
    paramList = a(paramLong, paramList);
    IPublicAccountManager localIPublicAccountManager;
    long l2;
    long l1;
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localIPublicAccountManager = (IPublicAccountManager)QRoute.api(IPublicAccountManager.class);
      l2 = localIPublicAccountManager.getMsgID(this.a, String.valueOf(paramLong));
      l1 = l2;
      if (l2 == 0L) {
        l1 = 9223372036854775807L;
      }
      localIterator = paramList.iterator();
    }
    for (;;)
    {
      String str;
      if (localIterator.hasNext())
      {
        str = ((MessageRecord)localIterator.next()).getExtInfoFromExtStr("pa_msgId");
        if (TextUtils.isEmpty(str)) {}
      }
      else
      {
        try
        {
          l2 = Long.parseLong(str);
          if ((l2 >= l1) || (l2 == 0L)) {
            continue;
          }
          localIPublicAccountManager.setMsgID(this.a, String.valueOf(paramLong), l2);
          l1 = l2;
        }
        catch (Exception localException) {}
        ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).addMessage(paramList, this.a.getCurrentAccountUin(), true);
        return;
      }
    }
  }
  
  public ArrayList<MessageRecord> b(long paramLong, List<msg_comm.Msg> paramList)
  {
    Object localObject1 = new ArrayList();
    a(paramList, (List)localObject1);
    paramList = new ArrayList();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(this.a.getLongAccountUin(), paramLong, true, true, false, false);
    localDecodeProtoPkgContext.h = true;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (msg_comm.Msg)((Iterator)localObject1).next();
      try
      {
        localObject2 = a((msg_comm.Msg)localObject2, localDecodeProtoPkgContext);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          continue;
        }
        paramList.addAll((Collection)localObject2);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.w("DynamicMsgProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.DynamicMsgProcessor
 * JD-Core Version:    0.7.0.1
 */
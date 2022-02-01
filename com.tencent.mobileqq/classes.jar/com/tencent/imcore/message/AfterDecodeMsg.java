package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.messageprocessor.LastC2CBubbleID;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.model.CommercialDrainageManagerConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AfterDecodeMsg
{
  private ArrayList<MessageRecord> a;
  private long b;
  private long c;
  private List<MessageRecord> d;
  private C2CMessageProcessor e;
  private DecodeProtoPkgContext f;
  
  public AfterDecodeMsg(C2CMessageProcessor paramC2CMessageProcessor, ArrayList<MessageRecord> paramArrayList, long paramLong1, long paramLong2, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    this.a = paramArrayList;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramList;
    this.e = paramC2CMessageProcessor;
    this.f = paramDecodeProtoPkgContext;
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2002)
    {
      b(paramLong1, paramLong2, paramLong3, paramLong4, paramMessageRecord);
      return;
    }
    paramMessageRecord.vipBubbleID = 0L;
  }
  
  private void a(MessageForPtt paramMessageForPtt1, MessageForPtt paramMessageForPtt2, C2CMessageProcessor paramC2CMessageProcessor)
  {
    boolean bool;
    if ((paramMessageForPtt1.getPttStreamFlag() == 10001) && (!TextUtils.isEmpty(paramMessageForPtt2.directUrl)) && (TextUtils.isEmpty(paramMessageForPtt1.directUrl))) {
      try
      {
        paramMessageForPtt1.directUrl = paramMessageForPtt2.directUrl;
        paramMessageForPtt1.serial();
        ((IMessageFacade)paramC2CMessageProcessor.q.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
        bool = true;
      }
      catch (Exception paramMessageForPtt1)
      {
        paramMessageForPtt1.printStackTrace();
      }
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForPtt1 = new StringBuilder();
      paramMessageForPtt1.append("updateStreamPttDirectUrl : ");
      paramMessageForPtt1.append(bool);
      QLog.d("Q.msg.C2CMessageProcessor", 2, paramMessageForPtt1.toString());
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == -2002)
    {
      if ((!paramBoolean) && (((IStreamDataManager)QRoute.api(IStreamDataManager.class)).getStreamFileInfoEntryByMsg(paramMessageRecord.msgUid, paramMessageRecord.shmsgseq) != null)) {
        PttInfoCollector.reportPttDownloadStream2Offline(true);
      }
      if ((paramBoolean) && ((paramMessageRecord instanceof MessageForPtt)) && (UinTypeUtil.b(paramMessageRecord.istroop)))
      {
        Iterator localIterator = ((IMessageFacade)this.e.q.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop).iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (((localMessageRecord instanceof MessageForPtt)) && (localMessageRecord.msgUid == paramMessageRecord.msgUid) && (localMessageRecord.shmsgseq == paramMessageRecord.shmsgseq)) {
            a((MessageForPtt)localMessageRecord, (MessageForPtt)paramMessageRecord, this.e);
          }
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      b(paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForMarketFace)) {
        CommercialDrainageManagerConstants.a(this.e.q, (MessageForMarketFace)paramMessageRecord);
      }
      if (AppConstants.NEW_KANDIAN_UIN.equals(paramMessageRecord.frienduin)) {
        paramMessageRecord.time = NetConnInfoCenter.getServerTime();
      }
      if (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessageRecord.frienduin)) {
        ((IKandianDailyManagerService)((QQAppInterface)this.e.q).getRuntimeService(IKandianDailyManagerService.class)).onReceiveKandianDailyMsg(paramMessageRecord);
      }
      paramArrayList.add(paramMessageRecord);
      int i = ((IKanDianMergeManager)((QQAppInterface)this.e.q).getRuntimeService(IKanDianMergeManager.class)).getMsgFromSource(paramMessageRecord);
      if ((i == 0) || (i == 1))
      {
        paramMessageRecord = ((IKanDianMergeManager)((QQAppInterface)this.e.q).getRuntimeService(IKanDianMergeManager.class)).createFakeFromNewMsg(paramMessageRecord);
        if (paramMessageRecord != null) {
          paramArrayList.add(paramMessageRecord);
        }
      }
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    return ((MessageCache)this.e.q.getMsgCache()).c(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, MessageRecord paramMessageRecord)
  {
    if (MessageRecordInfo.b(paramMessageRecord.issend))
    {
      if (paramLong2 != -1L)
      {
        paramMessageRecord.vipBubbleID = paramLong2;
        return;
      }
      paramMessageRecord.vipBubbleID = LastC2CBubbleID.a(this.e.q, String.valueOf(paramLong4), String.valueOf(paramLong3));
      return;
    }
    if (paramLong1 != -1L)
    {
      paramMessageRecord.vipBubbleID = paramLong1;
      return;
    }
    paramMessageRecord.vipBubbleID = LastC2CBubbleID.a(this.e.q, String.valueOf(paramLong4), String.valueOf(paramLong3));
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.isPALongMsg(paramMessageRecord)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramMessageRecord))))
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
      if ((str == null) || (!String.valueOf(3).equals(str)))
      {
        paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
        StructLongMessageDownloadProcessor.getStructLongMessage(this.e.q, paramMessageRecord);
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramMessageRecord.istroop == 1008)) {
      PublicAccountEventReport.a(this.e.q, paramMessageRecord);
    }
  }
  
  public AfterDecodeMsg a()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      long l = localMessageRecord.vipBubbleID;
      if (l != -1L)
      {
        if (MessageRecordInfo.b(localMessageRecord.issend)) {
          this.f.s = l;
        } else {
          this.f.r = l;
        }
      }
      else {
        a(this.f.r, this.f.s, this.b, this.c, localMessageRecord);
      }
      this.f.u = localMessageRecord.istroop;
      boolean bool1 = this.e.a(localMessageRecord, true);
      boolean bool2 = a(localMessageRecord);
      a(this.a, localMessageRecord, bool1, bool2);
      a(localMessageRecord, bool1);
      b(localMessageRecord, bool1);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.AfterDecodeMsg
 * JD-Core Version:    0.7.0.1
 */
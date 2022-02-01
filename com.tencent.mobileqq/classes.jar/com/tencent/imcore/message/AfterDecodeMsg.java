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
  private long jdField_a_of_type_Long;
  private C2CMessageProcessor jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor;
  private DecodeProtoPkgContext jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private long b;
  
  public AfterDecodeMsg(C2CMessageProcessor paramC2CMessageProcessor, ArrayList<MessageRecord> paramArrayList, long paramLong1, long paramLong2, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor = paramC2CMessageProcessor;
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext = paramDecodeProtoPkgContext;
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
        ((IMessageFacade)paramC2CMessageProcessor.a.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
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
  
  private void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.isPALongMsg(paramMessageRecord)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramMessageRecord))))
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("longMsg_State");
      if ((str == null) || (!String.valueOf(3).equals(str)))
      {
        paramMessageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
        StructLongMessageDownloadProcessor.getStructLongMessage(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a, paramMessageRecord);
      }
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
        Iterator localIterator = ((IMessageFacade)this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop).iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (((localMessageRecord instanceof MessageForPtt)) && (localMessageRecord.msgUid == paramMessageRecord.msgUid) && (localMessageRecord.shmsgseq == paramMessageRecord.shmsgseq)) {
            a((MessageForPtt)localMessageRecord, (MessageForPtt)paramMessageRecord, this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor);
          }
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      a(paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForMarketFace)) {
        CommercialDrainageManagerConstants.a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a, (MessageForMarketFace)paramMessageRecord);
      }
      if (AppConstants.NEW_KANDIAN_UIN.equals(paramMessageRecord.frienduin)) {
        paramMessageRecord.time = NetConnInfoCenter.getServerTime();
      }
      if (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessageRecord.frienduin)) {
        ((IKandianDailyManagerService)((QQAppInterface)this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a).getRuntimeService(IKandianDailyManagerService.class)).onReceiveKandianDailyMsg(paramMessageRecord);
      }
      paramArrayList.add(paramMessageRecord);
      int i = ((IKanDianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a).getRuntimeService(IKanDianMergeManager.class)).getMsgFromSource(paramMessageRecord);
      if ((i == 0) || (i == 1))
      {
        paramMessageRecord = ((IKanDianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a).getRuntimeService(IKanDianMergeManager.class)).createFakeFromNewMsg(paramMessageRecord);
        if (paramMessageRecord != null) {
          paramArrayList.add(paramMessageRecord);
        }
      }
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    return ((MessageCache)this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a.getMsgCache()).a(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, MessageRecord paramMessageRecord)
  {
    if (MessageRecordInfo.a(paramMessageRecord.issend))
    {
      if (paramLong2 != -1L)
      {
        paramMessageRecord.vipBubbleID = paramLong2;
        return;
      }
      paramMessageRecord.vipBubbleID = LastC2CBubbleID.a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a, String.valueOf(paramLong4), String.valueOf(paramLong3));
      return;
    }
    if (paramLong1 != -1L)
    {
      paramMessageRecord.vipBubbleID = paramLong1;
      return;
    }
    paramMessageRecord.vipBubbleID = LastC2CBubbleID.a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a, String.valueOf(paramLong4), String.valueOf(paramLong3));
  }
  
  private void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramMessageRecord.istroop == 1008)) {
      PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a, paramMessageRecord);
    }
  }
  
  public AfterDecodeMsg a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      long l = localMessageRecord.vipBubbleID;
      if (l != -1L)
      {
        if (MessageRecordInfo.a(localMessageRecord.issend)) {
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.f = l;
        } else {
          this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.jdField_e_of_type_Long = l;
        }
      }
      else {
        a(this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.jdField_e_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.f, this.jdField_a_of_type_Long, this.b, localMessageRecord);
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageDecodeProtoPkgContext.jdField_e_of_type_Int = localMessageRecord.istroop;
      boolean bool1 = this.jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor.a(localMessageRecord, true);
      boolean bool2 = a(localMessageRecord);
      a(this.jdField_a_of_type_JavaUtilArrayList, localMessageRecord, bool1, bool2);
      a(localMessageRecord, bool1);
      b(localMessageRecord, bool1);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.AfterDecodeMsg
 * JD-Core Version:    0.7.0.1
 */
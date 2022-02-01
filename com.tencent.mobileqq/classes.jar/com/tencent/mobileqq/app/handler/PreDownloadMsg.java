package com.tencent.mobileqq.app.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class PreDownloadMsg
{
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject = (MessageForStructing)paramMessageRecord;
    if (((MessageForStructing)localObject).structingMsg == null) {
      return;
    }
    if ((!paramMessageRecord.isread) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 38) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mResid)))
    {
      VipGiftManager localVipGiftManager = (VipGiftManager)paramQQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      boolean bool = localVipGiftManager.a((MessageForStructing)localObject);
      localObject = localVipGiftManager.e();
      if ((bool) && (paramQQAppInterface.mAutomator != null) && (paramQQAppInterface.mAutomator.h()) && (localObject != null) && (((VipGiftDownloadInfo)localObject).f == 0L) && (((VipGiftDownloadInfo)localObject).c != 0L)) {
        localVipGiftManager.c(((VipGiftDownloadInfo)localObject).c);
      }
    }
    else if (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 35)
    {
      MultiMsgManager.a().a((MessageForStructing)localObject, paramQQAppInterface);
    }
    else if (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 107)
    {
      MultiMsgManager.a().a((MessageForStructing)localObject, paramQQAppInterface);
    }
    ((IPicPreDownload)paramQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromMsg(paramMessageRecord, 1);
  }
  
  public static void a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    if ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg)))
    {
      if ((paramMessageRecord instanceof MessageForShortVideo)) {
        paramAppInterface.getShortVideoPredownloer().a((MessageForShortVideo)paramMessageRecord);
      } else if ((paramMessageRecord instanceof MessageForPtt)) {
        b(paramAppInterface, paramMessageRecord);
      } else if (((paramMessageRecord instanceof MessageForLongTextMsg)) && (paramMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
        c(paramAppInterface, paramMessageRecord);
      } else if ((paramMessageRecord instanceof MessageForScribble)) {
        ((IScribbleDownloader)paramAppInterface.getRuntimeService(IScribbleDownloader.class)).PreDownloadFromMsg((MessageForScribble)paramMessageRecord);
      }
    }
    else {
      ((IPicPreDownload)paramAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromMsg(paramMessageRecord, 3);
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {
      a(paramAppInterface, paramMessageRecord);
    }
  }
  
  public static void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, AppInterface paramAppInterface)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((MessageRecord)paramArrayList.next(), paramAppInterface);
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    ((IPTTPreDownloader)paramQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onReceivedPTTMsg((MessageForPtt)paramMessageRecord);
    int i;
    if (paramMessageRecord.istroop == 0) {
      i = 1;
    } else if (paramMessageRecord.istroop == 1) {
      i = 3;
    } else if (paramMessageRecord.istroop == 3000) {
      i = 2;
    } else {
      i = 4;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPTTPV(paramQQAppInterface, i, false, 3);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    ((MessageForLongTextMsg)paramMessageRecord).loading = true;
    String str = paramMessageRecord.getExtInfoFromExtStr("long_text_msg_resid");
    if (TextUtils.isEmpty(str)) {
      QLog.e("Q.msg.MessageHandler", 1, "LongTextMsg resid is null!");
    }
    LongTextMsgManager.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.PreDownloadMsg
 * JD-Core Version:    0.7.0.1
 */
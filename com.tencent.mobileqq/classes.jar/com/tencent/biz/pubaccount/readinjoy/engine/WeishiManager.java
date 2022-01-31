package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.List;
import lmx;
import lmy;
import mqq.manager.Manager;

public class WeishiManager
  implements Manager
{
  private QQAppInterface a;
  
  public WeishiManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString, long paramLong)
  {
    if (this.a == null) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.a.getCurrentAccountUin();
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.aH;
    paramMessageRecord.senderuin = AppConstants.aH;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.createMessageUniseq();
  }
  
  public MessageForStructing a()
  {
    if ((this.a == null) || (this.a.a() == null) || (this.a.a().a() == null)) {
      return null;
    }
    if (this.a.a().a().a(AppConstants.aH, 1008) > 0)
    {
      MessageRecord localMessageRecord = this.a.a().b(AppConstants.aH, 1008);
      if ((localMessageRecord instanceof MessageForStructing)) {
        return (MessageForStructing)localMessageRecord;
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((a() != null) && (a().structingMsg != null) && (!TextUtils.isEmpty(a().structingMsg.mMsgActionData))) {
      return a().structingMsg.mMsgActionData;
    }
    return "";
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a == null) || (this.a.a() == null) || (this.a.a().a() == null)) {
      return null;
    }
    if (this.a.a().a().a(AppConstants.aH, 1008) > 0)
    {
      Object localObject = this.a.a().b(AppConstants.aH, 1008);
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)localObject;
        if ((((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mArticleIds)))
        {
          localObject = ((MessageForStructing)localObject).structingMsg.mArticleIds.split("\\|");
          int i = 0;
          while (i < localObject.length)
          {
            localArrayList.add(Long.valueOf(localObject[i]));
            i += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.a.a();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).a();
    } while ((localObject == null) || (((ConversationFacade)localObject).a(AppConstants.aH, 1008) <= 0));
    ThreadManager.post(new lmx(this), 8, null, false);
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a == null)) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQMessageFacade = this.a.a();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new lmy(this, localQQMessageFacade, paramString, paramLong), 10, null, false);
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager
 * JD-Core Version:    0.7.0.1
 */
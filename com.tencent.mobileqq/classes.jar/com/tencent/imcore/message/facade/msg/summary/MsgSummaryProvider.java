package com.tencent.imcore.message.facade.msg.summary;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

public class MsgSummaryProvider
  implements Provider<Map<Integer, IMsgSummaryCreator<QQMessageFacade, QQAppInterface>>>
{
  private final Map<Integer, IMsgSummaryCreator<QQMessageFacade, QQAppInterface>> a = new MsgSummaryProvider.1(this);
  
  public static MsgSummary a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    try
    {
      if ((paramQQMessageFacade.a(localMessage.istroop) instanceof TroopMessageManager))
      {
        if (TextUtils.isEmpty(ContactUtils.b(paramQQAppInterface, localMessage.frienduin, localMessage.senderuin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgSummaryProvider", 2, "getMsgSummaryStrForTroop nickname is null");
          }
          localMessage.isFromLS = true;
          paramQQMessageFacade.a(localMessage);
          localMessage.isFromLS = false;
          ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(paramQQAppInterface, ((QQLSActivity)paramContext).a, localMessage.senderuin, localMessage.frienduin));
        }
        else
        {
          paramQQMessageFacade.a(localMessage);
        }
      }
      else {
        paramQQMessageFacade.a(localMessage);
      }
    }
    catch (Throwable paramQQMessageFacade)
    {
      paramQQMessageFacade.printStackTrace();
    }
    paramQQMessageFacade = new MsgSummary();
    MsgUtils.a(paramContext, paramQQAppInterface, localMessage, localMessage.istroop, paramQQMessageFacade, localMessage.nickName, false, paramBoolean);
    return paramQQMessageFacade;
  }
  
  public Map<Integer, IMsgSummaryCreator<QQMessageFacade, QQAppInterface>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.summary.MsgSummaryProvider
 * JD-Core Version:    0.7.0.1
 */
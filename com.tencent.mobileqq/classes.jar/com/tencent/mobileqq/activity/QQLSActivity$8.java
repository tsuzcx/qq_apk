package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class QQLSActivity$8
  extends MessageObserver
{
  QQLSActivity$8(QQLSActivity paramQQLSActivity) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMsgRevokeNotice isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean1);
      QLog.d("MsgRevoke", 4, ((StringBuilder)localObject1).toString());
    }
    this.a.v.removeMessages(267387140);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onMsgRevokeNotice chatlist=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.d("MsgRevoke", 4, ((StringBuilder)localObject2).toString());
    }
    if ((paramBoolean1) && (!((List)localObject1).isEmpty()) && (((ChatMessage)((List)localObject1).get(0) instanceof MessageForPtt)))
    {
      localObject1 = (MessageForPtt)((List)localObject1).get(0);
      localObject2 = MediaPlayerManager.a(QQLSActivity.i(this.a)).f();
      if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).frienduin != null) && (((ChatMessage)localObject2).frienduin.equals(((MessageForPtt)localObject1).frienduin)) && (((ChatMessage)localObject2).uniseq == ((MessageForPtt)localObject1).uniseq))) {
        MediaPlayerManager.a(QQLSActivity.i(this.a)).a(true);
      }
    }
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.8
 * JD-Core Version:    0.7.0.1
 */
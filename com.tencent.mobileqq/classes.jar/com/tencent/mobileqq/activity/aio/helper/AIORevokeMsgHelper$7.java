package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class AIORevokeMsgHelper$7
  extends MessageObserver
{
  AIORevokeMsgHelper$7(AIORevokeMsgHelper paramAIORevokeMsgHelper) {}
  
  public void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString) {}
  
  public void onMsgForwardWXResult(int paramInt)
  {
    if ((AIORevokeMsgHelper.c(this.a).a == 0) || (AIORevokeMsgHelper.c(this.a).a == 3000) || (AIORevokeMsgHelper.c(this.a).a == 1)) {
      AIORevokeMsgHelper.a(this.a, paramInt);
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMsgRevokeNotice isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean1);
      QLog.d("MsgRevoke", 4, ((StringBuilder)localObject1).toString());
    }
    boolean bool = AIORevokeMsgHelper.b(this.a).getMsgCache().D();
    AIORevokeMsgHelper.d(this.a).j().removeMessages(267387140);
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
    AIORevokeMsgHelper.a(this.a, paramBoolean1, paramBoolean2, bool, (List)localObject1);
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.7
 * JD-Core Version:    0.7.0.1
 */
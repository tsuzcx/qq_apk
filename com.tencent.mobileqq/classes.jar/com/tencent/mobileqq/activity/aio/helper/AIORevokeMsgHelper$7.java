package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  
  public void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORevokeMsgHelper", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((AIORevokeMsgHelper.a(this.a) == null) || (AIORevokeMsgHelper.a(this.a) == null) || (!paramBoolean)) {
      return;
    }
    ((ApolloGameManager)AIORevokeMsgHelper.a(this.a).getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(3, AIORevokeMsgHelper.a(this.a).jdField_a_of_type_JavaLangString, AIORevokeMsgHelper.a(this.a).jdField_a_of_type_Int);
  }
  
  public void onMsgForwardWXResult(int paramInt)
  {
    if ((AIORevokeMsgHelper.a(this.a).jdField_a_of_type_Int == 0) || (AIORevokeMsgHelper.a(this.a).jdField_a_of_type_Int == 3000) || (AIORevokeMsgHelper.a(this.a).jdField_a_of_type_Int == 1)) {
      AIORevokeMsgHelper.a(this.a, paramInt);
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = AIORevokeMsgHelper.a(this.a).getMsgCache().e();
    AIORevokeMsgHelper.a(this.a).a().removeMessages(267387140);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)localIterator.next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + localArrayList.size());
    }
    AIORevokeMsgHelper.a(this.a, paramBoolean1, paramBoolean2, bool, localArrayList);
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.7
 * JD-Core Version:    0.7.0.1
 */
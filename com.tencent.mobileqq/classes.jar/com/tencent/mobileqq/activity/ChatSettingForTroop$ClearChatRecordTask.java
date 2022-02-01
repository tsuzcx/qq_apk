package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class ChatSettingForTroop$ClearChatRecordTask
  implements Runnable
{
  WeakReference<ChatSettingForTroop> a;
  
  public ChatSettingForTroop$ClearChatRecordTask(ChatSettingForTroop paramChatSettingForTroop)
  {
    this.a = new WeakReference(paramChatSettingForTroop);
  }
  
  public void run()
  {
    try
    {
      localChatSettingForTroop = (ChatSettingForTroop)this.a.get();
      if (localChatSettingForTroop == null) {
        return;
      }
      if (localChatSettingForTroop.c) {
        return;
      }
      localObject1 = localChatSettingForTroop.app;
      str = localChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      localObject2 = new StringBuilder();
      i = TroopUtils.a((QQAppInterface)localObject1, str, 1, (StringBuilder)localObject2);
      List localList = ((QQAppInterface)localObject1).getMessageFacade().b(str, 1);
      if ((localList == null) || (localList.isEmpty())) {
        break label378;
      }
      l1 = ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Object localObject1;
        long l1;
        try
        {
          ChatSettingForTroop localChatSettingForTroop;
          String str;
          int i;
          long l2 = Long.parseLong(((StringBuilder)localObject2).toString());
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            ((QQAppInterface)localObject1).getMsgCache().a(str, 1, l1);
          }
          if (!((TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER)).b(str)) {
            break label336;
          }
          FriendsStatusUtil.a((QQAppInterface)localObject1, str, 1);
          ((QQAppInterface)localObject1).getMessageFacade().a(str, 1, true, false);
          ((QQAppInterface)localObject1).getMessageFacade().e(str, 1);
          ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask((QQAppInterface)localObject1, "chat_history_confirm_del_msg");
          localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
          Object localObject2 = ((MqqHandler)localObject1).obtainMessage(1017);
          ((Message)localObject2).obj = str;
          ((Message)localObject2).arg1 = 1;
          ((MqqHandler)localObject1).sendMessage((Message)localObject2);
          localChatSettingForTroop.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
          return;
        }
        catch (Exception localException)
        {
          QLog.e("Q.chatopttroop", 1, "ClearChatRecordTask parse seq fail.", localException);
          localIllegalStateException.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
          return;
        }
        localIllegalStateException = localIllegalStateException;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.chatopttroop", 2, "msg history clear,  IllegalStateException" + localIllegalStateException.toString());
        return;
        label336:
        ((QQAppInterface)localObject1).getMessageFacade().a(localException, 1);
        TroopAssistantManager.a().b(localException, (QQAppInterface)localObject1);
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.chatopttroop", 2, "msg history already clear!");
          continue;
          label378:
          l1 = 0L;
        }
      }
    }
    if (i > 0) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.ClearChatRecordTask
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.task;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import zbt;
import zbu;

public class ApolloMsgPlayController
{
  private static ApolloMsgPlayController a;
  public long a;
  public WeakReference a;
  
  private ApolloMsgPlayController()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static ApolloMsgPlayController a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController == null) {
        jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController = new ApolloMsgPlayController();
      }
      ApolloMsgPlayController localApolloMsgPlayController = jdField_a_of_type_ComTencentMobileqqApolloTaskApolloMsgPlayController;
      return localApolloMsgPlayController;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] app:" + paramQQAppInterface + "sessionInfo:" + paramSessionInfo);
    }
    if ((paramSessionInfo == null) || (paramQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] sessionInfo or app is null,return.");
      }
    }
    Object localObject1;
    List localList;
    int i;
    label164:
    MessageRecord localMessageRecord;
    label262:
    label329:
    boolean bool2;
    label393:
    label429:
    boolean bool1;
    do
    {
      do
      {
        return;
        localObject2 = (ApolloDaoManager)paramQQAppInterface.getManager(154);
        localObject1 = ((ApolloDaoManager)localObject2).a(paramSessionInfo);
        if (localObject1 != null)
        {
          ThreadManager.getSubThreadHandler().postDelayed(new zbt(this, paramQQAppInterface, (ApolloActionPush)localObject1), 500L);
          return;
        }
        localList = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, null, 5);
        if (localList.size() > 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] no message,return.");
      return;
      i = localList.size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)localList.get(i);
        if (!(localMessageRecord instanceof MessageForApollo)) {
          break label429;
        }
        localObject1 = (MessageForApollo)localMessageRecord;
        if ((i != localList.size() - 1) || (!ApolloGameUtil.a(((MessageForApollo)localObject1).msgType))) {
          break label262;
        }
        ApolloGameData localApolloGameData = ((ApolloDaoManager)localObject2).a(((MessageForApollo)localObject1).gameId);
        if ((localApolloGameData == null) || (!ApolloConfigUtils.a("7.6.8", localApolloGameData.minVer, localApolloGameData.maxVer))) {
          break label262;
        }
      }
      do
      {
        do
        {
          do
          {
            i -= 1;
            break label164;
            break;
            if ((((MessageForApollo)localObject1).hasPlayed) || (i == localList.size() - 1)) {
              break label393;
            }
            if (!ApolloGameUtil.a(((MessageForApollo)localObject1).msgType)) {
              break label329;
            }
            localObject1 = ((ApolloDaoManager)localObject2).a(((MessageForApollo)localObject1).gameId);
          } while ((localObject1 != null) && (ApolloConfigUtils.a("7.6.8", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer)));
          paramQQAppInterface = ((SpriteScriptManager)paramQQAppInterface.getManager(248)).a();
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(1, (MessageForApollo)localMessageRecord);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] play MessageForApollo:" + localMessageRecord.toString());
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] has already played MessageForApollo:" + localMessageRecord.toString());
          return;
        } while (((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) || ((paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)));
        localObject1 = new ArrayList();
        bool2 = ApolloUtil.a(paramQQAppInterface, paramSessionInfo, localMessageRecord, (List)localObject1);
      } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
      paramSessionInfo = localMessageRecord.getExtInfoFromExtStr("is_apollo_emoticon_action_played");
      if ((TextUtils.isEmpty(paramSessionInfo)) || (!"2".equals(paramSessionInfo))) {
        break;
      }
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] apollo emoticon action played=", Boolean.valueOf(bool1), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
      }
    } while ((bool1) || (i == localList.size() - 1));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionList=", localObject1 });
    }
    Object localObject2 = (ChatMessage)localMessageRecord;
    if (bool2) {}
    for (paramSessionInfo = (SessionInfo)localObject1;; paramSessionInfo = null)
    {
      a(paramQQAppInterface, (ChatMessage)localObject2, (ArrayList)localObject1, paramSessionInfo);
      localMessageRecord.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
      ThreadManager.post(new zbu(this, localMessageRecord), 5, null, false);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[playWhiteFace]");
    }
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    do
    {
      return;
      paramQQAppInterface = ((SpriteScriptManager)paramQQAppInterface.getManager(248)).a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramChatMessage, paramArrayList1, paramArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController
 * JD-Core Version:    0.7.0.1
 */
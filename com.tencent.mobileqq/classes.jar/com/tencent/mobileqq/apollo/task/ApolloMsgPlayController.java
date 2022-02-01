package com.tencent.mobileqq.apollo.task;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ApolloMsgPlayController
{
  private static ApolloMsgPlayController a;
  public long a;
  
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
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = localApolloDaoManagerServiceImpl.getActionPushDataByAIO(paramSessionInfo);
      if (localObject1 != null)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new ApolloMsgPlayController.1(this, paramQQAppInterface, (ApolloActionPush)localObject1), 500L);
        return;
      }
      localObject2 = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, null, 5);
      if (((List)localObject2).size() > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] no message,return.");
    return;
    int i = ((List)localObject2).size() - 1;
    label165:
    MessageRecord localMessageRecord;
    if (i >= 0)
    {
      localMessageRecord = (MessageRecord)((List)localObject2).get(i);
      if (!(localMessageRecord instanceof MessageForApollo)) {
        break label423;
      }
      localObject1 = (MessageForApollo)localMessageRecord;
      if ((i != ((List)localObject2).size() - 1) || (!ApolloGameUtil.a(((MessageForApollo)localObject1).msgType))) {
        break label263;
      }
      ApolloGameData localApolloGameData = localApolloDaoManagerServiceImpl.findGameById(((MessageForApollo)localObject1).gameId);
      if ((localApolloGameData == null) || (!ApolloConfigUtils.a("8.5.5", localApolloGameData.minVer, localApolloGameData.maxVer))) {
        break label263;
      }
    }
    label263:
    label360:
    label638:
    int j;
    label423:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              i -= 1;
              break label165;
              break;
              if ((((MessageForApollo)localObject1).hasPlayed) || (i == ((List)localObject2).size() - 1))
              {
                QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] has already played MessageForApollo:" + localMessageRecord.toString());
                return;
              }
              if (!ApolloGameUtil.a(((MessageForApollo)localObject1).msgType)) {
                break label360;
              }
              localObject1 = localApolloDaoManagerServiceImpl.findGameById(((MessageForApollo)localObject1).gameId);
            } while ((localObject1 != null) && (ApolloConfigUtils.a("8.5.5", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer)));
            paramQQAppInterface = ((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(1, (MessageForApollo)localMessageRecord);
            }
            QLog.d("ApolloMsgPlayController", 2, "[playUnreadAction] play MessageForApollo:" + localMessageRecord.toString());
            return;
            if ((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) {
              break label643;
            }
          } while (!CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int));
          localObject1 = new ArrayList();
          bool2 = ApolloUtilImpl.getActionListFormMessage(paramQQAppInterface, paramSessionInfo, localMessageRecord, (List)localObject1);
        } while (((ArrayList)localObject1).size() == 0);
        paramSessionInfo = localMessageRecord.getExtInfoFromExtStr("is_apollo_emoticon_action_played");
        if ((!TextUtils.isEmpty(paramSessionInfo)) && ("2".equals(paramSessionInfo)))
        {
          bool1 = true;
          QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] apollo emoticon action played=", Boolean.valueOf(bool1), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
          if ((bool1) || (i == ((List)localObject2).size() - 1)) {
            break;
          }
          QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionList=", localObject1 });
          localObject2 = (ChatMessage)localMessageRecord;
          if (!bool2) {
            break label638;
          }
        }
        for (paramSessionInfo = (SessionInfo)localObject1;; paramSessionInfo = null)
        {
          a(paramQQAppInterface, (ChatMessage)localObject2, (ArrayList)localObject1, paramSessionInfo);
          localMessageRecord.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
          ThreadManager.post(new ApolloMsgPlayController.2(this, localMessageRecord), 5, null, false);
          return;
          bool1 = false;
          break;
        }
      } while ((!(localMessageRecord instanceof MessageForArkApp)) || (!CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int)));
      j = ApolloUtilImpl.getShareMsgActionId(paramQQAppInterface, (MessageForArkApp)localMessageRecord);
    } while (j <= 0);
    label643:
    paramSessionInfo = localMessageRecord.getExtInfoFromExtStr("is_share_ark_message_action_played");
    if ((!TextUtils.isEmpty(paramSessionInfo)) && ("2".equals(paramSessionInfo))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] share ark action played=", Boolean.valueOf(bool1), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
      }
      if ((bool1) || (i == ((List)localObject2).size() - 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionId=", Integer.valueOf(j) });
      }
      paramQQAppInterface = (SpriteBridge)((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a((ChatMessage)localMessageRecord, j);
      }
      localMessageRecord.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
      ThreadManager.excute(new ApolloMsgPlayController.3(this, localMessageRecord), 32, null, false);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloMsgPlayController", 2, "[playWhiteFace]");
    }
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramArrayList1 == null) || (paramArrayList1.size() == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (SpriteBridge)((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramChatMessage, paramArrayList1, paramArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.task;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.utils.VersionUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ApolloMsgPlayController
{
  private static ApolloMsgPlayController a;
  public long a;
  public WeakReference<AppInterface> a;
  
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
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[playUnreadAction] app:");
      ((StringBuilder)localObject1).append(paramQQAppInterface);
      ((StringBuilder)localObject1).append("sessionInfo:");
      ((StringBuilder)localObject1).append(paramSessionInfo);
      QLog.d("[cmshow]ApolloMsgPlayController", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramSessionInfo != null) && (paramQQAppInterface != null))
    {
      Object localObject3 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = ((ApolloDaoManagerServiceImpl)localObject3).getActionPushDataByAIO(paramSessionInfo);
      if (localObject1 != null)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new ApolloMsgPlayController.1(this, paramQQAppInterface, (ApolloActionPush)localObject1), 500L);
        return;
      }
      Object localObject2 = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, null, 5);
      if (((List)localObject2).size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloMsgPlayController", 2, "[playUnreadAction] no message,return.");
        }
        return;
      }
      int i = ((List)localObject2).size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)((List)localObject2).get(i);
        boolean bool;
        if ((localMessageRecord instanceof MessageForApollo))
        {
          localObject1 = (MessageForApollo)localMessageRecord;
          ApolloGameData localApolloGameData;
          if ((i == ((List)localObject2).size() - 1) && (ApolloGameUtil.a(((MessageForApollo)localObject1).msgType)))
          {
            localApolloGameData = ((ApolloDaoManagerServiceImpl)localObject3).findGameById(((MessageForApollo)localObject1).gameId);
            if ((localApolloGameData != null) && (VersionUtil.a("8.7.0", localApolloGameData.minVer, localApolloGameData.maxVer))) {}
          }
          else if ((!((MessageForApollo)localObject1).hasPlayed) && (i != ((List)localObject2).size() - 1))
          {
            if (ApolloGameUtil.a(((MessageForApollo)localObject1).msgType))
            {
              localApolloGameData = ((ApolloDaoManagerServiceImpl)localObject3).findGameById(((MessageForApollo)localObject1).gameId);
              if ((localApolloGameData != null) && (VersionUtil.a("8.7.0", localApolloGameData.minVer, localApolloGameData.maxVer))) {}
            }
            else
            {
              paramQQAppInterface = ((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
              if (paramQQAppInterface != null) {
                paramQQAppInterface.a(1, (MessageRecord)localObject1);
              }
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append("[playUnreadAction] play MessageForApollo:");
              paramQQAppInterface.append(localMessageRecord.toString());
              QLog.d("[cmshow]ApolloMsgPlayController", 2, paramQQAppInterface.toString());
            }
          }
          else
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("[playUnreadAction] has already played MessageForApollo:");
            paramQQAppInterface.append(localMessageRecord.toString());
            QLog.d("[cmshow]ApolloMsgPlayController", 2, paramQQAppInterface.toString());
          }
        }
        else if ((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg)))
        {
          if (((localMessageRecord instanceof MessageForArkApp)) && (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.jdField_a_of_type_Int)))
          {
            int j = ApolloUtilImpl.getShareMsgActionId(paramQQAppInterface, (MessageForArkApp)localMessageRecord);
            if (j > 0)
            {
              paramSessionInfo = localMessageRecord.getExtInfoFromExtStr("is_share_ark_message_action_played");
              if ((!TextUtils.isEmpty(paramSessionInfo)) && ("2".equals(paramSessionInfo))) {
                bool = true;
              } else {
                bool = false;
              }
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] share ark action played=", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
              }
              if (!bool)
              {
                if (i == ((List)localObject2).size() - 1) {
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("[cmshow]ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionId=", Integer.valueOf(j) });
                }
                paramQQAppInterface = (SpriteBridge)((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
                if (paramQQAppInterface != null) {
                  paramQQAppInterface.a((ChatMessage)localMessageRecord, j);
                }
                localMessageRecord.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
                ThreadManager.excute(new ApolloMsgPlayController.3(this, localMessageRecord), 32, null, false);
              }
            }
          }
        }
        else if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.jdField_a_of_type_Int))
        {
          localObject1 = new ArrayList();
          if (((ArrayList)localObject1).size() != 0) {
            break label722;
          }
        }
        i -= 1;
        continue;
        label722:
        localObject3 = localMessageRecord.getExtInfoFromExtStr("is_apollo_emoticon_action_played");
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && ("2".equals(localObject3))) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.d("[cmshow]ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] apollo emoticon action played=", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(localMessageRecord.uniseq) });
        if (!bool)
        {
          if (i == ((List)localObject2).size() - 1) {
            return;
          }
          QLog.d("[cmshow]ApolloMsgPlayController", 2, new Object[] { "[playUnreadAction] send action list to play, actionList=", localObject1 });
          bool = ApolloUtilImpl.getActionListFormMessage(paramQQAppInterface, paramSessionInfo, localMessageRecord, (List)localObject1);
          localObject2 = (ChatMessage)localMessageRecord;
          if (bool) {
            paramSessionInfo = (SessionInfo)localObject1;
          } else {
            paramSessionInfo = null;
          }
          a(paramQQAppInterface, (MessageRecord)localObject2, (ArrayList)localObject1, paramSessionInfo);
          localMessageRecord.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
          ThreadManager.post(new ApolloMsgPlayController.2(this, localMessageRecord), 5, null, false);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMsgPlayController", 2, "[playUnreadAction] sessionInfo or app is null,return.");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMsgPlayController", 2, "[playWhiteFace]");
    }
    if ((paramQQAppInterface != null) && (paramMessageRecord != null) && (paramArrayList1 != null))
    {
      if (paramArrayList1.size() == 0) {
        return;
      }
      paramQQAppInterface = (SpriteBridge)((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
      if ((paramQQAppInterface != null) && ((paramMessageRecord instanceof ChatMessage))) {
        paramQQAppInterface.a((ChatMessage)paramMessageRecord, paramArrayList1, paramArrayList2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloMsgPlayController
 * JD-Core Version:    0.7.0.1
 */
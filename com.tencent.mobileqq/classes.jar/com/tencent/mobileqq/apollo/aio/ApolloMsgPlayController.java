package com.tencent.mobileqq.apollo.aio;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
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
  private static volatile ApolloMsgPlayController a;
  
  public static ApolloMsgPlayController a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ApolloMsgPlayController();
        }
      }
      finally {}
    }
    return a;
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
      localObject1 = ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getActionPushDataByAIO(paramSessionInfo);
      if (localObject1 != null)
      {
        ThreadManager.getSubThreadHandler().postDelayed(new ApolloMsgPlayController.1(this, paramQQAppInterface, (ApolloActionPush)localObject1), 500L);
        return;
      }
      Object localObject2 = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, paramSessionInfo.a, null, 5);
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
        if ((localMessageRecord instanceof MessageForApollo))
        {
          if ((!((MessageForApollo)localMessageRecord).hasPlayed) && (i != ((List)localObject2).size() - 1))
          {
            paramQQAppInterface = ((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge();
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(1, localMessageRecord);
            }
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("[playUnreadAction] play MessageForApollo:");
            paramQQAppInterface.append(localMessageRecord.toString());
            QLog.d("[cmshow]ApolloMsgPlayController", 2, paramQQAppInterface.toString());
            return;
          }
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("[playUnreadAction] has already played MessageForApollo:");
          paramQQAppInterface.append(localMessageRecord.toString());
          QLog.d("[cmshow]ApolloMsgPlayController", 2, paramQQAppInterface.toString());
          return;
        }
        boolean bool;
        if ((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg)))
        {
          if (((localMessageRecord instanceof MessageForArkApp)) && (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a)))
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
                  paramQQAppInterface.a(localMessageRecord, j);
                }
                localMessageRecord.saveExtInfoToExtStr("is_share_ark_message_action_played", "2");
                ThreadManager.excute(new ApolloMsgPlayController.3(this, localMessageRecord), 32, null, false);
              }
            }
          }
        }
        else if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a))
        {
          localObject1 = new ArrayList();
          if (((ArrayList)localObject1).size() != 0) {
            break label603;
          }
        }
        i -= 1;
        continue;
        label603:
        String str = localMessageRecord.getExtInfoFromExtStr("is_apollo_emoticon_action_played");
        if ((!TextUtils.isEmpty(str)) && ("2".equals(str))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloMsgPlayController
 * JD-Core Version:    0.7.0.1
 */
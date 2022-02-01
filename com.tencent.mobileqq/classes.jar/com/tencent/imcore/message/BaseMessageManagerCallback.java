package com.tencent.imcore.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ext.getaiolist.PretreatmentAIOMsg;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MsgHelper;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class BaseMessageManagerCallback
  implements BaseMessageManager.Callback
{
  public BaseMsgProxy a(int paramInt, AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getMessageProxy(paramInt);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (paramString2.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
      paramString1 = DataLineMsgRecord.tableName();
    }
    if (paramString2.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN))) {
      paramString1 = DataLineMsgRecord.tableName(1);
    }
    return paramString1;
  }
  
  public String a(AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (paramInt == 1)
    {
      String str = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramString1);
      Bundle localBundle = new Bundle();
      a(paramMessageForUniteGrayTip, localBundle);
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      paramMessageForUniteGrayTip = ContactUtils.a(localQQAppInterface, paramString2, paramString1, str, true, localBundle);
      paramAppRuntime = paramMessageForUniteGrayTip;
      if (TextUtils.isEmpty(paramMessageForUniteGrayTip)) {
        return ContactUtils.a(localQQAppInterface, paramString2, paramString1, 1, 0);
      }
    }
    else
    {
      if (paramInt == 3000) {
        return ContactUtils.a((QQAppInterface)paramAppRuntime, paramString2, paramString1, 2, 0);
      }
      paramAppRuntime = HardCodeUtil.a(2131701235);
    }
    return paramAppRuntime;
  }
  
  public String a(AppRuntime paramAppRuntime, int paramInt, String paramString1, String paramString2, MessageForUniteGrayTip paramMessageForUniteGrayTip, String paramString3)
  {
    if (paramInt == 1)
    {
      paramString3 = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(paramString2);
      Bundle localBundle = new Bundle();
      a(paramMessageForUniteGrayTip, localBundle);
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      paramMessageForUniteGrayTip = ContactUtils.a(paramAppRuntime, paramString1, paramString2, paramString3, true, localBundle);
      if (TextUtils.isEmpty(paramMessageForUniteGrayTip)) {
        return ContactUtils.a(paramAppRuntime, paramString1, paramString2, 1, 0);
      }
      return paramMessageForUniteGrayTip;
    }
    if (paramInt == 3000) {
      paramString3 = ContactUtils.a((QQAppInterface)paramAppRuntime, paramString1, paramString2, 2, 0);
    }
    return paramString3;
  }
  
  public String a(AppRuntime paramAppRuntime, String paramString)
  {
    return ContactUtils.e((QQAppInterface)paramAppRuntime, paramString);
  }
  
  public Manager a(AppRuntime paramAppRuntime)
  {
    return ((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.TROOPINFO_MANAGER);
  }
  
  public void a(BaseMessageManager paramBaseMessageManager, AppRuntime paramAppRuntime, int paramInt, String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    if (PasswdRedBagFoldManager.a(paramAppRuntime, paramInt, paramString)) {
      FoldMessageManager.a(paramBaseMessageManager, paramAppRuntime, paramList1, paramList2, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    AnonymousChatHelper.c(paramMessageForUniteGrayTip);
  }
  
  public void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, Bundle paramBundle)
  {
    paramBundle.putInt(ContactUtils.a, ContactUtils.jdField_b_of_type_Int);
    paramBundle.putLong(ContactUtils.jdField_b_of_type_JavaLangString, paramMessageForUniteGrayTip.uniseq);
  }
  
  public void a(IMessageFacade paramIMessageFacade, String paramString, int paramInt, List<MessageRecord> paramList, BaseMessageManager paramBaseMessageManager)
  {
    if ((!paramList.isEmpty()) && ((paramList.get(paramList.size() - 1) instanceof MessageForLongMsg)) && (UinTypeUtil.a((MessageRecord)paramList.get(paramList.size() - 1), paramIMessageFacade.getLastMessage(paramString, paramInt))))
    {
      paramList = (MessageForLongMsg)paramList.get(paramList.size() - 1);
      if ((paramList.longMsgFragmentList != null) && (!paramList.longMsgFragmentList.isEmpty()) && (((MessageRecord)paramList.longMsgFragmentList.get(0)).longMsgIndex < paramIMessageFacade.getLastMessage(paramString, paramInt).longMsgIndex))
      {
        paramBaseMessageManager.a((MessageRecord)paramList.longMsgFragmentList.get(0), true, 2);
        paramBaseMessageManager.b(paramString, paramInt, (MessageRecord)paramList.longMsgFragmentList.get(0), 2);
        paramBaseMessageManager.a(paramList, true, 3);
        paramBaseMessageManager.b(paramString, paramInt, paramList, 3);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    PretreatmentAIOMsg.a(paramList, (QQAppInterface)paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime.isLogin()) {
      ((IAppBadgeService)paramAppRuntime.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, BaseMessageManager paramBaseMessageManager, IMessageFacade paramIMessageFacade, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (UinTypeUtil.c(paramString1))
    {
      MsgBoxHelper.a((QQAppInterface)paramAppRuntime, paramBaseMessageManager, paramIMessageFacade, paramString1, paramInt1, paramString2, paramString3, paramBoolean);
      return;
    }
    MsgBoxHelper.a((QQAppInterface)paramAppRuntime, paramBaseMessageManager, paramIMessageFacade, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, long paramLong)
  {
    ((QQAppInterface)paramAppRuntime).getMsgHandler().a(paramMessageRecord, paramLong);
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord)
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramAppRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (UinTypeUtil.h(paramMessageRecord.istroop))
    {
      paramBaseMessageManager.c(paramMessageRecord);
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
    if (ServiceAccountFolderManager.c(localQQAppInterface, paramMessageRecord.frienduin))
    {
      a(paramAppRuntime, paramIMessageFacade, paramBaseMessageManager, paramMessageRecord, localEcShopAssistantManager);
      return;
    }
    if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.b(localQQAppInterface, paramMessageRecord.frienduin)))
    {
      paramBaseMessageManager.d(paramMessageRecord);
      ServiceAccountFolderManager.a().b(localQQAppInterface);
      return;
    }
    if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.a((AppInterface)paramAppRuntime, paramMessageRecord.frienduin))) {
      return;
    }
    paramBaseMessageManager.d(paramMessageRecord);
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord, EcShopAssistantManager paramEcShopAssistantManager)
  {
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = UinTypeUtil.a(str, i);
    if (paramIMessageFacade.getCachedMsg().containsKey(paramMessageRecord))
    {
      EcShopData localEcShopData = paramEcShopAssistantManager.a();
      paramMessageRecord = paramIMessageFacade.getLastMsgForMsgTab(str, i);
      i = 0;
      if (paramMessageRecord != null)
      {
        paramBaseMessageManager.a(paramMessageRecord, true, 4);
        paramBaseMessageManager = localEcShopData;
      }
      else
      {
        paramEcShopAssistantManager.b(str);
        paramEcShopAssistantManager = paramEcShopAssistantManager.a();
        paramBaseMessageManager = paramEcShopAssistantManager;
        if (paramEcShopAssistantManager != null)
        {
          paramMessageRecord = paramIMessageFacade.getLastMessage(paramEcShopAssistantManager.mUin, 1008);
          i = 1;
          paramBaseMessageManager = paramEcShopAssistantManager;
        }
      }
      if (((paramBaseMessageManager != null) && (str.equals(paramBaseMessageManager.mUin))) || (i != 0))
      {
        paramBaseMessageManager = ((IRecentUserProxyService)paramAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(String.valueOf(9970L), 7120);
        if (paramBaseMessageManager != null)
        {
          if (paramMessageRecord != null)
          {
            paramBaseMessageManager.lastmsgtime = paramMessageRecord.time;
            ((IRecentUserProxyService)paramAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b(paramBaseMessageManager);
          }
          paramIMessageFacade.setChangeAndNotify(paramBaseMessageManager);
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, IConversationFacade paramIConversationFacade, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (TroopBarAssistantManager.a().a((QQAppInterface)paramAppRuntime, paramString1, paramInt))) {
      return;
    }
    if ((paramInt == 1008) && (ServiceAccountFolderManager.c((QQAppInterface)paramAppRuntime, paramString1)))
    {
      paramAppRuntime = (EcShopAssistantManager)paramAppRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (paramAppRuntime != null) {
        paramAppRuntime.a(paramString1, paramLong);
      }
      return;
    }
    if (UinTypeUtil.a(paramInt) == 1032) {
      return;
    }
    if ((!paramIConversationFacade.isUinInRecentList(paramString1, paramInt)) && (UinTypeUtil.h(paramInt)))
    {
      paramIConversationFacade = null;
    }
    else
    {
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)paramAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      if (0L == paramLong)
      {
        paramIConversationFacade = localRecentUserProxy.b(paramString1, paramInt);
      }
      else
      {
        paramIConversationFacade = localRecentUserProxy.a(paramString1, paramInt);
        paramIConversationFacade.troopUin = paramString2;
      }
      if (paramIConversationFacade != null)
      {
        paramIConversationFacade.lastmsgdrafttime = paramLong;
        if ((0L == paramLong) && (paramIConversationFacade.lastmsgtime == 0L))
        {
          localRecentUserProxy.a(paramIConversationFacade);
        }
        else
        {
          a(paramAppRuntime, paramIConversationFacade);
          localRecentUserProxy.b(paramIConversationFacade);
        }
      }
    }
    if (paramInt == 1008)
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (ServiceAccountFolderManager.b(paramAppRuntime, paramString1)) {
        ServiceAccountFolderManager.a().a(paramAppRuntime, paramString1, paramString3, paramLong);
      }
    }
    paramIMessageFacade.setChangeAndNotify(paramIConversationFacade);
  }
  
  public void a(AppRuntime paramAppRuntime, IMessageFacade paramIMessageFacade, boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramMessageRecord != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject3 = (MessageRecord)paramList.next();
        paramIMessageFacade.removeMsgByUniseq(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq, false);
        if (((MessageRecord)localObject3).msgtype == -2005)
        {
          localObject1 = (QQAppInterface)paramAppRuntime;
          localObject2 = ((QQAppInterface)localObject1).getFileManagerDataCenter();
          localObject3 = ((FileManagerDataCenter)localObject2).a(((MessageRecord)localObject3).uniseq, ((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop);
          if (localObject3 != null)
          {
            ((FileManagerDataCenter)localObject2).b((FileManagerEntity)localObject3);
            ((QQAppInterface)localObject1).getFileManagerEngine().b(((FileManagerEntity)localObject3).nSessionId);
          }
          if (paramMessageRecord.istroop == 3000) {
            FileManagerReporter.a("0X8005E50");
          } else {
            FileManagerReporter.a("0X8005E4D");
          }
          FileManagerReporter.a("0X8005E4C");
        }
      }
    }
    paramMessageRecord = paramList.iterator();
    while (paramMessageRecord.hasNext())
    {
      localObject1 = (MessageRecord)paramMessageRecord.next();
      if ((paramBoolean1) && (!((MessageRecord)localObject1).isread) && (localObject1 != paramList.get(0)))
      {
        ((MessageRecord)localObject1).isread = true;
        if ((paramInt == 1) || (paramInt == 3000))
        {
          i = 1;
          break label251;
        }
      }
      int i = 0;
      label251:
      if (i != 0) {
        a(paramInt, paramAppRuntime).a((MessageRecord)localObject1, false);
      } else {
        paramIMessageFacade.removeMsgByUniseq(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq, paramBoolean2 ^ true);
      }
      if ((((MessageRecord)localObject1).msgtype == -2005) || ((localObject1 instanceof MessageForTroopFile)))
      {
        Object localObject4;
        if (((MessageRecord)localObject1).msgtype == -2005)
        {
          localObject2 = (QQAppInterface)paramAppRuntime;
          localObject3 = ((QQAppInterface)localObject2).getFileManagerDataCenter();
          localObject4 = ((FileManagerDataCenter)localObject3).a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if (localObject4 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
            }
            ((FileManagerDataCenter)localObject3).b((FileManagerEntity)localObject4);
            ((QQAppInterface)localObject2).getFileManagerEngine().b(((FileManagerEntity)localObject4).nSessionId);
          }
          else if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("can't find fileEntity,uniseq[");
            ((StringBuilder)localObject2).append(((MessageRecord)localObject1).uniseq);
            ((StringBuilder)localObject2).append("],");
            QLog.i("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else if ((localObject1 instanceof MessageForTroopFile))
        {
          localObject3 = (MessageForTroopFile)localObject1;
          localObject4 = (QQAppInterface)paramAppRuntime;
          localObject2 = TroopFileTransferManager.a((QQAppInterface)localObject4, Long.parseLong(((MessageForTroopFile)localObject3).frienduin));
          localObject3 = TroopFileUtils.a((QQAppInterface)localObject4, (MessageForTroopFile)localObject3);
          if ((localObject3 != null) && (((TroopFileStatusInfo)localObject3).a != null) && (localObject2 != null))
          {
            localObject3 = ((TroopFileTransferManager)localObject2).a(((TroopFileStatusInfo)localObject3).a);
            if (localObject3 != null) {
              ((TroopFileTransferManager)localObject2).a((TroopFileTransferManager.Item)localObject3, 12);
            }
          }
        }
        ((AIOMessageSpreadManager)paramAppRuntime.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).b((MessageRecord)localObject1);
      }
      localObject1 = EmojiStickerManager.a((MessageRecord)localObject1);
      if (localObject1 != null) {
        EmojiStickerManager.a().b.put(localObject1, Boolean.valueOf(true));
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    ((ITransFileController)paramAppRuntime.getRuntimeService(ITransFileController.class, "")).removeProcessorByPeerUin(paramString, 0);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (MsgHelper.a((QQAppInterface)paramAppRuntime, paramString, paramInt))
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("find invalid refreshSingleLastMsg");
      paramAppRuntime.append(paramString);
      QLog.e("MsgInvalidTypeErr", 1, paramAppRuntime.toString());
      MsgHelper.b(paramString);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    ((QQAppInterface)paramAppRuntime).getMsgHandler().a().a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if (paramList != null)
    {
      ((QQAppInterface)paramAppRuntime).getMsgHandler().a().a(paramList);
      return;
    }
    ((QQAppInterface)paramAppRuntime).getMsgHandler().a().a(paramMessageRecord);
  }
  
  public void a(AppRuntime paramAppRuntime, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int i = paramList1.size();
    Object localObject = null;
    int j;
    if (i > 1)
    {
      j = i - 1;
      MessageForPoke localMessageForPoke2 = (MessageForPoke)paramList1.get(j);
      i = 0;
      for (;;)
      {
        localMessageForPoke1 = localMessageForPoke2;
        if (i >= j) {
          break;
        }
        localMessageForPoke1 = (MessageForPoke)paramList1.get(i);
        if ((localMessageForPoke1 != null) && (!localMessageForPoke1.isPlayed) && (!localMessageForPoke1.isSend())) {
          localMessageForPoke1.setPlayed((QQAppInterface)paramAppRuntime);
        }
        i += 1;
      }
    }
    MessageForPoke localMessageForPoke1 = null;
    int k = paramList2.size();
    paramList1 = localObject;
    if (k >= 1) {
      paramList1 = (MessageForPokeEmo)paramList2.get(k - 1);
    }
    if ((localMessageForPoke1 != null) && (paramList1 != null))
    {
      if (localMessageForPoke1.time >= paramList1.time) {
        break label181;
      }
      localMessageForPoke1.setPlayed((QQAppInterface)paramAppRuntime);
    }
    else
    {
      if (localMessageForPoke1 != null) {
        break label181;
      }
    }
    i = 1;
    break label184;
    label181:
    i = 0;
    label184:
    if ((localMessageForPoke1 != null) && (localMessageForPoke1.isread) && (!localMessageForPoke1.isPlayed)) {
      localMessageForPoke1.setPlayed((QQAppInterface)paramAppRuntime);
    }
    if ((paramList1 != null) && (i != 0))
    {
      j = k - 3;
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (k > 0)
      {
        j = k - 1;
        while (j >= i)
        {
          paramAppRuntime = (MessageForPokeEmo)paramList2.get(j);
          if (!paramAppRuntime.isread) {
            paramAppRuntime.setIsNeedPlayed(true);
          }
          j -= 1;
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, boolean paramBoolean)
  {
    ((QQAppInterface)paramAppRuntime).getMsgHandler().a().a(paramList, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    ConfessMsgUtil.a((QQAppInterface)paramAppRuntime, paramBoolean1, paramBoolean2);
  }
  
  public boolean a(BaseMessageManager paramBaseMessageManager, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      Object localObject = (MessageForShortVideo)paramMessageRecord;
      if (((MessageForShortVideo)localObject).busiType == 0)
      {
        boolean bool;
        if ((((MessageForShortVideo)localObject).videoFileStatus != 1007) && ((((MessageForShortVideo)localObject).videoFileStatus != 1003) || (((MessageForShortVideo)localObject).extraflag != 32772))) {
          bool = false;
        } else {
          bool = true;
        }
        if (!bool) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doMsgRevokeReqForRichMsg, holdFlag: ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
        }
        paramBaseMessageManager.f(paramMessageRecord);
        return true;
      }
    }
    else if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if (paramMessageRecord.extraflag == 32772)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, msgForPic");
        }
        paramBaseMessageManager.f(paramMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, Message paramMessage)
  {
    if ((paramMessageRecord == null) && (paramMessage != null))
    {
      paramMessageRecord = new DataLineMsgRecord();
      DataLineMsgRecord.unpackMsgData(paramMessageRecord, paramMessage.msgData, paramMessage.versionCode);
      paramMessage.msg = paramMessageRecord.msg;
    }
    else
    {
      if ((paramMessageRecord instanceof MessageForFoldMsg)) {
        return true;
      }
      if (((paramMessageRecord instanceof MessageForNearbyLiveTip)) && (paramMessage != null)) {
        paramMessage.nickName = ((MessageForNearbyLiveTip)paramMessageRecord).nickName;
      } else if (((paramMessageRecord instanceof MessageForText)) && (paramMessage == null)) {
        ((MessageForText)paramMessageRecord).parse();
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      if (paramList != null) {
        paramList.addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(Object paramObject)
  {
    return PaiYiPaiMsgUtil.a(paramObject);
  }
  
  public boolean a(AppRuntime paramAppRuntime, Message paramMessage)
  {
    return ReactivePushHelper.a((QQAppInterface)paramAppRuntime, paramMessage);
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return QidianManager.a((QQAppInterface)paramAppRuntime, paramMessageRecord);
  }
  
  public boolean a(AppRuntime paramAppRuntime, RecentUser paramRecentUser)
  {
    return ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser((QQAppInterface)paramAppRuntime, paramRecentUser);
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    return ((ITroopRobotService)paramAppRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString);
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    return (DiscussionManager.a(paramAppRuntime, paramString, paramInt)) || (paramAppRuntime.isTroopMark(paramString, paramInt));
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    ((PaiYiPaiHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).notifyUI(9999, true, null);
  }
  
  public void b(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, long paramLong)
  {
    ((PaiYiPaiHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).a(paramMessageRecord, paramLong);
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    ((MiniMsgHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(paramString, paramInt, -1);
  }
  
  public boolean b(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    return QCallFacade.a((QQAppInterface)paramAppRuntime, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerCallback
 * JD-Core Version:    0.7.0.1
 */
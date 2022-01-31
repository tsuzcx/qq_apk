package com.tencent.mobileqq.app.message;

import ActionMsg.MsgBody;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipCallBack;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import localpb.richMsg.RichMsg.FoldMsg;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import zow;
import zoy;
import zoz;
import zpa;
import zpb;

public abstract class BaseMessageManager
  extends Observable
  implements IMessageManager
{
  public QQAppInterface a;
  public QQMessageFacade a;
  private Object a;
  private Object b = new Object();
  
  public BaseMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    Object localObject2;
    if (MsgProxyUtils.a(paramInt) == 1009)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.v, 1009);
      localObject2 = "";
    }
    for (;;)
    {
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (paramString.equals(localMessageRecord.senderuin))
            {
              return localMessageRecord.uniseq;
              if (MsgProxyUtils.a(paramInt) == 1001)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.G, 1001);
                localObject2 = AppConstants.ae;
                continue;
              }
              if (MsgProxyUtils.a(paramInt) == 1010)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.X, 1010);
                localObject2 = AppConstants.af;
                continue;
              }
              if (MsgProxyUtils.a(paramInt) != 10002) {
                break label361;
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.G, 10002);
              localObject2 = AppConstants.ae;
              continue;
            }
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || ((!AppConstants.ae.equals(localMessageRecord.senderuin)) && (!AppConstants.af.equals(localMessageRecord.senderuin)))) {
              break label358;
            }
            i = 1;
          }
        }
      }
      label358:
      for (;;)
      {
        break;
        if (i != 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject2, MsgProxyUtils.a(paramInt));
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if (paramString.equals(((MessageRecord)localObject2).senderuin)) {
                return ((MessageRecord)localObject2).uniseq;
              }
            }
          }
        }
        return 0L;
      }
      label361:
      localObject2 = "";
    }
  }
  
  private UniteGrayTipParam a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MessageForUniteGrayTip paramMessageForUniteGrayTip, long paramLong)
  {
    Object localObject1 = "";
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(paramString3);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.jdField_b_of_type_Int);
      ((Bundle)localObject2).putLong(ContactUtils.jdField_b_of_type_JavaLangString, paramMessageForUniteGrayTip.uniseq);
      localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, (String)localObject1, true, (Bundle)localObject2);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, 1, 0);
      }
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131430833);
      int i = paramString1.length() + ((String)localObject2).length();
      int j = i + ((String)localObject1).length();
      paramString1 = paramString1 + (String)localObject2 + (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131430834);
      paramString3 = new UniteGrayTipParam(paramString3, paramString4, paramString1, paramInt, -5040, 1, paramLong);
      paramString4 = new Bundle();
      paramString4.putInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.jdField_b_of_type_Int);
      paramString4.putLong(ContactUtils.jdField_b_of_type_JavaLangString, paramMessageForUniteGrayTip.uniseq);
      paramString4.putInt("key_action", 28);
      paramString4.putString("troop_mem_uin", String.valueOf(paramString2));
      paramString4.putBoolean("need_update_nick", true);
      paramString3.a(i, j, paramString4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke message wording", paramString1, Integer.valueOf(i), " end:", Integer.valueOf(j) });
      }
      return paramString3;
      if (paramInt == 3000) {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, 2, 0);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap paramHashMap)
  {
    HashSet localHashSet = new HashSet();
    paramQQAppInterface = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    paramQQAppInterface.a(false);
    if (paramQQAppInterface.g.isEmpty()) {
      return;
    }
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      zpb localzpb1 = (zpb)localEntry.getValue();
      if (localzpb1.jdField_b_of_type_Boolean)
      {
        String str = (String)paramQQAppInterface.g.get(localEntry.getKey());
        if ((!TextUtils.isEmpty(str)) && (paramHashMap.containsKey(str)))
        {
          zpb localzpb2 = (zpb)paramHashMap.get(str);
          localHashSet.add(str);
          localzpb1.jdField_a_of_type_Int += localzpb2.jdField_a_of_type_Int;
          localzpb1.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(localzpb2.jdField_a_of_type_JavaUtilLinkedHashSet);
          if ((localzpb1.jdField_a_of_type_Boolean) || (localzpb2.jdField_a_of_type_Boolean)) {}
          for (boolean bool = true;; bool = false)
          {
            localzpb1.jdField_a_of_type_Boolean = bool;
            if (localzpb1.jdField_b_of_type_Long < localzpb2.jdField_b_of_type_Long)
            {
              localzpb1.jdField_b_of_type_Long = localzpb2.jdField_b_of_type_Long;
              localzpb1.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localzpb2.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
              localzpb1.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg.redBagIndex = ((String)localEntry.getKey());
            }
            if (localzpb1.jdField_a_of_type_Long <= localzpb2.jdField_a_of_type_Long) {
              break;
            }
            localzpb1.jdField_a_of_type_Long = localzpb2.jdField_a_of_type_Long;
            localzpb1.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localzpb2.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg;
            localzpb1.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg.redBagIndex = ((String)localEntry.getKey());
            break;
          }
        }
      }
    }
    paramHashMap.keySet().removeAll(localHashSet);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((QLog.isColorLevel()) && (StartupTracker.a()) && (paramList1 != null) && (paramList1.size() > 0))
    {
      localObject1 = new StringBuilder(paramList1.size() * 48 + 64);
      ((StringBuilder)localObject1).append("BaseMessageManager mergeFoldMsgGrayTips(),searchList size=").append(paramList1.size()).append(":");
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
      }
      QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
    }
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    Object localObject4 = new HashMap();
    Object localObject5 = paramList1.iterator();
    label533:
    label535:
    label940:
    label946:
    label950:
    for (;;)
    {
      label208:
      MessageForFoldMsg localMessageForFoldMsg;
      boolean bool;
      if (((Iterator)localObject5).hasNext())
      {
        localObject1 = (MessageRecord)((Iterator)localObject5).next();
        if (!(localObject1 instanceof MessageForFoldMsg)) {
          continue;
        }
        localMessageForFoldMsg = (MessageForFoldMsg)localObject1;
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          localPasswdRedBagManager.a(true, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex);
        }
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) || (TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          break label946;
        }
        if (localPasswdRedBagManager.f.containsKey(localMessageForFoldMsg.redBagId))
        {
          localMessageForFoldMsg.redBagIndex = ((String)localPasswdRedBagManager.f.get(localMessageForFoldMsg.redBagId));
          bool = true;
        }
      }
      for (;;)
      {
        label345:
        if (((!paramBoolean1) && (localPasswdRedBagManager.a(localMessageForFoldMsg.frienduin, localMessageForFoldMsg.istroop, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex))) || ((localMessageForFoldMsg.isSend()) && (!localMessageForFoldMsg.foldFlag) && (localMessageForFoldMsg.msgtype == -2006))) {
          break label950;
        }
        if (bool) {}
        for (localObject1 = localMessageForFoldMsg.redBagIndex;; localObject1 = localMessageForFoldMsg.redBagId)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label533;
          }
          localObject3 = (zpb)((HashMap)localObject4).get(localObject1);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new zpb();
            ((HashMap)localObject4).put(localObject1, localObject2);
          }
          ((zpb)localObject2).jdField_b_of_type_Boolean = bool;
          if (localMessageForFoldMsg.foldFlag) {
            break label535;
          }
          ((zpb)localObject2).jdField_a_of_type_Boolean = true;
          if (localMessageForFoldMsg.shmsgseq <= ((zpb)localObject2).jdField_b_of_type_Long) {
            break;
          }
          ((zpb)localObject2).jdField_b_of_type_Long = localMessageForFoldMsg.shmsgseq;
          ((zpb)localObject2).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
          break;
          bool = false;
          break label345;
        }
        break label208;
        ((zpb)localObject2).jdField_a_of_type_Int += 1;
        ((zpb)localObject2).jdField_a_of_type_JavaUtilLinkedHashSet.add(localMessageForFoldMsg.senderuin);
        if (localMessageForFoldMsg.shmsgseq >= ((zpb)localObject2).jdField_a_of_type_Long) {
          break label208;
        }
        ((zpb)localObject2).jdField_a_of_type_Long = localMessageForFoldMsg.shmsgseq;
        ((zpb)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
        break label208;
        if (((HashMap)localObject4).isEmpty()) {
          break;
        }
        a(paramQQAppInterface, (HashMap)localObject4);
        localObject2 = ((HashMap)localObject4).entrySet().iterator();
        label621:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (zpb)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (((zpb)localObject3).jdField_a_of_type_Int > 0)
          {
            if (((zpb)localObject3).jdField_a_of_type_Boolean) {
              ((zpb)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = ((zpb)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
            }
            if (paramList2 != null) {
              break label940;
            }
          }
        }
        for (localObject1 = (List)MsgPool.a(paramQQAppInterface.getAccount()).b().get(MsgProxyUtils.a(((MessageRecord)paramList1.get(0)).frienduin, ((MessageRecord)paramList1.get(0)).istroop));; localObject1 = paramList2)
        {
          localObject1 = localPasswdRedBagManager.a((List)localObject1, ((zpb)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg, ((zpb)localObject3).jdField_a_of_type_JavaUtilLinkedHashSet, ((zpb)localObject3).jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
          if ((localObject1 == null) || (paramList2 != null)) {
            break label621;
          }
          if ((QLog.isColorLevel()) && (StartupTracker.a()) && (paramList2 != null) && (paramList2.size() > 0))
          {
            localObject3 = new StringBuilder(paramList2.size() * 48 + 32);
            ((StringBuilder)localObject3).append("insert to clone list,addlist size=").append(paramList2.size()).append(":");
            localObject4 = paramList2.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MessageRecord)((Iterator)localObject4).next();
              ((StringBuilder)localObject3).append("(").append(((MessageRecord)localObject5).time).append(",").append(((MessageRecord)localObject5).shmsgseq).append(",").append(((MessageRecord)localObject5).msgtype).append(") ");
            }
            QLog.d("msgFold", 2, ((StringBuilder)localObject3).toString());
          }
          MsgProxyUtils.c(paramList1, (MessageRecord)localObject1, true);
          break label621;
          break;
        }
        bool = true;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    return (TextUtils.equals(paramString, "10000")) || (TextUtils.equals(paramString, "1000000")) || (TextUtils.equals(paramString, "50000000")) || (TextUtils.equals(paramString, "80000000")) || (localTroopRobotManager.b(paramString));
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new zpa(this, paramMessageRecord, l));
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (ConversationFacade.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (!MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if (((paramConversationInfo.type == 1001) || (paramConversationInfo.type == 10002)) && (AppConstants.G.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.v)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(AppConstants.X)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return ConversationFacade.a(paramConversationInfo);
        }
      }
      else {
        return ConversationFacade.a(paramConversationInfo);
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramBoolean1);
    Object localObject;
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, MsgProxyUtils.a(paramInt))))
      {
        if (MsgProxyUtils.a(paramInt) != 1009) {
          break label332;
        }
        a(AppConstants.v, 1009, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.v, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, localMessage.istroop);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((RecentUser)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.remove(MsgProxyUtils.a(paramString, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessage);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0);
      break;
      label332:
      if (MsgProxyUtils.a(paramInt) == 1001)
      {
        a(AppConstants.G, 1001, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.G, 1001);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (MsgProxyUtils.a(paramInt) == 1010)
      {
        a(AppConstants.X, 1010, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.X, 1010);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (MsgProxyUtils.a(paramInt) == 10002)
      {
        a(AppConstants.G, 10002, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.G, 10002);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
    }
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    String str = MsgProxyUtils.a(paramString, paramInt);
    Object localObject1 = null;
    Object localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(AppConstants.y))) {
        localObject1 = DataLineMsgRecord.tableName();
      }
      if (paramString.equals(String.valueOf(AppConstants.z))) {
        localObject1 = DataLineMsgRecord.tableName(1);
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject1, paramEntityManager);
      Object localObject3 = localObject1;
      localObject2 = localMessage;
      if (localMessage == null) {
        if ((!MsgProxyUtils.c(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject1;
          localObject2 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject2);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).a((String)localObject3, paramEntityManager);
          localObject1 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject1 = paramEntityManager;
          }
        }
      }
      if ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).isSendFromLocal()) && (((QQMessageFacade.Message)localObject1).extraflag == 32772) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1))) {
        ((QQMessageFacade.Message)localObject1).extraflag = 32768;
      }
      if (localObject1 != null)
      {
        if (((paramString.equals(String.valueOf(AppConstants.y))) || (paramString.equals(String.valueOf(AppConstants.z)))) && (((QQMessageFacade.Message)localObject1).msgData != null))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        if ((AppConstants.G.equals(((QQMessageFacade.Message)localObject1).frienduin)) || ((MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 1001) && (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 10002)))
        {
          paramString = (String)localObject1;
          if (!AppConstants.X.equals(((QQMessageFacade.Message)localObject1).frienduin))
          {
            paramString = (String)localObject1;
            if (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 1010) {}
          }
        }
        else
        {
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          paramString = (String)localObject1;
          if (paramEntityManager != null)
          {
            paramString = (String)localObject1;
            if (paramEntityManager.size() > 0)
            {
              paramEntityManager = paramEntityManager.iterator();
              do
              {
                paramString = (String)localObject1;
                if (!paramEntityManager.hasNext()) {
                  break;
                }
                paramString = (MessageRecord)paramEntityManager.next();
              } while ((paramString.senderuin == null) || (!paramString.senderuin.equals(paramString.frienduin)) || (MessageUtils.a(paramString.msgtype)));
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              paramString = (String)localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                paramString = (String)localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramEntityManager = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
        if (paramEntityManager != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
        paramEntityManager = paramString;
      }
      catch (Throwable localThrowable)
      {
        paramEntityManager = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramEntityManager = paramString;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramString = paramEntityManager;
      if (paramEntityManager == null) {
        break;
      }
      paramString = paramEntityManager;
      if (!MsgProxyUtils.a(paramEntityManager.frienduin, paramEntityManager.istroop)) {
        break;
      }
      paramEntityManager.istroop = MsgProxyUtils.a(paramEntityManager.istroop);
      return paramEntityManager;
      paramEntityManager = new QQMessageFacade.Message();
      paramEntityManager.frienduin = paramString;
      paramEntityManager.istroop = paramInt;
      paramString = paramEntityManager;
      continue;
      if (a(paramEntityManager) < a(paramString))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else if ((!paramEntityManager.isCacheValid) && (paramString.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramEntityManager.isCacheValid = true;
        paramString = paramEntityManager;
        continue;
        paramEntityManager = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramEntityManager = localThrowable;
        }
      }
    }
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramEntityManager, paramInt2);
    }
    return a(paramString, paramInt1, paramEntityManager);
  }
  
  public List a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  protected List a(String paramString, int paramInt1, int paramInt2)
  {
    return new ArrayList();
  }
  
  public List a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramLong >= 0L) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
    }
    while (localObject1 == null)
    {
      return new ArrayList();
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, true, true);
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramInt2, true);
      }
    }
    if (CacheConstants.jdField_a_of_type_Boolean) {
      MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().addCacheOpWeight(MsgProxyUtils.a(paramString, paramInt1), CacheConstants.k);
    }
    Object localObject2 = (List)((ArrayList)localObject1).clone();
    if (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject2, null, false, true);
    }
    MsgProxyUtils.a((List)localObject2);
    MsgProxyUtils.a(paramString, paramInt1, (List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((!((List)localObject2).isEmpty()) && ((((List)localObject2).get(((List)localObject2).size() - 1) instanceof MessageForLongMsg)) && (MsgProxyUtils.a((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1))))
    {
      localObject1 = (MessageForLongMsg)((List)localObject2).get(((List)localObject2).size() - 1);
      if ((((MessageForLongMsg)localObject1).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0)).longMsgIndex < this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1).longMsgIndex))
      {
        a((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), true, 2);
        b(paramString, paramInt1, (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), 2);
        a((MessageRecord)localObject1, true, 3);
        b(paramString, paramInt1, (MessageRecord)localObject1, 3);
      }
    }
    Object localObject3;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    label465:
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("newAIOCursor clone ");
      if (localObject2 != null)
      {
        localObject1 = Integer.valueOf(((List)localObject2).size());
        QLog.d("Q.msg.BaseMessageManager", 2, localObject1);
      }
    }
    else
    {
      localObject3 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      Iterator localIterator = ((List)localObject2).iterator();
      if (!localIterator.hasNext()) {
        break label1097;
      }
      localObject1 = (MessageRecord)localIterator.next();
      if (!(localObject1 instanceof MessageForArkApp)) {
        break label1384;
      }
      localObject2 = ArkTipsManager.a().a();
      if ((localObject2 == null) || (((MessageRecord)localObject1).uniseq != ((MessageForArkApp)localObject2).uniseq)) {
        break label1384;
      }
      localObject4 = ArkTipsManager.a().a();
      if (localObject4 != null)
      {
        ((MessageForArkApp)localObject2).arkContainer = ((ArkAioContainerWrapper)localObject4);
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "refill ark msg: " + ((MessageForArkApp)localObject2).uniseq + " ark c=" + ((MessageForArkApp)localObject2).arkContainer);
      }
    }
    label1097:
    label1362:
    label1370:
    label1379:
    label1384:
    for (;;)
    {
      for (;;)
      {
        ((List)localObject3).add((ChatMessage)localObject1);
        localObject2 = ((MessageRecord)localObject1).getExtInfoFromExtStr("sens_msg_ctrl_info");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (((MessageRecord)localObject1).isSend())
          {
            ((MessageRecord)localObject1).saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
            break label465;
            localObject1 = "clone is null";
            break;
          }
          localObject4 = new bankcode_info.BankcodeCtrlInfo();
        }
        try
        {
          ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.hexStr2Bytes((String)localObject2));
          paramInt2 = 0;
          if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has()) {
            paramInt2 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
          }
          if (paramInt2 != 1) {
            break label465;
          }
          ((ChatMessage)localObject1).parse();
          localObject2 = MessageRecordFactory.a(-1014);
          ((MessageRecord)localObject2).msgtype = -1046;
          ((MessageRecord)localObject2).senderuin = ((MessageRecord)localObject2).selfuin;
          ((MessageRecord)localObject2).frienduin = paramString;
          ((MessageRecord)localObject2).istroop = ((MessageRecord)localObject1).istroop;
          ((MessageRecord)localObject2).msg = "";
          ((MessageRecord)localObject2).isread = true;
          ((MessageRecord)localObject2).shmsgseq = ((MessageRecord)localObject1).shmsgseq;
          ((MessageRecord)localObject2).time = ((MessageRecord)localObject1).time;
          ((MessageRecord)localObject2).saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(((MessageRecord)localObject1).uniseq));
          ((List)localObject3).add((ChatMessage)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str;
            localException.printStackTrace();
          }
        }
      }
      if ((paramInt1 == 1008) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject4 = ((MessageRecord)localObject1).getExtInfoFromExtStr("pa_phone_msg_tip");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = new TroopTipsEntity();
          ((TroopTipsEntity)localObject2).optContent = ((String)localObject4);
          ((TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a((TroopTipsEntity)localObject2);
          localObject4 = new MessageForGrayTips();
          paramLong = ((MessageRecord)localObject1).time;
          str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((MessageForGrayTips)localObject4).init(str, paramString, str, ((TroopTipsEntity)localObject2).optContent, paramLong, -1048, paramInt1, paramLong);
          ((MessageForGrayTips)localObject4).isread = true;
          TroopTipsMsgMgr.a((MessageForGrayTips)localObject4, ((TroopTipsEntity)localObject2).highlightItems);
          ((List)localObject3).add(localObject4);
        }
      }
      if (paramBoolean) {
        break label465;
      }
      if ((paramInt1 == 0) && ((localObject1 instanceof MessageForPoke)))
      {
        localObject2 = (MessageForPoke)localObject1;
        if (!((MessageForPoke)localObject2).isSend()) {
          localArrayList2.add(localObject2);
        }
        if ((((MessageForPoke)localObject2).interactType == 126) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          break label465;
        }
        if ((((MessageForPoke)localObject2).isread) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          ((MessageForPoke)localObject2).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      if ((paramInt1 != 0) || (!(localObject1 instanceof MessageForPokeEmo))) {
        break label465;
      }
      localArrayList1.add((MessageForPokeEmo)localObject1);
      break label465;
      if (!paramBoolean)
      {
        paramInt2 = localArrayList2.size();
        if (paramInt2 <= 1) {
          break label1379;
        }
        paramString = (MessageForPoke)localArrayList2.get(paramInt2 - 1);
        paramInt1 = 0;
        while (paramInt1 < paramInt2 - 1)
        {
          localObject1 = (MessageForPoke)localArrayList2.get(paramInt1);
          if ((localObject1 != null) && (!((MessageForPoke)localObject1).isPlayed) && (!((MessageForPoke)localObject1).isSend())) {
            ((MessageForPoke)localObject1).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        paramInt2 = localArrayList1.size();
        if (paramInt2 > 1) {}
        for (localObject1 = (MessageForPokeEmo)localArrayList1.get(paramInt2 - 1);; localObject1 = null)
        {
          paramInt1 = 0;
          if ((paramString != null) && (localObject1 != null))
          {
            if (paramString.time < ((MessageForPokeEmo)localObject1).time)
            {
              paramString.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              paramInt1 = 1;
            }
            if ((paramString != null) && (paramString.isread) && (!paramString.isPlayed)) {
              paramString.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if ((localObject1 == null) || (paramInt1 == 0)) {
              break label1370;
            }
            if (paramInt2 - 3 >= 0) {
              break label1362;
            }
          }
          for (paramInt1 = 0;; paramInt1 = paramInt2 - 3)
          {
            if (paramInt2 <= 3) {
              break label1370;
            }
            paramInt2 -= 1;
            while (paramInt2 >= paramInt1)
            {
              paramString = (MessageForPokeEmo)localArrayList1.get(paramInt2);
              if (!paramString.isread) {
                paramString.setIsNeedPlayed(true);
              }
              paramInt2 -= 1;
            }
            if (paramString != null) {
              break;
            }
            paramInt1 = 1;
            break;
          }
          return localObject3;
        }
        paramString = null;
      }
    }
  }
  
  public List a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List a(List paramList, String paramString, int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt == 3000) || (paramInt == 1)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.next();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((paramInt != 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long))
          {
            if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!MsgProxyUtils.a(localMessageRecord))) {
              paramString.add(localMessageRecord);
            }
          }
          else if ((paramInt == 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.jdField_a_of_type_Long) && (localMessageRecord.msgUid == localRevokeMsgInfo.jdField_b_of_type_Long)) {
            paramString.add(localMessageRecord);
          }
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    synchronized (this.b)
    {
      try
      {
        this.b.wait(15000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait over");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait interrupted");
          }
        }
      }
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && ((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002))) {}
    for (;;)
    {
      int i;
      for (;;)
      {
        label1679:
        for (;;)
        {
          try
          {
            paramMessage.msg = ActionMsgUtil.a(paramMessage.msg).msg;
            if (paramMessage.msgtype != -2018) {
              if (paramMessage.msgtype != -2050) {
                break label706;
              }
            }
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              Object localObject4;
              Object localObject1;
              try
              {
                localObject4 = new structmsg.StructMsg();
                ((structmsg.StructMsg)localObject4).mergeFrom(paramMessage.msgData);
                if (((structmsg.StructMsg)localObject4).msg_type.get() == 1) {
                  switch (((structmsg.StructMsg)localObject4).msg.sub_type.get())
                  {
                  case 2: 
                  case 3: 
                    localObject1 = ((structmsg.StructMsg)localObject4).msg.msg_describe.get();
                    localObject1 = ((structmsg.StructMsg)localObject4).msg.req_uin_nick.get() + (String)localObject1;
                    paramMessage.msg = ((String)localObject1);
                    if ((!ActionMsgUtil.a(paramMessage.msgtype)) && (paramMessage.msgtype != -3001) && (paramMessage.msgtype != -30002)) {
                      if (paramMessage.msgtype != -30003) {
                        continue;
                      }
                    }
                    break;
                  }
                }
              }
              catch (Exception paramMessage)
              {
                throw paramMessage;
              }
              try
              {
                localObject1 = ActionMsgUtil.a(paramMessage.msg);
                paramMessage.msg = ((MsgBody)localObject1).msg;
                paramMessage.action = ((MsgBody)localObject1).action;
                paramMessage.shareAppID = ((MsgBody)localObject1).shareAppID;
                paramMessage.actMsgContentValue = ((MsgBody)localObject1).actMsgContentValue;
                localObject1 = null;
                if ((!AppConstants.H.equals(paramMessage.senderuin)) || (paramMessage.msgtype != -2011)) {
                  localObject1 = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
                }
                b(paramMessage);
                if (localObject1 == null) {
                  break label1132;
                }
                paramMessage.msg = ((SystemMsg)localObject1).message;
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + paramMessage.msg);
                return;
              }
              catch (Exception paramMessage)
              {
                UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg;
                throw paramMessage;
              }
            }
            paramMessage = paramMessage;
            throw paramMessage;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131434651);
          continue;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131434652);
          continue;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131434653);
          continue;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131434661);
          continue;
          localObject1 = "";
          i = ((structmsg.StructMsg)localObject4).msg.group_msg_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "groupMsgType:" + i + "|req_uin_nick:" + ((structmsg.StructMsg)localObject4).msg.req_uin_nick.get() + "|actor_uin_nick:" + ((structmsg.StructMsg)localObject4).msg.actor_uin_nick.get() + "|action_uin_nick:" + ((structmsg.StructMsg)localObject4).msg.action_uin_nick.get() + "|msg_describe:" + ((structmsg.StructMsg)localObject4).msg.msg_describe.get());
          }
          i = TroopUtils.a(i);
          if (i == 1) {
            localObject1 = ((structmsg.StructMsg)localObject4).msg.action_uin_nick.get();
          }
          for (;;)
          {
            localObject1 = TroopUtils.a((structmsg.StructMsg)localObject4, (String)localObject1 + ((structmsg.StructMsg)localObject4).msg.msg_describe.get());
            break;
            if (i == 2) {
              localObject1 = ((structmsg.StructMsg)localObject4).msg.req_uin_nick.get();
            }
          }
          label706:
          if (paramMessage.msgtype == -2011)
          {
            localObject4 = StructMsgFactory.a(paramMessage.msgData);
            localObject1 = "";
            if (localObject4 != null) {
              localObject1 = ((AbsStructMsg)localObject4).mMsgBrief;
            }
            paramMessage.msg = ((String)localObject1);
          }
          else if (paramMessage.msgtype == -5003)
          {
            localObject1 = new SubMsgType0x76.MsgBody();
            ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramMessage.msgData);
            paramMessage.msg = ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
          }
          else if (paramMessage.msgtype == -1000)
          {
            if ((paramMessage.getExtInfoFromExtStr("redbag_fold_msg").equals("true")) && (paramMessage.msgData != null))
            {
              localObject1 = new RichMsg.FoldMsg();
              try
              {
                ((RichMsg.FoldMsg)localObject1).mergeFrom(paramMessage.msgData);
                paramMessage.msg = ((RichMsg.FoldMsg)localObject1).msg_content.get().toStringUtf8();
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
              if (QLog.isColorLevel()) {
                QLog.e("msgFold", 2, "MessageForFoldMsg decodeMsg error， " + localException1.getMessage());
              }
            }
          }
          else if (paramMessage.msgtype == -5012)
          {
            if (paramMessage.msgData != null) {
              try
              {
                paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
              }
              catch (JSONException localJSONException1)
              {
                localJSONException1.printStackTrace();
              }
            }
          }
          else if (paramMessage.msgtype == -5018)
          {
            if (paramMessage.msgData != null) {
              try
              {
                paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
              }
              catch (JSONException localJSONException2)
              {
                localJSONException2.printStackTrace();
              }
            }
          }
          else if ((MsgProxyUtils.i(paramMessage.msgtype)) && (paramMessage.msgData != null))
          {
            localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
            try
            {
              localUniteGrayTipMsg.mergeFrom(paramMessage.msgData);
              paramMessage.msg = localUniteGrayTipMsg.content.get();
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            if (QLog.isColorLevel())
            {
              QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 2, "MessageForUniteGrayTip, docodeMsg failed, " + localException2.getMessage());
              continue;
              label1132:
              if (paramMessage.msgtype == -2007)
              {
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436259);
                return;
              }
              if (paramMessage.msgtype == -2058)
              {
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436260);
                return;
              }
              if (paramMessage.msgtype == -1035)
              {
                localObject2 = new MessageForMixedMsg();
                ((MessageForMixedMsg)localObject2).frienduin = paramMessage.frienduin;
                ((MessageForMixedMsg)localObject2).msgData = paramMessage.msgData;
                ((MessageForMixedMsg)localObject2).extStr = paramMessage.extStr;
                ((MessageForMixedMsg)localObject2).extLong |= 0x1;
                ((MessageForMixedMsg)localObject2).parse();
                paramMessage.msg = ((MessageForMixedMsg)localObject2).msg;
                paramMessage.msg2 = ((MessageForMixedMsg)localObject2).msg2;
                if ((paramMessage.msg2 != null) && (!"".equals(paramMessage.msg2)))
                {
                  paramMessage.emoRecentMsg = new QQText(paramMessage.msg2, 3, 16);
                  return;
                }
                if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
                  break;
                }
                paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
                return;
              }
              if ((paramMessage.msgtype == -5000) || (paramMessage.msgtype == -5001))
              {
                localObject2 = new MessageForNewGrayTips();
                ((MessageForNewGrayTips)localObject2).msgData = paramMessage.msgData;
                ((MessageForNewGrayTips)localObject2).parse();
                paramMessage.msg = ((MessageForNewGrayTips)localObject2).msg;
                if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
                  break;
                }
                paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
                return;
              }
              if ((paramMessage.msgtype == -4500) || (paramMessage.msgtype == -4502) || (paramMessage.msgtype == -4503) || (paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4509))
              {
                if (paramMessage.msgData == null) {
                  break;
                }
                localObject2 = null;
                switch (paramMessage.msgtype)
                {
                }
                while (localObject2 != null)
                {
                  ((ChatMessage)localObject2).msgData = paramMessage.msgData;
                  ((ChatMessage)localObject2).parse();
                  paramMessage.msg = ((ChatMessage)localObject2).msg;
                  if (paramMessage.msgtype != -4501) {
                    break label1679;
                  }
                  paramMessage.msg = ((MessageForDevPtt)localObject2).getSummary();
                  return;
                  localObject2 = new MessageForDeviceFile();
                  continue;
                  localObject2 = new MessageForDeviceSingleStruct();
                  continue;
                  localObject2 = new MessageForDevPtt();
                  continue;
                  localObject2 = new MessageForDevShortVideo();
                  continue;
                  localObject2 = new MessageForDevLittleVideo();
                  continue;
                  localObject2 = new MessageForNewGrayTips();
                }
                break;
                if (paramMessage.msgtype == -4503)
                {
                  paramMessage.msg = ((MessageForDevShortVideo)localObject2).getSummary();
                  return;
                }
                if (paramMessage.msgtype != -4509) {
                  break;
                }
                paramMessage.msg = ((MessageForDevLittleVideo)localObject2).getSummary();
                return;
              }
              if (paramMessage.msgtype == -2011)
              {
                localObject2 = StructMsgFactory.a(paramMessage.msgData);
                if ((paramMessage.istroop != 1) || (localObject2 == null) || (((AbsStructMsg)localObject2).mMsgServiceID != 43)) {
                  break;
                }
                paramMessage.nickName = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
                return;
              }
              if ((paramMessage.msgtype == -3006) || (paramMessage.msgtype == -5004))
              {
                if (paramMessage.msgtype == -3006)
                {
                  paramMessage.msg = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, false);
                  if (paramMessage.istroop != 1) {
                    break;
                  }
                  paramMessage.nickName = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
                  return;
                }
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436105);
                return;
              }
              if (paramMessage.msgtype != -2010) {
                break label1992;
              }
              Object localObject2 = new FunnyFaceMessage();
              try
              {
                ((FunnyFaceMessage)localObject2).readExternal(new ObjectInputStream(new ByteArrayInputStream(paramMessage.msgData)));
                if (localObject2 == null) {
                  break;
                }
                if (((FunnyFaceMessage)localObject2).faceId == 1)
                {
                  paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433410);
                  return;
                }
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageManager", 2, localException3.toString());
                  }
                  localObject3 = null;
                }
              }
            }
          }
        }
        if (((FunnyFaceMessage)localObject3).faceId != 2) {
          break;
        }
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433411);
        return;
        label1992:
        if (paramMessage.msgtype == -2000)
        {
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433004);
          return;
        }
        if (paramMessage.msgtype == -2005)
        {
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435064);
          return;
        }
        if (paramMessage.msgtype == -2020)
        {
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433330);
          if (MsgUtils.a(paramMessage.issend))
          {
            localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, "", 0, 0);
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433331, new Object[] { localObject3 });
            return;
          }
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433330);
          return;
        }
        if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
        {
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435553);
          try
          {
            localObject3 = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
            if (localObject3 == null) {
              break;
            }
            paramMessage.pttUrl = ((MessageForPtt)localObject3).url;
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
      }
      if (paramMessage.msgtype == -2025)
      {
        if (paramMessage.msgData == null) {
          break;
        }
        try
        {
          localObject3 = new MessageForQQWalletMsg();
          ((MessageForQQWalletMsg)localObject3).msgData = paramMessage.msgData;
          ((MessageForQQWalletMsg)localObject3).parse();
          paramMessage.msg = ((MessageForQQWalletMsg)localObject3).getMsgSummary();
          return;
        }
        catch (Exception paramMessage) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.BaseMessageManager", 2, paramMessage.toString());
        return;
      }
      if (paramMessage.msgtype == -2039)
      {
        paramMessage.msg = "[动作消息]";
        if (paramMessage.msgData == null) {
          break;
        }
        localObject3 = new MessageForApollo();
        ((MessageForApollo)localObject3).msgData = paramMessage.msgData;
        ((MessageForApollo)localObject3).parse();
        paramMessage.msg = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForApollo)localObject3);
        return;
      }
      if (paramMessage.msgtype == -5008)
      {
        if (paramMessage.msgData == null) {
          break;
        }
        localObject3 = new ArkAppMessage();
        ((ArkAppMessage)localObject3).fromBytes(paramMessage.msgData);
        paramMessage.msg = ((ArkAppMessage)localObject3).getSummery();
        return;
      }
      if (paramMessage.msgtype == -5016)
      {
        if (paramMessage.msgData == null) {
          break;
        }
        localObject3 = new MessageForArkBabyqReply();
        ((MessageForArkBabyqReply)localObject3).fromBytes(paramMessage.msgData);
        paramMessage.msg = ((MessageForArkBabyqReply)localObject3).getSummery();
        return;
      }
      if (paramMessage.msgtype == -5017)
      {
        if (paramMessage.msgData == null) {
          break;
        }
        localObject3 = new ArkAppMessage();
        ((ArkAppMessage)localObject3).fromBytes(paramMessage.msgData);
        paramMessage.msg = ((ArkAppMessage)localObject3).getSummery();
        return;
      }
      if (paramMessage.msgtype == -5013)
      {
        if (paramMessage.msgData == null) {
          break;
        }
        localObject3 = new ArkFlashChatMessage();
        ((ArkFlashChatMessage)localObject3).fromBytes(paramMessage.msgData);
        paramMessage.msg = ((ArkFlashChatMessage)localObject3).getSummery();
        return;
      }
      if (paramMessage.msgtype == -5014)
      {
        if (paramMessage.msgData == null) {
          break;
        }
        paramMessage.msg = ((HiBoomMessage)MessagePkgUtils.a(paramMessage.msgData)).text;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HiBoomFont.BaseMessageManager", 2, "update messageList " + paramMessage.msg);
        return;
      }
      if (paramMessage.msgtype == -2048)
      {
        localObject3 = new MessageForTroopReward();
        ((MessageForTroopReward)localObject3).msgData = paramMessage.msgData;
        ((MessageForTroopReward)localObject3).parse();
        paramMessage.msg = ((MessageForTroopReward)localObject3).getSummaryMsg();
        return;
      }
      if (paramMessage.msgtype == -2051)
      {
        localObject3 = new MessageForQQStory();
        ((MessageForQQStory)localObject3).msgData = paramMessage.msgData;
        ((MessageForQQStory)localObject3).parse();
        paramMessage.msg = ((MessageForQQStory)localObject3).getSummaryMsg();
        return;
      }
      if (paramMessage.msgtype == -7002)
      {
        localObject3 = new MessageForTribeShortVideo();
        ((MessageForTribeShortVideo)localObject3).msgData = paramMessage.msgData;
        ((MessageForTribeShortVideo)localObject3).parse();
        paramMessage.msg = ((MessageForTribeShortVideo)localObject3).getSummaryMsg();
        return;
      }
      if (paramMessage.msgtype == -2054)
      {
        localObject3 = new MessageForTroopSign();
        ((MessageForTroopSign)localObject3).msgData = paramMessage.msgData;
        ((MessageForTroopSign)localObject3).parse();
        paramMessage.msg = ((MessageForTroopSign)localObject3).getSummaryMsg();
        return;
      }
      if (paramMessage.msgtype == -5015)
      {
        paramMessage.msg = "[秀图]";
        return;
      }
      if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
        break;
      }
      Object localObject3 = paramMessage.msg;
      if (a((String)localObject3))
      {
        localObject3 = localObject3.split("\026")[1].split("\\|");
        if (localObject3 == null) {
          break;
        }
        if (localObject3.length < 2)
        {
          i = 1;
          label2869:
          paramMessage.fileType = i;
        }
        for (;;)
        {
          try
          {
            if (localObject3.length < 2)
            {
              l = -1L;
              paramMessage.fileSize = l;
            }
          }
          catch (Exception localException4)
          {
            long l;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException4);
            paramMessage.fileSize = -1L;
            continue;
            if (paramMessage.msgtype != -3001) {
              continue;
            }
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436261);
            return;
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433004);
            return;
          }
          switch (i)
          {
          case 3: 
          default: 
            return;
          case 0: 
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435064);
            return;
            i = Integer.valueOf(localObject3[2]).intValue();
            break label2869;
            l = Long.valueOf(localObject3[1]).longValue();
          }
        }
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435553);
        paramMessage.pttUrl = localObject3[0];
        return;
      }
      if (paramMessage.msgtype == -2006)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
        }
        paramMessage.msg = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435553) + "(0x7f)");
        return;
      }
      if (paramMessage.msgtype == -2008)
      {
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436144);
        return;
      }
      if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
      {
        localObject7 = MessageUtils.a(paramMessage.msg);
        localObject5 = "";
        localObject3 = localObject5;
        if (localObject7 != null)
        {
          localObject3 = localObject5;
          if (localObject7[2] != null) {
            localObject3 = localObject7[2];
          }
        }
        paramMessage.fileType = 65536;
        paramMessage.msg = ("[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433822) + "] " + (String)localObject3);
        return;
      }
      if (paramMessage.msgtype == -2029)
      {
        localObject3 = new MessageForQQWalletTips();
        ((MessageForQQWalletTips)localObject3).init(paramMessage.selfuin, paramMessage.frienduin, paramMessage.senderuin, "[QQWallet Tips]", MessageCache.a(), paramMessage.msgtype, paramMessage.istroop, MessageCache.a());
        ((MessageForQQWalletTips)localObject3).msgData = paramMessage.msgData;
        ((MessageForQQWalletTips)localObject3).isread = true;
        ((MessageForQQWalletTips)localObject3).parse();
        ((MessageForQQWalletTips)localObject3).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), null);
        paramMessage.msg = ((MessageForQQWalletTips)localObject3).summary;
        return;
      }
      localObject3 = new StringBuilder(paramMessage.msg);
      Object localObject7 = paramMessage.getExtInfoFromExtStr("disc_at_info_list");
      Object localObject5 = localObject3;
      if (paramMessage.istroop == 3000)
      {
        localObject5 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject7)) {}
      }
      try
      {
        localObject5 = BaseApplicationImpl.sApplication.getRuntime();
        if (!QQAppInterface.class.isInstance(localObject5)) {
          break label3552;
        }
        localObject5 = AtTroopMemberSpan.a((QQAppInterface)localObject5, (StringBuilder)localObject3, (String)localObject7, paramMessage.frienduin, paramMessage.isSend());
        localObject3 = localObject5;
        localObject5 = localObject3;
      }
      catch (Exception localException5)
      {
        Object localObject6;
        for (;;)
        {
          QLog.e("Q.msg.BaseMessageManager", 1, "replaceAtMsgByMarkName", localException5);
          localObject6 = localObject3;
        }
        paramMessage.emoRecentMsg = new QQText(localObject6, 3, 16);
        return;
      }
      if (paramMessage.msgtype == -1000)
      {
        localObject3 = MsgUtils.c(((StringBuilder)localObject5).toString());
        if ((!LoveLanguageManager.a(paramMessage)) || (!((LoveLanguageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273)).b())) {
          break label3607;
        }
        localObject3 = LoveLanguageManager.a((String)localObject3);
      }
      label3607:
      for (;;)
      {
        paramMessage.emoRecentMsg = new QQText((CharSequence)localObject3, 3, 16);
        return;
        label3552:
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageManager", 1, "We get error AppRuntime");
        }
        break;
      }
    }
  }
  
  public void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramRefreshMessageContext.h)
      {
        paramRefreshMessageContext.h = false;
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList != null) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      do
      {
        synchronized (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList)
        {
          MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaUtilList);
          if (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0) {
            MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaLangString, paramRefreshMessageContext.jdField_d_of_type_Int, paramRefreshMessageContext.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          ??? = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
          int j = paramRefreshMessageContext.e;
          if ((paramRefreshMessageContext.jdField_d_of_type_Boolean) && (i != 0) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramRefreshMessageContext.jdField_a_of_type_Int < 9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramRefreshMessageContext.jdField_a_of_type_Int + " ]");
            }
            paramRefreshMessageContext.jdField_a_of_type_Int += 1;
            b((String)???, paramInt, j, paramRefreshMessageContext);
            return;
          }
        }
        paramRefreshMessageContext.jdField_a_of_type_Int = 0;
        paramRefreshMessageContext.jdField_b_of_type_Int = 0;
      } while (!paramRefreshMessageContext.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject1 != null)
    {
      a((MessageRecord)localObject1, true, 4);
      b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (MessageRecord)localObject1, 4);
    }
    for (;;)
    {
      return;
      Object localObject2 = null;
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i = MsgProxyUtils.a(paramMessageRecord.istroop);
      if ((i == 1001) || (i == 10002)) {
        if (MsgProxyUtils.c(paramMessageRecord))
        {
          a(AppConstants.ae, i, paramMessageRecord.frienduin, (String)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ae, i);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject3).senderuin != null)
            {
              localObject1 = localObject2;
              if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
              {
                ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      while ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).senderuin != null) && (((QQMessageFacade.Message)localObject1).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject1).cleanMessageRecordBaseField();
        return;
        a(AppConstants.G, i, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.G, i);
        continue;
        if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1009)
        {
          a(AppConstants.v, 1009, paramMessageRecord.frienduin, (String)localObject3);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.v, 1009);
        }
        else
        {
          localObject1 = localObject2;
          if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1010) {
            if (MsgProxyUtils.c(paramMessageRecord))
            {
              a(AppConstants.af, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.af, 1010);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((QQMessageFacade.Message)localObject3).senderuin != null)
                {
                  localObject1 = localObject2;
                  if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
                  {
                    ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                    localObject1 = localObject2;
                  }
                }
              }
            }
            else
            {
              a(AppConstants.X, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.X, 1010);
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, EcShopAssistantManager paramEcShopAssistantManager)
  {
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = MsgProxyUtils.a(str, i);
    int j = 0;
    Object localObject;
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageRecord))
    {
      localObject = paramEcShopAssistantManager.a();
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(str, i);
      if (localMessageRecord == null) {
        break label159;
      }
      a(localMessageRecord, true, 4);
      i = j;
      paramMessageRecord = localMessageRecord;
    }
    for (;;)
    {
      if (((localObject != null) && (str.equals(((EcShopData)localObject).mUin))) || (i != 0))
      {
        paramEcShopAssistantManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(9970L), 7120);
        if (paramEcShopAssistantManager != null)
        {
          if (paramMessageRecord != null)
          {
            paramEcShopAssistantManager.lastmsgtime = paramMessageRecord.time;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramEcShopAssistantManager);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramEcShopAssistantManager);
        }
      }
      return;
      label159:
      paramEcShopAssistantManager.b(str);
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramMessageRecord = localMessageRecord;
      i = j;
      if (localQQMessageFacade != null)
      {
        paramEcShopAssistantManager = paramEcShopAssistantManager.a();
        paramMessageRecord = localMessageRecord;
        localObject = paramEcShopAssistantManager;
        i = j;
        if (paramEcShopAssistantManager != null)
        {
          paramMessageRecord = localQQMessageFacade.a(paramEcShopAssistantManager.mUin, 1008);
          i = 1;
          localObject = paramEcShopAssistantManager;
        }
      }
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramEntityManager = paramAddMessageContext.d;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    paramAddMessageContext = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
      }
      paramMessageRecord.extraflag = 32772;
      paramMessageRecord.sendFailCode = 0;
    }
    Object localObject;
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if (((MessageForUniteGrayTip)localObject).callback != null) {
        ((MessageForUniteGrayTip)localObject).callback.a((MessageForUniteGrayTip)localObject);
      }
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((localObject != null) && (((AbsStructMsg)localObject).mMsgServiceID == 61)) {
        paramMessageRecord.extInt = 61;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, null, paramBoolean1, paramBoolean2, paramBoolean4);
    if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) {
      if (a(paramMessageRecord, false, 1))
      {
        if ((paramEntityManager.containsKey(MsgProxyUtils.a(paramAddMessageContext, i))) && (!paramMessageRecord.isSendFromLocal())) {
          break label465;
        }
        paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1051) || ((paramMessageRecord.isLongMsg()) && (paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1))))
          {
            paramEntityManager = (LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
              continue;
            }
            paramEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
          }
        }
        catch (Exception paramEntityManager)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", paramEntityManager);
          continue;
          ThreadManager.getSubThreadHandler().postDelayed(new zoz(this, paramEntityManager, paramMessageRecord), 10000L);
        }
        try
        {
          if ((paramMessageRecord.isSendFromLocal()) || ((paramMessageRecord.msgtype != -1036) && (paramMessageRecord.msgtype != -1035))) {
            break;
          }
          paramEntityManager = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
            continue;
          }
          paramEntityManager.a(paramMessageRecord);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", paramMessageRecord);
          return;
        }
      }
      label465:
      localObject = (MessageRecord)paramEntityManager.get(MsgProxyUtils.a(paramAddMessageContext, i));
      if (a(paramMessageRecord) >= a((MessageRecord)localObject))
      {
        paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
        continue;
        a(paramMessageRecord, true, 1);
        continue;
        ThreadManager.getSubThreadHandler().postDelayed(new zoy(this, paramEntityManager, paramMessageRecord), 10000L);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    Object localObject1 = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!MsgProxyUtils.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label450;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + paramMessageRecord);
      }
      Object localObject2 = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(localObject2))
      {
        localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((!paramMessageRecord.isread) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop, (MessageRecord)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      int k = ((List)localObject1).size();
      for (;;)
      {
        if (j < k)
        {
          localObject2 = (MessageRecord)((List)localObject1).get(j);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject2).istroop).a((MessageRecord)localObject2, paramBoolean2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject2);
          j += 1;
          continue;
          ((List)localObject1).add(paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord);
      }
      if (i != 0)
      {
        localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        if (!MsgProxyUtils.r(paramMessageRecord.istroop)) {
          break label352;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).f();
        }
        return;
        label352:
        if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))
        {
          a(paramMessageRecord, (EcShopAssistantManager)localObject1);
        }
        else if ((paramMessageRecord.istroop == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((paramMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
        }
      }
      label450:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt1;
    paramRefreshMessageContext.e = paramInt2;
    if (MsgProxyUtils.a(paramInt1) != 1032) {}
    for (String str = MsgProxyUtils.a(paramString, paramInt1); this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(str); str = ConfessMsgUtil.a(paramString, paramInt1, paramRefreshMessageContext.jdField_f_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      if ((paramRefreshMessageContext.h) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.BaseMessageManager", 2, "numTroopRefresh = " + paramRefreshMessageContext.h + ", refreshActionMap[" + MsgProxyUtils.a(paramString, paramInt1) + "] = " + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(str));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(str, Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new zow(this, paramString, paramInt1, paramInt2, paramRefreshMessageContext, str));
  }
  
  public void a(String paramString, int paramInt, long paramLong) {}
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong + ",force=" + paramBoolean);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong);
    a(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((MsgProxyUtils.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    while ((paramMessageRecord == null) || (localList == null) || (localList.isEmpty()) || (paramMessageRecord.uniseq != ((MessageRecord)localList.get(localList.size() - 1)).uniseq)) {
      return;
    }
    a(paramMessageRecord, true, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, true);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    String str;
    if (MsgProxyUtils.c(paramString1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, 0);
      str = "";
      if (paramInt1 == 1010) {
        str = AppConstants.X;
      }
    }
    label40:
    label48:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label48;
                break label48;
                break label48;
                break label48;
                break label48;
                break label48;
                break label48;
                if (TextUtils.isEmpty(str)) {}
                for (;;)
                {
                  return;
                  if ((paramInt1 != 1001) && (paramInt1 != 10002)) {
                    break label40;
                  }
                  str = AppConstants.G;
                  break label40;
                  QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt1);
                  if ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString2))) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(str, paramInt1, paramString1, paramString3, 0);
                  paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString1, paramInt1);
                  if ((paramString2 != null) && (!paramString2.isEmpty()))
                  {
                    paramString2 = (MessageRecord)paramString2.get(paramString2.size() - 1);
                    paramString3 = MessageRecordFactory.a(paramString2.msgtype);
                    MessageRecord.copyMessageRecordBaseField(paramString3, paramString2);
                    paramString3.frienduin = str;
                    paramString3.senderuin = paramString1;
                    if (!MsgProxyUtils.g(paramString2.msgtype)) {
                      a(paramString3, null, false, true, 1);
                    }
                    MessageRecord.copyMessageRecordBaseField(localMessage, paramString2);
                    localMessage.frienduin = paramString1;
                    localMessage.emoRecentMsg = null;
                  }
                  try
                  {
                    a(localMessage);
                    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(str, paramInt1);
                    if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1)))
                    {
                      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(str, paramInt1);
                      if ((paramString1 != null) && (!paramString1.isEmpty()))
                      {
                        MessageRecord.copyMessageRecordBaseField(paramString2, (MessageRecord)paramString1.get(paramString1.size() - 1));
                        paramString2.frienduin = str;
                        paramString2.emoRecentMsg = null;
                        try
                        {
                          a(paramString2);
                          return;
                        }
                        catch (Throwable paramString1) {}
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
                      }
                    }
                  }
                  catch (Throwable paramString2)
                  {
                    for (;;)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox decode msgInLBSBox ERROR", paramString2);
                      }
                    }
                    paramString2.emoRecentMsg = null;
                    paramString2.msg = null;
                  }
                }
              } while (!paramBoolean);
              paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, paramInt1);
            } while (paramString1 == null);
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
            return;
            paramInt2 = MsgProxyUtils.a(paramInt2, paramInt3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2);
            paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt1);
          } while ((paramString3.senderuin == null) || (!paramString3.senderuin.equals(paramString2)) || ((paramInt2 != 0) && ((paramInt2 == 0) || (paramInt2 != paramString3.getExtraKey()))));
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString1, paramInt1);
          if ((paramString2 == null) || (paramString2.isEmpty())) {
            break;
          }
          MessageRecord.copyMessageRecordBaseField(paramString3, (MessageRecord)paramString2.get(paramString2.size() - 1));
          paramString3.frienduin = paramString1;
          paramString3.emoRecentMsg = null;
          try
          {
            a(paramString3);
            return;
          }
          catch (Throwable paramString1) {}
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
        return;
        paramString3.emoRecentMsg = null;
        paramString3.msg = null;
        ConfessMsgUtil.a(paramString3);
      } while (!paramBoolean);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramInt1);
    } while (paramString1 == null);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt))) {}
    do
    {
      do
      {
        return;
        if ((paramInt != 1008) || (!ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
          break;
        }
        paramString2 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      } while (paramString2 == null);
      paramString2.a(paramString1, paramLong);
      return;
    } while (MsgProxyUtils.a(paramInt) == 1032);
    RecentUserProxy localRecentUserProxy;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt)) || (!MsgProxyUtils.r(paramInt)))
    {
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (0L == paramLong)
      {
        paramString2 = localRecentUserProxy.b(paramString1, paramInt);
        if (paramString2 == null) {
          break label235;
        }
        paramString2.lastmsgdrafttime = paramLong;
        if ((0L != paramLong) || (paramString2.lastmsgtime != 0L)) {
          break label220;
        }
        localRecentUserProxy.b(paramString2);
      }
    }
    for (;;)
    {
      if ((paramInt == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
        ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString3, paramLong);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString2);
      return;
      RecentUser localRecentUser = localRecentUserProxy.a(paramString1, paramInt);
      localRecentUser.troopUin = paramString2;
      paramString2 = localRecentUser;
      break;
      label220:
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localRecentUserProxy.a(paramString2);
      label235:
      continue;
      paramString2 = null;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramInt, paramString2, paramString3, paramInt, 0, paramBoolean);
  }
  
  public abstract void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle);
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l = 0L;
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + paramString + ",type=" + paramInt1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
    }
    for (;;)
    {
      return;
      int i = 0;
      if (QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt1)) {
        i = 1;
      }
      MessageRecord localMessageRecord;
      ConversationFacade localConversationFacade;
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1) > 0)
        {
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1);
          localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localMessageRecord != null) {
            l = a(localMessageRecord);
          }
          localConversationFacade.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
          a(paramString, paramInt1);
          i = j;
        }
      }
      while (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1, paramInt2));
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramInt2) > 0)
          {
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, paramInt2);
            localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (localMessageRecord != null) {
              l = a(localMessageRecord);
            }
            localConversationFacade.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2, paramInt2);
            a(paramString, paramInt1);
            i = j;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          }
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Object localObject2 = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)localObject2).jdField_a_of_type_Int;
    String str = ((RevokeMsgInfo)localObject2).jdField_a_of_type_JavaLangString;
    int j = ((RevokeMsgInfo)localObject2).e;
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify frienduin = " + str + ", istroop = " + i);
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).e(str, i);
    if ((??? == null) || (((List)???).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, i, UncommonMessageProcessor.jdField_d_of_type_Int, UncommonMessageProcessor.j);
    }
    List localList;
    do
    {
      return;
      localList = a((List)???, str, i, paramArrayList);
      if ((localList == null) || (localList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(str, i, UncommonMessageProcessor.jdField_d_of_type_Int, UncommonMessageProcessor.k);
        return;
      }
      if ((localList == null) || (localList.size() != 1) || (!UniteGrayTipUtil.a((MessageRecord)localList.get(0)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
      }
      paramArrayList = (MessageRecord)localList.get(0);
    } while (!(paramArrayList instanceof MessageForUniteGrayTip));
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)paramArrayList, i);
    return;
    Object localObject3 = (MessageRecord)localList.get(0);
    ??? = localList.iterator();
    while (((Iterator)???).hasNext())
    {
      paramArrayList = (MessageRecord)((Iterator)???).next();
      if ((paramArrayList.shmsgseq == ((RevokeMsgInfo)localObject2).jdField_a_of_type_Long) && (paramArrayList.msgUid == ((RevokeMsgInfo)localObject2).jdField_b_of_type_Long)) {
        localObject3 = paramArrayList;
      }
    }
    for (;;)
    {
      ??? = null;
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      long l;
      if ((j == 1) || (j == 2))
      {
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (((MessageRecord)localList.get(0)).msgtype != -2006)
        {
          l = ((MessageRecord)localList.get(0)).time;
          if ((((RevokeMsgInfo)localObject2).jdField_c_of_type_JavaLangString == null) || (b(((RevokeMsgInfo)localObject2).jdField_c_of_type_JavaLangString))) {
            break label723;
          }
          localObject2 = a(i, "你", ((RevokeMsgInfo)localObject2).jdField_c_of_type_JavaLangString, str, paramArrayList, localMessageForUniteGrayTip, l);
          label466:
          ((UniteGrayTipParam)localObject2).e = true;
          ((UniteGrayTipParam)localObject2).jdField_f_of_type_Boolean = false;
          localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
          localMessageForUniteGrayTip.msgUid = ((MessageRecord)localObject3).msgUid;
          localMessageForUniteGrayTip.shmsgseq = ((MessageRecord)localObject3).shmsgseq;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doReplaceRevokedMsgAndNotify senderUin=", paramArrayList, ",frienduin=", str });
          }
          UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip, localList, i, (String)???, (UniteGrayTipParam)localObject2);
          paramArrayList = localList.iterator();
          label570:
          do
          {
            if (!paramArrayList.hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, false);
          } while (((MessageRecord)localObject2).msgtype != -2005);
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject2 = ((FileManagerDataCenter)???).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject2 != null)
          {
            ((FileManagerDataCenter)???).b((FileManagerEntity)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject2).nSessionId);
          }
          if (((MessageRecord)localObject3).istroop != 3000) {
            break label851;
          }
          FileManagerReporter.a("0X8005E50");
        }
      }
      for (;;)
      {
        FileManagerReporter.a("0X8005E4C");
        break label570;
        l = ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long;
        break;
        label723:
        ??? = "你" + BaseApplicationImpl.getApplication().getString(2131430832);
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = new UniteGrayTipParam(str, paramArrayList, (String)???, i, -5040, 1, ((MessageRecord)localObject3).time);
        break label466;
        ??? = "你" + BaseApplicationImpl.getApplication().getString(2131438085);
        paramArrayList = ((MessageRecord)localObject3).senderuin;
        localObject2 = new UniteGrayTipParam(str, paramArrayList, (String)???, i, -5040, 1, ((MessageRecord)localObject3).time);
        break label466;
        label851:
        FileManagerReporter.a("0X8005E4D");
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).f(str, i);
      synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(str, i))
      {
        MsgProxyUtils.a(paramArrayList, localMessageForUniteGrayTip, true);
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(null, true);
        return;
      }
    }
  }
  
  protected void a(List paramList)
  {
    if ((Looper.myLooper() == Looper.getMainLooper()) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForText)) {
          ((MessageForText)localMessageRecord).parse();
        }
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (paramList.size() == 0) {}
    label774:
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = (MessageRecord)paramList.get(0);
      int i = 1;
      Object localObject2;
      if (i < paramList.size())
      {
        localObject2 = (MessageRecord)paramList.get(i);
        if ((((MessageRecord)localObject2).istroop == 1) || (((MessageRecord)localObject2).istroop == 3000)) {
          if (((MessageRecord)localObject2).shmsgseq > ((MessageRecord)localObject3).shmsgseq) {
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          i += 1;
          localObject3 = localObject1;
          break;
          localObject1 = localObject3;
          if (((MessageRecord)localObject2).shmsgseq == ((MessageRecord)localObject3).shmsgseq)
          {
            localObject1 = localObject3;
            if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId())
            {
              localObject1 = localObject2;
              continue;
              if (((MessageRecord)localObject2).time > ((MessageRecord)localObject3).time)
              {
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject3;
                if (((MessageRecord)localObject2).time == ((MessageRecord)localObject3).time)
                {
                  localObject1 = localObject3;
                  if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId()) {
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
        }
      }
      Object localObject1 = paramList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForLongMsg)) {
          localArrayList.addAll(((MessageForLongMsg)localObject2).longMsgFragmentList);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + localObject2);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject2);
          break;
          localArrayList.add(localObject2);
        }
      }
      localObject1 = MsgProxyUtils.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(localObject1))
      {
        localObject1 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramList.next();
            if (!localMessageRecord.isread) {
              ((List)localObject2).add(localMessageRecord);
            }
          }
          if (((List)localObject2).size() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, (List)localObject2);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject3).istroop).a(localArrayList, paramBoolean2);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((MessageRecord)localObject1);
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList);
      }
      if ((localObject3 instanceof MessageForLongMsg))
      {
        if (!MsgProxyUtils.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop))) {
          break label665;
        }
        i = j;
        if (i != 0)
        {
          paramList = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
          if (!MsgProxyUtils.r(((MessageRecord)localObject3).istroop)) {
            break label671;
          }
          a((MessageRecord)localObject3);
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label774;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject3).istroop).f();
        return;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject3)) {
          break;
        }
        label665:
        i = 0;
        break;
        label671:
        if (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin))
        {
          a((MessageRecord)localObject3, paramList);
        }
        else if ((((MessageRecord)localObject3).istroop == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((((MessageRecord)localObject3).istroop != 1008) || (!ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if (localMessageForShortVideo.busiType == 0)
      {
        if ((localMessageForShortVideo.videoFileStatus == 1007) || ((localMessageForShortVideo.videoFileStatus == 1003) && (localMessageForShortVideo.extraflag == 32772))) {}
        for (boolean bool = true; !bool; bool = false) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, holdFlag: " + bool);
        }
        e(paramMessageRecord);
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
        e(paramMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    boolean bool1;
    if (paramMessageRecord == null)
    {
      bool1 = false;
      return bool1;
    }
    if (paramMessageRecord.isLongMsg())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord))
      {
        if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(AppConstants.C).equals(paramMessageRecord.frienduin))) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
        }
        return false;
      }
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
    }
    for (;;)
    {
      if (QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)) {
        return false;
      }
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool2 = false;
      bool1 = bool2;
      if (!paramMessageRecord.isValid) {
        break;
      }
      bool1 = bool2;
      if (MsgProxyUtils.g(paramMessageRecord.msgtype)) {
        break;
      }
      if (paramMessageRecord.frienduin.equals(AppConstants.ap))
      {
        bool1 = bool2;
        if (paramMessageRecord.istroop == 0) {
          break;
        }
      }
      if (paramMessageRecord.frienduin.equals(AppConstants.aw))
      {
        bool1 = bool2;
        if (paramMessageRecord.istroop == 0) {
          break;
        }
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + localMessage.getBaseInfoString());
      }
      int i;
      if (paramInt == 1)
      {
        i = 0;
        if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1))
        {
          paramInt = i;
          if (!paramMessageRecord.isSendFromLocal())
          {
            paramInt = i;
            if (paramMessageRecord.shmsgseq < localMessage.shmsgseq) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          i = paramInt;
          if (MsgProxyUtils.d(paramMessageRecord.senderuin))
          {
            i = paramInt;
            if (TextUtils.equals(paramMessageRecord.senderuin, localMessage.senderuin)) {
              i = 0;
            }
          }
          if (!MsgProxyUtils.a(paramMessageRecord, localMessage)) {
            break label1234;
          }
          if (paramMessageRecord.longMsgIndex < localMessage.longMsgIndex) {
            break;
          }
          return false;
          paramInt = i;
          if (MsgProxyUtils.c(paramMessageRecord.istroop))
          {
            paramInt = i;
            if (!paramMessageRecord.isSendFromLocal())
            {
              paramInt = i;
              if (paramMessageRecord.time < localMessage.time) {
                paramInt = 1;
              }
            }
          }
        }
      }
      label1234:
      for (paramInt = 0;; paramInt = i)
      {
        bool1 = bool3;
        if (paramInt == 0)
        {
          MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
          localMessage.emoRecentMsg = null;
          localMessage.fileType = -1;
          localMessage.lastMsg = null;
          if (!paramBoolean) {}
        }
        do
        {
          for (;;)
          {
            try
            {
              a(localMessage);
              Object localObject;
              if ((paramMessageRecord instanceof MessageForReplyText))
              {
                localObject = (MessageForReplyText)paramMessageRecord;
                if ((((MessageForReplyText)localObject).atInfoList != null) && (((MessageForReplyText)localObject).atInfoList.size() > 0) && (TextUtils.isEmpty(((MessageForReplyText)localObject).mSourceMsgInfo.mAnonymousNickName)))
                {
                  localObject = (MessageForText.AtTroopMemberInfo)((MessageForReplyText)localObject).atInfoList.get(0);
                  localMessage.msg = localMessage.msg.substring(((MessageForText.AtTroopMemberInfo)localObject).textLen + 1);
                }
              }
              bool1 = true;
              if ((!paramMessageRecord.isSend()) && (!MessageUtils.a(paramMessageRecord.msgtype)))
              {
                localMessage.hasReply = true;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + localMessage + ",hasReply=" + localMessage.hasReply);
                }
              }
              if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034))
              {
                i = 1;
                if (((paramMessageRecord.isSendFromLocal()) || (paramMessageRecord.isread) || (i != 0)) && (paramMessageRecord.msgtype != -1013) && (paramMessageRecord.msgtype != -1019))
                {
                  paramBoolean = bool1;
                  if (paramMessageRecord.msgtype != -1018) {}
                }
                else
                {
                  if ((paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
                  }
                  if (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && (MsgProxyUtils.c(paramMessageRecord))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
                  }
                  if ((!String.valueOf(AppConstants.C).equals(localMessage.frienduin)) && ((!MsgProxyUtils.c(localMessage)) || (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))
                  {
                    if ((paramMessageRecord instanceof MessageForNearbyLiveTip)) {
                      localMessage.nickName = ((MessageForNearbyLiveTip)paramMessageRecord).nickName;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
                  }
                  if (((localMessage.msgtype == -2009) || (localMessage.msgtype == -2016)) && (paramInt != 0))
                  {
                    localObject = new QQMessageFacade.Message();
                    MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramMessageRecord);
                    ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
                    ((QQMessageFacade.Message)localObject).fileType = -1;
                    localMessage.lastMsg = null;
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b((QQMessageFacade.Message)localObject);
                  }
                  paramBoolean = bool1;
                  if (AppConstants.L.equals(localMessage.frienduin))
                  {
                    paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    if (paramInt <= 0) {
                      continue;
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
                    paramBoolean = bool1;
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + localMessage.getBaseInfoString() + " , result = " + paramBoolean);
                }
                bool1 = paramBoolean;
                if (!MsgProxyUtils.a(localMessage.frienduin, localMessage.istroop)) {
                  break;
                }
                localMessage.istroop = MsgProxyUtils.a(localMessage.istroop);
                return paramBoolean;
              }
            }
            catch (Throwable localThrowable)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable);
              continue;
              i = 0;
              continue;
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
              paramBoolean = bool1;
              continue;
            }
            if ((paramInt == 4) || (paramInt == 2))
            {
              MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
              localMessage.emoRecentMsg = null;
              localMessage.fileType = -1;
              localMessage.lastMsg = null;
              if (paramBoolean) {}
              try
              {
                a(localMessage);
                paramBoolean = true;
              }
              catch (Throwable paramMessageRecord)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                  }
                }
              }
            }
          }
          paramBoolean = bool4;
        } while (paramInt != 3);
        if (localMessage.uniseq == paramMessageRecord.uniseq) {
          MessageRecord.copyMessageRecordStatusField(localMessage, paramMessageRecord);
        }
        for (;;)
        {
          paramBoolean = true;
          break;
          MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
          localMessage.emoRecentMsg = null;
          localMessage.fileType = -1;
          localMessage.lastMsg = null;
          try
          {
            a(localMessage);
          }
          catch (Throwable paramMessageRecord) {}
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
          }
        }
      }
    }
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if (paramString == null)
    {
      paramEntityManager = new QQMessageFacade.Message();
      return paramEntityManager;
    }
    String str1 = MsgProxyUtils.a(paramString, paramInt1);
    Object localObject = null;
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str1);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt1);
    if ((localMessage == null) || (!localMessage.isCacheValid) || (localMessage.getConfessTopicId() != paramInt2))
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(str2, paramEntityManager, paramInt2);
      localObject = localMessage;
      if (localMessage != null)
      {
        localObject = localMessage;
        if (localMessage.uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage.istroop).b(localMessage.frienduin, localMessage.istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage.istroop).a(str2, paramEntityManager, paramInt2);
          localObject = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject = paramEntityManager;
          }
        }
      }
      if ((localObject != null) && (((QQMessageFacade.Message)localObject).isSendFromLocal()) && (((QQMessageFacade.Message)localObject).extraflag == 32772) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject))) {
        ((QQMessageFacade.Message)localObject).extraflag = 32768;
      }
      paramEntityManager = (EntityManager)localObject;
      if (localObject == null)
      {
        paramEntityManager = new QQMessageFacade.Message();
        paramEntityManager.frienduin = paramString;
        paramEntityManager.istroop = paramInt1;
        paramEntityManager.setConfessTopicId(paramInt2);
      }
    }
    for (;;)
    {
      try
      {
        paramString = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str1);
        if (paramString != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramEntityManager);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramEntityManager);
        paramString = paramEntityManager;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramEntityManager;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramString = paramEntityManager;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramEntityManager = paramString;
      if (paramString == null) {
        break;
      }
      paramEntityManager = paramString;
      if (!MsgProxyUtils.a(paramString.frienduin, paramString.istroop)) {
        break;
      }
      paramString.istroop = MsgProxyUtils.a(paramString.istroop);
      return paramString;
      if (a(paramString) < a(paramEntityManager))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramEntityManager);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramEntityManager);
        paramString = paramEntityManager;
      }
      else if ((!paramString.isCacheValid) && (paramEntityManager.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramEntityManager);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramEntityManager);
        paramString = paramEntityManager;
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramString.isCacheValid = true;
        continue;
        paramString = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localMessage);
          paramString = localThrowable;
        }
      }
    }
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      this.b.notify();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
      }
      return;
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage) {}
  
  public void b(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = paramRefreshMessageContext.h;
      if (bool) {}
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(40000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
        }
        return;
      }
      catch (InterruptedException paramRefreshMessageContext)
      {
        for (;;)
        {
          paramRefreshMessageContext.printStackTrace();
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = MsgProxyUtils.a((String)localObject, j);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageRecord)) {
      if (j != 1026) {
        break label237;
      }
    }
    label237:
    for (int i = 1;; i = j)
    {
      RecentUser localRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((String)localObject, j);
      if (localObject != null)
      {
        a((MessageRecord)localObject, true, 4);
        if (localRecentUser != null)
        {
          if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
            localRecentUser.troopUin = ((MessageRecord)localObject).senderuin;
          }
          localRecentUser.type = i;
          localRecentUser.lastmsgtime = ((MessageRecord)localObject).time;
          HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localRecentUser);
        }
      }
      for (;;)
      {
        if (localRecentUser != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
        }
        return;
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.remove(paramMessageRecord);
        }
      }
    }
  }
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext);
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    long l;
    Object localObject;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      l = a(paramString, paramInt1);
      if (l != 0L)
      {
        if (MsgProxyUtils.a(paramInt1) != 1009) {
          break label273;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.v, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString)))
        {
          paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = AppConstants.v;
          if (paramInt2 != 3) {
            break label181;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.v, 1009, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.v, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label181:
    do
    {
      do
      {
        MessageRecord localMessageRecord;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    int i;
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    if (paramInt2 == 2)
                                    {
                                      a(paramString, true, paramInt2);
                                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.v, 1009, l, paramMessageRecord.msg);
                                      return;
                                    }
                                  } while (paramInt2 != 4);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.v, 1009, paramString.senderuin, paramString.selfuin, 0);
                                  a(paramString, null, false, true, paramInt2);
                                  a(paramString, true, paramInt2);
                                  return;
                                  if ((MsgProxyUtils.a(paramInt1) != 1001) && (MsgProxyUtils.a(paramInt1) != 10002)) {
                                    break label1072;
                                  }
                                  i = MsgProxyUtils.a(paramInt1);
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                                  bool2 = MsgProxyUtils.c(paramMessageRecord);
                                  bool1 = false;
                                  if (bool2) {
                                    bool1 = ((ConversationFacade)localObject).a(paramString, i, AppConstants.G);
                                  }
                                  if ((!bool2) || (bool1)) {
                                    break;
                                  }
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.ae, i);
                                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                                paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                                paramString.frienduin = AppConstants.ae;
                                paramString.senderuin = paramMessageRecord.frienduin;
                                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                                localMessageRecord.frienduin = AppConstants.G;
                                localMessageRecord.senderuin = AppConstants.ae;
                                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.G, i);
                                if (paramInt2 != 3) {
                                  break;
                                }
                                a(paramString, true, paramInt2);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ae, i, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ae, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.ae)));
                              a(localMessageRecord, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              return;
                              if (paramInt2 != 2) {
                                break;
                              }
                              a(paramString, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ae, i, l, paramMessageRecord.msg);
                            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.ae)));
                            a(localMessageRecord, true, paramInt2);
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, l, paramMessageRecord.msg);
                            return;
                          } while (paramInt2 != 4);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.ae, i, paramString.senderuin, paramString.selfuin, 0);
                          a(paramString, null, false, true, 1);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
                          a(localMessageRecord, null, false, true, 1);
                          a(paramString, true, paramInt2);
                        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.ae)));
                        a(localMessageRecord, true, paramInt2);
                        return;
                        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.G, i);
                      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
                      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                      paramString.selfuin = paramMessageRecord.selfuin;
                      paramString.senderuin = paramMessageRecord.frienduin;
                      paramString.frienduin = AppConstants.G;
                      if (paramInt2 == 3)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                        return;
                      }
                      if (paramInt2 == 2)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, l, paramMessageRecord.msg);
                        return;
                      }
                    } while (paramInt2 != 4);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.G, i, paramString.senderuin, paramString.selfuin, 0);
                    a(paramString, null, false, true, paramInt2);
                    a(paramString, true, paramInt2);
                    return;
                  } while (MsgProxyUtils.a(paramInt1) != 1010);
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                  boolean bool2 = MsgProxyUtils.c(paramMessageRecord);
                  boolean bool1 = false;
                  if (bool2) {
                    bool1 = ((ConversationFacade)localObject).a(paramString, 1010, AppConstants.X);
                  }
                  if ((!bool2) || (bool1)) {
                    break;
                  }
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.af, 1010);
                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.frienduin = AppConstants.af;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localMessageRecord = MessageRecordFactory.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                localMessageRecord.frienduin = AppConstants.X;
                localMessageRecord.senderuin = AppConstants.af;
                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.X, 1010);
                if (paramInt2 != 3) {
                  break;
                }
                a(paramString, true, paramInt2);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1010, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.af)));
              a(localMessageRecord, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
              if (paramInt2 != 2) {
                break;
              }
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1010, l, paramMessageRecord.msg);
            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.af)));
            a(localMessageRecord, true, paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, l, paramMessageRecord.msg);
            return;
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1010, paramString.senderuin, paramString.selfuin, 0);
          a(paramString, null, false, true, 1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
          a(localMessageRecord, null, false, true, 1);
          a(paramString, true, paramInt2);
        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.af)));
        a(localMessageRecord, true, paramInt2);
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.X, 1010);
      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = AppConstants.X;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label273:
    label1072:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.X, 1010, paramString.senderuin, paramString.selfuin, 0);
    a(paramString, null, false, true, paramInt2);
    a(paramString, true, paramInt2);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded boxUin=" + paramString + ",boxType=" + paramInt + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : boxUin=null");
      }
    }
    do
    {
      return;
      if (MsgProxyUtils.a(paramString, paramInt)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
    return;
    Object localObject = null;
    if (paramString.equals(AppConstants.G)) {
      localObject = AppConstants.ae;
    }
    ConversationFacade localConversationFacade;
    while (localObject != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, paramInt) > 0)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject, paramInt);
        localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (paramString != null) {
          l = a(paramString);
        }
        localConversationFacade.a((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
        a((String)localObject, paramInt);
        return;
        if (paramString.equals(AppConstants.X)) {
          localObject = AppConstants.af;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
      localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        l = a((MessageRecord)localObject);
      }
      localConversationFacade.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      a(paramString, paramInt);
    }
    for (int i = 1;; i = 0)
    {
      if (paramString.equals(AppConstants.aE))
      {
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
      }
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
      }
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.get(0);
    int i;
    int n;
    Object localObject2;
    Object localObject4;
    String str2;
    int k;
    String str1;
    Object localObject3;
    label184:
    boolean bool;
    if (localRevokeMsgInfo.jdField_c_of_type_Int > 1)
    {
      i = 1;
      n = localRevokeMsgInfo.jdField_a_of_type_Int;
      localObject2 = localRevokeMsgInfo.jdField_b_of_type_JavaLangString;
      ??? = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
      localObject4 = localRevokeMsgInfo.jdField_c_of_type_JavaLangString;
      str2 = localRevokeMsgInfo.d;
      k = localRevokeMsgInfo.e;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify fromUin = " + (String)localObject2 + ", istroop = " + n + ",toUin=" + (String)??? + ",groupUin=" + (String)localObject4 + ",authorUin=" + str2 + ",opType= " + k);
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject3 = localObject4;
      if (n != 1004)
      {
        if (n != 1000) {
          break label303;
        }
        localObject3 = localObject4;
      }
      bool = TextUtils.equals(str1, (CharSequence)localObject2);
      if ((n != 3000) && (n != 1)) {
        break label310;
      }
    }
    ArrayList localArrayList;
    Object localObject6;
    label303:
    label310:
    while (bool)
    {
      localArrayList = new ArrayList();
      localObject4 = paramArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (RevokeMsgInfo)((Iterator)localObject4).next();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)???, n, ((RevokeMsgInfo)localObject6).jdField_a_of_type_Long, ((RevokeMsgInfo)localObject6).jdField_b_of_type_Long);
        if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
          localArrayList.addAll((Collection)localObject6);
        }
      }
      i = 0;
      break;
      localObject3 = localObject2;
      break label184;
    }
    for (;;)
    {
      ??? = localObject2;
    }
    if (i != 0) {}
    try
    {
      Collections.sort(localArrayList, MsgProxyUtils.a);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        if (UniteGrayTipUtil.a((MessageRecord)localArrayList.get(0))) {
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", localException);
          }
        }
        if ((((MessageRecord)localArrayList.get(0)).msgtype != -2006) || (!(localArrayList.get(0) instanceof MessageForFoldMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
      return;
      int j = 1;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        j = 0;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayList);
          return;
        }
      }
      localObject6 = new MessageForUniteGrayTip();
      long l;
      label545:
      label604:
      label736:
      int m;
      label697:
      label844:
      Object localObject5;
      if ((j != 0) && (((MessageRecord)localArrayList.get(0)).msgtype != -2006))
      {
        l = ((MessageRecord)localArrayList.get(0)).time;
        if (!bool) {
          break label1008;
        }
        paramArrayList = "你";
        if ((k != 1) && (k != 2)) {
          break label1373;
        }
        if (!TextUtils.equals((CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label1182;
        }
        if ((str2 == null) || (b(str2))) {
          break label1142;
        }
        paramArrayList = a(n, paramArrayList, str2, (String)???, (String)localObject3, (MessageForUniteGrayTip)localObject6, l);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doHandleRevokedNotifyAndNotify isRevokeSender = ", Boolean.valueOf(bool), ",selfuin=", str1, ",fromUin=", localObject2 });
        }
        paramArrayList.e = true;
        paramArrayList.jdField_f_of_type_Boolean = false;
        ((MessageForUniteGrayTip)localObject6).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
        if (j == 0) {
          break label1450;
        }
        l = ((MessageRecord)localArrayList.get(0)).msgUid;
        ((MessageForUniteGrayTip)localObject6).msgUid = l;
        ((MessageForUniteGrayTip)localObject6).shmsgseq = localRevokeMsgInfo.jdField_a_of_type_Long;
        if (bool) {
          UniteGrayTipUtil.a(localArrayList);
        }
        if (j == 0) {
          break label1534;
        }
        paramArrayList = localArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break label1534;
        }
        localObject2 = (MessageRecord)paramArrayList.next();
        m = 0;
        k = m;
        if (i != 0)
        {
          k = m;
          if (!((MessageRecord)localObject2).isread)
          {
            k = m;
            if (localObject2 != localArrayList.get(0))
            {
              ((MessageRecord)localObject2).isread = true;
              if (n != 1)
              {
                k = m;
                if (n != 3000) {}
              }
              else
              {
                k = 1;
              }
            }
          }
        }
        if (k == 0) {
          break label1460;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(n).a((MessageRecord)localObject2, false);
        if ((((MessageRecord)localObject2).msgtype == -2005) || ((localObject2 instanceof MessageForTroopFile))) {
          if (((MessageRecord)localObject2).msgtype == -2005)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            localObject5 = ((FileManagerDataCenter)localObject3).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
            if (localObject5 == null) {
              break label1489;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
            }
            ((FileManagerDataCenter)localObject3).b((FileManagerEntity)localObject5);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject5).nSessionId);
          }
        }
      }
      for (;;)
      {
        ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(271)).b((MessageRecord)localObject2);
        localObject2 = EmojiStickerManager.a((MessageRecord)localObject2);
        if (localObject2 == null) {
          break label736;
        }
        EmojiStickerManager.a().b.put(localObject2, Boolean.valueOf(true));
        break label736;
        l = localRevokeMsgInfo.jdField_c_of_type_Long;
        break;
        label1008:
        if (n == 1)
        {
          paramArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d((String)???);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.jdField_b_of_type_Int);
          ((Bundle)localObject5).putLong(ContactUtils.jdField_b_of_type_JavaLangString, ((MessageForUniteGrayTip)localObject6).uniseq);
          localObject5 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)???, paramArrayList, true, (Bundle)localObject5);
          paramArrayList = (ArrayList)localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            paramArrayList = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)???, 1, 0);
          }
          break label545;
        }
        if (n == 3000)
        {
          paramArrayList = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, (String)???, 2, 0);
          break label545;
        }
        paramArrayList = "对方";
        break label545;
        label1142:
        paramArrayList = new UniteGrayTipParam((String)???, (String)localObject3, paramArrayList.concat(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131430832)), n, -5040, 1, l);
        break label604;
        label1182:
        if (k == 2) {}
        for (localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131430575);; localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131430574))
        {
          k = ((String)localObject5).length();
          m = ((String)localObject5).length();
          int i1 = paramArrayList.length();
          paramArrayList = new UniteGrayTipParam((String)???, (String)localObject3, (String)localObject5 + paramArrayList + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131430832), n, -5040, 1, l);
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.jdField_b_of_type_Int);
          ((Bundle)localObject3).putLong(ContactUtils.jdField_b_of_type_JavaLangString, ((MessageForUniteGrayTip)localObject6).uniseq);
          ((Bundle)localObject3).putInt("key_action", 5);
          ((Bundle)localObject3).putString("troop_mem_uin", String.valueOf(localObject2));
          ((Bundle)localObject3).putBoolean("need_update_nick", true);
          paramArrayList.a(k, m + i1, (Bundle)localObject3);
          break;
        }
        label1373:
        localObject5 = paramArrayList;
        if (paramArrayList.length() > 12) {
          localObject5 = paramArrayList.substring(0, 11) + "...";
        }
        paramArrayList = new UniteGrayTipParam((String)???, (String)localObject3, ((String)localObject5).concat(BaseApplicationImpl.getApplication().getString(2131438085)), n, -5040, 1, l);
        break label604;
        label1450:
        l = localRevokeMsgInfo.jdField_b_of_type_Long;
        break label697;
        label1460:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, false);
        break label844;
        label1489:
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageManager", 2, "can't find fileEntity,uniseq[" + ((MessageRecord)localObject2).uniseq + "],");
        }
      }
      label1534:
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(n).f((String)???, n);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
        }
      }
      for (;;)
      {
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject6);
        if (j != 0)
        {
          paramArrayList = localArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            ??? = (MessageRecord)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a((MessageRecord)???);
          }
          synchronized (MsgPool.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a((String)???, n))
          {
            MsgProxyUtils.a(paramArrayList, (MessageRecord)localObject6, true);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a((MessageRecord)localObject6);
      if ((j != 0) && (!((MessageRecord)localArrayList.get(0)).isread)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList, bool);
    }
  }
  
  public void c(MessageRecord paramMessageRecord) {}
  
  public void d(MessageRecord paramMessageRecord)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    Object localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, "你撤回了一条消息", paramMessageRecord.istroop, -5040, 1, paramMessageRecord.time);
    ((UniteGrayTipParam)localObject).jdField_f_of_type_Boolean = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).e(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, UncommonMessageProcessor.jdField_d_of_type_Int, UncommonMessageProcessor.l);
      return;
    }
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */
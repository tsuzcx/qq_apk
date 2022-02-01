package com.tencent.imcore.message;

import ActionMsg.MsgBody;
import acmb;
import acmc;
import acmw;
import acnd;
import acne;
import acnf;
import acnh;
import acnt;
import acnu;
import acod;
import agnw;
import akes;
import akqe;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import anvx;
import aohe;
import aood;
import aoog;
import aopk;
import aoqy;
import aoxz;
import apab;
import apzo;
import aqvh;
import arzh;
import athn;
import atlf;
import audy;
import avht;
import avhz;
import avia;
import awyg;
import axii;
import axma;
import axnc;
import axnp;
import bapk;
import bcrg;
import bcsa;
import bcsc;
import bdof;
import bdzy;
import bedr;
import bfjs;
import bgcz;
import bgiz;
import bgja;
import bgke;
import bgls;
import bgmf;
import bhca;
import bhfj;
import bhhy;
import bjxa;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFuDai;
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
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.revokemsg.RevokeMsgInfo;>;
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
import java.util.concurrent.locks.Lock;
import localpb.richMsg.RichMsg.FoldMsg;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import mqq.os.MqqHandler;
import nty;
import onq;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import uot;
import uqx;
import usu;

public abstract class BaseMessageManager
  extends Observable
  implements aood
{
  protected acne a;
  public QQMessageFacade a;
  public QQAppInterface a;
  private Object a;
  private Object b = new Object();
  
  public BaseMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, acne paramacne)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = paramQQMessageFacade;
    this.jdField_a_of_type_Acne = paramacne;
  }
  
  private void A(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5008) && (paramMessage.msgData != null))
    {
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.fromBytes(paramMessage.msgData);
      paramMessage.msg = localArkAppMessage.getSummery();
    }
  }
  
  private void B(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2039)
    {
      paramMessage.msg = anvx.a(2131700518);
      if (paramMessage.msgData != null)
      {
        MessageForApollo localMessageForApollo = new MessageForApollo();
        localMessageForApollo.msgData = paramMessage.msgData;
        localMessageForApollo.parse();
        paramMessage.msg = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForApollo);
      }
    }
  }
  
  private void C(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -2072) && (paramMessage.msgData != null)) {}
    try
    {
      MessageForFuDai localMessageForFuDai = new MessageForFuDai();
      localMessageForFuDai.msgData = paramMessage.msgData;
      localMessageForFuDai.parse();
      paramMessage.msg = localMessageForFuDai.getSummaryMsg();
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("Q.msg.BaseMessageManager", 1, paramMessage, new Object[0]);
    }
  }
  
  private void D(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -2025) && (paramMessage.msgData != null)) {}
    try
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = new MessageForQQWalletMsg();
      localMessageForQQWalletMsg.msgData = paramMessage.msgData;
      localMessageForQQWalletMsg.parse();
      paramMessage.msg = localMessageForQQWalletMsg.getMsgSummary();
      return;
    }
    catch (Exception paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageManager", 2, paramMessage.toString());
    }
  }
  
  private void E(QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage)) {
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691258);
    }
    try
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getMsgItemByUniseq(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      if (localMessageForPtt != null)
      {
        paramMessage.pttUrl = localMessageForPtt.url;
        paramMessage.msg = localMessageForPtt.getSummaryMsg();
      }
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void F(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2020)
    {
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718619);
      if (bhfj.a(paramMessage.issend))
      {
        String str = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, "", 0, 0);
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718620, new Object[] { str });
      }
    }
    else
    {
      return;
    }
    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718619);
  }
  
  private void G(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2005) {
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692201);
    }
  }
  
  private void H(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2000)
    {
      MessageForPic localMessageForPic = new MessageForPic();
      localMessageForPic.msgData = paramMessage.msgData;
      localMessageForPic.istroop = paramMessage.istroop;
      localMessageForPic.parse();
      paramMessage.msg = localMessageForPic.getSummaryMsg();
    }
  }
  
  private void I(QQMessageFacade.Message paramMessage)
  {
    FunnyFaceMessage localFunnyFaceMessage;
    if (paramMessage.msgtype == -2010) {
      localFunnyFaceMessage = new FunnyFaceMessage();
    }
    try
    {
      localFunnyFaceMessage.readExternal(new ObjectInputStream(new ByteArrayInputStream(paramMessage.msgData)));
      if (localFunnyFaceMessage != null)
      {
        if (localFunnyFaceMessage.faceId == 1) {
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693780);
        }
      }
      else {
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageManager", 2, localException.toString());
          }
          localObject = null;
        }
      } while (localObject.faceId != 2);
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693781);
    }
  }
  
  private void J(QQMessageFacade.Message paramMessage)
  {
    if (b(paramMessage))
    {
      if (paramMessage.msgtype != -3006) {
        break label54;
      }
      paramMessage.msg = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, false);
      if (paramMessage.istroop == 1) {
        paramMessage.nickName = usu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      }
    }
    return;
    label54:
    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694485);
  }
  
  private void K(QQMessageFacade.Message paramMessage)
  {
    Object localObject;
    if ((d(paramMessage)) && (paramMessage.msgData != null))
    {
      localObject = null;
      switch (paramMessage.msgtype)
      {
      default: 
        if (localObject != null)
        {
          ((ChatMessage)localObject).msgData = paramMessage.msgData;
          ((ChatMessage)localObject).parse();
          paramMessage.msg = ((ChatMessage)localObject).msg;
          if (paramMessage.msgtype != -4501) {
            break label192;
          }
          paramMessage.msg = ((MessageForDevPtt)localObject).getSummary();
        }
        break;
      }
    }
    label192:
    do
    {
      return;
      localObject = new MessageForDeviceFile();
      break;
      localObject = new MessageForDeviceSingleStruct();
      break;
      localObject = new MessageForDevPtt();
      break;
      localObject = new MessageForDevShortVideo();
      break;
      localObject = new MessageForDevLittleVideo();
      break;
      localObject = new MessageForNewGrayTips();
      break;
      if (paramMessage.msgtype == -4503)
      {
        paramMessage.msg = ((MessageForDevShortVideo)localObject).getSummary();
        return;
      }
    } while (paramMessage.msgtype != -4509);
    paramMessage.msg = ((MessageForDevLittleVideo)localObject).getSummary();
  }
  
  private void L(QQMessageFacade.Message paramMessage)
  {
    if (c(paramMessage))
    {
      MessageForNewGrayTips localMessageForNewGrayTips = new MessageForNewGrayTips();
      localMessageForNewGrayTips.msgData = paramMessage.msgData;
      localMessageForNewGrayTips.parse();
      paramMessage.msg = localMessageForNewGrayTips.msg;
      if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
        paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
      }
    }
  }
  
  private void M(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -1035)
    {
      MessageForMixedMsg localMessageForMixedMsg = new MessageForMixedMsg();
      localMessageForMixedMsg.frienduin = paramMessage.frienduin;
      localMessageForMixedMsg.msgData = paramMessage.msgData;
      localMessageForMixedMsg.extStr = paramMessage.extStr;
      localMessageForMixedMsg.extLong |= 0x1;
      localMessageForMixedMsg.parse();
      paramMessage.msg = localMessageForMixedMsg.msg;
      paramMessage.msg2 = localMessageForMixedMsg.msg2;
      if ((paramMessage.msg2 == null) || ("".equals(paramMessage.msg2))) {
        break label110;
      }
      paramMessage.emoRecentMsg = new QQText(paramMessage.msg2, 3, 16);
    }
    label110:
    while ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
      return;
    }
    paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
  }
  
  private void N(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2058) {
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718981);
    }
  }
  
  private void O(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2007) {}
    try
    {
      MarkFaceMessage localMarkFaceMessage = (MarkFaceMessage)apab.a(paramMessage.msgData);
      if ((localMarkFaceMessage != null) && (!TextUtils.isEmpty(localMarkFaceMessage.faceName)))
      {
        paramMessage.msg = ("[" + localMarkFaceMessage.faceName + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.msg.BaseMessageManager", 1, "parse MarkFaceMessage: ", localException);
        Object localObject = null;
      }
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691876);
    }
  }
  
  private void P(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.isFromLS)
    {
      c(paramMessage);
      return;
    }
    b(paramMessage);
  }
  
  private void Q(QQMessageFacade.Message paramMessage)
  {
    if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && ((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002))) {}
    try
    {
      paramMessage.msg = bhca.a(paramMessage.msg).msg;
      return;
    }
    catch (Exception paramMessage)
    {
      throw paramMessage;
    }
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    Object localObject2;
    if (acnh.a(paramInt) == 1009)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(AppConstants.SAME_STATE_BOX_UIN, 1009);
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
              if (acnh.a(paramInt) == 1001)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(AppConstants.LBS_HELLO_UIN, 1001);
                localObject2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                continue;
              }
              if (acnh.a(paramInt) == 1010)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(AppConstants.DATE_UIN, 1010);
                localObject2 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                continue;
              }
              if (acnh.a(paramInt) != 10002) {
                break label361;
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(AppConstants.LBS_HELLO_UIN, 10002);
              localObject2 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
              continue;
            }
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || ((!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(localMessageRecord.senderuin)) && (!AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(localMessageRecord.senderuin)))) {
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
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a((String)localObject2, acnh.a(paramInt));
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
  
  private avhz a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MessageForUniteGrayTip paramMessageForUniteGrayTip, long paramLong)
  {
    Object localObject1 = "";
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).d(paramString3);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt(ContactUtils.KEY_TROOP_MEM_NICK_UPDATE_TARGET, ContactUtils.VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG);
      ((Bundle)localObject2).putLong(ContactUtils.KEY_UNI_SEQ, paramMessageForUniteGrayTip.uniseq);
      localObject2 = ContactUtils.getTroopNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, (String)localObject1, true, (Bundle)localObject2);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, 1, 0);
      }
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697450);
      int i = paramString1.length() + ((String)localObject2).length();
      int j = i + ((String)localObject1).length();
      paramString1 = paramString1 + (String)localObject2 + (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697451);
      paramString3 = new avhz(paramString3, paramString4, paramString1, paramInt, -5040, 1, paramLong);
      paramString4 = new Bundle();
      paramString4.putInt(ContactUtils.KEY_TROOP_MEM_NICK_UPDATE_TARGET, ContactUtils.VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG);
      paramString4.putLong(ContactUtils.KEY_UNI_SEQ, paramMessageForUniteGrayTip.uniseq);
      paramString4.putInt("key_action", 28);
      paramString4.putString("troop_mem_uin", String.valueOf(paramString2));
      paramString4.putBoolean("need_update_nick", true);
      paramString3.a(i, j, paramString4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke message wording", paramString1, Integer.valueOf(i), " end:", Integer.valueOf(j) });
      }
      return paramString3;
      if (paramInt == 3000) {
        localObject1 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, 2, 0);
      }
    }
  }
  
  @org.jetbrains.annotations.Nullable
  private QQMessageFacade.Message a(String paramString, QQMessageFacade.Message paramMessage, StringBuilder paramStringBuilder)
  {
    try
    {
      localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.get(paramString);
      if (localMessage == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramMessage);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.put(paramString, paramMessage);
        return paramMessage;
      }
      if (a(localMessage) < a(paramMessage))
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramMessage);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.put(paramString, paramMessage);
        return paramMessage;
      }
    }
    catch (Throwable paramStringBuilder)
    {
      QQMessageFacade.Message localMessage;
      paramString = paramMessage;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", paramStringBuilder);
        return paramMessage;
        if ((!localMessage.isCacheValid) && (paramMessage.isCacheValid))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append(" : case 3 : valid inplace");
          }
          a(paramMessage);
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.put(paramString, paramMessage);
          return paramMessage;
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" : case 4 :invalid inplace");
        }
        localMessage.isCacheValid = true;
        paramString = localMessage;
      }
    }
    return paramString;
  }
  
  @android.support.annotation.Nullable
  private SystemMsg a(QQMessageFacade.Message paramMessage)
  {
    SystemMsg localSystemMsg = null;
    if ((!AppConstants.QQBROADCAST_MSG_UIN.equals(paramMessage.senderuin)) || (paramMessage.msgtype != -2011)) {
      localSystemMsg = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
    }
    return localSystemMsg;
  }
  
  private void a(QQMessageFacade.Message paramMessage, SystemMsg paramSystemMsg)
  {
    if (paramSystemMsg != null)
    {
      paramMessage.msg = paramSystemMsg.message;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + paramMessage.msg);
      }
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, String paramString)
  {
    int i = 1;
    paramString = paramString.split("\026")[1].split("\\|");
    if (paramString == null) {
      return;
    }
    if (paramString.length < 2) {
      label29:
      paramMessage.fileType = i;
    }
    for (;;)
    {
      try
      {
        if (paramString.length < 2)
        {
          l = -1L;
          paramMessage.fileSize = l;
        }
      }
      catch (Exception localException)
      {
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException);
        paramMessage.fileSize = -1L;
        continue;
        if (paramMessage.msgtype != -3001) {
          continue;
        }
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694510);
        return;
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693142);
        return;
      }
      switch (i)
      {
      case 3: 
      default: 
        return;
      case 0: 
        paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692201);
        return;
        i = Integer.valueOf(paramString[2]).intValue();
        break label29;
        l = Long.valueOf(paramString[1]).longValue();
      }
    }
    paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691258);
    paramMessage.pttUrl = paramString[0];
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, acmc> paramHashMap)
  {
    HashSet localHashSet = new HashSet();
    paramQQAppInterface = (akqe)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    paramQQAppInterface.a(false);
    if (paramQQAppInterface.h.isEmpty()) {
      return;
    }
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      acmc localacmc1 = (acmc)localEntry.getValue();
      if (localacmc1.jdField_b_of_type_Boolean)
      {
        String str = (String)paramQQAppInterface.h.get(localEntry.getKey());
        if ((!TextUtils.isEmpty(str)) && (paramHashMap.containsKey(str)))
        {
          acmc localacmc2 = (acmc)paramHashMap.get(str);
          localHashSet.add(str);
          localacmc1.jdField_a_of_type_Int += localacmc2.jdField_a_of_type_Int;
          localacmc1.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(localacmc2.jdField_a_of_type_JavaUtilLinkedHashSet);
          if ((localacmc1.jdField_a_of_type_Boolean) || (localacmc2.jdField_a_of_type_Boolean)) {}
          for (boolean bool = true;; bool = false)
          {
            localacmc1.jdField_a_of_type_Boolean = bool;
            if (localacmc1.jdField_b_of_type_Long < localacmc2.jdField_b_of_type_Long)
            {
              localacmc1.jdField_b_of_type_Long = localacmc2.jdField_b_of_type_Long;
              localacmc1.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localacmc2.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
              localacmc1.jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg.redBagIndex = ((String)localEntry.getKey());
            }
            if (localacmc1.jdField_a_of_type_Long <= localacmc2.jdField_a_of_type_Long) {
              break;
            }
            localacmc1.jdField_a_of_type_Long = localacmc2.jdField_a_of_type_Long;
            localacmc1.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localacmc2.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg;
            localacmc1.jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg.redBagIndex = ((String)localEntry.getKey());
            break;
          }
        }
      }
    }
    paramHashMap.keySet().removeAll(localHashSet);
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg != null) && (paramMessageForStructing.structingMsg.mMsgUrl != null) && (paramMessageForStructing.structingMsg.mMsgUrl.startsWith("https://docs.qq.com"))) {
      arzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForStructing.frienduin, paramMessageForStructing.senderuin, paramMessageForStructing.istroop, paramMessageForStructing.time, paramMessageForStructing.msgseq, paramMessageForStructing.msgUid);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramMessageRecord.frienduin))) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.uniseq == paramMessageRecord.uniseq) {
      MessageRecord.copyMessageRecordStatusField(paramMessage, paramMessageRecord);
    }
    do
    {
      return;
      MessageRecord.copyMessageRecordBaseField(paramMessage, paramMessageRecord);
      paramMessage.emoRecentMsg = null;
      paramMessage.fileType = -1;
      paramMessage.lastMsg = null;
      try
      {
        a(paramMessage);
        return;
      }
      catch (Throwable paramMessageRecord) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
  }
  
  private void a(MessageRecord paramMessageRecord, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(paramMessage);
    }
    if ((!String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(paramMessage.frienduin)) && ((!acnh.d(paramMessage)) || (acnh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))
    {
      if ((paramMessageRecord instanceof MessageForNearbyLiveTip)) {
        paramMessage.nickName = ((MessageForNearbyLiveTip)paramMessageRecord).nickName;
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(paramMessage);
    }
    if (((paramMessage.msgtype == -2009) || (paramMessage.msgtype == -2016)) && (paramBoolean))
    {
      QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      localMessage.emoRecentMsg = null;
      localMessage.fileType = -1;
      paramMessage.lastMsg = null;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(localMessage);
    }
    if (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(paramMessage.frienduin))
    {
      int i = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i > 0) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getIncomingMsg().unReadNum = i;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setIncomingMsg(null);
  }
  
  private void a(MessageRecord paramMessageRecord, Map<String, MessageRecord> paramMap, String paramString, int paramInt)
  {
    if (a(paramMessageRecord, false, 1))
    {
      if ((paramMap.containsKey(acnh.a(paramString, paramInt))) && (!paramMessageRecord.isSendFromLocal())) {
        break label47;
      }
      paramMap.put(acnh.a(paramString, paramInt), paramMessageRecord);
    }
    label47:
    MessageRecord localMessageRecord;
    do
    {
      return;
      localMessageRecord = (MessageRecord)paramMap.get(acnh.a(paramString, paramInt));
    } while (a(paramMessageRecord) < a(localMessageRecord));
    paramMap.put(acnh.a(paramString, paramInt), paramMessageRecord);
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean, QQMessageFacade.Message paramMessage)
  {
    MessageRecord.copyMessageRecordBaseField(paramMessage, paramMessageRecord);
    paramMessage.emoRecentMsg = null;
    paramMessage.fileType = -1;
    paramMessage.lastMsg = null;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (axnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)) {
        bool = true;
      }
    }
    if (bool) {}
    try
    {
      a(paramMessage);
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
    }
  }
  
  private void a(String paramString, QQMessageFacade.Message paramMessage)
  {
    if (((paramString.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) || (paramString.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN)))) && (paramMessage.msgData != null))
    {
      paramString = new DataLineMsgRecord();
      DataLineMsgRecord.unpackMsgData(paramString, paramMessage.msgData, paramMessage.versionCode);
      paramMessage.msg = paramString.msg;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString2, paramInt, paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramString2 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString2, paramInt);
    if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1))) {
      paramString2.cleanMessageRecordBaseField();
    }
  }
  
  private void a(boolean paramBoolean, QQMessageFacade.Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + paramMessage.getBaseInfoString() + " , result = " + paramBoolean);
    }
    if (acnh.b(paramMessage.frienduin, paramMessage.istroop)) {
      paramMessage.istroop = acnh.a(paramMessage.istroop);
    }
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031);
  }
  
  private boolean a(MessageRecord paramMessageRecord, QQMessageFacade.Message paramMessage)
  {
    boolean bool1 = true;
    if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1)) {}
    for (bool1 = a(paramMessageRecord, paramMessage, false);; bool1 = false) {
      do
      {
        boolean bool2 = bool1;
        if (acnh.c(paramMessageRecord.senderuin))
        {
          bool2 = bool1;
          if (TextUtils.equals(paramMessageRecord.senderuin, paramMessage.senderuin)) {
            bool2 = false;
          }
        }
        return bool2;
      } while ((acnh.d(paramMessageRecord.istroop)) && (!paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.time < paramMessage.time));
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    int j = (int)(paramMessage.shmsgseq - paramMessageRecord.shmsgseq);
    int k;
    boolean bool;
    if (paramMessageRecord.msgtype != -1012)
    {
      k = j;
      bool = paramBoolean;
      if (paramMessageRecord.msgtype != -5021) {}
    }
    else
    {
      if ((paramMessage.msgtype != -1012) && (paramMessage.msgtype != -5021)) {
        break label164;
      }
      k = 1;
      i = j;
      if (j == 0) {
        if (k == 0) {
          break label170;
        }
      }
    }
    label164:
    label170:
    for (int i = (int)(paramMessage.time - paramMessageRecord.time);; i = -1)
    {
      if (i > 0) {
        paramBoolean = true;
      }
      k = i;
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("GrayTipsForTroop", 2, "updateMsgTab mrIsOld " + paramBoolean);
        bool = paramBoolean;
        k = i;
      }
      paramBoolean = bool;
      if (!paramMessageRecord.isSendFromLocal())
      {
        paramBoolean = bool;
        if (k > 0) {
          paramBoolean = true;
        }
      }
      return paramBoolean;
      k = 0;
      break;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2, QQMessageFacade.Message paramMessage, boolean paramBoolean3)
  {
    int j = 1;
    if (!paramBoolean3)
    {
      a(paramMessageRecord, paramBoolean1, paramMessage);
      paramBoolean2 = true;
    }
    if ((!paramMessageRecord.isSend()) && (!bcsc.a(paramMessageRecord.msgtype)))
    {
      paramMessage.hasReply = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + paramMessage + ",hasReply=" + paramMessage.hasReply);
      }
    }
    int i = j;
    if (paramMessageRecord.istroop != 1033) {
      if (paramMessageRecord.istroop != 1034) {
        break label176;
      }
    }
    label176:
    for (i = j;; i = 0)
    {
      if (((!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (i == 0)) || (paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
        a(paramMessageRecord, paramMessage, paramBoolean3);
      }
      return paramBoolean2;
    }
  }
  
  private boolean b(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -3006) || (paramMessage.msgtype == -5004);
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (bhfj.a(paramMessageRecord.issend)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab isBlessMsg:" + paramMessageRecord.isBlessMsg + " needUpdateMsgTag:" + paramMessageRecord.needUpdateMsgTag + " isCheckNeedShowInListTypeMsg:" + paramMessageRecord.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + paramMessageRecord.needNeedShowInList);
      }
      if ((!paramMessageRecord.isBlessMsg) || (!paramMessageRecord.needUpdateMsgTag)) {
        break label142;
      }
    }
    label142:
    for (int i = 0;; i = 1)
    {
      int j = i;
      if (paramMessageRecord.isCheckNeedShowInListTypeMsg)
      {
        j = i;
        if (paramMessageRecord.needNeedShowInList) {
          j = 0;
        }
      }
      return j != 0;
    }
  }
  
  private boolean c(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -5000) || (paramMessage.msgtype == -5001);
  }
  
  private boolean c(String paramString)
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
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((acnh.a(paramMessage.istroop) == 1001) || (acnh.a(paramMessage.istroop) == 10002))) || (acnh.a(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (acnh.a(paramMessage.istroop) == 1010)))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessage.istroop).b(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) && (!bcsc.a(localMessageRecord.msgtype)))
          {
            paramMessage.hasReply = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + paramMessage + ",hasReply=" + paramMessage.hasReply);
            }
          }
        }
      }
    }
  }
  
  private boolean d(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -4500) || (paramMessage.msgtype == -4502) || (paramMessage.msgtype == -4503) || (paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4509);
  }
  
  private void e(QQMessageFacade.Message paramMessage)
  {
    if ((bhca.a(paramMessage.msgtype)) || (paramMessage.msgtype == -3001) || (paramMessage.msgtype == -30002) || (paramMessage.msgtype == -30003)) {}
    try
    {
      MsgBody localMsgBody = bhca.a(paramMessage.msg);
      paramMessage.msg = localMsgBody.msg;
      paramMessage.action = localMsgBody.action;
      paramMessage.shareAppID = localMsgBody.shareAppID;
      paramMessage.actMsgContentValue = localMsgBody.actMsgContentValue;
      return;
    }
    catch (Exception paramMessage)
    {
      throw paramMessage;
    }
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramMessageRecord).structingMsg;
    if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 61)) {
      paramMessageRecord.extInt = 61;
    }
  }
  
  private boolean e(QQMessageFacade.Message paramMessage)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getRegistry().b().iterator();
    while (localIterator.hasNext()) {
      if (((acod)localIterator.next()).a(paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  private void f(QQMessageFacade.Message paramMessage)
  {
    if (acnh.j(paramMessage.msgtype))
    {
      if (paramMessage.msgData == null) {
        break label129;
      }
      localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    }
    label129:
    while (!QLog.isColorLevel()) {
      try
      {
        UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg;
        localUniteGrayTipMsg.mergeFrom(paramMessage.msgData);
        paramMessage.msg = localUniteGrayTipMsg.content.get();
        if ((localUniteGrayTipMsg.graytip_id.has()) && (axma.b(localUniteGrayTipMsg.graytip_id.get()))) {
          paramMessage.emoRecentMsg = axnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage.msg);
        }
        return;
      }
      catch (Exception paramMessage)
      {
        do
        {
          paramMessage.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.e(avia.jdField_a_of_type_JavaLangString, 2, "MessageForUniteGrayTip, docodeMsg failed, " + paramMessage.getMessage());
        return;
      }
    }
    QLog.e(avia.jdField_a_of_type_JavaLangString, 2, "MessageForUniteGrayTip, docodeMsg msgData == null, msg: " + paramMessage.msg);
  }
  
  private void f(MessageRecord paramMessageRecord)
  {
    awyg localawyg;
    if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1036) || (paramMessageRecord.msgtype == -1035)))
    {
      localawyg = (awyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a() == 1) {
        localawyg.a(paramMessageRecord);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new BaseMessageManager.1(this, localawyg, paramMessageRecord), 10000L);
  }
  
  private void g(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5018) && (paramMessage.msgData != null)) {}
    try
    {
      paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
      return;
    }
    catch (JSONException paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void g(MessageRecord paramMessageRecord)
  {
    axii localaxii;
    if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1051) || ((paramMessageRecord.isLongMsg()) && (paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1))))
    {
      localaxii = (axii)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a() == 1) {
        localaxii.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new BaseMessageManager.2(this, localaxii, paramMessageRecord), 10000L);
  }
  
  private void h(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5012) && (paramMessage.msgData != null)) {}
    try
    {
      paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
      return;
    }
    catch (JSONException paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void h(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new BaseMessageManager.3(this, paramMessageRecord, l));
  }
  
  private void i(QQMessageFacade.Message paramMessage)
  {
    RichMsg.FoldMsg localFoldMsg;
    if ((paramMessage.msgtype == -1000) && (paramMessage.getExtInfoFromExtStr("redbag_fold_msg").equals("true")) && (paramMessage.msgData != null)) {
      localFoldMsg = new RichMsg.FoldMsg();
    }
    try
    {
      localFoldMsg.mergeFrom(paramMessage.msgData);
      paramMessage.msg = localFoldMsg.msg_content.get().toStringUtf8();
      return;
    }
    catch (Exception paramMessage)
    {
      do
      {
        paramMessage.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("msgFold", 2, "MessageForFoldMsg decodeMsg error， " + paramMessage.getMessage());
    }
  }
  
  private void j(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -5003)
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramMessage.msgData);
      paramMessage.msg = aohe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), localMsgBody);
    }
  }
  
  private void k(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2011)
    {
      AbsStructMsg localAbsStructMsg = bdof.a(paramMessage.msgData);
      String str = "";
      if (localAbsStructMsg != null) {
        str = localAbsStructMsg.mMsgBrief;
      }
      paramMessage.msg = str;
    }
  }
  
  private void l(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -2018) || (paramMessage.msgtype == -2050)) {}
    try
    {
      structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
      localStructMsg.mergeFrom(paramMessage.msgData);
      paramMessage.msg = MessageForSystemMsg.getSysMsgDesc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), localStructMsg);
      return;
    }
    catch (Exception paramMessage)
    {
      throw paramMessage;
    }
  }
  
  private void m(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
      return;
    }
    Object localObject = paramMessage.msg;
    if (c((String)localObject))
    {
      a(paramMessage, (String)localObject);
      return;
    }
    if (paramMessage.msgtype == -2006)
    {
      p(paramMessage);
      return;
    }
    if (paramMessage.msgtype == -2008)
    {
      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718416);
      return;
    }
    if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
    {
      String[] arrayOfString = bcsc.a(paramMessage.msg);
      String str = "";
      localObject = str;
      if (arrayOfString != null)
      {
        localObject = str;
        if (arrayOfString[2] != null) {
          localObject = arrayOfString[2];
        }
      }
      paramMessage.fileType = 65536;
      paramMessage.msg = ("[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719444) + "] " + (String)localObject);
      return;
    }
    if (paramMessage.msgtype == -2029)
    {
      o(paramMessage);
      return;
    }
    if (paramMessage.msgtype == -2068)
    {
      localObject = new MessageForDarenAssistant();
      ((MessageForDarenAssistant)localObject).msgData = paramMessage.msgData;
      ((MessageForDarenAssistant)localObject).parse();
      paramMessage.msg = ((MessageForDarenAssistant)localObject).msg;
      return;
    }
    if (axnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))
    {
      paramMessage.emoRecentMsg = axnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage.msg);
      return;
    }
    n(paramMessage);
  }
  
  private void n(QQMessageFacade.Message paramMessage)
  {
    Object localObject1 = new StringBuilder(paramMessage.msg);
    String str = paramMessage.getExtInfoFromExtStr("disc_at_info_list");
    Object localObject2 = localObject1;
    if (paramMessage.istroop == 3000)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty(str)) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = BaseApplicationImpl.sApplication.getRuntime();
        if (!QQAppInterface.class.isInstance(localObject2)) {
          continue;
        }
        localObject2 = bgcz.a((QQAppInterface)localObject2, (StringBuilder)localObject1, str, paramMessage.frienduin, paramMessage.isSend());
        localObject1 = localObject2;
        localObject2 = localObject1;
      }
      catch (Exception localException)
      {
        QLog.e("Q.msg.BaseMessageManager", 1, "replaceAtMsgByMarkName", localException);
        Object localObject3 = localObject1;
        continue;
        paramMessage.emoRecentMsg = new QQText(localObject3, 3, 16);
      }
      if (paramMessage.msgtype != -1000) {
        continue;
      }
      paramMessage.emoRecentMsg = new QQText(bhfj.c(((StringBuilder)localObject2).toString()), 3, 16);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageManager", 1, "We get error AppRuntime");
      }
    }
  }
  
  private void o(QQMessageFacade.Message paramMessage)
  {
    MessageForQQWalletTips localMessageForQQWalletTips = new MessageForQQWalletTips();
    localMessageForQQWalletTips.init(paramMessage.selfuin, paramMessage.frienduin, paramMessage.senderuin, "[QQWallet Tips]", bcrg.a(), paramMessage.msgtype, paramMessage.istroop, bcrg.a());
    localMessageForQQWalletTips.msgData = paramMessage.msgData;
    localMessageForQQWalletTips.isread = true;
    localMessageForQQWalletTips.parse();
    localMessageForQQWalletTips.buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), null);
    paramMessage.msg = localMessageForQQWalletTips.summary;
  }
  
  private void p(QQMessageFacade.Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
    }
    paramMessage.msg = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691258) + "(0x7f)");
  }
  
  private void q(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2067)
    {
      Object localObject = new MessageForTroopConfess();
      ((MessageForTroopConfess)localObject).msgData = paramMessage.msgData;
      ((MessageForTroopConfess)localObject).doParse();
      paramMessage.msg = ((MessageForTroopConfess)localObject).msg;
      localObject = bgiz.a(paramMessage);
      if (localObject != null) {
        paramMessage.nickName = ((bgja)localObject).c;
      }
      if (TextUtils.isEmpty(paramMessage.nickName)) {
        paramMessage.nickName = anvx.a(2131700521);
      }
    }
  }
  
  private void r(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -5015) {
      paramMessage.msg = anvx.a(2131700519);
    }
  }
  
  private void s(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2054)
    {
      MessageForTroopSign localMessageForTroopSign = new MessageForTroopSign();
      localMessageForTroopSign.msgData = paramMessage.msgData;
      localMessageForTroopSign.parse();
      paramMessage.msg = localMessageForTroopSign.getSummaryMsg();
    }
  }
  
  private void t(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -7002)
    {
      MessageForTribeShortVideo localMessageForTribeShortVideo = new MessageForTribeShortVideo();
      localMessageForTribeShortVideo.msgData = paramMessage.msgData;
      localMessageForTribeShortVideo.parse();
      paramMessage.msg = localMessageForTribeShortVideo.getSummaryMsg();
    }
  }
  
  private void u(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2051)
    {
      MessageForQQStory localMessageForQQStory = new MessageForQQStory();
      localMessageForQQStory.msgData = paramMessage.msgData;
      localMessageForQQStory.parse();
      paramMessage.msg = localMessageForQQStory.getSummaryMsg();
    }
  }
  
  private void v(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.msgtype == -2048)
    {
      MessageForTroopReward localMessageForTroopReward = new MessageForTroopReward();
      localMessageForTroopReward.msgData = paramMessage.msgData;
      localMessageForTroopReward.parse();
      paramMessage.msg = localMessageForTroopReward.getSummaryMsg();
    }
  }
  
  private void w(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5014) && (paramMessage.msgData != null)) {
      paramMessage.msg = ((HiBoomMessage)apab.a(paramMessage.msgData)).text;
    }
  }
  
  private void x(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5013) && (paramMessage.msgData != null))
    {
      ArkFlashChatMessage localArkFlashChatMessage = new ArkFlashChatMessage();
      localArkFlashChatMessage.fromBytes(paramMessage.msgData);
      paramMessage.msg = localArkFlashChatMessage.getSummery();
    }
  }
  
  private void y(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5017) && (paramMessage.msgData != null))
    {
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.fromBytes(paramMessage.msgData);
      paramMessage.msg = localArkAppMessage.getSummery();
    }
  }
  
  private void z(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.msgtype == -5016) && (paramMessage.msgData != null))
    {
      MessageForArkBabyqReply localMessageForArkBabyqReply = new MessageForArkBabyqReply();
      localMessageForArkBabyqReply.fromBytes(paramMessage.msgData);
      paramMessage.msg = localMessageForArkBabyqReply.getSummery();
    }
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (acmw.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isTroopMark(paramConversationInfo.uin, paramConversationInfo.type)) && (!acnh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getConversationFacade().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return acmw.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if (((paramConversationInfo.type == 1001) || (paramConversationInfo.type == 10002)) && (AppConstants.LBS_HELLO_UIN.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getConversationFacade().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return acmw.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getConversationFacade().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return acmw.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(AppConstants.DATE_UIN)) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getConversationFacade().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return acmw.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getConversationFacade().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return acmw.a(paramConversationInfo);
        }
      }
      else if (paramInt == 10)
      {
        if (((paramConversationInfo.type == 0) || (paramConversationInfo.type == 1) || (paramConversationInfo.type == 3000)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isTroopMark(paramConversationInfo.uin, paramConversationInfo.type)) && (!acnh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getConversationFacade().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return acmw.a(paramConversationInfo);
        }
      }
      else {
        return acmw.a(paramConversationInfo);
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt, paramBoolean1);
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.clearTransFileInfo(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, acnh.a(paramInt))))
      {
        if (acnh.a(paramInt) != 1009) {
          break label288;
        }
        a(paramString, AppConstants.SAME_STATE_BOX_UIN, 1009);
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().findRecentUserByUin(paramString, localMessage.istroop);
        if (localRecentUser != null) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.removeRecentUser(localRecentUser);
        }
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.remove(acnh.a(paramString, paramInt));
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(localMessage);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().removeProcessorByPeerUin(paramString, 0);
      break;
      label288:
      if (acnh.a(paramInt) == 1001) {
        a(paramString, AppConstants.LBS_HELLO_UIN, 1001);
      } else if (acnh.a(paramInt) == 1010) {
        a(paramString, AppConstants.DATE_UIN, 1010);
      } else if (acnh.a(paramInt) == 10002) {
        a(paramString, AppConstants.LBS_HELLO_UIN, 10002);
      } else if (acnh.a(paramInt) == 1044) {
        a(paramString, AppConstants.MATCH_CHAT_UIN, 1044);
      } else if (acnh.a(paramInt) == 10008) {
        a(paramString, AppConstants.QCIRCLE_CHAT_UIN, 10008);
      }
    }
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    if (paramString == null)
    {
      paramEntityManager = new QQMessageFacade.Message();
      return paramEntityManager;
    }
    if (aoog.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt))
    {
      QLog.e("MsgInvalidTypeErr", 1, "find invalid refreshSingleLastMsg" + paramString);
      aoog.b(paramString);
    }
    String str = acnh.a(paramString, paramInt);
    Object localObject1 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    Object localObject2;
    if ((localObject1 == null) || (!((QQMessageFacade.Message)localObject1).isCacheValid))
    {
      localObject2 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
        localObject2 = DataLineMsgRecord.tableName();
      }
      if (paramString.equals(String.valueOf(AppConstants.DATALINE_IPAD_UIN))) {
        localObject2 = DataLineMsgRecord.tableName(1);
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a((String)localObject2, paramEntityManager);
      Object localObject3 = localObject2;
      localObject1 = localMessage;
      if (localMessage == null) {
        if ((!acnh.d(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject2;
          localObject1 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject1);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((QQMessageFacade.Message)localObject1).uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((QQMessageFacade.Message)localObject1).istroop).a((String)localObject3, paramEntityManager);
          localObject2 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject2 = paramEntityManager;
          }
        }
      }
      if (localObject2 != null)
      {
        a(paramString, (QQMessageFacade.Message)localObject2);
        d((QQMessageFacade.Message)localObject2);
      }
    }
    label415:
    for (paramString = a(str, (QQMessageFacade.Message)localObject2, localStringBuilder);; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramEntityManager = paramString;
      if (paramString == null) {
        break;
      }
      paramEntityManager = paramString;
      if (!acnh.b(paramString.frienduin, paramString.istroop)) {
        break;
      }
      paramString.istroop = acnh.a(paramString.istroop);
      return paramString;
      localObject2 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject2).frienduin = paramString;
      ((QQMessageFacade.Message)localObject2).istroop = paramInt;
      break label415;
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" : case 5 : not null or isValid : " + localObject1);
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
  
  protected List<MessageRecord> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (List)this.jdField_a_of_type_Acne.a().get(acnh.a(paramString, paramInt));
  }
  
  public List<ChatMessage> a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return new ArrayList();
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramLong >= 0L) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
    }
    while (localObject1 == null)
    {
      return new ArrayList();
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, true, true);
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1, paramInt2, true);
      }
    }
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    if (akqe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject2, null, false, true);
    }
    acnh.a((List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    acnh.a(paramString, paramInt1, (List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((!((List)localObject2).isEmpty()) && ((((List)localObject2).get(((List)localObject2).size() - 1) instanceof MessageForLongMsg)) && (acnh.a((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1), this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt1))))
    {
      localObject1 = (MessageForLongMsg)((List)localObject2).get(((List)localObject2).size() - 1);
      if ((((MessageForLongMsg)localObject1).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0)).longMsgIndex < this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt1).longMsgIndex))
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
    label453:
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
        break label1133;
      }
      localObject1 = (MessageRecord)localIterator.next();
      if (!(localObject1 instanceof MessageForArkApp)) {
        break label1420;
      }
      localObject2 = apzo.a().a();
      if ((localObject2 == null) || (((MessageRecord)localObject1).uniseq != ((MessageForArkApp)localObject2).uniseq)) {
        break label1420;
      }
      localObject4 = apzo.a().a();
      if (localObject4 != null)
      {
        ((MessageForArkApp)localObject2).arkContainer = ((agnw)localObject4);
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "refill ark msg: " + ((MessageForArkApp)localObject2).uniseq + " ark c=" + ((MessageForArkApp)localObject2).arkContainer);
      }
    }
    label1415:
    label1420:
    for (;;)
    {
      for (;;)
      {
        if ((localObject1 instanceof ChatMessage))
        {
          ((List)localObject3).add((ChatMessage)localObject1);
          localObject2 = ((MessageRecord)localObject1).getExtInfoFromExtStr("sens_msg_ctrl_info");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label856;
          }
          if (!((MessageRecord)localObject1).isSend()) {
            break label694;
          }
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
          break label453;
          localObject1 = "clone is null";
          break;
        }
        QLog.e("MsgInvalidTypeErr", 1, "err msg" + ((MessageRecord)localObject1).getBaseInfoString());
        aoog.a((MessageRecord)localObject1);
        break label453;
        label694:
        localObject4 = new bankcode_info.BankcodeCtrlInfo();
        try
        {
          ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.hexStr2Bytes((String)localObject2));
          paramInt2 = 0;
          if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has()) {
            paramInt2 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
          }
          if (paramInt2 != 1) {
            break label453;
          }
          ((ChatMessage)localObject1).parse();
          localObject2 = bcsa.a(-1014);
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
            label856:
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
          ((bgmf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a((TroopTipsEntity)localObject2);
          localObject4 = new MessageForGrayTips();
          paramLong = ((MessageRecord)localObject1).time;
          str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((MessageForGrayTips)localObject4).init(str, paramString, str, ((TroopTipsEntity)localObject2).optContent, paramLong, -1048, paramInt1, paramLong);
          ((MessageForGrayTips)localObject4).isread = true;
          bgmf.a((MessageForGrayTips)localObject4, ((TroopTipsEntity)localObject2).highlightItems);
          ((List)localObject3).add(localObject4);
        }
      }
      if (paramBoolean) {
        break label453;
      }
      if ((paramInt1 == 0) && ((localObject1 instanceof MessageForPoke)))
      {
        localObject2 = (MessageForPoke)localObject1;
        if (!((MessageForPoke)localObject2).isSend()) {
          localArrayList2.add(localObject2);
        }
        if ((((MessageForPoke)localObject2).interactType == 126) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          break label453;
        }
        if ((((MessageForPoke)localObject2).isread) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          ((MessageForPoke)localObject2).setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      if ((paramInt1 != 0) || (!(localObject1 instanceof MessageForPokeEmo))) {
        break label453;
      }
      localArrayList1.add((MessageForPokeEmo)localObject1);
      break label453;
      label1133:
      if (!paramBoolean)
      {
        paramInt2 = localArrayList2.size();
        if (paramInt2 <= 1) {
          break label1415;
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
              break label1406;
            }
            if (paramInt2 - 3 >= 0) {
              break label1398;
            }
          }
          label1398:
          for (paramInt1 = 0;; paramInt1 = paramInt2 - 3)
          {
            if (paramInt2 <= 3) {
              break label1406;
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
          label1406:
          return localObject3;
        }
        paramString = null;
      }
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(List<MessageRecord> paramList, String paramString, int paramInt, ArrayList<RevokeMsgInfo> paramArrayList)
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
            if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!acnh.a(localMessageRecord))) {
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
  
  public <T extends MessageRecord> void a(int paramInt, String paramString, T paramT, List<T> paramList)
  {
    paramString = this.jdField_a_of_type_Acne.a(paramString, paramInt);
    paramString.lock();
    try
    {
      acnh.a(paramList, paramT, true);
      return;
    }
    finally
    {
      paramString.unlock();
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    while (e(paramMessage)) {
      return;
    }
    Q(paramMessage);
    l(paramMessage);
    k(paramMessage);
    j(paramMessage);
    i(paramMessage);
    h(paramMessage);
    g(paramMessage);
    f(paramMessage);
    e(paramMessage);
    SystemMsg localSystemMsg = a(paramMessage);
    P(paramMessage);
    a(paramMessage, localSystemMsg);
    O(paramMessage);
    N(paramMessage);
    M(paramMessage);
    L(paramMessage);
    K(paramMessage);
    J(paramMessage);
    I(paramMessage);
    H(paramMessage);
    G(paramMessage);
    F(paramMessage);
    E(paramMessage);
    D(paramMessage);
    C(paramMessage);
    B(paramMessage);
    A(paramMessage);
    z(paramMessage);
    y(paramMessage);
    x(paramMessage);
    w(paramMessage);
    v(paramMessage);
    u(paramMessage);
    t(paramMessage);
    s(paramMessage);
    r(paramMessage);
    q(paramMessage);
    m(paramMessage);
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramRefreshMessageContext.numTroopRefresh)
      {
        paramRefreshMessageContext.numTroopRefresh = false;
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
    if ((paramRefreshMessageContext.resultMsgList != null) && (paramRefreshMessageContext.resultMsgList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      do
      {
        synchronized (paramRefreshMessageContext.resultMsgList)
        {
          acnh.a(paramRefreshMessageContext.resultMsgList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramRefreshMessageContext.resultMsgList.size() > 0) {
            acnh.a(paramRefreshMessageContext.uin, paramRefreshMessageContext.uinType, paramRefreshMessageContext.resultMsgList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          ??? = paramRefreshMessageContext.uin;
          int j = paramRefreshMessageContext.count;
          if ((paramRefreshMessageContext.needRefreshAIO) && (i != 0) && (paramRefreshMessageContext.resultMsgList.isEmpty()) && (paramRefreshMessageContext.retryIndex < 9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramRefreshMessageContext.retryIndex + " ]");
            }
            paramRefreshMessageContext.retryIndex += 1;
            b((String)???, paramInt, j, paramRefreshMessageContext);
            return;
          }
        }
        paramRefreshMessageContext.retryIndex = 0;
        paramRefreshMessageContext.repullLongMsgIndex = 0;
      } while (!paramRefreshMessageContext.needNotifyUI);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList1, List<MessageRecord> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((QLog.isColorLevel()) && (bhhy.a()) && (paramList1 != null) && (paramList1.size() > 0))
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
    akqe localakqe = (akqe)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    Object localObject4 = new HashMap();
    Object localObject5 = paramList1.iterator();
    label535:
    label537:
    label944:
    label950:
    label954:
    for (;;)
    {
      label209:
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
          localakqe.a(true, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex);
        }
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) || (TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          break label950;
        }
        if (localakqe.g.containsKey(localMessageForFoldMsg.redBagId))
        {
          localMessageForFoldMsg.redBagIndex = ((String)localakqe.g.get(localMessageForFoldMsg.redBagId));
          bool = true;
        }
      }
      for (;;)
      {
        label346:
        if (((!paramBoolean1) && (localakqe.a(localMessageForFoldMsg.frienduin, localMessageForFoldMsg.istroop, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex))) || ((localMessageForFoldMsg.isSend()) && (!localMessageForFoldMsg.foldFlag) && (localMessageForFoldMsg.msgtype == -2006))) {
          break label954;
        }
        if (bool) {}
        for (localObject1 = localMessageForFoldMsg.redBagIndex;; localObject1 = localMessageForFoldMsg.redBagId)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label535;
          }
          localObject3 = (acmc)((HashMap)localObject4).get(localObject1);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new acmc();
            ((HashMap)localObject4).put(localObject1, localObject2);
          }
          ((acmc)localObject2).jdField_b_of_type_Boolean = bool;
          if (localMessageForFoldMsg.foldFlag) {
            break label537;
          }
          ((acmc)localObject2).jdField_a_of_type_Boolean = true;
          if (localMessageForFoldMsg.shmsgseq <= ((acmc)localObject2).jdField_b_of_type_Long) {
            break;
          }
          ((acmc)localObject2).jdField_b_of_type_Long = localMessageForFoldMsg.shmsgseq;
          ((acmc)localObject2).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
          break;
          bool = false;
          break label346;
        }
        break label209;
        ((acmc)localObject2).jdField_a_of_type_Int += 1;
        ((acmc)localObject2).jdField_a_of_type_JavaUtilLinkedHashSet.add(localMessageForFoldMsg.senderuin);
        if (localMessageForFoldMsg.shmsgseq >= ((acmc)localObject2).jdField_a_of_type_Long) {
          break label209;
        }
        ((acmc)localObject2).jdField_a_of_type_Long = localMessageForFoldMsg.shmsgseq;
        ((acmc)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = localMessageForFoldMsg;
        break label209;
        if (((HashMap)localObject4).isEmpty()) {
          break;
        }
        a(paramQQAppInterface, (HashMap)localObject4);
        localObject2 = ((HashMap)localObject4).entrySet().iterator();
        label623:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (acmc)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (((acmc)localObject3).jdField_a_of_type_Int > 0)
          {
            if (((acmc)localObject3).jdField_a_of_type_Boolean) {
              ((acmc)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg = ((acmc)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageForFoldMsg;
            }
            if (paramList2 != null) {
              break label944;
            }
          }
        }
        for (localObject1 = a(paramQQAppInterface, ((MessageRecord)paramList1.get(0)).frienduin, ((MessageRecord)paramList1.get(0)).istroop);; localObject1 = paramList2)
        {
          if (localObject1 == null)
          {
            QLog.e("Q.msg.BaseMessageManager", 1, "mergeFoldMsgGrayTips null aioList");
            return;
          }
          localObject1 = localakqe.a((List)localObject1, ((acmc)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageForFoldMsg, ((acmc)localObject3).jdField_a_of_type_JavaUtilLinkedHashSet, ((acmc)localObject3).jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
          if ((localObject1 == null) || (paramList2 != null)) {
            break label623;
          }
          if ((QLog.isColorLevel()) && (bhhy.a()) && (paramList2 != null) && (paramList2.size() > 0))
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
          acnh.c(paramList1, (MessageRecord)localObject1, true);
          break label623;
          break;
        }
        bool = true;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMsgForMsgTabWithAutoInit(paramMessageRecord.frienduin, paramMessageRecord.istroop);
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
      int i = acnh.a(paramMessageRecord.istroop);
      if ((i == 1001) || (i == 10002)) {
        if (acnh.d(paramMessageRecord))
        {
          a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, paramMessageRecord.frienduin, (String)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.LBS_SAY_HELLO_LIST_UIN, i);
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
        a(AppConstants.LBS_HELLO_UIN, i, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
        continue;
        if (acnh.a(paramMessageRecord.istroop) == 1009)
        {
          a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessageRecord.frienduin, (String)localObject3);
          localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.SAME_STATE_BOX_UIN, 1009);
        }
        else
        {
          localObject1 = localObject2;
          if (acnh.a(paramMessageRecord.istroop) == 1010) {
            if (acnh.d(paramMessageRecord))
            {
              a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject3 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
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
              a(AppConstants.DATE_UIN, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.DATE_UIN, 1010);
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, acmb paramacmb)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramEntityManager = paramacmb.d;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = bcrg.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    paramacmb = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
      }
      paramMessageRecord.extraflag = 32772;
      paramMessageRecord.sendFailCode = 0;
    }
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramMessageRecord;
      if (localMessageForUniteGrayTip.callback != null) {
        localMessageForUniteGrayTip.callback.a(localMessageForUniteGrayTip);
      }
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {
      e(paramMessageRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, new acnu(), paramBoolean1, paramBoolean2, paramBoolean4);
    if ((paramMessageRecord instanceof MessageForStructing)) {
      a((MessageForStructing)paramMessageRecord);
    }
    if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) {
      a(paramMessageRecord, paramEntityManager, paramacmb, i);
    }
    try
    {
      for (;;)
      {
        g(paramMessageRecord);
        try
        {
          f(paramMessageRecord);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", paramMessageRecord);
          return;
        }
        a(paramMessageRecord, true, 1);
      }
    }
    catch (Exception paramEntityManager)
    {
      for (;;)
      {
        QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", paramEntityManager);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, onq paramonq)
  {
    String str = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = acnh.a(str, j);
    int i = 0;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.containsKey(paramMessageRecord))
    {
      paramMessageRecord = paramonq.a();
      localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMsgForMsgTab(str, j);
      if (localObject == null) {
        break label158;
      }
      a((MessageRecord)localObject, true, 4);
      paramonq = (onq)localObject;
    }
    for (;;)
    {
      if (((paramMessageRecord != null) && (str.equals(paramMessageRecord.mUin))) || (i != 0))
      {
        paramMessageRecord = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().findRecentUserByUin(String.valueOf(9970L), 7120);
        if (paramMessageRecord != null)
        {
          if (paramonq != null)
          {
            paramMessageRecord.lastmsgtime = paramonq.time;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().saveRecentUser(paramMessageRecord);
          }
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramMessageRecord);
        }
      }
      return;
      label158:
      paramonq.b(str);
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        paramonq = paramonq.a();
        paramMessageRecord = paramonq;
        if (paramonq != null)
        {
          localObject = localQQMessageFacade.getLastMessage(paramonq.mUin, 1008);
          i = 1;
          paramMessageRecord = paramonq;
          paramonq = (onq)localObject;
          continue;
        }
      }
      paramonq = (onq)localObject;
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
      if (!acnh.a(paramMessageRecord, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label451;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + paramMessageRecord);
      }
      Object localObject2 = acnh.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.containsKey(localObject2))
      {
        localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.get(localObject2);
        if ((!paramMessageRecord.isread) && (localObject2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop, (MessageRecord)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.stopHttpProcessorIfNeed(paramMessageRecord);
      int k = ((List)localObject1).size();
      for (;;)
      {
        if (j < k)
        {
          localObject2 = (MessageRecord)((List)localObject1).get(j);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((MessageRecord)localObject2).istroop).a((MessageRecord)localObject2, paramBoolean2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c((MessageRecord)localObject2);
          j += 1;
          continue;
          ((List)localObject1).add(paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.isTheLastTabMsg(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramMessageRecord);
      }
      if (i != 0)
      {
        localObject1 = (onq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (!acnh.t(paramMessageRecord.istroop)) {
          break label353;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).f();
        }
        return;
        label353:
        if (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))
        {
          a(paramMessageRecord, (onq)localObject1);
        }
        else if ((paramMessageRecord.istroop == 1008) && (uot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
          uot.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((paramMessageRecord.istroop != 1008) || (!uot.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin)))
        {
          b(paramMessageRecord);
        }
      }
      label451:
      i = 0;
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    ((akes)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(paramString, paramInt, -1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.needRefreshAIO = true;
    paramRefreshMessageContext.uin = paramString;
    paramRefreshMessageContext.uinType = paramInt1;
    paramRefreshMessageContext.count = paramInt2;
    if (acnh.a(paramInt1) != 1032) {}
    for (String str = acnh.a(paramString, paramInt1); this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.refreshActionMap.containsKey(str); str = aqvh.a(paramString, paramInt1, paramRefreshMessageContext.topicId))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      if ((paramRefreshMessageContext.numTroopRefresh) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.BaseMessageManager", 2, "numTroopRefresh = " + paramRefreshMessageContext.numTroopRefresh + ", refreshActionMap[" + acnh.a(paramString, paramInt1) + "] = " + this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.refreshActionMap.get(str));
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.refreshActionMap.put(str, Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new BaseMessageManager.RefreshRunnable(paramString, paramInt1, paramInt2, paramRefreshMessageContext, str, this));
  }
  
  protected void a(String paramString, int paramInt, long paramLong) {}
  
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt, paramLong, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt, paramLong);
    a(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt));
    a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).b(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((acnh.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
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
    if (acnh.b(paramString1))
    {
      acnd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade, paramString1, paramInt1, paramString2, paramString3, paramBoolean);
      return;
    }
    acnd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (uqx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt))) {}
    do
    {
      do
      {
        return;
        if ((paramInt != 1008) || (!uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
          break;
        }
        paramString2 = (onq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      } while (paramString2 == null);
      paramString2.a(paramString1, paramLong);
      return;
    } while (acnh.a(paramInt) == 1032);
    aoxz localaoxz;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().b(paramString1, paramInt)) || (!acnh.t(paramInt)))
    {
      localaoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      if (0L == paramLong)
      {
        paramString2 = (RecentUser)localaoxz.findRecentUser(paramString1, paramInt);
        if (paramString2 == null) {
          break label242;
        }
        paramString2.lastmsgdrafttime = paramLong;
        if ((0L != paramLong) || (paramString2.lastmsgtime != 0L)) {
          break label227;
        }
        localaoxz.delRecentUser(paramString2);
      }
    }
    for (;;)
    {
      if ((paramInt == 1008) && (uot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {
        uot.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString3, paramLong);
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(paramString2);
      return;
      RecentUser localRecentUser = (RecentUser)localaoxz.findRecentUserByUin(paramString1, paramInt);
      localRecentUser.troopUin = paramString2;
      paramString2 = localRecentUser;
      break;
      label227:
      axnp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localaoxz.saveRecentUser(paramString2);
      label242:
      continue;
      paramString2 = null;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramInt, paramString2, paramString3, paramInt, 0, paramBoolean);
  }
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle);
  
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
      if (a(paramString, paramInt1)) {
        i = 1;
      }
      MessageRecord localMessageRecord;
      acmw localacmw;
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt1) > 0)
        {
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1);
          localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
          if (localMessageRecord != null) {
            l = a(localMessageRecord);
          }
          localacmw.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
          b(paramString, paramInt1);
          i = j;
        }
      }
      while (i != 0)
      {
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt1, paramInt2));
        a(paramString, paramInt1);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt1, paramInt2) > 0)
          {
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, paramInt2);
            localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
            if (localMessageRecord != null) {
              l = a(localMessageRecord);
            }
            localacmw.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2, paramInt2);
            b(paramString, paramInt1);
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
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject2 = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)localObject2).jdField_a_of_type_Int;
    String str1 = ((RevokeMsgInfo)localObject2).jdField_a_of_type_JavaLangString;
    Object localObject1 = ((RevokeMsgInfo)localObject2).jdField_b_of_type_JavaLangString;
    int j = ((RevokeMsgInfo)localObject2).jdField_e_of_type_Int;
    int k = ((RevokeMsgInfo)localObject2).g;
    Object localObject4 = ((RevokeMsgInfo)localObject2).jdField_f_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify frienduin = " + str1 + ", fromUin = " + (String)localObject1 + ", istroop = " + i + ", grayTipsWordingId = " + k + ", senderUin = " + ((RevokeMsgInfo)localObject2).d);
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(i).f(str1, i);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(str1, i, aopk.jdField_a_of_type_Int, aopk.g);
    }
    List localList;
    do
    {
      return;
      localList = a((List)localObject3, str1, i, paramArrayList);
      if ((localList == null) || (localList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(str1, i, aopk.jdField_a_of_type_Int, aopk.h);
        return;
      }
      if ((localList == null) || (localList.size() != 1) || (!avia.a((MessageRecord)localList.get(0)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
      }
      paramArrayList = (MessageRecord)localList.get(0);
    } while (!(paramArrayList instanceof MessageForUniteGrayTip));
    avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)paramArrayList, i);
    return;
    localObject3 = (MessageRecord)localList.get(0);
    Object localObject5 = localList.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      paramArrayList = (MessageRecord)((Iterator)localObject5).next();
      if ((paramArrayList.shmsgseq == ((RevokeMsgInfo)localObject2).jdField_a_of_type_Long) && (paramArrayList.msgUid == ((RevokeMsgInfo)localObject2).jdField_b_of_type_Long)) {
        localObject3 = paramArrayList;
      }
    }
    for (;;)
    {
      localObject5 = new MessageForUniteGrayTip();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697453);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697452);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697449);
      k = ((RevokeMsgInfo)localObject2).jdField_f_of_type_Int;
      if ((j == 1) || (j == 2))
      {
        localObject4 = anvx.a(2131700525);
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        long l;
        if (((MessageRecord)localList.get(0)).msgtype != -2006)
        {
          l = ((MessageRecord)localList.get(0)).time;
          if ((((RevokeMsgInfo)localObject2).d == null) || (a(((RevokeMsgInfo)localObject2).d))) {
            break label864;
          }
          localObject2 = a(i, (String)localObject4, ((RevokeMsgInfo)localObject2).d, str1, paramArrayList, (MessageForUniteGrayTip)localObject5, l);
          localObject1 = ((avhz)localObject2).c;
        }
        for (;;)
        {
          ((avhz)localObject2).e = true;
          ((avhz)localObject2).f = false;
          ((MessageForUniteGrayTip)localObject5).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avhz)localObject2);
          ((MessageForUniteGrayTip)localObject5).msgUid = ((MessageRecord)localObject3).msgUid;
          ((MessageForUniteGrayTip)localObject5).shmsgseq = ((MessageRecord)localObject3).shmsgseq;
          ((MessageForUniteGrayTip)localObject5).saveExtInfoToExtStr("revoke_op_type", String.valueOf(j));
          if (k == 1) {
            nty.c((MessageRecord)localObject5);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doReplaceRevokedMsgAndNotify senderUin=", paramArrayList, ",frienduin=", str1 });
          }
          avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject5, localList, i, (String)localObject1, (avhz)localObject2);
          paramArrayList = localList.iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label1199;
            }
            localObject2 = (MessageRecord)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, false);
            if (((MessageRecord)localObject2).msgtype == -2005)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter();
              localObject2 = ((atlf)localObject1).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
              if (localObject2 != null)
              {
                ((atlf)localObject1).b((FileManagerEntity)localObject2);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(((FileManagerEntity)localObject2).nSessionId);
              }
              if (((MessageRecord)localObject3).istroop != 3000) {
                break;
              }
              audy.a("0X8005E50");
              audy.a("0X8005E4C");
            }
          }
          l = ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long;
          break;
          label864:
          localObject1 = anvx.a(2131700522) + BaseApplicationImpl.getApplication().getString(2131697453);
          if (k == 1) {
            localObject1 = ((String)localObject4).concat(str2);
          }
          paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject2 = new avhz(str1, paramArrayList, (String)localObject1, i, -5040, 1, ((MessageRecord)localObject3).time);
        }
      }
      paramArrayList = anvx.a(2131700520) + BaseApplicationImpl.getApplication().getString(2131694158);
      localObject2 = ((MessageRecord)localObject3).senderuin;
      if (k == 1) {
        paramArrayList = anvx.a(2131700520) + str2;
      }
      for (;;)
      {
        label1017:
        localObject4 = new avhz(str1, (String)localObject2, paramArrayList, i, -5040, 1, ((MessageRecord)localObject3).time);
        localObject1 = localObject2;
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<RevokeMsgInfo>)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          }
          for (;;)
          {
            localObject1 = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              paramArrayList = (ArrayList<RevokeMsgInfo>)localObject1;
              if (((String)localObject1).length() > 9) {
                paramArrayList = ((String)localObject1).substring(0, 8) + "...";
              }
              paramArrayList = paramArrayList.concat(BaseApplicationImpl.getApplication().getString(2131694158));
            }
            for (;;)
            {
              paramArrayList = paramArrayList.concat("，" + (String)localObject4);
              break label1017;
              audy.a("0X8005E4D");
              break;
              label1199:
              a(i, str1, (MessageRecord)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(i).g(str1, i));
              avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject5);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(null, true);
              return;
            }
          }
        }
      }
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.get(0);
    int i;
    int n;
    Object localObject4;
    Object localObject1;
    Object localObject3;
    String str3;
    int m;
    int i1;
    boolean bool2;
    int j;
    String str2;
    String str1;
    if (localRevokeMsgInfo.jdField_c_of_type_Int > 1)
    {
      i = 1;
      n = localRevokeMsgInfo.jdField_a_of_type_Int;
      localObject4 = localRevokeMsgInfo.jdField_b_of_type_JavaLangString;
      localObject1 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
      localObject3 = localRevokeMsgInfo.d;
      str3 = localRevokeMsgInfo.jdField_e_of_type_JavaLangString;
      m = localRevokeMsgInfo.jdField_e_of_type_Int;
      i1 = localRevokeMsgInfo.jdField_f_of_type_Int;
      bool2 = localRevokeMsgInfo.jdField_a_of_type_Boolean;
      j = localRevokeMsgInfo.g;
      str2 = localRevokeMsgInfo.jdField_f_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify fromUin = " + (String)localObject4 + ", istroop = " + n + ",toUin=" + (String)localObject1 + ",groupUin=" + (String)localObject3 + ",authorUin=" + str3 + ",opType= " + m + ",anonyType " + i1 + ", needShow = " + bool2 + ", grayTipsWordingId = " + j);
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject5 = localObject3;
      if (n != 1004) {
        if (n != 1000) {
          break label367;
        }
      }
    }
    ArrayList localArrayList;
    Object localObject6;
    label367:
    for (Object localObject5 = localObject3;; localObject5 = localObject4)
    {
      paramBoolean = TextUtils.equals(str1, (CharSequence)localObject4);
      if ((n != 3000) && (n != 1)) {
        break label374;
      }
      localObject3 = localObject1;
      localArrayList = new ArrayList();
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject6 = (RevokeMsgInfo)((Iterator)localObject1).next();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq((String)localObject3, n, ((RevokeMsgInfo)localObject6).jdField_a_of_type_Long, ((RevokeMsgInfo)localObject6).jdField_b_of_type_Long);
        if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
          localArrayList.addAll((Collection)localObject6);
        }
      }
      i = 0;
      break;
    }
    label374:
    if (paramBoolean) {}
    for (;;)
    {
      localObject3 = localObject1;
      break;
      localObject1 = localObject4;
    }
    if (i != 0) {}
    try
    {
      Collections.sort(localArrayList, acnh.a);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        if (avia.a((MessageRecord)localArrayList.get(0))) {
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", localException);
            }
          }
          if (((MessageRecord)localArrayList.get(0)).msgtype != -2006) {
            break label526;
          }
          if (!(localArrayList.get(0) instanceof MessageForFoldMsg)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: same revoke msg");
      return;
      label526:
      j = 1;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        j = 0;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramArrayList);
          return;
        }
      }
      if (localRevokeMsgInfo.jdField_f_of_type_Int != 1) {
        break label2222;
      }
    }
    int k;
    if (!paramBoolean) {
      if (m == 0)
      {
        k = 1;
        if ((k == 0) || (localArrayList.size() <= 0)) {
          break label1241;
        }
        paramBoolean = ((MessageRecord)localArrayList.get(0)).isSend();
      }
    }
    label673:
    label2222:
    for (;;)
    {
      label623:
      localObject6 = new MessageForUniteGrayTip();
      long l;
      label708:
      String str4;
      Object localObject2;
      if ((j != 0) && (((MessageRecord)localArrayList.get(0)).msgtype != -2006))
      {
        l = ((MessageRecord)localArrayList.get(0)).time;
        if (!paramBoolean) {
          break label1266;
        }
        if ((m != 0) || (localRevokeMsgInfo.jdField_f_of_type_Int != 0) || (TextUtils.isEmpty(str2))) {
          break label1256;
        }
        paramArrayList = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697453);
        str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697452);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697449);
        if ((m != 1) && (m != 2)) {
          break label1656;
        }
        if (!TextUtils.equals((CharSequence)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label1462;
        }
        if ((str3 == null) || (a(str3))) {
          break label1404;
        }
        paramArrayList = a(n, paramArrayList, str3, (String)localObject3, (String)localObject5, (MessageForUniteGrayTip)localObject6, l);
        localObject2 = paramArrayList.c;
        label817:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doHandleRevokedNotifyAndNotify isRevokeSender = ", Boolean.valueOf(paramBoolean), ",selfuin=", str1, ",fromUin=", localObject4 });
        }
        paramArrayList.e = true;
        paramArrayList.f = false;
        ((MessageForUniteGrayTip)localObject6).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
        if (j == 0) {
          break label1798;
        }
        l = ((MessageRecord)localArrayList.get(0)).msgUid;
        ((MessageForUniteGrayTip)localObject6).msgUid = l;
        ((MessageForUniteGrayTip)localObject6).shmsgseq = localRevokeMsgInfo.jdField_a_of_type_Long;
        ((MessageForUniteGrayTip)localObject6).saveExtInfoToExtStr("revoke_op_type", String.valueOf(m));
        if (i1 == 1) {
          nty.c((MessageRecord)localObject6);
        }
        if (paramBoolean) {
          avia.a(localArrayList);
        }
        if (j == 0) {
          break label2003;
        }
        paramArrayList = localArrayList.iterator();
        label973:
        if (!paramArrayList.hasNext()) {
          break label2003;
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
          break label1808;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(n).a((MessageRecord)localObject2, false);
        if ((((MessageRecord)localObject2).msgtype == -2005) || ((localObject2 instanceof MessageForTroopFile)))
        {
          if (((MessageRecord)localObject2).msgtype != -2005) {
            break label1913;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter();
          localObject5 = ((atlf)localObject4).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject5 == null) {
            break label1868;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
          }
          ((atlf)localObject4).b((FileManagerEntity)localObject5);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(((FileManagerEntity)localObject5).nSessionId);
        }
      }
      for (;;)
      {
        ((bedr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).b((MessageRecord)localObject2);
        localObject2 = EmojiStickerManager.a((MessageRecord)localObject2);
        if (localObject2 == null) {
          break label973;
        }
        EmojiStickerManager.a().b.put(localObject2, Boolean.valueOf(true));
        break label973;
        k = 0;
        break;
        label1241:
        paramBoolean = false;
        break label623;
        l = localRevokeMsgInfo.jdField_c_of_type_Long;
        break label673;
        label1256:
        paramArrayList = anvx.a(2131700524);
        break label708;
        label1266:
        if (n == 1)
        {
          paramArrayList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).d((String)localObject3);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt(ContactUtils.KEY_TROOP_MEM_NICK_UPDATE_TARGET, ContactUtils.VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG);
          ((Bundle)localObject2).putLong(ContactUtils.KEY_UNI_SEQ, ((MessageForUniteGrayTip)localObject6).uniseq);
          localObject2 = ContactUtils.getTroopNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject5, (String)localObject3, paramArrayList, true, (Bundle)localObject2);
          paramArrayList = (ArrayList<RevokeMsgInfo>)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            paramArrayList = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject5, (String)localObject3, 1, 0);
          }
          break label708;
        }
        if (n == 3000)
        {
          paramArrayList = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject5, (String)localObject3, 2, 0);
          break label708;
        }
        paramArrayList = anvx.a(2131700516);
        break label708;
        label1404:
        localObject2 = paramArrayList.concat(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697453));
        if (i1 == 1) {
          localObject2 = paramArrayList.concat(str4);
        }
        paramArrayList = new avhz((String)localObject3, (String)localObject5, (String)localObject2, n, -5040, 1, l);
        break label817;
        label1462:
        if (m == 2) {}
        for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697481);; localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697480))
        {
          k = ((String)localObject2).length();
          int i2 = ((String)localObject2).length();
          int i3 = paramArrayList.length();
          paramArrayList = new avhz((String)localObject3, (String)localObject5, (String)localObject2 + paramArrayList + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697453), n, -5040, 1, l);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt(ContactUtils.KEY_TROOP_MEM_NICK_UPDATE_TARGET, ContactUtils.VALUE_EXTRA_UPDATE_TARGET_REVOKED_GRAY_MSG);
          ((Bundle)localObject2).putLong(ContactUtils.KEY_UNI_SEQ, ((MessageForUniteGrayTip)localObject6).uniseq);
          ((Bundle)localObject2).putInt("key_action", 5);
          ((Bundle)localObject2).putString("troop_mem_uin", String.valueOf(localObject4));
          ((Bundle)localObject2).putBoolean("need_update_nick", true);
          paramArrayList.a(k, i2 + i3, (Bundle)localObject2);
          break;
        }
        label1656:
        if (localRevokeMsgInfo.jdField_f_of_type_Int == 1) {
          if (paramBoolean) {
            localObject2 = paramArrayList.concat(str4);
          }
        }
        for (;;)
        {
          paramArrayList = new avhz((String)localObject3, (String)localObject5, (String)localObject2, n, -5040, 1, l);
          break;
          localObject2 = paramArrayList;
          if (paramArrayList.length() > 9) {
            localObject2 = paramArrayList.substring(0, 8) + "...";
          }
          paramArrayList = ((String)localObject2).concat(BaseApplicationImpl.getApplication().getString(2131694158));
          localObject2 = paramArrayList;
          if (!TextUtils.isEmpty(str2)) {
            localObject2 = paramArrayList.concat("，" + str2);
          }
        }
        l = localRevokeMsgInfo.jdField_b_of_type_Long;
        break label910;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        localObject5 = ((MessageRecord)localObject2).frienduin;
        k = ((MessageRecord)localObject2).istroop;
        l = ((MessageRecord)localObject2).uniseq;
        if (!bool2) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject4).removeMsgByUniseq((String)localObject5, k, l, bool1);
          break;
        }
        label1868:
        if (QLog.isColorLevel())
        {
          QLog.i("Q.msg.BaseMessageManager", 2, "can't find fileEntity,uniseq[" + ((MessageRecord)localObject2).uniseq + "],");
          continue;
          label1913:
          if ((localObject2 instanceof MessageForTroopFile))
          {
            localObject5 = (MessageForTroopFile)localObject2;
            localObject4 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(((MessageForTroopFile)localObject5).frienduin));
            localObject5 = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject5);
            if ((localObject5 != null) && (((bfjs)localObject5).a != null) && (localObject4 != null))
            {
              localObject5 = ((TroopFileTransferManager)localObject4).a(((bfjs)localObject5).a);
              if (localObject5 != null) {
                ((TroopFileTransferManager)localObject4).a((TroopFileTransferManager.Item)localObject5, 12);
              }
            }
          }
        }
      }
      label2003:
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(n).g((String)localObject3, n);
      if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
        }
        if (!bool2) {
          break label2133;
        }
        avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject6);
      }
      for (;;)
      {
        if (j == 0) {
          break label2161;
        }
        paramArrayList = localArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject2 = (MessageRecord)paramArrayList.next();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.a((MessageRecord)localObject2);
        }
        if (!bool2) {
          break;
        }
        a(n, (String)localObject3, (MessageRecord)localObject6, paramArrayList);
        break;
        label2133:
        if (localArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(localArrayList.get(0));
        }
      }
      label2161:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.a((MessageRecord)localObject6);
      if ((j != 0) && (!((MessageRecord)localArrayList.get(0)).isread)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(localArrayList, paramBoolean);
      return;
    }
  }
  
  public void a(List<MessageRecord> paramList)
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
  
  public void a(List<? extends MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (paramList.size() == 0) {}
    label775:
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
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.stopHttpProcessorIfNeed((MessageRecord)localObject2);
          break;
          localArrayList.add(localObject2);
        }
      }
      localObject1 = acnh.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop);
      if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.containsKey(localObject1))
      {
        localObject1 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.get(localObject1);
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, (List)localObject2);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((MessageRecord)localObject3).istroop).a(localArrayList, paramBoolean2);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c((MessageRecord)localObject1);
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(localArrayList);
      }
      if ((localObject3 instanceof MessageForLongMsg))
      {
        if (!acnh.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop))) {
          break label666;
        }
        i = j;
        if (i != 0)
        {
          paramList = (onq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
          if (!acnh.t(((MessageRecord)localObject3).istroop)) {
            break label672;
          }
          a((MessageRecord)localObject3);
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label775;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((MessageRecord)localObject3).istroop).f();
        return;
        i = j;
        if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.isTheLastTabMsg((MessageRecord)localObject3)) {
          break;
        }
        label666:
        i = 0;
        break;
        label672:
        if (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin))
        {
          a((MessageRecord)localObject3, paramList);
        }
        else if ((((MessageRecord)localObject3).istroop == 1008) && (uot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
        {
          b((MessageRecord)localObject3);
          uot.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else if ((((MessageRecord)localObject3).istroop != 1008) || (!uot.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject3).frienduin)))
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
        h(paramMessageRecord);
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
        h(paramMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    if (paramMessageRecord == null) {}
    label334:
    for (;;)
    {
      return false;
      if (paramMessageRecord.isLongMsg())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord))
        {
          a(paramMessageRecord, paramInt);
          return false;
        }
        paramMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.findLongMsgHead(paramMessageRecord);
      }
      for (;;)
      {
        if ((paramMessageRecord.istroop == 1036) || (bjxa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)) || (!paramMessageRecord.isValid) || (acnh.h(paramMessageRecord.msgtype)) || ((paramMessageRecord.frienduin.equals(AppConstants.MAYKNOW_RECOMMEND_UIN)) && (paramMessageRecord.istroop == 0)) || ((paramMessageRecord.frienduin.equals(AppConstants.FRIEND_ANNIVER_UIN)) && (paramMessageRecord.istroop == 0))) {
          break label334;
        }
        QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + localMessage.getBaseInfoString());
        }
        if (b(paramMessageRecord)) {
          break;
        }
        if (paramInt == 1)
        {
          bool = a(paramMessageRecord, localMessage);
          if (acnh.a(paramMessageRecord, localMessage))
          {
            if (paramMessageRecord.longMsgIndex >= localMessage.longMsgIndex) {
              break;
            }
            bool = false;
          }
          paramBoolean = a(paramMessageRecord, paramBoolean, false, localMessage, bool);
        }
        for (;;)
        {
          a(paramBoolean, localMessage);
          return paramBoolean;
          if ((paramInt == 4) || (paramInt == 2))
          {
            a(paramMessageRecord, paramBoolean, localMessage);
            paramBoolean = true;
          }
          else
          {
            paramBoolean = bool;
            if (paramInt == 3)
            {
              a(paramMessageRecord, localMessage);
              paramBoolean = true;
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "10000")) || (TextUtils.equals(paramString, "1000000")) || (TextUtils.equals(paramString, "50000000")) || (TextUtils.equals(paramString, "80000000")) || (b(paramString));
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    return bapk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if (paramString == null)
    {
      paramEntityManager = new QQMessageFacade.Message();
      return paramEntityManager;
    }
    String str1 = acnh.a(paramString, paramInt1);
    Object localObject = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.get(str1);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt1);
    if ((localObject == null) || (!((QQMessageFacade.Message)localObject).isCacheValid) || (((QQMessageFacade.Message)localObject).getConfessTopicId() != paramInt2))
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(str2, paramEntityManager, paramInt2);
      localObject = localMessage;
      if (localMessage != null)
      {
        localObject = localMessage;
        if (localMessage.uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(localMessage.istroop).b(localMessage.frienduin, localMessage.istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(localMessage.istroop).a(str2, paramEntityManager, paramInt2);
          localObject = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject = paramEntityManager;
          }
        }
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
    for (paramString = a(str1, paramEntityManager, localStringBuilder);; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramEntityManager = paramString;
      if (paramString == null) {
        break;
      }
      paramEntityManager = paramString;
      if (!acnh.b(paramString.frienduin, paramString.istroop)) {
        break;
      }
      paramString.istroop = acnh.a(paramString.istroop);
      return paramString;
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" : case 5 : not null or isValid : " + localObject);
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
  
  protected void b(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = paramRefreshMessageContext.numTroopRefresh;
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
    paramMessageRecord = acnh.a((String)localObject, j);
    if (this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.containsKey(paramMessageRecord)) {
      if (j != 1026) {
        break label240;
      }
    }
    label240:
    for (int i = 1;; i = j)
    {
      RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().findRecentUser((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMsgForMsgTabWithAutoInit((String)localObject, j);
      if (localObject != null)
      {
        a((MessageRecord)localObject, true, 4);
        if (localRecentUser != null)
        {
          if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
            localRecentUser.troopUin = ((MessageRecord)localObject).senderuin;
          }
          localRecentUser.setType(i);
          localRecentUser.lastmsgtime = ((MessageRecord)localObject).time;
          axnp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().saveRecentUser(localRecentUser);
        }
      }
      for (;;)
      {
        if (localRecentUser != null) {
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(localRecentUser);
        }
        return;
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
          }
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.removeRecentUser(localRecentUser);
          this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.cachedMsg.remove(paramMessageRecord);
        }
      }
    }
  }
  
  protected void b(String paramString, int paramInt) {}
  
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
        if (acnh.a(paramInt1) != 1009) {
          break label273;
        }
        localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.SAME_STATE_BOX_UIN, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString)))
        {
          paramString = bcsa.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = AppConstants.SAME_STATE_BOX_UIN;
          if (paramInt2 != 3) {
            break label181;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
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
                                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, l, paramMessageRecord.msg);
                                      return;
                                    }
                                  } while (paramInt2 != 4);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.SAME_STATE_BOX_UIN, 1009, paramString.senderuin, paramString.selfuin, 0);
                                  a(paramString, null, false, true, paramInt2);
                                  a(paramString, true, paramInt2);
                                  return;
                                  if ((acnh.a(paramInt1) != 1001) && (acnh.a(paramInt1) != 10002)) {
                                    break label1072;
                                  }
                                  i = acnh.a(paramInt1);
                                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
                                  bool2 = acnh.d(paramMessageRecord);
                                  bool1 = false;
                                  if (bool2) {
                                    bool1 = ((acmw)localObject).a(paramString, i, AppConstants.LBS_HELLO_UIN);
                                  }
                                  if ((!bool2) || (bool1)) {
                                    break;
                                  }
                                  localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.LBS_SAY_HELLO_LIST_UIN, i);
                                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                                paramString = bcsa.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                                paramString.frienduin = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                                paramString.senderuin = paramMessageRecord.frienduin;
                                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localMessageRecord = bcsa.a(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                                localMessageRecord.frienduin = AppConstants.LBS_HELLO_UIN;
                                localMessageRecord.senderuin = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
                                if (paramInt2 != 3) {
                                  break;
                                }
                                a(paramString, true, paramInt2);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)));
                              a(localMessageRecord, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              return;
                              if (paramInt2 != 2) {
                                break;
                              }
                              a(paramString, true, paramInt2);
                              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, l, paramMessageRecord.msg);
                            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)));
                            a(localMessageRecord, true, paramInt2);
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.msg);
                            return;
                          } while (paramInt2 != 4);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_SAY_HELLO_LIST_UIN, i, paramString.senderuin, paramString.selfuin, 0);
                          a(paramString, null, false, true, 1);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
                          a(localMessageRecord, null, false, true, 1);
                          a(paramString, true, paramInt2);
                        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.LBS_SAY_HELLO_LIST_UIN)));
                        a(localMessageRecord, true, paramInt2);
                        return;
                        localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.LBS_HELLO_UIN, i);
                      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                      paramString = bcsa.a(paramMessageRecord.msgtype);
                      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                      paramString.selfuin = paramMessageRecord.selfuin;
                      paramString.senderuin = paramMessageRecord.frienduin;
                      paramString.frienduin = AppConstants.LBS_HELLO_UIN;
                      if (paramInt2 == 3)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                        return;
                      }
                      if (paramInt2 == 2)
                      {
                        a(paramString, true, paramInt2);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, l, paramMessageRecord.msg);
                        return;
                      }
                    } while (paramInt2 != 4);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.LBS_HELLO_UIN, i, paramString.senderuin, paramString.selfuin, 0);
                    a(paramString, null, false, true, paramInt2);
                    a(paramString, true, paramInt2);
                    return;
                  } while (acnh.a(paramInt1) != 1010);
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
                  boolean bool2 = acnh.d(paramMessageRecord);
                  boolean bool1 = false;
                  if (bool2) {
                    bool1 = ((acmw)localObject).a(paramString, 1010, AppConstants.DATE_UIN);
                  }
                  if ((!bool2) || (bool1)) {
                    break;
                  }
                  localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                paramString = bcsa.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.frienduin = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localMessageRecord = bcsa.a(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                localMessageRecord.frienduin = AppConstants.DATE_UIN;
                localMessageRecord.senderuin = AppConstants.DATE_SAY_HELLO_LIST_UIN;
                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.DATE_UIN, 1010);
                if (paramInt2 != 3) {
                  break;
                }
                a(paramString, true, paramInt2);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN)));
              a(localMessageRecord, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
              if (paramInt2 != 2) {
                break;
              }
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, l, paramMessageRecord.msg);
            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN)));
            a(localMessageRecord, true, paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.msg);
            return;
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010, paramString.senderuin, paramString.selfuin, 0);
          a(paramString, null, false, true, 1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
          a(localMessageRecord, null, false, true, 1);
          a(paramString, true, paramInt2);
        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(AppConstants.DATE_SAY_HELLO_LIST_UIN)));
        a(localMessageRecord, true, paramInt2);
        return;
        localObject = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(AppConstants.DATE_UIN, 1010);
      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
      paramString = bcsa.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = AppConstants.DATE_UIN;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label273:
    label1072:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(AppConstants.DATE_UIN, 1010, paramString.senderuin, paramString.selfuin, 0);
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
      if (acnh.b(paramString, paramInt)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
    return;
    Object localObject = null;
    if (paramString.equals(AppConstants.LBS_HELLO_UIN)) {
      localObject = AppConstants.LBS_SAY_HELLO_LIST_UIN;
    }
    acmw localacmw;
    while (localObject != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a((String)localObject, paramInt) > 0)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a((String)localObject, paramInt);
        localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
        if (paramString != null) {
          l = a(paramString);
        }
        localacmw.a((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
        b((String)localObject, paramInt);
        return;
        if (paramString.equals(AppConstants.DATE_UIN)) {
          localObject = AppConstants.DATE_SAY_HELLO_LIST_UIN;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt) > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt);
      localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
      if (localObject != null) {
        l = a((MessageRecord)localObject);
      }
      localacmw.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      b(paramString, paramInt);
    }
    for (int i = 1;; i = 0)
    {
      if (paramString.equals(AppConstants.CONFESS_UIN))
      {
        aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
        aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
      }
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
      }
    }
  }
  
  protected boolean b(String paramString)
  {
    return ((bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramString);
  }
  
  protected void c(QQMessageFacade.Message paramMessage) {}
  
  public void c(MessageRecord paramMessageRecord) {}
  
  public void d(MessageRecord paramMessageRecord)
  {
    Object localObject = anvx.a(2131700515);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localObject = new avhz(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 1, paramMessageRecord.time);
    ((avhz)localObject).f = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avhz)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramMessageRecord.istroop).f(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, aopk.jdField_a_of_type_Int, aopk.i);
      return;
    }
    avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */
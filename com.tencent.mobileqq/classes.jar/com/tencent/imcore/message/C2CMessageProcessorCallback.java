package com.tencent.imcore.message;

import PushNotifyPack.C2CMsgReadedNotify;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.etrump.mixlayout.ETDIYUtil;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.app.message.GiftMessageUtils;
import com.tencent.mobileqq.app.message.MessageStatisticHelper;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ConversationInfoErrorReporter;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.dating.MsgBoxProtocol;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.gamecenter.message.TinyMsgCodec;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.api.INearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.FriendShieldUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;

public class C2CMessageProcessorCallback
  implements C2CMessageProcessor.Callback
{
  public int a;
  HashSet<String> jdField_a_of_type_JavaUtilHashSet = null;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  HashSet<String> b;
  public int c;
  public int d;
  public int e = 0;
  public int f = 1;
  public int g = 5;
  public int h = 10;
  public int i = 50;
  public int j = 0;
  
  public C2CMessageProcessorCallback()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 10;
    this.jdField_d_of_type_Int = 30;
    this.jdField_b_of_type_JavaUtilHashSet = null;
  }
  
  private static int a(msg_comm.Msg paramMsg)
  {
    int m = -1;
    int k = m;
    try
    {
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      int i1 = m;
      if (paramMsg != null)
      {
        k = m;
        i1 = m;
        if (paramMsg.size() > 0)
        {
          int i2 = 0;
          for (;;)
          {
            k = m;
            i1 = m;
            if (i2 >= paramMsg.size()) {
              break;
            }
            k = m;
            Object localObject = (im_msg_body.Elem)paramMsg.get(i2);
            i1 = m;
            k = m;
            if (((im_msg_body.Elem)localObject).general_flags.has())
            {
              k = m;
              boolean bool = ((im_msg_body.Elem)localObject).general_flags.bytes_pb_reserve.has();
              i1 = m;
              if (bool)
              {
                int n = m;
                k = m;
                try
                {
                  generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
                  n = m;
                  k = m;
                  localResvAttr.mergeFrom(((im_msg_body.Elem)localObject).general_flags.bytes_pb_reserve.get().toByteArray());
                  n = m;
                  i1 = m;
                  k = m;
                  if (localResvAttr.uint32_show_in_msg_list.has())
                  {
                    n = m;
                    k = m;
                    m = localResvAttr.uint32_show_in_msg_list.get();
                    n = m;
                    k = m;
                    i1 = m;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    n = m;
                    k = m;
                    localObject = new StringBuilder();
                    n = m;
                    k = m;
                    ((StringBuilder)localObject).append("----------handleMsgPush_PB_SlaveMaster has uint32ShowInMsgList:");
                    n = m;
                    k = m;
                    ((StringBuilder)localObject).append(m);
                    n = m;
                    k = m;
                    QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
                    return m;
                  }
                }
                catch (Exception localException)
                {
                  k = n;
                  QLog.e("msgFold", 1, "prase ResvAttr error, ", localException);
                  i1 = n;
                }
              }
            }
            i2 += 1;
            m = i1;
          }
        }
      }
      return i1;
    }
    catch (Throwable paramMsg)
    {
      QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", paramMsg);
      i1 = k;
    }
  }
  
  private long a(String paramString, int paramInt, AppInterface paramAppInterface)
  {
    if (paramInt == 1006)
    {
      paramString = ContactUtils.b(paramAppInterface, paramString);
      if (!TextUtils.isEmpty(paramString)) {
        return Long.parseLong(paramString);
      }
      return -1L;
    }
    return Long.parseLong(paramString);
  }
  
  private long a(msg_comm.Msg paramMsg, long paramLong)
  {
    long l1 = paramLong;
    try
    {
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      long l2 = paramLong;
      if (paramMsg != null)
      {
        l1 = paramLong;
        l2 = paramLong;
        if (paramMsg.size() > 0)
        {
          int k = 0;
          for (;;)
          {
            l1 = paramLong;
            l2 = paramLong;
            if (k >= paramMsg.size()) {
              break;
            }
            l1 = paramLong;
            im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.get(k);
            l2 = paramLong;
            l1 = paramLong;
            if (localElem.elem_flags2.has())
            {
              l2 = paramLong;
              l1 = paramLong;
              if (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.has())
              {
                l1 = paramLong;
                l2 = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.get();
              }
            }
            k += 1;
            paramLong = l2;
          }
        }
      }
      return l2;
    }
    catch (Throwable paramMsg)
    {
      QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", paramMsg);
      l2 = l1;
    }
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString, AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet == null) {}
    label129:
    label138:
    for (;;)
    {
      int k;
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashSet == null)
        {
          this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
          paramString = new StringBuilder();
          paramString.append(paramAppInterface.getCurrentAccountUin());
          paramString.append("_OneWayMsgDateRecentUinList");
          paramString = paramSharedPreferences.getString(paramString.toString(), "");
          paramSharedPreferences = paramString.split("\\|");
          int m = paramSharedPreferences.length;
          k = 0;
          if (k >= m) {
            break label138;
          }
          paramAppInterface = paramSharedPreferences[k];
          if ((paramAppInterface.length() <= 0) || (Long.parseLong(paramAppInterface) <= 0L)) {
            break label129;
          }
          this.jdField_a_of_type_JavaUtilHashSet.add(paramAppInterface);
          break label129;
        }
        return paramString;
      }
      finally {}
      return paramString;
      k += 1;
    }
  }
  
  private String a(SharedPreferences paramSharedPreferences, String paramString, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    Object localObject = paramString;
    if (!this.jdField_b_of_type_JavaUtilHashSet.contains(paramMessageRecord.frienduin))
    {
      this.jdField_b_of_type_JavaUtilHashSet.add(paramMessageRecord.frienduin);
      if (paramString.length() == 0)
      {
        paramString = paramMessageRecord.frienduin;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
        paramString = ((StringBuilder)localObject).toString();
      }
      paramMessageRecord = paramSharedPreferences.edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_OneWayMsgLBSFriendRecentUinList");
      paramMessageRecord.putString(((StringBuilder)localObject).toString(), paramString);
      paramSharedPreferences.edit().commit();
      localObject = paramString;
    }
    return localObject;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject2 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
      Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
      localObject2 = ((String)localObject2).split("\\|");
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject2.length >= 6) && (localObject1.length >= 6))
      {
        this.jdField_a_of_type_Int = Integer.parseInt(localObject2[0]);
        this.jdField_b_of_type_Int = Integer.parseInt(localObject2[1]);
        this.jdField_c_of_type_Int = Integer.parseInt(localObject2[2]);
        this.jdField_d_of_type_Int = Integer.parseInt(localObject2[3]);
        this.f = Integer.parseInt(localObject1[0]);
        this.g = Integer.parseInt(localObject1[1]);
        this.h = Integer.parseInt(localObject1[2]);
        this.i = Integer.parseInt(localObject1[3]);
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("DealOneWayMessageNotify,date:[");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
          ((StringBuilder)localObject1).append("],LBS:[");
          ((StringBuilder)localObject1).append(this.f);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(this.g);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(this.h);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(this.i);
          ((StringBuilder)localObject1).append("]");
          QLog.d("Q.nearby_bank", 4, ((StringBuilder)localObject1).toString());
        }
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(int paramInt, ArrayList<MessageRecord> paramArrayList)
  {
    if ((paramArrayList.size() == 0) && (paramInt > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
      }
      MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
      localMessageForText.msgtype = -1000;
      localMessageForText.msg = "";
      paramArrayList.add(localMessageForText);
    }
  }
  
  private void a(AppInterface paramAppInterface)
  {
    ((SystemMessageProcessor)((BaseMessageHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a("system_processor")).a();
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPoke))
    {
      if ((!paramMessageRecord.isread) && (!paramMessageRecord.isSend())) {
        ((MessageForPoke)paramMessageRecord).isPlayed = false;
      }
      ((MessageForPoke)paramMessageRecord).initMsg();
    }
  }
  
  private void a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && (paramMessageRecord.structingMsg.mMsgServiceID == 76)) {
        ((NowLiveManager)paramAppInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER)).a(paramMessageRecord);
      }
    }
  }
  
  private void a(DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageRecord paramMessageRecord)
  {
    if (paramDecodeProtoPkgContext.f)
    {
      paramMessageRecord.issend = 2;
      paramMessageRecord.isread = true;
      return;
    }
    if ((paramMessageRecord.msgtype != -2037) && (paramMessageRecord.msgtype != -2009)) {
      paramMessageRecord.isread = paramDecodeProtoPkgContext.jdField_a_of_type_Boolean;
    }
  }
  
  private void a(DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    paramAppInterface = (IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "");
    if ((1 == paramDecodeProtoPkgContext.jdField_d_of_type_Int) && (UinTypeUtil.h(paramMessageRecord.istroop)) && (UinTypeUtil.a(paramMessageRecord.istroop) != 1032) && (!paramAppInterface.isUinInRecentNotSubAccount(paramMessageRecord.frienduin)) && (!paramAppInterface.isInMsgBox(paramMessageRecord.frienduin, UinTypeUtil.a(paramMessageRecord.istroop), MsgProxyUtils.a(UinTypeUtil.a(paramMessageRecord.istroop)))))
    {
      MsgProxyUtils.a(paramMessageRecord, true);
      return;
    }
    MsgProxyUtils.a(paramMessageRecord, false);
  }
  
  private void a(String paramString, int paramInt, AppInterface paramAppInterface)
  {
    Integer localInteger = Integer.valueOf(-1);
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    if (localITempMsgBoxManager.isBelongToMsgBox(paramString, paramInt)) {
      localInteger = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(paramInt));
    } else if (localITempMsgBoxManager.isBelongToFilterBox(paramString, paramInt)) {
      localInteger = Integer.valueOf(10000);
    }
    if ((localInteger != null) && (localInteger.intValue() >= 0)) {
      ReportController.b(paramAppInterface, "dc00898", "", "", "0X800B1C2", "0X800B1C2", localInteger.intValue(), 0, "", "", "", "");
    }
  }
  
  private void a(String paramString, int paramInt, msg_svc.PbC2CReadedReportReq.UinPairReadInfo paramUinPairReadInfo, AppInterface paramAppInterface)
  {
    if (paramInt == 1024)
    {
      paramString = ((MessageCache)paramAppInterface.getMsgCache()).d(paramString);
      if (paramString != null)
      {
        if (QLog.isDevelopLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("Readcomfirmed------->Sig:");
          paramAppInterface.append(HexUtil.bytes2HexStr(paramString));
          paramAppInterface.append(",length:");
          paramAppInterface.append(paramString.length);
          QLog.d("Q.msg.sendReadConfirm_PB", 4, paramAppInterface.toString());
        }
        paramUinPairReadInfo.crm_sig.set(ByteStringMicro.copyFrom(paramString));
      }
    }
  }
  
  private void a(String paramString, AppInterface paramAppInterface)
  {
    if (MsgProxyUtils.a(paramString))
    {
      MsgBoxProtocol.a(paramAppInterface, 1, null);
      return;
    }
    if (UinTypeUtil.e(paramString))
    {
      MsgBoxProtocol.a(paramAppInterface);
      return;
    }
    MsgBoxProtocol.a(paramAppInterface, 2, null);
  }
  
  private void a(String paramString, ArrayList<MessageRecord> paramArrayList, int paramInt, AppInterface paramAppInterface)
  {
    if ((paramInt == 0) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        IceBreakingUtil.a(paramAppInterface, paramString, 0, (MessageRecord)paramArrayList.next());
      }
    }
  }
  
  private void a(String paramString, List<msg_comm.Msg> paramList, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (ConversationInfoErrorReporter.reportPublicaccoutTypeError(paramString, paramInt)))
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("reportPublicaccoutTypeError");
      localStringBuilder.append(" uin :");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" type :");
      localStringBuilder.append(paramInt);
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramString = (msg_comm.Msg)paramList.get(0);
        if (paramString.msg_head.has())
        {
          paramString = (msg_comm.MsgHead)paramString.msg_head.get();
          localStringBuilder.append(" msgType :");
          localStringBuilder.append(paramString.msg_type.get());
          localStringBuilder.append(" msgSeq :");
          localStringBuilder.append(paramString.msg_seq.get());
          localStringBuilder.append(" msgUid :");
          localStringBuilder.append(paramString.msg_uid.get());
          localStringBuilder.append(" msgTime :");
          localStringBuilder.append(paramString.msg_time.get());
          if (paramString.c2c_tmp_msg_head.has())
          {
            paramString = (msg_comm.C2CTmpMsgHead)paramString.c2c_tmp_msg_head.get();
            localStringBuilder.append(" serviceType :");
            localStringBuilder.append(paramString.service_type.get());
            localStringBuilder.append(" c2cType :");
            localStringBuilder.append(paramString.c2c_type.get());
          }
        }
      }
      QLog.e("Q.msg.C2CMessageProcessor", 1, localStringBuilder.toString());
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, int paramInt, AppInterface paramAppInterface)
  {
    if (paramInt == 1008) {
      try
      {
        IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (localIPublicAccountDataManager != null)
        {
          localIPublicAccountDataManager.decodeMessageRecord(paramArrayList, paramAppInterface);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("decodeC2CUinPublicAccountMsg get an Exception:");
        paramAppInterface.append(paramArrayList.toString());
        QLog.e("Q.msg.C2CMessageProcessor", 1, paramAppInterface.toString());
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean1, IMessageFacade paramIMessageFacade, short paramShort, boolean paramBoolean2, SharedPreferences paramSharedPreferences, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = paramString2;
    while (localIterator.hasNext())
    {
      paramString2 = (MessageRecord)localIterator.next();
      if ((a(paramString2, paramAppInterface)) && (paramIMessageFacade != null)) {
        if (paramString2.istroop == 1010)
        {
          paramString1 = b(paramSharedPreferences, paramString1, paramString2, paramAppInterface);
          b(paramBoolean1, paramShort, paramBoolean2, paramSharedPreferences, paramString2, paramAppInterface);
        }
        else if ((paramString2.istroop == 1001) || (paramString2.istroop == 10002))
        {
          paramArrayList = a(paramSharedPreferences, paramArrayList, paramString2, paramAppInterface);
          a(paramBoolean1, paramShort, paramBoolean2, paramSharedPreferences, paramString2, paramAppInterface);
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageRecord paramMessageRecord)
  {
    if (paramDecodeProtoPkgContext.jdField_b_of_type_Int > 0) {
      paramMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(paramDecodeProtoPkgContext.jdField_b_of_type_Int));
    }
    int k = MessageProtoCodec.b(paramMsg);
    if (k > 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(k));
    }
    k = MessageProtoCodec.a(paramMsg);
    if (k >= 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(k));
    }
    k = MessageProtoCodec.c(paramMsg);
    if (k >= 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_face_id", String.valueOf(k));
    }
    k = ETDIYUtil.a(paramMsg);
    if (k > 0) {
      paramMessageRecord.saveExtInfoToExtStr("vip_diy_font_id", String.valueOf(k));
    }
  }
  
  private void a(msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, ArrayList<MessageRecord> paramArrayList)
  {
    if ((paramDecodeProtoPkgContext.jdField_c_of_type_Int == 1008) && (paramMsg.msg_body.has()))
    {
      paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
      if (paramMsg.rich_text.has())
      {
        paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
        if (paramMsg.elems.has())
        {
          paramMsg = paramMsg.elems.get().iterator();
          while (paramMsg.hasNext())
          {
            paramDecodeProtoPkgContext = (im_msg_body.Elem)paramMsg.next();
            if (paramDecodeProtoPkgContext.pub_acc_info.has())
            {
              int k = paramDecodeProtoPkgContext.pub_acc_info.uint32_is_inter_num.get();
              paramMsg = paramDecodeProtoPkgContext.pub_acc_info.string_msg_template_id.get();
              if (k != 0)
              {
                paramDecodeProtoPkgContext = paramArrayList.iterator();
                while (paramDecodeProtoPkgContext.hasNext()) {
                  ((MessageRecord)paramDecodeProtoPkgContext.next()).saveExtInfoToExtStr("inter_num", String.valueOf(k));
                }
              }
              paramDecodeProtoPkgContext = paramArrayList.iterator();
              while (paramDecodeProtoPkgContext.hasNext()) {
                ((MessageRecord)paramDecodeProtoPkgContext.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, ArrayList<MessageRecord> paramArrayList1, msg_comm.MsgHead paramMsgHead, int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, int paramInt4, int paramInt5, ArrayList<MessageRecord> paramArrayList2, long paramLong4, AppInterface paramAppInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("");
    int k;
    if (QFileAssistantUtils.a(((StringBuilder)localObject).toString())) {
      k = QFileAssistantUtils.a(paramMsg);
    } else {
      k = 0;
    }
    paramArrayList2 = paramArrayList2.iterator();
    while (paramArrayList2.hasNext())
    {
      localObject = (MessageRecord)paramArrayList2.next();
      if ((!a(paramDecodeProtoPkgContext, (MessageRecord)localObject, paramAppInterface)) && (!a(paramDecodeProtoPkgContext, paramInt1, paramLong1, paramLong2, paramInt2, paramAppInterface)))
      {
        ((MessageRecord)localObject).selfuin = String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long);
        ((MessageRecord)localObject).frienduin = String.valueOf(paramDecodeProtoPkgContext.g);
        ((MessageRecord)localObject).senderuin = String.valueOf(paramDecodeProtoPkgContext.jdField_b_of_type_Long);
        ((MessageRecord)localObject).time = paramDecodeProtoPkgContext.jdField_c_of_type_Long;
        ((MessageRecord)localObject).shmsgseq = paramInt1;
        ((MessageRecord)localObject).msgUid = paramLong2;
        ((MessageRecord)localObject).istroop = paramDecodeProtoPkgContext.jdField_c_of_type_Int;
        ((MessageRecord)localObject).longMsgId = paramInt3;
        ((MessageRecord)localObject).longMsgCount = paramInt4;
        ((MessageRecord)localObject).longMsgIndex = paramInt5;
        a(paramDecodeProtoPkgContext, (MessageRecord)localObject, paramAppInterface);
        if (((MessageRecord)localObject).msgtype == -2058) {
          EmojiStickerManager.a((MessageRecord)localObject, paramAppInterface);
        }
        if (QFileAssistantUtils.a(((MessageRecord)localObject).frienduin)) {
          QFileAssistantUtils.a((MessageRecord)localObject, k);
        }
        if (!a(paramDecodeProtoPkgContext, paramInt1, paramLong1, paramLong2, paramInt2, (MessageRecord)localObject, paramAppInterface)) {
          for (;;)
          {
            b(paramMsgHead, (MessageRecord)localObject);
            a(paramMsgHead, (MessageRecord)localObject);
            if ((paramDecodeProtoPkgContext.jdField_c_of_type_Int == 0) && ((localObject instanceof MessageForPic))) {
              ((MessageForPic)localObject).bEnableEnc = true;
            }
            if (!a(paramDecodeProtoPkgContext, paramMsgHead, paramLong1, (MessageRecord)localObject, paramAppInterface))
            {
              a(paramDecodeProtoPkgContext, (MessageRecord)localObject);
              a((MessageRecord)localObject);
              ((MessageRecord)localObject).vipBubbleID = paramDecodeProtoPkgContext.jdField_d_of_type_Long;
              ((MessageRecord)localObject).vipBubbleDiyTextId = paramDecodeProtoPkgContext.jdField_a_of_type_Int;
              ((MessageRecord)localObject).vipSubBubbleId = paramDecodeProtoPkgContext.jdField_b_of_type_Int;
              a(paramMsg, paramDecodeProtoPkgContext, (MessageRecord)localObject);
              a(paramMsgHead, paramLong4, (MessageRecord)localObject);
              a((MessageRecord)localObject, paramAppInterface);
              if (((MessageRecord)localObject).msgtype == -7005)
              {
                ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).handleLimitChatC2CConfirmMsg((MessageRecord)localObject, paramAppInterface);
              }
              else
              {
                paramArrayList1.add(localObject);
                if (paramDecodeProtoPkgContext.jdField_c_of_type_Int == 1036) {
                  MessageProtoCodec.a(paramLong3, paramInt1, paramLong2, paramInt2, paramAppInterface);
                }
                b((MessageRecord)localObject, paramAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(msg_comm.MsgHead paramMsgHead, long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1008)
    {
      try
      {
        if (paramMsgHead.public_account_group_send_flag.has()) {
          paramMessageRecord.saveExtInfoToExtStr("public_account_send_flag", String.valueOf(paramMsgHead.public_account_group_send_flag.get()));
        }
      }
      catch (Throwable paramMsgHead)
      {
        QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramMsgHead);
      }
      if (paramLong != -1L) {
        paramMessageRecord.saveExtInfoToExtStr("public_account_msg_id", String.valueOf(paramLong));
      }
    }
  }
  
  private void a(msg_comm.MsgHead paramMsgHead, MessageRecord paramMessageRecord)
  {
    paramMsgHead = (msg_comm.C2CTmpMsgHead)paramMsgHead.c2c_tmp_msg_head.get();
    if (paramMsgHead != null)
    {
      if (paramMsgHead.business_name.has()) {
        paramMessageRecord.saveExtInfoToExtStr("temp_conv_biz_name", paramMsgHead.business_name.get().toStringUtf8());
      }
      if (paramMsgHead.business_sub_content.has()) {
        paramMessageRecord.saveExtInfoToExtStr("temp_conv_biz_content", paramMsgHead.business_sub_content.get().toStringUtf8());
      }
    }
  }
  
  private void a(boolean paramBoolean1, short paramShort, boolean paramBoolean2, SharedPreferences paramSharedPreferences, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramShort == 0)
    {
      if (paramBoolean2) {
        paramShort = this.h;
      } else {
        paramShort = this.f;
      }
    }
    else if (paramBoolean2) {
      paramShort = this.i;
    } else {
      paramShort = this.g;
    }
    this.j = this.jdField_b_of_type_JavaUtilHashSet.size();
    if (this.j % paramShort == 0)
    {
      ((QQAppInterface)paramAppInterface).oneWayMessageNotifyVibert(paramMessageRecord, paramBoolean1);
      this.jdField_b_of_type_JavaUtilHashSet.clear();
      paramMessageRecord = paramSharedPreferences.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_OneWayMsgLBSFriendRecentUinList");
      paramMessageRecord.remove(localStringBuilder.toString());
      paramSharedPreferences.edit().commit();
      if (paramBoolean2) {
        ReportController.b(paramAppInterface, "CliOper", "", "", "0X8005296", "0X8005296", 0, 0, "", "", "", "");
      }
    }
  }
  
  private boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, MessageForStructing paramMessageForStructing, AppInterface paramAppInterface)
  {
    if ((paramMessageForStructing.structingMsg.mMsgServiceID == ((INearbyFlowerMessage)QRoute.api(INearbyFlowerMessage.class)).getFlowerServiceId()) && ((NearbyFlowerManager)paramAppInterface.getManager(QQManagerFactory.NEARBY_FLOWER_MANAGER) != null))
    {
      INearbyFlowerMessage localINearbyFlowerMessage = (INearbyFlowerMessage)QRoute.api(INearbyFlowerMessage.class);
      localINearbyFlowerMessage.init(paramAppInterface, paramMessageForStructing);
      if (paramAppInterface.getCurrentUin().equals(localINearbyFlowerMessage.getsUin())) {
        ReportController.b(paramAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
      } else if (paramAppInterface.getCurrentUin().equals(localINearbyFlowerMessage.getrUin())) {
        ReportController.b(paramAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
      }
      if ("4".equals(localINearbyFlowerMessage.getVersion()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
        }
        MessageProtoCodec.a(paramLong1, paramInt1, paramLong2, paramInt2, paramAppInterface);
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(C2CMessageProcessor.ProcessMsgPushPBSlaveMaster paramProcessMsgPushPBSlaveMaster, MessageRecord paramMessageRecord, boolean paramBoolean, MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      if (paramMessageForStructing.structingMsg.mMsgServiceID != 128) {
        return paramBoolean;
      }
      String str = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
      paramBoolean = false;
      try
      {
        k = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        k = 0;
      }
      int m;
      if ((k & 0x4) == 4) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        paramMessageForStructing.setExtraFlag(32768);
        paramMessageRecord.issend = 1;
        paramMessageForStructing.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(k & 0xFFFFFFFB));
        paramProcessMsgPushPBSlaveMaster.jdField_a_of_type_Boolean = true;
        paramProcessMsgPushPBSlaveMaster.jdField_a_of_type_JavaLangString = paramMessageForStructing.frienduin;
      }
      paramMessageForStructing.isCheckNeedShowInListTypeMsg = true;
      int k = a(paramProcessMsgPushPBSlaveMaster.jdField_a_of_type_MsfMsgcommMsg_comm$Msg);
      if (k == 1) {
        paramBoolean = true;
      }
      paramMessageForStructing.needNeedShowInList = paramBoolean;
      if (QLog.isColorLevel())
      {
        paramProcessMsgPushPBSlaveMaster = new StringBuilder();
        paramProcessMsgPushPBSlaveMaster.append("----------handleMsgPush_PB_SlaveMaster isCheckNeedShowInListTypeMsg:");
        paramProcessMsgPushPBSlaveMaster.append(paramMessageForStructing.isCheckNeedShowInListTypeMsg);
        paramProcessMsgPushPBSlaveMaster.append(" needNeedShowInList:");
        paramProcessMsgPushPBSlaveMaster.append(paramMessageForStructing.needNeedShowInList);
        paramProcessMsgPushPBSlaveMaster.append(" uint32ShowInMsgList:");
        paramProcessMsgPushPBSlaveMaster.append(k);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramProcessMsgPushPBSlaveMaster.toString());
      }
      return true;
    }
    return paramBoolean;
  }
  
  private boolean a(DecodeProtoPkgContext paramDecodeProtoPkgContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, AppInterface paramAppInterface)
  {
    if (UinTypeUtil.a(paramDecodeProtoPkgContext.jdField_c_of_type_Int) == 1032)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramAppInterface != null)
      {
        MessageCache localMessageCache = (MessageCache)paramAppInterface.getMsgCache();
        localObject1 = localObject2;
        if (localMessageCache != null) {
          localObject1 = localMessageCache.a(String.valueOf(paramDecodeProtoPkgContext.g), String.valueOf(paramDecodeProtoPkgContext.jdField_a_of_type_Long));
        }
      }
      MessageProtoCodec.a(paramAppInterface, paramLong1, paramInt1, paramLong2, paramInt2, (byte[])localObject1);
      if (paramDecodeProtoPkgContext.jdField_c_of_type_Int == 1032)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", new Object[] { Long.toString(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean a(DecodeProtoPkgContext paramDecodeProtoPkgContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if ((UinTypeUtil.h(paramDecodeProtoPkgContext.jdField_c_of_type_Int)) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      int k = GiftMessageUtils.a(paramMessageRecord, 1);
      if (k > 0)
      {
        paramDecodeProtoPkgContext = new StringBuilder();
        paramDecodeProtoPkgContext.append("1|");
        paramDecodeProtoPkgContext.append(k);
        paramMessageRecord.saveExtInfoToExtStr("nearby_gift_msg", paramDecodeProtoPkgContext.toString());
      }
      if (a(paramInt1, paramLong1, paramLong2, paramInt2, (MessageForStructing)paramMessageRecord, paramAppInterface)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramMessageRecord == null) {
      return true;
    }
    if ((paramDecodeProtoPkgContext.jdField_b_of_type_Long == 3338705755L) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isDeleteOldKandian(paramAppInterface))) {
      return true;
    }
    if ((paramDecodeProtoPkgContext.jdField_b_of_type_Long == 2171946401L) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isDeleteNewKandian())) {
      return true;
    }
    if (paramDecodeProtoPkgContext.jdField_b_of_type_Long == 2171946401L) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).updateDeleteOldKandian(paramAppInterface, true);
    }
    return ((paramDecodeProtoPkgContext.jdField_c_of_type_Int == 1025) || (paramDecodeProtoPkgContext.jdField_c_of_type_Int == 1024)) && (paramMessageRecord.msgtype == -1000) && (paramMessageRecord.msg.startsWith("default:SigT="));
  }
  
  private boolean a(DecodeProtoPkgContext paramDecodeProtoPkgContext, msg_comm.MsgHead paramMsgHead, long paramLong, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramDecodeProtoPkgContext.jdField_c_of_type_Int == 1006)
    {
      if (paramMsgHead.from_nick.has()) {
        ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(paramDecodeProtoPkgContext.g), paramMsgHead.from_nick.get());
      }
      paramMessageRecord.frienduin = ContactUtils.c(paramAppInterface, String.valueOf(paramDecodeProtoPkgContext.g));
      paramMessageRecord.senderuin = ContactUtils.c(paramAppInterface, String.valueOf(paramLong));
      if ((TextUtils.isEmpty(paramMessageRecord.frienduin)) && (paramDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
        paramMessageRecord.frienduin = String.valueOf(paramDecodeProtoPkgContext.g);
      }
      if (paramMessageRecord.frienduin == null)
      {
        QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(paramDecodeProtoPkgContext.g), Long.valueOf(paramLong), Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.msgtype) }));
        return true;
      }
    }
    return false;
  }
  
  private String b(SharedPreferences paramSharedPreferences, String paramString, AppInterface paramAppInterface)
  {
    if (this.jdField_b_of_type_JavaUtilHashSet == null) {}
    label130:
    label139:
    for (;;)
    {
      int k;
      try
      {
        if (this.jdField_b_of_type_JavaUtilHashSet == null)
        {
          this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
          paramString = new StringBuilder();
          paramString.append(paramAppInterface.getCurrentAccountUin());
          paramString.append("_OneWayMsgLBSFriendRecentUinList");
          paramString = paramSharedPreferences.getString(paramString.toString(), "");
          paramSharedPreferences = paramString.split("\\|");
          int m = paramSharedPreferences.length;
          k = 0;
          if (k >= m) {
            break label139;
          }
          paramAppInterface = paramSharedPreferences[k];
          if ((paramAppInterface.length() <= 0) || (Long.parseLong(paramAppInterface) <= 0L)) {
            break label130;
          }
          this.jdField_b_of_type_JavaUtilHashSet.add(paramAppInterface);
          break label130;
        }
        return paramString;
      }
      finally {}
      return paramString;
      k += 1;
    }
  }
  
  private String b(SharedPreferences paramSharedPreferences, String paramString, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    Object localObject = paramString;
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramMessageRecord.frienduin))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramMessageRecord.frienduin);
      if (paramString.length() == 0)
      {
        paramString = paramMessageRecord.frienduin;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
        paramString = ((StringBuilder)localObject).toString();
      }
      paramMessageRecord = paramSharedPreferences.edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_OneWayMsgDateRecentUinList");
      paramMessageRecord.putString(((StringBuilder)localObject).toString(), paramString);
      paramSharedPreferences.edit().commit();
      localObject = paramString;
    }
    return localObject;
  }
  
  private void b(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramMessageRecord.msgtype == -2039) {
      ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).decodeC2CApolloMsg(paramAppInterface, paramMessageRecord);
    }
  }
  
  private void b(String paramString, int paramInt, long paramLong, C2CMessageProcessor paramC2CMessageProcessor)
  {
    AppInterface localAppInterface = paramC2CMessageProcessor.a;
    long l = a(paramString, paramInt, localAppInterface);
    if (l != -1L) {
      paramC2CMessageProcessor.a(a(paramString, paramInt, paramLong, l, localAppInterface));
    }
  }
  
  private void b(msg_comm.MsgHead paramMsgHead, MessageRecord paramMessageRecord)
  {
    paramMsgHead = (msg_comm.C2CTmpMsgHead)paramMsgHead.c2c_tmp_msg_head.get();
    if ((paramMsgHead != null) && (paramMsgHead.lock_display.has()) && (paramMsgHead.lock_display.get() == 1))
    {
      paramMessageRecord.extLong |= 0x1;
      paramMessageRecord.saveExtInfoToExtStr("lockDisplay", "true");
    }
  }
  
  private void b(boolean paramBoolean1, short paramShort, boolean paramBoolean2, SharedPreferences paramSharedPreferences, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramShort == 0)
    {
      if (paramBoolean2) {
        paramShort = this.jdField_c_of_type_Int;
      } else {
        paramShort = this.jdField_a_of_type_Int;
      }
    }
    else if (paramBoolean2) {
      paramShort = this.jdField_d_of_type_Int;
    } else {
      paramShort = this.jdField_b_of_type_Int;
    }
    this.e = this.jdField_a_of_type_JavaUtilHashSet.size();
    if (this.e % paramShort == 0)
    {
      ((QQAppInterface)paramAppInterface).oneWayMessageNotifyVibert(paramMessageRecord, paramBoolean1);
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      paramMessageRecord = paramSharedPreferences.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_OneWayMsgDateRecentUinList");
      paramMessageRecord.remove(localStringBuilder.toString());
      paramSharedPreferences.edit().commit();
      if (paramBoolean2) {
        ReportController.b(paramAppInterface, "CliOper", "", "", "0X8005296", "0X8005296", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = XMLMessageUtils.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          ReportController.b(paramC2CMessageProcessor.a, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new C2CMessageProcessorCallback.1(this, paramC2CMessageProcessor, localMessageRecord));
      }
    }
    a(paramArrayList, paramC2CMessageProcessor);
  }
  
  public int a(C2CMessageProcessor paramC2CMessageProcessor)
  {
    return ((MessageRoamManager)paramC2CMessageProcessor.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).b();
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    return SVIPHandlerConstants.a(paramInt1, paramInt2);
  }
  
  public long a(AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    return MessageHandlerUtils.a(paramAppInterface, paramLong1, paramLong2, paramLong3);
  }
  
  public long a(AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, msg_comm.UinPairMsg paramUinPairMsg)
  {
    return MessageHandlerUtils.a(paramAppInterface, paramLong1, paramLong2, paramUinPairMsg.peer_uin.get(), paramUinPairMsg);
  }
  
  public String a(String paramString, C2CMessageProcessor paramC2CMessageProcessor)
  {
    return ((IPhoneContactService)paramC2CMessageProcessor.a.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(paramString);
  }
  
  public String a(msg_comm.UinPairMsg paramUinPairMsg, AppInterface paramAppInterface, int paramInt)
  {
    return TinyMsgCodec.a(paramUinPairMsg, paramAppInterface, paramInt);
  }
  
  public List<MessageRecord> a(String paramString, long paramLong1, long paramLong2, C2CMessageProcessor paramC2CMessageProcessor)
  {
    return ((MessageRoamManager)paramC2CMessageProcessor.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(String.valueOf(paramString), paramLong1 - 30L, paramLong2 + 30L);
  }
  
  public List<MessageRecord> a(String paramString, List<msg_comm.Msg> paramList, C2CMessageProcessor paramC2CMessageProcessor)
  {
    return ((QQAppInterface)paramC2CMessageProcessor.a()).getFileTransferHandler().a(paramList, Long.valueOf(paramString).longValue(), true);
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt, long paramLong1, long paramLong2, AppInterface paramAppInterface)
  {
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    if (paramInt == 10007)
    {
      TinyMsgCodec.a(paramAppInterface, localPbMsgReadedReportReq, paramString, paramLong1);
      return localPbMsgReadedReportReq;
    }
    msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    localUinPairReadInfo.peer_uin.set(paramLong2);
    localUinPairReadInfo.last_read_time.set((int)paramLong1);
    a(paramString, paramInt, localUinPairReadInfo, paramAppInterface);
    paramString = new msg_svc.PbC2CReadedReportReq();
    paramString.pair_info.add(localUinPairReadInfo);
    paramAppInterface = ((MessageCache)paramAppInterface.getMsgCache()).a();
    if (paramAppInterface != null) {
      paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramAppInterface));
    }
    localPbMsgReadedReportReq.c2c_read_report.set(paramString);
    return localPbMsgReadedReportReq;
  }
  
  public void a(int paramInt, C2CMessageProcessor paramC2CMessageProcessor)
  {
    ((QQAppInterface)paramC2CMessageProcessor.a()).userActiveStatus = paramInt;
  }
  
  public void a(long paramLong)
  {
    MessageStatisticHelper.a("actC2cDecodeCost", paramLong);
  }
  
  public void a(long paramLong, C2CMessageProcessor paramC2CMessageProcessor)
  {
    ((FriendsManager)paramC2CMessageProcessor.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramLong);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    FriendShieldUtils.a(paramAppInterface, paramString);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    TinyMsgCodec.a(paramAppInterface, paramString, paramC2CMsgReadedNotify);
  }
  
  public void a(C2CMessageProcessor paramC2CMessageProcessor, ArrayList<MessageRecord> paramArrayList, long paramLong1, long paramLong2, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    new AfterDecodeMsg(paramC2CMessageProcessor, paramArrayList, paramLong1, paramLong2, paramList, paramDecodeProtoPkgContext).a();
  }
  
  public void a(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, ArrayList<MessageRecord> paramArrayList, ArrayList<msg_comm.Msg> paramArrayList1, StringBuilder paramStringBuilder, DecodeProtoPkgContext paramDecodeProtoPkgContext, int paramInt)
  {
    new DecodeMsg(paramC2CMessageProcessor, paramUinPairMsg, paramLong, paramArrayList, paramArrayList1, paramStringBuilder, paramDecodeProtoPkgContext, paramInt).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get Error pkgUinType: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", uin: ");
    localStringBuilder.append(paramString);
    ConversationInfoErrorReporter.reportTypeError(paramInt, localStringBuilder.toString());
  }
  
  public void a(String paramString, int paramInt, long paramLong, C2CMessageProcessor paramC2CMessageProcessor)
  {
    if (AppConstants.SYSTEM_MSG_UIN.equals(paramString))
    {
      a(paramC2CMessageProcessor.a);
      return;
    }
    if ((paramInt == 1001) && ((UinTypeUtil.d(paramString)) || (UinTypeUtil.e(paramString))))
    {
      a(paramString, paramC2CMessageProcessor.a);
      return;
    }
    b(paramString, paramInt, paramLong, paramC2CMessageProcessor);
  }
  
  public void a(String paramString, long paramLong, int paramInt, C2CMessageProcessor paramC2CMessageProcessor)
  {
    ((MessageRoamManager)paramC2CMessageProcessor.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a().b(paramString, paramLong, 3);
  }
  
  public void a(String paramString, List<msg_comm.Msg> paramList, boolean paramBoolean, int paramInt, C2CMessageProcessor paramC2CMessageProcessor)
  {
    a(paramString, paramList, paramBoolean, paramInt);
  }
  
  public void a(String paramString1, boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, String paramString2, int paramInt, C2CMessageProcessor paramC2CMessageProcessor)
  {
    a(paramArrayList, paramBoolean, paramC2CMessageProcessor);
    MessageStatisticHelper.a((MessageRecord)paramArrayList.get(0), paramC2CMessageProcessor.a);
    a(paramArrayList, paramInt, paramC2CMessageProcessor.a);
    a(paramString1, paramArrayList, paramInt, paramC2CMessageProcessor.a);
    a(paramString2, paramInt, paramC2CMessageProcessor.a);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor)
  {
    ConfessMsgUtil.a(paramC2CMessageProcessor.a, paramArrayList);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean, C2CMessageProcessor paramC2CMessageProcessor)
  {
    try
    {
      paramC2CMessageProcessor = (MessageRoamManager)paramC2CMessageProcessor.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if (paramC2CMessageProcessor != null)
      {
        paramC2CMessageProcessor.a(paramArrayList, paramString, paramBoolean);
        return;
      }
    }
    catch (OutOfMemoryError paramArrayList)
    {
      paramArrayList.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramArrayList);
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramArrayList);
      }
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, C2CMessageProcessor paramC2CMessageProcessor)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramC2CMessageProcessor = paramC2CMessageProcessor.a();
      if (UserguideActivity.a(BaseApplicationImpl.getApplication(), paramC2CMessageProcessor.getCurrentAccountUin())) {
        return;
      }
      if (!NoDisturbUtil.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramC2CMessageProcessor)) {
        return;
      }
      Object localObject1 = paramArrayList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((UinTypeUtil.h(((MessageRecord)localObject2).istroop)) && (UinTypeUtil.a((MessageRecord)localObject2)) && (!MsgProxyUtils.a(paramC2CMessageProcessor, (MessageRecord)localObject2)) && (!((MessageRecord)localObject2).isSend()) && (!((MessageRecord)localObject2).isread))
        {
          k = 1;
          break label126;
        }
      }
      int k = 0;
      label126:
      if (k != 0)
      {
        localObject2 = ((FriendsManager)paramC2CMessageProcessor.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramC2CMessageProcessor.getCurrentAccountUin());
        localObject1 = (IMessageFacade)paramC2CMessageProcessor.getRuntimeService(IMessageFacade.class, "");
        short s;
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "findFriendCardByUin card is null");
          }
          s = 1;
        }
        else
        {
          s = ((Card)localObject2).shGender;
        }
        boolean bool = ((INearbyCardManager)paramC2CMessageProcessor.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("DealOneWayMessageNotify,gender:");
          ((StringBuilder)localObject2).append(s);
          ((StringBuilder)localObject2).append(",isGod:");
          ((StringBuilder)localObject2).append(bool);
          QLog.d("Q.msg_box", 2, ((StringBuilder)localObject2).toString());
        }
        a();
        localObject2 = BaseApplicationImpl.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramC2CMessageProcessor.getCurrentAccountUin());
        localStringBuilder.append("OneWayMsgRecentUinList");
        localObject2 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
        a(paramArrayList, paramBoolean, (IMessageFacade)localObject1, s, bool, (SharedPreferences)localObject2, a((SharedPreferences)localObject2, "", paramC2CMessageProcessor), b((SharedPreferences)localObject2, "", paramC2CMessageProcessor), paramC2CMessageProcessor);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    BaseMessageHandlerUtils.a(paramList);
  }
  
  public void a(List<MessageRecord> paramList, C2CMessageProcessor paramC2CMessageProcessor)
  {
    paramC2CMessageProcessor = paramC2CMessageProcessor.a();
    PreDownloadMsg.a((ArrayList)paramList, true, paramC2CMessageProcessor);
  }
  
  public void a(msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, long paramLong1, ArrayList<MessageRecord> paramArrayList1, msg_comm.MsgHead paramMsgHead, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3, int paramInt4, int paramInt5, ArrayList<MessageRecord> paramArrayList2, C2CMessageProcessor paramC2CMessageProcessor)
  {
    paramC2CMessageProcessor = paramC2CMessageProcessor.a();
    a(paramInt4, paramArrayList2);
    a(paramMsg, paramDecodeProtoPkgContext, paramArrayList1, paramMsgHead, paramInt1, paramLong2, paramLong3, paramInt2, paramLong4, paramInt3, paramInt4, paramInt5, paramArrayList2, a(paramMsg, -1L), paramC2CMessageProcessor);
    a(paramMsg, paramDecodeProtoPkgContext, paramArrayList1);
    MsgAutoMonitorUtil.getInstance().addDecodeC2CMsgTime(System.currentTimeMillis() - paramLong1);
    paramMsg = paramArrayList1.iterator();
    paramInt3 = 0;
    for (paramInt1 = 0; paramMsg.hasNext(); paramInt1 = paramInt2)
    {
      paramDecodeProtoPkgContext = (MessageRecord)paramMsg.next();
      paramInt3 = paramDecodeProtoPkgContext.istroop;
      paramInt2 = paramInt1;
      if (!paramDecodeProtoPkgContext.isread) {
        paramInt2 = paramInt1 + 1;
      }
    }
    FightMsgReporter.a(0, 1, paramInt3, paramInt1);
  }
  
  public boolean a(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    int k = paramMessageRecord.istroop;
    boolean bool2 = false;
    if ((k != 1010) && (paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) {
      return false;
    }
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(paramAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    if (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && (paramMessageRecord.msgtype == -3001)) {
      return false;
    }
    boolean bool1 = bool2;
    if (UinTypeUtil.a(paramMessageRecord))
    {
      bool1 = bool2;
      if (!MsgProxyUtils.a(paramAppInterface, paramMessageRecord)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(MessageRecord paramMessageRecord, C2CMessageProcessor.ProcessMsgPushPBSlaveMaster paramProcessMsgPushPBSlaveMaster, C2CMessageProcessor paramC2CMessageProcessor)
  {
    boolean bool2 = paramMessageRecord instanceof MessageForStructing;
    boolean bool1 = false;
    if (bool2) {
      return a(paramProcessMsgPushPBSlaveMaster, paramMessageRecord, false, (MessageForStructing)paramMessageRecord);
    }
    if (paramMessageRecord.msgtype == -10000) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(MessageRecord paramMessageRecord, C2CMessageProcessor paramC2CMessageProcessor)
  {
    return (!paramMessageRecord.isSend()) && (!paramMessageRecord.isread) && ((!UinTypeUtil.a(paramMessageRecord)) || (MsgProxyUtils.a(paramC2CMessageProcessor.a, paramMessageRecord))) && (!FriendsStatusUtil.a(paramMessageRecord.frienduin, paramC2CMessageProcessor.a)) && (AppletsFolderManager.a(paramMessageRecord.frienduin)) && (TinyMsgCodec.a(paramMessageRecord));
  }
  
  public byte[] a(C2CMessageProcessor paramC2CMessageProcessor)
  {
    return ((MessageRoamManager)paramC2CMessageProcessor.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a();
  }
  
  public void b(ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor)
  {
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPubAccMsg(paramArrayList);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    OfficialAccountReporter.a.a(paramArrayList);
    c(paramArrayList, paramC2CMessageProcessor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */
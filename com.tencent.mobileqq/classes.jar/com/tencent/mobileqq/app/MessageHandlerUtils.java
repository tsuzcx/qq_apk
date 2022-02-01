package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.core.codec.CreatePbSendReqFromMessageCallback;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider;
import com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.MultiMsgAssist;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class MessageHandlerUtils
  extends BaseMessageHandlerUtils
{
  private static MessageHandlerUtils.Callback jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback;
  private static ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(24), Integer.valueOf(14), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(23), Integer.valueOf(25), Integer.valueOf(26), Integer.valueOf(8), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(15), Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(22), Integer.valueOf(28), Integer.valueOf(27), Integer.valueOf(29), Integer.valueOf(31), Integer.valueOf(30), Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34) }));
  
  static {}
  
  public static long a(AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramAppInterface.getLongAccountUin();
    if (paramLong1 == l) {
      return paramLong2;
    }
    if (paramLong2 == l) {
      return paramLong1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandlerUtils", 2, "<---decodeC2CMessagePackage: neither fromUin nor toUin is selfUin.use peerUin instead.");
    }
    return paramLong3;
  }
  
  public static long a(AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, msg_comm.UinPairMsg paramUinPairMsg)
  {
    paramLong1 = a(paramAppInterface, paramLong1, paramLong2, paramLong3);
    return jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.a(paramLong1, paramUinPairMsg, paramAppInterface);
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 4) {
      return 0L;
    }
    return ((paramArrayOfByte[0] & 0xFF) << 24) + ((paramArrayOfByte[1] & 0xFF) << 16) + ((paramArrayOfByte[2] & 0xFF) << 8) + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.a(paramAppInterface, paramString1, paramString2);
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject = new MessageHandlerUtils.GetRichTextAndMsgVia(paramAppInterface, paramMessageRecord, null, 0).a();
    im_msg_body.RichText localRichText = ((MessageHandlerUtils.GetRichTextAndMsgVia)localObject).a();
    int i = ((MessageHandlerUtils.GetRichTextAndMsgVia)localObject).a();
    if (localRichText == null) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send message, entrance: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("MsgVia", 2, ((StringBuilder)localObject).toString());
    }
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().l().iterator();
    for (localObject = null; localIterator.hasNext(); localObject = ((IPbSendReqHandler)localIterator.next()).a(paramAppInterface, paramMessageRecord, localRichText, i, (msg_svc.PbSendMsgReq)localObject)) {}
    a(paramMessageRecord, (msg_svc.PbSendMsgReq)localObject, paramAppInterface);
    return localObject;
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, Object paramObject)
  {
    Object localObject1 = jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback;
    boolean bool5 = false;
    Object localObject2 = ((MessageHandlerUtils.Callback)localObject1).a(paramMessageRecord, null, 0);
    localObject1 = (im_msg_body.RichText)localObject2[0];
    int i = ((Integer)localObject2[1]).intValue();
    if ((paramMessageRecord.msgtype != -1000) && (paramMessageRecord.msgtype != -2022) && (paramMessageRecord.msgtype != -2000))
    {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getPbSendReqFromBlessMsg, error msgtype, ");
        paramAppInterface.append(paramMessageRecord.msgtype);
        QLog.d("Q.msg.MessageHandlerUtils", 2, paramAppInterface.toString());
      }
      return null;
    }
    if ((localObject1 != null) && (((im_msg_body.RichText)localObject1).elems != null) && (paramArrayList != null) && (paramArrayList.size() != 0))
    {
      localObject2 = new im_msg_body.Elem();
      im_msg_body.BlessingMessage localBlessingMessage = new im_msg_body.BlessingMessage();
      localBlessingMessage.uint32_msg_type.set(1);
      if (paramMessageRecord.needUpdateMsgTag) {
        localBlessingMessage.uint32_ex_flag.set(1);
      } else {
        localBlessingMessage.uint32_ex_flag.set(0);
      }
      ((im_msg_body.Elem)localObject2).bless_msg.set(localBlessingMessage);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      localObject2 = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject2).rich_text.set((MessageMicro)localObject1);
      localObject1 = new msg_svc.MultiMsgAssist();
      ((msg_svc.MultiMsgAssist)localObject1).msg_use.set(1);
      a(paramArrayList, (msg_svc.MultiMsgAssist)localObject1);
      jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.a(paramObject, (msg_svc.MultiMsgAssist)localObject1);
      int j = MessageUtils.a(paramMessageRecord.msgUid);
      int k = (short)(int)paramMessageRecord.msgseq;
      paramArrayList = ((MessageCache)paramAppInterface.getMsgCache()).a();
      paramObject = new msg_svc.PbSendMsgReq();
      paramObject.msg_body.set((MessageMicro)localObject2);
      paramObject.msg_seq.set(0xFFFF & k);
      paramObject.msg_rand.set(j);
      paramObject.msg_via.set(i);
      paramObject.multi_msg_assist.set((MessageMicro)localObject1);
      if (paramArrayList != null) {
        paramObject.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
      }
      jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.a(paramAppInterface, paramMessageRecord, paramObject);
      return paramObject;
    }
    if (QLog.isColorLevel())
    {
      boolean bool1;
      if (localObject1 == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((localObject1 != null) && (((im_msg_body.RichText)localObject1).elems == null)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3;
      if (paramArrayList == null) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      boolean bool4 = bool5;
      if (paramArrayList != null)
      {
        bool4 = bool5;
        if (paramArrayList.size() == 0) {
          bool4 = true;
        }
      }
      QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, error: %s, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
    }
    return null;
  }
  
  public static im_msg_body.GeneralFlags a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
    boolean bool2 = a(false, localResvAttr, paramMessageRecord.getExtInfoFromExtStr(MessageConstants.c));
    if (paramMessageRecord.msgtype == -1052)
    {
      if (paramMessageRecord.msg != null)
      {
        if (jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.a(paramMessageRecord, localGeneralFlags)) {
          return null;
        }
        return localGeneralFlags;
      }
      return null;
    }
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().k().iterator();
    boolean bool1 = false;
    int k;
    int i;
    int j;
    for (;;)
    {
      boolean bool3 = localIterator.hasNext();
      k = 1;
      if (!bool3) {
        break;
      }
      boolean[] arrayOfBoolean = ((IGeneralFlagProvider)localIterator.next()).a(paramAppInterface, bool1, bool2, paramMessageRecord, localResvAttr, paramPbSendMsgReq, localGeneralFlags);
      i = arrayOfBoolean[0];
      j = arrayOfBoolean[1];
    }
    if (j != 0)
    {
      localGeneralFlags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
      i = k;
    }
    if (i != 0) {
      return localGeneralFlags;
    }
    return null;
  }
  
  public static void a(MessageHandlerUtils.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback = paramCallback;
  }
  
  private static void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, AppInterface paramAppInterface)
  {
    Iterator localIterator = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().c().iterator();
    while (localIterator.hasNext()) {
      ((CreatePbSendReqFromMessageCallback)localIterator.next()).a(paramMessageRecord, paramPbSendMsgReq, paramAppInterface);
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramLong);
      QLog.d(paramString1, 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString4);
      paramString3 = localStringBuilder.toString();
      if (paramString2 != null)
      {
        paramString4 = new StringBuilder();
        paramString4.append(paramString2);
        paramString4.append(paramString3);
        QLog.d(paramString1, 2, paramString4.toString());
      }
    }
  }
  
  private static void a(ArrayList<String> paramArrayList, msg_svc.MultiMsgAssist paramMultiMsgAssist)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      msg_svc.C2C localC2C = new msg_svc.C2C();
      localC2C.to_uin.set(Long.valueOf(str).longValue());
      localRoutingHead.c2c.set(localC2C);
      paramMultiMsgAssist.repeated_routing.add(localRoutingHead);
    }
  }
  
  public static boolean a(int paramInt, AppInterface paramAppInterface)
  {
    paramAppInterface = (RoutingType)((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().a().a(Integer.valueOf(paramInt));
    if ((paramAppInterface != null) && (paramAppInterface.a())) {
      return true;
    }
    return jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("------->msgFilter :msgIsTroop:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",peerUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",list size:");
      if (paramAppInterface == null) {
        paramInt = 0;
      } else {
        paramInt = paramAppInterface.size();
      }
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
    }
    if ((paramAppInterface != null) && (paramAppInterface.size() > 0))
    {
      paramAppInterface = paramAppInterface.iterator();
      while (paramAppInterface.hasNext())
      {
        paramString1 = (MessageRecord)paramAppInterface.next();
        if ((Math.abs(paramString1.time - paramLong1) < 30L) && (paramString1.shmsgseq == paramLong2) && (paramString1.senderuin.equals(paramString2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "------->msgFilter-duplicated msg.");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = null;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ");
      localStringBuilder.append(paramMessageRecord.istroop);
      localStringBuilder.append(" shmsgseq: ");
      localStringBuilder.append(paramMessageRecord.shmsgseq);
      localStringBuilder.append(" friendUin: ");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append(" senderUin: ");
      localStringBuilder.append(paramMessageRecord.senderuin);
      localStringBuilder.append(" msgType: ");
      localStringBuilder.append(paramMessageRecord.msgtype);
      localStringBuilder.append(" time:");
      localStringBuilder.append(paramMessageRecord.time);
      localStringBuilder.append(" msgContent: ");
      localStringBuilder.append(paramMessageRecord.getLogColorContent());
    }
    paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    int j;
    if (paramAppInterface == null) {
      j = 0;
    } else {
      j = paramAppInterface.size();
    }
    int i;
    if (j > 15) {
      i = j - 15;
    } else {
      i = 0;
    }
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramAppInterface.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == paramMessageRecord.msgtype) && (Utils.a(localMessageRecord.msg, paramMessageRecord.msg)))
      {
        if ((QLog.isColorLevel()) && (localStringBuilder != null))
        {
          localStringBuilder.append(" filterType: other");
          QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
        }
        MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
        return true;
      }
      i += 1;
    }
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
    }
    MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord.msg != null) || (paramMessageRecord.msgData != null)))
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("---------------msgFilter istroop: ");
        localStringBuilder.append(paramMessageRecord.istroop);
        localStringBuilder.append(" uid: ");
        localStringBuilder.append(paramMessageRecord.msgUid);
        localStringBuilder.append(" shmsgseq: ");
        localStringBuilder.append(paramMessageRecord.shmsgseq);
        localStringBuilder.append(" friendUin: ");
        localStringBuilder.append(paramMessageRecord.frienduin);
        localStringBuilder.append(" senderUin: ");
        localStringBuilder.append(paramMessageRecord.senderuin);
        localStringBuilder.append(" msgType: ");
        localStringBuilder.append(paramMessageRecord.msgtype);
        localStringBuilder.append(" time:");
        localStringBuilder.append(paramMessageRecord.time);
        localStringBuilder.append(" msgContent: ");
        localStringBuilder.append(paramMessageRecord.getLogColorContent());
        localStringBuilder.append(" isNormalMsg: ");
        localStringBuilder.append(paramBoolean);
      }
      if (a(paramAppInterface, paramMessageRecord, paramBoolean, l, localStringBuilder)) {
        return true;
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
    }
    return true;
  }
  
  private static boolean a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong, StringBuilder paramStringBuilder)
  {
    List localList = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026) && (paramMessageRecord.istroop != 3000))
    {
      if (UinTypeUtil.b(paramMessageRecord.istroop))
      {
        if (a(paramAppInterface, paramMessageRecord, paramBoolean, paramLong, paramStringBuilder, localList)) {
          return true;
        }
      }
      else if (paramMessageRecord.istroop == 7220)
      {
        if (b(paramMessageRecord, paramLong, paramStringBuilder, localList)) {
          return true;
        }
      }
      else if (a(paramMessageRecord, paramLong, paramStringBuilder, localList)) {
        return true;
      }
    }
    else if (b(paramAppInterface, paramMessageRecord, paramBoolean, paramLong, paramStringBuilder, localList)) {
      return true;
    }
    return false;
  }
  
  private static boolean a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (MsgProxyUtils.a((MessageRecord)paramList.next(), paramMessageRecord, paramBoolean))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append(" filterType: ");
            paramAppInterface.append(paramMessageRecord.istroop);
            paramStringBuilder.append(paramAppInterface.toString());
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return ((MessageCache)paramAppInterface.getMsgCache()).d(paramMessageRecord);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.b(paramMessageRecord);
  }
  
  public static boolean a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool = paramBoolean2;
    if (paramBoolean1) {
      if (paramInt3 > 0)
      {
        bool = paramBoolean2;
        if (paramInt1 + paramInt2 < paramInt3)
        {
          bool = paramBoolean2;
          if (paramInt3 <= 0) {}
        }
      }
      else
      {
        bool = paramBoolean2;
        if (paramMessageRecord.vipBubbleDiyTextId > 0)
        {
          paramBoolean1 = true;
          paramGeneralFlags.uint32_bubble_diy_text_id.set(paramMessageRecord.vipBubbleDiyTextId);
          bool = paramBoolean1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "add BubbleDiyTextId!");
            bool = paramBoolean1;
          }
        }
      }
    }
    return bool;
  }
  
  private static boolean a(MessageRecord paramMessageRecord, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord.time == paramMessageRecord.time) && (localMessageRecord.msg.equals(paramMessageRecord.msg)))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(boolean paramBoolean, generalflags.ResvAttr paramResvAttr, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.parseInt(paramString);
      paramResvAttr.uint32_holiday_flag.set(i);
      return true;
    }
    catch (Exception paramResvAttr)
    {
      label22:
      break label22;
    }
    if (QLog.isColorLevel())
    {
      paramResvAttr = new StringBuilder();
      paramResvAttr.append("getGeneralFlagElem, holiday_activie_flag.error: ");
      paramResvAttr.append(paramString);
      QLog.i("Q.msg.MessageHandlerUtils", 2, paramResvAttr.toString());
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  private static boolean b(AppInterface paramAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (MsgProxyUtils.a((MessageRecord)paramList.next(), paramMessageRecord, false, paramBoolean))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append(" filterType: troop msg isNormalMsg=");
            paramAppInterface.append(paramBoolean);
            paramStringBuilder.append(paramAppInterface.toString());
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return ((MessageCache)paramAppInterface.getMsgCache()).d(paramMessageRecord);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
      return a(paramMessageRecord);
    }
    return (a(paramMessageRecord)) && (paramMessageRecord.extraflag == 0);
  }
  
  private static boolean b(MessageRecord paramMessageRecord, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (MsgProxyUtils.a((MessageRecord)paramList.next(), paramMessageRecord, true))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(ArrayList<MessageRecord> paramArrayList)
  {
    boolean bool2 = false;
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      bool1 = bool2;
      if (localMessageRecord.msgtype != -2006) {
        return bool1;
      }
      if (!jdField_a_of_type_ComTencentMobileqqAppMessageHandlerUtils$Callback.a(localMessageRecord)) {
        return false;
      }
    }
    boolean bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandlerUtils
 * JD-Core Version:    0.7.0.1
 */
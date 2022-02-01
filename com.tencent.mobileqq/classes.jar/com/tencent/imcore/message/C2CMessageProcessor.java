package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGenerator;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.oidb.searcher.oidb_c2c_searcher.RspBody;

public class C2CMessageProcessor
  extends BaseMessageProcessor
{
  public static C2CMessageProcessor.Callback a;
  public Comparator a;
  private Set<String> a;
  private Set<String> b = new HashSet();
  
  static {}
  
  public C2CMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    super(paramAppInterface, paramBaseMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new C2CMessageProcessor.1(this);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  private int a()
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(this);
  }
  
  private int a(byte paramByte, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    IMessageFacade localIMessageFacade = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
    if ((paramUinPairMsg.c2c_type.has()) && (paramUinPairMsg.service_type.has()))
    {
      int i = paramUinPairMsg.c2c_type.get();
      int j = paramUinPairMsg.service_type.get();
      if (QLog.isColorLevel())
      {
        paramUinPairMsg = new StringBuilder();
        paramUinPairMsg.append("<---decodeC2CMessagePackage : peerUin:");
        paramUinPairMsg.append(paramString);
        paramUinPairMsg.append("c2cType:");
        paramUinPairMsg.append(i);
        paramUinPairMsg.append(" serviceType:");
        paramUinPairMsg.append(j);
        paramUinPairMsg.append(" channelType:");
        paramUinPairMsg.append(paramByte);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramUinPairMsg.toString());
      }
      if ((i == 1) && (j == 130)) {
        return 1006;
      }
      if ((i == 1) && (j == 164)) {
        return 10007;
      }
      if ((i == 2) && (j == 0)) {
        return 1000;
      }
      if ((i == 2) && (j == 1)) {
        return 1004;
      }
      if ((i == 1) && (j == 133)) {
        return 1023;
      }
      if ((i == 1) && (j == 134)) {
        return 1022;
      }
      if ((i == 1) && (j == 167)) {
        return 10010;
      }
      return localIMessageFacade.getLastMessage(paramString, paramInt).istroop;
    }
    return localIMessageFacade.getLastMessage(paramString, paramInt).istroop;
  }
  
  private int a(msg_svc.PbGetMsgResp paramPbGetMsgResp, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (paramPbGetMsgResp.pubaccount_cookie.has()) {
      arrayOfByte = paramPbGetMsgResp.pubaccount_cookie.get().toByteArray();
    } else {
      arrayOfByte = null;
    }
    int i = 0;
    if (paramPbGetMsgResp.msg_rsp_type.has()) {
      i = paramPbGetMsgResp.msg_rsp_type.get();
    }
    a(paramArrayOfByte, arrayOfByte, i);
    return i;
  }
  
  private long a(byte paramByte, boolean paramBoolean1, boolean paramBoolean2, long paramLong, StringBuilder paramStringBuilder, List<msg_comm.UinPairMsg> paramList, int paramInt)
  {
    int i = 0;
    int k = 0;
    while (k < paramList.size())
    {
      paramLong = System.currentTimeMillis();
      msg_comm.UinPairMsg localUinPairMsg = (msg_comm.UinPairMsg)paramList.get(k);
      ??? = String.valueOf(localUinPairMsg.peer_uin.get());
      long l = localUinPairMsg.last_read_time.get() & 0xFFFFFFFF;
      List localList = localUinPairMsg.msg.get();
      boolean bool;
      if ((localUinPairMsg.msg_completed.has()) && (localUinPairMsg.msg_completed.get() != 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.setLength(i);
        paramStringBuilder.append("<---handleGetC2CMessageResp pkgPeerUin:");
        paramStringBuilder.append((String)???);
        paramStringBuilder.append(" uMsgCompleted:");
        paramStringBuilder.append(bool);
        paramStringBuilder.append(" lastReadTime:");
        paramStringBuilder.append(l);
        paramStringBuilder.append(" msgListSize:");
        if (localList == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(localList.size());
        }
        paramStringBuilder.append(localObject1);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramStringBuilder.toString());
      }
      int m;
      int j;
      if ((localList != null) && (localList.size() > 0))
      {
        if (localList.size() > 1) {
          Collections.sort(localList, this.jdField_a_of_type_JavaUtilComparator);
        }
        b(localList);
        try
        {
          synchronized (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a((String)???, i))
          {
            Pair localPair = a(localUinPairMsg, l, bool, paramBoolean1, paramBoolean2);
            localObject1 = (String)localPair.first;
            m = ((Integer)localPair.second).intValue();
            a(paramByte, (String)localObject1, localList, bool);
            i = 0;
            bool = false;
          }
          m = a(paramByte, localUinPairMsg, (String)???, i);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("decodeC2CMessagePackage error ");
            ((StringBuilder)???).append(localException);
            QLog.e("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)???).toString(), localException);
          }
          j = 0;
        }
      }
      else
      {
        b((String)???, m);
        Object localObject3 = ???;
        bool = true;
        j = i;
        if (paramBoolean1)
        {
          a(paramByte, paramInt, l, localUinPairMsg, localObject3, m, localList, bool);
          j = i;
        }
      }
      k += 1;
      i = j;
    }
    return paramLong;
  }
  
  private long a(int paramInt1, int paramInt2)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramInt1, paramInt2);
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong1, paramLong2, paramLong3);
  }
  
  private long a(msg_svc.PbGetRoamMsgResp paramPbGetRoamMsgResp, ArrayList<msg_comm.Msg> paramArrayList, long paramLong)
  {
    if (!paramArrayList.isEmpty())
    {
      paramArrayList = (msg_comm.Msg)paramArrayList.get(0);
      paramLong = a(((msg_comm.MsgHead)paramArrayList.msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)paramArrayList.msg_head.get()).to_uin.get(), paramPbGetRoamMsgResp.peer_uin.get());
    }
    return paramLong;
  }
  
  private Pair<List<MessageRecord>, List<MessageRecord>> a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a(paramLong1, paramLong2, paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i;
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        boolean bool = paramList.hasNext();
        i = 0;
        if (!bool) {
          break;
        }
        localObject1 = (msg_comm.Msg)paramList.next();
        if (!((msg_comm.Msg)localObject1).msg_head.has())
        {
          paramList.remove();
        }
        else
        {
          localObject1 = (msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject1).msg_seq.get();
          while (i < localList.size())
          {
            localObject1 = (MessageRecord)localList.get(i);
            if ((((MessageRecord)localObject1).msgUid == paramLong1) && (((MessageRecord)localObject1).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("filterRoamMsgFromDB duplicated ");
                ((StringBuilder)localObject2).append(localObject1);
                QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject2).toString());
              }
              localArrayList.add(localObject1);
              paramList.remove();
            }
            i += 1;
          }
        }
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        i = 0;
        while (i < localList.size())
        {
          localObject2 = (MessageRecord)localList.get(i);
          if ((((MessageRecord)localObject2).msgUid == ((MessageRecord)localObject1).msgUid) && (((MessageRecord)localObject2).shmsgseq == ((MessageRecord)localObject1).shmsgseq))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("filterRoamMsgFromDB duplicated ");
              ((StringBuilder)localObject2).append(localObject1);
              QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject2).toString());
            }
            paramList.remove();
          }
          i += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList1);
  }
  
  private Pair<String, Integer> a(msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    long l = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(l, paramUinPairMsg.peer_uin.get(), true, paramBoolean2, paramBoolean3, false);
    localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString = String.valueOf(paramUinPairMsg.peer_uin.get());
    Object localObject2 = paramUinPairMsg.msg.get();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      a((List)localObject2, (List)localObject1);
      localObject2 = new StringBuilder();
      HashMap localHashMap = new HashMap();
      HashSet localHashSet = new HashSet();
      localDecodeProtoPkgContext.jdField_e_of_type_Boolean = true;
      localDecodeProtoPkgContext.a(1000, localHashMap);
      localDecodeProtoPkgContext.a(1001, localHashSet);
      int i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        a(this, paramUinPairMsg, paramLong, localArrayList, localDecodeProtoPkgContext, (ArrayList)localObject1, (StringBuilder)localObject2, i);
        i += 1;
      }
      localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString = a(String.valueOf(paramUinPairMsg.peer_uin.get()), localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString);
      a(l, localHashMap, localHashSet);
      if (localArrayList.size() > 0)
      {
        if (!paramBoolean2) {
          ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(localArrayList);
        }
        localObject1 = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
        localObject2 = localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString;
        paramBoolean3 = false;
        ((IMessageFacade)localObject1).setAutoPullC2CMsgResult((String)localObject2, 0, localArrayList, paramBoolean1);
        boolean bool = a(localArrayList);
        i = MsgProxyUtils.a(localArrayList, (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache());
        b(localArrayList);
        localObject1 = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
        if ((bool) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop)) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = paramBoolean3;
        }
        ((IMessageFacade)localObject1).addMessage(localArrayList, str, paramBoolean1);
        c(localArrayList);
        a("handleGetBuddyMessageResp", true, i, bool, paramBoolean2);
        a(String.valueOf(paramUinPairMsg.peer_uin.get()), paramBoolean2, localArrayList, localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString, localDecodeProtoPkgContext.jdField_e_of_type_Int);
      }
      if (QLog.isColorLevel())
      {
        paramUinPairMsg = new StringBuilder();
        paramUinPairMsg.append("<---decodeC2CMessagePackage : dstUin:");
        paramUinPairMsg.append(localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString);
        paramUinPairMsg.append(", pkgUinType:");
        paramUinPairMsg.append(localDecodeProtoPkgContext.jdField_e_of_type_Int);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramUinPairMsg.toString());
      }
      return new Pair(localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString, Integer.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Int));
    }
    return new Pair(localDecodeProtoPkgContext.jdField_a_of_type_JavaLangString, Integer.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Int));
  }
  
  private String a(String paramString)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramString, this);
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString2 != null)
    {
      if (paramString2.equals("0")) {
        return paramString1;
      }
      str = paramString2;
    }
    return str;
  }
  
  @NonNull
  private String a(msg_comm.UinPairMsg paramUinPairMsg, int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramUinPairMsg, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
  }
  
  private List<MessageRecord> a(long paramLong1, long paramLong2, long paramLong3)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(String.valueOf(paramLong1), paramLong2 - 30L, paramLong3 + 30L, this);
  }
  
  private List<MessageRecord> a(String paramString, List<msg_comm.Msg> paramList)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramString, paramList, this);
  }
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte)
  {
    msg_svc.PbGetMsgResp localPbGetMsgResp = new msg_svc.PbGetMsgResp();
    try
    {
      paramArrayOfByte = (msg_svc.PbGetMsgResp)localPbGetMsgResp.mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB : decode pb:", paramArrayOfByte);
      }
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
    }
    return paramArrayOfByte;
  }
  
  @Nullable
  private oidb_c2c_searcher.RspBody a(msg_svc.PbSearchRoamMsgInCloudResp paramPbSearchRoamMsgInCloudResp, oidb_c2c_searcher.RspBody paramRspBody)
  {
    if (paramPbSearchRoamMsgInCloudResp.serialize_rspbody.has()) {
      try
      {
        paramPbSearchRoamMsgInCloudResp = (oidb_c2c_searcher.RspBody)paramRspBody.mergeFrom(paramPbSearchRoamMsgInCloudResp.serialize_rspbody.get().toByteArray());
        return paramPbSearchRoamMsgInCloudResp;
      }
      catch (OutOfMemoryError paramPbSearchRoamMsgInCloudResp)
      {
        if (QLog.isColorLevel())
        {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud OutOfMemoryError ! oidb_search!", paramPbSearchRoamMsgInCloudResp);
          return null;
        }
      }
      catch (InvalidProtocolBufferMicroException paramPbSearchRoamMsgInCloudResp)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud InvalidProtocolBufferMicroException oidb_search! ", paramPbSearchRoamMsgInCloudResp);
        }
      }
    }
    return null;
  }
  
  private void a(byte paramByte, int paramInt1, long paramLong, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt2, List<msg_comm.Msg> paramList, boolean paramBoolean)
  {
    if (paramInt2 == 1006) {
      a(paramString);
    }
    int i = UinTypeUtil.a(paramInt2);
    boolean bool = false;
    if (i == 1032) {
      i = 0;
    } else {
      i = paramInt2;
    }
    paramUinPairMsg = a(paramUinPairMsg, i);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("update c2c unread , pkguin=");
      paramString.append(paramUinPairMsg);
      paramString.append(", pkgUinType=");
      paramString.append(paramInt2);
      paramString.append(", lastReadTime=");
      paramString.append(paramLong);
      QLog.d("Q.msg.C2CMessageProcessor", 2, paramString.toString());
    }
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramUinPairMsg, paramList, paramBoolean, i, this);
    paramString = new android.os.Message();
    paramString.what = 1;
    paramList = new Bundle();
    paramList.putLong("update_unread_time", paramLong);
    paramList.putString("update_unread_uin", paramUinPairMsg);
    paramList.putInt("update_unread_type", i);
    paramString.setData(paramList);
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler;
    paramBoolean = bool;
    if (paramByte <= 0) {
      paramBoolean = true;
    }
    paramList.a(paramString, paramBoolean);
    if (paramInt1 == 2)
    {
      this.b.add(paramUinPairMsg);
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramUinPairMsg);
  }
  
  private void a(byte paramByte, String paramString, List<msg_comm.Msg> paramList, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      long l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).g(paramString);
      long l2 = ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).msg_time.get();
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("<---decodeC2CMessagePackage : peerUin:");
        paramList.append(paramString);
        paramList.append("lastBreakTime:");
        paramList.append(l1);
        paramList.append(" currentBreakTime:");
        paramList.append(l2);
        paramList.append(" channelType:");
        paramList.append(paramByte);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramList.toString());
      }
      paramList = (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache();
      if ((l1 == 0L) || (l2 < l1))
      {
        paramList.b(paramString, l2, 0L);
        if (paramByte > 0) {
          paramList.g(paramString, l2);
        }
      }
      if (paramByte == 0) {
        paramList.c();
      }
    }
  }
  
  private void a(byte paramByte, boolean paramBoolean, int paramInt)
  {
    if (paramByte <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b();
      if (paramBoolean)
      {
        a(paramInt, ((IConversationFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IConversationFacade.class, "")).getConversationInfoSet());
        if (paramInt == 2) {
          this.b.clear();
        } else {
          this.jdField_a_of_type_JavaUtilSet.clear();
        }
      }
      MsgAutoMonitorUtil.getInstance().markC2CFinishTime();
      b(paramInt);
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).i();
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB handleMsgNew()");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(false, 0);
      }
    }
  }
  
  private void a(int paramInt)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramInt, this);
  }
  
  private void a(int paramInt, Set<ConversationInfo> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)paramSet.next();
      if ((localConversationInfo.uin != null) && (localConversationInfo.type != 1036) && (UinTypeUtil.a(localConversationInfo.type) != 1032) && ((paramInt != 1) || (localConversationInfo.type != 1008)) && ((paramInt != 2) || (localConversationInfo.type == 1008)) && ((paramInt == 2) || (this.jdField_a_of_type_JavaUtilSet.size() <= 0) || (!this.jdField_a_of_type_JavaUtilSet.contains(localConversationInfo.uin))) && ((paramInt != 2) || (this.b.size() <= 0) || (!this.b.contains(localConversationInfo.uin)))) {
        a(localConversationInfo);
      }
    }
  }
  
  private void a(int paramInt, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, BaseMessageHandler paramBaseMessageHandler, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Decoder localDecoder = a(paramInt);
    if (localDecoder != null) {
      localDecoder.a(paramBaseMessageHandler, paramMsg, paramArrayList, paramDecodeProtoPkgContext);
    }
  }
  
  private void a(long paramLong)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramLong);
  }
  
  private void a(long paramLong, HashMap<Long, msg_comm.Msg> paramHashMap, HashSet<Long> paramHashSet)
  {
    if (!paramHashMap.isEmpty())
    {
      paramHashSet = paramHashSet.iterator();
      Object localObject;
      while (paramHashSet.hasNext())
      {
        localObject = (Long)paramHashSet.next();
        paramHashMap.remove(localObject);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Discard video request because canceled: fromUin = ");
          localStringBuilder.append(localObject);
          QLog.d("svenxu", 2, localStringBuilder.toString());
        }
      }
      paramHashSet = paramHashMap.keySet().iterator();
      while (paramHashSet.hasNext())
      {
        localObject = (msg_comm.Msg)paramHashMap.get((Long)paramHashSet.next());
        if (((msg_comm.Msg)localObject).msg_body.has()) {
          ((im_msg_body.MsgBody)((msg_comm.Msg)localObject).msg_body.get()).msg_content.has();
        }
      }
    }
  }
  
  private void a(C2CMsgReadedNotify paramC2CMsgReadedNotify, String paramString)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, paramC2CMsgReadedNotify);
  }
  
  public static void a(C2CMessageProcessor.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback = paramCallback;
  }
  
  private static void a(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, ArrayList<MessageRecord> paramArrayList, DecodeProtoPkgContext paramDecodeProtoPkgContext, ArrayList<msg_comm.Msg> paramArrayList1, StringBuilder paramStringBuilder, int paramInt)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramC2CMessageProcessor, paramUinPairMsg, paramLong, paramArrayList, paramArrayList1, paramStringBuilder, paramDecodeProtoPkgContext, paramInt);
  }
  
  private void a(ConversationInfo paramConversationInfo)
  {
    if ((UinTypeUtil.b(paramConversationInfo.type)) && (ConversationFacade.c(paramConversationInfo) > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("update c2c unread , frienduin=");
        ((StringBuilder)localObject1).append(paramConversationInfo.uin);
        ((StringBuilder)localObject1).append(", friendUinType=");
        ((StringBuilder)localObject1).append(paramConversationInfo.type);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramConversationInfo.uin.length() <= 4) {
        return;
      }
      if (paramConversationInfo.type == 1001)
      {
        localObject1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).m(paramConversationInfo.uin);
        if (localObject1 != null)
        {
          if (localObject1.length <= 0) {
            return;
          }
          if (!QLog.isColorLevel()) {
            break label219;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("clean the unreadcount of lbs : ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (paramConversationInfo.type == 10002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "processOffline : ");
        }
      }
      else if (paramConversationInfo.isImax)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "processOffline 0xf9 no need syn unreadtime");
        }
        return;
      }
      label219:
      Object localObject1 = new android.os.Message();
      ((android.os.Message)localObject1).what = 1;
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("update_unread_time", 9223372036854775807L);
      ((Bundle)localObject2).putString("update_unread_uin", paramConversationInfo.uin);
      ((Bundle)localObject2).putInt("update_unread_type", paramConversationInfo.type);
      ((android.os.Message)localObject1).setData((Bundle)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a((android.os.Message)localObject1, true);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int i = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (i < 2))
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSearchRoamMsgInCloudTimeOutAndError retry index:");
        paramFromServiceMsg.append(i);
        QLog.w("Q.msg.C2CMessageProcessor", 2, paramFromServiceMsg.toString());
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler("com.tencent.mobileqq.app.MessageHandler").sendPbReq(paramToServiceMsg);
      return;
    }
    a(8015, false, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    long l = paramToServiceMsg.extraData.getLong("lBeginTime");
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramString, l, 3, this);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetRoamMsgResp paramPbGetRoamMsgResp, Long paramLong, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString, int paramInt2, List<msg_comm.Msg> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iload 9
    //   5: ifeq +19 -> 24
    //   8: iload 9
    //   10: iconst_1
    //   11: if_icmpne +6 -> 17
    //   14: goto +10 -> 24
    //   17: iload 11
    //   19: istore 4
    //   21: goto +653 -> 674
    //   24: aload_2
    //   25: getfield 809	msf/msgsvc/msg_svc$PbGetRoamMsgResp:last_msgtime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   28: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   31: lstore 13
    //   33: aload_1
    //   34: getfield 734	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   37: ldc_w 811
    //   40: invokevirtual 739	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   43: lstore 15
    //   45: iload 9
    //   47: ifne +78 -> 125
    //   50: aload_0
    //   51: aload 8
    //   53: aload 10
    //   55: invokespecial 814	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/lang/String;Ljava/util/List;)V
    //   58: aload_2
    //   59: getfield 817	msf/msgsvc/msg_svc$PbGetRoamMsgResp:random	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   62: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   65: lstore 17
    //   67: aload_0
    //   68: invokespecial 819	com/tencent/imcore/message/C2CMessageProcessor:a	()[B
    //   71: astore 10
    //   73: aload_0
    //   74: invokespecial 821	com/tencent/imcore/message/C2CMessageProcessor:a	()I
    //   77: istore 11
    //   79: aload_1
    //   80: getfield 734	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   83: ldc_w 743
    //   86: invokevirtual 747	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   89: istore 12
    //   91: aload_0
    //   92: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   95: aload 8
    //   97: aload_3
    //   98: invokevirtual 824	java/lang/Long:longValue	()J
    //   101: lload 13
    //   103: lload 15
    //   105: iconst_0
    //   106: lload 17
    //   108: iconst_1
    //   109: aload 10
    //   111: iload 11
    //   113: iload 12
    //   115: iload 4
    //   117: iload 5
    //   119: iload 6
    //   121: invokevirtual 827	com/tencent/mobileqq/app/BaseMessageHandler:a	(Ljava/lang/String;JJJSJI[BIZIZZ)V
    //   124: return
    //   125: new 284	java/util/ArrayList
    //   128: dup
    //   129: aload 10
    //   131: invokespecial 830	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   134: astore 21
    //   136: aload_0
    //   137: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   140: getfield 833	com/tencent/mobileqq/app/BaseMessageHandler:a	Ljava/util/HashMap;
    //   143: aload 8
    //   145: invokevirtual 836	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   148: ifeq +37 -> 185
    //   151: aload 21
    //   153: aload_0
    //   154: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   157: getfield 833	com/tencent/mobileqq/app/BaseMessageHandler:a	Ljava/util/HashMap;
    //   160: aload 8
    //   162: invokevirtual 672	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast 838	java/util/Collection
    //   168: invokevirtual 842	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   171: pop
    //   172: aload_0
    //   173: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   176: getfield 833	com/tencent/mobileqq/app/BaseMessageHandler:a	Ljava/util/HashMap;
    //   179: aload 8
    //   181: invokevirtual 663	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: aload 21
    //   187: invokevirtual 287	java/util/ArrayList:isEmpty	()Z
    //   190: ifeq +38 -> 228
    //   193: iconst_2
    //   194: anewarray 844	java/lang/Object
    //   197: iconst_0
    //   198: iconst_1
    //   199: invokestatic 849	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   202: aastore
    //   203: aload 7
    //   205: ldc_w 851
    //   208: getstatic 855	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   211: invokevirtual 858	java/lang/Boolean:booleanValue	()Z
    //   214: invokevirtual 751	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   217: aload_0
    //   218: sipush 1004
    //   221: iconst_0
    //   222: aload 7
    //   224: invokevirtual 754	com/tencent/imcore/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   227: return
    //   228: aload_1
    //   229: getfield 734	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   232: ldc_w 736
    //   235: invokevirtual 739	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   238: lstore 17
    //   240: new 284	java/util/ArrayList
    //   243: dup
    //   244: invokespecial 313	java/util/ArrayList:<init>	()V
    //   247: astore 22
    //   249: aload_0
    //   250: aload 21
    //   252: lload 17
    //   254: lload 15
    //   256: aload 22
    //   258: invokespecial 861	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/util/ArrayList;JJLjava/util/ArrayList;)V
    //   261: aload_0
    //   262: aload 8
    //   264: aload 22
    //   266: invokespecial 863	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    //   269: astore 23
    //   271: new 284	java/util/ArrayList
    //   274: dup
    //   275: invokespecial 313	java/util/ArrayList:<init>	()V
    //   278: astore 10
    //   280: aload_0
    //   281: aload_2
    //   282: aload 22
    //   284: aload 8
    //   286: invokestatic 866	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   289: invokespecial 868	com/tencent/imcore/message/C2CMessageProcessor:a	(Lmsf/msgsvc/msg_svc$PbGetRoamMsgResp;Ljava/util/ArrayList;J)J
    //   292: lstore 17
    //   294: aload_3
    //   295: invokevirtual 824	java/lang/Long:longValue	()J
    //   298: lstore 19
    //   300: aload 10
    //   302: aload_0
    //   303: aload 22
    //   305: aload 23
    //   307: lload 17
    //   309: lload 19
    //   311: lload 15
    //   313: invokespecial 870	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/util/List;Ljava/util/List;JJJ)Landroid/util/Pair;
    //   316: getfield 249	android/util/Pair:second	Ljava/lang/Object;
    //   319: checkcast 838	java/util/Collection
    //   322: invokevirtual 842	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   325: pop
    //   326: new 367	com/tencent/mobileqq/service/message/DecodeProtoPkgContext
    //   329: dup
    //   330: aload_0
    //   331: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   334: invokevirtual 365	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   337: invokestatic 866	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   340: lload 17
    //   342: iconst_1
    //   343: iconst_1
    //   344: iconst_0
    //   345: iconst_0
    //   346: invokespecial 370	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:<init>	(JJZZZZ)V
    //   349: astore_3
    //   350: aload_3
    //   351: iconst_1
    //   352: putfield 873	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:h	Z
    //   355: aload_0
    //   356: aload 22
    //   358: aload 10
    //   360: aload_3
    //   361: invokespecial 876	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mobileqq/service/message/DecodeProtoPkgContext;)V
    //   364: aload_0
    //   365: iload 6
    //   367: aload 8
    //   369: aload 10
    //   371: invokespecial 879	com/tencent/imcore/message/C2CMessageProcessor:a	(ZLjava/lang/String;Ljava/util/ArrayList;)V
    //   374: aload_0
    //   375: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   378: invokevirtual 398	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   381: checkcast 400	com/tencent/mobileqq/service/message/MessageCache
    //   384: aload_2
    //   385: getfield 308	msf/msgsvc/msg_svc$PbGetRoamMsgResp:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   388: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   391: invokestatic 175	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   394: invokevirtual 882	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;)Landroid/util/Pair;
    //   397: astore_3
    //   398: aload_3
    //   399: ifnull +19 -> 418
    //   402: aload_3
    //   403: getfield 246	android/util/Pair:first	Ljava/lang/Object;
    //   406: checkcast 660	java/lang/Long
    //   409: invokevirtual 824	java/lang/Long:longValue	()J
    //   412: lload 13
    //   414: lcmp
    //   415: ifle +37 -> 452
    //   418: aload_0
    //   419: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   422: invokevirtual 398	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   425: checkcast 400	com/tencent/mobileqq/service/message/MessageCache
    //   428: aload_2
    //   429: getfield 308	msf/msgsvc/msg_svc$PbGetRoamMsgResp:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   432: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   435: invokestatic 175	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   438: aload_1
    //   439: getfield 734	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   442: ldc_w 736
    //   445: invokevirtual 739	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   448: lconst_0
    //   449: invokevirtual 583	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;JJ)V
    //   452: aload_0
    //   453: aload_1
    //   454: aload 8
    //   456: invokespecial 884	com/tencent/imcore/message/C2CMessageProcessor:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;)V
    //   459: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: istore 5
    //   464: iload 5
    //   466: ifeq +280 -> 746
    //   469: new 83	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   476: astore_1
    //   477: aload_1
    //   478: ldc_w 886
    //   481: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_1
    //   486: aload 21
    //   488: invokevirtual 386	java/util/ArrayList:size	()I
    //   491: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_1
    //   496: ldc_w 888
    //   499: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_1
    //   504: aload 22
    //   506: invokevirtual 386	java/util/ArrayList:size	()I
    //   509: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_1
    //   514: ldc_w 890
    //   517: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_1
    //   522: aload 10
    //   524: invokevirtual 386	java/util/ArrayList:size	()I
    //   527: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload_1
    //   532: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: astore_1
    //   536: ldc 101
    //   538: iconst_2
    //   539: aload_1
    //   540: invokestatic 789	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto +3 -> 546
    //   546: aload 10
    //   548: invokevirtual 386	java/util/ArrayList:size	()I
    //   551: istore 11
    //   553: aload 7
    //   555: astore_1
    //   556: aload_1
    //   557: ldc_w 892
    //   560: iload 4
    //   562: iload 11
    //   564: isub
    //   565: invokevirtual 558	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   568: aload_0
    //   569: sipush 1004
    //   572: iconst_1
    //   573: aload_1
    //   574: invokevirtual 754	com/tencent/imcore/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   577: iconst_1
    //   578: istore 4
    //   580: goto +94 -> 674
    //   583: astore_1
    //   584: goto +40 -> 624
    //   587: astore_1
    //   588: goto +63 -> 651
    //   591: astore_1
    //   592: goto +32 -> 624
    //   595: astore_1
    //   596: goto +55 -> 651
    //   599: astore_1
    //   600: goto +24 -> 624
    //   603: astore_1
    //   604: goto +47 -> 651
    //   607: astore_1
    //   608: goto +8 -> 616
    //   611: astore_1
    //   612: goto +8 -> 620
    //   615: astore_1
    //   616: goto +8 -> 624
    //   619: astore_1
    //   620: goto +31 -> 651
    //   623: astore_1
    //   624: aload_1
    //   625: invokevirtual 893	java/lang/OutOfMemoryError:printStackTrace	()V
    //   628: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   631: ifeq +13 -> 644
    //   634: ldc 101
    //   636: iconst_2
    //   637: ldc_w 895
    //   640: aload_1
    //   641: invokestatic 512	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   644: iconst_0
    //   645: istore 4
    //   647: goto +27 -> 674
    //   650: astore_1
    //   651: aload_1
    //   652: invokevirtual 258	java/lang/Exception:printStackTrace	()V
    //   655: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq -14 -> 644
    //   661: ldc 101
    //   663: iconst_2
    //   664: ldc_w 897
    //   667: aload_1
    //   668: invokestatic 512	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   671: goto -27 -> 644
    //   674: iload 4
    //   676: ifne +61 -> 737
    //   679: aload_0
    //   680: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   683: getfield 833	com/tencent/mobileqq/app/BaseMessageHandler:a	Ljava/util/HashMap;
    //   686: aload 8
    //   688: invokevirtual 663	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   691: pop
    //   692: aload 7
    //   694: ldc_w 899
    //   697: iload 9
    //   699: invokevirtual 558	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   702: aload_2
    //   703: getfield 903	msf/msgsvc/msg_svc$PbGetRoamMsgResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   706: invokevirtual 906	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   709: ifeq +18 -> 727
    //   712: aload 7
    //   714: ldc_w 908
    //   717: aload_2
    //   718: getfield 903	msf/msgsvc/msg_svc$PbGetRoamMsgResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   721: invokevirtual 910	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   724: invokevirtual 553	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload_0
    //   728: sipush 1004
    //   731: iconst_0
    //   732: aload 7
    //   734: invokevirtual 754	com/tencent/imcore/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   737: return
    //   738: astore_1
    //   739: goto -139 -> 600
    //   742: astore_1
    //   743: goto -139 -> 604
    //   746: goto -200 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	C2CMessageProcessor
    //   0	749	1	paramToServiceMsg	ToServiceMsg
    //   0	749	2	paramPbGetRoamMsgResp	msg_svc.PbGetRoamMsgResp
    //   0	749	3	paramLong	Long
    //   0	749	4	paramInt1	int
    //   0	749	5	paramBoolean1	boolean
    //   0	749	6	paramBoolean2	boolean
    //   0	749	7	paramBundle	Bundle
    //   0	749	8	paramString	String
    //   0	749	9	paramInt2	int
    //   0	749	10	paramList	List<msg_comm.Msg>
    //   1	564	11	i	int
    //   89	25	12	bool	boolean
    //   31	382	13	l1	long
    //   43	269	15	l2	long
    //   65	276	17	l3	long
    //   298	12	19	l4	long
    //   134	353	21	localArrayList1	ArrayList
    //   247	258	22	localArrayList2	ArrayList
    //   269	37	23	localList	List
    // Exception table:
    //   from	to	target	type
    //   568	577	583	java/lang/OutOfMemoryError
    //   568	577	587	java/lang/Exception
    //   556	568	591	java/lang/OutOfMemoryError
    //   556	568	595	java/lang/Exception
    //   536	543	599	java/lang/OutOfMemoryError
    //   546	553	599	java/lang/OutOfMemoryError
    //   536	543	603	java/lang/Exception
    //   546	553	603	java/lang/Exception
    //   300	398	607	java/lang/OutOfMemoryError
    //   402	418	607	java/lang/OutOfMemoryError
    //   418	452	607	java/lang/OutOfMemoryError
    //   452	464	607	java/lang/OutOfMemoryError
    //   300	398	611	java/lang/Exception
    //   402	418	611	java/lang/Exception
    //   418	452	611	java/lang/Exception
    //   452	464	611	java/lang/Exception
    //   249	300	615	java/lang/OutOfMemoryError
    //   249	300	619	java/lang/Exception
    //   24	45	623	java/lang/OutOfMemoryError
    //   50	124	623	java/lang/OutOfMemoryError
    //   125	185	623	java/lang/OutOfMemoryError
    //   185	227	623	java/lang/OutOfMemoryError
    //   228	249	623	java/lang/OutOfMemoryError
    //   24	45	650	java/lang/Exception
    //   50	124	650	java/lang/Exception
    //   125	185	650	java/lang/Exception
    //   185	227	650	java/lang/Exception
    //   228	249	650	java/lang/Exception
    //   469	536	738	java/lang/OutOfMemoryError
    //   469	536	742	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
  }
  
  private void a(String paramString, List<msg_comm.Msg> paramList)
  {
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a.containsKey(paramString))
      {
        paramString = (List)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a.get(paramString);
        if (paramString.size() == 0)
        {
          paramString.addAll(0, paramList);
          return;
        }
        if ((((msg_comm.MsgHead)((msg_comm.Msg)paramString.get(0)).msg_head.get()).msg_uid.get() != ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).msg_uid.get()) || (((msg_comm.MsgHead)((msg_comm.Msg)paramString.get(0)).msg_head.get()).msg_seq.get() != ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).msg_seq.get())) {
          paramString.addAll(0, paramList);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a.put(paramString, paramList);
      }
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, String paramString2, int paramInt)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramString1, paramBoolean, paramArrayList, paramString2, paramInt, this);
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList1, long paramLong1, long paramLong2, ArrayList<msg_comm.Msg> paramArrayList2)
  {
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      msg_comm.Msg localMsg = (msg_comm.Msg)paramArrayList1.next();
      if (!localMsg.msg_head.has())
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
        }
      }
      else
      {
        long l = ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_time.get();
        if ((l >= paramLong1) && (l <= paramLong2)) {
          paramArrayList2.add(localMsg);
        }
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, long paramLong, DecodeProtoPkgContext paramDecodeProtoPkgContext, ArrayList<MessageRecord> paramArrayList1)
  {
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      paramArrayList = (msg_comm.Msg)localIterator.next();
      if (paramArrayList == null) {}
    }
    for (;;)
    {
      long l2;
      long l3;
      try
      {
        if ((paramArrayList.msg_head.has()) && (paramArrayList.msg_body.has()))
        {
          localObject2 = (msg_comm.MsgHead)paramArrayList.msg_head.get();
          l2 = ((msg_comm.MsgHead)localObject2).to_uin.get();
          l3 = ((msg_comm.MsgHead)localObject2).from_uin.get();
          if ((l2 == paramLong) || (l3 == paramLong)) {
            break label289;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C msg uin not selfUin and toUin : ");
          break;
          Object localObject1;
          paramDecodeProtoPkgContext.g = localObject1;
          paramArrayList = a(paramArrayList, paramDecodeProtoPkgContext);
          if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
            break;
          }
          paramArrayList1.addAll(paramArrayList);
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decodeSinglePBMsg_C2C return : ");
        if (paramArrayList == null)
        {
          paramArrayList = " msg=null";
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" msg.msg_head:");
          localStringBuilder.append(paramArrayList.msg_head);
          localStringBuilder.append(" msg.msg_body:");
          localStringBuilder.append(paramArrayList.msg_body.has());
          paramArrayList = localStringBuilder.toString();
        }
        ((StringBuilder)localObject2).append(paramArrayList);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      catch (Exception paramArrayList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud decodeSinglePBMsg_C2C error,", paramArrayList);
      break;
      return;
      label289:
      long l1 = l2;
      if (l2 == paramLong) {
        l1 = l3;
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (msg_comm.Msg)paramArrayList.next();
      try
      {
        localObject = a((msg_comm.Msg)localObject, paramDecodeProtoPkgContext);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          continue;
        }
        paramArrayList1.addAll((Collection)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<DelMsgInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList2)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      int j = paramArrayList1.size();
      int i = 0;
      while (i < j)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList1.get(i);
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: ");
          ((StringBuilder)localObject).append(localMessageRecord.senderuin);
          ((StringBuilder)localObject).append(" mr.msgtype: ");
          ((StringBuilder)localObject).append(localMessageRecord.msgtype);
          ((StringBuilder)localObject).append(" mr.frienduin: ");
          ((StringBuilder)localObject).append(localMessageRecord.frienduin);
          ((StringBuilder)localObject).append(" mr.shmsgseq: ");
          ((StringBuilder)localObject).append(localMessageRecord.shmsgseq);
          ((StringBuilder)localObject).append(" mr.time:");
          ((StringBuilder)localObject).append(localMessageRecord.time);
          ((StringBuilder)localObject).append(" mr.msg: ");
          ((StringBuilder)localObject).append(localMessageRecord.getLogColorContent());
          QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
        }
        if ((localMessageRecord.frienduin != null) && (localMessageRecord.frienduin.length() > 2))
        {
          localMessageRecord.isread = false;
          paramArrayList2.add(localMessageRecord);
          localObject = new DelMsgInfo();
          ((DelMsgInfo)localObject).lFromUin = Long.parseLong(localMessageRecord.senderuin);
          ((DelMsgInfo)localObject).shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
          ((DelMsgInfo)localObject).uMsgTime = localMessageRecord.time;
          paramArrayList.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramList);
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:");
      localStringBuilder.append(paramList1.size());
      localStringBuilder.append(" outListSize:");
      localStringBuilder.append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, ArrayList<MessageRecord> paramArrayList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (msg_comm.Msg)localIterator.next();
      try
      {
        paramList = a(paramList, paramDecodeProtoPkgContext);
      }
      catch (Exception localException)
      {
        paramList = paramList1;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
          paramList = paramList1;
        }
      }
      paramList1 = paramList;
      if (paramList != null)
      {
        paramList1 = paramList;
        if (paramList.size() > 0)
        {
          paramArrayList.addAll(paramList);
          paramList1 = paramList;
        }
      }
    }
  }
  
  /* Error */
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 294	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   4: invokevirtual 299	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 296	msf/msgcomm/msg_comm$MsgHead
    //   10: astore 23
    //   12: aload 23
    //   14: getfield 1021	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   17: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   20: ifne +19 -> 39
    //   23: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +12 -> 38
    //   29: ldc 101
    //   31: iconst_2
    //   32: ldc_w 1023
    //   35: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: return
    //   39: aload 23
    //   41: getfield 1021	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   44: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   47: i2l
    //   48: lstore 6
    //   50: aload 23
    //   52: getfield 302	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   55: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   58: lstore 8
    //   60: aload 23
    //   62: getfield 305	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   65: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   68: lstore 10
    //   70: aload 23
    //   72: getfield 340	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   75: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   78: i2l
    //   79: lstore 12
    //   81: aload 23
    //   83: getfield 576	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   86: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   89: i2l
    //   90: lstore 14
    //   92: aload 23
    //   94: getfield 337	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   97: invokevirtual 169	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   100: lstore 16
    //   102: aload 23
    //   104: getfield 1026	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: istore 4
    //   112: aload 23
    //   114: getfield 1029	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   117: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   120: istore 5
    //   122: aload_2
    //   123: invokevirtual 1034	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   126: ifnonnull +15 -> 141
    //   129: aload_0
    //   130: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   133: invokevirtual 365	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   136: astore 22
    //   138: goto +9 -> 147
    //   141: aload_2
    //   142: invokevirtual 1034	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   145: astore 22
    //   147: aload 22
    //   149: invokestatic 1037	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   152: invokevirtual 824	java/lang/Long:longValue	()J
    //   155: lstore 18
    //   157: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +189 -> 349
    //   163: new 83	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   170: astore 22
    //   172: aload 22
    //   174: ldc_w 1039
    //   177: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 22
    //   183: lload 8
    //   185: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 22
    //   191: ldc_w 1041
    //   194: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 22
    //   200: lload 10
    //   202: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 22
    //   208: ldc_w 1043
    //   211: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 22
    //   217: lload 14
    //   219: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 22
    //   225: ldc_w 1045
    //   228: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 22
    //   234: lload 12
    //   236: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 22
    //   242: ldc_w 1047
    //   245: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 22
    //   251: lload 16
    //   253: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 22
    //   259: ldc_w 1049
    //   262: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 22
    //   268: iload 4
    //   270: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 22
    //   276: ldc_w 1051
    //   279: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 22
    //   285: iload 5
    //   287: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 22
    //   293: ldc_w 1053
    //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 22
    //   302: aload_1
    //   303: getfield 1057	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   306: invokevirtual 1060	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   309: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 22
    //   315: ldc_w 1062
    //   318: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 22
    //   324: aload_1
    //   325: getfield 676	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   328: invokevirtual 679	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   331: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: ldc 101
    //   337: iconst_2
    //   338: aload 22
    //   340: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: goto +3 -> 349
    //   349: aload_0
    //   350: iload 4
    //   352: invokespecial 1064	com/tencent/imcore/message/C2CMessageProcessor:a	(I)V
    //   355: new 284	java/util/ArrayList
    //   358: dup
    //   359: invokespecial 313	java/util/ArrayList:<init>	()V
    //   362: astore 22
    //   364: new 367	com/tencent/mobileqq/service/message/DecodeProtoPkgContext
    //   367: dup
    //   368: lload 18
    //   370: lload 8
    //   372: iconst_1
    //   373: iconst_0
    //   374: iconst_0
    //   375: iconst_0
    //   376: invokespecial 370	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:<init>	(JJZZZZ)V
    //   379: astore 24
    //   381: aload 24
    //   383: iconst_1
    //   384: putfield 873	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:h	Z
    //   387: aload_0
    //   388: aload_1
    //   389: aload 24
    //   391: invokevirtual 936	com/tencent/imcore/message/C2CMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/service/message/PBDecodeContext;)Ljava/util/List;
    //   394: astore_1
    //   395: goto +31 -> 426
    //   398: astore_1
    //   399: goto +5 -> 404
    //   402: astore 24
    //   404: aload_1
    //   405: invokevirtual 258	java/lang/Exception:printStackTrace	()V
    //   408: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +13 -> 424
    //   414: ldc 101
    //   416: iconst_2
    //   417: ldc_w 1066
    //   420: aload_1
    //   421: invokestatic 512	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   424: aconst_null
    //   425: astore_1
    //   426: aload_0
    //   427: aload_1
    //   428: invokespecial 1067	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/util/List;)V
    //   431: aload_1
    //   432: ifnull +285 -> 717
    //   435: aload_1
    //   436: invokeinterface 152 1 0
    //   441: ifne +4 -> 445
    //   444: return
    //   445: aload_0
    //   446: aload_1
    //   447: aload 22
    //   449: iconst_1
    //   450: invokevirtual 1070	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/util/List;Ljava/util/ArrayList;Z)V
    //   453: new 284	java/util/ArrayList
    //   456: dup
    //   457: invokespecial 313	java/util/ArrayList:<init>	()V
    //   460: astore_1
    //   461: new 284	java/util/ArrayList
    //   464: dup
    //   465: invokespecial 313	java/util/ArrayList:<init>	()V
    //   468: astore 24
    //   470: aload_0
    //   471: aload 22
    //   473: aload_1
    //   474: aload 24
    //   476: invokespecial 1072	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   479: aload_0
    //   480: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   483: invokevirtual 398	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   486: checkcast 400	com/tencent/mobileqq/service/message/MessageCache
    //   489: aload 24
    //   491: invokevirtual 401	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/util/List;)V
    //   494: aload 24
    //   496: invokestatic 1075	com/tencent/mobileqq/app/BaseMessageHandlerUtils:a	(Ljava/util/ArrayList;)Z
    //   499: istore 21
    //   501: aload 22
    //   503: aload_0
    //   504: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   507: invokevirtual 398	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   510: checkcast 400	com/tencent/mobileqq/service/message/MessageCache
    //   513: invokestatic 413	com/tencent/imcore/message/MsgProxyUtils:a	(Ljava/util/List;Lcom/tencent/mobileqq/service/message/MessageCache;)I
    //   516: istore 4
    //   518: aload_0
    //   519: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   522: ldc 50
    //   524: ldc 52
    //   526: invokevirtual 58	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   529: checkcast 50	com/tencent/mobileqq/msg/api/IMessageFacade
    //   532: astore 22
    //   534: iload 21
    //   536: ifeq +19 -> 555
    //   539: aload_0
    //   540: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   543: getfield 419	com/tencent/common/app/AppInterface:isBackgroundStop	Z
    //   546: ifeq +9 -> 555
    //   549: iconst_1
    //   550: istore 20
    //   552: goto +6 -> 558
    //   555: iconst_0
    //   556: istore 20
    //   558: aload 22
    //   560: aload 24
    //   562: lload 18
    //   564: invokestatic 175	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   567: iload 20
    //   569: invokeinterface 423 4 0
    //   574: aload_0
    //   575: getfield 48	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   578: invokevirtual 398	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   581: checkcast 400	com/tencent/mobileqq/service/message/MessageCache
    //   584: aload 23
    //   586: getfield 340	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   589: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   592: invokevirtual 1076	com/tencent/mobileqq/service/message/MessageCache:a	(I)V
    //   595: aload_2
    //   596: invokevirtual 1079	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   599: istore 5
    //   601: aload_3
    //   602: getfield 1084	msf/onlinepush/msg_onlinepush$PbPushMsg:bytes_push_token	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   605: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   608: invokevirtual 1087	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   611: astore_2
    //   612: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +41 -> 656
    //   618: ldc 101
    //   620: iconst_2
    //   621: iconst_5
    //   622: anewarray 844	java/lang/Object
    //   625: dup
    //   626: iconst_0
    //   627: ldc_w 1089
    //   630: aastore
    //   631: dup
    //   632: iconst_1
    //   633: aload_2
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: ldc_w 1091
    //   640: aastore
    //   641: dup
    //   642: iconst_3
    //   643: ldc_w 1093
    //   646: aastore
    //   647: dup
    //   648: iconst_4
    //   649: ldc_w 1095
    //   652: aastore
    //   653: invokestatic 1098	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   656: aload_0
    //   657: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   660: lload 8
    //   662: aload_1
    //   663: aload_3
    //   664: getfield 1102	msf/onlinepush/msg_onlinepush$PbPushMsg:svrip	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   667: invokevirtual 1105	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   670: iload 5
    //   672: aload_3
    //   673: invokevirtual 1108	com/tencent/mobileqq/app/BaseMessageHandler:a	(JLjava/util/ArrayList;IILmsf/onlinepush/msg_onlinepush$PbPushMsg;)V
    //   676: lload 6
    //   678: ldc2_w 1109
    //   681: lcmp
    //   682: ifne +4 -> 686
    //   685: return
    //   686: aload_0
    //   687: ldc_w 1112
    //   690: iconst_1
    //   691: iload 4
    //   693: aload_0
    //   694: getfield 232	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   697: iload 21
    //   699: invokevirtual 1115	com/tencent/mobileqq/app/BaseMessageHandler:a	(Z)Z
    //   702: iconst_0
    //   703: invokevirtual 431	com/tencent/imcore/message/C2CMessageProcessor:a	(Ljava/lang/String;ZIZZ)V
    //   706: getstatic 39	com/tencent/imcore/message/C2CMessageProcessor:jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback	Lcom/tencent/imcore/message/C2CMessageProcessor$Callback;
    //   709: aload 24
    //   711: aload_0
    //   712: invokeinterface 1118 3 0
    //   717: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	C2CMessageProcessor
    //   0	718	1	paramMsg	msg_comm.Msg
    //   0	718	2	paramFromServiceMsg	FromServiceMsg
    //   0	718	3	paramPbPushMsg	msg_onlinepush.PbPushMsg
    //   110	241	4	i	int
    //   120	166	5	j	int
    //   48	1	6	l1	long
    //   58	313	8	l2	long
    //   68	133	10	l3	long
    //   79	156	12	l4	long
    //   90	128	14	l5	long
    //   100	152	16	l6	long
    //   155	214	18	l7	long
    //   136	227	22	localObject	Object
    //   10	103	23	localMsgHead	msg_comm.MsgHead
    //   379	11	24	localDecodeProtoPkgContext	DecodeProtoPkgContext
    // Exception table:
    //   from	to	target	type
    //   364	395	398	java/lang/Exception
  }
  
  private void a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, DecodeProtoPkgContext paramDecodeProtoPkgContext, BaseMessageHandler paramBaseMessageHandler)
  {
    Iterator localIterator = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().a().a().iterator();
    while (localIterator.hasNext()) {
      ((Decoder)localIterator.next()).a(paramBaseMessageHandler, paramMsg, paramArrayList, paramDecodeProtoPkgContext);
    }
  }
  
  private void a(msg_svc.PbGetOneDayRoamMsgResp paramPbGetOneDayRoamMsgResp, Bundle paramBundle, ArrayList<MessageRecord> paramArrayList, long paramLong, int paramInt)
  {
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("UIN", 0L);
      boolean bool3 = paramBundle.getBoolean("canUpdateEct", true);
      int i = paramPbGetOneDayRoamMsgResp.iscomplete.get();
      boolean bool2 = false;
      boolean bool1;
      if (i != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((paramInt == 0) || (paramInt == 1) || (paramInt == 4)) {
        bool2 = true;
      }
      if ((bool2) && (bool3))
      {
        if (bool1) {
          ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(String.valueOf(l), 0L, 0L);
        } else {
          ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(String.valueOf(paramPbGetOneDayRoamMsgResp.peer_uin.get()), paramPbGetOneDayRoamMsgResp.last_msgtime.get(), paramPbGetOneDayRoamMsgResp.random.get());
        }
      }
      else if (!bool3) {
        if (bool1)
        {
          paramBundle.putLong("tempEct", 0L);
          paramBundle.putLong("tempRandom", 0L);
        }
        else
        {
          paramBundle.putLong("tempEct", paramPbGetOneDayRoamMsgResp.last_msgtime.get());
          paramBundle.putLong("tempRandom", paramPbGetOneDayRoamMsgResp.random.get());
        }
      }
      paramBundle.putBoolean("complete", bool1);
      paramBundle.putBoolean("success", bool2);
      paramBundle.putLong("lowTime", paramLong);
      ArrayList localArrayList = new ArrayList();
      try
      {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).handleRefreshMessageListHeadResult(String.valueOf(paramPbGetOneDayRoamMsgResp.peer_uin.get()), 0, paramArrayList, localArrayList, paramBundle);
      }
      catch (Exception paramPbGetOneDayRoamMsgResp)
      {
        paramPbGetOneDayRoamMsgResp.printStackTrace();
      }
      if (paramArrayList != null) {
        jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(localArrayList, this);
      }
    }
  }
  
  private void a(msg_svc.PbSearchRoamMsgInCloudResp paramPbSearchRoamMsgInCloudResp, oidb_c2c_searcher.RspBody paramRspBody, int paramInt1, ToServiceMsg paramToServiceMsg, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    paramPbSearchRoamMsgInCloudResp = paramPbSearchRoamMsgInCloudResp.msg.get();
    if (paramPbSearchRoamMsgInCloudResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud pb error search result == null");
      }
    }
    else
    {
      ArrayList localArrayList2 = new ArrayList();
      a(paramPbSearchRoamMsgInCloudResp, localArrayList2);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      Object localObject = new DecodeProtoPkgContext(l, 0L, true, true, false, false);
      ((DecodeProtoPkgContext)localObject).h = true;
      ArrayList localArrayList1 = new ArrayList();
      a(localArrayList2, l, (DecodeProtoPkgContext)localObject, localArrayList1);
      if (localArrayList1.size() > 0) {
        Collections.sort(localArrayList1, new C2CMessageProcessor.4(this));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processSearchRoamMsgInCloud resultList size:");
        ((StringBuilder)localObject).append(paramPbSearchRoamMsgInCloudResp.size());
        ((StringBuilder)localObject).append(",outList size:");
        ((StringBuilder)localObject).append(localArrayList2.size());
        ((StringBuilder)localObject).append(",loopList size:");
        ((StringBuilder)localObject).append(localArrayList1.size());
        QLog.w("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if (paramRspBody.friends.has()) {
        paramPbSearchRoamMsgInCloudResp = paramRspBody.friends.get();
      } else {
        paramPbSearchRoamMsgInCloudResp = null;
      }
      if (paramPbSearchRoamMsgInCloudResp != null)
      {
        if (QLog.isColorLevel())
        {
          paramRspBody = new StringBuilder();
          paramRspBody.append("processSearchRoamMsgInCloud friendsInfo size:");
          paramRspBody.append(paramPbSearchRoamMsgInCloudResp.size());
          QLog.w("Q.msg.C2CMessageProcessor", 2, paramRspBody.toString());
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo == null");
      }
      int i = localArrayList1.size();
      boolean bool = false;
      if ((i == 0) && (paramInt1 != 1))
      {
        paramInt1 = paramToServiceMsg.extraData.getInt("retryIndex");
        if (paramInt1 < 4)
        {
          ((BaseMessageHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler("com.tencent.mobileqq.app.MessageHandler")).a(paramInt2, null, paramToServiceMsg.extraData.getString("keyword"), paramToServiceMsg.extraData.getLong("sequence"), paramPbSearchRoamMsgInCloudResp, paramInt1 + 1, 0L);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud retry extend 5 times, do not request again");
        }
        paramHashMap.put("SEARCHINFO", paramPbSearchRoamMsgInCloudResp);
        a(8015, false, paramHashMap);
        return;
      }
      paramHashMap.put("SEARCHINFO", paramPbSearchRoamMsgInCloudResp);
      paramHashMap.put("SEARCHRESULT", localArrayList1);
      if (paramInt1 == 1) {
        bool = true;
      }
      paramHashMap.put("SEARCHCOMPLETE", Boolean.valueOf(bool));
      a(8015, true, paramHashMap);
    }
  }
  
  private void a(boolean paramBoolean, String paramString, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      Collections.sort(paramArrayList, new C2CMessageProcessor.2(this));
      b(paramBoolean, paramString, paramArrayList);
      jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramArrayList, this);
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    MessageCache localMessageCache = (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        localMessageCache.b(paramArrayOfByte2);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(false);
        return;
      }
      localMessageCache.a(paramArrayOfByte1);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(false);
      return;
    }
    localMessageCache.a(paramArrayOfByte1);
    localMessageCache.b(paramArrayOfByte1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(false);
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramMessageRecord, this);
  }
  
  public static boolean a(StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, AppInterface paramAppInterface)
  {
    paramLong2 = ((MessageCache)paramAppInterface.getMsgCache()).a(String.valueOf(paramLong2), 0);
    if ((paramLong1 <= paramLong2) && (paramBoolean))
    {
      if (QLog.isColorLevel())
      {
        paramStringBuilder.setLength(0);
        paramStringBuilder.append("<---decodeC2CMessagePackage : msgList[");
        paramStringBuilder.append(paramInt);
        paramStringBuilder.append("] : filter msg by del time delTime =");
        paramStringBuilder.append(paramLong2);
        paramStringBuilder.append(", msgTime = ");
        paramStringBuilder.append(paramLong1);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  private byte[] a()
  {
    return jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(this);
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        a(4016, true, null);
        return;
      }
      a(4001, true, null);
      return;
    }
    a(4016, true, null);
    a(4001, true, null);
  }
  
  private void b(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      b((msg_comm.Msg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], (msg_onlinepush.PbPushMsg)paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isPullRoamMsg", true);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("needNofityConversation", true);
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("used_register_proxy", false);
    long l = System.currentTimeMillis();
    msg_svc.PbGetMsgResp localPbGetMsgResp = a((byte[])paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if ((localPbGetMsgResp != null) && (localPbGetMsgResp.result.has()) && (localPbGetMsgResp.result.get() == 0))
    {
      localObject = localPbGetMsgResp.uin_pair_msgs.get();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(0);
      int i;
      if (localPbGetMsgResp.sync_flag.has()) {
        i = localPbGetMsgResp.sync_flag.get();
      } else {
        i = 2;
      }
      byte b1;
      if (i < 2) {
        b1 = (byte)1;
      } else {
        b1 = 0;
      }
      if (localPbGetMsgResp.sync_cookie.has()) {
        paramFromServiceMsg = localPbGetMsgResp.sync_cookie.get().toByteArray();
      } else {
        paramFromServiceMsg = null;
      }
      int j = a(localPbGetMsgResp, paramFromServiceMsg);
      boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a();
      if (b1 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(b1, paramFromServiceMsg, i, bool1, bool2, bool4, null, j, null);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder.setLength(0);
        localStringBuilder.append("<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:");
        localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
        localStringBuilder.append(" msgStruct.cReplyCode: ");
        localStringBuilder.append(localPbGetMsgResp.result.get());
        localStringBuilder.append(" hasSyncCookie:");
        localStringBuilder.append(localPbGetMsgResp.sync_cookie.has());
        localStringBuilder.append(" channelType:");
        localStringBuilder.append(b1);
        localStringBuilder.append(" cSyncFlag:");
        localStringBuilder.append(i);
        localStringBuilder.append(" isPullRoam");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",needNofityConversation:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(" uinPairMsg size:");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append(", dataHash=@");
        localStringBuilder.append(Integer.toHexString(paramObject.hashCode()));
        localStringBuilder.append("pullMsgType");
        localStringBuilder.append(j);
        QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
      l = a(b1, bool1, bool3, l, localStringBuilder, (List)localObject, j);
      a(b1, bool1, j);
      l = System.currentTimeMillis() - l;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("decodecMsg costTime = [");
        paramToServiceMsg.append(l);
        paramToServiceMsg.append("]");
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramToServiceMsg.toString());
      }
      a(l);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" msgStruct.cReplyCode: ");
      localObject = "null";
      if (localPbGetMsgResp == null) {
        paramObject = "null";
      } else {
        paramObject = Integer.valueOf(localPbGetMsgResp.result.get());
      }
      localStringBuilder.append(paramObject);
      localStringBuilder.append(",hasSyncCookie:");
      if (localPbGetMsgResp == null) {
        paramObject = localObject;
      } else {
        paramObject = Boolean.valueOf(localPbGetMsgResp.sync_cookie.has());
      }
      localStringBuilder.append(paramObject);
      localStringBuilder.append(",isPullRoam:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",needNofityConversation:");
      localStringBuilder.append(bool2);
      QLog.e("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(String paramString, int paramInt)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramString, paramInt);
  }
  
  private void b(String paramString, int paramInt, long paramLong)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramString, paramInt, paramLong, this);
  }
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramArrayList, this);
  }
  
  private void b(List<msg_comm.Msg> paramList)
  {
    long l = ((msg_comm.MsgHead)((msg_comm.Msg)paramList.get(0)).msg_head.get()).from_uin.get();
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(l, this);
  }
  
  private void b(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
      return;
    }
    long l1 = localMsgHead.c2c_cmd.get();
    long l2 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.to_uin.get();
    long l4 = localMsgHead.msg_seq.get();
    long l5 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i = localMsgHead.user_active.get();
    int j = localMsgHead.from_instid.get();
    Object localObject1;
    if (paramFromServiceMsg.getUin() == null) {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    } else {
      localObject1 = paramFromServiceMsg.getUin();
    }
    C2CMessageProcessor localC2CMessageProcessor = this;
    long l7 = Long.valueOf((String)localObject1).longValue();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---handleMsgPush_PB_SlaveMaster:fromUin:");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(",toUin:");
      ((StringBuilder)localObject1).append(l3);
      ((StringBuilder)localObject1).append(",msgTime:");
      ((StringBuilder)localObject1).append(l5);
      ((StringBuilder)localObject1).append(",msgSeq:");
      ((StringBuilder)localObject1).append(l4);
      ((StringBuilder)localObject1).append(",msgUid:");
      ((StringBuilder)localObject1).append(l6);
      ((StringBuilder)localObject1).append(",userActive:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",fromInstid:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",hasAppShare:");
      ((StringBuilder)localObject1).append(paramMsg.appshare_info.has());
      ((StringBuilder)localObject1).append(",hasMsgBody:");
      ((StringBuilder)localObject1).append(paramMsg.msg_body.has());
      QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    localC2CMessageProcessor.a(i);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2;
    try
    {
      localObject1 = new DecodeProtoPkgContext(l7, l3, true, false, false, false);
      ((DecodeProtoPkgContext)localObject1).h = true;
      localObject1 = localC2CMessageProcessor.a(paramMsg, (PBDecodeContext)localObject1);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException);
      }
      localObject2 = null;
    }
    localC2CMessageProcessor.a((List)localObject2);
    if (localObject2 != null)
    {
      if (((List)localObject2).size() == 0) {
        return;
      }
      localC2CMessageProcessor.a((List)localObject2, localArrayList1, true);
      localObject2 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramMsg = new C2CMessageProcessor.ProcessMsgPushPBSlaveMaster(this, paramMsg, localArrayList1, false, null, (ArrayList)localObject2, localArrayList2).a();
      boolean bool = paramMsg.jdField_a_of_type_Boolean;
      paramMsg = paramMsg.jdField_a_of_type_JavaLangString;
      ((MessageCache)localC2CMessageProcessor.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(localArrayList2);
      ((IMessageFacade)localC2CMessageProcessor.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(localArrayList2, String.valueOf(l7), false);
      ((MessageCache)localC2CMessageProcessor.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(localMsgHead.msg_seq.get());
      i = paramFromServiceMsg.getRequestSsoSeq();
      localC2CMessageProcessor.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l2, (ArrayList)localObject2, paramPbPushMsg.svrip.get(), i, null);
      if (l1 == 127L) {
        return;
      }
      a("handleMsgPush_PB_SlaveMaster", true, 0, localC2CMessageProcessor.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(false), false);
      jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(localArrayList2, localC2CMessageProcessor);
      if ((bool) && (!TextUtils.isEmpty(paramMsg))) {
        localC2CMessageProcessor.a(paramMsg);
      }
    }
  }
  
  private void b(boolean paramBoolean, String paramString, ArrayList<MessageRecord> paramArrayList)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramArrayList, paramString, paramBoolean, this);
  }
  
  private void c(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      d((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    Long localLong = null;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (OutOfMemoryError paramObject)
    {
      paramFromServiceMsg = localLong;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramObject);
        paramFromServiceMsg = localLong;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramFromServiceMsg = localLong;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramObject);
        paramFromServiceMsg = localLong;
      }
    }
    localLong = Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime"));
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("fetchMore");
    int i = paramToServiceMsg.extraData.getInt("fetchNum");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("notify", true);
    paramObject = new Bundle();
    paramObject.putLong("BEGTIME", localLong.longValue());
    paramObject.putBoolean("FETCH_MORE", bool1);
    paramObject.putInt("MSG_COUNT", i);
    paramObject.putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
    paramObject.putBoolean("IS_PRELOAD_TYPE", bool2);
    if (paramFromServiceMsg != null)
    {
      String str = String.valueOf(paramFromServiceMsg.peer_uin.get());
      int j = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a.remove(str);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handlePBGetRoamMsg code=");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(", msgList is null !");
          QLog.w("Q.msg.C2CMessageProcessor", 2, paramToServiceMsg.toString());
        }
        a(1004, false, paramObject);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      a((List)localObject, localArrayList);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePBGetRoamMsg begTime: ");
        ((StringBuilder)localObject).append(localLong);
        ((StringBuilder)localObject).append(", code=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" ,errMsg=");
        ((StringBuilder)localObject).append(paramFromServiceMsg.errmsg.get());
        ((StringBuilder)localObject).append(", msgList.size()=");
        ((StringBuilder)localObject).append(localArrayList.size());
        ((StringBuilder)localObject).append(",peerUin=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",time=");
        ((StringBuilder)localObject).append(paramFromServiceMsg.last_msgtime.get());
        ((StringBuilder)localObject).append(",fetchMore:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(",fetchNum: ");
        ((StringBuilder)localObject).append(i);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      a(paramToServiceMsg, paramFromServiceMsg, localLong, i, bool2, bool3, paramObject, str, j, localArrayList);
      return;
    }
    a(1004, false, paramObject);
  }
  
  private void c(ArrayList<MessageRecord> paramArrayList)
  {
    jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.b(paramArrayList, this);
  }
  
  private void d(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      e((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      paramFromServiceMsg = null;
    }
    paramObject = paramToServiceMsg.extraData.getBundle("context");
    if (paramFromServiceMsg != null)
    {
      int i = paramFromServiceMsg.result.get();
      paramToServiceMsg = paramFromServiceMsg.msg.get();
      ArrayList localArrayList = new ArrayList();
      a(paramToServiceMsg, localArrayList);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handlePBGetRoamMsgInOneDay code=");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(", complete=");
        paramToServiceMsg.append(paramFromServiceMsg.iscomplete.get());
        paramToServiceMsg.append(" ,respRandom:");
        paramToServiceMsg.append(paramFromServiceMsg.random.get());
        paramToServiceMsg.append(", lastMsgTime:");
        paramToServiceMsg.append(paramFromServiceMsg.last_msgtime.get());
        paramToServiceMsg.append(", msgList.size()=");
        paramToServiceMsg.append(localArrayList.size());
        paramToServiceMsg.append(", context");
        paramToServiceMsg.append(paramObject);
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramToServiceMsg.toString());
      }
      long l;
      if (i == 0)
      {
        paramToServiceMsg = new ArrayList();
        try
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramFromServiceMsg.peer_uin.get());
          ((StringBuilder)localObject1).append("");
          localObject1 = a(((StringBuilder)localObject1).toString(), localArrayList);
          if (localObject1 != null) {
            paramToServiceMsg.addAll((Collection)localObject1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException);
          }
        }
        l = paramFromServiceMsg.peer_uin.get();
        if (!localArrayList.isEmpty())
        {
          localObject2 = (msg_comm.Msg)localArrayList.get(0);
          l = a(((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        Object localObject2 = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()), l, true, true, false, false);
        ((DecodeProtoPkgContext)localObject2).h = true;
        a(localArrayList, null, paramToServiceMsg, (DecodeProtoPkgContext)localObject2);
        if (paramToServiceMsg.size() > 0)
        {
          Collections.sort(paramToServiceMsg, new C2CMessageProcessor.3(this));
          l = ((MessageRecord)paramToServiceMsg.get(0)).time;
        }
        else
        {
          paramToServiceMsg = null;
          l = 0L;
        }
      }
      else
      {
        if ((i == 1) && (QLog.isColorLevel())) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
        }
        paramToServiceMsg = null;
        l = 0L;
      }
      a(paramFromServiceMsg, paramObject, paramToServiceMsg, l, i);
    }
  }
  
  private void e(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      c((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("loadType");
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    localHashMap.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    localHashMap.put("LOADTYPE", Integer.valueOf(i));
    Object localObject = new msg_svc.PbSearchRoamMsgInCloudResp();
    try
    {
      paramObject = (msg_svc.PbSearchRoamMsgInCloudResp)((msg_svc.PbSearchRoamMsgInCloudResp)localObject).mergeFrom((byte[])paramObject);
    }
    catch (OutOfMemoryError paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud OutOfMemoryError ! ", paramObject);
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud InvalidProtocolBufferMicroException ! ", paramObject);
      }
    }
    paramObject = null;
    if (paramObject != null)
    {
      localObject = a(paramObject, new oidb_c2c_searcher.RspBody());
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "<----processSearchRoamMsgInCloud error oidb_search null----> ");
        }
        a(paramToServiceMsg, paramFromServiceMsg, false);
        return;
      }
      int j = ((oidb_c2c_searcher.RspBody)localObject).result.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processSearchRoamMsgInCloud result--------->>>>>> ");
        localStringBuilder.append(j);
        localStringBuilder.append(", loadType: ");
        localStringBuilder.append(i);
        QLog.w("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
      if ((j != 0) && (j != 1))
      {
        a(paramToServiceMsg, paramFromServiceMsg, false);
        return;
      }
      a(paramObject, (oidb_c2c_searcher.RspBody)localObject, j, paramToServiceMsg, i, localHashMap);
    }
  }
  
  private void f(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      b((ToServiceMsg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  private void g(int paramInt, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      a((msg_comm.Msg)paramArrayOfObject[0], (FromServiceMsg)paramArrayOfObject[1], (msg_onlinepush.PbPushMsg)paramArrayOfObject[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public Decoder a(int paramInt)
  {
    return ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().a(paramInt);
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    paramMsg = new StringBuilder(64);
    paramMsg.append("key_uid_");
    paramMsg.append(l1);
    paramMsg.append("_seq_");
    paramMsg.append(l2);
    return paramMsg.toString();
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    if (!(paramPBDecodeContext instanceof DecodeProtoPkgContext)) {
      return new ArrayList();
    }
    Object localObject1 = (DecodeProtoPkgContext)paramPBDecodeContext;
    long l2 = System.currentTimeMillis();
    paramPBDecodeContext = new ArrayList();
    Object localObject2;
    if ((paramMsg != null) && (paramMsg.msg_head.has()) && (paramMsg.msg_body.has()))
    {
      localObject2 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      int m = (short)((msg_comm.MsgHead)localObject2).msg_seq.get();
      long l3 = ((msg_comm.MsgHead)localObject2).to_uin.get();
      long l4 = ((msg_comm.MsgHead)localObject2).from_uin.get();
      long l5 = ((msg_comm.MsgHead)localObject2).msg_time.get();
      long l6 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
      int n = ((msg_comm.MsgHead)localObject2).msg_type.get();
      int i1 = paramMsg.msg_head.c2c_cmd.get();
      ((DecodeProtoPkgContext)localObject1).jdField_c_of_type_Int = 0;
      ((DecodeProtoPkgContext)localObject1).jdField_d_of_type_Int = 0;
      int j;
      int i;
      int k;
      if (paramMsg.content_head.has())
      {
        localObject3 = (msg_comm.ContentHead)paramMsg.content_head.get();
        j = ((msg_comm.ContentHead)localObject3).div_seq.get();
        i = ((msg_comm.ContentHead)localObject3).pkg_num.get();
        k = ((msg_comm.ContentHead)localObject3).pkg_index.get();
      }
      else
      {
        i = 0;
        j = 0;
        k = 0;
      }
      long l1 = -1L;
      if (!((DecodeProtoPkgContext)localObject1).jdField_d_of_type_Boolean) {
        l1 = DecodeC2CMsgPkgBubbleID.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler, paramMsg, String.valueOf(((DecodeProtoPkgContext)localObject1).g), String.valueOf(l4));
      }
      ((DecodeProtoPkgContext)localObject1).jdField_b_of_type_Long = l4;
      ((DecodeProtoPkgContext)localObject1).jdField_c_of_type_Long = l5;
      int i2 = DecodeC2CMsgPkgBubbleID.a(paramMsg);
      ((DecodeProtoPkgContext)localObject1).jdField_a_of_type_Int = i2;
      ((DecodeProtoPkgContext)localObject1).jdField_d_of_type_Long = a((int)l1, i2);
      ((DecodeProtoPkgContext)localObject1).jdField_b_of_type_Int = DecodeC2CMsgPkgBubbleID.b(paramMsg);
      if (l4 == ((DecodeProtoPkgContext)localObject1).jdField_a_of_type_Long)
      {
        ((DecodeProtoPkgContext)localObject1).jdField_a_of_type_Boolean = true;
        ((DecodeProtoPkgContext)localObject1).f = true;
      }
      else
      {
        ((DecodeProtoPkgContext)localObject1).f = false;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:");
        ((StringBuilder)localObject3).append(l5);
        ((StringBuilder)localObject3).append(" shortSeq:");
        ((StringBuilder)localObject3).append(m);
        ((StringBuilder)localObject3).append(" uint32Seq:");
        ((StringBuilder)localObject3).append(((msg_comm.MsgHead)localObject2).msg_seq.get());
        ((StringBuilder)localObject3).append(" msgUid:");
        ((StringBuilder)localObject3).append(l6);
        ((StringBuilder)localObject3).append(" toUin:");
        ((StringBuilder)localObject3).append(l3);
        ((StringBuilder)localObject3).append(" senderUin:");
        ((StringBuilder)localObject3).append(l4);
        ((StringBuilder)localObject3).append(" friendUin:");
        ((StringBuilder)localObject3).append(((DecodeProtoPkgContext)localObject1).g);
        ((StringBuilder)localObject3).append(" isReaded:");
        ((StringBuilder)localObject3).append(((DecodeProtoPkgContext)localObject1).jdField_a_of_type_Boolean);
        ((StringBuilder)localObject3).append(" isSyncFromOtherTerm:");
        ((StringBuilder)localObject3).append(((DecodeProtoPkgContext)localObject1).f);
        ((StringBuilder)localObject3).append(" msgType:0x");
        ((StringBuilder)localObject3).append(Integer.toHexString(n));
        ((StringBuilder)localObject3).append(" c2CCmd:0x");
        ((StringBuilder)localObject3).append(Integer.toHexString(i1));
        ((StringBuilder)localObject3).append(" hasTemp:");
        ((StringBuilder)localObject3).append(((msg_comm.MsgHead)localObject2).c2c_tmp_msg_head.has());
        ((StringBuilder)localObject3).append(" hasShare:");
        ((StringBuilder)localObject3).append(paramMsg.appshare_info.has());
        ((StringBuilder)localObject3).append(" pkgID:");
        ((StringBuilder)localObject3).append(l1);
        ((StringBuilder)localObject3).append(" longMsgID:");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(" longMsgCount:");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(" longMsgIndex:");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append("init_direction_flag");
        ((StringBuilder)localObject3).append(((DecodeProtoPkgContext)localObject1).jdField_d_of_type_Int);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject3).toString());
      }
      else if (((DecodeProtoPkgContext)localObject1).g == 0L)
      {
        QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
      }
      Object localObject3 = new ArrayList();
      a(n, paramMsg, (ArrayList)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler, (DecodeProtoPkgContext)localObject1);
      a(paramMsg, (ArrayList)localObject3, (DecodeProtoPkgContext)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler);
      jdField_a_of_type_ComTencentImcoreMessageC2CMessageProcessor$Callback.a(paramMsg, (DecodeProtoPkgContext)localObject1, l2, paramPBDecodeContext, (msg_comm.MsgHead)localObject2, m, l4, l6, n, l4, j, i, k, (ArrayList)localObject3, this);
      return paramPBDecodeContext;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeSinglePBMsg_C2C return : ");
      if (paramMsg == null)
      {
        paramMsg = " msg=null";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" msg.msg_head:");
        ((StringBuilder)localObject2).append(paramMsg.msg_head);
        ((StringBuilder)localObject2).append(" msg.msg_body:");
        ((StringBuilder)localObject2).append(paramMsg.msg_body.has());
        paramMsg = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject1).append(paramMsg);
      QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    return paramPBDecodeContext;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramInt != 2001)
    {
      if (paramInt != 2005) {
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg, false);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processType");
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
    if (paramInt != 2001)
    {
      if (paramInt != 2003)
      {
        if (paramInt != 2005)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 1003: 
            c(paramInt, paramVarArgs);
            return;
          case 1002: 
            f(paramInt, paramVarArgs);
            return;
          }
          g(paramInt, paramVarArgs);
          return;
        }
        d(paramInt, paramVarArgs);
        return;
      }
      b(paramInt, paramVarArgs);
      return;
    }
    e(paramInt, paramVarArgs);
  }
  
  public void a(C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    String str = String.valueOf(paramC2CMsgReadedNotify.lPeerUin);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processPushReadedNotify is called. uAioType = ");
      localStringBuilder.append(paramC2CMsgReadedNotify.uAioType);
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
    if (paramC2CMsgReadedNotify.uAioType == 3L)
    {
      a(paramC2CMsgReadedNotify, str);
      return;
    }
    ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom(str, 0, paramC2CMsgReadedNotify.lLastReadTime);
    if (paramC2CMsgReadedNotify.lLastReadTime >= 0L) {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeNotification(str, 0);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    if (!UinTypeUtil.b(paramInt)) {
      return;
    }
    if (paramLong == 0L) {
      return;
    }
    b(paramString, paramInt, paramLong);
  }
  
  public void a(ArrayList<Pair<Long, Long>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("-ReportList-");
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Pair localPair = (Pair)paramArrayList.next();
        msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        localUinPairReadInfo.peer_uin.set(((Long)localPair.first).longValue());
        localUinPairReadInfo.last_read_time.set(((Long)localPair.second).intValue());
        localStringBuilder.append("-uin:");
        localStringBuilder.append(localPair.first);
        localStringBuilder.append("-ReadTime-");
        localStringBuilder.append(localPair.second);
        localPbC2CReadedReportReq.pair_info.add(localUinPairReadInfo);
      }
      paramArrayList = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a();
      if (paramArrayList != null) {
        localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
      }
      localPbMsgReadedReportReq.c2c_read_report.set(localPbC2CReadedReportReq);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("<ReadReport><S>_C2C:");
        paramArrayList.append(localStringBuilder.toString());
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramArrayList.toString());
      }
      a(localPbMsgReadedReportReq);
    }
  }
  
  public boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    boolean bool2 = false;
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    do
    {
      bool1 = bool2;
      if (!paramArrayList.hasNext()) {
        break;
      }
    } while (!a((MessageRecord)paramArrayList.next()));
    boolean bool1 = true;
    return bool1;
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramInt != 2001)
    {
      if (paramInt != 2005) {
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg, true);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor
 * JD-Core Version:    0.7.0.1
 */
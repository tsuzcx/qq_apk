package com.tencent.mobileqq.app;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.Msg;
import msf.msgsvc.msg_svc.PbSearchRoamMsgInCloudReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;
import tencent.im.oidb.searcher.oidb_c2c_searcher.MsgKey;
import tencent.im.oidb.searcher.oidb_c2c_searcher.ReqBody;

public class BaseMessageHandler
  extends BusinessHandler
{
  protected final int a;
  public RegisterProxyHandler a;
  public final HashMap<String, List<msg_comm.Msg>> a;
  protected Map<String, BaseMessageProcessor> a;
  protected final int b;
  protected final HashMap<Long, SendMessageHandler> b;
  private final int c = 450000;
  
  protected BaseMessageHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Int = 9;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppHandlerRegisterProxyHandler = new RegisterProxyHandler(this);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static String a(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)))
    {
      if (paramFromServiceMsg.getAttribute("_tag_socket") != null) {
        return "timeout_reason_SERVER_NO_RESPONSE";
      }
      return (String)paramFromServiceMsg.getAttribute("_tag_socket_connerror", String.valueOf(paramFromServiceMsg.getResultCode()));
    }
    return null;
  }
  
  public static String[] a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String[] arrayOfString = new String[7];
      long l2 = paramToServiceMsg.extraData.getLong("startTime", 0L);
      long l7 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
      long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
      long l9 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
      long l4 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
      long l5 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
      long l3 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
      long l8 = System.currentTimeMillis();
      arrayOfString[1] = String.valueOf(l8 - l2);
      arrayOfString[2] = String.valueOf(l4 - l9);
      arrayOfString[3] = String.valueOf(l9 - l2);
      arrayOfString[4] = String.valueOf(l8 - l4);
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handler");
      long l1 = l2;
      if (l7 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l7 - l2));
        paramToServiceMsg.append("|app");
        l1 = l7;
      }
      l2 = l1;
      if (l6 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l6 - l1));
        paramToServiceMsg.append("|msf");
        l2 = l6;
      }
      if (l9 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l9 - l2));
        paramToServiceMsg.append("|net");
      }
      arrayOfString[5] = paramToServiceMsg.toString();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("net");
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l5 - l4));
        paramToServiceMsg.append("|msf");
        l1 = l5;
      }
      else
      {
        l1 = l4;
      }
      l2 = l1;
      if (l3 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l3 - l1));
        paramToServiceMsg.append("|app");
        l2 = l3;
      }
      paramToServiceMsg.append("|");
      paramToServiceMsg.append(String.valueOf(l8 - l2));
      paramToServiceMsg.append("|handler");
      arrayOfString[6] = paramToServiceMsg.toString();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("{");
      paramToServiceMsg.append("total:");
      paramToServiceMsg.append(arrayOfString[1]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("net:");
      paramToServiceMsg.append(arrayOfString[2]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("send:");
      paramToServiceMsg.append(arrayOfString[3]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("recv:");
      paramToServiceMsg.append(arrayOfString[4]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("sendDetail:");
      paramToServiceMsg.append(arrayOfString[5]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("recvDetail:");
      paramToServiceMsg.append(arrayOfString[6]);
      paramToServiceMsg.append("}");
      arrayOfString[0] = paramToServiceMsg.toString();
      return arrayOfString;
    }
    return null;
  }
  
  protected int a(SendMessageHandler paramSendMessageHandler)
  {
    int i;
    do
    {
      i = MobileQQServiceBase.seq;
      MobileQQServiceBase.seq = i + 1;
    } while (!a(i, paramSendMessageHandler));
    return i;
  }
  
  public AppInterface a()
  {
    return this.appRuntime;
  }
  
  public BaseMessageProcessor a(String paramString)
  {
    return null;
  }
  
  public EntityManager a()
  {
    return null;
  }
  
  public SendMessageHandler a(long paramLong)
  {
    return (SendMessageHandler)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public Object a(String paramString, int paramInt)
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  protected void a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((SendMessageHandler)localEntry.getValue()).a();
        }
      }
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(byte paramByte, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt2, Object paramObject) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, List<String> paramList, String paramString, long paramLong1, List<oidb_c2c_searcher.Iterator> paramList1, int paramInt2, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("PbMessageSvc.PbSearchRoamMsgInCloud");
    localToServiceMsg.setTimeout(5000L);
    localToServiceMsg.extraData.putString("keyword", paramString);
    localToServiceMsg.extraData.putLong("sequence", paramLong1);
    localToServiceMsg.extraData.putInt("retryIndex", paramInt2);
    localToServiceMsg.extraData.putInt("loadType", paramInt1);
    msg_svc.PbSearchRoamMsgInCloudReq localPbSearchRoamMsgInCloudReq = new msg_svc.PbSearchRoamMsgInCloudReq();
    oidb_c2c_searcher.ReqBody localReqBody = new oidb_c2c_searcher.ReqBody();
    localReqBody.query.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.max_cnt.set(20);
    localReqBody.type.set(1);
    ArrayList localArrayList = new ArrayList();
    paramInt1 = 0;
    Object localObject2 = "MessageHandler";
    Object localObject1;
    if (paramList1 == null)
    {
      localObject1 = localObject2;
      if (paramList != null)
      {
        paramList1 = (List<oidb_c2c_searcher.Iterator>)localObject2;
        for (;;)
        {
          localObject1 = paramList1;
          if (paramInt1 >= paramList.size()) {
            break;
          }
          localObject1 = new oidb_c2c_searcher.Iterator();
          localObject2 = new oidb_c2c_searcher.MsgKey();
          if (paramLong2 != 0L) {
            ((oidb_c2c_searcher.MsgKey)localObject2).time.set(paramLong2);
          } else {
            ((oidb_c2c_searcher.MsgKey)localObject2).time.set(NetConnInfoCenter.getServerTime());
          }
          ((oidb_c2c_searcher.Iterator)localObject1).key.set((MessageMicro)localObject2);
          ((oidb_c2c_searcher.Iterator)localObject1).uin.set(Long.parseLong((String)paramList.get(paramInt1)));
          localArrayList.add(localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("--->>searchRoamMsgInCloud friendUin: ");
            ((StringBuilder)localObject2).append((String)paramList.get(paramInt1));
            ((StringBuilder)localObject2).append(" beginTime: ");
            ((StringBuilder)localObject2).append(((oidb_c2c_searcher.Iterator)localObject1).key.time.get());
            ((StringBuilder)localObject2).append(", searchkey: ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(",lastDatelineTime:");
            ((StringBuilder)localObject2).append(paramLong2);
            QLog.d(paramList1, 2, ((StringBuilder)localObject2).toString());
          }
          paramInt1 += 1;
        }
      }
    }
    else
    {
      localObject1 = "MessageHandler";
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("--->>searchRoamMsgInCloud  beginTime: ");
        paramList.append(((oidb_c2c_searcher.Iterator)paramList1.get(0)).key.time.get());
        paramList.append(", searchkey: ");
        paramList.append(paramString);
        paramList.append(",retryIndex");
        paramList.append(paramInt2);
        QLog.d((String)localObject1, 2, paramList.toString());
      }
      localArrayList.addAll(paramList1);
    }
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d((String)localObject1, 2, "--->>searchRoamMsgInCloud listSize 0: it should not happen, check why");
      }
      return;
    }
    localReqBody.friends.set(localArrayList);
    localReqBody.set(localReqBody);
    localPbSearchRoamMsgInCloudReq.serialize_reqbody.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(localPbSearchRoamMsgInCloudReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeSendMessageHandler msgseq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramLong);
    if (localObject != null)
    {
      ((SendMessageHandler)localObject).a();
      a(paramLong);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, null, 1, DeviceInfoUtil.a());
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    a(paramLong, paramInt1, paramInt2, paramPbPushMsg, 1, DeviceInfoUtil.a());
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg, int paramInt3, DeviceInfo paramDeviceInfo)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
    localToServiceMsg.extraData.putInt("svrip", paramInt1);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    localToServiceMsg.extraData.putLong("lUin", paramLong);
    if (paramInt3 != -1) {
      localToServiceMsg.extraData.putInt("service_type", paramInt3);
    }
    if (paramDeviceInfo != null) {
      localToServiceMsg.extraData.putSerializable("deviceInfo", paramDeviceInfo);
    }
    if ((paramPbPushMsg != null) && (paramPbPushMsg.bytes_push_token.has())) {
      localToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[])paramPbPushMsg.bytes_push_token.get().toByteArray().clone());
    }
    localToServiceMsg.setNeedCallback(false);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, ArrayList<DelMsgInfo> paramArrayList, int paramInt1, int paramInt2, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OnlinePush.RespPush");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localToServiceMsg.extraData.putSerializable("delMsgInfos", paramArrayList);
      localToServiceMsg.extraData.putInt("svrip", paramInt1);
      localToServiceMsg.extraData.putInt("seq", paramInt2);
      localToServiceMsg.extraData.putLong("lUin", paramLong);
      if ((paramPbPushMsg != null) && (paramPbPushMsg.bytes_push_token.has())) {
        localToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[])paramPbPushMsg.bytes_push_token.get().toByteArray().clone());
      }
      localToServiceMsg.setNeedCallback(false);
      send(localToServiceMsg);
    }
  }
  
  public void a(Message paramMessage, boolean paramBoolean) {}
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2) {}
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (!paramToServiceMsg.extraData.containsKey("msgSeq"))
      {
        QLog.e("MessageHandler", 1, "no msgSeq");
        return;
      }
      long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      long l2 = paramFromServiceMsg.getResultCode();
      long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 9223372036854775807L);
      SendMessageHandler localSendMessageHandler = a(l1);
      if (localSendMessageHandler != null)
      {
        paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<---TimeConsume---> cmd[");
          localStringBuilder.append(paramToServiceMsg.getServiceCmd());
          localStringBuilder.append("] seq[");
          localStringBuilder.append(l1);
          localStringBuilder.append("] retryIndex[");
          localStringBuilder.append(i);
          localStringBuilder.append("] ");
          localStringBuilder.append(paramFromServiceMsg[0]);
          localStringBuilder.append("");
          QLog.d("MessageHandler", 2, localStringBuilder.toString());
        }
        localSendMessageHandler.a(i, l2, l3, paramFromServiceMsg);
        return;
      }
      QLog.e("MessageHandler", 1, "can not found handler");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "req or resp is null");
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      BaseMessageProcessor localBaseMessageProcessor = (BaseMessageProcessor)localIterator.next();
      if (localBaseMessageProcessor != null) {
        localBaseMessageProcessor.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void a(Long paramLong) {}
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, short paramShort, long paramLong4, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(ProcessorDispatcher.a(paramString)).a(ProcessorDispatcher.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  protected void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (ProcessorDispatcher.a().containsKey(paramString)) {
      a(ProcessorDispatcher.a(paramString)).a(ProcessorDispatcher.a(paramString), new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
      {
        this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
  }
  
  public boolean a(long paramLong, SendMessageHandler paramSendMessageHandler)
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramSendMessageHandler);
        paramSendMessageHandler.a = paramLong;
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = new StringBuilder();
        paramSendMessageHandler.append("sendQueue alread has msgSeq[");
        paramSendMessageHandler.append(paramLong);
        paramSendMessageHandler.append("]");
        QLog.e("MessageHandler", 2, paramSendMessageHandler.toString());
      }
      return false;
    }
  }
  
  public boolean a(SendMessageHandler paramSendMessageHandler, String paramString)
  {
    long l = paramSendMessageHandler.a(System.currentTimeMillis());
    boolean bool1;
    if (l < 450000L)
    {
      l = 480000L - l - 5000L;
      boolean bool2 = paramSendMessageHandler.a(0L, l, paramString);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<<<---retrySendMessage scheduleSuccess[");
        localStringBuilder.append(bool2);
        localStringBuilder.append("] msgSeq[");
        localStringBuilder.append(paramSendMessageHandler.a);
        localStringBuilder.append("] timeout[");
        localStringBuilder.append(l);
        localStringBuilder.append("] reason[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.d("MessageHandler", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if ((!bool1) && (paramSendMessageHandler.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageHandler", 2, "<<<---retrySendMessage No unfinished retry attampt.");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "<<<---retrySendMessage Wait SendMessage Retry");
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, null, -1, null);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void b(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(ProcessorDispatcher.a(paramString)).b(ProcessorDispatcher.a(paramString), paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BaseMessageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseMessageHandler
 * JD-Core Version:    0.7.0.1
 */
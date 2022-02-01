package com.tencent.av.business.handler;

import com.tencent.av.common.ErrorInfo;
import com.tencent.av.utils.SeqUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

public class MessageHandler
  extends BusinessHandler
{
  static volatile long jdField_a_of_type_Long = 1L;
  static Object jdField_a_of_type_JavaLangObject = new Object();
  static volatile HashMap<Long, MessageHandler.MsgListener> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public MessageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a(common.ErrorInfo paramErrorInfo)
  {
    if ((paramErrorInfo.has()) && (paramErrorInfo.uint32_errcode.has())) {
      return paramErrorInfo.uint32_errcode.get();
    }
    return -99;
  }
  
  static long a()
  {
    try
    {
      jdField_a_of_type_Long += 1L;
      long l = jdField_a_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static MessageHandler.MsgListener a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageHandler.MsgListener localMsgListener = (MessageHandler.MsgListener)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      return localMsgListener;
    }
  }
  
  public static String a(common.ErrorInfo paramErrorInfo)
  {
    if ((paramErrorInfo.has()) && (paramErrorInfo.bytes_errmsg.has())) {
      return paramErrorInfo.bytes_errmsg.get().toStringUtf8();
    }
    return "";
  }
  
  static void a(long paramLong, MessageHandler.MsgListener paramMsgListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramMsgListener);
      return;
    }
  }
  
  public static void a(long paramLong, AppInterface paramAppInterface, String paramString, MessageMicro paramMessageMicro, MessageHandler.MsgListener paramMsgListener)
  {
    MessageHandler localMessageHandler = (MessageHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.QAV_HANDLER);
    paramAppInterface = new ToServiceMsg("", paramAppInterface.getCurrentAccountUin(), paramString);
    SeqUtil.a(paramAppInterface.getAttributes(), paramLong);
    long l = a();
    paramAppInterface.getAttributes().put("msgSeq_for_callback", Long.valueOf(l));
    a(l, paramMsgListener);
    paramAppInterface.putWupBuffer(paramMessageMicro.toByteArray());
    localMessageHandler.sendPbReq(paramAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVMessageHandler", 1, "sendMsg, msgListener[" + paramMsgListener + "], msgSeq_for_callback[" + l + "], seq[" + paramLong + "]");
    }
  }
  
  private static MessageHandler.ClassInfo b(MessageHandler.MsgListener paramMsgListener)
  {
    paramMsgListener = paramMsgListener.getClass().getGenericSuperclass();
    Object localObject;
    String str;
    if (paramMsgListener != null) {
      if ((paramMsgListener instanceof ParameterizedType))
      {
        localObject = ((ParameterizedType)paramMsgListener).getActualTypeArguments();
        if (localObject != null) {
          if (localObject.length == 2)
          {
            paramMsgListener = (Class)localObject[0];
            localObject = (Class)localObject[1];
            str = "reqType[" + paramMsgListener + "]rspType[" + localObject + "]";
          }
        }
      }
    }
    while (((paramMsgListener == null) || (localObject == null)) && (AudioHelper.d()))
    {
      throw new IllegalArgumentException("QAVMessageHandler get getClassInfo失败, " + str);
      str = "ActualTypeArguments长度为" + localObject.length;
      localObject = null;
      paramMsgListener = null;
      continue;
      localObject = null;
      str = "getActualTypeArguments为空";
      paramMsgListener = null;
      continue;
      str = "type[" + paramMsgListener.getClass().getName() + "]";
      localObject = null;
      paramMsgListener = null;
      continue;
      str = "genericInterfaces为空";
      localObject = null;
      paramMsgListener = null;
    }
    MessageHandler.ClassInfo localClassInfo = new MessageHandler.ClassInfo(null);
    localClassInfo.jdField_a_of_type_JavaLangString = str;
    localClassInfo.jdField_a_of_type_JavaLangClass = paramMsgListener;
    localClassInfo.b = ((Class)localObject);
    return localClassInfo;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return MessageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l2 = SeqUtil.a(paramToServiceMsg.getAttributes());
    long l1 = 0L;
    Object localObject = paramToServiceMsg.getAttribute("msgSeq_for_callback");
    if ((localObject instanceof Integer)) {
      l1 = ((Integer)localObject).intValue();
    }
    for (;;)
    {
      localObject = a(l1);
      if (QLog.isColorLevel()) {
        QLog.w("QAVMessageHandler", 1, "onReceive, cmd[" + str + "], req_cmd[" + paramToServiceMsg.getServiceCmd() + "], isSuccess[" + paramFromServiceMsg.isSuccess() + "], RequestSsoSeq[" + paramToServiceMsg.getRequestSsoSeq() + "], ResultCode[" + paramFromServiceMsg.getResultCode() + "], RequestSsoSeq[" + paramFromServiceMsg.getRequestSsoSeq() + "], msgSeq_for_callback[" + l1 + "], msgListener[" + localObject + "], seq[" + l2 + "]");
      }
      if (localObject == null) {
        break;
      }
      ((MessageHandler.MsgListener)localObject).a(l2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ((localObject instanceof Long)) {
        l1 = ((Long)localObject).longValue();
      }
    }
    QLog.w("QAVMessageHandler", 1, "onReceive, 没有MsgListener， cmd[" + str + "], seq[" + l2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.handler.MessageHandler
 * JD-Core Version:    0.7.0.1
 */
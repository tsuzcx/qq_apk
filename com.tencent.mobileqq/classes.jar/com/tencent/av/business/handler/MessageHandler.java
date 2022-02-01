package com.tencent.av.business.handler;

import com.tencent.av.common.ErrorInfo;
import com.tencent.av.utils.AudioHelper;
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
    if (QLog.isDevelopLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("sendMsg, msgListener[");
      paramAppInterface.append(paramMsgListener);
      paramAppInterface.append("], msgSeq_for_callback[");
      paramAppInterface.append(l);
      paramAppInterface.append("], seq[");
      paramAppInterface.append(paramLong);
      paramAppInterface.append("]");
      QLog.w("QAVMessageHandler", 1, paramAppInterface.toString());
    }
  }
  
  private static MessageHandler.ClassInfo b(MessageHandler.MsgListener paramMsgListener)
  {
    paramMsgListener = paramMsgListener.getClass().getGenericSuperclass();
    if (paramMsgListener != null)
    {
      if ((paramMsgListener instanceof ParameterizedType))
      {
        paramMsgListener = ((ParameterizedType)paramMsgListener).getActualTypeArguments();
        if (paramMsgListener != null)
        {
          if (paramMsgListener.length == 2)
          {
            localObject = (Class)paramMsgListener[0];
            localClass = (Class)paramMsgListener[1];
            paramMsgListener = new StringBuilder();
            paramMsgListener.append("reqType[");
            paramMsgListener.append(localObject);
            paramMsgListener.append("]rspType[");
            paramMsgListener.append(localClass);
            paramMsgListener.append("]");
            paramMsgListener = paramMsgListener.toString();
            break label187;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ActualTypeArguments长度为");
          ((StringBuilder)localObject).append(paramMsgListener.length);
          paramMsgListener = ((StringBuilder)localObject).toString();
        }
        else
        {
          paramMsgListener = "getActualTypeArguments为空";
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("type[");
        ((StringBuilder)localObject).append(paramMsgListener.getClass().getName());
        ((StringBuilder)localObject).append("]");
        paramMsgListener = ((StringBuilder)localObject).toString();
      }
    }
    else {
      paramMsgListener = "genericInterfaces为空";
    }
    Class localClass = null;
    Object localObject = localClass;
    label187:
    if (((localObject != null) && (localClass != null)) || (!AudioHelper.a()))
    {
      MessageHandler.ClassInfo localClassInfo = new MessageHandler.ClassInfo(null);
      localClassInfo.jdField_a_of_type_JavaLangString = paramMsgListener;
      localClassInfo.jdField_a_of_type_JavaLangClass = ((Class)localObject);
      localClassInfo.b = localClass;
      return localClassInfo;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QAVMessageHandler get getClassInfo失败, ");
    ((StringBuilder)localObject).append(paramMsgListener);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return MessageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l2 = SeqUtil.a(paramToServiceMsg.getAttributes());
    Object localObject = paramToServiceMsg.getAttribute("msgSeq_for_callback");
    long l1;
    if ((localObject instanceof Integer)) {
      l1 = ((Integer)localObject).intValue();
    } else if ((localObject instanceof Long)) {
      l1 = ((Long)localObject).longValue();
    } else {
      l1 = 0L;
    }
    localObject = a(l1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, cmd[");
      localStringBuilder.append(str);
      localStringBuilder.append("], req_cmd[");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append("], isSuccess[");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      localStringBuilder.append("], RequestSsoSeq[");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append("], ResultCode[");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append("], RequestSsoSeq[");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append("], msgSeq_for_callback[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], msgListener[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l2);
      localStringBuilder.append("]");
      QLog.w("QAVMessageHandler", 1, localStringBuilder.toString());
    }
    if (localObject != null)
    {
      ((MessageHandler.MsgListener)localObject).a(l2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onReceive, 没有MsgListener， cmd[");
    paramToServiceMsg.append(str);
    paramToServiceMsg.append("], seq[");
    paramToServiceMsg.append(l2);
    paramToServiceMsg.append("]");
    QLog.w("QAVMessageHandler", 1, paramToServiceMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.MessageHandler
 * JD-Core Version:    0.7.0.1
 */
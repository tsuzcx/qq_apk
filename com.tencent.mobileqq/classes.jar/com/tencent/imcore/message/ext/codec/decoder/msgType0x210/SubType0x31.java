package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;

public class SubType0x31
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, int paramInt, SubAccountBackProtocData paramSubAccountBackProtocData, long paramLong)
  {
    Object localObject1 = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    Object localObject2 = (ISubAccountControlService)((QQAppInterface)localObject1).getRuntimeService(ISubAccountControlService.class, null);
    if (paramInt == 1)
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus((AppInterface)localObject1, (byte)0, paramSubAccountBackProtocData.d);
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).clearAllData((AppInterface)localObject1, paramSubAccountBackProtocData.d);
      paramSubAccountBackProtocData.a = 1;
      ((ISubAccountControlService)localObject2).addHintPair(paramSubAccountBackProtocData.d, 1);
      paramOnLinePushMessageProcessor.a(8004, true, paramSubAccountBackProtocData);
      return;
    }
    if (paramInt == 0)
    {
      localObject2 = String.valueOf(paramLong);
      ISubAccountService localISubAccountService = (ISubAccountService)((QQAppInterface)localObject1).getRuntimeService(ISubAccountService.class, null);
      paramSubAccountBackProtocData.a((String)localObject2);
      localISubAccountService.updateSubAccountInfo(paramSubAccountBackProtocData);
      Object localObject3 = paramSubAccountBackProtocData.b();
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("decodeC2CMsgPush() hint is new,msg num=1, subUin=");
            localStringBuilder.append(str);
            QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
          }
          paramInt = 1 - ((QQAppInterface)localObject1).getConversationFacade().a(str, 7000);
          if (paramInt != 0) {
            ((QQAppInterface)localObject1).getConversationFacade().e(str, 7000, paramInt);
          }
        }
      }
      localObject3 = ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).checkSubAccountLoginStatus((AppInterface)localObject1, (String)localObject2);
      boolean bool;
      if (localObject3 != null) {
        bool = ((Boolean)((Pair)localObject3).second).booleanValue();
      } else {
        bool = false;
      }
      if (bool)
      {
        localISubAccountService.setStatus((String)localObject2, 1);
        ((QQAppInterface)localObject1).getSubAccountKey(((QQAppInterface)localObject1).getAccount(), String.valueOf(paramLong), new SubType0x31.1((QQAppInterface)localObject1, localISubAccountService));
      }
      else if (localISubAccountService.setStatus(String.valueOf(paramLong), 2))
      {
        paramInt = 1 - ((QQAppInterface)localObject1).getConversationFacade().a((String)localObject2, 7000);
        if (paramInt != 0)
        {
          ((QQAppInterface)localObject1).getConversationFacade().e((String)localObject2, 7000, paramInt);
          ((QQAppInterface)localObject1).getMessageFacade().a(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, localObject2 });
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("decodeC2CMsgPush() hint need to verify,msg num=1, subUin=");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
        }
      }
      paramSubAccountBackProtocData.a = 0;
      paramOnLinePushMessageProcessor.a(8004, true, paramSubAccountBackProtocData);
    }
  }
  
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x31.MsgBody();
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
      }
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("param_FailCode", "12017");
      paramArrayOfByte.put("fail_step", "msgbyod_null");
      paramArrayOfByte.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
      return;
    }
    if ((paramArrayOfByte.uint32_flag.has()) && (paramArrayOfByte.uint64_bind_uin.has()) && (paramArrayOfByte.uint64_uin.has()))
    {
      int i = paramArrayOfByte.uint32_flag.get();
      paramArrayOfByte.uint32_time.get();
      long l1 = paramArrayOfByte.uint64_uin.get();
      long l2 = paramArrayOfByte.uint64_bind_uin.get();
      if ((l1 > 0L) && (l2 > 0L))
      {
        if (!String.valueOf(paramLong).equalsIgnoreCase(paramOnLinePushMessageProcessor.a().getAccount())) {
          return;
        }
        paramArrayOfByte = new SubAccountBackProtocData();
        paramArrayOfByte.d = String.valueOf(l1);
        paramArrayOfByte.c = String.valueOf(l2);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_FailCode", "12018");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("success_");
        localStringBuilder.append(i);
        ((HashMap)localObject).put("fail_step", localStringBuilder.toString());
        ((HashMap)localObject).put("fail_location", "MessageHandler");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject, "");
        a(paramOnLinePushMessageProcessor, i, paramArrayOfByte, l1);
        return;
      }
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("param_FailCode", "12017");
      paramArrayOfByte.put("fail_step", "uin_error");
      paramArrayOfByte.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
      return;
    }
    paramArrayOfByte = new HashMap();
    paramArrayOfByte.put("param_FailCode", "12017");
    paramArrayOfByte.put("fail_step", "uinflag_null");
    paramArrayOfByte.put("fail_location", "MessageHandler");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramLong, paramArrayOfByte);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x31
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopmemberlevel.api.ITroopMemberLevelHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GeneralNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;

public class SubType0x44
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static submsgtype0x44.MsgBody a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
      }
    }
    return null;
  }
  
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    paramArrayOfByte = a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return;
    }
    a(paramArrayOfByte);
    a(paramOnLinePushMessageProcessor, b(paramOnLinePushMessageProcessor, paramArrayOfByte), a(paramOnLinePushMessageProcessor, paramArrayOfByte));
    c(paramOnLinePushMessageProcessor, paramArrayOfByte);
    b(paramOnLinePushMessageProcessor, paramArrayOfByte);
    a(paramOnLinePushMessageProcessor, paramArrayOfByte);
  }
  
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_waiting_msg_sync.has()) && (paramMsgBody.msg_waiting_msg_sync.get() != null)) {
      d(paramOnLinePushMessageProcessor, paramMsgBody);
    }
  }
  
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (paramBoolean2)) {
      b(paramOnLinePushMessageProcessor, paramBoolean1, paramBoolean2);
    }
  }
  
  private static void a(submsgtype0x44.MsgBody paramMsgBody)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      if ((paramMsgBody.msg_friend_msg_sync.has()) && (paramMsgBody.msg_friend_msg_sync.get() != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=");
        localStringBuilder.append(paramMsgBody.msg_friend_msg_sync.uint32_processflag.get());
        localStringBuilder.append(";processtype=");
        localStringBuilder.append(paramMsgBody.msg_friend_msg_sync.uint32_processtype.get());
        localStringBuilder.append(";fuin");
        localStringBuilder.append(paramMsgBody.msg_friend_msg_sync.uint64_fuin.get());
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
      if ((paramMsgBody.msg_group_msg_sync.has()) && (paramMsgBody.msg_group_msg_sync.get() != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=");
        localStringBuilder.append(paramMsgBody.msg_group_msg_sync.uint32_processflag.get());
        localStringBuilder.append(";processtype=");
        localStringBuilder.append(paramMsgBody.msg_group_msg_sync.uint32_msg_type.get());
        localStringBuilder.append(";grp_code=");
        localStringBuilder.append(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
      if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=");
        localStringBuilder.append(paramMsgBody.msg_clean_count_msg.uint32_processflag.get());
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
    }
  }
  
  private static boolean a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool1;
    if ((paramMsgBody.msg_group_msg_sync.has()) && (paramMsgBody.msg_group_msg_sync.get() != null)) {
      bool1 = c(paramOnLinePushMessageProcessor, paramMsgBody);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramMsgBody.msg_general_notify.has())
    {
      bool2 = bool1;
      if (paramMsgBody.msg_general_notify.get() != null) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private static void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_modify_msg_sync.has()) && (paramMsgBody.msg_modify_msg_sync.get() != null)) {
      e(paramOnLinePushMessageProcessor, paramMsgBody);
    }
  }
  
  private static void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramOnLinePushMessageProcessor = (SystemMessageProcessor)((BaseMessageHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a("system_processor");
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramOnLinePushMessageProcessor.a(4);
      return;
    }
    if (paramBoolean1)
    {
      paramOnLinePushMessageProcessor.a(2);
      return;
    }
    if (paramBoolean2) {
      paramOnLinePushMessageProcessor.a(3, 1, false);
    }
  }
  
  private static boolean b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_friend_msg_sync.has()) && (paramMsgBody.msg_friend_msg_sync.get() != null)) {
      return d(paramOnLinePushMessageProcessor, paramMsgBody);
    }
    return false;
  }
  
  private static void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null)) {
      f(paramOnLinePushMessageProcessor, paramMsgBody);
    }
  }
  
  private static boolean c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool = paramOnLinePushMessageProcessor.a(paramMsgBody.msg_group_msg_sync.uint32_processflag.get());
    if (paramOnLinePushMessageProcessor.b(paramMsgBody.msg_group_msg_sync.uint32_msg_type.get()))
    {
      String str = String.valueOf(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
      Object localObject1 = SystemMsgUtils.a(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (StringUtil.c(str)))
      {
        Object localObject2 = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
        if (((TroopManager)localObject2).b(str) == null)
        {
          TroopInfo localTroopInfo = new TroopInfo();
          localTroopInfo.troopuin = str;
          localTroopInfo.troopcode = ((String)localObject1);
          ((TroopManager)localObject2).a(localTroopInfo);
          localObject1 = (ITroopMngHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
          localObject2 = (ITroopInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
          ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
          ((ITroopInfoHandler)localObject2).a(localTroopInfo.troopuin, false, "SubType0x44.source_apply_for_join_troop", true, true, true, false);
          localITroopMemberListHandler.a(1, TroopFileHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
          ((ITroopMemberLevelHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LEVEL_HANDLER)).a(str);
          ((ITroopMngHandler)localObject1).a(TroopMngObserver.c, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), str });
          ((ITroopMngHandler)localObject1).a(TroopMngObserver.h, true, new Object[] { str });
        }
        paramOnLinePushMessageProcessor.a(2001, true, null);
      }
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_group_msg_sync.uint32_processflag.get());
      paramOnLinePushMessageProcessor.append(";uint32_msg_type=");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_group_msg_sync.uint32_msg_type.get());
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
    return bool;
  }
  
  private static void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    ((SystemMessageProcessor)((BaseMessageHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a("system_processor")).a(2);
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_waiting_msg_sync.get());
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private static boolean d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool = paramOnLinePushMessageProcessor.a(paramMsgBody.msg_friend_msg_sync.uint32_processflag.get());
    if (paramOnLinePushMessageProcessor.c(paramMsgBody.msg_friend_msg_sync.uint32_processtype.get()))
    {
      String str = String.valueOf(paramMsgBody.msg_friend_msg_sync.uint64_fuin.get());
      if ((!TextUtils.isEmpty(str)) && (StringUtil.c(str)))
      {
        paramOnLinePushMessageProcessor = (FriendListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        int i = paramMsgBody.msg_friend_msg_sync.uint32_sourceid.get();
        str = String.valueOf(str);
        if (!paramOnLinePushMessageProcessor.addFriendToFriendList(str, 0, i, null, false, false, -1L)) {
          paramOnLinePushMessageProcessor.getFriendDetailInfo(str);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_friend_msg_sync.uint32_processflag.get());
      paramOnLinePushMessageProcessor.append(";uint32_processtype=");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_friend_msg_sync.uint32_processtype.get());
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
    return bool;
  }
  
  private static void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    ((SystemMessageProcessor)((BaseMessageHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a("system_processor")).b(2);
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_modify_msg_sync.get());
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private static void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    if (paramOnLinePushMessageProcessor.a(paramMsgBody.msg_clean_count_msg.uint32_processflag.get()))
    {
      localQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - GroupSystemMsgController.a().a(localQQAppInterface));
      GroupSystemMsgController.a().a(localQQAppInterface, 0);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(localQQAppInterface, 0);
      paramOnLinePushMessageProcessor = (INewFriendService)localQQAppInterface.getRuntimeService(INewFriendService.class);
      localQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      paramOnLinePushMessageProcessor.reloadNewFriendMsg();
    }
    int i = ((submsgtype0x44.ClearCountMsg)paramMsgBody.msg_clean_count_msg.get()).uint32_updateflag.get();
    if (i > 0) {
      localQQAppInterface.getMsgHandler().a().a(2);
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=");
      paramOnLinePushMessageProcessor.append(paramMsgBody.msg_clean_count_msg.uint32_processflag.get());
      paramOnLinePushMessageProcessor.append(" updateFlag=");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramLong, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x44
 * JD-Core Version:    0.7.0.1
 */
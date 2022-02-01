package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
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
  implements Msg0X210SubTypeDecoder
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
      if ((paramMsgBody.msg_friend_msg_sync.has()) && (paramMsgBody.msg_friend_msg_sync.get() != null)) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramMsgBody.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramMsgBody.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramMsgBody.msg_friend_msg_sync.uint64_fuin.get());
      }
      if ((paramMsgBody.msg_group_msg_sync.has()) && (paramMsgBody.msg_group_msg_sync.get() != null)) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramMsgBody.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramMsgBody.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
      }
      if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null)) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramMsgBody.msg_clean_count_msg.uint32_processflag.get());
      }
    }
  }
  
  private static boolean a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgBody.msg_group_msg_sync.has())
    {
      bool1 = bool2;
      if (paramMsgBody.msg_group_msg_sync.get() != null) {
        bool1 = c(paramOnLinePushMessageProcessor, paramMsgBody);
      }
    }
    bool2 = bool1;
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
    if ((paramBoolean1) && (paramBoolean2)) {
      paramOnLinePushMessageProcessor.a().getMsgHandler().a().a(4);
    }
    do
    {
      return;
      if (paramBoolean1)
      {
        paramOnLinePushMessageProcessor.a().getMsgHandler().a().a(2);
        return;
      }
    } while (!paramBoolean2);
    paramOnLinePushMessageProcessor.a().getMsgHandler().a().a(3, 1, false);
  }
  
  private static boolean b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgBody.msg_friend_msg_sync.has())
    {
      bool1 = bool2;
      if (paramMsgBody.msg_friend_msg_sync.get() != null) {
        bool1 = d(paramOnLinePushMessageProcessor, paramMsgBody);
      }
    }
    return bool1;
  }
  
  private static void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if ((paramMsgBody.msg_clean_count_msg.has()) && (paramMsgBody.msg_clean_count_msg.get() != null)) {
      f(paramOnLinePushMessageProcessor, paramMsgBody);
    }
  }
  
  private static boolean c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramOnLinePushMessageProcessor.a(paramMsgBody.msg_group_msg_sync.uint32_processflag.get())) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramOnLinePushMessageProcessor.b(paramMsgBody.msg_group_msg_sync.uint32_msg_type.get()))
      {
        String str = String.valueOf(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        Object localObject = SystemMsgUtils.a(paramMsgBody.msg_group_msg_sync.uint64_grp_code.get());
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (StringUtil.c(str)))
        {
          TroopManager localTroopManager = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
          if (localTroopManager.b(str) == null)
          {
            TroopInfo localTroopInfo = new TroopInfo();
            localTroopInfo.troopuin = str;
            localTroopInfo.troopcode = ((String)localObject);
            localTroopManager.a(localTroopInfo);
            localObject = (TroopHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
            ((TroopInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(localTroopInfo.troopuin, false, "SubType0x44.source_apply_for_join_troop", true, true, true, false);
            ((TroopHandler)localObject).a(1, BizTroopHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
            ((TroopHandler)localObject).f(str);
            ((TroopHandler)localObject).notifyUI(TroopNotificationConstants.f, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), str });
            ((TroopHandler)localObject).notifyUI(TroopNotificationConstants.bx, true, new Object[] { str });
          }
          paramOnLinePushMessageProcessor.a(2001, true, null);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramMsgBody.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramMsgBody.msg_group_msg_sync.uint32_msg_type.get());
      }
      return bool;
    }
  }
  
  private static void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    paramOnLinePushMessageProcessor.a().getMsgHandler().a().a(2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramMsgBody.msg_waiting_msg_sync.get());
    }
  }
  
  private static boolean d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramOnLinePushMessageProcessor.a(paramMsgBody.msg_friend_msg_sync.uint32_processflag.get())) {}
    for (boolean bool = true;; bool = false)
    {
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramMsgBody.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramMsgBody.msg_friend_msg_sync.uint32_processtype.get());
      }
      return bool;
    }
  }
  
  private static void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    paramOnLinePushMessageProcessor.a().getMsgHandler().a().b(2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramMsgBody.msg_modify_msg_sync.get());
    }
  }
  
  private static void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, submsgtype0x44.MsgBody paramMsgBody)
  {
    if (paramOnLinePushMessageProcessor.a(paramMsgBody.msg_clean_count_msg.uint32_processflag.get()))
    {
      paramOnLinePushMessageProcessor.a().getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - GroupSystemMsgController.a().a(paramOnLinePushMessageProcessor.a()));
      GroupSystemMsgController.a().a(paramOnLinePushMessageProcessor.a(), 0);
      FriendSystemMsgController.a().a(paramOnLinePushMessageProcessor.a(), 0);
      NewFriendManager localNewFriendManager = (NewFriendManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      paramOnLinePushMessageProcessor.a().getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      localNewFriendManager.b();
    }
    int i = ((submsgtype0x44.ClearCountMsg)paramMsgBody.msg_clean_count_msg.get()).uint32_updateflag.get();
    if (i > 0) {
      paramOnLinePushMessageProcessor.a().getMsgHandler().a().a(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramMsgBody.msg_clean_count_msg.uint32_processflag.get() + " updateFlag=" + i);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramLong, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x44
 * JD-Core Version:    0.7.0.1
 */
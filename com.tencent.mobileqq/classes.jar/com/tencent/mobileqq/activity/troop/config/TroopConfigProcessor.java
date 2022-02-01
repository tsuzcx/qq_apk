package com.tencent.mobileqq.activity.troop.config;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.config.AbsTroopConfigHandlerProcessor;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.GroupMsgConfig;

public class TroopConfigProcessor
  extends AbsTroopConfigHandlerProcessor
{
  public void a(AppInterface paramAppInterface, oidb_0x496.AioKeyword paramAioKeyword)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ThreadManager.post(new TroopConfigProcessor.1(this, (QQAppInterface)paramAppInterface, paramAioKeyword), 8, null, true);
    }
  }
  
  public void a(AppInterface paramAppInterface, oidb_0x496.GroupMsgConfig paramGroupMsgConfig)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (paramGroupMsgConfig != null) && (paramGroupMsgConfig.has()) && (paramGroupMsgConfig.bool_uin_enable.has()) && (paramGroupMsgConfig.uint32_max_aio_msg.has()) && (paramGroupMsgConfig.uint32_enable_helper.has()) && (paramGroupMsgConfig.uint32_group_max_number.has()))
    {
      paramAppInterface = ((QQAppInterface)paramAppInterface).getMessageFacade().p();
      paramAppInterface.h = paramGroupMsgConfig.bool_uin_enable.get();
      paramAppInterface.i = paramGroupMsgConfig.uint32_max_aio_msg.get();
      paramAppInterface.k = paramGroupMsgConfig.uint32_group_max_number.get();
      paramAppInterface.l = paramGroupMsgConfig.uint32_enable_helper.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopConfigProcessor
 * JD-Core Version:    0.7.0.1
 */
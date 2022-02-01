package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;

public class TroopMsgTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramAIOContext = TroopBusinessUtil.a(paramMessage);
    if (paramAIOContext != null) {
      paramMessage.nickName = paramAIOContext.d;
    }
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (!paramAIOContext.a().isTroopMark(paramMessage))
    {
      if (TroopManager.a(paramAIOContext.a(), paramMessage)) {
        return true;
      }
      return (paramMessage.istroop == 0) && (TextUtils.equals(paramMessage.frienduin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN));
    }
    return true;
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramAIOContext = (ITroopRobotService)paramAIOContext.a().getRuntimeService(ITroopRobotService.class, "all");
    if (paramAIOContext.hasRobotNewsClassId(paramMessage))
    {
      if (!paramAIOContext.hasProcessedMoreDetail(paramMessage)) {
        paramAIOContext.preProcessMessageMoreDetail(paramMessage);
      }
      paramAIOContext = paramAIOContext.generateMoreDetailMsg(paramMessage);
      if (!TextUtils.isEmpty(paramAIOContext)) {
        return paramAIOContext;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.TroopMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */
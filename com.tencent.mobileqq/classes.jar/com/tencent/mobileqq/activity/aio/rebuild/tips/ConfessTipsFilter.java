package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class ConfessTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (1033 != paramAIOContext.a().a)
    {
      if (1034 == paramAIOContext.a().a) {
        return true;
      }
      if (ConfessMsgUtil.a(paramMessage)) {
        return true;
      }
      return ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.ConfessTipsFilter
 * JD-Core Version:    0.7.0.1
 */
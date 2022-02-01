package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;

public class MediaMsgTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if ((paramMessageRecord instanceof MessageForPtt)) {
      paramMessage.msg = ((MessageForPtt)paramMessageRecord).getSummaryMsg();
    }
    return paramMessage.msgtype == -2058;
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (paramMessage.msgtype == -2016)
    {
      paramAIOContext = paramMessage.msg.split("\\|");
      if (paramAIOContext.length > 0) {
        return paramAIOContext[0].trim();
      }
      return "";
    }
    if ((paramMessage.msgtype != -2011) && (paramMessage.msgtype != -2059))
    {
      if (paramMessage.msgtype == -2000)
      {
        if ((!((HotChatManager)paramAIOContext.a().getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramMessage.frienduin)) && (!((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessage))) {
          return paramMessage.getMessageText();
        }
        return paramAIOContext.b().getResources().getString(2131888233);
      }
      if (paramMessage.msgtype == -7001) {
        return paramAIOContext.b().getResources().getString(2131891967);
      }
      return null;
    }
    paramAIOContext = StructMsgFactory.a(paramMessage.msgData);
    if (paramAIOContext != null) {
      return paramAIOContext.mMsgBrief;
    }
    return paramMessage.msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.MediaMsgTipsFilter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.activity.aio.coreui.tips.IMsgTipsListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.util.notification.NotifyIdManager;

public class SpecialCareTipsFilter
  implements IMsgTipsFilter, IMsgTipsListener
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramMessageRecord = new SpannableStringBuilder();
    if (paramMessage.nickName != null)
    {
      NotifyIdManager.a(paramAIOContext.a()).a(paramMessage, paramIntent, paramMessageRecord);
    }
    else
    {
      paramIntent = paramIntent.getStringExtra("uinname");
      NotifyIdManager.a(paramAIOContext.a()).a(paramMessage, paramMessageRecord);
      if ((paramIntent != null) && (paramIntent.length() != 0)) {
        paramMessageRecord.append(paramIntent);
      } else {
        paramMessageRecord.append(paramMessage.frienduin);
      }
    }
    paramAIOContext = paramMessageRecord;
    if (paramMessageRecord.length() == 0) {
      paramAIOContext = null;
    }
    return paramAIOContext;
  }
  
  public CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, Message paramMessage)
  {
    NotifyIdManager.a(paramAIOContext.a()).a(paramMessage);
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return NotifyIdManager.a(paramAIOContext.a()).c(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.SpecialCareTipsFilter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.data.MessageRecord;

public class CMRTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (1024 == paramMessage.istroop)
    {
      paramMessageRecord = new SpannableStringBuilder();
      paramIntent = paramIntent.getStringExtra("uinname");
      paramAIOContext = CrmUtils.b(paramAIOContext.a(), paramMessage.frienduin);
      if (TextUtils.isEmpty(paramAIOContext))
      {
        paramMessageRecord.append(paramIntent);
        return paramMessageRecord;
      }
      paramMessageRecord.append(paramAIOContext);
      return paramMessageRecord;
    }
    return null;
  }
  
  public CharSequence a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.CMRTipsFilter
 * JD-Core Version:    0.7.0.1
 */
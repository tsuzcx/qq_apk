package com.tencent.mobileqq.activity.aio.rebuild.tips;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.data.MessageRecord;

public class SubAccountTipsFilter
  implements IMsgTipsFilter
{
  public CharSequence a(AIOContext paramAIOContext, Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    paramMessageRecord = paramIntent.getStringExtra("uinname");
    if ((7000 == paramMessage.istroop) && (!TextUtils.isEmpty(paramMessageRecord)))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramIntent = paramIntent.getStringExtra("subAccountLatestNick");
      if (paramIntent != null)
      {
        paramAIOContext = paramIntent;
        if (paramIntent.length() != 0) {}
      }
      else
      {
        paramAIOContext = paramMessage.senderuin;
      }
      localSpannableStringBuilder.append(paramMessageRecord);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(paramAIOContext);
    }
    return null;
  }
  
  public boolean a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return false;
  }
  
  public CharSequence b(AIOContext paramAIOContext, MessageRecord paramMessageRecord, Message paramMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.SubAccountTipsFilter
 * JD-Core Version:    0.7.0.1
 */
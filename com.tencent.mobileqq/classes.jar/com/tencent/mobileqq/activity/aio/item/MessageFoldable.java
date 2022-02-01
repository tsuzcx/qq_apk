package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class MessageFoldable
{
  public static void a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord.isFolded = false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isSendFromLocal()) {
      return false;
    }
    String str = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("strFlag: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", mr: ");
      localStringBuilder.append(paramMessageRecord);
      QLog.d("MessageFoldable", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    int i;
    try
    {
      i = Integer.parseInt(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      i = 0;
    }
    if ((i & 0x8) != 0) {
      return paramMessageRecord.isFolded;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MessageFoldable
 * JD-Core Version:    0.7.0.1
 */
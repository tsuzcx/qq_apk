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
    if (paramMessageRecord.isSendFromLocal()) {}
    for (;;)
    {
      return false;
      String str = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
      if (QLog.isColorLevel()) {
        QLog.d("MessageFoldable", 2, "strFlag: " + str + ", mr: " + paramMessageRecord);
      }
      if (TextUtils.isEmpty(str)) {
        continue;
      }
      try
      {
        i = Integer.parseInt(str);
        if ((i & 0x8) == 0) {
          continue;
        }
        return paramMessageRecord.isFolded;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MessageFoldable
 * JD-Core Version:    0.7.0.1
 */
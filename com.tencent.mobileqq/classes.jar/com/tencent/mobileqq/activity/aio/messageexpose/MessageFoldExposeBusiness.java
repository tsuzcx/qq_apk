package com.tencent.mobileqq.activity.aio.messageexpose;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.MessageFoldable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;

public class MessageFoldExposeBusiness
  implements OnAIOMessageExposeListener
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (MessageFoldable.a(paramMessageRecord))
    {
      int i;
      if (paramMessageRecord.istroop == 0) {
        i = 1;
      } else if (paramMessageRecord.istroop == 1) {
        i = 2;
      } else if (ChatActivityUtils.a(paramMessageRecord.istroop)) {
        i = 3;
      } else {
        i = 4;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B154", "0X800B154", i, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.messageexpose.MessageFoldExposeBusiness
 * JD-Core Version:    0.7.0.1
 */
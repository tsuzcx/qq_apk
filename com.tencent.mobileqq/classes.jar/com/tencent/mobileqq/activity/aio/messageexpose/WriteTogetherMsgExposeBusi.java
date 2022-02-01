package com.tencent.mobileqq.activity.aio.messageexpose;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.statistics.ReportController;

public class WriteTogetherMsgExposeBusi
  implements OnAIOMessageExposeListener
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
      return;
    }
    if ("1033".equals(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"))) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AF35", "0X800AF35", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.messageexpose.WriteTogetherMsgExposeBusi
 * JD-Core Version:    0.7.0.1
 */
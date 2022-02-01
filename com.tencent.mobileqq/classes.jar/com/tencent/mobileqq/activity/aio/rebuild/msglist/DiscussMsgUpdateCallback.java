package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;

public class DiscussMsgUpdateCallback
  implements IMsgUpdateCallback
{
  private void a(QQAppInterface paramQQAppInterface, MessageForText paramMessageForText)
  {
    if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 0))
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006211", "0X8006211", 0, 0, "", "", "", "");
      ArrayList localArrayList = paramMessageForText.atInfoList;
      int j = 0;
      if ((localArrayList != null) && (paramMessageForText.atInfoList.size() == 1))
      {
        if (!((AtTroopMemberInfo)paramMessageForText.atInfoList.get(0)).isIncludingAll()) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006212", "0X8006212", 0, 0, "", "", "", "");
        }
      }
      else if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 1))
      {
        paramMessageForText = paramMessageForText.atInfoList.iterator();
        do
        {
          i = j;
          if (!paramMessageForText.hasNext()) {
            break;
          }
        } while (!((AtTroopMemberInfo)paramMessageForText.next()).isIncludingAll());
        int i = 1;
        if (i == 0) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006213", "0X8006213", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForText)) && (paramChatMessage.istroop == 3000) && (paramChatMessage.extraflag == 0)) {
      a(paramAIOContext.a(), (MessageForText)paramChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DiscussMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */
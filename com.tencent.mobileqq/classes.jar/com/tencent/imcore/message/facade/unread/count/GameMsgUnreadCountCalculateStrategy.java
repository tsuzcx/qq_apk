package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import java.util.Locale;

class GameMsgUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    paramQQAppInterface = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if ((paramQQAppInterface.isInited()) && (!paramQQAppInterface.isShowInMsgBox()))
    {
      int i = paramQQAppInterface.getUnshowedUnreadCnt();
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { "2747277822", Integer.valueOf(10007), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.GameMsgUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */
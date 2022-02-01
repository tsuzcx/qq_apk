package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import java.util.Locale;

class GameMsgUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    paramQQMessageFacade = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (paramQQMessageFacade.isInited())
    {
      if (paramQQMessageFacade.isShowInMsgBox())
      {
        int j = paramQQMessageFacade.getUnshowedUnreadCntMsgBoxExclusive();
        i = j;
        if (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
          i = j + ((IGameMsgBoxRuntimeService)paramQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getBoxUnReadCnt();
        }
        paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { Integer.valueOf(10015), Integer.valueOf(10015), Integer.valueOf(i) }));
        return i;
      }
      int i = paramQQMessageFacade.getUnshowedUnreadCnt();
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { "2747277822", Integer.valueOf(10007), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.GameMsgUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */
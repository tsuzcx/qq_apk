package com.tencent.imcore.message.facade.unread.count;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import java.util.Locale;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

class TencentDocsUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    if ((((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(paramQQAppInterface)) && (paramQQAppInterface.getConversationFacade().b(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004)))
    {
      paramQQAppInterface = ((TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
      int i;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.uint32_number.has()) && (paramQQAppInterface.bool_display_reddot.get())) {
        i = paramQQAppInterface.uint32_number.get();
      } else {
        i = 0;
      }
      paramStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { AppConstants.TENCENT_DOCS_ASSISTANT_UIN, Integer.valueOf(6004), Integer.valueOf(i) }));
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.TencentDocsUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */
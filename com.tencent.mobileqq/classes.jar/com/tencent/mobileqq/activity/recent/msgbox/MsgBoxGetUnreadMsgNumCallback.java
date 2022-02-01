package com.tencent.mobileqq.activity.recent.msgbox;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;

public class MsgBoxGetUnreadMsgNumCallback
  implements GetUnreadMsgNumCallback
{
  public int a(String paramString, StringBuilder paramStringBuilder, AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    int i = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempMsgBoxUnread(paramAppInterface);
    if (((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).isUinInRecentList(AppConstants.TEMP_MSG_BOX_UIN, 10011)) {
      paramStringBuilder.append(String.format(paramString, new Object[] { AppConstants.TEMP_MSG_BOX_UIN, Integer.valueOf(10011), Integer.valueOf(i) }));
    }
    return i;
  }
  
  public boolean a(ConversationInfo paramConversationInfo)
  {
    return false;
  }
  
  public boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean, AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    paramAppInterface = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    if ((!paramAppInterface.isBelongToFilterBox(paramConversationInfo.uin, paramConversationInfo.type)) && (!paramAppInterface.isBelongToMsgBox(paramConversationInfo.uin, paramConversationInfo.type)) && (paramConversationInfo.type != 10011) && (paramConversationInfo.type != 10012) && (!TextUtils.equals(paramConversationInfo.uin, AppConstants.FILTER_MSG_UIN)) && (!TextUtils.equals(paramConversationInfo.uin, AppConstants.TEMP_MSG_BOX_UIN))) {
      return false;
    }
    paramArrayOfBoolean[0] = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.MsgBoxGetUnreadMsgNumCallback
 * JD-Core Version:    0.7.0.1
 */
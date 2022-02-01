package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.IGetMiniCardCallback;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;
import mqq.os.MqqHandler;

class ChatSettingActivity$3
  implements IGetMiniCardCallback
{
  ChatSettingActivity$3(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(int paramInt, List<NowSummaryCard.MiniCard> paramList, String paramString)
  {
    if ((paramInt == 0) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ChatSettingActivity.3.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.3
 * JD-Core Version:    0.7.0.1
 */
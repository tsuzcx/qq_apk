package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener;
import com.tencent.mobileqq.statistics.ReportController;

class ChatSettingForTroop$40
  implements LongClickCopyAction.ICopyListener
{
  ChatSettingForTroop$40(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onCopyContent(String paramString)
  {
    ReportController.b(this.a.app, "grp_set", "", "", "grp_data", "grp_set_copy", 0, 0, paramString, "", "", "");
  }
  
  public void onShowCopyMenu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.40
 * JD-Core Version:    0.7.0.1
 */
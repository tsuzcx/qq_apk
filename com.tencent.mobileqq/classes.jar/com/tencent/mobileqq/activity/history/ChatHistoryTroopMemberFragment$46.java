package com.tencent.mobileqq.activity.history;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

class ChatHistoryTroopMemberFragment$46
  extends TroopOnlineMemberObserver
{
  ChatHistoryTroopMemberFragment$46(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.w)) && (this.a.bj == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.46.1(this, paramList));
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.w)) && (this.a.bj == 8) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.46.2(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.46
 * JD-Core Version:    0.7.0.1
 */
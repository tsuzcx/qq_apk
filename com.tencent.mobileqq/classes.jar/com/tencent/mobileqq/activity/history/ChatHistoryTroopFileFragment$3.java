package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileItem;
import com.tencent.widget.XListView;

class ChatHistoryTroopFileFragment$3
  extends Handler
{
  ChatHistoryTroopFileFragment$3(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (ChatHistoryTroopFileFragment.c(this.a) == null) {
        return;
      }
      int i = ChatHistoryTroopFileFragment.c(this.a).getFirstVisiblePosition();
      while (i <= ChatHistoryTroopFileFragment.c(this.a).getLastVisiblePosition())
      {
        paramMessage = ChatHistoryTroopFileFragment.c(this.a).getChildAt(i);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.getTag();
          if ((paramMessage != null) && ((paramMessage instanceof TroopFileItem))) {
            ((TroopFileItem)paramMessage).a(this.a.a, ChatHistoryTroopFileFragment.b(this.a));
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.3
 * JD-Core Version:    0.7.0.1
 */
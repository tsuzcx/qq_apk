package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class ChatHistoryC2CAllFragment$10
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryC2CAllFragment$10(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.c.A == null) {
        this.c.A = new ArrayList();
      }
      if ((this.a instanceof MessageForPtt))
      {
        paramView = MediaPlayerManager.a(this.c.a).f();
        if ((paramView == this.a) || (((paramView instanceof MessageForPtt)) && (paramView.uniseq == this.a.uniseq))) {
          MediaPlayerManager.a(this.c.a).c(false);
        }
      }
      paramView = this.c;
      paramView.z = true;
      paramView.A.add(this.a);
      paramView = this.c.R.obtainMessage(1);
      this.c.R.sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new ChatHistoryC2CAllFragment.10.1(this), new MessageRecord[] { this.a });
      VipUtils.a(this.c.a, "chat_history", "ChatHistory", "Clk_deleteOne", 1, 0, new String[0]);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.10
 * JD-Core Version:    0.7.0.1
 */
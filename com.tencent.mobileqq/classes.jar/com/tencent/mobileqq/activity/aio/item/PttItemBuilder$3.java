package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PttItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  PttItemBuilder$3(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ChatActivityFacade.a(this.c.d, this.a);
    paramView = ChatActivityFacade.a(this.c.d, this.c.f, this.a);
    if (paramView != null) {
      try
      {
        ((MessageForPtt)paramView).c2cViaOffline = true;
        ((MessageForPtt)paramView).isResend = true;
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", paramView.vipBubbleDiyTextId);
        ChatActivityFacade.a(this.c.d, this.a.istroop, this.a.frienduin, this.a.getLocalFilePath(), paramView.uniseq, true, this.a.voiceLength * 1000, this.a.voiceType, true, this.a.voiceChangeFlag, 0, true, paramView.vipSubBubbleId, localBundle);
      }
      catch (RuntimeException paramView)
      {
        paramView.printStackTrace();
        Toast.makeText(this.c.e, paramView.getMessage(), 0).show();
      }
    }
    this.c.d();
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */
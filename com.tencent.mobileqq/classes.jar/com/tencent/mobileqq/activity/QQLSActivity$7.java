package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQLSActivity$7
  implements ActionSheet.OnButtonClickListener
{
  QQLSActivity$7(QQLSActivity paramQQLSActivity, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ChatActivityFacade.a(QQLSActivity.i(this.c), this.a);
    paramView = ChatActivityFacade.a(QQLSActivity.i(this.c), new SessionInfo(), this.a);
    if (paramView != null) {
      try
      {
        ((MessageForPtt)paramView).c2cViaOffline = true;
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", paramView.vipBubbleDiyTextId);
        ChatActivityFacade.a(QQLSActivity.i(this.c), this.a.istroop, this.a.frienduin, this.a.getLocalFilePath(), paramView.uniseq, true, this.a.voiceLength * 1000, this.a.voiceType, true, this.a.voiceChangeFlag, 0, true, paramView.vipSubBubbleId, localBundle);
      }
      catch (RuntimeException paramView)
      {
        paramView.printStackTrace();
        QQToast.makeText(this.c, paramView.getMessage(), 0).show();
      }
    }
    this.c.g();
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.7
 * JD-Core Version:    0.7.0.1
 */
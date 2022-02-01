package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

final class ChatActivityFacade$17
  implements Runnable
{
  ChatActivityFacade$17(Context paramContext, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.c = (ActionSheet)ActionSheetHelper.b(this.a, null);
    ChatActivityFacade.d = this.b;
    String str = this.a.getResources().getString(2131893858);
    ChatActivityFacade.c.setMainTitle(str);
    ChatActivityFacade.c.addButton(2131888438, 3);
    ChatActivityFacade.c.addCancelButton(2131887648);
    ChatActivityFacade.c.setOnButtonClickListener(new ChatActivityFacade.17.1(this));
    ChatActivityFacade.c.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.17
 * JD-Core Version:    0.7.0.1
 */
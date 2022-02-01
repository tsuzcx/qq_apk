package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

final class ChatActivityFacade$18
  implements Runnable
{
  ChatActivityFacade$18(Context paramContext, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.e = (ActionSheet)ActionSheetHelper.b(this.a, null);
    ChatActivityFacade.f = this.b;
    String str = this.a.getResources().getString(2131893858);
    ChatActivityFacade.e.setMainTitle(str);
    ChatActivityFacade.e.addButton(2131888438, 3);
    ChatActivityFacade.e.addCancelButton(2131887648);
    ChatActivityFacade.e.setOnButtonClickListener(new ChatActivityFacade.18.1(this));
    ChatActivityFacade.e.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.18
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

class DiscussionInfoCardActivity$8
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.app.getMessageFacade().c(DiscussionInfoCardActivity.c(this.b), 3000);
      this.b.app.getMessageFacade().g(DiscussionInfoCardActivity.c(this.b), 3000);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.b.app, "chat_history_confirm_del_msg");
      paramView = this.b.app.getHandler(Conversation.class);
      Message localMessage = paramView.obtainMessage(1017);
      localMessage.obj = DiscussionInfoCardActivity.c(this.b);
      localMessage.arg1 = 3000;
      paramView.sendMessage(localMessage);
      paramView = this.b;
      QQToast.makeText(paramView, 2, paramView.getString(2131887802), 0).show();
      if (this.b.b != null) {
        ((TextView)this.b.b.findViewById(2131447463)).setTextColor(Color.parseColor("#cccccc"));
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.8
 * JD-Core Version:    0.7.0.1
 */
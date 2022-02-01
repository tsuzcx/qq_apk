package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class DiscussionInfoCardActivity$7
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  DiscussionInfoCardActivity$7(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    this.a.app.getMessageFacade().a(DiscussionInfoCardActivity.a(this.a), 3000);
    this.a.app.getMessageFacade().e(DiscussionInfoCardActivity.a(this.a), 3000);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.app, "chat_history_confirm_del_msg");
    paramDialog = this.a.app.getHandler(Conversation.class);
    paramView = paramDialog.obtainMessage(1017);
    paramView.obj = DiscussionInfoCardActivity.a(this.a);
    paramView.arg1 = 3000;
    paramDialog.sendMessage(paramView);
    QQToast.a(this.a, 2, this.a.getString(2131690937), 0).a();
    if (this.a.a != null) {
      ((TextView)this.a.a.findViewById(2131379432)).setTextColor(Color.parseColor("#cccccc"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;

class RecentAdapter$10$2
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  RecentAdapter$10$2(RecentAdapter.10 param10) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    this.a.f.d.getMessageFacade().c(this.a.a.getRecentUserUin(), 3000);
    this.a.f.d.getMessageFacade().g(this.a.a.getRecentUserUin(), 3000);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.f.d, "chat_history_confirm_del_msg");
    QQToast.makeText(this.a.f.c, 2, 2131888442, 0).show();
    RecentAdapter.a(this.a.f, this.a.a, this.a.b, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.10.2
 * JD-Core Version:    0.7.0.1
 */
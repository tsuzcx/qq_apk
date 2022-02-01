package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
import android.os.Message;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class RecentAdapter$10$3
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  RecentAdapter$10$3(RecentAdapter.10 param10) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    try
    {
      paramDialog = this.a.a.getRecentUserUin();
      paramView = new StringBuilder();
      int i = ChatHistory.a(this.a.f.d, paramDialog, 1, paramView);
      Object localObject = this.a.f.d.getMessageFacade().h(paramDialog, 1);
      long l1;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq;
      } else {
        l1 = 0L;
      }
      if (i > 0) {
        try
        {
          long l2 = Long.parseLong(paramView.toString());
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.a.f.d.getMsgCache().a(paramDialog, 1, l1);
          }
          if (((TroopManager)this.a.f.d.getManager(QQManagerFactory.TROOP_MANAGER)).o(paramDialog))
          {
            FriendsStatusUtil.b(this.a.f.d, paramDialog, 1);
            this.a.f.d.getMessageFacade().b(paramDialog, 1, true, false);
          }
          else
          {
            this.a.f.d.getMessageFacade().c(paramDialog, 1);
          }
          this.a.f.d.getMessageFacade().g(paramDialog, 1);
          ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.f.d, "chat_history_confirm_del_msg");
          paramView = this.a.f.d.getHandler(Conversation.class);
          localObject = paramView.obtainMessage(1017);
          ((Message)localObject).obj = paramDialog;
          ((Message)localObject).arg1 = 1;
          paramView.sendMessage((Message)localObject);
        }
        catch (Exception paramDialog)
        {
          QLog.e("Q.recent", 1, "ClearChatRecordTask parse seq fail.", paramDialog);
          QQToast.makeText(this.a.f.c, 2, 2131888442, 0).show();
          RecentAdapter.a(this.a.f, this.a.a, this.a.b, this.a.c);
          return;
        }
      } else if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "msg history already clear!");
      }
      QQToast.makeText(this.a.f.c, 2, 2131888442, 0).show();
      RecentAdapter.a(this.a.f, this.a.a, this.a.b, this.a.c);
      return;
    }
    catch (IllegalStateException paramDialog)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("msg history clear,  IllegalStateException");
        paramView.append(paramDialog.toString());
        QLog.e("Q.recent", 2, paramView.toString());
      }
      QQToast.makeText(this.a.f.c, 1, 2131888439, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.10.3
 * JD-Core Version:    0.7.0.1
 */
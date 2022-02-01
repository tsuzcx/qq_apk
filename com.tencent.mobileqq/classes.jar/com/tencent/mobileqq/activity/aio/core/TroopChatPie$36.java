package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import antp;
import awub;
import bgig;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import java.util.Set;

class TroopChatPie$36
  implements Runnable
{
  TroopChatPie$36(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (awub.a().a(this.this$0.sessionInfo.curFriendUin, this.this$0.app))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.this$0.mActivity, this.this$0.mActivity.getString(2131689920));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      awub.a().a(this.this$0.sessionInfo.curFriendUin, this.this$0.app);
    }
    Object localObject = (antp)this.this$0.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if ((localObject != null) && (((antp)localObject).a.contains(this.this$0.sessionInfo.curFriendUin)))
    {
      this.this$0.app.getMessageFacade().pullRecentGroupMsg(this.this$0.sessionInfo.curFriendUin);
      ((antp)localObject).a.remove(this.this$0.sessionInfo.curFriendUin);
    }
    localObject = (bgig)this.this$0.app.getManager(QQManagerFactory.TROOP_APP_MGR);
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      if (this.this$0.jdField_a_of_type_Int != ((bgig)localObject).a(0))
      {
        this.this$0.jdField_a_of_type_Int = ((bgig)localObject).a(0);
        this.this$0.b.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.sessionInfo.curFriendUin);
      ((bgig)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.36
 * JD-Core Version:    0.7.0.1
 */
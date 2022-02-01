package com.tencent.mobileqq.activity.aio.core;

import amrb;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import avnw;
import bfaa;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import java.util.Set;

class TroopChatPie$37
  implements Runnable
{
  TroopChatPie$37(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (avnw.a().a(this.this$0.sessionInfo.curFriendUin, this.this$0.app))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.this$0.mActivity, this.this$0.mActivity.getString(2131689891));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      avnw.a().a(this.this$0.sessionInfo.curFriendUin, this.this$0.app);
    }
    Object localObject = (amrb)this.this$0.app.getManager(53);
    if ((localObject != null) && (((amrb)localObject).a.contains(this.this$0.sessionInfo.curFriendUin)))
    {
      this.this$0.app.getMessageFacade().pullRecentGroupMsg(this.this$0.sessionInfo.curFriendUin);
      ((amrb)localObject).a.remove(this.this$0.sessionInfo.curFriendUin);
    }
    localObject = (bfaa)this.this$0.app.getManager(109);
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(52);
    if (localObject != null)
    {
      if (this.this$0.jdField_a_of_type_Int != ((bfaa)localObject).a(0))
      {
        this.this$0.jdField_a_of_type_Int = ((bfaa)localObject).a(0);
        this.this$0.b.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.sessionInfo.curFriendUin);
      ((bfaa)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.37
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.widget.Toast;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.utils.TroopRemindSettingManager;
import java.util.Set;

class TroopChatPie$27
  implements Runnable
{
  TroopChatPie$27(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TroopRemindSettingManager.a().a(this.this$0.ah.b, this.this$0.d))
    {
      localObject = this.this$0;
      ((TroopChatPie)localObject).cg = ChatActivityUtils.a(((TroopChatPie)localObject).f, this.this$0.f.getString(2131886518));
      this.this$0.cg.show();
      TroopRemindSettingManager.a().b(this.this$0.ah.b, this.this$0.d);
    }
    Object localObject = (DiscussionManager)this.this$0.d.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if ((localObject != null) && (((DiscussionManager)localObject).b.contains(this.this$0.ah.b)))
    {
      this.this$0.d.getMessageFacade().c(this.this$0.ah.b);
      ((DiscussionManager)localObject).b.remove(this.this$0.ah.b);
    }
    localObject = (ITroopAppService)this.this$0.d.getRuntimeService(ITroopAppService.class, "all");
    TroopManager localTroopManager = (TroopManager)this.this$0.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (this.this$0.bE != ((ITroopAppService)localObject).getAppListTimestamp(0))
    {
      this.this$0.bE = ((ITroopAppService)localObject).getAppListTimestamp(0);
      this.this$0.bX.sendEmptyMessage(4);
    }
    localTroopManager.g(this.this$0.ah.b);
    ((ITroopAppService)localObject).clickReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.27
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;

class TroopChatPie$26
  implements Runnable
{
  TroopChatPie$26(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.bQ();
    Object localObject1 = ((TroopGagMgr)this.this$0.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.this$0.ah.b, true);
    Object localObject2 = this.this$0.bX.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.bX.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.this$0.ah.b);
    int i = this.this$0.d.getTroopMask(this.this$0.ah.b);
    localObject2 = this.this$0.d.getMessageFacade().p();
    int j = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((TroopMessageManager)localObject2).l > 0))) && (((TroopMessageManager)localObject2).h) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((TroopMessageManager)localObject2).k) && ((j == 4) || (j == 1))) {
      ((TroopMessageManager)localObject2).e(this.this$0.ah.b, Math.min(this.this$0.cd, ((TroopMessageManager)localObject2).i));
    }
    if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
      TroopReportor.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.ah.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.26
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import bfjz;
import bgkf;
import bhbu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.os.MqqHandler;

class TroopChatPie$35
  implements Runnable
{
  TroopChatPie$35(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.l();
    Object localObject1 = ((bgkf)this.this$0.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.this$0.sessionInfo.curFriendUin, true);
    Object localObject2 = this.this$0.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.this$0.sessionInfo.curFriendUin);
    int i = this.this$0.app.getTroopMask(this.this$0.sessionInfo.curFriendUin);
    localObject2 = this.this$0.app.getMessageFacade().getTroopMessageManager();
    int j = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((bfjz)localObject2).c > 0))) && (((bfjz)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((bfjz)localObject2).b) && ((j == 4) || (j == 1))) {
      ((bfjz)localObject2).c(this.this$0.sessionInfo.curFriendUin, Math.min(this.this$0.e, ((bfjz)localObject2).jdField_a_of_type_Int));
    }
    this.this$0.uiHandler.obtainMessage(85).sendToTarget();
    if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
      bhbu.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.sessionInfo.curFriendUin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.35
 * JD-Core Version:    0.7.0.1
 */
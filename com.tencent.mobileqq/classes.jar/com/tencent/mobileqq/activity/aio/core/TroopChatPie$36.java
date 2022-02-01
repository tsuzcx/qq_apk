package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import becw;
import bfbz;
import bftc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.os.MqqHandler;

class TroopChatPie$36
  implements Runnable
{
  TroopChatPie$36(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.k();
    Object localObject1 = ((bfbz)this.this$0.app.getManager(48)).a(this.this$0.sessionInfo.curFriendUin, true);
    Object localObject2 = this.this$0.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.app.getManager(52)).c(this.this$0.sessionInfo.curFriendUin);
    int i = this.this$0.app.getTroopMask(this.this$0.sessionInfo.curFriendUin);
    localObject2 = this.this$0.app.getMessageFacade().getTroopMessageManager();
    int j = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((becw)localObject2).c > 0))) && (((becw)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((becw)localObject2).b) && ((j == 4) || (j == 1))) {
      ((becw)localObject2).c(this.this$0.sessionInfo.curFriendUin, Math.min(this.this$0.e, ((becw)localObject2).jdField_a_of_type_Int));
    }
    this.this$0.uiHandler.obtainMessage(85).sendToTarget();
    if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
      bftc.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.sessionInfo.curFriendUin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.36
 * JD-Core Version:    0.7.0.1
 */
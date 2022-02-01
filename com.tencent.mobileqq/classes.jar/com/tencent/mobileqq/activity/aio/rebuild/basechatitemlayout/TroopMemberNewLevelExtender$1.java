package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberRankItem;

class TroopMemberNewLevelExtender$1
  extends NickNameExtenderViewBasicAbility
{
  TroopMemberNewLevelExtender$1(TroopMemberNewLevelExtender paramTroopMemberNewLevelExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {}
    while ((paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return;
    }
    ((TroopMemberNewLevelView)this.mView).setTroopMemberNewLevel((TroopMemberRankItem)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberNewLevelExtender.1
 * JD-Core Version:    0.7.0.1
 */
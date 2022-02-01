package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;

class TroopMemberNewLevelExtender$1
  extends BaseChatItemLayoutViewBasicAbility
{
  TroopMemberNewLevelExtender$1(TroopMemberNewLevelExtender paramTroopMemberNewLevelExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
      ((TroopMemberNewLevelView)this.mView).setTroopMemberNewLevel((TroopMemberRankItem)paramVarArgs[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberNewLevelExtender.1
 * JD-Core Version:    0.7.0.1
 */
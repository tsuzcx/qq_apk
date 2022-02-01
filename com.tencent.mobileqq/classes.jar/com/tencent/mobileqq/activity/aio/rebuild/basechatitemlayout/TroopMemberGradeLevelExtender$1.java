package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView;

class TroopMemberGradeLevelExtender$1
  extends BaseChatItemLayoutViewBasicAbility
{
  TroopMemberGradeLevelExtender$1(TroopMemberGradeLevelExtender paramTroopMemberGradeLevelExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {
      return;
    }
    if (paramVarArgs == null)
    {
      ((TroopMemberGradeLevelView)this.mView).setTroopMemberGradeLevel(null);
      return;
    }
    if ((paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof MemberGradeLevelInfo))) {
      ((TroopMemberGradeLevelView)this.mView).setTroopMemberGradeLevel((MemberGradeLevelInfo)paramVarArgs[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberGradeLevelExtender.1
 * JD-Core Version:    0.7.0.1
 */
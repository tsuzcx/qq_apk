package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView;

class TroopMemberGradeLevelExtender$1
  extends NickNameExtenderViewBasicAbility
{
  TroopMemberGradeLevelExtender$1(TroopMemberGradeLevelExtender paramTroopMemberGradeLevelExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {}
    do
    {
      return;
      if (paramVarArgs == null)
      {
        ((TroopMemberGradeLevelView)this.mView).setTroopMemberGradeLevel(null);
        return;
      }
    } while ((paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof MemberGradeLevelInfo)));
    ((TroopMemberGradeLevelView)this.mView).setTroopMemberGradeLevel((MemberGradeLevelInfo)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberGradeLevelExtender.1
 * JD-Core Version:    0.7.0.1
 */
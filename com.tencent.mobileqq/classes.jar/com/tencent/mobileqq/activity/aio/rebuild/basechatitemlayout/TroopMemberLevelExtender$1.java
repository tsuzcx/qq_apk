package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelView;

class TroopMemberLevelExtender$1
  extends NickNameExtenderViewBasicAbility
{
  TroopMemberLevelExtender$1(TroopMemberLevelExtender paramTroopMemberLevelExtender, View paramView)
  {
    super(paramView);
  }
  
  public void setData(Object... paramVarArgs)
  {
    if (!checkViewNonNull()) {}
    while ((paramVarArgs == null) || (paramVarArgs.length != 6)) {
      return;
    }
    ((TroopMemberLevelView)this.mView).setTroopMemberLevel((QQAppInterface)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue(), (String)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue(), ((Integer)paramVarArgs[4]).intValue(), ((Integer)paramVarArgs[5]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.TroopMemberLevelExtender.1
 * JD-Core Version:    0.7.0.1
 */
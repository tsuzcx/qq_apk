package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.qphone.base.util.QLog;

class GameMsgBoxFragment$1
  extends GameCenterUnissoObserver
{
  GameMsgBoxFragment$1(GameMsgBoxFragment paramGameMsgBoxFragment, int paramInt)
  {
    super(paramInt);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, " onSetSwitchCallback ");
    }
    GameMsgBoxFragment.a(this.a);
    GameMsgBoxFragment.b(this.a);
  }
  
  public void b(Object paramObject)
  {
    super.b(paramObject);
    QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, " game usr info change notify.");
    GameMsgBoxFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.1
 * JD-Core Version:    0.7.0.1
 */
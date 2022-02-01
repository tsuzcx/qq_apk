package com.tencent.avgame.gameresult;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.qphone.base.util.QLog;

class GameResultPKPresenterImp$2
  extends SimpleGameRoomStatusListener
{
  GameResultPKPresenterImp$2(GameResultPKPresenterImp paramGameResultPKPresenterImp) {}
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 2, String.format("onSurvivalPoolEnter isSuc:%b errCode:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), paramString }));
    }
    this.a.a.b(GameEngine.a().s());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultPKPresenterImp.2
 * JD-Core Version:    0.7.0.1
 */
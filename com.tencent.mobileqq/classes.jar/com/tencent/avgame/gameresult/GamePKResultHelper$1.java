package com.tencent.avgame.gameresult;

import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class GamePKResultHelper$1
  extends SimpleGameRoomStatusListener
{
  GamePKResultHelper$1(GamePKResultHelper paramGamePKResultHelper) {}
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(GamePKResultHelper.e(), 2, String.format(Locale.ENGLISH, "onSurvivalPoolEnter isSuc:%b errCode:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), paramString }));
    }
    this.a.a.showRoom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultHelper.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avgame.gamelogic;

import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qphone.base.util.QLog;

class GameEngine$5
  extends AVGameUIEventCallback
{
  GameEngine$5(GameEngine paramGameEngine) {}
  
  public void a()
  {
    QLog.i("avgame_logic.GameEngine", 1, "onEnterRoomSucess.");
    if ((this.a.h()) && (Build.VERSION.SDK_INT >= 16)) {
      AudioProcess.a().startRecog(this.a);
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoomError errorType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" engineData = ");
    localStringBuilder.append(GameEngine.a(this.a));
    QLog.i("avgame_logic.GameEngine", 1, localStringBuilder.toString());
    if ((paramInt == 4) || (paramInt == 3)) {
      AVGameHandler.a().b().post(new GameEngine.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.GameEngine.5
 * JD-Core Version:    0.7.0.1
 */
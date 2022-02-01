package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameManager$GameEventReceiver$1
  implements Runnable
{
  CmGameManager$GameEventReceiver$1(CmGameManager.GameEventReceiver paramGameEventReceiver, String paramString) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.a).optInt("__apollo_game_id__");
      ApolloCmdChannel.getInstance().handleWebEvent(this.a, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameManager", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameManager.GameEventReceiver.1
 * JD-Core Version:    0.7.0.1
 */
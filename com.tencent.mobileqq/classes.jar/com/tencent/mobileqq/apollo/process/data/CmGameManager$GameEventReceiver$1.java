package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameManager$GameEventReceiver$1
  implements Runnable
{
  CmGameManager$GameEventReceiver$1(CmGameManager.GameEventReceiver paramGameEventReceiver, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(this.a);
        if (localObject != null)
        {
          i = ((JSONObject)localObject).optInt("__apollo_game_id__");
          localObject = CmGameUtil.a();
          if (localObject != null) {
            ((IApolloCmdChannel)localObject).handleWebEvent(this.a, i);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameManager", 1, localException, new Object[0]);
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameManager.GameEventReceiver.1
 * JD-Core Version:    0.7.0.1
 */
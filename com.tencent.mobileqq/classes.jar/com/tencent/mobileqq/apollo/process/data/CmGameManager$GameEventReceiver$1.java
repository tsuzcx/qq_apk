package com.tencent.mobileqq.apollo.process.data;

import akwd;
import akyr;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameManager$GameEventReceiver$1
  implements Runnable
{
  public CmGameManager$GameEventReceiver$1(akyr paramakyr, String paramString) {}
  
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
          localObject = akwd.a();
          if (localObject != null) {
            ((ApolloCmdChannel)localObject).handleWebEvent(this.a, i);
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
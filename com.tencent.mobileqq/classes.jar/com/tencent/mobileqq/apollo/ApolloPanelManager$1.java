package com.tencent.mobileqq.apollo;

import android.app.Activity;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ApolloPanelManager$1
  implements IRequestHandler
{
  ApolloPanelManager$1(ApolloPanelManager paramApolloPanelManager) {}
  
  public int a()
  {
    return 0;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (!"cs.script_action_status_notify.local".equals(paramString1)) {}
    do
    {
      return null;
      paramString1 = this.a.a();
    } while (paramString1 == null);
    label269:
    label275:
    label278:
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        int i = ((JSONObject)localObject).optInt("taskId");
        int j = ((JSONObject)localObject).optInt("status");
        localObject = (ISpriteScriptManager)paramString1.getRuntimeService(ISpriteScriptManager.class, "all");
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ISpriteScriptManager)localObject).getTaskHandler();
          bool1 = bool2;
          if (localObject != null)
          {
            if (((ISpriteTaskHandler)localObject).a()) {
              break label275;
            }
            if (((ISpriteTaskHandler)localObject).a() <= 0) {
              break label269;
            }
            break label275;
          }
        }
        QLog.i("Apollo_PanelManager", 2, "ApolloPanelManager handleCmd, isAnyTaskRunning:" + bool1 + ", reqData:" + paramString2);
        if ((i <= 0) || (bool1) || ((2 != j) && (3 != j))) {
          break;
        }
        QLog.i("Apollo_PanelManager", 2, "ApolloPanelManager handleCmd, notifyPanelTabStatusChange for taskId:" + i + " state change to:" + j);
        paramString1 = SpriteUtil.a(paramString1);
        if (paramString1 == null) {
          break;
        }
        paramString1.a(this.a.a());
        return null;
      }
      catch (JSONException paramString1)
      {
        QLog.e("Apollo_PanelManager", 2, "ApolloPanelManager handleCmd reqData:" + paramString2 + ", exception", paramString1);
        return null;
      }
      boolean bool1 = false;
      break label278;
      bool1 = true;
    }
  }
  
  public void a() {}
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */
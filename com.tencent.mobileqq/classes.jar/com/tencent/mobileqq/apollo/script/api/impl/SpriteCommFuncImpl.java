package com.tencent.mobileqq.apollo.script.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class SpriteCommFuncImpl
  implements ISpriteCommFunc
{
  private static final Set<String> ALL_SHOW_HIDE_BUSINESS = new SpriteCommFuncImpl.1();
  public static final String APOLLO_NONE_ACTION_PLAY = "none_apollo_play_action";
  public static final String TAG = "[cmshow][scripted]SpriteCommFunc";
  
  public boolean isSpriteActive(AppRuntime paramAppRuntime, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteCommFunc", 2, new Object[] { "[isSpriteActive]", ",from:", paramString });
    }
    if (!SpriteUtil.a(paramAppRuntime, Scene.AIO)) {
      return false;
    }
    paramAppRuntime = SpriteUtil.a(paramAppRuntime);
    if (paramAppRuntime == null) {
      return false;
    }
    paramAppRuntime = paramAppRuntime.getTaskHandler();
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.a();
  }
  
  public boolean isSpriteHidden(AppRuntime paramAppRuntime)
  {
    boolean bool1 = SpriteUtil.b(paramAppRuntime);
    boolean bool2 = SpriteUtil.a(paramAppRuntime);
    return (bool1) || (bool2);
  }
  
  public boolean isSpriteHiddenForBusiness(AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      paramAppRuntime = SpriteUtil.a(paramAppRuntime);
      bool1 = bool2;
      if (paramAppRuntime != null)
      {
        bool1 = bool2;
        if (paramAppRuntime.a(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void showOrHideSprite(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteCommFunc", 2, new Object[] { "[showOrHideSprite]", ",from:", paramString });
    }
    if (!SpriteUtil.a(paramAppRuntime, Scene.AIO)) {
      return;
    }
    if (!ALL_SHOW_HIDE_BUSINESS.contains(paramString)) {
      return;
    }
    ISpriteScriptManager localISpriteScriptManager = SpriteUtil.a(paramAppRuntime);
    if (localISpriteScriptManager == null) {
      return;
    }
    ISpriteContext localISpriteContext = SpriteUtil.a(paramAppRuntime);
    if (localISpriteContext != null) {
      localISpriteContext.a(paramString, paramBoolean);
    }
    if (SpriteUtil.a(paramAppRuntime))
    {
      QLog.i("[cmshow][scripted]SpriteCommFunc", 1, "showOrHideSprite double should hide");
      return;
    }
    paramAppRuntime = localISpriteScriptManager.getUIHandler();
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.a(paramBoolean, false, paramString);
  }
  
  public void stopAllTask(AppRuntime paramAppRuntime, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteCommFunc", 2, new Object[] { "[stopAllTask]", ",from:", paramString });
    }
    if (!SpriteUtil.a(paramAppRuntime, Scene.AIO)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("errCode", 0);
      paramString.put("type", 0);
      paramAppRuntime = (SpriteContext)SpriteUtil.a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("[cmshow][scripted]SpriteCommFunc", 1, "[stopAllTask], spriteContext or getSurfaceView is null.");
        return;
      }
      paramAppRuntime.a("sc.stop_all_task.local", paramString.toString());
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.e("[cmshow][scripted]SpriteCommFunc", 1, "[stopAllTask],", paramAppRuntime);
    }
  }
  
  public void stopTaskByMsg(long paramLong, AppRuntime paramAppRuntime, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteCommFunc", 2, new Object[] { "[stopTaskByMsg], msgId", Long.valueOf(paramLong), ",from:", paramString });
    }
    if (!SpriteUtil.a(paramAppRuntime, Scene.AIO)) {
      return;
    }
    paramAppRuntime = SpriteUtil.a(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.getTaskHandler();
    if (paramAppRuntime == null) {
      return;
    }
    paramString = paramAppRuntime.a((int)paramLong);
    if (paramString == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("task NOT exist, msgId:");
      paramAppRuntime.append(paramLong);
      QLog.w("[cmshow][scripted]SpriteCommFunc", 2, paramAppRuntime.toString());
      return;
    }
    ThreadManager.post(new SpriteCommFuncImpl.2(this, paramAppRuntime, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.api.impl.SpriteCommFuncImpl
 * JD-Core Version:    0.7.0.1
 */
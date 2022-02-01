package com.tencent.mobileqq.apollo.api.script.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class SpriteCommFuncImpl
  implements ISpriteCommFunc
{
  private static final Set<String> ALL_SHOW_HIDE_BUSINESS = new SpriteCommFuncImpl.1();
  public static final String APOLLO_NONE_ACTION_PLAY = "none_apollo_play_action";
  public static final String TAG = "cmshow_scripted_SpriteCommFunc";
  
  public boolean isSpriteActive(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[isSpriteActive]", ",from:", paramString });
    }
    if (!SpriteUtil.d(paramQQAppInterface)) {}
    do
    {
      do
      {
        return false;
        paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.getTaskHandler();
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
  
  public boolean isSpriteHidden(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = SpriteUtil.b(paramQQAppInterface);
    boolean bool2 = SpriteUtil.a(paramQQAppInterface);
    return (bool1) || (bool2);
  }
  
  public boolean isSpriteHiddenForBusiness(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    do
    {
      return false;
      paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
    } while ((paramQQAppInterface == null) || (!paramQQAppInterface.a(paramString)));
    return true;
  }
  
  public void showOrHideSprite(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[showOrHideSprite]", ",from:", paramString });
    }
    if (!SpriteUtil.d(paramQQAppInterface)) {}
    do
    {
      ISpriteScriptManager localISpriteScriptManager;
      do
      {
        do
        {
          return;
        } while (!ALL_SHOW_HIDE_BUSINESS.contains(paramString));
        localISpriteScriptManager = SpriteUtil.a(paramQQAppInterface);
      } while (localISpriteScriptManager == null);
      ISpriteContext localISpriteContext = SpriteUtil.a(paramQQAppInterface);
      if (localISpriteContext != null) {
        localISpriteContext.a(paramString, paramBoolean);
      }
      if (SpriteUtil.a(paramQQAppInterface))
      {
        QLog.i("cmshow_scripted_SpriteCommFunc", 1, "showOrHideSprite double should hide");
        return;
      }
      paramQQAppInterface = localISpriteScriptManager.getUIHandler();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramBoolean, false, paramString);
  }
  
  public void stopAllTask(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopAllTask]", ",from:", paramString });
    }
    if (!SpriteUtil.d(paramQQAppInterface)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("type", 0);
      paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null))
      {
        QLog.e("cmshow_scripted_SpriteCommFunc", 1, "[stopAllTask], spriteContext or getSurfaceView is null.");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("cmshow_scripted_SpriteCommFunc", 1, "[stopAllTask],", paramQQAppInterface);
      return;
    }
    ApolloUtilImpl.getCmdChannel().callbackFromRequest(paramQQAppInterface.a().getLuaState(), 0, "sc.stop_all_task.local", paramString.toString());
  }
  
  public void stopTaskByMsg(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopTaskByMsg], msgId", Long.valueOf(paramLong), ",from:", paramString });
    }
    if (!SpriteUtil.d(paramQQAppInterface)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.getTaskHandler();
    } while (paramQQAppInterface == null);
    paramString = paramQQAppInterface.a((int)paramLong);
    if (paramString == null)
    {
      QLog.w("cmshow_scripted_SpriteCommFunc", 2, "task NOT exist, msgId:" + paramLong);
      return;
    }
    ThreadManager.post(new SpriteCommFuncImpl.2(this, paramQQAppInterface, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.impl.SpriteCommFuncImpl
 * JD-Core Version:    0.7.0.1
 */
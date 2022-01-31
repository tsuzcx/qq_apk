package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import ysc;

public class SpriteCommFunc
{
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopTaskByMsg], msgId", Long.valueOf(paramLong), ",from:", paramString });
    }
    if (!SpriteUtil.c(paramQQAppInterface)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramString = paramQQAppInterface.a(paramLong);
    if (paramString == null)
    {
      QLog.w("cmshow_scripted_SpriteCommFunc", 2, "task NOT exist, msgId:" + paramLong);
      return;
    }
    ThreadManager.post(new ysc(paramQQAppInterface, paramString), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[stopAllTask]", ",from:", paramString });
    }
    if (!SpriteUtil.c(paramQQAppInterface)) {
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
    ApolloCmdChannel.getChannel(paramQQAppInterface.a()).callbackFromRequest(paramQQAppInterface.a().getLuaState(), 0, "sc.stop_all_task.local", paramString.toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[showOrHideSprite]", ",from:", paramString });
    }
    if (!SpriteUtil.c(paramQQAppInterface)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramBoolean, false, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = SpriteUtil.b(paramQQAppInterface);
    boolean bool2 = SpriteUtil.a(paramQQAppInterface);
    return (bool1) || (bool2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteCommFunc", 2, new Object[] { "[isSpriteActive]", ",from:", paramString });
    }
    if (!SpriteUtil.c(paramQQAppInterface)) {}
    do
    {
      do
      {
        return false;
        paramQQAppInterface = SpriteUtil.a(paramQQAppInterface);
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteCommFunc
 * JD-Core Version:    0.7.0.1
 */
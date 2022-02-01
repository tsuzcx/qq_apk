package com.tencent.avgame.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class AVGameBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String[] a;
  public static final String[] b = { "tencent.avgame.g2q.preload", "action_notify_av_game_room_changed", "tencent.avgame.g2q.exit", "tencent.avgame.g2q.pkRestart" };
  public static final String[] c = { "tencent.video.v2g.exitAVGame", "tencent.avgame.q2g.entring" };
  private final WeakReference<AppRuntime> a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public AVGameBroadcastReceiver(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
  }
  
  private void a(BaseAVGameAppInterface paramBaseAVGameAppInterface, Context paramContext, Intent paramIntent)
  {
    paramBaseAVGameAppInterface = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("actionToAVGame, action[");
      paramContext.append(paramBaseAVGameAppInterface);
      paramContext.append("]");
      QLog.i("AVGameBroadcastReceiver", 2, paramContext.toString());
    }
    if ("tencent.video.v2g.exitAVGame".equals(paramBaseAVGameAppInterface))
    {
      GameEngine.a().a(8, null, GameEngine.a().a());
      return;
    }
    if ("tencent.avgame.q2g.entring".equals(paramBaseAVGameAppInterface)) {
      ProcessMonitor.a().a("ACTION_MAIN_TO_AV_GAME_ENTERING");
    }
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("actionToQQ, action[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.i("AVGameBroadcastReceiver", 2, localStringBuilder.toString());
    }
    if ("tencent.avgame.g2q.preload".equals(str))
    {
      AVGameUtilService.a(paramIntent, true);
      return;
    }
    if ("action_notify_av_game_room_changed".equals(str))
    {
      int i = paramIntent.getIntExtra("action_key_status", 0);
      paramContext = paramIntent.getStringExtra("action_key_room_id");
      paramBaseQQAppInterface = (IAvGameManager)paramBaseQQAppInterface.getRuntimeService(IAvGameManager.class);
      if (paramBaseQQAppInterface != null) {
        paramBaseQQAppInterface.setCurrentAvGameRoomInfo(i, paramContext);
      }
    }
    else
    {
      if ("tencent.avgame.g2q.exit".equals(str))
      {
        AVGameUtilService.a(null, false);
        return;
      }
      if ("tencent.avgame.g2q.pkRestart".equals(str)) {
        AVGameUtilService.a(paramBaseQQAppInterface, paramContext, paramIntent);
      }
    }
  }
  
  private void a(BaseVideoAppInterface paramBaseVideoAppInterface, Context paramContext, Intent paramIntent)
  {
    paramBaseVideoAppInterface = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("actionToVideo, action[");
      paramContext.append(paramBaseVideoAppInterface);
      paramContext.append("]");
      QLog.i("AVGameBroadcastReceiver", 2, paramContext.toString());
    }
  }
  
  public String[] a()
  {
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localAppRuntime instanceof BaseVideoAppInterface)) {
      return jdField_a_of_type_ArrayOfJavaLangString;
    }
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return b;
    }
    if ((localAppRuntime instanceof BaseAVGameAppInterface)) {
      return c;
    }
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localAppRuntime == null) {
      return;
    }
    String str = paramIntent.getAction();
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive, action[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameBroadcastReceiver", 4, ((StringBuilder)localObject).toString());
    }
    boolean bool = localAppRuntime instanceof BaseVideoAppInterface;
    int j = 0;
    int k = 0;
    int i = 0;
    if (bool)
    {
      localObject = jdField_a_of_type_ArrayOfJavaLangString;
      j = localObject.length;
      while (i < j)
      {
        if (TextUtils.equals(str, localObject[i]))
        {
          a((BaseVideoAppInterface)localAppRuntime, paramContext, paramIntent);
          return;
        }
        i += 1;
      }
    }
    if ((localAppRuntime instanceof BaseQQAppInterface))
    {
      localObject = b;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        if (TextUtils.equals(str, localObject[i]))
        {
          a((BaseQQAppInterface)localAppRuntime, paramContext, paramIntent);
          return;
        }
        i += 1;
      }
    }
    if ((localAppRuntime instanceof BaseAVGameAppInterface))
    {
      localObject = c;
      j = localObject.length;
      i = k;
      while (i < j)
      {
        if (TextUtils.equals(str, localObject[i]))
        {
          a((BaseAVGameAppInterface)localAppRuntime, paramContext, paramIntent);
          return;
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("onReceive, not deal action[");
      paramContext.append(str);
      paramContext.append("]");
      QLog.i("AVGameBroadcastReceiver", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
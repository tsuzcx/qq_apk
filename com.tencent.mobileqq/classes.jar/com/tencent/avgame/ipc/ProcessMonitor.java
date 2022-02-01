package com.tencent.avgame.ipc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class ProcessMonitor
{
  private static ProcessMonitor a;
  private static final String[] b = { "AVGameActivity_doOnCreate", "AVGameActivity_doOnNewIntent", "ACTION_MAIN_TO_AV_GAME_ENTERING" };
  private long c = 0L;
  private long d = 0L;
  private boolean e = false;
  private final List<String> f = new ArrayList();
  
  public static ProcessMonitor a()
  {
    if (a == null) {
      try
      {
        a = new ProcessMonitor();
      }
      finally {}
    }
    return a;
  }
  
  static float e()
  {
    Object localObject = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("AV_GAME_MONITOR", 4);
    float f2 = 1.0F;
    if (localObject == null) {
      return 1.0F;
    }
    long l1 = ((SharedPreferences)localObject).getLong("totalAliveCnt", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("userActiveCnt", 0L);
    float f1 = f2;
    if (l1 >= 0L) {
      if (l2 < 0L)
      {
        f1 = f2;
      }
      else if ((l1 > 20L) && (l2 > 0L))
      {
        f1 = (float)l2 / (float)l1;
      }
      else
      {
        f1 = f2;
        if (l1 > 20L) {
          f1 = 0.0F;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAVGamePreloadUseRate, totalAliveCnt[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], userActiveCnt[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("], useRate[");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append("]");
      QLog.i("ProcessMonitor", 2, ((StringBuilder)localObject).toString());
    }
    return f1;
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateActiveTime, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("ProcessMonitor", 2, ((StringBuilder)localObject).toString());
    }
    this.c = SystemClock.elapsedRealtime();
    this.f.add(paramString);
    if (!this.e)
    {
      localObject = b;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (TextUtils.equals(localObject[i], paramString))
        {
          i = 1;
          break label115;
        }
        i += 1;
      }
      i = 0;
      label115:
      if (i != 0) {
        a(false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e) {
      return;
    }
    this.e = true;
    Object localObject1 = b;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (this.f.contains(localObject2))
      {
        bool = true;
        break label65;
      }
      i += 1;
    }
    boolean bool = false;
    label65:
    localObject1 = new ProcessMonitor.SaveDataTask(null);
    ((ProcessMonitor.SaveDataTask)localObject1).a = bool;
    ((ProcessMonitor.SaveDataTask)localObject1).b = false;
    if (paramBoolean)
    {
      ((ProcessMonitor.SaveDataTask)localObject1).run();
      return;
    }
    ThreadManager.excute((Runnable)localObject1, 16, null, true);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProcessMonitor", 2, "onProcessStart");
    }
    ProcessMonitor.SaveDataTask localSaveDataTask = new ProcessMonitor.SaveDataTask(null);
    localSaveDataTask.a = false;
    localSaveDataTask.b = true;
    ThreadManager.excute(localSaveDataTask, 64, null, true);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateExitGameTime, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("ProcessMonitor", 2, localStringBuilder.toString());
    }
    this.d = SystemClock.elapsedRealtime();
  }
  
  public void c()
  {
    a(true);
  }
  
  boolean d()
  {
    Object localObject = IAVGameBusinessCtrl.p();
    boolean bool2 = false;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProcessMonitor", 2, "checkAndExitAVGame, AVGameBusinessCtrl is null.");
      }
      return false;
    }
    localObject = ((IAVGameBusinessCtrl)localObject).j();
    if ((localObject != null) && (!((AVGameSession)localObject).d()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProcessMonitor", 2, "checkAndExitAVGame, in game now.");
      }
      return false;
    }
    if (Foreground.getActivityCount() > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkAndExitAVGame, foreground[");
        ((StringBuilder)localObject).append(Foreground.getActivityCount());
        ((StringBuilder)localObject).append("]");
        QLog.i("ProcessMonitor", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    long l2 = SystemClock.elapsedRealtime();
    long l1 = Math.abs(l2 - this.d);
    l2 = Math.abs(l2 - this.c);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkCanExitProcess, activeInterval[");
      ((StringBuilder)localObject).append(l2 / 1000L);
      ((StringBuilder)localObject).append("]s, exitGameInterval[");
      ((StringBuilder)localObject).append(l1 / 1000L);
      ((StringBuilder)localObject).append("]s");
      QLog.i("ProcessMonitor", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = bool2;
    if (l2 > 300000L)
    {
      bool1 = bool2;
      if (l1 > 120000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.ProcessMonitor
 * JD-Core Version:    0.7.0.1
 */
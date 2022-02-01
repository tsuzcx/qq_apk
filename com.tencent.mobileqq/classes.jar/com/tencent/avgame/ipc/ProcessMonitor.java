package com.tencent.avgame.ipc;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Foreground;

public class ProcessMonitor
{
  private static ProcessMonitor jdField_a_of_type_ComTencentAvgameIpcProcessMonitor = null;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "AVGameActivity_doOnCreate", "AVGameActivity_doOnNewIntent", "ACTION_MAIN_TO_AV_GAME_ENTERING" };
  private long jdField_a_of_type_Long = 0L;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long b = 0L;
  
  static float a()
  {
    float f2 = 1.0F;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("AV_GAME_MONITOR", 4);
    if (localSharedPreferences == null) {
      return f2;
    }
    long l1 = localSharedPreferences.getLong("totalAliveCnt", 0L);
    long l2 = localSharedPreferences.getLong("userActiveCnt", 0L);
    float f1 = f2;
    if (l1 >= 0L)
    {
      if (l2 >= 0L) {
        break label119;
      }
      f1 = f2;
    }
    for (;;)
    {
      f2 = f1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProcessMonitor", 2, "getAVGamePreloadUseRate, totalAliveCnt[" + l1 + "], userActiveCnt[" + l2 + "], useRate[" + f1 + "]");
      return f1;
      label119:
      if ((l1 > 20L) && (l2 > 0L))
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
  }
  
  public static ProcessMonitor a()
  {
    if (jdField_a_of_type_ComTencentAvgameIpcProcessMonitor == null) {}
    try
    {
      jdField_a_of_type_ComTencentAvgameIpcProcessMonitor = new ProcessMonitor();
      return jdField_a_of_type_ComTencentAvgameIpcProcessMonitor;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProcessMonitor", 2, "onProcessStart");
    }
    ProcessMonitor.SaveDataTask localSaveDataTask = new ProcessMonitor.SaveDataTask(null);
    localSaveDataTask.jdField_a_of_type_Boolean = false;
    localSaveDataTask.b = true;
    ThreadManager.excute(localSaveDataTask, 64, null, true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProcessMonitor", 2, "updateActiveTime, from[" + paramString + "]");
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    if (!this.jdField_a_of_type_Boolean)
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label107;
      }
      if (!TextUtils.equals(arrayOfString[i], paramString)) {
        break label100;
      }
    }
    label100:
    label107:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a(false);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i];
      if (!this.jdField_a_of_type_JavaUtilList.contains(localObject2)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new ProcessMonitor.SaveDataTask(null);
      ((ProcessMonitor.SaveDataTask)localObject1).jdField_a_of_type_Boolean = bool;
      ((ProcessMonitor.SaveDataTask)localObject1).b = false;
      if (paramBoolean)
      {
        ((ProcessMonitor.SaveDataTask)localObject1).run();
        return;
        i += 1;
        break;
      }
      ThreadManager.excute((Runnable)localObject1, 16, null, true);
      return;
    }
  }
  
  boolean a()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if ((localAVGameSession != null) && (!localAVGameSession.a())) {
      if (QLog.isColorLevel()) {
        QLog.i("ProcessMonitor", 2, "checkAndExitAVGame, in game now.");
      }
    }
    long l2;
    long l1;
    do
    {
      do
      {
        return false;
        if (Foreground.getActivityCount() <= 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ProcessMonitor", 2, "checkAndExitAVGame, foreground[" + Foreground.getActivityCount() + "]");
      return false;
      l2 = SystemClock.elapsedRealtime();
      l1 = Math.abs(l2 - this.b);
      l2 = Math.abs(l2 - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("ProcessMonitor", 2, "checkCanExitProcess, activeInterval[" + l2 / 1000L + "]s, exitGameInterval[" + l1 / 1000L + "]s");
      }
    } while ((l2 <= 300000L) || (l1 <= 120000L));
    return true;
  }
  
  public void b()
  {
    a(true);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProcessMonitor", 2, "updateExitGameTime, from[" + paramString + "]");
    }
    this.b = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.ProcessMonitor
 * JD-Core Version:    0.7.0.1
 */
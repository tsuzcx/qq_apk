package com.tencent.avgame.ipc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class ProcessMonitor$SaveDataTask
  implements Runnable
{
  boolean a = false;
  boolean b = false;
  
  public void run()
  {
    long l3 = 1L;
    long l4 = 0L;
    for (;;)
    {
      long l5;
      long l1;
      try
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("AV_GAME_MONITOR", 4);
        if (localSharedPreferences == null)
        {
          QLog.i("ProcessMonitor", 1, "SaveDataTask, sp is null");
          return;
        }
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        if (localEditor == null)
        {
          QLog.i("ProcessMonitor", 1, "SaveDataTask, editor is null");
          return;
        }
        l5 = localSharedPreferences.getLong("totalAliveCnt", 0L);
        long l2 = localSharedPreferences.getLong("userActiveCnt", 0L);
        if ((localSharedPreferences.getBoolean("saveDataFlag", false)) || (!this.b))
        {
          l5 += 1L;
          l1 = l2;
          if (!this.a) {
            break label250;
          }
          l1 = l2 + 1L;
          break label250;
          l1 = l4;
          l2 = l3;
          if (this.a)
          {
            l1 = 1L;
            l2 = l3;
          }
          localEditor.putLong("totalAliveCnt", l2).putLong("userActiveCnt", l1);
          localEditor.putBoolean("saveDataFlag", this.b).apply();
          if (QLog.isColorLevel())
          {
            QLog.i("ProcessMonitor", 2, "SaveDataTask, totalAliveCnt[" + l2 + "], userActiveCnt[" + l1 + "], isStartProcess[" + this.b + "]");
            return;
            l2 = l5;
            continue;
          }
        }
        else
        {
          l1 = l2;
          l2 = l5;
          continue;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label250:
      if (l5 >= 0L) {
        if (l1 >= 0L) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ipc.ProcessMonitor.SaveDataTask
 * JD-Core Version:    0.7.0.1
 */
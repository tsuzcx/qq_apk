package com.tencent.avgame.ipc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ProcessMonitor$SaveDataTask
  implements Runnable
{
  boolean a = false;
  boolean b = false;
  
  public void run()
  {
    for (;;)
    {
      long l1;
      long l2;
      long l3;
      try
      {
        Object localObject = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("AV_GAME_MONITOR", 4);
        if (localObject == null)
        {
          QLog.i("ProcessMonitor", 1, "SaveDataTask, sp is null");
          return;
        }
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        if (localEditor == null)
        {
          QLog.i("ProcessMonitor", 1, "SaveDataTask, editor is null");
          return;
        }
        long l4 = 0L;
        long l5 = ((SharedPreferences)localObject).getLong("totalAliveCnt", 0L);
        l1 = ((SharedPreferences)localObject).getLong("userActiveCnt", 0L);
        if (!((SharedPreferences)localObject).getBoolean("saveDataFlag", false))
        {
          l2 = l5;
          l3 = l1;
          if (this.b) {}
        }
        else
        {
          l3 = l5 + 1L;
          l2 = l1;
          if (!this.a) {
            break label267;
          }
          l2 = l1 + 1L;
          break label267;
          l1 = l4;
          if (!this.a) {
            break label289;
          }
          l1 = 1L;
          break label289;
          localEditor.putLong("totalAliveCnt", l1).putLong("userActiveCnt", l3);
          l2 = l1;
        }
        localEditor.putBoolean("saveDataFlag", this.b).apply();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("SaveDataTask, totalAliveCnt[");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append("], userActiveCnt[");
          ((StringBuilder)localObject).append(l3);
          ((StringBuilder)localObject).append("], isStartProcess[");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append("]");
          QLog.i("ProcessMonitor", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label267:
      if (l3 >= 0L)
      {
        l1 = l3;
        l3 = l2;
        if (l2 < 0L)
        {
          continue;
          label289:
          l2 = 1L;
          l3 = l1;
          l1 = l2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.ProcessMonitor.SaveDataTask
 * JD-Core Version:    0.7.0.1
 */
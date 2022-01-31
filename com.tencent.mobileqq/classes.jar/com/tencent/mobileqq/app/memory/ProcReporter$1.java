package com.tencent.mobileqq.app.memory;

import ajzq;
import ajzr;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.text.TextUtils;
import awrn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class ProcReporter$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
    label234:
    for (;;)
    {
      try
      {
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            String str = ((ActivityManager.RunningAppProcessInfo)localObject3).processName;
            int j = ((ActivityManager.RunningAppProcessInfo)localObject3).pid;
            localObject3 = this.a.iterator();
            i = 0;
            if (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (ajzr)((Iterator)localObject3).next();
              if ((j != ((ajzr)localObject4).jdField_a_of_type_Int) || (!TextUtils.equals(str, ((ajzr)localObject4).jdField_a_of_type_JavaLangString))) {
                break label234;
              }
              this.this$0.a.add(str);
              localObject4 = new HashMap();
              ((HashMap)localObject4).put("param_FailCode", str);
              ((HashMap)localObject4).put("processname", str);
              awrn.a(BaseApplicationImpl.getApplication()).a(null, "ProcKillFailed", true, 0L, 0L, (HashMap)localObject4, null);
              if (QLog.isColorLevel()) {
                QLog.d("GuardManager", 2, "kill reporting " + str);
              }
              i = 1;
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        Object localObject2 = null;
        continue;
        if (i == 0) {
          continue;
        }
        this.this$0.b();
        continue;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.ProcReporter.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class QLogReporter$1
  implements Runnable
{
  QLogReporter$1(QLogReporter paramQLogReporter, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject1).append("/tencent/msflogs/");
        ((StringBuilder)localObject1).append("com.tencent.mobileqq".replace(".", "/"));
        ((StringBuilder)localObject1).append("/");
        String str1 = ((StringBuilder)localObject1).toString();
        localObject1 = new File(str1);
        if (((File)localObject1).exists())
        {
          if (!((File)localObject1).isDirectory()) {
            return;
          }
          Object localObject3 = ((File)localObject1).list();
          if (localObject3 != null)
          {
            if (localObject3.length == 0) {
              return;
            }
            long l = System.currentTimeMillis() - 86400000L;
            localObject1 = Calendar.getInstance();
            ((Calendar)localObject1).setTimeInMillis(l);
            Object localObject4 = QLogReporter.a.format(((Calendar)localObject1).getTime());
            ((Calendar)localObject1).setTimeInMillis(l - 86400000L);
            localObject1 = QLogReporter.a.format(((Calendar)localObject1).getTime());
            i = 0;
            j = localObject3.length;
            if (i < j)
            {
              localObject2 = localObject3[i];
              if (i != localObject3.length - 1)
              {
                if (!((String)localObject2).contains((CharSequence)localObject1)) {
                  break label759;
                }
              }
              else
              {
                if (((String)localObject2).contains((CharSequence)localObject1)) {
                  break label759;
                }
                localObject1 = this.a.edit();
                ((SharedPreferences.Editor)localObject1).putLong("LastLogSizeReportTime", this.b);
                ((SharedPreferences.Editor)localObject1).commit();
                return;
              }
            }
            Object localObject5 = new HashMap();
            int k = localObject3.length;
            i = 0;
            if (i < k)
            {
              Object localObject6 = localObject3[i];
              if ((!localObject6.contains((CharSequence)localObject4)) || (!localObject6.contains("com.tencent.mobileqq"))) {
                break label773;
              }
              if (localObject6.endsWith(".log")) {
                return;
              }
              if (!localObject6.contains("_"))
              {
                localObject2 = (List)((Map)localObject5).get("com.tencent.mobileqq");
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = new LinkedList();
                  ((Map)localObject5).put("com.tencent.mobileqq", localObject1);
                }
                ((List)localObject1).add(localObject6);
                break label773;
              }
              localObject2 = localObject6.split("\\.");
              int m = localObject2.length;
              j = 0;
              if (j >= m) {
                break label773;
              }
              localObject1 = localObject2[j];
              if (!((String)localObject1).contains("_")) {
                break label766;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("com.tencent.");
              ((StringBuilder)localObject2).append((String)localObject1);
              String str2 = ((StringBuilder)localObject2).toString();
              localObject2 = (List)((Map)localObject5).get(str2);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new LinkedList();
                ((Map)localObject5).put(str2, localObject1);
              }
              ((List)localObject1).add(localObject6);
              break label773;
            }
            localObject1 = new HashMap();
            Object localObject2 = ((Map)localObject5).entrySet().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              l = 0L;
              localObject4 = ((List)((Map.Entry)localObject3).getValue()).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = new File(str1, (String)((Iterator)localObject4).next());
                if ((!((File)localObject5).exists()) || (((File)localObject5).isDirectory())) {
                  continue;
                }
                l += ((File)localObject5).length();
                continue;
              }
              ((HashMap)localObject1).put(((Map.Entry)localObject3).getKey(), String.valueOf(l));
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
              ((StringBuilder)localObject4).append(" Yesterday log size is ");
              ((StringBuilder)localObject4).append(l);
              QLog.i("QLogReporter", 1, ((StringBuilder)localObject4).toString());
              continue;
            }
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "YesterdayLogSizeCollection", true, 0L, 0L, (HashMap)localObject1, "");
            localObject1 = this.a.edit();
            ((SharedPreferences.Editor)localObject1).putLong("LastLogSizeReportTime", this.b);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label759:
      i += 1;
      continue;
      label766:
      j += 1;
      continue;
      label773:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.QLogReporter.1
 * JD-Core Version:    0.7.0.1
 */
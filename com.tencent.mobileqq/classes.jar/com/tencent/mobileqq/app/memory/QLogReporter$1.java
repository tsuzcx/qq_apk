package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import aory;
import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
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

public class QLogReporter$1
  implements Runnable
{
  public QLogReporter$1(aory paramaory, SharedPreferences paramSharedPreferences, long paramLong) {}
  
  public void run()
  {
    String str1;
    Object localObject4;
    long l;
    Object localObject5;
    int i;
    Object localObject3;
    Object localObject6;
    Object localObject7;
    for (;;)
    {
      try
      {
        str1 = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", "/") + "/";
        Object localObject1 = new File(str1);
        if (!((File)localObject1).exists()) {
          break label718;
        }
        if (!((File)localObject1).isDirectory()) {
          return;
        }
        localObject4 = ((File)localObject1).list();
        if ((localObject4 == null) || (localObject4.length == 0)) {
          break label718;
        }
        l = System.currentTimeMillis() - 86400000L;
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(l);
        localObject5 = aory.a.format(((Calendar)localObject1).getTime());
        ((Calendar)localObject1).setTimeInMillis(l - 86400000L);
        localObject1 = aory.a.format(((Calendar)localObject1).getTime());
        i = 0;
        if (i < localObject4.length)
        {
          localObject3 = localObject4[i];
          if (i != localObject4.length - 1) {
            if (!((String)localObject3).contains((CharSequence)localObject1)) {
              break label356;
            }
          }
        }
        else
        {
          localObject6 = new HashMap();
          int k = localObject4.length;
          i = 0;
          if (i >= k) {
            break label480;
          }
          localObject7 = localObject4[i];
          if ((!localObject7.contains((CharSequence)localObject5)) || (!localObject7.contains("com.tencent.mobileqq"))) {
            break label719;
          }
          if (localObject7.endsWith(".log")) {
            break label718;
          }
          if (localObject7.contains("_")) {
            break;
          }
          localObject3 = (List)((Map)localObject6).get("com.tencent.mobileqq");
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new LinkedList();
            ((Map)localObject6).put("com.tencent.mobileqq", localObject1);
          }
          ((List)localObject1).add(localObject7);
          break label719;
        }
        if (!((String)localObject3).contains((CharSequence)localObject1))
        {
          localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putLong("LastLogSizeReportTime", this.jdField_a_of_type_Long);
          ((SharedPreferences.Editor)localObject1).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label356:
      i += 1;
    }
    Object localObject2 = localObject7.split("\\.");
    int m = localObject2.length;
    int j = 0;
    for (;;)
    {
      if (j < m)
      {
        localObject3 = localObject2[j];
        if (!((String)localObject3).contains("_")) {
          break label726;
        }
        String str2 = "com.tencent." + (String)localObject3;
        localObject3 = (List)((Map)localObject6).get(str2);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new LinkedList();
          ((Map)localObject6).put(str2, localObject2);
        }
        ((List)localObject2).add(localObject7);
        break label719;
        label480:
        localObject2 = new HashMap();
        localObject3 = ((Map)localObject6).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          localObject5 = ((List)((Map.Entry)localObject4).getValue()).iterator();
          for (l = 0L; ((Iterator)localObject5).hasNext(); l += ((File)localObject6).length())
          {
            label545:
            localObject6 = new File(str1, (String)((Iterator)localObject5).next());
            if ((!((File)localObject6).exists()) || (((File)localObject6).isDirectory())) {
              break label545;
            }
          }
          ((HashMap)localObject2).put(((Map.Entry)localObject4).getKey(), String.valueOf(l));
          QLog.i("QLogReporter", 1, (String)((Map.Entry)localObject4).getKey() + " Yesterday log size is " + l);
        }
        bdmc.a(BaseApplicationImpl.getContext()).a("", "YesterdayLogSizeCollection", true, 0L, 0L, (HashMap)localObject2, "");
        localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject2).putLong("LastLogSizeReportTime", this.jdField_a_of_type_Long);
        ((SharedPreferences.Editor)localObject2).commit();
        label718:
        return;
      }
      label719:
      i += 1;
      break;
      label726:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.QLogReporter.1
 * JD-Core Version:    0.7.0.1
 */
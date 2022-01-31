import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class amfp
{
  private static amfp jdField_a_of_type_Amfp;
  int jdField_a_of_type_Int = 0;
  public CopyOnWriteArraySet<String> a;
  private int b;
  
  private amfp()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("proc_reporter", 0);
    this.b = ((SharedPreferences)localObject1).getInt("proc_max_count", 0);
    long l1 = ((SharedPreferences)localObject1).getLong("proc_report_time", 0L);
    long l2 = System.currentTimeMillis();
    if (l1 == 0L) {
      ((SharedPreferences)localObject1).edit().putLong("proc_report_time", l2).commit();
    }
    for (;;)
    {
      localObject1 = ((SharedPreferences)localObject1).getString("KillFaieldProcesses", null);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((String)localObject1).split(";");
      int j = localObject1.length;
      int i = 0;
      Object localObject2;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localObject2);
        i += 1;
      }
      if ((Math.abs(l2 - l1) > 86400000L) && (this.b > 2))
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_FailCode", "" + this.b);
        azmz.a(BaseApplicationImpl.getApplication()).a(null, "ProcReporter", true, 0L, this.b, (HashMap)localObject2, null);
        this.b = 0;
        ((SharedPreferences)localObject1).edit().putLong("proc_report_time", l2).putInt("proc_max_count", 0).commit();
      }
    }
  }
  
  public static amfp a()
  {
    if (jdField_a_of_type_Amfp == null) {}
    try
    {
      if (jdField_a_of_type_Amfp == null) {
        jdField_a_of_type_Amfp = new amfp();
      }
      return jdField_a_of_type_Amfp;
    }
    finally {}
  }
  
  public void a()
  {
    int i = 0;
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int % 3 == 0) {}
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningAppProcesses().iterator();
        if (localIterator.hasNext())
        {
          if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.startsWith("com.tencent.mobileqq")) {
            i += 1;
          }
        }
        else
        {
          if (i > this.b)
          {
            this.b = i;
            BaseApplicationImpl.getApplication().getSharedPreferences("proc_reporter", 0).edit().putInt("proc_max_count", i).commit();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramArrayList.get(i))) {
        paramArrayList.remove(i);
      }
      i -= 1;
    }
    if (paramArrayList.isEmpty()) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(str);
      HashMap localHashMap = new HashMap();
      str = str + ".fg";
      localHashMap.put("param_FailCode", str);
      localHashMap.put("processname", str);
      azmz.a(BaseApplicationImpl.getApplication()).a(null, "ProcKillFailed", true, 0L, 0L, localHashMap, null);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "kill reporting " + str);
      }
    }
    b();
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("proc_reporter", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new CopyOnWriteArraySet();
    ((CopyOnWriteArraySet)localObject).addAll(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
    localObject = ((CopyOnWriteArraySet)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == 0) {
        localStringBuilder.append(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(";");
        localStringBuilder.append(str);
      }
    }
    localSharedPreferences.edit().putString("KillFaieldProcesses", localStringBuilder.toString()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfp
 * JD-Core Version:    0.7.0.1
 */
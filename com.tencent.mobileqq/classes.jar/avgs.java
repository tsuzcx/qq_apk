import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class avgs
{
  private static volatile avgs jdField_a_of_type_Avgs;
  private Map<String, avgu> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static avgs a()
  {
    if (jdField_a_of_type_Avgs == null) {}
    try
    {
      if (jdField_a_of_type_Avgs == null) {
        jdField_a_of_type_Avgs = new avgs();
      }
      return jdField_a_of_type_Avgs;
    }
    finally {}
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey("task_qgame_task_all_complete")))
    {
      avgu localavgu = (avgu)this.jdField_a_of_type_JavaUtilMap.get("task_qgame_task_all_complete");
      if ((localavgu != null) && (avgu.a(localavgu) != null))
      {
        avgu.a(localavgu).a("task_qgame_task_all_complete", new EIPCResult());
        this.jdField_a_of_type_JavaUtilMap.remove(localavgu);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_msg", new avgu("findMessage"));
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_session_msg", new avgu("getGameMsg"));
      this.jdField_a_of_type_JavaUtilMap.put("task_qgame_task_all_complete", new avgu("task_qgame_task_all_complete"));
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      avgu.a((avgu)this.jdField_a_of_type_JavaUtilMap.get(paramString), null);
    }
  }
  
  public void a(String paramString, avgv paramavgv)
  {
    if ((paramavgv != null) && (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      avgu.a((avgu)this.jdField_a_of_type_JavaUtilMap.get(paramString), paramavgv);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    avgu localavgu;
    do
    {
      return;
      localavgu = (avgu)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (localavgu == null);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", avgu.a(localavgu), null, new avgt(this, localavgu, paramString, paramBoolean));
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((avgu)((Map.Entry)localIterator.next()).getValue()).a();
        }
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    jdField_a_of_type_Avgs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgs
 * JD-Core Version:    0.7.0.1
 */
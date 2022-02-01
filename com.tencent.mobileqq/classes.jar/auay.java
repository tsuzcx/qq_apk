import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class auay
{
  private static volatile auay jdField_a_of_type_Auay;
  private Map<String, auba> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static auay a()
  {
    if (jdField_a_of_type_Auay == null) {}
    try
    {
      if (jdField_a_of_type_Auay == null) {
        jdField_a_of_type_Auay = new auay();
      }
      return jdField_a_of_type_Auay;
    }
    finally {}
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey("task_qgame_task_all_complete")))
    {
      auba localauba = (auba)this.jdField_a_of_type_JavaUtilMap.get("task_qgame_task_all_complete");
      if ((localauba != null) && (auba.a(localauba) != null))
      {
        auba.a(localauba).a("task_qgame_task_all_complete", new EIPCResult());
        this.jdField_a_of_type_JavaUtilMap.remove(localauba);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_msg", new auba("findMessage"));
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_session_msg", new auba("getGameMsg"));
      this.jdField_a_of_type_JavaUtilMap.put("task_qgame_task_all_complete", new auba("task_qgame_task_all_complete"));
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      auba.a((auba)this.jdField_a_of_type_JavaUtilMap.get(paramString), null);
    }
  }
  
  public void a(String paramString, aubb paramaubb)
  {
    if ((paramaubb != null) && (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      auba.a((auba)this.jdField_a_of_type_JavaUtilMap.get(paramString), paramaubb);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    auba localauba;
    do
    {
      return;
      localauba = (auba)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (localauba == null);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", auba.a(localauba), null, new auaz(this, localauba, paramString, paramBoolean));
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          ((auba)((Map.Entry)localIterator.next()).getValue()).a();
        }
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    jdField_a_of_type_Auay = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auay
 * JD-Core Version:    0.7.0.1
 */
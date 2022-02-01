import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class avny
{
  private static volatile avny jdField_a_of_type_Avny;
  private Map<String, avoa> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static avny a()
  {
    if (jdField_a_of_type_Avny == null) {}
    try
    {
      if (jdField_a_of_type_Avny == null) {
        jdField_a_of_type_Avny = new avny();
      }
      return jdField_a_of_type_Avny;
    }
    finally {}
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey("task_qgame_task_all_complete")))
    {
      avoa localavoa = (avoa)this.jdField_a_of_type_JavaUtilMap.get("task_qgame_task_all_complete");
      if ((localavoa != null) && (avoa.a(localavoa) != null))
      {
        avoa.a(localavoa).a("task_qgame_task_all_complete", new EIPCResult());
        this.jdField_a_of_type_JavaUtilMap.remove(localavoa);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_msg", new avoa(this, "findMessage"));
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_session_msg", new avoa(this, "getGameMsg"));
      this.jdField_a_of_type_JavaUtilMap.put("task_qgame_task_all_complete", new avoa(this, "task_qgame_task_all_complete"));
    }
  }
  
  public void a(String paramString, avob paramavob)
  {
    if ((paramavob != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      avoa.a((avoa)this.jdField_a_of_type_JavaUtilMap.get(paramString), paramavob);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    avoa localavoa = (avoa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localavoa == null) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", avoa.a(localavoa), null, new avnz(this, localavoa, paramString, paramBoolean));
  }
  
  public void b()
  {
    jdField_a_of_type_Avny = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avny
 * JD-Core Version:    0.7.0.1
 */
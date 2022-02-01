import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class auvy
{
  private static volatile auvy jdField_a_of_type_Auvy;
  private Map<String, auwa> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static auvy a()
  {
    if (jdField_a_of_type_Auvy == null) {}
    try
    {
      if (jdField_a_of_type_Auvy == null) {
        jdField_a_of_type_Auvy = new auvy();
      }
      return jdField_a_of_type_Auvy;
    }
    finally {}
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() == 1) && (this.jdField_a_of_type_JavaUtilMap.containsKey("task_qgame_task_all_complete")))
    {
      auwa localauwa = (auwa)this.jdField_a_of_type_JavaUtilMap.get("task_qgame_task_all_complete");
      if ((localauwa != null) && (auwa.a(localauwa) != null))
      {
        auwa.a(localauwa).a("task_qgame_task_all_complete", new EIPCResult());
        this.jdField_a_of_type_JavaUtilMap.remove(localauwa);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_msg", new auwa(this, "findMessage"));
      this.jdField_a_of_type_JavaUtilMap.put("task_get_qgame_session_msg", new auwa(this, "getGameMsg"));
      this.jdField_a_of_type_JavaUtilMap.put("task_qgame_task_all_complete", new auwa(this, "task_qgame_task_all_complete"));
    }
  }
  
  public void a(String paramString, auwb paramauwb)
  {
    if ((paramauwb != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      auwa.a((auwa)this.jdField_a_of_type_JavaUtilMap.get(paramString), paramauwb);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    auwa localauwa = (auwa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localauwa == null) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", auwa.a(localauwa), null, new auvz(this, localauwa, paramString, paramBoolean));
  }
  
  public void b()
  {
    jdField_a_of_type_Auvy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvy
 * JD-Core Version:    0.7.0.1
 */
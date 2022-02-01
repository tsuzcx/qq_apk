import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class auke
  implements Manager
{
  private augp jdField_a_of_type_Augp;
  private Map<String, Map<String, Object>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public auke()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> init");
    this.jdField_a_of_type_Augp = new augp();
  }
  
  public augp a()
  {
    return this.jdField_a_of_type_Augp;
  }
  
  public Map<String, Object> a(String paramString)
  {
    return (Map)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public void a(String paramString, Map<String, Object> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramMap);
  }
  
  public void onDestroy()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> onDestroy");
    this.jdField_a_of_type_Augp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auke
 * JD-Core Version:    0.7.0.1
 */
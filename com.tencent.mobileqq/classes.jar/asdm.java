import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class asdm
  implements Manager
{
  private arzn jdField_a_of_type_Arzn;
  private Map<String, Map<String, Object>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public asdm()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> init");
    this.jdField_a_of_type_Arzn = new arzn();
  }
  
  public arzn a()
  {
    return this.jdField_a_of_type_Arzn;
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
    this.jdField_a_of_type_Arzn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdm
 * JD-Core Version:    0.7.0.1
 */
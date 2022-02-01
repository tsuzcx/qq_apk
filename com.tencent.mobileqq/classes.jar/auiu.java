import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.concurrent.ConcurrentHashMap;

public class auiu
{
  private static auiu jdField_a_of_type_Auiu;
  public static String a;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new auiv(this, "Module_WeiyunDownloadService");
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static auiu a()
  {
    if (jdField_a_of_type_Auiu == null) {}
    try
    {
      jdField_a_of_type_Auiu = new auiu();
      return jdField_a_of_type_Auiu;
    }
    finally {}
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiu
 * JD-Core Version:    0.7.0.1
 */
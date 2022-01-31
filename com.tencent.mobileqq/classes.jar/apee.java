import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.concurrent.ConcurrentHashMap;

public class apee
{
  private static apee jdField_a_of_type_Apee;
  public static String a;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new apef(this, "Module_WeiyunDownloadService");
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static apee a()
  {
    if (jdField_a_of_type_Apee == null) {}
    try
    {
      jdField_a_of_type_Apee = new apee();
      return jdField_a_of_type_Apee;
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
 * Qualified Name:     apee
 * JD-Core Version:    0.7.0.1
 */
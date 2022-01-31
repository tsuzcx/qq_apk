import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.concurrent.ConcurrentHashMap;

public class aqxc
{
  private static aqxc jdField_a_of_type_Aqxc;
  public static String a;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new aqxd(this, "Module_WeiyunDownloadService");
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static aqxc a()
  {
    if (jdField_a_of_type_Aqxc == null) {}
    try
    {
      jdField_a_of_type_Aqxc = new aqxc();
      return jdField_a_of_type_Aqxc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxc
 * JD-Core Version:    0.7.0.1
 */
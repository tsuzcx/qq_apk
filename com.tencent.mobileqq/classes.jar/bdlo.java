import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bdlo
{
  private static bdlo jdField_a_of_type_Bdlo;
  private bdlq jdField_a_of_type_Bdlq = new bdlq(this, null);
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new bdlp(this, "Module_DownloaderGetCodeServer");
  private Map<String, Bundle> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static bdlo a()
  {
    if (jdField_a_of_type_Bdlo == null) {}
    try
    {
      jdField_a_of_type_Bdlo = new bdlo();
      return jdField_a_of_type_Bdlo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlo
 * JD-Core Version:    0.7.0.1
 */